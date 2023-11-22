package id.dana.contract.maintenance;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.maintenance.interactor.ObserveMaintenanceBroadcast;
import id.dana.domain.maintenance.interactor.ObserveMaintenanceBroadcast_Factory;
import id.dana.richview.MaintenanceBroadcastView;
import id.dana.richview.MaintenanceBroadcastView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMaintenanceBroadcastComponent {
    private DaggerMaintenanceBroadcastComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MaintenanceBroadcastModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MaintenanceBroadcastComponentImpl implements MaintenanceBroadcastComponent {
        private final MaintenanceBroadcastComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<MaintenanceBroadcastPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ObserveMaintenanceBroadcast> PlaceComponentResult;
        private Provider<PostExecutionThread> getAuthRequestContext;
        private Provider<MaintenanceBroadcastContract.Presenter> getErrorConfigVersion;
        private Provider<MaintenanceBroadcastContract.View> lookAheadTest;

        public /* synthetic */ MaintenanceBroadcastComponentImpl(MaintenanceBroadcastModule maintenanceBroadcastModule, ApplicationComponent applicationComponent, byte b) {
            this(maintenanceBroadcastModule, applicationComponent);
        }

        private MaintenanceBroadcastComponentImpl(MaintenanceBroadcastModule maintenanceBroadcastModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(MaintenanceBroadcastModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(maintenanceBroadcastModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.getAuthRequestContext = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            ObserveMaintenanceBroadcast_Factory create = ObserveMaintenanceBroadcast_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            Provider<MaintenanceBroadcastPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(MaintenanceBroadcastPresenter_Factory.getAuthRequestContext(this.lookAheadTest, create));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(MaintenanceBroadcastModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(maintenanceBroadcastModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.contract.maintenance.MaintenanceBroadcastComponent
        public final void BuiltInFictitiousFunctionClassFactory(MaintenanceBroadcastView maintenanceBroadcastView) {
            MaintenanceBroadcastView_MembersInjector.PlaceComponentResult(maintenanceBroadcastView, DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
        }
    }
}
