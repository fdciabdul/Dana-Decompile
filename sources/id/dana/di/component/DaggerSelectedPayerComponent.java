package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.model.SelectedPayerModule;
import id.dana.model.SelectedPayerModule_ProvidePresenterFactory;
import id.dana.model.SelectedPayerModule_ProvideViewFactory;
import id.dana.requestmoney.splitbill.mapper.SplitBillRecentPayerMapper_Factory;
import id.dana.richview.splitbill.SelectedPayerContract;
import id.dana.richview.splitbill.SelectedPayerPresenter;
import id.dana.richview.splitbill.SelectedPayerPresenter_Factory;
import id.dana.richview.splitbill.SelectedPayerView;
import id.dana.richview.splitbill.SelectedPayerView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSelectedPayerComponent {
    private DaggerSelectedPayerComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SelectedPayerModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SelectedPayerComponentImpl implements SelectedPayerComponent {
        private Provider<RecentRecipientRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SelectedPayerContract.View> MyBillsEntityDataFactory;
        private final SelectedPayerComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetRecentRecipient> PlaceComponentResult;
        private Provider<SelectedPayerContract.Presenter> getAuthRequestContext;
        private Provider<ThreadExecutor> moveToNextValue;
        private Provider<SelectedPayerPresenter> scheduleImpl;

        public /* synthetic */ SelectedPayerComponentImpl(SelectedPayerModule selectedPayerModule, ApplicationComponent applicationComponent, byte b) {
            this(selectedPayerModule, applicationComponent);
        }

        private SelectedPayerComponentImpl(SelectedPayerModule selectedPayerModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.MyBillsEntityDataFactory = DoubleCheck.getAuthRequestContext(SelectedPayerModule_ProvideViewFactory.PlaceComponentResult(selectedPayerModule));
            this.moveToNextValue = new ThreadExecutorProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new PostExecutionThreadProvider(applicationComponent);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = recentRecipientRepositoryProvider;
            GetRecentRecipient_Factory create = GetRecentRecipient_Factory.create(this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, recentRecipientRepositoryProvider);
            this.PlaceComponentResult = create;
            SelectedPayerPresenter_Factory BuiltInFictitiousFunctionClassFactory = SelectedPayerPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, create, SplitBillRecentPayerMapper_Factory.MyBillsEntityDataFactory());
            this.scheduleImpl = BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(SelectedPayerModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(selectedPayerModule, BuiltInFictitiousFunctionClassFactory));
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
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$setShowcaseShowing$p());
            }
        }

        @Override // id.dana.di.component.SelectedPayerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SelectedPayerView selectedPayerView) {
            SelectedPayerView_MembersInjector.PlaceComponentResult(selectedPayerView, this.getAuthRequestContext.get());
        }
    }
}
