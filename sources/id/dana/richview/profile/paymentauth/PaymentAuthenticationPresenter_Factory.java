package id.dana.richview.profile.paymentauth;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PaymentAuthenticationPresenter_Factory implements Factory<PaymentAuthenticationPresenter> {
    private final Provider<ControlSwitchPaymentAuthentication> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PaymentSecurityInitMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PaymentAuthenticationContract.View> MyBillsEntityDataFactory;
    private final Provider<PaymentSecuritySwitchMapper> PlaceComponentResult;
    private final Provider<InitPaymentAuthentication> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentAuthenticationPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
