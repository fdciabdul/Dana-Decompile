package id.dana.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.EdgeEffect;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.viewbinding.ViewBinding;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.metrics.Trace;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeRecycleFragment$swipeListener$2;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.adapter.HomeViewWidgetModel;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.appshortcut.DanaAppShortcut;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.pin.LogoutContract;
import id.dana.constants.ErrorCode;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.tracker.DeeplinkFlowValue;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.contract.inbox.UnreadInboxModule;
import id.dana.contract.ott.OttVerifyContract;
import id.dana.contract.ott.OttVerifyModule;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.contract.permission.PermissionStateModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder;
import id.dana.core.ui.util.ViewUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.databinding.FragmentHomeRecycleBinding;
import id.dana.databinding.ViewHomeToolbarDanaBalanceBinding;
import id.dana.databinding.ViewHomeToolbarMenuBinding;
import id.dana.databinding.ViewItemNearbyWidgetBinding;
import id.dana.databinding.ViewItemPromoWidgetBinding;
import id.dana.databinding.ViewItemServicesWidgetBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerHomeRecycleComponent;
import id.dana.di.component.HomeRecycleComponent;
import id.dana.di.modules.BiometricAnalyticModule;
import id.dana.di.modules.GeofenceModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DialogPermission;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence;
import id.dana.domain.featureconfig.model.GeofenceConfig;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.eventbus.base.BaseFragmentWithPageLoadTracker;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeofenceContract;
import id.dana.geofence.GeofenceManager;
import id.dana.geofence.model.PoiModel;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.HasNewModel;
import id.dana.model.HomeDataModel;
import id.dana.model.HomeInfo;
import id.dana.model.KycInfo;
import id.dana.model.OttVerifyModel;
import id.dana.model.PromotionModel;
import id.dana.model.ThirdPartyService;
import id.dana.model.UserInfo;
import id.dana.nearbyme.NewNearbyMeView;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.oauth.MatchPhoneNumberDialog;
import id.dana.onboarding.OnboardingActivity;
import id.dana.pay.PayCardInfo;
import id.dana.pay.model.PayCardConfigModel;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.richview.NewPromoBannerView;
import id.dana.richview.servicescard.ServiceCardListener;
import id.dana.richview.servicescard.ServiceCardV2View;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.social.utils.SyncContactsEngineWorker;
import id.dana.sync_engine.domain.model.ConfigRepeatBackgroundJob;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.sync_engine.permission.PermissionUtil;
import id.dana.sync_engine.permission.workmanager.SyncPermissionWorker;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.BiometricAnalyticTracker;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.BalanceUtil;
import id.dana.utils.OnSwipeListener;
import id.dana.utils.UrlUtil;
import id.dana.utils.ViewHelper;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import io.reactivex.internal.util.NotificationLite;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.C;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u009c\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Û\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004Û\u0002Ü\u0002B\b¢\u0006\u0005\bÚ\u0002\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J-\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016¢\u0006\u0004\b\u0005\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b!\u0010\"J)\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\t\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020$2\u0006\u0010\f\u001a\u00020%H\u0002¢\u0006\u0004\b&\u0010'J!\u0010\u0005\u001a\u0004\u0018\u00010%2\u0006\u0010\t\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020$H\u0002¢\u0006\u0004\b\u0005\u0010(J%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\t\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#H\u0002¢\u0006\u0004\b\u0005\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010\u0006J\u000f\u00101\u001a\u000200H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0004\b:\u0010;J\u0011\u0010=\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0002¢\u0006\u0004\bC\u0010DJ\u0015\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0015\u001a\u00020#2\u0006\u0010\t\u001a\u00020#H\u0002¢\u0006\u0004\b\u0015\u0010IJ\u000f\u0010J\u001a\u00020#H\u0014¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bM\u0010NJ\u0011\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bY\u0010ZJ\u0011\u0010\\\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010_\u001a\u00020^H\u0002¢\u0006\u0004\b_\u0010`J\u0011\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\be\u0010fJ\u0011\u0010h\u001a\u0004\u0018\u00010gH\u0002¢\u0006\u0004\bh\u0010iJ\u000f\u0010k\u001a\u00020jH\u0002¢\u0006\u0004\bk\u0010lJ\u000f\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u0004H\u0002¢\u0006\u0004\bp\u0010\u0006J\u000f\u0010r\u001a\u00020qH\u0002¢\u0006\u0004\br\u0010sJ\r\u0010t\u001a\u00020\r¢\u0006\u0004\bt\u0010\u0013J\u000f\u0010u\u001a\u00020\u0004H\u0002¢\u0006\u0004\bu\u0010\u0006J\u0015\u0010w\u001a\b\u0012\u0004\u0012\u00020*0vH\u0002¢\u0006\u0004\bw\u0010HJ\u000f\u0010x\u001a\u00020\u0004H\u0014¢\u0006\u0004\bx\u0010\u0006J\u000f\u0010y\u001a\u00020\u0004H\u0002¢\u0006\u0004\by\u0010\u0006J\u000f\u0010z\u001a\u00020\u0004H\u0002¢\u0006\u0004\bz\u0010\u0006J\r\u0010{\u001a\u00020\u0004¢\u0006\u0004\b{\u0010\u0006J\u000f\u0010|\u001a\u00020\u0004H\u0002¢\u0006\u0004\b|\u0010\u0006J\u000f\u0010}\u001a\u00020\u0004H\u0002¢\u0006\u0004\b}\u0010\u0006J\u000f\u0010~\u001a\u00020\u0004H\u0002¢\u0006\u0004\b~\u0010\u0006J\u000f\u0010\u007f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u007f\u0010\u0006J\u0011\u0010\u0080\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014¢\u0006\u0005\b\u0015\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0082\u0001\u0010\u0006J\u0011\u0010\u0083\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u0006J\u0014\u0010\u0084\u0001\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0006J\u0011\u0010\u0087\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0006J\u0013\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0006J-\u0010\u008d\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#2\t\u0010\f\u001a\u0005\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u000f\u0010\u008f\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u008f\u0001\u0010\u0006J\u0011\u0010\u0090\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0006J\u001b\u0010\u0092\u0001\u001a\u00020\u00042\u0007\u0010\t\u001a\u00030\u0091\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0094\u0001\u0010\u0006J\u000f\u0010\u0095\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u0095\u0001\u0010\u0006J\u001a\u0010\u0096\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0098\u0001\u0010\u0006J\u001c\u0010\u0099\u0001\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u009b\u0001\u0010\u0006J\u0011\u0010\u009c\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u009c\u0001\u0010\u0006J\u0011\u0010\u009d\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u009d\u0001\u0010\u0006J\u0011\u0010\u009e\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u009e\u0001\u0010\u0006J\u0011\u0010\u009f\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0006J\u0011\u0010 \u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b \u0001\u0010\u0006J$\u0010£\u0001\u001a\u00020\u00042\u0007\u0010\t\u001a\u00030¡\u00012\u0007\u0010\u000b\u001a\u00030¢\u0001H\u0016¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0011\u0010¥\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b¥\u0001\u0010\u0006J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016H\u0002¢\u0006\u0004\b&\u0010\u0017J\u0013\u0010¦\u0001\u001a\u00030\u0088\u0001H\u0002¢\u0006\u0006\b¦\u0001\u0010\u008a\u0001J\u0011\u0010§\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b§\u0001\u0010\u0006J\u0011\u0010¨\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¨\u0001\u0010\u0006J\u0011\u0010©\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b©\u0001\u0010\u0006J0\u0010£\u0001\u001a\u00020\u00042\u001c\u0010\t\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010ª\u0001¢\u0006\u0003\b¬\u0001H\u0002¢\u0006\u0006\b£\u0001\u0010\u00ad\u0001J\u0011\u0010®\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b®\u0001\u0010\u0006J\u001a\u0010¯\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0006\b¯\u0001\u0010\u0097\u0001J\u001a\u0010°\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0006\b°\u0001\u0010\u0097\u0001J\u001b\u0010\u0015\u001a\u00020\u00042\t\u0010\t\u001a\u0005\u0018\u00010±\u0001H\u0002¢\u0006\u0005\b\u0015\u0010²\u0001J\u0017\u0010³\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\r¢\u0006\u0005\b³\u0001\u0010\u0006J\u001a\u0010´\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0006\b´\u0001\u0010\u0097\u0001J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020#H\u0002¢\u0006\u0005\b&\u0010µ\u0001J\u001c\u0010¯\u0001\u001a\u00030¶\u00012\u0007\u0010\t\u001a\u00030\u0091\u0001H\u0002¢\u0006\u0006\b¯\u0001\u0010·\u0001J\u0011\u0010¸\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¸\u0001\u0010\u0006J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\r¢\u0006\u0005\b&\u0010\u0097\u0001J\u0019\u0010¯\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¯\u0001\u0010\u0017J\u0011\u0010¹\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¹\u0001\u0010\u0006J\u000f\u0010º\u0001\u001a\u00020\u0004¢\u0006\u0005\bº\u0001\u0010\u0006J.\u0010£\u0001\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0006\b£\u0001\u0010»\u0001J&\u0010&\u001a\u00020\u00042\t\u0010\t\u001a\u0005\u0018\u00010¼\u00012\t\u0010\u000b\u001a\u0005\u0018\u00010½\u0001H\u0002¢\u0006\u0005\b&\u0010¾\u0001J\u0011\u0010¿\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¿\u0001\u0010\u0006J\u0011\u0010À\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0006J\"\u0010£\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0006\b£\u0001\u0010Á\u0001J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0015\u0010Á\u0001J3\u0010&\u001a\u00020\u00042\u0007\u0010\t\u001a\u00030¢\u00012\u0007\u0010\u000b\u001a\u00030¢\u00012\u0006\u0010\f\u001a\u00020\n2\u0007\u0010Â\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b&\u0010Ã\u0001J\u0011\u0010Ä\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÄ\u0001\u0010\u0006J\u0011\u0010Å\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÅ\u0001\u0010\u0006J\u0011\u0010Æ\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÆ\u0001\u0010\u0006J\u0011\u0010Ç\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÇ\u0001\u0010\u0006J*\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0002¢\u0006\u0005\b&\u0010È\u0001J\u0011\u0010É\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÉ\u0001\u0010\u0006J\u001d\u0010£\u0001\u001a\u00020\u00042\t\u0010\t\u001a\u0005\u0018\u00010Ê\u0001H\u0002¢\u0006\u0006\b£\u0001\u0010Ë\u0001J$\u0010£\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0006\b£\u0001\u0010Ì\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\u0007\u0010\t\u001a\u00030Í\u0001H\u0002¢\u0006\u0005\b\u0005\u0010Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÏ\u0001\u0010\u0006J\u001b\u0010£\u0001\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0005\b£\u0001\u0010\u0017J\u0011\u0010Ð\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÐ\u0001\u0010\u0006J*\u0010£\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#2\u0006\u0010\f\u001a\u00020$H\u0002¢\u0006\u0006\b£\u0001\u0010Ñ\u0001J\u000f\u0010Ò\u0001\u001a\u00020\u0004¢\u0006\u0005\bÒ\u0001\u0010\u0006R\u001b\u0010&\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010Ô\u0001R\u0013\u0010¯\u0001\u001a\u00020$8G¢\u0006\u0007\u001a\u0005\b&\u0010Õ\u0001R\u001f\u0010\u0005\u001a\u00030Ö\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\bG\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001R \u0010\u0015\u001a\u00030Ö\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÚ\u0001\u0010×\u0001\u001a\u0006\bÛ\u0001\u0010Ù\u0001R!\u0010£\u0001\u001a\u00030Ö\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÜ\u0001\u0010×\u0001\u001a\u0006\bÝ\u0001\u0010Ù\u0001R!\u0010´\u0001\u001a\u00030Ö\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÞ\u0001\u0010×\u0001\u001a\u0006\bß\u0001\u0010Ù\u0001R\u0018\u0010á\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bà\u0001\u0010nR\u0019\u0010ä\u0001\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R \u0010æ\u0001\u001a\u00030å\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bæ\u0001\u0010ç\u0001\u001a\u0006\b°\u0001\u0010è\u0001R'\u0010ë\u0001\u001a\n\u0012\u0005\u0012\u00030ê\u00010é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\b´\u0001\u0010í\u0001R\u001c\u0010ñ\u0001\u001a\u0005\u0018\u00010î\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u0019\u0010°\u0001\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ã\u0001R\u0019\u0010à\u0001\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ã\u0001R'\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030ô\u00010é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bõ\u0001\u0010ì\u0001\u001a\u0006\bö\u0001\u0010í\u0001R'\u0010ø\u0001\u001a\n\u0012\u0005\u0012\u00030÷\u00010é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bø\u0001\u0010ì\u0001\u001a\u0006\bá\u0001\u0010í\u0001R\u0018\u0010Ú\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bù\u0001\u0010nR\u0017\u0010Ü\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u0010nR\u001d\u0010û\u0001\u001a\n\u0012\u0005\u0012\u00030ú\u00010é\u0001X\u0087\"¢\u0006\b\n\u0006\bû\u0001\u0010ì\u0001R \u0010ý\u0001\u001a\u00030ü\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bý\u0001\u0010þ\u0001\u001a\u0006\bñ\u0001\u0010ÿ\u0001R'\u0010\u0081\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0081\u0002\u0010ì\u0001\u001a\u0006\bä\u0001\u0010í\u0001R'\u0010\u0083\u0002\u001a\n\u0012\u0005\u0012\u00030\u0082\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0083\u0002\u0010ì\u0001\u001a\u0006\b\u0084\u0002\u0010í\u0001R'\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0086\u0002\u0010ì\u0001\u001a\u0006\b\u0087\u0002\u0010í\u0001R'\u0010\u0089\u0002\u001a\n\u0012\u0005\u0012\u00030\u0088\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u0089\u0002\u0010ì\u0001\u001a\u0006\b\u008a\u0002\u0010í\u0001R'\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u00030\u008b\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u008c\u0002\u0010ì\u0001\u001a\u0006\bÞ\u0001\u0010í\u0001R'\u0010\u008e\u0002\u001a\n\u0012\u0005\u0012\u00030\u008d\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u008e\u0002\u0010ì\u0001\u001a\u0006\bÚ\u0001\u0010í\u0001R\u001b\u0010Þ\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010ã\u0001R!\u0010G\u001a\u0005\u0018\u00010\u008f\u00028\u0007X\u0087\u0006¢\u0006\u0010\n\u0006\b\u0090\u0002\u0010\u0091\u0002\u001a\u0006\bÜ\u0001\u0010\u0092\u0002R*\u0010ò\u0001\u001a\u00030\u0093\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bä\u0001\u0010\u0094\u0002\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b£\u0001\u0010\u0097\u0002R\u0019\u0010ù\u0001\u001a\u0004\u0018\u00010<8\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R'\u0010\u009b\u0002\u001a\n\u0012\u0005\u0012\u00030\u009a\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u009b\u0002\u0010ì\u0001\u001a\u0006\b\u009c\u0002\u0010í\u0001R'\u0010\u009e\u0002\u001a\n\u0012\u0005\u0012\u00030\u009d\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u009e\u0002\u0010ì\u0001\u001a\u0006\b\u009f\u0002\u0010í\u0001R'\u0010 \u0002\u001a\n\u0012\u0005\u0012\u00030«\u00010é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b \u0002\u0010ì\u0001\u001a\u0006\b¡\u0002\u0010í\u0001R\u0018\u0010ó\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010nR\u0018\u0010ï\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b³\u0001\u0010nR(\u0010â\u0001\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r8\u0002@CX\u0083\u000e¢\u0006\u000f\n\u0005\b¢\u0002\u0010n\"\u0006\b£\u0001\u0010\u0097\u0001R&\u0010t\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r8\u0002@CX\u0083\u000e¢\u0006\u000e\n\u0005\bÒ\u0001\u0010n\"\u0005\b\u0015\u0010\u0097\u0001R\u0018\u0010\u0095\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bº\u0001\u0010nR\u001a\u0010\u0098\u0002\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0007\u0010£\u0002R$\u0010\u0090\u0002\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r@GX\u0087\n¢\u0006\r\n\u0004\b\u0018\u0010n\"\u0005\b\u0090\u0002\u0010\u0006R\u0017\u0010\u008f\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010nR\u0017\u0010Ò\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010nR\u0017\u0010º\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010nR%\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r8\u0002@CX\u0083\u000e¢\u0006\r\n\u0004\b\u0010\u0010n\"\u0005\b\u0005\u0010\u0097\u0001R\u0017\u0010¢\u0002\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010nR\u0017\u0010³\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010nR\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010nR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010nR\u0017\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bØ\u0001\u0010nR\u001b\u0010\u0010\u001a\u0005\u0018\u00010¤\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010¥\u0002R\u0019\u0010\u0014\u001a\u00030¦\u00028\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\bÛ\u0001\u0010§\u0002R\u001a\u0010\u0019\u001a\u0005\u0018\u00010¨\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b!\u0010©\u0002R\u001a\u0010\u001c\u001a\u0005\u0018\u00010ª\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010«\u0002R'\u0010\u00ad\u0002\u001a\n\u0012\u0005\u0012\u00030¬\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b\u00ad\u0002\u0010ì\u0001\u001a\u0006\bà\u0001\u0010í\u0001R'\u0010¯\u0002\u001a\n\u0012\u0005\u0012\u00030®\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b¯\u0002\u0010ì\u0001\u001a\u0006\b°\u0002\u0010í\u0001R\u001b\u0010\u001b\u001a\u0005\u0018\u00010±\u00028\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bß\u0001\u0010²\u0002R'\u0010´\u0002\u001a\n\u0012\u0005\u0012\u00030³\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b´\u0002\u0010ì\u0001\u001a\u0006\bµ\u0002\u0010í\u0001R'\u0010·\u0002\u001a\n\u0012\u0005\u0012\u00030¶\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b·\u0002\u0010ì\u0001\u001a\u0006\b¸\u0002\u0010í\u0001R \u0010º\u0002\u001a\u00030¹\u00028\u0007X\u0087&¢\u0006\u0010\n\u0006\bº\u0002\u0010»\u0002\u001a\u0006\b¼\u0002\u0010½\u0002R'\u0010¿\u0002\u001a\n\u0012\u0005\u0012\u00030¾\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\b¿\u0002\u0010ì\u0001\u001a\u0006\bó\u0001\u0010í\u0001R*\u0010Ø\u0001\u001a\u00030À\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bñ\u0001\u0010Á\u0002\u001a\u0006\bù\u0001\u0010Â\u0002\"\u0006\b¯\u0001\u0010Ã\u0002R'\u0010Å\u0002\u001a\n\u0012\u0005\u0012\u00030Ä\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÅ\u0002\u0010ì\u0001\u001a\u0006\bò\u0001\u0010í\u0001R'\u0010Ç\u0002\u001a\n\u0012\u0005\u0012\u00030Æ\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÇ\u0002\u0010ì\u0001\u001a\u0006\bâ\u0001\u0010í\u0001R\u0019\u0010\u001a\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b-\u0010È\u0002R\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u0010nR'\u0010Ê\u0002\u001a\n\u0012\u0005\u0012\u00030É\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÊ\u0002\u0010ì\u0001\u001a\u0006\bï\u0001\u0010í\u0001R\u0018\u0010ß\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u0010-R)\u0010!\u001a\u00030Ë\u00028\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bá\u0001\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002\"\u0006\b£\u0001\u0010Ï\u0002R \u0010Ý\u0001\u001a\u00030Ð\u00028CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b/\u0010×\u0001\u001a\u0006\bÑ\u0002\u0010Ò\u0002R\u001b\u0010Û\u0001\u001a\u0005\u0018\u00010Ó\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b1\u0010Ô\u0002R'\u0010Ö\u0002\u001a\n\u0012\u0005\u0012\u00030Õ\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÖ\u0002\u0010ì\u0001\u001a\u0006\b×\u0002\u0010í\u0001R'\u0010Ù\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020é\u00018\u0007X\u0087&¢\u0006\u0010\n\u0006\bÙ\u0002\u0010ì\u0001\u001a\u0006\b\u0098\u0002\u0010í\u0001"}, d2 = {"Lid/dana/home/HomeRecycleFragment;", "Lid/dana/eventbus/base/BaseFragmentWithPageLoadTracker;", "Lid/dana/databinding/FragmentHomeRecycleBinding;", "Lin/srain/cube/views/ptr/PtrHandler;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "SubSequence", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "p0", "Landroid/view/View;", "p1", "p2", "", "checkCanDoRefresh", "(Lin/srain/cube/views/ptr/PtrFrameLayout;Landroid/view/View;Landroid/view/View;)Z", "A", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "()Z", "VerifyPinStateManager$executeRiskChallenge$2$1", "MyBillsEntityDataFactory", "", "(Ljava/lang/String;)V", DiskFormatter.B, "E", "VerifyPinStateManager$executeRiskChallenge$2$2", "getOnBoardingScenario", "getValueOfTouchPositionAbsolute", "Lid/dana/contract/user/GetBalanceModule;", LogConstants.RESULT_FALSE, "()Lid/dana/contract/user/GetBalanceModule;", "Landroidx/fragment/app/FragmentManager;", SummaryActivity.HOURS, "()Landroidx/fragment/app/FragmentManager;", "", "", "Landroid/animation/ValueAnimator;", "getAuthRequestContext", "(IFLandroid/animation/ValueAnimator;)Landroid/animation/ValueAnimator;", "(IF)Landroid/animation/ValueAnimator;", "", "Lid/dana/home/adapter/HomeViewWidgetModel;", "(I)Ljava/util/Set;", "Lid/dana/home/adapter/HomeAdapter$FourKingViewHolder;", "J", "()Lid/dana/home/adapter/HomeAdapter$FourKingViewHolder;", DiskFormatter.MB, "Lid/dana/di/modules/GeofenceModule;", DiskFormatter.KB, "()Lid/dana/di/modules/GeofenceModule;", "Lid/dana/di/modules/GlobalNetworkModule;", "getNameOrBuilderList", "()Lid/dana/di/modules/GlobalNetworkModule;", "Lid/dana/contract/globalsearch/GlobalSearchModule;", "L", "()Lid/dana/contract/globalsearch/GlobalSearchModule;", "Lid/dana/home/adapter/HomeAdapter$GlobalSearchViewHolder;", "Q", "()Lid/dana/home/adapter/HomeAdapter$GlobalSearchViewHolder;", "Lid/dana/home/HomeFragmentListener;", "O", "()Lid/dana/home/HomeFragmentListener;", "Lid/dana/contract/homeinfo/HomeInfoModule;", "N", "()Lid/dana/contract/homeinfo/HomeInfoModule;", "Lid/dana/di/modules/HomeTabModules;", "SummaryVoucherView$$ExternalSyntheticLambda0", "()Lid/dana/di/modules/HomeTabModules;", "", "Lid/dana/showcase/target/Target;", "GetContactSyncConfig", "()Ljava/util/List;", "(I)I", "getLayout", "()I", "Lid/dana/di/modules/LogoutModule;", "P", "()Lid/dana/di/modules/LogoutModule;", "Lid/dana/home/adapter/HomeAdapter$NearbyViewHolder;", "S", "()Lid/dana/home/adapter/HomeAdapter$NearbyViewHolder;", "Lid/dana/contract/ott/OttVerifyModule;", "SummaryVoucherView$$ExternalSyntheticLambda1", "()Lid/dana/contract/ott/OttVerifyModule;", "Lid/dana/contract/paylater/PayLaterModule;", "R", "()Lid/dana/contract/paylater/PayLaterModule;", "Lid/dana/contract/permission/PermissionStateModule;", "isAuth", "()Lid/dana/contract/permission/PermissionStateModule;", "Lid/dana/home/adapter/HomeAdapter$PromoViewHolder;", "SummaryVoucherView$$ExternalSyntheticLambda2", "()Lid/dana/home/adapter/HomeAdapter$PromoViewHolder;", "Lid/dana/contract/payasset/QueryPayMethodModule;", "W", "()Lid/dana/contract/payasset/QueryPayMethodModule;", "Lid/dana/home/adapter/HomeAdapter$ServicesViewHolder;", "X", "()Lid/dana/home/adapter/HomeAdapter$ServicesViewHolder;", "Lid/dana/contract/services/ServicesModule;", "V", "()Lid/dana/contract/services/ServicesModule;", "Lid/dana/home/adapter/HomeAdapter$SocialWidgetHolder;", "U", "()Lid/dana/home/adapter/HomeAdapter$SocialWidgetHolder;", "Lid/dana/home/HomeRecycleFragment$getSpringEdgeEffect$1;", "T", "()Lid/dana/home/HomeRecycleFragment$getSpringEdgeEffect$1;", "Lid/dana/contract/inbox/UnreadInboxModule;", "Z", "()Lid/dana/contract/inbox/UnreadInboxModule;", "shouldRecycleViewType", "Lid/dana/contract/user/GetUserInfoModule;", "flip", "()Lid/dana/contract/user/GetUserInfoModule;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "isAuto", "", "b", IAPSyncCommand.COMMAND_INIT, "c", "QrExpiredActivity", "reduceIndexed-z1zDJgo", d.f7256a, "a", "FillAnimation", f.f7258a, "TypeProjectionImpl", "(Landroid/view/View;)Lid/dana/databinding/FragmentHomeRecycleBinding;", e.PlaceComponentResult, "g", "FlowViewUtil$textChanges$1", "()Ljava/lang/Boolean;", "connectForeground", "FlowViewUtil$textChanges$2", "Landroid/view/View$OnClickListener;", i.MyBillsEntityDataFactory, "()Landroid/view/View$OnClickListener;", "h", "Landroid/content/Intent;", "onActivityResult", "(IILandroid/content/Intent;)V", "FragmentBottomSheetPaymentSettingBinding", "k", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "onDestroy", "NetworkUserEntityData$$ExternalSyntheticLambda3", "onHiddenChanged", "(Z)V", "onPause", "onRefreshBegin", "(Lin/srain/cube/views/ptr/PtrFrameLayout;)V", "onResume", "onSelected", "onStart", "access$throwIllegalArgumentType", "l", "m", "Lid/dana/eventbus/models/TimerEvent;", "", "PlaceComponentResult", "(Lid/dana/eventbus/models/TimerEvent;J)V", "onUnSelected", "j", "DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider", "OtpRegistrationPresenter$input$2", "n", "Lkotlin/Function1;", "Lid/dana/home/tracker/HomeTrackerImpl;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", BranchLinkConstant.PayloadKey.PROMO_CODE, "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/model/HasNewModel;", "(Lid/dana/model/HasNewModel;)V", "whenAvailable", "moveToNextValue", "(I)V", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "SizeSelectors$OrSelector", SecurityConstants.KEY_TEXT, "getSupportButtonTintMode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", BranchLinkConstant.PayloadKey.REFERRAL, "s", "(Landroid/view/View;Landroid/view/View;)V", "p3", "(JJLandroid/view/View;Landroid/view/View;)V", HereUrlConstant.QUERY, "x", SecurityConstants.KEY_VALUE, "TypefaceCompatApi26Impl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "w", "Lid/dana/model/HomeInfo;", "(Lid/dana/model/HomeInfo;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/model/PromotionModel;", "(Lid/dana/model/PromotionModel;)V", "u", "z", "(IIF)V", "readMicros", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "()F", "Landroid/view/animation/TranslateAnimation;", "Lkotlin/Lazy;", SummaryActivity.DAYS, "()Landroid/view/animation/TranslateAnimation;", "initRecordTimeStamp", "AppCompatEmojiTextHelper", "DatabaseTableConfigUtil", "I", "NetworkUserEntityData$$ExternalSyntheticLambda1", DiskFormatter.GB, "NetworkUserEntityData$$ExternalSyntheticLambda2", "lookAheadTest", "isLayoutRequested", "Ljava/lang/String;", "scheduleImpl", "Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "biometricAnalyticTracker", "Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "()Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "Ldagger/Lazy;", "Lid/dana/cashier/CashierEventHandler;", "cashierEventHandler", "Ldagger/Lazy;", "()Ldagger/Lazy;", "Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "getErrorConfigVersion", "PrepareContext", "newProxyInstance", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "deeplinkTracker", "setNetAuthId", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "Lid/dana/geofence/GeofenceManager;", "geoFenceManager", "Lid/dana/geofence/GeoFencePresenter;", "geofencePresenter", "initAnimators", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getBalancePresenter", "RequestMoneyQrContract$View", "Lid/dana/contract/user/GetUserInfoContract$Presenter;", "getUserInfoPresenter", "y", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "globalNetworkPresenter", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "globalSearchPresenter", "Lid/dana/home/adapter/HomeAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/home/adapter/HomeAdapter;", "()Lid/dana/home/adapter/HomeAdapter;", "Lid/dana/di/component/HomeRecycleComponent;", "Lid/dana/di/component/HomeRecycleComponent;", "getCardNumberOCR", "()Lid/dana/di/component/HomeRecycleComponent;", "(Lid/dana/di/component/HomeRecycleComponent;)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/home/HomeFragmentListener;", "Lid/dana/contract/homeinfo/HomeInfoContract$Presenter;", "homeInfoContractPresenter", "verifyNotNull", "Lid/dana/home/presenter/HomeTabContract$Presenter;", "homeTabPresenter", "FlowableCreate$BufferAsyncEmitter", "homeTracker", "OtpRegistrationPresenter$input$1", "getCallingPid", "Ljava/lang/Boolean;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lid/dana/dialog/DialogPermission;", "Lid/dana/dialog/DialogPermission;", "Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "locationPermissionSubject", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "logoutPresenter", "FlowableReduce$ReduceSubscriber", "Lid/dana/oauth/MatchPhoneNumberDialog;", "Lid/dana/oauth/MatchPhoneNumberDialog;", "Lid/dana/contract/ott/OttVerifyContract$Presenter;", "ottVerifyPresenter", "getDefaultSenderId", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "payLaterPresenter", "onDecodeSuccess", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "paylaterAnalyticTracker", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "getContainerAuth", "()Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "Lid/dana/contract/permission/PermissionStateContract$Presenter;", "permissionStatePresenter", "Lid/dana/home/HomeRecycleFragment$PullBehaviorListener;", "Lid/dana/home/HomeRecycleFragment$PullBehaviorListener;", "()Lid/dana/home/HomeRecycleFragment$PullBehaviorListener;", "(Lid/dana/home/HomeRecycleFragment$PullBehaviorListener;)V", "Lid/dana/contract/payasset/QueryPayMethodContract$Presenter;", "queryPayMethodPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Ljava/lang/Integer;", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicePresenter", "Lid/dana/home/SwipeDelegateListener;", "Lid/dana/home/SwipeDelegateListener;", "secondaryHash", "()Lid/dana/home/SwipeDelegateListener;", "(Lid/dana/home/SwipeDelegateListener;)V", "Lid/dana/home/HomeRecycleFragment$swipeListener$2$1;", "Y", "()Lid/dana/home/HomeRecycleFragment$swipeListener$2$1;", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "Lid/dana/contract/inbox/UnreadInboxContract$Presenter;", "unreadInboxPresenter", "JsonParseException", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "<init>", "Companion", "PullBehaviorListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeRecycleFragment extends BaseFragmentWithPageLoadTracker<FragmentHomeRecycleBinding> implements PtrHandler {
    public static final byte[] $$a = {4, -41, 37, 5, -6, -55, TarHeader.LF_DIR, -4, 12, -14, -52, 57, 6, -3, -9, -56, 40, 9, 10, -1, -8, 14, -52, 33, 16, -12, 12, -14, 10, 4};
    public static final int $$b = 179;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int N;
    private static char O;
    private static char P;
    private static char Q;
    private static char SummaryVoucherView$$ExternalSyntheticLambda0;
    private static int SummaryVoucherView$$ExternalSyntheticLambda1;

    /* renamed from: A  reason: from kotlin metadata */
    private boolean SubSequence;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private LinearLayoutManager VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: D */
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: E  reason: from kotlin metadata */
    private boolean getCallingPid;

    /* renamed from: F */
    private DialogPermission getValueOfTouchPositionAbsolute;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: G */
    private MatchPhoneNumberDialog getOnBoardingScenario;

    /* renamed from: H */
    private FragmentPermissionRequest E;

    /* renamed from: I  reason: from kotlin metadata */
    private LoadingLottieAnimationView A;

    /* renamed from: J  reason: from kotlin metadata */
    private Integer VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: K */
    private CountDownTimer AppCompatEmojiTextHelper;

    /* renamed from: L  reason: from kotlin metadata */
    private boolean com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private HomeAdapter GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final HomeFragmentListener NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private DanaHomeBalanceConfigModel getErrorConfigVersion;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private Boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private boolean C;
    @Inject
    public BiometricAnalyticTracker biometricAnalyticTracker;
    @Inject
    public Lazy<CashierEventHandler> cashierEventHandler;
    @Inject
    public Lazy<DeeplinkTracker> deeplinkTracker;
    @Inject
    public Lazy<DeviceInformationProvider> deviceInformationProvider;
    @Inject
    public Lazy<DynamicUrlWrapper> dynamicUrlWrapper;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    @Inject
    public Lazy<GeofenceManager> geoFenceManager;
    @Inject
    public Lazy<GeoFencePresenter> geofencePresenter;
    @Inject
    public Lazy<GetBalanceContract.Presenter> getBalancePresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public PullBehaviorListener id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;

    /* renamed from: getNameOrBuilderList  reason: from kotlin metadata */
    private long com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private boolean whenAvailable;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    @Inject
    public Lazy<GetUserInfoContract.Presenter> getUserInfoPresenter;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private boolean com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
    @Inject
    public Lazy<GlobalNetworkContract.Presenter> globalNetworkPresenter;
    @Inject
    public Lazy<GlobalSearchContract.Presenter> globalSearchPresenter;
    @Inject
    public Lazy<HomeInfoContract.Presenter> homeInfoContractPresenter;
    @Inject
    public Lazy<HomeTabContract.Presenter> homeTabPresenter;
    @Inject
    public Lazy<HomeTrackerImpl> homeTracker;
    @Inject
    public Lazy<LocationPermissionSubject> locationPermissionSubject;
    @Inject
    public Lazy<LogoutContract.Presenter> logoutPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public SwipeDelegateListener id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private TwoButtonWithImageDialog getAuthRequestContext;
    @Inject
    public Lazy<OttVerifyContract.Presenter> ottVerifyPresenter;
    @Inject
    public Lazy<PayLaterContract.Presenter> payLaterPresenter;
    @Inject
    public PaylaterAnalyticTracker paylaterAnalyticTracker;
    @Inject
    public Lazy<PermissionStateContract.Presenter> permissionStatePresenter;
    @Inject
    public Lazy<QueryPayMethodContract.Presenter> queryPayMethodPresenter;
    @Inject
    public Lazy<ReadLinkPropertiesContract.Presenter> readLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public HomeRecycleComponent PrepareContext;
    @Inject
    public Lazy<ServicesContract.Presenter> servicePresenter;
    @Inject
    public Lazy<UnreadInboxContract.Presenter> unreadInboxPresenter;
    @Inject
    public Lazy<WalletH5ServicesImplementation> walletH5ServicesImplementation;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private boolean getSupportButtonTintMode = true;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private boolean readMicros = true;

    /* renamed from: C  reason: from kotlin metadata */
    private boolean FragmentBottomSheetPaymentSettingBinding = true;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2 = "";

    /* renamed from: B */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5 = true;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean isLayoutRequested = true;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String scheduleImpl = "";

    /* renamed from: readMicros  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4 = true;

    /* renamed from: M */
    private final kotlin.Lazy I = LazyKt.lazy(new Function0<HomeRecycleFragment$swipeListener$2.AnonymousClass1>() { // from class: id.dana.home.HomeRecycleFragment$swipeListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.home.HomeRecycleFragment$swipeListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            Context context = HomeRecycleFragment.this.getContext();
            final HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
            return new OnSwipeListener(context) { // from class: id.dana.home.HomeRecycleFragment$swipeListener$2.1
                @Override // id.dana.utils.OnSwipeListener
                public final void MyBillsEntityDataFactory() {
                    HomeRecycleFragment.B(HomeRecycleFragment.this);
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void getAuthRequestContext() {
                    HomeRecycleFragment.BottomSheetCardBindingView$watcherCardNumberView$1(HomeRecycleFragment.this);
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    HomeRecycleFragment.C(HomeRecycleFragment.this);
                }
            };
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final kotlin.Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<TranslateAnimation>() { // from class: id.dana.home.HomeRecycleFragment$animateDownDanaBalance$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final android.view.animation.TranslateAnimation invoke() {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, -HomeRecycleFragment.this.getAuthRequestContext(), 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            return translateAnimation;
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final kotlin.Lazy PlaceComponentResult = LazyKt.lazy(new Function0<TranslateAnimation>() { // from class: id.dana.home.HomeRecycleFragment$animateUpDanaBalance$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TranslateAnimation invoke() {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -HomeRecycleFragment.this.getAuthRequestContext());
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            return translateAnimation;
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final kotlin.Lazy moveToNextValue = LazyKt.lazy(new Function0<TranslateAnimation>() { // from class: id.dana.home.HomeRecycleFragment$animateUpDanaPlus$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TranslateAnimation invoke() {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, HomeRecycleFragment.this.getAuthRequestContext(), 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            return translateAnimation;
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final kotlin.Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<TranslateAnimation>() { // from class: id.dana.home.HomeRecycleFragment$animateDownDanaPlus$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TranslateAnimation invoke() {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, HomeRecycleFragment.this.getAuthRequestContext());
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            return translateAnimation;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/home/HomeRecycleFragment$PullBehaviorListener;", "", "", "getAuthRequestContext", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PullBehaviorListener {
        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void getAuthRequestContext();
    }

    static {
        try {
            N = 0;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = 1;
                getCallingPid();
                INSTANCE = new Companion(null);
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
                N = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding, HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 107;
        N = i % 128;
        if ((i % 2 != 0 ? 'a' : Typography.greater) != 'a') {
            try {
                MyBillsEntityDataFactory(viewHomeToolbarMenuBinding, homeRecycleFragment);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        MyBillsEntityDataFactory(viewHomeToolbarMenuBinding, homeRecycleFragment);
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 49;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            boolean z = i % 2 != 0;
            K(homeRecycleFragment);
            if (!z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, String str) {
        try {
            int i = N + 57;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            Object[] objArr = null;
            if (!(i % 2 != 0)) {
                try {
                    MyBillsEntityDataFactory(homeRecycleFragment, str);
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                MyBillsEntityDataFactory(homeRecycleFragment, str);
            }
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 33;
            N = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return;
            }
            objArr.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding, HomeRecycleFragment homeRecycleFragment) {
        int i = N + 117;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        getAuthRequestContext(viewHomeToolbarMenuBinding, homeRecycleFragment);
        if (!z) {
            int i2 = 54 / 0;
        }
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 67;
        N = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 84 / 0;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 35;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '=' : '-') != '-') {
            J(homeRecycleFragment);
            int i2 = 86 / 0;
        } else {
            try {
                J(homeRecycleFragment);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 33;
        N = i3 % 128;
        if ((i3 % 2 != 0 ? '`' : '4') != '`') {
            return;
        }
        int i4 = 86 / 0;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(long j, long j2, HomeRecycleFragment homeRecycleFragment, View view, View view2) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 7;
            N = i % 128;
            Object obj = null;
            if ((i % 2 != 0 ? 'M' : 'Q') != 'Q') {
                PlaceComponentResult(j, j2, homeRecycleFragment, view, view2);
                obj.hashCode();
            } else {
                try {
                    PlaceComponentResult(j, j2, homeRecycleFragment, view, view2);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = N + 1;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            if ((i2 % 2 == 0 ? 'X' : (char) 30) != 30) {
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void MyBillsEntityDataFactory(AppCompatImageView appCompatImageView, int i) {
        if ((appCompatImageView instanceof ImageView ? '=' : (char) 25) != '=') {
            appCompatImageView.setImageResource(i);
            return;
        }
        try {
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 7;
            N = i2 % 128;
            int i3 = i2 % 2;
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            int i4 = N + 81;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
            if ((i4 % 2 == 0 ? (char) 1 : '9') != '9') {
                int i5 = 71 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 93;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        Q(homeRecycleFragment);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
        N = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 5 : '[') != 5) {
            return;
        }
        int i3 = 10 / 0;
    }

    public static /* synthetic */ void PlaceComponentResult() {
        int i = N + 89;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            o();
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 111;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        M(homeRecycleFragment);
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 67;
        N = i3 % 128;
        if ((i3 % 2 != 0 ? 'I' : '\'') != '\'') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, int i, float f, ValueAnimator valueAnimator) {
        int i2 = N + 109;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
        BuiltInFictitiousFunctionClassFactory(homeRecycleFragment, i, f, valueAnimator);
        try {
            int i4 = N + 111;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ boolean PlaceComponentResult(HomeViewWidgetModel homeViewWidgetModel) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 17;
        N = i % 128;
        int i2 = i % 2;
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(homeViewWidgetModel);
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
        N = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 67 / 0;
            return MyBillsEntityDataFactory;
        }
        return MyBillsEntityDataFactory;
    }

    private static void ac(short s, int i, byte b, Object[] objArr) {
        int i2 = 3 - (s * 4);
        int i3 = (b * 2) + 27;
        int i4 = (i * 2) + 105;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = i2 + i4 + 1;
            i2 = i2;
        }
        while (true) {
            i5++;
            int i7 = i2 + 1;
            bArr2[i5] = (byte) i4;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i4 = i4 + bArr[i7] + 1;
                i2 = i7;
            }
        }
    }

    public static /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 69;
        N = i % 128;
        int i2 = i % 2;
        getNameOrBuilderList(homeRecycleFragment);
        try {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, int i, float f, ValueAnimator valueAnimator) {
        int i2 = N + 111;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        boolean z = i2 % 2 == 0;
        Object[] objArr = null;
        MyBillsEntityDataFactory(homeRecycleFragment, i, f, valueAnimator);
        if (z) {
            int length = objArr.length;
        }
        int i3 = N + 97;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? '^' : 'c') != 'c') {
            int length2 = objArr.length;
        }
    }

    static void getCallingPid() {
        O = (char) 26407;
        P = (char) 31121;
        SummaryVoucherView$$ExternalSyntheticLambda0 = (char) 64124;
        Q = (char) 64859;
    }

    public static /* synthetic */ void getErrorConfigVersion(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 101;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                if (!(i % 2 == 0)) {
                    H(homeRecycleFragment);
                    return;
                }
                H(homeRecycleFragment);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static View.OnClickListener j() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeRecycleFragment.PlaceComponentResult();
            }
        };
        int i = N + 43;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return onClickListener;
    }

    public static /* synthetic */ void moveToNextValue(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 45;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? (char) 29 : 'O';
        L(homeRecycleFragment);
        if (c != 29) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void scheduleImpl(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 31;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            P(homeRecycleFragment);
            int i3 = N + 99;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 15 : (char) 24) != 24) {
                int i4 = 56 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
        N = i % 128;
        int i2 = i % 2;
        try {
            this.PlaceComponentResult.clear();
            int i3 = N + 87;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? '1' : (char) 5) != 5) {
                int i4 = 79 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x007e, code lost:
    
        r0.put(java.lang.Integer.valueOf(r8), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0082, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0083, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x008f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0091, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0023, code lost:
    
        if ((r4 == null) != true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x003d, code lost:
    
        if ((r4 == null ? '9' : kotlin.text.Typography.amp) != '9') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x003f, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0041, code lost:
    
        r4 = getGetAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0045, code lost:
    
        if (r4 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0047, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0049, code lost:
    
        r5 = 'M';
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x004b, code lost:
    
        if (r5 == 1) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004e, code lost:
    
        r4 = r4.findViewById(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0054, code lost:
    
        if (r4 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0056, code lost:
    
        r6 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0059, code lost:
    
        r6 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x005b, code lost:
    
        if (r6 == ' ') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005d, code lost:
    
        r5 = id.dana.animation.HomeRecycleFragment.N + 125;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0067, code lost:
    
        if ((r5 % 2) != 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x006a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x006b, code lost:
    
        if (r2 == true) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x006d, code lost:
    
        r0.put(java.lang.Integer.valueOf(r8), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0074, code lost:
    
        r1.hashCode();
     */
    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r8) {
        /*
            r7 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L28
            java.util.Map<java.lang.Integer, android.view.View> r0 = r7.PlaceComponentResult
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            java.lang.Object r4 = r0.get(r4)
            android.view.View r4 = (android.view.View) r4
            r5 = 56
            int r5 = r5 / r2
            if (r4 != 0) goto L22
            r5 = 1
            goto L23
        L22:
            r5 = 0
        L23:
            if (r5 == r3) goto L41
            goto L3f
        L26:
            r8 = move-exception
            throw r8
        L28:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r7.PlaceComponentResult
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            java.lang.Object r4 = r0.get(r4)
            android.view.View r4 = (android.view.View) r4
            r5 = 57
            if (r4 != 0) goto L3b
            r6 = 57
            goto L3d
        L3b:
            r6 = 38
        L3d:
            if (r6 == r5) goto L41
        L3f:
            r1 = r4
            goto L84
        L41:
            android.view.View r4 = r7.getGetAuthRequestContext()
            if (r4 == 0) goto L49
            r5 = 1
            goto L4b
        L49:
            r5 = 77
        L4b:
            if (r5 == r3) goto L4e
            goto L84
        L4e:
            android.view.View r4 = r4.findViewById(r8)     // Catch: java.lang.Exception -> L8f
            r5 = 32
            if (r4 == 0) goto L59
            r6 = 64
            goto L5b
        L59:
            r6 = 32
        L5b:
            if (r6 == r5) goto L84
            int r5 = id.dana.animation.HomeRecycleFragment.N
            int r5 = r5 + 125
            int r6 = r5 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L6a
            goto L6b
        L6a:
            r2 = 1
        L6b:
            if (r2 == r3) goto L7a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L8f
            r0.put(r8, r4)     // Catch: java.lang.Exception -> L8f
            r1.hashCode()     // Catch: java.lang.Throwable -> L78
            goto L3f
        L78:
            r8 = move-exception
            throw r8
        L7a:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L8f
            r0.put(r8, r4)     // Catch: java.lang.Exception -> L82
            goto L3f
        L82:
            r8 = move-exception
            throw r8
        L84:
            int r8 = id.dana.animation.HomeRecycleFragment.N
            int r8 = r8 + 73
            int r0 = r8 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0
            int r8 = r8 % 2
            return r1
        L8f:
            r8 = move-exception
            goto L92
        L91:
            throw r8
        L92:
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment._$_findCachedViewById(int):android.view.View");
    }

    @Override // in.srain.cube.views.ptr.PtrHandler
    public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
        try {
            int i = N + 125;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            try {
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 49;
                N = i3 % 128;
                int i4 = i3 % 2;
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 121;
        N = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return R.layout.fragment_home_recycle;
        }
        return R.layout.fragment_home_recycle;
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
        N = i % 128;
        char c = i % 2 != 0 ? 'U' : '+';
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        if (c != '+') {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = N + 91;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
                if (i2 % 2 != 0) {
                    return;
                }
                int i3 = 13 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void A(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 1;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            homeRecycleFragment.FragmentBottomSheetPaymentSettingBinding = false;
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void AppCompatEmojiTextHelper(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 99;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.w();
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 113;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void B(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
        N = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.m();
        int i3 = N + 53;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
        N = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.l();
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 53;
        N = i3 % 128;
        if ((i3 % 2 != 0 ? '6' : Typography.less) != '6') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, int i) {
        try {
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 55;
            N = i2 % 128;
            int i3 = i2 % 2;
            homeRecycleFragment.getAuthRequestContext(i);
            int i4 = N + 95;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
            if (i4 % 2 != 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, long j, long j2, View view, View view2) {
        int i = N + 35;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.getAuthRequestContext(j, j2, view, view2);
        try {
            int i3 = N + 67;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, HomeInfo homeInfo) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
        N = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.PlaceComponentResult(homeInfo);
        int i3 = N + 53;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, Function1 function1) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 83;
        N = i % 128;
        boolean z = i % 2 != 0;
        homeRecycleFragment.PlaceComponentResult(function1);
        if (!z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, boolean z) {
        int i = N + 39;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 != 0)) {
            homeRecycleFragment.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String = z;
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                homeRecycleFragment.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String = z;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = N + 1;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void C(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 115;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? (char) 23 : 'a') == 'a') {
            homeRecycleFragment.access$throwIllegalArgumentType();
            return;
        }
        homeRecycleFragment.access$throwIllegalArgumentType();
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static final /* synthetic */ void D(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 47;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? (char) 14 : ':') != ':') {
            homeRecycleFragment.getCallingPid = false;
        } else {
            homeRecycleFragment.getCallingPid = true;
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
        N = i2 % 128;
        if (i2 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 45;
        N = i % 128;
        boolean z = i % 2 == 0;
        homeRecycleFragment.E();
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 103;
        N = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void E(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 11;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (i % 2 == 0) {
            }
            homeRecycleFragment.BuiltInFictitiousFunctionClassFactory(false);
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void F(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
        N = i % 128;
        if ((i % 2 != 0 ? (char) 2 : 'c') != 'c') {
            homeRecycleFragment.v();
            int i2 = 65 / 0;
        } else {
            homeRecycleFragment.v();
        }
        int i3 = N + 37;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 22 : 'L') != 22) {
            return;
        }
        int i4 = 56 / 0;
    }

    public static final /* synthetic */ DialogPermission FragmentBottomSheetPaymentSettingBinding(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 35;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            DialogPermission dialogPermission = homeRecycleFragment.getValueOfTouchPositionAbsolute;
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 21;
            N = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return dialogPermission;
            }
            int i4 = 11 / 0;
            return dialogPermission;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void G(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 85;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 != 0;
        homeRecycleFragment.q();
        if (z) {
            return;
        }
        int i2 = 56 / 0;
    }

    public static final /* synthetic */ FragmentHomeRecycleBinding GetContactSyncConfig(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 85;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) homeRecycleFragment.getBinding();
            int i3 = N + 109;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            return fragmentHomeRecycleBinding;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void I(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 125;
            N = i % 128;
            char c = i % 2 != 0 ? '2' : '8';
            homeRecycleFragment.x();
            if (c != '8') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = N + 99;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? (char) 18 : '[';
        OtpRegistrationPresenter$input$2();
        if (c != '[') {
            int i2 = 37 / 0;
        }
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 47;
        N = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        int i4 = 84 / 0;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
        int i = N + 117;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? (char) 16 : '_';
        homeRecycleFragment.getErrorConfigVersion = danaHomeBalanceConfigModel;
        if (c != '_') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = N + 45;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment, MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 97;
        N = i % 128;
        char c = i % 2 != 0 ? '[' : Typography.dollar;
        homeRecycleFragment.getAuthRequestContext(merchantConsultReviewModel, merchantReviewModel);
        if (c == '[') {
            int i2 = 67 / 0;
        }
        int i3 = N + 53;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment, String str) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 39;
            N = i % 128;
            boolean z = i % 2 != 0;
            homeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(str);
            if (!z) {
                return;
            }
            int i2 = 32 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment, boolean z) {
        int i = N + 49;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(z);
        try {
            int i3 = N + 29;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ Drawable MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, Context context) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 81;
        N = i % 128;
        boolean z = i % 2 != 0;
        Drawable KClassImpl$Data$declaredNonStaticMembers$2 = homeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(context);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, View view, View view2) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 73;
        N = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? 'R' : '0') != '0') {
            homeRecycleFragment.PlaceComponentResult(view, view2);
            int length = objArr.length;
        } else {
            homeRecycleFragment.PlaceComponentResult(view, view2);
        }
        int i2 = N + 59;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        if (i2 % 2 == 0) {
            int length2 = objArr.length;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, PromotionModel promotionModel) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 7;
        N = i % 128;
        char c = i % 2 != 0 ? 'P' : (char) 6;
        homeRecycleFragment.BuiltInFictitiousFunctionClassFactory(promotionModel);
        if (c != 6) {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = N + 65;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            if ((i2 % 2 == 0 ? '\t' : 'M') != 'M') {
                int i3 = 14 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, Integer num) {
        int i = N + 3;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            homeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$2 = num;
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 89;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, boolean z) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
        N = i % 128;
        boolean z2 = i % 2 == 0;
        homeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(z);
        if (!z2) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
        N = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 13;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? (char) 30 : '/';
        homeRecycleFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        if (c != 30) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 91;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        boolean z = i % 2 == 0;
        homeRecycleFragment.B();
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ String NetworkUserEntityData$$ExternalSyntheticLambda2(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 11;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                boolean z = i % 2 == 0;
                String str = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (z) {
                    Object obj = null;
                    obj.hashCode();
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ MatchPhoneNumberDialog NetworkUserEntityData$$ExternalSyntheticLambda3(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 15;
        N = i % 128;
        int i2 = i % 2;
        MatchPhoneNumberDialog matchPhoneNumberDialog = homeRecycleFragment.getOnBoardingScenario;
        int i3 = N + 71;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? '[' : (char) 5) != '[') {
            return matchPhoneNumberDialog;
        }
        Object obj = null;
        obj.hashCode();
        return matchPhoneNumberDialog;
    }

    public static final /* synthetic */ FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda4(HomeRecycleFragment homeRecycleFragment) {
        FragmentPermissionRequest fragmentPermissionRequest;
        int i = N + 93;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'A' : (char) 18) != 'A') {
            fragmentPermissionRequest = homeRecycleFragment.E;
        } else {
            fragmentPermissionRequest = homeRecycleFragment.E;
            int length = objArr.length;
        }
        int i2 = N + 115;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 15 : '*') != 15) {
            return fragmentPermissionRequest;
        }
        objArr.hashCode();
        return fragmentPermissionRequest;
    }

    public static final /* synthetic */ HomeAdapter.ServicesViewHolder NetworkUserEntityData$$ExternalSyntheticLambda5(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
        N = i % 128;
        int i2 = i % 2;
        HomeAdapter.ServicesViewHolder X = homeRecycleFragment.X();
        try {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 107;
            N = i3 % 128;
            if (i3 % 2 == 0) {
                return X;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return X;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Integer NetworkUserEntityData$$ExternalSyntheticLambda6(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 89;
        N = i % 128;
        char c = i % 2 != 0 ? (char) 25 : '-';
        Integer num = homeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (c == 25) {
            Object obj = null;
            obj.hashCode();
        }
        return num;
    }

    public static final /* synthetic */ LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment homeRecycleFragment) {
        LoadingLottieAnimationView loadingLottieAnimationView;
        int i = N + 29;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 28 : (char) 29) != 28) {
            try {
                loadingLottieAnimationView = homeRecycleFragment.A;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            loadingLottieAnimationView = homeRecycleFragment.A;
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 53;
        N = i2 % 128;
        int i3 = i2 % 2;
        return loadingLottieAnimationView;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
            N = i % 128;
            if (i % 2 == 0) {
                homeRecycleFragment.M();
                return;
            }
            homeRecycleFragment.M();
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, View view, View view2) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 115;
            N = i % 128;
            int i2 = i % 2;
            homeRecycleFragment.MyBillsEntityDataFactory(view, view2);
            try {
                int i3 = N + 109;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, String str) {
        try {
            int i = N + 89;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
            N = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, String str, String str2) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 53;
        N = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.PlaceComponentResult(str, str2);
        int i3 = N + 55;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? 'E' : (char) 19) != 19) {
            int i4 = 85 / 0;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, boolean z) {
        int i = N + 85;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? Typography.less : (char) 2;
        homeRecycleFragment.moveToNextValue(z);
        if (c != 2) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ String PrepareContext(HomeRecycleFragment homeRecycleFragment) {
        String str;
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
        N = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            str = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
            objArr.hashCode();
        } else {
            try {
                str = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = N + 25;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public static final /* synthetic */ long SubSequence(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 57;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        long j = homeRecycleFragment.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
        int i3 = N + 61;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return j;
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$1(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 57;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
        }
        homeRecycleFragment.DatabaseTableConfigUtil = false;
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 23;
        N = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$2(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 27;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.t();
        try {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, HasNewModel hasNewModel) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
        N = i % 128;
        char c = i % 2 != 0 ? '%' : (char) 4;
        homeRecycleFragment.MyBillsEntityDataFactory(hasNewModel);
        if (c != '%') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, Boolean bool) {
        int i = N + 63;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda6 = bool;
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, String str) {
        try {
            int i = N + 95;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
                int i3 = N + 25;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, boolean z) {
        int i = N + 81;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.PlaceComponentResult(z);
        try {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 87;
            try {
                N = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ boolean getCallingPid(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 83;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            char c = i % 2 == 0 ? '\f' : '1';
            boolean z = homeRecycleFragment.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (c == '\f') {
                int i2 = 99 / 0;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getOnBoardingScenario(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 99;
            N = i % 128;
            if (i % 2 == 0) {
                homeRecycleFragment.SizeSelectors$OrSelector();
            } else {
                homeRecycleFragment.SizeSelectors$OrSelector();
                int i2 = 19 / 0;
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 87;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ boolean getSupportButtonTintMode(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 89;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 == 0 ? 'B' : 'c';
        boolean z = homeRecycleFragment.FragmentBottomSheetPaymentSettingBinding;
        if (c == 'B') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = N + 53;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
        return z;
    }

    public static final /* synthetic */ void getValueOfTouchPositionAbsolute(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 69;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        int i3 = N + 47;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void initRecordTimeStamp(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = N + 99;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            boolean z = i % 2 == 0;
            homeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$2();
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ LinearLayoutManager isLayoutRequested(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 79;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            LinearLayoutManager linearLayoutManager = homeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$1;
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
            N = i3 % 128;
            if (i3 % 2 == 0) {
                return linearLayoutManager;
            }
            int i4 = 37 / 0;
            return linearLayoutManager;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void lookAheadTest(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 113;
            N = i % 128;
            int i2 = i % 2;
            homeRecycleFragment.A();
            int i3 = N + 75;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? '\\' : 'V') != '\\') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String newProxyInstance(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 3;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        String str = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 9;
        N = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.dollar : 'O') != 'O') {
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return str;
    }

    public static final /* synthetic */ CountDownTimer readMicros(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 105;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        CountDownTimer countDownTimer = homeRecycleFragment.AppCompatEmojiTextHelper;
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
        N = i3 % 128;
        int i4 = i3 % 2;
        return countDownTimer;
    }

    public static final /* synthetic */ void whenAvailable(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 27;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        homeRecycleFragment.h();
        int i3 = N + 71;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? 'F' : '-') != 'F') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        int i = N + 125;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? 'W' : (char) 7) != 'W') {
            return MyBillsEntityDataFactory(view);
        }
        try {
            try {
                FragmentHomeRecycleBinding MyBillsEntityDataFactory = MyBillsEntityDataFactory(view);
                Object obj = null;
                obj.hashCode();
                return MyBillsEntityDataFactory;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0018, code lost:
    
        if (r0 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0029, code lost:
    
        if ((r0 != null ? 15 : 'B') != 'B') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x002c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.animation.HomeRecycleFragment.N + 105;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x003b, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "scheduleImpl")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.geofence.GeofenceManager> scheduleImpl() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 94
            if (r0 != 0) goto L11
            r0 = 94
            goto L13
        L11:
            r0 = 69
        L13:
            r2 = 0
            if (r0 == r1) goto L1b
            dagger.Lazy<id.dana.geofence.GeofenceManager> r0 = r4.geoFenceManager
            if (r0 == 0) goto L2c
            goto L2b
        L1b:
            dagger.Lazy<id.dana.geofence.GeofenceManager> r0 = r4.geoFenceManager
            r2.hashCode()     // Catch: java.lang.Throwable -> L3c
            r1 = 66
            if (r0 == 0) goto L27
            r3 = 15
            goto L29
        L27:
            r3 = 66
        L29:
            if (r3 == r1) goto L2c
        L2b:
            return r0
        L2c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            return r2
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.scheduleImpl():dagger.Lazy");
    }

    @JvmName(name = "initAnimators")
    private Lazy<GeoFencePresenter> initAnimators() {
        int i = N + 39;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Lazy<GeoFencePresenter> lazy = this.geofencePresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = N + 85;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return lazy;
    }

    @JvmName(name = "RequestMoneyQrContract$View")
    private Lazy<GetBalanceContract.Presenter> RequestMoneyQrContract$View() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 65;
        N = i % 128;
        int i2 = i % 2;
        Lazy<GetBalanceContract.Presenter> lazy = this.getBalancePresenter;
        Object obj = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = N + 43;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? 'T' : '^') != '^') {
            obj.hashCode();
        }
        try {
            int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 97;
            N = i4 % 128;
            int i5 = i4 % 2;
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x001a, code lost:
    
        if ((r0 == null) != true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0022, code lost:
    
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0024, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 7;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002e, code lost:
    
        if ((r1 % 2) == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0032, code lost:
    
        r1 = 99 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0033, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0036, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0037, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.animation.HomeRecycleFragment.N + 85;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0047, code lost:
    
        if ((r0 % 2) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0049, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "verifyNotNull")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private dagger.Lazy<id.dana.contract.homeinfo.HomeInfoContract.Presenter> verifyNotNull() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1d
            dagger.Lazy<id.dana.contract.homeinfo.HomeInfoContract$Presenter> r0 = r4.homeInfoContractPresenter
            if (r0 == 0) goto L19
            r3 = 0
            goto L1a
        L19:
            r3 = 1
        L1a:
            if (r3 == r1) goto L37
            goto L24
        L1d:
            dagger.Lazy<id.dana.contract.homeinfo.HomeInfoContract$Presenter> r0 = r4.homeInfoContractPresenter     // Catch: java.lang.Exception -> L52
            r1 = 60
            int r1 = r1 / r2
            if (r0 == 0) goto L37
        L24:
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 7
            int r3 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L36
            r1 = 99
            int r1 = r1 / r2
            return r0
        L34:
            r0 = move-exception
            throw r0
        L36:
            return r0
        L37:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L4f
            r1.hashCode()     // Catch: java.lang.Throwable -> L4d
            return r1
        L4d:
            r0 = move-exception
            throw r0
        L4f:
            return r1
        L50:
            r0 = move-exception
            throw r0
        L52:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.verifyNotNull():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0023, code lost:
    
        if ((r0 != null ? '@' : '9') != '9') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002c, code lost:
    
        if (r0 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002e, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
        id.dana.animation.HomeRecycleFragment.N = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0038, code lost:
    
        if ((r3 % 2) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003a, code lost:
    
        r2 = 64 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0044, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "FlowableReduce$ReduceSubscriber")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private dagger.Lazy<id.dana.challenge.pin.LogoutContract.Presenter> FlowableReduce$ReduceSubscriber() {
        /*
            r6 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            r2 = 64
            r3 = 0
            if (r0 == 0) goto L2a
            dagger.Lazy<id.dana.challenge.pin.LogoutContract$Presenter> r0 = r6.logoutPresenter     // Catch: java.lang.Exception -> L28
            r3.hashCode()     // Catch: java.lang.Throwable -> L26
            r4 = 57
            if (r0 == 0) goto L21
            r5 = 64
            goto L23
        L21:
            r5 = 57
        L23:
            if (r5 == r4) goto L3f
            goto L2e
        L26:
            r0 = move-exception
            throw r0
        L28:
            r0 = move-exception
            throw r0
        L2a:
            dagger.Lazy<id.dana.challenge.pin.LogoutContract$Presenter> r0 = r6.logoutPresenter
            if (r0 == 0) goto L3f
        L2e:
            int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r3 = r3 + 41
            int r4 = r3 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L3e
            int r2 = r2 / r1
            goto L3e
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            return r0
        L3f:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.FlowableReduce$ReduceSubscriber():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x001d, code lost:
    
        if ((r0 != null ? '[' : 0) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0024, code lost:
    
        if (r0 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0026, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 39;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0030, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0031, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0036, code lost:
    
        r0 = id.dana.animation.HomeRecycleFragment.N + 101;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        if ((r0 % 2) != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0042, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0043, code lost:
    
        if (r1 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0046, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0049, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "initRecordTimeStamp")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.contract.globalsearch.GlobalSearchContract.Presenter> initRecordTimeStamp() {
        /*
            r5 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L4a
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L4a
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == r2) goto L22
            dagger.Lazy<id.dana.contract.globalsearch.GlobalSearchContract$Presenter> r0 = r5.globalSearchPresenter
            int r4 = r3.length     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L1c
            r4 = 91
            goto L1d
        L1c:
            r4 = 0
        L1d:
            if (r4 == 0) goto L31
            goto L26
        L20:
            r0 = move-exception
            throw r0
        L22:
            dagger.Lazy<id.dana.contract.globalsearch.GlobalSearchContract$Presenter> r0 = r5.globalSearchPresenter     // Catch: java.lang.Exception -> L4a
            if (r0 == 0) goto L31
        L26:
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 39
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            return r0
        L31:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L4a
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 101
            int r4 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L43
            r1 = 1
        L43:
            if (r1 == 0) goto L49
            int r0 = r3.length     // Catch: java.lang.Throwable -> L47
            return r3
        L47:
            r0 = move-exception
            throw r0
        L49:
            return r3
        L4a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.initRecordTimeStamp():dagger.Lazy");
    }

    @JvmName(name = "y")
    private Lazy<GetUserInfoContract.Presenter> y() {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
            N = i % 128;
            int i2 = i % 2;
            Lazy<GetUserInfoContract.Presenter> lazy = this.getUserInfoPresenter;
            if ((lazy != null ? 'P' : '4') != '4') {
                return lazy;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i3 = N + 25;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "PrepareContext")
    public final Lazy<QueryPayMethodContract.Presenter> PrepareContext() {
        Lazy<QueryPayMethodContract.Presenter> lazy = this.queryPayMethodPresenter;
        if (!(lazy == null)) {
            int i = N + 39;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if ((i % 2 == 0 ? '+' : (char) 14) != 14) {
                int i2 = 16 / 0;
            }
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 97;
        N = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    @JvmName(name = "JsonParseException")
    private Lazy<UnreadInboxContract.Presenter> JsonParseException() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 55;
        N = i % 128;
        int i2 = i % 2;
        Lazy<UnreadInboxContract.Presenter> lazy = this.unreadInboxPresenter;
        Object[] objArr = null;
        if ((lazy != null ? '=' : (char) 15) == '=') {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 17;
            N = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int length = objArr.length;
            }
            return lazy;
        }
        try {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i4 = N + 45;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
            int i5 = i4 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "moveToNextValue")
    public final Lazy<CashierEventHandler> moveToNextValue() {
        int i = N + 33;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Lazy<CashierEventHandler> lazy = this.cashierEventHandler;
        if ((lazy != null ? '1' : Typography.greater) != '>') {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        try {
            int i3 = N + 23;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            Object[] objArr = null;
            if (!(i3 % 2 == 0)) {
                return null;
            }
            int length = objArr.length;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0018, code lost:
    
        if (r0 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0020, code lost:
    
        if (r0 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0022, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 113;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0036, code lost:
    
        if ((r1 % 2) == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0038, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0039, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003d, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.animation.HomeRecycleFragment.N + 83;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004c, code lost:
    
        if ((r0 % 2) != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004e, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0050, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0051, code lost:
    
        if (r0 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0053, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0054, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0057, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "newProxyInstance")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.contract.permission.PermissionStateContract.Presenter> newProxyInstance() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 54
            if (r0 == 0) goto L11
            r0 = 54
            goto L13
        L11:
            r0 = 21
        L13:
            r2 = 0
            if (r0 == r1) goto L1b
            dagger.Lazy<id.dana.contract.permission.PermissionStateContract$Presenter> r0 = r4.permissionStatePresenter
            if (r0 == 0) goto L3d
            goto L22
        L1b:
            dagger.Lazy<id.dana.contract.permission.PermissionStateContract$Presenter> r0 = r4.permissionStatePresenter     // Catch: java.lang.Exception -> L5a
            r2.hashCode()     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L3d
        L22:
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 113
            int r3 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
            int r1 = r1 % 2
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 51
            int r3 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L3c
            int r1 = r2.length     // Catch: java.lang.Throwable -> L3a
            return r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            return r0
        L3d:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L50
            r0 = 1
            goto L51
        L50:
            r0 = 0
        L51:
            if (r0 == 0) goto L57
            int r0 = r2.length     // Catch: java.lang.Throwable -> L55
            return r2
        L55:
            r0 = move-exception
            throw r0
        L57:
            return r2
        L58:
            r0 = move-exception
            throw r0
        L5a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.newProxyInstance():dagger.Lazy");
    }

    @JvmName(name = "getDefaultSenderId")
    private Lazy<OttVerifyContract.Presenter> getDefaultSenderId() {
        Lazy<OttVerifyContract.Presenter> lazy = this.ottVerifyPresenter;
        if (!(lazy == null)) {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            N = i % 128;
            if (i % 2 != 0) {
                int i2 = 89 / 0;
                return lazy;
            }
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 13;
        N = i3 % 128;
        boolean z = i3 % 2 != 0;
        Object[] objArr = null;
        if (!z) {
            return null;
        }
        int length = objArr.length;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0015, code lost:
    
        if ((r0 != null) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0025, code lost:
    
        if ((r0 != null ? '`' : 22) != '`') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0027, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x002e, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 93;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0038, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.toggle.locationpermission.LocationPermissionSubject> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        /*
            r3 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1a
            dagger.Lazy<id.dana.toggle.locationpermission.LocationPermissionSubject> r0 = r3.locationPermissionSubject
            r1 = 32
            r2 = 0
            int r1 = r1 / r2
            if (r0 == 0) goto L15
            r2 = 1
        L15:
            if (r2 == 0) goto L27
            goto L2e
        L18:
            r0 = move-exception
            throw r0
        L1a:
            dagger.Lazy<id.dana.toggle.locationpermission.LocationPermissionSubject> r0 = r3.locationPermissionSubject     // Catch: java.lang.Exception -> L39
            r1 = 96
            if (r0 == 0) goto L23
            r2 = 96
            goto L25
        L23:
            r2 = 22
        L25:
            if (r2 == r1) goto L2e
        L27:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            return r0
        L2e:
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            return r0
        L39:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda2():dagger.Lazy");
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda1")
    public final Lazy<GlobalNetworkContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = N + 51;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Lazy<GlobalNetworkContract.Presenter> lazy = this.globalNetworkPresenter;
        Object obj = null;
        if ((lazy != null ? '-' : (char) 31) != '-') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = N + 59;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? 'O' : '3') != 'O') {
            obj.hashCode();
        }
        return lazy;
    }

    @JvmName(name = "onDecodeSuccess")
    private Lazy<PayLaterContract.Presenter> onDecodeSuccess() {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 69;
            N = i % 128;
            int i2 = i % 2;
            Lazy<PayLaterContract.Presenter> lazy = this.payLaterPresenter;
            Object[] objArr = null;
            if ((lazy != null ? (char) 19 : '+') != 19) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            try {
                int i3 = N + 101;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                if (i3 % 2 == 0) {
                    int length = objArr.length;
                }
                return lazy;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "FlowableCreate$BufferAsyncEmitter")
    private Lazy<HomeTabContract.Presenter> FlowableCreate$BufferAsyncEmitter() {
        int i = N + 37;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Lazy<HomeTabContract.Presenter> lazy = this.homeTabPresenter;
        if ((lazy != null ? ']' : (char) 4) == 4) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
        N = i3 % 128;
        int i4 = i3 % 2;
        return lazy;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:52:0x0038
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final id.dana.tracker.mixpanel.BiometricAnalyticTracker NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r3 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 76
            if (r0 == 0) goto L11
            r0 = 76
            goto L12
        L11:
            r0 = 3
        L12:
            if (r0 == r1) goto L19
            id.dana.tracker.mixpanel.BiometricAnalyticTracker r0 = r3.biometricAnalyticTracker
            if (r0 == 0) goto L25
            goto L24
        L19:
            id.dana.tracker.mixpanel.BiometricAnalyticTracker r0 = r3.biometricAnalyticTracker
            r1 = 28
            r2 = 0
            int r1 = r1 / r2
            if (r0 == 0) goto L22
            r2 = 1
        L22:
            if (r2 == 0) goto L25
        L24:
            return r0
        L25:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L36
            r0 = 0
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 65
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            return r0
        L36:
            r0 = move-exception
            throw r0
        L38:
            r0 = move-exception
            throw r0
        L3a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0():id.dana.tracker.mixpanel.BiometricAnalyticTracker");
    }

    @JvmName(name = "OtpRegistrationPresenter$input$1")
    private Lazy<HomeTrackerImpl> OtpRegistrationPresenter$input$1() {
        try {
            Lazy<HomeTrackerImpl> lazy = this.homeTracker;
            Object[] objArr = null;
            if (lazy != null) {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 111;
                N = i % 128;
                if (i % 2 != 0) {
                    int length = objArr.length;
                }
                return lazy;
            }
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 121;
                N = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    return null;
                }
                objArr.hashCode();
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setNetAuthId")
    private Lazy<DeeplinkTracker> setNetAuthId() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
        N = i % 128;
        int i2 = i % 2;
        Lazy<DeeplinkTracker> lazy = this.deeplinkTracker;
        if (!(lazy == null)) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
        N = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0024, code lost:
    
        if ((r0 != null ? '^' : 'F') != '^') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x002e, code lost:
    
        if ((r0 != null) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0030, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 55;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0041, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda8")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.contract.services.ServicesContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda8() {
        /*
            r3 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 45
            if (r0 == 0) goto L11
            r0 = 62
            goto L13
        L11:
            r0 = 45
        L13:
            r2 = 0
            if (r0 == r1) goto L29
            dagger.Lazy<id.dana.contract.services.ServicesContract$Presenter> r0 = r3.servicePresenter
            r1 = 64
            int r1 = r1 / r2
            r1 = 94
            if (r0 == 0) goto L22
            r2 = 94
            goto L24
        L22:
            r2 = 70
        L24:
            if (r2 == r1) goto L30
            goto L3b
        L27:
            r0 = move-exception
            throw r0
        L29:
            dagger.Lazy<id.dana.contract.services.ServicesContract$Presenter> r0 = r3.servicePresenter
            if (r0 == 0) goto L2e
            r2 = 1
        L2e:
            if (r2 == 0) goto L3b
        L30:
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 55
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            return r0
        L3b:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda8():dagger.Lazy");
    }

    @JvmName(name = "isLayoutRequested")
    public final Lazy<ReadLinkPropertiesContract.Presenter> isLayoutRequested() {
        try {
            int i = N + 37;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                Lazy<ReadLinkPropertiesContract.Presenter> lazy = this.readLinkPropertiesPresenter;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 95;
                N = i3 % 128;
                int i4 = i3 % 2;
                return lazy;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0018, code lost:
    
        if ((r0 != null) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0022, code lost:
    
        if ((r0 == null) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0024, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.animation.HomeRecycleFragment.N + 35;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0033, code lost:
    
        if ((r0 % 2) != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0037, code lost:
    
        r0 = 13 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0038, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003c, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda6")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.wallet_v3.WalletH5ServicesImplementation> NetworkUserEntityData$$ExternalSyntheticLambda6() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1d
            dagger.Lazy<id.dana.wallet_v3.WalletH5ServicesImplementation> r0 = r4.walletH5ServicesImplementation     // Catch: java.lang.Exception -> L3d
            r2.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L17
            goto L18
        L17:
            r1 = 0
        L18:
            if (r1 == 0) goto L24
            goto L3c
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            dagger.Lazy<id.dana.wallet_v3.WalletH5ServicesImplementation> r0 = r4.walletH5ServicesImplementation     // Catch: java.lang.Exception -> L3d
            if (r0 == 0) goto L22
            r1 = 0
        L22:
            if (r1 == 0) goto L3c
        L24:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3b
            r0 = 13
            int r0 = r0 / r3
            return r2
        L39:
            r0 = move-exception
            throw r0
        L3b:
            return r2
        L3c:
            return r0
        L3d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda6():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0015, code lost:
    
        if ((r0 == null) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0025, code lost:
    
        if ((r0 != null ? 'Q' : 19) != 'Q') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002e, code lost:
    
        r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0032, code lost:
    
        id.dana.animation.HomeRecycleFragment.N = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0034, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0036, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0038, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0039, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "lookAheadTest")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dagger.Lazy<id.dana.data.config.DeviceInformationProvider> lookAheadTest() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1a
            dagger.Lazy<id.dana.data.config.DeviceInformationProvider> r0 = r4.deviceInformationProvider
            int r2 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L14
            r2 = 0
            goto L15
        L14:
            r2 = 1
        L15:
            if (r2 == 0) goto L39
            goto L27
        L18:
            r0 = move-exception
            throw r0
        L1a:
            dagger.Lazy<id.dana.data.config.DeviceInformationProvider> r0 = r4.deviceInformationProvider     // Catch: java.lang.Exception -> L3a
            r2 = 81
            if (r0 == 0) goto L23
            r3 = 81
            goto L25
        L23:
            r3 = 19
        L25:
            if (r3 == r2) goto L39
        L27:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L3a
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L3a
            int r0 = r0 + 5
            int r2 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r2     // Catch: java.lang.Exception -> L37
            int r0 = r0 % 2
            return r1
        L37:
            r0 = move-exception
            throw r0
        L39:
            return r0
        L3a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.lookAheadTest():dagger.Lazy");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0015, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0027, code lost:
    
        if ((r0 != null ? 'E' : 'M') != 'E') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002f, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 73;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getContainerAuth")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.cashier.tracker.PaylaterAnalyticTracker getContainerAuth() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r1 = 0
            if (r0 == 0) goto L1c
            id.dana.cashier.tracker.PaylaterAnalyticTracker r0 = r4.paylaterAnalyticTracker     // Catch: java.lang.Exception -> L1a
            int r2 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L29
            goto L2f
        L18:
            r0 = move-exception
            throw r0
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            id.dana.cashier.tracker.PaylaterAnalyticTracker r0 = r4.paylaterAnalyticTracker     // Catch: java.lang.Exception -> L3a
            r2 = 69
            if (r0 == 0) goto L25
            r3 = 69
            goto L27
        L25:
            r3 = 77
        L27:
            if (r3 == r2) goto L2f
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L2f:
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 73
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            return r0
        L3a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getContainerAuth():id.dana.cashier.tracker.PaylaterAnalyticTracker");
    }

    @JvmName(name = "getErrorConfigVersion")
    public final FeatureContract.Presenter getErrorConfigVersion() {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 83;
            N = i % 128;
            int i2 = i % 2;
            FeatureContract.Presenter presenter = this.featurePresenter;
            if ((presenter != null ? '@' : '#') == '#') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 11;
            N = i3 % 128;
            int i4 = i3 % 2;
            int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
            N = i5 % 128;
            int i6 = i5 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "PlaceComponentResult")
    private void PlaceComponentResult(HomeRecycleComponent homeRecycleComponent) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 19;
            N = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(homeRecycleComponent, "");
            this.PrepareContext = homeRecycleComponent;
            int i3 = N + 113;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? JSONLexer.EOI : (char) 14) != 26) {
                return;
            }
            int i4 = 82 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0019, code lost:
    
        if ((r0 != null ? 'Y' : 'O') != 'O') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0028, code lost:
    
        if ((r0 != null ? 'E' : 2) != 'E') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002a, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0030, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 103;
        id.dana.animation.HomeRecycleFragment.N = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003b, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003f, code lost:
    
        id.dana.animation.HomeRecycleFragment.N = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0042, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0043, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0044, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getCardNumberOCR")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.di.component.HomeRecycleComponent getCardNumberOCR() {
        /*
            r5 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L45
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1     // Catch: java.lang.Exception -> L45
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            if (r0 == 0) goto L1e
            id.dana.di.component.HomeRecycleComponent r0 = r5.PrepareContext
            int r3 = r2.length     // Catch: java.lang.Throwable -> L1c
            r3 = 79
            if (r0 == 0) goto L17
            r4 = 89
            goto L19
        L17:
            r4 = 79
        L19:
            if (r4 == r3) goto L2a
            goto L30
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.di.component.HomeRecycleComponent r0 = r5.PrepareContext
            r3 = 69
            if (r0 == 0) goto L27
            r4 = 69
            goto L28
        L27:
            r4 = 2
        L28:
            if (r4 == r3) goto L30
        L2a:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        L30:
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r2 = r2 + 103
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r2 = r2 % r1
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L43
            int r2 = r2 + 101
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r3     // Catch: java.lang.Exception -> L43
            int r2 = r2 % r1
            return r0
        L43:
            r0 = move-exception
            throw r0
        L45:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getCardNumberOCR():id.dana.di.component.HomeRecycleComponent");
    }

    @JvmName(name = "DatabaseTableConfigUtil")
    public final HomeAdapter DatabaseTableConfigUtil() {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 55;
            try {
                N = i % 128;
                int i2 = i % 2;
                HomeAdapter homeAdapter = this.GetContactSyncConfig;
                int i3 = N + 55;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                return homeAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004a  */
    @kotlin.jvm.JvmName(name = "PlaceComponentResult")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(boolean r6) {
        /*
            r5 = this;
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            r1 = 28
            if (r0 == 0) goto Ld
            r2 = 46
            goto Lf
        Ld:
            r2 = 28
        Lf:
            if (r2 == r1) goto L94
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 49
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L94
            android.widget.RelativeLayout r1 = r0.PlaceComponentResult
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.view.View r1 = (android.view.View) r1
            int r1 = r1.getVisibility()
            r3 = 0
            if (r1 != 0) goto L46
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 71
            int r4 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
            int r1 = r1 % 2
            r4 = 91
            if (r1 != 0) goto L40
            r1 = 91
            goto L42
        L40:
            r1 = 77
        L42:
            if (r1 == r4) goto L46
            r1 = 1
            goto L47
        L46:
            r1 = 0
        L47:
            if (r1 != 0) goto L4a
            return
        L4a:
            if (r6 == 0) goto L7b
            int r1 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L79
            int r1 = r1 + 35
            int r4 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4     // Catch: java.lang.Exception -> L79
            int r1 = r1 % 2
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r1 = r1.getErrorConfigVersion
            java.lang.String r4 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r1 = r1.lookAheadTest
            java.lang.String r4 = r5.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r0 = r0.lookAheadTest
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r3)
            goto L94
        L79:
            r6 = move-exception
            throw r6
        L7b:
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r1 = r1.getErrorConfigVersion
            java.lang.String r3 = "●●●"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r0 = r0.lookAheadTest
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.view.View r0 = (android.view.View) r0
            r1 = 8
            r0.setVisibility(r1)
        L94:
            r5.isLayoutRequested = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x001d, code lost:
    
        if ((r0 == null) != true) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0028, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002a, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x002c, code lost:
    
        if (r0 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x002e, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0030, code lost:
    
        if (r0 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0032, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0034, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0035, code lost:
    
        if (r3 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0037, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.N + 35;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0044, code lost:
    
        if ((r3 % 2) != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0046, code lost:
    
        r3 = r0.PlaceComponentResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0053, code lost:
    
        r5 = 9 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0054, code lost:
    
        if (r3.getVisibility() != 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0059, code lost:
    
        r3 = r0.PlaceComponentResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        if (r3.getVisibility() != 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0066, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0068, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.N + 113;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0072, code lost:
    
        if (r1 != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0075, code lost:
    
        if (r7 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0077, code lost:
    
        r1 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x007a, code lost:
    
        r1 = '#';
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x007c, code lost:
    
        if (r1 == '#') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x007e, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
        r1 = r1 % 2;
        MyBillsEntityDataFactory(r0.KClassImpl$Data$declaredNonStaticMembers$2, (int) id.dana.R.drawable.ic_eye_crossed_white);
        r0.MyBillsEntityDataFactory.setText(r6.scheduleImpl);
        r0.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getString(id.dana.R.string.icn_hide_balance));
        r0.MyBillsEntityDataFactory.setContentDescription(getString(id.dana.R.string.show_dana_amount));
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00b6, code lost:
    
        MyBillsEntityDataFactory(r0.KClassImpl$Data$declaredNonStaticMembers$2, (int) id.dana.R.drawable.ic_eye_filled_white);
        r0.MyBillsEntityDataFactory.setText(id.dana.wallet_v3.constant.WalletConstant.SECURE_TEXT);
        r0.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getString(id.dana.R.string.icn_show_balance));
        r0.MyBillsEntityDataFactory.setContentDescription(getString(id.dana.R.string.hide_dana_amount));
     */
    @kotlin.jvm.JvmName(name = "MyBillsEntityDataFactory")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(boolean r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.MyBillsEntityDataFactory(boolean):void");
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
        try {
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            if (fragmentHomeRecycleBinding != null && (viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                ViewHomeToolbarDanaBalanceBinding viewHomeToolbarDanaBalanceBinding = viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory;
                if ((viewHomeToolbarDanaBalanceBinding != null ? (char) 28 : '*') == 28) {
                    int i = N + 115;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                    int i2 = i % 2;
                    LinearLayout linearLayout = viewHomeToolbarDanaBalanceBinding.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                    if (!(linearLayout.getVisibility() == 0)) {
                        return;
                    }
                    boolean z2 = !z;
                    viewHomeToolbarDanaBalanceBinding.PlaceComponentResult.setClickable(z2);
                    viewHomeToolbarDanaBalanceBinding.PlaceComponentResult.setEnabled(z2);
                    if ((z ? '@' : 'a') == '@') {
                        try {
                            int i3 = N + 123;
                            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                            int i4 = i3 % 2;
                            viewHomeToolbarDanaBalanceBinding.PlaceComponentResult.setOnTouchListener(null);
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        viewHomeToolbarDanaBalanceBinding.PlaceComponentResult.setOnTouchListener(Y());
                    }
                }
            }
            this.SubSequence = z;
            int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            N = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "PlaceComponentResult")
    private void PlaceComponentResult(SwipeDelegateListener swipeDelegateListener) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 95;
        N = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(swipeDelegateListener, "");
        this.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = swipeDelegateListener;
        try {
            int i3 = N + 49;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001b, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0029, code lost:
    
        if ((r0 == null) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002b, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 69;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0036, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003c, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "secondaryHash")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.animation.SwipeDelegateListener secondaryHash() {
        /*
            r3 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 26
            if (r0 == 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 26
        L13:
            r2 = 0
            if (r0 == r1) goto L22
            id.dana.home.SwipeDelegateListener r0 = r3.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String     // Catch: java.lang.Exception -> L20
            r1 = 48
            int r1 = r1 / r2
            if (r0 == 0) goto L36
            goto L2b
        L1e:
            r0 = move-exception
            throw r0
        L20:
            r0 = move-exception
            throw r0
        L22:
            id.dana.home.SwipeDelegateListener r0 = r3.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String
            r1 = 1
            if (r0 == 0) goto L28
            goto L29
        L28:
            r2 = 1
        L29:
            if (r2 == r1) goto L36
        L2b:
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 69
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            return r0
        L36:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.secondaryHash():id.dana.home.SwipeDelegateListener");
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    private void KClassImpl$Data$declaredNonStaticMembers$2(PullBehaviorListener pullBehaviorListener) {
        int i = N + 13;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(pullBehaviorListener, "");
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = pullBehaviorListener;
        try {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 95;
            N = i3 % 128;
            if ((i3 % 2 != 0 ? '8' : 'E') != '8') {
                return;
            }
            int i4 = 94 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0017, code lost:
    
        if ((r0 == null) != true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0021, code lost:
    
        if ((r0 == null) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0023, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 55;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0035, code lost:
    
        if ((r1 % 2) == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0037, code lost:
    
        r1 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003a, code lost:
    
        r1 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x003c, code lost:
    
        if (r1 == '5') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0041, code lost:
    
        r1 = 20 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0042, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0045, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda7")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.home.HomeRecycleFragment.PullBehaviorListener NetworkUserEntityData$$ExternalSyntheticLambda7() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1c
            id.dana.home.HomeRecycleFragment$PullBehaviorListener r0 = r4.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String
            r3 = 6
            int r3 = r3 / r2
            if (r0 == 0) goto L16
            r3 = 0
            goto L17
        L16:
            r3 = 1
        L17:
            if (r3 == r1) goto L23
            goto L45
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            id.dana.home.HomeRecycleFragment$PullBehaviorListener r0 = r4.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String
            if (r0 == 0) goto L21
            r1 = 0
        L21:
            if (r1 == 0) goto L45
        L23:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 55
            int r3 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r1 = r1 % 2
            r3 = 53
            if (r1 == 0) goto L3a
            r1 = 53
            goto L3c
        L3a:
            r1 = 50
        L3c:
            if (r1 == r3) goto L3f
            return r0
        L3f:
            r1 = 20
            int r1 = r1 / r2
            return r0
        L43:
            r0 = move-exception
            throw r0
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7():id.dana.home.HomeRecycleFragment$PullBehaviorListener");
    }

    @JvmName(name = "Y")
    private final HomeRecycleFragment$swipeListener$2.AnonymousClass1 Y() {
        HomeRecycleFragment$swipeListener$2.AnonymousClass1 anonymousClass1;
        try {
            int i = N + 89;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if ((i % 2 == 0 ? '.' : 'V') != '.') {
                anonymousClass1 = (HomeRecycleFragment$swipeListener$2.AnonymousClass1) this.I.getValue();
            } else {
                anonymousClass1 = (HomeRecycleFragment$swipeListener$2.AnonymousClass1) this.I.getValue();
                int i2 = 14 / 0;
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 55;
            N = i3 % 128;
            int i4 = i3 % 2;
            return anonymousClass1;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void m() {
        FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
        if ((fragmentHomeRecycleBinding != null ? Typography.dollar : '4') != '$') {
            return;
        }
        try {
            ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            if (viewHomeToolbarMenuBinding != null) {
                try {
                    LinearLayout linearLayout = viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                    boolean z = false;
                    if (linearLayout.getVisibility() == 0) {
                        int i = N + 13;
                        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                        if (i % 2 != 0) {
                        }
                        z = true;
                    }
                    if (z) {
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
                            getAuthRequestContext(WalletConstant.SECURE_TEXT);
                            return;
                        }
                        getAuthRequestContext(this.scheduleImpl);
                        int i2 = N + 123;
                        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
                        int i3 = i2 % 2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0079, code lost:
    
        if (r2 == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x008b, code lost:
    
        if (r2.getVisibility() == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x008e, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x008f, code lost:
    
        if (r3 == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void l() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.l():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0057, code lost:
    
        if (r3 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0059, code lost:
    
        r3 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x005c, code lost:
    
        r3 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x005e, code lost:
    
        if (r3 == '&') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0062, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.N + 79;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x006e, code lost:
    
        if (r8.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0070, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 107;
        id.dana.animation.HomeRecycleFragment.N = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x007c, code lost:
    
        if (r8.getErrorConfigVersion == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x007e, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 39;
        id.dana.animation.HomeRecycleFragment.N = r3 % 128;
        r3 = r3 % 2;
        r3 = r8.AppCompatEmojiTextHelper;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x008a, code lost:
    
        if (r3 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x008c, code lost:
    
        r6 = id.dana.animation.HomeRecycleFragment.N + 3;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0095, code lost:
    
        if ((r6 % 2) != 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0097, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0099, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x009a, code lost:
    
        if (r6 == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x009c, code lost:
    
        r3.cancel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00a0, code lost:
    
        r3.cancel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00a5, code lost:
    
        r3 = 25 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00a9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00aa, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00ab, code lost:
    
        r3 = r8.NetworkUserEntityData$$ExternalSyntheticLambda6;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b4, code lost:
    
        if (r3.booleanValue() == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00b6, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00b8, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00b9, code lost:
    
        if (r3 == true) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00bb, code lost:
    
        r3 = r0.getErrorConfigVersion;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00c3, code lost:
    
        r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00ca, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        MyBillsEntityDataFactory(r0, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0023, code lost:
    
        if ((r0 != null ? 'G' : 7) != 'G') goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0034, code lost:
    
        if ((r0 != null ? 'V' : 27) != 27) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0036, code lost:
    
        r3 = r0.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0046, code lost:
    
        if (r3.getVisibility() != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0048, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 113;
        id.dana.animation.HomeRecycleFragment.N = r3 % 128;
        r3 = r3 % 2;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0054, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void access$throwIllegalArgumentType() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.access$throwIllegalArgumentType():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x005f, code lost:
    
        if ((r1 ? 21 : '#') != 21) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0061, code lost:
    
        r1 = r0.getErrorConfigVersion;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0069, code lost:
    
        r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x006b, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0070, code lost:
    
        r2 = r11.getErrorConfigVersion;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r5 = r2.getLoopUntilInMillis();
        r2 = r11.getErrorConfigVersion;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r7 = r2.getDelayInMillis();
        r0 = r0.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r10 = r1.KClassImpl$Data$declaredNonStaticMembers$2();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "");
        getAuthRequestContext(r5, r7, r0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0098, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0099, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0049, code lost:
    
        if (r1.booleanValue() != false) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void s() {
        /*
            r11 = this;
            androidx.viewbinding.ViewBinding r0 = r11.getBinding()     // Catch: java.lang.Exception -> L9d
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            if (r0 == 0) goto L9c
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 19
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L18
            r1 = 0
            goto L19
        L18:
            r1 = 1
        L19:
            r4 = 0
            if (r1 == r3) goto L24
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r4.length     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L9c
            goto L28
        L22:
            r0 = move-exception
            throw r0
        L24:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L9c
        L28:
            java.lang.Boolean r1 = r11.NetworkUserEntityData$$ExternalSyntheticLambda6
            if (r1 == 0) goto L9c
            id.dana.domain.user.DanaHomeBalanceConfigModel r5 = r11.getErrorConfigVersion
            if (r5 == 0) goto L9c
            int r5 = id.dana.animation.HomeRecycleFragment.N
            int r5 = r5 + 125
            int r6 = r5 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L3d
            goto L3e
        L3d:
            r2 = 1
        L3e:
            java.lang.String r3 = ""
            if (r2 == 0) goto L4c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L61
            goto L69
        L4c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r1.booleanValue()
            r4.hashCode()     // Catch: java.lang.Throwable -> L9a
            r2 = 21
            if (r1 == 0) goto L5d
            r1 = 21
            goto L5f
        L5d:
            r1 = 35
        L5f:
            if (r1 == r2) goto L69
        L61:
            id.dana.databinding.ViewHomeToolbarDanaPlusUnactiveBinding r1 = r0.getErrorConfigVersion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            androidx.viewbinding.ViewBinding r1 = (androidx.viewbinding.ViewBinding) r1
            goto L70
        L69:
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L98
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch: java.lang.Exception -> L9d
            androidx.viewbinding.ViewBinding r1 = (androidx.viewbinding.ViewBinding) r1     // Catch: java.lang.Exception -> L9d
        L70:
            id.dana.domain.user.DanaHomeBalanceConfigModel r2 = r11.getErrorConfigVersion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r5 = r2.getLoopUntilInMillis()
            id.dana.domain.user.DanaHomeBalanceConfigModel r2 = r11.getErrorConfigVersion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r7 = r2.getDelayInMillis()
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r0 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.LinearLayout r0 = r0.PlaceComponentResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r9 = r0
            android.view.View r9 = (android.view.View) r9
            android.view.View r10 = r1.KClassImpl$Data$declaredNonStaticMembers$2()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            r4 = r11
            r4.getAuthRequestContext(r5, r7, r9, r10)
            goto L9c
        L98:
            r0 = move-exception
            throw r0
        L9a:
            r0 = move-exception
            throw r0
        L9c:
            return
        L9d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.s():void");
    }

    @JvmName(name = "getAuthRequestContext")
    public final float getAuthRequestContext() {
        int i = N + 103;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        TypedArray obtainStyledAttributes = requireContext().getTheme().obtainStyledAttributes(new int[]{16843499});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        int i3 = N + 67;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return dimension;
    }

    @JvmName(name = SummaryActivity.DAYS)
    private final TranslateAnimation D() {
        int i = N + 43;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            try {
                TranslateAnimation translateAnimation = (TranslateAnimation) this.BuiltInFictitiousFunctionClassFactory.getValue();
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 91;
                N = i3 % 128;
                int i4 = i3 % 2;
                return translateAnimation;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "I")
    private final TranslateAnimation I() {
        int i = N + 83;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            TranslateAnimation translateAnimation = (TranslateAnimation) this.PlaceComponentResult.getValue();
            int i3 = N + 23;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            return translateAnimation;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = DiskFormatter.GB)
    private final TranslateAnimation G() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 57;
        N = i % 128;
        int i2 = i % 2;
        try {
            TranslateAnimation translateAnimation = (TranslateAnimation) this.moveToNextValue.getValue();
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
            N = i3 % 128;
            if ((i3 % 2 != 0 ? '\b' : 'H') != 'H') {
                Object[] objArr = null;
                int length = objArr.length;
                return translateAnimation;
            }
            return translateAnimation;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "AppCompatEmojiTextHelper")
    private final TranslateAnimation AppCompatEmojiTextHelper() {
        int i = N + 41;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            TranslateAnimation translateAnimation = (TranslateAnimation) this.MyBillsEntityDataFactory.getValue();
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 19;
            N = i3 % 128;
            int i4 = i3 % 2;
            return translateAnimation;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        LinearLayout linearLayout;
        ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
        PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                invoke2(homeTrackerImpl);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                long SubSequence = HomeRecycleFragment.SubSequence(HomeRecycleFragment.this);
                if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                    AnalyticsTracker KClassImpl$Data$declaredNonStaticMembers$2 = homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.BALANCE_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.NOTIFICATION_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.FOUR_KING, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.ALL_SERVICE_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.FEED_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.PROMO_CAROUSEL_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.WHAT_S_NEW_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.NEARBY_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.MORE_FOR_YOU_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.HOME_INVESTMENT_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.DANA_PROTECTION_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.HOME_PERSONALIZATION_LOAD_TIME, SubSequence);
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.BOTTOM_BAR_LOAD_TIME, SubSequence);
                }
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
        }
        PlaceComponentResult(((HomeTabActivity) activity).getSwipeDelegateListener());
        d();
        FillAnimation();
        e();
        a();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
        ImageView imageView = null;
        if ((fragmentHomeRecycleBinding != null ? '\b' : (char) 22) != 22) {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
            N = i % 128;
            int i2 = i % 2;
            linearLayout = fragmentHomeRecycleBinding.MyBillsEntityDataFactory;
        } else {
            linearLayout = null;
        }
        ViewHelper.getAuthRequestContext(linearLayout, new Runnable() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                HomeRecycleFragment.getAuthRequestContext(HomeRecycleFragment.this);
            }
        });
        FragmentHomeRecycleBinding fragmentHomeRecycleBinding2 = (FragmentHomeRecycleBinding) getBinding();
        if ((fragmentHomeRecycleBinding2 != null ? (char) 1 : 'A') == 1 && (viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            imageView = viewHomeToolbarMenuBinding.MyBillsEntityDataFactory;
        }
        ViewHelper.getAuthRequestContext(imageView, new Runnable() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                HomeRecycleFragment.PlaceComponentResult(HomeRecycleFragment.this);
            }
        });
        int i3 = N + 5;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void getNameOrBuilderList(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 47;
        N = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        homeRecycleFragment.RequestMoneyQrContract$View().get().KClassImpl$Data$declaredNonStaticMembers$2();
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.BALANCE);
        homeRecycleFragment.RequestMoneyQrContract$View().get().PlaceComponentResult(Boolean.FALSE);
        homeRecycleFragment.FragmentBottomSheetPaymentSettingBinding();
        if ((homeRecycleFragment.C() ? (char) 31 : 'F') != 31) {
            return;
        }
        try {
            homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda3();
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 123;
            N = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void M(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 53;
            N = i % 128;
            if (!(i % 2 == 0)) {
                Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                homeRecycleFragment.PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$init$3$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                        invoke2(homeTrackerImpl);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                        Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.NOTIFICATION);
                        if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                            homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.NOTIFICATION_LOAD_TIME, System.currentTimeMillis());
                        }
                    }
                });
                Object obj = null;
                obj.hashCode();
                return;
            }
            Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
            homeRecycleFragment.PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$init$3$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                    invoke2(homeTrackerImpl);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                    Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.NOTIFICATION);
                    if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                        homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.NOTIFICATION_LOAD_TIME, System.currentTimeMillis());
                    }
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x001b, code lost:
    
        if ((r4) != true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0026, code lost:
    
        if ((r0 instanceof id.dana.animation.HomeTabActivity) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0028, code lost:
    
        r0 = (id.dana.animation.HomeTabActivity) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x002b, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v5, types: [id.dana.home.HomeTabActivity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean C() {
        /*
            r6 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L86
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1     // Catch: java.lang.Exception -> L86
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()     // Catch: java.lang.Exception -> L84
            boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> L86
            int r5 = r1.length     // Catch: java.lang.Throwable -> L1e
            if (r4 == 0) goto L1a
            r4 = 1
            goto L1b
        L1a:
            r4 = 0
        L1b:
            if (r4 == r3) goto L28
            goto L2b
        L1e:
            r0 = move-exception
            throw r0
        L20:
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()     // Catch: java.lang.Exception -> L84
            boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> L84
            if (r4 == 0) goto L2b
        L28:
            id.dana.home.HomeTabActivity r0 = (id.dana.animation.HomeTabActivity) r0
            goto L2c
        L2b:
            r0 = r1
        L2c:
            if (r0 == 0) goto L40
            boolean r0 = r0.getOnFinishCheckSessionNotCalled()
            if (r0 != r3) goto L40
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 29
            int r4 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r0 = r0 % 2
            r0 = 1
            goto L4b
        L40:
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 111
            int r4 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r0 = r0 % 2
            r0 = 0
        L4b:
            if (r0 == 0) goto L83
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()
            boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity
            r5 = 15
            if (r4 == 0) goto L5a
            r4 = 43
            goto L5c
        L5a:
            r4 = 15
        L5c:
            if (r4 == r5) goto L61
            r1 = r0
            id.dana.home.HomeTabActivity r1 = (id.dana.animation.HomeTabActivity) r1
        L61:
            r0 = 11
            if (r1 == 0) goto L68
            r4 = 11
            goto L69
        L68:
            r4 = 1
        L69:
            if (r4 == r0) goto L6c
            goto L7e
        L6c:
            boolean r0 = r1.getIsFinishCheckSession()
            if (r0 != r3) goto L7e
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 69
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r0 = 1
            goto L7f
        L7e:
            r0 = 0
        L7f:
            if (r0 != 0) goto L82
            goto L83
        L82:
            r2 = 1
        L83:
            return r2
        L84:
            r0 = move-exception
            throw r0
        L86:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.C():boolean");
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 47;
        N = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            super.onAttach(p0);
            this.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String = System.currentTimeMillis();
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 63;
            N = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, androidx.fragment.app.Fragment
    public final void onStart() {
        int i = N + 115;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? Typography.dollar : Typography.quote) != '\"') {
            super.onStart();
            isAuto();
            obj.hashCode();
        } else {
            super.onStart();
            isAuto();
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 81;
        N = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00b8, code lost:
    
        JsonParseException().get().getAuthRequestContext();
        connectForeground();
        r0 = r6.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00ca, code lost:
    
        if (r0 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00cd, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ce, code lost:
    
        if (r1 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00d1, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00d3, code lost:
    
        if (r0 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00d5, code lost:
    
        r0.onNext(java.lang.Boolean.TRUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00da, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0021, code lost:
    
        if ((!r4) != true) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x002c, code lost:
    
        if ((r0 instanceof id.dana.animation.HomeTabActivity) != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x002e, code lost:
    
        r2 = (id.dana.animation.HomeTabActivity) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0031, code lost:
    
        if (r2 == 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0033, code lost:
    
        r2.setOnFinishCheckSessionNotCalled(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0036, code lost:
    
        k();
        m2615reduceIndexedz1zDJgo();
        MyBillsEntityDataFactory();
        RequestMoneyQrContract$View().get().PlaceComponentResult(java.lang.Boolean.TRUE);
        RequestMoneyQrContract$View().get().PlaceComponentResult();
        initRecordTimeStamp().get().BuiltInFictitiousFunctionClassFactory();
        y().get().PlaceComponentResult(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0081, code lost:
    
        if (getBaseActivity().getDanaApplication().isRefreshService() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0083, code lost:
    
        r0 = X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0087, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x008b, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x008f, code lost:
    
        id.dana.animation.HomeRecycleFragment.N = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0091, code lost:
    
        r2 = r2 % 2;
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0095, code lost:
    
        if (r0 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0097, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0099, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x009a, code lost:
    
        if (r2 == true) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x009c, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x009e, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00a0, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
        id.dana.animation.HomeRecycleFragment.N = r2 % 128;
        r2 = r2 % 2;
        r0.refreshView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00ad, code lost:
    
        getBaseActivity().getDanaApplication().setRefreshService(false);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [id.dana.home.HomeTabActivity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        /*
            r6 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L10
            r0 = 23
            goto L11
        L10:
            r0 = 0
        L11:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L26
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()
            boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity
            int r5 = r2.length     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto L20
            r4 = 0
            goto L21
        L20:
            r4 = 1
        L21:
            if (r4 == r3) goto L31
            goto L2e
        L24:
            r0 = move-exception
            throw r0
        L26:
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()     // Catch: java.lang.Exception -> Ldd
            boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> Ldb
            if (r4 == 0) goto L31
        L2e:
            r2 = r0
            id.dana.home.HomeTabActivity r2 = (id.dana.animation.HomeTabActivity) r2
        L31:
            if (r2 == 0) goto L36
            r2.setOnFinishCheckSessionNotCalled(r1)     // Catch: java.lang.Exception -> Ldd
        L36:
            r6.k()
            r6.m2615reduceIndexedz1zDJgo()
            r6.MyBillsEntityDataFactory()
            dagger.Lazy r0 = r6.RequestMoneyQrContract$View()
            java.lang.Object r0 = r0.get()
            id.dana.contract.user.GetBalanceContract$Presenter r0 = (id.dana.contract.user.GetBalanceContract.Presenter) r0
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.PlaceComponentResult(r2)
            dagger.Lazy r0 = r6.RequestMoneyQrContract$View()
            java.lang.Object r0 = r0.get()
            id.dana.contract.user.GetBalanceContract$Presenter r0 = (id.dana.contract.user.GetBalanceContract.Presenter) r0
            r0.PlaceComponentResult()
            dagger.Lazy r0 = r6.initRecordTimeStamp()
            java.lang.Object r0 = r0.get()
            id.dana.contract.globalsearch.GlobalSearchContract$Presenter r0 = (id.dana.contract.globalsearch.GlobalSearchContract.Presenter) r0
            r0.BuiltInFictitiousFunctionClassFactory()
            dagger.Lazy r0 = r6.y()
            java.lang.Object r0 = r0.get()
            id.dana.contract.user.GetUserInfoContract$Presenter r0 = (id.dana.contract.user.GetUserInfoContract.Presenter) r0
            r0.PlaceComponentResult(r3)
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()
            id.dana.DanaApplication r0 = r0.getDanaApplication()
            boolean r0 = r0.isRefreshService()
            if (r0 == 0) goto Lb8
            id.dana.home.adapter.HomeAdapter$ServicesViewHolder r0 = r6.X()
            if (r0 == 0) goto Lad
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> Ldd
            int r2 = r2 + 29
            int r4 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r4     // Catch: java.lang.Exception -> Ldd
            int r2 = r2 % 2
            id.dana.databinding.ViewItemServicesWidgetBinding r0 = r0.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L99
            r2 = 0
            goto L9a
        L99:
            r2 = 1
        L9a:
            if (r2 == r3) goto Lad
            id.dana.richview.servicescard.ServiceCardV2View r0 = r0.MyBillsEntityDataFactory
            if (r0 == 0) goto Lad
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r2 = r2 + 71
            int r4 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r2 = r2 % 2
            r0.refreshView()
        Lad:
            id.dana.base.BaseActivity r0 = r6.getBaseActivity()
            id.dana.DanaApplication r0 = r0.getDanaApplication()
            r0.setRefreshService(r1)
        Lb8:
            dagger.Lazy r0 = r6.JsonParseException()
            java.lang.Object r0 = r0.get()
            id.dana.contract.inbox.UnreadInboxContract$Presenter r0 = (id.dana.contract.inbox.UnreadInboxContract.Presenter) r0
            r0.getAuthRequestContext()
            r6.connectForeground()
            id.dana.home.adapter.HomeAdapter r0 = r6.GetContactSyncConfig
            if (r0 == 0) goto Lcd
            goto Lce
        Lcd:
            r1 = 1
        Lce:
            if (r1 == 0) goto Ld1
            goto Lda
        Ld1:
            io.reactivex.subjects.BehaviorSubject<java.lang.Boolean> r0 = r0.PlaceComponentResult
            if (r0 == 0) goto Lda
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.onNext(r1)
        Lda:
            return
        Ldb:
            r0 = move-exception
            throw r0
        Ldd:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda3():void");
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if ((this.readMicros ? '-' : (char) 7) != 7) {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 61;
            N = i % 128;
            if (i % 2 != 0) {
            }
            this.readMicros = false;
        } else {
            p();
            int i2 = N + 51;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
        }
        PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$onPause$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                invoke2(homeTrackerImpl);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                homeTrackerImpl.PlaceComponentResult();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean p0) {
        AppReadyMixpanelTracker appReadyMixpanelTracker;
        boolean z;
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
            N = i % 128;
            int i2 = i % 2;
            super.onHiddenChanged(p0);
            if (p0) {
                int i3 = N + 15;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                if ((i3 % 2 == 0 ? '?' : '(') != '?') {
                    p();
                    PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$onHiddenChanged$1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                            invoke2(homeTrackerImpl);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                            Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                            homeTrackerImpl.PlaceComponentResult();
                        }
                    });
                    appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                    z = false;
                } else {
                    p();
                    PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$onHiddenChanged$1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                            invoke2(homeTrackerImpl);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                            Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                            homeTrackerImpl.PlaceComponentResult();
                        }
                    });
                    appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                    z = true;
                }
                appReadyMixpanelTracker.getAuthRequestContext(TrackerKey.Property.NAVIGATES_OUT, z);
                try {
                    int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 103;
                    N = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            if ((!p0 ? '\t' : JSONLexer.EOI) != '\t') {
                return;
            }
            s();
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0079, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x007b, code lost:
    
        if (r0 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x007d, code lost:
    
        r0.setOnClickListener(new id.dana.animation.HomeRecycleFragment$$ExternalSyntheticLambda10());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0021, code lost:
    
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x002a, code lost:
    
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x002e, code lost:
    
        r0.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.setOnClickListener(new id.dana.animation.HomeRecycleFragment$$ExternalSyntheticLambda8());
        r0.getErrorConfigVersion.MyBillsEntityDataFactory.setOnClickListener(new id.dana.animation.HomeRecycleFragment$$ExternalSyntheticLambda9());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0066, code lost:
    
        if ((r0 != null ? 'K' : '\t') != 'K') goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0076, code lost:
    
        if ((r0 != null ? '?' : '4') != '?') goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e() {
        /*
            r5 = this;
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lc
            r3 = 0
            goto Ld
        Lc:
            r3 = 1
        Ld:
            if (r3 == 0) goto L10
            goto L44
        L10:
            int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L9f
            int r3 = r3 + 53
            int r4 = r3 % 128
            id.dana.animation.HomeRecycleFragment.N = r4     // Catch: java.lang.Exception -> L9f
            int r3 = r3 % 2
            if (r3 == 0) goto L1d
            r1 = 0
        L1d:
            if (r1 == 0) goto L24
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L86
            if (r0 == 0) goto L44
            goto L2c
        L24:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L9d
            if (r0 == 0) goto L44
        L2c:
            id.dana.databinding.ViewHomeToolbarDanaPlusActiveBinding r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L86
            id.dana.home.view.SavedCardIndicatorLottieAnimationView r1 = r1.scheduleImpl
            id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda8 r3 = new id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda8
            r3.<init>()
            r1.setOnClickListener(r3)
            id.dana.databinding.ViewHomeToolbarDanaPlusUnactiveBinding r1 = r0.getErrorConfigVersion
            id.dana.home.view.SavedCardIndicatorLottieAnimationView r1 = r1.MyBillsEntityDataFactory
            id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda9 r3 = new id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda9
            r3.<init>()
            r1.setOnClickListener(r3)
        L44:
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            if (r0 == 0) goto L88
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 107
            int r3 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L6b
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 24
            int r1 = r1 / r2
            r1 = 75
            if (r0 == 0) goto L64
            r2 = 75
            goto L66
        L64:
            r2 = 9
        L66:
            if (r2 == r1) goto L79
            goto L88
        L69:
            r0 = move-exception
            throw r0
        L6b:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L86
            r1 = 63
            if (r0 == 0) goto L74
            r2 = 63
            goto L76
        L74:
            r2 = 52
        L76:
            if (r2 == r1) goto L79
            goto L88
        L79:
            android.widget.ImageView r0 = r0.MyBillsEntityDataFactory
            if (r0 == 0) goto L88
            id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda10 r1 = new id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda10
            r1.<init>()
            r0.setOnClickListener(r1)
            goto L88
        L86:
            r0 = move-exception
            throw r0
        L88:
            id.dana.home.HomeRecycleFragment$initViewListener$3 r0 = new id.dana.home.HomeRecycleFragment$initViewListener$3
            r0.<init>()
            id.dana.home.HomeRecycleFragment$PullBehaviorListener r0 = (id.dana.home.HomeRecycleFragment.PullBehaviorListener) r0
            r5.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            return
        L9d:
            r0 = move-exception
            throw r0
        L9f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.e():void");
    }

    private static final void MyBillsEntityDataFactory(ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding, HomeRecycleFragment homeRecycleFragment) {
        boolean z;
        Intrinsics.checkNotNullParameter(viewHomeToolbarMenuBinding, "");
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        LinearLayout linearLayout = viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        if ((linearLayout.getVisibility() == 0 ? (char) 6 : (char) 18) != 6) {
            z = false;
            try {
                int i = N + 107;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } else {
            int i3 = N + 73;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            z = true;
            int i5 = N + 5;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i5 % 128;
            int i6 = i5 % 2;
        }
        if (z) {
            homeRecycleFragment.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider();
        }
    }

    private static final void getAuthRequestContext(ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding, HomeRecycleFragment homeRecycleFragment) {
        boolean z;
        int i = N + 41;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(viewHomeToolbarMenuBinding, "");
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        LinearLayout linearLayout = viewHomeToolbarMenuBinding.getErrorConfigVersion.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        if (!(linearLayout.getVisibility() == 0)) {
            z = false;
        } else {
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 69;
            N = i3 % 128;
            int i4 = i3 % 2;
            try {
                int i5 = N + 115;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i5 % 128;
                int i6 = i5 % 2;
                z = true;
            } catch (Exception e) {
                throw e;
            }
        }
        if (z ? false : true) {
            return;
        }
        homeRecycleFragment.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider();
    }

    private static final void K(HomeRecycleFragment homeRecycleFragment) {
        int i = N + 23;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        homeRecycleFragment.secondaryHash().getAuthRequestContext("Inbox Icon", false);
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 1;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0047, code lost:
    
        if ((r7 != null ? kotlin.text.Typography.quote : '`') != '\"') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0076, code lost:
    
        if ((r7 != null ? '^' : 'G') != '^') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0079, code lost:
    
        r7 = getAuthRequestContext(r3, r0, r7);
        BuiltInFictitiousFunctionClassFactory(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0080, code lost:
    
        if (r7 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0082, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0084, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0085, code lost:
    
        if (r0 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0087, code lost:
    
        r7.start();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(java.lang.String r7) {
        /*
            r6 = this;
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8d
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L8b
            if (r0 == 0) goto L8d
            int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r3 = r3 + 5
            int r4 = r3 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L4c
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r3 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r3 = r3.MyBillsEntityDataFactory
            int r3 = r3.getWidth()
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r4 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r4 = r4.MyBillsEntityDataFactory
            android.text.TextPaint r4 = r4.getPaint()
            float r7 = r4.measureText(r7)
            int r7 = (int) r7
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r0 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r0 = r0.MyBillsEntityDataFactory
            float r0 = r0.getAlpha()
            android.animation.ValueAnimator r7 = r6.BuiltInFictitiousFunctionClassFactory(r7, r0)
            r4 = 29
            int r4 = r4 / r1
            r4 = 34
            if (r7 == 0) goto L45
            r5 = 34
            goto L47
        L45:
            r5 = 96
        L47:
            if (r5 == r4) goto L79
            goto L8d
        L4a:
            r7 = move-exception
            throw r7
        L4c:
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r3 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r3 = r3.MyBillsEntityDataFactory
            int r3 = r3.getWidth()
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r4 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r4 = r4.MyBillsEntityDataFactory
            android.text.TextPaint r4 = r4.getPaint()
            float r7 = r4.measureText(r7)
            int r7 = (int) r7
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r0 = r0.BuiltInFictitiousFunctionClassFactory
            android.widget.TextView r0 = r0.MyBillsEntityDataFactory
            float r0 = r0.getAlpha()
            android.animation.ValueAnimator r7 = r6.BuiltInFictitiousFunctionClassFactory(r7, r0)
            r4 = 94
            if (r7 == 0) goto L74
            r5 = 94
            goto L76
        L74:
            r5 = 71
        L76:
            if (r5 == r4) goto L79
            goto L8d
        L79:
            android.animation.ValueAnimator r7 = r6.getAuthRequestContext(r3, r0, r7)
            r6.BuiltInFictitiousFunctionClassFactory(r2)
            if (r7 == 0) goto L84
            r0 = 1
            goto L85
        L84:
            r0 = 0
        L85:
            if (r0 == 0) goto L8d
            r7.start()
            goto L8d
        L8b:
            r7 = move-exception
            throw r7
        L8d:
            int r7 = id.dana.animation.HomeRecycleFragment.N
            int r7 = r7 + 95
            int r0 = r7 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L9b
            r7 = 0
            goto L9c
        L9b:
            r7 = 1
        L9c:
            if (r7 == r2) goto La4
            r7 = 26
            int r7 = r7 / r1
            return
        La2:
            r7 = move-exception
            throw r7
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getAuthRequestContext(java.lang.String):void");
    }

    private final ValueAnimator getAuthRequestContext(final int p0, final float p1, final ValueAnimator p2) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 107;
            N = i % 128;
            int i2 = i % 2;
            try {
                FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
                Object[] objArr = null;
                if (fragmentHomeRecycleBinding == null) {
                    return null;
                }
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 99;
                N = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                    int length = objArr.length;
                    if (viewHomeToolbarMenuBinding == null) {
                        return null;
                    }
                } else if (fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    return null;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(p0, 0);
                ofInt.setDuration(200L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda14
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HomeRecycleFragment.PlaceComponentResult(HomeRecycleFragment.this, p0, p1, valueAnimator);
                    }
                });
                ofInt.addListener(new AnimatorListenerAdapter() { // from class: id.dana.home.HomeRecycleFragment$getCollapseBalanceAnimator$1$1$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator p02) {
                        Intrinsics.checkNotNullParameter(p02, "");
                        super.onAnimationEnd(p02);
                        HomeRecycleFragment.I(HomeRecycleFragment.this);
                        p2.start();
                    }
                });
                return ofInt;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, int i, float f, ValueAnimator valueAnimator) {
        Integer num;
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (!(animatedValue instanceof Integer)) {
            num = null;
            try {
                int i2 = N + 53;
                try {
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
                    int i3 = i2 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            int i4 = N + 41;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
            int i5 = i4 % 2;
            num = (Integer) animatedValue;
        }
        if (!(num != null)) {
            return;
        }
        homeRecycleFragment.PlaceComponentResult(num.intValue(), i, f);
    }

    private final ValueAnimator BuiltInFictitiousFunctionClassFactory(final int p0, final float p1) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 11;
            N = i % 128;
            int i2 = i % 2;
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            if ((fragmentHomeRecycleBinding != null ? 'O' : Typography.greater) == 'O') {
                int i3 = N + 75;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                final ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                if (viewHomeToolbarMenuBinding != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(0, p0);
                    ofInt.setDuration(200L);
                    ofInt.setStartDelay(100L);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda7
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            HomeRecycleFragment.getAuthRequestContext(HomeRecycleFragment.this, p0, p1, valueAnimator);
                        }
                    });
                    ofInt.addListener(new AnimatorListenerAdapter() { // from class: id.dana.home.HomeRecycleFragment$getExpandBalanceAnimator$1$1$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator p02) {
                            Intrinsics.checkNotNullParameter(p02, "");
                            super.onAnimationEnd(p02);
                            ViewHomeToolbarMenuBinding.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getLayoutParams().width = -2;
                            HomeRecycleFragment.E(this);
                        }
                    });
                    return ofInt;
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, int i, float f, ValueAnimator valueAnimator) {
        Integer num;
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (!(animatedValue instanceof Integer)) {
            num = null;
        } else {
            int i2 = N + 77;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            try {
                num = (Integer) animatedValue;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((num != null ? '0' : 'a') != 'a') {
            int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
            N = i4 % 128;
            int i5 = i4 % 2;
            try {
                homeRecycleFragment.PlaceComponentResult(num.intValue(), i, f);
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void PlaceComponentResult(int p0, int p1, float p2) {
        FragmentHomeRecycleBinding fragmentHomeRecycleBinding;
        int i = N + 55;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 != 0) {
            fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            if (fragmentHomeRecycleBinding == null) {
                return;
            }
        } else {
            fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            Object obj = null;
            obj.hashCode();
            if (fragmentHomeRecycleBinding == null) {
                return;
            }
        }
        try {
            ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            if (viewHomeToolbarMenuBinding != null) {
                int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 35;
                N = i2 % 128;
                int i3 = i2 % 2;
                try {
                    ViewGroup.LayoutParams layoutParams = viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getLayoutParams();
                    layoutParams.width = p0;
                    viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setLayoutParams(layoutParams);
                    viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setAlpha(p2 * (p0 / p1));
                    int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 35;
                    N = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider() {
        try {
            if (getBaseActivity() instanceof HomeTabActivity) {
                try {
                    int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 89;
                    N = i % 128;
                    int i2 = i % 2;
                    BaseActivity baseActivity = getBaseActivity();
                    if (baseActivity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                    }
                    ((HomeTabActivity) baseActivity).showDanaLoadingDialog();
                    int i3 = N + 25;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda8().get().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, true);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: reduceIndexed-z1zDJgo */
    private void m2615reduceIndexedz1zDJgo() {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 39;
        N = i % 128;
        if (i % 2 != 0) {
            boolean z = this.newProxyInstance;
            Object obj = null;
            obj.hashCode();
            if (z) {
                return;
            }
        } else if (this.newProxyInstance) {
            return;
        }
        try {
            this.newProxyInstance = true;
            NetworkUserEntityData$$ExternalSyntheticLambda1().get().KClassImpl$Data$declaredNonStaticMembers$2();
            g();
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 91;
            N = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getAuthRequestContext(boolean p0) {
        int i = N + 43;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'V' : 'b') != 'V') {
            this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = p0;
        } else {
            this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = p0;
            int length = objArr.length;
        }
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 121;
        N = i2 % 128;
        if ((i2 % 2 != 0 ? 'Y' : (char) 16) != 'Y') {
            return;
        }
        int length2 = objArr.length;
    }

    private final void d() {
        DaggerHomeRecycleComponent.Builder PlaceComponentResult = DaggerHomeRecycleComponent.PlaceComponentResult();
        PlaceComponentResult.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (GetBalanceModule) Preconditions.getAuthRequestContext(F());
        PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding = (UnreadInboxModule) Preconditions.getAuthRequestContext(Z());
        PlaceComponentResult.newProxyInstance = (QueryPayMethodModule) Preconditions.getAuthRequestContext(W());
        PlaceComponentResult.DatabaseTableConfigUtil = (PayLaterModule) Preconditions.getAuthRequestContext(R());
        PlaceComponentResult.lookAheadTest = (HomeInfoModule) Preconditions.getAuthRequestContext(N());
        PlaceComponentResult.getAuthRequestContext = (GeofenceModule) Preconditions.getAuthRequestContext(K());
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 = (LogoutModule) Preconditions.getAuthRequestContext(P());
        PlaceComponentResult.scheduleImpl = (GlobalSearchModule) Preconditions.getAuthRequestContext(L());
        PlaceComponentResult.moveToNextValue = (GlobalNetworkModule) Preconditions.getAuthRequestContext(getNameOrBuilderList());
        PlaceComponentResult.getErrorConfigVersion = (GetUserInfoModule) Preconditions.getAuthRequestContext(flip());
        PlaceComponentResult.GetContactSyncConfig = (OttVerifyModule) Preconditions.getAuthRequestContext(SummaryVoucherView$$ExternalSyntheticLambda1());
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = (PermissionStateModule) Preconditions.getAuthRequestContext(isAuth());
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2 = (HomeTabModules) Preconditions.getAuthRequestContext(SummaryVoucherView$$ExternalSyntheticLambda0());
        PlaceComponentResult.isLayoutRequested = (ServicesModule) Preconditions.getAuthRequestContext(V());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
        Object[] objArr = new Object[1];
        ab(8 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{50372, 49810, 31786, 19122, 65285, 16044, 58995, 41687}, objArr);
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = ((String) objArr[0]).intern();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        PlaceComponentResult.PrepareContext = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        PlaceComponentResult.initRecordTimeStamp = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, GetBalanceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding, UnreadInboxModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.newProxyInstance, QueryPayMethodModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.lookAheadTest, HomeInfoModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, GeofenceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1, LogoutModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.scheduleImpl, GlobalSearchModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getErrorConfigVersion, GetUserInfoModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.GetContactSyncConfig, OttVerifyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8, PermissionStateModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.moveToNextValue, GlobalNetworkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.DatabaseTableConfigUtil, PayLaterModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2, HomeTabModules.class);
        if (PlaceComponentResult.PlaceComponentResult == null) {
            PlaceComponentResult.PlaceComponentResult = new BiometricAnalyticModule();
            int i = N + 99;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
        }
        if (PlaceComponentResult.isLayoutRequested == null) {
            PlaceComponentResult.isLayoutRequested = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PrepareContext, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.initRecordTimeStamp, OauthModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, ApplicationComponent.class);
        DaggerHomeRecycleComponent.HomeRecycleComponentImpl homeRecycleComponentImpl = new DaggerHomeRecycleComponent.HomeRecycleComponentImpl(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding, PlaceComponentResult.newProxyInstance, PlaceComponentResult.lookAheadTest, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1, PlaceComponentResult.scheduleImpl, PlaceComponentResult.getErrorConfigVersion, PlaceComponentResult.GetContactSyncConfig, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8, PlaceComponentResult.moveToNextValue, PlaceComponentResult.DatabaseTableConfigUtil, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.isLayoutRequested, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.PrepareContext, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.initRecordTimeStamp, PlaceComponentResult.MyBillsEntityDataFactory, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(homeRecycleComponentImpl, "");
        PlaceComponentResult(homeRecycleComponentImpl);
        getCardNumberOCR().getAuthRequestContext(this);
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    private final ServicesModule V() {
        ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.home.HomeRecycleFragment$getServicesModule$1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int BuiltInFictitiousFunctionClassFactory = 0;
            private static int MyBillsEntityDataFactory = 1;
            private static char[] PlaceComponentResult = {62237, 40390, 12006, 49151, 18579, 55692, 27301, 64326};
            private static long KClassImpl$Data$declaredNonStaticMembers$2 = -1487208148026090077L;

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                int i = BuiltInFictitiousFunctionClassFactory + 117;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                int i3 = BuiltInFictitiousFunctionClassFactory + 5;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                try {
                    int i = MyBillsEntityDataFactory + 9;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    int i3 = BuiltInFictitiousFunctionClassFactory + 25;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return authRequestContext;
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                int i = MyBillsEntityDataFactory + 123;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 != 0 ? '+' : ')') != '+') {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                    return;
                }
                try {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                try {
                    int i = MyBillsEntityDataFactory + 45;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    ServicesContract.View.CC.PlaceComponentResult();
                    try {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 19;
                        MyBillsEntityDataFactory = i3 % 128;
                        if (i3 % 2 != 0) {
                            return;
                        }
                        int i4 = 51 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                int i = MyBillsEntityDataFactory + 93;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                int i3 = MyBillsEntityDataFactory + 61;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? '3' : (char) 17) != 17) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                int i = MyBillsEntityDataFactory + 115;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                boolean z = i % 2 == 0;
                ServicesContract.View.CC.PlaceComponentResult(list);
                if (!z) {
                    Object obj = null;
                    obj.hashCode();
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 119;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                    int i3 = MyBillsEntityDataFactory + 123;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if ((i3 % 2 != 0 ? (char) 19 : 'B') != 'B') {
                        int i4 = 47 / 0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                int i = MyBillsEntityDataFactory + 21;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 != 0 ? '5' : (char) 30) == 30) {
                    try {
                        Intrinsics.checkNotNullParameter(list, "");
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                try {
                    Intrinsics.checkNotNullParameter(list, "");
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e2) {
                    throw e2;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                int i = MyBillsEntityDataFactory + 99;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                try {
                    if (i % 2 == 0) {
                        ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    }
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                int i = BuiltInFictitiousFunctionClassFactory + 1;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                int i3 = MyBillsEntityDataFactory + 17;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? ')' : ']') != ')') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> p0) {
                Unit unit;
                Object obj;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                Iterator<T> it = p0.iterator();
                while (true) {
                    unit = null;
                    str = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    int i = BuiltInFictitiousFunctionClassFactory + 57;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    obj = it.next();
                    if (Intrinsics.areEqual(((ThirdPartyService) obj).NetworkUserEntityData$$ExternalSyntheticLambda8, "service_dana_plus")) {
                        break;
                    }
                }
                ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
                if ((thirdPartyService != null ? (char) 22 : (char) 30) == 22) {
                    HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                    String str2 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    if ((str2 != null ? '^' : (char) 25) == '^') {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 63;
                        MyBillsEntityDataFactory = i3 % 128;
                        if (i3 % 2 == 0) {
                            Object[] objArr = new Object[1];
                            a(KeyEvent.normalizeMetaState(0), 8 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >>> 2), objArr);
                            str = StringsKt.replace$default(str2, ((String) objArr[0]).intern(), TrackerKey.SourceType.HOMEPAGE_CLICK, false, 3, (Object) null);
                        } else {
                            Object[] objArr2 = new Object[1];
                            a(KeyEvent.normalizeMetaState(0), Gravity.getAbsoluteGravity(0, 0) + 8, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), objArr2);
                            str = StringsKt.replace$default(str2, ((String) objArr2[0]).intern(), TrackerKey.SourceType.HOMEPAGE_CLICK, false, 4, (Object) null);
                        }
                        int i4 = MyBillsEntityDataFactory + 119;
                        BuiltInFictitiousFunctionClassFactory = i4 % 128;
                        int i5 = i4 % 2;
                    }
                    try {
                        ServicesContract.Presenter presenter = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda8().get();
                        Intrinsics.checkNotNullExpressionValue(presenter, "");
                        presenter.MyBillsEntityDataFactory(ThirdPartyService.getAuthRequestContext(thirdPartyService, str), (Map<String, String>) null);
                        unit = Unit.INSTANCE;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if ((unit == null ? Typography.greater : 'R') != '>') {
                    return;
                }
                HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                int i = BuiltInFictitiousFunctionClassFactory + 33;
                MyBillsEntityDataFactory = i % 128;
                char c = i % 2 != 0 ? '0' : '!';
                HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                if (c != '0') {
                    int i2 = 20 / 0;
                }
                int i3 = MyBillsEntityDataFactory + 21;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionFailed(String p0) {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 117;
                    MyBillsEntityDataFactory = i % 128;
                    if (!(i % 2 == 0)) {
                        HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                        return;
                    }
                    HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                    int i2 = 87 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService p0) {
                int i = MyBillsEntityDataFactory + 77;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(p0, "");
                HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if ((str != null ? 'Z' : 'P') != 'Z') {
                    return;
                }
                try {
                    HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                    Object[] objArr = null;
                    if (!UrlUtil.getErrorConfigVersion(str)) {
                        WalletH5ServicesImplementation walletH5ServicesImplementation = homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda6().get();
                        String authRequestContext = UrlUtil.getAuthRequestContext(str);
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        walletH5ServicesImplementation.openH5(p0, authRequestContext, null, null);
                        return;
                    }
                    int i3 = BuiltInFictitiousFunctionClassFactory + 67;
                    MyBillsEntityDataFactory = i3 % 128;
                    if ((i3 % 2 == 0 ? '-' : ')') == ')') {
                        homeRecycleFragment.isLayoutRequested().get().MyBillsEntityDataFactory(str);
                        return;
                    }
                    try {
                        homeRecycleFragment.isLayoutRequested().get().MyBillsEntityDataFactory(str);
                        int length = objArr.length;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService p0, String p1) {
                int i = BuiltInFictitiousFunctionClassFactory + 103;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                try {
                    Intrinsics.checkNotNullParameter(p0, "");
                    try {
                        HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                        WalletH5ServicesImplementation walletH5ServicesImplementation = HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6().get();
                        String authRequestContext = UrlUtil.getAuthRequestContext(p0.getCallingPid);
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        walletH5ServicesImplementation.openH5(p0, authRequestContext, p1, HomeRecycleFragment.this.lookAheadTest().get().getDeviceUUID());
                        int i3 = MyBillsEntityDataFactory + 55;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        if (!(i3 % 2 == 0)) {
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

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onMaintenanceAction(ThirdPartyService p0) {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 125;
                    MyBillsEntityDataFactory = i % 128;
                    if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : (char) 11) != 11) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                        ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                        int i2 = 8 / 0;
                    } else {
                        Intrinsics.checkNotNullParameter(p0, "");
                        HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                        ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    }
                    int i3 = BuiltInFictitiousFunctionClassFactory + 5;
                    MyBillsEntityDataFactory = i3 % 128;
                    if (i3 % 2 == 0) {
                        Object obj = null;
                        obj.hashCode();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService p0, Map<String, String> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (!(str == null)) {
                    HomeRecycleFragment.this.getErrorConfigVersion().getAuthRequestContext(str, p1);
                    int i = BuiltInFictitiousFunctionClassFactory + 21;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                }
                int i3 = MyBillsEntityDataFactory + 55;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, int i2, char c, Object[] objArr) {
                whenAvailable whenavailable = new whenAvailable();
                long[] jArr = new long[i2];
                try {
                    whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
                    while (true) {
                        if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                            break;
                        }
                        jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
                        whenavailable.BuiltInFictitiousFunctionClassFactory++;
                    }
                    char[] cArr = new char[i2];
                    whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
                    while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                        try {
                            int i3 = $10 + 43;
                            $11 = i3 % 128;
                            int i4 = i3 % 2;
                            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                            whenavailable.BuiltInFictitiousFunctionClassFactory++;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    String str = new String(cArr);
                    int i5 = $10 + 11;
                    $11 = i5 % 128;
                    if (i5 % 2 != 0) {
                        objArr[0] = str;
                        return;
                    }
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                    objArr[0] = str;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        });
        int i = N + 23;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? 'R' : (char) 16) != 16) {
            Object obj = null;
            obj.hashCode();
            return servicesModule;
        }
        return servicesModule;
    }

    private final void B() {
        try {
            if ((getBaseActivity() instanceof HomeTabActivity ? 'A' : (char) 4) == 4) {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
                N = i % 128;
                if (i % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                return;
            }
            int i2 = N + 99;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
            }
            ((HomeTabActivity) baseActivity).dismissDanaLoadingDialog();
        } catch (Exception e) {
            throw e;
        }
    }

    private final OttVerifyModule SummaryVoucherView$$ExternalSyntheticLambda1() {
        OttVerifyModule ottVerifyModule = new OttVerifyModule(new OttVerifyContract.View() { // from class: id.dana.home.HomeRecycleFragment$getOttVerifyDependencyModule$1
            @Override // id.dana.contract.ott.OttVerifyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(OttVerifyModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().lookAheadTest = p0.PlaceComponentResult;
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("deeplink_payment_with_ott", "");
                Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("deeplink_payment_with_ott");
                if (trace != null) {
                    trace.stop();
                }
                if (p0.getGetAuthRequestContext()) {
                    HomeRecycleFragment.this.getSupportButtonTintMode();
                } else {
                    HomeRecycleFragment.lookAheadTest(HomeRecycleFragment.this);
                }
            }

            @Override // id.dana.contract.ott.OttVerifyContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                if (p0) {
                    HomeRecycleFragment.lookAheadTest(HomeRecycleFragment.this);
                } else {
                    HomeRecycleFragment.this.getSupportButtonTintMode();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                if (HomeRecycleFragment.this.getBaseActivity() instanceof HomeTabActivity) {
                    BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                    if (baseActivity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                    }
                    ((HomeTabActivity) baseActivity).showDanaLoadingDialog();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                if (HomeRecycleFragment.this.getBaseActivity() instanceof HomeTabActivity) {
                    BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                    if (baseActivity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                    }
                    ((HomeTabActivity) baseActivity).dismissDanaLoadingDialog();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                HomeRecycleFragment.this.getBaseActivity().showWarningDialog(p0);
            }
        });
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
        N = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return ottVerifyModule;
        }
        return ottVerifyModule;
    }

    private final PermissionStateModule isAuth() {
        PermissionStateModule permissionStateModule = new PermissionStateModule(new PermissionStateContract.View() { // from class: id.dana.home.HomeRecycleFragment$getPermissionStateDependencyModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.permission.PermissionStateContract.View
            public final void PlaceComponentResult(boolean p0) {
                if (p0) {
                    return;
                }
                HomeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$2(HomeRecycleFragment.this);
            }
        });
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 63;
        N = i % 128;
        if ((i % 2 != 0 ? '0' : (char) 25) != 25) {
            Object[] objArr = null;
            int length = objArr.length;
            return permissionStateModule;
        }
        return permissionStateModule;
    }

    private static HomeTabModules SummaryVoucherView$$ExternalSyntheticLambda0() {
        try {
            HomeTabModules homeTabModules = new HomeTabModules(new HomeTabContract.View() { // from class: id.dana.home.HomeRecycleFragment$getHomeTabModule$1
                @Override // id.dana.home.presenter.HomeTabContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean z) {
                    HomeTabContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                    HomeTabContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void PlaceComponentResult(boolean p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void getAuthRequestContext() {
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void getAuthRequestContext(boolean p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                }

                @Override // id.dana.home.presenter.HomeTabContract.View
                public final void scheduleImpl(boolean p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            });
            int i = N + 119;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (i % 2 != 0) {
                return homeTabModules;
            }
            int i2 = 71 / 0;
            return homeTabModules;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0016, code lost:
    
        if ((r0 != null) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x001d, code lost:
    
        if (r4.getValueOfTouchPositionAbsolute == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0023, code lost:
    
        if (getContext() == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0025, code lost:
    
        r0 = id.dana.dialog.DialogPermissionFactory.BuiltInFictitiousFunctionClassFactory(getContext(), "location", new id.dana.animation.HomeRecycleFragment$showLocationPermissionDialog$1());
        r4.getValueOfTouchPositionAbsolute = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x003a, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003c, code lost:
    
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x003f, code lost:
    
        r3 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0041, code lost:
    
        if (r3 == '8') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0045, code lost:
    
        r2 = id.dana.animation.HomeRecycleFragment.N + 47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0049, code lost:
    
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x004b, code lost:
    
        r2 = r2 % 2;
        r0.MyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0050, code lost:
    
        if (r2 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0054, code lost:
    
        r0 = 8 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0059, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x005b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x005c, code lost:
    
        r0 = id.dana.animation.HomeRecycleFragment.N + 69;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0066, code lost:
    
        if ((r0 % 2) != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x006a, code lost:
    
        r0 = 97 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x006e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void t() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1b
            id.dana.dialog.DialogPermission r0 = r4.getValueOfTouchPositionAbsolute
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L15
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            if (r0 == 0) goto L1f
            goto L5c
        L19:
            r0 = move-exception
            throw r0
        L1b:
            id.dana.dialog.DialogPermission r0 = r4.getValueOfTouchPositionAbsolute
            if (r0 != 0) goto L5c
        L1f:
            android.content.Context r0 = r4.getContext()
            if (r0 == 0) goto L5c
            android.content.Context r0 = r4.getContext()
            id.dana.home.HomeRecycleFragment$showLocationPermissionDialog$1 r2 = new id.dana.home.HomeRecycleFragment$showLocationPermissionDialog$1
            r2.<init>()
            id.dana.dialog.DialogPermission$DialogListener r2 = (id.dana.dialog.DialogPermission.DialogListener) r2
            java.lang.String r3 = "location"
            id.dana.dialog.DialogPermission r0 = id.dana.dialog.DialogPermissionFactory.BuiltInFictitiousFunctionClassFactory(r0, r3, r2)
            r4.getValueOfTouchPositionAbsolute = r0
            r2 = 56
            if (r0 == 0) goto L3f
            r3 = 26
            goto L41
        L3f:
            r3 = 56
        L41:
            if (r3 == r2) goto L5c
            int r2 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L5a
            int r2 = r2 + 47
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3     // Catch: java.lang.Exception -> L58
            int r2 = r2 % 2
            r0.MyBillsEntityDataFactory()
            if (r2 != 0) goto L5c
            r0 = 8
            int r0 = r0 / r1
            goto L5c
        L56:
            r0 = move-exception
            throw r0
        L58:
            r0 = move-exception
            throw r0
        L5a:
            r0 = move-exception
            throw r0
        L5c:
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 69
            int r2 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L6e
            r0 = 97
            int r0 = r0 / r1
            return
        L6c:
            r0 = move-exception
            throw r0
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.t():void");
    }

    private static final void J(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 115;
        N = i % 128;
        try {
            if ((i % 2 != 0 ? '8' : 'a') != 'a') {
                Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                OtpRegistrationPresenter$input$2();
                Object obj = null;
                obj.hashCode();
            } else {
                Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                OtpRegistrationPresenter$input$2();
            }
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
            N = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getSupportButtonTintMode() {
        MatchPhoneNumberDialog.Builder builder = new MatchPhoneNumberDialog.Builder(getContext(), new DialogInterface.OnDismissListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this);
            }
        });
        builder.MyBillsEntityDataFactory = new View.OnClickListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeRecycleFragment.scheduleImpl(HomeRecycleFragment.this);
            }
        };
        builder.getAuthRequestContext = new View.OnClickListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeRecycleFragment.MyBillsEntityDataFactory(HomeRecycleFragment.this);
            }
        };
        MatchPhoneNumberDialog matchPhoneNumberDialog = new MatchPhoneNumberDialog(builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult, builder, (byte) 0);
        this.getOnBoardingScenario = matchPhoneNumberDialog;
        matchPhoneNumberDialog.MyBillsEntityDataFactory();
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
        N = i % 128;
        int i2 = i % 2;
    }

    private static final void P(HomeRecycleFragment homeRecycleFragment) {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 37;
            N = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
            OtpRegistrationPresenter$input$2();
            MatchPhoneNumberDialog matchPhoneNumberDialog = homeRecycleFragment.getOnBoardingScenario;
            if ((matchPhoneNumberDialog != null ? '.' : '\\') != '\\') {
                matchPhoneNumberDialog.getAuthRequestContext();
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 115;
                N = i3 % 128;
                int i4 = i3 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void Q(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
        N = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
            try {
                DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().moveToNextValue = Boolean.TRUE;
                homeRecycleFragment.FlowableReduce$ReduceSubscriber().get().KClassImpl$Data$declaredNonStaticMembers$2();
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
                N = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 31 : (char) 23) != 31) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void q() {
        int i = N + 3;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$stopBalanceLoadTime$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                    invoke2(homeTrackerImpl);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                    Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.BALANCE);
                    if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                        homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.BALANCE_LOAD_TIME, System.currentTimeMillis());
                    }
                }
            });
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = true;
        }
        try {
            int i3 = N + 59;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final GetBalanceModule F() {
        GetBalanceModule getBalanceModule = new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.home.HomeRecycleFragment$getBalanceDependencyModule$1
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

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceState(Boolean bool) {
                HomeRecycleFragment.MyBillsEntityDataFactory(HomeRecycleFragment.this, bool.booleanValue());
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalance(CurrencyAmountModel p0) {
                if (p0 != null) {
                    HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                    if (p0.MyBillsEntityDataFactory == null || p0.BuiltInFictitiousFunctionClassFactory == null) {
                        return;
                    }
                    String BuiltInFictitiousFunctionClassFactory = BalanceUtil.BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory);
                    Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                    HomeRecycleFragment.PlaceComponentResult(homeRecycleFragment, BuiltInFictitiousFunctionClassFactory, p0.BuiltInFictitiousFunctionClassFactory);
                    HomeRecycleFragment.G(homeRecycleFragment);
                }
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalanceError() {
                HomeRecycleFragment.G(HomeRecycleFragment.this);
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetAllBalanceState(List<Boolean> p0) {
                HomeRecycleFragment.MyBillsEntityDataFactory(HomeRecycleFragment.this, p0 != null ? p0.get(0).booleanValue() : true);
                HomeRecycleFragment.getAuthRequestContext(HomeRecycleFragment.this, p0 != null ? p0.get(2).booleanValue() : true);
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalanceDanaPlusActive(String p0, String p1, DanaHomeBalanceConfigModel p2) {
                ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
                Intrinsics.checkNotNullParameter(p2, "");
                FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                if (GetContactSyncConfig == null || (viewHomeToolbarMenuBinding = GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                    return;
                }
                HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                HomeRecycleFragment.getAuthRequestContext(homeRecycleFragment, Boolean.TRUE);
                if (p0 == null) {
                    p0 = "";
                }
                HomeRecycleFragment.PlaceComponentResult(homeRecycleFragment, p0);
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                if (p1 == null) {
                    p1 = "";
                }
                sb.append(p1);
                sb.append(')');
                HomeRecycleFragment.getAuthRequestContext(homeRecycleFragment, sb.toString());
                viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.setText(HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(homeRecycleFragment));
                viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.setText(HomeRecycleFragment.PrepareContext(homeRecycleFragment));
                HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(homeRecycleFragment, p2);
                long loopUntilInMillis = p2.getLoopUntilInMillis();
                long delayInMillis = p2.getDelayInMillis();
                LinearLayout linearLayout = viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                LinearLayout linearLayout2 = linearLayout;
                LinearLayout linearLayout3 = viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
                HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(homeRecycleFragment, loopUntilInMillis, delayInMillis, linearLayout2, linearLayout3);
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel p0) {
                ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
                Intrinsics.checkNotNullParameter(p0, "");
                FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                if (GetContactSyncConfig == null || (viewHomeToolbarMenuBinding = GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                    return;
                }
                HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                HomeRecycleFragment.getAuthRequestContext(homeRecycleFragment, Boolean.FALSE);
                HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(homeRecycleFragment, p0);
                long loopUntilInMillis = p0.getLoopUntilInMillis();
                long delayInMillis = p0.getDelayInMillis();
                LinearLayout linearLayout = viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                LinearLayout linearLayout2 = linearLayout;
                LinearLayout linearLayout3 = viewHomeToolbarMenuBinding.getErrorConfigVersion.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
                HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(homeRecycleFragment, loopUntilInMillis, delayInMillis, linearLayout2, linearLayout3);
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetBalanceDanaPlusError() {
                ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
                FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                if (GetContactSyncConfig != null && (viewHomeToolbarMenuBinding = GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    HomeRecycleFragment.getAuthRequestContext(HomeRecycleFragment.this, (Boolean) null);
                    viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.setVisibility(8);
                    viewHomeToolbarMenuBinding.getErrorConfigVersion.getAuthRequestContext.setVisibility(8);
                }
                CountDownTimer readMicros = HomeRecycleFragment.readMicros(HomeRecycleFragment.this);
                if (readMicros != null) {
                    readMicros.cancel();
                }
            }
        });
        int i = N + 29;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '@' : '5') != '5') {
            int i2 = 36 / 0;
            return getBalanceModule;
        }
        return getBalanceModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0026, code lost:
    
        if (r1 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0040, code lost:
    
        if ((r1 != null ? 'L' : '%') != 'L') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0043, code lost:
    
        r1.cancel();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void PlaceComponentResult(long r12, long r14, final id.dana.animation.HomeRecycleFragment r16, final android.view.View r17, final android.view.View r18) {
        /*
            r0 = r16
            r6 = r17
            r8 = r18
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 87
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            r9 = 0
            r10 = 1
            if (r1 != 0) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            java.lang.String r2 = ""
            if (r1 == r10) goto L29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            android.os.CountDownTimer r1 = r0.AppCompatEmojiTextHelper
            if (r1 == 0) goto L46
            goto L43
        L29:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            android.os.CountDownTimer r1 = r0.AppCompatEmojiTextHelper
            r2 = 66
            int r2 = r2 / r9
            r2 = 76
            if (r1 == 0) goto L3e
            r3 = 76
            goto L40
        L3e:
            r3 = 37
        L40:
            if (r3 == r2) goto L43
            goto L46
        L43:
            r1.cancel()
        L46:
            id.dana.home.HomeRecycleFragment$startSwitchBalanceAnimation$runnable$1$1 r11 = new id.dana.home.HomeRecycleFragment$startSwitchBalanceAnimation$runnable$1$1
            long r2 = r12 - r14
            r1 = r11
            r4 = r14
            r6 = r17
            r7 = r16
            r8 = r18
            r1.<init>(r2, r4)
            android.os.CountDownTimer r11 = (android.os.CountDownTimer) r11
            r0.AppCompatEmojiTextHelper = r11
            r11.start()
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 13
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L69
            r9 = 1
        L69:
            if (r9 == r10) goto L6c
            return
        L6c:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6f
            return
        L6f:
            r0 = move-exception
            r1 = r0
            throw r1
        L72:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(long, long, id.dana.home.HomeRecycleFragment, android.view.View, android.view.View):void");
    }

    private final void getAuthRequestContext(final long p0, final long p1, final View p2, final View p3) {
        int i = N + 125;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0) ? p0 > 0 : p0 > 0) {
            new Handler().postDelayed(new Runnable() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    HomeRecycleFragment.MyBillsEntityDataFactory(p0, p1, this, p2, p3);
                }
            }, p1);
            return;
        }
        try {
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
            try {
                N = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void MyBillsEntityDataFactory(View p0, View p1) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 19;
        N = i % 128;
        if (!(i % 2 == 0)) {
            p0.startAnimation(I());
            p0.setVisibility(98);
            p1.setVisibility(1);
        } else {
            p0.startAnimation(I());
            p0.setVisibility(8);
            p1.setVisibility(0);
        }
        p1.startAnimation(G());
    }

    private final void PlaceComponentResult(View p0, View p1) {
        int i = N + 91;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '4' : '@') != '4') {
            p1.startAnimation(AppCompatEmojiTextHelper());
            p1.setVisibility(8);
            p0.setVisibility(0);
            p0.startAnimation(D());
            return;
        }
        try {
            p1.startAnimation(AppCompatEmojiTextHelper());
            p1.setVisibility(92);
            p0.setVisibility(1);
            p0.startAnimation(D());
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x001d, code lost:
    
        if ((r0 == null) != true) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002a, code lost:
    
        if (r0 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002c, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002e, code lost:
    
        if (r0 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0030, code lost:
    
        r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
        id.dana.animation.HomeRecycleFragment.N = r3 % 128;
        r3 = r3 % 2;
        r0 = r0.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
    
        if (r0 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003e, code lost:
    
        r0.MyBillsEntityDataFactory.setVisibility(0);
        r0.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        r0.getAuthRequestContext.setVisibility(0);
        r0.getAuthRequestContext.setText(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0056, code lost:
    
        if (r5.NetworkUserEntityData$$ExternalSyntheticLambda4 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0058, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0059, code lost:
    
        if (r2 == true) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x005c, code lost:
    
        r0.MyBillsEntityDataFactory.setText(r6);
        r7 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
        id.dana.animation.HomeRecycleFragment.N = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0070, code lost:
    
        r5.scheduleImpl = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0072, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L24
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()     // Catch: java.lang.Exception -> L22
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0     // Catch: java.lang.Exception -> L22
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L1c
            r3 = 0
            goto L1d
        L1c:
            r3 = 1
        L1d:
            if (r3 == r1) goto L70
            goto L2c
        L20:
            r6 = move-exception
            throw r6
        L22:
            r6 = move-exception
            goto L6f
        L24:
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()     // Catch: java.lang.Exception -> L73
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L70
        L2c:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L70
            int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r3 = r3 + 75
            int r4 = r3 % 128
            id.dana.animation.HomeRecycleFragment.N = r4
            int r3 = r3 % 2
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r0 = r0.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L70
            android.widget.TextView r3 = r0.MyBillsEntityDataFactory
            r3.setVisibility(r2)
            androidx.appcompat.widget.AppCompatImageView r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r3.setVisibility(r2)
            android.widget.TextView r3 = r0.getAuthRequestContext
            r3.setVisibility(r2)
            android.widget.TextView r3 = r0.getAuthRequestContext
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.setText(r7)
            boolean r7 = r5.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r7 == 0) goto L59
            r2 = 1
        L59:
            if (r2 == r1) goto L5c
            goto L70
        L5c:
            android.widget.TextView r7 = r0.MyBillsEntityDataFactory
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setText(r0)
            int r7 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r7 = r7 + 71
            int r0 = r7 % 128
            id.dana.animation.HomeRecycleFragment.N = r0
            int r7 = r7 % 2
            goto L70
        L6f:
            throw r6
        L70:
            r5.scheduleImpl = r6
            return
        L73:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(java.lang.String, java.lang.String):void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        int i = N + 115;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            if (getGetAuthRequestContext() == null) {
                return;
            }
            MyBillsEntityDataFactory(p0);
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            N = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final UnreadInboxModule Z() {
        UnreadInboxModule unreadInboxModule = new UnreadInboxModule(new UnreadInboxContract.View() { // from class: id.dana.home.HomeRecycleFragment$getUnreadInboxDependencyModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.inbox.UnreadInboxContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this, p0);
            }
        });
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 89;
        N = i % 128;
        int i2 = i % 2;
        return unreadInboxModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x002c, code lost:
    
        if ((r0 == null) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0034, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0036, code lost:
    
        r3 = r0.MyBillsEntityDataFactory;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(boolean r5) {
        /*
            r4 = this;
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            r1 = 6
            if (r0 == 0) goto Lc
            r2 = 62
            goto Ld
        Lc:
            r2 = 6
        Ld:
            r3 = 0
            if (r2 == r1) goto L3d
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 63
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            r2 = 82
            if (r1 == 0) goto L21
            r1 = 82
            goto L23
        L21:
            r1 = 87
        L23:
            if (r1 == r2) goto L2f
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L2b
            r1 = 0
            goto L2c
        L2b:
            r1 = 1
        L2c:
            if (r1 == 0) goto L36
            goto L3d
        L2f:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L3b
            r3.hashCode()     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L3d
        L36:
            android.widget.ImageView r3 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L4d
            goto L3d
        L39:
            r5 = move-exception
            throw r5
        L3b:
            r5 = move-exception
            throw r5
        L3d:
            if (r3 == 0) goto L4f
            r3.setSelected(r5)     // Catch: java.lang.Exception -> L4d
            int r5 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r5 = r5 + 41
            int r0 = r5 % 128
            id.dana.animation.HomeRecycleFragment.N = r0
            int r5 = r5 % 2
            goto L4f
        L4d:
            r5 = move-exception
            throw r5
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(boolean):void");
    }

    private final QueryPayMethodModule W() {
        try {
            QueryPayMethodModule queryPayMethodModule = new QueryPayMethodModule(new QueryPayMethodContract.View() { // from class: id.dana.home.HomeRecycleFragment$getQueryPayMethodDependencyModule$1
                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<? extends PayCardInfo> list) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void MyBillsEntityDataFactory(int p0) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(Boolean bool) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void PlaceComponentResult(PayCardConfigModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
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

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void getAuthRequestContext() {
                    if (HomeRecycleFragment.this.isVisible()) {
                        HomeRecycleFragment.this.PrepareContext().get().BuiltInFictitiousFunctionClassFactory();
                    }
                }
            });
            int i = N + 39;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            return queryPayMethodModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final HomeInfoModule N() {
        try {
            HomeInfoModule homeInfoModule = new HomeInfoModule(new HomeInfoContract.View() { // from class: id.dana.home.HomeRecycleFragment$getHomeInfoDependencyModule$1
                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetHomeInfo(HomeInfo p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetProcessingTransaction(ProcessingTransactionModel p0) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetSurveyInfo(SurveyInfoModel p0) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onShowTooltip(boolean p0) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetHomeData(HomeDataModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment.this, p0.BuiltInFictitiousFunctionClassFactory);
                    HomeRecycleFragment.getAuthRequestContext(HomeRecycleFragment.this, p0.MyBillsEntityDataFactory);
                    HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                    PromotionModel promotionModel = p0.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(promotionModel, "");
                    HomeRecycleFragment.MyBillsEntityDataFactory(homeRecycleFragment, promotionModel);
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onShouldShowMerchant(MerchantConsultReviewModel p0, MerchantReviewModel p1) {
                    HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this, p0, p1);
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onShowMerchantReviewCheckingError() {
                    HomeRecycleFragment.whenAvailable(HomeRecycleFragment.this);
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetSyncPermissionConfig(SyncPermissionAndChangeConfig p0) {
                    WorkManager PlaceComponentResult;
                    Context context = HomeRecycleFragment.this.getContext();
                    if (context == null || p0 == null) {
                        return;
                    }
                    SyncPermissionWorker.Companion companion = SyncPermissionWorker.INSTANCE;
                    Intrinsics.checkNotNullParameter(context, "");
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.getGetAuthRequestContext()) {
                        if (SyncPermissionWorker.Companion.MyBillsEntityDataFactory(context)) {
                            if (!p0.getBuiltInFictitiousFunctionClassFactory()) {
                                return;
                            }
                            SyncPermissionWorker.Companion.getAuthRequestContext(context);
                        }
                        PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
                        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                        Constraints.Builder builder = new Constraints.Builder();
                        builder.PlaceComponentResult = NetworkType.CONNECTED;
                        PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(SyncPermissionWorker.class, p0.KClassImpl$Data$declaredNonStaticMembers$2, TimeUnit.MILLISECONDS);
                        builder2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new Constraints(builder);
                        PeriodicWorkRequest.Builder MyBillsEntityDataFactory = builder2.MyBillsEntityDataFactory();
                        MyBillsEntityDataFactory.PlaceComponentResult.add("SYNC_PERMISSION_TRACKER_KEY");
                        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("SYNC_PERMISSION_TRACKER_KEY", p0.getBuiltInFictitiousFunctionClassFactory() ? ExistingPeriodicWorkPolicy.REPLACE : ExistingPeriodicWorkPolicy.KEEP, KClassImpl$Data$declaredNonStaticMembers$2);
                        return;
                    }
                    SyncPermissionWorker.Companion.getAuthRequestContext(context);
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetIsSyncPermission() {
                    Context context = HomeRecycleFragment.this.getContext();
                    if (context != null) {
                        PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
                        PermissionUtil.PlaceComponentResult(context);
                    }
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    HomeRecycleFragment.initRecordTimeStamp(HomeRecycleFragment.this);
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public final void onGetConfigSyncContact(ConfigRepeatBackgroundJob p0) {
                    WorkManager PlaceComponentResult;
                    Context context = HomeRecycleFragment.this.getContext();
                    if (context == null || p0 == null) {
                        return;
                    }
                    SyncContactsEngineWorker.Companion companion = SyncContactsEngineWorker.INSTANCE;
                    Intrinsics.checkNotNullParameter(context, "");
                    Intrinsics.checkNotNullParameter(p0, "");
                    DanaLog.MyBillsEntityDataFactory("SyncContactEngine", "SyncContactsEngineWorker : startWorker");
                    if (p0.getGetAuthRequestContext()) {
                        if (SyncContactsEngineWorker.Companion.BuiltInFictitiousFunctionClassFactory(context)) {
                            if (!p0.getPlaceComponentResult()) {
                                return;
                            }
                            SyncContactsEngineWorker.Companion.PlaceComponentResult(context);
                        }
                        Constraints.Builder builder = new Constraints.Builder();
                        builder.PlaceComponentResult = NetworkType.CONNECTED;
                        builder.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getMyBillsEntityDataFactory();
                        if (Build.VERSION.SDK_INT >= 23) {
                            builder.BuiltInFictitiousFunctionClassFactory = p0.getBuiltInFictitiousFunctionClassFactory();
                        }
                        Constraints constraints = new Constraints(builder);
                        Intrinsics.checkNotNullExpressionValue(constraints, "");
                        PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(SyncContactsEngineWorker.class, p0.KClassImpl$Data$declaredNonStaticMembers$2, TimeUnit.MILLISECONDS);
                        builder2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = constraints;
                        PeriodicWorkRequest KClassImpl$Data$declaredNonStaticMembers$2 = builder2.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
                        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                        PeriodicWorkRequest periodicWorkRequest = KClassImpl$Data$declaredNonStaticMembers$2;
                        try {
                            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
                            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("SYNC_CONTACTS_WORKER_KEY", p0.getPlaceComponentResult() ? ExistingPeriodicWorkPolicy.REPLACE : ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
                            return;
                        } catch (Exception e) {
                            try {
                                Crashlytics.Companion companion2 = Crashlytics.INSTANCE;
                                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                                WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                                Intrinsics.checkNotNullParameter(workManagerFailure, "");
                                authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                    }
                    SyncContactsEngineWorker.Companion.PlaceComponentResult(context);
                }
            });
            int i = N + 13;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (i % 2 == 0) {
                int i2 = 34 / 0;
                return homeInfoModule;
            }
            return homeInfoModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void VerifyPinStateManager$executeRiskChallenge$2$2() {
        HomeAdapter.PromoViewHolder SummaryVoucherView$$ExternalSyntheticLambda2;
        this.DatabaseTableConfigUtil = true;
        this.initRecordTimeStamp = true;
        if ((getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED) ? '8' : (char) 27) != 27) {
            int i = N + 77;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 == 0)) {
                SummaryVoucherView$$ExternalSyntheticLambda2 = SummaryVoucherView$$ExternalSyntheticLambda2();
                if (!(SummaryVoucherView$$ExternalSyntheticLambda2 != null)) {
                    return;
                }
            } else {
                SummaryVoucherView$$ExternalSyntheticLambda2 = SummaryVoucherView$$ExternalSyntheticLambda2();
                Object obj = null;
                obj.hashCode();
                if (SummaryVoucherView$$ExternalSyntheticLambda2 == null) {
                    return;
                }
            }
            try {
                int i2 = N + 97;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
                ViewItemPromoWidgetBinding viewItemPromoWidgetBinding = SummaryVoucherView$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory;
                if (viewItemPromoWidgetBinding != null) {
                    try {
                        NewPromoBannerView newPromoBannerView = viewItemPromoWidgetBinding.PlaceComponentResult;
                        if (newPromoBannerView != null) {
                            newPromoBannerView.hideBannerSkeleton();
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.model.HomeInfo r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L9f
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 15
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            id.dana.model.CurrencyAmountModel r1 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            if (r1 == 0) goto L9f
            boolean r1 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r1 == 0) goto L90
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 113
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r1 = (id.dana.databinding.FragmentHomeRecycleBinding) r1
            r2 = 43
            if (r1 == 0) goto L2c
            r3 = 39
            goto L2e
        L2c:
            r3 = 43
        L2e:
            if (r3 == r2) goto L4f
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r2 = r2 + 19
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r2 = r2 % 2
            id.dana.databinding.ViewHomeToolbarMenuBinding r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            if (r1 == 0) goto L4f
            id.dana.databinding.ViewHomeToolbarDanaBalanceBinding r1 = r1.BuiltInFictitiousFunctionClassFactory
            if (r1 == 0) goto L4f
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r2 = r2 + 29
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r2 = r2 % 2
            android.widget.TextView r1 = r1.MyBillsEntityDataFactory
            goto L5a
        L4f:
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 121
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            r1 = r0
        L5a:
            if (r1 == 0) goto L5e
            r2 = 1
            goto L5f
        L5e:
            r2 = 0
        L5f:
            if (r2 == 0) goto L90
            int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r2 = r2 + 41
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L80
            id.dana.model.CurrencyAmountModel r2 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r2 = r2.MyBillsEntityDataFactory
            java.lang.String r2 = id.dana.utils.BalanceUtil.BuiltInFictitiousFunctionClassFactory(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            r0.hashCode()     // Catch: java.lang.Throwable -> L7e
            goto L90
        L7e:
            r5 = move-exception
            throw r5
        L80:
            id.dana.model.CurrencyAmountModel r2 = r5.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = id.dana.utils.BalanceUtil.BuiltInFictitiousFunctionClassFactory(r2)     // Catch: java.lang.Exception -> L8e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L8e
            r1.setText(r2)     // Catch: java.lang.Exception -> L8e
            goto L90
        L8e:
            r5 = move-exception
            throw r5
        L90:
            id.dana.model.CurrencyAmountModel r5 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r5 = r5.MyBillsEntityDataFactory
            java.lang.String r5 = id.dana.utils.BalanceUtil.BuiltInFictitiousFunctionClassFactory(r5)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r4.scheduleImpl = r5
        L9f:
            int r5 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r5 = r5 + 101
            int r1 = r5 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r5 = r5 % 2
            if (r5 == 0) goto Laf
            int r5 = r0.length     // Catch: java.lang.Throwable -> Lad
            return
        Lad:
            r5 = move-exception
            throw r5
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(id.dana.model.HomeInfo):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0057, code lost:
    
        if ((r0 != null ? '*' : 18) != 18) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0069, code lost:
    
        if ((r0 != null ? 'O' : 23) != 23) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x006b, code lost:
    
        r3 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(id.dana.model.HasNewModel r5) {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L18
            int r0 = r3.length     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L13
            r1 = 1
        L13:
            if (r1 == 0) goto L83
            goto L1e
        L16:
            r5 = move-exception
            throw r5
        L18:
            if (r5 == 0) goto L1b
            goto L1c
        L1b:
            r1 = 1
        L1c:
            if (r1 == r2) goto L83
        L1e:
            boolean r0 = r5.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L83
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
            r1 = 25
            if (r0 == 0) goto L31
            r2 = 39
            goto L33
        L31:
            r2 = 25
        L33:
            if (r2 == r1) goto L6d
            int r2 = id.dana.animation.HomeRecycleFragment.N
            int r2 = r2 + r1
            int r1 = r2 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r2 = r2 % 2
            r1 = 37
            if (r2 != 0) goto L45
            r2 = 98
            goto L47
        L45:
            r2 = 37
        L47:
            if (r2 == r1) goto L5e
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L5c
            r3.hashCode()     // Catch: java.lang.Throwable -> L5a
            r1 = 18
            if (r0 == 0) goto L55
            r2 = 42
            goto L57
        L55:
            r2 = 18
        L57:
            if (r2 == r1) goto L6d
            goto L6b
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            r5 = move-exception
            throw r5
        L5e:
            id.dana.databinding.ViewHomeToolbarMenuBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            if (r0 == 0) goto L67
            r2 = 79
            goto L69
        L67:
            r2 = 23
        L69:
            if (r2 == r1) goto L6d
        L6b:
            android.widget.ImageView r3 = r0.MyBillsEntityDataFactory
        L6d:
            r0 = 50
            if (r3 == 0) goto L74
            r1 = 50
            goto L76
        L74:
            r1 = 49
        L76:
            if (r1 == r0) goto L79
            goto L83
        L79:
            boolean r5 = r5.PlaceComponentResult()
            r3.setSelected(r5)
            goto L83
        L81:
            r5 = move-exception
            throw r5
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.MyBillsEntityDataFactory(id.dana.model.HasNewModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x002a, code lost:
    
        if ((r0 != null ? '2' : 'H') != '2') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x003c, code lost:
    
        if ((r0 != null ? 'X' : 'T') != 'X') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003f, code lost:
    
        r0.updateBanner(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.model.PromotionModel r4) {
        /*
            r3 = this;
            id.dana.home.adapter.HomeAdapter$PromoViewHolder r0 = r3.SummaryVoucherView$$ExternalSyntheticLambda2()
            if (r0 == 0) goto L47
            id.dana.databinding.ViewItemPromoWidgetBinding r0 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L47
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 109
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            r2 = 74
            if (r1 == 0) goto L1b
            r1 = 74
            goto L1d
        L1b:
            r1 = 52
        L1d:
            if (r1 == r2) goto L2d
            id.dana.richview.NewPromoBannerView r0 = r0.PlaceComponentResult     // Catch: java.lang.Exception -> L45
            r1 = 50
            if (r0 == 0) goto L28
            r2 = 50
            goto L2a
        L28:
            r2 = 72
        L2a:
            if (r2 == r1) goto L3f
            goto L47
        L2d:
            id.dana.richview.NewPromoBannerView r0 = r0.PlaceComponentResult
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L43
            r1 = 88
            if (r0 == 0) goto L3a
            r2 = 88
            goto L3c
        L3a:
            r2 = 84
        L3c:
            if (r2 == r1) goto L3f
            goto L47
        L3f:
            r0.updateBanner(r4)
            goto L47
        L43:
            r4 = move-exception
            throw r4
        L45:
            r4 = move-exception
            throw r4
        L47:
            int r4 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L5b
            int r4 = r4 + 1
            int r0 = r4 % 128
            id.dana.animation.HomeRecycleFragment.N = r0     // Catch: java.lang.Exception -> L5b
            int r4 = r4 % 2
            if (r4 == 0) goto L5a
            r4 = 48
            int r4 = r4 / 0
            return
        L58:
            r4 = move-exception
            throw r4
        L5a:
            return
        L5b:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(id.dana.model.PromotionModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0023, code lost:
    
        if ((r2 == null ? ']' : ',') != ']') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if ((r2 == null ? '\f' : 'A') != '\f') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003b, code lost:
    
        if (r6 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003d, code lost:
    
        r3 = id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.Companion.MyBillsEntityDataFactory(r2, r6, false, r7, new id.dana.animation.HomeRecycleFragment$showMerchantReviewForm$1$1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0049, code lost:
    
        r6 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 45;
        id.dana.animation.HomeRecycleFragment.N = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0056, code lost:
    
        r0.stop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005b, code lost:
    
        r6 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005f, code lost:
    
        id.dana.animation.HomeRecycleFragment.N = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:
    
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0064, code lost:
    
        r0.stop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0069, code lost:
    
        r6 = id.dana.animation.HomeRecycleFragment.N + 81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x006d, code lost:
    
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0071, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel r6, id.dana.nearbyme.merchantdetail.model.MerchantReviewModel r7) {
        /*
            r5 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = "Ugc - Step"
            if (r0 == 0) goto L28
            com.google.firebase.perf.metrics.Trace r0 = com.google.firebase.perf.FirebasePerformance.startTrace(r2)
            androidx.fragment.app.FragmentManager r2 = r5.H()
            r3 = 56
            int r3 = r3 / r1
            r3 = 93
            if (r2 != 0) goto L21
            r4 = 93
            goto L23
        L21:
            r4 = 44
        L23:
            if (r4 == r3) goto L64
            goto L3b
        L26:
            r6 = move-exception
            throw r6
        L28:
            com.google.firebase.perf.metrics.Trace r0 = com.google.firebase.perf.FirebasePerformance.startTrace(r2)
            androidx.fragment.app.FragmentManager r2 = r5.H()
            r3 = 12
            if (r2 != 0) goto L37
            r4 = 12
            goto L39
        L37:
            r4 = 65
        L39:
            if (r4 == r3) goto L64
        L3b:
            if (r6 == 0) goto L56
            id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$Companion r3 = id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L54
            id.dana.home.HomeRecycleFragment$showMerchantReviewForm$1$1 r3 = new id.dana.home.HomeRecycleFragment$showMerchantReviewForm$1$1     // Catch: java.lang.Exception -> L54
            r3.<init>()     // Catch: java.lang.Exception -> L54
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch: java.lang.Exception -> L54
            id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.Companion.MyBillsEntityDataFactory(r2, r6, r1, r7, r3)     // Catch: java.lang.Exception -> L54
            int r6 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r6 = r6 + 45
            int r7 = r6 % 128
            id.dana.animation.HomeRecycleFragment.N = r7
            int r6 = r6 % 2
            goto L56
        L54:
            r6 = move-exception
            goto L72
        L56:
            r0.stop()
            int r6 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L54
            int r6 = r6 + 15
            int r7 = r6 % 128
            id.dana.animation.HomeRecycleFragment.N = r7     // Catch: java.lang.Exception -> L73
            int r6 = r6 % 2
            return
        L64:
            r0.stop()
            int r6 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L73
            int r6 = r6 + 81
            int r7 = r6 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r7     // Catch: java.lang.Exception -> L54
            int r6 = r6 % 2
            return
        L72:
            throw r6
        L73:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getAuthRequestContext(id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel, id.dana.nearbyme.merchantdetail.model.MerchantReviewModel):void");
    }

    private final FragmentManager H() {
        FragmentManager childFragmentManager;
        Object obj = null;
        if ((getActivity() != null ? 'D' : '\t') != '\t') {
            try {
                int i = N + 101;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                if ((isAdded() ? '#' : (char) 0) != 0) {
                    int i3 = N + 1;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                    if ((i3 % 2 == 0 ? '(' : '-') != '(') {
                        childFragmentManager = getChildFragmentManager();
                    } else {
                        childFragmentManager = getChildFragmentManager();
                        obj.hashCode();
                    }
                    FragmentManager fragmentManager = childFragmentManager;
                    int i4 = N + 21;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
                    int i5 = i4 % 2;
                    return fragmentManager;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    private final void h() {
        int i = N + 79;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if ((getBaseActivity() instanceof HomeTabActivity ? 'a' : '_') != 'a') {
            return;
        }
        try {
            int i3 = N + 97;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
            }
            try {
                int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 59;
                N = i5 % 128;
                int i6 = i5 % 2;
                ((HomeTabActivity) baseActivity).nextOnboardingStep();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final GeofenceModule K() {
        GeofenceModule geofenceModule = new GeofenceModule(new GeofenceContract.View() { // from class: id.dana.home.HomeRecycleFragment$getGeofenceDependencyModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.geofence.GeofenceContract.View
            public final void MyBillsEntityDataFactory(List<PoiModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomeRecycleFragment.this.scheduleImpl().get().MyBillsEntityDataFactory(p0);
            }
        });
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 65;
        N = i % 128;
        if ((i % 2 != 0 ? Typography.quote : '\t') != '\t') {
            Object[] objArr = null;
            int length = objArr.length;
            return geofenceModule;
        }
        return geofenceModule;
    }

    private final LogoutModule P() {
        LogoutModule logoutModule = new LogoutModule(new LogoutContract.View() { // from class: id.dana.home.HomeRecycleFragment$getLogoutDependencyModule$1
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

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                MatchPhoneNumberDialog NetworkUserEntityData$$ExternalSyntheticLambda3 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(HomeRecycleFragment.this);
                if (NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                    NetworkUserEntityData$$ExternalSyntheticLambda3.lpvLoading.setVisibility(0);
                    NetworkUserEntityData$$ExternalSyntheticLambda3.lpvLoading.startRefresh();
                    NetworkUserEntityData$$ExternalSyntheticLambda3.btnLogin.setVisibility(8);
                }
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void MyBillsEntityDataFactory() {
                MatchPhoneNumberDialog NetworkUserEntityData$$ExternalSyntheticLambda3 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(HomeRecycleFragment.this);
                if (NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                    NetworkUserEntityData$$ExternalSyntheticLambda3.lpvLoading.setVisibility(8);
                    NetworkUserEntityData$$ExternalSyntheticLambda3.lpvLoading.stopRefresh();
                    NetworkUserEntityData$$ExternalSyntheticLambda3.btnLogin.setVisibility(0);
                }
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void PlaceComponentResult() {
                OnboardingActivity.Companion companion = OnboardingActivity.INSTANCE;
                BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                BaseActivity baseActivity2 = baseActivity;
                Intrinsics.checkNotNullParameter(baseActivity2, "");
                Intent MyBillsEntityDataFactory = OnboardingActivity.Companion.MyBillsEntityDataFactory((Context) baseActivity2);
                MyBillsEntityDataFactory.putExtra("FROM_LOGOUT", true);
                baseActivity2.startActivity(MyBillsEntityDataFactory);
            }
        });
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
        N = i % 128;
        if (i % 2 == 0) {
            return logoutModule;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return logoutModule;
    }

    private final GlobalSearchModule L() {
        try {
            GlobalSearchModule globalSearchModule = new GlobalSearchModule(new GlobalSearchContract.View() { // from class: id.dana.home.HomeRecycleFragment$getGlobalSearchModule$1
                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                    GlobalSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SearchResultModel searchResultModel) {
                    Intrinsics.checkNotNullParameter(searchResultModel, "");
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                    GlobalSearchContract.View.CC.scheduleImpl();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.MyBillsEntityDataFactory(searchResultModel);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                    GlobalSearchContract.View.CC.getAuthRequestContext(str);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    GlobalSearchContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchConfig globalSearchConfig) {
                    GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(globalSearchConfig);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.getAuthRequestContext(searchResultModel);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
                    GlobalSearchContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void PlaceComponentResult(ThirdPartyServiceResponse thirdPartyServiceResponse, String str, String str2) {
                    GlobalSearchContract.View.CC.MyBillsEntityDataFactory(thirdPartyServiceResponse, str);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void PlaceComponentResult(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(searchResultModel);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void PlaceComponentResult(String str) {
                    GlobalSearchContract.View.CC.MyBillsEntityDataFactory(str);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void PlaceComponentResult(List list) {
                    GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void getAuthRequestContext() {
                    GlobalSearchContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void getAuthRequestContext(ThirdPartyServiceResponse thirdPartyServiceResponse, String str) {
                    GlobalSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyServiceResponse, str);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void getAuthRequestContext(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.PlaceComponentResult(searchResultModel);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void getAuthRequestContext(List list) {
                    GlobalSearchContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void lookAheadTest() {
                    GlobalSearchContract.View.CC.lookAheadTest();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void lookAheadTest(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.scheduleImpl(searchResultModel);
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void moveToNextValue() {
                    GlobalSearchContract.View.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void scheduleImpl() {
                    GlobalSearchContract.View.CC.moveToNextValue();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final /* synthetic */ void scheduleImpl(SearchResultModel searchResultModel) {
                    GlobalSearchContract.View.CC.moveToNextValue(searchResultModel);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    HomeAdapter DatabaseTableConfigUtil = HomeRecycleFragment.this.DatabaseTableConfigUtil();
                    if (DatabaseTableConfigUtil != null) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Iterator<HomeViewWidgetModel> it = DatabaseTableConfigUtil.getErrorConfigVersion.iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            }
                            if (it.next().MyBillsEntityDataFactory == HomeAdapter.HomeWidget.GLOBAL_SEARCH) {
                                break;
                            }
                            i++;
                        }
                        DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
                        DatabaseTableConfigUtil.notifyItemChanged(i);
                    }
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final void MyBillsEntityDataFactory(boolean z) {
                    HomeRecycleFragment.PlaceComponentResult(HomeRecycleFragment.this, z);
                    if (z) {
                        HomeRecycleFragment.this.initRecordTimeStamp().get().lookAheadTest();
                    }
                }

                @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
                public final void getAuthRequestContext(boolean p0) {
                    if (p0) {
                        HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(false);
                    } else {
                        HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(true);
                        HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().getAuthRequestContext();
                    }
                    HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment.this, p0);
                }
            });
            int i = N + 101;
            try {
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                return globalSearchModule;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final GlobalNetworkModule getNameOrBuilderList() {
        GlobalNetworkModule globalNetworkModule = new GlobalNetworkModule(new GlobalNetworkListener() { // from class: id.dana.home.HomeRecycleFragment$getGlobalNetworkDependencyModule$1
            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment.this);
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, final boolean p1, final boolean p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                final HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.home.HomeRecycleFragment$getGlobalNetworkDependencyModule$1$onPayCashier$danaH5Listener$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p02) {
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p02) {
                        if (p2) {
                            return;
                        }
                        homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1().get().MyBillsEntityDataFactory();
                        homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda1().get().getAuthRequestContext(p1, null);
                    }
                };
                HomeRecycleFragment.F(HomeRecycleFragment.this);
                if (p2) {
                    CashierEventHandler cashierEventHandler = HomeRecycleFragment.this.moveToNextValue().get();
                    BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    BaseActivity baseActivity2 = baseActivity;
                    String NetworkUserEntityData$$ExternalSyntheticLambda2 = UrlUtil.NetworkUserEntityData$$ExternalSyntheticLambda2(p0);
                    Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda2, "");
                    Intrinsics.checkNotNullParameter(baseActivity2, "");
                    Intrinsics.checkNotNullParameter(NetworkUserEntityData$$ExternalSyntheticLambda2, "");
                    cashierEventHandler.BuiltInFictitiousFunctionClassFactory(baseActivity2, NetworkUserEntityData$$ExternalSyntheticLambda2, danaH5Listener, "Mini Program");
                    return;
                }
                DanaH5.startContainerFullUrl(p0, danaH5Listener);
            }
        });
        int i = N + 105;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '6' : 'F') != '6') {
            return globalNetworkModule;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return globalNetworkModule;
    }

    private final PayLaterModule R() {
        PayLaterModule payLaterModule = new PayLaterModule(new PayLaterViewListener() { // from class: id.dana.home.HomeRecycleFragment$getPayLaterModule$1
            @Override // id.dana.contract.paylater.PayLaterViewListener, id.dana.contract.paylater.PayLaterContract.View
            public final void getAuthRequestContext() {
                HomeAdapter.ServicesViewHolder NetworkUserEntityData$$ExternalSyntheticLambda5;
                ViewItemServicesWidgetBinding viewItemServicesWidgetBinding;
                ServiceCardV2View serviceCardV2View;
                if (!HomeRecycleFragment.this.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED) || (NetworkUserEntityData$$ExternalSyntheticLambda5 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(HomeRecycleFragment.this)) == null || (viewItemServicesWidgetBinding = NetworkUserEntityData$$ExternalSyntheticLambda5.BuiltInFictitiousFunctionClassFactory) == null || (serviceCardV2View = viewItemServicesWidgetBinding.MyBillsEntityDataFactory) == null) {
                    return;
                }
                serviceCardV2View.hideShimmerOnPromotedService();
            }

            @Override // id.dana.contract.paylater.PayLaterViewListener, id.dana.contract.paylater.PayLaterContract.View
            public final void MyBillsEntityDataFactory() {
                HomeAdapter.ServicesViewHolder NetworkUserEntityData$$ExternalSyntheticLambda5;
                ViewItemServicesWidgetBinding viewItemServicesWidgetBinding;
                ServiceCardV2View serviceCardV2View;
                HomeRecycleFragment.AppCompatEmojiTextHelper(HomeRecycleFragment.this);
                if (!HomeRecycleFragment.this.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED) || HomeRecycleFragment.this.getBaseActivity().getDanaApplication().isRefreshService() || (NetworkUserEntityData$$ExternalSyntheticLambda5 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(HomeRecycleFragment.this)) == null || (viewItemServicesWidgetBinding = NetworkUserEntityData$$ExternalSyntheticLambda5.BuiltInFictitiousFunctionClassFactory) == null || (serviceCardV2View = viewItemServicesWidgetBinding.MyBillsEntityDataFactory) == null) {
                    return;
                }
                serviceCardV2View.refreshView();
            }
        });
        int i = N + 105;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return payLaterModule;
        }
        return payLaterModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0021, code lost:
    
        if ((r0 == null) != true) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002d, code lost:
    
        if ((r0 != null) != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0030, code lost:
    
        getContainerAuth().PlaceComponentResult(r0, onDecodeSuccess().get().PlaceComponentResult(id.dana.domain.paylater.model.LoanInfo.LOAN_PERSONAL).getLoanStatus());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w() {
        /*
            r4 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r1
            int r0 = r0 % 2
            r1 = 72
            if (r0 == 0) goto L11
            r0 = 87
            goto L13
        L11:
            r0 = 72
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L26
            android.content.Context r0 = r4.getContext()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L20
            goto L21
        L20:
            r2 = 1
        L21:
            if (r2 == r3) goto L4b
            goto L30
        L24:
            r0 = move-exception
            throw r0
        L26:
            android.content.Context r0 = r4.getContext()
            if (r0 == 0) goto L2d
            r2 = 1
        L2d:
            if (r2 == r3) goto L30
            goto L4b
        L30:
            id.dana.cashier.tracker.PaylaterAnalyticTracker r1 = r4.getContainerAuth()
            dagger.Lazy r2 = r4.onDecodeSuccess()
            java.lang.Object r2 = r2.get()
            id.dana.contract.paylater.PayLaterContract$Presenter r2 = (id.dana.contract.paylater.PayLaterContract.Presenter) r2
            java.lang.String r3 = "LOAN_PERSONAL"
            id.dana.domain.paylater.model.UserLoanInfo r2 = r2.PlaceComponentResult(r3)
            java.lang.String r2 = r2.getLoanStatus()
            r1.PlaceComponentResult(r0, r2)
        L4b:
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.w():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x002c, code lost:
    
        if (r6 != null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0044, code lost:
    
        if ((r6 != null ? 19 : 'L') != 'L') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0046, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 115;
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0053, code lost:
    
        if ((r1 % 2) != 0) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0055, code lost:
    
        r6 = (in.srain.cube.views.ptr.PtrClassicDefaultHeader) r6.findViewById(id.dana.R.id.pcdh_loading);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x005b, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x005f, code lost:
    
        r6 = (in.srain.cube.views.ptr.PtrClassicDefaultHeader) r6.findViewById(id.dana.R.id.pcdh_loading);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0066, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00d6, code lost:
    
        if ((r6 != null) != true) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00e6, code lost:
    
        if ((r6 != null ? '8' : '^') != '8') goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00e9, code lost:
    
        r6 = r6.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00eb, code lost:
    
        if (r6 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x00ed, code lost:
    
        r6.setBackgroundColor(r5.NetworkUserEntityData$$ExternalSyntheticLambda1);
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(java.lang.String):void");
    }

    private final HomeAdapter.ServicesViewHolder X() {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView;
        HomeAdapter.HomeWidget homeWidget = HomeAdapter.HomeWidget.SERVICES;
        FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
        Object[] objArr = null;
        if (fragmentHomeRecycleBinding == null || (recyclerView = fragmentHomeRecycleBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            viewHolder = null;
        } else {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 117;
            N = i % 128;
            if (i % 2 == 0) {
                viewHolder = recyclerView.findViewHolderForAdapterPosition(homeWidget.getIndex());
            } else {
                try {
                    viewHolder = recyclerView.findViewHolderForAdapterPosition(homeWidget.getIndex());
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        if (!(viewHolder instanceof HomeAdapter.ServicesViewHolder)) {
            viewHolder = null;
        } else {
            int i2 = N + 29;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 125;
            N = i4 % 128;
            int i5 = i4 % 2;
        }
        HomeAdapter.ServicesViewHolder servicesViewHolder = (HomeAdapter.ServicesViewHolder) viewHolder;
        int i6 = SummaryVoucherView$$ExternalSyntheticLambda1 + 1;
        N = i6 % 128;
        if (i6 % 2 != 0) {
            int length2 = objArr.length;
            return servicesViewHolder;
        }
        return servicesViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.home.adapter.HomeAdapter.FourKingViewHolder J() {
        /*
            r5 = this;
            id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.FOUR_KINGS
            androidx.viewbinding.ViewBinding r1 = r5.getBinding()
            id.dana.databinding.FragmentHomeRecycleBinding r1 = (id.dana.databinding.FragmentHomeRecycleBinding) r1
            r2 = 60
            if (r1 == 0) goto Lf
            r3 = 56
            goto L11
        Lf:
            r3 = 60
        L11:
            r4 = 0
            if (r3 == r2) goto L41
            androidx.recyclerview.widget.RecyclerView r1 = r1.BuiltInFictitiousFunctionClassFactory
            r2 = 1
            if (r1 == 0) goto L1b
            r3 = 0
            goto L1c
        L1b:
            r3 = 1
        L1c:
            if (r3 == r2) goto L41
            int r2 = id.dana.animation.HomeRecycleFragment.N
            int r2 = r2 + 9
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L38
            int r0 = r0.getIndex()     // Catch: java.lang.Exception -> L36
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r1.findViewHolderForAdapterPosition(r0)     // Catch: java.lang.Exception -> L36
            int r1 = r4.length     // Catch: java.lang.Throwable -> L34
            goto L42
        L34:
            r0 = move-exception
            throw r0
        L36:
            r0 = move-exception
            throw r0
        L38:
            int r0 = r0.getIndex()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r1.findViewHolderForAdapterPosition(r0)
            goto L42
        L41:
            r0 = r4
        L42:
            boolean r1 = r0 instanceof id.dana.home.adapter.HomeAdapter.FourKingViewHolder
            r2 = 28
            if (r1 == 0) goto L4b
            r1 = 59
            goto L4d
        L4b:
            r1 = 28
        L4d:
            if (r1 == r2) goto L60
            int r1 = id.dana.animation.HomeRecycleFragment.N
            int r1 = r1 + 79
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L5f
            int r1 = r4.length     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r0 = move-exception
            throw r0
        L5f:
            r4 = r0
        L60:
            id.dana.home.adapter.HomeAdapter$FourKingViewHolder r4 = (id.dana.home.adapter.HomeAdapter.FourKingViewHolder) r4
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.J():id.dana.home.adapter.HomeAdapter$FourKingViewHolder");
    }

    private final void moveToNextValue(boolean p0) {
        HomeFragmentListener O2;
        int i = N + 37;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '+' : (char) 2) != 2) {
            O2 = O();
            Object obj = null;
            obj.hashCode();
            if (!p0) {
                return;
            }
        } else {
            O2 = O();
            if ((p0 ? JSONLexer.EOI : (char) 31) == 31) {
                return;
            }
        }
        int i2 = N + 37;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 64 / 0;
            if (!(O2 != null)) {
                return;
            }
        } else {
            if ((O2 != null ? ';' : ':') != ';') {
                return;
            }
        }
        try {
            O2.KClassImpl$Data$declaredNonStaticMembers$2();
            int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
            N = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0019, code lost:
    
        if ((r0 != null ? 'M' : '6') != '6') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0029, code lost:
    
        if ((r0 != null ? '2' : 'Q') != 'Q') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002d, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.N + 87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0031, code lost:
    
        id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0036, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0038, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0039, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003a, code lost:
    
        r0 = getParentFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003e, code lost:
    
        if (r0 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0040, code lost:
    
        r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 79;
        id.dana.animation.HomeRecycleFragment.N = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x004e, code lost:
    
        return ((id.dana.animation.tab.HomeTabFragment) r0).NetworkUserEntityData$$ExternalSyntheticLambda2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0056, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type id.dana.home.tab.HomeTabFragment");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.animation.HomeFragmentListener O() {
        /*
            r3 = this;
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L1e
            id.dana.home.HomeFragmentListener r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda7
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1c
            r1 = 54
            if (r0 == 0) goto L17
            r2 = 77
            goto L19
        L17:
            r2 = 54
        L19:
            if (r2 == r1) goto L3a
            goto L2b
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.home.HomeFragmentListener r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda7
            r1 = 81
            if (r0 == 0) goto L27
            r2 = 50
            goto L29
        L27:
            r2 = 81
        L29:
            if (r2 == r1) goto L3a
        L2b:
            int r1 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L38
            int r1 = r1 + 87
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2     // Catch: java.lang.Exception -> L36
            int r1 = r1 % 2
            return r0
        L36:
            r0 = move-exception
            throw r0
        L38:
            r0 = move-exception
            throw r0
        L3a:
            androidx.fragment.app.Fragment r0 = r3.getParentFragment()
            if (r0 == 0) goto L4f
            int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r1 = r1 + 79
            int r2 = r1 % 128
            id.dana.animation.HomeRecycleFragment.N = r2
            int r1 = r1 % 2
            id.dana.home.tab.HomeTabFragment r0 = (id.dana.animation.tab.HomeTabFragment) r0
            id.dana.home.HomeFragmentListener r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda2
            return r0
        L4f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type id.dana.home.tab.HomeTabFragment"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.O():id.dana.home.HomeFragmentListener");
    }

    private final GetUserInfoModule flip() {
        GetUserInfoModule getUserInfoModule = new GetUserInfoModule(new GetUserInfoContract.View() { // from class: id.dana.home.HomeRecycleFragment$getUserInfoModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                HomeTabActivity homeTabActivity = baseActivity instanceof HomeTabActivity ? (HomeTabActivity) baseActivity : null;
                if (homeTabActivity != null) {
                    homeTabActivity.dismissLoadingDialogIfNeeded();
                }
            }

            @Override // id.dana.contract.user.GetUserInfoContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(UserInfo p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda2, "SUSPENDED")) {
                    BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                    HomeTabActivity homeTabActivity = baseActivity instanceof HomeTabActivity ? (HomeTabActivity) baseActivity : null;
                    if (homeTabActivity != null) {
                        homeTabActivity.dismissLoadingDialogIfNeeded();
                    }
                    HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this, ErrorCode.ACCESS_TOKEN_NOT_ACTIVE);
                } else if (Intrinsics.areEqual(p0.isLayoutRequested, "FROZEN")) {
                    BaseActivity baseActivity2 = HomeRecycleFragment.this.getBaseActivity();
                    HomeTabActivity homeTabActivity2 = baseActivity2 instanceof HomeTabActivity ? (HomeTabActivity) baseActivity2 : null;
                    if (homeTabActivity2 != null) {
                        homeTabActivity2.dismissLoadingDialogIfNeeded();
                    }
                    HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this, "AE15112158065208");
                } else {
                    BaseActivity baseActivity3 = HomeRecycleFragment.this.getBaseActivity();
                    HomeTabActivity homeTabActivity3 = baseActivity3 instanceof HomeTabActivity ? (HomeTabActivity) baseActivity3 : null;
                    if (homeTabActivity3 != null) {
                        homeTabActivity3.checkGnTopUpFlow();
                    }
                    if (HomeRecycleFragment.getCallingPid(HomeRecycleFragment.this)) {
                        MixPanelTracker.MyBillsEntityDataFactory(p0.getGetAuthRequestContext());
                        MixPanelTracker.getAuthRequestContext(p0.getPlaceComponentResult());
                        HomeRecycleFragment.getValueOfTouchPositionAbsolute(HomeRecycleFragment.this);
                    }
                }
                KycInfo kycInfo = p0.DatabaseTableConfigUtil;
                MixPanelTracker.MyBillsEntityDataFactory(kycInfo != null ? kycInfo.PlaceComponentResult : null);
            }
        });
        int i = N + 13;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? 'J' : ',') != ',') {
            Object[] objArr = null;
            int length = objArr.length;
            return getUserInfoModule;
        }
        return getUserInfoModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0039, code lost:
    
        if ((r0.PlaceComponentResult()) != false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r6) {
        /*
            r5 = this;
            id.dana.dialog.TwoButtonWithImageDialog r0 = r5.getAuthRequestContext
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L8
            r0 = 0
            goto L9
        L8:
            r0 = 1
        L9:
            if (r0 == r2) goto L18
            r5.c()
            int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r0 = r0 + 5
            int r3 = r0 % 128
            id.dana.animation.HomeRecycleFragment.N = r3
            int r0 = r0 % 2
        L18:
            id.dana.dialog.TwoButtonWithImageDialog r0 = r5.getAuthRequestContext
            r3 = 20
            if (r0 == 0) goto L21
            r4 = 20
            goto L23
        L21:
            r4 = 94
        L23:
            if (r4 == r3) goto L26
            goto L3c
        L26:
            int r3 = id.dana.animation.HomeRecycleFragment.N
            int r3 = r3 + 31
            int r4 = r3 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
            int r3 = r3 % 2
            boolean r0 = r0.PlaceComponentResult()
            if (r0 == r2) goto L38
            r0 = 0
            goto L39
        L38:
            r0 = 1
        L39:
            if (r0 == 0) goto L3c
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L4a
            int r6 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
            int r6 = r6 + 71
            int r0 = r6 % 128
            id.dana.animation.HomeRecycleFragment.N = r0
            int r6 = r6 % 2
            return
        L4a:
            id.dana.dialog.TwoButtonWithImageDialog r0 = r5.getAuthRequestContext
            if (r0 == 0) goto L70
            int r2 = id.dana.animation.HomeRecycleFragment.N
            int r2 = r2 + 3
            int r3 = r2 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L63
            r0.MyBillsEntityDataFactory()
            r0 = 93
            int r0 = r0 / r1
            goto L66
        L61:
            r6 = move-exception
            throw r6
        L63:
            r0.MyBillsEntityDataFactory()
        L66:
            int r0 = id.dana.animation.HomeRecycleFragment.N
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
        L70:
            r0 = 2131951646(0x7f13001e, float:1.9539712E38)
            java.lang.String r1 = r5.getString(r0)
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r5.getAuthRequestContext(r6, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):void");
    }

    private final void c() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.account_freeze_dialog_title);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.getErrorConfigVersion = getString(R.string.account_freeze_dialog_login_desc);
        String string = getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        View.OnClickListener i = i();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = upperCase;
        builder.DatabaseTableConfigUtil = i;
        builder.initRecordTimeStamp = true;
        String string2 = getString(R.string.account_freeze_dialog_positive_btn);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "");
        String upperCase2 = string2.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        View.OnClickListener j = j();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = upperCase2;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = j;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        MyBillsEntityDataFactory.isLayoutRequested = false;
        this.getAuthRequestContext = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 59;
        N = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final View.OnClickListener i() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeRecycleFragment.moveToNextValue(HomeRecycleFragment.this);
            }
        };
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 13;
        N = i % 128;
        if ((i % 2 != 0 ? 'F' : '`') != '`') {
            Object[] objArr = null;
            int length = objArr.length;
            return onClickListener;
        }
        return onClickListener;
    }

    private static final void L(HomeRecycleFragment homeRecycleFragment) {
        int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
        N = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        homeRecycleFragment.FlowableReduce$ReduceSubscriber().get().KClassImpl$Data$declaredNonStaticMembers$2();
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 43;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void o() {
        try {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 103;
            N = i % 128;
            int i2 = i % 2;
            DanaH5.startContainerFullUrl("https://www.dana.id/contact");
            try {
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 99;
                N = i3 % 128;
                if (i3 % 2 != 0) {
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

    private final void getAuthRequestContext(String p0, String p1, String p2) {
        int i = N + 25;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), p0, "alipayplus.mobilewallet.wallet.user.info", p1, p2, "Home", "");
        int i3 = N + 97;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? '\b' : 'I') != '\b') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void FillAnimation() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.home.HomeRecycleFragment$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Object obj = null;
                if (p0.MyBillsEntityDataFactory()) {
                    HomeRecycleFragment.DatabaseTableConfigUtil(HomeRecycleFragment.this);
                    HomeAdapter DatabaseTableConfigUtil = HomeRecycleFragment.this.DatabaseTableConfigUtil();
                    if (DatabaseTableConfigUtil != null) {
                        DatabaseTableConfigUtil.MyBillsEntityDataFactory = true;
                        DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    }
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this.getBaseActivity().getApplicationContext(), true);
                    LocationPermissionSubject locationPermissionSubject = HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2().get();
                    Object obj2 = locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
                    if (!NotificationLite.isComplete(obj2) && !NotificationLite.isError(obj2)) {
                        obj = NotificationLite.getValue(obj2);
                    }
                    if (!Intrinsics.areEqual(obj, Boolean.TRUE)) {
                        locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
                    }
                    HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(HomeRecycleFragment.this);
                    return;
                }
                HomeRecycleFragment.DatabaseTableConfigUtil(HomeRecycleFragment.this);
                HomeAdapter DatabaseTableConfigUtil2 = HomeRecycleFragment.this.DatabaseTableConfigUtil();
                if (DatabaseTableConfigUtil2 != null) {
                    DatabaseTableConfigUtil2.MyBillsEntityDataFactory = false;
                    DatabaseTableConfigUtil2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment.this.getBaseActivity().getApplicationContext(), true);
                LocationPermissionSubject locationPermissionSubject2 = HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2().get();
                Object obj3 = locationPermissionSubject2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
                if (!NotificationLite.isComplete(obj3) && !NotificationLite.isError(obj3)) {
                    obj = NotificationLite.getValue(obj3);
                }
                if (!Intrinsics.areEqual(obj, Boolean.FALSE)) {
                    locationPermissionSubject2.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.FALSE);
                }
                boolean shouldShowRequestPermissionRationale = HomeRecycleFragment.this.shouldShowRequestPermissionRationale(p0.BuiltInFictitiousFunctionClassFactory.get(0).KClassImpl$Data$declaredNonStaticMembers$2);
                if (shouldShowRequestPermissionRationale) {
                    HomeRecycleFragment.this.newProxyInstance().get().MyBillsEntityDataFactory(shouldShowRequestPermissionRationale);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseActivity baseActivity = HomeRecycleFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PermissionHelper.MyBillsEntityDataFactory(baseActivity);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.E = builder.PlaceComponentResult();
        int i = N + 69;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void E() {
        DialogPermission dialogPermission = this.getValueOfTouchPositionAbsolute;
        if ((dialogPermission != null ? '@' : '0') != '0') {
            try {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 123;
                N = i % 128;
                if ((i % 2 != 0 ? '8' : '^') != '8') {
                    dialogPermission.getAuthRequestContext();
                } else {
                    try {
                        dialogPermission.getAuthRequestContext();
                        int i2 = 21 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        newProxyInstance().get().MyBillsEntityDataFactory(true);
        int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 15;
        N = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void M() {
        int i = N + 109;
        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? (char) 15 : '(') != '(') {
            try {
                boolean NetworkUserEntityData$$ExternalSyntheticLambda4 = NetworkUserEntityData$$ExternalSyntheticLambda4();
                Object[] objArr = null;
                int length = objArr.length;
                if (!NetworkUserEntityData$$ExternalSyntheticLambda4) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else if (!NetworkUserEntityData$$ExternalSyntheticLambda4()) {
            return;
        }
        final GeoFencePresenter geoFencePresenter = initAnimators().get();
        geoFencePresenter.PlaceComponentResult.get().execute(new DefaultObserver<GeofenceConfig>() { // from class: id.dana.geofence.GeoFencePresenter$getGeoFencingConfig$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                GeofenceConfig geofenceConfig;
                GeofenceConfig geofenceConfig2 = (GeofenceConfig) obj;
                Intrinsics.checkNotNullParameter(geofenceConfig2, "");
                GeoFencePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = geofenceConfig2;
                GeoFencePresenter geoFencePresenter2 = GeoFencePresenter.this;
                SetRetryIntervalGeoFence setRetryIntervalGeoFence = geoFencePresenter2.getErrorConfigVersion.get();
                DefaultObserver defaultObserver = new DefaultObserver();
                SetRetryIntervalGeoFence.Params.Companion companion = SetRetryIntervalGeoFence.Params.INSTANCE;
                GeofenceConfig geofenceConfig3 = geoFencePresenter2.KClassImpl$Data$declaredNonStaticMembers$2;
                GeofenceConfig geofenceConfig4 = null;
                if (geofenceConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    geofenceConfig3 = null;
                }
                setRetryIntervalGeoFence.execute(defaultObserver, companion.forRetryInterval(geofenceConfig3.getMaxRetry()));
                geofenceConfig = GeoFencePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (geofenceConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    geofenceConfig4 = geofenceConfig;
                }
                if (geofenceConfig4.isFeatureEnable()) {
                    r6.getAuthRequestContext.get().execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: INVOKE 
                          (wrap: id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime : 0x0002: INVOKE 
                          (wrap: dagger.Lazy<id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime> : 0x0000: IGET (r6v10 id.dana.geofence.GeoFencePresenter) A[WRAPPED] (LINE:1067) id.dana.geofence.GeoFencePresenter.getErrorConfigVersion dagger.Lazy)
                         type: INTERFACE call: dagger.Lazy.get():java.lang.Object A[MD:():T (m), WRAPPED] (LINE:1067))
                          (wrap: id.dana.domain.DefaultObserver<java.lang.Long> : 0x000a: CONSTRUCTOR 
                          (wrap: id.dana.geofence.GeoFencePresenter : 0x0046: IGET (r5v0 'this' id.dana.geofence.GeoFencePresenter$getGeoFencingConfig$1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:1052) id.dana.geofence.GeoFencePresenter$getGeoFencingConfig$1.PlaceComponentResult id.dana.geofence.GeoFencePresenter)
                         A[MD:(id.dana.geofence.GeoFencePresenter):void (m), WRAPPED] (LINE:1052) call: id.dana.geofence.GeoFencePresenter$startGeoFencing$1.<init>(id.dana.geofence.GeoFencePresenter):void type: CONSTRUCTOR)
                         type: VIRTUAL call: id.dana.domain.UseCase.execute(io.reactivex.observers.DisposableObserver):void A[MD:(io.reactivex.observers.DisposableObserver<T>):void (m)] (LINE:1067) in method: id.dana.geofence.GeoFencePresenter$getGeoFencingConfig$1.onNext(java.lang.Object):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                        	at java.base/java.util.ArrayList.forEach(Unknown Source)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.geofence.GeoFencePresenter$startGeoFencing$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 23 more
                        */
                    /*
                        this = this;
                        id.dana.domain.featureconfig.model.GeofenceConfig r6 = (id.dana.domain.featureconfig.model.GeofenceConfig) r6
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        id.dana.geofence.GeoFencePresenter r1 = id.dana.geofence.GeoFencePresenter.this
                        id.dana.geofence.GeoFencePresenter.PlaceComponentResult(r1, r6)
                        id.dana.geofence.GeoFencePresenter r6 = id.dana.geofence.GeoFencePresenter.this
                        dagger.Lazy<id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence> r1 = r6.getErrorConfigVersion
                        java.lang.Object r1 = r1.get()
                        id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence r1 = (id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence) r1
                        id.dana.domain.DefaultObserver r2 = new id.dana.domain.DefaultObserver
                        r2.<init>()
                        io.reactivex.observers.DisposableObserver r2 = (io.reactivex.observers.DisposableObserver) r2
                        id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence$Params$Companion r3 = id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence.Params.INSTANCE
                        id.dana.domain.featureconfig.model.GeofenceConfig r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
                        r4 = 0
                        if (r6 != 0) goto L28
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        r6 = r4
                    L28:
                        int r6 = r6.getMaxRetry()
                        id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence$Params r6 = r3.forRetryInterval(r6)
                        r1.execute(r2, r6)
                        id.dana.geofence.GeoFencePresenter r6 = id.dana.geofence.GeoFencePresenter.this
                        id.dana.domain.featureconfig.model.GeofenceConfig r6 = id.dana.geofence.GeoFencePresenter.PlaceComponentResult(r6)
                        if (r6 != 0) goto L3f
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        goto L40
                    L3f:
                        r4 = r6
                    L40:
                        boolean r6 = r4.isFeatureEnable()
                        if (r6 == 0) goto L4b
                        id.dana.geofence.GeoFencePresenter r6 = id.dana.geofence.GeoFencePresenter.this
                        id.dana.geofence.GeoFencePresenter.KClassImpl$Data$declaredNonStaticMembers$2(r6)
                    L4b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.geofence.GeoFencePresenter$getGeoFencingConfig$1.onNext(java.lang.Object):void");
                }
            });
            int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 43;
            N = i2 % 128;
            int i3 = i2 % 2;
        }

        private static List<HomeViewWidgetModel> b() {
            try {
                HomeViewWidgetModel[] homeViewWidgetModelArr = new HomeViewWidgetModel[12];
                try {
                    homeViewWidgetModelArr[0] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.GLOBAL_SEARCH);
                    homeViewWidgetModelArr[1] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.FOUR_KINGS);
                    homeViewWidgetModelArr[2] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.SERVICES);
                    homeViewWidgetModelArr[3] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.SOCIAL_WIDGET);
                    homeViewWidgetModelArr[4] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.PROMO_BANNER);
                    homeViewWidgetModelArr[5] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.PROMO_CENTER);
                    homeViewWidgetModelArr[6] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.NEARBY_ME);
                    homeViewWidgetModelArr[7] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.HOME_INVESTMENT);
                    homeViewWidgetModelArr[8] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.MORE_FOR_YOU);
                    homeViewWidgetModelArr[9] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.DANA_PROTECTION);
                    homeViewWidgetModelArr[10] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.PERSONALIZED_BACKGROUND);
                    homeViewWidgetModelArr[11] = new HomeViewWidgetModel(HomeAdapter.HomeWidget.SPACERS);
                    List<HomeViewWidgetModel> mutableListOf = CollectionsKt.mutableListOf(homeViewWidgetModelArr);
                    int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
                    N = i % 128;
                    if (!(i % 2 != 0)) {
                        return mutableListOf;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return mutableListOf;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        private final void a() {
            HomeAdapter homeAdapter;
            RecyclerView recyclerView;
            RecyclerView recyclerView2;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            initRecordTimeStamp().get().scheduleImpl();
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            AppReadyMixpanelTracker.MyBillsEntityDataFactory(this.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new LinearLayoutManager(this, getActivity()) { // from class: id.dana.home.HomeRecycleFragment$initHomeWidget$1
                final /* synthetic */ HomeRecycleFragment getAuthRequestContext;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r3, 1, false);
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public final void onLayoutCompleted(RecyclerView.State p0) {
                    super.onLayoutCompleted(p0);
                    if (Ref.BooleanRef.this.element) {
                        return;
                    }
                    this.getAuthRequestContext.readMicros();
                }
            };
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            Object[] objArr = null;
            RecyclerView recyclerView3 = fragmentHomeRecycleBinding != null ? fragmentHomeRecycleBinding.BuiltInFictitiousFunctionClassFactory : null;
            if ((recyclerView3 != null ? (char) 1 : '-') != '-') {
                LinearLayoutManager linearLayoutManager = this.VerifyPinStateManager$executeRiskChallenge$2$1;
                if (linearLayoutManager == null) {
                    int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 125;
                    N = i % 128;
                    if ((i % 2 != 0 ? '^' : Typography.greater) != '>') {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        int i2 = 0 / 0;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    linearLayoutManager = null;
                }
                recyclerView3.setLayoutManager(linearLayoutManager);
            }
            Context context = getContext();
            if (context != null) {
                List<HomeViewWidgetModel> b = b();
                BaseActivity baseActivity = getBaseActivity();
                if (baseActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                }
                HomeTabActivity homeTabActivity = (HomeTabActivity) baseActivity;
                SwipeDelegateListener secondaryHash = secondaryHash();
                HomeTrackerImpl homeTrackerImpl = OtpRegistrationPresenter$input$1().get();
                Intrinsics.checkNotNullExpressionValue(homeTrackerImpl, "");
                homeAdapter = new HomeAdapter(b, context, homeTabActivity, secondaryHash, this, homeTrackerImpl, new ServiceCardListener() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda4
                    @Override // id.dana.richview.servicescard.ServiceCardListener
                    public final void MyBillsEntityDataFactory(String str) {
                        HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment.this, str);
                    }
                });
            } else {
                homeAdapter = null;
            }
            this.GetContactSyncConfig = homeAdapter;
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding2 = (FragmentHomeRecycleBinding) getBinding();
            if (fragmentHomeRecycleBinding2 != null) {
                int i3 = N + 7;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                if (i3 % 2 == 0) {
                    recyclerView = fragmentHomeRecycleBinding2.BuiltInFictitiousFunctionClassFactory;
                    int i4 = 66 / 0;
                } else {
                    recyclerView = fragmentHomeRecycleBinding2.BuiltInFictitiousFunctionClassFactory;
                }
            } else {
                int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 25;
                N = i5 % 128;
                int i6 = i5 % 2;
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.setAdapter(this.GetContactSyncConfig);
                try {
                    int i7 = N + 15;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i7 % 128;
                    int i8 = i7 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                FragmentHomeRecycleBinding fragmentHomeRecycleBinding3 = (FragmentHomeRecycleBinding) getBinding();
                RecyclerView recyclerView4 = fragmentHomeRecycleBinding3 != null ? fragmentHomeRecycleBinding3.BuiltInFictitiousFunctionClassFactory : null;
                if ((recyclerView4 == null ? '/' : '-') != '/') {
                    int i9 = N + 75;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i9 % 128;
                    if (i9 % 2 == 0) {
                        recyclerView4.setEdgeEffectFactory(T());
                        int length = objArr.length;
                    } else {
                        recyclerView4.setEdgeEffectFactory(T());
                    }
                }
                HomeAdapter homeAdapter2 = this.GetContactSyncConfig;
                if (homeAdapter2 != null) {
                    homeAdapter2.lookAheadTest = new HomeAdapter.HomeAdapterListener() { // from class: id.dana.home.HomeRecycleFragment$initHomeWidget$3
                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void MyBillsEntityDataFactory(boolean p0) {
                            FragmentHomeRecycleBinding GetContactSyncConfig;
                            ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding;
                            ImageView imageView;
                            if (HomeRecycleFragment.this.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED) && (GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this)) != null && (viewHomeToolbarMenuBinding = GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2) != null && (imageView = viewHomeToolbarMenuBinding.MyBillsEntityDataFactory) != null) {
                                InstrumentInjector.Resources_setImageResource(imageView, p0 ? R.drawable.ic_inbox_bar : R.drawable.ic_notif_feeds_bar);
                            }
                            if (HomeRecycleFragment.this.getActivity() == null || !HomeRecycleFragment.getSupportButtonTintMode(HomeRecycleFragment.this)) {
                                return;
                            }
                            FragmentActivity activity = HomeRecycleFragment.this.getActivity();
                            if (activity == null) {
                                throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                            }
                            ((HomeTabActivity) activity).setFeedEnabledAndFeedRevamp(true, p0);
                            HomeRecycleFragment.A(HomeRecycleFragment.this);
                        }

                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void getAuthRequestContext(boolean p0) {
                            if (p0) {
                                FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda4 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(HomeRecycleFragment.this);
                                if (NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
                                    NetworkUserEntityData$$ExternalSyntheticLambda4.check();
                                    return;
                                }
                                return;
                            }
                            HomeRecycleFragment.this.newProxyInstance().get().PlaceComponentResult();
                        }

                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void PlaceComponentResult(IntentSender p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            HomeRecycleFragment.this.startIntentSenderForResult(p0, 100, null, 0, 0, 0, null);
                        }

                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void getAuthRequestContext(TimerEventKey p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            HomeRecycleFragment.this.BuiltInFictitiousFunctionClassFactory(p0);
                        }

                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                            HomeRecycleFragment.D(HomeRecycleFragment.this);
                        }

                        @Override // id.dana.home.adapter.HomeAdapter.HomeAdapterListener
                        public final void MyBillsEntityDataFactory() {
                            HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment.this, new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$initHomeWidget$3$stopHomeInvestmentViewLoadTime$1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl2) {
                                    invoke2(homeTrackerImpl2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(HomeTrackerImpl homeTrackerImpl2) {
                                    Intrinsics.checkNotNullParameter(homeTrackerImpl2, "");
                                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.HOME_INVESTMENT);
                                    if (homeTrackerImpl2.MyBillsEntityDataFactory.get()) {
                                        homeTrackerImpl2.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.HOME_INVESTMENT_LOAD_TIME, System.currentTimeMillis());
                                    }
                                }
                            });
                        }
                    };
                }
                FragmentHomeRecycleBinding fragmentHomeRecycleBinding4 = (FragmentHomeRecycleBinding) getBinding();
                if (fragmentHomeRecycleBinding4 != null && (recyclerView2 = fragmentHomeRecycleBinding4.BuiltInFictitiousFunctionClassFactory) != null) {
                    recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.home.HomeRecycleFragment$initHomeWidget$4
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public final void onScrollStateChanged(RecyclerView p0, int p1) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            super.onScrollStateChanged(p0, p1);
                            LinearLayoutManager isLayoutRequested = HomeRecycleFragment.isLayoutRequested(HomeRecycleFragment.this);
                            if (isLayoutRequested == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                isLayoutRequested = null;
                            }
                            if (isLayoutRequested.findFirstCompletelyVisibleItemPosition() == 0) {
                                HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(true);
                            } else {
                                HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(false);
                            }
                            booleanRef.element = true;
                        }

                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public final void onScrolled(RecyclerView p0, int p1, int p2) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            super.onScrolled(p0, p1, p2);
                            LinearLayoutManager isLayoutRequested = HomeRecycleFragment.isLayoutRequested(HomeRecycleFragment.this);
                            if (isLayoutRequested == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                isLayoutRequested = null;
                            }
                            HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment.this, isLayoutRequested.findFirstCompletelyVisibleItemPosition());
                        }
                    });
                }
                f();
                TypeProjectionImpl();
                int i10 = N + 87;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i10 % 128;
                if (i10 % 2 == 0) {
                    objArr.hashCode();
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        private static final void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, String str) {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
            N = i % 128;
            Object[] objArr = null;
            try {
                if ((i % 2 != 0 ? (char) 22 : '\b') != 22) {
                    Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                    homeRecycleFragment.PlaceComponentResult(str);
                } else {
                    Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                    homeRecycleFragment.PlaceComponentResult(str);
                    int length = objArr.length;
                }
                int i2 = N + 103;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
                if (i2 % 2 != 0) {
                    return;
                }
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }

        public final void readMicros() {
            LinearLayoutManager linearLayoutManager = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            if ((linearLayoutManager == null ? '!' : (char) 16) == '!') {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 81;
                N = i % 128;
                if ((i % 2 != 0 ? Typography.amp : Typography.quote) != '&') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int i2 = 13 / 0;
                }
                linearLayoutManager = null;
                try {
                    int i3 = N + 97;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            Set<HomeViewWidgetModel> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(linearLayoutManager.findLastVisibleItemPosition());
            BuiltInFictitiousFunctionClassFactory.add(new HomeViewWidgetModel(HomeAdapter.HomeWidget.BALANCE));
            BuiltInFictitiousFunctionClassFactory.add(new HomeViewWidgetModel(HomeAdapter.HomeWidget.NOTIFICATION));
            BuiltInFictitiousFunctionClassFactory.add(new HomeViewWidgetModel(HomeAdapter.HomeWidget.BOTTOM_BAR));
            Collection.EL.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, new Predicate() { // from class: id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda5
                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate negate() {
                    return Predicate.CC.PlaceComponentResult(this);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return HomeRecycleFragment.PlaceComponentResult((HomeViewWidgetModel) obj);
                }
            });
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(CollectionsKt.toList(BuiltInFictitiousFunctionClassFactory));
        }

        private static final boolean MyBillsEntityDataFactory(HomeViewWidgetModel homeViewWidgetModel) {
            Intrinsics.checkNotNullParameter(homeViewWidgetModel, "");
            if (homeViewWidgetModel.MyBillsEntityDataFactory != HomeAdapter.HomeWidget.GLOBAL_SEARCH) {
                try {
                    int i = N + 95;
                    try {
                        SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                        if (!(i % 2 != 0)) {
                            HomeAdapter.HomeWidget homeWidget = homeViewWidgetModel.MyBillsEntityDataFactory;
                            HomeAdapter.HomeWidget homeWidget2 = HomeAdapter.HomeWidget.NO_SPACE;
                            Object[] objArr = null;
                            int length = objArr.length;
                            if (homeWidget != homeWidget2) {
                                return false;
                            }
                        } else if (homeViewWidgetModel.MyBillsEntityDataFactory != HomeAdapter.HomeWidget.NO_SPACE) {
                            return false;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            int i2 = N + 51;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            return true;
        }

        private final Set<HomeViewWidgetModel> BuiltInFictitiousFunctionClassFactory(int i) {
            Integer valueOf;
            List<HomeViewWidgetModel> b = b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (i >= 0) {
                int i2 = 0;
                while (true) {
                    HomeAdapter homeAdapter = this.GetContactSyncConfig;
                    if (homeAdapter != null) {
                        try {
                            valueOf = Integer.valueOf(homeAdapter.getItemViewType(i2));
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        valueOf = null;
                    }
                    Iterator<HomeViewWidgetModel> it = b.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            int i4 = N + 83;
                            SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
                            int i5 = i4 % 2;
                            i3 = -1;
                            break;
                        }
                        if (valueOf != null && it.next().MyBillsEntityDataFactory.getIndex() == valueOf.intValue()) {
                            break;
                        }
                        i3++;
                    }
                    if ((i3 != -1 ? (char) 27 : '.') != '.') {
                        int i6 = N + 75;
                        SummaryVoucherView$$ExternalSyntheticLambda1 = i6 % 128;
                        int i7 = i6 % 2;
                        linkedHashSet.add(b.get(i3));
                    }
                    if ((i2 != i ? 'D' : 'W') != 'D') {
                        break;
                    }
                    int i8 = N + 43;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i8 % 128;
                    int i9 = i8 % 2;
                    i2++;
                }
            }
            return linkedHashSet;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.home.HomeRecycleFragment$getSpringEdgeEffect$1] */
        private static HomeRecycleFragment$getSpringEdgeEffect$1 T() {
            ?? r0 = new RecyclerView.EdgeEffectFactory() { // from class: id.dana.home.HomeRecycleFragment$getSpringEdgeEffect$1
                @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
                public final EdgeEffect BuiltInFictitiousFunctionClassFactory(final RecyclerView p0, final int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    final Context context = p0.getContext();
                    return new EdgeEffect(context) { // from class: id.dana.home.HomeRecycleFragment$getSpringEdgeEffect$1$createEdgeEffect$1
                        @Override // android.widget.EdgeEffect
                        public final void onPull(float p02) {
                            super.onPull(p02);
                            MyBillsEntityDataFactory(p02);
                        }

                        @Override // android.widget.EdgeEffect
                        public final void onPull(float p02, float p12) {
                            super.onPull(p02, p12);
                            MyBillsEntityDataFactory(p02);
                        }

                        private final void MyBillsEntityDataFactory(float p02) {
                            float width = (p1 == 3 ? -1 : 1) * p0.getWidth();
                            RecyclerView recyclerView = p0;
                            int childCount = recyclerView.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                                if (childViewHolder != null) {
                                    BaseSpringAnimationViewHolder baseSpringAnimationViewHolder = (BaseSpringAnimationViewHolder) childViewHolder;
                                    SpringAnimation translationY = baseSpringAnimationViewHolder.getTranslationY();
                                    if (Looper.myLooper() != Looper.getMainLooper()) {
                                        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
                                    }
                                    if (translationY.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                                        translationY.KClassImpl$Data$declaredNonStaticMembers$2();
                                    }
                                    View view = baseSpringAnimationViewHolder.itemView;
                                    view.setTranslationY(view.getTranslationY() + (width * p02 * 0.2f));
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder");
                                }
                            }
                        }

                        @Override // android.widget.EdgeEffect
                        public final void onRelease() {
                            super.onRelease();
                            RecyclerView recyclerView = p0;
                            int childCount = recyclerView.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                                if (childViewHolder != null) {
                                    ((BaseSpringAnimationViewHolder) childViewHolder).getTranslationY().getAuthRequestContext();
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder");
                                }
                            }
                        }

                        @Override // android.widget.EdgeEffect
                        public final void onAbsorb(int p02) {
                            super.onAbsorb(p02);
                            float f = (p1 == 3 ? -1 : 1) * p02;
                            RecyclerView recyclerView = p0;
                            int childCount = recyclerView.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                                if (childViewHolder != null) {
                                    ((BaseSpringAnimationViewHolder) childViewHolder).getTranslationY().MyBillsEntityDataFactory(0.5f * f).getAuthRequestContext();
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder");
                                }
                            }
                        }
                    };
                }
            };
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 113;
            N = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = 44 / 0;
                return r0;
            }
            return r0;
        }

        private final void x() {
            try {
                int i = N + 69;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                MyBillsEntityDataFactory(!this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                RequestMoneyQrContract$View().get().MyBillsEntityDataFactory("dana");
                boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                boolean z2 = this.isLayoutRequested;
                if (z != z2) {
                    PlaceComponentResult(!z2);
                    RequestMoneyQrContract$View().get().MyBillsEntityDataFactory(AccountEntityRepository.BalanceType.INVESTMENT);
                    return;
                }
                try {
                    int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 73;
                    N = i3 % 128;
                    if ((i3 % 2 != 0 ? (char) 23 : 'T') != 'T') {
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:102:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x007a  */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.recyclerview.widget.RecyclerView] */
        /* JADX WARN: Type inference failed for: r1v6, types: [androidx.recyclerview.widget.RecyclerView] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void getAuthRequestContext(int r7) {
            /*
                r6 = this;
                android.content.Context r0 = r6.getContext()
                if (r0 == 0) goto Lbd
                kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
                r2 = 0
                r3 = 1
                r1.<init>(r2, r3)
                boolean r7 = r1.contains(r7)
                r1 = 0
                if (r7 == 0) goto L94
                id.dana.core.ui.util.ViewUtil r7 = id.dana.core.ui.util.ViewUtil.INSTANCE
                id.dana.home.adapter.HomeAdapter$GlobalSearchViewHolder r7 = r6.Q()
                if (r7 == 0) goto L29
                id.dana.databinding.ViewItemHomeGlobalSearchBinding r7 = r7.MyBillsEntityDataFactory
                if (r7 == 0) goto L22
                r4 = 0
                goto L23
            L22:
                r4 = 1
            L23:
                if (r4 == 0) goto L26
                goto L29
            L26:
                id.dana.richview.globalsearch.ToolbarGlobalSearchView r7 = r7.getAuthRequestContext
                goto L2a
            L29:
                r7 = r1
            L2a:
                android.view.View r7 = (android.view.View) r7
                java.lang.String r4 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
                id.dana.core.ui.util.ViewUtil.BuiltInFictitiousFunctionClassFactory(r7, r4)
                id.dana.home.adapter.HomeAdapter$GlobalSearchViewHolder r7 = r6.Q()
                if (r7 == 0) goto L39
                r4 = 1
                goto L3a
            L39:
                r4 = 0
            L3a:
                if (r4 == 0) goto L72
                int r4 = id.dana.animation.HomeRecycleFragment.N
                int r4 = r4 + 83
                int r5 = r4 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5
                int r4 = r4 % 2
                id.dana.databinding.ViewItemHomeGlobalSearchBinding r7 = r7.MyBillsEntityDataFactory
                r4 = 18
                if (r7 == 0) goto L4f
                r5 = 18
                goto L51
            L4f:
                r5 = 23
            L51:
                if (r5 == r4) goto L54
                goto L72
            L54:
                id.dana.richview.globalsearch.ToolbarGlobalSearchView r7 = r7.getAuthRequestContext
                if (r7 == 0) goto L72
                int r4 = id.dana.animation.HomeRecycleFragment.N
                int r4 = r4 + 71
                int r5 = r4 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5
                int r4 = r4 % 2
                if (r4 != 0) goto L6d
                java.lang.String r4 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
                r7.setBackgroundColor(r4)
                int r7 = r1.length     // Catch: java.lang.Throwable -> L6b
                goto L72
            L6b:
                r7 = move-exception
                throw r7
            L6d:
                java.lang.String r4 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
                r7.setBackgroundColor(r4)
            L72:
                androidx.viewbinding.ViewBinding r7 = r6.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r7 = (id.dana.databinding.FragmentHomeRecycleBinding) r7
                if (r7 == 0) goto L7b
                r2 = 1
            L7b:
                if (r2 == r3) goto L7e
                goto L80
            L7e:
                androidx.recyclerview.widget.RecyclerView r1 = r7.BuiltInFictitiousFunctionClassFactory
            L80:
                if (r1 == 0) goto Lbd
                android.graphics.drawable.Drawable r7 = r6.KClassImpl$Data$declaredNonStaticMembers$2(r0)
                r1.setBackground(r7)
                int r7 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r7 = r7 + 49
                int r0 = r7 % 128
                id.dana.animation.HomeRecycleFragment.N = r0
                int r7 = r7 % 2
                return
            L94:
                androidx.viewbinding.ViewBinding r7 = r6.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r7 = (id.dana.databinding.FragmentHomeRecycleBinding) r7
                r2 = 77
                if (r7 == 0) goto La1
                r3 = 74
                goto La3
            La1:
                r3 = 77
            La3:
                if (r3 == r2) goto Lb1
                int r1 = id.dana.animation.HomeRecycleFragment.N
                int r1 = r1 + 119
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
                int r1 = r1 % 2
                androidx.recyclerview.widget.RecyclerView r1 = r7.BuiltInFictitiousFunctionClassFactory
            Lb1:
                if (r1 == 0) goto Lbd
                r7 = 2131100497(0x7f060351, float:1.7813377E38)
                android.graphics.drawable.Drawable r7 = androidx.core.content.ContextCompat.PlaceComponentResult(r0, r7)
                r1.setBackground(r7)
            Lbd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getAuthRequestContext(int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x003c, code lost:
        
            if (r1 != null) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0056, code lost:
        
            if ((r1 != null ? 'H' : '?') != '?') goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0058, code lost:
        
            r1 = (android.graphics.drawable.GradientDrawable) r1;
            r1.setColor(r0);
            r1.setColor(r0);
            r5 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0062, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 39;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x006c, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0074, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final android.graphics.drawable.Drawable KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r5) {
            /*
                r4 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 13
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r0 = 2131232201(0x7f0805c9, float:1.8080505E38)
                android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.PlaceComponentResult(r5, r0)
                r0 = 48
                if (r5 == 0) goto L18
                r1 = 48
                goto L1a
            L18:
                r1 = 67
            L1a:
                if (r1 != r0) goto L7a
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 121
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                if (r0 == 0) goto L2a
                r0 = 0
                goto L2b
            L2a:
                r0 = 1
            L2b:
                r1 = 2131364089(0x7f0a08f9, float:1.8348005E38)
                if (r0 == 0) goto L3f
                android.graphics.drawable.LayerDrawable r5 = (android.graphics.drawable.LayerDrawable) r5
                java.lang.String r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L77
                int r0 = android.graphics.Color.parseColor(r0)     // Catch: java.lang.Exception -> L77
                android.graphics.drawable.Drawable r1 = r5.findDrawableByLayerId(r1)     // Catch: java.lang.Exception -> L77
                if (r1 == 0) goto L6d
                goto L58
            L3f:
                android.graphics.drawable.LayerDrawable r5 = (android.graphics.drawable.LayerDrawable) r5
                java.lang.String r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L77
                int r0 = android.graphics.Color.parseColor(r0)     // Catch: java.lang.Exception -> L77
                android.graphics.drawable.Drawable r1 = r5.findDrawableByLayerId(r1)     // Catch: java.lang.Exception -> L77
                r2 = 0
                int r2 = r2.length     // Catch: java.lang.Throwable -> L75
                r2 = 63
                if (r1 == 0) goto L54
                r3 = 72
                goto L56
            L54:
                r3 = 63
            L56:
                if (r3 == r2) goto L6d
            L58:
                android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1     // Catch: java.lang.Exception -> L77
                r1.setColor(r0)     // Catch: java.lang.Exception -> L77
                r1.setColor(r0)     // Catch: java.lang.Exception -> L77
                android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch: java.lang.Exception -> L77
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 39
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                return r5
            L6d:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L77
                java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
                r0.<init>(r1)     // Catch: java.lang.Exception -> L77
                throw r0     // Catch: java.lang.Exception -> L77
            L75:
                r5 = move-exception
                throw r5
            L77:
                android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
                return r5
            L7a:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException
                java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context):android.graphics.drawable.Drawable");
        }

        private final void TypeProjectionImpl() {
            OnSwipeListener.GestureListener.PlaceComponentResult(Y().KClassImpl$Data$declaredNonStaticMembers$2);
            OnSwipeListener.GestureListener.KClassImpl$Data$declaredNonStaticMembers$2(Y().KClassImpl$Data$declaredNonStaticMembers$2);
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            if ((fragmentHomeRecycleBinding != null ? (char) 24 : (char) 6) != 24) {
                return;
            }
            try {
                int i = N + 81;
                try {
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                    int i2 = i % 2;
                    ViewHomeToolbarMenuBinding viewHomeToolbarMenuBinding = fragmentHomeRecycleBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (viewHomeToolbarMenuBinding == null) {
                        return;
                    }
                    int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 1;
                    N = i3 % 128;
                    int i4 = i3 % 2;
                    viewHomeToolbarMenuBinding.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setOnTouchListener(Y());
                    viewHomeToolbarMenuBinding.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.setOnTouchListener(Y());
                    viewHomeToolbarMenuBinding.getErrorConfigVersion.PlaceComponentResult.setOnTouchListener(Y());
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        private final void f() {
            PtrClassicFrameLayout ptrClassicFrameLayout;
            PtrClassicFrameLayout ptrClassicFrameLayout2;
            PtrClassicFrameLayout ptrClassicFrameLayout3;
            PtrClassicFrameLayout ptrClassicFrameLayout4;
            int i = N + 27;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(false);
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            if (!(fragmentHomeRecycleBinding == null)) {
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
                N = i3 % 128;
                int i4 = i3 % 2;
                PtrClassicFrameLayout ptrClassicFrameLayout5 = fragmentHomeRecycleBinding.getAuthRequestContext;
                if (ptrClassicFrameLayout5 != null) {
                    ptrClassicFrameLayout5.addPtrUIHandler(new PtrUIHandler() { // from class: id.dana.home.HomeRecycleFragment$initPullToRefreshComponent$1
                        @Override // in.srain.cube.views.ptr.PtrUIHandler
                        public final void onUIPositionChange(PtrFrameLayout p0, boolean p1, byte p2, PtrIndicator p3) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            Intrinsics.checkNotNullParameter(p3, "");
                        }

                        @Override // in.srain.cube.views.ptr.PtrUIHandler
                        public final void onUIRefreshBegin(PtrFrameLayout p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                        }

                        @Override // in.srain.cube.views.ptr.PtrUIHandler
                        public final void onUIRefreshComplete(PtrFrameLayout p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                        }

                        @Override // in.srain.cube.views.ptr.PtrUIHandler
                        public final void onUIReset(PtrFrameLayout p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                            PtrClassicFrameLayout ptrClassicFrameLayout6 = GetContactSyncConfig != null ? GetContactSyncConfig.getAuthRequestContext : null;
                            if (ptrClassicFrameLayout6 != null) {
                                ptrClassicFrameLayout6.setBackground(null);
                            }
                            FragmentHomeRecycleBinding GetContactSyncConfig2 = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                            RecyclerView recyclerView = GetContactSyncConfig2 != null ? GetContactSyncConfig2.BuiltInFictitiousFunctionClassFactory : null;
                            if (recyclerView != null) {
                                recyclerView.setBackground(null);
                            }
                            HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7().BuiltInFictitiousFunctionClassFactory(false);
                        }

                        @Override // in.srain.cube.views.ptr.PtrUIHandler
                        public final void onUIRefreshPrepare(PtrFrameLayout p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            Context context = HomeRecycleFragment.this.getContext();
                            if (context != null) {
                                HomeRecycleFragment homeRecycleFragment = HomeRecycleFragment.this;
                                ViewUtil viewUtil = ViewUtil.INSTANCE;
                                FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(homeRecycleFragment);
                                ViewUtil.BuiltInFictitiousFunctionClassFactory(GetContactSyncConfig != null ? GetContactSyncConfig.getAuthRequestContext : null, HomeRecycleFragment.newProxyInstance(homeRecycleFragment));
                                FragmentHomeRecycleBinding GetContactSyncConfig2 = HomeRecycleFragment.GetContactSyncConfig(homeRecycleFragment);
                                RecyclerView recyclerView = GetContactSyncConfig2 != null ? GetContactSyncConfig2.BuiltInFictitiousFunctionClassFactory : null;
                                if (recyclerView != null) {
                                    recyclerView.setBackground(HomeRecycleFragment.MyBillsEntityDataFactory(homeRecycleFragment, context));
                                }
                            }
                        }
                    });
                    int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 9;
                    N = i5 % 128;
                    int i6 = i5 % 2;
                }
            }
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding2 = (FragmentHomeRecycleBinding) getBinding();
            if ((fragmentHomeRecycleBinding2 != null) && (ptrClassicFrameLayout4 = fragmentHomeRecycleBinding2.getAuthRequestContext) != null) {
                ptrClassicFrameLayout4.setPtrHandler(this);
            }
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding3 = (FragmentHomeRecycleBinding) getBinding();
            if (fragmentHomeRecycleBinding3 != null && (ptrClassicFrameLayout3 = fragmentHomeRecycleBinding3.getAuthRequestContext) != null) {
                int i7 = SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
                N = i7 % 128;
                int i8 = i7 % 2;
                ptrClassicFrameLayout3.disableWhenHorizontalMove(true);
            }
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding4 = (FragmentHomeRecycleBinding) getBinding();
            LoadingLottieAnimationView loadingLottieAnimationView = null;
            if (fragmentHomeRecycleBinding4 != null) {
                int i9 = SummaryVoucherView$$ExternalSyntheticLambda1 + 91;
                N = i9 % 128;
                if (i9 % 2 != 0) {
                    ptrClassicFrameLayout = fragmentHomeRecycleBinding4.getAuthRequestContext;
                    int i10 = 59 / 0;
                } else {
                    ptrClassicFrameLayout = fragmentHomeRecycleBinding4.getAuthRequestContext;
                }
            } else {
                ptrClassicFrameLayout = null;
            }
            if ((ptrClassicFrameLayout != null ? Typography.dollar : InputCardNumberView.DIVIDER) == '$') {
                ptrClassicFrameLayout.setHeaderView(getLayoutInflater().inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
            }
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding5 = (FragmentHomeRecycleBinding) getBinding();
            if (fragmentHomeRecycleBinding5 != null && (ptrClassicFrameLayout2 = fragmentHomeRecycleBinding5.getAuthRequestContext) != null) {
                int i11 = SummaryVoucherView$$ExternalSyntheticLambda1 + 23;
                N = i11 % 128;
                int i12 = i11 % 2;
                View headerView = ptrClassicFrameLayout2.getHeaderView();
                if (!(headerView == null)) {
                    loadingLottieAnimationView = (LoadingLottieAnimationView) headerView.findViewById(R.id.lav_loading_animation);
                }
            }
            this.A = loadingLottieAnimationView;
            if (loadingLottieAnimationView != null) {
                loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.home.HomeRecycleFragment$initPullToRefreshComponent$2
                    @Override // android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator p0) {
                        LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda7;
                        Intrinsics.checkNotNullParameter(p0, "");
                        LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda72 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this);
                        if (NetworkUserEntityData$$ExternalSyntheticLambda72 == null || (NetworkUserEntityData$$ExternalSyntheticLambda7 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this)) == null) {
                            return;
                        }
                        NetworkUserEntityData$$ExternalSyntheticLambda7.setupIntroMinMaxFrame(NetworkUserEntityData$$ExternalSyntheticLambda72);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator p0) {
                        PtrClassicFrameLayout ptrClassicFrameLayout6;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this) != null) {
                            LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda7 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this);
                            if (NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                                NetworkUserEntityData$$ExternalSyntheticLambda7.setLoopFinished(false);
                            }
                            HomeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$1(HomeRecycleFragment.this);
                            FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                            if (GetContactSyncConfig != null && (ptrClassicFrameLayout6 = GetContactSyncConfig.getAuthRequestContext) != null) {
                                ptrClassicFrameLayout6.refreshComplete();
                            }
                            FragmentHomeRecycleBinding GetContactSyncConfig2 = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                            PtrClassicFrameLayout ptrClassicFrameLayout7 = GetContactSyncConfig2 != null ? GetContactSyncConfig2.getAuthRequestContext : null;
                            if (ptrClassicFrameLayout7 != null) {
                                ptrClassicFrameLayout7.setBackground(null);
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public final void onAnimationRepeat(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this) != null) {
                            LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda7 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this);
                            if (NetworkUserEntityData$$ExternalSyntheticLambda7 != null && NetworkUserEntityData$$ExternalSyntheticLambda7.getIsLoopFinished()) {
                                LoadingLottieAnimationView NetworkUserEntityData$$ExternalSyntheticLambda72 = HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment.this);
                                if (NetworkUserEntityData$$ExternalSyntheticLambda72 != null) {
                                    NetworkUserEntityData$$ExternalSyntheticLambda72.cancelAnimation();
                                    return;
                                }
                                return;
                            }
                        }
                        HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(HomeRecycleFragment.this);
                    }
                });
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x008e, code lost:
        
            r2 = id.dana.animation.HomeRecycleFragment.N + 13;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2 % 128;
            r2 = r2 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0098, code lost:
        
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x009b, code lost:
        
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x009c, code lost:
        
            r2.scrollToPositionWithOffset(r0, r1);
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x00a9, code lost:
        
            if ((r0 % 2) == 0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x00ab, code lost:
        
            r0 = r4.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x00ac, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x00af, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x00b0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x00b1, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x005a, code lost:
        
            if ((r0 >= r5) != true) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x005f, code lost:
        
            if (r0 < r5) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0061, code lost:
        
            r2 = r0 - r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0065, code lost:
        
            if (r2 < 0) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0067, code lost:
        
            r6 = 'F';
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x006a, code lost:
        
            r6 = 'O';
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x006c, code lost:
        
            if (r6 == 'F') goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x006f, code lost:
        
            r5 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 35;
            id.dana.animation.HomeRecycleFragment.N = r5 % 128;
            r5 = r5 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x007d, code lost:
        
            if (r2 >= r1.getChildCount()) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x007f, code lost:
        
            r1 = r1.getChildAt(r2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
            r1 = r1.getTop();
            r2 = r8.VerifyPinStateManager$executeRiskChallenge$2$1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x008c, code lost:
        
            if (r2 != null) goto L103;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void isAuto() {
            /*
                r8 = this;
                id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.FOUR_KINGS
                int r0 = r0.getIndex()
                int r0 = MyBillsEntityDataFactory(r0)
                androidx.viewbinding.ViewBinding r1 = r8.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r1 = (id.dana.databinding.FragmentHomeRecycleBinding) r1
                if (r1 == 0) goto Lb8
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r2 = r2 + 97
                int r3 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r3
                int r2 = r2 % 2
                androidx.recyclerview.widget.RecyclerView r1 = r1.BuiltInFictitiousFunctionClassFactory
                if (r1 == 0) goto Lb8
                androidx.recyclerview.widget.LinearLayoutManager r2 = r8.VerifyPinStateManager$executeRiskChallenge$2$1
                java.lang.String r3 = ""
                r4 = 0
                if (r2 != 0) goto L35
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r2 = r2 + 25
                int r5 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r5
                int r2 = r2 % 2
                r2 = r4
            L35:
                int r2 = r2.findFirstVisibleItemPosition()
                androidx.recyclerview.widget.LinearLayoutManager r5 = r8.VerifyPinStateManager$executeRiskChallenge$2$1
                if (r5 != 0) goto L41
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                r5 = r4
            L41:
                int r5 = r5.findLastVisibleItemPosition()
                if (r0 <= r2) goto Lb2
                int r6 = id.dana.animation.HomeRecycleFragment.N
                int r6 = r6 + 39
                int r7 = r6 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r7
                int r6 = r6 % 2
                if (r6 != 0) goto L5f
                int r6 = r4.length     // Catch: java.lang.Throwable -> L5d
                r6 = 1
                if (r0 >= r5) goto L59
                r5 = 0
                goto L5a
            L59:
                r5 = 1
            L5a:
                if (r5 == r6) goto Lb2
                goto L61
            L5d:
                r0 = move-exception
                throw r0
            L5f:
                if (r0 >= r5) goto Lb2
            L61:
                int r2 = r0 - r2
                r5 = 70
                if (r2 < 0) goto L6a
                r6 = 70
                goto L6c
            L6a:
                r6 = 79
            L6c:
                if (r6 == r5) goto L6f
                goto Lb8
            L6f:
                int r5 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r5 = r5 + 35
                int r6 = r5 % 128
                id.dana.animation.HomeRecycleFragment.N = r6
                int r5 = r5 % 2
                int r5 = r1.getChildCount()
                if (r2 >= r5) goto Lb8
                android.view.View r1 = r1.getChildAt(r2)     // Catch: java.lang.Exception -> Lb0
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch: java.lang.Exception -> Lb0
                int r1 = r1.getTop()     // Catch: java.lang.Exception -> Lb0
                androidx.recyclerview.widget.LinearLayoutManager r2 = r8.VerifyPinStateManager$executeRiskChallenge$2$1     // Catch: java.lang.Exception -> Lb0
                if (r2 != 0) goto L9c
                int r2 = id.dana.animation.HomeRecycleFragment.N
                int r2 = r2 + 13
                int r5 = r2 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5
                int r2 = r2 % 2
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch: java.lang.Exception -> Lb6
                r2 = r4
            L9c:
                r2.scrollToPositionWithOffset(r0, r1)
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 31
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                if (r0 == 0) goto Laf
                int r0 = r4.length     // Catch: java.lang.Throwable -> Lad
                return
            Lad:
                r0 = move-exception
                throw r0
            Laf:
                return
            Lb0:
                r0 = move-exception
                throw r0
            Lb2:
                r1.scrollToPosition(r0)     // Catch: java.lang.Exception -> Lb6
                goto Lb8
            Lb6:
                r0 = move-exception
                throw r0
            Lb8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.isAuto():void");
        }

        private final void BottomSheetCardBindingView$watcherCardNumberView$1() {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 33;
            N = i % 128;
            int i2 = i % 2;
            LoadingLottieAnimationView loadingLottieAnimationView = this.A;
            if (loadingLottieAnimationView != null) {
                loadingLottieAnimationView.setupLoopMinMaxFrame(loadingLottieAnimationView);
                if ((this.DatabaseTableConfigUtil ? '\\' : ',') == '\\') {
                    try {
                        try {
                            loadingLottieAnimationView.setMaxFrame(loadingLottieAnimationView.getOutroMaxFrame());
                            loadingLottieAnimationView.setLoopFinished(true);
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            int i3 = N + 67;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 20 : '#') != '#') {
                int i4 = 14 / 0;
            }
        }

        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
            int i = N + 19;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            if ((ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 ? '9' : '^') != '^') {
                int i3 = N + 15;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                if (i3 % 2 == 0) {
                }
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0047, code lost:
        
            r3 = 26 / 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x004a, code lost:
        
            if (r0 == null) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x004c, code lost:
        
            r4 = '+';
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x004f, code lost:
        
            r4 = 4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0050, code lost:
        
            if (r4 != '+') goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0055, code lost:
        
            r0 = getParentFragment();
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0059, code lost:
        
            if (r0 == null) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x005b, code lost:
        
            r0 = ((id.dana.animation.tab.AppReadyConsumedProvider) r0).isConsumed();
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0063, code lost:
        
            r3 = id.dana.animation.HomeRecycleFragment.N + 63;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x006b, code lost:
        
            if ((r3 % 2) != 0) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x006e, code lost:
        
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x006f, code lost:
        
            if (r1 == false) goto L123;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x0071, code lost:
        
            r1 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x0072, code lost:
        
            r1.hashCode();
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0075, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x0078, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x0080, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type id.dana.home.tab.AppReadyConsumedProvider");
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x008a, code lost:
        
            throw new java.lang.IllegalStateException("Hosting Activity must implement AppReadyConsumedprovider");
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x001e, code lost:
        
            if ((!(getParentFragment() instanceof id.dana.animation.tab.AppReadyConsumedProvider)) != true) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0033, code lost:
        
            if ((getParentFragment() instanceof id.dana.animation.tab.AppReadyConsumedProvider) != false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0037, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x003b, code lost:
        
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x003f, code lost:
        
            if ((r0 % 2) == 0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0041, code lost:
        
            r0 = getParentFragment();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.Boolean FlowViewUtil$textChanges$1() {
            /*
                r5 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 69
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L10
                r0 = 1
                goto L11
            L10:
                r0 = 0
            L11:
                if (r0 == r1) goto L25
                androidx.fragment.app.Fragment r0 = r5.getParentFragment()     // Catch: java.lang.Exception -> L23
                boolean r0 = r0 instanceof id.dana.animation.tab.AppReadyConsumedProvider     // Catch: java.lang.Exception -> L21
                if (r0 == 0) goto L1d
                r0 = 0
                goto L1e
            L1d:
                r0 = 1
            L1e:
                if (r0 == r1) goto L83
                goto L35
            L21:
                r0 = move-exception
                goto L81
            L23:
                r0 = move-exception
                goto L82
            L25:
                androidx.fragment.app.Fragment r0 = r5.getParentFragment()
                boolean r0 = r0 instanceof id.dana.animation.tab.AppReadyConsumedProvider
                r3 = 68
                int r3 = r3 / r2
                if (r0 == 0) goto L32
                r0 = 1
                goto L33
            L32:
                r0 = 0
            L33:
                if (r0 == 0) goto L83
            L35:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L23
                int r0 = r0 + 41
                int r3 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r3     // Catch: java.lang.Exception -> L21
                int r0 = r0 % 2
                if (r0 == 0) goto L55
                androidx.fragment.app.Fragment r0 = r5.getParentFragment()
                r3 = 26
                int r3 = r3 / r2
                r3 = 43
                if (r0 == 0) goto L4f
                r4 = 43
                goto L50
            L4f:
                r4 = 4
            L50:
                if (r4 != r3) goto L79
                goto L5b
            L53:
                r0 = move-exception
                throw r0
            L55:
                androidx.fragment.app.Fragment r0 = r5.getParentFragment()
                if (r0 == 0) goto L79
            L5b:
                id.dana.home.tab.AppReadyConsumedProvider r0 = (id.dana.animation.tab.AppReadyConsumedProvider) r0
                java.lang.Boolean r0 = r0.isConsumed()
                int r3 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L21
                int r3 = r3 + 63
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
                int r3 = r3 % 2
                if (r3 != 0) goto L6e
                goto L6f
            L6e:
                r1 = 0
            L6f:
                if (r1 == 0) goto L78
                r1 = 0
                r1.hashCode()     // Catch: java.lang.Throwable -> L76
                return r0
            L76:
                r0 = move-exception
                throw r0
            L78:
                return r0
            L79:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r1 = "null cannot be cast to non-null type id.dana.home.tab.AppReadyConsumedProvider"
                r0.<init>(r1)
                throw r0
            L81:
                throw r0
            L82:
                throw r0
            L83:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Hosting Activity must implement AppReadyConsumedprovider"
                r0.<init>(r1)
                throw r0
            L8b:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.FlowViewUtil$textChanges$1():java.lang.Boolean");
        }

        public final void FragmentBottomSheetPaymentSettingBinding() {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 93;
            N = i % 128;
            if (i % 2 != 0) {
                boolean areEqual = Intrinsics.areEqual(FlowViewUtil$textChanges$1(), Boolean.FALSE);
                Object obj = null;
                obj.hashCode();
                if (areEqual) {
                    return;
                }
            } else if (Intrinsics.areEqual(FlowViewUtil$textChanges$1(), Boolean.FALSE)) {
                return;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 53;
                N = i2 % 128;
                int i3 = i2 % 2;
                if (this.lookAheadTest) {
                    return;
                }
                this.lookAheadTest = true;
                onSelected();
                k();
                M();
                verifyNotNull().get().PlaceComponentResult();
                verifyNotNull().get().moveToNextValue();
                getValueOfTouchPositionAbsolute();
                QrExpiredActivity();
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
                }
                try {
                    ((HomeTabActivity) activity).startOnBoardingProcess();
                } catch (Exception e) {
                    throw e;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0020, code lost:
        
            if ((r0 instanceof id.dana.animation.HomeTabActivity ? 'M' : ';') != 'M') goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0030, code lost:
        
            if ((r0 instanceof id.dana.animation.HomeTabActivity) != true) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0032, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0034, code lost:
        
            r0 = (id.dana.animation.HomeTabActivity) r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void k() {
            /*
                r6 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 73
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 77
                r2 = 0
                r3 = 1
                if (r0 != 0) goto L25
                id.dana.base.BaseActivity r0 = r6.getBaseActivity()
                boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity
                r5 = 66
                int r5 = r5 / r2
                if (r4 == 0) goto L1e
                r4 = 77
                goto L20
            L1e:
                r4 = 59
            L20:
                if (r4 == r1) goto L34
                goto L32
            L23:
                r0 = move-exception
                throw r0
            L25:
                id.dana.base.BaseActivity r0 = r6.getBaseActivity()     // Catch: java.lang.Exception -> L76
                boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> L76
                if (r4 == 0) goto L2f
                r4 = 1
                goto L30
            L2f:
                r4 = 0
            L30:
                if (r4 == r3) goto L34
            L32:
                r0 = 0
                goto L36
            L34:
                id.dana.home.HomeTabActivity r0 = (id.dana.animation.HomeTabActivity) r0
            L36:
                if (r0 == 0) goto L3a
                r4 = 0
                goto L3b
            L3a:
                r4 = 1
            L3b:
                if (r4 == 0) goto L3e
                goto L50
            L3e:
                int r4 = id.dana.animation.HomeRecycleFragment.N
                int r4 = r4 + 41
                int r5 = r4 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5
                int r4 = r4 % 2
                boolean r0 = r0.getIsFinishCheckSession()
                if (r0 == r3) goto L4f
                goto L50
            L4f:
                r2 = 1
            L50:
                if (r2 == 0) goto L75
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + r1
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                dagger.Lazy r0 = r6.PrepareContext()
                java.lang.Object r0 = r0.get()
                id.dana.contract.payasset.QueryPayMethodContract$Presenter r0 = (id.dana.contract.payasset.QueryPayMethodContract.Presenter) r0
                r0.PlaceComponentResult()
                dagger.Lazy r0 = r6.verifyNotNull()
                java.lang.Object r0 = r0.get()
                id.dana.contract.homeinfo.HomeInfoContract$Presenter r0 = (id.dana.contract.homeinfo.HomeInfoContract.Presenter) r0
                r0.getErrorConfigVersion()
            L75:
                return
            L76:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.k():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void VerifyPinStateManager$executeRiskChallenge$2$1() {
            /*
                Method dump skipped, instructions count: 189
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.VerifyPinStateManager$executeRiskChallenge$2$1():void");
        }

        private final void A() {
            String str = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().PlaceComponentResult;
            if ((str == null ? 'G' : 'Q') != 'Q') {
                str = "";
            }
            if (str.length() <= 0 ? false : true) {
                TypefaceCompatApi26Impl();
                CashierEventHandler cashierEventHandler = moveToNextValue().get();
                BaseActivity baseActivity = getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                BaseActivity baseActivity2 = baseActivity;
                DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.home.HomeRecycleFragment$checkCashierUrlToOpenCashier$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p0) {
                        if (Intrinsics.areEqual(DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda1, HomeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(HomeRecycleFragment.this))) {
                            HomeRecycleFragment.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p0) {
                        HomeRecycleFragment.MyBillsEntityDataFactory(HomeRecycleFragment.this, DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda1);
                    }
                };
                Intrinsics.checkNotNullParameter(baseActivity2, "");
                Intrinsics.checkNotNullParameter(str, "");
                cashierEventHandler.BuiltInFictitiousFunctionClassFactory(baseActivity2, str, danaH5Listener, "Deeplink");
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 3;
                N = i % 128;
                int i2 = i % 2;
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 9;
            N = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        }

        private final void TypefaceCompatApi26Impl() {
            int i = N + 49;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            FragmentActivity activity = getActivity();
            boolean z = false;
            if (activity != null) {
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 15;
                N = i3 % 128;
                char c = i3 % 2 != 0 ? (char) 28 : (char) 19;
                Intent intent = activity.getIntent();
                if (c == 19 ? intent != null : intent != null) {
                    try {
                        z = intent.getBooleanExtra(HomeTabActivity.NEW_REGISTERED_USER, false);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            String str = "Register";
            if ((DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().PlaceComponentResult() ? '\n' : 'X') != '\n') {
                if ((z ? (char) 19 : 'W') != 'W') {
                    int i4 = N + 65;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i4 % 128;
                    if (i4 % 2 == 0) {
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                } else {
                    int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 91;
                    N = i5 % 128;
                    int i6 = i5 % 2;
                    str = "None";
                }
            } else {
                int i7 = N + 47;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i7 % 128;
                int i8 = i7 % 2;
                str = DeeplinkFlowValue.NORMAL_LOGIN;
            }
            DeeplinkTracker deeplinkTracker = setNetAuthId().get();
            String str2 = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext;
            if (str2 == null) {
                str2 = "";
            }
            deeplinkTracker.KClassImpl$Data$declaredNonStaticMembers$2(str2, "Cashier", str);
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x003e A[Catch: Exception -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x008a, blocks: (B:64:0x0013, B:80:0x003e), top: B:106:0x0013 }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0078  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void v() {
            /*
                r6 = this;
                androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L1a
                android.content.Intent r0 = r0.getIntent()
                if (r0 == 0) goto L10
                r3 = 1
                goto L11
            L10:
                r3 = 0
            L11:
                if (r3 == 0) goto L1a
                java.lang.String r3 = "NEW_REGISTERED_USER"
                boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch: java.lang.Exception -> L8a
                goto L1b
            L1a:
                r0 = 0
            L1b:
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r3 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE     // Catch: java.lang.Exception -> L8c
                id.dana.contract.deeplink.DeeplinkSaveDataManager r3 = r3.PlaceComponentResult()
                boolean r3 = r3.PlaceComponentResult()
                r4 = 85
                if (r3 == 0) goto L2c
                r3 = 85
                goto L2e
            L2c:
                r3 = 87
            L2e:
                java.lang.String r5 = "Normal Login"
                if (r3 == r4) goto L3e
                if (r0 == 0) goto L35
                goto L36
            L35:
                r2 = 1
            L36:
                if (r2 == r1) goto L3b
                java.lang.String r5 = "Register"
                goto L5a
            L3b:
                java.lang.String r5 = "None"
                goto L5a
            L3e:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L8a
                int r0 = r0 + 59
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1     // Catch: java.lang.Exception -> L8a
                int r0 = r0 % 2
                r1 = 22
                if (r0 == 0) goto L4f
                r0 = 46
                goto L51
            L4f:
                r0 = 22
            L51:
                if (r0 == r1) goto L5a
                r0 = 0
                r0.hashCode()     // Catch: java.lang.Throwable -> L58
                goto L5a
            L58:
                r0 = move-exception
                throw r0
            L5a:
                dagger.Lazy r0 = r6.setNetAuthId()
                java.lang.Object r0 = r0.get()
                id.dana.contract.deeplink.tracker.DeeplinkTracker r0 = (id.dana.contract.deeplink.tracker.DeeplinkTracker) r0
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r1 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE
                id.dana.contract.deeplink.DeeplinkSaveDataManager r1 = r1.PlaceComponentResult()
                java.lang.String r1 = r1.getAuthRequestContext
                r2 = 94
                if (r1 != 0) goto L73
                r3 = 94
                goto L75
            L73:
                r3 = 29
            L75:
                if (r3 == r2) goto L78
                goto L7a
            L78:
                java.lang.String r1 = ""
            L7a:
                java.lang.String r2 = "ACCashier"
                r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2, r5)
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 91
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                return
            L8a:
                r0 = move-exception
                throw r0
            L8c:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.v():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0020, code lost:
        
            if (id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().scheduleImpl() != false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0038, code lost:
        
            if ((id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().scheduleImpl() ? '_' : 23) != '_') goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x003b, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 111;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
        
            if ((r0 % 2) == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0047, code lost:
        
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0048, code lost:
        
            if (r1 == false) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x004a, code lost:
        
            id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda0();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0054, code lost:
        
            id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda0();
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x005e, code lost:
        
            r0 = r0.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x005f, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.N + 71;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
            r0 = r0 % 2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void OtpRegistrationPresenter$input$2() {
            /*
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 85
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L10
                r0 = 1
                goto L11
            L10:
                r0 = 0
            L11:
                if (r0 == 0) goto L25
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()
                boolean r0 = r0.scheduleImpl()
                r3 = 74
                int r3 = r3 / r2
                if (r0 == 0) goto L69
                goto L3b
            L23:
                r0 = move-exception
                throw r0
            L25:
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE     // Catch: java.lang.Exception -> L78
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L76
                boolean r0 = r0.scheduleImpl()     // Catch: java.lang.Exception -> L76
                r3 = 95
                if (r0 == 0) goto L36
                r0 = 95
                goto L38
            L36:
                r0 = 23
            L38:
                if (r0 == r3) goto L3b
                goto L69
            L3b:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 111
                int r3 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r3
                int r0 = r0 % 2
                if (r0 == 0) goto L48
                r1 = 0
            L48:
                if (r1 == 0) goto L54
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()
                r0.NetworkUserEntityData$$ExternalSyntheticLambda0()
                goto L5f
            L54:
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()
                r0.NetworkUserEntityData$$ExternalSyntheticLambda0()
                r0 = 0
                int r0 = r0.length     // Catch: java.lang.Throwable -> L74
            L5f:
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 71
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
            L69:
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 101
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                return
            L74:
                r0 = move-exception
                throw r0
            L76:
                r0 = move-exception
                throw r0
            L78:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.OtpRegistrationPresenter$input$2():void");
        }

        private final void getValueOfTouchPositionAbsolute() {
            ViewTreeObserver viewTreeObserver;
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 29;
            N = i % 128;
            int i2 = i % 2;
            if (this.lookAheadTest) {
                RequestMoneyQrContract$View().get().KClassImpl$Data$declaredNonStaticMembers$2();
                n();
                r();
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
                this.getSupportButtonTintMode = false;
                FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
                if ((fragmentHomeRecycleBinding != null ? '\'' : '4') != '4') {
                    try {
                        int i3 = N + 69;
                        SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                        int i4 = i3 % 2;
                        RecyclerView recyclerView = fragmentHomeRecycleBinding.BuiltInFictitiousFunctionClassFactory;
                        if ((recyclerView == null) || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
                            return;
                        }
                        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.home.HomeRecycleFragment$doResumeProcess$1
                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                            public final void onGlobalLayout() {
                                RecyclerView recyclerView2;
                                ViewTreeObserver viewTreeObserver2;
                                HomeRecycleFragment.getOnBoardingScenario(HomeRecycleFragment.this);
                                FragmentHomeRecycleBinding GetContactSyncConfig = HomeRecycleFragment.GetContactSyncConfig(HomeRecycleFragment.this);
                                if (GetContactSyncConfig == null || (recyclerView2 = GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory) == null || (viewTreeObserver2 = recyclerView2.getViewTreeObserver()) == null) {
                                    return;
                                }
                                viewTreeObserver2.removeOnGlobalLayoutListener(this);
                            }
                        });
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:76:0x001c, code lost:
        
            if ((!(r0 instanceof id.dana.animation.HomeTabActivity)) != true) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0027, code lost:
        
            if ((r0 instanceof id.dana.animation.HomeTabActivity) != false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0029, code lost:
        
            r3 = id.dana.animation.HomeRecycleFragment.N + 35;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3 % 128;
            r3 = r3 % 2;
            r0 = (id.dana.animation.HomeTabActivity) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0036, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void n() {
            /*
                Method dump skipped, instructions count: 225
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.n():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v5 */
        private final void r() {
            String stringExtra;
            try {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 73;
                N = i % 128;
                if (i % 2 != 0) {
                    boolean z = getActivity() instanceof HomeTabActivity;
                    int length = r2.length;
                    if (!z) {
                        return;
                    }
                } else if (!(getActivity() instanceof HomeTabActivity)) {
                    return;
                }
                FragmentActivity activity = getActivity();
                Intent intent = !(activity == null) ? activity.getIntent() : null;
                if ((intent != null ? Typography.greater : 'Y') != '>') {
                    stringExtra = null;
                } else {
                    try {
                        stringExtra = intent.getStringExtra(HomeTabActivity.EXTRA_SHOP_ID);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                String stringExtra2 = intent != null ? intent.getStringExtra("source") : null;
                r2 = intent != null ? Boolean.valueOf(intent.getBooleanExtra(HomeTabActivity.EXTRA_IGNORE_DISMISS_RULE, false)) : 0;
                if ((intent != null ? 'I' : (char) 0) == 'I') {
                    int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
                    N = i2 % 128;
                    if (i2 % 2 != 0) {
                        intent.removeExtra(HomeTabActivity.EXTRA_SHOP_ID);
                        int i3 = 52 / 0;
                    } else {
                        intent.removeExtra(HomeTabActivity.EXTRA_SHOP_ID);
                    }
                }
                if (intent != null) {
                    intent.removeExtra("source");
                }
                if (intent != null) {
                    intent.removeExtra(HomeTabActivity.EXTRA_IGNORE_DISMISS_RULE);
                }
                if (stringExtra != null) {
                    PlaceComponentResult(stringExtra2, stringExtra, r2);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0011, code lost:
        
            if (r3 != null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x001f, code lost:
        
            if ((r3 != null ? 4 : 28) != 4) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0024, code lost:
        
            if (r4 == null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0026, code lost:
        
            r1 = 'I';
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0029, code lost:
        
            r1 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x002b, code lost:
        
            if (r1 == 'I') goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x002e, code lost:
        
            if (r5 == null) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0032, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0036, code lost:
        
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x003a, code lost:
        
            verifyNotNull().get().PlaceComponentResult(r3, r4, r5.booleanValue());
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x004b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x004c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x004d, code lost:
        
            throw r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x004e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
        
            throw r3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void PlaceComponentResult(java.lang.String r3, java.lang.String r4, java.lang.Boolean r5) {
            /*
                r2 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 27
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                if (r0 != 0) goto Le
                r0 = 0
                goto Lf
            Le:
                r0 = 1
            Lf:
                if (r0 == 0) goto L14
                if (r3 == 0) goto L50
                goto L22
            L14:
                r0 = 0
                r0.hashCode()     // Catch: java.lang.Throwable -> L54
                r0 = 4
                if (r3 == 0) goto L1d
                r1 = 4
                goto L1f
            L1d:
                r1 = 28
            L1f:
                if (r1 == r0) goto L22
                goto L50
            L22:
                r0 = 73
                if (r4 == 0) goto L29
                r1 = 73
                goto L2b
            L29:
                r1 = 32
            L2b:
                if (r1 == r0) goto L2e
                goto L50
            L2e:
                if (r5 == 0) goto L50
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L4e
                int r0 = r0 + 9
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1     // Catch: java.lang.Exception -> L4c
                int r0 = r0 % 2
                dagger.Lazy r0 = r2.verifyNotNull()
                java.lang.Object r0 = r0.get()
                id.dana.contract.homeinfo.HomeInfoContract$Presenter r0 = (id.dana.contract.homeinfo.HomeInfoContract.Presenter) r0
                boolean r5 = r5.booleanValue()
                r0.PlaceComponentResult(r3, r4, r5)
                return
            L4c:
                r3 = move-exception
                throw r3
            L4e:
                r3 = move-exception
                throw r3
            L50:
                r2.h()
                return
            L54:
                r3 = move-exception
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.PlaceComponentResult(java.lang.String, java.lang.String, java.lang.Boolean):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x003e  */
        @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onResume() {
            /*
                r4 = this;
                super.onResume()
                r4.SubSequence()
                id.dana.base.BaseActivity r0 = r4.getBaseActivity()
                boolean r1 = r0 instanceof id.dana.animation.HomeTabActivity
                if (r1 == 0) goto L1d
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r1 = r1 + 121
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r1 = r1 % 2
                id.dana.home.HomeTabActivity r0 = (id.dana.animation.HomeTabActivity) r0     // Catch: java.lang.Exception -> L1b
                goto L1e
            L1b:
                r0 = move-exception
                throw r0
            L1d:
                r0 = 0
            L1e:
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L2d
                boolean r0 = r0.getIsFinishCheckSession()     // Catch: java.lang.Exception -> L2b
                if (r0 == r2) goto L29
                goto L2d
            L29:
                r0 = 1
                goto L38
            L2b:
                r0 = move-exception
                throw r0
            L2d:
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 25
                int r3 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
                int r0 = r0 % 2
                r0 = 0
            L38:
                if (r0 == 0) goto L3b
                goto L3c
            L3b:
                r1 = 1
            L3c:
                if (r1 == r2) goto L4b
                r4.connectForeground()
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 43
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
            L4b:
                r4.getValueOfTouchPositionAbsolute()
                r4.z()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.onResume():void");
        }

        public final void whenAvailable() {
            try {
                int i = N + 115;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                try {
                    this.C = true;
                    int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
                    N = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x001e, code lost:
        
            if ((r0 != null ? 'L' : 2) != 'L') goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0032, code lost:
        
            if ((r0 != null ? '_' : 'P') != '_') goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0035, code lost:
        
            r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 125;
            id.dana.animation.HomeRecycleFragment.N = r2 % 128;
            r2 = r2 % 2;
            r0 = r0.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0042, code lost:
        
            if (r0 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0044, code lost:
        
            r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0047, code lost:
        
            r3 = ',';
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0049, code lost:
        
            if (r3 == 26) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x004c, code lost:
        
            r0 = r0.getViewTreeObserver();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0050, code lost:
        
            if (r0 == null) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0052, code lost:
        
            r0.addOnScrollChangedListener(new id.dana.animation.HomeRecycleFragment$$ExternalSyntheticLambda6());
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x005a, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 21;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0063, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0064, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0065, code lost:
        
            throw r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void BuiltInFictitiousFunctionClassFactory() {
            /*
                r4 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 35
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                r1 = 2
                int r0 = r0 % r1
                if (r0 != 0) goto L23
                androidx.viewbinding.ViewBinding r0 = r4.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
                r2 = 0
                r2.hashCode()     // Catch: java.lang.Throwable -> L21
                r2 = 76
                if (r0 == 0) goto L1d
                r3 = 76
                goto L1e
            L1d:
                r3 = 2
            L1e:
                if (r3 == r2) goto L35
                goto L5a
            L21:
                r0 = move-exception
                throw r0
            L23:
                androidx.viewbinding.ViewBinding r0 = r4.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
                r2 = 95
                if (r0 == 0) goto L30
                r3 = 95
                goto L32
            L30:
                r3 = 80
            L32:
                if (r3 == r2) goto L35
                goto L5a
            L35:
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r2 = r2 + 125
                int r3 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r3
                int r2 = r2 % r1
                androidx.recyclerview.widget.RecyclerView r0 = r0.BuiltInFictitiousFunctionClassFactory
                r2 = 26
                if (r0 == 0) goto L47
                r3 = 26
                goto L49
            L47:
                r3 = 44
            L49:
                if (r3 == r2) goto L4c
                goto L5a
            L4c:
                android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()     // Catch: java.lang.Exception -> L64
                if (r0 == 0) goto L5a
                id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda6 r2 = new id.dana.home.HomeRecycleFragment$$ExternalSyntheticLambda6
                r2.<init>()
                r0.addOnScrollChangedListener(r2)
            L5a:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 21
                int r2 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r0 = r0 % r1
                return
            L64:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.BuiltInFictitiousFunctionClassFactory():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static final void H(id.dana.animation.HomeRecycleFragment r6) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                boolean r0 = r6.C
                r1 = 0
                r2 = 1
                if (r0 == 0) goto Ld
                r0 = 0
                goto Le
            Ld:
                r0 = 1
            Le:
                if (r0 == r2) goto L91
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 35
                int r3 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
                int r0 = r0 % 2
                androidx.viewbinding.ViewBinding r0 = r6.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
                if (r0 == 0) goto L3a
                int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r3 = r3 + 65
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r3 = r3 % 2
                androidx.recyclerview.widget.RecyclerView r0 = r0.BuiltInFictitiousFunctionClassFactory
                if (r0 == 0) goto L3a
                int r0 = r0.getScrollY()     // Catch: java.lang.Exception -> L38
                if (r0 != 0) goto L3a
                r0 = 1
                goto L3b
            L38:
                r6 = move-exception
                goto L8e
            L3a:
                r0 = 0
            L3b:
                if (r0 == 0) goto L91
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 43
                int r3 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r3
                int r0 = r0 % 2
                androidx.fragment.app.Fragment r0 = r6.getParentFragment()     // Catch: java.lang.Exception -> L8f
                boolean r3 = r0 instanceof id.dana.animation.tab.HomeTabFragment     // Catch: java.lang.Exception -> L38
                r4 = 83
                if (r3 == 0) goto L54
                r3 = 83
                goto L56
            L54:
                r3 = 59
            L56:
                r5 = 0
                if (r3 == r4) goto L5b
                r0 = r5
                goto L66
            L5b:
                int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r3 = r3 + r4
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r3 = r3 % 2
                id.dana.home.tab.HomeTabFragment r0 = (id.dana.animation.tab.HomeTabFragment) r0
            L66:
                if (r0 == 0) goto L86
                int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r3 = r3 + 77
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r3 = r3 % 2
                if (r3 == 0) goto L7f
                java.util.List r3 = r6.GetContactSyncConfig()     // Catch: java.lang.Exception -> L38
                r0.getAuthRequestContext(r3)     // Catch: java.lang.Exception -> L8f
                int r3 = r5.length     // Catch: java.lang.Throwable -> L7d
                goto L86
            L7d:
                r6 = move-exception
                throw r6
            L7f:
                java.util.List r3 = r6.GetContactSyncConfig()
                r0.getAuthRequestContext(r3)
            L86:
                r6.C = r1
                if (r0 == 0) goto L91
                r0.PlaceComponentResult(r2)
                goto L91
            L8e:
                throw r6
            L8f:
                r6 = move-exception
                throw r6
            L91:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.H(id.dana.home.HomeRecycleFragment):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:132:0x0091, code lost:
        
            if (r0 != null) goto L139;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0099, code lost:
        
            if (r0 != null) goto L139;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x009b, code lost:
        
            r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x001a, code lost:
        
            if ((r0 instanceof id.dana.animation.HomeTabActivity) != false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0026, code lost:
        
            if (r4 != false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0028, code lost:
        
            r0 = (id.dana.animation.HomeTabActivity) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x002b, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x0078  */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v2, types: [id.dana.social.view.NewSocialWidgetView] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        @Override // id.dana.base.BaseFragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onSelected() {
            /*
                r5 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 9
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L10
                r0 = 1
                goto L11
            L10:
                r0 = 0
            L11:
                r3 = 0
                if (r0 == r2) goto L1d
                id.dana.base.BaseActivity r0 = r5.getBaseActivity()
                boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity
                if (r4 == 0) goto L2b
                goto L28
            L1d:
                id.dana.base.BaseActivity r0 = r5.getBaseActivity()
                boolean r4 = r0 instanceof id.dana.animation.HomeTabActivity
                r3.hashCode()     // Catch: java.lang.Throwable -> Lb0
                if (r4 == 0) goto L2b
            L28:
                id.dana.home.HomeTabActivity r0 = (id.dana.animation.HomeTabActivity) r0
                goto L2c
            L2b:
                r0 = r3
            L2c:
                if (r0 == 0) goto L39
                boolean r0 = r0.getIsFinishCheckSession()     // Catch: java.lang.Exception -> L37
                if (r0 == r2) goto L35
                goto L39
            L35:
                r0 = 1
                goto L3a
            L37:
                r0 = move-exception
                goto L67
            L39:
                r0 = 0
            L3a:
                if (r0 == 0) goto L6a
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 117
                int r4 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
                int r0 = r0 % 2
                if (r0 != 0) goto L59
                dagger.Lazy r0 = r5.JsonParseException()
                java.lang.Object r0 = r0.get()
                id.dana.contract.inbox.UnreadInboxContract$Presenter r0 = (id.dana.contract.inbox.UnreadInboxContract.Presenter) r0
                r0.getAuthRequestContext()
                int r0 = r3.length     // Catch: java.lang.Throwable -> L57
                goto L6a
            L57:
                r0 = move-exception
                throw r0
            L59:
                dagger.Lazy r0 = r5.JsonParseException()     // Catch: java.lang.Exception -> L68
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L37
                id.dana.contract.inbox.UnreadInboxContract$Presenter r0 = (id.dana.contract.inbox.UnreadInboxContract.Presenter) r0     // Catch: java.lang.Exception -> L68
                r0.getAuthRequestContext()     // Catch: java.lang.Exception -> L68
                goto L6a
            L67:
                throw r0
            L68:
                r0 = move-exception
                goto L96
            L6a:
                boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda5
                r4 = 29
                if (r0 == 0) goto L73
                r0 = 29
                goto L75
            L73:
                r0 = 14
            L75:
                if (r0 == r4) goto L78
                goto Lac
            L78:
                id.dana.home.adapter.HomeAdapter$SocialWidgetHolder r0 = r5.U()
                if (r0 == 0) goto L7f
                goto L80
            L7f:
                r1 = 1
            L80:
                if (r1 == r2) goto L9d
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r1 = r1 + 5
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r1 = r1 % 2
                if (r1 == 0) goto L97
                id.dana.databinding.ViewItemSocialWidgetBinding r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L68
                int r1 = r3.length     // Catch: java.lang.Throwable -> L94
                if (r0 == 0) goto L9d
                goto L9b
            L94:
                r0 = move-exception
                throw r0
            L96:
                throw r0
            L97:
                id.dana.databinding.ViewItemSocialWidgetBinding r0 = r0.getAuthRequestContext
                if (r0 == 0) goto L9d
            L9b:
                id.dana.social.view.NewSocialWidgetView r3 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            L9d:
                if (r3 == 0) goto Lac
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 121
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r3.onTabSwipeResume()
            Lac:
                super.onSelected()
                return
            Lb0:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.onSelected():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0074, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0075, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0076, code lost:
        
            super.onUnSelected();
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0079, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0015, code lost:
        
            if (r0 != false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0025, code lost:
        
            if ((!r5.NetworkUserEntityData$$ExternalSyntheticLambda5) != true) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0027, code lost:
        
            r0 = U();
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x002d, code lost:
        
            if (r0 == null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x002f, code lost:
        
            r3 = kotlin.text.Typography.dollar;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0032, code lost:
        
            r3 = 'J';
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0034, code lost:
        
            if (r3 == '$') goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0037, code lost:
        
            r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 21;
            id.dana.animation.HomeRecycleFragment.N = r2 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0042, code lost:
        
            if ((r2 % 2) == 0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0044, code lost:
        
            r0 = r0.getAuthRequestContext;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0046, code lost:
        
            r2 = r1.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0047, code lost:
        
            if (r0 == null) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x004c, code lost:
        
            r0 = r0.getAuthRequestContext;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x004e, code lost:
        
            if (r0 == null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0050, code lost:
        
            r2 = 21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0053, code lost:
        
            r2 = 'K';
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0055, code lost:
        
            if (r2 == 21) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0058, code lost:
        
            r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x005a, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.N + 61;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0064, code lost:
        
            if (r1 == 0) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0066, code lost:
        
            r1.onUnselected();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0069, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.N + 47;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v4, types: [id.dana.social.view.NewSocialWidgetView] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        @Override // id.dana.base.BaseFragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onUnSelected() {
            /*
                r5 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 89
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 0
                if (r0 != 0) goto L1a
                r5.getOnBoardingScenario()
                boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda5
                r1.hashCode()     // Catch: java.lang.Throwable -> L18
                if (r0 == 0) goto L76
                goto L27
            L18:
                r0 = move-exception
                throw r0
            L1a:
                r5.getOnBoardingScenario()
                boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda5     // Catch: java.lang.Exception -> L7a
                r2 = 1
                if (r0 == 0) goto L24
                r0 = 0
                goto L25
            L24:
                r0 = 1
            L25:
                if (r0 == r2) goto L76
            L27:
                id.dana.home.adapter.HomeAdapter$SocialWidgetHolder r0 = r5.U()
                r2 = 36
                if (r0 == 0) goto L32
                r3 = 36
                goto L34
            L32:
                r3 = 74
            L34:
                if (r3 == r2) goto L37
                goto L64
            L37:
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                r3 = 21
                int r2 = r2 + r3
                int r4 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r2 = r2 % 2
                if (r2 == 0) goto L4c
                id.dana.databinding.ViewItemSocialWidgetBinding r0 = r0.getAuthRequestContext
                int r2 = r1.length     // Catch: java.lang.Throwable -> L4a
                if (r0 == 0) goto L64
                goto L58
            L4a:
                r0 = move-exception
                throw r0
            L4c:
                id.dana.databinding.ViewItemSocialWidgetBinding r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L74
                if (r0 == 0) goto L53
                r2 = 21
                goto L55
            L53:
                r2 = 75
            L55:
                if (r2 == r3) goto L58
                goto L64
            L58:
                id.dana.social.view.NewSocialWidgetView r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L7a
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 61
                int r2 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2
                int r0 = r0 % 2
            L64:
                if (r1 == 0) goto L76
                r1.onUnselected()
                int r0 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L7a
                int r0 = r0 + 47
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L7a
                int r0 = r0 % 2
                goto L76
            L74:
                r0 = move-exception
                throw r0
            L76:
                super.onUnSelected()
                return
            L7a:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.onUnSelected():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x004e, code lost:
        
            r5 = 'M';
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0050, code lost:
        
            if (r5 == 'M') goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0052, code lost:
        
            r0 = r0.getText();
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0058, code lost:
        
            if (r0 == null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x005a, code lost:
        
            r5 = '\n';
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x005d, code lost:
        
            r5 = 15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x005f, code lost:
        
            if (r5 == 15) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x0065, code lost:
        
            if (r0.length() <= 0) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0067, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 71;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0073, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0074, code lost:
        
            if (r0 != true) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0076, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 91;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0080, code lost:
        
            if ((r0 % 2) == 0) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0082, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x0084, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x0085, code lost:
        
            if (r0 == false) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x0088, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x008a, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x001b, code lost:
        
            if ((r0 == null) != false) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0027, code lost:
        
            if (r0 != null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0029, code lost:
        
            r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x002b, code lost:
        
            if (r0 == null) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x002d, code lost:
        
            r4 = id.dana.animation.HomeRecycleFragment.N + 113;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4 % 128;
            r4 = r4 % 2;
            r0 = r0.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x003b, code lost:
        
            if (r0 == null) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x003d, code lost:
        
            r5 = '5';
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0040, code lost:
        
            r5 = 'I';
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0042, code lost:
        
            if (r5 == '5') goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0045, code lost:
        
            r0 = r0.MyBillsEntityDataFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0049, code lost:
        
            if (r0 == null) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x004b, code lost:
        
            r5 = '2';
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void getOnBoardingScenario() {
            /*
                Method dump skipped, instructions count: 200
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.getOnBoardingScenario():void");
        }

        @Override // androidx.fragment.app.Fragment
        public final void onActivityResult(int p0, int p1, Intent p2) {
            HomeAdapter homeAdapter;
            int i = N + 113;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (i % 2 == 0) {
                int i2 = 49 / 0;
                if ((p2 != null ? '8' : 'T') == 'T') {
                    return;
                }
            } else {
                if ((p2 != null ? 'B' : '\\') == '\\') {
                    return;
                }
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 9;
            N = i3 % 128;
            int i4 = i3 % 2;
            if (100 == p0) {
                try {
                    int i5 = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
                    N = i5 % 128;
                    if (i5 % 2 != 0) {
                        homeAdapter = this.GetContactSyncConfig;
                        Object obj = null;
                        obj.hashCode();
                        if ((homeAdapter == null ? 'V' : 'T') == 'V') {
                            return;
                        }
                    } else {
                        homeAdapter = this.GetContactSyncConfig;
                        if (homeAdapter == null) {
                            return;
                        }
                    }
                    homeAdapter.moveToNextValue = Integer.valueOf(p1);
                    int i6 = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
                    N = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }

        private final void QrExpiredActivity() {
            int i = N + 55;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 == 0)) {
                DanaAppShortcut.Companion companion = DanaAppShortcut.INSTANCE;
                Context applicationContext = getBaseActivity().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                DanaAppShortcut.Companion.KClassImpl$Data$declaredNonStaticMembers$2(applicationContext);
                return;
            }
            DanaAppShortcut.Companion companion2 = DanaAppShortcut.INSTANCE;
            Context applicationContext2 = getBaseActivity().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "");
            DanaAppShortcut.Companion.KClassImpl$Data$declaredNonStaticMembers$2(applicationContext2);
            Object obj = null;
            obj.hashCode();
        }

        /* JADX WARN: Removed duplicated region for block: B:176:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void SizeSelectors$OrSelector() {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.SizeSelectors$OrSelector():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x005b, code lost:
        
            r0 = getParentFragment();
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0061, code lost:
        
            if ((r0 instanceof id.dana.animation.tab.HomeTabFragment) == false) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0063, code lost:
        
            r1 = (id.dana.animation.tab.HomeTabFragment) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0066, code lost:
        
            if (r1 == 0) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0068, code lost:
        
            r1.getAuthRequestContext(0, id.dana.analytics.tracker.TrackerKey.SourceType.BALANCE_ARROW);
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x006d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x006e, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0012, code lost:
        
            if (r0 != false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0020, code lost:
        
            if ((r7.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String ? kotlin.text.Typography.greater : 3) != 3) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0022, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.N + 113;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x002c, code lost:
        
            if ((r0 % 2) != 0) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x002e, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0030, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0031, code lost:
        
            if (r0 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x003b, code lost:
        
            r4 = 93 / 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x003e, code lost:
        
            if ((getParentFragment() instanceof id.dana.animation.tab.HomeTabFragment) == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0040, code lost:
        
            r0 = '#';
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0043, code lost:
        
            r0 = kotlin.text.Typography.quote;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0045, code lost:
        
            if (r0 == '\"') goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x004a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x004c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x004d, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0054, code lost:
        
            if ((getParentFragment() instanceof id.dana.animation.tab.HomeTabFragment) == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0056, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0058, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0059, code lost:
        
            if (r0 == true) goto L107;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void FlowViewUtil$textChanges$2() {
            /*
                r7 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 67
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 0
                r2 = 0
                r3 = 1
                if (r0 != 0) goto L17
                boolean r0 = r7.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String
                int r4 = r1.length     // Catch: java.lang.Throwable -> L15
                if (r0 == 0) goto L6f
                goto L22
            L15:
                r0 = move-exception
                throw r0
            L17:
                boolean r0 = r7.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String
                r4 = 3
                if (r0 == 0) goto L1f
                r0 = 62
                goto L20
            L1f:
                r0 = 3
            L20:
                if (r0 == r4) goto L6f
            L22:
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 113
                int r4 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
                int r0 = r0 % 2
                if (r0 != 0) goto L30
                r0 = 1
                goto L31
            L30:
                r0 = 0
            L31:
                if (r0 == 0) goto L4e
                androidx.fragment.app.Fragment r0 = r7.getParentFragment()     // Catch: java.lang.Exception -> L4c
                boolean r0 = r0 instanceof id.dana.animation.tab.HomeTabFragment     // Catch: java.lang.Exception -> L4a
                r4 = 93
                int r4 = r4 / r2
                r4 = 34
                if (r0 == 0) goto L43
                r0 = 35
                goto L45
            L43:
                r0 = 34
            L45:
                if (r0 == r4) goto L6f
                goto L5b
            L48:
                r0 = move-exception
                throw r0
            L4a:
                r0 = move-exception
                goto L6e
            L4c:
                r0 = move-exception
                throw r0
            L4e:
                androidx.fragment.app.Fragment r0 = r7.getParentFragment()
                boolean r0 = r0 instanceof id.dana.animation.tab.HomeTabFragment
                if (r0 == 0) goto L58
                r0 = 0
                goto L59
            L58:
                r0 = 1
            L59:
                if (r0 == r3) goto L6f
            L5b:
                androidx.fragment.app.Fragment r0 = r7.getParentFragment()
                boolean r3 = r0 instanceof id.dana.animation.tab.HomeTabFragment
                if (r3 == 0) goto L66
                r1 = r0
                id.dana.home.tab.HomeTabFragment r1 = (id.dana.animation.tab.HomeTabFragment) r1
            L66:
                if (r1 == 0) goto L94
                java.lang.String r0 = "Balance Arrow"
                r1.getAuthRequestContext(r2, r0)     // Catch: java.lang.Exception -> L4a
                return
            L6e:
                throw r0
            L6f:
                android.content.Intent r0 = new android.content.Intent
                androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
                android.content.Context r1 = (android.content.Context) r1
                byte[] r4 = id.dana.animation.HomeRecycleFragment.$$a
                r5 = 19
                r4 = r4[r5]
                int r4 = r4 + r3
                byte r4 = (byte) r4
                byte r5 = (byte) r4
                byte r6 = (byte) r5
                java.lang.Object[] r3 = new java.lang.Object[r3]
                ac(r4, r5, r6, r3)
                r2 = r3[r2]
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Class r2 = java.lang.Class.forName(r2)
                r0.<init>(r1, r2)
                r7.startActivity(r0)
            L94:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.FlowViewUtil$textChanges$2():void");
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public final void onRefreshBegin(PtrFrameLayout p0) {
            LoadingLottieAnimationView loadingLottieAnimationView = this.A;
            if (loadingLottieAnimationView != null) {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
                N = i % 128;
                int i2 = i % 2;
                loadingLottieAnimationView.playAnimation();
            }
            u();
            int i3 = N + 113;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        }

        private static FragmentHomeRecycleBinding MyBillsEntityDataFactory(View p0) {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 109;
            N = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(p0, "");
            FragmentHomeRecycleBinding PlaceComponentResult = FragmentHomeRecycleBinding.PlaceComponentResult(p0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 123;
            N = i3 % 128;
            if (i3 % 2 == 0) {
                return PlaceComponentResult;
            }
            Object obj = null;
            obj.hashCode();
            return PlaceComponentResult;
        }

        @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker
        public final void PlaceComponentResult(TimerEvent p0, long p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
            builder.MyBillsEntityDataFactory = p0.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory("Ready in Milliseconds", p1).BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INITIAL_LOAD, p0.getBuiltInFictitiousFunctionClassFactory());
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
            try {
                int i = N + 59;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                if (!(i % 2 == 0)) {
                    return;
                }
                int i2 = 72 / 0;
            } catch (Exception e) {
                throw e;
            }
        }

        private final void g() {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 21;
            N = i % 128;
            if (!(i % 2 == 0)) {
                NetworkUserEntityData$$ExternalSyntheticLambda1().get().getErrorConfigVersion();
                int i2 = 57 / 0;
            } else {
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda1().get().getErrorConfigVersion();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
            N = i3 % 128;
            if ((i3 % 2 != 0 ? 'L' : 'X') != 'L') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        }

        public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            PlaceComponentResult(new Function1<HomeTrackerImpl, Unit>() { // from class: id.dana.home.HomeRecycleFragment$connectionStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(HomeTrackerImpl homeTrackerImpl) {
                    invoke2(homeTrackerImpl);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HomeTrackerImpl homeTrackerImpl) {
                    Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
                    String str = p0;
                    Intrinsics.checkNotNullParameter(str, "");
                    if (!homeTrackerImpl.MyBillsEntityDataFactory.get() || homeTrackerImpl.BuiltInFictitiousFunctionClassFactory.containsKey(TrackerDataKey.Property.CONNECTION_STATUS)) {
                        return;
                    }
                    homeTrackerImpl.BuiltInFictitiousFunctionClassFactory.put(TrackerDataKey.Property.CONNECTION_STATUS, str);
                }
            });
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 45;
            N = i % 128;
            int i2 = i % 2;
        }

        private final void PlaceComponentResult(Function1<? super HomeTrackerImpl, Unit> p0) {
            if (this.homeTracker == null) {
                return;
            }
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            N = i % 128;
            if ((i % 2 != 0 ? 'K' : 'T') != 'K') {
                HomeTrackerImpl homeTrackerImpl = OtpRegistrationPresenter$input$1().get();
                Intrinsics.checkNotNullExpressionValue(homeTrackerImpl, "");
                p0.invoke(homeTrackerImpl);
            } else {
                HomeTrackerImpl homeTrackerImpl2 = OtpRegistrationPresenter$input$1().get();
                Intrinsics.checkNotNullExpressionValue(homeTrackerImpl2, "");
                p0.invoke(homeTrackerImpl2);
                Object[] objArr = null;
                int length = objArr.length;
            }
            try {
                int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
                N = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x004d A[Catch: Exception -> 0x002c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x002c, blocks: (B:51:0x0017, B:70:0x004d), top: B:83:0x0017 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0061 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.util.List<id.dana.showcase.target.Target> GetContactSyncConfig() {
            /*
                r4 = this;
                androidx.viewbinding.ViewBinding r0 = r4.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0
                r1 = 0
                if (r0 == 0) goto L30
                int r2 = id.dana.animation.HomeRecycleFragment.N
                int r2 = r2 + 21
                int r3 = r2 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
                int r2 = r2 % 2
                androidx.recyclerview.widget.RecyclerView r0 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L2e
                if (r0 == 0) goto L30
                id.dana.home.adapter.HomeAdapter$HomeWidget r2 = id.dana.home.adapter.HomeAdapter.HomeWidget.FOUR_KINGS     // Catch: java.lang.Exception -> L2c
                int r2 = r2.getIndex()     // Catch: java.lang.Exception -> L2c
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.findViewHolderForAdapterPosition(r2)     // Catch: java.lang.Exception -> L2c
                int r2 = id.dana.animation.HomeRecycleFragment.N
                int r2 = r2 + 47
                int r3 = r2 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3
                int r2 = r2 % 2
                goto L31
            L2c:
                r0 = move-exception
                goto L60
            L2e:
                r0 = move-exception
                throw r0
            L30:
                r0 = r1
            L31:
                boolean r2 = r0 instanceof id.dana.home.adapter.HomeAdapter.FourKingViewHolder
                r3 = 69
                if (r2 == 0) goto L3a
                r2 = 69
                goto L3c
            L3a:
                r2 = 10
            L3c:
                if (r2 == r3) goto L40
                r0 = r1
                goto L42
            L40:
                id.dana.home.adapter.HomeAdapter$FourKingViewHolder r0 = (id.dana.home.adapter.HomeAdapter.FourKingViewHolder) r0
            L42:
                r2 = 22
                if (r0 == 0) goto L49
                r3 = 28
                goto L4b
            L49:
                r3 = 22
            L4b:
                if (r3 == r2) goto L61
                id.dana.databinding.ViewItemFourKingBinding r0 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L2c
                if (r0 == 0) goto L53
                r2 = 0
                goto L54
            L53:
                r2 = 1
            L54:
                if (r2 == 0) goto L57
                goto L61
            L57:
                id.dana.home.view.FourKingView r0 = r0.PlaceComponentResult
                if (r0 == 0) goto L61
                java.util.List r1 = r0.getHomeTooltipTarget()
                goto L61
            L60:
                throw r0
            L61:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.GetContactSyncConfig():java.util.List");
        }

        /* JADX WARN: Code restructure failed: missing block: B:226:0x00c5, code lost:
        
            if (r3 != null) goto L232;
         */
        /* JADX WARN: Code restructure failed: missing block: B:231:0x00cc, code lost:
        
            if (r3 != null) goto L232;
         */
        /* JADX WARN: Code restructure failed: missing block: B:232:0x00ce, code lost:
        
            r3.refreshView();
         */
        /* JADX WARN: Code restructure failed: missing block: B:284:0x0171, code lost:
        
            if (r3 != null) goto L290;
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:0x0178, code lost:
        
            if (r3 != null) goto L290;
         */
        /* JADX WARN: Code restructure failed: missing block: B:290:0x017a, code lost:
        
            r3.refreshContent();
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:251:0x0102  */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void u() {
            /*
                Method dump skipped, instructions count: 497
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.u():void");
        }

        private static int MyBillsEntityDataFactory(int p0) {
            boolean z;
            Iterator<HomeViewWidgetModel> it = b().iterator();
            int i = 0;
            while (it.hasNext()) {
                try {
                    if ((it.next().MyBillsEntityDataFactory.getIndex() == p0 ? '7' : '_') != '_') {
                        int i2 = SummaryVoucherView$$ExternalSyntheticLambda1 + 65;
                        N = i2 % 128;
                        int i3 = i2 % 2;
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((!z ? 'R' : '3') == '3') {
                        return i;
                    }
                    int i4 = SummaryVoucherView$$ExternalSyntheticLambda1 + 49;
                    N = i4 % 128;
                    i = i4 % 2 != 0 ? i + 54 : i + 1;
                } catch (Exception e) {
                    throw e;
                }
            }
            return -1;
        }

        private final void connectForeground() {
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 75;
            N = i % 128;
            int i2 = i % 2;
            onDecodeSuccess().get().getAuthRequestContext();
            int i3 = N + 3;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x001d, code lost:
        
            if (r1 != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0028, code lost:
        
            if ((r0 instanceof id.dana.animation.HomeTabActivity) != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x002a, code lost:
        
            r2 = (id.dana.animation.HomeTabActivity) r0;
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void shouldRecycleViewType() {
            /*
                r3 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 59
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r1 = 5
                if (r0 == 0) goto L10
                r0 = 48
                goto L11
            L10:
                r0 = 5
            L11:
                r2 = 0
                if (r0 == r1) goto L22
                androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
                boolean r1 = r0 instanceof id.dana.animation.HomeTabActivity
                r2.hashCode()     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L37
                goto L2a
            L20:
                r0 = move-exception
                throw r0
            L22:
                androidx.fragment.app.FragmentActivity r0 = r3.getActivity()     // Catch: java.lang.Exception -> L4f
                boolean r1 = r0 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> L4d
                if (r1 == 0) goto L37
            L2a:
                r2 = r0
                id.dana.home.HomeTabActivity r2 = (id.dana.animation.HomeTabActivity) r2
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 105
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
            L37:
                r0 = 1
                if (r2 == 0) goto L3c
                r1 = 0
                goto L3d
            L3c:
                r1 = 1
            L3d:
                if (r1 == r0) goto L4c
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 51
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r2.getUserCohort()
            L4c:
                return
            L4d:
                r0 = move-exception
                throw r0
            L4f:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.shouldRecycleViewType():void");
        }

        private final HomeAdapter.NearbyViewHolder S() {
            RecyclerView.ViewHolder viewHolder;
            RecyclerView recyclerView;
            FragmentHomeRecycleBinding fragmentHomeRecycleBinding = (FragmentHomeRecycleBinding) getBinding();
            HomeAdapter.NearbyViewHolder nearbyViewHolder = null;
            if ((fragmentHomeRecycleBinding != null ? '?' : 'a') == '?' && (recyclerView = fragmentHomeRecycleBinding.BuiltInFictitiousFunctionClassFactory) != null) {
                try {
                    viewHolder = recyclerView.findViewHolderForAdapterPosition(HomeAdapter.HomeWidget.NEARBY_ME.getIndex());
                } catch (Exception e) {
                    throw e;
                }
            } else {
                viewHolder = null;
            }
            try {
                if ((viewHolder instanceof HomeAdapter.NearbyViewHolder ? 'J' : (char) 6) != 6) {
                    int i = N + 47;
                    SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
                    nearbyViewHolder = viewHolder;
                    if (i % 2 == 0) {
                        int i2 = 37 / 0;
                    }
                }
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 121;
                N = i3 % 128;
                int i4 = i3 % 2;
                return nearbyViewHolder;
            } catch (Exception e2) {
                throw e2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x001e, code lost:
        
            if (r0 != null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0023, code lost:
        
            if (r0 != null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0025, code lost:
        
            r0 = r0.findViewHolderForAdapterPosition(id.dana.home.adapter.HomeAdapter.HomeWidget.PROMO_BANNER.getIndex());
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0041  */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final id.dana.home.adapter.HomeAdapter.PromoViewHolder SummaryVoucherView$$ExternalSyntheticLambda2() {
            /*
                r4 = this;
                androidx.viewbinding.ViewBinding r0 = r4.getBinding()     // Catch: java.lang.Exception -> L5a
                id.dana.databinding.FragmentHomeRecycleBinding r0 = (id.dana.databinding.FragmentHomeRecycleBinding) r0     // Catch: java.lang.Exception -> L5a
                r1 = 1
                if (r0 == 0) goto Lb
                r2 = 0
                goto Lc
            Lb:
                r2 = 1
            Lc:
                r3 = 0
                if (r2 == r1) goto L32
                int r1 = id.dana.animation.HomeRecycleFragment.N     // Catch: java.lang.Exception -> L30
                int r1 = r1 + 47
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r2     // Catch: java.lang.Exception -> L30
                int r1 = r1 % 2
                androidx.recyclerview.widget.RecyclerView r0 = r0.BuiltInFictitiousFunctionClassFactory
                if (r1 != 0) goto L23
                int r1 = r3.length     // Catch: java.lang.Throwable -> L21
                if (r0 == 0) goto L32
                goto L25
            L21:
                r0 = move-exception
                throw r0
            L23:
                if (r0 == 0) goto L32
            L25:
                id.dana.home.adapter.HomeAdapter$HomeWidget r1 = id.dana.home.adapter.HomeAdapter.HomeWidget.PROMO_BANNER
                int r1 = r1.getIndex()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.findViewHolderForAdapterPosition(r1)
                goto L3d
            L30:
                r0 = move-exception
                goto L59
            L32:
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 93
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r0 = r3
            L3d:
                boolean r1 = r0 instanceof id.dana.home.adapter.HomeAdapter.PromoViewHolder     // Catch: java.lang.Exception -> L30
                if (r1 == 0) goto L4e
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r1 = r1 + 103
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r1 = r1 % 2
                r3 = r0
                id.dana.home.adapter.HomeAdapter$PromoViewHolder r3 = (id.dana.home.adapter.HomeAdapter.PromoViewHolder) r3
            L4e:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 107
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                return r3
            L59:
                throw r0
            L5a:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda2():id.dana.home.adapter.HomeAdapter$PromoViewHolder");
        }

        /* JADX WARN: Code restructure failed: missing block: B:173:0x002f, code lost:
        
            if (r4 != null) goto L179;
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x003c, code lost:
        
            if (r4 != null) goto L179;
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x003e, code lost:
        
            r4 = r4.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0040, code lost:
        
            if (r4 == null) goto L182;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0042, code lost:
        
            r0 = r4.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x004b, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x004e, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.NearbyViewHolder) != false) goto L186;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0050, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x0052, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0053, code lost:
        
            if (r4 == true) goto L189;
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x0055, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0056, code lost:
        
            r0 = (id.dana.home.adapter.HomeAdapter.NearbyViewHolder) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x0058, code lost:
        
            if (r0 == null) goto L199;
         */
        /* JADX WARN: Code restructure failed: missing block: B:191:0x005a, code lost:
        
            r0 = r0.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:192:0x005e, code lost:
        
            if (r0 == null) goto L194;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0060, code lost:
        
            r5 = 'M';
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x0063, code lost:
        
            r5 = '6';
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x0065, code lost:
        
            if (r5 == '6') goto L199;
         */
        /* JADX WARN: Code restructure failed: missing block: B:196:0x0067, code lost:
        
            r0 = r0.PlaceComponentResult;
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x0069, code lost:
        
            if (r0 == null) goto L199;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x006b, code lost:
        
            r0.disposeByActivity();
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x006e, code lost:
        
            r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.PROMO_BANNER;
            r4 = (id.dana.databinding.FragmentHomeRecycleBinding) getBinding();
         */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x0076, code lost:
        
            if (r4 == null) goto L204;
         */
        /* JADX WARN: Code restructure failed: missing block: B:201:0x0078, code lost:
        
            r5 = id.dana.animation.HomeRecycleFragment.N + 119;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5 % 128;
            r5 = r5 % 2;
            r4 = r4.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:202:0x0084, code lost:
        
            if (r4 == null) goto L204;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0086, code lost:
        
            r5 = id.dana.animation.HomeRecycleFragment.N + 87;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r5 % 128;
            r5 = r5 % 2;
            r0 = r4.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x0099, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:206:0x009c, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.PromoViewHolder) != false) goto L208;
         */
        /* JADX WARN: Code restructure failed: missing block: B:207:0x009e, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x009f, code lost:
        
            r0 = (id.dana.home.adapter.HomeAdapter.PromoViewHolder) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x00a1, code lost:
        
            if (r0 == null) goto L211;
         */
        /* JADX WARN: Code restructure failed: missing block: B:210:0x00a3, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:211:0x00a5, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:0x00a6, code lost:
        
            if (r4 == true) goto L214;
         */
        /* JADX WARN: Code restructure failed: missing block: B:214:0x00a9, code lost:
        
            r0 = r0.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:215:0x00ab, code lost:
        
            if (r0 == null) goto L219;
         */
        /* JADX WARN: Code restructure failed: missing block: B:216:0x00ad, code lost:
        
            r0 = r0.PlaceComponentResult;
         */
        /* JADX WARN: Code restructure failed: missing block: B:217:0x00af, code lost:
        
            if (r0 == null) goto L219;
         */
        /* JADX WARN: Code restructure failed: missing block: B:218:0x00b1, code lost:
        
            r0.disposeByActivity();
            r0 = id.dana.animation.HomeRecycleFragment.N + 21;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:219:0x00be, code lost:
        
            r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.PROMO_CENTER;
            r4 = (id.dana.databinding.FragmentHomeRecycleBinding) getBinding();
         */
        /* JADX WARN: Code restructure failed: missing block: B:220:0x00c6, code lost:
        
            if (r4 == null) goto L231;
         */
        /* JADX WARN: Code restructure failed: missing block: B:221:0x00c8, code lost:
        
            r4 = r4.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:222:0x00cc, code lost:
        
            if (r4 == null) goto L224;
         */
        /* JADX WARN: Code restructure failed: missing block: B:223:0x00ce, code lost:
        
            r6 = '\\';
         */
        /* JADX WARN: Code restructure failed: missing block: B:224:0x00d1, code lost:
        
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:225:0x00d2, code lost:
        
            if (r6 == '\\') goto L314;
         */
        /* JADX WARN: Code restructure failed: missing block: B:227:0x00d5, code lost:
        
            r0 = r4.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:229:0x00de, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:231:0x00e1, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:233:0x00e4, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.PromoCenterViewHolder) != false) goto L235;
         */
        /* JADX WARN: Code restructure failed: missing block: B:234:0x00e6, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:235:0x00e7, code lost:
        
            r0 = (id.dana.home.adapter.HomeAdapter.PromoCenterViewHolder) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:236:0x00e9, code lost:
        
            if (r0 == null) goto L312;
         */
        /* JADX WARN: Code restructure failed: missing block: B:237:0x00eb, code lost:
        
            r0 = r0.PlaceComponentResult;
         */
        /* JADX WARN: Code restructure failed: missing block: B:238:0x00ed, code lost:
        
            if (r0 == null) goto L312;
         */
        /* JADX WARN: Code restructure failed: missing block: B:239:0x00ef, code lost:
        
            r0 = r0.getAuthRequestContext;
         */
        /* JADX WARN: Code restructure failed: missing block: B:240:0x00f1, code lost:
        
            if (r0 == null) goto L312;
         */
        /* JADX WARN: Code restructure failed: missing block: B:241:0x00f3, code lost:
        
            r4 = id.dana.animation.HomeRecycleFragment.N + 57;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4 % 128;
            r4 = r4 % 2;
            r0.disposeByActivity();
         */
        /* JADX WARN: Code restructure failed: missing block: B:242:0x0100, code lost:
        
            r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.PERSONALIZED_BACKGROUND;
         */
        /* JADX WARN: Code restructure failed: missing block: B:243:0x0106, code lost:
        
            r4 = (id.dana.databinding.FragmentHomeRecycleBinding) getBinding();
         */
        /* JADX WARN: Code restructure failed: missing block: B:244:0x0108, code lost:
        
            if (r4 == null) goto L262;
         */
        /* JADX WARN: Code restructure failed: missing block: B:245:0x010a, code lost:
        
            r4 = r4.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:246:0x010e, code lost:
        
            if (r4 == null) goto L248;
         */
        /* JADX WARN: Code restructure failed: missing block: B:247:0x0110, code lost:
        
            r6 = '=';
         */
        /* JADX WARN: Code restructure failed: missing block: B:248:0x0113, code lost:
        
            r6 = ')';
         */
        /* JADX WARN: Code restructure failed: missing block: B:249:0x0115, code lost:
        
            if (r6 == '=') goto L251;
         */
        /* JADX WARN: Code restructure failed: missing block: B:251:0x0118, code lost:
        
            r5 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 83;
            id.dana.animation.HomeRecycleFragment.N = r5 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:252:0x0124, code lost:
        
            if ((r5 % 2) == 0) goto L254;
         */
        /* JADX WARN: Code restructure failed: missing block: B:253:0x0126, code lost:
        
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:254:0x0128, code lost:
        
            r5 = 18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:255:0x012a, code lost:
        
            if (r5 == 18) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:256:0x012c, code lost:
        
            r0 = r4.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:257:0x0134, code lost:
        
            r3.hashCode();
         */
        /* JADX WARN: Code restructure failed: missing block: B:261:0x013a, code lost:
        
            r0 = r4.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:262:0x0143, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:264:0x0146, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.HomePersonalizationViewHolder) != false) goto L266;
         */
        /* JADX WARN: Code restructure failed: missing block: B:265:0x0148, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:266:0x014a, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:267:0x014b, code lost:
        
            if (r4 == true) goto L269;
         */
        /* JADX WARN: Code restructure failed: missing block: B:269:0x014e, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:270:0x014f, code lost:
        
            r0 = (id.dana.home.adapter.HomeAdapter.HomePersonalizationViewHolder) r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:271:0x0151, code lost:
        
            if (r0 == null) goto L288;
         */
        /* JADX WARN: Code restructure failed: missing block: B:272:0x0153, code lost:
        
            r4 = id.dana.animation.HomeRecycleFragment.N + 113;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:273:0x015d, code lost:
        
            if ((r4 % 2) != 0) goto L283;
         */
        /* JADX WARN: Code restructure failed: missing block: B:274:0x015f, code lost:
        
            r0 = r0.PlaceComponentResult;
         */
        /* JADX WARN: Code restructure failed: missing block: B:275:0x0161, code lost:
        
            r4 = r3.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:276:0x0162, code lost:
        
            if (r0 == null) goto L278;
         */
        /* JADX WARN: Code restructure failed: missing block: B:278:0x0165, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:279:0x0166, code lost:
        
            if (r1 == true) goto L288;
         */
        /* JADX WARN: Code restructure failed: missing block: B:283:0x016b, code lost:
        
            r0 = r0.PlaceComponentResult;
         */
        /* JADX WARN: Code restructure failed: missing block: B:284:0x016d, code lost:
        
            if (r0 == null) goto L288;
         */
        /* JADX WARN: Code restructure failed: missing block: B:285:0x016f, code lost:
        
            r0 = r0.getAuthRequestContext;
         */
        /* JADX WARN: Code restructure failed: missing block: B:286:0x0171, code lost:
        
            if (r0 == null) goto L288;
         */
        /* JADX WARN: Code restructure failed: missing block: B:287:0x0173, code lost:
        
            r0.disposeByActivity();
         */
        /* JADX WARN: Code restructure failed: missing block: B:288:0x0176, code lost:
        
            r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.HOME_INVESTMENT;
            r1 = (id.dana.databinding.FragmentHomeRecycleBinding) getBinding();
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:0x017e, code lost:
        
            if (r1 == null) goto L293;
         */
        /* JADX WARN: Code restructure failed: missing block: B:290:0x0180, code lost:
        
            r1 = r1.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:291:0x0182, code lost:
        
            if (r1 == null) goto L293;
         */
        /* JADX WARN: Code restructure failed: missing block: B:292:0x0184, code lost:
        
            r0 = r1.findViewHolderForAdapterPosition(r0.getIndex());
            r1 = id.dana.animation.HomeRecycleFragment.N + 71;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
            r1 = r1 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:293:0x0197, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:295:0x019a, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.HomeInvestmentViewHolder) == false) goto L297;
         */
        /* JADX WARN: Code restructure failed: missing block: B:296:0x019c, code lost:
        
            r3 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:297:0x019d, code lost:
        
            r3 = (id.dana.home.adapter.HomeAdapter.HomeInvestmentViewHolder) r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:298:0x019f, code lost:
        
            if (r3 == null) goto L304;
         */
        /* JADX WARN: Code restructure failed: missing block: B:299:0x01a1, code lost:
        
            r0 = r3.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:300:0x01a3, code lost:
        
            if (r0 == null) goto L304;
         */
        /* JADX WARN: Code restructure failed: missing block: B:301:0x01a5, code lost:
        
            r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:302:0x01a7, code lost:
        
            if (r0 == null) goto L304;
         */
        /* JADX WARN: Code restructure failed: missing block: B:303:0x01a9, code lost:
        
            r1 = id.dana.animation.HomeRecycleFragment.N + 83;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1 % 128;
            r1 = r1 % 2;
            r0.disposeByActivity();
         */
        /* JADX WARN: Code restructure failed: missing block: B:309:0x01cd, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:310:0x01ce, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:311:0x01cf, code lost:
        
            throw r0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, androidx.fragment.app.Fragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onDestroy() {
            /*
                Method dump skipped, instructions count: 464
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.onDestroy():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x0027, code lost:
        
            if ((r1 instanceof id.dana.animation.HomeTabActivity ? 1 : 20) != 20) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
        
            if ((r1 instanceof id.dana.animation.HomeTabActivity) != false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0039, code lost:
        
            r1 = (id.dana.animation.HomeTabActivity) r1;
            r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 105;
            id.dana.animation.HomeRecycleFragment.N = r2 % 128;
            r2 = r2 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0046, code lost:
        
            r1 = null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void SubSequence() {
            /*
                r6 = this;
                java.lang.String r0 = ""
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r1 = r1 + 97
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r1 = r1 % 2
                r2 = 86
                if (r1 == 0) goto L13
                r1 = 86
                goto L15
            L13:
                r1 = 89
            L15:
                r3 = 1
                r4 = 0
                if (r1 == r2) goto L2e
                id.dana.base.BaseActivity r1 = r6.getBaseActivity()     // Catch: java.lang.Exception -> L2c
                boolean r2 = r1 instanceof id.dana.animation.HomeTabActivity     // Catch: java.lang.Exception -> L2a
                r5 = 20
                if (r2 == 0) goto L25
                r2 = 1
                goto L27
            L25:
                r2 = 20
            L27:
                if (r2 == r5) goto L46
                goto L39
            L2a:
                r0 = move-exception
                goto L71
            L2c:
                r0 = move-exception
                goto L70
            L2e:
                id.dana.base.BaseActivity r1 = r6.getBaseActivity()
                boolean r2 = r1 instanceof id.dana.animation.HomeTabActivity
                r5 = 85
                int r5 = r5 / r4
                if (r2 == 0) goto L46
            L39:
                id.dana.home.HomeTabActivity r1 = (id.dana.animation.HomeTabActivity) r1
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r2 = r2 + 105
                int r5 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r5
                int r2 = r2 % 2
                goto L47
            L46:
                r1 = 0
            L47:
                id.dana.tracker.risk.RiskEventStrategy$Builder r2 = new id.dana.tracker.risk.RiskEventStrategy$Builder
                androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1     // Catch: java.lang.Exception -> L2a
                r2.<init>(r1)
                java.lang.String r1 = "DANA - HomePage"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)     // Catch: java.lang.Exception -> L2a
                r5 = r2
                id.dana.tracker.risk.RiskEventStrategy$Builder r5 = (id.dana.tracker.risk.RiskEventStrategy.Builder) r5     // Catch: java.lang.Exception -> L2a
                r2.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L2a
                java.lang.String r1 = "onPageTrack"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)     // Catch: java.lang.Exception -> L2a
                r0 = r2
                id.dana.tracker.risk.RiskEventStrategy$Builder r0 = (id.dana.tracker.risk.RiskEventStrategy.Builder) r0     // Catch: java.lang.Exception -> L2a
                r2.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L2a
                id.dana.analytics.tracker.EventStrategy[] r0 = new id.dana.analytics.tracker.EventStrategy[r3]     // Catch: java.lang.Exception -> L2a
                id.dana.tracker.risk.RiskEventStrategy r1 = r2.getAuthRequestContext()     // Catch: java.lang.Exception -> L2a
                id.dana.analytics.tracker.EventStrategy r1 = (id.dana.analytics.tracker.EventStrategy) r1     // Catch: java.lang.Exception -> L2a
                r0[r4] = r1     // Catch: java.lang.Exception -> L2a
                id.dana.tracker.EventTracker.BuiltInFictitiousFunctionClassFactory(r0)     // Catch: java.lang.Exception -> L2a
                return
            L70:
                throw r0
            L71:
                throw r0
            L72:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.SubSequence():void");
        }

        private final void p() {
            if (this.homeTabPresenter == null) {
                int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 35;
                N = i % 128;
                if ((i % 2 != 0 ? 'G' : Typography.dollar) != '$') {
                    int i2 = 96 / 0;
                    return;
                }
                return;
            }
            FlowableCreate$BufferAsyncEmitter().get().MyBillsEntityDataFactory(new Function1<BiometricDataSize, Unit>() { // from class: id.dana.home.HomeRecycleFragment$saveScoringDeviceData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(BiometricDataSize biometricDataSize) {
                    invoke2(biometricDataSize);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(BiometricDataSize biometricDataSize) {
                    Intrinsics.checkNotNullParameter(biometricDataSize, "");
                    HomeRecycleFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0().KClassImpl$Data$declaredNonStaticMembers$2(biometricDataSize);
                }
            });
            try {
                int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 31;
                N = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }

        private final void z() {
            NewNearbyMeView newNearbyMeView;
            if ((this.getCallingPid ? 'T' : 'S') != 'T') {
                return;
            }
            int i = N + 1;
            SummaryVoucherView$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            LinearLayoutManager linearLayoutManager = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            LinearLayoutManager linearLayoutManager2 = null;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayoutManager = null;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            LinearLayoutManager linearLayoutManager3 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            if (!(linearLayoutManager3 != null)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                linearLayoutManager2 = linearLayoutManager3;
            }
            if (new IntRange(findFirstVisibleItemPosition, linearLayoutManager2.findLastVisibleItemPosition()).contains(4)) {
                int i3 = N + 107;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                HomeAdapter.NearbyViewHolder S = S();
                if ((S != null ? (char) 29 : (char) 22) != 29) {
                    return;
                }
                ViewItemNearbyWidgetBinding viewItemNearbyWidgetBinding = S.BuiltInFictitiousFunctionClassFactory;
                if ((viewItemNearbyWidgetBinding == null) || (newNearbyMeView = viewItemNearbyWidgetBinding.PlaceComponentResult) == null) {
                    return;
                }
                int i5 = N + 107;
                SummaryVoucherView$$ExternalSyntheticLambda1 = i5 % 128;
                int i6 = i5 % 2;
                newNearbyMeView.checkPermission(false, false);
                int i7 = SummaryVoucherView$$ExternalSyntheticLambda1 + 7;
                N = i7 % 128;
                int i8 = i7 % 2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x0022, code lost:
        
            if ((r3 != null ? 'S' : '!') != 'S') goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0033, code lost:
        
            if ((r3 == null) != false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0036, code lost:
        
            r1 = r3.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0038, code lost:
        
            if (r1 == null) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x003a, code lost:
        
            r3 = id.dana.animation.HomeRecycleFragment.N + 13;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r3 % 128;
            r3 = r3 % 2;
            r0 = r1.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x004c, code lost:
        
            if (r3 != 0) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x004e, code lost:
        
            r1 = r2.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0052, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final id.dana.home.adapter.HomeAdapter.GlobalSearchViewHolder Q() {
            /*
                r5 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 87
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 0
                r2 = 0
                if (r0 != 0) goto L27
                id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.GLOBAL_SEARCH
                androidx.viewbinding.ViewBinding r3 = r5.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r3 = (id.dana.databinding.FragmentHomeRecycleBinding) r3
                r4 = 64
                int r4 = r4 / r1
                r1 = 83
                if (r3 == 0) goto L20
                r4 = 83
                goto L22
            L20:
                r4 = 33
            L22:
                if (r4 == r1) goto L36
                goto L52
            L25:
                r0 = move-exception
                throw r0
            L27:
                id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.GLOBAL_SEARCH
                androidx.viewbinding.ViewBinding r3 = r5.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r3 = (id.dana.databinding.FragmentHomeRecycleBinding) r3
                if (r3 == 0) goto L32
                goto L33
            L32:
                r1 = 1
            L33:
                if (r1 == 0) goto L36
                goto L52
            L36:
                androidx.recyclerview.widget.RecyclerView r1 = r3.BuiltInFictitiousFunctionClassFactory
                if (r1 == 0) goto L52
                int r3 = id.dana.animation.HomeRecycleFragment.N
                int r3 = r3 + 13
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r4
                int r3 = r3 % 2
                int r0 = r0.getIndex()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r1.findViewHolderForAdapterPosition(r0)
                if (r3 != 0) goto L53
                int r1 = r2.length     // Catch: java.lang.Throwable -> L50
                goto L53
            L50:
                r0 = move-exception
                throw r0
            L52:
                r0 = r2
            L53:
                boolean r1 = r0 instanceof id.dana.home.adapter.HomeAdapter.GlobalSearchViewHolder     // Catch: java.lang.Exception -> L5b
                if (r1 == 0) goto L58
                r2 = r0
            L58:
                id.dana.home.adapter.HomeAdapter$GlobalSearchViewHolder r2 = (id.dana.home.adapter.HomeAdapter.GlobalSearchViewHolder) r2
                return r2
            L5b:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.Q():id.dana.home.adapter.HomeAdapter$GlobalSearchViewHolder");
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x0020, code lost:
        
            if (r1 != null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0031, code lost:
        
            if ((r1 != null) != false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0033, code lost:
        
            r1 = r1.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0035, code lost:
        
            if (r1 == null) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0037, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0038, code lost:
        
            if (r2 == true) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x003b, code lost:
        
            r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 1;
            id.dana.animation.HomeRecycleFragment.N = r2 % 128;
            r2 = r2 % 2;
            r0 = r1.findViewHolderForAdapterPosition(r0.getIndex());
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x004e, code lost:
        
            r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0052, code lost:
        
            id.dana.animation.HomeRecycleFragment.N = r1 % 128;
            r1 = r1 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0057, code lost:
        
            r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 51;
            id.dana.animation.HomeRecycleFragment.N = r0 % 128;
            r0 = r0 % 2;
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0064, code lost:
        
            if ((r0 instanceof id.dana.home.adapter.HomeAdapter.SocialWidgetHolder) == false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0066, code lost:
        
            r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 5;
            id.dana.animation.HomeRecycleFragment.N = r1 % 128;
            r1 = r1 % 2;
            r3 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0073, code lost:
        
            return (id.dana.home.adapter.HomeAdapter.SocialWidgetHolder) r3;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final id.dana.home.adapter.HomeAdapter.SocialWidgetHolder U() {
            /*
                r6 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 77
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r1 = 37
                if (r0 == 0) goto L11
                r0 = 37
                goto L13
            L11:
                r0 = 96
            L13:
                r2 = 0
                r3 = 0
                r4 = 1
                if (r0 == r1) goto L23
                id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.SOCIAL_WIDGET
                androidx.viewbinding.ViewBinding r1 = r6.getBinding()
                id.dana.databinding.FragmentHomeRecycleBinding r1 = (id.dana.databinding.FragmentHomeRecycleBinding) r1
                if (r1 == 0) goto L57
                goto L33
            L23:
                id.dana.home.adapter.HomeAdapter$HomeWidget r0 = id.dana.home.adapter.HomeAdapter.HomeWidget.SOCIAL_WIDGET     // Catch: java.lang.Exception -> L78
                androidx.viewbinding.ViewBinding r1 = r6.getBinding()     // Catch: java.lang.Exception -> L76
                id.dana.databinding.FragmentHomeRecycleBinding r1 = (id.dana.databinding.FragmentHomeRecycleBinding) r1     // Catch: java.lang.Exception -> L76
                int r5 = r3.length     // Catch: java.lang.Throwable -> L74
                if (r1 == 0) goto L30
                r5 = 1
                goto L31
            L30:
                r5 = 0
            L31:
                if (r5 == 0) goto L57
            L33:
                androidx.recyclerview.widget.RecyclerView r1 = r1.BuiltInFictitiousFunctionClassFactory
                if (r1 == 0) goto L38
                r2 = 1
            L38:
                if (r2 == r4) goto L3b
                goto L57
            L3b:
                int r2 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r2 = r2 + r4
                int r4 = r2 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r2 = r2 % 2
                int r0 = r0.getIndex()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r1.findViewHolderForAdapterPosition(r0)
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L78
                int r1 = r1 + 79
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2     // Catch: java.lang.Exception -> L76
                int r1 = r1 % 2
                goto L62
            L57:
                int r0 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r0 = r0 + 51
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.N = r1
                int r0 = r0 % 2
                r0 = r3
            L62:
                boolean r1 = r0 instanceof id.dana.home.adapter.HomeAdapter.SocialWidgetHolder
                if (r1 == 0) goto L71
                int r1 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r1 = r1 + 5
                int r2 = r1 % 128
                id.dana.animation.HomeRecycleFragment.N = r2
                int r1 = r1 % 2
                r3 = r0
            L71:
                id.dana.home.adapter.HomeAdapter$SocialWidgetHolder r3 = (id.dana.home.adapter.HomeAdapter.SocialWidgetHolder) r3
                return r3
            L74:
                r0 = move-exception
                throw r0
            L76:
                r0 = move-exception
                throw r0
            L78:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.U():id.dana.home.adapter.HomeAdapter$SocialWidgetHolder");
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0071, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0072, code lost:
        
            if (r1 == false) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0075, code lost:
        
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = java.lang.Boolean.TRUE;
            VerifyPinStateManager$executeRiskChallenge$2$1();
            r0 = id.dana.animation.HomeRecycleFragment.N + 53;
            id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0086, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x001c, code lost:
        
            if (r3 != false) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x002b, code lost:
        
            if (r0.PlaceComponentResult() != false) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x002d, code lost:
        
            r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 + 101;
            id.dana.animation.HomeRecycleFragment.N = r3 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0037, code lost:
        
            if ((r3 % 2) == 0) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0039, code lost:
        
            r3 = r0.lookAheadTest;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x003d, code lost:
        
            r4 = 90 / 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x003e, code lost:
        
            if (r3 != null) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0043, code lost:
        
            r3 = r0.lookAheadTest;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0045, code lost:
        
            if (r3 != null) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0047, code lost:
        
            r3 = "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x004f, code lost:
        
            if (r3.length() <= 0) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0051, code lost:
        
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0053, code lost:
        
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0054, code lost:
        
            if (r3 == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0056, code lost:
        
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0058, code lost:
        
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0059, code lost:
        
            if (r3 == true) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0064, code lost:
        
            getDefaultSenderId().get().BuiltInFictitiousFunctionClassFactory();
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0069, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x006e, code lost:
        
            if (r0.PlaceComponentResult() == false) goto L100;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void MyBillsEntityDataFactory() {
            /*
                r5 = this;
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 95
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L21
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()
                boolean r3 = r0.PlaceComponentResult()
                r4 = 0
                r4.hashCode()     // Catch: java.lang.Throwable -> L1f
                if (r3 == 0) goto L6a
                goto L2d
            L1f:
                r0 = move-exception
                throw r0
            L21:
                id.dana.contract.deeplink.DeeplinkSaveDataManager$Companion r0 = id.dana.contract.deeplink.DeeplinkSaveDataManager.INSTANCE     // Catch: java.lang.Exception -> L89
                id.dana.contract.deeplink.DeeplinkSaveDataManager r0 = r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L87
                boolean r3 = r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L89
                if (r3 == 0) goto L6a
            L2d:
                int r3 = id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1
                int r3 = r3 + 101
                int r4 = r3 % 128
                id.dana.animation.HomeRecycleFragment.N = r4
                int r3 = r3 % 2
                if (r3 == 0) goto L43
                java.lang.String r3 = r0.lookAheadTest
                r4 = 90
                int r4 = r4 / r1
                if (r3 != 0) goto L49
                goto L47
            L41:
                r0 = move-exception
                throw r0
            L43:
                java.lang.String r3 = r0.lookAheadTest
                if (r3 != 0) goto L49
            L47:
                java.lang.String r3 = ""
            L49:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 <= 0) goto L53
                r3 = 1
                goto L54
            L53:
                r3 = 0
            L54:
                if (r3 == 0) goto L58
                r3 = 1
                goto L59
            L58:
                r3 = 0
            L59:
                if (r3 == r2) goto L5c
                goto L6a
            L5c:
                dagger.Lazy r0 = r5.getDefaultSenderId()     // Catch: java.lang.Exception -> L89
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L87
                id.dana.contract.ott.OttVerifyContract$Presenter r0 = (id.dana.contract.ott.OttVerifyContract.Presenter) r0
                r0.BuiltInFictitiousFunctionClassFactory()
                return
            L6a:
                boolean r3 = r0.PlaceComponentResult()
                if (r3 == 0) goto L71
                goto L72
            L71:
                r1 = 1
            L72:
                if (r1 == 0) goto L75
                goto L86
            L75:
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
                r5.VerifyPinStateManager$executeRiskChallenge$2$1()
                int r0 = id.dana.animation.HomeRecycleFragment.N
                int r0 = r0 + 53
                int r1 = r0 % 128
                id.dana.animation.HomeRecycleFragment.SummaryVoucherView$$ExternalSyntheticLambda1 = r1
                int r0 = r0 % 2
            L86:
                return
            L87:
                r0 = move-exception
                throw r0
            L89:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.HomeRecycleFragment.MyBillsEntityDataFactory():void");
        }

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda5")
        public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
            HomeAdapter homeAdapter;
            int i = SummaryVoucherView$$ExternalSyntheticLambda1 + 23;
            N = i % 128;
            if (i % 2 == 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
                homeAdapter = this.GetContactSyncConfig;
                if (homeAdapter == null) {
                    return;
                }
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
                homeAdapter = this.GetContactSyncConfig;
                if (homeAdapter == null) {
                    return;
                }
            }
            Iterator<HomeViewWidgetModel> it = homeAdapter.getErrorConfigVersion.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    int i3 = SummaryVoucherView$$ExternalSyntheticLambda1 + 101;
                    N = i3 % 128;
                    int i4 = i3 % 2;
                    break;
                }
                try {
                    try {
                        if (it.next().MyBillsEntityDataFactory == HomeAdapter.HomeWidget.SOCIAL_WIDGET) {
                            break;
                        }
                        i2++;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            HomeViewWidgetModel homeViewWidgetModel = homeAdapter.getErrorConfigVersion.get(i2);
            HomeAdapter.HomeWidget homeWidget = HomeAdapter.HomeWidget.NO_SPACE;
            Intrinsics.checkNotNullParameter(homeWidget, "");
            homeViewWidgetModel.MyBillsEntityDataFactory = homeWidget;
            homeAdapter.notifyItemChanged(i2);
            homeAdapter.getAuthRequestContext.readMicros();
        }

        private static void ab(int i, char[] cArr, Object[] objArr) {
            C c = new C();
            char[] cArr2 = new char[cArr.length];
            c.BuiltInFictitiousFunctionClassFactory = 0;
            char[] cArr3 = new char[2];
            int i2 = $11 + 117;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '4' : (char) 14) == '4') {
                    int i4 = $11 + 123;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                    cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                    int i6 = 58224;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= 16) {
                            break;
                        }
                        int i8 = $10 + 39;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i6) ^ ((cArr3[0] << 4) + ((char) (Q ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (SummaryVoucherView$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i6) ^ ((cArr3[1] << 4) + ((char) (P ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (O ^ 6353485791441662354L)))));
                        i6 -= 40503;
                        i7++;
                    }
                    cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                    cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                    c.BuiltInFictitiousFunctionClassFactory += 2;
                } else {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
            }
        }
    }
