package id.dana.animation;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.ComponentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.GriverParams;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.gol.AlipayPlusClientAutoDebit;
import com.iap.ac.android.gol.google.service.TopUpService;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.HomeTabActivity$swipeDelegateListener$2;
import id.dana.animation.KycAmlEddActivity;
import id.dana.animation.model.EddConsultModel;
import id.dana.animation.model.EddInfoModel;
import id.dana.animation.model.SnackbarEvent;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.tab.AppReadyConsumedProvider;
import id.dana.animation.tab.ConnectivitySnackbarListener;
import id.dana.animation.tab.HomeFragmentManager;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.animation.tab.HomeTabs;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.view.OnboardingState;
import id.dana.animation.worker.GetStorageInfoWorker;
import id.dana.backgroundwork.DeviceStatsReportWorker;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseFragment;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.challenge.ChallengeControl;
import id.dana.common.IntentKeySource;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.account.FirstTimeContract;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.danaviz.DanaVizPromptActivity;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.miniprogram.provider.DeeplinkServiceProvider;
import id.dana.data.model.DiagnosticLogException;
import id.dana.databinding.ActivityHomeTabBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerHomeTabActivityComponent;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.KycAmlEddModule;
import id.dana.di.modules.KycRenewalModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PaymentSettingModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.ReferralDialogModule;
import id.dana.di.modules.TncSummaryModules;
import id.dana.di.modules.UserConfigModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.KycAmlEddDialog;
import id.dana.dialog.KycRenewalDialog;
import id.dana.dialog.PaymentSettingSuccessDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.autoroute.model.AuthenticationTypeOption;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.kycamledd.model.EddConsult;
import id.dana.domain.kycrenewal.model.ShowDialogPreference;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.electronicmoney.RxEmoneyBus;
import id.dana.explore.model.TrackerExploreDanaOpen;
import id.dana.explore.view.ExploreDanaFragment;
import id.dana.extension.ContextExtKt;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.globalnetwork.GnTopUpSaveDataManager;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.globalnetwork.model.GnTopUpResultModel;
import id.dana.globalnetwork.tracker.GlobalNetworkTracker;
import id.dana.globalsearch.model.TrackerGlobalSearchOpen;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;
import id.dana.globalsearch.view.GlobalSearchActivity;
import id.dana.globalsearch.view.GlobalSearchFragment;
import id.dana.googleassistant.DanaGoogleAssistant;
import id.dana.googleplay.updates.DanaUpdateManager;
import id.dana.googleplay.updates.DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1;
import id.dana.kyb.model.KybPageInfo;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.KycAmlEddPresenter;
import id.dana.kycrenewal.KycRenewalContract;
import id.dana.kycrenewal.KycRenewalPresenter;
import id.dana.kycrenewal.KycRenewalPresenter$saveKYCRenewalButtonClick$1;
import id.dana.kycrenewal.KycRenewalPresenter$saveKYCRenewalButtonClick$2;
import id.dana.kycrenewal.model.QueryKYCRenewalStatusResponseModel;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.EddConsultToEddConsultModelMapperKt;
import id.dana.miniprogram.provider.TopUpServiceProvider;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.MyProfileMainFragment;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity;
import id.dana.myprofile.model.AuthenticationTypeOptionModel;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import id.dana.network.rpc.RpcLogging;
import id.dana.notification.NotificationData;
import id.dana.notification.NotificationDirector;
import id.dana.notification.NotificationDirectorFactory;
import id.dana.notificationcenter.views.NotificationCenterFragment;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog;
import id.dana.onboarding.referral.ReferralDialogContract;
import id.dana.onboarding.referral.model.ReferralEngagementDialogModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.pay.PayActivity;
import id.dana.paymentsetting.BottomSheetPaymentSettingFragment;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.performancetracker.IdleTimeUtil;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import id.dana.referral.MyReferralDetailActivity;
import id.dana.referral.view.ReferralEngagementDialog;
import id.dana.riskChallenges.ui.createpin.CreatePinLauncher;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinLauncher;
import id.dana.rum.Rum;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.ScannerFragment;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerFromViewType;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sharepay.SharePayManager;
import id.dana.social.FeedMaintenanceFragment;
import id.dana.social.FeedsFragment;
import id.dana.social.FeedsFragment$toFriendTab$1;
import id.dana.social.di.module.SocialCommonModule;
import id.dana.social.utils.FeedsContentAction;
import id.dana.social.utils.SaveContactSyncManagerKt;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.tncsummary.TncSummaryActivity;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.risk.RiskEventStrategy;
import id.dana.userconfig.UserConfigContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.util.IapConnectKtx;
import id.dana.util.RaspUtils;
import id.dana.utils.DANAToast;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ExtensionsKt;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.OSUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.RandomInteger;
import id.dana.utils.StringWrapper;
import id.dana.utils.UrlUtil;
import id.dana.utils.ViewHelper;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.ActivityPermissionRequestKt;
import id.dana.wallet_v3.view.NewWalletFragment;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000®\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¤\u00022\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\n¤\u0002¥\u0002¦\u0002§\u0002¨\u0002B\b¢\u0006\u0005\b£\u0002\u0010\u000eJ-\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u0010\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\u000eJ\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u000eJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0007\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u000b\u0010&J\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\u0004H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0015H\u0002¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0007\u001a\u00020\u001cH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0015H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u000200H\u0002¢\u0006\u0004\b,\u00101J\u0015\u00104\u001a\u00020\u00152\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0015H\u0002¢\u0006\u0004\b6\u0010+J\u000f\u00107\u001a\u00020\u0015H\u0002¢\u0006\u0004\b7\u0010+J\u0015\u00108\u001a\u00020\u00152\u0006\u00103\u001a\u000202¢\u0006\u0004\b8\u00105J\u0017\u00109\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u001cH\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b;\u0010+J!\u0010\u000b\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010<2\u0006\u0010\u0007\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u000b\u0010=J\r\u0010>\u001a\u00020\n¢\u0006\u0004\b>\u0010\u000eJ)\u0010B\u001a\u00020\n2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u0002022\b\u0010A\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\nH\u0016¢\u0006\u0004\bD\u0010\u000eJ\u0019\u0010G\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\nH\u0014¢\u0006\u0004\bI\u0010\u000eJ\u0019\u0010K\u001a\u00020\n2\b\u0010J\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\n2\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\nH\u0014¢\u0006\u0004\bQ\u0010\u000eJ\u0017\u0010S\u001a\u00020\n2\u0006\u0010N\u001a\u00020RH\u0007¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\n2\u0006\u0010N\u001a\u00020UH\u0007¢\u0006\u0004\bV\u0010WJ/\u0010\\\u001a\u00020\n2\u0006\u0010?\u001a\u0002022\u000e\u0010Y\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0X2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\nH\u0014¢\u0006\u0004\b^\u0010\u000eJ\u000f\u0010_\u001a\u00020\nH\u0014¢\u0006\u0004\b_\u0010\u000eJ\u000f\u0010`\u001a\u00020\nH\u0016¢\u0006\u0004\b`\u0010\u000eJ\u0017\u0010a\u001a\u00020\n2\u0006\u0010N\u001a\u000200H\u0007¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\nH\u0014¢\u0006\u0004\bc\u0010\u000eJ\u000f\u0010d\u001a\u00020\nH\u0014¢\u0006\u0004\bd\u0010\u000eJ\u000f\u0010e\u001a\u00020\nH\u0016¢\u0006\u0004\be\u0010\u000eJ\u000f\u0010f\u001a\u00020\nH\u0014¢\u0006\u0004\bf\u0010\u000eJ'\u00109\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020g2\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015H\u0002¢\u0006\u0004\b9\u0010hJ-\u0010,\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010<2\u0006\u0010\u0007\u001a\u00020\u001e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010iJ\u001d\u0010l\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u00152\u0006\u0010k\u001a\u00020\u0015¢\u0006\u0004\bl\u0010mJ\u0015\u0010o\u001a\u00020\n2\u0006\u0010n\u001a\u00020\u0015¢\u0006\u0004\bo\u0010\u0019J\u0015\u0010q\u001a\u00020\n2\u0006\u0010N\u001a\u00020p¢\u0006\u0004\bq\u0010rJ\r\u0010s\u001a\u00020\n¢\u0006\u0004\bs\u0010\u000eJ\r\u0010t\u001a\u00020\n¢\u0006\u0004\bt\u0010\u000eJ\r\u0010u\u001a\u00020\n¢\u0006\u0004\bu\u0010\u000eJ)\u0010y\u001a\u00020\n2\u0006\u0010v\u001a\u00020\u001c2\b\b\u0002\u0010w\u001a\u00020\u001c2\b\b\u0002\u0010x\u001a\u00020\u0015¢\u0006\u0004\by\u0010zJ\u000f\u0010{\u001a\u00020\nH\u0002¢\u0006\u0004\b{\u0010\u000eJ\r\u0010|\u001a\u00020\n¢\u0006\u0004\b|\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010}R)\u0010\u0084\u0001\u001a\u0004\u0018\u00010~8\u0007@\u0007X\u0086\u000e¢\u0006\u0016\n\u0004\b'\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0015\u0010\u000b\u001a\u00030\u0085\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b7\u0010\u0086\u0001R\u0016\u00109\u001a\u00030\u0087\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R1\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0018\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b{\u0010\u0092\u0001R\u0015\u0010,\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b;\u0010\u0093\u0001R\u001b\u0010*\u001a\b*\u00030\u0094\u00010\u0094\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0086\u0001R1\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u008c\u0001\u001a\u0006\b\u0098\u0001\u0010\u008e\u0001\"\u0006\b\u0099\u0001\u0010\u0090\u0001R1\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u008c\u0001\u001a\u0006\b\u009c\u0001\u0010\u008e\u0001\"\u0006\b\u009d\u0001\u0010\u0090\u0001R\u0015\u0010\u001f\u001a\u00020\u00158\u0002X\u0083\u0006¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010}R&\u0010¢\u0001\u001a\u00020\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010}\u001a\u0005\b \u0001\u0010+\"\u0005\b¡\u0001\u0010\u0019R.\u0010k\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010}\u001a\u0005\b¥\u0001\u0010+\"\u0005\b¦\u0001\u0010\u0019R*\u0010¨\u0001\u001a\u00030§\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R1\u0010¯\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¯\u0001\u0010\u008c\u0001\u001a\u0006\b°\u0001\u0010\u008e\u0001\"\u0006\b±\u0001\u0010\u0090\u0001R1\u0010³\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b³\u0001\u0010\u008c\u0001\u001a\u0006\b´\u0001\u0010\u008e\u0001\"\u0006\bµ\u0001\u0010\u0090\u0001R\u001a\u0010¹\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0015\u00106\u001a\u0002028CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b,\u0010º\u0001R\u0019\u0010'\u001a\u0005\u0018\u00010»\u00018CX\u0082\u0004¢\u0006\b\u001a\u0006\b¹\u0001\u0010¼\u0001R1\u0010¾\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¾\u0001\u0010\u008c\u0001\u001a\u0006\b¿\u0001\u0010\u008e\u0001\"\u0006\bÀ\u0001\u0010\u0090\u0001R*\u0010Â\u0001\u001a\u00030Á\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R/\u0010É\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0015\n\u0005\bÈ\u0001\u0010}\u001a\u0005\bÉ\u0001\u0010+\"\u0005\bÊ\u0001\u0010\u0019R&\u0010Ì\u0001\u001a\u00020\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\bË\u0001\u0010}\u001a\u0005\bÌ\u0001\u0010+\"\u0005\bÍ\u0001\u0010\u0019R\u0017\u0010{\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bÎ\u0001\u0010}R\u0015\u0010;\u001a\u00020\u00158CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010+R\u0017\u00107\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bÏ\u0001\u0010}R1\u0010Ñ\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bÑ\u0001\u0010\u008c\u0001\u001a\u0006\bÒ\u0001\u0010\u008e\u0001\"\u0006\bÓ\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R1\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030×\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bØ\u0001\u0010\u008c\u0001\u001a\u0006\bÙ\u0001\u0010\u008e\u0001\"\u0006\bÚ\u0001\u0010\u0090\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bÛ\u0001\u0010}R&\u0010ß\u0001\u001a\u00020\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\bÜ\u0001\u0010}\u001a\u0005\bÝ\u0001\u0010+\"\u0005\bÞ\u0001\u0010\u0019R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010à\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R*\u0010æ\u0001\u001a\u0004\u0018\u00010~8\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0005\bã\u0001\u0010\u007f\u001a\u0006\bä\u0001\u0010\u0081\u0001\"\u0006\bå\u0001\u0010\u0083\u0001R\u001a\u0010È\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bç\u0001\u0010Ö\u0001R1\u0010é\u0001\u001a\n\u0012\u0005\u0012\u00030è\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bé\u0001\u0010\u008c\u0001\u001a\u0006\bê\u0001\u0010\u008e\u0001\"\u0006\bë\u0001\u0010\u0090\u0001R \u0010ñ\u0001\u001a\u00030ì\u00018\u0001X\u0081\u0004¢\u0006\u0010\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001R\u0017\u0010\u009e\u0001\u001a\u00030ò\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\bó\u0001\u0010\u0086\u0001R1\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030ô\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bõ\u0001\u0010\u008c\u0001\u001a\u0006\bö\u0001\u0010\u008e\u0001\"\u0006\b÷\u0001\u0010\u0090\u0001R\"\u0010\u009f\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001c\u0018\u00010ø\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0018\u0010¤\u0001\u001a\u00030ì\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bû\u0001\u0010î\u0001R1\u0010ý\u0001\u001a\n\u0012\u0005\u0012\u00030ü\u00010\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bý\u0001\u0010\u008c\u0001\u001a\u0006\bþ\u0001\u0010\u008e\u0001\"\u0006\bÿ\u0001\u0010\u0090\u0001R\u001a\u0010Ë\u0001\u001a\u00030\u0080\u00028\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u001a\u0010Î\u0001\u001a\u00030\u0083\u00028\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001c\u0010Û\u0001\u001a\u0005\u0018\u00010\u0086\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\"\u0010Õ\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001b\u0018\u00010ø\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010ú\u0001R&\u0010\u008d\u0002\u001a\u00020\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0002\u0010}\u001a\u0005\b\u008b\u0002\u0010+\"\u0005\b\u008c\u0002\u0010\u0019R!\u0010\u0092\u0002\u001a\u00030\u008e\u00028GX\u0087\u0084\u0002¢\u0006\u0010\n\u0006\b\u008f\u0002\u0010\u0086\u0001\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\"\u0010Ï\u0001\u001a\r\u0012\b\u0012\u0006*\u00020\u001b0\u001b0ø\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0093\u0002\u0010ú\u0001R1\u0010\u0095\u0002\u001a\n\u0012\u0005\u0012\u00030\u0094\u00020\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0095\u0002\u0010\u008c\u0001\u001a\u0006\b\u0096\u0002\u0010\u008e\u0001\"\u0006\b\u0097\u0002\u0010\u0090\u0001R\u0017\u0010Ü\u0001\u001a\u00030\u0098\u0002X\u0083\u0080\u0002¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u0086\u0001R\u001c\u0010ç\u0001\u001a\u0005\u0018\u00010\u009a\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R1\u0010\u009e\u0002\u001a\n\u0012\u0005\u0012\u00030\u009d\u00020\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009e\u0002\u0010\u008c\u0001\u001a\u0006\b\u009f\u0002\u0010\u008e\u0001\"\u0006\b \u0002\u0010\u0090\u0001R\u0017\u0010ã\u0001\u001a\u00030¡\u0002X\u0083\u0080\u0002¢\u0006\b\n\u0006\b¢\u0002\u0010\u0086\u0001"}, d2 = {"Lid/dana/home/HomeTabActivity;", "Lid/dana/home/tab/AppReadyConsumedProvider;", "Lid/dana/home/OnResumeInterceptor;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityHomeTabBinding;", "", "p0", "p1", "", "p2", "", "PlaceComponentResult", "(FFJ)V", "checkGnTopUpFlow", "()V", "checkNotificationPermission", "BuiltInFictitiousFunctionClassFactory", "dismissDanaLoadingDialog", "dismissLoadingDialogIfNeeded", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "MyBillsEntityDataFactory", "(Z)V", "finish", "Landroid/content/Intent;", "", "(Landroid/content/Intent;)Ljava/lang/String;", "Lid/dana/kyb/model/KybPageInfo;", "getErrorConfigVersion", "()Lid/dana/kyb/model/KybPageInfo;", "getUserCohort", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", IAPSyncCommand.COMMAND_INIT, "(Ljava/lang/String;Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "initViewBinding", "()Lid/dana/databinding/ActivityHomeTabBinding;", "scheduleImpl", "()Z", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Z", "isConsumed", "()Ljava/lang/Boolean;", "Lid/dana/home/HomeTabActivity$OnBackToHomepageMessageEvent;", "(Lid/dana/home/HomeTabActivity$OnBackToHomepageMessageEvent;)Z", "", "position", "isExploreDanaFragment", "(I)Z", "lookAheadTest", "initRecordTimeStamp", "isGlobalSearchFragment", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/home/tab/HomeTabs;", "(Lid/dana/home/tab/HomeTabs;Z)Z", "nextOnboardingStep", RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$OpenDeeplinkMessageEvent;", "event", "onOpenDeeplink", "(Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$OpenDeeplinkMessageEvent;)V", "onPause", "Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$MessageEvent;", "onReceiveDeeplinkServiceMessageEvent", "(Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$MessageEvent;)V", "Lid/dana/danah5/DanaH5$CheckAppUpdatesMessageEvent;", "onReceiveUpdateRequest", "(Lid/dana/danah5/DanaH5$CheckAppUpdatesMessageEvent;)V", "", RequestPermission.PERMISSIONS, "", RequestPermission.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onRestart", "onResume", "onResumeFromFragment", "onReturnToHomepage", "(Lid/dana/home/HomeTabActivity$OnBackToHomepageMessageEvent;)V", "onStart", "onStop", "onUserInteraction", "onUserLeaveHint", "Lid/dana/domain/profilemenu/model/SettingModel;", "(Lid/dana/domain/profilemenu/model/SettingModel;ZZ)V", "(Lid/dana/home/tab/HomeTabs;Lid/dana/kyb/model/KybPageInfo;Ljava/lang/String;)V", "feedEnabled", "feedRevamp", "setFeedEnabledAndFeedRevamp", "(ZZ)V", "swipeAble", "setSwipeable", "Lid/dana/home/model/SnackbarEvent;", "showCustomToast", "(Lid/dana/home/model/SnackbarEvent;)V", "showDanaLoadingDialog", "showDeeplinkErrorDialog", "showDefaultNotificationPage", "source", FeatureParams.SHOP_ID, "ignoreDismissRule", "showMerchantReview", "(Ljava/lang/String;Ljava/lang/String;Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "startOnBoardingProcess", "Z", "Lid/dana/home/HomeTabActivity$PaymentSettingListener;", "Lid/dana/home/HomeTabActivity$PaymentSettingListener;", "getAutoRouteListener", "()Lid/dana/home/HomeTabActivity$PaymentSettingListener;", "setAutoRouteListener", "(Lid/dana/home/HomeTabActivity$PaymentSettingListener;)V", "autoRouteListener", "Lid/dana/paymentsetting/BottomSheetPaymentSettingFragment;", "Lkotlin/Lazy;", "Lid/dana/riskChallenges/ui/createpin/CreatePinLauncher;", "DatabaseTableConfigUtil", "Ldagger/Lazy;", "Lid/dana/contract/contact/DanaContactContract$Presenter;", "danaContactPresenter", "Ldagger/Lazy;", "getDanaContactPresenter", "()Ldagger/Lazy;", "setDanaContactPresenter", "(Ldagger/Lazy;)V", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "J", "Lid/dana/dialog/DialogWithImage;", "GetContactSyncConfig", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "deeplinkReader", "getDeeplinkReader", "setDeeplinkReader", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "getDynamicUrlWrapper", "setDynamicUrlWrapper", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "getEnableGlobalSearch", "setEnableGlobalSearch", "enableGlobalSearch", "value", "NetworkUserEntityData$$ExternalSyntheticLambda8", "getFeedRevamp", "setFeedRevamp", "Lid/dana/social/utils/FeedsContentAction;", "feedsContentAction", "Lid/dana/social/utils/FeedsContentAction;", "getFeedsContentAction", "()Lid/dana/social/utils/FeedsContentAction;", "setFeedsContentAction", "(Lid/dana/social/utils/FeedsContentAction;)V", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "globalNetworkPresenter", "getGlobalNetworkPresenter", "setGlobalNetworkPresenter", "Lid/dana/globalnetwork/tracker/GlobalNetworkTracker;", "globalNetworkTracker", "getGlobalNetworkTracker", "setGlobalNetworkTracker", "Lid/dana/home/HomeFragmentStateAdapter;", "PrepareContext", "Lid/dana/home/HomeFragmentStateAdapter;", "moveToNextValue", "()I", "Lid/dana/home/tab/HomeTabFragment;", "()Lid/dana/home/tab/HomeTabFragment;", "Lid/dana/home/presenter/HomeTabContract$Presenter;", "homeTabPresenter", "getHomeTabPresenter", "setHomeTabPresenter", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "Lid/dana/home/tracker/HomeTrackerImpl;", "getHomeTrackerImpl", "()Lid/dana/home/tracker/HomeTrackerImpl;", "setHomeTrackerImpl", "(Lid/dana/home/tracker/HomeTrackerImpl;)V", "isLayoutRequested", "isFeedMaintenance", "setFeedMaintenance", "FragmentBottomSheetPaymentSettingBinding", "isFinishCheckSession", "setFinishCheckSession", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/kycamledd/KycAmlEddPresenter;", "kycAmlEddPresenter", "getKycAmlEddPresenter", "setKycAmlEddPresenter", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lid/dana/kycrenewal/KycRenewalPresenter;", "kycRenewalPresenter", "getKycRenewalPresenter", "setKycRenewalPresenter", "NetworkUserEntityData$$ExternalSyntheticLambda4", "whenAvailable", "getOnFinishCheckSessionNotCalled", "setOnFinishCheckSessionNotCalled", "onFinishCheckSessionNotCalled", "Lid/dana/home/OnboardingOrchestrator;", "getSupportButtonTintMode", "Lid/dana/home/OnboardingOrchestrator;", "readMicros", "getPaymentAuthListener", "setPaymentAuthListener", "paymentAuthListener", "getCallingPid", "Lid/dana/paymentsetting/PaymentSettingContract$Presenter;", "paymentSettingPresenter", "getPaymentSettingPresenter", "setPaymentSettingPresenter", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "SubSequence", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getPhonePermission$app_productionRelease", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "phonePermission", "Lid/dana/onboarding/bottomsheet/DanaConfirmationBottomSheetDialog;", "C", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "playStoreReviewPresenter", "getPlayStoreReviewPresenter", "setPlayStoreReviewPresenter", "Landroidx/activity/result/ActivityResultLauncher;", "A", "Landroidx/activity/result/ActivityResultLauncher;", DiskFormatter.B, "Lid/dana/onboarding/referral/ReferralDialogContract$Presenter;", "referralDialogPresenter", "getReferralDialogPresenter", "setReferralDialogPresenter", "Lid/dana/referral/view/ReferralEngagementDialog;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/referral/view/ReferralEngagementDialog;", "Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;", "Lio/reactivex/disposables/Disposable;", SummaryActivity.DAYS, "Lio/reactivex/disposables/Disposable;", "getOnBoardingScenario", "VerifyPinStateManager$executeRiskChallenge$2$2", "getShowShareFeedBottomSheet", "setShowShareFeedBottomSheet", "showShareFeedBottomSheet", "Lid/dana/home/SwipeDelegateListener;", "E", "getSwipeDelegateListener", "()Lid/dana/home/SwipeDelegateListener;", "swipeDelegateListener", "getValueOfTouchPositionAbsolute", "Lid/dana/tncsummary/TncSummaryContract$Presenter;", "tncSummaryPresenter", "getTncSummaryPresenter", "setTncSummaryPresenter", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "I", "Lid/dana/googleplay/updates/DanaUpdateManager;", DiskFormatter.GB, "Lid/dana/googleplay/updates/DanaUpdateManager;", "Lid/dana/userconfig/UserConfigContract$Presenter;", "userConfigPresenter", "getUserConfigPresenter", "setUserConfigPresenter", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", LogConstants.RESULT_FALSE, "<init>", "Companion", "FinishSubActivitiesMessageEvent", "OnBackToHomepageMessageEvent", "PaymentSettingListener", "SwitchFragment"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeTabActivity extends ViewBindingActivity<ActivityHomeTabBinding> implements AppReadyConsumedProvider, OnResumeInterceptor {
    public static final String AC_CODE_VALUE = "ACCodeValue";
    public static final String DEEPLINK_PAYMENT_PATH = "/pay";
    public static final String DEEPLINK_WALLET_PATH = "/wallet";
    public static final String EXTRA_IGNORE_DISMISS_RULE = "ignoredismissrule";
    public static final String EXTRA_SHOP_ID = "shopid";
    public static final String EXTRA_SOURCE = "source";
    public static final String NEW_REGISTERED_USER = "NEW_REGISTERED_USER";
    public static final String OAUTH_LOADING_VALUE = "oauthvalue";
    public static final String WALLET_SECTION = "section";

    /* renamed from: A  reason: from kotlin metadata */
    private ActivityResultLauncher<String> newProxyInstance;

    /* renamed from: B */
    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private ReferralEngagementDialog FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: C  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: D */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: E  reason: from kotlin metadata */
    private final Lazy swipeDelegateListener;

    /* renamed from: F */
    private final Lazy readMicros;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean isFinishCheckSession;

    /* renamed from: G */
    private DanaUpdateManager getCallingPid;

    /* renamed from: I  reason: from kotlin metadata */
    private final Lazy whenAvailable;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private PaymentSettingListener autoRouteListener;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private DanaLoadingDialog MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final long getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private MaterialDialog GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean feedRevamp;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private HomeFragmentStateAdapter moveToNextValue;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final ActivityPermissionRequest phonePermission;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private ReferralEngagementDialogModel NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private boolean showShareFeedBottomSheet;
    @Inject
    public dagger.Lazy<DanaContactContract.Presenter> danaContactPresenter;
    @Inject
    public dagger.Lazy<ReadLinkPropertiesContract.Presenter> deeplinkReader;
    @Inject
    public dagger.Lazy<DynamicUrlWrapper> dynamicUrlWrapper;
    @Inject
    public FeedsContentAction feedsContentAction;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private MaterialDialog isLayoutRequested;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private OnboardingOrchestrator PrepareContext;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> NetworkUserEntityData$$ExternalSyntheticLambda6;
    @Inject
    public dagger.Lazy<GlobalNetworkContract.Presenter> globalNetworkPresenter;
    @Inject
    public dagger.Lazy<GlobalNetworkTracker> globalNetworkTracker;
    @Inject
    public dagger.Lazy<HomeTabContract.Presenter> homeTabPresenter;
    @Inject
    public HomeTrackerImpl homeTrackerImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean isFeedMaintenance;
    @Inject
    public dagger.Lazy<KycAmlEddPresenter> kycAmlEddPresenter;
    @Inject
    public dagger.Lazy<KycRenewalPresenter> kycRenewalPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean enableGlobalSearch;
    @Inject
    public dagger.Lazy<PaymentSettingContract.Presenter> paymentSettingPresenter;
    @Inject
    public dagger.Lazy<PlayStoreReviewContract.Presenter> playStoreReviewPresenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private PaymentSettingListener paymentAuthListener;
    @Inject
    public dagger.Lazy<ReferralDialogContract.Presenter> referralDialogPresenter;
    @Inject
    public dagger.Lazy<TncSummaryContract.Presenter> tncSummaryPresenter;
    @Inject
    public dagger.Lazy<UserConfigContract.Presenter> userConfigPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean onFinishCheckSessionNotCalled;
    public static final byte[] $$j = {83, 16, 71, 115, 3, TarHeader.LF_BLK, -56, 1, -15, 11, TarHeader.LF_LINK, -72, 4, 9, -18, -4, 6, -2, 10, -19, -9, 73, -40, -28, 9, 14, -36, 6, -2, 10, -19, -9, TarHeader.LF_FIFO, -36, -19, 9, -15, 11, -13, -7};
    public static final int $$k = 88;
    public static final byte[] $$a = {112, 91, -28, 61, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 154;
    public static final byte[] getAuthRequestContext = {Ascii.ETB, -59, 18, 83, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 145;
    private static long H = 8404011787469291121L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy scheduleImpl = LazyKt.lazy(new Function0<DialogWithImage>() { // from class: id.dana.home.HomeTabActivity$deeplinkErrorDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DialogWithImage invoke() {
            DialogWithImage.Builder builder = new DialogWithImage.Builder();
            builder.MyBillsEntityDataFactory = R.drawable.ic_general_error_somethings_wrong;
            builder.moveToNextValue = HomeTabActivity.this.getString(R.string.deeplink_error_title);
            builder.PlaceComponentResult = HomeTabActivity.this.getString(R.string.deeplink_error_description);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = HomeTabActivity.this.getString(R.string.deeplink_error_button);
            return new DialogWithImage(HomeTabActivity.this, builder.lookAheadTest, builder, (byte) 0);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/home/HomeTabActivity$PaymentSettingListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface PaymentSettingListener {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x002f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x002f -> B:59:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = 3 - r6
            int r7 = r7 * 4
            int r7 = r7 + 37
            int r8 = r8 * 3
            int r8 = 105 - r8
            byte[] r0 = id.dana.animation.HomeTabActivity.$$j
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + (-2)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeTabActivity.a(short, int, byte, java.lang.Object[]):void");
    }

    public static final /* synthetic */ void access$setupActivityData(HomeTabActivity homeTabActivity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0024 -> B:59:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.animation.HomeTabActivity.getAuthRequestContext
            int r6 = r6 + 16
            int r7 = r7 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2c
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2c:
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeTabActivity.c(short, int, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntentFromDeeplink(Context context, String str) {
        return Companion.PlaceComponentResult(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0026 -> B:59:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 47 - r7
            byte[] r0 = id.dana.animation.HomeTabActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeTabActivity.k(byte, byte, short, java.lang.Object[]):void");
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
        b(Color.alpha(0) + 64871, new char[]{44883, 21051, 21912, 22389, 23233, 23640, 24380, 17101, 17509, 18398, 18714, 19471, 20372, 29030, 29939, 30302, 31025, 31894}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(24877 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{44895, 52838, 27965, 36060, 11234}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(41443 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{44805, 3762, 60610, 19107, 10382, 34361, 25689, 49727, 40989, 8108, 64911, 23445, 14835, 38791, 30057, 54089, 45363, 28432, 52978, 44170, 2794, 59598, 18131, 9313, 33310, 24618, 56836, 48551, 7124, 63969, 22473, 13610, 37739, 28999, 12070, 36098, 27832, 51908, 43192, 1687, 58493, 16911, 8248, 40485, 31828, 56294, 47566, 6138}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 28868, new char[]{44883, 57284, 20098, 64799, 27736, 40132, 2960, 47711, 10574, 22922, 51349, 30566, 58994, 5860, 34217, 13419, 41776, 54259, 17122, 61818, 24682, 37116, 8134, 36484, 15692, 44123, 56517, 19398, 64094, 26945, 39386, 2205, 46897, 9845, 22240, 50595, 29757, 58238, 5104, 33460, 12671, 41017, 53417, 24514, 52949, 32066, 60425, 7368, 35729, 14930, 43283, 55762, 18583, 63322, 26144, 38630, 1450, 46184, 9087, 21409, 49847, 29053, 57452, 4348}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 46410, new char[]{44800, 6728, 50625, 45233, 31271, 9586, 37058, 23051, 1362, 61609, 48100, 25914, 53383, 39886, 17688, 12384, 64483, 42668, 4160, 56263, 34524, 28791, 15137, 59068, 20493, 6919, 50837, 45539, 31584, 9771, 37327, 23364, 1637, 61949, 48374, 26187, 53724, 40146, 17958, 12647, 64690, 42583, 4429, 56479, 34798, 28973, 15401, 59285, 20804, 7248, 51191, 45734, 31804, 10116, 37510, 23578, 1901, 62132, 48629, 26445, 53952, 40408, 18221, 12926}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(2856 - ImageFormat.getBitsPerPixel(0), new char[]{44890, 42095, 47380, 36409, 33765, 39109, 60907, 57602, 63006, 52002, 49350, 54672, 10992, 15955, 13156, 2087, 7623, 4842, 26532, 31578, 28775, 17692, 23232, 44979, 42125, 47174, 36217, 33299, 38698, 60644, 57741, 63152, 51827, 57097, 54309, 10631, 16021, 13232, 1865, 7202, 4411, 26323, 31713, 28926, 17495, 22889, 44555, 41936, 47345, 36255, 33055, 38511, 60244, 57440, 62961, 51851, 57263, 54141, 10252, 15666}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(30448 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{44811, 55789, 17124, 52175, 29892, 64950}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                c(b, (byte) (b | 36), getAuthRequestContext[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                c(b2, (byte) (b2 | Ascii.NAK), (byte) (getAuthRequestContext[32] - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16777271, 3 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Color.alpha(0));
                        Object[] objArr16 = new Object[1];
                        k($$a[78], $$a[53], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 752, 15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.blue(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), Color.argb(0, 0, 0, 0) + 15, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 29 - View.getDefaultSize(0, 0), (char) (57994 - (ViewConfiguration.getTouchSlop() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), 15 - KeyEvent.normalizeMetaState(0), (char) TextUtils.getOffsetAfter("", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {325994962, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                c(b3, (byte) (b3 | 36), getAuthRequestContext[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                c(b4, (byte) (b4 | Ascii.NAK), (byte) (getAuthRequestContext[32] - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.indexOf("", ""), 47 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        k((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {325994962, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, Color.rgb(0, 0, 0) + 16777234, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                c(b5, (byte) (b5 | 36), getAuthRequestContext[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                c(b6, (byte) (b6 | Ascii.NAK), (byte) (getAuthRequestContext[32] - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 118, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) (38968 - (Process.myTid() >> 22)));
                        Object[] objArr28 = new Object[1];
                        k((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {325994962, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), TextUtils.indexOf("", "", 0, 0) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                c(b7, (byte) (b7 | 36), getAuthRequestContext[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                c(b8, (byte) (b8 | Ascii.NAK), (byte) (getAuthRequestContext[32] - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getPressedStateDuration() >> 16), 2 - ExpandableListView.getPackedPositionChild(0L), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        k($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 36, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {325994962, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public HomeTabActivity() {
        HomeTabActivity homeTabActivity = this;
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) homeTabActivity);
        String[] strArr = {"android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.home.HomeTabActivity$readPhoneStatePermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                HomeTabFragment moveToNextValue;
                Intrinsics.checkNotNullParameter(p0, "");
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                HomeTabFragment homeTabFragment = moveToNextValue instanceof ConnectivitySnackbarListener ? moveToNextValue : null;
                if (homeTabFragment != null) {
                    homeTabFragment.BuiltInFictitiousFunctionClassFactory();
                }
                HomeTabActivity.this.nextOnboardingStep();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionCallback.CC.getAuthRequestContext(p0);
                HomeTabActivity.this.nextOnboardingStep();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = builder.PlaceComponentResult();
        this.whenAvailable = LazyKt.lazy(new Function0<UiComponent>() { // from class: id.dana.home.HomeTabActivity$uiComponentChangePIN$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UiComponent invoke() {
                return new UiComponent(UIComponentType.Full, R.color.f27072131100488, R.string.change_pin);
            }
        });
        this.readMicros = LazyKt.lazy(new Function0<VerifyPinLauncher>() { // from class: id.dana.home.HomeTabActivity$verifyPinLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyPinLauncher invoke() {
                VerifyPinLauncher.Builder builder2 = new VerifyPinLauncher.Builder(HomeTabActivity.this);
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("MODIFY_PASSWORD", null, null, 6, null);
                Intrinsics.checkNotNullParameter(useCaseStrategy, "");
                builder2.PlaceComponentResult = useCaseStrategy;
                Intrinsics.checkNotNullParameter("RESET_PASSWORD", "");
                builder2.getAuthRequestContext = "RESET_PASSWORD";
                Intrinsics.checkNotNullParameter("Change PIN", "");
                builder2.BuiltInFictitiousFunctionClassFactory = "Change PIN";
                UiComponent access$getUiComponentChangePIN = HomeTabActivity.access$getUiComponentChangePIN(HomeTabActivity.this);
                Intrinsics.checkNotNullParameter(access$getUiComponentChangePIN, "");
                builder2.scheduleImpl = access$getUiComponentChangePIN;
                final HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.home.HomeTabActivity$verifyPinLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Parcelable parcelable;
                        SecurityInfoModel placeComponentResult;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        String str = null;
                        if (Build.VERSION.SDK_INT >= 33) {
                            parcelable = (Parcelable) bundle.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
                        } else {
                            Parcelable parcelable2 = bundle.getParcelable("KEY_DATA_RISK_CONSULT");
                            if (!(parcelable2 instanceof BasicRiskChallengesModel)) {
                                parcelable2 = null;
                            }
                            parcelable = (BasicRiskChallengesModel) parcelable2;
                        }
                        BasicRiskChallengesModel basicRiskChallengesModel = (BasicRiskChallengesModel) parcelable;
                        String string = bundle.getString("KEY_PHONE_NUMBER");
                        CreatePinLauncher access$getCreatePinLauncher = HomeTabActivity.access$getCreatePinLauncher(HomeTabActivity.this);
                        if (string == null) {
                            string = "";
                        }
                        Intrinsics.checkNotNullParameter(string, "");
                        access$getCreatePinLauncher.PlaceComponentResult = string;
                        String kClassImpl$Data$declaredNonStaticMembers$2 = basicRiskChallengesModel != null ? basicRiskChallengesModel.getKClassImpl$Data$declaredNonStaticMembers$2() : null;
                        if (kClassImpl$Data$declaredNonStaticMembers$2 == null) {
                            kClassImpl$Data$declaredNonStaticMembers$2 = "";
                        }
                        Intrinsics.checkNotNullParameter(kClassImpl$Data$declaredNonStaticMembers$2, "");
                        access$getCreatePinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = kClassImpl$Data$declaredNonStaticMembers$2;
                        if (basicRiskChallengesModel != null && (placeComponentResult = basicRiskChallengesModel.getPlaceComponentResult()) != null) {
                            str = placeComponentResult.MyBillsEntityDataFactory;
                        }
                        if (str == null) {
                            str = "";
                        }
                        Intrinsics.checkNotNullParameter(str, "");
                        access$getCreatePinLauncher.BuiltInFictitiousFunctionClassFactory = str;
                        access$getCreatePinLauncher.BuiltInFictitiousFunctionClassFactory();
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder2.getErrorConfigVersion = function1;
                return builder2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<CreatePinLauncher>() { // from class: id.dana.home.HomeTabActivity$createPinLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreatePinLauncher invoke() {
                CreatePinLauncher.Builder builder2 = new CreatePinLauncher.Builder(HomeTabActivity.this);
                Intrinsics.checkNotNullParameter("Change PIN", "");
                builder2.BuiltInFictitiousFunctionClassFactory = "Change PIN";
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("MODIFY_PASSWORD", null, null, 6, null);
                Intrinsics.checkNotNullParameter(useCaseStrategy, "");
                builder2.KClassImpl$Data$declaredNonStaticMembers$2 = useCaseStrategy;
                UiComponent access$getUiComponentChangePIN = HomeTabActivity.access$getUiComponentChangePIN(HomeTabActivity.this);
                Intrinsics.checkNotNullParameter(access$getUiComponentChangePIN, "");
                builder2.scheduleImpl = access$getUiComponentChangePIN;
                final HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.home.HomeTabActivity$createPinLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "");
                        HomeTabActivity.this.getHomeTrackerImpl().getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.PIN_CREATE_COMPLETE, new Pair[]{TuplesKt.to("Source", "Change PIN")});
                        HomeTabActivity.this.getHomeTabPresenter().get().BuiltInFictitiousFunctionClassFactory();
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder2.getErrorConfigVersion = function1;
                return builder2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<BottomSheetPaymentSettingFragment>() { // from class: id.dana.home.HomeTabActivity$bottomSheetPaymentSettingFragment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetPaymentSettingFragment invoke() {
                return new BottomSheetPaymentSettingFragment();
            }
        });
        this.initRecordTimeStamp = true;
        ActivityPermissionRequest.Builder builder2 = new ActivityPermissionRequest.Builder((ComponentActivity) homeTabActivity);
        String[] strArr2 = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.PlaceComponentResult = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.home.HomeTabActivity$phonePermission$1
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
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(HomeTabActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.getAuthRequestContext = permissionCallback2;
        this.phonePermission = builder2.PlaceComponentResult();
        this.swipeDelegateListener = LazyKt.lazy(new Function0<HomeTabActivity$swipeDelegateListener$2.AnonymousClass1>() { // from class: id.dana.home.HomeTabActivity$swipeDelegateListener$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $PlaceComponentResult = 0;
            private static int $getErrorConfigVersion = 1;
            private static char BuiltInFictitiousFunctionClassFactory = 60394;
            private static char KClassImpl$Data$declaredNonStaticMembers$2 = 1600;
            private static char MyBillsEntityDataFactory = 4546;
            private static char getAuthRequestContext = 42266;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
                int i = $getErrorConfigVersion + 41;
                $PlaceComponentResult = i % 128;
                int i2 = i % 2;
                AnonymousClass1 invoke = invoke();
                int i3 = $PlaceComponentResult + 21;
                $getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return invoke;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.home.HomeTabActivity$swipeDelegateListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                ?? r0 = new SwipeDelegateListener() { // from class: id.dana.home.HomeTabActivity$swipeDelegateListener$2.1
                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void getAuthRequestContext() {
                        ActivityHomeTabBinding binding;
                        boolean z;
                        HomeFragmentStateAdapter homeFragmentStateAdapter;
                        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
                        FirstActionTracker.MyBillsEntityDataFactory();
                        binding = HomeTabActivity.this.getBinding();
                        ViewPager2 viewPager2 = binding.PlaceComponentResult;
                        HomeTabActivity homeTabActivity3 = HomeTabActivity.this;
                        z = homeTabActivity3.getErrorConfigVersion;
                        if (z) {
                            homeFragmentStateAdapter = homeTabActivity3.moveToNextValue;
                            if (homeFragmentStateAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                homeFragmentStateAdapter = null;
                            }
                            BaseFragment baseFragment = 2 >= homeFragmentStateAdapter.getAuthRequestContext.size() ? null : homeFragmentStateAdapter.getAuthRequestContext.get(2);
                            if (baseFragment instanceof FeedsFragment) {
                                ((FeedsFragment) baseFragment).PlaceComponentResult((String) null);
                            }
                            SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(homeTabActivity3);
                        }
                        viewPager2.setCurrentItem(2);
                    }

                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, boolean p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        HomeTabActivity.this.initRecordTimeStamp = false;
                        PlaceComponentResult(p1, new Function1<FeedsFragment, Unit>() { // from class: id.dana.home.HomeTabActivity$swipeDelegateListener$2$1$onSwipeRightToFriendsFeed$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(FeedsFragment feedsFragment) {
                                invoke2(feedsFragment);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(FeedsFragment feedsFragment) {
                                Intrinsics.checkNotNullParameter(feedsFragment, "");
                                FeedsFragment$toFriendTab$1 feedsFragment$toFriendTab$1 = new FeedsFragment$toFriendTab$1(p0);
                                if (feedsFragment.BuiltInFictitiousFunctionClassFactory) {
                                    feedsFragment$toFriendTab$1.invoke((FeedsFragment$toFriendTab$1) feedsFragment);
                                } else {
                                    feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2.add(feedsFragment$toFriendTab$1);
                                }
                            }
                        });
                    }

                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        ActivityResultLauncher activityResultLauncher;
                        HomeTabActivity.this.initRecordTimeStamp = false;
                        TrackerQRScanner.PlaceComponentResult(HomeTabActivity.this.getEnableGlobalSearch() ? "Home" : TrackerKey.SourceType.SWIPE);
                        Intent intent = new Intent(HomeTabActivity.this, ScannerActivity.class);
                        if (HomeTabActivity.this.getEnableGlobalSearch()) {
                            intent.putExtra(ScannerActivity.FROM_VIEW_TYPE, ScannerFromViewType.FOUR_KINGKONG);
                        }
                        activityResultLauncher = HomeTabActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        if (activityResultLauncher != null) {
                            activityResultLauncher.MyBillsEntityDataFactory(intent, null);
                        }
                    }

                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        ActivityHomeTabBinding binding;
                        HomeTabActivity.this.initRecordTimeStamp = false;
                        binding = HomeTabActivity.this.getBinding();
                        binding.PlaceComponentResult.setCurrentItem(HomeTabActivity.access$getHomeIndex(HomeTabActivity.this));
                    }

                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void getAuthRequestContext(final String p0, boolean p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        HomeTabActivity.this.initRecordTimeStamp = p1;
                        PlaceComponentResult(false, new Function1<FeedsFragment, Unit>() { // from class: id.dana.home.HomeTabActivity$swipeDelegateListener$2$1$onSwipeRightToMeFeed$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(FeedsFragment feedsFragment) {
                                invoke2(feedsFragment);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(FeedsFragment feedsFragment) {
                                Intrinsics.checkNotNullParameter(feedsFragment, "");
                                feedsFragment.PlaceComponentResult(p0);
                            }
                        });
                    }

                    @Override // id.dana.animation.SwipeDelegateListener
                    public final void MyBillsEntityDataFactory(String p0) {
                        if (HomeTabActivity.this.getEnableGlobalSearch()) {
                            HomeTabActivity.this.startActivity(new Intent(HomeTabActivity.this.getApplicationContext(), GlobalSearchActivity.class));
                            TrackerGlobalSearchOpen.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                        }
                        if (HomeTabActivity.this.isExploreDanaFragment(0)) {
                            TrackerExploreDanaOpen.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.SWIPE_RIGHT);
                        }
                    }

                    private final void PlaceComponentResult(boolean p0, Function1<? super FeedsFragment, Unit> p1) {
                        ActivityHomeTabBinding binding;
                        boolean z;
                        HomeFragmentStateAdapter homeFragmentStateAdapter;
                        binding = HomeTabActivity.this.getBinding();
                        ViewPager2 viewPager2 = binding.PlaceComponentResult;
                        HomeTabActivity homeTabActivity3 = HomeTabActivity.this;
                        z = homeTabActivity3.getErrorConfigVersion;
                        if (z || p0) {
                            homeFragmentStateAdapter = homeTabActivity3.moveToNextValue;
                            if (homeFragmentStateAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                homeFragmentStateAdapter = null;
                            }
                            BaseFragment baseFragment = 2 < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(2) : null;
                            if (baseFragment instanceof FeedsFragment) {
                                p1.invoke(baseFragment);
                            }
                        }
                        viewPager2.setCurrentItem(2);
                    }
                };
                int i = $getErrorConfigVersion + 125;
                $PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return r0;
            }

            public static void $$a(long j, long j2) {
                long j3 = j ^ (j2 << 32);
                Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                a(6 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{30254, 20509, 15686, 790, 53398, 53246}, objArr);
                sb.append((String) objArr[0]);
                sb.append(j3);
                String obj = sb.toString();
                Intrinsics.checkNotNullParameter(obj, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
                RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
                Intrinsics.checkNotNullParameter(dexguardException, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
                RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED);
                UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.ROOTED);
                int i = $PlaceComponentResult + 33;
                $getErrorConfigVersion = i % 128;
                if ((i % 2 == 0 ? (char) 5 : '\\') != '\\') {
                    int i2 = 81 / 0;
                }
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                C c = new C();
                char[] cArr2 = new char[cArr.length];
                c.BuiltInFictitiousFunctionClassFactory = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 1 : '6') == 1) {
                        cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                        cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                        int i2 = 58224;
                        int i3 = 0;
                        while (true) {
                            if ((i3 < 16 ? '7' : '+') != '+') {
                                int i4 = $10 + 85;
                                $11 = i4 % 128;
                                int i5 = i4 % 2;
                                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                                i2 -= 40503;
                                i3++;
                            }
                        }
                        cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                        cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                        c.BuiltInFictitiousFunctionClassFactory += 2;
                    } else {
                        String str = new String(cArr2, 0, i);
                        int i6 = $11 + 85;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                        objArr[0] = str;
                        return;
                    }
                }
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeTabActivity.m2618$r8$lambda$9xloK4rIh7ZerOlkC7UuaaLwps(HomeTabActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = registerForActivityResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<DanaConfirmationBottomSheetDialog>() { // from class: id.dana.home.HomeTabActivity$pinRegularChangesBottomSheet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // kotlin.jvm.functions.Function0
            public final DanaConfirmationBottomSheetDialog invoke() {
                int i = 2;
                ?? r2 = 0;
                StringWrapper.ResValue resValue = new StringWrapper.ResValue(R.string.pin_regular_changes_dialog_title, r2, i, r2);
                StringWrapper.ResValue resValue2 = new StringWrapper.ResValue(R.string.pin_regular_changes_dialog_desc, r2, i, r2);
                StringWrapper.ResValue resValue3 = new StringWrapper.ResValue(R.string.pin_regular_changes_dialog_update_pin, r2, i, r2);
                final HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                return new DanaConfirmationBottomSheetDialog(resValue, resValue2, resValue3, null, R.drawable.illustration_security_upgrade, new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$pinRegularChangesBottomSheet$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DanaLoadingDialog danaLoadingDialog;
                        danaLoadingDialog = HomeTabActivity.this.MyBillsEntityDataFactory;
                        if (danaLoadingDialog != null && !danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                            danaLoadingDialog.MyBillsEntityDataFactory.show();
                            danaLoadingDialog.getAuthRequestContext.startRefresh();
                        }
                        HomeTabActivity.this.getHomeTabPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }, null, false, 72, null);
            }
        });
        this.onFinishCheckSessionNotCalled = true;
    }

    public static final /* synthetic */ void access$showKycAmlEddDialog(HomeTabActivity homeTabActivity, final EddConsultModel eddConsultModel) {
        Trace startTrace = FirebasePerformance.startTrace("Edd - Show");
        HomeTabActivity homeTabActivity2 = homeTabActivity;
        KycAmlEddDialog kycAmlEddDialog = new KycAmlEddDialog(homeTabActivity2, eddConsultModel.getKClassImpl$Data$declaredNonStaticMembers$2(), new DialogInterface.OnCancelListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                HomeTabActivity.m2616$r8$lambda$3EGWDyxntrl5UW8tOqNWDgdi5g(HomeTabActivity.this, dialogInterface);
            }
        }, new View.OnClickListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTabActivity.m2619$r8$lambda$iEXwnIr5RcNfhoKlT9VhBJXng8(HomeTabActivity.this, eddConsultModel, view);
            }
        });
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(kycAmlEddDialog.BuiltInFictitiousFunctionClassFactory);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_edd_dialog;
        builder.FragmentBottomSheetPaymentSettingBinding = kycAmlEddDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_aml_edd_dialog_title);
        builder.getErrorConfigVersion = kycAmlEddDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_aml_edd_dialog_message);
        TwoButtonWithImageDialog.Builder PlaceComponentResult2 = builder.MyBillsEntityDataFactory(!kycAmlEddDialog.getAuthRequestContext).PlaceComponentResult(!kycAmlEddDialog.getAuthRequestContext);
        PlaceComponentResult2.MyBillsEntityDataFactory = kycAmlEddDialog.MyBillsEntityDataFactory;
        String string = kycAmlEddDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_aml_edd_dialog_button_text);
        View.OnClickListener onClickListener = kycAmlEddDialog.KClassImpl$Data$declaredNonStaticMembers$2;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
        EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(homeTabActivity2);
        builder2.MyBillsEntityDataFactory = TrackerKey.Event.KYC_AML_EDD_APPEAR;
        builder2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder2, (byte) 0));
        startTrace.stop();
    }

    public static final /* synthetic */ void access$showKycRenewalDialog(HomeTabActivity homeTabActivity) {
        Trace startTrace = FirebasePerformance.startTrace("Kyc Renewal - Show");
        HomeTabActivity homeTabActivity2 = homeTabActivity;
        CustomDialog.Builder builder = new CustomDialog.Builder(homeTabActivity2);
        builder.DatabaseTableConfigUtil = R.drawable.ic_kyc_renewal_dialog;
        builder.SubSequence = homeTabActivity.getString(R.string.kyc_renewal_dialog_title);
        builder.GetContactSyncConfig = homeTabActivity.getString(R.string.kyc_renewal_dialog_message);
        byte b = 0;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        MaterialDialog BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(homeTabActivity.getString(R.string.kyc_renewal_dialog_update_button_text), new Function1<View, Unit>() { // from class: id.dana.home.HomeTabActivity$showKycRenewalDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                materialDialog = HomeTabActivity.this.GetContactSyncConfig;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.dismiss();
                HomeTabActivity.this.getKycRenewalPresenter().get().getErrorConfigVersion.get().execute(KycRenewalPresenter.KClassImpl$Data$declaredNonStaticMembers$2(), KycRenewalPresenter$saveKYCRenewalButtonClick$1.INSTANCE, KycRenewalPresenter$saveKYCRenewalButtonClick$2.INSTANCE);
                HomeTabActivity.this.getKycRenewalPresenter().get().MyBillsEntityDataFactory();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity.getString(R.string.kyc_renewal_dialog_later_button_text), new Function1<View, Unit>() { // from class: id.dana.home.HomeTabActivity$showKycRenewalDialog$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                materialDialog = HomeTabActivity.this.GetContactSyncConfig;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.dismiss();
                HomeTabActivity.access$savePopupKycDismiss(HomeTabActivity.this);
                HomeTabActivity.this.getKycRenewalPresenter().get().getErrorConfigVersion.get().execute(KycRenewalPresenter.KClassImpl$Data$declaredNonStaticMembers$2(), KycRenewalPresenter$saveKYCRenewalButtonClick$1.INSTANCE, KycRenewalPresenter$saveKYCRenewalButtonClick$2.INSTANCE);
                HomeTabActivity.this.nextOnboardingStep();
            }
        }).BuiltInFictitiousFunctionClassFactory();
        homeTabActivity.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            BuiltInFictitiousFunctionClassFactory = null;
        }
        BuiltInFictitiousFunctionClassFactory.show();
        homeTabActivity.getKycRenewalPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2(true, homeTabActivity.getAuthRequestContext);
        EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(homeTabActivity2);
        builder2.MyBillsEntityDataFactory = TrackerKey.Event.KYC_RENEWAL_APPEAR;
        builder2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder2, b));
        startTrace.stop();
    }

    public static final /* synthetic */ void access$showPaymentSettingBottomSheet(final HomeTabActivity homeTabActivity, final BottomSheetPaymentSettingFragment bottomSheetPaymentSettingFragment) {
        Trace startTrace = FirebasePerformance.startTrace("Payment Setting - Show");
        if (!homeTabActivity.isActivityAvailable()) {
            startTrace.stop();
            return;
        }
        bottomSheetPaymentSettingFragment.setCancelable(false);
        FragmentManager supportFragmentManager = homeTabActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        AndroidComponentUtilsKt.MyBillsEntityDataFactory(bottomSheetPaymentSettingFragment, supportFragmentManager, "");
        bottomSheetPaymentSettingFragment.KClassImpl$Data$declaredNonStaticMembers$2 = new BottomSheetPaymentSettingFragment.BottomSheetListener() { // from class: id.dana.home.HomeTabActivity$showPaymentSettingBottomSheet$1$1
            @Override // id.dana.paymentsetting.BottomSheetPaymentSettingFragment.BottomSheetListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                BottomSheetPaymentSettingFragment.this.dismiss();
                homeTabActivity.getPaymentSettingPresenter().get().getAuthRequestContext("SWITCH_AOUTOROUTE_ON");
            }

            @Override // id.dana.paymentsetting.BottomSheetPaymentSettingFragment.BottomSheetListener
            public final void PlaceComponentResult() {
                BottomSheetPaymentSettingFragment.this.dismiss();
                homeTabActivity.getPaymentSettingPresenter().get().getAuthRequestContext("SWITCH_PAYMENT_AUTH_ON");
            }

            @Override // id.dana.paymentsetting.BottomSheetPaymentSettingFragment.BottomSheetListener
            public final void getAuthRequestContext() {
                homeTabActivity.nextOnboardingStep();
            }
        };
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(homeTabActivity);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_SETTING_APPEAR;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        startTrace.stop();
    }

    public static final /* synthetic */ void access$showTermsAndConditionsDialog(HomeTabActivity homeTabActivity, List list) {
        Trace startTrace = FirebasePerformance.startTrace("Tnc - Show");
        HomeTabFragment moveToNextValue = homeTabActivity.moveToNextValue();
        if (Intrinsics.areEqual(moveToNextValue != null ? moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, HomeTabFragment.FragmentTag.HOME_FRAGMENT)) {
            ActivityResultLauncher<Intent> activityResultLauncher = homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
            HomeTabActivity homeTabActivity2 = homeTabActivity;
            byte b = (byte) ($$j[7] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            activityResultLauncher.MyBillsEntityDataFactory(new Intent(homeTabActivity2, Class.forName((String) objArr[0])).putParcelableArrayListExtra(TncSummaryActivity.AGREEMENT_INFO, (ArrayList) CollectionsKt.toCollection(list, new ArrayList())), null);
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(homeTabActivity2);
            builder.MyBillsEntityDataFactory = TrackerKey.Event.TNC_APPEAR;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        } else {
            OnboardingOrchestrator onboardingOrchestrator = homeTabActivity.PrepareContext;
            if (onboardingOrchestrator != null) {
                onboardingOrchestrator.getAuthRequestContext.addFirst(OnboardingState.TncStep.INSTANCE);
            }
            homeTabActivity.DatabaseTableConfigUtil = true;
        }
        startTrace.stop();
    }

    @Override // id.dana.animation.tab.AppReadyConsumedProvider
    public final Boolean isConsumed() {
        return Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory);
    }

    @JvmName(name = "getPlayStoreReviewPresenter")
    public final dagger.Lazy<PlayStoreReviewContract.Presenter> getPlayStoreReviewPresenter() {
        dagger.Lazy<PlayStoreReviewContract.Presenter> lazy = this.playStoreReviewPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPlayStoreReviewPresenter")
    public final void setPlayStoreReviewPresenter(dagger.Lazy<PlayStoreReviewContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.playStoreReviewPresenter = lazy;
    }

    @JvmName(name = "getDanaContactPresenter")
    public final dagger.Lazy<DanaContactContract.Presenter> getDanaContactPresenter() {
        dagger.Lazy<DanaContactContract.Presenter> lazy = this.danaContactPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaContactPresenter")
    public final void setDanaContactPresenter(dagger.Lazy<DanaContactContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.danaContactPresenter = lazy;
    }

    @JvmName(name = "getTncSummaryPresenter")
    public final dagger.Lazy<TncSummaryContract.Presenter> getTncSummaryPresenter() {
        dagger.Lazy<TncSummaryContract.Presenter> lazy = this.tncSummaryPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTncSummaryPresenter")
    public final void setTncSummaryPresenter(dagger.Lazy<TncSummaryContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.tncSummaryPresenter = lazy;
    }

    @JvmName(name = "getPaymentSettingPresenter")
    public final dagger.Lazy<PaymentSettingContract.Presenter> getPaymentSettingPresenter() {
        dagger.Lazy<PaymentSettingContract.Presenter> lazy = this.paymentSettingPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPaymentSettingPresenter")
    public final void setPaymentSettingPresenter(dagger.Lazy<PaymentSettingContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.paymentSettingPresenter = lazy;
    }

    @JvmName(name = "getKycRenewalPresenter")
    public final dagger.Lazy<KycRenewalPresenter> getKycRenewalPresenter() {
        dagger.Lazy<KycRenewalPresenter> lazy = this.kycRenewalPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setKycRenewalPresenter")
    public final void setKycRenewalPresenter(dagger.Lazy<KycRenewalPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.kycRenewalPresenter = lazy;
    }

    @JvmName(name = "getKycAmlEddPresenter")
    public final dagger.Lazy<KycAmlEddPresenter> getKycAmlEddPresenter() {
        dagger.Lazy<KycAmlEddPresenter> lazy = this.kycAmlEddPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setKycAmlEddPresenter")
    public final void setKycAmlEddPresenter(dagger.Lazy<KycAmlEddPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.kycAmlEddPresenter = lazy;
    }

    @JvmName(name = "getGlobalNetworkPresenter")
    public final dagger.Lazy<GlobalNetworkContract.Presenter> getGlobalNetworkPresenter() {
        dagger.Lazy<GlobalNetworkContract.Presenter> lazy = this.globalNetworkPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalNetworkPresenter")
    public final void setGlobalNetworkPresenter(dagger.Lazy<GlobalNetworkContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.globalNetworkPresenter = lazy;
    }

    @JvmName(name = "getUserConfigPresenter")
    public final dagger.Lazy<UserConfigContract.Presenter> getUserConfigPresenter() {
        dagger.Lazy<UserConfigContract.Presenter> lazy = this.userConfigPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserConfigPresenter")
    public final void setUserConfigPresenter(dagger.Lazy<UserConfigContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.userConfigPresenter = lazy;
    }

    @JvmName(name = "getHomeTabPresenter")
    public final dagger.Lazy<HomeTabContract.Presenter> getHomeTabPresenter() {
        dagger.Lazy<HomeTabContract.Presenter> lazy = this.homeTabPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeTabPresenter")
    public final void setHomeTabPresenter(dagger.Lazy<HomeTabContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.homeTabPresenter = lazy;
    }

    @JvmName(name = "getFeedsContentAction")
    public final FeedsContentAction getFeedsContentAction() {
        FeedsContentAction feedsContentAction = this.feedsContentAction;
        if (feedsContentAction != null) {
            return feedsContentAction;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeedsContentAction")
    public final void setFeedsContentAction(FeedsContentAction feedsContentAction) {
        Intrinsics.checkNotNullParameter(feedsContentAction, "");
        this.feedsContentAction = feedsContentAction;
    }

    @JvmName(name = "getReferralDialogPresenter")
    public final dagger.Lazy<ReferralDialogContract.Presenter> getReferralDialogPresenter() {
        dagger.Lazy<ReferralDialogContract.Presenter> lazy = this.referralDialogPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReferralDialogPresenter")
    public final void setReferralDialogPresenter(dagger.Lazy<ReferralDialogContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.referralDialogPresenter = lazy;
    }

    @JvmName(name = "getDeeplinkReader")
    public final dagger.Lazy<ReadLinkPropertiesContract.Presenter> getDeeplinkReader() {
        dagger.Lazy<ReadLinkPropertiesContract.Presenter> lazy = this.deeplinkReader;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDeeplinkReader")
    public final void setDeeplinkReader(dagger.Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.deeplinkReader = lazy;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final dagger.Lazy<DynamicUrlWrapper> getDynamicUrlWrapper() {
        dagger.Lazy<DynamicUrlWrapper> lazy = this.dynamicUrlWrapper;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(dagger.Lazy<DynamicUrlWrapper> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.dynamicUrlWrapper = lazy;
    }

    @JvmName(name = "getHomeTrackerImpl")
    public final HomeTrackerImpl getHomeTrackerImpl() {
        HomeTrackerImpl homeTrackerImpl = this.homeTrackerImpl;
        if (homeTrackerImpl != null) {
            return homeTrackerImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeTrackerImpl")
    public final void setHomeTrackerImpl(HomeTrackerImpl homeTrackerImpl) {
        Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
        this.homeTrackerImpl = homeTrackerImpl;
    }

    @JvmName(name = "getGlobalNetworkTracker")
    public final dagger.Lazy<GlobalNetworkTracker> getGlobalNetworkTracker() {
        dagger.Lazy<GlobalNetworkTracker> lazy = this.globalNetworkTracker;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalNetworkTracker")
    public final void setGlobalNetworkTracker(dagger.Lazy<GlobalNetworkTracker> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.globalNetworkTracker = lazy;
    }

    @JvmName(name = "getAuthRequestContext")
    private final int getAuthRequestContext() {
        HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        return (1 < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(1) : null) instanceof HomeTabFragment ? 1 : 0;
    }

    @JvmName(name = "getPhonePermission$app_productionRelease")
    /* renamed from: getPhonePermission$app_productionRelease  reason: from getter */
    public final ActivityPermissionRequest getPhonePermission() {
        return this.phonePermission;
    }

    @JvmName(name = "getAutoRouteListener")
    public final PaymentSettingListener getAutoRouteListener() {
        return this.autoRouteListener;
    }

    @JvmName(name = "setAutoRouteListener")
    public final void setAutoRouteListener(PaymentSettingListener paymentSettingListener) {
        this.autoRouteListener = paymentSettingListener;
    }

    @JvmName(name = "getPaymentAuthListener")
    public final PaymentSettingListener getPaymentAuthListener() {
        return this.paymentAuthListener;
    }

    @JvmName(name = "setPaymentAuthListener")
    public final void setPaymentAuthListener(PaymentSettingListener paymentSettingListener) {
        this.paymentAuthListener = paymentSettingListener;
    }

    @JvmName(name = "getSwipeDelegateListener")
    public final SwipeDelegateListener getSwipeDelegateListener() {
        return (SwipeDelegateListener) this.swipeDelegateListener.getValue();
    }

    @JvmName(name = "getFeedRevamp")
    public final boolean getFeedRevamp() {
        return this.feedRevamp;
    }

    @JvmName(name = "setFeedRevamp")
    public final void setFeedRevamp(boolean z) {
        this.feedRevamp = z;
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ((DanaApplication) application).setFeedRevamp(z);
    }

    @JvmName(name = "getEnableGlobalSearch")
    public final boolean getEnableGlobalSearch() {
        return this.enableGlobalSearch;
    }

    @JvmName(name = "setEnableGlobalSearch")
    public final void setEnableGlobalSearch(boolean z) {
        this.enableGlobalSearch = z;
    }

    @JvmName(name = "getShowShareFeedBottomSheet")
    public final boolean getShowShareFeedBottomSheet() {
        return this.showShareFeedBottomSheet;
    }

    @JvmName(name = "setShowShareFeedBottomSheet")
    public final void setShowShareFeedBottomSheet(boolean z) {
        this.showShareFeedBottomSheet = z;
    }

    @JvmName(name = "isFeedMaintenance")
    /* renamed from: isFeedMaintenance  reason: from getter */
    public final boolean getIsFeedMaintenance() {
        return this.isFeedMaintenance;
    }

    @JvmName(name = "setFeedMaintenance")
    public final void setFeedMaintenance(boolean z) {
        this.isFeedMaintenance = z;
        if (z) {
            final HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
            if (homeFragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeFragmentStateAdapter = null;
            }
            homeFragmentStateAdapter.getAuthRequestContext(FeedMaintenanceFragment.MyBillsEntityDataFactory(), new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof FeedMaintenanceFragment);
                }
            });
            PlaceComponentResult();
        }
    }

    @JvmName(name = "DatabaseTableConfigUtil")
    private final boolean DatabaseTableConfigUtil() {
        HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        int currentItem = getBinding().PlaceComponentResult.getCurrentItem();
        return (currentItem < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(currentItem) : null) instanceof NotificationCenterFragment;
    }

    @JvmName(name = "isFinishCheckSession")
    /* renamed from: isFinishCheckSession  reason: from getter */
    public final boolean getIsFinishCheckSession() {
        return this.isFinishCheckSession;
    }

    @JvmName(name = "setFinishCheckSession")
    public final void setFinishCheckSession(boolean z) {
        this.isFinishCheckSession = z;
    }

    @JvmName(name = "getOnFinishCheckSessionNotCalled")
    public final boolean getOnFinishCheckSessionNotCalled() {
        return this.onFinishCheckSessionNotCalled;
    }

    @JvmName(name = "setOnFinishCheckSessionNotCalled")
    public final void setOnFinishCheckSessionNotCalled(boolean z) {
        this.onFinishCheckSessionNotCalled = z;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    public final void showCustomToast(final SnackbarEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = event.MyBillsEntityDataFactory;
        if (event.getAuthRequestContext != null) {
            builder.lookAheadTest = event.getAuthRequestContext;
        }
        if (event.BuiltInFictitiousFunctionClassFactory != null) {
            HomeTabs homeTabs = HomeTabs.POCKET;
            Function1<CustomSnackbar, Unit> function1 = new Function1<CustomSnackbar, Unit>() { // from class: id.dana.home.HomeTabActivity$showCustomToast$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CustomSnackbar customSnackbar) {
                    invoke2(customSnackbar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CustomSnackbar customSnackbar) {
                    Intrinsics.checkNotNullParameter(customSnackbar, "");
                    HomeTabActivity.getAuthRequestContext$default(HomeTabActivity.this, event.BuiltInFictitiousFunctionClassFactory, new KybPageInfo(false, false, null, false, 15, null), null, 4, null);
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
        }
        CustomSnackbar.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(event.KClassImpl$Data$declaredNonStaticMembers$2);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = event.PlaceComponentResult;
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        double d = this.pageHeight;
        Double.isNaN(d);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) (d * 0.1d);
        MyBillsEntityDataFactory.moveToNextValue = 0;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        getHomeTabPresenter().get().NetworkUserEntityData$$ExternalSyntheticLambda0();
        super.onStop();
    }

    public static /* synthetic */ void showMerchantReview$default(HomeTabActivity homeTabActivity, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        homeTabActivity.showMerchantReview(str, str2, z);
    }

    public final void showMerchantReview(String source, String r6, boolean ignoreDismissRule) {
        Intrinsics.checkNotNullParameter(source, "");
        Intrinsics.checkNotNullParameter(r6, "");
        HomeTabFragment moveToNextValue = moveToNextValue();
        if (moveToNextValue != null) {
            Boolean valueOf = Boolean.valueOf(ignoreDismissRule);
            FragmentManager childFragmentManager = (moveToNextValue.getActivity() == null || !moveToNextValue.isAdded()) ? null : moveToNextValue.getChildFragmentManager();
            if ((childFragmentManager != null ? (HomeRecycleFragment) childFragmentManager.findFragmentByTag(HomeTabFragment.FragmentTag.HOME_FRAGMENT) : null) != null) {
                HomeFragmentManager homeFragmentManager = moveToNextValue.GetContactSyncConfig;
                boolean booleanValue = valueOf.booleanValue();
                Intrinsics.checkNotNullParameter(source, "");
                Intrinsics.checkNotNullParameter(r6, "");
                homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(source, r6, Boolean.valueOf(booleanValue));
            } else if (moveToNextValue.getBaseActivity() instanceof HomeTabActivity) {
                ((HomeTabActivity) moveToNextValue.getBaseActivity()).nextOnboardingStep();
            }
            r2 = Unit.INSTANCE;
        }
        if (r2 == null) {
            nextOnboardingStep();
        }
    }

    public final void nextOnboardingStep() {
        OnboardingOrchestrator onboardingOrchestrator = this.PrepareContext;
        if (onboardingOrchestrator != null) {
            onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("app_ready_hot");
        AppReadyMixpanelTracker.PrepareContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Bundle extras;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(getPackageName().length() + 12562, new char[]{44883, 40517, 52580, 15371, 27449, 23078, 35264, 63667, 10139, 5795, 17848, 45839, 57951, 53524, 24, 20268, 48852, 60914, 56452, 2960, 31378, 43095, 38758, 50792, 13579, 25639}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(283 - View.getDefaultSize(0, 0), new char[]{44881, 44636, 44406, 44049, 43835, 43739, 43492, 43214, 42906, 42673, 42064, 41842, 41493, 41228, 41020, 49102, 48877, 48535}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), 18 - TextUtils.getOffsetBefore("", 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        AppReadyMixpanelTracker.getErrorConfigVersion();
        if (this.DatabaseTableConfigUtil) {
            OnboardingOrchestrator onboardingOrchestrator = this.PrepareContext;
            if (onboardingOrchestrator != null) {
                onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            this.DatabaseTableConfigUtil = false;
        } else {
            OnboardingOrchestrator onboardingOrchestrator2 = this.PrepareContext;
            if (onboardingOrchestrator2 != null && onboardingOrchestrator2.BuiltInFictitiousFunctionClassFactory()) {
                onboardingOrchestrator2.getAuthRequestContext.add(OnboardingState.UgcStep.INSTANCE);
                onboardingOrchestrator2.getAuthRequestContext.add(OnboardingState.ReferralEngagementStep.INSTANCE);
                onboardingOrchestrator2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        HomeTabFragment moveToNextValue = moveToNextValue();
        if (!(moveToNextValue != null ? Intrinsics.areEqual(Boolean.valueOf(moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2), Boolean.FALSE) : false) && (extras = getIntent().getExtras()) != null && extras.containsKey("redirectType")) {
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str : extras.keySet()) {
                try {
                    String string = extras.getString(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Notification data [");
                    sb.append(str);
                    sb.append(" : ");
                    sb.append(string);
                    sb.append(']');
                    DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.FCM_PUSH, sb.toString());
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    hashMap.put(str, string);
                } catch (ClassCastException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getNotificationData error. key = ");
                    sb2.append(str);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FCM_PUSH, sb2.toString(), e);
                }
            }
            NotificationDirectorFactory notificationDirectorFactory = new NotificationDirectorFactory(getDynamicUrlWrapper().get());
            String string2 = extras.getString("iconUrl");
            String string3 = extras.getString("contentType");
            String string4 = extras.getString("redirectType");
            String string5 = extras.getString(ShareToFeedBridge.REDIRECT_VALUE);
            String string6 = extras.getString(GriverParams.ShareParams.IMAGE_URL);
            NotificationData notificationData = new NotificationData();
            notificationData.MyBillsEntityDataFactory = string3;
            notificationData.BuiltInFictitiousFunctionClassFactory = string2;
            notificationData.getErrorConfigVersion = string4;
            notificationData.DatabaseTableConfigUtil = string5;
            notificationData.moveToNextValue = string6;
            notificationData.NetworkUserEntityData$$ExternalSyntheticLambda0 = hashMap;
            NotificationDirector PlaceComponentResult2 = notificationDirectorFactory.PlaceComponentResult(this, notificationData);
            if (PlaceComponentResult2 != null) {
                PlaceComponentResult2.PlaceComponentResult(this);
            }
            getIntent().replaceExtras(new Bundle());
        }
        DanaGoogleAssistant danaGoogleAssistant = DanaGoogleAssistant.INSTANCE;
        if (DanaGoogleAssistant.PlaceComponentResult()) {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("google_assistant_app_action");
            String stringExtra2 = intent.getStringExtra("searchQuery");
            if (stringExtra != null) {
                getDeeplinkReader().get().BuiltInFictitiousFunctionClassFactory(DanaGoogleAssistant.MyBillsEntityDataFactory(stringExtra, stringExtra2 != null ? stringExtra2 : ""), TrackerKey.SourceType.VOICE_ASSISTANT);
                intent.removeExtra("google_assistant_app_action");
            }
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (!getOnBackPressedDispatcher().getAuthRequestContext()) {
            ActivityHomeTabBinding binding = getBinding();
            if (binding.PlaceComponentResult.getCurrentItem() != getAuthRequestContext()) {
                binding.PlaceComponentResult.setCurrentItem(getAuthRequestContext());
                return;
            }
            HomeTabFragment moveToNextValue = moveToNextValue();
            if (!Intrinsics.areEqual(moveToNextValue != null ? moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, HomeTabFragment.FragmentTag.WALLET_FRAGMENT)) {
                HomeTabFragment moveToNextValue2 = moveToNextValue();
                if (!Intrinsics.areEqual(moveToNextValue2 != null ? moveToNextValue2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, HomeTabFragment.FragmentTag.ME_FRAGMENT)) {
                    finishAffinity();
                    return;
                }
            }
            HomeTabFragment moveToNextValue3 = moveToNextValue();
            if (moveToNextValue3 != null) {
                if (((moveToNextValue3.getActivity() == null || !moveToNextValue3.isAdded()) ? null : moveToNextValue3.getChildFragmentManager()) != null) {
                    if (Objects.equals(moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda0, HomeTabFragment.FragmentTag.WALLET_FRAGMENT)) {
                        Fragment fragment = moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory;
                        NewWalletFragment newWalletFragment = fragment instanceof NewWalletFragment ? (NewWalletFragment) fragment : null;
                        if (newWalletFragment != null) {
                            newWalletFragment.checkWalletAddAssetTooltip();
                        }
                    }
                    String str = moveToNextValue3.initRecordTimeStamp.get(moveToNextValue3.initRecordTimeStamp.size() - 1);
                    if (!Objects.equals(moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda0, str)) {
                        moveToNextValue3.initRecordTimeStamp.remove(str);
                        if (!moveToNextValue3.moveToNextValue()) {
                            moveToNextValue3.showTabBarMenu();
                        }
                        moveToNextValue3.BuiltInFictitiousFunctionClassFactory(str, moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, false, true);
                        moveToNextValue3.lookAheadTest();
                        return;
                    } else if (!Objects.equals(moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda0, str) || Objects.equals(str, HomeTabFragment.FragmentTag.HOME_FRAGMENT)) {
                        return;
                    } else {
                        moveToNextValue3.initRecordTimeStamp.remove(str);
                        if (!moveToNextValue3.moveToNextValue()) {
                            moveToNextValue3.showTabBarMenu();
                        }
                        moveToNextValue3.BuiltInFictitiousFunctionClassFactory(HomeTabFragment.FragmentTag.HOME_FRAGMENT, moveToNextValue3.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, false, true);
                        moveToNextValue3.lookAheadTest();
                        return;
                    }
                }
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        boolean z = false;
        if (ev != null && ev.getActionMasked() == 0) {
            z = true;
        }
        if (z) {
            PlaceComponentResult(ev.getX(), ev.getY(), System.currentTimeMillis());
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory = false;
        getDanaApplication().dispose();
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        String string = getString(R.string.rum_session_id);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Rum.Companion companion2 = Rum.getAuthRequestContext;
        String PlaceComponentResult2 = Rum.Companion.PlaceComponentResult();
        Intrinsics.checkNotNullParameter(string, "");
        Intrinsics.checkNotNullParameter(PlaceComponentResult2, "");
        authRequestContext.getAuthRequestContext.setCustomKey(string, PlaceComponentResult2);
        Crashlytics.Companion companion3 = Crashlytics.INSTANCE;
        Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
        DiagnosticLogException diagnosticLogException = new DiagnosticLogException();
        Intrinsics.checkNotNullParameter(diagnosticLogException, "");
        authRequestContext2.getAuthRequestContext.recordException(diagnosticLogException);
        EventBus.getDefault().unregister(this);
        ActivityResultLauncher<String> activityResultLauncher = this.newProxyInstance;
        if (activityResultLauncher != null) {
            activityResultLauncher.getAuthRequestContext();
        }
        super.onDestroy();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((VerifyPinLauncher) this.readMicros.getValue());
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((CreatePinLauncher) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
    }

    public final void setSwipeable(boolean swipeAble) {
        getBinding().PlaceComponentResult.setUserInputEnabled(swipeAble);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityHomeTabBinding initViewBinding() {
        ActivityHomeTabBinding PlaceComponentResult2 = ActivityHomeTabBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.group_send_member_count).substring(0, 3).codePointAt(0) + 64834, new char[]{44883, 21051, 21912, 22389, 23233, 23640, 24380, 17101, 17509, 18398, 18714, 19471, 20372, 29030, 29939, 30302, 31025, 31894}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(super.getResources().getString(R.string.request_money_add_bank_sender_name_error).substring(0, 1).length() + 24876, new char[]{44895, 52838, 27965, 36060, 11234}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    c((byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], getAuthRequestContext[25], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    c(getAuthRequestContext[56], getAuthRequestContext[59], (byte) (-getAuthRequestContext[5]), objArr5);
                    Object[] objArr6 = new Object[1];
                    b(((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 12536, new char[]{44883, 40517, 52580, 15371, 27449, 23078, 35264, 63667, 10139, 5795, 17848, 45839, 57951, 53524, 24, 20268, 48852, 60914, 56452, 2960, 31378, 43095, 38758, 50792, 13579, 25639}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    b(284 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{44881, 44636, 44406, 44049, 43835, 43739, 43492, 43214, 42906, 42673, 42064, 41842, 41493, 41228, 41020, 49102, 48877, 48535}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    b(super.getResources().getString(R.string.hint_form_routing_no).substring(14, 15).length() + 41442, new char[]{44805, 3762, 60610, 19107, 10382, 34361, 25689, 49727, 40989, 8108, 64911, 23445, 14835, 38791, 30057, 54089, 45363, 28432, 52978, 44170, 2794, 59598, 18131, 9313, 33310, 24618, 56836, 48551, 7124, 63969, 22473, 13610, 37739, 28999, 12070, 36098, 27832, 51908, 43192, 1687, 58493, 16911, 8248, 40485, 31828, 56294, 47566, 6138}, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((ViewConfiguration.getFadingEdgeLength() >> 16) + 28867, new char[]{44883, 57284, 20098, 64799, 27736, 40132, 2960, 47711, 10574, 22922, 51349, 30566, 58994, 5860, 34217, 13419, 41776, 54259, 17122, 61818, 24682, 37116, 8134, 36484, 15692, 44123, 56517, 19398, 64094, 26945, 39386, 2205, 46897, 9845, 22240, 50595, 29757, 58238, 5104, 33460, 12671, 41017, 53417, 24514, 52949, 32066, 60425, 7368, 35729, 14930, 43283, 55762, 18583, 63322, 26144, 38630, 1450, 46184, 9087, 21409, 49847, 29053, 57452, 4348}, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((ViewConfiguration.getTapTimeout() >> 16) + 46411, new char[]{44800, 6728, 50625, 45233, 31271, 9586, 37058, 23051, 1362, 61609, 48100, 25914, 53383, 39886, 17688, 12384, 64483, 42668, 4160, 56263, 34524, 28791, 15137, 59068, 20493, 6919, 50837, 45539, 31584, 9771, 37327, 23364, 1637, 61949, 48374, 26187, 53724, 40146, 17958, 12647, 64690, 42583, 4429, 56479, 34798, 28973, 15401, 59285, 20804, 7248, 51191, 45734, 31804, 10116, 37510, 23578, 1901, 62132, 48629, 26445, 53952, 40408, 18221, 12926}, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(getPackageName().length() + 2850, new char[]{44890, 42095, 47380, 36409, 33765, 39109, 60907, 57602, 63006, 52002, 49350, 54672, 10992, 15955, 13156, 2087, 7623, 4842, 26532, 31578, 28775, 17692, 23232, 44979, 42125, 47174, 36217, 33299, 38698, 60644, 57741, 63152, 51827, 57097, 54309, 10631, 16021, 13232, 1865, 7202, 4411, 26323, 31713, 28926, 17495, 22889, 44555, 41936, 47345, 36255, 33055, 38511, 60244, 57440, 62961, 51851, 57263, 54141, 10252, 15666}, objArr11);
                    String str4 = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    b(super.getResources().getString(R.string.see_more).substring(0, 2).codePointAt(0) + 30366, new char[]{44811, 55789, 17124, 52175, 29892, 64950}, objArr12);
                    try {
                        Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, 18 - TextUtils.getOffsetBefore("", 0), (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr13);
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
        }
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr14 = new Object[1];
            c(b, (byte) (b | 36), getAuthRequestContext[32], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b2 = getAuthRequestContext[25];
            Object[] objArr15 = new Object[1];
            c(b2, (byte) (b2 | Ascii.NAK), (byte) (getAuthRequestContext[32] - 1), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 494, 3 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1));
                    Object[] objArr17 = new Object[1];
                    k($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSizeAndState(0, 0, 0), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-1825553269, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - TextUtils.getOffsetAfter("", 0), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                super.onCreate(savedInstanceState);
                Rum.Companion companion = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("HomeTabActivity.onCreate");
                AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8();
                getLifecycle().BuiltInFictitiousFunctionClassFactory((VerifyPinLauncher) this.readMicros.getValue());
                getLifecycle().BuiltInFictitiousFunctionClassFactory((CreatePinLauncher) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
                Rum.Companion companion2 = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("HomeTabActivity.onCreate");
                this.newProxyInstance = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda15
                    @Override // androidx.view.result.ActivityResultCallback
                    public final void onActivityResult(Object obj6) {
                        HomeTabActivity.$r8$lambda$4YEcmgLRiRLaCZzyNGnOanAI9wA(HomeTabActivity.this, (Boolean) obj6);
                    }
                });
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda16
                    @Override // androidx.view.result.ActivityResultCallback
                    public final void onActivityResult(Object obj6) {
                        HomeTabActivity.m2620$r8$lambda$qTOQQZQQHDkRRk0XLYyatPVf7s(HomeTabActivity.this, (ActivityResult) obj6);
                    }
                });
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        byte b = 0;
        RpcLogging.INSTANCE.setEnabled(false);
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        Boolean isMePageRevamp = ((DanaApplication) application).getIsMePageRevamp();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = isMePageRevamp != null ? isMePageRevamp.booleanValue() : false;
        if (initRecordTimeStamp()) {
            getIntent().removeExtra("fromGoogle");
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.PlaceComponentResult(false);
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            OauthLoginManager.BuiltInFictitiousFunctionClassFactory(false);
            OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
            OauthLoginManager.MyBillsEntityDataFactory(false);
            OauthGrantActivity.Companion companion = OauthGrantActivity.INSTANCE;
            startActivity(OauthGrantActivity.Companion.PlaceComponentResult(this));
        }
        DaggerHomeTabActivityComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerHomeTabActivityComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        HomeTabActivity homeTabActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(homeTabActivity)));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaContactModule) Preconditions.getAuthRequestContext(new DanaContactModule(new DanaContactContract.View() { // from class: id.dana.home.HomeTabActivity$getDanaContactModule$1
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

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetContactSyncState(boolean z) {
                DanaContactContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final void onGetDanaUserContactSuccess(List<String> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetRecipientSyncContacts(List list) {
                DanaContactContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetSyncContacts(List list) {
                DanaContactContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final void onEnableContactSyncFeature() {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                sb.append(getClass().getName());
                sb.append(":init");
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.SYNC_CONTACT_TAG, sb.toString());
                HomeTabActivity.this.getDanaContactPresenter().get().MyBillsEntityDataFactory();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7 = (TncSummaryModules) Preconditions.getAuthRequestContext(new TncSummaryModules(new TncSummaryContract.View() { // from class: id.dana.home.HomeTabActivity$getTncSummaryModule$1
            @Override // id.dana.tncsummary.TncSummaryContract.View
            public final void PlaceComponentResult(boolean p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.tncsummary.TncSummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<AgreementInfo> p0) {
                if (p0 != null) {
                    HomeTabActivity.access$showTermsAndConditionsDialog(HomeTabActivity.this, p0);
                } else {
                    HomeTabActivity.this.nextOnboardingStep();
                }
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 = (UserConfigModule) Preconditions.getAuthRequestContext(new UserConfigModule(new UserConfigContract.View() { // from class: id.dana.home.HomeTabActivity$getUserConfigModule$1
            @Override // id.dana.userconfig.UserConfigContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (PaymentSettingModule) Preconditions.getAuthRequestContext(new PaymentSettingModule(new PaymentSettingContract.View() { // from class: id.dana.home.HomeTabActivity$getPaymentSettingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void getAuthRequestContext(boolean p0) {
                if (p0) {
                    HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                    HomeTabActivity.access$showPaymentSettingBottomSheet(homeTabActivity2, HomeTabActivity.access$getBottomSheetPaymentSettingFragment(homeTabActivity2));
                    return;
                }
                HomeTabActivity.this.nextOnboardingStep();
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory();
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (!Intrinsics.areEqual(p0, "SWITCH_AOUTOROUTE_ON")) {
                    HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory(p0, new SettingModel());
                } else {
                    HomeTabActivity.this.getPaymentSettingPresenter().get().PlaceComponentResult("");
                }
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void getAuthRequestContext(List<AuthenticationTypeOption> p0) {
                String str;
                AuthenticationTypeOption authenticationTypeOption;
                if (p0 == null || (authenticationTypeOption = (AuthenticationTypeOption) CollectionsKt.firstOrNull((List) p0)) == null || (str = authenticationTypeOption.getAuthenticationType()) == null) {
                    str = "";
                }
                HomeTabActivity.this.getPaymentSettingPresenter().get().PlaceComponentResult(str);
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void getAuthRequestContext() {
                HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory("SWITCH_PAYMENT_AUTH_OFF", new SettingModel());
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory("SWITCH_PAYMENT_AUTH_OFF", new SettingModel());
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void PlaceComponentResult() {
                HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory("SWITCH_PAYMENT_AUTH_OFF", new SettingModel());
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void PlaceComponentResult(boolean p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                HomeTabActivity.access$startRecommendSecurityChallenge(HomeTabActivity.this, p0, p1, p2);
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                HomeTabActivity.access$showPaymentSettingFailedDialog(HomeTabActivity.this);
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void MyBillsEntityDataFactory(SettingModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory("SWITCH_PAYMENT_AUTH_ON", p0);
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(PaymentSecurityInitModel p0, String p1, SettingModel p2) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                HomeTabActivity.access$switchPaymentAuth(HomeTabActivity.this, p0, p1, p2);
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void MyBillsEntityDataFactory(String p0, SettingModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                if (Intrinsics.areEqual(p0, "SWITCH_PAYMENT_AUTH_ON")) {
                    HomeTabActivity.access$switchPaymentAuth(HomeTabActivity.this, new PaymentSecurityInitModel(), p0, p1);
                } else {
                    new PaymentSettingSuccessDialog(r3, new HomeTabActivity$$ExternalSyntheticLambda4(HomeTabActivity.this)).PlaceComponentResult();
                }
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void getAuthRequestContext(String p0, SettingModel p1, boolean p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                if (Intrinsics.areEqual(p0, "SWITCH_PAYMENT_AUTH_ON")) {
                    HomeTabActivity.this.nextOnboardingStep();
                    HomeTabActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p1, p2, false);
                    return;
                }
                new PaymentSettingSuccessDialog(r2, new HomeTabActivity$$ExternalSyntheticLambda4(HomeTabActivity.this)).PlaceComponentResult();
            }

            @Override // id.dana.paymentsetting.PaymentSettingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(PaymentSecuritySwitchModel p0, String p1, SettingModel p2) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                boolean areEqual = Intrinsics.areEqual(p1, "SWITCH_PAYMENT_AUTH_ON");
                HomeTabActivity.this.paymentAuthListener = new HomeTabActivity.PaymentSettingListener() { // from class: id.dana.home.HomeTabActivity$activityResultPaymentControl$1
                    @Override // id.dana.home.HomeTabActivity.PaymentSettingListener
                    public final void getAuthRequestContext() {
                        if (areEqual) {
                            r2.KClassImpl$Data$declaredNonStaticMembers$2(p2, true, false);
                        } else {
                            new PaymentSettingSuccessDialog(r0, new HomeTabActivity$$ExternalSyntheticLambda4(r2)).PlaceComponentResult();
                        }
                    }

                    @Override // id.dana.home.HomeTabActivity.PaymentSettingListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        HomeTabActivity homeTabActivity2 = r2;
                        HomeTabActivity.access$showPaymentSettingBottomSheet(homeTabActivity2, HomeTabActivity.access$getBottomSheetPaymentSettingFragment(homeTabActivity2));
                    }
                };
                HomeTabActivity.access$startAlwaysAskPinPasswordChallenge(HomeTabActivity.this, areEqual, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                HomeTabActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                HomeTabActivity.this.dismissDanaLoadingDialog();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (KycRenewalModule) Preconditions.getAuthRequestContext(new KycRenewalModule(new KycRenewalContract.View() { // from class: id.dana.home.HomeTabActivity$getKycRenewalModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.kycrenewal.KycRenewalContract.View
            public final void getAuthRequestContext(QueryKYCRenewalStatusResponseModel queryKYCRenewalStatusResponseModel) {
                Intrinsics.checkNotNullParameter(queryKYCRenewalStatusResponseModel, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.kycrenewal.KycRenewalContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabActivity.access$showKycRenewalDialog(HomeTabActivity.this);
            }

            @Override // id.dana.kycrenewal.KycRenewalContract.View
            public final void PlaceComponentResult() {
                HomeTabActivity.access$showForceKycRenewalDialog(HomeTabActivity.this);
            }

            @Override // id.dana.kycrenewal.KycRenewalContract.View
            public final void PlaceComponentResult(int p0) {
                if (p0 <= 0) {
                    HomeTabActivity.access$createKycRenewalUrl(HomeTabActivity.this, SummaryActivity.CHECKED);
                } else {
                    HomeTabActivity.access$createKycRenewalUrl(HomeTabActivity.this, "false");
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                HomeTabActivity.this.nextOnboardingStep();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (KycAmlEddModule) Preconditions.getAuthRequestContext(new KycAmlEddModule(new KycAmlEddContract.View() { // from class: id.dana.home.HomeTabActivity$getKycAmlEddModule$1
            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void MyBillsEntityDataFactory(int p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0, EddConsultModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                if (p0 && p1.getGetAuthRequestContext() && HomeTabActivity.this.isActivityAvailable()) {
                    HomeTabActivity.access$showKycAmlEddDialog(HomeTabActivity.this, p1);
                } else {
                    HomeTabActivity.this.nextOnboardingStep();
                }
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.home.HomeTabActivity$initInjector$1
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
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
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
            public final /* synthetic */ void onError(String str) {
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
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = homeTabActivity;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = TrackerKey.SourceType.CLICK;
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = homeTabActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = homeTabActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = homeTabActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = homeTabActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (GlobalNetworkModule) Preconditions.getAuthRequestContext(new GlobalNetworkModule(new GlobalNetworkListener() { // from class: id.dana.home.HomeTabActivity$initInjector$2
            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
                HomeTabActivity.this.getGlobalNetworkTracker().get().getAuthRequestContext(p0);
                HomeTabActivity.this.showDeeplinkErrorDialog();
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomeTabActivity.this.showWarningDialog(p0);
                Intent intent = new Intent(HomeTabActivity.this, LocalConfigSplashActivity.class);
                HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                homeTabActivity2.startActivity(homeTabActivity2.getIntent());
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void lookAheadTest() {
                HomeTabActivity.this.showDanaLoadingDialog();
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                HomeTabActivity.this.dismissDanaLoadingDialog();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = (HomeTabModules) Preconditions.getAuthRequestContext(new HomeTabModules(new HomeTabContract.View() { // from class: id.dana.home.HomeTabActivity$initInjector$3
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog danaLoadingDialog;
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                danaLoadingDialog = HomeTabActivity.this.MyBillsEntityDataFactory;
                if (danaLoadingDialog == null || danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                DanaLoadingDialog danaLoadingDialog;
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                danaLoadingDialog = HomeTabActivity.this.MyBillsEntityDataFactory;
                if (danaLoadingDialog != null) {
                    danaLoadingDialog.PlaceComponentResult();
                }
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                HomeTabActivity.access$runStorageLogger(HomeTabActivity.this, p0);
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                DanaGoogleAssistant danaGoogleAssistant = DanaGoogleAssistant.INSTANCE;
                DanaGoogleAssistant.getAuthRequestContext(p0);
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void getAuthRequestContext() {
                DanaConfirmationBottomSheetDialog access$getPinRegularChangesBottomSheet = HomeTabActivity.access$getPinRegularChangesBottomSheet(HomeTabActivity.this);
                FragmentManager supportFragmentManager = HomeTabActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                access$getPinRegularChangesBottomSheet.getAuthRequestContext(supportFragmentManager);
                HomeTabActivity.this.getHomeTrackerImpl().getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("PIN Change Prompt", null);
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void MyBillsEntityDataFactory() {
                OnboardingOrchestrator onboardingOrchestrator;
                onboardingOrchestrator = HomeTabActivity.this.PrepareContext;
                if (onboardingOrchestrator != null) {
                    onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabActivity.access$getPinRegularChangesBottomSheet(HomeTabActivity.this).dismiss();
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void getAuthRequestContext(boolean p0) {
                HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                DanaVizPromptActivity.Companion companion2 = DanaVizPromptActivity.INSTANCE;
                homeTabActivity2.startActivity(DanaVizPromptActivity.Companion.MyBillsEntityDataFactory(HomeTabActivity.this).putExtra("dana_viz_prompt_skippable", !p0));
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void PlaceComponentResult(boolean p0) {
                if (p0) {
                    HomeTabActivity.access$getVerifyPinLauncher(HomeTabActivity.this).BuiltInFictitiousFunctionClassFactory();
                    HomeTabActivity.this.getHomeTrackerImpl().getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.PIN_CHANGE, new Pair[]{TuplesKt.to("Source", "PIN Change Prompt")});
                    return;
                }
                HomeTabActivity.access$openH5Container(HomeTabActivity.this, DanaUrl.REGULAR_CHANGES_PIN);
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void scheduleImpl(boolean p0) {
                if (p0) {
                    HomeTabActivity.this.getHomeTabPresenter().get().MyBillsEntityDataFactory();
                    HomeTabActivity.access$setupDataAfterFinishCheckSession(HomeTabActivity.this);
                    return;
                }
                HomeTabActivity.this.getHomeTabPresenter().get().PlaceComponentResult();
            }

            @Override // id.dana.home.presenter.HomeTabContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (p0) {
                    HomeTabActivity.access$setupDataAfterFinishCheckSession(HomeTabActivity.this);
                }
                HomeTabActivity.this.setFinishCheckSession(true);
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp = (ReferralDialogModule) Preconditions.getAuthRequestContext(new ReferralDialogModule(new ReferralDialogContract.View() { // from class: id.dana.home.HomeTabActivity$getReferralDialogModule$1
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

            @Override // id.dana.onboarding.referral.ReferralDialogContract.View
            public final void MyBillsEntityDataFactory(ReferralEngagementDialogModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.getPlaceComponentResult()) {
                    HomeTabActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda3 = p0;
                    HomeTabActivity.access$checkReferralDialog(HomeTabActivity.this);
                    return;
                }
                HomeTabActivity.this.nextOnboardingStep();
            }

            @Override // id.dana.onboarding.referral.ReferralDialogContract.View
            public final void getAuthRequestContext() {
                HomeTabActivity.this.nextOnboardingStep();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, DanaContactModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7, TncSummaryModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8, UserConfigModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KycRenewalModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KycAmlEddModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, GlobalNetworkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp, ReferralDialogModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, PaymentSettingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, HomeTabModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerHomeTabActivityComponent.HomeTabActivityComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1, KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        Intrinsics.checkNotNullExpressionValue(getApplicationComponent().PlaceComponentResult(new SocialCommonModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.home.HomeTabActivity$initSocialCommonComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }
        })), "");
        ActivityHomeTabBinding binding = getBinding();
        Bundle extras = getIntent().getExtras();
        HomeFragmentStateAdapter homeFragmentStateAdapter = null;
        HomeFragmentStateAdapter MyBillsEntityDataFactory2 = HomeFragmentStateAdapter.MyBillsEntityDataFactory((HomeTabs) (extras != null ? extras.getSerializable("OPEN_PAGE_EXTRA") : null), getSupportFragmentManager(), getLifecycle(), new HomeFragmentListener() { // from class: id.dana.home.HomeTabActivity$initHomeFragmentPagerStateAdapter$1$1
            @Override // id.dana.animation.HomeFragmentListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabActivity.this.setEnableGlobalSearch(true);
            }

            @Override // id.dana.animation.HomeFragmentListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                final HomeFragmentStateAdapter homeFragmentStateAdapter2;
                homeFragmentStateAdapter2 = HomeTabActivity.this.moveToNextValue;
                if (homeFragmentStateAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    homeFragmentStateAdapter2 = null;
                }
                homeFragmentStateAdapter2.BuiltInFictitiousFunctionClassFactory(ExploreDanaFragment.PlaceComponentResult(), new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof ExploreDanaFragment);
                    }
                });
            }

            @Override // id.dana.animation.HomeFragmentListener
            public final void MyBillsEntityDataFactory() {
                HomeFragmentStateAdapter homeFragmentStateAdapter2;
                HomeFragmentStateAdapter homeFragmentStateAdapter3;
                GlobalSearchFragment PlaceComponentResult2;
                final HomeFragmentStateAdapter homeFragmentStateAdapter4 = null;
                if (HomeTabActivity.this.getEnableGlobalSearch()) {
                    homeFragmentStateAdapter3 = HomeTabActivity.this.moveToNextValue;
                    if (homeFragmentStateAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        homeFragmentStateAdapter4 = homeFragmentStateAdapter3;
                    }
                    PlaceComponentResult2 = GlobalSearchFragment.Companion.PlaceComponentResult();
                    homeFragmentStateAdapter4.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof GlobalSearchFragment);
                        }
                    });
                    return;
                }
                homeFragmentStateAdapter2 = HomeTabActivity.this.moveToNextValue;
                if (homeFragmentStateAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    homeFragmentStateAdapter4 = homeFragmentStateAdapter2;
                }
                homeFragmentStateAdapter4.BuiltInFictitiousFunctionClassFactory(ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(), new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof ScannerFragment);
                    }
                });
            }
        }, getErrorConfigVersion());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.moveToNextValue = MyBillsEntityDataFactory2;
        ViewPager2 viewPager2 = binding.PlaceComponentResult;
        HomeFragmentStateAdapter homeFragmentStateAdapter2 = this.moveToNextValue;
        if (homeFragmentStateAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            homeFragmentStateAdapter = homeFragmentStateAdapter2;
        }
        viewPager2.setAdapter(homeFragmentStateAdapter);
        ViewPager2 viewPager22 = binding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "");
        ExtensionsKt.getAuthRequestContext(viewPager22, 7);
        binding.PlaceComponentResult.setCurrentItem(getAuthRequestContext(), false);
        getBinding().PlaceComponentResult.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: id.dana.home.HomeTabActivity$addOnPagerChangeListener$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void onPageSelected(int p0) {
                HomeFragmentStateAdapter homeFragmentStateAdapter3;
                HomeFragmentStateAdapter homeFragmentStateAdapter4;
                boolean z;
                boolean z2;
                boolean scheduleImpl;
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = null;
                if (p0 != 2) {
                    HomeTabActivity.this.initRecordTimeStamp = true;
                    scheduleImpl = HomeTabActivity.this.scheduleImpl();
                    if (scheduleImpl) {
                        HomeTabActivity.MyBillsEntityDataFactory$default(HomeTabActivity.this, false, 1, null);
                    }
                }
                if (p0 == 2) {
                    z = HomeTabActivity.this.getErrorConfigVersion;
                    if (z) {
                        z2 = HomeTabActivity.this.initRecordTimeStamp;
                        if (z2) {
                            HomeTabActivity.this.getSwipeDelegateListener().getAuthRequestContext(TrackerKey.SourceType.SWIPE_HOME, true);
                        }
                    }
                }
                if (HomeTabActivity.this.isExploreDanaFragment(p0)) {
                    TrackerExploreDanaOpen.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.SWIPE_RIGHT);
                    homeFragmentStateAdapter4 = HomeTabActivity.this.moveToNextValue;
                    if (homeFragmentStateAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        homeFragmentStateAdapter4 = null;
                    }
                    ExploreDanaFragment exploreDanaFragment = (ExploreDanaFragment) (p0 >= homeFragmentStateAdapter4.getAuthRequestContext.size() ? null : homeFragmentStateAdapter4.getAuthRequestContext.get(p0));
                    if (exploreDanaFragment != null) {
                        exploreDanaFragment.getErrorConfigVersion();
                    }
                    if (exploreDanaFragment != null) {
                        exploreDanaFragment.MyBillsEntityDataFactory();
                    }
                }
                if (HomeTabActivity.this.isGlobalSearchFragment(p0)) {
                    TrackerGlobalSearchOpen.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.SWIPE_RIGHT);
                    homeFragmentStateAdapter3 = HomeTabActivity.this.moveToNextValue;
                    if (homeFragmentStateAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        homeFragmentStateAdapter3 = null;
                    }
                    GlobalSearchFragment globalSearchFragment = (GlobalSearchFragment) (p0 >= homeFragmentStateAdapter3.getAuthRequestContext.size() ? null : homeFragmentStateAdapter3.getAuthRequestContext.get(p0));
                    if (globalSearchFragment != null) {
                        GlobalSearchAnalyticTracker globalSearchAnalyticTracker2 = globalSearchFragment.globalSearchAnalyticTracker;
                        if (globalSearchAnalyticTracker2 != null) {
                            globalSearchAnalyticTracker = globalSearchAnalyticTracker2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        globalSearchAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    if (globalSearchFragment != null) {
                        globalSearchFragment.initRecordTimeStamp();
                        return;
                    }
                    return;
                }
                KeyboardHelper.MyBillsEntityDataFactory(HomeTabActivity.this);
            }
        });
        ViewHelper.getAuthRequestContext(getBinding().PlaceComponentResult, new Runnable() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                HomeTabActivity.m2621$r8$lambda$zxU8CuqqU7rbxN6HUk00R73Bzw(HomeTabActivity.this);
            }
        });
    }

    public final void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            ActivityResultLauncher<String> activityResultLauncher = this.newProxyInstance;
            if (activityResultLauncher != null) {
                activityResultLauncher.MyBillsEntityDataFactory("android.permission.POST_NOTIFICATIONS", null);
                return;
            }
            return;
        }
        OnboardingOrchestrator onboardingOrchestrator = this.PrepareContext;
        if (onboardingOrchestrator != null) {
            onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final void startOnBoardingProcess() {
        OnboardingOrchestrator onboardingOrchestrator;
        if (NetworkUserEntityData$$ExternalSyntheticLambda2() || (onboardingOrchestrator = this.PrepareContext) == null) {
            return;
        }
        onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        String stringExtra = getIntent().getStringExtra("ACCodeValue");
        if (stringExtra == null) {
            Uri data = getIntent().getData();
            stringExtra = data != null ? data.getQueryParameter("ACCodeValue") : null;
        }
        String str = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        return !TextUtils.isEmpty(stringExtra) || KClassImpl$Data$declaredNonStaticMembers$2(str) || lookAheadTest() || initRecordTimeStamp();
    }

    private final boolean initRecordTimeStamp() {
        return getIntent().getBooleanExtra("fromGoogle", false);
    }

    private final boolean lookAheadTest() {
        Uri data = getIntent().getData();
        return Intrinsics.areEqual(data != null ? data.getEncodedPath() : null, DEEPLINK_PAYMENT_PATH) || DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().PlaceComponentResult();
    }

    public final void getUserCohort() {
        getHomeTabPresenter().get().NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    private static boolean getAuthRequestContext(String p0, String p1) {
        String str = p0;
        return !(str == null || StringsKt.isBlank(str)) || (StringsKt.isBlank(p1) ^ true);
    }

    private final void PlaceComponentResult(final String p0, final String p1) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(p1)) {
            AlipayConnectInitializer alipayConnectInitializer = getDanaApplication().getAlipayConnectInitializer();
            Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer, "");
            IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer, new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$initAcCashierPayment$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HomeTabActivity.this.getGlobalNetworkPresenter().get().PlaceComponentResult(p1);
                }
            });
            DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().MyBillsEntityDataFactory = Boolean.FALSE;
        } else {
            AlipayConnectInitializer alipayConnectInitializer2 = getDanaApplication().getAlipayConnectInitializer();
            Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer2, "");
            IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer2, new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$initAcCashierPayment$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GlobalNetworkContract.Presenter presenter = HomeTabActivity.this.getGlobalNetworkPresenter().get();
                    String str = p0;
                    presenter.PlaceComponentResult(!(str == null || StringsKt.isBlank(str)) ? p0 : p1);
                }
            });
        }
        DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory = null;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2() && !TextUtils.isEmpty(p0);
    }

    @Subscribe
    public final void onReceiveUpdateRequest(DanaH5.CheckAppUpdatesMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        DanaUpdateManager danaUpdateManager = this.getCallingPid;
        if (danaUpdateManager != null) {
            danaUpdateManager.PlaceComponentResult(new DanaUpdateManager.ManualCheckUpdateCallback() { // from class: id.dana.home.HomeTabActivity$onReceiveUpdateRequest$1
                @Override // id.dana.googleplay.updates.DanaUpdateManager.ManualCheckUpdateCallback
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                    DanaUpdateManager.ManualCheckUpdateCallback.CC.getAuthRequestContext();
                }

                @Override // id.dana.googleplay.updates.DanaUpdateManager.ManualCheckUpdateCallback
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                    DanaUpdateManager.ManualCheckUpdateCallback.CC.PlaceComponentResult();
                }
            });
        }
    }

    private final KybPageInfo getErrorConfigVersion() {
        Bundle extras = getIntent().getExtras();
        KybPageInfo kybPageInfo = extras != null ? (KybPageInfo) extras.getParcelable("KYB_PAGE_INFO") : null;
        return kybPageInfo == null ? new KybPageInfo(false, false, null, false, 15, null) : kybPageInfo;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = Completable.KClassImpl$Data$declaredNonStaticMembers$2(new Callable() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return HomeTabActivity.$r8$lambda$lq9bhkImYMAu3UvCICpKqZxj3HY(HomeTabActivity.this);
            }
        });
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2));
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$22, MyBillsEntityDataFactory)).getAuthRequestContext(new Action() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Action
            public final void run() {
                DanaLog.MyBillsEntityDataFactory("initHomeTabActivityData", "Complete");
            }
        }, new Consumer() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("initHomeTabActivityData", "Complete", (Throwable) obj);
            }
        }));
        HomeTabActivity homeTabActivity = this;
        String str = NotificationManagerCompat.MyBillsEntityDataFactory(homeTabActivity).BuiltInFictitiousFunctionClassFactory() ? DanaLogConstants.PushPermissionStatus.PUSH_ENABLED : "denied";
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.SeedId.PUSH_PERMISSION, DanaLogConstants.BizType.PUSH_NOTIFICATION, MapsKt.mutableMapOf(TuplesKt.to("status", str)));
        StringBuilder sb = new StringBuilder();
        sb.append("reportNotificationPermission status: ");
        sb.append(str);
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.BEHAVIOR_TAG, sb.toString());
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity, "android.permission.READ_CONTACTS") == 0) {
            getDanaContactPresenter().get().getAuthRequestContext();
        }
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity, "android.permission.WRITE_CONTACTS") == 0) {
            getDanaContactPresenter().get().BuiltInFictitiousFunctionClassFactory();
        } else if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity, "android.permission.READ_CONTACTS") == 0 && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity, "android.permission.WRITE_CONTACTS") != 0) {
            getDanaContactPresenter().get().BuiltInFictitiousFunctionClassFactory();
        }
        SocialSyncManagerKt.MyBillsEntityDataFactory(homeTabActivity);
        SaveContactSyncManagerKt.BuiltInFictitiousFunctionClassFactory(homeTabActivity);
        SaveContactSyncManagerKt.getAuthRequestContext(homeTabActivity);
    }

    @Override // id.dana.base.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (getIntent() != null) {
            if (getIntent().getBooleanExtra("OPEN_FROM_FEATURE_HOME", false)) {
                getBinding().PlaceComponentResult.setCurrentItem(getAuthRequestContext(), false);
                Bundle extras = getIntent().getExtras();
                HomeTabs homeTabs = (HomeTabs) (extras != null ? extras.getSerializable("OPEN_PAGE_EXTRA") : null);
                if (homeTabs != null) {
                    KybPageInfo errorConfigVersion = getErrorConfigVersion();
                    Bundle extras2 = getIntent().getExtras();
                    getAuthRequestContext(homeTabs, errorConfigVersion, extras2 != null ? extras2.getString(WALLET_SECTION) : null);
                }
            }
            if (!this.isFeedMaintenance && this.getErrorConfigVersion) {
                MyBillsEntityDataFactory(this.feedRevamp);
            } else {
                PlaceComponentResult();
            }
            if (Intrinsics.areEqual(GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext, Boolean.TRUE)) {
                showDanaLoadingDialog();
            }
            BuiltInFictitiousFunctionClassFactory();
            if (SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                getSwipeDelegateListener().BuiltInFictitiousFunctionClassFactory();
            }
            Bundle extras3 = getIntent().getExtras();
            SnackbarEvent snackbarEvent = extras3 != null ? (SnackbarEvent) extras3.getParcelable("SNACKBAR_EVENT") : null;
            if (snackbarEvent != null) {
                showCustomToast(snackbarEvent);
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        String stringExtra = getIntent().getStringExtra("ACCodeValue");
        String str = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        if (getAuthRequestContext(stringExtra, str)) {
            HomeTabFragment moveToNextValue = moveToNextValue();
            if (moveToNextValue != null) {
                moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(true);
            }
            PlaceComponentResult(stringExtra, str);
            return;
        }
        HomeTabFragment moveToNextValue2 = moveToNextValue();
        if (moveToNextValue2 != null) {
            moveToNextValue2.KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    public final void checkGnTopUpFlow() {
        Boolean bool = GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext = Boolean.FALSE;
            GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory = bool2;
            DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/topup", new DanaH5Listener() { // from class: id.dana.home.HomeTabActivity$checkGnTopUpFlow$$inlined$withDanaH5Callback$1
                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerCreated(Bundle p0) {
                }

                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerDestroyed(Bundle p0) {
                    GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory = null;
                    HomeTabActivity.access$checkGnTopUpResult(HomeTabActivity.this);
                }
            });
        }
    }

    public final void dismissLoadingDialogIfNeeded() {
        if (Intrinsics.areEqual(GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext, Boolean.TRUE)) {
            dismissDanaLoadingDialog();
        }
    }

    public static /* synthetic */ void getAuthRequestContext$default(HomeTabActivity homeTabActivity, HomeTabs homeTabs, KybPageInfo kybPageInfo, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        homeTabActivity.getAuthRequestContext(homeTabs, kybPageInfo, str);
    }

    private final void getAuthRequestContext(HomeTabs p0, KybPageInfo p1, String p2) {
        if (PlaceComponentResult(p0, p1.getPlaceComponentResult())) {
            String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.KYB);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            DanaH5.startContainerFullUrl(authRequestContext);
            return;
        }
        HomeTabFragment moveToNextValue = moveToNextValue();
        if (moveToNextValue != null) {
            moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda3 = p0;
            moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda5 = p1;
            moveToNextValue.FragmentBottomSheetPaymentSettingBinding = p2;
            if (moveToNextValue.getBinding() != null) {
                TabLayout tabLayout = moveToNextValue.getBinding().getAuthRequestContext;
                int i = HomeTabFragment.AnonymousClass17.BuiltInFictitiousFunctionClassFactory[p0.ordinal()];
                TabLayout.Tab tab = null;
                tab = null;
                tab = null;
                tab = null;
                if (i == 1) {
                    tab = tabLayout.getTabAt(0);
                } else if (i == 2) {
                    tab = tabLayout.getTabAt(1);
                } else if (i == 3) {
                    tab = tabLayout.getTabAt(2);
                } else if (i != 4) {
                    if (i == 5) {
                        FragmentManager childFragmentManager = (moveToNextValue.getActivity() == null || !moveToNextValue.isAdded()) ? null : moveToNextValue.getChildFragmentManager();
                        MyProfileMainFragment myProfileMainFragment = childFragmentManager != null ? (MyProfileMainFragment) childFragmentManager.findFragmentByTag(HomeTabFragment.FragmentTag.ME_FRAGMENT) : null;
                        if (myProfileMainFragment != null) {
                            if (p1.getPlaceComponentResult()) {
                                myProfileMainFragment.MyBillsEntityDataFactory = true;
                                if (myProfileMainFragment.getAuthRequestContext) {
                                    myProfileMainFragment.MyBillsEntityDataFactory(1);
                                }
                            } else {
                                myProfileMainFragment.MyBillsEntityDataFactory(0);
                                myProfileMainFragment.getAuthRequestContext(false);
                            }
                        }
                        tab = moveToNextValue.getBinding().getAuthRequestContext.getTabAt(4);
                    }
                } else if (moveToNextValue.newProxyInstance) {
                    if (moveToNextValue.PrepareContext) {
                        moveToNextValue.getAuthRequestContext(moveToNextValue.scheduleImpl, TrackerKey.SourceType.DEEP_LINK);
                    }
                } else {
                    moveToNextValue.scheduleImpl();
                }
                if (tab != null) {
                    tab.select();
                }
            }
        }
    }

    private final boolean PlaceComponentResult(HomeTabs p0, boolean p1) {
        if (p0 == HomeTabs.ME && p1) {
            Application application = getApplication();
            if (application == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
            }
            if (!((DanaApplication) application).getIsKybRevamp()) {
                return true;
            }
        }
        return false;
    }

    public final boolean scheduleImpl() {
        if (this.getErrorConfigVersion && !this.isFeedMaintenance) {
            HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
            if (homeFragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeFragmentStateAdapter = null;
            }
            if ((2 < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(2) : null) instanceof NotificationCenterFragment) {
                return true;
            }
        }
        return false;
    }

    public final boolean isExploreDanaFragment(int position) {
        if (position == 0) {
            HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
            if (homeFragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeFragmentStateAdapter = null;
            }
            if ((position < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(position) : null) instanceof ExploreDanaFragment) {
                return true;
            }
        }
        return false;
    }

    public final boolean isGlobalSearchFragment(int position) {
        if (this.enableGlobalSearch && position == 0) {
            HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
            if (homeFragmentStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeFragmentStateAdapter = null;
            }
            if ((position < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(position) : null) instanceof GlobalSearchFragment) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory$default(HomeTabActivity homeTabActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        homeTabActivity.MyBillsEntityDataFactory(z);
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        final HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        homeFragmentStateAdapter.getAuthRequestContext(FeedsFragment.BuiltInFictitiousFunctionClassFactory(Boolean.valueOf(p0).booleanValue()), new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof FeedsFragment);
            }
        });
        PlaceComponentResult();
    }

    public final void showDefaultNotificationPage() {
        Completable PlaceComponentResult2 = Completable.PlaceComponentResult(new Runnable() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                HomeTabActivity.$r8$lambda$e0heOzGM_0fI8PvtZM0ifKv0GQA(HomeTabActivity.this);
            }
        });
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(PlaceComponentResult2, PlaceComponentResult3));
        Scheduler PlaceComponentResult4 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult4, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult4));
        Predicate BuiltInFictitiousFunctionClassFactory = Functions.BuiltInFictitiousFunctionClassFactory();
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "predicate is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableOnErrorComplete(KClassImpl$Data$declaredNonStaticMembers$22, BuiltInFictitiousFunctionClassFactory)).q_());
    }

    private final void PlaceComponentResult() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("target");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent.getStringExtra("Source");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String stringExtra3 = intent.getStringExtra("bizOrderId");
        String str = stringExtra3 != null ? stringExtra3 : "";
        intent.removeExtra("target");
        intent.removeExtra("bizOrderId");
        int hashCode = stringExtra.hashCode();
        if (hashCode != -600094315) {
            if (hashCode != 3480) {
                if (hashCode != 100344454) {
                    if (hashCode == 317649683 && stringExtra.equals("maintenance")) {
                        getSwipeDelegateListener().getAuthRequestContext();
                    }
                } else if (stringExtra.equals("inbox")) {
                    getSwipeDelegateListener().getAuthRequestContext();
                }
            } else if (stringExtra.equals("me")) {
                getSwipeDelegateListener().getAuthRequestContext(stringExtra2, false);
            }
        } else if (stringExtra.equals("friends")) {
            getSwipeDelegateListener().KClassImpl$Data$declaredNonStaticMembers$2(stringExtra2, str.length() > 0);
        }
        if (str.length() > 0) {
            this.showShareFeedBottomSheet = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r5, int resultCode, Intent data) {
        int i;
        HomeFragmentStateAdapter homeFragmentStateAdapter;
        KycAmlEddActivity.Companion companion = KycAmlEddActivity.INSTANCE;
        if (KycAmlEddActivity.Companion.getAuthRequestContext() == r5) {
            nextOnboardingStep();
        } else {
            SwitchFragment.Companion companion2 = SwitchFragment.INSTANCE;
            if (SwitchFragment.Companion.BuiltInFictitiousFunctionClassFactory == r5) {
                nextOnboardingStep();
            } else {
                SocialActivityDetail.Companion companion3 = SocialActivityDetail.INSTANCE;
                i = SocialActivityDetail.lookAheadTest;
                if (i == r5) {
                    getSwipeDelegateListener().KClassImpl$Data$declaredNonStaticMembers$2("", false);
                } else if (1006 == r5) {
                    if (resultCode == -1) {
                        PaymentSettingListener paymentSettingListener = this.autoRouteListener;
                        if (paymentSettingListener != null) {
                            paymentSettingListener.getAuthRequestContext();
                        }
                    } else {
                        PaymentSettingListener paymentSettingListener2 = this.autoRouteListener;
                        if (paymentSettingListener2 != null) {
                            BuiltInFictitiousFunctionClassFactory(data);
                            paymentSettingListener2.BuiltInFictitiousFunctionClassFactory();
                        }
                    }
                } else if (1001 == r5) {
                    if (resultCode == -1) {
                        PaymentSettingListener paymentSettingListener3 = this.paymentAuthListener;
                        if (paymentSettingListener3 != null) {
                            paymentSettingListener3.getAuthRequestContext();
                        }
                    } else {
                        PaymentSettingListener paymentSettingListener4 = this.paymentAuthListener;
                        if (paymentSettingListener4 != null) {
                            BuiltInFictitiousFunctionClassFactory(data);
                            paymentSettingListener4.BuiltInFictitiousFunctionClassFactory();
                        }
                    }
                } else if (data != null && (homeFragmentStateAdapter = this.moveToNextValue) != null) {
                    if (homeFragmentStateAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        homeFragmentStateAdapter = null;
                    }
                    int authRequestContext = getAuthRequestContext();
                    BaseFragment baseFragment = authRequestContext < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(authRequestContext) : null;
                    if (baseFragment != null) {
                        baseFragment.onActivityResult(r5, resultCode, data);
                    }
                }
            }
        }
        super.onActivityResult(r5, resultCode, data);
        DanaUpdateManager danaUpdateManager = this.getCallingPid;
        if (danaUpdateManager != null) {
            danaUpdateManager.PlaceComponentResult(r5, resultCode);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(r4, "");
        super.onRequestPermissionsResult(r2, r3, r4);
    }

    private static String BuiltInFictitiousFunctionClassFactory(Intent p0) {
        Bundle extras;
        String string = (p0 == null || (extras = p0.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
        return string == null ? "" : string;
    }

    @JvmName(name = "moveToNextValue")
    public final HomeTabFragment moveToNextValue() {
        HomeFragmentStateAdapter homeFragmentStateAdapter = this.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        BaseFragment baseFragment = 1 >= homeFragmentStateAdapter.getAuthRequestContext.size() ? null : homeFragmentStateAdapter.getAuthRequestContext.get(1);
        HomeTabFragment homeTabFragment = baseFragment instanceof HomeTabFragment ? (HomeTabFragment) baseFragment : null;
        if (homeTabFragment == null) {
            HomeFragmentStateAdapter homeFragmentStateAdapter2 = this.moveToNextValue;
            if (homeFragmentStateAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeFragmentStateAdapter2 = null;
            }
            BaseFragment baseFragment2 = homeFragmentStateAdapter2.getAuthRequestContext.size() <= 0 ? null : homeFragmentStateAdapter2.getAuthRequestContext.get(0);
            if (baseFragment2 instanceof HomeTabFragment) {
                return (HomeTabFragment) baseFragment2;
            }
            return null;
        }
        return homeTabFragment;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        Trace startTrace = FirebasePerformance.startTrace("Referral Engagement - Show");
        final ReferralEngagementDialog.Builder builder = new ReferralEngagementDialog.Builder();
        HomeTabActivity homeTabActivity = this;
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        builder.PlaceComponentResult = homeTabActivity;
        ReferralEngagementDialogModel referralEngagementDialogModel = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (referralEngagementDialogModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralEngagementDialogModel = null;
        }
        Intrinsics.checkNotNullParameter(referralEngagementDialogModel, "");
        builder.MyBillsEntityDataFactory = referralEngagementDialogModel;
        DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeTabActivity.$r8$lambda$5zqtC5z5pBvfW1A5xux_ulzKWDM(HomeTabActivity.this, dialogInterface);
            }
        };
        Intrinsics.checkNotNullParameter(onDismissListener, "");
        builder.BuiltInFictitiousFunctionClassFactory = onDismissListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTabActivity.$r8$lambda$inoWDX5qiFXTYaSip1j7EZ0lzQQ(HomeTabActivity.this, view);
            }
        };
        Intrinsics.checkNotNullParameter(onClickListener, "");
        builder.getAuthRequestContext = onClickListener;
        DialogInterface.OnShowListener onShowListener = new DialogInterface.OnShowListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                HomeTabActivity.$r8$lambda$c81KBhtm8w5dCIr0sop3Cy4pEFI(ReferralEngagementDialog.Builder.this, this, dialogInterface);
            }
        };
        Intrinsics.checkNotNullParameter(onShowListener, "");
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = onShowListener;
        Context context = builder.PlaceComponentResult;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        ReferralEngagementDialog referralEngagementDialog = new ReferralEngagementDialog(context, builder, defaultConstructorMarker);
        this.FragmentBottomSheetPaymentSettingBinding = referralEngagementDialog;
        referralEngagementDialog.MyBillsEntityDataFactory();
        startTrace.stop();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(12569 - Color.alpha(0), new char[]{44883, 40517, 52580, 15371, 27449, 23078, 35264, 63667, 10139, 5795, 17848, 45839, 57951, 53524, 24, 20268, 48852, 60914, 56452, 2960, 31378, 43095, 38758, 50792, 13579, 25639}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                c((byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                c(getAuthRequestContext[56], getAuthRequestContext[59], (byte) (-getAuthRequestContext[5]), objArr3);
                Object[] objArr4 = new Object[1];
                b(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 250, new char[]{44881, 44636, 44406, 44049, 43835, 43739, 43492, 43214, 42906, 42673, 42064, 41842, 41493, 41228, 41020, 49102, 48877, 48535}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        getUserCohort();
        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(true);
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void showDanaLoadingDialog() {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new DanaLoadingDialog(this);
        }
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog == null || danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(TrackerKey.Property.APP_MINIMIZED, true);
    }

    public final void dismissDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog == null || danaLoadingDialog == null) {
            return;
        }
        danaLoadingDialog.PlaceComponentResult();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel p0, boolean p1, boolean p2) {
        Intent intent;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            intent = new Intent(this, SmartPayActivity.class);
            p0.setCollection(SmartPayActivity.SMARTPAY_COLLECTION);
            p0.setTitle(getString(R.string.smartpay_toolbar_title));
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, p0);
            intent.putExtra(MyProfileBundleKey.SWITCH_FACE_AUTH_ON, p2);
        } else {
            intent = new Intent(this, SettingMoreProfileActivity.class);
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, p0);
        }
        intent.putExtra(MyProfileBundleKey.SHOW_ALWAYS_ASK_PIN_SUCCESS_DIALOG, p1);
        startActivity(intent);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/HomeTabActivity$FinishSubActivitiesMessageEvent;", "", "Landroid/os/Bundle;", "getAuthRequestContext", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class FinishSubActivitiesMessageEvent {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Bundle KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FinishSubActivitiesMessageEvent() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.HomeTabActivity.FinishSubActivitiesMessageEvent.<init>():void");
        }

        private FinishSubActivitiesMessageEvent(Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
        }

        public /* synthetic */ FinishSubActivitiesMessageEvent(Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/home/HomeTabActivity$OnBackToHomepageMessageEvent;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class OnBackToHomepageMessageEvent {
        final Bundle KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnBackToHomepageMessageEvent) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnBackToHomepageMessageEvent) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            Bundle bundle = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bundle == null) {
                return 0;
            }
            return bundle.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnBackToHomepageMessageEvent(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public OnBackToHomepageMessageEvent(Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
        }
    }

    static /* synthetic */ void PlaceComponentResult$default(HomeTabActivity homeTabActivity, float f, float f2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        homeTabActivity.PlaceComponentResult(f, f2, j);
    }

    private final void PlaceComponentResult(float p0, float p1, long p2) {
        RiskEventStrategy.Builder builder = new RiskEventStrategy.Builder(this);
        Intrinsics.checkNotNullParameter("DANA - HomePage", "");
        builder.MyBillsEntityDataFactory = "DANA - HomePage";
        Intrinsics.checkNotNullParameter(RiskActionConstant.ON_TOUCH, "");
        builder.getAuthRequestContext = RiskActionConstant.ON_TOUCH;
        builder.moveToNextValue = Float.valueOf(p0);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.valueOf(p1);
        builder.BuiltInFictitiousFunctionClassFactory = Long.valueOf(p2);
        EventTracker.BuiltInFictitiousFunctionClassFactory(builder.getAuthRequestContext());
    }

    public final ViewPager2 getViewPager() {
        ViewPager2 viewPager2 = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "");
        return viewPager2;
    }

    public final void setFeedEnabledAndFeedRevamp(boolean feedEnabled, boolean feedRevamp) {
        setFeedRevamp(feedRevamp);
        this.getErrorConfigVersion = feedEnabled;
        if (DatabaseTableConfigUtil() || !feedEnabled || this.isFeedMaintenance) {
            return;
        }
        MyBillsEntityDataFactory(this.feedRevamp);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0007\u0010\u0011J/\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0018"}, d2 = {"Lid/dana/home/HomeTabActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Lid/dana/home/tab/HomeTabs;", "Lid/dana/kyb/model/KybPageInfo;", "p2", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/home/tab/HomeTabs;Lid/dana/kyb/model/KybPageInfo;)V", "Lid/dana/home/model/SnackbarEvent;", "p3", "(Landroid/content/Context;Lid/dana/home/tab/HomeTabs;Lid/dana/kyb/model/KybPageInfo;Lid/dana/home/model/SnackbarEvent;)V", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/home/tab/HomeTabs;Lid/dana/kyb/model/KybPageInfo;Ljava/lang/String;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "AC_CODE_VALUE", "Ljava/lang/String;", "DEEPLINK_PAYMENT_PATH", "DEEPLINK_WALLET_PATH", "EXTRA_IGNORE_DISMISS_RULE", "EXTRA_SHOP_ID", "EXTRA_SOURCE", HomeTabActivity.NEW_REGISTERED_USER, "OAUTH_LOADING_VALUE", NewWalletFragment.WALLET_SECTION, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, HomeTabActivity.class);
            intent.setData(Uri.parse(p1));
            intent.putExtra(TrackerType.BRANCH, p1);
            intent.putExtra("branch_force_new_session", true);
            intent.putExtra("in_app_deeplink_process", true);
            return intent;
        }

        public static void getAuthRequestContext(Context p0, HomeTabs p1, KybPageInfo p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, HomeTabActivity.class);
            intent.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
            intent.putExtra("OPEN_PAGE_EXTRA", p1);
            intent.putExtra("KYB_PAGE_INFO", p2);
            intent.putExtra("OPEN_FROM_FEATURE_HOME", true);
            p0.startActivity(intent);
        }

        public static void BuiltInFictitiousFunctionClassFactory(Context p0, HomeTabs p1, KybPageInfo p2, String p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, HomeTabActivity.class);
            intent.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
            intent.putExtra("OPEN_PAGE_EXTRA", p1);
            intent.putExtra("KYB_PAGE_INFO", p2);
            intent.putExtra("OPEN_FROM_FEATURE_HOME", true);
            intent.putExtra(HomeTabActivity.WALLET_SECTION, p3);
            p0.startActivity(intent);
        }

        public static void PlaceComponentResult(Context p0, HomeTabs p1, KybPageInfo p2, SnackbarEvent p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, HomeTabActivity.class);
            intent.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
            intent.putExtra("OPEN_PAGE_EXTRA", p1);
            intent.putExtra("KYB_PAGE_INFO", p2);
            intent.putExtra("OPEN_FROM_FEATURE_HOME", true);
            intent.putExtra("SNACKBAR_EVENT", p3);
            p0.startActivity(intent);
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intent flags = new Intent(context, HomeTabActivity.class).putExtra("OPEN_FROM_FEATURE_HOME", true).putExtra("source", str).putExtra(HomeTabActivity.EXTRA_SHOP_ID, str2).putExtra(HomeTabActivity.EXTRA_IGNORE_DISMISS_RULE, true).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            context.startActivity(flags);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/home/HomeTabActivity$SwitchFragment;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface SwitchFragment {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.PlaceComponentResult;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/home/HomeTabActivity$SwitchFragment$Companion;", "", "", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion PlaceComponentResult = new Companion();
            private static final int BuiltInFictitiousFunctionClassFactory = RandomInteger.BuiltInFictitiousFunctionClassFactory();

            private Companion() {
            }
        }
    }

    @Override // id.dana.animation.OnResumeInterceptor
    public final void onResumeFromFragment() {
        onResume();
    }

    @Override // android.app.Activity
    public final void onUserInteraction() {
        super.onUserInteraction();
        IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
        IdleTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$3EGWDyx-ntrl5UW8tOqNWDgdi5g */
    public static /* synthetic */ void m2616$r8$lambda$3EGWDyxntrl5UW8tOqNWDgdi5g(HomeTabActivity homeTabActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.nextOnboardingStep();
    }

    public static /* synthetic */ void $r8$lambda$4YEcmgLRiRLaCZzyNGnOanAI9wA(HomeTabActivity homeTabActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        OnboardingOrchestrator onboardingOrchestrator = homeTabActivity.PrepareContext;
        if (onboardingOrchestrator != null) {
            onboardingOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$5zqtC5z5pBvfW1A5xux_ulzKWDM(HomeTabActivity homeTabActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.nextOnboardingStep();
    }

    /* renamed from: $r8$lambda$8-OZ3MakSrRqlQryaDhnAmKNuFQ */
    public static /* synthetic */ void m2617$r8$lambda$8OZ3MakSrRqlQryaDhnAmKNuFQ(HomeTabActivity homeTabActivity) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    /* renamed from: $r8$lambda$9xloK4rIh7-ZerOlkC7UuaaLwps */
    public static /* synthetic */ void m2618$r8$lambda$9xloK4rIh7ZerOlkC7UuaaLwps(HomeTabActivity homeTabActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            homeTabActivity.nextOnboardingStep();
            return;
        }
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        HomeTabActivity homeTabActivity2 = homeTabActivity;
        String string = homeTabActivity.getString(R.string.tnc_failed_toast_text);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.PlaceComponentResult(homeTabActivity2, string);
    }

    public static /* synthetic */ void $r8$lambda$WS_nt9v2QvemIKtdD4GimUXPoHw(HomeTabActivity homeTabActivity, View view) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.nextOnboardingStep();
    }

    public static /* synthetic */ void $r8$lambda$c81KBhtm8w5dCIr0sop3Cy4pEFI(ReferralEngagementDialog.Builder builder, HomeTabActivity homeTabActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(builder, "");
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        ReferralEngagementDialogModel referralEngagementDialogModel = builder.MyBillsEntityDataFactory;
        if (referralEngagementDialogModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralEngagementDialogModel = null;
        }
        ReferralDialogContract.Presenter presenter = homeTabActivity.getReferralDialogPresenter().get();
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(referralEngagementDialogModel.MyBillsEntityDataFactory);
        presenter.getAuthRequestContext(System.currentTimeMillis() / 1000);
        String str = referralEngagementDialogModel.MyBillsEntityDataFactory;
        EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(homeTabActivity);
        builder2.MyBillsEntityDataFactory = TrackerKey.Event.REFERRAL_ENGAGEMENT_POPUP;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder2.MyBillsEntityDataFactory("Source", str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static /* synthetic */ void $r8$lambda$e0heOzGM_0fI8PvtZM0ifKv0GQA(HomeTabActivity homeTabActivity) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        final HomeFragmentStateAdapter homeFragmentStateAdapter = homeTabActivity.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        homeFragmentStateAdapter.getAuthRequestContext(NotificationCenterFragment.BuiltInFictitiousFunctionClassFactory(), new Function1() { // from class: id.dana.home.HomeFragmentStateAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HomeFragmentStateAdapter.this.getAuthRequestContext.get(((Integer) obj).intValue()) instanceof NotificationCenterFragment);
            }
        });
    }

    /* renamed from: $r8$lambda$iEXwnIr5RcNfhoKlT9-VhBJXng8 */
    public static /* synthetic */ void m2619$r8$lambda$iEXwnIr5RcNfhoKlT9VhBJXng8(HomeTabActivity homeTabActivity, EddConsultModel eddConsultModel, View view) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        Intrinsics.checkNotNullParameter(eddConsultModel, "");
        EddInfoModel eddInfoModel = eddConsultModel.MyBillsEntityDataFactory;
        if (eddInfoModel != null) {
            Intent intent = new Intent(homeTabActivity, KycAmlEddActivity.class);
            intent.putExtra(KycAmlEddActivity.KYC_AML_EDD_INTENT, eddInfoModel);
            KycAmlEddActivity.Companion companion = KycAmlEddActivity.INSTANCE;
            homeTabActivity.startActivityForResult(intent, KycAmlEddActivity.Companion.getAuthRequestContext());
        }
    }

    public static /* synthetic */ void $r8$lambda$inoWDX5qiFXTYaSip1j7EZ0lzQQ(HomeTabActivity homeTabActivity, View view) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        Intent intent = new Intent(homeTabActivity, MyReferralDetailActivity.class);
        intent.putExtra(MyReferralDetailActivity.OPEN_BOTTOM_SHEET_DIRECTLY, true);
        homeTabActivity.startActivity(intent);
        ReferralEngagementDialog referralEngagementDialog = homeTabActivity.FragmentBottomSheetPaymentSettingBinding;
        if (referralEngagementDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralEngagementDialog = null;
        }
        referralEngagementDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$jNCEc3yDmRng_JwdLecnQQv3GXg(HomeTabActivity homeTabActivity, View view) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        new DialogInterface.OnDismissListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeTabActivity.$r8$lambda$nGpfazS76OyeVy3Zr1euPqdJloc(HomeTabActivity.this, dialogInterface);
            }
        };
        homeTabActivity.getKycRenewalPresenter().get().getErrorConfigVersion.get().execute(KycRenewalPresenter.KClassImpl$Data$declaredNonStaticMembers$2(), KycRenewalPresenter$saveKYCRenewalButtonClick$1.INSTANCE, KycRenewalPresenter$saveKYCRenewalButtonClick$2.INSTANCE);
        homeTabActivity.getKycRenewalPresenter().get().MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$kJvTKSkwBW5s5eCrdtBvLl3ylig(CompletableEmitter completableEmitter) {
        Intrinsics.checkNotNullParameter(completableEmitter, "");
        completableEmitter.onComplete();
    }

    public static /* synthetic */ Unit $r8$lambda$lq9bhkImYMAu3UvCICpKqZxj3HY(HomeTabActivity homeTabActivity) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.getUserConfigPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
        homeTabActivity.getUserConfigPresenter().get().getAuthRequestContext();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void $r8$lambda$nGpfazS76OyeVy3Zr1euPqdJloc(HomeTabActivity homeTabActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        homeTabActivity.nextOnboardingStep();
    }

    /* renamed from: $r8$lambda$qTOQQZQQHDkRRk0-XLYyatPVf7s */
    public static /* synthetic */ void m2620$r8$lambda$qTOQQZQQHDkRRk0XLYyatPVf7s(HomeTabActivity homeTabActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            homeTabActivity.startActivity(activityResult.MyBillsEntityDataFactory);
        }
    }

    /* renamed from: $r8$lambda$zxU8CuqqU7rbxN6H-Uk00R73Bzw */
    public static /* synthetic */ void m2621$r8$lambda$zxU8CuqqU7rbxN6HUk00R73Bzw(HomeTabActivity homeTabActivity) {
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        DanaApplication danaApplication = homeTabActivity.getDanaApplication();
        Intrinsics.checkNotNullExpressionValue(danaApplication, "");
        homeTabActivity.PrepareContext = new OnboardingOrchestrator(danaApplication, new OnboardingEvent() { // from class: id.dana.home.HomeTabActivity$initOnboardingOrchestrator$1
            @Override // id.dana.animation.OnboardingEvent
            public final void lookAheadTest() {
                HomeTabActivity.this.getHomeTabPresenter().get().moveToNextValue();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void DatabaseTableConfigUtil() {
                Trace startTrace = FirebasePerformance.startTrace("Tnc - Step");
                HomeTabActivity.this.getTncSummaryPresenter().get().MyBillsEntityDataFactory();
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void GetContactSyncConfig() {
                HomeTabActivity.this.checkNotificationPermission();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void moveToNextValue() {
                Trace startTrace = FirebasePerformance.startTrace("Payment Setting - Step");
                HomeTabActivity.this.getPaymentSettingPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void BuiltInFictitiousFunctionClassFactory() {
                Trace startTrace = FirebasePerformance.startTrace("Kyc Renewal - Step");
                HomeTabActivity.access$isPopupKycQueryExceedLimit(HomeTabActivity.this);
                HomeTabActivity.access$isPopupKycShowExceedLimit(HomeTabActivity.this);
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void getAuthRequestContext() {
                Trace startTrace = FirebasePerformance.startTrace("Edd - Step");
                final KycAmlEddPresenter kycAmlEddPresenter = HomeTabActivity.this.getKycAmlEddPresenter().get();
                kycAmlEddPresenter.PlaceComponentResult.get().execute(new DefaultObserver<EddConsult>() { // from class: id.dana.kycamledd.KycAmlEddPresenter$checkAmlRequired$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        dagger.Lazy lazy;
                        EddConsult eddConsult = (EddConsult) obj;
                        Intrinsics.checkNotNullParameter(eddConsult, "");
                        lazy = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        ((KycAmlEddContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(true, EddConsultToEddConsultModelMapperKt.MyBillsEntityDataFactory(eddConsult));
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p0) {
                        dagger.Lazy lazy;
                        Intrinsics.checkNotNullParameter(p0, "");
                        lazy = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        ((KycAmlEddContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(false, new EddConsultModel(false, null, false, 7, null));
                    }
                });
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void PlaceComponentResult() {
                HomeTabFragment moveToNextValue;
                Unit unit;
                Trace startTrace = FirebasePerformance.startTrace("Normal Tooltip - Step");
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    dagger.Lazy<FirstTimeContract.Presenter> lazy = moveToNextValue.firstTimePresenter;
                    if (lazy != null) {
                        lazy.get().MyBillsEntityDataFactory();
                    } else {
                        HomeTabActivity homeTabActivity2 = (HomeTabActivity) moveToNextValue.getBaseActivity();
                        if (homeTabActivity2 != null) {
                            homeTabActivity2.nextOnboardingStep();
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    HomeTabActivity.this.nextOnboardingStep();
                }
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
                HomeTabFragment moveToNextValue;
                Unit unit;
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    moveToNextValue.getErrorConfigVersion();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    HomeTabActivity.this.nextOnboardingStep();
                }
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabFragment moveToNextValue;
                boolean booleanExtra = HomeTabActivity.this.getIntent().getBooleanExtra(HomeTabActivity.NEW_REGISTERED_USER, false);
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    if (booleanExtra) {
                        moveToNextValue.homeRevampPresenter.get().getAuthRequestContext(HomeTabFragment.PlaceComponentResult(), true);
                        HomeTabActivity homeTabActivity2 = (HomeTabActivity) moveToNextValue.getBaseActivity();
                        if (homeTabActivity2 != null) {
                            homeTabActivity2.nextOnboardingStep();
                        }
                    } else {
                        if (moveToNextValue.homeRevampPresenter != null) {
                            FragmentManager childFragmentManager = (moveToNextValue.getActivity() == null || !moveToNextValue.isAdded()) ? null : moveToNextValue.getChildFragmentManager();
                            if ((childFragmentManager != null ? (HomeRecycleFragment) childFragmentManager.findFragmentByTag(HomeTabFragment.FragmentTag.HOME_FRAGMENT) : null) != null && !moveToNextValue.GetContactSyncConfig.PlaceComponentResult()) {
                                moveToNextValue.homeRevampPresenter.get().PlaceComponentResult(HomeTabFragment.PlaceComponentResult());
                            }
                        }
                        HomeTabActivity homeTabActivity3 = (HomeTabActivity) moveToNextValue.getBaseActivity();
                        if (homeTabActivity3 != null) {
                            homeTabActivity3.nextOnboardingStep();
                        }
                    }
                    r2 = Unit.INSTANCE;
                }
                if (r2 == null) {
                    HomeTabActivity.this.nextOnboardingStep();
                }
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void scheduleImpl() {
                HomeTabFragment moveToNextValue;
                Unit unit;
                dagger.Lazy<QrisCrossBorderContract.Presenter> lazy;
                Trace startTrace = FirebasePerformance.startTrace("Qcb Onboarding - Step");
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    if (HomeTabFragment.LocationMode.QRIS_CROSS_BORDER.equals(HomeTabFragment.LocationMode.QRIS_CROSS_BORDER) && (lazy = moveToNextValue.qrisCrossBorderPresenter) != null) {
                        lazy.get().PlaceComponentResult();
                    } else {
                        HomeTabActivity homeTabActivity2 = (HomeTabActivity) moveToNextValue.getBaseActivity();
                        if (homeTabActivity2 != null) {
                            homeTabActivity2.nextOnboardingStep();
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    HomeTabActivity.this.nextOnboardingStep();
                }
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void MyBillsEntityDataFactory() {
                HomeTabFragment moveToNextValue;
                Unit unit;
                Trace startTrace = FirebasePerformance.startTrace("Interstitial Banner - Step");
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    dagger.Lazy<InterstitialPromotionBannerContract.Presenter> lazy = moveToNextValue.interstitialPresenter;
                    if (lazy != null) {
                        lazy.get().BuiltInFictitiousFunctionClassFactory();
                    } else {
                        HomeTabActivity homeTabActivity2 = (HomeTabActivity) moveToNextValue.getBaseActivity();
                        if (homeTabActivity2 != null) {
                            homeTabActivity2.nextOnboardingStep();
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    HomeTabActivity.this.nextOnboardingStep();
                }
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
                Trace startTrace = FirebasePerformance.startTrace("Ugc - Step");
                try {
                    HomeTabActivity.showMerchantReview$default(HomeTabActivity.this, "Home", null, false, 6, null);
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_TAG, e.getMessage(), e);
                    HomeTabActivity.this.nextOnboardingStep();
                }
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
                Trace startTrace = FirebasePerformance.startTrace("Referral Engagement - Step");
                HomeTabActivity.this.getReferralDialogPresenter().get().PlaceComponentResult(HomeTabActivity.access$getCurrentUnixEpochTime(HomeTabActivity.this));
                startTrace.stop();
            }

            @Override // id.dana.animation.OnboardingEvent
            public final void getErrorConfigVersion() {
                ActivityPermissionRequest activityPermissionRequest;
                if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                    activityPermissionRequest = HomeTabActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    ActivityPermissionRequestKt.BuiltInFictitiousFunctionClassFactory(activityPermissionRequest);
                    return;
                }
                HomeTabActivity.this.nextOnboardingStep();
            }
        });
        homeTabActivity.getHomeTabPresenter().get().BuiltInFictitiousFunctionClassFactory("DANA - HomePage", new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$initRiskTracker$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppReadyMixpanelTracker.moveToNextValue();
            }
        }, new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$initRiskTracker$2
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Boolean, Unit>() { // from class: id.dana.home.HomeTabActivity$initRiskTracker$3
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                AppReadyMixpanelTracker.getAuthRequestContext(z);
            }
        });
        homeTabActivity.getHomeTabPresenter().get().NetworkUserEntityData$$ExternalSyntheticLambda2();
        homeTabActivity.getHomeTabPresenter().get().lookAheadTest();
        homeTabActivity.getHomeTabPresenter().get().getErrorConfigVersion();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig();
        homeTabActivity.getHomeTabPresenter().get().scheduleImpl();
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        AppReadyMixpanelTracker.getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$initAppReadyCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z;
                HomeTabFragment moveToNextValue;
                z = HomeTabActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (z) {
                    return;
                }
                HomeTabActivity.this.BuiltInFictitiousFunctionClassFactory = true;
                HomeTabActivity.access$initHomeTabDataAndSharedImages(HomeTabActivity.this);
                HomeTabActivity.access$setupUpdateManager(HomeTabActivity.this);
                HomeTabActivity.access$setupActivityData(HomeTabActivity.this);
                RxEmoneyBus.PlaceComponentResult().onNext(Boolean.TRUE);
                HomeTabActivity.this.autoRouteListener = new HomeTabActivity.PaymentSettingListener() { // from class: id.dana.home.HomeTabActivity$activityResultAutoRoute$1
                    @Override // id.dana.home.HomeTabActivity.PaymentSettingListener
                    public final void getAuthRequestContext() {
                        HomeTabActivity.this.getPaymentSettingPresenter().get().MyBillsEntityDataFactory("SWITCH_PAYMENT_AUTH_OFF", new SettingModel());
                    }

                    @Override // id.dana.home.HomeTabActivity.PaymentSettingListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        HomeTabActivity homeTabActivity2 = HomeTabActivity.this;
                        HomeTabActivity.access$showPaymentSettingBottomSheet(homeTabActivity2, HomeTabActivity.access$getBottomSheetPaymentSettingFragment(homeTabActivity2));
                    }
                };
                HomeTabActivity.access$showLoadingDialogIfNeeded(HomeTabActivity.this);
                moveToNextValue = HomeTabActivity.this.moveToNextValue();
                if (moveToNextValue != null) {
                    moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2();
                }
                HomeTabActivity.this.getDanaApplication().chckTmprdApp();
                HomeTabActivity.access$beginFirstActionFlow(HomeTabActivity.this);
                r0.getHomeTabPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$scheduleDeviceStatsWorker$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DeviceStatsReportWorker.Companion companion = DeviceStatsReportWorker.INSTANCE;
                        DeviceStatsReportWorker.Companion.getAuthRequestContext(HomeTabActivity.this);
                    }
                }, new Function0<Unit>() { // from class: id.dana.home.HomeTabActivity$scheduleDeviceStatsWorker$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DeviceStatsReportWorker.Companion companion = DeviceStatsReportWorker.INSTANCE;
                        DeviceStatsReportWorker.Companion.KClassImpl$Data$declaredNonStaticMembers$2(HomeTabActivity.this);
                    }
                });
            }
        });
    }

    public static final /* synthetic */ void access$beginFirstActionFlow(HomeTabActivity homeTabActivity) {
        try {
            Rum.Companion companion = Rum.getAuthRequestContext;
            Rum BuiltInFictitiousFunctionClassFactory = Rum.Companion.BuiltInFictitiousFunctionClassFactory();
            Rum.Companion companion2 = Rum.getAuthRequestContext;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(TrackerKey.Event.FIRST_ACTION, Rum.Companion.getAuthRequestContext(TrackerKey.Property.START_TYPE, TrackerKey.AppStartProperty.APP_START_COLD));
            MixPanelTracker.BuiltInFictitiousFunctionClassFactory();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            DanaLog.MyBillsEntityDataFactory("beginFirstActionFlow", message);
        }
    }

    public static final /* synthetic */ void access$checkGnTopUpResult(HomeTabActivity homeTabActivity) {
        GnTopUpResultModel gnTopUpResultModel = GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().MyBillsEntityDataFactory;
        Unit unit = null;
        if (gnTopUpResultModel != null) {
            homeTabActivity.dismissDanaLoadingDialog();
            TopUpService topUpService = AlipayPlusClientAutoDebit.getInstance().getTopUpService();
            if (topUpService == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.provider.TopUpServiceProvider");
            }
            ((TopUpServiceProvider) topUpService).PlaceComponentResult(gnTopUpResultModel);
            GnTopUpSaveDataManager PlaceComponentResult2 = GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult();
            PlaceComponentResult2.getAuthRequestContext = null;
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = null;
            PlaceComponentResult2.MyBillsEntityDataFactory = null;
            GnTopUpSaveDataManager.getAuthRequestContext = null;
            homeTabActivity.finishAffinity();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            homeTabActivity.dismissDanaLoadingDialog();
        }
    }

    public static final /* synthetic */ void access$checkReferralDialog(HomeTabActivity homeTabActivity) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        ReferralEngagementDialogModel referralEngagementDialogModel = homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (referralEngagementDialogModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralEngagementDialogModel = null;
        }
        ReferralEngagementDialogModel referralEngagementDialogModel2 = (referralEngagementDialogModel.KClassImpl$Data$declaredNonStaticMembers$2 > 0L ? 1 : (referralEngagementDialogModel.KClassImpl$Data$declaredNonStaticMembers$2 == 0L ? 0 : -1)) < 0 ? null : referralEngagementDialogModel;
        if (referralEngagementDialogModel2 != null) {
            if (referralEngagementDialogModel2.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
                return;
            }
            long j = referralEngagementDialogModel2.KClassImpl$Data$declaredNonStaticMembers$2;
            Disposable disposable = homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (disposable != null) {
                disposable.dispose();
            }
            Completable BuiltInFictitiousFunctionClassFactory = Completable.BuiltInFictitiousFunctionClassFactory(new CompletableOnSubscribe() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda0
                @Override // io.reactivex.CompletableOnSubscribe
                public final void subscribe(CompletableEmitter completableEmitter) {
                    HomeTabActivity.$r8$lambda$kJvTKSkwBW5s5eCrdtBvLl3ylig(completableEmitter);
                }
            });
            TimeUnit timeUnit = TimeUnit.SECONDS;
            KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
            Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(BuiltInFictitiousFunctionClassFactory, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
            Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
            ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
            homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda4 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult2)).KClassImpl$Data$declaredNonStaticMembers$2(new Action() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Action
                public final void run() {
                    HomeTabActivity.m2617$r8$lambda$8OZ3MakSrRqlQryaDhnAmKNuFQ(HomeTabActivity.this);
                }
            });
        }
    }

    public static final /* synthetic */ void access$checkUpdatesManually(HomeTabActivity homeTabActivity) {
        DanaUpdateManager danaUpdateManager = homeTabActivity.getCallingPid;
        if (danaUpdateManager != null) {
            DanaUpdateManager.ManualCheckUpdateCallback manualCheckUpdateCallback = new DanaUpdateManager.ManualCheckUpdateCallback() { // from class: id.dana.home.HomeTabActivity$checkUpdatesManually$1
                @Override // id.dana.googleplay.updates.DanaUpdateManager.ManualCheckUpdateCallback
                public final void BuiltInFictitiousFunctionClassFactory() {
                    DanaUpdateManager danaUpdateManager2;
                    danaUpdateManager2 = HomeTabActivity.this.getCallingPid;
                    if (danaUpdateManager2 != null) {
                        danaUpdateManager2.getAuthRequestContext(R.string.no_updates_found, R.string.dismiss, -1, null);
                    }
                }

                @Override // id.dana.googleplay.updates.DanaUpdateManager.ManualCheckUpdateCallback
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    DanaUpdateManager danaUpdateManager2;
                    danaUpdateManager2 = HomeTabActivity.this.getCallingPid;
                    if (danaUpdateManager2 != null) {
                        danaUpdateManager2.getAuthRequestContext(R.string.error_check_updates, R.string.dismiss, -1, null);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(manualCheckUpdateCallback, "");
            final DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1 danaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1 = new DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1(danaUpdateManager, manualCheckUpdateCallback);
            if (danaUpdateManager.lookAheadTest) {
                danaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1.invoke();
                return;
            }
            List<Runnable> list = danaUpdateManager.getAuthRequestContext;
            if (list != null) {
                list.add(new Runnable() { // from class: id.dana.googleplay.updates.DanaUpdateManager$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        DanaUpdateManager.getAuthRequestContext(Function0.this);
                    }
                });
            }
        }
    }

    public static final /* synthetic */ void access$createKycRenewalUrl(HomeTabActivity homeTabActivity, String str) {
        String obj = Uri.parse("https://m.dana.id/i/kyc/renewal-intro").buildUpon().appendQueryParameter("showCloseButton", str).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        DanaH5.startContainerFullUrl(obj, new DanaH5Listener() { // from class: id.dana.home.HomeTabActivity$createKycRenewalUrl$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                HomeTabActivity.access$savePopupKycDismiss(HomeTabActivity.this);
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                HomeTabActivity.this.nextOnboardingStep();
            }
        });
    }

    public static final /* synthetic */ BottomSheetPaymentSettingFragment access$getBottomSheetPaymentSettingFragment(HomeTabActivity homeTabActivity) {
        return (BottomSheetPaymentSettingFragment) homeTabActivity.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ CreatePinLauncher access$getCreatePinLauncher(HomeTabActivity homeTabActivity) {
        return (CreatePinLauncher) homeTabActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ long access$getCurrentUnixEpochTime(HomeTabActivity homeTabActivity) {
        return System.currentTimeMillis() / 1000;
    }

    public static final /* synthetic */ int access$getHomeIndex(HomeTabActivity homeTabActivity) {
        HomeFragmentStateAdapter homeFragmentStateAdapter = homeTabActivity.moveToNextValue;
        if (homeFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeFragmentStateAdapter = null;
        }
        return (1 < homeFragmentStateAdapter.getAuthRequestContext.size() ? homeFragmentStateAdapter.getAuthRequestContext.get(1) : null) instanceof HomeTabFragment ? 1 : 0;
    }

    public static final /* synthetic */ DanaConfirmationBottomSheetDialog access$getPinRegularChangesBottomSheet(HomeTabActivity homeTabActivity) {
        return (DanaConfirmationBottomSheetDialog) homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
    }

    public static final /* synthetic */ UiComponent access$getUiComponentChangePIN(HomeTabActivity homeTabActivity) {
        return (UiComponent) homeTabActivity.whenAvailable.getValue();
    }

    public static final /* synthetic */ VerifyPinLauncher access$getVerifyPinLauncher(HomeTabActivity homeTabActivity) {
        return (VerifyPinLauncher) homeTabActivity.readMicros.getValue();
    }

    public static final /* synthetic */ void access$initHomeTabDataAndSharedImages(HomeTabActivity homeTabActivity) {
        if (homeTabActivity.isFinishCheckSession) {
            homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                homeTabActivity.getSwipeDelegateListener().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public static final /* synthetic */ void access$isPopupKycQueryExceedLimit(HomeTabActivity homeTabActivity) {
        final KycRenewalPresenter kycRenewalPresenter = homeTabActivity.getKycRenewalPresenter().get();
        kycRenewalPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<Long, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getQueryKYCRenewalDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                dagger.Lazy lazy;
                if (j != -1 && j != 0 && !KycRenewalPresenter.BuiltInFictitiousFunctionClassFactory(j)) {
                    lazy = KycRenewalPresenter.this.lookAheadTest;
                    ((KycRenewalContract.View) lazy.get()).onError("");
                    return;
                }
                KycRenewalPresenter.this.getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getQueryKYCRenewalDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public static final /* synthetic */ void access$isPopupKycShowExceedLimit(HomeTabActivity homeTabActivity) {
        final KycRenewalPresenter kycRenewalPresenter = homeTabActivity.getKycRenewalPresenter().get();
        kycRenewalPresenter.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<ShowDialogPreference, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getShowKYCRenewalDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShowDialogPreference showDialogPreference) {
                invoke2(showDialogPreference);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShowDialogPreference showDialogPreference) {
                Intrinsics.checkNotNullParameter(showDialogPreference, "");
                if (!showDialogPreference.getShow() || !KycRenewalPresenter.MyBillsEntityDataFactory(showDialogPreference.getTimeStamp())) {
                    if (showDialogPreference.getShow() && KycRenewalPresenter.BuiltInFictitiousFunctionClassFactory(showDialogPreference.getTimeStamp())) {
                        KycRenewalPresenter.this.getAuthRequestContext();
                        return;
                    }
                    return;
                }
                final KycRenewalPresenter kycRenewalPresenter2 = KycRenewalPresenter.this;
                kycRenewalPresenter2.PlaceComponentResult.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getKYCRenewalButtonClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        if (z) {
                            return;
                        }
                        KycRenewalPresenter.this.PlaceComponentResult();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getKYCRenewalButtonClick$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getShowKYCRenewalDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public static final /* synthetic */ void access$openH5Container(HomeTabActivity homeTabActivity, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(str);
        DanaH5.startContainerFullUrl(sb.toString(), new DanaH5Listener() { // from class: id.dana.home.HomeTabActivity$openH5Container$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                HomeTabActivity.this.getHomeTabPresenter().get().BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public static final /* synthetic */ void access$runStorageLogger(HomeTabActivity homeTabActivity, boolean z) {
        WorkManager PlaceComponentResult2;
        WorkManager PlaceComponentResult3;
        if (!z) {
            PlaceComponentResult2 = WorkManagerImpl.PlaceComponentResult(homeTabActivity);
            PlaceComponentResult2.getAuthRequestContext("Storage Info");
            return;
        }
        Constraints.Builder builder = new Constraints.Builder();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        builder.MyBillsEntityDataFactory = false;
        builder.PlaceComponentResult = NetworkType.CONNECTED;
        Intrinsics.checkNotNullExpressionValue(builder, "");
        PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(GetStorageInfoWorker.class, 7L, TimeUnit.DAYS);
        builder2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new Constraints(builder);
        PeriodicWorkRequest.Builder MyBillsEntityDataFactory = builder2.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.PlaceComponentResult.add("Storage Info");
        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        PlaceComponentResult3 = WorkManagerImpl.PlaceComponentResult(homeTabActivity);
        PlaceComponentResult3.PlaceComponentResult(Collections.singletonList(KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static final /* synthetic */ void access$savePopupKycDismiss(HomeTabActivity homeTabActivity) {
        final KycRenewalPresenter kycRenewalPresenter = homeTabActivity.getKycRenewalPresenter().get();
        kycRenewalPresenter.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveKYCRenewalDismiss$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                KycRenewalPresenter.this.MyBillsEntityDataFactory(i + 1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveKYCRenewalDismiss$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public static final /* synthetic */ void access$setupDataAfterFinishCheckSession(HomeTabActivity homeTabActivity) {
        homeTabActivity.isFinishCheckSession = true;
        if (1 != 0) {
            homeTabActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                homeTabActivity.getSwipeDelegateListener().BuiltInFictitiousFunctionClassFactory();
            }
        }
        homeTabActivity.getHomeTabPresenter().get().getAuthRequestContext();
        HomeTabFragment moveToNextValue = homeTabActivity.moveToNextValue();
        if (moveToNextValue != null) {
            if (moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                moveToNextValue.pushNotificationPresenter.get().PlaceComponentResult();
            }
            if (moveToNextValue.isAdded() && moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                moveToNextValue.MyBillsEntityDataFactory();
                moveToNextValue.getAuthRequestContext();
            }
            if (moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 && moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                moveToNextValue.homePresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
            }
            FragmentManager childFragmentManager = (moveToNextValue.getActivity() == null || !moveToNextValue.isAdded()) ? null : moveToNextValue.getChildFragmentManager();
            if ((childFragmentManager == null ? null : (HomeRecycleFragment) childFragmentManager.findFragmentByTag(HomeTabFragment.FragmentTag.HOME_FRAGMENT)) != null) {
                FragmentManager childFragmentManager2 = (moveToNextValue.getActivity() == null || !moveToNextValue.isAdded()) ? null : moveToNextValue.getChildFragmentManager();
                (childFragmentManager2 != null ? (HomeRecycleFragment) childFragmentManager2.findFragmentByTag(HomeTabFragment.FragmentTag.HOME_FRAGMENT) : null).NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
        }
        homeTabActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$setupUpdateManager(HomeTabActivity homeTabActivity) {
        DanaUpdateManager danaUpdateManager = new DanaUpdateManager(homeTabActivity);
        homeTabActivity.getCallingPid = danaUpdateManager;
        danaUpdateManager.moveToNextValue = new DanaUpdateManager.SilentUpdateCallback() { // from class: id.dana.home.HomeTabActivity$setupUpdateManager$1
            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                DanaUpdateManager.SilentUpdateCallback.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                DanaUpdateManager.SilentUpdateCallback.CC.PlaceComponentResult();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final /* synthetic */ void PlaceComponentResult() {
                DanaUpdateManager.SilentUpdateCallback.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final /* synthetic */ void getAuthRequestContext() {
                DanaUpdateManager.SilentUpdateCallback.CC.getAuthRequestContext();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HomeTabActivity.access$checkUpdatesManually(HomeTabActivity.this);
            }
        };
    }

    public static final /* synthetic */ void access$showForceKycRenewalDialog(HomeTabActivity homeTabActivity) {
        HomeTabActivity homeTabActivity2 = homeTabActivity;
        KycRenewalDialog kycRenewalDialog = new KycRenewalDialog(homeTabActivity2, new View.OnClickListener() { // from class: id.dana.home.HomeTabActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTabActivity.$r8$lambda$jNCEc3yDmRng_JwdLecnQQv3GXg(HomeTabActivity.this, view);
            }
        });
        CustomDialog.Builder builder = new CustomDialog.Builder(kycRenewalDialog.BuiltInFictitiousFunctionClassFactory);
        builder.DatabaseTableConfigUtil = R.drawable.ic_kyc_renewal_dialog;
        builder.SubSequence = kycRenewalDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_renewal_dialog_title);
        builder.GetContactSyncConfig = kycRenewalDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_renewal_dialog_message);
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        String string = kycRenewalDialog.BuiltInFictitiousFunctionClassFactory.getString(R.string.kyc_renewal_dialog_update_button_text);
        View.OnClickListener onClickListener = kycRenewalDialog.MyBillsEntityDataFactory;
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode = onClickListener;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
        EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(homeTabActivity2);
        builder2.MyBillsEntityDataFactory = TrackerKey.Event.KYC_RENEWAL_APPEAR;
        builder2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder2, (byte) 0));
    }

    public static final /* synthetic */ void access$showLoadingDialogIfNeeded(HomeTabActivity homeTabActivity) {
        if (Intrinsics.areEqual(GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext, Boolean.TRUE)) {
            homeTabActivity.showDanaLoadingDialog();
        }
    }

    public static final /* synthetic */ void access$showPaymentSettingFailedDialog(HomeTabActivity homeTabActivity) {
        CustomDialog.Builder builder = new CustomDialog.Builder(homeTabActivity);
        builder.SubSequence = homeTabActivity.getString(R.string.payment_setting_failed_dialog_title);
        builder.GetContactSyncConfig = homeTabActivity.getString(R.string.payment_setting_failed_dialog_message);
        builder.DatabaseTableConfigUtil = R.drawable.ic_payment_setting_failed_dialog;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false);
        builder.PlaceComponentResult(false);
        builder.moveToNextValue = 0L;
        builder.BuiltInFictitiousFunctionClassFactory(homeTabActivity.getString(R.string.try_again), new Function1<View, Unit>() { // from class: id.dana.home.HomeTabActivity$showPaymentSettingFailedDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                materialDialog = HomeTabActivity.this.isLayoutRequested;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.dismiss();
                HomeTabActivity.this.getPaymentSettingPresenter().get().getAuthRequestContext("SWITCH_AOUTOROUTE_ON");
            }
        });
        builder.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.home.HomeTabActivity$showPaymentSettingFailedDialog$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MaterialDialog materialDialog;
                Intrinsics.checkNotNullParameter(view, "");
                materialDialog = HomeTabActivity.this.isLayoutRequested;
                if (materialDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    materialDialog = null;
                }
                materialDialog.dismiss();
                HomeTabActivity.this.nextOnboardingStep();
            }
        });
        MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        homeTabActivity.isLayoutRequested = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            BuiltInFictitiousFunctionClassFactory = null;
        }
        BuiltInFictitiousFunctionClassFactory.show();
    }

    public static final /* synthetic */ void access$startAlwaysAskPinPasswordChallenge(HomeTabActivity homeTabActivity, boolean z, PaymentSecuritySwitchModel paymentSecuritySwitchModel) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(homeTabActivity);
        builder.scheduleImpl = "payment_auth";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "payment_auth";
        Intrinsics.checkNotNull(paymentSecuritySwitchModel);
        new ChallengeControl(builder.getAuthRequestContext(z, paymentSecuritySwitchModel), null).getAuthRequestContext();
    }

    public static final /* synthetic */ void access$startRecommendSecurityChallenge(HomeTabActivity homeTabActivity, boolean z, String str, String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(homeTabActivity);
        builder.scheduleImpl = "auto_route";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "auto_route";
        new ChallengeControl(builder.MyBillsEntityDataFactory(z, str, str2), null).getAuthRequestContext();
    }

    public static final /* synthetic */ void access$switchPaymentAuth(HomeTabActivity homeTabActivity, PaymentSecurityInitModel paymentSecurityInitModel, String str, SettingModel settingModel) {
        List<AuthenticationTypeOptionModel> list;
        AuthenticationTypeOptionModel authenticationTypeOptionModel;
        boolean BuiltInFictitiousFunctionClassFactory = paymentSecurityInitModel != null ? paymentSecurityInitModel.BuiltInFictitiousFunctionClassFactory() : true;
        String str2 = (paymentSecurityInitModel == null || (list = paymentSecurityInitModel.PlaceComponentResult) == null || (authenticationTypeOptionModel = (AuthenticationTypeOptionModel) CollectionsKt.first((List) list)) == null) ? null : authenticationTypeOptionModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!Intrinsics.areEqual(str, "SWITCH_PAYMENT_AUTH_ON")) {
            if (BuiltInFictitiousFunctionClassFactory) {
                homeTabActivity.getPaymentSettingPresenter().get().getAuthRequestContext(false, str2, str, settingModel);
            } else {
                new PaymentSettingSuccessDialog(homeTabActivity, new HomeTabActivity$$ExternalSyntheticLambda4(homeTabActivity)).PlaceComponentResult();
            }
        } else if (!BuiltInFictitiousFunctionClassFactory) {
            homeTabActivity.getPaymentSettingPresenter().get().getAuthRequestContext(true, str2, str, settingModel);
        } else {
            homeTabActivity.nextOnboardingStep();
            homeTabActivity.KClassImpl$Data$declaredNonStaticMembers$2(settingModel, false, false);
        }
    }

    private static boolean getAuthRequestContext(OnBackToHomepageMessageEvent p0) {
        Bundle bundle = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        return bundle != null && bundle.getBoolean(IntentKeySource.DEEPLINK.ON_TRANSACTION_DEEPLINK_PAYMENT, false);
    }

    @Override // android.app.Activity
    public final void finish() {
        getDanaContactPresenter().get().onDestroy();
        getPaymentSettingPresenter().get().onDestroy();
        getKycRenewalPresenter().get().onDestroy();
        getPlayStoreReviewPresenter().get().onDestroy();
        getGlobalNetworkPresenter().get().onDestroy();
        getTncSummaryPresenter().get().onDestroy();
        getKycAmlEddPresenter().get().onDestroy();
        super.finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onOpenDeeplink(DeeplinkServiceProvider.OpenDeeplinkMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (Intrinsics.areEqual(Uri.parse(event.KClassImpl$Data$declaredNonStaticMembers$2).getPath(), "/miniprogram")) {
            GContainer.closeAllContainers();
        }
        getDeeplinkReader().get().MyBillsEntityDataFactory(event.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Subscribe
    public final void onReceiveDeeplinkServiceMessageEvent(DeeplinkServiceProvider.MessageEvent event) {
        HomeTabFragment moveToNextValue;
        HomeTabFragment moveToNextValue2;
        Intrinsics.checkNotNullParameter(event, "");
        String str = event.getAuthRequestContext;
        switch (str.hashCode()) {
            case -1897368214:
                if (!str.equals(DeeplinkService.Scene.QR_PAY) || (moveToNextValue = moveToNextValue()) == null) {
                    return;
                }
                moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2();
                Intent createPayActivityIntent = PayActivity.createPayActivityIntent(moveToNextValue.getBaseActivity(), TrackerKey.SourceType.HOME_PAY_BUTTON);
                createPayActivityIntent.putExtra(PayActivity.MP_POSITION, 1);
                createPayActivityIntent.addFlags(67141632);
                moveToNextValue.startActivityForResult(createPayActivityIntent, HomeTabFragment.PlaceComponentResult);
                GContainer.closeAllContainers();
                return;
            case -1814683163:
                if (!str.equals(DeeplinkService.Scene.TOP_UP)) {
                    return;
                }
                break;
            case 2539133:
                if (!str.equals(DeeplinkService.Scene.SCAN) || (moveToNextValue2 = moveToNextValue()) == null) {
                    return;
                }
                moveToNextValue2.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2();
                Intent createPayActivityIntent2 = PayActivity.createPayActivityIntent(moveToNextValue2.getBaseActivity(), TrackerKey.SourceType.HOME_PAY_BUTTON);
                createPayActivityIntent2.putExtra(PayActivity.MP_POSITION, 0);
                createPayActivityIntent2.addFlags(67141632);
                moveToNextValue2.startActivityForResult(createPayActivityIntent2, HomeTabFragment.PlaceComponentResult);
                GContainer.closeAllContainers();
                return;
            case 93594810:
                if (!str.equals(DeeplinkService.Scene.WEB_PAGE)) {
                    return;
                }
                break;
            case 1885613522:
                if (!str.equals(DeeplinkService.Scene.BIND_CARD)) {
                    return;
                }
                break;
            default:
                return;
        }
        String str2 = event.MyBillsEntityDataFactory;
        if (str2 == null) {
            return;
        }
        String str3 = event.PlaceComponentResult;
        if (UrlUtil.getErrorConfigVersion(str2)) {
            getDeeplinkReader().get().BuiltInFictitiousFunctionClassFactory(str2, str3);
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(str2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReturnToHomepage(OnBackToHomepageMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        Bundle bundle = event.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z = true;
        if (bundle != null && bundle.getBoolean(IntentKeySource.TransactionKey.ON_TRANSACTION_SUCCESS, false)) {
            getPlayStoreReviewPresenter().get().PlaceComponentResult();
            return;
        }
        Bundle bundle2 = event.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bundle2 != null && bundle2.getBoolean(IntentKeySource.FamilyAccountKey.ON_INVITATION_REJECTED, false)) {
            getSwipeDelegateListener().KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (getAuthRequestContext(event)) {
            Bundle bundle3 = event.KClassImpl$Data$declaredNonStaticMembers$2;
            String string = bundle3 != null ? bundle3.getString(IntentKeySource.DEEPLINK.MERCHANT_RETURN_URL) : null;
            String str = string;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            Boolean lookAheadTest = UrlUtil.lookAheadTest(string);
            Intrinsics.checkNotNullExpressionValue(lookAheadTest, "");
            if (lookAheadTest.booleanValue()) {
                ContextExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this, string, null, 6);
            }
        }
    }

    public final void showDeeplinkErrorDialog() {
        ((DialogWithImage) this.scheduleImpl.getValue()).MyBillsEntityDataFactory();
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (H ^ 4796183387843776835L);
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
