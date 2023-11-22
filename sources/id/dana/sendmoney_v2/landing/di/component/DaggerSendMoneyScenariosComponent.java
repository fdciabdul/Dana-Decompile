package id.dana.sendmoney_v2.landing.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.SendMoneyScenarioModule;
import id.dana.di.modules.SendMoneyScenarioModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyScenarioModule_ProvideViewFactory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyScenarios;
import id.dana.domain.sendmoney.interactor.GetSendMoneyScenarios_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.mapper.SendMoneyScenariosMapper_Factory;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter_Factory;
import id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView;
import id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSendMoneyScenariosComponent {
    private DaggerSendMoneyScenariosComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;
        public SendMoneyScenarioModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class SendMoneyScenariosComponentImpl implements SendMoneyScenariosComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetSendMoneyScenarios> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SendMoneyScenariosContract.Presenter> MyBillsEntityDataFactory;
        private Provider<SendMoneyScenariosPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SendMoneyRepository> PlaceComponentResult;
        private Provider<SendMoneyScenariosContract.View> getAuthRequestContext;
        private final SendMoneyScenariosComponentImpl scheduleImpl;

        public /* synthetic */ SendMoneyScenariosComponentImpl(SendMoneyScenarioModule sendMoneyScenarioModule, ApplicationComponent applicationComponent, byte b) {
            this(sendMoneyScenarioModule, applicationComponent);
        }

        private SendMoneyScenariosComponentImpl(SendMoneyScenarioModule sendMoneyScenarioModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(SendMoneyScenarioModule_ProvideViewFactory.getAuthRequestContext(sendMoneyScenarioModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = sendMoneyRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetSendMoneyScenarios_Factory.create(sendMoneyRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = new ContextProvider(applicationComponent);
            Provider<SendMoneyScenariosPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SendMoneyScenariosPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, SendMoneyScenariosMapper_Factory.PlaceComponentResult(), this.BuiltInFictitiousFunctionClassFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
            this.MyBillsEntityDataFactory = DoubleCheck.getAuthRequestContext(SendMoneyScenarioModule_ProvidePresenterFactory.PlaceComponentResult(sendMoneyScenarioModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.sendmoney_v2.landing.di.component.SendMoneyScenariosComponent
        public final void MyBillsEntityDataFactory(SendMoneyScenariosView sendMoneyScenariosView) {
            SendMoneyScenariosView_MembersInjector.PlaceComponentResult(sendMoneyScenariosView, this.MyBillsEntityDataFactory.get());
        }
    }
}
