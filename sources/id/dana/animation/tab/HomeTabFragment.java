package id.dana.animation.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.LiveData;
import androidx.view.Observer;
import com.anggrayudi.storage.extension.ContextUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeFragmentListener;
import id.dana.animation.HomeRecycleFragment;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.OnResumeInterceptor;
import id.dana.animation.SwipeDelegateListener;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.view.MainNavigationTabView;
import id.dana.animation.view.NavigationTabView;
import id.dana.animation.view.PocketNavigationView;
import id.dana.animation.view.ProfileNavigationTabView;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.connectivity.ConnectivityMonitorContract;
import id.dana.connectivity.ConnectivityMonitorModule;
import id.dana.contract.account.FirstTimeContract;
import id.dana.contract.account.FirstTimeModule;
import id.dana.contract.deeplink.DeepLinkCallback;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeatureUnsupportedDeepLink;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.homeinfo.HomeRevampContract;
import id.dana.contract.homeinfo.HomeRevampModule;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationModule;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.contract.promotion.InterstitialPromotionBannerModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.ConnectivityMonitorKt;
import id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor;
import id.dana.core.ui.util.connectivity.factory.ConnectivityMonitorFactory;
import id.dana.core.ui.util.connectivity.factory.ConnectivityMonitorSource;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.core.ui.util.preventscreenshot.PreventScreenshotEvent;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import id.dana.databinding.FragmentHomeTabBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerHomeTabComponent;
import id.dana.di.component.HomeTabComponent;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.QrisCrossBorderModule;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.transactionhistory.model.TransactionHistoryConfig;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.interstitial.InterstitialBannerActivity;
import id.dana.kyb.model.KybPageInfo;
import id.dana.lib.gcontainer.GContainer;
import id.dana.model.CdpContentModel;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.model.HomeDataModel;
import id.dana.model.HomeInfo;
import id.dana.model.ProcessingTransaction;
import id.dana.model.PromotionModel;
import id.dana.model.QrisCrossBorderContentModel;
import id.dana.model.ScanModel;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.MyProfileMainFragment;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.oauth.OauthLoginManager;
import id.dana.pay.PayActivity;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.performancetracker.IdleTimeUtil;
import id.dana.permissionprompt.view.PermissionPromptBottomSheetDialog;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity;
import id.dana.richview.animation.ClickToBounceAnimation;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.PagerShowcaseBuilder;
import id.dana.showcase.Showcase;
import id.dana.showcase.TwoButtonWithImageShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.view.SplitBillDetailsActivity;
import id.dana.sync_engine.domain.model.ConfigRepeatBackgroundJob;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.SizeUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.ViewHelper;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.BranchDeeplinkUtil;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import id.dana.utils.permission.PermissionHelper;
import id.dana.wallet_v3.listener.WalletTabListener;
import id.dana.wallet_v3.view.NewWalletFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes2.dex */
public class HomeTabFragment extends ViewBindingFragment<FragmentHomeTabBinding> implements WalletTabListener, AppReadyConsumedProvider, ConnectivitySnackbarListener {
    private ConnectivityMonitorFactory A;
    private boolean AppCompatEmojiTextHelper;
    private final List<Integer> B;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    private int C;
    private boolean D;
    HomeInfo DatabaseTableConfigUtil;
    private boolean E;
    private boolean F;
    public String FragmentBottomSheetPaymentSettingBinding;
    private ScannerActionFactory G;
    public HomeFragmentManager GetContactSyncConfig;
    private String H;
    private String I;
    private Showcase J;
    private PocketNavigationView K;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private ProfileNavigationTabView L;
    private PromotionModel M;
    boolean MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    Class<? extends Fragment> NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final HomeFragmentListener NetworkUserEntityData$$ExternalSyntheticLambda2;
    public HomeTabs NetworkUserEntityData$$ExternalSyntheticLambda3;
    public WalletFragmentManager NetworkUserEntityData$$ExternalSyntheticLambda4;
    public KybPageInfo NetworkUserEntityData$$ExternalSyntheticLambda5;
    public SwipeDelegateListener NetworkUserEntityData$$ExternalSyntheticLambda6;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Showcase P;
    public boolean PrepareContext;
    private boolean Q;
    private LiveData<ConnectivityModel> SubSequence;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$2;
    @Inject
    Lazy<CashierEventHandler> cashierEventHandler;
    @Inject
    Lazy<ConnectivityMonitorContract.Presenter> connectivityMonitorPresenter;
    @Inject
    Lazy<DeepLinkContract.Presenter> deepLinkPresenter;
    @Inject
    Lazy<DynamicUrlWrapper> dynamicUrlWrapper;
    @Inject
    Lazy<FeatureContract.Presenter> featurePresenter;
    @Inject
    public Lazy<FirstTimeContract.Presenter> firstTimePresenter;
    Class<? extends Fragment> getErrorConfigVersion;
    private NavigationTabView getNameOrBuilderList;
    private HomeTabComponent getOnBoardingScenario;
    private boolean getValueOfTouchPositionAbsolute;
    @Inject
    Lazy<CheckoutH5EventContract.Presenter> h5EventPresenter;
    @Inject
    public Lazy<HomeInfoContract.Presenter> homePresenter;
    @Inject
    public Lazy<HomeRevampContract.Presenter> homeRevampPresenter;
    @Inject
    Lazy<HomeTrackerImpl> homeTracker;
    public final List<String> initRecordTimeStamp;
    @Inject
    public Lazy<InterstitialPromotionBannerContract.Presenter> interstitialPresenter;
    boolean isLayoutRequested;
    ConnectivitySnackbarManager lookAheadTest;
    String moveToNextValue;
    public boolean newProxyInstance;
    @Inject
    Lazy<PayLaterContract.Presenter> payLaterPresenter;
    @Inject
    Lazy<PlayStoreReviewContract.Presenter> playStoreReviewPresenter;
    @Inject
    public Lazy<PushNotificationContract.Presenter> pushNotificationPresenter;
    @Inject
    public Lazy<QrisCrossBorderContract.Presenter> qrisCrossBorderPresenter;
    @Inject
    Lazy<ReadLinkPropertiesContract.Presenter> readDeepLinkPropertiesPresenter;
    @Inject
    Lazy<RestoreUrlContract.Presenter> restoreUrlPresenter;
    @Inject
    Lazy<ScanQrContract.Presenter> scanQrPresenter;
    public int scheduleImpl;
    @Inject
    Lazy<StartupConfigEntityData> sharedPrefStartupConfig;
    private BroadcastReceiver whenAvailable;
    private static final int readMicros = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    public static final int PlaceComponentResult = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    private static final int getCallingPid = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    private static final int getSupportButtonTintMode = SizeUtil.getAuthRequestContext(30);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FragmentTag {
        public static final String HOME_FRAGMENT = "HOME_FRAGMENT";
        public static final String ME_FRAGMENT = "ME_FRAGMENT";
        public static final String WALLET_FRAGMENT = "WALLET_FRAGMENT";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface HomeTabIndex {
        public static final int HISTORY = 1;
        public static final int HOME = 0;
        public static final int ME = 4;
        public static final int PAY = 2;
        public static final int WALLET_OR_POCKET = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface HomeTabVariant {
        public static final String POCKET = "POCKET";
        public static final String TRANSACTION_HISTORY = "TRANSACTION_HISTORY";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LocationMode {
        public static final String GLOBAL_NETWORK = "GLOBAL_NETWORK";
        public static final String QRIS_CROSS_BORDER = "QRIS_CROSS_BORDER";
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_home_tab;
    }

    static /* synthetic */ Showcase NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabFragment homeTabFragment) {
        homeTabFragment.J = null;
        return null;
    }

    static /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda7(HomeTabFragment homeTabFragment) {
        homeTabFragment.isLayoutRequested = false;
        return false;
    }

    static /* synthetic */ void getAuthRequestContext(HomeTabFragment homeTabFragment, QrisCrossBorderContentModel qrisCrossBorderContentModel, String str) {
        Trace startTrace = FirebasePerformance.startTrace("Qcb Onboarding - Show");
        Intent intent = new Intent(homeTabFragment.getContext(), OnboardingQrisCrossBorderSheetActivity.class);
        intent.putExtra(OnboardingQrisCrossBorderSheetActivity.EXTRA_QCB_CONTENT, qrisCrossBorderContentModel);
        intent.putExtra(OnboardingQrisCrossBorderSheetActivity.EXTRA_QCB_COUNTRY_CODE, str);
        homeTabFragment.startActivityForResult(intent, getCallingPid);
        startTrace.stop();
    }

    static /* synthetic */ boolean lookAheadTest(HomeTabFragment homeTabFragment) {
        homeTabFragment.E = false;
        return false;
    }

    static /* synthetic */ Showcase newProxyInstance(HomeTabFragment homeTabFragment) {
        homeTabFragment.P = null;
        return null;
    }

    @Override // id.dana.animation.tab.AppReadyConsumedProvider
    public Boolean isConsumed() {
        return Boolean.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public HomeTabFragment() {
        this((byte) 0);
    }

    private HomeTabFragment(byte b) {
        this.FragmentBottomSheetPaymentSettingBinding = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.Q = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.PrepareContext = true;
        this.newProxyInstance = true;
        this.isLayoutRequested = false;
        this.B = new ArrayList(5);
        this.scheduleImpl = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FragmentTag.HOME_FRAGMENT;
        this.initRecordTimeStamp = new ArrayList(3);
        this.K = null;
        this.L = null;
        this.getNameOrBuilderList = null;
        this.G = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        this.D = false;
        this.E = false;
        this.C = 1;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
        this.H = "";
        this.getValueOfTouchPositionAbsolute = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
    }

    private HomeTabFragment(HomeTabs homeTabs, HomeFragmentListener homeFragmentListener, KybPageInfo kybPageInfo) {
        this.FragmentBottomSheetPaymentSettingBinding = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.Q = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.PrepareContext = true;
        this.newProxyInstance = true;
        this.isLayoutRequested = false;
        this.B = new ArrayList(5);
        this.scheduleImpl = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FragmentTag.HOME_FRAGMENT;
        this.initRecordTimeStamp = new ArrayList(3);
        this.K = null;
        this.L = null;
        this.getNameOrBuilderList = null;
        this.G = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        this.D = false;
        this.E = false;
        this.C = 1;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
        this.H = "";
        this.getValueOfTouchPositionAbsolute = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = homeFragmentListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = homeTabs;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = kybPageInfo;
    }

    public static HomeTabFragment BuiltInFictitiousFunctionClassFactory(HomeTabs homeTabs, HomeFragmentListener homeFragmentListener, KybPageInfo kybPageInfo) {
        return new HomeTabFragment(homeTabs, homeFragmentListener, kybPageInfo);
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.BOTTOM_BAR);
        if (getActivity() == null) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = ((HomeTabActivity) getActivity()).getSwipeDelegateListener();
        if (this.getOnBoardingScenario == null) {
            DaggerHomeTabComponent.Builder authRequestContext = DaggerHomeTabComponent.getAuthRequestContext();
            authRequestContext.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = (FirstTimeModule) Preconditions.getAuthRequestContext(new FirstTimeModule(new FirstTimeContract.View() { // from class: id.dana.home.tab.HomeTabFragment.9
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.contract.account.FirstTimeContract.View
                public final void getAuthRequestContext(boolean z) {
                    HomeTabFragment.this.VerifyPinStateManager$executeRiskChallenge$2$1 = z;
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this, z);
                    HomeTabFragment.this.firstTimePresenter.get().BuiltInFictitiousFunctionClassFactory();
                }
            }));
            authRequestContext.getErrorConfigVersion = (HomeInfoModule) Preconditions.getAuthRequestContext(new HomeInfoModule(new HomeInfoContract.View() { // from class: id.dana.home.tab.HomeTabFragment.8
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetConfigSyncContact(ConfigRepeatBackgroundJob configRepeatBackgroundJob) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetHomeData(HomeDataModel homeDataModel) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetIsSyncPermission() {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetSurveyInfo(SurveyInfoModel surveyInfoModel) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetSyncPermissionConfig(SyncPermissionAndChangeConfig syncPermissionAndChangeConfig) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onShouldShowMerchant(MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel) {
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onShowMerchantReviewCheckingError() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetHomeInfo(HomeInfo homeInfo) {
                    HomeTabFragment.this.DatabaseTableConfigUtil = homeInfo;
                    if (HomeTabFragment.this.sharedPrefStartupConfig.get().getQueryUserDataConfig().getSeperateProcessTrans()) {
                        HomeTabFragment homeTabFragment = HomeTabFragment.this;
                        if (homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                            homeTabFragment.homePresenter.get().MyBillsEntityDataFactory();
                        }
                    } else {
                        ProcessingTransaction processingTransaction = homeInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        boolean z = false;
                        int i = processingTransaction == null ? 0 : processingTransaction.BuiltInFictitiousFunctionClassFactory;
                        if (processingTransaction != null && processingTransaction.PlaceComponentResult()) {
                            z = true;
                        }
                        HomeTabFragment.this.getNameOrBuilderList.setUnreadNotif(i, z);
                    }
                    if (HomeTabFragment.this.L != null) {
                        ProfileNavigationTabView profileNavigationTabView = HomeTabFragment.this.L;
                        String str = HomeTabFragment.this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
                        HomeTabFragment homeTabFragment2 = HomeTabFragment.this;
                        HomeInfo homeInfo2 = homeTabFragment2.DatabaseTableConfigUtil;
                        String str2 = "";
                        if (homeInfo2 == null || homeInfo2.getAuthRequestContext == null || homeTabFragment2.DatabaseTableConfigUtil.getAuthRequestContext.PlaceComponentResult == null) {
                            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                            Exception exc = new Exception("getKycLevel is null");
                            Intrinsics.checkNotNullParameter(exc, "");
                            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(exc);
                        } else {
                            str2 = homeTabFragment2.DatabaseTableConfigUtil.getAuthRequestContext.PlaceComponentResult;
                        }
                        profileNavigationTabView.setupUserTabIcon(str, "KYC2".equals(str2));
                    }
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onGetProcessingTransaction(ProcessingTransactionModel processingTransactionModel) {
                    HomeTabFragment.this.getNameOrBuilderList.setUnreadNotif(processingTransactionModel.getCount(), processingTransactionModel.getHasMore());
                }

                @Override // id.dana.contract.homeinfo.HomeInfoContract.View
                public void onShowTooltip(boolean z) {
                    if (HomeTabFragment.this.D) {
                        HomeTabFragment.PlaceComponentResult(HomeTabFragment.this, z);
                    } else {
                        HomeTabFragment.getAuthRequestContext(HomeTabFragment.this, z);
                    }
                }
            }));
            authRequestContext.lookAheadTest = (HomeRevampModule) Preconditions.getAuthRequestContext(new HomeRevampModule(new HomeRevampContract.View() { // from class: id.dana.home.tab.HomeTabFragment.7
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
                    if (!z) {
                        HomeTabFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory();
                    } else {
                        HomeTabFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory();
                    }
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void PlaceComponentResult(boolean z, int i) {
                    HomeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(HomeTabFragment.this);
                    HomeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabFragment.this, z);
                    HomeTabFragment.this.C = i;
                    HomeTabFragment.this.newProxyInstance = z;
                    if (z) {
                        return;
                    }
                    HomeTabFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8();
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
                    HomeTabFragment.this.getBaseActivity().getDanaApplication().setMePageRevamp(Boolean.valueOf(z));
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void PlaceComponentResult(boolean z) {
                    HomeTabFragment.this.getBaseActivity().getDanaApplication().setKybRevamp(z);
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void getAuthRequestContext(boolean z) {
                    if (z) {
                        ScanQrContract.Presenter presenter = HomeTabFragment.this.scanQrPresenter.get();
                        String str = DeeplinkSaveDataManager.MyBillsEntityDataFactory().DatabaseTableConfigUtil;
                        if (str == null) {
                            str = "";
                        }
                        presenter.MyBillsEntityDataFactory(str, "Scan QR", null, false, true);
                    }
                    DeeplinkSaveDataManager.MyBillsEntityDataFactory().DatabaseTableConfigUtil = null;
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<String> list) {
                    EventBus.getDefault().postSticky(new PreventScreenshotEvent(list));
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(TransactionHistoryConfig transactionHistoryConfig) {
                    HomeTabFragment.this.VerifyPinStateManager$executeRiskChallenge$2$2 = transactionHistoryConfig.getUseNewUrl();
                    HomeTabFragment.this.H = transactionHistoryConfig.getUrl();
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void PlaceComponentResult() {
                    HomeTabFragment.getAuthRequestContext(HomeTabFragment.this);
                }

                @Override // id.dana.contract.homeinfo.HomeRevampContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    HomeTabFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeTabFragment.this);
                }
            }));
            authRequestContext.scheduleImpl = (InterstitialPromotionBannerModule) Preconditions.getAuthRequestContext(new InterstitialPromotionBannerModule(new InterstitialPromotionBannerContract.View() { // from class: id.dana.home.tab.HomeTabFragment.6
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.View
                public final void PlaceComponentResult(PromotionModel promotionModel) {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this, promotionModel);
                }

                @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.View
                public final void MyBillsEntityDataFactory() {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                }
            }));
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = (PushNotificationModule) Preconditions.getAuthRequestContext(new PushNotificationModule(new PushNotificationContract.View() { // from class: id.dana.home.tab.HomeTabFragment.5
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.contract.notification.PushNotificationContract.View
                public void onCheckPushNotifDiagnosticFeatureeSuccess(boolean z) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.contract.notification.PushNotificationContract.View
                public void onReportDeviceFailed() {
                }

                @Override // id.dana.contract.notification.PushNotificationContract.View
                public void onReportDeviceSuccess() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                {
                    HomeTabFragment.this = this;
                }
            }));
            authRequestContext.GetContactSyncConfig = (QrisCrossBorderModule) Preconditions.getAuthRequestContext(new QrisCrossBorderModule(new QrisCrossBorderContract.View() { // from class: id.dana.home.tab.HomeTabFragment.4
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.qriscrossborder.QrisCrossBorderContract.View
                public final void BuiltInFictitiousFunctionClassFactory(QrisCrossBorderContentModel qrisCrossBorderContentModel, String str) {
                    HomeTabFragment.getAuthRequestContext(HomeTabFragment.this, qrisCrossBorderContentModel, str);
                }

                @Override // id.dana.qriscrossborder.QrisCrossBorderContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                }
            }));
            authRequestContext.initRecordTimeStamp = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(getActivity())));
            authRequestContext.getAuthRequestContext = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda2
                @Override // id.dana.h5event.CheckoutH5EventContract.View
                public final void getAuthRequestContext(boolean z) {
                    HomeTabFragment.this.MyBillsEntityDataFactory = z;
                }
            }));
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new DeepLinkCallback() { // from class: id.dana.home.tab.HomeTabFragment.10
                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayloadModel deepLinkPayloadModel) {
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void getAuthRequestContext() {
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void PlaceComponentResult(String str) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DEEPLINK_TAG, str);
                    if (HomeTabFragment.this.getActivity() == null || !"url must not be null".equalsIgnoreCase(str)) {
                        return;
                    }
                    new FeatureUnsupportedDeepLink(HomeTabFragment.this.getActivity());
                }
            };
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
            byte b = 0;
            authRequestContext.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.home.tab.HomeTabFragment.3
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                {
                    HomeTabFragment.this = this;
                }
            }));
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = (PayLaterModule) Preconditions.getAuthRequestContext(new PayLaterModule(new PayLaterViewListener() { // from class: id.dana.home.tab.HomeTabFragment.2
                {
                    HomeTabFragment.this = this;
                }
            }));
            ScanQrModule.Builder authRequestContext2 = ScanQrModule.getAuthRequestContext();
            authRequestContext2.MyBillsEntityDataFactory = getActivity();
            authRequestContext2.PlaceComponentResult = new AnonymousClass15();
            authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = ScannerViewType.FRAGMENT;
            authRequestContext.PrepareContext = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext2, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
            authRequestContext.DatabaseTableConfigUtil = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
            authRequestContext.moveToNextValue = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            authRequestContext.MyBillsEntityDataFactory = (ConnectivityMonitorModule) Preconditions.getAuthRequestContext(new ConnectivityMonitorModule(new ConnectivityMonitorContract.View() { // from class: id.dana.home.tab.HomeTabFragment.11
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                {
                    HomeTabFragment.this = this;
                }

                @Override // id.dana.connectivity.ConnectivityMonitorContract.View
                public final void getAuthRequestContext() {
                    HomeTabFragment.this.Q = true;
                    HomeTabFragment.this.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.connectivity.ConnectivityMonitorContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    HomeTabFragment.this.Q = false;
                    HomeTabFragment.this.BuiltInFictitiousFunctionClassFactory();
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.lookAheadTest, HomeRevampModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, FirstTimeModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion, HomeInfoModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.scheduleImpl, InterstitialPromotionBannerModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PrepareContext, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.DatabaseTableConfigUtil, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.moveToNextValue, OauthModule.class);
            if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
                authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2, PushNotificationModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.initRecordTimeStamp, PlayStoreReviewModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, CheckoutH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.GetContactSyncConfig, QrisCrossBorderModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ConnectivityMonitorModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1, PayLaterModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.getOnBoardingScenario = new DaggerHomeTabComponent.HomeTabComponentImpl(authRequestContext.lookAheadTest, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, authRequestContext.getErrorConfigVersion, authRequestContext.scheduleImpl, authRequestContext.PlaceComponentResult, authRequestContext.PrepareContext, authRequestContext.DatabaseTableConfigUtil, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.moveToNextValue, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2, authRequestContext.initRecordTimeStamp, authRequestContext.getAuthRequestContext, authRequestContext.GetContactSyncConfig, authRequestContext.MyBillsEntityDataFactory, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1, authRequestContext.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
        this.getOnBoardingScenario.PlaceComponentResult(this);
        if (FragmentBottomSheetPaymentSettingBinding() != null) {
            this.GetContactSyncConfig = new HomeFragmentManager(FragmentBottomSheetPaymentSettingBinding());
        }
        getBinding().MyBillsEntityDataFactory.setOnTouchListener(new ClickToBounceAnimation(new View.OnClickListener() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTabFragment homeTabFragment = HomeTabFragment.this;
                FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory();
                homeTabFragment.startActivityForResult(PayActivity.createPayActivityIntent(homeTabFragment.getBaseActivity(), TrackerKey.SourceType.HOME_PAY_BUTTON), HomeTabFragment.PlaceComponentResult);
            }
        }, true));
        getBinding().MyBillsEntityDataFactory.setContentDescription(getString(R.string.btn_payment_offline));
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = NewWalletFragment.class;
        NetworkUserEntityData$$ExternalSyntheticLambda8();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        this.whenAvailable = new BroadcastReceiver() { // from class: id.dana.home.tab.HomeTabFragment.1
            {
                HomeTabFragment.this = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                HomeTabFragment.this.readDeepLinkPropertiesPresenter.get().MyBillsEntityDataFactory(intent.getStringExtra("urlDeepLinkH5"));
            }
        };
        if (getContext() != null) {
            getContext().registerReceiver(this.whenAvailable, new IntentFilter("deepLinkH5_broadcast_filter"));
        }
        if (isAdded() && KClassImpl$Data$declaredNonStaticMembers$2()) {
            MyBillsEntityDataFactory();
            getAuthRequestContext();
        }
        if (getBinding() == null) {
            return;
        }
        ViewHelper.getAuthRequestContext(getBinding().BuiltInFictitiousFunctionClassFactory, new Runnable() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HomeTabFragment homeTabFragment = HomeTabFragment.this;
                homeTabFragment.homeRevampPresenter.get().scheduleImpl();
                homeTabFragment.isLayoutRequested = true;
                homeTabFragment.homeRevampPresenter.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
                homeTabFragment.homeRevampPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
                homeTabFragment.homeRevampPresenter.get().MyBillsEntityDataFactory();
                homeTabFragment.homeRevampPresenter.get().BuiltInFictitiousFunctionClassFactory();
                homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
            }
        });
    }

    public final void MyBillsEntityDataFactory() {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        if (OauthLoginManager.GetContactSyncConfig()) {
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            OauthLoginManager.PrepareContext();
            this.deepLinkPresenter.get().onDestroy();
            return;
        }
        initRecordTimeStamp();
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        if (getActivity() == null || getActivity().getIntent().getData() == null) {
            return false;
        }
        return getActivity().getIntent().getData().getEncodedPath().startsWith(HomeTabActivity.DEEPLINK_WALLET_PATH);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 && KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.homePresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
        }
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        this.E = false;
        BuiltInFictitiousFunctionClassFactory();
        if (NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            Showcase showcase = this.J;
            if (showcase != null) {
                showcase.PlaceComponentResult();
            }
            Showcase showcase2 = this.P;
            if (showcase2 != null) {
                showcase2.PlaceComponentResult();
                return;
            }
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(true);
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(TrackerKey.Property.NAVIGATES_OUT, false);
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        LiveData<ConnectivityModel> liveData = this.SubSequence;
        if (liveData != null) {
            liveData.PlaceComponentResult(this);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.firstTimePresenter.get().onDestroy();
            this.homePresenter.get().onDestroy();
            this.interstitialPresenter.get().onDestroy();
            this.scanQrPresenter.get().onDestroy();
            this.restoreUrlPresenter.get().onDestroy();
            this.pushNotificationPresenter.get().onDestroy();
            this.deepLinkPresenter.get().onDestroy();
            this.readDeepLinkPropertiesPresenter.get().onDestroy();
            this.h5EventPresenter.get().onDestroy();
            this.playStoreReviewPresenter.get().onDestroy();
            this.featurePresenter.get().onDestroy();
            this.homeRevampPresenter.get().onDestroy();
            this.payLaterPresenter.get().onDestroy();
            this.connectivityMonitorPresenter.get().onDestroy();
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (getBaseActivity() instanceof HomeTabActivity) && ((HomeTabActivity) getBaseActivity()).getIsFinishCheckSession();
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if ((!isLayoutRequested() && NetworkUserEntityData$$ExternalSyntheticLambda6() && isSafe()) || DeepLinkParser.MyBillsEntityDataFactory()) {
            getAuthRequestContext(this.M);
        }
    }

    private boolean isLayoutRequested() {
        if (this.VerifyPinStateManager$executeRiskChallenge$2$1 && this.homePresenter != null && this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.D = false;
            PlaceComponentResult(false);
            this.homePresenter.get().KClassImpl$Data$declaredNonStaticMembers$2(UserEducationScenarioKt.HOME_PAGE);
            return true;
        }
        return false;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return newProxyInstance() && this.F;
    }

    private void getAuthRequestContext(PromotionModel promotionModel) {
        if (promotionModel != null && promotionModel.BuiltInFictitiousFunctionClassFactory()) {
            this.F = false;
            CdpContentModel KClassImpl$Data$declaredNonStaticMembers$2 = promotionModel.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return;
            }
            if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig)) {
                startActivityForResult(InterstitialBannerActivity.createIntent(getBaseActivity(), KClassImpl$Data$declaredNonStaticMembers$2, promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda1), readMicros);
                return;
            }
            HomeTabActivity homeTabActivity = (HomeTabActivity) getBaseActivity();
            if (homeTabActivity != null) {
                homeTabActivity.nextOnboardingStep();
                return;
            }
            return;
        }
        HomeTabActivity homeTabActivity2 = (HomeTabActivity) getBaseActivity();
        if (homeTabActivity2 != null) {
            homeTabActivity2.nextOnboardingStep();
        }
    }

    public final void PlaceComponentResult(boolean z) {
        if (getBinding() != null) {
            LinearLayout linearLayout = (LinearLayout) getBinding().getAuthRequestContext.getChildAt(0);
            linearLayout.setEnabled(z);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).setClickable(z);
            }
        }
    }

    private boolean newProxyInstance() {
        return getBinding() != null && getBinding().getAuthRequestContext.getSelectedTabPosition() == 0;
    }

    public final boolean DatabaseTableConfigUtil() {
        return getBinding() != null && getBinding().getAuthRequestContext.getSelectedTabPosition() == 4;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return getBinding() != null && getBinding().getAuthRequestContext.getSelectedTabPosition() == 3;
    }

    @Override // id.dana.animation.tab.ConnectivitySnackbarListener
    public final void BuiltInFictitiousFunctionClassFactory() {
        ConnectivityMonitor connectivityMonitor;
        if (getContext() == null) {
            return;
        }
        if (this.A == null) {
            this.A = new ConnectivityMonitorFactory(getContext());
        }
        LiveData<ConnectivityModel> liveData = this.SubSequence;
        if (liveData != null) {
            liveData.PlaceComponentResult(this);
        }
        ConnectivityMonitorFactory connectivityMonitorFactory = this.A;
        if (Intrinsics.areEqual((!this.Q || (Build.VERSION.SDK_INT >= 24 && (getContext() == null || !PermissionHelper.MyBillsEntityDataFactory(getContext(), "android.permission.READ_PHONE_STATE")))) ? ConnectivityMonitorSource.CONNECTION : ConnectivityMonitorSource.SIGNAL, ConnectivityMonitorSource.SIGNAL)) {
            connectivityMonitor = (ConnectivityWithSignalMonitor) connectivityMonitorFactory.PlaceComponentResult.getValue();
        } else {
            connectivityMonitor = (ConnectivityMonitor) connectivityMonitorFactory.getAuthRequestContext.getValue();
        }
        this.SubSequence = connectivityMonitor;
        ConnectivityMonitorKt.MyBillsEntityDataFactory(connectivityMonitor, 1000L).PlaceComponentResult(this, new Observer() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda4
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                HomeTabFragment homeTabFragment = HomeTabFragment.this;
                String BuiltInFictitiousFunctionClassFactory = ConnectivityModelMapperKt.BuiltInFictitiousFunctionClassFactory((ConnectivityModel) obj);
                homeTabFragment.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
                if (homeTabFragment.lookAheadTest == null && homeTabFragment.getBinding() != null) {
                    homeTabFragment.lookAheadTest = new ConnectivitySnackbarManager(homeTabFragment.getBaseActivity(), homeTabFragment.getBinding().PlaceComponentResult);
                }
                if (homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                    homeTabFragment.lookAheadTest.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                }
                String str = homeTabFragment.moveToNextValue;
                HomeFragmentManager homeFragmentManager = homeTabFragment.GetContactSyncConfig;
                if (homeFragmentManager != null) {
                    Intrinsics.checkNotNullParameter(str, "");
                    homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(str);
                }
            }
        });
    }

    public final void getAuthRequestContext(int i, String str) {
        FragmentHomeTabBinding binding = getBinding();
        if (binding != null) {
            TabLayout.Tab tabAt = binding.getAuthRequestContext.getTabAt(i);
            TabLayout.Tab tabAt2 = binding.getAuthRequestContext.getTabAt(3);
            if (tabAt2 == null || tabAt == null || tabAt.getCustomView() == null) {
                return;
            }
            this.PrepareContext = false;
            tabAt2.select();
            getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, str);
            tabAt.getCustomView().setSelected(false);
            this.PrepareContext = true;
        }
    }

    private void getAuthRequestContext(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(NewWalletFragment.WALLET_SECTION, str);
        BuiltInFictitiousFunctionClassFactory(FragmentTag.WALLET_FRAGMENT, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda1, bundle, true, false);
        FragmentManager childFragmentManager = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
        if ((childFragmentManager == null ? null : childFragmentManager.findFragmentByTag(FragmentTag.WALLET_FRAGMENT)) == null || this.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory();
        } else {
            FragmentManager childFragmentManager2 = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
            WalletFragmentManager walletFragmentManager = new WalletFragmentManager(childFragmentManager2 != null ? childFragmentManager2.findFragmentByTag(FragmentTag.WALLET_FRAGMENT) : null);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = walletFragmentManager;
            if (walletFragmentManager != null) {
                walletFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory(str2, this.C);
        this.scheduleImpl = 3;
        MyBillsEntityDataFactory(3);
    }

    private void PlaceComponentResult(String str) {
        int indexOf = this.initRecordTimeStamp.indexOf(str);
        if (indexOf >= 0) {
            this.initRecordTimeStamp.remove(indexOf);
        }
        this.initRecordTimeStamp.add(str);
    }

    public final void getAuthRequestContext(List<Target> list) {
        Trace startTrace = FirebasePerformance.startTrace("Normal Tooltip - Show");
        if (list == null || list.isEmpty() || this.J != null || this.AppCompatEmojiTextHelper) {
            startTrace.stop();
            return;
        }
        this.AppCompatEmojiTextHelper = true;
        PagerShowcaseBuilder pagerShowcaseBuilder = new PagerShowcaseBuilder(getBaseActivity());
        pagerShowcaseBuilder.GetContactSyncConfig = list;
        this.J = pagerShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.home.tab.HomeTabFragment.12
            {
                HomeTabFragment.this = this;
            }

            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public void onFinished(int i) {
                HomeTabFragment.this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
                HomeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabFragment.this);
                HomeTabFragment.this.homePresenter.get().getAuthRequestContext(UserEducationScenarioKt.HOME_PAGE);
                HomeTabFragment.this.firstTimePresenter.get().BuiltInFictitiousFunctionClassFactory();
                if (HomeTabFragment.this.E) {
                    HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                } else {
                    HomeTabFragment.this.getErrorConfigVersion();
                }
            }
        }).PlaceComponentResult();
        NetworkUserEntityData$$ExternalSyntheticLambda4();
        startTrace.stop();
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.HOME_TOOLTIP_APPEAR;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        if (getBinding() != null) {
            TabLayout tabLayout = getBinding().getAuthRequestContext;
            tabLayout.clearOnTabSelectedListeners();
            final boolean z = this.newProxyInstance;
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: id.dana.home.tab.HomeTabFragment.13
                {
                    HomeTabFragment.this = this;
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    HomeTabFragment.this.MyBillsEntityDataFactory(position);
                    HomeTabFragment.getAuthRequestContext(HomeTabFragment.this, position);
                    HomeTabFragment.PlaceComponentResult(HomeTabFragment.this, position, z);
                    if (position != 0) {
                        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(true);
                        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(TrackerKey.Property.NAVIGATES_OUT, true);
                    }
                    if (position == 0) {
                        HomeTabFragment.initRecordTimeStamp(HomeTabFragment.this);
                        HomeTabFragment.lookAheadTest(HomeTabFragment.this);
                        HomeTabFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    }
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(TabLayout.Tab tab) {
                    if (tab.getCustomView() != null) {
                        tab.getCustomView().setSelected(false);
                    }
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabReselected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    HomeTabFragment.PlaceComponentResult(HomeTabFragment.this, position, z);
                    if (position != 0) {
                        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(true);
                    }
                }
            });
        }
        getAuthRequestContext(this.newProxyInstance);
        if (getBinding() != null) {
            getBinding().MyBillsEntityDataFactory.setVisibility(0);
        }
        if (this.getValueOfTouchPositionAbsolute) {
            return;
        }
        this.homeTracker.get().KClassImpl$Data$declaredNonStaticMembers$2();
        this.getValueOfTouchPositionAbsolute = true;
    }

    public void MyBillsEntityDataFactory(int i) {
        FragmentHomeTabBinding binding = getBinding();
        if (binding != null) {
            int tabCount = binding.getAuthRequestContext.getTabCount();
            int i2 = 0;
            while (i2 < tabCount) {
                TabLayout.Tab tabAt = binding.getAuthRequestContext.getTabAt(i2);
                if (tabAt != null && tabAt.getCustomView() != null) {
                    tabAt.getCustomView().setSelected(i == i2);
                }
                i2++;
            }
        }
    }

    private void getAuthRequestContext(boolean z) {
        if (getBinding() != null) {
            TabLayout tabLayout = getBinding().getAuthRequestContext;
            tabLayout.removeAllTabs();
            if (getBinding() != null) {
                TabLayout tabLayout2 = getBinding().getAuthRequestContext;
                tabLayout2.addTab(tabLayout2.newTab().setCustomView(new NavigationTabView(getContext(), (int) R.drawable.ic_nav_home, getString(R.string.nav_home_title))), !KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs.HOME));
            }
            NavigationTabView navigationTabView = new NavigationTabView(getContext(), (int) R.drawable.ic_nav_history, getString(R.string.nav_history_title));
            this.getNameOrBuilderList = navigationTabView;
            navigationTabView.setContentDescription(getResources().getString(R.string.btnHistory));
            if (getBinding() != null) {
                TabLayout tabLayout3 = getBinding().getAuthRequestContext;
                tabLayout3.addTab(tabLayout3.newTab().setCustomView(this.getNameOrBuilderList), KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs.HISTORY));
            }
            tabLayout.addTab(tabLayout.newTab().setCustomView(MainNavigationTabView.generate(getContext())));
            this.K = new PocketNavigationView(getContext(), (int) R.drawable.ic_nav_pocket, getString(R.string.nav_pocket_title));
            if (getBinding() != null) {
                TabLayout tabLayout4 = getBinding().getAuthRequestContext;
                if (z) {
                    tabLayout4.addTab(tabLayout4.newTab().setCustomView(new NavigationTabView(getContext(), (int) R.drawable.ic_nav_wallet, getString(R.string.nav_wallet_title))), KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs.WALLET));
                } else {
                    this.K = new PocketNavigationView(getContext(), (int) R.drawable.ic_nav_pocket, getString(R.string.nav_pocket_title));
                    tabLayout4.addTab(tabLayout4.newTab().setCustomView(this.K), KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs.POCKET));
                }
            }
            this.L = new ProfileNavigationTabView(getContext());
            if (getBinding() != null) {
                TabLayout tabLayout5 = getBinding().getAuthRequestContext;
                tabLayout5.addTab(tabLayout5.newTab().setCustomView(this.L), KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs.ME));
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext().getApplicationContext());
        builder.MyBillsEntityDataFactory = str;
        if (str2 != null) {
            builder.MyBillsEntityDataFactory("Source", str2);
            IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IDLE_TIME, IdleTimeUtil.PlaceComponentResult());
        }
        if (str.equals(TrackerKey.Event.TRANSACTION_HISTORY_OPEN)) {
            FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory();
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.ROAMING_TIME, FirstActionEntryPointClickTracker.PlaceComponentResult(IdleTimeUtil.MyBillsEntityDataFactory()));
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.TOTAL_TIME, FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0()));
        }
        IdleTimeUtil idleTimeUtil2 = IdleTimeUtil.INSTANCE;
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IDLE_TIME, IdleTimeUtil.PlaceComponentResult());
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }

    public final void scheduleImpl() {
        if (this.I == null) {
            this.I = this.dynamicUrlWrapper.get().getPocketUrl();
        }
        BuiltInFictitiousFunctionClassFactory(this.I, HomeTabVariant.POCKET);
    }

    /* renamed from: id.dana.home.tab.HomeTabFragment$14 */
    /* loaded from: classes2.dex */
    public class AnonymousClass14 implements DanaH5Listener {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.utils.danah5.DanaH5Listener
        public void onContainerCreated(Bundle bundle) {
        }

        AnonymousClass14(String str) {
            HomeTabFragment.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Override // id.dana.utils.danah5.DanaH5Listener
        public void onContainerDestroyed(Bundle bundle) {
            HomeTabFragment homeTabFragment = HomeTabFragment.this;
            if (homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 && homeTabFragment.KClassImpl$Data$declaredNonStaticMembers$2()) {
                homeTabFragment.homePresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
            }
            HomeTabFragment.this.h5EventPresenter.get().BuiltInFictitiousFunctionClassFactory();
            if (HomeTabVariant.POCKET.equals(this.BuiltInFictitiousFunctionClassFactory)) {
                HomeTabFragment.this.K.setBadge(false);
            } else if (!"TRANSACTION_HISTORY".equals(this.BuiltInFictitiousFunctionClassFactory)) {
                return;
            } else {
                HomeTabFragment.this.getNameOrBuilderList.setUnreadNotif(0, false);
                if (HomeTabFragment.this.MyBillsEntityDataFactory) {
                    HomeTabFragment.this.playStoreReviewPresenter.get().PlaceComponentResult();
                }
            }
            HomeTabFragment.this.lookAheadTest();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (!GContainer.isOpeningH5()) {
            DanaH5.startContainerFullUrlWithSendCredentials(str, new AnonymousClass14(str2));
        }
        this.MyBillsEntityDataFactory = false;
        this.h5EventPresenter.get().MyBillsEntityDataFactory();
    }

    public final void lookAheadTest() {
        if (this.B.isEmpty()) {
            return;
        }
        int size = this.B.size() - 1;
        int intValue = this.B.get(size).intValue();
        this.scheduleImpl = intValue;
        this.B.remove(size);
        MyBillsEntityDataFactory(intValue);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        HomeTabActivity homeTabActivity;
        Lazy<InterstitialPromotionBannerContract.Presenter> lazy;
        SwipeDelegateListener swipeDelegateListener;
        byte b = 0;
        if (PlaceComponentResult == i && i2 == 0 && intent != null) {
            if (intent.getBooleanExtra("cancel_to_scan", false) && (swipeDelegateListener = this.NetworkUserEntityData$$ExternalSyntheticLambda6) != null) {
                swipeDelegateListener.BuiltInFictitiousFunctionClassFactory();
                return;
            }
        } else if (readMicros != i) {
            if (getCallingPid == i && (homeTabActivity = (HomeTabActivity) getBaseActivity()) != null) {
                homeTabActivity.nextOnboardingStep();
            }
        } else {
            if (-1 == i2 && intent != null) {
                Lazy<InterstitialPromotionBannerContract.Presenter> lazy2 = this.interstitialPresenter;
                if (lazy2 != null) {
                    lazy2.get().getAuthRequestContext();
                    this.interstitialPresenter.get().PlaceComponentResult();
                }
                CdpContentModel cdpContentModel = (CdpContentModel) intent.getParcelableExtra(InterstitialBannerActivity.KEY_CDPCONTENTMODEL);
                String stringExtra = intent.getStringExtra("spaceCode");
                boolean booleanExtra = intent.getBooleanExtra(InterstitialBannerActivity.KEY_BANNERREAD, false);
                if (cdpContentModel != null) {
                    if (!TextUtils.isEmpty(cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && (lazy = this.interstitialPresenter) != null) {
                        lazy.get().KClassImpl$Data$declaredNonStaticMembers$2(cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    }
                    String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4, TopupSource.PROMOTION_BANNER);
                    if (booleanExtra && !TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
                        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_BANNER_OPEN;
                        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, cdpContentModel.DatabaseTableConfigUtil).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, stringExtra);
                        if (cdpContentModel.PrepareContext != null) {
                            MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(cdpContentModel.PrepareContext, "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
                        }
                        MyBillsEntityDataFactory.PlaceComponentResult();
                        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
                        KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, (Intent) null);
                    }
                }
            }
            HomeTabActivity homeTabActivity2 = (HomeTabActivity) getBaseActivity();
            if (homeTabActivity2 != null) {
                homeTabActivity2.nextOnboardingStep();
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ContextUtils.MyBillsEntityDataFactory(requireContext(), this.whenAvailable);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        super.onDestroy();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, Intent intent) {
        Lazy<ReadLinkPropertiesContract.Presenter> lazy;
        if (UrlUtil.getErrorConfigVersion(str) && (lazy = this.readDeepLinkPropertiesPresenter) != null) {
            lazy.get().MyBillsEntityDataFactory(str, intent);
        } else {
            DanaH5.startContainerFullUrl(str);
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(HomeTabs homeTabs) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3 == homeTabs;
    }

    private boolean GetContactSyncConfig() {
        return ((HomeTabActivity) getBaseActivity()).getDanaApplication().getIsKybRevamp();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        HomeFragmentManager homeFragmentManager;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 && !z && !PrepareContext()) {
            if (!DeeplinkSaveDataManager.MyBillsEntityDataFactory().PlaceComponentResult() || (homeFragmentManager = this.GetContactSyncConfig) == null) {
                initRecordTimeStamp();
            } else {
                homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            getAuthRequestContext();
        }
    }

    private void initRecordTimeStamp() {
        Boolean bool;
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8 || getActivity() == null || getActivity().getIntent().getData() == null || getActivity().getIntent().hasExtra("branch_force_new_session")) {
            return;
        }
        String obj = getActivity().getIntent().getData().toString();
        if (obj == null || obj.isEmpty()) {
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.valueOf(UrlUtil.getErrorConfigVersion(obj) || UrlUtil.moveToNextValue(obj) || UrlUtil.BuiltInFictitiousFunctionClassFactory(obj));
        }
        if (bool.booleanValue()) {
            if (!DeeplinkSaveDataManager.MyBillsEntityDataFactory().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                this.deepLinkPresenter.get().PlaceComponentResult(false);
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity instanceof HomeTabActivity) {
                ((HomeTabActivity) activity).showDeeplinkErrorDialog();
            }
        }
    }

    public final void getAuthRequestContext() {
        boolean z;
        if (BranchDeeplinkUtil.getAuthRequestContext(getActivity())) {
            this.deepLinkPresenter.get().BuiltInFictitiousFunctionClassFactory(requireActivity());
        }
        if (DeepLinkParser.PlaceComponentResult()) {
            DanaH5.startContainerFullUrl("https://m.dana.id/m/withdraw");
        }
        z = DeepLinkParser.MyBillsEntityDataFactory;
        if (z) {
            DanaH5.startContainerFullUrl("https://m.dana.id/m/luckywheel");
        }
        if (DeepLinkParser.lookAheadTest()) {
            String BuiltInFictitiousFunctionClassFactory = DeepLinkParser.BuiltInFictitiousFunctionClassFactory();
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(String.format(DanaUrl.LUCKY_MONEY, BuiltInFictitiousFunctionClassFactory));
            DanaH5.startContainerFullUrl(sb.toString());
        }
        if (DeepLinkParser.scheduleImpl()) {
            DeepLinkParser.BuiltInFictitiousFunctionClassFactory = false;
            try {
                if (this.dynamicUrlWrapper == null || getActivity() == null || getActivity().getIntent() == null) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(this.dynamicUrlWrapper.get().getReadEMoney(), (Intent) getActivity().getIntent().getParcelableExtra("android.nfc.extra.TAG"));
            } catch (ClassCastException unused) {
            } catch (NullPointerException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("android.nfc.extra.TAG");
                sb2.append(e.getMessage());
                CrashlyticsLogUtil.PlaceComponentResult("android.nfc.extra.TAG", sb2.toString(), e);
            }
        }
        if (DeepLinkParser.moveToNextValue()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://m.dana.id");
            sb3.append(String.format(DanaUrl.PAYMENT_LINK, DeepLinkParser.BuiltInFictitiousFunctionClassFactory()));
            String obj = sb3.toString();
            CashierEventHandler cashierEventHandler = this.cashierEventHandler.get();
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullParameter(baseActivity, "");
            Intrinsics.checkNotNullParameter(obj, "");
            cashierEventHandler.BuiltInFictitiousFunctionClassFactory(baseActivity, obj, null, TrackerKey.SourceType.DEEP_LINK);
        }
        if (PrepareContext()) {
            this.scanQrPresenter.get().getAuthRequestContext();
            this.homeRevampPresenter.get().PlaceComponentResult();
        }
    }

    private static boolean PrepareContext() {
        String str = DeeplinkSaveDataManager.MyBillsEntityDataFactory().DatabaseTableConfigUtil;
        if (str == null) {
            str = "";
        }
        return !str.isEmpty();
    }

    private void PlaceComponentResult(int i) {
        if (getBinding() != null) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(i);
            getBinding().MyBillsEntityDataFactory.setVisibility(i);
        }
    }

    public final boolean moveToNextValue() {
        return getBinding() != null && getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getVisibility() == 0 && getBinding().MyBillsEntityDataFactory.getVisibility() == 0;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (getBinding() != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, i);
            getBinding().BuiltInFictitiousFunctionClassFactory.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: id.dana.home.tab.HomeTabFragment$17 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass17 {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[HomeTabs.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[HomeTabs.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[HomeTabs.HISTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[HomeTabs.PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[HomeTabs.POCKET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[HomeTabs.ME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: id.dana.home.tab.HomeTabFragment$15 */
    /* loaded from: classes2.dex */
    class AnonymousClass15 implements ScanQrContract.View {
        public static /* synthetic */ void lookAheadTest() {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void BuiltInFictitiousFunctionClassFactory(ScanModel scanModel) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final FeatureTimeModel MyBillsEntityDataFactory() {
            return null;
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void MyBillsEntityDataFactory(boolean z) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final String PlaceComponentResult() {
            return null;
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void PlaceComponentResult(String str) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void PlaceComponentResult(boolean z) {
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void dismissProgress() {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void getAuthRequestContext(QrBindingConfig qrBindingConfig) {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void getErrorConfigVersion() {
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void moveToNextValue() {
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void onError(String str) {
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void showProgress() {
        }

        AnonymousClass15() {
            HomeTabFragment.this = r1;
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void PlaceComponentResult(ScanModel scanModel) {
            PlaceComponentResult(scanModel, false, false);
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void BuiltInFictitiousFunctionClassFactory() {
            HomeTabFragment.this.getBaseActivity().showWarningDialog(HomeTabFragment.this.getString(R.string.send_to_self_number_error), new DialogInterface.OnDismissListener() { // from class: id.dana.home.tab.HomeTabFragment$15$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    HomeTabFragment.AnonymousClass15.lookAheadTest();
                }
            }, true, 3000);
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void BuiltInFictitiousFunctionClassFactory(String str) {
            ((HomeTabActivity) HomeTabFragment.this.getActivity()).showWarningDialog(ErrorUtil.MyBillsEntityDataFactory(HomeTabFragment.this.getContext()));
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void getAuthRequestContext() {
            HomeTabFragment.this.getBaseActivity().startActivity(SplitBillDetailsActivity.createNonEligibleUserIntent(HomeTabFragment.this.getContext(), "Scan QR"));
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void getAuthRequestContext(ScanModel scanModel, boolean z) {
            PlaceComponentResult(scanModel, true, z);
        }

        @Override // id.dana.contract.staticqr.ScanQrContract.View
        public final void PlaceComponentResult(String str, String str2, String str3, Throwable th) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(HomeTabFragment.this.getContext(), str2, str3, str, th);
        }

        private void PlaceComponentResult(ScanModel scanModel, boolean z, boolean z2) {
            if (HomeTabFragment.this.G == null) {
                HomeTabFragment.this.G = new ScannerActionFactory(HomeTabFragment.this.getBaseActivity());
            }
            HomeTabFragment.this.G.getAuthRequestContext = z2;
            HomeTabFragment.this.G.MyBillsEntityDataFactory = z;
            HomeTabFragment.this.G.MyBillsEntityDataFactory(null, scanModel, ScannerViewType.FRAGMENT, "", null).PlaceComponentResult();
        }
    }

    public final void getErrorConfigVersion() {
        Lazy<HomeInfoContract.Presenter> lazy = this.homePresenter;
        if (lazy != null && !this.isLayoutRequested && this.newProxyInstance) {
            this.D = true;
            lazy.get().KClassImpl$Data$declaredNonStaticMembers$2(UserEducationPreference.WALLET_TAB_MENU_TOOLTIP);
            return;
        }
        HomeTabActivity homeTabActivity = (HomeTabActivity) getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    public static long PlaceComponentResult() {
        return System.currentTimeMillis() / 1000;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(HomeTabFragment homeTabFragment) {
        HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    static /* synthetic */ void getAuthRequestContext(final HomeTabFragment homeTabFragment) {
        if (homeTabFragment.newProxyInstance() && homeTabFragment.BottomSheetCardBindingView$watcherCardNumberView$1) {
            new PermissionPromptBottomSheetDialog("home", new Function0() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    HomeTabFragment homeTabFragment2 = HomeTabFragment.this;
                    HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment2.getBaseActivity();
                    if (homeTabActivity != null) {
                        homeTabActivity.nextOnboardingStep();
                    }
                    PermissionHelper.MyBillsEntityDataFactory(homeTabFragment2.requireContext());
                    return Unit.INSTANCE;
                }
            }, new Function0() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    HomeTabActivity homeTabActivity = (HomeTabActivity) HomeTabFragment.this.getBaseActivity();
                    if (homeTabActivity != null) {
                        homeTabActivity.nextOnboardingStep();
                    }
                    return Unit.INSTANCE;
                }
            }).BuiltInFictitiousFunctionClassFactory(homeTabFragment.getBaseActivity().getSupportFragmentManager());
            homeTabFragment.homeRevampPresenter.get().getAuthRequestContext(System.currentTimeMillis() / 1000, false);
            return;
        }
        HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeTabFragment homeTabFragment) {
        if (homeTabFragment.getBaseActivity() instanceof HomeTabActivity) {
            ((HomeTabActivity) homeTabFragment.getBaseActivity()).nextOnboardingStep();
        }
    }

    static /* synthetic */ void PlaceComponentResult(final HomeTabFragment homeTabFragment, boolean z) {
        Target target;
        if (z && homeTabFragment.newProxyInstance() && homeTabFragment.BottomSheetCardBindingView$watcherCardNumberView$1 && !homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            if (homeTabFragment.getBinding() != null) {
                TabLayout.Tab tabAt = homeTabFragment.getBinding().getAuthRequestContext.getTabAt(3);
                CircleShape circleShape = new CircleShape(getSupportButtonTintMode);
                if (tabAt != null) {
                    target = new TargetBuilder(homeTabFragment.getBaseActivity()).BuiltInFictitiousFunctionClassFactory(tabAt.view).BuiltInFictitiousFunctionClassFactory(circleShape).getAuthRequestContext(new Content(homeTabFragment.getResources().getString(R.string.tooltip_wallet_menu_title), homeTabFragment.getResources().getString(R.string.tooltip_wallet_menu_desc), (int) R.drawable.ic_tooltip_home_scan)).KClassImpl$Data$declaredNonStaticMembers$2();
                    if (target == null && homeTabFragment.P == null) {
                        homeTabFragment.D = false;
                        TwoButtonWithImageShowcaseBuilder MyBillsEntityDataFactory = new TwoButtonWithImageShowcaseBuilder(homeTabFragment.getBaseActivity(), target).BuiltInFictitiousFunctionClassFactory(false).MyBillsEntityDataFactory(homeTabFragment.getResources().getString(R.string.tooltip_wallet_menu_positive_btn_text), new View.OnClickListener() { // from class: id.dana.home.tab.HomeTabFragment$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                HomeTabFragment.this.getAuthRequestContext(0, TrackerKey.SourceType.TAB_BAR);
                            }
                        }, homeTabFragment.getResources().getString(R.string.wallet_btn_explore_now_tooltip_home));
                        String string = homeTabFragment.getResources().getString(R.string.tooltip_wallet_menu_negative_btn_text);
                        String string2 = homeTabFragment.getResources().getString(R.string.wallet_btn_later_tooltip_home);
                        Intrinsics.checkNotNullParameter(string, "");
                        Intrinsics.checkNotNullParameter(string2, "");
                        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = string;
                        MyBillsEntityDataFactory.PlaceComponentResult = string2;
                        homeTabFragment.P = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.home.tab.HomeTabFragment.16
                            {
                                HomeTabFragment.this = homeTabFragment;
                            }

                            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                            public void onFinished(int i) {
                                HomeTabFragment.newProxyInstance(HomeTabFragment.this);
                                HomeTabFragment.MyBillsEntityDataFactory(HomeTabFragment.this);
                            }

                            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                            public void onStarted() {
                                HomeTabFragment.this.homePresenter.get().getAuthRequestContext(UserEducationPreference.WALLET_TAB_MENU_TOOLTIP);
                            }
                        }).PlaceComponentResult();
                        return;
                    }
                    return;
                }
            }
            target = null;
            if (target == null) {
                return;
            }
            return;
        }
        HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    static /* synthetic */ void getAuthRequestContext(HomeTabFragment homeTabFragment, boolean z) {
        if (!z || !homeTabFragment.newProxyInstance() || !homeTabFragment.BottomSheetCardBindingView$watcherCardNumberView$1 || homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            homeTabFragment.PlaceComponentResult(true);
            HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
            if (homeTabActivity != null) {
                homeTabActivity.nextOnboardingStep();
                return;
            }
            return;
        }
        FragmentManager childFragmentManager = (homeTabFragment.getActivity() == null || !homeTabFragment.isAdded()) ? null : homeTabFragment.getChildFragmentManager();
        if ((childFragmentManager == null ? null : (HomeRecycleFragment) childFragmentManager.findFragmentByTag(FragmentTag.HOME_FRAGMENT)) != null) {
            FragmentManager childFragmentManager2 = (homeTabFragment.getActivity() == null || !homeTabFragment.isAdded()) ? null : homeTabFragment.getChildFragmentManager();
            HomeRecycleFragment homeRecycleFragment = childFragmentManager2 != null ? (HomeRecycleFragment) childFragmentManager2.findFragmentByTag(FragmentTag.HOME_FRAGMENT) : null;
            if (homeRecycleFragment == null || !homeRecycleFragment.isVisible()) {
                return;
            }
            homeTabFragment.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable();
            homeTabFragment.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            homeTabFragment.getAuthRequestContext(homeTabFragment.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig());
            homeTabFragment.PlaceComponentResult(true);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(HomeTabFragment homeTabFragment, PromotionModel promotionModel) {
        if (homeTabFragment.newProxyInstance() && homeTabFragment.BottomSheetCardBindingView$watcherCardNumberView$1) {
            homeTabFragment.getAuthRequestContext(promotionModel);
            return;
        }
        homeTabFragment.F = true;
        homeTabFragment.M = promotionModel;
        HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(HomeTabFragment homeTabFragment, boolean z) {
        if (z) {
            homeTabFragment.E = true;
            homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
            return;
        }
        HomeTabActivity homeTabActivity = (HomeTabActivity) homeTabFragment.getBaseActivity();
        if (homeTabActivity != null) {
            homeTabActivity.nextOnboardingStep();
        }
    }

    static /* synthetic */ void getAuthRequestContext(HomeTabFragment homeTabFragment, int i) {
        WalletFragmentManager walletFragmentManager;
        if (i != 3 || (walletFragmentManager = homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda4) == null) {
            return;
        }
        Fragment fragment = walletFragmentManager.MyBillsEntityDataFactory;
        NewWalletFragment newWalletFragment = fragment instanceof NewWalletFragment ? (NewWalletFragment) fragment : null;
        if (newWalletFragment != null) {
            newWalletFragment.setSkipLoadData(false);
        }
    }

    static /* synthetic */ void PlaceComponentResult(HomeTabFragment homeTabFragment, int i, boolean z) {
        int i2 = homeTabFragment.scheduleImpl;
        int indexOf = homeTabFragment.B.indexOf(Integer.valueOf(i2));
        if (indexOf >= 0) {
            homeTabFragment.B.remove(indexOf);
        }
        homeTabFragment.B.add(Integer.valueOf(i2));
        homeTabFragment.scheduleImpl = i;
        if (i == 0) {
            homeTabFragment.BuiltInFictitiousFunctionClassFactory(FragmentTag.HOME_FRAGMENT, homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, homeTabFragment.getErrorConfigVersion, null, false, false);
        } else if (i != 1) {
            if (i == 2) {
                homeTabFragment.startActivityForResult(PayActivity.createPayActivityIntent(homeTabFragment.getBaseActivity(), TrackerKey.SourceType.HOME_PAY_BUTTON), PlaceComponentResult);
            } else if (i != 3) {
                if (i == 4) {
                    FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
                    FirstActionTracker.MyBillsEntityDataFactory();
                    homeTabFragment.BuiltInFictitiousFunctionClassFactory(FragmentTag.ME_FRAGMENT, homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, MyProfileMainFragment.class, MyProfileMainFragment.getAuthRequestContext(((HomeTabActivity) homeTabFragment.getBaseActivity()).getDanaApplication().getIsMePageRevamp().booleanValue(), homeTabFragment.GetContactSyncConfig(), homeTabFragment.NetworkUserEntityData$$ExternalSyntheticLambda5), false, false);
                    homeTabFragment.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.PROFILE_PAGE_OPEN, TrackerKey.SourceType.CLICK);
                }
            } else if (z) {
                if (homeTabFragment.PrepareContext) {
                    homeTabFragment.getAuthRequestContext(homeTabFragment.FragmentBottomSheetPaymentSettingBinding, TrackerKey.SourceType.TAB_BAR);
                }
            } else {
                homeTabFragment.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.POCKET_OPEN, (String) null);
                homeTabFragment.scheduleImpl();
            }
        } else {
            FirstActionTracker firstActionTracker2 = FirstActionTracker.INSTANCE;
            FirstActionTracker.MyBillsEntityDataFactory();
            homeTabFragment.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.TRANSACTION_HISTORY_OPEN, (String) null);
            boolean hasUnreadNotif = homeTabFragment.getNameOrBuilderList.hasUnreadNotif();
            if (homeTabFragment.VerifyPinStateManager$executeRiskChallenge$2$2) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(homeTabFragment.H);
                String obj = sb.toString();
                if (!GContainer.isOpeningH5()) {
                    DanaH5.startContainerFullUrlWithSendCredentials(obj, new AnonymousClass14("TRANSACTION_HISTORY"));
                }
                homeTabFragment.MyBillsEntityDataFactory = false;
                homeTabFragment.h5EventPresenter.get().MyBillsEntityDataFactory();
            } else if (hasUnreadNotif) {
                String transactionProgressingUrl = homeTabFragment.dynamicUrlWrapper.get().getTransactionProgressingUrl();
                if (!GContainer.isOpeningH5()) {
                    DanaH5.startContainerFullUrlWithSendCredentials(transactionProgressingUrl, new AnonymousClass14("TRANSACTION_HISTORY"));
                }
                homeTabFragment.MyBillsEntityDataFactory = false;
                homeTabFragment.h5EventPresenter.get().MyBillsEntityDataFactory();
            } else {
                String transactionCompletedUrl = homeTabFragment.dynamicUrlWrapper.get().getTransactionCompletedUrl();
                if (!GContainer.isOpeningH5()) {
                    DanaH5.startContainerFullUrlWithSendCredentials(transactionCompletedUrl, new AnonymousClass14("TRANSACTION_HISTORY"));
                }
                homeTabFragment.MyBillsEntityDataFactory = false;
                homeTabFragment.h5EventPresenter.get().MyBillsEntityDataFactory();
            }
        }
    }

    static /* synthetic */ void initRecordTimeStamp(HomeTabFragment homeTabFragment) {
        try {
            if (homeTabFragment.getActivity() != null) {
                ((OnResumeInterceptor) homeTabFragment.getActivity()).onResumeFromFragment();
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_TAG, e.getMessage());
        }
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabFragment homeTabFragment, boolean z) {
        FragmentManager childFragmentManager = (homeTabFragment.getActivity() == null || !homeTabFragment.isAdded()) ? null : homeTabFragment.getChildFragmentManager();
        if ((childFragmentManager != null ? (HomeRecycleFragment) childFragmentManager.findFragmentByTag(FragmentTag.HOME_FRAGMENT) : null) != null) {
            HomeFragmentManager homeFragmentManager = homeTabFragment.GetContactSyncConfig;
            if (homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.isViewBinded()) {
                homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(z);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2) {
        FragmentManager childFragmentManager = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
        if (childFragmentManager == null) {
            return;
        }
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(str2);
        Fragment findFragmentByTag2 = childFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null && findFragmentByTag2 != null) {
            if (z) {
                findFragmentByTag2.setArguments(bundle);
            }
            if (!z2) {
                PlaceComponentResult(str2);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            beginTransaction.isLayoutRequested = true;
            beginTransaction.PlaceComponentResult(findFragmentByTag).BuiltInFictitiousFunctionClassFactory(findFragmentByTag2).getAuthRequestContext();
        } else if (findFragmentByTag2 != null || cls == null || findFragmentByTag == null) {
        } else {
            if (!z2) {
                PlaceComponentResult(str2);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            FragmentTransaction beginTransaction2 = childFragmentManager.beginTransaction();
            beginTransaction2.isLayoutRequested = true;
            FragmentTransaction MyBillsEntityDataFactory = beginTransaction2.PlaceComponentResult(findFragmentByTag).MyBillsEntityDataFactory(R.id.fragment_container_view, cls, bundle, str);
            if (!MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
            }
            MyBillsEntityDataFactory.scheduleImpl = true;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = str2;
            MyBillsEntityDataFactory.getAuthRequestContext();
            childFragmentManager.executePendingTransactions();
        }
    }

    private HomeRecycleFragment FragmentBottomSheetPaymentSettingBinding() {
        FragmentManager childFragmentManager = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
        if (childFragmentManager == null) {
            return null;
        }
        return (HomeRecycleFragment) childFragmentManager.findFragmentByTag(FragmentTag.HOME_FRAGMENT);
    }

    private MyProfileMainFragment NetworkUserEntityData$$ExternalSyntheticLambda5() {
        FragmentManager childFragmentManager = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
        if (childFragmentManager == null) {
            return null;
        }
        return (MyProfileMainFragment) childFragmentManager.findFragmentByTag(FragmentTag.ME_FRAGMENT);
    }

    @Override // id.dana.wallet_v3.listener.WalletTabListener
    public void hideTabBarMenu() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        ConnectivitySnackbarManager connectivitySnackbarManager = this.lookAheadTest;
        if (connectivitySnackbarManager != null && connectivitySnackbarManager.KClassImpl$Data$declaredNonStaticMembers$2.isShownOrQueued()) {
            connectivitySnackbarManager.KClassImpl$Data$declaredNonStaticMembers$2.dismiss();
        }
        PlaceComponentResult(8);
        KClassImpl$Data$declaredNonStaticMembers$2(0);
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public /* synthetic */ FragmentHomeTabBinding initViewBinding(View view) {
        return FragmentHomeTabBinding.getAuthRequestContext(view);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        Boolean bool;
        FragmentActivity activity = getActivity();
        if (activity instanceof AppReadyConsumedProvider) {
            bool = ((AppReadyConsumedProvider) activity).isConsumed();
        } else {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue() && this.NetworkUserEntityData$$ExternalSyntheticLambda8 && !this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.homeRevampPresenter.get().getAuthRequestContext();
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.pushNotificationPresenter.get().PlaceComponentResult();
            }
            this.connectivityMonitorPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
            HomeFragmentManager homeFragmentManager = this.GetContactSyncConfig;
            if (homeFragmentManager != null) {
                homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding();
            }
        }
    }

    @Override // id.dana.base.BaseFragment
    public boolean onBackPressed() {
        FragmentManager childFragmentManager = (getActivity() == null || !isAdded()) ? null : getChildFragmentManager();
        if (childFragmentManager != null && childFragmentManager.getFragments().size() > 1) {
            return childFragmentManager.popBackStackImmediate();
        }
        return super.onBackPressed();
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        int i = this.scheduleImpl;
        if (i == 0) {
            HomeFragmentManager homeFragmentManager = this.GetContactSyncConfig;
            if (homeFragmentManager != null) {
                homeFragmentManager.KClassImpl$Data$declaredNonStaticMembers$2.onSelected();
            }
        } else if (i == 3) {
            WalletFragmentManager walletFragmentManager = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (walletFragmentManager != null) {
                walletFragmentManager.MyBillsEntityDataFactory();
            }
        } else if (i == 4) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda5() != null) {
                NetworkUserEntityData$$ExternalSyntheticLambda5().onSelected();
            }
        } else {
            DanaLog.scheduleImpl("HomeTabFragment", "Default selected log on Tab");
        }
        super.onSelected();
    }

    @Override // id.dana.wallet_v3.listener.WalletTabListener
    public void showTabBarMenu() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        ConnectivitySnackbarManager connectivitySnackbarManager = this.lookAheadTest;
        if (connectivitySnackbarManager != null) {
            connectivitySnackbarManager.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue);
        }
        PlaceComponentResult(0);
        KClassImpl$Data$declaredNonStaticMembers$2((int) getResources().getDimension(R.dimen.f33312131165970));
    }
}
