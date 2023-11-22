package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentPresenterFactory;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentViewFactory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.interactor.CheckFeatureInvestment;
import id.dana.domain.investment.interactor.CheckFeatureInvestment_Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary_Factory;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter_Factory;
import id.dana.investment.view.HomeInvestmentView;
import id.dana.investment.view.HomeInvestmentView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerInvestmentComponent {
    private DaggerInvestmentComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public InvestmentModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class InvestmentComponentImpl implements InvestmentComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private final InvestmentComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<DanaPlusInvestmentPresenter> MyBillsEntityDataFactory;
        private Provider<CheckFeatureInvestment> PlaceComponentResult;
        private Provider<GetUserInvestmentSummary> getAuthRequestContext;
        private Provider<InvestmentContract.Presenter> getErrorConfigVersion;
        private Provider<InvestmentRepository> lookAheadTest;
        private Provider<InvestmentContract.View> moveToNextValue;

        public /* synthetic */ InvestmentComponentImpl(InvestmentModule investmentModule, ApplicationComponent applicationComponent, byte b) {
            this(investmentModule, applicationComponent);
        }

        private InvestmentComponentImpl(InvestmentModule investmentModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(investmentModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.PlaceComponentResult = CheckFeatureInvestment_Factory.create(featureConfigRepositoryProvider);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.lookAheadTest = provideInvestmentRepositoryProvider;
            GetUserInvestmentSummary_Factory create = GetUserInvestmentSummary_Factory.create(provideInvestmentRepositoryProvider);
            this.getAuthRequestContext = create;
            Provider<DanaPlusInvestmentPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(DanaPlusInvestmentPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, this.PlaceComponentResult, create));
            this.MyBillsEntityDataFactory = authRequestContext;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentPresenterFactory.PlaceComponentResult(investmentModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypefaceCompatApi26Impl());
            }
        }

        @Override // id.dana.di.component.InvestmentComponent
        public final void getAuthRequestContext(HomeInvestmentView homeInvestmentView) {
            HomeInvestmentView_MembersInjector.BuiltInFictitiousFunctionClassFactory(homeInvestmentView, DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion));
        }
    }
}
