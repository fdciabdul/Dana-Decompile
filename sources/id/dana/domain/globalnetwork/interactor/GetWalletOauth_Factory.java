package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWalletOauth_Factory implements Factory<GetWalletOauth> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetWalletOauth_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWalletOauth get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetWalletOauth_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetWalletOauth_Factory(provider);
    }

    public static GetWalletOauth newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetWalletOauth(globalNetworkRepository);
    }
}
