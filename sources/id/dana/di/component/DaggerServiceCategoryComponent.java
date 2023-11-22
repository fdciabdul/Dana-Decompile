package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.services.ServiceCategoryContract;
import id.dana.contract.services.ServiceCategoryModule;
import id.dana.contract.services.ServiceCategoryModule_ProvidePresenterFactory;
import id.dana.contract.services.ServiceCategoryModule_ProvideViewFactory;
import id.dana.contract.services.ServiceCategoryPresenter;
import id.dana.contract.services.ServiceCategoryPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.GetCategory;
import id.dana.domain.services.interactor.GetCategory_Factory;
import id.dana.richview.servicescard.ServiceCategoryView;
import id.dana.richview.servicescard.ServiceCategoryView_MembersInjector;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerServiceCategoryComponent {
    private DaggerServiceCategoryComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public ServiceCategoryModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ServiceCategoryComponentImpl implements ServiceCategoryComponent {
        private Provider<ServiceCategoryContract.Presenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<PostExecutionThread> MyBillsEntityDataFactory;
        private Provider<ServiceCategoryMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetCategory> PlaceComponentResult;
        private Provider<ServiceCategoryContract.View> getAuthRequestContext;
        private final ServiceCategoryComponentImpl getErrorConfigVersion;
        private Provider<ThreadExecutor> lookAheadTest;
        private Provider<ServiceCategoryPresenter> moveToNextValue;
        private Provider<ServicesRepository> scheduleImpl;

        public /* synthetic */ ServiceCategoryComponentImpl(ServiceCategoryModule serviceCategoryModule, ApplicationComponent applicationComponent, byte b) {
            this(serviceCategoryModule, applicationComponent);
        }

        private ServiceCategoryComponentImpl(ServiceCategoryModule serviceCategoryModule, ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(ServiceCategoryModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(serviceCategoryModule));
            this.lookAheadTest = new ThreadExecutorProvider(applicationComponent);
            this.MyBillsEntityDataFactory = new PostExecutionThreadProvider(applicationComponent);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.scheduleImpl = servicesRepositoryProvider;
            this.PlaceComponentResult = GetCategory_Factory.create(this.lookAheadTest, this.MyBillsEntityDataFactory, servicesRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            ServiceCategoryMapper_Factory authRequestContext = ServiceCategoryMapper_Factory.getAuthRequestContext(contextProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
            ServiceCategoryPresenter_Factory authRequestContext2 = ServiceCategoryPresenter_Factory.getAuthRequestContext(this.getAuthRequestContext, this.PlaceComponentResult, authRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.moveToNextValue = authRequestContext2;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(ServiceCategoryModule_ProvidePresenterFactory.PlaceComponentResult(serviceCategoryModule, authRequestContext2));
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SecuritySettingsActivity$createPinLauncher$2$1());
            }
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

        @Override // id.dana.di.component.ServiceCategoryComponent
        public final void MyBillsEntityDataFactory(ServiceCategoryView serviceCategoryView) {
            ServiceCategoryView_MembersInjector.BuiltInFictitiousFunctionClassFactory(serviceCategoryView, this.BuiltInFictitiousFunctionClassFactory.get());
        }
    }
}
