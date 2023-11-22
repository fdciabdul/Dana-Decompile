package id.dana.miniprogram.provider;

import android.app.Application;
import android.content.Intent;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.BaseResult;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.MiniProgramMetaData;
import com.alipay.iap.android.wallet.acl.base.ResultError;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthConsultResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthPageConfirmResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.iap.ac.android.acs.plugin.utils.Constants;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.util.UrlUtil;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.useragreement.interactor.BuildAgreementContent;
import id.dana.domain.useragreement.interactor.BuildIncompleteUserDataContent;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.RecordAgreement;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.domain.util.AlipayConnectUtils;
import id.dana.lib.gcontainer.GContainer;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity;
import id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity;
import id.dana.miniprogram.tnc.TncMiniProgramDialogActivity;
import id.dana.miniprogram.tracker.MiniProgramTracker;
import id.dana.utils.ErrorUtil;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u0001:\u0003a`bB\u0007¢\u0006\u0004\b^\u0010_J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0012J+\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00132\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00182\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001a0\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJW\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00182\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001eJA\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0016¢\u0006\u0004\b \u0010\u000fJ\u0015\u0010!\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&JS\u0010)\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020(0\fH\u0016¢\u0006\u0004\b)\u0010\u0012J_\u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\fH\u0016¢\u0006\u0004\b,\u0010-J#\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002¢\u0006\u0004\b.\u0010/R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u00103R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u00104R\u0012\u00106\u001a\u000205X\u0087\"¢\u0006\u0006\n\u0004\b6\u00107R\u0012\u00109\u001a\u000208X\u0087\"¢\u0006\u0006\n\u0004\b9\u0010:R\u0012\u0010<\u001a\u00020;X\u0087\"¢\u0006\u0006\n\u0004\b<\u0010=R\u0012\u0010?\u001a\u00020>X\u0087\"¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010\u0016\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010BR\u0012\u0010\u001b\u001a\u00020CX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010DR\u0016\u00101\u001a\u00020E8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010H8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010IR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001a0\f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bK\u00103R\u0012\u0010N\u001a\u00020MX\u0087\"¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bJ\u0010QR\u0016\u0010F\u001a\u00020S8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bR\u0010TR\u0012\u0010V\u001a\u00020UX\u0087\"¢\u0006\u0006\n\u0004\bV\u0010WR\u0012\u0010Y\u001a\u00020XX\u0087\"¢\u0006\u0006\n\u0004\bY\u0010ZR\u0012\u0010\\\u001a\u00020[X\u0087\"¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bL\u00104"}, d2 = {"Lid/dana/miniprogram/provider/OauthServiceProvider;", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthService;", "", "p0", "p1", "p2", "p3", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthConsultResult;", "consultAuthPage", "(Ljava/lang/String;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "", "p4", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "", "Lkotlin/Function1;", "Lid/dana/domain/authcode/AuthCodeResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLkotlin/jvm/functions/Function1;)V", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;", "", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthResult;", Constants.JS_API_GET_AUTH_CODE, "(Ljava/lang/String;Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "p5", "(Ljava/lang/String;Ljava/util/Set;Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthScopeQueryResult;", "getAuthorizedScopes", "getAuthRequestContext", "(Lcom/alipay/iap/android/wallet/acl/oauth/OAuthResult;)V", "Lid/dana/miniprogram/provider/OauthServiceProvider$AgreementMessageEvent;", "event", "onReceiveAgreementMessageEvent", "(Lid/dana/miniprogram/provider/OauthServiceProvider$AgreementMessageEvent;)V", "", "Lcom/alipay/iap/android/wallet/acl/base/BaseResult;", "revokeAuthorizedScopes", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthPageConfirmResult;", "p6", "showAuthPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "PlaceComponentResult", "(Ljava/util/Set;)Ljava/util/Set;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Ljava/lang/String;", "Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "buildAgreementContent", "Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "buildIncompleteUserDataContent", "Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "checkUserInfo", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "consultAgreement", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/data/globalnetwork/model/GnAuthResult;", "moveToNextValue", "Lid/dana/data/globalnetwork/model/GnAuthResult;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "miniProgramPreference", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "Lid/dana/miniprogram/provider/OauthServiceProvider$OauthInfo;", "Lid/dana/miniprogram/provider/OauthServiceProvider$OauthInfo;", "scheduleImpl", "Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity$StartParams;", "Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity$StartParams;", "Lid/dana/domain/useragreement/interactor/RecordAgreement;", "recordAgreement", "Lid/dana/domain/useragreement/interactor/RecordAgreement;", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "remoteGnPaymentEntityData", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "()V", "Companion", "AgreementMessageEvent", "OauthInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OauthServiceProvider implements OAuthService {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<String> MyBillsEntityDataFactory = new ArrayList();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Callback<OAuthPageConfirmResult> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public PublishSubject<GnAuthResult> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private OauthInfo scheduleImpl;
    private String PlaceComponentResult;
    @Inject
    public BuildAgreementContent buildAgreementContent;
    @Inject
    public BuildIncompleteUserDataContent buildIncompleteUserDataContent;
    @Inject
    public GetEmptyUserInfo checkUserInfo;
    @Inject
    public ConsultAgreement consultAgreement;
    @Inject
    public GetAuthCode getAuthCode;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private ConsultAgreementResponse KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Callback<OAuthResult> lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String getErrorConfigVersion;
    @Inject
    public MiniProgramPreference miniProgramPreference;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private GnAuthResult BuiltInFictitiousFunctionClassFactory;
    @Inject
    public RecordAgreement recordAgreement;
    @Inject
    public RemoteGnPaymentEntityData remoteGnPaymentEntityData;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TncMiniProgramDialogActivity.StartParams moveToNextValue;
    @Inject
    public SplitFacade splitFacade;

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void consultAuthPage(String p0, Map<String, String> p1, APIContext p2, Callback<OAuthConsultResult> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
    }

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void consultAuthPage(String p0, Set<String> p1, Map<String, String> p2, APIContext p3, Callback<OAuthConsultResult> p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
    }

    public OauthServiceProvider() {
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
        EventBus.getDefault().register(this);
    }

    private static Set<String> PlaceComponentResult(Set<String> p0) {
        List split$default = StringsKt.split$default((CharSequence) CollectionsKt.joinToString$default(p0, ",", null, null, 0, null, null, 62, null), new char[]{','}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if ((!StringsKt.isBlank((String) obj)) != false) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void getAuthCode(String str, Set<String> set, OAuthCodeFlowType oAuthCodeFlowType, Map<String, String> map, APIContext aPIContext, Callback<OAuthResult> callback) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(oAuthCodeFlowType, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aPIContext, "");
        Intrinsics.checkNotNullParameter(callback, "");
        Set<String> PlaceComponentResult = PlaceComponentResult(set);
        String str3 = this.PlaceComponentResult;
        GnAuthResult gnAuthResult = null;
        if (str3 != null) {
            OAuthResult oAuthResult = new OAuthResult();
            Object[] array = PlaceComponentResult.toArray(new String[0]);
            if (array != null) {
                oAuthResult.setAuthSuccessScopes((String[]) array);
                oAuthResult.setAuthCode(str3);
                callback.result(oAuthResult);
                this.PlaceComponentResult = null;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        if (OAuthCodeFlowType.ALIPAY_CONNECT != oAuthCodeFlowType) {
            String str4 = map.get("authClientId");
            str2 = str4 == null ? "" : str4;
        } else {
            str2 = str;
        }
        GnAuthResult gnAuthResult2 = new GnAuthResult(str2, null, null, null, null, 30, null);
        gnAuthResult2.setOAuthCodeFlowType(oAuthCodeFlowType);
        gnAuthResult2.setScopes(PlaceComponentResult);
        gnAuthResult2.setExtendInfo(map);
        gnAuthResult2.setCallback(callback);
        this.BuiltInFictitiousFunctionClassFactory = gnAuthResult2;
        if (oAuthCodeFlowType != OAuthCodeFlowType.ALIPAY_CONNECT) {
            OAuthResult oAuthResult2 = new OAuthResult();
            oAuthResult2.setResultError(new ResultError(2001, ""));
            callback.result(oAuthResult2);
            return;
        }
        GnAuthResult gnAuthResult3 = this.BuiltInFictitiousFunctionClassFactory;
        if (gnAuthResult3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            gnAuthResult3 = null;
        }
        gnAuthResult3.setScopes(SetsKt.setOf("MINI_PROGRAM"));
        PublishSubject<GnAuthResult> publishSubject = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (publishSubject != null) {
            GnAuthResult gnAuthResult4 = this.BuiltInFictitiousFunctionClassFactory;
            if (gnAuthResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                gnAuthResult4 = null;
            }
            publishSubject.onNext(gnAuthResult4);
        }
        MiniProgramPreference miniProgramPreference = this.miniProgramPreference;
        if (miniProgramPreference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            miniProgramPreference = null;
        }
        GnAuthResult gnAuthResult5 = this.BuiltInFictitiousFunctionClassFactory;
        if (gnAuthResult5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            gnAuthResult = gnAuthResult5;
        }
        miniProgramPreference.getAuthRequestContext(str, gnAuthResult);
    }

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void getAuthCode(String str, OAuthCodeFlowType oAuthCodeFlowType, Map<String, String> map, APIContext aPIContext, Callback<OAuthResult> callback) {
        String replace;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(oAuthCodeFlowType, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aPIContext, "");
        Intrinsics.checkNotNullParameter(callback, "");
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "https://m.dana.id/m/portal/oauth", false, 2, (Object) null)) {
            replace = StringsKt.replace(str, "https://m.dana.id/m/portal/oauth", "https://link.dana.id/bind", true);
        } else {
            replace = StringsKt.contains$default((CharSequence) str2, (CharSequence) "https://m.dana.id/d/portal/oauth", false, 2, (Object) null) ? StringsKt.replace(str, "https://m.dana.id/d/portal/oauth", "https://link.dana.id/bind", true) : str;
        }
        this.lookAheadTest = callback;
        if (UrlUtil.isDeepLink(replace)) {
            EventBus.getDefault().post(new DanaApplication.GnAuthSpecialMerchantMessageEvent(replace, str));
        }
    }

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void showAuthPage(final String p0, String p1, String p2, Set<String> p3, final Map<String, String> p4, final APIContext p5, Callback<OAuthPageConfirmResult> p6) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Intrinsics.checkNotNullParameter(p6, "");
        final Set<String> PlaceComponentResult = PlaceComponentResult(p3);
        this.scheduleImpl = new OauthInfo(p0, p1, PlaceComponentResult, p2, p4, p5);
        this.getAuthRequestContext = p6;
        MiniProgramMetaData miniProgramInfo = p5.getMiniProgramInfo();
        if (miniProgramInfo == null || (str = miniProgramInfo.getMerchantId()) == null || !StringsKt.startsWith$default(str, "SUB", false, 2, (Object) null)) {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.getErrorConfigVersion = str;
        String str3 = p4.get("authClientId");
        String str4 = str3 == null ? "" : str3;
        Set<String> set = PlaceComponentResult;
        String joinToString$default = CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
        String str5 = this.getErrorConfigVersion;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str2 = null;
        } else {
            str2 = str5;
        }
        String str6 = null;
        this.moveToNextValue = new TncMiniProgramDialogActivity.StartParams(p0, str4, joinToString$default, p2, p1, str2, false, null, 192, null);
        this.MyBillsEntityDataFactory.clear();
        ConsultAgreement consultAgreement = this.consultAgreement;
        if (consultAgreement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            consultAgreement = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ShowAgreementBridge.MINI_PROGRAM_PREFIX);
        sb.append(p0);
        sb.append('_');
        MiniProgramMetaData miniProgramInfo2 = p5.getMiniProgramInfo();
        if (miniProgramInfo2 != null) {
            str6 = miniProgramInfo2.getMerchantId();
        }
        sb.append(str6);
        consultAgreement.execute(new ConsultAgreement.Params(p0, CollectionsKt.listOf(sb.toString()), ShowAgreementBridge.MERCHANT_PAGE_AGREEMENT_TYPE, CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null), null, true), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAuthPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                List list;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                OauthServiceProvider.this.KClassImpl$Data$declaredNonStaticMembers$2 = consultAgreementResponse;
                if (consultAgreementResponse.getNeedUserAgreement()) {
                    List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
                    if (agreementInfos != null) {
                        OauthServiceProvider oauthServiceProvider = OauthServiceProvider.this;
                        Iterator<T> it = agreementInfos.iterator();
                        while (it.hasNext()) {
                            String agreementKey = ((AgreementInfo) it.next()).getAgreementKey();
                            if (agreementKey != null) {
                                list = oauthServiceProvider.MyBillsEntityDataFactory;
                                list.add(agreementKey);
                            }
                        }
                    }
                    OauthServiceProvider oauthServiceProvider2 = OauthServiceProvider.this;
                    String str7 = p0;
                    String str8 = p4.get("authClientId");
                    if (str8 == null) {
                        str8 = "";
                    }
                    MiniProgramMetaData miniProgramInfo3 = p5.getMiniProgramInfo();
                    String merchantId = miniProgramInfo3 != null ? miniProgramInfo3.getMerchantId() : null;
                    oauthServiceProvider2.MyBillsEntityDataFactory(str7, str8, merchantId != null ? merchantId : "", CollectionsKt.joinToString$default(PlaceComponentResult, ",", null, null, 0, null, null, 62, null));
                    return;
                }
                OauthServiceProvider oauthServiceProvider3 = OauthServiceProvider.this;
                final OauthServiceProvider oauthServiceProvider4 = OauthServiceProvider.this;
                oauthServiceProvider3.KClassImpl$Data$declaredNonStaticMembers$2(true, (Function1<? super AuthCodeResult, Unit>) new Function1<AuthCodeResult, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAuthPage$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                        invoke2(authCodeResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(AuthCodeResult authCodeResult) {
                        OauthServiceProvider.OauthInfo oauthInfo;
                        GnAuthResult gnAuthResult;
                        Callback callback;
                        Intrinsics.checkNotNullParameter(authCodeResult, "");
                        OauthServiceProvider.this.PlaceComponentResult = authCodeResult.getAuthCode();
                        MiniProgramPreference miniProgramPreference = OauthServiceProvider.this.miniProgramPreference;
                        if (miniProgramPreference == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            miniProgramPreference = null;
                        }
                        oauthInfo = OauthServiceProvider.this.scheduleImpl;
                        if (oauthInfo == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            oauthInfo = null;
                        }
                        String str9 = oauthInfo.getAuthRequestContext;
                        gnAuthResult = OauthServiceProvider.this.BuiltInFictitiousFunctionClassFactory;
                        if (gnAuthResult == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            gnAuthResult = null;
                        }
                        miniProgramPreference.getAuthRequestContext(str9, gnAuthResult);
                        callback = OauthServiceProvider.this.getAuthRequestContext;
                        if (callback != null) {
                            callback.result(new OAuthPageConfirmResult(null));
                        }
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAuthPage$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullParameter(th, "");
                OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
            }
        });
    }

    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    public final void revokeAuthorizedScopes(String p0, Set<String> p1, Map<String, String> p2, APIContext p3, Callback<BaseResult> p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p4, "");
        StringBuilder sb = new StringBuilder();
        sb.append("An operation is not implemented: ");
        sb.append("Not yet implemented");
        throw new NotImplementedError(sb.toString());
    }

    @Subscribe
    public final void onReceiveAgreementMessageEvent(final AgreementMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (!event.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            this.PlaceComponentResult = null;
            Callback<OAuthPageConfirmResult> callback = this.getAuthRequestContext;
            if (callback != null) {
                OAuthPageConfirmResult oAuthPageConfirmResult = new OAuthPageConfirmResult("");
                oAuthPageConfirmResult.setResultError(new ResultError(1001, "User disagreed"));
                callback.result(oAuthPageConfirmResult);
                return;
            }
            return;
        }
        RecordAgreement recordAgreement = this.recordAgreement;
        if (recordAgreement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recordAgreement = null;
        }
        OauthInfo oauthInfo = this.scheduleImpl;
        if (oauthInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo = null;
        }
        String str = oauthInfo.getAuthRequestContext;
        List<String> list = this.MyBillsEntityDataFactory;
        OauthInfo oauthInfo2 = this.scheduleImpl;
        if (oauthInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo2 = null;
        }
        String joinToString$default = CollectionsKt.joinToString$default(oauthInfo2.NetworkUserEntityData$$ExternalSyntheticLambda0, ",", null, null, 0, null, null, 62, null);
        OauthInfo oauthInfo3 = this.scheduleImpl;
        if (oauthInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo3 = null;
        }
        String str2 = oauthInfo3.getAuthRequestContext;
        OauthInfo oauthInfo4 = this.scheduleImpl;
        if (oauthInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo4 = null;
        }
        String str3 = oauthInfo4.BuiltInFictitiousFunctionClassFactory.get("authClientId");
        String str4 = str3 == null ? "" : str3;
        OauthInfo oauthInfo5 = this.scheduleImpl;
        if (oauthInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo5 = null;
        }
        MiniProgramMetaData miniProgramInfo = oauthInfo5.PlaceComponentResult.getMiniProgramInfo();
        String merchantId = miniProgramInfo != null ? miniProgramInfo.getMerchantId() : null;
        recordAgreement.execute(new RecordAgreement.Params(str, list, true, ShowAgreementBridge.MERCHANT_PAGE_AGREEMENT_TYPE, joinToString$default, str2, str4, merchantId == null ? "" : merchantId), new Function1<Unit, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$onReceiveAgreementMessageEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                GnAuthResult gnAuthResult;
                Callback callback2;
                Intrinsics.checkNotNullParameter(unit, "");
                OauthServiceProvider.this.PlaceComponentResult = event.PlaceComponentResult;
                MiniProgramPreference miniProgramPreference = OauthServiceProvider.this.miniProgramPreference;
                if (miniProgramPreference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    miniProgramPreference = null;
                }
                String str5 = event.BuiltInFictitiousFunctionClassFactory;
                gnAuthResult = OauthServiceProvider.this.BuiltInFictitiousFunctionClassFactory;
                if (gnAuthResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    gnAuthResult = null;
                }
                miniProgramPreference.getAuthRequestContext(str5, gnAuthResult);
                callback2 = OauthServiceProvider.this.getAuthRequestContext;
                if (callback2 != null) {
                    callback2.result(new OAuthPageConfirmResult(null));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$onReceiveAgreementMessageEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullParameter(th, "");
                OauthServiceProvider.this.PlaceComponentResult = null;
                OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0007X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/miniprogram/provider/OauthServiceProvider$AgreementMessageEvent;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class AgreementMessageEvent {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        public AgreementMessageEvent(boolean z, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = str2;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public final void getAuthRequestContext(OAuthResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Callback<OAuthResult> callback = this.lookAheadTest;
        if (callback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            callback = null;
        }
        callback.result(p0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/miniprogram/provider/OauthServiceProvider$Companion;", "", "Lid/dana/miniprogram/provider/OauthServiceProvider;", "getAuthRequestContext", "()Lid/dana/miniprogram/provider/OauthServiceProvider;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OauthServiceProvider getAuthRequestContext() {
            try {
                BaseService service = WalletServiceManager.getInstance().getService(OAuthService.class);
                if (service instanceof OauthServiceProvider) {
                    return (OauthServiceProvider) service;
                }
                return null;
            } catch (Exception unused) {
                AlipayConnectUtils alipayConnectUtils = AlipayConnectUtils.INSTANCE;
                boolean z = true;
                try {
                    WalletServiceManager.getInstance().registerServices(OauthServiceProvider.class);
                } catch (Exception unused2) {
                    z = false;
                }
                if (z) {
                    return getAuthRequestContext();
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\"\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/miniprogram/provider/OauthServiceProvider$OauthInfo;", "", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "PlaceComponentResult", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "", "Ljava/util/Map;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/Set;", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OauthInfo {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final APIContext PlaceComponentResult;
        final String MyBillsEntityDataFactory;
        final Set<String> NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Map<String, String> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public OauthInfo(String str, String str2, Set<String> set, String str3, Map<String, String> map, APIContext aPIContext) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(set, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(aPIContext, "");
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = set;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.BuiltInFictitiousFunctionClassFactory = map;
            this.PlaceComponentResult = aPIContext;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(final OauthServiceProvider oauthServiceProvider, final String str, final String str2, Set set, final String str3, final String str4, Set set2) {
        final String joinToString$default = CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
        BuildIncompleteUserDataContent buildIncompleteUserDataContent = oauthServiceProvider.buildIncompleteUserDataContent;
        if (buildIncompleteUserDataContent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            buildIncompleteUserDataContent = null;
        }
        buildIncompleteUserDataContent.execute(new BuildIncompleteUserDataContent.Param(set2), new Function1<List<? extends String>, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showMissingRequiredUserInfoDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                OauthServiceProvider.OauthInfo oauthInfo;
                Intrinsics.checkNotNullParameter(list, "");
                Application applicationContext = GriverEnv.getApplicationContext();
                String str5 = str;
                oauthInfo = oauthServiceProvider.scheduleImpl;
                if (oauthInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo = null;
                }
                Intent putExtra = new Intent(applicationContext, MissingRequiredUserInfoDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).putExtra("startParams", new MissingRequiredUserInfoDialogActivity.StartParams(str5, oauthInfo.MyBillsEntityDataFactory, str2, joinToString$default, str3, str4, true, list));
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                applicationContext.startActivity(putExtra);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showMissingRequiredUserInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullParameter(th, "");
                OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider oauthServiceProvider, Throwable th) {
        Callback<OAuthPageConfirmResult> callback = oauthServiceProvider.getAuthRequestContext;
        if (callback != null) {
            OAuthPageConfirmResult oAuthPageConfirmResult = new OAuthPageConfirmResult("");
            oAuthPageConfirmResult.setResultError(new ResultError(1000, th.getMessage()));
            callback.result(oAuthPageConfirmResult);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, final Function1<? super AuthCodeResult, Unit> p1) {
        String str;
        GetAuthCode getAuthCode = this.getAuthCode;
        OauthInfo oauthInfo = null;
        if (getAuthCode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getAuthCode = null;
        }
        GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
        OauthInfo oauthInfo2 = this.scheduleImpl;
        if (oauthInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo2 = null;
        }
        String str2 = oauthInfo2.BuiltInFictitiousFunctionClassFactory.get("authClientId");
        String str3 = str2 == null ? "" : str2;
        OauthInfo oauthInfo3 = this.scheduleImpl;
        if (oauthInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            oauthInfo3 = null;
        }
        String joinToString$default = CollectionsKt.joinToString$default(oauthInfo3.NetworkUserEntityData$$ExternalSyntheticLambda0, ",", null, null, 0, null, null, 62, null);
        String str4 = this.getErrorConfigVersion;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str4;
        }
        OauthInfo oauthInfo4 = this.scheduleImpl;
        if (oauthInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            oauthInfo = oauthInfo4;
        }
        getAuthCode.execute(companion.forGetAuthCodeMpAgreements("https://m.dana.id/m/portal", str3, joinToString$default, p0, str, true, oauthInfo.getAuthRequestContext), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$fetchAuthCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                p1.invoke(authCodeResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$fetchAuthCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                OauthServiceProvider.OauthInfo oauthInfo5;
                OauthServiceProvider.OauthInfo oauthInfo6;
                OauthServiceProvider.OauthInfo oauthInfo7;
                OauthServiceProvider.OauthInfo oauthInfo8;
                OauthServiceProvider.OauthInfo oauthInfo9;
                OauthServiceProvider.OauthInfo oauthInfo10;
                OauthServiceProvider.OauthInfo oauthInfo11;
                Intrinsics.checkNotNullParameter(th, "");
                MiniProgramTracker miniProgramTracker = MiniProgramTracker.INSTANCE;
                Application applicationContext = GriverEnv.getApplicationContext();
                String PlaceComponentResult = ErrorUtil.PlaceComponentResult(th, GriverEnv.getApplicationContext());
                oauthInfo5 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo5 = null;
                }
                String str5 = oauthInfo5.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                MiniProgramTracker.BuiltInFictitiousFunctionClassFactory(applicationContext, th, Constants.JS_API_GET_AUTH_CODE, PlaceComponentResult, str5);
                OauthServiceProvider.this.PlaceComponentResult = null;
                if (!(th instanceof GetAuthCode.MissingRequiredUserInfoException)) {
                    OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
                    return;
                }
                GetAuthCode.MissingRequiredUserInfoException missingRequiredUserInfoException = (GetAuthCode.MissingRequiredUserInfoException) th;
                oauthInfo6 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo6 = null;
                }
                String str6 = oauthInfo6.getAuthRequestContext;
                oauthInfo7 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo7 = null;
                }
                String str7 = oauthInfo7.MyBillsEntityDataFactory;
                oauthInfo8 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo8 = null;
                }
                String str8 = oauthInfo8.KClassImpl$Data$declaredNonStaticMembers$2;
                oauthInfo9 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo9 = null;
                }
                String joinToString$default2 = CollectionsKt.joinToString$default(oauthInfo9.NetworkUserEntityData$$ExternalSyntheticLambda0, ",", null, null, 0, null, null, 62, null);
                oauthInfo10 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo10 = null;
                }
                String str9 = oauthInfo10.BuiltInFictitiousFunctionClassFactory.get("authClientId");
                String str10 = str9 == null ? "" : str9;
                oauthInfo11 = OauthServiceProvider.this.scheduleImpl;
                if (oauthInfo11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    oauthInfo11 = null;
                }
                MiniProgramMetaData miniProgramInfo = oauthInfo11.PlaceComponentResult.getMiniProgramInfo();
                String merchantId = miniProgramInfo != null ? miniProgramInfo.getMerchantId() : null;
                ExtensionsKt.BuiltInFictitiousFunctionClassFactory(missingRequiredUserInfoException, str6, str7, str8, joinToString$default2, str10, merchantId == null ? "" : merchantId, true);
            }
        });
    }

    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        GetEmptyUserInfo getEmptyUserInfo = this.checkUserInfo;
        if (getEmptyUserInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getEmptyUserInfo = null;
        }
        getEmptyUserInfo.execute(new GetEmptyUserInfo.Params(p0, p3, p1, true), new Function1<GetEmptyUserInfo.UserInfo, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$checkUserInfoCompletion$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GetEmptyUserInfo.UserInfo userInfo) {
                invoke2(userInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GetEmptyUserInfo.UserInfo userInfo) {
                ConsultAgreementResponse consultAgreementResponse;
                OauthServiceProvider.OauthInfo oauthInfo;
                OauthServiceProvider.OauthInfo oauthInfo2;
                Intrinsics.checkNotNullParameter(userInfo, "");
                ConsultAgreementResponse consultAgreementResponse2 = null;
                OauthServiceProvider.OauthInfo oauthInfo3 = null;
                if (userInfo.getStatus() == GetEmptyUserInfo.Status.INCOMPLETE) {
                    OauthServiceProvider oauthServiceProvider = OauthServiceProvider.this;
                    String str = p0;
                    oauthInfo = oauthServiceProvider.scheduleImpl;
                    if (oauthInfo == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        oauthInfo = null;
                    }
                    String str2 = oauthInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                    oauthInfo2 = OauthServiceProvider.this.scheduleImpl;
                    if (oauthInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        oauthInfo3 = oauthInfo2;
                    }
                    OauthServiceProvider.getAuthRequestContext(oauthServiceProvider, str, str2, oauthInfo3.NetworkUserEntityData$$ExternalSyntheticLambda0, p1, p2, userInfo.getIncompleteUserData());
                } else if (userInfo.getStatus() != GetEmptyUserInfo.Status.EMAIL_UNVERIFIED) {
                    if (GContainer.isOpeningH5()) {
                        consultAgreementResponse = OauthServiceProvider.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (consultAgreementResponse == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            consultAgreementResponse2 = consultAgreementResponse;
                        }
                        if (!consultAgreementResponse2.getNeedUserAgreement()) {
                            OauthServiceProvider oauthServiceProvider2 = OauthServiceProvider.this;
                            final OauthServiceProvider oauthServiceProvider3 = OauthServiceProvider.this;
                            oauthServiceProvider2.KClassImpl$Data$declaredNonStaticMembers$2(true, (Function1<? super AuthCodeResult, Unit>) new Function1<AuthCodeResult, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$checkUserInfoCompletion$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                                    invoke2(authCodeResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(AuthCodeResult authCodeResult) {
                                    OauthServiceProvider.OauthInfo oauthInfo4;
                                    GnAuthResult gnAuthResult;
                                    Callback callback;
                                    Intrinsics.checkNotNullParameter(authCodeResult, "");
                                    OauthServiceProvider.this.PlaceComponentResult = authCodeResult.getAuthCode();
                                    MiniProgramPreference miniProgramPreference = OauthServiceProvider.this.miniProgramPreference;
                                    if (miniProgramPreference == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        miniProgramPreference = null;
                                    }
                                    oauthInfo4 = OauthServiceProvider.this.scheduleImpl;
                                    if (oauthInfo4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        oauthInfo4 = null;
                                    }
                                    String str3 = oauthInfo4.getAuthRequestContext;
                                    gnAuthResult = OauthServiceProvider.this.BuiltInFictitiousFunctionClassFactory;
                                    if (gnAuthResult == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        gnAuthResult = null;
                                    }
                                    miniProgramPreference.getAuthRequestContext(str3, gnAuthResult);
                                    callback = OauthServiceProvider.this.getAuthRequestContext;
                                    if (callback != null) {
                                        callback.result(new OAuthPageConfirmResult(null));
                                    }
                                }
                            });
                            return;
                        }
                        r12.KClassImpl$Data$declaredNonStaticMembers$2(false, (Function1<? super AuthCodeResult, Unit>) new Function1<AuthCodeResult, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAgreementDialog$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                                invoke2(authCodeResult);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(AuthCodeResult authCodeResult) {
                                TncMiniProgramDialogActivity.StartParams startParams;
                                Intrinsics.checkNotNullParameter(authCodeResult, "");
                                BuildAgreementContent buildAgreementContent = OauthServiceProvider.this.buildAgreementContent;
                                TncMiniProgramDialogActivity.StartParams startParams2 = null;
                                if (buildAgreementContent == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    buildAgreementContent = null;
                                }
                                startParams = OauthServiceProvider.this.moveToNextValue;
                                if (startParams == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                } else {
                                    startParams2 = startParams;
                                }
                                BuildAgreementContent.Params params = new BuildAgreementContent.Params(startParams2.moveToNextValue, authCodeResult.getAgreements());
                                final OauthServiceProvider oauthServiceProvider4 = OauthServiceProvider.this;
                                Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAgreementDialog$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                                        invoke2(arrayList);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(ArrayList<String> arrayList) {
                                        TncMiniProgramDialogActivity.StartParams startParams3;
                                        TncMiniProgramDialogActivity.StartParams startParams4;
                                        Intrinsics.checkNotNullParameter(arrayList, "");
                                        startParams3 = OauthServiceProvider.this.moveToNextValue;
                                        TncMiniProgramDialogActivity.StartParams startParams5 = null;
                                        if (startParams3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            startParams3 = null;
                                        }
                                        Intrinsics.checkNotNullParameter(arrayList, "");
                                        startParams3.getAuthRequestContext = arrayList;
                                        Application applicationContext = GriverEnv.getApplicationContext();
                                        Intent addFlags = new Intent(applicationContext, TncMiniProgramDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        startParams4 = OauthServiceProvider.this.moveToNextValue;
                                        if (startParams4 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                        } else {
                                            startParams5 = startParams4;
                                        }
                                        Intent putExtra = addFlags.putExtra("startParams", startParams5);
                                        Intrinsics.checkNotNullExpressionValue(putExtra, "");
                                        applicationContext.startActivity(putExtra);
                                    }
                                };
                                final OauthServiceProvider oauthServiceProvider5 = OauthServiceProvider.this;
                                buildAgreementContent.execute(params, function1, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$showAgreementDialog$1.2
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
                                        Intrinsics.checkNotNullParameter(th, "");
                                        OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
                                    }
                                });
                            }
                        });
                    }
                } else {
                    GriverEnv.getApplicationContext().startActivity(new Intent(GriverEnv.getApplicationContext(), EmailNotVerifiedDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.provider.OauthServiceProvider$checkUserInfoCompletion$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullParameter(th, "");
                OauthServiceProvider.KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider.this, th);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        if (r2 == null) goto L33;
     */
    @Override // com.alipay.iap.android.wallet.acl.oauth.OAuthService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthorizedScopes(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3, com.alipay.iap.android.wallet.acl.base.APIContext r4, com.alipay.iap.android.wallet.acl.base.Callback<com.alipay.iap.android.wallet.acl.oauth.OAuthScopeQueryResult> r5) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            id.dana.data.miniprogram.source.local.MiniProgramPreference r3 = r1.miniProgramPreference
            if (r3 == 0) goto L13
            goto L17
        L13:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r3 = 0
        L17:
            java.util.HashMap r3 = r3.getAuthRequestContext()
            java.lang.Object r2 = r3.get(r2)
            id.dana.data.globalnetwork.model.GnAuthResult r2 = (id.dana.data.globalnetwork.model.GnAuthResult) r2
            if (r2 == 0) goto L3e
            java.util.Set r2 = r2.getScopes()
            if (r2 != 0) goto L2d
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L2d:
            org.json.JSONArray r3 = new org.json.JSONArray
            java.util.Collection r2 = (java.util.Collection) r2
            r3.<init>(r2)
            java.lang.String r2 = r3.toString()
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            if (r2 != 0) goto L42
        L3e:
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L42:
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.Object[] r2 = r2.toArray(r3)
            if (r2 == 0) goto L61
            java.lang.String[] r2 = (java.lang.String[]) r2
            com.alipay.iap.android.wallet.acl.oauth.OAuthScopeQueryResult r3 = new com.alipay.iap.android.wallet.acl.oauth.OAuthScopeQueryResult
            int r4 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String[] r2 = (java.lang.String[]) r2
            r3.<init>(r2)
            com.alipay.iap.android.wallet.acl.base.Result r3 = (com.alipay.iap.android.wallet.acl.base.Result) r3
            r5.result(r3)
            return
        L61:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.provider.OauthServiceProvider.getAuthorizedScopes(java.lang.String, java.util.Map, com.alipay.iap.android.wallet.acl.base.APIContext, com.alipay.iap.android.wallet.acl.base.Callback):void");
    }
}
