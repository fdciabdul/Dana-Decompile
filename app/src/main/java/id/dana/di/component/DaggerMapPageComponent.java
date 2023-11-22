package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.danah5.locationpicker.MapPageActivity;
import id.dana.danah5.locationpicker.MapPageActivity_MembersInjector;
import id.dana.danah5.locationpicker.presenter.MapPagePresenter;
import id.dana.di.modules.MapPageModule;
import id.dana.di.modules.MapPageModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.MapPageModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerMapPageComponent {
    private DaggerMapPageComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public MapPageModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class MapPageComponentImpl implements MapPageComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsOfflineF2FPay> MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final MapPageComponentImpl PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<SSLPinningRepository> lookAheadTest;
        private final MapPageModule scheduleImpl;

        public /* synthetic */ MapPageComponentImpl(MapPageModule mapPageModule, ApplicationComponent applicationComponent, byte b) {
            this(mapPageModule, applicationComponent);
        }

        private MapPageComponentImpl(MapPageModule mapPageModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.getAuthRequestContext = applicationComponent;
            this.scheduleImpl = mapPageModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
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

        @Override // id.dana.di.component.MapPageComponent
        public final void BuiltInFictitiousFunctionClassFactory(MapPageActivity mapPageActivity) {
            ((BaseActivity) mapPageActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(mapPageActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(mapPageActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            MapPageActivity_MembersInjector.injectPresenter(mapPageActivity, MapPageModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(this.scheduleImpl, new MapPagePresenter(MapPageModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(this.scheduleImpl), new GetIndoSubdivisionsByLocation((ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto()), (GeocodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getSupportButtonTintMode())))));
        }
    }
}
