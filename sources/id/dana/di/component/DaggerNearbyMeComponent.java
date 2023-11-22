package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.contract.nearbyme.NearbyPresenter;
import id.dana.contract.nearbyme.NearbyPresenter_Factory;
import id.dana.di.modules.NearbyMeModule;
import id.dana.di.modules.NearbyMeModule_ProvideNearbyMePresenterFactory;
import id.dana.di.modules.NearbyMeModule_ProvideNearbyMeViewFactory;
import id.dana.di.modules.NearbyMeModule_ProvideNearbymeTrackerFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeFeature;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeFeature_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius_Factory;
import id.dana.domain.nearbyme.interactor.IsNearbyReviewPageEnabled;
import id.dana.domain.nearbyme.interactor.IsNearbyReviewPageEnabled_Factory;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip_Factory;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.drawable.ShopRankingCalculator_Factory;
import id.dana.nearbyme.NearbyMeActivity;
import id.dana.nearbyme.NearbyMeActivity_MembersInjector;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.NearbyPromoModelMapper_Factory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.MapHelper;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerNearbyMeComponent {
    private DaggerNearbyMeComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public NearbyMeModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class NearbyMeComponentImpl implements NearbyMeComponent {
        private Provider<NearbyAnalyticTracker> A;
        private Provider<SaveShowOnboardingTooltip> B;
        private Provider<ThreadExecutor> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetNearbyRankingConfig> DatabaseTableConfigUtil;
        private final NearbyMeComponentImpl FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDistrictNameByLocation> GetContactSyncConfig;
        private Provider<CheckNearbyMeFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GeocodeRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetNearbyShopsWithPagination> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetNearbyConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<MixpanelRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<NearbyMeRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<NearbyDefaultTracker> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<NearbyPresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<IsNearbyReviewPageEnabled> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<GetNearbyShopsWithRadius> PrepareContext;
        private Provider<NearbyMeContract.Presenter> SubSequence;
        private Provider<SSLPinningRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<ConsultMerchantReview> getAuthRequestContext;
        private Provider<NearbyShopsModelMapper> getCallingPid;
        private Provider<FeatureConfigRepository> getErrorConfigVersion;
        private Provider<NearbyPromoModelMapper> getSupportButtonTintMode;
        private Provider<GetNearbyShopsPromo> initRecordTimeStamp;
        private Provider<IsNeedToShowOnboardingToolTip> isLayoutRequested;
        private Provider<Context> lookAheadTest;
        private Provider<GetAutoSearchConfig> moveToNextValue;
        private Provider<MerchantInfoRepository> newProxyInstance;
        private Provider<PostExecutionThread> readMicros;
        private Provider<GetAccount> scheduleImpl;
        private Provider<NearbyMeContract.View> whenAvailable;

        public /* synthetic */ NearbyMeComponentImpl(NearbyMeModule nearbyMeModule, ApplicationComponent applicationComponent, byte b) {
            this(nearbyMeModule, applicationComponent);
        }

        private NearbyMeComponentImpl(NearbyMeModule nearbyMeModule, ApplicationComponent applicationComponent) {
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.FragmentBottomSheetPaymentSettingBinding = this;
            this.PlaceComponentResult = applicationComponent;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new ThreadExecutorProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new SSLPinningRepositoryProvider(applicationComponent);
            this.readMicros = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.VerifyPinStateManager$executeRiskChallenge$2$1, create);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.lookAheadTest = contextProvider;
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(contextProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = BuiltInFictitiousFunctionClassFactory;
            this.A = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbymeTrackerFactory.getAuthRequestContext(nearbyMeModule, BuiltInFictitiousFunctionClassFactory));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckNearbyMeFeature_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, this.getErrorConfigVersion);
            NearbyMeRepositoryProvider nearbyMeRepositoryProvider = new NearbyMeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = nearbyMeRepositoryProvider;
            this.DatabaseTableConfigUtil = GetNearbyRankingConfig_Factory.create(nearbyMeRepositoryProvider);
            MixpanelRepositoryProvider mixpanelRepositoryProvider = new MixpanelRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = mixpanelRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetNearbyShopsWithPagination_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getErrorConfigVersion, mixpanelRepositoryProvider);
            this.whenAvailable = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbyMeViewFactory.PlaceComponentResult(nearbyMeModule));
            MerchantSubcategoriesMapper_Factory authRequestContext = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.getCallingPid = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext, shopOpenHourListMapper_Factory);
            this.PrepareContext = GetNearbyShopsWithRadius_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.initRecordTimeStamp = GetNearbyShopsPromo_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.getSupportButtonTintMode = NearbyPromoModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.isLayoutRequested = IsNeedToShowOnboardingToolTip_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = geocodeRepositoryProvider;
            this.GetContactSyncConfig = GetDistrictNameByLocation_Factory.create(geocodeRepositoryProvider);
            this.B = SaveShowOnboardingTooltip_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.moveToNextValue = GetAutoSearchConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.scheduleImpl = GetAccount_Factory.create(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, accountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetNearbyConfig_Factory.create(this.getErrorConfigVersion);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = IsNearbyReviewPageEnabled_Factory.create(this.getErrorConfigVersion);
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.newProxyInstance = merchantInfoRepositoryProvider;
            this.getAuthRequestContext = ConsultMerchantReview_Factory.create(merchantInfoRepositoryProvider);
            NearbyPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = NearbyPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.whenAvailable, this.getCallingPid, this.PrepareContext, this.initRecordTimeStamp, this.getSupportButtonTintMode, this.isLayoutRequested, this.GetContactSyncConfig, this.B, this.moveToNextValue, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, ShopRankingCalculator_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.getAuthRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = BuiltInFictitiousFunctionClassFactory2;
            this.SubSequence = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbyMePresenterFactory.getAuthRequestContext(nearbyMeModule, BuiltInFictitiousFunctionClassFactory2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class NearbyMeRepositoryProvider implements Provider<NearbyMeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            NearbyMeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ NearbyMeRepository get() {
                return (NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class MixpanelRepositoryProvider implements Provider<MixpanelRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MixpanelRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MixpanelRepository get() {
                return (MixpanelRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.N());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class GeocodeRepositoryProvider implements Provider<GeocodeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GeocodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeocodeRepository get() {
                return (GeocodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.M());
            }
        }

        @Override // id.dana.di.component.NearbyMeComponent
        public final void getAuthRequestContext(NearbyMeActivity nearbyMeActivity) {
            ((BaseActivity) nearbyMeActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(nearbyMeActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(nearbyMeActivity, DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
            NearbyMeActivity_MembersInjector.getAuthRequestContext(nearbyMeActivity, new MapHelper((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
            NearbyMeActivity_MembersInjector.PlaceComponentResult(nearbyMeActivity, this.A.get());
            NearbyMeActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(nearbyMeActivity, this.SubSequence.get());
        }
    }
}
