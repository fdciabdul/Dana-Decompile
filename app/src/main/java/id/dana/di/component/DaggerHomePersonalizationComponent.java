package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.animation.view.HomePersonalizationView;
import id.dana.animation.view.HomePersonalizationView_MembersInjector;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetIndoProvinceLandmark;
import id.dana.domain.geocode.interactor.GetIndoProvinceLandmark_Factory;
import id.dana.domain.personalizedhome.GetHomeLandmarkUrl;
import id.dana.domain.personalizedhome.GetHomeLandmarkUrl_Factory;
import id.dana.domain.personalizedhome.GetPersonalizedHomeConfig;
import id.dana.domain.personalizedhome.GetPersonalizedHomeConfig_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.personalizedhome.HomePersonalizationContract;
import id.dana.personalizedhome.HomePersonalizationPresenter;
import id.dana.personalizedhome.HomePersonalizationPresenter_Factory;
import id.dana.personalizedhome.HomePersonalizedModule;
import id.dana.personalizedhome.HomePersonalizedModule_ProvidePresenterFactory;
import id.dana.personalizedhome.HomePersonalizedModule_ProvideViewFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerHomePersonalizationComponent {
    private DaggerHomePersonalizationComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public HomePersonalizedModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class HomePersonalizationComponentImpl implements HomePersonalizationComponent {
        private Provider<GetPersonalizedHomeConfig> BuiltInFictitiousFunctionClassFactory;
        private Provider<GeocodeRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private final HomePersonalizationComponentImpl MyBillsEntityDataFactory;
        private Provider<HomePersonalizationContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetIndoProvinceLandmark> PlaceComponentResult;
        private Provider<GetHomeLandmarkUrl> getAuthRequestContext;
        private Provider<HomePersonalizationPresenter> getErrorConfigVersion;
        private Provider<HomePersonalizationContract.View> lookAheadTest;
        private Provider<UserRepository> scheduleImpl;

        public /* synthetic */ HomePersonalizationComponentImpl(HomePersonalizedModule homePersonalizedModule, ApplicationComponent applicationComponent, byte b) {
            this(homePersonalizedModule, applicationComponent);
        }

        private HomePersonalizationComponentImpl(HomePersonalizedModule homePersonalizedModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(HomePersonalizedModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(homePersonalizedModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.scheduleImpl = userRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetPersonalizedHomeConfig_Factory.create(userRepositoryProvider);
            this.getAuthRequestContext = GetHomeLandmarkUrl_Factory.create(this.scheduleImpl);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = geocodeRepositoryProvider;
            GetIndoProvinceLandmark_Factory create = GetIndoProvinceLandmark_Factory.create(geocodeRepositoryProvider);
            this.PlaceComponentResult = create;
            HomePersonalizationPresenter_Factory MyBillsEntityDataFactory = HomePersonalizationPresenter_Factory.MyBillsEntityDataFactory(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, create);
            this.getErrorConfigVersion = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(HomePersonalizedModule_ProvidePresenterFactory.PlaceComponentResult(homePersonalizedModule, MyBillsEntityDataFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.HomePersonalizationComponent
        public final void PlaceComponentResult(HomePersonalizationView homePersonalizationView) {
            HomePersonalizationView_MembersInjector.getAuthRequestContext(homePersonalizationView, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
    }
}
