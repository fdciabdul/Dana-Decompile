package id.dana.contract.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.MultipleClickHandler;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.listener.DeeplinkFeatureListener;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesPresenter;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.di.PerActivity;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.extension.MapExtKt;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.oauth.OauthLoginManager;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.UrlUtil;
import id.dana.utils.android.UriUtils;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.getCallingPid;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020G\u0012\u0006\u0010\u0006\u001a\u00020E\u0012\u0006\u0010\u0007\u001a\u000208\u0012\u0006\u0010\"\u001a\u00020C\u0012\u0006\u0010#\u001a\u00020I\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SJ9\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\nJ9\u0010\f\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0011J9\u0010\u0012\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\nJ3\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0017J\u0019\u0010\u0012\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J%\u0010\u0014\u001a\u00020\u00162\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0019J9\u0010\u001a\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\nJ%\u0010\t\u001a\u00020\b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\t\u0010\u001eJ\u0019\u0010\u001a\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0015J)\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\u001fJ#\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010 J;\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\nJI\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00052\u0006\u0010\u0007\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010$J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020%H\u0016¢\u0006\u0004\b\u001a\u0010&J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b\u0014\u0010(J\u0017\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010)¢\u0006\u0004\b\u000b\u0010*J\u0019\u0010\f\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\f\u0010+J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\u0011J9\u0010\u0018\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\nR\u0018\u0010\u001a\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010-R\u0018\u0010\u0014\u001a\u0006*\u00020.0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010/R\u001b\u0010\t\u001a\u0002008CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b\u0014\u00102R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u00103R$\u0010\u000b\u001a\u0004\u0018\u0001048\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u00105\u001a\u0004\b\t\u00106\"\u0004\b\f\u00107R\u0014\u0010;\u001a\u0002088\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010=\u001a\u00020<8\u0007X\u0087&¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010AR\u0014\u0010\u0012\u001a\u00020C8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010DR\u0014\u00109\u001a\u00020E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010FR\u0014\u0010\u0018\u001a\u00020G8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010O\u001a\u0004\u0018\u00010\u00038W@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\b\u001a\u0010N\"\u0004\b\t\u0010\u0015"}, d2 = {"Lid/dana/contract/deeplink/DeepLinkView;", "Lid/dana/contract/deeplink/DeepLinkContract$View;", "Lid/dana/contract/deeplink/H5ListenerHandler;", "", "p0", "", "p1", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/utils/danah5/DanaH5Listener;", "()Lid/dana/utils/danah5/DanaH5Listener;", "dismissProgress", "()V", "getErrorConfigVersion", "(Ljava/util/Map;)Ljava/util/Map;", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "(Ljava/lang/String;)Z", "moveToNextValue", "(Ljava/util/Map;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Map;)V", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Landroid/content/Intent;", "(Ljava/lang/String;Landroid/content/Intent;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Lorg/json/JSONObject;", "p3", "p4", "(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;Ljava/lang/String;)V", "Lid/dana/domain/deeplink/model/OauthParams;", "(Lid/dana/domain/deeplink/model/OauthParams;)V", "Lid/dana/model/DeepLinkPayloadModel;", "(Lid/dana/model/DeepLinkPayloadModel;)V", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "(Lid/dana/utils/danah5/DanaH5Listener;)V", "showProgress", "Landroid/app/Activity;", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "Lid/dana/dialog/DanaLoadingDialog;", "Lkotlin/Lazy;", "()Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/utils/danah5/DanaH5Listener;", "Lid/dana/contract/deeplink/DeepLinkCallback;", "Lid/dana/contract/deeplink/DeepLinkCallback;", "()Lid/dana/contract/deeplink/DeepLinkCallback;", "(Lid/dana/contract/deeplink/DeepLinkCallback;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "scheduleImpl", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "lookAheadTest", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "getUserLoanInfo", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "()Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "Lid/dana/base/MultipleClickHandler;", "Lid/dana/base/MultipleClickHandler;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/contract/deeplink/path/OauthContract$Presenter;", "Lid/dana/contract/deeplink/path/OauthContract$Presenter;", "Lid/dana/contract/shortener/RestoreUrlContract$Presenter;", "Lid/dana/contract/shortener/RestoreUrlContract$Presenter;", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "Lid/dana/contract/services/ServicesPresenter;", "GetContactSyncConfig", "Lid/dana/contract/services/ServicesPresenter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/String;", "()Ljava/lang/String;", "DatabaseTableConfigUtil", "Landroid/app/Application;", "p5", "<init>", "(Lid/dana/contract/staticqr/ScanQrContract$Presenter;Lid/dana/contract/shortener/RestoreUrlContract$Presenter;Lid/dana/contract/deeplink/path/FeatureContract$Presenter;Lid/dana/contract/deeplink/path/OauthContract$Presenter;Lid/dana/contract/services/ServicesPresenter;Landroid/app/Application;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class DeepLinkView implements DeepLinkContract.View, H5ListenerHandler {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char DatabaseTableConfigUtil = 42071;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda8 = 1;
    private static char[] initRecordTimeStamp = {42068, 37256, 37249, 42071};

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DanaH5Listener PlaceComponentResult;
    private final ServicesPresenter GetContactSyncConfig;
    private Activity KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private DeepLinkCallback BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final RestoreUrlContract.Presenter scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    private final AlipayConnectInitializer getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ScanQrContract.Presenter moveToNextValue;
    @Inject
    public GetUserLoanInfo getUserLoanInfo;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private MultipleClickHandler NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final OauthContract.Presenter getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final FeatureContract.Presenter lookAheadTest;

    public static /* synthetic */ void MyBillsEntityDataFactory(Map map, DeepLinkView deepLinkView, String str, String str2, boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(map, deepLinkView, str, str2, z);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            int i4 = 9 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 37;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            if ((i % 2 == 0 ? (char) 5 : 'T') != 5) {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }
            int i2 = 71 / 0;
            return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public DeepLinkView(ScanQrContract.Presenter presenter, RestoreUrlContract.Presenter presenter2, FeatureContract.Presenter presenter3, OauthContract.Presenter presenter4, ServicesPresenter servicesPresenter, Application application) {
        Intrinsics.checkNotNullParameter(presenter, "");
        Intrinsics.checkNotNullParameter(presenter2, "");
        Intrinsics.checkNotNullParameter(presenter3, "");
        Intrinsics.checkNotNullParameter(presenter4, "");
        Intrinsics.checkNotNullParameter(servicesPresenter, "");
        Intrinsics.checkNotNullParameter(application, "");
        this.moveToNextValue = presenter;
        this.scheduleImpl = presenter2;
        this.lookAheadTest = presenter3;
        this.getErrorConfigVersion = presenter4;
        this.GetContactSyncConfig = servicesPresenter;
        this.getAuthRequestContext = ((DanaApplication) application).getAlipayConnectInitializer();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.contract.deeplink.DeepLinkView$danaLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialog invoke() {
                return new DanaLoadingDialog(DeepLinkView.MyBillsEntityDataFactory(DeepLinkView.this));
            }
        });
        this.DatabaseTableConfigUtil = TrackerKey.SourceType.DEEP_LINK;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DeepLinkView deepLinkView, String str, Map map, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        deepLinkView.getErrorConfigVersion(str, map, str2);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int i3 = 1 / 0;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkView deepLinkView, String str, Map map, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        deepLinkView.moveToNextValue(str, map, str2);
        if (!z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ Activity MyBillsEntityDataFactory(DeepLinkView deepLinkView) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Activity activity = deepLinkView.KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? 'N' : 'I') != 'I') {
                Object[] objArr = null;
                int length = objArr.length;
                return activity;
            }
            return activity;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DeepLinkView deepLinkView, String str, Map map, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        deepLinkView.BuiltInFictitiousFunctionClassFactory(str, map, str2);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ Map PlaceComponentResult(Map map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Map<String, String> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(map);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        if ((i3 % 2 == 0 ? '(' : '@') != '(') {
            return BuiltInFictitiousFunctionClassFactory;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static final /* synthetic */ void getAuthRequestContext(DeepLinkView deepLinkView, String str, Map map, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        char c = i % 2 == 0 ? 'F' : '-';
        deepLinkView.MyBillsEntityDataFactory(str, map, str2);
        if (c == 'F') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final DeepLinkCallback MyBillsEntityDataFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        DeepLinkCallback deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (i3 % 2 != 0) {
                return deepLinkCallback;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return deepLinkCallback;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(DeepLinkCallback deepLinkCallback) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 == 0;
        this.BuiltInFictitiousFunctionClassFactory = deepLinkCallback;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @JvmName(name = "getAuthRequestContext")
    private final DanaLoadingDialog getAuthRequestContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.MyBillsEntityDataFactory.getValue();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
        return danaLoadingDialog;
    }

    @JvmName(name = "lookAheadTest")
    private GetUserLoanInfo lookAheadTest() {
        GetUserLoanInfo getUserLoanInfo = this.getUserLoanInfo;
        Object obj = null;
        if ((getUserLoanInfo != null ? (char) 15 : '=') == '=') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            return null;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return getUserLoanInfo;
        }
        obj.hashCode();
        return getUserLoanInfo;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            try {
                this.DatabaseTableConfigUtil = str;
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            String str = this.DatabaseTableConfigUtil;
            if (str == null) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 51;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                if (i % 2 != 0) {
                    int i2 = 62 / 0;
                }
                str = TrackerKey.SourceType.DEEP_LINK;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void getAuthRequestContext(DeepLinkPayloadModel p0) {
        DeepLinkCallback deepLinkCallback;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            if ((i % 2 == 0 ? '.' : ']') != ']') {
                PlaceComponentResult();
                try {
                    deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
                    Object obj = null;
                    obj.hashCode();
                    if (deepLinkCallback == null) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else {
                PlaceComponentResult();
                deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
                if (deepLinkCallback == null) {
                    return;
                }
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 15;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i2 % 128;
            int i3 = i2 % 2;
            deepLinkCallback.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0027, code lost:
    
        if ((r7 != null) != true) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003c, code lost:
    
        if ((r7 != null) != true) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003f, code lost:
    
        r7.getAuthRequestContext();
        r7 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 + 95;
        id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x004c, code lost:
    
        r7 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 + 83;
        id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0058, code lost:
    
        if ((r7 % 2) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x005a, code lost:
    
        r7 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x005d, code lost:
    
        r7 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x005f, code lost:
    
        if (r7 == 22) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0061, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0064, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0067, code lost:
    
        return;
     */
    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.deeplink.model.OauthParams r7) {
        /*
            r6 = this;
            int r0 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1
            int r0 = r0 % 2
            r1 = 32
            if (r0 != 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 74
        L13:
            r2 = 0
            r3 = 0
            java.lang.String r4 = ""
            r5 = 1
            if (r0 == r1) goto L2c
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)     // Catch: java.lang.Exception -> L2a
            id.dana.contract.deeplink.path.OauthContract$Presenter r0 = r6.getErrorConfigVersion     // Catch: java.lang.Exception -> L2a
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r7)     // Catch: java.lang.Exception -> L2a
            id.dana.contract.deeplink.DeepLinkCallback r7 = r6.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L2a
            if (r7 == 0) goto L27
            r2 = 1
        L27:
            if (r2 == r5) goto L3f
            goto L4c
        L2a:
            r7 = move-exception
            throw r7
        L2c:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            id.dana.contract.deeplink.path.OauthContract$Presenter r0 = r6.getErrorConfigVersion
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            id.dana.contract.deeplink.DeepLinkCallback r7 = r6.BuiltInFictitiousFunctionClassFactory
            r3.hashCode()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L3c
            r2 = 1
        L3c:
            if (r2 == r5) goto L3f
            goto L4c
        L3f:
            r7.getAuthRequestContext()
            int r7 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r7 = r7 + 95
            int r0 = r7 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r7 = r7 % 2
        L4c:
            int r7 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r7 = r7 + 83
            int r0 = r7 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r7 = r7 % 2
            r0 = 22
            if (r7 == 0) goto L5d
            r7 = 85
            goto L5f
        L5d:
            r7 = 22
        L5f:
            if (r7 == r0) goto L67
            r3.hashCode()     // Catch: java.lang.Throwable -> L65
            return
        L65:
            r7 = move-exception
            throw r7
        L67:
            return
        L68:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.deeplink.model.OauthParams):void");
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String str, Map<String, String> map, final JSONObject jSONObject, final String str2) {
        try {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(jSONObject, "");
            final ServicesPresenter servicesPresenter = this.GetContactSyncConfig;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(jSONObject, "");
            if (!(!Intrinsics.areEqual(str, BranchLinkConstant.ActionTarget.OPEN_APP))) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 47;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                final String str3 = map.get("appId");
                if (str3 != null) {
                    servicesPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5.showProgress();
                    servicesPresenter.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1<List<? extends ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$consultAndOpenMiniProgram$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyServiceResponse> list) {
                            invoke2((List<ThirdPartyServiceResponse>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<ThirdPartyServiceResponse> list) {
                            ServicesContract.View view;
                            Object obj;
                            Intrinsics.checkNotNullParameter(list, "");
                            view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            view.dismissProgress();
                            String str4 = str3;
                            Iterator<T> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (Intrinsics.areEqual(((ThirdPartyServiceResponse) obj).getAppId(), str4)) {
                                    break;
                                }
                            }
                            ThirdPartyServiceResponse thirdPartyServiceResponse = (ThirdPartyServiceResponse) obj;
                            if (thirdPartyServiceResponse == null || thirdPartyServiceResponse.isEnable()) {
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                linkedHashMap.put("_ariver_appid", str3);
                                linkedHashMap.put("_ariver_path", UrlUtil.MyBillsEntityDataFactory(str2));
                                Bundle KClassImpl$Data$declaredNonStaticMembers$2 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject);
                                KClassImpl$Data$declaredNonStaticMembers$2.putString(DanaH5.SERVICE_KEY, thirdPartyServiceResponse != null ? thirdPartyServiceResponse.getKey() : null);
                                linkedHashMap.put("query", JSONExtKt.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, "query"));
                                Set<String> keySet = KClassImpl$Data$declaredNonStaticMembers$2.keySet();
                                Intrinsics.checkNotNullExpressionValue(keySet, "");
                                for (String str5 : CollectionsKt.toList(keySet)) {
                                    Intrinsics.checkNotNullExpressionValue(str5, "");
                                    if (StringsKt.startsWith$default(str5, "_ariver_", false, 2, (Object) null)) {
                                        linkedHashMap.put(str5, JSONExtKt.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, str5));
                                    }
                                }
                                String obj2 = UriUtils.BuiltInFictitiousFunctionClassFactory(DanaUrl.MINIPROGRAM_URI, MapExtKt.filterNotNullValues(linkedHashMap)).toString();
                                Intrinsics.checkNotNullExpressionValue(obj2, "");
                                DanaH5.openApp(obj2, KClassImpl$Data$declaredNonStaticMembers$2, thirdPartyServiceResponse != null ? thirdPartyServiceResponse.getScreenOrientation() : null);
                            }
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.services.ServicesPresenter$consultAndOpenMiniProgram$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            ServicesContract.View view;
                            Intrinsics.checkNotNullParameter(th, "");
                            view = ServicesPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            view.dismissProgress();
                            ServicesPresenter.PlaceComponentResult(ServicesPresenter.this, DanaLogConstants.Prefix.CONSULT_AND_OPEN_MINI_PROGRAM, th);
                        }
                    });
                }
            }
            DeepLinkCallback deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
            if (deepLinkCallback != null) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 67;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if ((i3 % 2 != 0 ? '\\' : ',') == ',') {
                    deepLinkCallback.getAuthRequestContext();
                    return;
                }
                deepLinkCallback.getAuthRequestContext();
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        this.lookAheadTest.PlaceComponentResult(p0);
        DeepLinkCallback deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
        if ((deepLinkCallback != null ? '7' : 'c') != 'c') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            try {
                deepLinkCallback.getAuthRequestContext();
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void MyBillsEntityDataFactory(String p0, Intent p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Bundle bundle = new Bundle();
        if (moveToNextValue(p0)) {
            this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(p1, true);
            return;
        }
        try {
            if (DeepLinkParser.moveToNextValue()) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 89;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                if (i % 2 != 0) {
                    DeepLinkParser.getErrorConfigVersion();
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                DeepLinkParser.getErrorConfigVersion();
                return;
            }
            String PlaceComponentResult = PlaceComponentResult(p0);
            bundle.putString("url", PlaceComponentResult);
            DanaH5.startContainerFullUrlWithSendCredentials$default(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory(), null, null, 12, null);
            DeepLinkCallback deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
            if (deepLinkCallback != null) {
                try {
                    int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 101;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                    int i3 = i2 % 2;
                    deepLinkCallback.getAuthRequestContext();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean moveToNextValue(String p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        boolean contains$default = StringsKt.contains$default((CharSequence) p0, (CharSequence) "electronicMoney", false, 2, (Object) null);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return contains$default;
        }
        int i4 = 16 / 0;
        return contains$default;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 91;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        String str = p0;
        return i % 2 != 0 ? StringsKt.contains$default((CharSequence) str, (CharSequence) r4, false, 2, (Object) null) : StringsKt.contains$default((CharSequence) str, (CharSequence) r4, false, 3, (Object) null);
    }

    private final String PlaceComponentResult(String p0) {
        String PlaceComponentResult;
        String str;
        UserLoanInfo execute = lookAheadTest().execute(new GetUserLoanInfo.Params(LoanInfo.LOAN_PERSONAL));
        Boolean isWhitelisted = execute.getIsWhitelisted();
        if (isWhitelisted != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if (i % 2 != 0) {
                boolean booleanValue = isWhitelisted.booleanValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(DanaUrl.WLCICIL, Arrays.copyOf(new Object[]{Boolean.valueOf(booleanValue)}, 0));
                Intrinsics.checkNotNullExpressionValue(format, "");
                PlaceComponentResult = UrlUtil.PlaceComponentResult(p0, format);
                if (PlaceComponentResult == null) {
                    return p0;
                }
            } else {
                boolean booleanValue2 = isWhitelisted.booleanValue();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(DanaUrl.WLCICIL, Arrays.copyOf(new Object[]{Boolean.valueOf(booleanValue2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                PlaceComponentResult = UrlUtil.PlaceComponentResult(p0, format2);
                if ((PlaceComponentResult != null ? (char) 27 : (char) 24) != 27) {
                    return p0;
                }
            }
            if ((!BuiltInFictitiousFunctionClassFactory(PlaceComponentResult) ? 'R' : 'V') == 'R') {
                PlaceComponentResult = null;
            }
            if (!(PlaceComponentResult == null)) {
                Boolean isRegistered = execute.getIsRegistered();
                if (isRegistered != null) {
                    int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 63;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                    int i3 = i2 % 2;
                    try {
                        boolean booleanValue3 = isRegistered.booleanValue();
                        try {
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            String format3 = String.format(DanaUrl.REGISTERED, Arrays.copyOf(new Object[]{Boolean.valueOf(booleanValue3)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "");
                            str = UrlUtil.PlaceComponentResult(PlaceComponentResult, format3);
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                } else {
                    str = null;
                }
                if (!(str != null)) {
                    return PlaceComponentResult;
                }
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 125;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i4 % 128;
                int i5 = i4 % 2;
                return str;
            }
            return p0;
        }
        return p0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x002b, code lost:
    
        if ((r11 == null) != true) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0040, code lost:
    
        if (r11 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0042, code lost:
    
        r11.getAuthRequestContext();
     */
    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r10 = this;
            int r0 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = ""
            if (r0 == 0) goto L2e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r3)
            id.dana.contract.staticqr.ScanQrContract$Presenter r4 = r10.moveToNextValue
            r8 = 1
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r4.MyBillsEntityDataFactory(r5, r6, r7, r8, r9)
            id.dana.contract.deeplink.DeepLinkCallback r11 = r10.BuiltInFictitiousFunctionClassFactory
            if (r11 == 0) goto L2a
            goto L2b
        L2a:
            r1 = 1
        L2b:
            if (r1 == r2) goto L45
            goto L42
        L2e:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r3)
            id.dana.contract.staticqr.ScanQrContract$Presenter r3 = r10.moveToNextValue
            r7 = 0
            r8 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r3.MyBillsEntityDataFactory(r4, r5, r6, r7, r8)
            id.dana.contract.deeplink.DeepLinkCallback r11 = r10.BuiltInFictitiousFunctionClassFactory
            if (r11 == 0) goto L45
        L42:
            r11.getAuthRequestContext()
        L45:
            int r11 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L50
            int r11 = r11 + 13
            int r12 = r11 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r12     // Catch: java.lang.Exception -> L50
            int r11 = r11 % 2
            return
        L50:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.PlaceComponentResult(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        if (r3.length() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0040, code lost:
    
        if (r3.length() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0042, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x004b, code lost:
    
        if (r8 == null) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            if (r3 == 0) goto L4e
            boolean r3 = id.dana.contract.deeplink.util.SourceParamUtil.BuiltInFictitiousFunctionClassFactory(r8)
            if (r3 == 0) goto L4e
            int r3 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r3 = r3 + 45
            int r4 = r3 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r4
            int r3 = r3 % 2
            java.lang.String r8 = id.dana.contract.deeplink.util.SourceParamUtil.PlaceComponentResult(r8)
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L44
            int r4 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r4 = r4 + 51
            int r5 = r4 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L3c
            int r3 = r3.length()
            r4 = 62
            int r4 = r4 / r2
            if (r3 == 0) goto L44
            goto L42
        L3a:
            r7 = move-exception
            throw r7
        L3c:
            int r3 = r3.length()     // Catch: java.lang.Exception -> L7b
            if (r3 == 0) goto L44
        L42:
            r3 = 0
            goto L45
        L44:
            r3 = 1
        L45:
            if (r3 == 0) goto L5f
            java.lang.String r8 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r8 != 0) goto L5f
            goto L60
        L4e:
            java.lang.String r8 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r8 != 0) goto L5f
            int r8 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r8 = r8 + 123
            int r3 = r8 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r8 = r8 % 2
            goto L60
        L5f:
            r0 = r8
        L60:
            id.dana.contract.shortener.RestoreUrlContract$Presenter r8 = r6.scheduleImpl
            r8.getAuthRequestContext(r7, r0)
            id.dana.contract.deeplink.DeepLinkCallback r7 = r6.BuiltInFictitiousFunctionClassFactory
            if (r7 == 0) goto L6a
            goto L6b
        L6a:
            r1 = 0
        L6b:
            if (r1 == 0) goto L7a
            r7.getAuthRequestContext()
            int r7 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L7b
            int r7 = r7 + 9
            int r8 = r7 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r8     // Catch: java.lang.Exception -> L7b
            int r7 = r7 % 2
        L7a:
            return
        L7b:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):void");
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, Map<String, String> p1, String p2) {
        if ((getErrorConfigVersion(p0) ? (char) 11 : '-') == 11) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
            try {
                if (!getAuthRequestContext(p1)) {
                    getAuthRequestContext(p0, BuiltInFictitiousFunctionClassFactory(p1), p2);
                    return;
                }
                try {
                    FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("binding_gn");
                    PlaceComponentResult(p0, p1, p2);
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 13;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                    if (i3 % 2 != 0) {
                        Object obj = null;
                        obj.hashCode();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        getAuthRequestContext(p0, p1, p2);
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void MyBillsEntityDataFactory(final Map<String, String> p0) {
        String str;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("binding_gn");
        if ((p0 != null ? (char) 27 : 'R') != 'R') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (i3 % 2 != 0) {
                str = p0.get("merchantId");
            } else {
                try {
                    str = p0.get("merchantId");
                    int i4 = 31 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        } else {
            str = null;
        }
        try {
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.initRecordTimeStamp = Random.INSTANCE.nextInt();
            this.getErrorConfigVersion.getAuthRequestContext(str, new OauthPresenter.WhitelistedSubMerchantIdListener() { // from class: id.dana.contract.deeplink.DeepLinkView$onCheckKycStatusForPathGn$1
                @Override // id.dana.contract.deeplink.path.OauthPresenter.WhitelistedSubMerchantIdListener
                public final void PlaceComponentResult() {
                    OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                    if (OauthLoginManager.lookAheadTest() != 0) {
                        DeepLinkView.KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkView.this, "oauth", p0, null);
                    }
                }

                @Override // id.dana.contract.deeplink.path.OauthPresenter.WhitelistedSubMerchantIdListener
                public final void MyBillsEntityDataFactory() {
                    OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                    if (OauthLoginManager.lookAheadTest() != 0) {
                        DeepLinkView.getAuthRequestContext(DeepLinkView.this, "oauth", p0, null);
                    }
                }
            });
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.View
    public final void getAuthRequestContext(String p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(p0, "");
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (activity != null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 15 : 'W') != 'W') {
                try {
                    HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
                    try {
                        activity.startActivity(HomeTabActivity.Companion.PlaceComponentResult(activity, p0));
                        int i4 = 85 / 0;
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            HomeTabActivity.Companion companion2 = HomeTabActivity.INSTANCE;
            activity.startActivity(HomeTabActivity.Companion.PlaceComponentResult(activity, p0));
        }
    }

    public final void getAuthRequestContext(String p0, Map<String, String> p1, String p2) {
        this.lookAheadTest.getAuthRequestContext(new DeeplinkFeatureListener() { // from class: id.dana.contract.deeplink.DeepLinkView$onGetSuccessDeepLinkPathFeature$1
            @Override // id.dana.contract.deeplink.listener.DeeplinkFeatureListener
            public final void PlaceComponentResult() {
                DeepLinkView.this.dismissProgress();
                DeepLinkCallback MyBillsEntityDataFactory = DeepLinkView.this.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory != null) {
                    MyBillsEntityDataFactory.getAuthRequestContext();
                }
            }

            @Override // id.dana.contract.deeplink.listener.DeeplinkFeatureListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DeepLinkView.this.dismissProgress();
            }
        });
        this.lookAheadTest.getAuthRequestContext(p0, p1, p2);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return;
            }
            getAuthRequestContext().PlaceComponentResult();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        PlaceComponentResult();
        DeepLinkCallback deepLinkCallback = this.BuiltInFictitiousFunctionClassFactory;
        if (deepLinkCallback == null) {
            return;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
        try {
            deepLinkCallback.PlaceComponentResult(str);
        } catch (Exception e) {
            throw e;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final String p0, final Map<String, String> p1, final String p2) {
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(new OauthPresenter.GetNicknameCallback() { // from class: id.dana.contract.deeplink.DeepLinkView$$ExternalSyntheticLambda0
            @Override // id.dana.contract.deeplink.path.OauthPresenter.GetNicknameCallback
            public final void PlaceComponentResult(boolean z) {
                DeepLinkView.MyBillsEntityDataFactory(p1, this, p0, p2, z);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(Map map, DeepLinkView deepLinkView, String str, String str2, boolean z) {
        Map<String, String> mutableMap;
        Intrinsics.checkNotNullParameter(deepLinkView, "");
        if (map != null) {
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 49;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                mutableMap = MapsKt.toMutableMap(map);
                if (mutableMap != null) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 59;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                    int i4 = i3 % 2;
                    mutableMap.put(BranchLinkConstant.Params.HAS_NICKNAME, String.valueOf(z));
                    deepLinkView.getAuthRequestContext(str, mutableMap, str2);
                }
            } catch (Exception e) {
                throw e;
            }
        }
        mutableMap = null;
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
        int i6 = i5 % 2;
        deepLinkView.getAuthRequestContext(str, mutableMap, str2);
    }

    private final void PlaceComponentResult() {
        MultipleClickHandler multipleClickHandler = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if ((multipleClickHandler != null ? Typography.amp : 'L') == '&') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
            multipleClickHandler.enableClick();
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final void PlaceComponentResult(DanaH5Listener p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult = p0;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? '0' : 'Q') != 'Q') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Activity p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        if (p0 instanceof BaseActivity) {
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
                    if (!(i % 2 != 0)) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (MultipleClickHandler) p0;
                        Object[] objArr = null;
                        int length = objArr.length;
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (MultipleClickHandler) p0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x001e, code lost:
    
        if ((!kotlin.text.StringsKt.equals(r4, "oauth", false)) != true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0025, code lost:
    
        if (kotlin.text.StringsKt.equals(r4, "oauth", true) == false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getErrorConfigVersion(java.lang.String r4) {
        /*
            int r0 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "oauth"
            if (r0 == r2) goto L21
            boolean r0 = kotlin.text.StringsKt.equals(r4, r3, r1)
            if (r0 != 0) goto L1d
            r0 = 1
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == r2) goto L27
            goto L3c
        L21:
            boolean r0 = kotlin.text.StringsKt.equals(r4, r3, r2)     // Catch: java.lang.Exception -> L49
            if (r0 != 0) goto L3b
        L27:
            java.lang.String r0 = "qrBind"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r0, r2)
            if (r4 == 0) goto L30
            goto L3b
        L30:
            int r4 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r4 = r4 + 5
            int r0 = r4 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r4 = r4 % 2
            goto L3c
        L3b:
            r1 = 1
        L3c:
            int r4 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L47
            int r4 = r4 + 11
            int r0 = r4 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0     // Catch: java.lang.Exception -> L47
            int r4 = r4 % 2
            return r1
        L47:
            r4 = move-exception
            throw r4
        L49:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.getErrorConfigVersion(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getAuthRequestContext(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            java.lang.String r3 = "bindDanaType"
            r4 = 0
            if (r2 == 0) goto L13
            java.lang.Object r2 = r10.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            goto L14
        L13:
            r2 = r4
        L14:
            r5 = 2
            char[] r6 = new char[r5]
            r6 = {x008a: FILL_ARRAY_DATA , data: [0, 3} // fill-array
            int r7 = android.view.ViewConfiguration.getFadingEdgeLength()
            int r7 = r7 >> 16
            int r7 = r7 + 13
            byte r7 = (byte) r7
            int r8 = android.view.ViewConfiguration.getTapTimeout()
            int r8 = r8 >> 16
            int r8 = r8 + r5
            java.lang.Object[] r9 = new java.lang.Object[r1]
            a(r6, r7, r8, r9)
            r6 = r9[r0]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.intern()
            boolean r2 = kotlin.text.StringsKt.equals(r2, r6, r1)
            if (r2 != 0) goto L88
            int r2 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r2 = r2 + 67
            int r6 = r2 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r6
            int r2 = r2 % r5
            if (r10 == 0) goto L4f
            java.lang.Object r10 = r10.get(r3)
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
        L4f:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r10 = 17
            if (r4 == 0) goto L58
            r2 = 17
            goto L5a
        L58:
            r2 = 79
        L5a:
            if (r2 == r10) goto L5d
            goto L7c
        L5d:
            int r10 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r10 = r10 + 63
            int r2 = r10 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2
            int r10 = r10 % r5
            int r10 = r4.length()
            if (r10 == 0) goto L6e
            r10 = 1
            goto L6f
        L6e:
            r10 = 0
        L6f:
            if (r10 == 0) goto L7c
            int r10 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r10 = r10 + 65
            int r2 = r10 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2
            int r10 = r10 % r5
            r10 = 0
            goto L86
        L7c:
            int r10 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r10 = r10 + 89
            int r2 = r10 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            int r10 = r10 % r5
            r10 = 1
        L86:
            if (r10 == 0) goto L89
        L88:
            r0 = 1
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.getAuthRequestContext(java.util.Map):boolean");
    }

    private final void PlaceComponentResult(final String p0, final Map<String, String> p1, final String p2) {
        String str;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if (!(p1 == null)) {
            str = p1.get("merchantId");
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            int i4 = i3 % 2;
        } else {
            str = null;
        }
        try {
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.initRecordTimeStamp = Random.INSTANCE.nextInt();
            this.getErrorConfigVersion.getAuthRequestContext(str, new OauthPresenter.WhitelistedSubMerchantIdListener() { // from class: id.dana.contract.deeplink.DeepLinkView$checkWhitelistGnMerchant$1
                @Override // id.dana.contract.deeplink.path.OauthPresenter.WhitelistedSubMerchantIdListener
                public final void PlaceComponentResult() {
                    DeepLinkView.KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkView.this, p0, p1, p2);
                }

                @Override // id.dana.contract.deeplink.path.OauthPresenter.WhitelistedSubMerchantIdListener
                public final void MyBillsEntityDataFactory() {
                    DeepLinkView.getAuthRequestContext(DeepLinkView.this, p0, p1, p2);
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x001c, code lost:
    
        if ((r0) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x002a, code lost:
    
        if ((id.dana.oauth.OauthLoginManager.newProxyInstance() ? false : true) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x002c, code lost:
    
        r5 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
        id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r5 % 128;
        r5 = r5 % 2;
        r5 = id.dana.oauth.OauthLoginManager.INSTANCE;
        id.dana.oauth.OauthLoginManager.scheduleImpl = true;
        r5 = id.dana.oauth.OauthLoginManager.INSTANCE;
        id.dana.oauth.OauthLoginManager.lookAheadTest = true;
        r5 = r4.getAuthRequestContext;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
        id.dana.util.IapConnectKtx.MyBillsEntityDataFactory(r5, id.dana.contract.deeplink.DeepLinkView$validateRequestIdGn$1.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004f, code lost:
    
        MyBillsEntityDataFactory(r5, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0052, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void moveToNextValue(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L21
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            boolean r0 = id.dana.oauth.OauthLoginManager.newProxyInstance()
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L1b
            goto L1c
        L1b:
            r1 = 1
        L1c:
            if (r1 == 0) goto L2c
            goto L4f
        L1f:
            r5 = move-exception
            throw r5
        L21:
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            boolean r0 = id.dana.oauth.OauthLoginManager.newProxyInstance()
            if (r0 != 0) goto L2a
            r1 = 1
        L2a:
            if (r1 == 0) goto L4f
        L2c:
            int r5 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r5 = r5 + 3
            int r6 = r5 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r6
            int r5 = r5 % 2
            id.dana.oauth.OauthLoginManager r5 = id.dana.oauth.OauthLoginManager.INSTANCE
            id.dana.oauth.OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda3()
            id.dana.oauth.OauthLoginManager r5 = id.dana.oauth.OauthLoginManager.INSTANCE
            id.dana.oauth.OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            id.dana.globalnetwork.AlipayConnectInitializer r5 = r4.getAuthRequestContext
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            id.dana.contract.deeplink.DeepLinkView$validateRequestIdGn$1 r6 = id.dana.contract.deeplink.DeepLinkView$validateRequestIdGn$1.INSTANCE
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            id.dana.util.IapConnectKtx.MyBillsEntityDataFactory(r5, r6)
            return
        L4f:
            r4.MyBillsEntityDataFactory(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.moveToNextValue(java.lang.String, java.util.Map, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0018, code lost:
    
        if ((r5 != null ? '.' : 7) != '.') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x001d, code lost:
    
        if (r5 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x001f, code lost:
    
        r1 = r5.get("merchantId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0028, code lost:
    
        r3.getErrorConfigVersion.getAuthRequestContext(r1, new id.dana.contract.deeplink.DeepLinkView$checkAddingNameInputWhitelist$1(r3, r4, r5, r6));
        r4 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 + 49;
        id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0040, code lost:
    
        if ((r4 % 2) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0042, code lost:
    
        r4 = '6';
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0045, code lost:
    
        r4 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0047, code lost:
    
        if (r4 == '6') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x004c, code lost:
    
        r4 = 57 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x004e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(final java.lang.String r4, final java.util.Map<java.lang.String, java.lang.String> r5, final java.lang.String r6) {
        /*
            r3 = this;
            int r0 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L51
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L51
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1d
            r1.hashCode()     // Catch: java.lang.Throwable -> L1b
            r0 = 46
            if (r5 == 0) goto L17
            r2 = 46
            goto L18
        L17:
            r2 = 7
        L18:
            if (r2 == r0) goto L1f
            goto L28
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            if (r5 == 0) goto L28
        L1f:
            java.lang.String r0 = "merchantId"
            java.lang.Object r0 = r5.get(r0)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L28:
            id.dana.contract.deeplink.path.OauthContract$Presenter r0 = r3.getErrorConfigVersion
            id.dana.contract.deeplink.DeepLinkView$checkAddingNameInputWhitelist$1 r2 = new id.dana.contract.deeplink.DeepLinkView$checkAddingNameInputWhitelist$1
            r2.<init>()
            id.dana.contract.deeplink.path.OauthPresenter$AddingNameSubMerchantIdListener r2 = (id.dana.contract.deeplink.path.OauthPresenter.AddingNameSubMerchantIdListener) r2
            r0.getAuthRequestContext(r1, r2)
            int r4 = id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r4 = r4 + 49
            int r5 = r4 % 128
            id.dana.contract.deeplink.DeepLinkView.NetworkUserEntityData$$ExternalSyntheticLambda8 = r5
            int r4 = r4 % 2
            r5 = 54
            if (r4 != 0) goto L45
            r4 = 54
            goto L47
        L45:
            r4 = 29
        L47:
            if (r4 == r5) goto L4a
            return
        L4a:
            r4 = 57
            int r4 = r4 / 0
            return
        L4f:
            r4 = move-exception
            throw r4
        L51:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.DeepLinkView.MyBillsEntityDataFactory(java.lang.String, java.util.Map, java.lang.String):void");
    }

    private static Map<String, String> BuiltInFictitiousFunctionClassFactory(Map<String, String> p0) {
        Map<String, String> map;
        if ((p0 != null ? '?' : '\t') != '\t') {
            map = MapsKt.toMutableMap(p0);
            if (map != null) {
                map.put(BranchLinkConstant.Params.IGNORE_NICKNAME, SummaryActivity.CHECKED);
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 109;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
                int i2 = i % 2;
                return map;
            }
        }
        map = null;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i5 % 128;
        int i22 = i5 % 2;
        return map;
    }

    private final void getErrorConfigVersion(final String p0, final Map<String, String> p1, final String p2) {
        this.getErrorConfigVersion.MyBillsEntityDataFactory(new OauthPresenter.GetKycStatusCallback() { // from class: id.dana.contract.deeplink.DeepLinkView$getKcyStatusPathGn$1
            @Override // id.dana.contract.deeplink.path.OauthPresenter.GetKycStatusCallback
            public final void MyBillsEntityDataFactory(boolean p02) {
                Map<String, String> map;
                Map<String, String> map2 = p1;
                if (map2 == null || (map = MapsKt.toMutableMap(map2)) == null) {
                    map = null;
                } else {
                    map.put(BranchLinkConstant.Params.PREMIUM_USER, String.valueOf(p02));
                }
                if (p02) {
                    this.getAuthRequestContext(p0, map, p2);
                } else {
                    DeepLinkView.MyBillsEntityDataFactory(this, p0, map, p2);
                }
            }

            @Override // id.dana.contract.deeplink.path.OauthPresenter.GetKycStatusCallback
            public final void PlaceComponentResult() {
                this.getAuthRequestContext(p0, DeepLinkView.PlaceComponentResult(p1), p2);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    private static DanaH5Listener BuiltInFictitiousFunctionClassFactory() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.contract.deeplink.DeepLinkView$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                DanaH5.dispose();
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        return danaH5Listener;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        DanaLoadingDialog authRequestContext = getAuthRequestContext();
        if ((!authRequestContext.MyBillsEntityDataFactory.isShowing() ? 'A' : (char) 23) != 23) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
            if (!(i5 % 2 == 0)) {
                authRequestContext.MyBillsEntityDataFactory.show();
                authRequestContext.getAuthRequestContext.startRefresh();
                Object obj = null;
                obj.hashCode();
                return;
            }
            authRequestContext.MyBillsEntityDataFactory.show();
            authRequestContext.getAuthRequestContext.startRefresh();
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = initRecordTimeStamp;
        if (cArr2 != null) {
            try {
                int i3 = $11 + 123;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                    i5++;
                }
                int i6 = $11 + 1;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                cArr2 = cArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        char c = (char) ((-1549216646985767851L) ^ DatabaseTableConfigUtil);
        char[] cArr4 = new char[i];
        if ((i % 2 != 0 ? '@' : Typography.less) != '<') {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if ((getcallingpid.getAuthRequestContext < i2 ? (char) 1 : 'R') != 1) {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        int i10 = $11 + 9;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                    } else {
                        int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                        try {
                            int i16 = $11 + 27;
                            $10 = i16 % 128;
                            int i17 = i16 % 2;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
