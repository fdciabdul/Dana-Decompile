package id.dana.data.profilemenu.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaymentAuthenticationDataFactory_Factory implements Factory<PaymentAuthenticationDataFactory> {
    private final Provider<NetworkPaymentAuthenticationEntityData> networkPaymentAuthenticationEntityDataProvider;

    public PaymentAuthenticationDataFactory_Factory(Provider<NetworkPaymentAuthenticationEntityData> provider) {
        this.networkPaymentAuthenticationEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PaymentAuthenticationDataFactory get() {
        return newInstance(this.networkPaymentAuthenticationEntityDataProvider.get());
    }

    public static PaymentAuthenticationDataFactory_Factory create(Provider<NetworkPaymentAuthenticationEntityData> provider) {
        return new PaymentAuthenticationDataFactory_Factory(provider);
    }

    public static PaymentAuthenticationDataFactory newInstance(NetworkPaymentAuthenticationEntityData networkPaymentAuthenticationEntityData) {
        return new PaymentAuthenticationDataFactory(networkPaymentAuthenticationEntityData);
    }
}
