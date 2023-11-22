package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.SavingConfigModule;
import id.dana.di.modules.SavingConfigModule_ProvideSavingViewFactory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility_Factory;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility_Factory;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.presenter.SavingConfigPresenter;
import id.dana.savings.presenter.SavingConfigPresenter_Factory;
import id.dana.savings.view.TotalSavingAmountView;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSavingConfigComponent {
    private DaggerSavingConfigComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SavingConfigModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SavingConfigComponentImpl implements SavingConfigComponent {
        private Provider<SaveSavingBalanceVisibility> BuiltInFictitiousFunctionClassFactory;
        private Provider<SavingConfigContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<Context> PlaceComponentResult;
        private Provider<GetSavingBalanceVisibility> getAuthRequestContext;
        private final SavingConfigComponentImpl lookAheadTest;
        private Provider<SavingConfigPresenter> moveToNextValue;

        public /* synthetic */ SavingConfigComponentImpl(SavingConfigModule savingConfigModule, ApplicationComponent applicationComponent, byte b) {
            this(savingConfigModule, applicationComponent);
        }

        private SavingConfigComponentImpl(SavingConfigModule savingConfigModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DoubleCheck.getAuthRequestContext(SavingConfigModule_ProvideSavingViewFactory.BuiltInFictitiousFunctionClassFactory(savingConfigModule));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.getAuthRequestContext = GetSavingBalanceVisibility_Factory.create(accountRepositoryProvider);
            SaveSavingBalanceVisibility_Factory create = SaveSavingBalanceVisibility_Factory.create(this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(SavingConfigPresenter_Factory.PlaceComponentResult(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, create));
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
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.SavingConfigComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(TotalSavingAmountView totalSavingAmountView) {
            totalSavingAmountView.savingConfigPresenter = this.moveToNextValue.get();
        }
    }
}
