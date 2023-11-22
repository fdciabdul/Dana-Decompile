package id.dana.challenge.pin;

import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinTwilioPresenter_Factory implements Factory<PinTwilioPresenter> {
    private final Provider<AbstractPinContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TwilioVerifySecurityProduct> PlaceComponentResult;

    private PinTwilioPresenter_Factory(Provider<TwilioVerifySecurityProduct> provider, Provider<AbstractPinContract.View> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static PinTwilioPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<TwilioVerifySecurityProduct> provider, Provider<AbstractPinContract.View> provider2) {
        return new PinTwilioPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinTwilioPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
