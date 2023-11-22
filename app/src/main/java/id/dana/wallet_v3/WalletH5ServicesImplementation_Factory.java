package id.dana.wallet_v3;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class WalletH5ServicesImplementation_Factory implements Factory<WalletH5ServicesImplementation> {
    private final Provider<GetCheckoutH5Event> getCheckoutH5EventProvider;

    public WalletH5ServicesImplementation_Factory(Provider<GetCheckoutH5Event> provider) {
        this.getCheckoutH5EventProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WalletH5ServicesImplementation get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.getCheckoutH5EventProvider));
    }

    public static WalletH5ServicesImplementation_Factory create(Provider<GetCheckoutH5Event> provider) {
        return new WalletH5ServicesImplementation_Factory(provider);
    }

    public static WalletH5ServicesImplementation newInstance(Lazy<GetCheckoutH5Event> lazy) {
        return new WalletH5ServicesImplementation(lazy);
    }
}
