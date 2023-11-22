package id.dana.challenge.pin;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinPaymentAuthPresenter_Factory implements Factory<PinPaymentAuthPresenter> {
    private final Provider<ControlSwitchPaymentAuthentication> MyBillsEntityDataFactory;
    private final Provider<AbstractPinContract.View> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private PinPaymentAuthPresenter_Factory(Provider<Context> provider, Provider<AbstractPinContract.View> provider2, Provider<ControlSwitchPaymentAuthentication> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static PinPaymentAuthPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<AbstractPinContract.View> provider2, Provider<ControlSwitchPaymentAuthentication> provider3) {
        return new PinPaymentAuthPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinPaymentAuthPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
