package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity;
import id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity_MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.miniprogram.interactor.GetReverseGeocodeByLocation;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.interactor.GetChainQueryResult;
import id.dana.domain.nearbyplaces.interactor.GetListNearbyLocation;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.drawable.search.searchresult.ChainQueryFragment;
import id.dana.drawable.search.searchresult.ChainQueryFragment_MembersInjector;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;
import id.dana.nearbyme.NearbyMerchantLocationSearchView_MembersInjector;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.utils.MapHelper;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNearbyMerchantLocationComponent {
    private DaggerNearbyMerchantLocationComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public NearbyMerchantLocationSearchModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final NearbyMerchantLocationComponent getAuthRequestContext() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, NearbyMerchantLocationSearchModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            return new NearbyMerchantLocationComponentImpl(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class NearbyMerchantLocationComponentImpl implements NearbyMerchantLocationComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<NearbyDefaultTracker> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Context> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<NearbyAnalyticTracker> getErrorConfigVersion;
        private Provider<SSLPinningRepository> initRecordTimeStamp;
        private final NearbyMerchantLocationComponentImpl lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private final NearbyMerchantLocationSearchModule scheduleImpl;

        /* synthetic */ NearbyMerchantLocationComponentImpl(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, ApplicationComponent applicationComponent, byte b) {
            this(nearbyMerchantLocationSearchModule, applicationComponent);
        }

        private NearbyMerchantLocationComponentImpl(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.scheduleImpl = nearbyMerchantLocationSearchModule;
            this.getAuthRequestContext = applicationComponent;
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(contextProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchModule, BuiltInFictitiousFunctionClassFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.initRecordTimeStamp = new SSLPinningRepositoryProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.initRecordTimeStamp, create);
        }

        private NearbyMerchantLocationSearchPresenter BuiltInFictitiousFunctionClassFactory() {
            return new NearbyMerchantLocationSearchPresenter(NearbyMerchantLocationSearchModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(this.scheduleImpl), new GetListNearbyLocation((NearbyPlaceRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.S())), new GetNearbyShopsWithPagination((NearbyMeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuth()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5()), (MixpanelRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.N())), new GetNearbyShopsPromo((NearbyMeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuth())), (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7()), new GetReverseGeocodeByLocation((GeocodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getSupportButtonTintMode())), new NearbyShopsModelMapper(new MerchantSubcategoriesMapper(), new ShopOpenHourListMapper()), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), new GetNearbyRankingConfig((NearbyMeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuth())), new ShopRankingCalculator(), new GetChainQueryResult((NearbyPlaceRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.S())));
        }

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.NearbyMerchantLocationComponent
        public final void getAuthRequestContext(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity) {
            ((BaseActivity) miniProgramLocationPickerActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(miniProgramLocationPickerActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(miniProgramLocationPickerActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            MiniProgramLocationPickerActivity_MembersInjector.injectPresenter(miniProgramLocationPickerActivity, BuiltInFictitiousFunctionClassFactory());
            MiniProgramLocationPickerActivity_MembersInjector.injectMapHelper(miniProgramLocationPickerActivity, new MapHelper((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue())));
        }

        @Override // id.dana.di.component.NearbyMerchantLocationComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView) {
            NearbyMerchantLocationSearchView_MembersInjector.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchView, NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, BuiltInFictitiousFunctionClassFactory()));
            NearbyMerchantLocationSearchView_MembersInjector.MyBillsEntityDataFactory(nearbyMerchantLocationSearchView, this.getErrorConfigVersion.get());
        }

        @Override // id.dana.di.component.NearbyMerchantLocationComponent
        public final void BuiltInFictitiousFunctionClassFactory(ChainQueryFragment chainQueryFragment) {
            ChainQueryFragment_MembersInjector.getAuthRequestContext(chainQueryFragment, NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, BuiltInFictitiousFunctionClassFactory()));
        }
    }
}
