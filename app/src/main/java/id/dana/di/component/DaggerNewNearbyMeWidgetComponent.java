package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.contract.nearbyme.NewNearbyPresenter;
import id.dana.contract.nearbyme.NewNearbyPresenter_Factory;
import id.dana.di.modules.NewNearbyMeModule;
import id.dana.di.modules.NewNearbyMeModule_ProvideNearbyMePresenterFactory;
import id.dana.di.modules.NewNearbyMeModule_ProvideNearbyMeViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeMapFeature;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeMapFeature_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsFromCache;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsFromCache_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyWidgetVisibility;
import id.dana.domain.nearbyme.interactor.GetNearbyWidgetVisibility_Factory;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip_Factory;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip_Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.drawable.ShopRankingCalculator_Factory;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.NearbyPromoModelMapper_Factory;
import id.dana.nearbyme.NewNearbyMeView;
import id.dana.nearbyme.NewNearbyMeView_MembersInjector;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNewNearbyMeWidgetComponent {
    private DaggerNewNearbyMeWidgetComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public NewNearbyMeModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewNearbyMeWidgetComponentImpl implements NewNearbyMeWidgetComponent {
        private Provider<GetAutoSearchConfig> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetNearbyWidgetVisibility> DatabaseTableConfigUtil;
        private Provider<NewNearbyMeContract.Presenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<IsNeedToShowOnboardingToolTip> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckNearbyMeMapFeature> MyBillsEntityDataFactory;
        private Provider<GetNearbyConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MixpanelRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetNearbyShopsWithRadius> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<NewNearbyMeContract.View> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<SaveShowOnboardingTooltip> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<NearbyPromoModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<NewNearbyPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<NearbyMeRepository> PrepareContext;
        private Provider<GeocodeRepository> getAuthRequestContext;
        private Provider<GetDistrictNameByLocation> getErrorConfigVersion;
        private Provider<GetNearbyShopsWithPagination> initRecordTimeStamp;
        private Provider<NearbyShopsModelMapper> isLayoutRequested;
        private Provider<GetNearbyShopsFromCache> lookAheadTest;
        private Provider<GetNearbyShopsPromo> moveToNextValue;
        private final NewNearbyMeWidgetComponentImpl newProxyInstance;
        private Provider<GetNearbyRankingConfig> scheduleImpl;

        public /* synthetic */ NewNearbyMeWidgetComponentImpl(NewNearbyMeModule newNearbyMeModule, ApplicationComponent applicationComponent, byte b) {
            this(newNearbyMeModule, applicationComponent);
        }

        private NewNearbyMeWidgetComponentImpl(NewNearbyMeModule newNearbyMeModule, ApplicationComponent applicationComponent) {
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            this.newProxyInstance = this;
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(NewNearbyMeModule_ProvideNearbyMeViewFactory.PlaceComponentResult(newNearbyMeModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            this.DatabaseTableConfigUtil = GetNearbyWidgetVisibility_Factory.create(featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = CheckNearbyMeMapFeature_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            NearbyMeRepositoryProvider nearbyMeRepositoryProvider = new NearbyMeRepositoryProvider(applicationComponent);
            this.PrepareContext = nearbyMeRepositoryProvider;
            this.scheduleImpl = GetNearbyRankingConfig_Factory.create(nearbyMeRepositoryProvider);
            MixpanelRepositoryProvider mixpanelRepositoryProvider = new MixpanelRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = mixpanelRepositoryProvider;
            this.initRecordTimeStamp = GetNearbyShopsWithPagination_Factory.create(this.PrepareContext, this.KClassImpl$Data$declaredNonStaticMembers$2, mixpanelRepositoryProvider);
            MerchantSubcategoriesMapper_Factory authRequestContext = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.isLayoutRequested = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext, shopOpenHourListMapper_Factory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetNearbyShopsWithRadius_Factory.create(this.PrepareContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.moveToNextValue = GetNearbyShopsPromo_Factory.create(this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = NearbyPromoModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = postExecutionThreadProvider;
            this.GetContactSyncConfig = IsNeedToShowOnboardingToolTip_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, postExecutionThreadProvider, this.PrepareContext);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = geocodeRepositoryProvider;
            this.getErrorConfigVersion = GetDistrictNameByLocation_Factory.create(geocodeRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = SaveShowOnboardingTooltip_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.PrepareContext);
            this.BuiltInFictitiousFunctionClassFactory = GetAutoSearchConfig_Factory.create(this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetNearbyConfig_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.lookAheadTest = GetNearbyShopsFromCache_Factory.create(this.PrepareContext);
            NewNearbyPresenter_Factory PlaceComponentResult = NewNearbyPresenter_Factory.PlaceComponentResult(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.DatabaseTableConfigUtil, this.MyBillsEntityDataFactory, this.scheduleImpl, this.initRecordTimeStamp, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.GetContactSyncConfig, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, ShopRankingCalculator_Factory.getAuthRequestContext(), this.lookAheadTest);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = PlaceComponentResult;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(NewNearbyMeModule_ProvideNearbyMePresenterFactory.PlaceComponentResult(newNearbyMeModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class NearbyMeRepositoryProvider implements Provider<NearbyMeRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            NearbyMeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ NearbyMeRepository get() {
                return (NearbyMeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuth());
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
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
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

        @Override // id.dana.di.component.NewNearbyMeWidgetComponent
        public final void BuiltInFictitiousFunctionClassFactory(NewNearbyMeView newNearbyMeView) {
            NewNearbyMeView_MembersInjector.BuiltInFictitiousFunctionClassFactory(newNearbyMeView, DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding));
        }
    }
}
