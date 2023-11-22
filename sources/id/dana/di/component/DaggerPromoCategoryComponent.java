package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.promocenter.PromoCategoryContract;
import id.dana.contract.promocenter.PromoCategoryModule;
import id.dana.contract.promocenter.PromoCategoryModule_ProvidePresenterFactory;
import id.dana.contract.promocenter.PromoCategoryModule_ProvideViewFactory;
import id.dana.contract.promocenter.PromoCategoryPresenter;
import id.dana.contract.promocenter.PromoCategoryPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promocenter.interactor.GetPromoCategoryList;
import id.dana.domain.promocenter.interactor.GetPromoCategoryList_Factory;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.promocenter.mapper.CategoryModelMapper;
import id.dana.promocenter.mapper.CategoryModelMapper_Factory;
import id.dana.richview.promocenter.PromoCategoryView;
import id.dana.richview.promocenter.PromoCategoryView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPromoCategoryComponent {
    private DaggerPromoCategoryComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public PromoCategoryModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PromoCategoryComponentImpl implements PromoCategoryComponent {
        private Provider<GetPromoCategoryList> BuiltInFictitiousFunctionClassFactory;
        private Provider<CategoryModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<PromoCenterRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final PromoCategoryComponentImpl PlaceComponentResult;
        private Provider<PostExecutionThread> getAuthRequestContext;
        private Provider<ThreadExecutor> getErrorConfigVersion;
        private Provider<PromoCategoryPresenter> lookAheadTest;
        private Provider<PromoCategoryContract.Presenter> moveToNextValue;
        private Provider<PromoCategoryContract.View> scheduleImpl;

        public /* synthetic */ PromoCategoryComponentImpl(PromoCategoryModule promoCategoryModule, ApplicationComponent applicationComponent, byte b) {
            this(promoCategoryModule, applicationComponent);
        }

        private PromoCategoryComponentImpl(PromoCategoryModule promoCategoryModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(PromoCategoryModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(promoCategoryModule));
            this.getErrorConfigVersion = new ThreadExecutorProvider(applicationComponent);
            this.getAuthRequestContext = new PostExecutionThreadProvider(applicationComponent);
            PromoCenterRepositoryProvider promoCenterRepositoryProvider = new PromoCenterRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoCenterRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetPromoCategoryList_Factory.create(this.getErrorConfigVersion, this.getAuthRequestContext, promoCenterRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contextProvider;
            CategoryModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = CategoryModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            PromoCategoryPresenter_Factory authRequestContext = PromoCategoryPresenter_Factory.getAuthRequestContext(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
            this.lookAheadTest = authRequestContext;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(PromoCategoryModule_ProvidePresenterFactory.PlaceComponentResult(promoCategoryModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
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
        public static final class PromoCenterRepositoryProvider implements Provider<PromoCenterRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromoCenterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoCenterRepository get() {
                return (PromoCenterRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.d());
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

        @Override // id.dana.di.component.PromoCategoryComponent
        public final void PlaceComponentResult(PromoCategoryView promoCategoryView) {
            PromoCategoryView_MembersInjector.PlaceComponentResult(promoCategoryView, this.moveToNextValue.get());
        }
    }
}
