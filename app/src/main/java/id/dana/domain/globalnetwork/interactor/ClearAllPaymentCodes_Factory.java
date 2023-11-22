package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ClearAllPaymentCodes_Factory implements Factory<ClearAllPaymentCodes> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public ClearAllPaymentCodes_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearAllPaymentCodes get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static ClearAllPaymentCodes_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new ClearAllPaymentCodes_Factory(provider);
    }

    public static ClearAllPaymentCodes newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new ClearAllPaymentCodes(globalNetworkRepository);
    }
}
