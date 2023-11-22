package id.dana.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.DeepLinkCallback;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerServiceComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.dialog.DialogWithImage;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.richview.ToolbarSearchView;
import id.dana.richview.category.CategoryView;
import id.dana.richview.category.model.CategoryModel;
import id.dana.richview.servicescard.ServiceCategoryView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.service.adapter.ServiceAdapter;
import id.dana.service.favorites.FavoriteServicesView;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.SizeUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\b¢\u0006\u0005\b\u0083\u0001\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0012J\u000f\u0010\n\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\n\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020#2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0013H\u0016¢\u0006\u0004\b,\u0010\u0014J\u000f\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u0014J\u000f\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010\u0014J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0014J\u000f\u00100\u001a\u00020\u0013H\u0016¢\u0006\u0004\b0\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0004\u00101J3\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u00102\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u00103J\u001d\u0010\b\u001a\u00020\u00132\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\b\b\u00104J\u0019\u0010\b\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u00105J\u0017\u0010$\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u00101J\u0015\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u00101J\u0017\u0010\b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u00101J\u001d\u0010\f\u001a\u00020\u00132\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\b\f\u00104J\u000f\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0014J\u000f\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0014J\u0017\u0010\f\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u00101J\u0017\u0010\n\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\n\u0010:R\u0016\u0010\u0004\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010;R\"\u0010=\u001a\u00020<8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010$\u001a\u00020\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010\f\u001a\u00020E8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010;R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u0010;R\u0014\u0010\u0017\u001a\u00020E8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010GR\"\u0010X\u001a\u00020W8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010C\u001a\u00020E8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010GR\"\u0010`\u001a\u00020_8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0016\u0010\u001a\u001a\u00020{8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b*\u0010|R\u0016\u0010F\u001a\u00020}8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b^\u0010~R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001d\u0010\u0080\u0001R\u0016\u0010*\u001a\u00020\u00118CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001"}, d2 = {"Lid/dana/service/ServicesActivity;", "Lid/dana/base/BaseActivity;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", "", "getAuthRequestContext", "(I)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/danah5/DanaH5Listener;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/view/View;", "p1", "p2", "Lid/dana/showcase/target/Target;", "(Landroid/view/View;)Lid/dana/showcase/target/Target;", "", "()V", "lookAheadTest", "Lid/dana/service/ServicesActivity$getDeeplinkCallback$1;", "scheduleImpl", "()Lid/dana/service/ServicesActivity$getDeeplinkCallback$1;", "Lid/dana/contract/deeplink/DeepLinkModule;", "getErrorConfigVersion", "()Lid/dana/contract/deeplink/DeepLinkModule;", "Landroidx/recyclerview/widget/GridLayoutManager;", "GetContactSyncConfig", "()Landroidx/recyclerview/widget/GridLayoutManager;", "getLayout", "()I", "", "Lid/dana/model/ThirdPartyService;", "", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/contract/paylater/PayLaterModule;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Lid/dana/contract/paylater/PayLaterModule;", "Lid/dana/contract/services/ServicesModule;", "DatabaseTableConfigUtil", "()Lid/dana/contract/services/ServicesModule;", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "isLayoutRequested", "onBackPressed", "(Z)V", "p3", "(Lid/dana/model/ThirdPartyService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/util/List;)V", "(Ljava/lang/String;)V", "onEdit", "setEditMode", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda5", "(Lid/dana/showcase/target/Target;)V", "Z", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "moveToNextValue", "()Landroid/view/View;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "h5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getH5EventPresenter", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "setH5EventPresenter", "(Lid/dana/h5event/CheckoutH5EventContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingServicePresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingServicePresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingServicePresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "initRecordTimeStamp", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "payLaterPresenter", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "getPayLaterPresenter", "()Lid/dana/contract/paylater/PayLaterContract$Presenter;", "setPayLaterPresenter", "(Lid/dana/contract/paylater/PayLaterContract$Presenter;)V", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "getPlayStoreReviewPresenter", "()Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "setPlayStoreReviewPresenter", "(Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;)V", "Lid/dana/contract/services/ServicesContract$Presenter;", "presenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getPresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setPresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/service/adapter/ServiceAdapter;", "Lid/dana/service/adapter/ServiceAdapter;", "Lid/dana/service/ServiceItemDecorator;", "Lid/dana/service/ServiceItemDecorator;", "Lid/dana/showcase/Showcase;", "Lid/dana/showcase/Showcase;", "newProxyInstance", "()Lid/dana/showcase/target/Target;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesActivity extends BaseActivity {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String FILTER_BY = "FILTER_BY";
    public static final String FILTER_SERVICES = "FILTER_SERVICES";
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    public static final String OPEN_SERVICE = "OPEN_SERVICE";
    public static final byte[] PlaceComponentResult;
    public static final int getAuthRequestContext;
    private static final int getErrorConfigVersion;
    private static char[] newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ServiceAdapter getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Showcase lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    @Inject
    public CheckoutH5EventContract.Presenter h5EventPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private ServiceItemDecorator NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingServicePresenter;
    @Inject
    public PayLaterContract.Presenter payLaterPresenter;
    @Inject
    public PlayStoreReviewContract.Presenter playStoreReviewPresenter;
    @Inject
    public ServicesContract.Presenter presenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 226;
    private static int PrepareContext = 1;

    public static /* synthetic */ void $r8$lambda$3haRmtloXlzggOih4VMHeQ1yMiw(ServicesActivity servicesActivity, boolean z) {
        int i = PrepareContext + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        char c = i % 2 != 0 ? (char) 24 : '2';
        Object[] objArr = null;
        PlaceComponentResult(servicesActivity, z);
        if (c == 24) {
            int length = objArr.length;
        }
        try {
            int i2 = PrepareContext + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$Fo1rd5t2cTyDwphDCjJZJH28noY(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 51;
        PrepareContext = i % 128;
        int i2 = i % 2;
        BuiltInFictitiousFunctionClassFactory(servicesActivity);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 43;
        PrepareContext = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.amp : (char) 23) != 23) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ void $r8$lambda$G8mAYdI3BcFuFiTDuAGXMDE1oh0(ServicesActivity servicesActivity, View view) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 89;
        PrepareContext = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(servicesActivity);
        int i3 = PrepareContext + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* renamed from: $r8$lambda$OJipHXW2vM-zTHy9d_6NQd7L_XY */
    public static /* synthetic */ void m2941$r8$lambda$OJipHXW2vMzTHy9d_6NQd7L_XY(ServicesActivity servicesActivity, int i) {
        int i2 = PrepareContext + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        boolean z = i2 % 2 != 0;
        Object[] objArr = null;
        BuiltInFictitiousFunctionClassFactory(servicesActivity, i);
        if (z) {
            int length = objArr.length;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 103;
        PrepareContext = i3 % 128;
        if (i3 % 2 == 0) {
            int length2 = objArr.length;
        }
    }

    /* renamed from: $r8$lambda$UgH_vBOu2BdBVlvz-Kj3qY3AQng */
    public static /* synthetic */ int m2942$r8$lambda$UgH_vBOu2BdBVlvzKj3qY3AQng(ServicesActivity servicesActivity, ThirdPartyService thirdPartyService) {
        int i = PrepareContext + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? '\'' : 'X') != '\'') {
            return BuiltInFictitiousFunctionClassFactory(servicesActivity, thirdPartyService);
        }
        try {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(servicesActivity, thirdPartyService);
            int i2 = 81 / 0;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$m88_OfNqXPtFF55rkBrUJczR0eQ(ServicesActivity servicesActivity, int i) {
        int i2 = PrepareContext + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        char c = i2 % 2 != 0 ? 'V' : (char) 3;
        MyBillsEntityDataFactory(servicesActivity, i);
        if (c != 'V') {
            return;
        }
        int i3 = 74 / 0;
    }

    /* renamed from: $r8$lambda$miC9TmYeLousklzZZYYnB5ax-GU */
    public static /* synthetic */ void m2943$r8$lambda$miC9TmYeLousklzZZYYnB5axGU(ServicesActivity servicesActivity, CategoryModel categoryModel, boolean z) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 25;
        PrepareContext = i % 128;
        int i2 = i % 2;
        try {
            getAuthRequestContext(servicesActivity, categoryModel, z);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 35;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 42070;
        newProxyInstance = new char[]{37305, 37290, 37276, 37286, 37308, 37307, 37304, 37292, 37309};
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0045  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0030 -> B:39:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 16
            int r7 = r7 + 97
            byte[] r0 = id.dana.service.ServicesActivity.PlaceComponentResult     // Catch: java.lang.Exception -> L54
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 32
            if (r0 != 0) goto L13
            r3 = 32
            goto L15
        L13:
            r3 = 59
        L15:
            r4 = 0
            if (r3 == r2) goto L20
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r7
            r7 = r8
            goto L38
        L20:
            int r7 = id.dana.service.ServicesActivity.PrepareContext     // Catch: java.lang.Exception -> L54
            int r7 = r7 + 9
            int r2 = r7 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2     // Catch: java.lang.Exception -> L54
            int r7 = r7 % 2
            r7 = r8
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r10
            r10 = r9
        L30:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-4)
            int r9 = r10 + 1
            r10 = r9
            r9 = r8
        L38:
            byte r8 = (byte) r9
            r2[r3] = r8
            if (r3 != r7) goto L45
            java.lang.String r7 = new java.lang.String
            r7.<init>(r2, r4)
            r0[r4] = r7
            return
        L45:
            r8 = r1[r10]
            int r3 = r3 + 1
            int r5 = id.dana.service.ServicesActivity.PrepareContext
            int r5 = r5 + 105
            int r6 = r5 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r6
            int r5 = r5 % 2
            goto L30
        L54:
            r7 = move-exception
            goto L57
        L56:
            throw r7
        L57:
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 4
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = id.dana.service.ServicesActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.g(byte, int, int, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        try {
            int i = PrepareContext + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if ((i % 2 != 0 ? (char) 0 : (char) 6) != 6) {
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = 4562815083317175338L;
                    int i2 = 90 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = 4562815083317175338L;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 71;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void _$_clearFindViewByIdCache() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 49;
        PrepareContext = i % 128;
        int i2 = i % 2;
        this._$_findViewCache.clear();
        int i3 = PrepareContext + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        int i4 = 4 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0022, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003d, code lost:
    
        if ((r1 == null ? '(' : '5') != '(') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0040, code lost:
    
        r1 = findViewById(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0044, code lost:
    
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0046, code lost:
    
        r3 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 27;
        id.dana.service.ServicesActivity.PrepareContext = r3 % 128;
        r3 = r3 % 2;
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0057, code lost:
    
        if (r3 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0059, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 26
            if (r0 == 0) goto L11
            r0 = 26
            goto L13
        L11:
            r0 = 66
        L13:
            r2 = 0
            if (r0 == r1) goto L27
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L25
            goto L40
        L25:
            r2 = r1
            goto L5f
        L27:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            android.view.View r1 = (android.view.View) r1
            int r3 = r2.length     // Catch: java.lang.Throwable -> L60
            r3 = 40
            if (r1 != 0) goto L3b
            r4 = 40
            goto L3d
        L3b:
            r4 = 53
        L3d:
            if (r4 == r3) goto L40
            goto L25
        L40:
            android.view.View r1 = r5.findViewById(r6)
            if (r1 == 0) goto L5f
            int r3 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r3 = r3 + 27
            int r4 = r3 % 128
            id.dana.service.ServicesActivity.PrepareContext = r4
            int r3 = r3 % 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r1)
            if (r3 != 0) goto L25
            r2.hashCode()     // Catch: java.lang.Throwable -> L5d
            goto L25
        L5d:
            r6 = move-exception
            throw r6
        L5f:
            return r2
        L60:
            r6 = move-exception
            goto L63
        L62:
            throw r6
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity._$_findCachedViewById(int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:345:0x0071, code lost:
    
        if (r2 > 99999) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0083, code lost:
    
        if ((r2 > 99999 ? 'M' : 14) != 'M') goto L377;
     */
    /* JADX WARN: Removed duplicated region for block: B:378:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0ac8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0704 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:662:0x0514 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:670:0x08ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 3076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        Context applicationContext;
        int i = PrepareContext + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if (!(i % 2 != 0)) {
            applicationContext = super.getApplicationContext();
        } else {
            applicationContext = super.getApplicationContext();
            int i2 = 80 / 0;
        }
        int i3 = PrepareContext + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
        return applicationContext;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        Context baseContext;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 69;
        PrepareContext = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            baseContext = super.getBaseContext();
        } else {
            baseContext = super.getBaseContext();
            objArr.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 125;
        PrepareContext = i2 % 128;
        if (i2 % 2 == 0) {
            int length = objArr.length;
            return baseContext;
        }
        return baseContext;
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = PrepareContext + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? 'D' : 'Q') == 'D') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PrepareContext + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        if ((i2 % 2 != 0 ? 'F' : '\t') != '\t') {
            int i3 = 55 / 0;
            return R.layout.activity_service;
        }
        return R.layout.activity_service;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        try {
            int i = PrepareContext + 115;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if ((i % 2 != 0 ? 'P' : '@') != '@') {
                int i2 = 34 / 0;
                return super.getResources();
            }
            return super.getResources();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        c(super.getResources().getString(R.string.kyc_0_title).substring(0, 5).codePointAt(0) + 15773, new char[]{62728, 51444, 36587, 19650, 714, 49343, 34495, 17634, 6814, 55441, 40505, 23624, 4735, 53329, 38464, 21553, 10794, 59449}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        c(super.getResources().getString(R.string.confirm_dialog_positive).substring(0, 1).codePointAt(0) + 61630, new char[]{62724, 1063, 5970, 9893, 12753}, objArr3);
        Object obj = null;
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if ((intValue < 99000) || intValue > 99999) {
            Context baseContext = getBaseContext();
            if ((baseContext == null ? 'E' : (char) 19) != 19) {
                Object[] objArr4 = new Object[1];
                c(super.getResources().getString(R.string.confirm_pin_description).substring(10, 11).length() + 39658, new char[]{62728, 28652, 49371, 9690, 40618, 62359, 21647, 51498, 8784, 34650, 63543, 23902, 46636, 10469, 36295, 59077, 23471, 48283, 4507, 35425, 61281, 16454, 42281, 7697, 29440, 54782}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    b(PlaceComponentResult[25], PlaceComponentResult[30], PlaceComponentResult[25], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(PlaceComponentResult[5], PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), objArr6);
                    Object[] objArr7 = new Object[1];
                    c(((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 47878, new char[]{62730, 20027, 33621, 50286, 6544, 21188, 38903, 60217, 11297, 24902, 47747, 65453, 12510, 30195, 51519, 585, 18294, 39056}, objArr7);
                    baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if ((baseContext != null ? 'V' : '^') != '^') {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 41;
                PrepareContext = i % 128;
                int i2 = i % 2;
                baseContext = baseContext.getApplicationContext();
                if (i2 == 0) {
                    obj.hashCode();
                }
            }
            if (baseContext != null) {
                int i3 = PrepareContext + 45;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                int i4 = i3 % 2;
                try {
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 35 - TextUtils.indexOf("", ""), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                    }
                    Object invoke = ((Method) obj2).invoke(null, null);
                    try {
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[25], PlaceComponentResult[30], PlaceComponentResult[25], objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(PlaceComponentResult[5], PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), objArr9);
                        Object[] objArr10 = new Object[1];
                        c(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 18490, new char[]{62814, 48465, 26089, 11328, 54325, 40138, 18290, 3884, 46982, 32319, 9860, 61158, 37192, 22980, 418, 51210, 28904, 15187, 58169, 43977, 21009, 6781, 49880, 30066, 15749, 58809, 44143, 21652, 7343, 51010, 36770, 13833, 65072, 42724, 26957, 4385, 55747, 32887, 18643, 61572, 47974, 25500, 11187, 53782, 39599, 17061, 62725, 48569}, objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        c(34543 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{62728, 29619, 63617, 25024, 61107, 22523, 56515, 17880, 49781, 19309, 45062, 14617, 42553, 12155, 37962, 7516, 39851, 132, 35265, 63205, 32673, 58563, 28117, 59939, 21303, 55388, 16662, 52793, 14197, 48158, 9561, 41898, 10474, 37314, 7907, 34812, 3222, 30081, 61987, 31539, 57348, 26910, 54842, 24445, 50206, 19805, 52138, 12479, 47498, 9957, 45040, 5325, 40412, 6693, 33587, 2049, 28945, 65135, 26412, 60446, 21852, 54178, 22767, 49547}, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        c(49102 - ExpandableListView.getPackedPositionChild(0L), new char[]{62811, 19095, 35474, 51814, 2668, 19029, 35713, 52212, 2857, 19222, 35655, 51389, 2284, 18649, 34827, 51327, 2552, 18867, 35283, 51536, 2423, 20208, 36546, 52931, 3638, 20024, 36438, 53124, 4011, 20348, 36636, 53019, 3262, 19618, 35877, 52252, 3095, 19893, 36325, 52696, 3337, 19752, 33454, 49816, 709, 16954, 33338, 49674, 991, 17359, 33636, 49969, 855, 16515, 32933, 49189, 22, 16459, 33206, 49642, 395, 16655, 33150, 50849}, objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        c((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 9539, new char[]{62721, 53342, 49051, 39632, 24598, 20252, 10964, 61843, 57109, 47699, 33177, 27881, 19043, 4474, 64683, 56310, 41276, 35963, 27563, 14067, 7220, 64357, 50911, 44098, 35654, 22167, 15814, 6922, 58969, 52621, 43202, 30209, 23912, 14520, 2026, 60782, 51302, 38825, 29430, 22643, 10096, 674, 59902, 46855, 37508, 31168, 18180, 8769, 2442, 54478, 45648, 39238, 25799, 17305, 10542, 62586, 54180, 48876, 33843, 25451}, objArr13);
                        String str4 = (String) objArr13[0];
                        try {
                            Object[] objArr14 = new Object[1];
                            b(PlaceComponentResult[25], PlaceComponentResult[30], PlaceComponentResult[25], objArr14);
                            Class<?> cls5 = Class.forName((String) objArr14[0]);
                            Object[] objArr15 = new Object[1];
                            b(PlaceComponentResult[5], PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), objArr15);
                            Object[] objArr16 = new Object[1];
                            c(((ApplicationInfo) cls5.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 31874, new char[]{62800, 35300, 3099, 32942, 2007, 39543}, objArr16);
                            try {
                                Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj3);
                                }
                                ((Method) obj3).invoke(invoke, objArr17);
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 65;
        PrepareContext = i5 % 128;
        int i6 = i5 % 2;
        try {
            byte b = (byte) (-PlaceComponentResult[32]);
            byte b2 = PlaceComponentResult[25];
            Object[] objArr18 = new Object[1];
            b(b, b2, (byte) (b2 | 37), objArr18);
            Class<?> cls6 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b((byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), objArr19);
            try {
                Object[] objArr20 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj4 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 494, 4 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    Object[] objArr21 = new Object[1];
                    g($$a[8], $$a[9], (byte) (-$$a[40]), objArr21);
                    obj4 = cls7.getMethod((String) objArr21[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj4);
                }
                Object[] objArr22 = (Object[]) ((Method) obj4).invoke(null, objArr20);
                int i7 = ((int[]) objArr22[1])[0];
                if (((int[]) objArr22[0])[0] != i7) {
                    long j = ((r0 ^ i7) & 4294967295L) | 42949672960L;
                    try {
                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj5 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 'S' - AndroidCharacter.getMirror('0'), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj5);
                        }
                        Object invoke2 = ((Method) obj5).invoke(objArr, objArr);
                        try {
                            Object[] objArr23 = {410676753, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj6 == null) {
                                obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, Color.blue(0) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj6);
                            }
                            ((Method) obj6).invoke(invoke2, objArr23);
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th8) {
                Throwable cause8 = th8.getCause();
                if (cause8 == null) {
                    throw th8;
                }
                throw cause8;
            }
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 37;
            PrepareContext = i % 128;
            int i2 = i % 2;
            try {
                Object[] objArr = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[5], PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), objArr2);
                Object[] objArr3 = new Object[1];
                c(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 39626, new char[]{62728, 28652, 49371, 9690, 40618, 62359, 21647, 51498, 8784, 34650, 63543, 23902, 46636, 10469, 36295, 59077, 23471, 48283, 4507, 35425, 61281, 16454, 42281, 7697, 29440, 54782}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                c(super.getResources().getString(R.string.family_account_text_title_intro_2).substring(11, 12).length() + 47910, new char[]{62730, 20027, 33621, 50286, 6544, 21188, 38903, 60217, 11297, 24902, 47747, 65453, 12510, 30195, 51519, 585, 18294, 39056}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if ((baseContext != null ? 'Z' : (char) 21) != 21) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 25;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 'S' - AndroidCharacter.getMirror('0'), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, TextUtils.indexOf("", "") + 18, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        Object obj = null;
        if (!(baseContext != null)) {
            int i = PrepareContext + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (!(i % 2 == 0)) {
                obj.hashCode();
            }
            int i2 = PrepareContext + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            int i3 = i2 % 2;
            try {
                Object[] objArr = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[5], PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), objArr2);
                Object[] objArr3 = new Object[1];
                c(39626 + ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion, new char[]{62728, 28652, 49371, 9690, 40618, 62359, 21647, 51498, 8784, 34650, 63543, 23902, 46636, 10469, 36295, 59077, 23471, 48283, 4507, 35425, 61281, 16454, 42281, 7697, 29440, 54782}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                c(AndroidCharacter.getMirror('0') + 47863, new char[]{62730, 20027, 33621, 50286, 6544, 21188, 38903, 60217, 11297, 24902, 47747, 65453, 12510, 30195, 51519, 585, 18294, 39056}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 47;
                PrepareContext = i4 % 128;
                int i5 = i4 % 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if ((baseContext != null ? '[' : '\f') != '\f') {
            try {
                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj2 == null) {
                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                }
                Object invoke = ((Method) obj2).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, Drawable.resolveOpacity(0, 0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj3);
                    }
                    ((Method) obj3).invoke(invoke, objArr5);
                    int i6 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 9;
                    PrepareContext = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    public ServicesActivity() {
        try {
            try {
                this._$_findViewCache = new LinkedHashMap();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ DanaH5Listener access$createH5AppListener(ServicesActivity servicesActivity) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 3;
            try {
                PrepareContext = i % 128;
                int i2 = i % 2;
                DanaH5Listener BuiltInFictitiousFunctionClassFactory = servicesActivity.BuiltInFictitiousFunctionClassFactory();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 77;
                PrepareContext = i3 % 128;
                int i4 = i3 % 2;
                return BuiltInFictitiousFunctionClassFactory;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$doOnOpenH5(ServicesActivity servicesActivity) {
        int i = PrepareContext + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        boolean z = i % 2 != 0;
        servicesActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = PrepareContext + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ boolean access$getCheckoutH5EventSuccess$p(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 91;
        PrepareContext = i % 128;
        int i2 = i % 2;
        boolean z = servicesActivity.MyBillsEntityDataFactory;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 43;
        PrepareContext = i3 % 128;
        if (i3 % 2 != 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    public static final /* synthetic */ List access$getListOfUniqueCategory(ServicesActivity servicesActivity, List list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 87;
        PrepareContext = i % 128;
        if ((i % 2 == 0 ? '#' : '4') != '4') {
            List<String> PlaceComponentResult2 = PlaceComponentResult(list);
            Object[] objArr = null;
            int length = objArr.length;
            return PlaceComponentResult2;
        }
        return PlaceComponentResult(list);
    }

    public static final /* synthetic */ ServiceAdapter access$getServiceAdapter$p(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 41;
        PrepareContext = i % 128;
        int i2 = i % 2;
        ServiceAdapter serviceAdapter = servicesActivity.getErrorConfigVersion;
        int i3 = PrepareContext + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
        return serviceAdapter;
    }

    public static final /* synthetic */ ServiceItemDecorator access$getServiceItemDecorator$p(ServicesActivity servicesActivity) {
        int i = PrepareContext + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        char c = i % 2 != 0 ? '`' : '4';
        ServiceItemDecorator serviceItemDecorator = servicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (c != '4') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = PrepareContext + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        int i3 = i2 % 2;
        return serviceItemDecorator;
    }

    public static final /* synthetic */ Target access$getTooltipTarget(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 67;
        PrepareContext = i % 128;
        int i2 = i % 2;
        Target newProxyInstance2 = servicesActivity.newProxyInstance();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 43;
        PrepareContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return newProxyInstance2;
        }
        int i4 = 41 / 0;
        return newProxyInstance2;
    }

    public static final /* synthetic */ void access$openH5(ServicesActivity servicesActivity, ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        try {
            int i = PrepareContext + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            char c = i % 2 != 0 ? (char) 19 : '\b';
            servicesActivity.MyBillsEntityDataFactory(thirdPartyService, str, str2, str3);
            if (c != '\b') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$saveBottomSheetOnboarding(ServicesActivity servicesActivity, String str) {
        int i = PrepareContext + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            servicesActivity.getAuthRequestContext(str);
        } else {
            servicesActivity.getAuthRequestContext(str);
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 85;
        PrepareContext = i2 % 128;
        if ((i2 % 2 == 0 ? '_' : 'Q') != 'Q') {
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$setCategoryViewVisibility(ServicesActivity servicesActivity, boolean z) {
        try {
            int i = PrepareContext + 83;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            char c = i % 2 != 0 ? '7' : '?';
            servicesActivity.PlaceComponentResult(z);
            if (c != '?') {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 59;
            PrepareContext = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setErrorView(ServicesActivity servicesActivity, boolean z) {
        int i = PrepareContext + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if (!(i % 2 != 0)) {
            servicesActivity.getAuthRequestContext(z);
        } else {
            servicesActivity.getAuthRequestContext(z);
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 5;
            PrepareContext = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setShowcase$p(ServicesActivity servicesActivity, Showcase showcase) {
        int i = PrepareContext + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        servicesActivity.lookAheadTest = showcase;
        int i3 = PrepareContext + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setupServiceList(ServicesActivity servicesActivity, List list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 55;
        PrepareContext = i % 128;
        char c = i % 2 == 0 ? 'R' : (char) 17;
        servicesActivity.BuiltInFictitiousFunctionClassFactory(list);
        if (c == 'R') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = PrepareContext + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$showEmptyFilteredResult(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 95;
        PrepareContext = i % 128;
        int i2 = i % 2;
        servicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda8();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 65;
            PrepareContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'T' : '.') != 'T') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showErrorDeeplinkDialog(ServicesActivity servicesActivity) {
        int i = PrepareContext + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? '+' : '\'') != '\'') {
            servicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
            int i2 = 62 / 0;
            return;
        }
        servicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
    }

    public static final /* synthetic */ void access$showSearchHeader(ServicesActivity servicesActivity, boolean z) {
        int i = PrepareContext + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        servicesActivity.BuiltInFictitiousFunctionClassFactory(z);
        int i3 = PrepareContext + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void access$showShowcase(ServicesActivity servicesActivity, Target target) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 25;
        PrepareContext = i % 128;
        char c = i % 2 == 0 ? (char) 6 : '5';
        servicesActivity.KClassImpl$Data$declaredNonStaticMembers$2(target);
        if (c == 6) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = PrepareContext + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 19 / 0;
        }
    }

    @JvmName(name = "getDeviceInformationProvider")
    public final DeviceInformationProvider getDeviceInformationProvider() {
        try {
            int i = PrepareContext + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            try {
                DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
                if ((deviceInformationProvider != null ? (char) 7 : '/') != '/') {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 79;
                    PrepareContext = i3 % 128;
                    int i4 = i3 % 2;
                    return deviceInformationProvider;
                }
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i5 = PrepareContext + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
                int i6 = i5 % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        int i = PrepareContext + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
        int i3 = PrepareContext + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if ((i3 % 2 != 0 ? 'a' : '6') != 'a') {
            return;
        }
        int i4 = 36 / 0;
    }

    @JvmName(name = "getH5EventPresenter")
    public final CheckoutH5EventContract.Presenter getH5EventPresenter() {
        CheckoutH5EventContract.Presenter presenter = this.h5EventPresenter;
        Object obj = null;
        if ((presenter != null ? 'L' : 'N') != 'L') {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 47;
        PrepareContext = i % 128;
        int i2 = i % 2;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 45;
        PrepareContext = i3 % 128;
        if ((i3 % 2 == 0 ? 'M' : (char) 1) != 'M') {
            return presenter;
        }
        obj.hashCode();
        return presenter;
    }

    @JvmName(name = "setH5EventPresenter")
    public final void setH5EventPresenter(CheckoutH5EventContract.Presenter presenter) {
        try {
            int i = PrepareContext + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.h5EventPresenter = presenter;
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 17;
                PrepareContext = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getPlayStoreReviewPresenter")
    public final PlayStoreReviewContract.Presenter getPlayStoreReviewPresenter() {
        int i = PrepareContext + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        PlayStoreReviewContract.Presenter presenter = this.playStoreReviewPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i3 = PrepareContext + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        try {
            int i5 = PrepareContext + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
            int i6 = i5 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setPlayStoreReviewPresenter")
    public final void setPlayStoreReviewPresenter(PlayStoreReviewContract.Presenter presenter) {
        try {
            int i = PrepareContext + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            Object[] objArr = null;
            if (i % 2 != 0) {
                try {
                    Intrinsics.checkNotNullParameter(presenter, "");
                    this.playStoreReviewPresenter = presenter;
                    objArr.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.playStoreReviewPresenter = presenter;
            }
            int i2 = PrepareContext + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 29 : Typography.dollar) != 29) {
                return;
            }
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x001b, code lost:
    
        if ((r0 != null) != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0028, code lost:
    
        if ((r0 != null ? 1 : 'M') != 1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x002a, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 91;
        id.dana.service.ServicesActivity.PrepareContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003b, code lost:
    
        if ((r0 % 2) != 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x003d, code lost:
    
        r0 = '3';
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0040, code lost:
    
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0042, code lost:
    
        if (r0 == 'Q') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0044, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0047, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x004a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004d, code lost:
    
        r2 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0051, code lost:
    
        id.dana.service.ServicesActivity.PrepareContext = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0055, code lost:
    
        if ((r2 % 2) != 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0059, code lost:
    
        r2 = 62 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x005a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x005d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x005e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005f, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.services.ServicesContract.Presenter getPresenter() {
        /*
            r5 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == 0) goto L20
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.presenter
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1a
            goto L1b
        L1a:
            r2 = 0
        L1b:
            if (r2 == 0) goto L2a
            goto L4b
        L1e:
            r0 = move-exception
            throw r0
        L20:
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.presenter
            if (r0 == 0) goto L26
            r4 = 1
            goto L28
        L26:
            r4 = 77
        L28:
            if (r4 == r2) goto L4b
        L2a:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.PrepareContext = r1
            int r0 = r0 % 2
            r1 = 81
            if (r0 != 0) goto L40
            r0 = 51
            goto L42
        L40:
            r0 = 81
        L42:
            if (r0 == r1) goto L4a
            r3.hashCode()     // Catch: java.lang.Throwable -> L48
            return r3
        L48:
            r0 = move-exception
            throw r0
        L4a:
            return r3
        L4b:
            int r2 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.Exception -> L5e
            int r2 = r2 + 55
            int r3 = r2 % 128
            id.dana.service.ServicesActivity.PrepareContext = r3     // Catch: java.lang.Exception -> L5e
            int r2 = r2 % 2
            if (r2 != 0) goto L5d
            r2 = 62
            int r2 = r2 / r1
            return r0
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            return r0
        L5e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.getPresenter():id.dana.contract.services.ServicesContract$Presenter");
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ServicesContract.Presenter presenter) {
        try {
            int i = PrepareContext + 99;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(presenter, "");
                this.presenter = presenter;
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 19;
                PrepareContext = i3 % 128;
                if ((i3 % 2 == 0 ? '/' : (char) 0) != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0019, code lost:
    
        if ((r0 != null ? 'T' : '@') != 'T') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0029, code lost:
    
        if ((r0 != null ? '3' : '+') != '+') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0031, code lost:
    
        r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 7;
        id.dana.service.ServicesActivity.PrepareContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003b, code lost:
    
        if ((r0 % 2) != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        r0 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0042, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0043, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getReadLinkPropertiesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.PrepareContext = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1e
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r4.readLinkPropertiesPresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L1c
            r2 = 84
            if (r0 == 0) goto L17
            r3 = 84
            goto L19
        L17:
            r3 = 64
        L19:
            if (r3 == r2) goto L2b
            goto L2c
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r4.readLinkPropertiesPresenter
            r2 = 43
            if (r0 == 0) goto L27
            r3 = 51
            goto L29
        L27:
            r3 = 43
        L29:
            if (r3 == r2) goto L2c
        L2b:
            return r0
        L2c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L42
            int r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 7
            int r2 = r0 % 128
            id.dana.service.ServicesActivity.PrepareContext = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L41
            int r0 = r1.length     // Catch: java.lang.Throwable -> L3f
            return r1
        L3f:
            r0 = move-exception
            throw r0
        L41:
            return r1
        L42:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.getReadLinkPropertiesPresenter():id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter");
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = PrepareContext + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
            int i2 = 68 / 0;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 107;
        PrepareContext = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getOnBoardingServicePresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingServicePresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingServicePresenter;
        if (presenter != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 7;
            PrepareContext = i % 128;
            int i2 = i % 2;
            int i3 = PrepareContext + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 47 / 0;
                return presenter;
            }
            return presenter;
        }
        try {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 5;
            PrepareContext = i5 % 128;
            boolean z = i5 % 2 == 0;
            Object obj = null;
            if (z) {
                obj.hashCode();
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setOnBoardingServicePresenter")
    public final void setOnBoardingServicePresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 65;
        PrepareContext = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.onBoardingServicePresenter = presenter;
            Object obj = null;
            obj.hashCode();
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.onBoardingServicePresenter = presenter;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 89;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
    }

    @JvmName(name = "getPayLaterPresenter")
    public final PayLaterContract.Presenter getPayLaterPresenter() {
        try {
            PayLaterContract.Presenter presenter = this.payLaterPresenter;
            Object obj = null;
            if (!(presenter != null)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i = PrepareContext + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            try {
                int i3 = PrepareContext + 23;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                if ((i3 % 2 != 0 ? 'G' : (char) 27) != 27) {
                    obj.hashCode();
                    return presenter;
                }
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setPayLaterPresenter")
    public final void setPayLaterPresenter(PayLaterContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 79;
        PrepareContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.payLaterPresenter = presenter;
        int i3 = PrepareContext + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 20 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0019, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0029, code lost:
    
        if ((r0 != null ? '\r' : 14) != '\r') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0030, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0032, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0033, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0034, code lost:
    
        r1 = id.dana.service.ServicesActivity.PrepareContext + 97;
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        if ((r1 % 2) == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0042, code lost:
    
        r1 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0045, code lost:
    
        r1 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0047, code lost:
    
        if (r1 == 20) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004b, code lost:
    
        r1 = 36 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0050, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getFeaturePresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.path.FeatureContract.Presenter getFeaturePresenter() {
        /*
            r3 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 3
            r2 = 96
            if (r0 == 0) goto L11
            r0 = 3
            goto L13
        L11:
            r0 = 96
        L13:
            if (r0 == r2) goto L1e
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r3.featurePresenter
            int r1 = r1 / 0
            if (r0 == 0) goto L2b
            goto L34
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r3.featurePresenter
            r1 = 13
            if (r0 == 0) goto L27
            r2 = 13
            goto L29
        L27:
            r2 = 14
        L29:
            if (r2 == r1) goto L34
        L2b:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L32
            r0 = 0
            return r0
        L32:
            r0 = move-exception
            throw r0
        L34:
            int r1 = id.dana.service.ServicesActivity.PrepareContext
            int r1 = r1 + 97
            int r2 = r1 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r1 = r1 % 2
            r2 = 20
            if (r1 == 0) goto L45
            r1 = 25
            goto L47
        L45:
            r1 = 20
        L47:
            if (r1 == r2) goto L50
            r1 = 36
            int r1 = r1 / 0
            goto L50
        L4e:
            r0 = move-exception
            throw r0
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.getFeaturePresenter():id.dana.contract.deeplink.path.FeatureContract$Presenter");
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        int i = PrepareContext + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.featurePresenter = presenter;
        int i3 = PrepareContext + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        PrepareContext();
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        isLayoutRequested();
        lookAheadTest();
        getPresenter().BuiltInFictitiousFunctionClassFactory();
        ((Button) _$_findCachedViewById(R.id.btn_try_another_keyword)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServicesActivity.$r8$lambda$G8mAYdI3BcFuFiTDuAGXMDE1oh0(ServicesActivity.this, view);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 125;
        PrepareContext = i % 128;
        int i2 = i % 2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x0037
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.service.ServicesActivity r2) {
        /*
            int r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.PrepareContext = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch: java.lang.Exception -> L35
            int r0 = id.dana.R.id.tsv_service     // Catch: java.lang.Exception -> L35
            android.view.View r2 = r2._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L35
            id.dana.richview.ToolbarSearchView r2 = (id.dana.richview.ToolbarSearchView) r2     // Catch: java.lang.Exception -> L35
            r2.clearSearch()     // Catch: java.lang.Exception -> L35
            int r2 = id.dana.service.ServicesActivity.PrepareContext
            int r2 = r2 + 3
            int r0 = r2 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0
            int r2 = r2 % 2
            r0 = 52
            if (r2 == 0) goto L2b
            r2 = 52
            goto L2d
        L2b:
            r2 = 66
        L2d:
            if (r2 == r0) goto L30
            return
        L30:
            r2 = 0
            int r2 = r2 / r2
            return
        L33:
            r2 = move-exception
            throw r2
        L35:
            r2 = move-exception
            throw r2
        L37:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.service.ServicesActivity):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x001b, code lost:
    
        if ((r0 == null) != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0024, code lost:
    
        if (r0 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0026, code lost:
    
        r4 = id.dana.service.ServicesActivity.PrepareContext + 117;
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r4 % 128;
        r4 = r4 % 2;
        r0 = r0.getExtras();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0034, code lost:
    
        if (r0 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0036, code lost:
    
        r2 = r0.getString(id.dana.service.ServicesActivity.FILTER_SERVICES);
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void isLayoutRequested() {
        /*
            r6 = this;
            int r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.PrepareContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L20
            android.content.Intent r0 = r6.getIntent()
            r2.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1a
            r4 = 0
            goto L1b
        L1a:
            r4 = 1
        L1b:
            if (r4 == r3) goto L3c
            goto L26
        L1e:
            r0 = move-exception
            throw r0
        L20:
            android.content.Intent r0 = r6.getIntent()
            if (r0 == 0) goto L3c
        L26:
            int r4 = id.dana.service.ServicesActivity.PrepareContext
            int r4 = r4 + 117
            int r5 = r4 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r5
            int r4 = r4 % 2
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L3c
            java.lang.String r2 = "FILTER_SERVICES"
            java.lang.String r2 = r0.getString(r2)
        L3c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L5a
            int r0 = r2.length()
            r2 = 38
            if (r0 == 0) goto L4b
            r0 = 91
            goto L4d
        L4b:
            r0 = 38
        L4d:
            if (r0 == r2) goto L5a
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 107
            int r2 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r0 = r0 % 2
            goto L5b
        L5a:
            r1 = 1
        L5b:
            int r0 = id.dana.R.id.tsv_service
            android.view.View r0 = r6._$_findCachedViewById(r0)
            id.dana.richview.ToolbarSearchView r0 = (id.dana.richview.ToolbarSearchView) r0
            r1 = r1 ^ r3
            if (r1 == 0) goto L71
            r1 = 2131956851(0x7f131473, float:1.955027E38)
            java.lang.String r1 = r6.getString(r1)
            r0.setTitle(r1)
            goto L8b
        L71:
            r1 = 2131233653(0x7f080b75, float:1.808345E38)
            r0.setMenuRightButton(r1)
            r1 = 2131951856(0x7f1300f0, float:1.9540138E38)
            java.lang.String r1 = r6.getString(r1)
            r0.setTitle(r1)
            int r1 = id.dana.service.ServicesActivity.PrepareContext
            int r1 = r1 + 35
            int r2 = r1 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r1 = r1 % 2
        L8b:
            r1 = 2131232241(0x7f0805f1, float:1.8080586E38)
            r0.setMenuLeftButton(r1)
            id.dana.service.ServicesActivity$initToolbar$1$1 r1 = new id.dana.service.ServicesActivity$initToolbar$1$1
            r1.<init>(r6)
            id.dana.richview.ToolbarSearchView$Listener r1 = (id.dana.richview.ToolbarSearchView.Listener) r1
            r0.setListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.isLayoutRequested():void");
    }

    private final void PrepareContext() {
        DaggerServiceComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerServiceComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(getErrorConfigVersion());
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        ServicesActivity servicesActivity = this;
        authRequestContext.MyBillsEntityDataFactory = servicesActivity;
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = servicesActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = servicesActivity;
        Object[] objArr = new Object[1];
        a(getPackageName().codePointAt(0) - 97, new char[]{0, 2, 6, 2, 4, 6, 4, 7}, (byte) ((Process.myPid() >> 22) + 97), objArr);
        MyBillsEntityDataFactory.PlaceComponentResult = ((String) objArr[0]).intern();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = servicesActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda3
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                ServicesActivity.$r8$lambda$3haRmtloXlzggOih4VMHeQ1yMiw(ServicesActivity.this, z);
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(servicesActivity)));
        KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp = (ServicesModule) Preconditions.getAuthRequestContext(DatabaseTableConfigUtil());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.service.ServicesActivity$initComponent$2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1, String p2) {
                Uri.Builder buildUpon = Uri.parse(p1).buildUpon();
                if (p0) {
                    buildUpon.appendQueryParameter(SummaryActivity.FIRST_STATE_SHARE_FEED, SummaryActivity.CHECKED);
                    ServicesActivity.access$saveBottomSheetOnboarding(ServicesActivity.this, p2);
                }
                DanaH5.startContainerFullUrlWithSendCredentials$default(buildUpon.build().toString(), ServicesActivity.access$createH5AppListener(ServicesActivity.this), null, null, 12, null);
                ServicesActivity.access$doOnOpenH5(ServicesActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append("on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = (PayLaterModule) Preconditions.getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda2());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, CheckoutH5EventModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp = new ServicesModule();
            int i = PrepareContext + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, PayLaterModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerServiceComponent.ServiceComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getPresenter(), getPlayStoreReviewPresenter(), getH5EventPresenter(), getOnBoardingServicePresenter());
    }

    private static final void PlaceComponentResult(ServicesActivity servicesActivity, boolean z) {
        try {
            int i = PrepareContext + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (i % 2 != 0) {
                Intrinsics.checkNotNullParameter(servicesActivity, "");
                servicesActivity.MyBillsEntityDataFactory = z;
                Object obj = null;
                obj.hashCode();
                return;
            }
            Intrinsics.checkNotNullParameter(servicesActivity, "");
            servicesActivity.MyBillsEntityDataFactory = z;
        } catch (Exception e) {
            throw e;
        }
    }

    private final ServicesModule DatabaseTableConfigUtil() {
        ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.service.ServicesActivity$getServiceModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesActivity.access$setErrorView(ServicesActivity.this, false);
                if (((TextView) ServicesActivity.this._$_findCachedViewById(R.id.tv_search_result)).getVisibility() == 0) {
                    ServicesActivity servicesActivity = ServicesActivity.this;
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : p0) {
                        if (hashSet.add(((ThirdPartyService) obj).NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                            arrayList.add(obj);
                        }
                    }
                    ServicesActivity.access$setupServiceList(servicesActivity, CollectionsKt.toMutableList((Collection) arrayList));
                    return;
                }
                ServicesActivity.access$setupServiceList(ServicesActivity.this, p0);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesActivity.this.getPayLaterPresenter().MyBillsEntityDataFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
                ServicesActivity servicesActivity = ServicesActivity.this;
                String authRequestContext = UrlUtil.getAuthRequestContext(p0.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                ServicesActivity.access$openH5(servicesActivity, p0, authRequestContext, p1, ServicesActivity.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesActivity.this.getPayLaterPresenter().MyBillsEntityDataFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    ServicesActivity servicesActivity = ServicesActivity.this;
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        servicesActivity.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                        return;
                    }
                    String authRequestContext = UrlUtil.getAuthRequestContext(str);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    ServicesActivity.access$openH5(servicesActivity, p0, authRequestContext, null, null);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetFilteredThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesActivity.access$setCategoryViewVisibility(ServicesActivity.this, false);
                if (p0.isEmpty()) {
                    ServicesActivity.access$showEmptyFilteredResult(ServicesActivity.this);
                } else {
                    ServicesActivity.access$setupServiceList(ServicesActivity.this, p0);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onEmptySearchService() {
                ServicesActivity.access$setErrorView(ServicesActivity.this, true);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetInitThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((ServiceCategoryView) ServicesActivity.this._$_findCachedViewById(R.id.scv_categories)).onlyGetIncludedCategories(ServicesActivity.access$getListOfUniqueCategory(ServicesActivity.this, p0));
                if (((TextView) ServicesActivity.this._$_findCachedViewById(R.id.tv_search_result)).getVisibility() == 0) {
                    ServicesActivity servicesActivity = ServicesActivity.this;
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : p0) {
                        if (hashSet.add(((ThirdPartyService) obj).NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                            arrayList.add(obj);
                        }
                    }
                    ServicesActivity.access$setupServiceList(servicesActivity, CollectionsKt.toMutableList((Collection) arrayList));
                    return;
                }
                ServicesActivity.access$setupServiceList(ServicesActivity.this, p0);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onShowTooltip(boolean p0) {
                if (p0) {
                    ServicesActivity servicesActivity = ServicesActivity.this;
                    ServicesActivity.access$showShowcase(servicesActivity, ServicesActivity.access$getTooltipTarget(servicesActivity));
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onMaintenanceAction(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionMiniApp(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str == null) {
                    return;
                }
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "");
                Uri.Builder buildUpon = parse.buildUpon();
                String str2 = p0.MyBillsEntityDataFactory;
                if (str2 != null) {
                    buildUpon.appendQueryParameter("bizType", str2);
                }
                String str3 = p0.getSupportButtonTintMode;
                if (str3 != null) {
                    buildUpon.appendQueryParameter(BranchLinkConstant.MiniAppParams.NEED_OAUTH, str3);
                }
                String str4 = p0.getCallingPid;
                if (str4 != null) {
                    buildUpon.appendQueryParameter("redirectUrl", str4);
                }
                String str5 = p0.VerifyPinStateManager$executeRiskChallenge$2$1;
                if (str5 != null) {
                    buildUpon.appendQueryParameter("scopes", str5);
                }
                String str6 = p0.moveToNextValue;
                if (str6 != null) {
                    buildUpon.appendQueryParameter("clientId", str6);
                }
                String obj = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                if (UrlUtil.getErrorConfigVersion(obj)) {
                    ServicesActivity.this.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(obj);
                    return;
                }
                ServicesActivity servicesActivity = ServicesActivity.this;
                String authRequestContext = UrlUtil.getAuthRequestContext(obj);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                ServicesActivity.access$openH5(servicesActivity, p0, authRequestContext, null, null);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService p0, Map<String, String> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    ServicesActivity.this.getFeaturePresenter().getAuthRequestContext(str, p1);
                }
            }
        });
        try {
            int i = PrepareContext + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (!(i % 2 != 0)) {
                return servicesModule;
            }
            int i2 = 3 / 0;
            return servicesModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private static PayLaterModule NetworkUserEntityData$$ExternalSyntheticLambda2() {
        PayLaterModule payLaterModule = new PayLaterModule(new PayLaterViewListener() { // from class: id.dana.service.ServicesActivity$getPayLaterModule$1
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 33;
            PrepareContext = i % 128;
            if (!(i % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return payLaterModule;
            }
            return payLaterModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final DeepLinkModule getErrorConfigVersion() {
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = this;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = scheduleImpl();
        Object[] objArr = new Object[1];
        a(getPackageName().codePointAt(0) - 97, new char[]{0, 2, 6, 2, 4, 6, 4, 7}, (byte) (97 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), objArr);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = ((String) objArr[0]).intern();
        DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
        int i = PrepareContext + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if (!(i % 2 != 0)) {
            return deepLinkModule;
        }
        int i2 = 25 / 0;
        return deepLinkModule;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.service.ServicesActivity$getDeeplinkCallback$1] */
    private final ServicesActivity$getDeeplinkCallback$1 scheduleImpl() {
        ?? r0 = new DeepLinkCallback() { // from class: id.dana.service.ServicesActivity$getDeeplinkCallback$1
            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayloadModel p0) {
            }

            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void PlaceComponentResult(String p0) {
                if (DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    ServicesActivity.access$showErrorDeeplinkDialog(ServicesActivity.this);
                }
            }
        };
        try {
            int i = PrepareContext + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            return r0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.MyBillsEntityDataFactory = R.drawable.ic_general_error_somethings_wrong;
        builder.moveToNextValue = getString(R.string.deeplink_error_title);
        builder.PlaceComponentResult = getString(R.string.deeplink_error_description);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getString(R.string.deeplink_error_button);
        new DialogWithImage(this, builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
        int i = PrepareContext + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
    }

    private final void getAuthRequestContext(String p0) {
        int i = PrepareContext + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? (char) 27 : (char) 30) != 30) {
            try {
                boolean areEqual = Intrinsics.areEqual(p0, "loan_personal");
                Object[] objArr = null;
                int length = objArr.length;
                if (!areEqual) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            if ((Intrinsics.areEqual(p0, "loan_personal") ? (char) 28 : '\t') != 28) {
                return;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 121;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
        getOnBoardingServicePresenter().MyBillsEntityDataFactory("loan_personal");
    }

    private static List<String> PlaceComponentResult(List<ThirdPartyService> p0) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                Iterator<T> it = p0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        return CollectionsKt.toList(linkedHashSet);
                    }
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 49;
                    PrepareContext = i % 128;
                    int i2 = i % 2;
                    String str = ((ThirdPartyService) it.next()).newProxyInstance;
                    if (!(str == null)) {
                        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 77;
                        PrepareContext = i3 % 128;
                        int i4 = i3 % 2;
                        linkedHashSet.add(str);
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0037, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x003a, code lost:
    
        if (r0 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x003f, code lost:
    
        r0 = r0.getExtras();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0045, code lost:
    
        if (r0 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0047, code lost:
    
        r5 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x004a, code lost:
    
        r5 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x004c, code lost:
    
        if (r5 == 'Q') goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x004f, code lost:
    
        r4 = r0.getString(id.dana.service.ServicesActivity.FILTER_SERVICES, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0055, code lost:
    
        if (r4 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0057, code lost:
    
        r5 = "";
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "");
        r6 = r0.getString("FILTER_BY", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0062, code lost:
    
        if (r6 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0064, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0066, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0067, code lost:
    
        if (r7 == true) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0069, code lost:
    
        r6 = id.dana.service.ServicesActivity.PrepareContext + 13;
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0073, code lost:
    
        if ((r6 % 2) == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0075, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x007b, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x007c, code lost:
    
        r8.getAuthRequestContext = r0.getBoolean(id.dana.service.ServicesActivity.OPEN_SERVICE, false);
        getPresenter().MyBillsEntityDataFactory(r4, r5);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x008e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x008f, code lost:
    
        if (r0 != null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0091, code lost:
    
        getPresenter().getAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0098, code lost:
    
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x009a, code lost:
    
        if (r0 != null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x009c, code lost:
    
        getPresenter().getAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00a3, code lost:
    
        r0 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 105;
        id.dana.service.ServicesActivity.PrepareContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00ad, code lost:
    
        if ((r0 % 2) != 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00b0, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00b1, code lost:
    
        if (r1 == true) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00b3, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00b6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00b9, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00ba, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00bb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0018, code lost:
    
        if (r0 != null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x001b, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0025, code lost:
    
        if (r0 != null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0027, code lost:
    
        r4 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 103;
        id.dana.service.ServicesActivity.PrepareContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0031, code lost:
    
        if ((r4 % 2) != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0033, code lost:
    
        r0 = r0.getExtras();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void lookAheadTest() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.lookAheadTest():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        ServiceAdapter serviceAdapter = new ServiceAdapter();
        serviceAdapter.setOnItemClickListener(initRecordTimeStamp());
        serviceAdapter.getAuthRequestContext = new ServiceAdapter.EditItemBadgeLookup() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda1
            @Override // id.dana.service.adapter.ServiceAdapter.EditItemBadgeLookup
            public final int MyBillsEntityDataFactory(ThirdPartyService thirdPartyService) {
                return ServicesActivity.m2942$r8$lambda$UgH_vBOu2BdBVlvzKj3qY3AQng(ServicesActivity.this, thirdPartyService);
            }
        };
        ServiceAdapter.EditItemBadgeViewHasAttached editItemBadgeViewHasAttached = new ServiceAdapter.EditItemBadgeViewHasAttached() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda2
            @Override // id.dana.service.adapter.ServiceAdapter.EditItemBadgeViewHasAttached
            public final void getAuthRequestContext() {
                ServicesActivity.$r8$lambda$Fo1rd5t2cTyDwphDCjJZJH28noY(ServicesActivity.this);
            }
        };
        serviceAdapter.PlaceComponentResult = true;
        serviceAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = editItemBadgeViewHasAttached;
        this.getErrorConfigVersion = serviceAdapter;
        ServicesActivity servicesActivity = this;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ServiceItemDecorator(servicesActivity, ContextCompat.BuiltInFictitiousFunctionClassFactory(servicesActivity, R.color.f27102131100497));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a0e9d_default_currentthreadtimemillis);
        ServiceItemDecorator serviceItemDecorator = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        ServiceAdapter serviceAdapter2 = null;
        if ((serviceItemDecorator == null ? InputCardNumberView.DIVIDER : '*') == ' ') {
            int i = PrepareContext + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            serviceItemDecorator = null;
        }
        recyclerView.removeItemDecoration(serviceItemDecorator);
        ServiceItemDecorator serviceItemDecorator2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (serviceItemDecorator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            serviceItemDecorator2 = null;
        }
        recyclerView.addItemDecoration(serviceItemDecorator2);
        ServiceAdapter serviceAdapter3 = this.getErrorConfigVersion;
        if (!(serviceAdapter3 != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 7;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
        } else {
            serviceAdapter2 = serviceAdapter3;
        }
        recyclerView.setAdapter(serviceAdapter2);
        recyclerView.setLayoutManager(GetContactSyncConfig());
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0039, code lost:
    
        if ((r5) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0052, code lost:
    
        if ((!r5.containService(r6)) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
    
        r5 = id.dana.service.ServicesActivity.PrepareContext + 101;
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int BuiltInFictitiousFunctionClassFactory(id.dana.service.ServicesActivity r5, id.dana.model.ThirdPartyService r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r1 = id.dana.R.id.edit_service_view
            android.view.View r1 = r5._$_findCachedViewById(r1)
            id.dana.service.favorites.FavoriteServicesView r1 = (id.dana.service.favorites.FavoriteServicesView) r1
            boolean r1 = r1.isItemFull()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L61
            int r1 = id.dana.service.ServicesActivity.PrepareContext
            int r1 = r1 + 63
            int r4 = r1 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L3e
            int r1 = id.dana.R.id.edit_service_view
            android.view.View r5 = r5._$_findCachedViewById(r1)
            id.dana.service.favorites.FavoriteServicesView r5 = (id.dana.service.favorites.FavoriteServicesView) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            boolean r5 = r5.containService(r6)
            r6 = 0
            r6.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r5 != 0) goto L38
            r5 = 0
            goto L39
        L38:
            r5 = 1
        L39:
            if (r5 == 0) goto L54
            goto L61
        L3c:
            r5 = move-exception
            throw r5
        L3e:
            int r1 = id.dana.R.id.edit_service_view     // Catch: java.lang.Exception -> L5f
            android.view.View r5 = r5._$_findCachedViewById(r1)     // Catch: java.lang.Exception -> L5f
            id.dana.service.favorites.FavoriteServicesView r5 = (id.dana.service.favorites.FavoriteServicesView) r5     // Catch: java.lang.Exception -> L5f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch: java.lang.Exception -> L5f
            boolean r5 = r5.containService(r6)     // Catch: java.lang.Exception -> L5f
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            if (r5 == 0) goto L61
        L54:
            int r5 = id.dana.service.ServicesActivity.PrepareContext
            int r5 = r5 + 101
            int r6 = r5 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r6
            int r5 = r5 % 2
            goto L62
        L5f:
            r5 = move-exception
            throw r5
        L61:
            r2 = 0
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.BuiltInFictitiousFunctionClassFactory(id.dana.service.ServicesActivity, id.dana.model.ThirdPartyService):int");
    }

    private static final void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 67;
        PrepareContext = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '1' : '+') != '+') {
            Intrinsics.checkNotNullParameter(servicesActivity, "");
            servicesActivity.getPresenter().BuiltInFictitiousFunctionClassFactory(UserEducationScenarioKt.EDIT_FAVORITE_SERVICE);
            int length = objArr.length;
        } else {
            Intrinsics.checkNotNullParameter(servicesActivity, "");
            servicesActivity.getPresenter().BuiltInFictitiousFunctionClassFactory(UserEducationScenarioKt.EDIT_FAVORITE_SERVICE);
        }
        int i2 = PrepareContext + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        if ((i2 % 2 != 0 ? 'T' : (char) 1) != 'T') {
            return;
        }
        int length2 = objArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmName(name = "moveToNextValue")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.view.View moveToNextValue() {
        /*
            r4 = this;
            int r0 = id.dana.R.id.res_0x7f0a0e9d_default_currentthreadtimemillis
            android.view.View r0 = r4._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r1 = 8
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.findViewHolderForLayoutPosition(r1)
            r1 = 2131365434(0x7f0a0e3a, float:1.8350733E38)
            if (r0 == 0) goto L2d
            android.view.View r0 = r0.itemView
            r2 = 1
            if (r0 == 0) goto L1a
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == r2) goto L1e
            goto L2d
        L1e:
            android.view.View r0 = r0.findViewById(r1)
            int r2 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r2 = r2 + 41
        L26:
            int r3 = r2 % 128
            id.dana.service.ServicesActivity.PrepareContext = r3
            int r2 = r2 % 2
            goto L33
        L2d:
            r0 = 0
            int r2 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r2 = r2 + 47
            goto L26
        L33:
            if (r0 != 0) goto L3e
            android.view.View r0 = r4.findViewById(r1)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.moveToNextValue():android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [id.dana.base.BaseRecyclerViewAdapter] */
    /* JADX WARN: Type inference failed for: r3v3 */
    private final void BuiltInFictitiousFunctionClassFactory(List<ThirdPartyService> p0) {
        ?? r3 = 0;
        r3 = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 39;
            PrepareContext = i % 128;
            if (i % 2 == 0) {
                CollectionsKt.removeAll((List) p0, (Function1) new Function1<ThirdPartyService, Boolean>() { // from class: id.dana.service.ServicesActivity$setupServiceList$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(ThirdPartyService thirdPartyService) {
                        Intrinsics.checkNotNullParameter(thirdPartyService, "");
                        return Boolean.valueOf(thirdPartyService.getNetworkUserEntityData$$ExternalSyntheticLambda7() || thirdPartyService.D == 5);
                    }
                });
                int length = r3.length;
            } else {
                try {
                    CollectionsKt.removeAll((List) p0, (Function1) new Function1<ThirdPartyService, Boolean>() { // from class: id.dana.service.ServicesActivity$setupServiceList$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ThirdPartyService thirdPartyService) {
                            Intrinsics.checkNotNullParameter(thirdPartyService, "");
                            return Boolean.valueOf(thirdPartyService.getNetworkUserEntityData$$ExternalSyntheticLambda7() || thirdPartyService.D == 5);
                        }
                    });
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        if (this.getAuthRequestContext) {
            getPresenter().MyBillsEntityDataFactory(p0.get(0), (Map<String, String>) null);
        }
        getAuthRequestContext(p0);
        ServiceAdapter serviceAdapter = this.getErrorConfigVersion;
        if ((serviceAdapter == null ? 'E' : (char) 5) != 5) {
            int i2 = PrepareContext + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if (i2 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i3 = 98 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
        } else {
            try {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 123;
                PrepareContext = i4 % 128;
                int i5 = i4 % 2;
                r3 = serviceAdapter;
            } catch (Exception e2) {
                throw e2;
            }
        }
        r3.setItems(p0);
        ((ServiceCategoryView) _$_findCachedViewById(R.id.scv_categories)).setListener(new CategoryView.OnClickListener() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda5
            @Override // id.dana.richview.category.CategoryView.OnClickListener
            public final void PlaceComponentResult(CategoryModel categoryModel, boolean z) {
                ServicesActivity.m2943$r8$lambda$miC9TmYeLousklzZZYYnB5axGU(ServicesActivity.this, categoryModel, z);
            }
        });
        int i6 = PrepareContext + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0017, code lost:
    
        if (r0 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0027, code lost:
    
        if ((r3.KClassImpl$Data$declaredNonStaticMembers$2 ? '`' : 23) != 23) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0029, code lost:
    
        r0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        r1 = id.dana.service.ServicesActivity.PrepareContext + 73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0033, code lost:
    
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0038, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0039, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003e, code lost:
    
        return NetworkUserEntityData$$ExternalSyntheticLambda1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "initRecordTimeStamp")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.base.BaseRecyclerViewHolder.OnItemClickListener initRecordTimeStamp() {
        /*
            r3 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext     // Catch: java.lang.Exception -> L3f
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1     // Catch: java.lang.Exception -> L3f
            int r0 = r0 % 2
            if (r0 == 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L1c
            boolean r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3a
            goto L29
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            boolean r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            if (r0 == 0) goto L25
            r0 = 96
            goto L27
        L25:
            r0 = 23
        L27:
            if (r0 == r1) goto L3a
        L29:
            id.dana.base.BaseRecyclerViewHolder$OnItemClickListener r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0()
            int r1 = id.dana.service.ServicesActivity.PrepareContext     // Catch: java.lang.Exception -> L3f
            int r1 = r1 + 73
            int r2 = r1 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2     // Catch: java.lang.Exception -> L38
            int r1 = r1 % 2
            goto L3e
        L38:
            r0 = move-exception
            throw r0
        L3a:
            id.dana.base.BaseRecyclerViewHolder$OnItemClickListener r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1()
        L3e:
            return r0
        L3f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.initRecordTimeStamp():id.dana.base.BaseRecyclerViewHolder$OnItemClickListener");
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda1")
    private final BaseRecyclerViewHolder.OnItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda1() {
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda6
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ServicesActivity.m2941$r8$lambda$OJipHXW2vMzTHy9d_6NQd7L_XY(ServicesActivity.this, i);
            }
        };
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 69;
            PrepareContext = i % 128;
            if ((i % 2 == 0 ? 'H' : ')') != 'H') {
                return onItemClickListener;
            }
            Object obj = null;
            obj.hashCode();
            return onItemClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity, int i) {
        Intrinsics.checkNotNullParameter(servicesActivity, "");
        if (servicesActivity.getAuthRequestContext(i)) {
            return;
        }
        try {
            ((ToolbarSearchView) servicesActivity._$_findCachedViewById(R.id.tsv_service)).hideKeyboard();
            ServiceAdapter serviceAdapter = servicesActivity.getErrorConfigVersion;
            boolean z = true;
            if (!(serviceAdapter != null)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                serviceAdapter = null;
            }
            ThirdPartyService item = serviceAdapter.getItem(i);
            if (item.NetworkUserEntityData$$ExternalSyntheticLambda8.length() > 0) {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 7;
                PrepareContext = i2 % 128;
                int i3 = i2 % 2;
            } else {
                z = false;
            }
            if (z) {
                ServicesTracker.KClassImpl$Data$declaredNonStaticMembers$2(servicesActivity.getApplicationContext(), item.NetworkUserEntityData$$ExternalSyntheticLambda8, item.newProxyInstance, item.NetworkUserEntityData$$ExternalSyntheticLambda6, item.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            ServicesContract.Presenter presenter = servicesActivity.getPresenter();
            Intrinsics.checkNotNullExpressionValue(item, "");
            presenter.MyBillsEntityDataFactory(item, (Map<String, String>) null);
            int i4 = PrepareContext + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
            if ((i4 % 2 != 0 ? '9' : '1') != '9') {
                return;
            }
            int i5 = 58 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    private final BaseRecyclerViewHolder.OnItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda0() {
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.service.ServicesActivity$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ServicesActivity.$r8$lambda$m88_OfNqXPtFF55rkBrUJczR0eQ(ServicesActivity.this, i);
            }
        };
        int i = PrepareContext + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        return onItemClickListener;
    }

    private static final void MyBillsEntityDataFactory(ServicesActivity servicesActivity, int i) {
        Intrinsics.checkNotNullParameter(servicesActivity, "");
        ServiceAdapter serviceAdapter = servicesActivity.getErrorConfigVersion;
        ServiceAdapter serviceAdapter2 = null;
        if (serviceAdapter == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                serviceAdapter = null;
            } catch (Exception e) {
                throw e;
            }
        }
        ThirdPartyService item = serviceAdapter.getItem(i);
        if (!(item != null)) {
            return;
        }
        int i2 = PrepareContext + 49;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        int i3 = i2 % 2;
        if (((FavoriteServicesView) servicesActivity._$_findCachedViewById(R.id.edit_service_view)).replaceEmptyItem(item) ? false : true) {
            return;
        }
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 11;
        PrepareContext = i4 % 128;
        int i5 = i4 % 2;
        ServiceAdapter serviceAdapter3 = servicesActivity.getErrorConfigVersion;
        if (serviceAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            serviceAdapter2 = serviceAdapter3;
        }
        serviceAdapter2.notifyDataSetChanged();
    }

    public final void setEditMode(boolean onEdit) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 79;
        PrepareContext = i % 128;
        if (i % 2 == 0) {
            int i2 = 81 / 0;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == onEdit) {
                return;
            }
        } else {
            try {
                if ((this.KClassImpl$Data$declaredNonStaticMembers$2 != onEdit ? 'W' : InputCardNumberView.DIVIDER) == ' ') {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = PrepareContext + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        int i4 = i3 % 2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onEdit;
        MyBillsEntityDataFactory(onEdit);
    }

    private final boolean getAuthRequestContext(int p0) {
        try {
            ServiceAdapter serviceAdapter = this.getErrorConfigVersion;
            if ((serviceAdapter == null ? '8' : Typography.amp) != '&') {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 67;
                PrepareContext = i % 128;
                int i2 = i % 2;
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    serviceAdapter = null;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (serviceAdapter.getItemViewType(p0) == 4) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 27;
                PrepareContext = i3 % 128;
                setEditMode((i3 % 2 == 0 ? '-' : '\t') != '-' ? !this.KClassImpl$Data$declaredNonStaticMembers$2 : this.KClassImpl$Data$declaredNonStaticMembers$2 & true);
                return true;
            }
            return false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 81;
        PrepareContext = i % 128;
        int i2 = i % 2;
        ServiceAdapter serviceAdapter = this.getErrorConfigVersion;
        ServiceItemDecorator serviceItemDecorator = null;
        if (!(serviceAdapter != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            serviceAdapter = null;
        }
        try {
            serviceAdapter.MyBillsEntityDataFactory(p0);
            ServiceAdapter serviceAdapter2 = this.getErrorConfigVersion;
            if (serviceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                serviceAdapter2 = null;
            }
            serviceAdapter2.setOnItemClickListener(initRecordTimeStamp());
            ((FavoriteServicesView) _$_findCachedViewById(R.id.edit_service_view)).setOnEdit(p0);
            ServiceItemDecorator serviceItemDecorator2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (serviceItemDecorator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                serviceItemDecorator = serviceItemDecorator2;
            }
            serviceItemDecorator.KClassImpl$Data$declaredNonStaticMembers$2 = !p0;
            ((ServiceCategoryView) _$_findCachedViewById(R.id.scv_categories)).hideFavoriteCategory(p0);
            ((ToolbarSearchView) _$_findCachedViewById(R.id.tsv_service)).setSearchIconVisibility(p0 ? 4 : 0);
            if (p0) {
                getDanaApplication().setRefreshService(true);
                ((FavoriteServicesView) _$_findCachedViewById(R.id.edit_service_view)).setFavoriteServiceActionListener(new FavoriteServicesView.FavoriteServiceActionListener() { // from class: id.dana.service.ServicesActivity$onEditModeChanged$1
                    @Override // id.dana.service.favorites.FavoriteServicesView.FavoriteServiceActionListener
                    public final void getAuthRequestContext() {
                        ServicesActivity.this.setEditMode(false);
                        ((ServiceCategoryView) ServicesActivity.this._$_findCachedViewById(R.id.scv_categories)).hideFavoriteCategory(false);
                    }

                    @Override // id.dana.service.favorites.FavoriteServicesView.FavoriteServiceActionListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        ServiceAdapter access$getServiceAdapter$p = ServicesActivity.access$getServiceAdapter$p(ServicesActivity.this);
                        if (access$getServiceAdapter$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            access$getServiceAdapter$p = null;
                        }
                        access$getServiceAdapter$p.notifyDataSetChanged();
                    }
                });
            } else {
                getPresenter().MyBillsEntityDataFactory();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 9;
                PrepareContext = i3 % 128;
                int i4 = i3 % 2;
            }
            if (!((ServiceCategoryView) _$_findCachedViewById(R.id.scv_categories)).isDefaultSelected()) {
                int i5 = PrepareContext + 125;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
                int i6 = i5 % 2;
                ((ServiceCategoryView) _$_findCachedViewById(R.id.scv_categories)).setDefaultSelected(p0);
            }
            ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a0e9d_default_currentthreadtimemillis)).smoothScrollToPosition(0);
        } catch (Exception e) {
            throw e;
        }
    }

    private final GridLayoutManager GetContactSyncConfig() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.service.ServicesActivity$getGridLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public final int PlaceComponentResult(int p0) {
                ServiceAdapter access$getServiceAdapter$p = ServicesActivity.access$getServiceAdapter$p(ServicesActivity.this);
                if (access$getServiceAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getServiceAdapter$p = null;
                }
                int itemViewType = access$getServiceAdapter$p.getItemViewType(p0);
                if (itemViewType == 1 || itemViewType == 3) {
                    return gridLayoutManager.getErrorConfigVersion;
                }
                return 1;
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 91;
        PrepareContext = i % 128;
        if ((i % 2 == 0 ? (char) 30 : '\f') != '\f') {
            Object obj = null;
            obj.hashCode();
            return gridLayoutManager;
        }
        return gridLayoutManager;
    }

    private final String MyBillsEntityDataFactory(String p0) {
        if (!(StringsKt.contains$default((CharSequence) p0, (CharSequence) "entryPoint", false, 2, (Object) null))) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 117;
            PrepareContext = i % 128;
            int i2 = i % 2;
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.save_reminder_btn).substring(2, 3).codePointAt(0) - 100, new char[]{0, 2, 6, 2, 4, 6, 4, 7}, (byte) (97 - Color.blue(0)), objArr);
            String authRequestContext = UrlUtil.getAuthRequestContext(p0, ((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            String correctedUrl = DanaH5.correctedUrl(authRequestContext);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 85;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
            return correctedUrl;
        }
        return p0;
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        try {
            int i = PrepareContext + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if ((i % 2 == 0 ? Typography.less : (char) 2) != '<') {
                String MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
                UserLoanInfo PlaceComponentResult2 = getPayLaterPresenter().PlaceComponentResult(LoanInfo.LOAN_PERSONAL);
                String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, MyBillsEntityDataFactory);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                String KClassImpl$Data$declaredNonStaticMembers$2 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, BuiltInFictitiousFunctionClassFactory);
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                String correctedUrl = DanaH5.correctedUrl(KClassImpl$Data$declaredNonStaticMembers$2);
                Object obj = null;
                obj.hashCode();
                return correctedUrl;
            }
            String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(p0);
            UserLoanInfo PlaceComponentResult3 = getPayLaterPresenter().PlaceComponentResult(LoanInfo.LOAN_PERSONAL);
            String BuiltInFictitiousFunctionClassFactory2 = UrlUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult3, MyBillsEntityDataFactory2);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            String KClassImpl$Data$declaredNonStaticMembers$22 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, BuiltInFictitiousFunctionClassFactory2);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
            return DanaH5.correctedUrl(KClassImpl$Data$declaredNonStaticMembers$22);
        } catch (Exception e) {
            throw e;
        }
    }

    private final void MyBillsEntityDataFactory(ThirdPartyService p0, String p1, String p2, String p3) {
        GContainer.closeAllContainers();
        Object[] objArr = null;
        try {
            if (GContainer.isOpeningH5()) {
                int i = PrepareContext + 109;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
                if ((i % 2 != 0 ? Typography.greater : 'M') != '>') {
                    return;
                }
                objArr.hashCode();
                return;
            }
            String KClassImpl$Data$declaredNonStaticMembers$2 = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(p1, p2, p3, p0);
            Bundle bundle = new Bundle();
            bundle.putString(DanaH5.SERVICE_KEY, p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_akulaku")) {
                bundle.putString("url", KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2));
                bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
                DanaH5.startContainerFullUrlWithSendCredentials$default(null, BuiltInFictitiousFunctionClassFactory(), bundle, null, 9, null);
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda8;
            try {
                switch (str.hashCode()) {
                    case -799331944:
                        if ((str.equals("service_danafood") ? '\\' : (char) 5) == '\\') {
                            getOnBoardingServicePresenter().PlaceComponentResult("dana_food", KClassImpl$Data$declaredNonStaticMembers$2);
                            return;
                        }
                        break;
                    case 994706502:
                        if (!(str.equals("service_danakaget") ? false : true)) {
                            getOnBoardingServicePresenter().PlaceComponentResult("dana_kaget", KClassImpl$Data$declaredNonStaticMembers$2);
                            return;
                        }
                        break;
                    case 1264036702:
                        if (str.equals("service_paylater_loan_personal")) {
                            getOnBoardingServicePresenter().PlaceComponentResult("loan_personal", KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2));
                            return;
                        }
                        break;
                    case 1397883715:
                        if (str.equals("service_my_bills")) {
                            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 37;
                            PrepareContext = i2 % 128;
                            if (i2 % 2 != 0) {
                                getOnBoardingServicePresenter().PlaceComponentResult("my_bills", KClassImpl$Data$declaredNonStaticMembers$2);
                                return;
                            }
                            getOnBoardingServicePresenter().PlaceComponentResult("my_bills", KClassImpl$Data$declaredNonStaticMembers$2);
                            int length = objArr.length;
                            return;
                        }
                        break;
                }
                DanaH5.startContainerFullUrlWithSendCredentials(KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2), BuiltInFictitiousFunctionClassFactory(), bundle, p0.C);
                KClassImpl$Data$declaredNonStaticMembers$2();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final DanaH5Listener BuiltInFictitiousFunctionClassFactory() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.service.ServicesActivity$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                ServicesActivity.this.getH5EventPresenter().BuiltInFictitiousFunctionClassFactory();
                DanaH5.dispose();
                if (ServicesActivity.access$getCheckoutH5EventSuccess$p(ServicesActivity.this)) {
                    ServicesActivity.this.getPlayStoreReviewPresenter().PlaceComponentResult();
                }
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 103;
        PrepareContext = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return danaH5Listener;
        }
        return danaH5Listener;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = PrepareContext + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (!(i % 2 == 0)) {
                this.MyBillsEntityDataFactory = true;
            } else {
                this.MyBillsEntityDataFactory = false;
            }
            getH5EventPresenter().MyBillsEntityDataFactory();
            int i2 = PrepareContext + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if ((i2 % 2 != 0 ? '\\' : '3') != '\\') {
                return;
            }
            int i3 = 15 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void PlaceComponentResult(boolean p0) {
        int i;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 17;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
        ServiceCategoryView serviceCategoryView = (ServiceCategoryView) _$_findCachedViewById(R.id.scv_categories);
        if (!(!p0)) {
            try {
                int i4 = PrepareContext + 51;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
                int i5 = i4 % 2;
                i = 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            i = 8;
        }
        serviceCategoryView.setVisibility(i);
        int i6 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 23;
        PrepareContext = i6 % 128;
        if (!(i6 % 2 != 0)) {
            int i7 = 93 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0024, code lost:
    
        if ((r6) != true) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0033, code lost:
    
        if (r6 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0035, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        r1 = 8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(boolean r6) {
        /*
            r5 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 30
            if (r0 == 0) goto L11
            r0 = 30
            goto L13
        L11:
            r0 = 60
        L13:
            r2 = 8
            r3 = 0
            if (r0 == r1) goto L29
            int r0 = id.dana.R.id.res_0x7f0a1b7b_com_alibaba_ariver_engine_api_extopt_4     // Catch: java.lang.Exception -> L27
            android.view.View r0 = r5._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L27
            r1 = 1
            if (r6 == 0) goto L23
            r4 = 1
            goto L24
        L23:
            r4 = 0
        L24:
            if (r4 == r1) goto L35
            goto L37
        L27:
            r6 = move-exception
            goto L56
        L29:
            int r0 = id.dana.R.id.res_0x7f0a1b7b_com_alibaba_ariver_engine_api_extopt_4     // Catch: java.lang.Exception -> L59
            android.view.View r0 = r5._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L59
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L57
            if (r6 == 0) goto L37
        L35:
            r1 = 0
            goto L39
        L37:
            r1 = 8
        L39:
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L27
            int r0 = id.dana.R.id.res_0x7f0a0e9d_default_currentthreadtimemillis
            android.view.View r0 = r5._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r6 == 0) goto L51
            int r6 = id.dana.service.ServicesActivity.PrepareContext
            int r6 = r6 + 47
            int r1 = r6 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r6 = r6 % 2
            goto L52
        L51:
            r2 = 0
        L52:
            r0.setVisibility(r2)
            return
        L56:
            throw r6
        L57:
            r6 = move-exception
            throw r6
        L59:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.getAuthRequestContext(boolean):void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 83;
        PrepareContext = i % 128;
        int i2 = i % 2;
        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a0e9d_default_currentthreadtimemillis)).setVisibility(8);
        getAuthRequestContext(true);
        ((TextView) _$_findCachedViewById(R.id.tv_search_not_found)).setText(getString(R.string.no_service_available));
        ((Button) _$_findCachedViewById(R.id.btn_try_another_keyword)).setVisibility(8);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 67;
        PrepareContext = i3 % 128;
        if ((i3 % 2 == 0 ? '2' : 'O') != 'O') {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0020, code lost:
    
        if ((r5 ? '3' : 3) != 3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0033, code lost:
    
        if ((!r5) != true) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0036, code lost:
    
        r1 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0038, code lost:
    
        r0.setVisibility(r1);
        r5 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 19;
        id.dana.service.ServicesActivity.PrepareContext = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0047, code lost:
    
        if ((r5 % 2) != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0049, code lost:
    
        r5 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004c, code lost:
    
        r5 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004e, code lost:
    
        if (r5 == 29) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0050, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0056, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(boolean r5) {
        /*
            r4 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext     // Catch: java.lang.Exception -> L57
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1     // Catch: java.lang.Exception -> L57
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L25
            int r0 = id.dana.R.id.tv_search_result
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.hashCode()     // Catch: java.lang.Throwable -> L23
            r3 = 3
            if (r5 == 0) goto L1f
            r5 = 51
            goto L20
        L1f:
            r5 = 3
        L20:
            if (r5 == r3) goto L36
            goto L38
        L23:
            r5 = move-exception
            throw r5
        L25:
            int r0 = id.dana.R.id.tv_search_result
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = 1
            if (r5 == 0) goto L32
            r5 = 0
            goto L33
        L32:
            r5 = 1
        L33:
            if (r5 == r3) goto L36
            goto L38
        L36:
            r1 = 8
        L38:
            r0.setVisibility(r1)
            int r5 = id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r5 = r5 + 19
            int r0 = r5 % 128
            id.dana.service.ServicesActivity.PrepareContext = r0
            int r5 = r5 % 2
            r0 = 29
            if (r5 != 0) goto L4c
            r5 = 10
            goto L4e
        L4c:
            r5 = 29
        L4e:
            if (r5 == r0) goto L56
            r2.hashCode()     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r5 = move-exception
            throw r5
        L56:
            return
        L57:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.BuiltInFictitiousFunctionClassFactory(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0028, code lost:
    
        if ((r0 ? 1 : 18) != 18) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x003c, code lost:
    
        if ((((id.dana.richview.ToolbarSearchView) _$_findCachedViewById(id.dana.R.id.tsv_service)).getSearchStatus()) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003e, code lost:
    
        super.onBackPressed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0041, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0042, code lost:
    
        ((id.dana.richview.ToolbarSearchView) _$_findCachedViewById(id.dana.R.id.tsv_service)).hideSearchView();
        r0 = id.dana.service.ServicesActivity.PrepareContext + 7;
        id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0057, code lost:
    
        return;
     */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onBackPressed() {
        /*
            r3 = this;
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L2d
            int r0 = id.dana.R.id.tsv_service
            android.view.View r0 = r3._$_findCachedViewById(r0)
            id.dana.richview.ToolbarSearchView r0 = (id.dana.richview.ToolbarSearchView) r0
            boolean r0 = r0.getSearchStatus()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L2b
            r1 = 18
            if (r0 == 0) goto L26
            goto L28
        L26:
            r2 = 18
        L28:
            if (r2 == r1) goto L3e
            goto L42
        L2b:
            r0 = move-exception
            throw r0
        L2d:
            int r0 = id.dana.R.id.tsv_service
            android.view.View r0 = r3._$_findCachedViewById(r0)
            id.dana.richview.ToolbarSearchView r0 = (id.dana.richview.ToolbarSearchView) r0
            boolean r0 = r0.getSearchStatus()
            if (r0 == 0) goto L3c
            r1 = 1
        L3c:
            if (r1 == r2) goto L42
        L3e:
            super.onBackPressed()
            return
        L42:
            int r0 = id.dana.R.id.tsv_service
            android.view.View r0 = r3._$_findCachedViewById(r0)
            id.dana.richview.ToolbarSearchView r0 = (id.dana.richview.ToolbarSearchView) r0
            r0.hideSearchView()
            int r0 = id.dana.service.ServicesActivity.PrepareContext
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.service.ServicesActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.onBackPressed():void");
    }

    private final Target BuiltInFictitiousFunctionClassFactory(View view) {
        Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder(this).BuiltInFictitiousFunctionClassFactory(view).BuiltInFictitiousFunctionClassFactory(new CircleShape(getErrorConfigVersion)).getAuthRequestContext(new Content(getString(R.string.text_tooltip_title_favorite_service), getString(R.string.text_tooltip_description_favorite_service))).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        int i = PrepareContext + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "newProxyInstance")
    private final Target newProxyInstance() {
        int i = PrepareContext + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        Target BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(moveToNextValue());
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 119;
        PrepareContext = i3 % 128;
        int i4 = i3 % 2;
        return BuiltInFictitiousFunctionClassFactory;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Target p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 69;
        PrepareContext = i % 128;
        if ((i % 2 == 0 ? (char) 28 : (char) 25) != 25) {
            int i2 = 49 / 0;
            if (this.lookAheadTest != null) {
                return;
            }
        } else if (this.lookAheadTest != null) {
            return;
        }
        SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(this);
        simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
        this.lookAheadTest = simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory("btnGotIt").BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.service.ServicesActivity$showShowcase$1
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public final void onFinished(int p02) {
                ServicesActivity.access$setShowcase$p(ServicesActivity.this, null);
                ServicesActivity.this.getPresenter().PlaceComponentResult(UserEducationScenarioKt.EDIT_FAVORITE_SERVICE);
            }
        }).PlaceComponentResult();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 89;
        PrepareContext = i3 % 128;
        if ((i3 % 2 == 0 ? 'L' : 'V') != 'V') {
            Object obj = null;
            obj.hashCode();
        }
    }

    private static void getAuthRequestContext(List<ThirdPartyService> p0) {
        if ((!p0.isEmpty()) == true) {
            int i = PrepareContext + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (i % 2 == 0) {
                if (p0.get(p0.size() - 1).D != 4) {
                    return;
                }
            } else {
                if (p0.get(p0.size() + 1).D != 4) {
                    return;
                }
            }
            if (p0.get(p0.size() - 2).D == 3) {
                int i2 = PrepareContext + 43;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
                p0.remove(i2 % 2 != 0 ? p0.size() << 2 : p0.size() - 2);
            }
        }
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        PlaceComponentResult();
        PlaceComponentResult = new byte[]{109, -87, 105, -77, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        getAuthRequestContext = 178;
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        getErrorConfigVersion = SizeUtil.getAuthRequestContext(44);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = SizeUtil.getAuthRequestContext(16);
        int i = PrepareContext + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
    }

    private static final void getAuthRequestContext(ServicesActivity servicesActivity, CategoryModel categoryModel, boolean z) {
        String str = "";
        Intrinsics.checkNotNullParameter(servicesActivity, "");
        if ((z ? (char) 23 : (char) 31) == 23) {
            try {
                int i = PrepareContext + 91;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
                int i2 = i % 2;
                categoryModel.MyBillsEntityDataFactory = null;
                if (i2 != 0) {
                    int i3 = 75 / 0;
                }
                try {
                    int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 99;
                    PrepareContext = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ServicesContract.Presenter presenter = servicesActivity.getPresenter();
        String str2 = categoryModel.MyBillsEntityDataFactory;
        if (str2 == null) {
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 9;
            PrepareContext = i6 % 128;
            int i7 = i6 % 2;
            int i8 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 3;
            PrepareContext = i8 % 128;
            int i9 = i8 % 2;
        } else {
            str = str2;
        }
        presenter.getAuthRequestContext(str);
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i3 = $10 + 49;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            while (true) {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i5 = $10 + 31;
                $11 = i5 % 128;
                if (i5 % 2 == 0) {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    i2 = getonboardingscenario.getAuthRequestContext >>> 1;
                } else {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    i2 = getonboardingscenario.getAuthRequestContext + 1;
                }
                getonboardingscenario.getAuthRequestContext = i2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x009e, code lost:
    
        r7 = id.dana.service.ServicesActivity.$11 + 9;
        id.dana.service.ServicesActivity.$10 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00a8, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00bb, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00bc, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00bf, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00d5, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00d7, code lost:
    
        r7 = id.dana.service.ServicesActivity.$11 + 121;
        id.dana.service.ServicesActivity.$10 = r7 % 128;
        r7 = r7 % 2;
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x010f, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0113, code lost:
    
        r7 = id.dana.service.ServicesActivity.$10 + 71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0117, code lost:
    
        id.dana.service.ServicesActivity.$11 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x011b, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0145, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0168, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0169, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x007f, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x009c, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? '=' : 17) != 17) goto L123;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r10, char[] r11, byte r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.service.ServicesActivity.a(int, char[], byte, java.lang.Object[]):void");
    }
}
