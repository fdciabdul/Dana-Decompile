package id.dana.expresspurchase.view;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.ComponentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.navigator.DefaultViewKey;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.SingleBaseActivity;
import id.dana.cancelsurvey.di.CancelSurveyModule;
import id.dana.cancelsurvey.model.BottomSheetCancelReasonModel;
import id.dana.cancelsurvey.model.BottomSheetCancelReasonResultModel;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ExpressPurchaseAnalyticModule;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DialogPermission;
import id.dana.expresspurchase.di.DaggerExpressPurchaseComponent;
import id.dana.expresspurchase.di.ExpressPurchaseModule;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker;
import id.dana.expresspurchase.util.ExpressPurchaseExtKt;
import id.dana.expresspurchase.view.OfferInfoDeals;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DANAToast;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.showcase.Utils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0096\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0096\u0001B\b¢\u0006\u0005\b\u0095\u0001\u0010'J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010'J\u0019\u0010(\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b(\u0010+J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010'J\u000f\u0010-\u001a\u00020\tH\u0014¢\u0006\u0004\b-\u0010'J\u000f\u0010.\u001a\u00020\tH\u0014¢\u0006\u0004\b.\u0010'J\u001f\u00102\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J%\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\tH\u0002¢\u0006\u0004\b9\u0010'J\r\u0010:\u001a\u00020\t¢\u0006\u0004\b:\u0010'J\u0015\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010\u001eJ\r\u0010=\u001a\u00020\t¢\u0006\u0004\b=\u0010'J\u0015\u0010@\u001a\u00020\t2\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\t2\u0006\u0010?\u001a\u00020B¢\u0006\u0004\bC\u0010DJG\u0010J\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00062\b\b\u0002\u0010F\u001a\u00020\u00062\b\b\u0002\u0010G\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010H\u001a\u00020\u00062\b\b\u0002\u0010I\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010KJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010?\u001a\u00020L¢\u0006\u0004\bM\u0010NR\u001e\u0010\n\u001a\f\u0012\b\u0012\u0006*\u00020P0P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010[\u001a\u00020Z8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0013\u0010j\u001a\u00020\u0010X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bh\u0010iR\u0013\u0010l\u001a\u00020\u0013X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bk\u0010iR\u0013\u0010n\u001a\u00020\u0016X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bm\u0010iR\"\u0010p\u001a\u00020o8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010h\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0013\u0010}\u001a\u00020{X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b|\u0010iR\u0013\u0010Q\u001a\u00020~X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u007f\u0010iR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\"\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b*\u00030\u0082\u00010\u0082\u00010O8\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010RR \u0010\u008a\u0001\u001a\u00030\u0085\u00018\u0007X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010v\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseActivity;", "Lid/dana/base/SingleBaseActivity;", "Lid/dana/expresspurchase/view/ExpressPurchaseNavigationManager;", "Lid/dana/expresspurchase/view/ExpressPurchaseGold;", "Lid/dana/expresspurchase/view/ExpressPurchaseInsurance;", "Lid/dana/expresspurchase/view/ExpressPurchaseDeals;", "", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/zhuinden/simplestack/Backstack;", "backstack", "createNavigationManager", "(Lcom/zhuinden/simplestack/Backstack;)Lid/dana/expresspurchase/view/ExpressPurchaseNavigationManager;", "Lid/dana/expresspurchase/view/ExpressPurchaseDealsViewExtender;", "expressPurchaseDealsExtender", "()Lid/dana/expresspurchase/view/ExpressPurchaseDealsViewExtender;", "Lid/dana/expresspurchase/view/ExpressPurchaseGoldViewExtender;", "expressPurchaseGoldExtender", "()Lid/dana/expresspurchase/view/ExpressPurchaseGoldViewExtender;", "Lid/dana/expresspurchase/view/ExpressPurchaseInsuranceViewExtender;", "expressPurchaseInsuranceExtender", "()Lid/dana/expresspurchase/view/ExpressPurchaseInsuranceViewExtender;", "", "getContainerId", "()I", "goodsId", "getDealsShopLocation", "(Ljava/lang/String;)V", "Lcom/zhuinden/simplestack/navigator/DefaultViewKey;", "getInitialLayoutView", "()Lcom/zhuinden/simplestack/navigator/DefaultViewKey;", "getLayout", "bizOrderId", "getTransactionDetailContentUrl", "(Ljava/lang/String;)Ljava/lang/String;", "handleConsultCancelSurveyExpressPurchase", "()V", IAPSyncCommand.COMMAND_INIT, "Landroid/os/Bundle;", "savedInstanceState", "(Landroid/os/Bundle;)V", "onBackPressed", "onPause", "onStart", "url", "", "isCloseAfterOpenContainer", LogConstants.Mpm.EndNodeType.OPEN_URL, "(Ljava/lang/String;Z)V", "addonId", "action", "type", "saveDismissAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "startEpTimer", "merchantName", "trackExpressDealsPurchase", "trackExpressPurchaseConfirmationDeals", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "expressPurchaseModel", "trackExpressPurchaseOpen", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;", "trackExpressPurchasePaylaterActivation", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;)V", "status", "pendingReason", "failedReason", "productCode", "source", "trackExpressPurchaseResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "validateGoldPrice", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Lid/dana/cancelsurvey/model/BottomSheetCancelReasonModel;", "lookAheadTest", "Landroidx/activity/result/ActivityResultLauncher;", "Lid/dana/cancelsurvey/presenter/CancelSurveyContract$Presenter;", "cancelSurveyPresenter", "Lid/dana/cancelsurvey/presenter/CancelSurveyContract$Presenter;", "getCancelSurveyPresenter", "()Lid/dana/cancelsurvey/presenter/CancelSurveyContract$Presenter;", "setCancelSurveyPresenter", "(Lid/dana/cancelsurvey/presenter/CancelSurveyContract$Presenter;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;", "expressPurchaseAnalyticTracker", "Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;", "getExpressPurchaseAnalyticTracker", "()Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;", "setExpressPurchaseAnalyticTracker", "(Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;)V", "getErrorConfigVersion", "Lkotlin/Lazy;", "getAuthRequestContext", "DatabaseTableConfigUtil", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda2", "MyBillsEntityDataFactory", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "expressPurchasePresenter", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "getExpressPurchasePresenter", "()Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "setExpressPurchasePresenter", "(Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;)V", "GetContactSyncConfig", "Ljava/lang/String;", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lio/reactivex/disposables/Disposable;", "Lid/dana/expresspurchase/view/OfferProductScreen;", "initRecordTimeStamp", "moveToNextValue", "Lid/dana/expresspurchase/view/ExpressPurchaseLoadingScreen;", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/activity/result/IntentSenderRequest;", "isLayoutRequested", "scheduleImpl", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "newProxyInstance", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getPermissionRequest", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "permissionRequest", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/dialog/DialogPermission;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/dialog/DialogPermission;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchaseActivity extends SingleBaseActivity<ExpressPurchaseNavigationManager> implements ExpressPurchaseGold, ExpressPurchaseInsurance, ExpressPurchaseDeals {
    public static final String BIZ_ORDER_ID = "BIZ_ORDER_ID";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DEALS_EVENT_SOURCE = "Deals";
    public static final String EP_ACTION_PURCHASE = "Purchase";
    public static final String EXPRESS_PURCHASE_PAYLOAD = "EXPRESS_PURCHASE_PAYLOAD";
    private static char[] FragmentBottomSheetPaymentSettingBinding = null;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda6 = 0;
    public static final String OPEN_RESULT_PAGE = "OPEN_RESULT_PAGE";
    public static final String PARAM_BIZ_ORDER_ID = "bizOrderId";
    public static final String PARAM_IS_CLOSABLE = "isClosable";
    public static final String QUICK_BUY_RESULT = "QUICK_BUY_RESULT";
    public static final int REQUEST_CODE = 1;
    public static final String STOP_LOADING = "STOP_LOADING";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Disposable getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private DialogPermission GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public CancelSurveyContract.Presenter cancelSurveyPresenter;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public ExpressPurchaseAnalyticTracker expressPurchaseAnalyticTracker;
    @Inject
    public ExpressPurchaseContract.Presenter expressPurchasePresenter;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final ActivityResultLauncher<IntentSenderRequest> scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ActivityResultLauncher<BottomSheetCancelReasonModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final ActivityPermissionRequest permissionRequest;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    public static final byte[] $$g = {45, -61, Ascii.ETB, 105, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 76;
    public static final byte[] scheduleImpl = {59, -103, 22, 57, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 181;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<OfferProductScreen>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$initialViewKey$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OfferProductScreen invoke() {
            return new OfferProductScreen(R.layout.view_express_purchase_offer, ExpressPurchaseActivity.this.getIntent().getExtras());
        }
    });

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<ExpressPurchaseLoadingScreen>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$loadingViewKey$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressPurchaseLoadingScreen invoke() {
            return new ExpressPurchaseLoadingScreen(R.layout.view_express_purchase_loading, null);
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<ExpressPurchaseGoldViewExtender>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseGoldViewExtender$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressPurchaseGoldViewExtender invoke() {
            ExpressPurchaseActivity expressPurchaseActivity = ExpressPurchaseActivity.this;
            return new ExpressPurchaseGoldViewExtender(expressPurchaseActivity, expressPurchaseActivity.getExpressPurchasePresenter());
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ExpressPurchaseInsuranceViewExtender>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseInsuranceViewExtender$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressPurchaseInsuranceViewExtender invoke() {
            return new ExpressPurchaseInsuranceViewExtender(ExpressPurchaseActivity.this.getExpressPurchasePresenter());
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ExpressPurchaseDealsViewExtender>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseDealsViewExtender$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressPurchaseDealsViewExtender invoke() {
            return new ExpressPurchaseDealsViewExtender(ExpressPurchaseActivity.this.getExpressPurchasePresenter());
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        FragmentBottomSheetPaymentSettingBinding = new char[]{39832, 39821, 39831, 39817, 39818, 39824, 39757, 39819, 39864, 39830, 39815, 39813, 39808, 39847, 39827, 39828, 39812, 39823, 39814, 39851, 39820, 39844, 39746, 39749, 39747, 39755, 39744, 39829, 39753, 39752, 39750, 39751, 39833, 39748, 39745, 39754, 39826, 39816};
        NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = 909155195;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0022 -> B:23:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 23 - r6
            int r7 = 56 - r7
            int r8 = r8 + 97
            byte[] r0 = id.dana.expresspurchase.view.ExpressPurchaseActivity.scheduleImpl
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2a
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2a:
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + (-4)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.expresspurchase.view.ExpressPurchaseActivity.h(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.expresspurchase.view.ExpressPurchaseActivity.$$g
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r8 = 46 - r8
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.expresspurchase.view.ExpressPurchaseActivity.j(int, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.SingleBaseActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.SingleBaseActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(null, 127 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(null, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(null, 128 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(null, 127 - View.resolveSize(0, 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(null, Color.blue(0) + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(null, 127 - TextUtils.getOffsetAfter("", 0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(null, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.indexOf("", "") + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                h((byte) (-scheduleImpl[30]), scheduleImpl[31], scheduleImpl[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-scheduleImpl[30]);
                byte b2 = (byte) (scheduleImpl[34] + 1);
                Object[] objArr14 = new Object[1];
                h(b, b2, (byte) (b2 & 40), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 54, 2 - ExpandableListView.getPackedPositionChild(0L), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        byte b3 = $$g[78];
                        Object[] objArr16 = new Object[1];
                        j(b3, b3, $$g[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (Process.myPid() >> 22) + 15, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), ExpandableListView.getPackedPositionGroup(0L) + 15, (char) (MotionEvent.axisFromString("") + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0', 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 29, (char) (ExpandableListView.getPackedPositionChild(0L) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 15 - View.resolveSizeAndState(0, 0, 0), (char) ExpandableListView.getPackedPositionType(0L)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-126059553, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - TextUtils.getTrimmedLength(""), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                h((byte) (-scheduleImpl[30]), scheduleImpl[31], scheduleImpl[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = (byte) (-scheduleImpl[30]);
                byte b5 = (byte) (scheduleImpl[34] + 1);
                Object[] objArr20 = new Object[1];
                h(b4, b5, (byte) (b5 & 40), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 61, 46 - ExpandableListView.getPackedPositionType(0L), (char) Color.green(0));
                        Object[] objArr22 = new Object[1];
                        j($$g[9], (byte) ($$g[78] - 1), $$g[84], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Gravity.getAbsoluteGravity(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-126059553, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                h((byte) (-scheduleImpl[30]), scheduleImpl[31], scheduleImpl[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = (byte) (-scheduleImpl[30]);
                byte b7 = (byte) (scheduleImpl[34] + 1);
                Object[] objArr26 = new Object[1];
                h(b6, b7, (byte) (b7 & 40), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 118, 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (38968 - TextUtils.indexOf("", "", 0, 0)));
                        Object[] objArr28 = new Object[1];
                        j($$g[9], (byte) ($$g[78] - 1), $$g[84], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-126059553, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), 17 - Process.getGidForName(""), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                h((byte) (-scheduleImpl[30]), scheduleImpl[31], scheduleImpl[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = (byte) (-scheduleImpl[30]);
                byte b9 = (byte) (scheduleImpl[34] + 1);
                Object[] objArr32 = new Object[1];
                h(b8, b9, (byte) (b9 & 40), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 107, MotionEvent.axisFromString("") + 4, (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$g[78] - 1), $$g[8], (byte) ($$g[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - TextUtils.indexOf("", ""), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-126059553, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.SingleBaseActivity
    public final int getContainerId() {
        return R.id.container;
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_express_purchase;
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        g(null, 127 - View.MeasureSpec.getMode(0), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        g(null, 127 - (ViewConfiguration.getWindowTouchSlop() >> 8), new byte[]{-125, -122, -106, -115, -107}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                g(null, super.getResources().getString(R.string.express_pay_desc).substring(4, 5).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                g(null, super.getResources().getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_title).substring(0, 1).length() + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, View.getDefaultSize(0, 0) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    g(null, 127 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    g(null, super.getResources().getString(R.string.mybills_detail_label_kk_va_number).substring(5, 6).length() + 126, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    g(null, 127 - View.resolveSizeAndState(0, 0, 0), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(null, super.getResources().getString(R.string.help_button).substring(0, 11).length() + 116, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(null, 127 - TextUtils.indexOf("", "", 0, 0), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr9);
                    try {
                        Object[] objArr10 = {baseContext, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        try {
            Object[] objArr11 = new Object[1];
            h((byte) (-scheduleImpl[30]), scheduleImpl[31], scheduleImpl[32], objArr11);
            Class<?> cls3 = Class.forName((String) objArr11[0]);
            byte b = (byte) (-scheduleImpl[30]);
            byte b2 = (byte) (scheduleImpl[34] + 1);
            Object[] objArr12 = new Object[1];
            h(b, b2, (byte) (b2 & 40), objArr12);
            try {
                Object[] objArr13 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr12[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (KeyEvent.getMaxKeyCode() >> 16), TextUtils.lastIndexOf("", '0', 0) + 5, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    Object[] objArr14 = new Object[1];
                    j((byte) ($$g[78] - 1), $$g[8], (byte) ($$g[78] - 1), objArr14);
                    obj3 = cls4.getMethod((String) objArr14[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr15 = (Object[]) ((Method) obj3).invoke(null, objArr13);
                int i = ((int[]) objArr15[1])[0];
                if (((int[]) objArr15[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), Color.rgb(0, 0, 0) + 16777251, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr16 = {-721598652, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 18 - TextUtils.indexOf("", "", 0), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr16);
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
                }
                super.onCreate(bundle);
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 == null) {
                    throw th5;
                }
                throw cause5;
            }
        } catch (Throwable th6) {
            Throwable cause6 = th6.getCause();
            if (cause6 == null) {
                throw th6;
            }
            throw cause6;
        }
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(null, super.getResources().getString(R.string.bottom_on_boarding_body_text_request_money_fourth).substring(14, 15).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(null, (KeyEvent.getMaxKeyCode() >> 16) + 127, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onResume();
    }

    public ExpressPurchaseActivity() {
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExpressPurchaseActivity.m2585$r8$lambda$pzfF7YOLFiUJVA9Y7BNi1k2TY(ExpressPurchaseActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.scheduleImpl = registerForActivityResult;
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$permissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    ExpressPurchaseActivity expressPurchaseActivity = ExpressPurchaseActivity.this;
                    str = expressPurchaseActivity.PlaceComponentResult;
                    expressPurchaseActivity.getDealsShopLocation(str);
                    return;
                }
                ExpressPurchaseActivity expressPurchaseActivity2 = ExpressPurchaseActivity.this;
                EventBus.getDefault().post(new OfferInfoDeals.DealsShopLocationFailedEvent());
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.permissionRequest = builder.PlaceComponentResult();
        ActivityResultLauncher<BottomSheetCancelReasonModel> registerForActivityResult2 = registerForActivityResult(new BottomSheetCancelSurveyActivity.BottomSheetCancelSurveyActivityContract(), new ActivityResultCallback() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$$ExternalSyntheticLambda4
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExpressPurchaseActivity.$r8$lambda$h18FbAdhxH51t6EXa8Qi_kgd6r4(ExpressPurchaseActivity.this, (BottomSheetCancelReasonResultModel) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = registerForActivityResult2;
    }

    @JvmName(name = "getExpressPurchasePresenter")
    public final ExpressPurchaseContract.Presenter getExpressPurchasePresenter() {
        ExpressPurchaseContract.Presenter presenter = this.expressPurchasePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setExpressPurchasePresenter")
    public final void setExpressPurchasePresenter(ExpressPurchaseContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.expressPurchasePresenter = presenter;
    }

    @JvmName(name = "getCancelSurveyPresenter")
    public final CancelSurveyContract.Presenter getCancelSurveyPresenter() {
        CancelSurveyContract.Presenter presenter = this.cancelSurveyPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCancelSurveyPresenter")
    public final void setCancelSurveyPresenter(CancelSurveyContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.cancelSurveyPresenter = presenter;
    }

    @JvmName(name = "getReadDeepLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadDeepLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readDeepLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadDeepLinkPropertiesPresenter")
    public final void setReadDeepLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readDeepLinkPropertiesPresenter = presenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @JvmName(name = "getExpressPurchaseAnalyticTracker")
    public final ExpressPurchaseAnalyticTracker getExpressPurchaseAnalyticTracker() {
        ExpressPurchaseAnalyticTracker expressPurchaseAnalyticTracker = this.expressPurchaseAnalyticTracker;
        if (expressPurchaseAnalyticTracker != null) {
            return expressPurchaseAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setExpressPurchaseAnalyticTracker")
    public final void setExpressPurchaseAnalyticTracker(ExpressPurchaseAnalyticTracker expressPurchaseAnalyticTracker) {
        Intrinsics.checkNotNullParameter(expressPurchaseAnalyticTracker, "");
        this.expressPurchaseAnalyticTracker = expressPurchaseAnalyticTracker;
    }

    @JvmName(name = "getPermissionRequest")
    public final ActivityPermissionRequest getPermissionRequest() {
        return this.permissionRequest;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(null, TextUtils.indexOf("", "", 0) + 127, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = scheduleImpl[25];
                Object[] objArr2 = new Object[1];
                h(b, (byte) (b | TarHeader.LF_BLK), scheduleImpl[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                h(scheduleImpl[27], scheduleImpl[25], (byte) (-scheduleImpl[5]), objArr3);
                Object[] objArr4 = new Object[1];
                g(null, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    @Override // id.dana.base.SingleBaseActivity
    public final ExpressPurchaseNavigationManager createNavigationManager(Backstack backstack) {
        Intrinsics.checkNotNullParameter(backstack, "");
        return new ExpressPurchaseNavigationManager(this, backstack);
    }

    @Override // id.dana.base.SingleBaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Object pVar = getNavigationManager().getAuthRequestContext.top();
        Intrinsics.checkNotNullExpressionValue(pVar, "");
        if (Intrinsics.areEqual((DefaultViewKey) pVar, (OfferProductScreen) this.moveToNextValue.getValue())) {
            handleConsultCancelSurveyExpressPurchase();
            return;
        }
        Object pVar2 = getNavigationManager().getAuthRequestContext.top();
        Intrinsics.checkNotNullExpressionValue(pVar2, "");
        if (Intrinsics.areEqual((DefaultViewKey) pVar2, (ExpressPurchaseLoadingScreen) this.lookAheadTest.getValue())) {
            return;
        }
        super.onBackPressed();
    }

    public final void trackExpressPurchaseOpen(ExpressPurchaseModel expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        getExpressPurchaseAnalyticTracker().getAuthRequestContext(expressPurchaseModel);
    }

    public final void trackExpressDealsPurchase(String merchantName) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        getExpressPurchaseAnalyticTracker().MyBillsEntityDataFactory(merchantName);
    }

    public final void trackExpressPurchaseConfirmationDeals() {
        getExpressPurchaseAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(false, false, Boolean.TRUE);
    }

    public final void trackExpressPurchaseResult(String status, String pendingReason, String failedReason, ExpressPurchaseModel expressPurchaseModel, String productCode, String source) {
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(pendingReason, "");
        Intrinsics.checkNotNullParameter(failedReason, "");
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(source, "");
        getExpressPurchaseAnalyticTracker().MyBillsEntityDataFactory(status, pendingReason, failedReason, expressPurchaseModel, productCode, source);
    }

    public final void trackExpressPurchasePaylaterActivation(ExpressPurchaseModel.Paylater expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        getExpressPurchaseAnalyticTracker().PlaceComponentResult(expressPurchaseModel);
    }

    public final void startEpTimer() {
        getExpressPurchaseAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        if ((!StringsKt.isBlank(p0)) == true && (!StringsKt.isBlank(p1)) == true) {
            getCancelSurveyPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
            Unit unit = Unit.INSTANCE;
            super.onBackPressed();
        }
    }

    public final void saveDismissAction(String addonId, String action, String type) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(action, "");
        Intrinsics.checkNotNullParameter(type, "");
        getExpressPurchasePresenter().getAuthRequestContext(addonId, action, type);
    }

    public final void validateGoldPrice(ExpressPurchaseModel.Gold expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        getExpressPurchasePresenter().getAuthRequestContext(expressPurchaseModel);
    }

    public static /* synthetic */ void openUrl$default(ExpressPurchaseActivity expressPurchaseActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        expressPurchaseActivity.openUrl(str, z);
    }

    public final void openUrl(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        if (UrlUtil.getErrorConfigVersion(str)) {
            getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
            if (z) {
                finish();
                return;
            }
            return;
        }
        getNavigationManager().getAuthRequestContext(str, z);
    }

    public final String getTransactionDetailContentUrl(String bizOrderId) {
        String PlaceComponentResult;
        String PlaceComponentResult2;
        String trxDetailUrl = getDynamicUrlWrapper().getTrxDetailUrl();
        Intrinsics.checkNotNullExpressionValue(trxDetailUrl, "");
        if (StringsKt.contains$default((CharSequence) trxDetailUrl, (CharSequence) "bizOrderId", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(trxDetailUrl, "");
            StringBuilder sb = new StringBuilder();
            sb.append("bizOrderId=");
            sb.append(bizOrderId);
            PlaceComponentResult = StringsKt.replace$default(trxDetailUrl, "bizOrderId=%s", sb.toString(), false, 4, (Object) null);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bizOrderId=");
            sb2.append(bizOrderId);
            PlaceComponentResult = UrlUtil.PlaceComponentResult(trxDetailUrl, sb2.toString());
        }
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        String str = PlaceComponentResult;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) PARAM_IS_CLOSABLE, false, 2, (Object) null)) {
            Regex regex = new Regex("isClosable=false|isClosable=%s|isClosable=true");
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            PlaceComponentResult2 = regex.replace(str, "isClosable=true");
        } else {
            PlaceComponentResult2 = UrlUtil.PlaceComponentResult(PlaceComponentResult, "isClosable=true");
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(PlaceComponentResult2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void getDealsShopLocation(final String goodsId) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        this.PlaceComponentResult = goodsId;
        ExpressPurchaseActivity expressPurchaseActivity = this;
        if (LocationUtil.BuiltInFictitiousFunctionClassFactory(expressPurchaseActivity)) {
            if (LocationUtil.getAuthRequestContext(expressPurchaseActivity)) {
                Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ExpressPurchaseActivity.$r8$lambda$cUbOkiKkHHsRpbCq0Mx4QzBA4I8(ExpressPurchaseActivity.this, goodsId, (Location) obj);
                    }
                });
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscribe;
                addDisposable(subscribe);
                return;
            }
            EventBus.getDefault().post(new OfferInfoDeals.DealsShopLocationFailedEvent());
            LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication());
            locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
            this.getErrorConfigVersion = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ExpressPurchaseActivity.m2584$r8$lambda$flrcQrmyanbABBcA1Ll25QJ7U(ExpressPurchaseActivity.this, (LocationSettingsResult) obj);
                }
            });
            return;
        }
        EventBus.getDefault().post(new OfferInfoDeals.DealsShopLocationFailedEvent());
    }

    private final void PlaceComponentResult() {
        if (this.GetContactSyncConfig == null) {
            DialogPermission.Builder builder = new DialogPermission.Builder(this, new DialogInterface.OnDismissListener() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ExpressPurchaseActivity.m2583$r8$lambda$TLjtCFUUkLrQyVITxxjfDIu21I(ExpressPurchaseActivity.this, dialogInterface);
                }
            });
            builder.scheduleImpl = R.drawable.ic_location_graphic;
            builder.lookAheadTest = getString(R.string.msg_location_dialog_desc);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = getString(R.string.msg_check_permission);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$showSettingLocationPermission$2
                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onDialogDismissed() {
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onPositiveButtonClicked() {
                    Utils.PlaceComponentResult(ExpressPurchaseActivity.this);
                    ExpressPurchaseActivity.access$dismissSettingLocationPermission(ExpressPurchaseActivity.this);
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onNegativeButtonClicked() {
                    ExpressPurchaseActivity.access$dismissSettingLocationPermission(ExpressPurchaseActivity.this);
                }
            };
            this.GetContactSyncConfig = new DialogPermission(builder.BuiltInFictitiousFunctionClassFactory, builder.moveToNextValue, builder, (byte) 0);
        }
        DialogPermission dialogPermission = this.GetContactSyncConfig;
        if (dialogPermission != null) {
            dialogPermission.MyBillsEntityDataFactory();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000b"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "p1", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/base/BaseActivity;Lid/dana/expresspurchase/model/ExpressPurchaseModel;)Landroid/content/Intent;", "", ExpressPurchaseActivity.BIZ_ORDER_ID, "Ljava/lang/String;", "DEALS_EVENT_SOURCE", "EP_ACTION_PURCHASE", ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, ExpressPurchaseActivity.OPEN_RESULT_PAGE, "PARAM_BIZ_ORDER_ID", "PARAM_IS_CLOSABLE", ExpressPurchaseActivity.QUICK_BUY_RESULT, "", "REQUEST_CODE", "I", ExpressPurchaseActivity.STOP_LOADING, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent KClassImpl$Data$declaredNonStaticMembers$2(BaseActivity p0, ExpressPurchaseModel p1) {
            Intent putExtra;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intentClassWithTracking = p0.getIntentClassWithTracking(ExpressPurchaseActivity.class);
            Intrinsics.checkNotNullExpressionValue(intentClassWithTracking, "");
            ExpressPurchaseExtKt.MyBillsEntityDataFactory(intentClassWithTracking, p1);
            if (p1 instanceof ExpressPurchaseModel.Gold) {
                putExtra = intentClassWithTracking.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, p1);
            } else if (p1 instanceof ExpressPurchaseModel.Insurance) {
                putExtra = intentClassWithTracking.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, p1);
            } else if (p1 instanceof ExpressPurchaseModel.Paylater) {
                putExtra = intentClassWithTracking.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, p1);
            } else if (p1 instanceof ExpressPurchaseModel.Deals) {
                putExtra = intentClassWithTracking.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, p1);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }
    }

    /* renamed from: $r8$lambda$TLjtCFUUkLrQyVITxxjfDI-u21I */
    public static /* synthetic */ void m2583$r8$lambda$TLjtCFUUkLrQyVITxxjfDIu21I(ExpressPurchaseActivity expressPurchaseActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(expressPurchaseActivity, "");
        expressPurchaseActivity.GetContactSyncConfig = null;
    }

    public static /* synthetic */ void $r8$lambda$cUbOkiKkHHsRpbCq0Mx4QzBA4I8(ExpressPurchaseActivity expressPurchaseActivity, String str, Location location) {
        Intrinsics.checkNotNullParameter(expressPurchaseActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        expressPurchaseActivity.getExpressPurchasePresenter().KClassImpl$Data$declaredNonStaticMembers$2(str, String.valueOf(location != null ? Double.valueOf(location.getLatitude()) : null), String.valueOf(location != null ? Double.valueOf(location.getLongitude()) : null));
        Disposable disposable = expressPurchaseActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
        }
        expressPurchaseActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    }

    /* renamed from: $r8$lambda$flrcQr-myanbABBcA-1Ll25QJ7U */
    public static /* synthetic */ void m2584$r8$lambda$flrcQrmyanbABBcA1Ll25QJ7U(ExpressPurchaseActivity expressPurchaseActivity, LocationSettingsResult locationSettingsResult) {
        Unit unit;
        int statusCode = locationSettingsResult.getStatus().getStatusCode();
        if (statusCode == 6) {
            PendingIntent resolution = locationSettingsResult.getStatus().getResolution();
            if (resolution != null) {
                ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = expressPurchaseActivity.scheduleImpl;
                IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(resolution.getIntentSender());
                activityResultLauncher.MyBillsEntityDataFactory(new IntentSenderRequest(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2), null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                expressPurchaseActivity.PlaceComponentResult();
            }
        } else if (statusCode != 8502) {
            expressPurchaseActivity.PlaceComponentResult();
        }
        Disposable disposable = expressPurchaseActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
        }
        expressPurchaseActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    }

    public static /* synthetic */ void $r8$lambda$h18FbAdhxH51t6EXa8Qi_kgd6r4(ExpressPurchaseActivity expressPurchaseActivity, BottomSheetCancelReasonResultModel bottomSheetCancelReasonResultModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseActivity, "");
        if (bottomSheetCancelReasonResultModel.PlaceComponentResult()) {
            Bundle extras = expressPurchaseActivity.getIntent().getExtras();
            ExpressPurchaseModel expressPurchaseModel = extras != null ? (ExpressPurchaseModel) extras.getParcelable(EXPRESS_PURCHASE_PAYLOAD) : null;
            if (expressPurchaseModel != null) {
                Intrinsics.checkNotNullExpressionValue(bottomSheetCancelReasonResultModel, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(expressPurchaseActivity);
                builder.MyBillsEntityDataFactory = TrackerKey.Event.CANCEL_SURVEY_EXPRESS_PURCHASE;
                builder.MyBillsEntityDataFactory("Merchant Name", expressPurchaseModel.getAuthRequestContext.MyBillsEntityDataFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BUSINESS_TYPE_ID, expressPurchaseModel.getAuthRequestContext.PlaceComponentResult);
                builder.MyBillsEntityDataFactory(TrackerKey.CancelSurveyProperties.CANCEL_REASON, bottomSheetCancelReasonResultModel.PlaceComponentResult);
                if (expressPurchaseModel instanceof ExpressPurchaseModel.Gold) {
                    ExpressPurchaseModel.Gold gold = (ExpressPurchaseModel.Gold) expressPurchaseModel;
                    String obj = gold.GetContactSyncConfig.toString();
                    String str = gold.MyBillsEntityDataFactory;
                    String str2 = gold.moveToNextValue.GetContactSyncConfig;
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.TEMPLATE, obj);
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_ID, str);
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_NAME, str2);
                } else if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
                    ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel;
                    String obj2 = insurance.initRecordTimeStamp.toString();
                    String str3 = insurance.getAuthRequestContext;
                    String str4 = insurance.MyBillsEntityDataFactory.GetContactSyncConfig;
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.TEMPLATE, obj2);
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_ID, str3);
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_NAME, str4);
                }
                builder.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            }
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            DANAToast.getAuthRequestContext(expressPurchaseActivity, bottomSheetCancelReasonResultModel.MyBillsEntityDataFactory);
        }
        expressPurchaseActivity.finish();
    }

    /* renamed from: $r8$lambda$pzfF7YOLFiUJVA9Y7BNi1-k2-TY */
    public static /* synthetic */ void m2585$r8$lambda$pzfF7YOLFiUJVA9Y7BNi1k2TY(ExpressPurchaseActivity expressPurchaseActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(expressPurchaseActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            expressPurchaseActivity.getDealsShopLocation(expressPurchaseActivity.PlaceComponentResult);
        }
    }

    public static final /* synthetic */ void access$dismissSettingLocationPermission(ExpressPurchaseActivity expressPurchaseActivity) {
        DialogPermission dialogPermission = expressPurchaseActivity.GetContactSyncConfig;
        if (dialogPermission != null) {
            dialogPermission.getAuthRequestContext();
        }
        expressPurchaseActivity.GetContactSyncConfig = null;
    }

    public static final /* synthetic */ void access$prepareBundle(ExpressPurchaseActivity expressPurchaseActivity, String str, String str2, ExpressPurchaseModel expressPurchaseModel) {
        Intent intent = expressPurchaseActivity.getIntent();
        intent.putExtra(QUICK_BUY_RESULT, str);
        intent.putExtra(BIZ_ORDER_ID, str2);
        if (expressPurchaseModel != null) {
            Intrinsics.checkNotNullExpressionValue(intent, "");
            ExpressPurchaseExtKt.MyBillsEntityDataFactory(intent, expressPurchaseModel);
        }
    }

    @JvmStatic
    public static final void open(BaseActivity baseActivity, ExpressPurchaseModel expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        baseActivity.startActivity(Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, expressPurchaseModel));
    }

    public final ExpressPurchaseDealsViewExtender expressPurchaseDealsExtender() {
        return (ExpressPurchaseDealsViewExtender) this.getAuthRequestContext.getValue();
    }

    public final ExpressPurchaseGoldViewExtender expressPurchaseGoldExtender() {
        return (ExpressPurchaseGoldViewExtender) this.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public final ExpressPurchaseInsuranceViewExtender expressPurchaseInsuranceExtender() {
        return (ExpressPurchaseInsuranceViewExtender) this.MyBillsEntityDataFactory.getValue();
    }

    @Override // id.dana.base.SingleBaseActivity
    public final DefaultViewKey getInitialLayoutView() {
        return (OfferProductScreen) this.moveToNextValue.getValue();
    }

    public final void handleConsultCancelSurveyExpressPurchase() {
        Bundle extras = getIntent().getExtras();
        ExpressPurchaseModel expressPurchaseModel = extras != null ? (ExpressPurchaseModel) extras.getParcelable(EXPRESS_PURCHASE_PAYLOAD) : null;
        if (expressPurchaseModel instanceof ExpressPurchaseModel.Gold) {
            ExpressPurchaseModel.Gold gold = (ExpressPurchaseModel.Gold) expressPurchaseModel;
            KClassImpl$Data$declaredNonStaticMembers$2(gold.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, gold.MyBillsEntityDataFactory);
        } else if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
            ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel;
            KClassImpl$Data$declaredNonStaticMembers$2(insurance.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, insurance.getAuthRequestContext);
        } else {
            super.onBackPressed();
        }
    }

    @Override // id.dana.base.SingleBaseActivity, id.dana.base.BaseActivity
    public final void init(Bundle bundle) {
        setRequestedOrientation((OSUtil.DatabaseTableConfigUtil() || OSUtil.initRecordTimeStamp()) ? -1 : 1);
        DaggerExpressPurchaseComponent.Builder MyBillsEntityDataFactory = DaggerExpressPurchaseComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
        MyBillsEntityDataFactory.getAuthRequestContext = (ExpressPurchaseModule) Preconditions.getAuthRequestContext(new ExpressPurchaseModule(new ExpressPurchaseActivity$expressPurchaseModule$1(this)));
        MyBillsEntityDataFactory.PlaceComponentResult = (CancelSurveyModule) Preconditions.getAuthRequestContext(new CancelSurveyModule(new CancelSurveyContract.View() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$cancelSurveyModule$1
            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                CancelSurveyContract.View.CC.PlaceComponentResult(str);
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                CancelSurveyContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final void MyBillsEntityDataFactory() {
                ExpressPurchaseActivity.this.finish();
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetCancelReasonModel p0) {
                ActivityResultLauncher activityResultLauncher;
                Intrinsics.checkNotNullParameter(p0, "");
                activityResultLauncher = ExpressPurchaseActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                activityResultLauncher.MyBillsEntityDataFactory(p0, null);
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ExpressPurchaseAnalyticModule) Preconditions.getAuthRequestContext(new ExpressPurchaseAnalyticModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        ExpressPurchaseActivity expressPurchaseActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = expressPurchaseActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = TrackerKey.SourceType.EXPRESS_PURCHASE;
        byte b = 0;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = expressPurchaseActivity;
        MyBillsEntityDataFactory.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = expressPurchaseActivity;
        MyBillsEntityDataFactory.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = expressPurchaseActivity;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = expressPurchaseActivity;
        MyBillsEntityDataFactory.moveToNextValue = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ExpressPurchaseModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, CancelSurveyModule.class);
        if (MyBillsEntityDataFactory.MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = new ExpressPurchaseAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.lookAheadTest, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.moveToNextValue, OauthModule.class);
        if (MyBillsEntityDataFactory.getErrorConfigVersion == null) {
            MyBillsEntityDataFactory.getErrorConfigVersion = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerExpressPurchaseComponent.ExpressPurchaseComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.lookAheadTest, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.getErrorConfigVersion, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getExpressPurchasePresenter(), getCancelSurveyPresenter());
        super.init(bundle);
    }

    private static void g(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = FragmentBottomSheetPaymentSettingBinding;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda6);
        if (NetworkUserEntityData$$ExternalSyntheticLambda3) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda4) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
