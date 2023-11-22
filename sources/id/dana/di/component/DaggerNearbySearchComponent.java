package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.NearbyMerchantLocationSearchModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.NearbySearchModule;
import id.dana.di.modules.NearbySearchModule_ProvideNearbySearchPresenterFactory;
import id.dana.di.modules.NearbySearchModule_ProvideNearbySearchViewFactory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.miniprogram.interactor.GetReverseGeocodeByLocation;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.interactor.GetMerchantImage_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.interactor.GetChainQueryResult;
import id.dana.domain.nearbyplaces.interactor.GetListNearbyLocation;
import id.dana.domain.nearbysearch.interactor.GetNearbyTrendingKeyword;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.drawable.search.NearbySearchFragment;
import id.dana.drawable.search.NearbySearchFragment_MembersInjector;
import id.dana.drawable.search.presenter.NearbySearchPresenter;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory;
import id.dana.nearbyme.di.module.PhotoGalleryModule_ProvideViewFactory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter_Factory;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class DaggerNearbySearchComponent {
    private DaggerNearbySearchComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public PhotoGalleryModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;
        public NearbyMerchantLocationSearchModule PlaceComponentResult;
        public NearbySearchModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NearbySearchComponentImpl implements NearbySearchComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<NearbyAnalyticTracker> DatabaseTableConfigUtil;
        private Provider<PhotoGalleryContract.View> GetContactSyncConfig;
        private Provider<MerchantInfoRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<PhotoGalleryPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PhotoGalleryContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantPhotoGalleryModel> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<CoroutineDispatcher> PlaceComponentResult;
        private Provider<GetMerchantImage> getAuthRequestContext;
        private Provider<NearbyDefaultTracker> getErrorConfigVersion;
        private final NearbySearchModule lookAheadTest;
        private final NearbySearchComponentImpl moveToNextValue;
        private final NearbyMerchantLocationSearchModule scheduleImpl;

        public /* synthetic */ NearbySearchComponentImpl(NearbySearchModule nearbySearchModule, NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent, byte b) {
            this(nearbySearchModule, nearbyMerchantLocationSearchModule, photoGalleryModule, applicationComponent);
        }

        private NearbySearchComponentImpl(NearbySearchModule nearbySearchModule, NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, PhotoGalleryModule photoGalleryModule, ApplicationComponent applicationComponent) {
            this.moveToNextValue = this;
            this.lookAheadTest = nearbySearchModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.scheduleImpl = nearbyMerchantLocationSearchModule;
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contextProvider;
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(contextProvider);
            this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchModule, BuiltInFictitiousFunctionClassFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideMerchantPhotoGalleryModelFactory.PlaceComponentResult(photoGalleryModule));
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(photoGalleryModule));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantInfoRepositoryProvider(applicationComponent);
            DefaultDispatcherProvider defaultDispatcherProvider = new DefaultDispatcherProvider(applicationComponent);
            this.PlaceComponentResult = defaultDispatcherProvider;
            GetMerchantImage_Factory create = GetMerchantImage_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2, defaultDispatcherProvider);
            this.getAuthRequestContext = create;
            PhotoGalleryPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = PhotoGalleryPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory.getAuthRequestContext(photoGalleryModule, BuiltInFictitiousFunctionClassFactory2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DefaultDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent getAuthRequestContext;

            DefaultDispatcherProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.getAuthRequestContext.GetContactSyncConfig());
            }
        }

        @Override // id.dana.di.component.NearbySearchComponent
        public final void getAuthRequestContext(NearbySearchFragment nearbySearchFragment) {
            NearbySearchFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(nearbySearchFragment, NearbySearchModule_ProvideNearbySearchPresenterFactory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, new NearbySearchPresenter(NearbySearchModule_ProvideNearbySearchViewFactory.PlaceComponentResult(this.lookAheadTest), new GetNearbyTrendingKeyword((NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth())))));
            NearbySearchFragment_MembersInjector.MyBillsEntityDataFactory(nearbySearchFragment, NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, new NearbyMerchantLocationSearchPresenter(NearbyMerchantLocationSearchModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(this.scheduleImpl), new GetListNearbyLocation((NearbyPlaceRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.S())), new GetNearbyShopsWithPagination((NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5()), (MixpanelRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.N())), new GetNearbyShopsPromo((NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth())), (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()), new GetReverseGeocodeByLocation((GeocodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode())), new NearbyShopsModelMapper(new MerchantSubcategoriesMapper(), new ShopOpenHourListMapper()), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), new GetNearbyRankingConfig((NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth())), new ShopRankingCalculator(), new GetChainQueryResult((NearbyPlaceRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.S())))));
            NearbySearchFragment_MembersInjector.getAuthRequestContext(nearbySearchFragment, this.DatabaseTableConfigUtil.get());
            NearbySearchFragment_MembersInjector.MyBillsEntityDataFactory(nearbySearchFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
