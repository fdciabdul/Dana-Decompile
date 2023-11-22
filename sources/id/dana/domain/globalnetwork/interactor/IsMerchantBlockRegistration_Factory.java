package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsMerchantBlockRegistration_Factory implements Factory<IsMerchantBlockRegistration> {
    private final Provider<GlobalNetworkRepository> repositoryProvider;

    public IsMerchantBlockRegistration_Factory(Provider<GlobalNetworkRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsMerchantBlockRegistration get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static IsMerchantBlockRegistration_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new IsMerchantBlockRegistration_Factory(provider);
    }

    public static IsMerchantBlockRegistration newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new IsMerchantBlockRegistration(globalNetworkRepository);
    }
}
