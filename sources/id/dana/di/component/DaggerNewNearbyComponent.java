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
import id.dana.di.modules.MerchantDetailModule;
import id.dana.di.modules.MerchantDetailModule_ProvidePresenterFactory;
import id.dana.di.modules.MerchantDetailModule_ProvideViewFactory;
import id.dana.di.modules.MerchantModule;
import id.dana.di.modules.MerchantModule_ProvidePresenterFactory;
import id.dana.di.modules.MerchantModule_ProvideViewFactory;
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
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.interactor.CheckMerchantCategoriesFeature;
import id.dana.domain.merchant.interactor.GetMerchantCategories;
import id.dana.domain.merchant.interactor.GetNewMerchantCategories;
import id.dana.domain.merchant.interactor.InitNewMerchantCategories;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.interactor.GetMerchantImage_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo_Factory;
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
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.drawable.NewNearbyMeActivity_MembersInjector;
import id.dana.drawable.ShopRankingCalculator_Factory;
import id.dana.nearbyme.MerchantPresenter;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.NearbyPromoModelMapper_Factory;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideViewFactory;
import id.dana.nearbyme.mapper.MerchantCategoriesMapper;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailPresenter;
import id.dana.nearbyme.merchantdetail.MerchantDetailPresenter_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDetailMapper_Factory;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter_Factory;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.MapHelper;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class DaggerNewNearbyComponent {
    private DaggerNewNearbyComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public NearbyMeModule KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantDetailModule MyBillsEntityDataFactory;
        public MerchantModule PlaceComponentResult;
        public PhotoGalleryModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewNearbyComponentImpl implements NewNearbyComponent {
        private Provider<PhotoGalleryPresenter> A;
        private Provider<MerchantDetailContract.View> AppCompatEmojiTextHelper;
        private Provider<PostExecutionThread> B;
        private Provider<MerchantPhotoGalleryModel> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckNearbyMeFeature> BuiltInFictitiousFunctionClassFactory;
        private Provider<NearbyShopsModelMapper> C;
        private Provider<MerchantDetailContract.Presenter> D;
        private Provider<GetMerchantInfo> DatabaseTableConfigUtil;
        private Provider<NearbyAnalyticTracker> E;
        private Provider<SSLPinningRepository> F;
        private Provider<IsOfflineF2FPay> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SaveShowOnboardingTooltip> G;
        private Provider<GetAutoSearchConfig> GetContactSyncConfig;
        private Provider<ThreadExecutor> H;
        private Provider<PhotoGalleryContract.View> I;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<CoroutineDispatcher> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetMerchantImage> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetNearbyConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<MerchantDetailPresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<IsNeedToShowOnboardingToolTip> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<MerchantInfoRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private final MerchantModule NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetNearbyRankingConfig> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetNearbyShopsWithPagination> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private Provider<IsNearbyReviewPageEnabled> PrepareContext;
        private Provider<NearbyMeRepository> SubSequence;
        private final NewNearbyComponentImpl VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<PhotoGalleryContract.Presenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<ConsultMerchantReview> getAuthRequestContext;
        private Provider<NearbyPromoModelMapper> getCallingPid;
        private Provider<FeatureConfigRepository> getErrorConfigVersion;
        private Provider<NearbyMeContract.View> getOnBoardingScenario;
        private Provider<NearbyPresenter> getSupportButtonTintMode;
        private Provider<NearbyMeContract.Presenter> getValueOfTouchPositionAbsolute;
        private Provider<GetDistrictNameByLocation> initRecordTimeStamp;
        private Provider<GetNearbyShopsPromo> isLayoutRequested;
        private Provider<Context> lookAheadTest;
        private Provider<GetAccount> moveToNextValue;
        private Provider<GetNearbyShopsWithRadius> newProxyInstance;
        private Provider<NearbyDefaultTracker> readMicros;
        private Provider<GeocodeRepository> scheduleImpl;
        private Provider<MixpanelRepository> whenAvailable;

        public /* synthetic */ NewNearbyComponentImpl(NearbyMeModule nearbyMeModule, MerchantDetailModule merchantDetailModule, MerchantModule merchantModule, PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent, byte b) {
            this(nearbyMeModule, merchantDetailModule, merchantModule, photoGalleryModule, applicationComponent);
        }

        private NewNearbyComponentImpl(NearbyMeModule nearbyMeModule, MerchantDetailModule merchantDetailModule, MerchantModule merchantModule, PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent) {
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = merchantModule;
            this.H = new ThreadExecutorProvider(applicationComponent);
            this.F = new SSLPinningRepositoryProvider(applicationComponent);
            this.B = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.H, this.B, featureConfigRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.H, this.F, create);
            this.lookAheadTest = new ContextProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = CheckNearbyMeFeature_Factory.create(this.H, this.B, this.getErrorConfigVersion);
            NearbyMeRepositoryProvider nearbyMeRepositoryProvider = new NearbyMeRepositoryProvider(applicationComponent);
            this.SubSequence = nearbyMeRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetNearbyRankingConfig_Factory.create(nearbyMeRepositoryProvider);
            MixpanelRepositoryProvider mixpanelRepositoryProvider = new MixpanelRepositoryProvider(applicationComponent);
            this.whenAvailable = mixpanelRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = GetNearbyShopsWithPagination_Factory.create(this.SubSequence, this.getErrorConfigVersion, mixpanelRepositoryProvider);
            this.getOnBoardingScenario = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbyMeViewFactory.PlaceComponentResult(nearbyMeModule));
            MerchantSubcategoriesMapper_Factory authRequestContext = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.C = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext, shopOpenHourListMapper_Factory);
            this.newProxyInstance = GetNearbyShopsWithRadius_Factory.create(this.SubSequence, this.getErrorConfigVersion, this.whenAvailable);
            this.isLayoutRequested = GetNearbyShopsPromo_Factory.create(this.SubSequence);
            this.getCallingPid = NearbyPromoModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = IsNeedToShowOnboardingToolTip_Factory.create(this.H, this.B, this.SubSequence);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.scheduleImpl = geocodeRepositoryProvider;
            this.initRecordTimeStamp = GetDistrictNameByLocation_Factory.create(geocodeRepositoryProvider);
            this.G = SaveShowOnboardingTooltip_Factory.create(this.H, this.B, this.SubSequence);
            this.GetContactSyncConfig = GetAutoSearchConfig_Factory.create(this.SubSequence);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.moveToNextValue = GetAccount_Factory.create(this.H, this.B, accountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetNearbyConfig_Factory.create(this.getErrorConfigVersion);
            this.PrepareContext = IsNearbyReviewPageEnabled_Factory.create(this.getErrorConfigVersion);
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = merchantInfoRepositoryProvider;
            this.getAuthRequestContext = ConsultMerchantReview_Factory.create(merchantInfoRepositoryProvider);
            NearbyPresenter_Factory BuiltInFictitiousFunctionClassFactory = NearbyPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.getOnBoardingScenario, this.C, this.newProxyInstance, this.isLayoutRequested, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, this.G, this.GetContactSyncConfig, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda2, ShopRankingCalculator_Factory.getAuthRequestContext(), this.PrepareContext, this.getAuthRequestContext);
            this.getSupportButtonTintMode = BuiltInFictitiousFunctionClassFactory;
            this.getValueOfTouchPositionAbsolute = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbyMePresenterFactory.getAuthRequestContext(nearbyMeModule, BuiltInFictitiousFunctionClassFactory));
            this.AppCompatEmojiTextHelper = DoubleCheck.getAuthRequestContext(MerchantDetailModule_ProvideViewFactory.PlaceComponentResult(merchantDetailModule));
            GetMerchantInfo_Factory create2 = GetMerchantInfo_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.DatabaseTableConfigUtil = create2;
            MerchantDetailPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MerchantDetailPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.AppCompatEmojiTextHelper, create2, MerchantDetailMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.D = DoubleCheck.getAuthRequestContext(MerchantDetailModule_ProvidePresenterFactory.MyBillsEntityDataFactory(merchantDetailModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory.PlaceComponentResult(photoGalleryModule));
            this.I = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(photoGalleryModule));
            DefaultDispatcherProvider defaultDispatcherProvider = new DefaultDispatcherProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = defaultDispatcherProvider;
            GetMerchantImage_Factory create3 = GetMerchantImage_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5, defaultDispatcherProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = create3;
            PhotoGalleryPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = PhotoGalleryPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.I, create3);
            this.A = BuiltInFictitiousFunctionClassFactory2;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory.getAuthRequestContext(photoGalleryModule, BuiltInFictitiousFunctionClassFactory2));
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory3 = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest);
            this.readMicros = BuiltInFictitiousFunctionClassFactory3;
            this.E = DoubleCheck.getAuthRequestContext(NearbyMeModule_ProvideNearbymeTrackerFactory.getAuthRequestContext(nearbyMeModule, BuiltInFictitiousFunctionClassFactory3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class MixpanelRepositoryProvider implements Provider<MixpanelRepository> {
            private final ApplicationComponent getAuthRequestContext;

            MixpanelRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MixpanelRepository get() {
                return (MixpanelRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.N());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GeocodeRepositoryProvider implements Provider<GeocodeRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GeocodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeocodeRepository get() {
                return (GeocodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getSupportButtonTintMode());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent getAuthRequestContext;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DefaultDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent PlaceComponentResult;

            DefaultDispatcherProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.PlaceComponentResult.GetContactSyncConfig());
            }
        }

        @Override // id.dana.di.component.NewNearbyComponent
        public final void PlaceComponentResult(NewNearbyMeActivity newNearbyMeActivity) {
            ((BaseActivity) newNearbyMeActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(newNearbyMeActivity, DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
            NewNearbyMeActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeActivity, new MapHelper((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
            NewNearbyMeActivity_MembersInjector.getAuthRequestContext(newNearbyMeActivity, this.getValueOfTouchPositionAbsolute.get());
            NewNearbyMeActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeActivity, this.D.get());
            NewNearbyMeActivity_MembersInjector.getAuthRequestContext(newNearbyMeActivity, MerchantModule_ProvidePresenterFactory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda6, new MerchantPresenter(MerchantModule_ProvideViewFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6), new GetMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.K())), new CheckMerchantCategoriesFeature((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetNewMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.K())), new MerchantCategoriesMapper(), new InitNewMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.K())))));
            NewNearbyMeActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeActivity, this.VerifyPinStateManager$executeRiskChallenge$2$2.get());
            NewNearbyMeActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeActivity, this.E.get());
        }
    }
}
