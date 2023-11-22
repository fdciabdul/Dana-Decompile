package id.dana.challenge.pin.presenter;

import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.wallet_v3.interactor.VerifyPinPersonalKtp;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinWalletPersonalKtpPresenter_Factory implements Factory<PinWalletPersonalKtpPresenter> {
    private final Provider<VerifyPinPersonalKtp> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AbstractPinContract.View> MyBillsEntityDataFactory;

    private PinWalletPersonalKtpPresenter_Factory(Provider<AbstractPinContract.View> provider, Provider<VerifyPinPersonalKtp> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static PinWalletPersonalKtpPresenter_Factory MyBillsEntityDataFactory(Provider<AbstractPinContract.View> provider, Provider<VerifyPinPersonalKtp> provider2) {
        return new PinWalletPersonalKtpPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinWalletPersonalKtpPresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
