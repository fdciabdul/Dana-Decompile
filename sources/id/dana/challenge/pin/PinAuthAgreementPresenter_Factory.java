package id.dana.challenge.pin;

import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinAuthAgreementPresenter_Factory implements Factory<PinAuthAgreementPresenter> {
    private final Provider<TwilioVerifySecurityProduct> PlaceComponentResult;
    private final Provider<AbstractPinContract.View> getAuthRequestContext;

    private PinAuthAgreementPresenter_Factory(Provider<AbstractPinContract.View> provider, Provider<TwilioVerifySecurityProduct> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static PinAuthAgreementPresenter_Factory PlaceComponentResult(Provider<AbstractPinContract.View> provider, Provider<TwilioVerifySecurityProduct> provider2) {
        return new PinAuthAgreementPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinAuthAgreementPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
