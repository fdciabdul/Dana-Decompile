package id.dana.sendmoney_v2.landing;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.extension.ContextExtKt;
import id.dana.core.ui.richview.InformationActionBottomSheetFragment;
import id.dana.danah5.DanaH5;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.UrlParam;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.ActivitySendMoneyLandingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.dialog.BillerX2BDialog;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.sendmoney.SendMoneyScenarioDirector;
import id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientModelExtKt;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.di.component.DaggerSendMoneyLandingComponent;
import id.dana.sendmoney_v2.landing.di.component.SendMoneyLandingComponent;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyLandingModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.view.OnboardingManageQuickActionBottomSheet;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.view.SplitBillIntroductionActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.SizeUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  \u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 \u0001B\b¢\u0006\u0005\b\u009f\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\b\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H\u0014¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0014¢\u0006\u0004\b%\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000e\u0010&J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010*\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0015¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b.\u0010-J\u001d\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\r2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b0\u00101R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u00103R\u0018\u0010\b\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010\u0013\u001a\u00020T8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u00103R\u0016\u0010a\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u00103R\"\u0010c\u001a\u00020b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0013\u0010l\u001a\u00020iX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bj\u0010kR\u0013\u00102\u001a\u00020mX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bn\u0010kR\"\u0010p\u001a\u00020o8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010w\u001a\u00020v8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020'8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b}\u0010~R)\u0010\u0084\u0001\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b\u0080\u0001\u0010~\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0005\b\u0083\u0001\u0010-R*\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0016\u0010\u0095\u0001\u001a\u00030\u0093\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010kR\u001b\u0010U\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010`\u001a\u00030\u0099\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010^\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/SendMoneyActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivitySendMoneyLandingBinding;", "", "configToolbar", "()V", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "PlaceComponentResult", "()Ljava/util/List;", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivitySendMoneyLandingBinding;", "", "getAuthRequestContext", "()Z", "Lid/dana/model/SendMoneyScenarioModel;", "p0", "(Lid/dana/model/SendMoneyScenarioModel;)Z", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "(Lid/dana/model/SendMoneyScenarioModel;)V", "Lid/dana/sendmoney/model/RecentRecipientModel;", "recentRecipientModel", "maxFavoriteAccount", "showFavoriteAccountExceedLimitDialog", "(Lid/dana/sendmoney/model/RecentRecipientModel;I)V", "showManageAccountBottomSheet", "(Lid/dana/sendmoney/model/RecentRecipientModel;)V", "showToastAfterDeleteAccountFromQuickSend", TrackerKey.SendMoneyProperties.IS_FAVORITE, "updateRecentTransactionFavoriteState", "(ZLid/dana/sendmoney/model/RecentRecipientModel;)V", "lookAheadTest", "Z", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "billerX2BPresenter", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "getBillerX2BPresenter", "()Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "setBillerX2BPresenter", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;)V", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "bottomSheetOnBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getBottomSheetOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setBottomSheetOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "initRecordTimeStamp", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "DatabaseTableConfigUtil", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "h5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getH5EventPresenter", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "setH5EventPresenter", "(Lid/dana/h5event/CheckoutH5EventContract$Presenter;)V", "GetContactSyncConfig", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda1", "moveToNextValue", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "kycAndDebitPayOptionPresenter", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "getKycAndDebitPayOptionPresenter", "()Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "setKycAndDebitPayOptionPresenter", "(Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;)V", "Lid/dana/sendmoney_v2/recipient/activity/ManageAccountBottomSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lkotlin/Lazy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney_v2/landing/view/OnboardingManageQuickActionBottomSheet;", "PrepareContext", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "getPlayStoreReviewPresenter", "()Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "setPlayStoreReviewPresenter", "(Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/sendmoney/model/RecentRecipientModel;", "scheduleImpl", "newProxyInstance", "getRecipientHoldClickAction", "()Lid/dana/sendmoney/model/RecentRecipientModel;", "setRecipientHoldClickAction", "recipientHoldClickAction", "Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "recipientPresenter", "Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "getRecipientPresenter", "()Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "setRecipientPresenter", "(Lid/dana/contract/sendmoney/RecipientContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "isLayoutRequested", "getErrorConfigVersion", "Lid/dana/sendmoney_v2/landing/di/component/SendMoneyLandingComponent;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/sendmoney_v2/landing/di/component/SendMoneyLandingComponent;", "Lid/dana/sendmoney/SendMoneyScenarioDirector;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/sendmoney/SendMoneyScenarioDirector;", "Lid/dana/showcase/Showcase;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/showcase/Showcase;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendMoneyActivity extends ViewBindingActivity<ActivitySendMoneyLandingBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda6;
    private static long SubSequence;
    private static char getCallingPid;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private MaterialDialog MyBillsEntityDataFactory;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private SendMoneyLandingComponent DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private Showcase GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private RecentRecipientModel scheduleImpl;
    @Inject
    public BillerX2BContract.Presenter billerX2BPresenter;
    @Inject
    public BottomSheetOnBoardingContract.Presenter bottomSheetOnBoardingPresenter;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public CheckoutH5EventContract.Presenter h5EventPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private CustomSnackbar PlaceComponentResult;
    @Inject
    public KycAndDebitPayOptionContract.Presenter kycAndDebitPayOptionPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private RecentRecipientModel recipientHoldClickAction;
    @Inject
    public PlayStoreReviewContract.Presenter playStoreReviewPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    @Inject
    public RecipientContract.Presenter recipientPresenter;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    public static final byte[] $$j = {108, 11, -123, -39, 6, TarHeader.LF_CONTIG, -53, 4, -12, 14, TarHeader.LF_BLK, -62, -11, Ascii.CAN, -6, -2, 1, -6, 70, -70, 13, 60, -52, -17, 3, 0, 6, 3, -8, 14, 5, -17, 74, -20, -49, 3, 0, 6, 3, 44, -38, -2, 1, 41, -32, -14, Ascii.DC4, -7, -2, Ascii.EM, -16, -18, 5, Ascii.US, -18, 5, -17, 1, -60, -11, 3, SignedBytes.MAX_POWER_OF_TWO, -56, -7, 1, 9, -4, 8, 56, -50, -12, 11, -13, 4, 7, 6, TarHeader.LF_CONTIG, -56, -5, -5, 70, -62, 13, -14, -2, 70, -75, 1, Ascii.SUB, -1};
    public static final int $$k = 249;
    public static final byte[] $$a = {119, -93, -18, -42, -58, 5, -10, -15, 36, -44, 33, -42, -1, -24, 4, -18, 4, -13, -13, -5, 38, -54, 0, 4, -24, 4, -13, -6, 36, -48, 4, -25, -7, 38, -34, -9, -24, -2, -10, -14, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, -35, 4, -9, -9, Ascii.ESC, -51, -5, -10, -6, -6, 2, -16, -13, Ascii.ESC, -26, -21, -9, 2, -15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 123;
    public static final byte[] PlaceComponentResult = {107, 3, 14, 112, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 230;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final SendMoneyScenarioDirector NetworkUserEntityData$$ExternalSyntheticLambda1 = new SendMoneyScenarioDirector(this);

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<ManageAccountBottomSheet>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$manageAccountBottomSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ManageAccountBottomSheet invoke() {
            final SendMoneyActivity sendMoneyActivity = SendMoneyActivity.this;
            Function1<RecipientModel, Unit> function1 = new Function1<RecipientModel, Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$manageAccountBottomSheet$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(RecipientModel recipientModel) {
                    invoke2(recipientModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(RecipientModel recipientModel) {
                    Intrinsics.checkNotNullParameter(recipientModel, "");
                    SendMoneyActivity.this.getBinding().PlaceComponentResult.getRecentRecipientPresenter().getAuthRequestContext("");
                    SendMoneyActivity.this.showToastAfterDeleteAccountFromQuickSend(RecipientModelExtKt.getAuthRequestContext(recipientModel));
                }
            };
            final SendMoneyActivity sendMoneyActivity2 = SendMoneyActivity.this;
            Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$manageAccountBottomSheet$2.2
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
                    SendMoneyActivity sendMoneyActivity3 = SendMoneyActivity.this;
                    SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                    SendMoneyActivity.access$showSnackbarRemoveFailed(sendMoneyActivity3, SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory.asString(SendMoneyActivity.this));
                }
            };
            final SendMoneyActivity sendMoneyActivity3 = SendMoneyActivity.this;
            return new ManageAccountBottomSheet(function1, null, function12, new Function4<Throwable, String, String, String, Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$manageAccountBottomSheet$2.3
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th, String str, String str2, String str3) {
                    invoke2(th, str, str2, str3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th, String str, String str2, String str3) {
                    Intrinsics.checkNotNullParameter(th, "");
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    Intrinsics.checkNotNullParameter(str3, "");
                    if (str2.length() > 0) {
                        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity.this, str, str2, str3, th);
                    }
                }
            }, 2, null);
        }
    });

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<OnboardingManageQuickActionBottomSheet>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$onBoardingManageQuickActionBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OnboardingManageQuickActionBottomSheet invoke() {
            return new OnboardingManageQuickActionBottomSheet();
        }
    });

    static void BuiltInFictitiousFunctionClassFactory() {
        getCallingPid = (char) 11892;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = 4360990799332652212L;
        NetworkUserEntityData$$ExternalSyntheticLambda4 = -956812108;
        SubSequence = 7587809718106570319L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = 56 - r7
            int r8 = r8 + 16
            byte[] r0 = id.dana.sendmoney_v2.landing.SendMoneyActivity.PlaceComponentResult
            int r9 = 106 - r9
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            r8 = r7
            goto L36
        L16:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r9
            r9 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r7 = r7 + 1
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.SendMoneyActivity.c(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 4
            int r7 = r7 + 66
            int r8 = 42 - r8
            byte[] r0 = id.dana.sendmoney_v2.landing.SendMoneyActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2e
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L2e:
            int r7 = -r7
            int r10 = r10 + 1
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.SendMoneyActivity.k(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 59 - r8
            byte[] r0 = id.dana.sendmoney_v2.landing.SendMoneyActivity.$$j
            int r6 = 54 - r6
            int r7 = r7 * 3
            int r7 = r7 + 36
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
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
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 1
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.SendMoneyActivity.l(byte, byte, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{21425, 61434, 42181, 26427}, View.combineMeasuredStates(0, 0), (char) (View.resolveSize(0, 0) + 15268), new char[]{17789, 54829, 52506, 62467, 23656, 25309, 42006, 9923, 13834, 22901, 909, 10196, 6535, 46896, 21376, 63310, 5765, 18421}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(View.resolveSizeAndState(0, 0, 0) + 51991, new char[]{28513, 42082, 63863, 3616, 17204}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 14983, new char[]{28475, 21992, 6708, 49313, 34080, 19403, 12319, 63109, 47875, 25046, 9769, 60583, 53565, 38885, 23647, 723, 51021, 36298, 29252, 14184, 64996, 41596, 26869, 11547, 5056, 55312, 40578, 17237, 2554, 52771, 46271, 31024, 16341, 58461, 43728, 28480, 21910, 6838, 57150, 34221, 18979, 12533, 62750, 48023, 24666, 9860, 60280, 53664}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(29989 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{28525, 6684, 34160, 12295, 48126, 9868, 53730, 23351, 50752, 28962, 64583, 26542, 4820, 40412, 1851, 45587, 15726, 43083, 21488, 56962, 18828, 62260, 32276, 59756, 37954, 8179, 35575, 13710, 48952, 10841, 54632, 16453, 52175, 30381, 57810, 27451, 5723, 33078, 3138, 47004, 8945, 44497, 22395, 49674, 19763, 63674, 25499, 61168, 39375, 810, 36353, 14698, 42161, 12178, 56050, 17870, 53028, 31232, 58637, 37097, 7057, 34533, 12702, 47908}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{55251, 64674, 19691, 25245}, View.combineMeasuredStates(0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{56955, 19782, 5861, 59358, 43658, 6475, 13037, 32074, 57162, 3305, 59507, 49924, 30092, 58961, 32522, 28834, 35309, 25883, 29800, 44350, 39730, 64747, 42490, 14988, 20136, 55855, 45210, 38369, 20272, 44415, 11865, 53981, 8239, 57774, 36279, 41861, 50138, 18331, 1395, 9311, 22238, 52978, 35772, 19616, 2584, 38772, 41491, 8085, 55121, 19236, 56865, 4718, 46268, 32123, 61242, 46865, 58839, 50142, 35072, 16203, 49779, 30824, 47788, 50815}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{63053, 59266, 55626, 57783}, TextUtils.getOffsetAfter("", 0), (char) View.MeasureSpec.getMode(0), new char[]{50500, 46699, 27722, 15863, 25992, 30573, 9443, 15240, 30832, 23175, 23531, 6216, 45993, 2246, 5456, 65416, 27328, 9386, 44261, 55033, 59874, 28131, 33246, 52111, 18769, 30432, 9606, 3012, 60583, 26983, 53105, 6006, 47491, 15546, 2616, 50541, 46824, 33213, 16465, 11590, 27100, 42120, 4250, 16965, 18809, 55911, 8352, 51947, 32755, 27589, 1005, 37810, 57980, 17995, 41188, 58976, 16442, 58063, 20506, 19871}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{13530, 12998, 17543, 11724}, ViewConfiguration.getKeyRepeatDelay() >> 16, (char) (52292 - ((Process.getThreadPriority(0) + 20) >> 6)), new char[]{63419, 24420, 41219, 8710, 46347, 34045}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                byte b = (byte) (-PlaceComponentResult[31]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                c(b, b2, b2, objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                c(30, PlaceComponentResult[25], PlaceComponentResult[9], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 56, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1));
                        Object[] objArr17 = new Object[1];
                        k((byte) (-$$a[72]), (byte) (-$$a[2]), $$a[8], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0), 15 - Color.alpha(0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myTid() >> 22), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 14, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0', 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 15, (char) Color.blue(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Gravity.getAbsoluteGravity(0, 0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {1674670310, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - TextUtils.getTrimmedLength(""), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                byte b3 = (byte) (-PlaceComponentResult[31]);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr21 = new Object[1];
                c(b3, b4, b4, objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                c(30, PlaceComponentResult[25], PlaceComponentResult[9], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 46, (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr24 = new Object[1];
                        k((byte) ($$a[20] - 1), (byte) (-$$a[74]), (byte) (-$$a[66]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {1674670310, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                byte b5 = (byte) (-PlaceComponentResult[31]);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr28 = new Object[1];
                c(b5, b6, b6, objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                c(30, PlaceComponentResult[25], PlaceComponentResult[9], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 118, 2 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 38968));
                        Object[] objArr31 = new Object[1];
                        k((byte) ($$a[20] - 1), (byte) (-$$a[74]), (byte) (-$$a[66]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {1674670310, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 18 - Color.red(0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                byte b7 = (byte) (-PlaceComponentResult[31]);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr35 = new Object[1];
                c(b7, b8, b8, objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                c(30, PlaceComponentResult[25], PlaceComponentResult[9], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.resolveSize(0, 0), View.resolveSizeAndState(0, 0, 0) + 3, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        byte b9 = $$a[73];
                        byte b10 = $$a[22];
                        Object[] objArr38 = new Object[1];
                        k(b9, b10, (byte) (b10 | 98), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {1674670310, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @JvmName(name = "getRecipientPresenter")
    public final RecipientContract.Presenter getRecipientPresenter() {
        RecipientContract.Presenter presenter = this.recipientPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRecipientPresenter")
    public final void setRecipientPresenter(RecipientContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.recipientPresenter = presenter;
    }

    @JvmName(name = "getBillerX2BPresenter")
    public final BillerX2BContract.Presenter getBillerX2BPresenter() {
        BillerX2BContract.Presenter presenter = this.billerX2BPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBillerX2BPresenter")
    public final void setBillerX2BPresenter(BillerX2BContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.billerX2BPresenter = presenter;
    }

    @JvmName(name = "getBottomSheetOnBoardingPresenter")
    public final BottomSheetOnBoardingContract.Presenter getBottomSheetOnBoardingPresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.bottomSheetOnBoardingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBottomSheetOnBoardingPresenter")
    public final void setBottomSheetOnBoardingPresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.bottomSheetOnBoardingPresenter = presenter;
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

    @JvmName(name = "getKycAndDebitPayOptionPresenter")
    public final KycAndDebitPayOptionContract.Presenter getKycAndDebitPayOptionPresenter() {
        KycAndDebitPayOptionContract.Presenter presenter = this.kycAndDebitPayOptionPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setKycAndDebitPayOptionPresenter")
    public final void setKycAndDebitPayOptionPresenter(KycAndDebitPayOptionContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.kycAndDebitPayOptionPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticTracker")
    public final void setSendMoneyAnalyticTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
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

    @JvmName(name = "getDeviceInformationProvider")
    public final DeviceInformationProvider getDeviceInformationProvider() {
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            return deviceInformationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @JvmName(name = "getH5EventPresenter")
    public final CheckoutH5EventContract.Presenter getH5EventPresenter() {
        CheckoutH5EventContract.Presenter presenter = this.h5EventPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setH5EventPresenter")
    public final void setH5EventPresenter(CheckoutH5EventContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.h5EventPresenter = presenter;
    }

    @JvmName(name = "getPlayStoreReviewPresenter")
    public final PlayStoreReviewContract.Presenter getPlayStoreReviewPresenter() {
        PlayStoreReviewContract.Presenter presenter = this.playStoreReviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPlayStoreReviewPresenter")
    public final void setPlayStoreReviewPresenter(PlayStoreReviewContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.playStoreReviewPresenter = presenter;
    }

    @JvmName(name = "getRecipientHoldClickAction")
    public final RecentRecipientModel getRecipientHoldClickAction() {
        return this.recipientHoldClickAction;
    }

    @JvmName(name = "setRecipientHoldClickAction")
    public final void setRecipientHoldClickAction(RecentRecipientModel recentRecipientModel) {
        this.recipientHoldClickAction = recentRecipientModel;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((ViewConfiguration.getPressedStateDuration() >> 16) + 35869, new char[]{28525, 58239, 30546, 52009, 24343, 54260, 10182, 48105, 3973, 33401, 5726, 27165, 65041, 29206, 50926, 23254, 44714, 8840, 46450, 2386, 40220, 4357, 25856, 63986, 19925, 49597}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{4364, 13956, 50229, 11244}, MotionEvent.axisFromString("") + 1, (char) (60613 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), new char[]{63233, 37353, 5372, 12932, 29994, 43045, 26030, 61030, 5280, 48802, 25829, 40432, 55818, 366, 48301, 25744, 31145, 55447}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, AndroidCharacter.getMirror('0') - '\r', (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.getErrorConfigVersion.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN LANDING PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN LANDING PAGE") == null) {
            long MyBillsEntityDataFactory = sendMoneyFeatureTime.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("OPEN LANDING PAGE", "");
            sendMoneyFeatureTime.getAuthRequestContext.put("OPEN LANDING PAGE", Long.valueOf(MyBillsEntityDataFactory));
        }
        if (getAuthRequestContext()) {
            getIntent().removeExtra("bundle_extra_for_resume");
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        getBinding().PlaceComponentResult.getRecentRecipientPresenter().getAuthRequestContext("");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(TextUtils.lastIndexOf("", '0', 0, 0) + 35870, new char[]{28525, 58239, 30546, 52009, 24343, 54260, 10182, 48105, 3973, 33401, 5726, 27165, 65041, 29206, 50926, 23254, 44714, 8840, 46450, 2386, 40220, 4357, 25856, 63986, 19925, 49597}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {4364, 13956, 50229, 11244};
            try {
                Object[] objArr2 = new Object[1];
                c((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                c(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[1], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(cArr, cArr2, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.tap_here_to_pay_by_using_your_qr_code_payment).substring(0, 4).length() + 60608), new char[]{63233, 37353, 5372, 12932, 29994, 43045, 26030, 61030, 5280, 48802, 25829, 40432, 55818, 366, 48301, 25744, 31145, 55447}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), TextUtils.indexOf("", "", 0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), TextUtils.getOffsetBefore("", 0) + 18, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        if (this.moveToNextValue) {
            return;
        }
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.getErrorConfigVersion.getValue();
        Intrinsics.checkNotNullParameter("OPEN LANDING PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN LANDING PAGE") != null) {
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            SendMoneyAnalyticTracker sendMoneyAnalyticTracker = getSendMoneyAnalyticTracker();
            String source = getSource();
            Intrinsics.checkNotNullExpressionValue(source, "");
            sendMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(source, z);
            this.moveToNextValue = true;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.sendmoney_landing_toolbar_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setMenuRightButton(R.drawable.ic_tooltip_help);
        setMenuRightContentDescription(getString(R.string.iconQuickSendHelp));
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivitySendMoneyLandingBinding initViewBinding() {
        ActivitySendMoneyLandingBinding KClassImpl$Data$declaredNonStaticMembers$2 = ActivitySendMoneyLandingBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r3, int resultCode, Intent data) {
        super.onActivityResult(r3, resultCode, data);
        if (-1 == resultCode && ScannerActionFactory.BuiltInFictitiousFunctionClassFactory == r3 && data != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(data.getExtras());
        }
        if (-1 == resultCode && NetworkUserEntityData$$ExternalSyntheticLambda0 == r3) {
            TextView textView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            SendMoneyActivity sendMoneyActivity = this;
            Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder(sendMoneyActivity).getAuthRequestContext(textView).BuiltInFictitiousFunctionClassFactory(new CircleShape(SplitBillIntroductionActivity.SPOTLIGHT_SIZE)).getAuthRequestContext(new Content(getResources().getString(R.string.tooltip_highlight_title), getResources().getString(R.string.tooltip_highlight_description_send_money))).KClassImpl$Data$declaredNonStaticMembers$2();
            if (this.GetContactSyncConfig == null) {
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(sendMoneyActivity);
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
                this.GetContactSyncConfig = simpleShowcaseBuilder.getAuthRequestContext(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showShowcase$1
                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public final void onFinished(int p0) {
                        SendMoneyActivity.this.GetContactSyncConfig = null;
                        SendMoneyActivity.this.getBottomSheetOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("favorite_quick_send");
                    }
                }).PlaceComponentResult();
            }
            getBottomSheetOnBoardingPresenter().MyBillsEntityDataFactory("send_money");
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyScenarioModel p0) {
        return p0.NetworkUserEntityData$$ExternalSyntheticLambda0() && Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda6, "scan_qr_code");
    }

    private static boolean PlaceComponentResult(SendMoneyScenarioModel p0) {
        return p0.NetworkUserEntityData$$ExternalSyntheticLambda2() || p0.MyBillsEntityDataFactory() || p0.KClassImpl$Data$declaredNonStaticMembers$2() || p0.getAuthRequestContext() || p0.moveToNextValue() || p0.initRecordTimeStamp() || p0.PlaceComponentResult();
    }

    private static boolean MyBillsEntityDataFactory(SendMoneyScenarioModel p0) {
        return !p0.scheduleImpl() && (StringsKt.isBlank(p0.NetworkUserEntityData$$ExternalSyntheticLambda3) ^ true);
    }

    private final List<ContentOnBoardingModel> PlaceComponentResult() {
        String string = getString(R.string.bottom_on_boarding_send_money_first_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.bottom_on_boarding_send_money_first_body_text);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = getString(R.string.bottom_on_boarding_send_money_second_subtitle);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = getString(R.string.bottom_on_boarding_send_money_second_body_text);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = getString(R.string.bottom_on_boarding_send_money_third_subtitle);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = getString(R.string.bottom_on_boarding_send_money_third_body_text);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        String string7 = getString(R.string.bottom_on_boarding_send_money_fourth_subtitle);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        String string8 = getString(R.string.bottom_on_boarding_send_money_fourth_body_text);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        return CollectionsKt.listOf((Object[]) new ContentOnBoardingModel[]{new ContentOnBoardingModel((int) R.drawable.on_boarding_enter_pin, string, string2), new ContentOnBoardingModel((int) R.drawable.ic_illustration_general_new_card, string3, string4), new ContentOnBoardingModel((int) R.drawable.ic_illustration_general_direct_cashout, string5, string6), new ContentOnBoardingModel((int) R.drawable.ic_illustration_general_secured_trx, string7, string8)});
    }

    private final void getAuthRequestContext(SendMoneyScenarioModel p0) {
        Bundle bundleWithSource = getBundleWithSource();
        bundleWithSource.putString("recipientType", p0.KClassImpl$Data$declaredNonStaticMembers$2);
        bundleWithSource.putString("iconUrl", p0.MyBillsEntityDataFactory);
        SendMoneyScenarioDirector sendMoneyScenarioDirector = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(bundleWithSource, "");
        sendMoneyScenarioDirector.KClassImpl$Data$declaredNonStaticMembers$2(bundleWithSource);
        getSendMoneyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(p0.KClassImpl$Data$declaredNonStaticMembers$2, false, (Boolean) null);
    }

    private final boolean getAuthRequestContext() {
        Bundle extras;
        Intent intent = getIntent();
        return (intent == null || (extras = intent.getExtras()) == null || !extras.getBoolean("bundle_extra_for_resume")) ? false : true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        SendMoneyScenarioDirector sendMoneyScenarioDirector = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intent intent = getIntent();
        boolean authRequestContext = sendMoneyScenarioDirector.getAuthRequestContext(intent != null ? intent.getExtras() : null);
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.removeExtra("recipientType");
        }
        return authRequestContext;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/landing/SendMoneyActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/sendmoney/model/QrTransferModel;", "p1", "", "p2", "p3", "Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/sendmoney/model/QrTransferModel;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "p4", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/sendmoney/model/QrTransferModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent PlaceComponentResult(Context p0, QrTransferModel p1, String p2, String p3) {
            Intent intent = new Intent(p0, SendMoneyActivity.class);
            intent.putExtra("scanner_data", p1);
            intent.putExtra("transactionType", p2);
            intent.putExtra("recipientType", BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE);
            intent.putExtra("source", p3);
            return intent;
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, QrTransferModel p1, String p2, String p3, String p4) {
            Intent intent = new Intent(p0, SendMoneyActivity.class);
            intent.putExtra("scanner_data", p1);
            intent.putExtra("transactionType", p2);
            intent.putExtra("recipientType", p4);
            intent.putExtra("source", p3);
            return intent;
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, QrTransferModel p1, String p2, String p3) {
            Intent intent = new Intent(p0, SendMoneyActivity.class);
            intent.putExtra("scanner_data", p1);
            intent.putExtra("transactionType", "split_bill");
            intent.putExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID, p2);
            intent.putExtra("recipientType", BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE);
            intent.putExtra("source", p3);
            return intent;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public final void showManageAccountBottomSheet(RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        this.recipientHoldClickAction = recentRecipientModel;
        Integer currentFavoriteAccountCount = getBinding().PlaceComponentResult.getCurrentFavoriteAccountCount();
        if (isActivityAvailable()) {
            ManageAccountBottomSheet manageAccountBottomSheet = (ManageAccountBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
            manageAccountBottomSheet.getAuthRequestContext = currentFavoriteAccountCount;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            AndroidComponentUtilsKt.MyBillsEntityDataFactory(manageAccountBottomSheet, supportFragmentManager, "MANAGE_QUICK_ACTION");
        }
    }

    public final void updateRecentTransactionFavoriteState(boolean r3, RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        getRecipientPresenter().KClassImpl$Data$declaredNonStaticMembers$2(r3, recentRecipientModel, false);
    }

    public final void showFavoriteAccountExceedLimitDialog(final RecentRecipientModel recentRecipientModel, int maxFavoriteAccount) {
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.DatabaseTableConfigUtil = R.drawable.ic_error_favorite;
        builder.SubSequence = getString(R.string.send_money_favorite_reach_limit_title);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.send_money_favorite_reach_limit_description);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(maxFavoriteAccount)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(getString(R.string.btn_continue), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showFavoriteAccountExceedLimitDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ActivitySendMoneyLandingBinding binding;
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                RecipientContract.Presenter recipientPresenter = SendMoneyActivity.this.getRecipientPresenter();
                binding = SendMoneyActivity.this.getBinding();
                recipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2(false, binding.PlaceComponentResult.getLeastTransactionFavoriteAccount(), true);
                SendMoneyActivity.this.scheduleImpl = recentRecipientModel;
                materialDialog = SendMoneyActivity.this.MyBillsEntityDataFactory;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.dismiss();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.btn_cancel_nearby_search), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showFavoriteAccountExceedLimitDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                SendMoneyActivity.this.showManageAccountBottomSheet(recentRecipientModel);
            }
        }).BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            BuiltInFictitiousFunctionClassFactory = null;
        }
        BuiltInFictitiousFunctionClassFactory.show();
    }

    /* renamed from: $r8$lambda$Wdk-W5T5cGQ1hZNM9HhN0FQFyi8 */
    public static /* synthetic */ void m2929$r8$lambda$WdkW5T5cGQ1hZNM9HhN0FQFyi8(SendMoneyActivity sendMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(sendMoneyActivity, "");
        CustomSnackbar customSnackbar = sendMoneyActivity.PlaceComponentResult;
        if (customSnackbar != null) {
            customSnackbar.dismiss();
        }
    }

    /* renamed from: $r8$lambda$eS5qXIjZrYI4lptlXZYQp-nEpPU */
    public static /* synthetic */ void m2930$r8$lambda$eS5qXIjZrYI4lptlXZYQpnEpPU(SendMoneyActivity sendMoneyActivity, boolean z) {
        Intrinsics.checkNotNullParameter(sendMoneyActivity, "");
        sendMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    /* renamed from: $r8$lambda$n6WE9Vx06D4UM-k-wS7zqSsred8 */
    public static /* synthetic */ void m2931$r8$lambda$n6WE9Vx06D4UMkwS7zqSsred8(SendMoneyActivity sendMoneyActivity, BillerX2BModel billerX2BModel, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(sendMoneyActivity, "");
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        if (-1 == i) {
            sendMoneyActivity.getBillerX2BPresenter().KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            dialogInterface.dismiss();
        }
    }

    public static final /* synthetic */ void access$checkSendMoneyUseCase(SendMoneyActivity sendMoneyActivity, SendMoneyScenarioModel sendMoneyScenarioModel) {
        if (sendMoneyScenarioModel.scheduleImpl()) {
            sendMoneyActivity.getKycAndDebitPayOptionPresenter().getAuthRequestContext(sendMoneyScenarioModel);
        } else if (!sendMoneyScenarioModel.getErrorConfigVersion()) {
            sendMoneyActivity.getAuthRequestContext(sendMoneyScenarioModel);
        } else {
            String str = sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (UrlUtil.getErrorConfigVersion(str)) {
                sendMoneyActivity.getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
            } else {
                DanaH5.startContainerFullUrl(str);
            }
        }
    }

    public static final /* synthetic */ void access$checkShowOnBoardingFavoriteQuickAction(final SendMoneyActivity sendMoneyActivity, boolean z) {
        try {
            if (sendMoneyActivity.getBinding().PlaceComponentResult.getIsRecentTransactionEmpty() || !z) {
                return;
            }
            OnboardingManageQuickActionBottomSheet onboardingManageQuickActionBottomSheet = (OnboardingManageQuickActionBottomSheet) sendMoneyActivity.lookAheadTest.getValue();
            OnboardingManageQuickActionBottomSheet.OnClickListener onClickListener = new OnboardingManageQuickActionBottomSheet.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showOnBoardingQuickActionBottomSheet$1
                @Override // id.dana.sendmoney_v2.landing.view.OnboardingManageQuickActionBottomSheet.OnClickListener
                public final void getAuthRequestContext() {
                    ActivitySendMoneyLandingBinding binding;
                    binding = SendMoneyActivity.this.getBinding();
                    binding.PlaceComponentResult.showTooltip();
                    SendMoneyActivity.access$getOnBoardingManageQuickActionBottomSheet(SendMoneyActivity.this).dismiss();
                }
            };
            Intrinsics.checkNotNullParameter(onClickListener, "");
            onboardingManageQuickActionBottomSheet.MyBillsEntityDataFactory = onClickListener;
            if (sendMoneyActivity.isActivityAvailable()) {
                OnboardingManageQuickActionBottomSheet onboardingManageQuickActionBottomSheet2 = (OnboardingManageQuickActionBottomSheet) sendMoneyActivity.lookAheadTest.getValue();
                FragmentManager supportFragmentManager = sendMoneyActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                AndroidComponentUtilsKt.MyBillsEntityDataFactory(onboardingManageQuickActionBottomSheet2, supportFragmentManager, "onboarding");
            }
            sendMoneyActivity.getBottomSheetOnBoardingPresenter().MyBillsEntityDataFactory("favorite_quick_send");
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, e.getMessage());
        }
    }

    public static final /* synthetic */ String access$constructFullUrl(SendMoneyActivity sendMoneyActivity, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (Intrinsics.areEqual("production", "production")) {
            buildUpon.scheme("https");
        }
        if (str2 != null) {
            buildUpon.appendQueryParameter("authCode", str2);
        }
        if (str3 != null) {
            buildUpon.appendQueryParameter(UrlParam.REQUEST_ID, str3);
        }
        String obj = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ String access$getChatBotUrl(SendMoneyActivity sendMoneyActivity) {
        Uri.Builder appendQueryParameter = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot").buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "resoCenterLandingPage");
        StringBuilder sb = new StringBuilder();
        sb.append(sendMoneyActivity.getDeviceInformationProvider().getDeviceUUID());
        sb.append("_other_other_problem");
        String obj = appendQueryParameter.appendQueryParameter("caseName", sb.toString()).appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "OTHER").appendQueryParameter("subtopic", "OTHER_PROBLEM").appendQueryParameter("journeySlug", "otherProblem").build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ OnboardingManageQuickActionBottomSheet access$getOnBoardingManageQuickActionBottomSheet(SendMoneyActivity sendMoneyActivity) {
        return (OnboardingManageQuickActionBottomSheet) sendMoneyActivity.lookAheadTest.getValue();
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SendMoneyActivity sendMoneyActivity) {
        return (SendMoneyFeatureTime) sendMoneyActivity.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void access$onMenuSelected(SendMoneyActivity sendMoneyActivity, SendMoneyScenarioModel sendMoneyScenarioModel) {
        if (!KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyScenarioModel)) {
            if (!MyBillsEntityDataFactory(sendMoneyScenarioModel)) {
                if (PlaceComponentResult(sendMoneyScenarioModel)) {
                    sendMoneyActivity.getKycAndDebitPayOptionPresenter().getAuthRequestContext((Object) sendMoneyScenarioModel);
                    return;
                } else {
                    sendMoneyActivity.getAuthRequestContext(sendMoneyScenarioModel);
                    return;
                }
            }
            String str = sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (UrlUtil.getErrorConfigVersion(str)) {
                sendMoneyActivity.getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                return;
            } else {
                DanaH5.startContainerFullUrl(str);
                return;
            }
        }
        Activity PlaceComponentResult2 = ContextExtKt.PlaceComponentResult(sendMoneyActivity);
        if (PlaceComponentResult2 != null) {
            Intent intent = new Intent(PlaceComponentResult2, ScannerActivity.class);
            intent.putExtra("source", "Send Money");
            PlaceComponentResult2.startActivityForResult(intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static final /* synthetic */ void access$onRecipientSelected(SendMoneyActivity sendMoneyActivity, RecipientModel recipientModel) {
        if (Intrinsics.areEqual(recipientModel.readMicros, "bank")) {
            sendMoneyActivity.getBillerX2BPresenter().PlaceComponentResult(recipientModel);
            return;
        }
        recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = "userid";
        sendMoneyActivity.getKycAndDebitPayOptionPresenter().getAuthRequestContext(recipientModel);
    }

    public static final /* synthetic */ void access$openBottomSheetOnBoardingViewPage(SendMoneyActivity sendMoneyActivity) {
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        String string = sendMoneyActivity.getString(R.string.bottom_on_boarding_send_money_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        sendMoneyActivity.startActivityForResult(BottomSheetHelpActivity.Companion.PlaceComponentResult(sendMoneyActivity, new OnBoardingModel(string, "list", sendMoneyActivity.PlaceComponentResult(), "send_money", null, null, null, 112, null), true), NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public static final /* synthetic */ void access$openPostH5Container(final SendMoneyActivity sendMoneyActivity, String str) {
        DanaH5.startContainerFullUrlWithSendCredentials$default(str, new DanaH5Listener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                boolean z;
                SendMoneyActivity.this.getH5EventPresenter().BuiltInFictitiousFunctionClassFactory();
                DanaH5.dispose();
                z = SendMoneyActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (z) {
                    SendMoneyActivity.this.getPlayStoreReviewPresenter().PlaceComponentResult();
                }
            }
        }, null, null, 12, null);
        sendMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        sendMoneyActivity.getH5EventPresenter().MyBillsEntityDataFactory();
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final /* synthetic */ void access$openSummary(SendMoneyActivity sendMoneyActivity, RecipientModel recipientModel) {
        if (Intrinsics.areEqual("contact", recipientModel.readMicros)) {
            recipientModel.BottomSheetCardBindingView$watcherCardNumberView$1 = "sendMoney";
        }
        recipientModel.B = "send_money";
        if (!Intrinsics.areEqual("bank", recipientModel.readMicros) || OSUtil.getErrorConfigVersion() || !sendMoneyActivity.getAuthRequestContext) {
            Intent intentClassWithTracking = sendMoneyActivity.getIntentClassWithTracking(SummaryActivity.class);
            intentClassWithTracking.putExtra("data", recipientModel);
            intentClassWithTracking.putExtra("transferScenario", sendMoneyActivity.getIntent().getStringExtra("transferScenario"));
            intentClassWithTracking.putExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID, sendMoneyActivity.getIntent().getStringExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID));
            sendMoneyActivity.startActivity(intentClassWithTracking);
        } else if (sendMoneyActivity.isActivityAvailable()) {
            ?? r1 = 0;
            MaterialDialog.positiveButton$default(MaterialDialog.message$default(new MaterialDialog(sendMoneyActivity, r1, 2, r1), Integer.valueOf((int) R.string.dialog_warning_below_kitkat), null, null, 6, null), null, null, null, 7, null).cancelable(false).show();
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public static final /* synthetic */ void access$showKycDialog(final SendMoneyActivity sendMoneyActivity) {
        if (sendMoneyActivity.isActivityAvailable()) {
            ?? r3 = 0;
            TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment = new TwoActionWithIconBottomSheetFragment(r3, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showKycDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://m.dana.id");
                    sb.append(SendMoneyActivity.this.getDynamicUrlWrapper().getKycFromSendMoneyUrl());
                    DanaH5.startContainerFullUrl(sb.toString());
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 1, r3);
            Context baseContext = sendMoneyActivity.getBaseContext();
            if (baseContext != null) {
                Intrinsics.checkNotNullExpressionValue(baseContext, "");
                twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory = R.drawable.ic_upgrade_to_kyc_bottomsheet;
                AppCompatImageView appCompatImageView = (AppCompatImageView) twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView != null) {
                    TwoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView, twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory);
                }
                String string = baseContext.getString(R.string.upgrade_to_dana_premium);
                Intrinsics.checkNotNullExpressionValue(string, "");
                twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory(string);
                String string2 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_description);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                twoActionWithIconBottomSheetFragment.PlaceComponentResult(string2);
                String string3 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_button_positive);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                twoActionWithIconBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(string3);
                String string4 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_button_negative);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(string4);
            }
            FragmentManager supportFragmentManager = sendMoneyActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager);
        }
    }

    public static final /* synthetic */ void access$showSnackbarRemoveFailed(final SendMoneyActivity sendMoneyActivity, String str) {
        View findViewById = sendMoneyActivity.getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = str;
        builder.lookAheadTest = sendMoneyActivity.getString(R.string.close);
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_red_50;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendMoneyActivity.m2929$r8$lambda$WdkW5T5cGQ1hZNM9HhN0FQFyi8(SendMoneyActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        sendMoneyActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    public static final /* synthetic */ void access$showToastAfterManageFavorite(SendMoneyActivity sendMoneyActivity, RecentRecipientModel recentRecipientModel) {
        String str;
        if (recentRecipientModel.getAuthRequestContext != null && recentRecipientModel.PlaceComponentResult() != null) {
            str = TextUtil.MyBillsEntityDataFactory(recentRecipientModel.getAuthRequestContext, "\\*");
            if (str == null) {
                str = TextUtil.MyBillsEntityDataFactory(recentRecipientModel.PlaceComponentResult(), "\\*");
            }
        } else {
            str = recentRecipientModel.getErrorConfigVersion;
        }
        if (recentRecipientModel.isLayoutRequested == 7 || recentRecipientModel.isLayoutRequested == 6) {
            String string = recentRecipientModel.getErrorConfigVersion() ? sendMoneyActivity.getString(R.string.success_delete_group_from_favorite) : sendMoneyActivity.getString(R.string.res_0x7f131606_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(sendMoneyActivity, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, string);
            return;
        }
        String string2 = recentRecipientModel.getErrorConfigVersion() ? sendMoneyActivity.getString(R.string.send_money_text_toast_remove_favorite) : sendMoneyActivity.getString(R.string.send_money_text_toast_add_favorite);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        CustomToast customToast2 = CustomToast.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(string2);
        CustomToast.MyBillsEntityDataFactory(sendMoneyActivity, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, sb.toString());
    }

    public static final /* synthetic */ void access$showUserDataOnProcessedDialog(final SendMoneyActivity sendMoneyActivity) {
        if (sendMoneyActivity.isActivityAvailable()) {
            new InformationActionBottomSheetFragment(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showUserDataOnProcessedDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DanaH5.startContainerFullUrlWithoutTimeout(SendMoneyActivity.access$getChatBotUrl(SendMoneyActivity.this), new DanaH5Listener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$showUserDataOnProcessedDialog$1.1
                        @Override // id.dana.utils.danah5.DanaH5Listener
                        public final void onContainerCreated(Bundle p0) {
                        }

                        @Override // id.dana.utils.danah5.DanaH5Listener
                        public final void onContainerDestroyed(Bundle p0) {
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }).show(sendMoneyActivity.getSupportFragmentManager(), "InformationActionBottomSheetFragment");
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        String str;
        byte b = 0;
        if (this.DatabaseTableConfigUtil == null) {
            DaggerSendMoneyLandingComponent.Builder authRequestContext = DaggerSendMoneyLandingComponent.getAuthRequestContext();
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = (SendMoneyLandingModule) Preconditions.getAuthRequestContext(new SendMoneyLandingModule(new SendMoneyActivity$sendMoneyLandingModule$1(this)));
            authRequestContext.moveToNextValue = (RecipientActivityModule) Preconditions.getAuthRequestContext(new RecipientActivityModule(new RecipientContract.View() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$recipientActivityModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.sendmoney.RecipientContract.View
                public final void onFinishCheckReferralSendMoney(boolean p0, String p1) {
                }

                @Override // id.dana.contract.sendmoney.RecipientContract.View
                public final void onGetSmartFrictionConfig(SmartFrictionConfig p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.sendmoney.RecipientContract.View
                public final void onGetFeatureBelowKitkatConfigSuccess(boolean p0) {
                    SendMoneyActivity.this.getAuthRequestContext = p0;
                }

                @Override // id.dana.contract.sendmoney.RecipientContract.View
                public final void onSuccessUpdateFavoriteState(boolean p0, RecentRecipientModel p1) {
                    ActivitySendMoneyLandingBinding binding;
                    Intrinsics.checkNotNullParameter(p1, "");
                    SendMoneyActivity.access$showToastAfterManageFavorite(SendMoneyActivity.this, p1);
                    binding = SendMoneyActivity.this.getBinding();
                    binding.PlaceComponentResult.updateRecentTransaction();
                }

                @Override // id.dana.contract.sendmoney.RecipientContract.View
                public final void onSuccessRemoveOldFavoriteState(boolean p0) {
                    RecentRecipientModel recentRecipientModel;
                    RecipientContract.Presenter recipientPresenter = SendMoneyActivity.this.getRecipientPresenter();
                    recentRecipientModel = SendMoneyActivity.this.scheduleImpl;
                    if (recentRecipientModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recentRecipientModel = null;
                    }
                    recipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2(true, recentRecipientModel, false);
                }
            }));
            authRequestContext.getAuthRequestContext = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$bottomSheetOnBoardingModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str2) {
                    BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1, String p2) {
                    if (!Intrinsics.areEqual(p2, "send_money")) {
                        if (Intrinsics.areEqual(p2, "favorite_quick_send")) {
                            SendMoneyActivity.access$checkShowOnBoardingFavoriteQuickAction(SendMoneyActivity.this, p0);
                        }
                    } else if (p0) {
                        SendMoneyActivity.access$openBottomSheetOnBoardingViewPage(SendMoneyActivity.this);
                    } else {
                        SendMoneyActivity.this.getBottomSheetOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("favorite_quick_send");
                    }
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
            authRequestContext.GetContactSyncConfig = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$initInjector$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str2) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str2) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }));
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            SendMoneyActivity sendMoneyActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = sendMoneyActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = "Send Money";
            authRequestContext.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            ScanQrModule.Builder authRequestContext2 = ScanQrModule.getAuthRequestContext();
            authRequestContext2.MyBillsEntityDataFactory = sendMoneyActivity;
            authRequestContext.initRecordTimeStamp = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext2, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = sendMoneyActivity;
            authRequestContext.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = sendMoneyActivity;
            authRequestContext.getErrorConfigVersion = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = sendMoneyActivity;
            authRequestContext.scheduleImpl = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            authRequestContext.BuiltInFictitiousFunctionClassFactory = (BillerX2BModule) Preconditions.getAuthRequestContext(new BillerX2BModule(new BillerX2BContract.View() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$billerX2BModule$1
                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<BillerX2B> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void PlaceComponentResult(BaseRecipientModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void PlaceComponentResult(boolean p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final /* synthetic */ void getAuthRequestContext(String str2) {
                    BillerX2BContract.View.CC.PlaceComponentResult(str2);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str2) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (SendMoneyActivity.this.isClickable()) {
                        new BillerX2BDialog(r0, new DialogInterface.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SendMoneyActivity.m2931$r8$lambda$n6WE9Vx06D4UMkwS7zqSsred8(SendMoneyActivity.this, p0, dialogInterface, i);
                            }
                        }).KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void getAuthRequestContext(BaseRecipientModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (SendMoneyActivity.this.isClickable() && (p0 instanceof RecipientModel)) {
                        SendMoneyActivity.access$openSummary(SendMoneyActivity.this, (RecipientModel) p0);
                    }
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if ((StringsKt.isBlank(p0) ^ true ? p0 : null) != null) {
                        DanaH5.startContainerFullUrl(p0);
                    }
                }
            }));
            authRequestContext.MyBillsEntityDataFactory = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$$ExternalSyntheticLambda0
                @Override // id.dana.h5event.CheckoutH5EventContract.View
                public final void getAuthRequestContext(boolean z) {
                    SendMoneyActivity.m2930$r8$lambda$eS5qXIjZrYI4lptlXZYQpnEpPU(SendMoneyActivity.this, z);
                }
            }));
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(sendMoneyActivity)));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.moveToNextValue, RecipientActivityModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, BottomSheetOnBoardingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.initRecordTimeStamp, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.lookAheadTest, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.scheduleImpl, OauthModule.class);
            if (authRequestContext.GetContactSyncConfig == null) {
                authRequestContext.GetContactSyncConfig = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2, SendMoneyLandingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, BillerX2BModule.class);
            if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SendMoneyTrackerModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, PlayStoreReviewModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, CheckoutH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            str = "Send Money";
            this.DatabaseTableConfigUtil = new DaggerSendMoneyLandingComponent.SendMoneyLandingComponentImpl(authRequestContext.moveToNextValue, authRequestContext.getAuthRequestContext, authRequestContext.PlaceComponentResult, authRequestContext.initRecordTimeStamp, authRequestContext.lookAheadTest, authRequestContext.getErrorConfigVersion, authRequestContext.scheduleImpl, authRequestContext.GetContactSyncConfig, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2, authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, authRequestContext.MyBillsEntityDataFactory, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        } else {
            str = "Send Money";
        }
        SendMoneyLandingComponent sendMoneyLandingComponent = this.DatabaseTableConfigUtil;
        if (sendMoneyLandingComponent != null) {
            sendMoneyLandingComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        registerPresenter(getRecipientPresenter(), getBottomSheetOnBoardingPresenter(), getReadDeepLinkPropertiesPresenter(), getKycAndDebitPayOptionPresenter(), getBillerX2BPresenter());
        SendMoneyScenarioModel sendMoneyScenarioModel = new SendMoneyScenarioModel(null, null, null, null, null, false, null, null, null, false, false, null, null, null, 16383, null);
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("recipientType") : null;
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullParameter(string, "");
        switch (string.hashCode()) {
            case -1482068345:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GROUPSEND)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "group";
                    break;
                }
                break;
            case -1420060106:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "phoneNumber";
                    break;
                }
                break;
            case -1088666555:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_OUTLET)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "outlet";
                    break;
                }
                break;
            case 757209410:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CASHOUT_WITHDRAW)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "external";
                    break;
                }
                break;
            case 785051764:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_BANK)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "bank";
                    break;
                }
                break;
            case 785087888:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CHAT)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "chat";
                    break;
                }
                break;
            case 1042376846:
                if (string.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GLOBAL)) {
                    sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2 = "globalTransfer";
                    break;
                }
                break;
        }
        if (PlaceComponentResult(sendMoneyScenarioModel)) {
            getKycAndDebitPayOptionPresenter().getAuthRequestContext((Object) sendMoneyScenarioModel);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        getBinding().PlaceComponentResult.setOnRecipientSelected(new SendMoneyActivity$setupRecentTransactionView$1(this));
        getBinding().PlaceComponentResult.setOnGestureHoldLongClickListener(new RecentTransactionView.GestureHoldClickListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$setupRecentTransactionView$2
            @Override // id.dana.sendmoney_v2.landing.view.RecentTransactionView.GestureHoldClickListener
            public final void BuiltInFictitiousFunctionClassFactory(RecentRecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendMoneyActivity.this.showManageAccountBottomSheet(p0);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnMenuSelected(new SendMoneyActivity$setupRecipientSelectorView$1(this));
        TrackerQRScanner.PlaceComponentResult(str);
        ((SendMoneyFeatureTime) this.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        getRecipientPresenter().getAuthRequestContext();
        getKycAndDebitPayOptionPresenter().PlaceComponentResult();
        getBottomSheetOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("send_money");
        getBinding().PlaceComponentResult.setRecentTransactionClickListener(new RecentTransactionView.RecentTransactionClickListener() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$initRecentTransactionView$1
            @Override // id.dana.sendmoney_v2.landing.view.RecentTransactionView.RecentTransactionClickListener
            public final void BuiltInFictitiousFunctionClassFactory(RecentRecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendMoneyActivity.this.getKycAndDebitPayOptionPresenter().getAuthRequestContext(p0);
            }

            @Override // id.dana.sendmoney_v2.landing.view.RecentTransactionView.RecentTransactionClickListener
            public final void getAuthRequestContext() {
                ActivitySendMoneyLandingBinding binding;
                KycAndDebitPayOptionContract.Presenter kycAndDebitPayOptionPresenter = SendMoneyActivity.this.getKycAndDebitPayOptionPresenter();
                binding = SendMoneyActivity.this.getBinding();
                RecentTransactionView recentTransactionView = binding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(recentTransactionView, "");
                kycAndDebitPayOptionPresenter.getAuthRequestContext(recentTransactionView);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney_v2.landing.SendMoneyActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SendMoneyActivity.access$getSendMoneyFeatureTime(SendMoneyActivity.this);
                Intrinsics.checkNotNullParameter("OPEN LANDING PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN LANDING PAGE");
                SendMoneyActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        String string = getString(R.string.bottom_on_boarding_send_money_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(this, new OnBoardingModel(string, "list", PlaceComponentResult(), "send_money", null, null, null, 112, null), true));
        getSendMoneyAnalyticTracker().MyBillsEntityDataFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:347:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x03a4 A[Catch: all -> 0x13f6, TryCatch #7 {all -> 0x13f6, blocks: (B:345:0x038a, B:349:0x03f9, B:348:0x03a4), top: B:567:0x038a }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0543 A[Catch: Exception -> 0x13f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x13f0, blocks: (B:377:0x04ef, B:379:0x0543), top: B:555:0x04ef }] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x076d A[Catch: all -> 0x13dc, TryCatch #22 {all -> 0x13dc, blocks: (B:385:0x074b, B:389:0x07c3, B:388:0x076d), top: B:596:0x074b }] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0a18  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0bef A[Catch: Exception -> 0x13c6, TRY_LEAVE, TryCatch #21 {Exception -> 0x13c6, blocks: (B:428:0x0ba1, B:430:0x0bef), top: B:594:0x0ba1 }] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0dab  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0e68  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x1220  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0e6e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r31) {
        /*
            Method dump skipped, instructions count: 5626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.SendMoneyActivity.onCreate(android.os.Bundle):void");
    }

    public final void showToastAfterDeleteAccountFromQuickSend(RecentRecipientModel recentRecipientModel) {
        String str;
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        ((ManageAccountBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).dismissAllowingStateLoss();
        ManageAccountContract.Presenter presenter = ((ManageAccountBottomSheet) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        if (recentRecipientModel.isLayoutRequested == 7) {
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            String string = getString(R.string.successfully_deleted_group);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToast.MyBillsEntityDataFactory(this, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, string);
            return;
        }
        if (recentRecipientModel.getAuthRequestContext != null && recentRecipientModel.PlaceComponentResult() != null) {
            str = TextUtil.MyBillsEntityDataFactory(recentRecipientModel.getAuthRequestContext, "\\*");
            if (str == null) {
                str = TextUtil.MyBillsEntityDataFactory(recentRecipientModel.PlaceComponentResult(), "\\*");
            }
        } else {
            str = recentRecipientModel.getErrorConfigVersion;
        }
        CustomToast customToast2 = CustomToast.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(getString(R.string.send_money_text_toast_remove_quick_action));
        CustomToast.MyBillsEntityDataFactory(this, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, sb.toString());
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda6 ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda4 ^ 4360990799332652212L))) ^ ((char) (getCallingPid ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (SubSequence ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
