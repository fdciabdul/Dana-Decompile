package id.dana.sendmoney_v2.landing.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.sendmoney.interactor.GetStateSuspiciousAccountSmartFriction;
import id.dana.domain.sendmoney.interactor.GetStateSuspiciousAccountSmartFriction_Factory;
import id.dana.domain.sendmoney.interactor.SaveStateSuspiciousAccountSmartFriction;
import id.dana.domain.sendmoney.interactor.SaveStateSuspiciousAccountSmartFriction_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.sendmoney_v2.landing.di.module.SuspiciousAccountModule;
import id.dana.sendmoney_v2.landing.di.module.SuspiciousAccountModule_ProvidePresenterFactory;
import id.dana.sendmoney_v2.landing.di.module.SuspiciousAccountModule_ProvideViewFactory;
import id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity;
import id.dana.sendmoney_v2.smartfriction.SuspiciousAccountActivity_MembersInjector;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSuspiciousAccountComponent {
    private DaggerSuspiciousAccountComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public SuspiciousAccountModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class SuspiciousAccountComponentImpl implements SuspiciousAccountComponent {
        private Provider<SuspiciousAccountContract.Presenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<SendMoneyRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SaveStateSuspiciousAccountSmartFriction> MyBillsEntityDataFactory;
        private Provider<GetStateSuspiciousAccountSmartFriction> PlaceComponentResult;
        private Provider<SuspiciousAccountContract.View> getAuthRequestContext;
        private Provider<SuspiciousAccountPresenter> getErrorConfigVersion;
        private final SuspiciousAccountComponentImpl scheduleImpl;

        public /* synthetic */ SuspiciousAccountComponentImpl(SuspiciousAccountModule suspiciousAccountModule, ApplicationComponent applicationComponent, byte b) {
            this(suspiciousAccountModule, applicationComponent);
        }

        private SuspiciousAccountComponentImpl(SuspiciousAccountModule suspiciousAccountModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(SuspiciousAccountModule_ProvideViewFactory.MyBillsEntityDataFactory(suspiciousAccountModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyRepositoryProvider;
            this.PlaceComponentResult = GetStateSuspiciousAccountSmartFriction_Factory.create(sendMoneyRepositoryProvider);
            SaveStateSuspiciousAccountSmartFriction_Factory create = SaveStateSuspiciousAccountSmartFriction_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.MyBillsEntityDataFactory = create;
            SuspiciousAccountPresenter_Factory PlaceComponentResult = SuspiciousAccountPresenter_Factory.PlaceComponentResult(this.getAuthRequestContext, this.PlaceComponentResult, create);
            this.getErrorConfigVersion = PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(SuspiciousAccountModule_ProvidePresenterFactory.PlaceComponentResult(suspiciousAccountModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BaseSocialFeedContract$Presenter());
            }
        }

        @Override // id.dana.sendmoney_v2.landing.di.component.SuspiciousAccountComponent
        public final void PlaceComponentResult(SuspiciousAccountActivity suspiciousAccountActivity) {
            SuspiciousAccountActivity_MembersInjector.PlaceComponentResult(suspiciousAccountActivity, this.BuiltInFictitiousFunctionClassFactory.get());
        }
    }
}
