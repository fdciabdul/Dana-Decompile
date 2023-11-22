package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.PaymentAuthenticationModule;
import id.dana.di.modules.PaymentAuthenticationModule_GetPresenterFactory;
import id.dana.di.modules.PaymentAuthenticationModule_GetViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationPresenter;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationView;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public final class DaggerPaymentAuthenticationComponent {
    private DaggerPaymentAuthenticationComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public PaymentAuthenticationModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final PaymentAuthenticationComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, PaymentAuthenticationModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new PaymentAuthenticationComponentImpl(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class PaymentAuthenticationComponentImpl implements PaymentAuthenticationComponent {
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final PaymentAuthenticationModule PlaceComponentResult;
        private final PaymentAuthenticationComponentImpl getAuthRequestContext;

        /* synthetic */ PaymentAuthenticationComponentImpl(PaymentAuthenticationModule paymentAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(paymentAuthenticationModule, applicationComponent);
        }

        private PaymentAuthenticationComponentImpl(PaymentAuthenticationModule paymentAuthenticationModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.PlaceComponentResult = paymentAuthenticationModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
        }

        private PaymentAuthenticationPresenter MyBillsEntityDataFactory() {
            return new PaymentAuthenticationPresenter(PaymentAuthenticationModule_GetViewFactory.MyBillsEntityDataFactory(this.PlaceComponentResult), new InitPaymentAuthentication((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SettingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isInfoWindowShown())), new PaymentSecurityInitMapper(), new ControlSwitchPaymentAuthentication((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SettingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isInfoWindowShown())), new PaymentSecuritySwitchMapper());
        }

        @Override // id.dana.di.component.PaymentAuthenticationComponent
        public final void BuiltInFictitiousFunctionClassFactory(NewPaymentAuthenticationView newPaymentAuthenticationView) {
            newPaymentAuthenticationView.presenter = PaymentAuthenticationModule_GetPresenterFactory.getAuthRequestContext(this.PlaceComponentResult, MyBillsEntityDataFactory());
        }

        @Override // id.dana.di.component.PaymentAuthenticationComponent
        public final void BuiltInFictitiousFunctionClassFactory(PaymentAuthenticationView paymentAuthenticationView) {
            PaymentAuthenticationView_MembersInjector.PlaceComponentResult(paymentAuthenticationView, PaymentAuthenticationModule_GetPresenterFactory.getAuthRequestContext(this.PlaceComponentResult, MyBillsEntityDataFactory()));
        }
    }
}
