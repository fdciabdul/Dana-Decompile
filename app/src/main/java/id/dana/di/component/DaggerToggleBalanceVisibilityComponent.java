package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.contract.user.GetBalanceModule_ProvidePresenterFactory;
import id.dana.contract.user.GetBalanceModule_ProvideViewFactory;
import id.dana.contract.user.GetBalancePresenter;
import id.dana.contract.user.GetBalancePresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetAllBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility_Factory;
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility_Factory;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary_Factory;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetBalance_Factory;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig_Factory;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.richview.ToggleBalanceView;
import id.dana.richview.ToggleBalanceView_MembersInjector;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerToggleBalanceVisibilityComponent {
    private DaggerToggleBalanceVisibilityComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GetBalanceModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ToggleBalanceVisibilityComponentImpl implements ToggleBalanceVisibilityComponent {
        private Provider<GetBalancePresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<SetBalanceVisibility> GetContactSyncConfig;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetBalanceVisibility> MyBillsEntityDataFactory;
        private Provider<InvestmentRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ToggleBalanceVisibilityComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetBalanceContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetAllBalanceVisibility> PlaceComponentResult;
        private Provider<GetBalance> getAuthRequestContext;
        private Provider<GetSingleBalance> getErrorConfigVersion;
        private Provider<GetBalanceContract.View> initRecordTimeStamp;
        private Provider<GetDanaHomeBalanceConfig> lookAheadTest;
        private Provider<GetUserInvestmentSummary> moveToNextValue;
        private Provider<UserRepository> newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ ToggleBalanceVisibilityComponentImpl(GetBalanceModule getBalanceModule, ApplicationComponent applicationComponent, byte b) {
            this(getBalanceModule, applicationComponent);
        }

        private ToggleBalanceVisibilityComponentImpl(GetBalanceModule getBalanceModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvideViewFactory.MyBillsEntityDataFactory(getBalanceModule));
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.newProxyInstance = userRepositoryProvider;
            this.getAuthRequestContext = GetBalance_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, userRepositoryProvider);
            this.getErrorConfigVersion = GetSingleBalance_Factory.create(this.newProxyInstance);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.MyBillsEntityDataFactory = GetBalanceVisibility_Factory.create(accountRepositoryProvider);
            this.GetContactSyncConfig = SetBalanceVisibility_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.PlaceComponentResult = GetAllBalanceVisibility_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.lookAheadTest = GetDanaHomeBalanceConfig_Factory.create(this.newProxyInstance);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provideInvestmentRepositoryProvider;
            this.moveToNextValue = GetUserInvestmentSummary_Factory.create(provideInvestmentRepositoryProvider);
            Provider<GetBalancePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GetBalancePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.getAuthRequestContext, this.getErrorConfigVersion, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.MyBillsEntityDataFactory, this.GetContactSyncConfig, this.PlaceComponentResult, this.lookAheadTest, this.moveToNextValue));
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvidePresenterFactory.getAuthRequestContext(getBalanceModule, authRequestContext));
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
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.TypefaceCompatApi26Impl());
            }
        }

        @Override // id.dana.di.component.ToggleBalanceVisibilityComponent
        public final void MyBillsEntityDataFactory(ToggleBalanceView toggleBalanceView) {
            ToggleBalanceView_MembersInjector.PlaceComponentResult(toggleBalanceView, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
        }
    }
}
