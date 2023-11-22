package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPayRequest_Factory implements Factory<GetPayRequest> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetPayRequest_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPayRequest get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetPayRequest_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetPayRequest_Factory(provider);
    }

    public static GetPayRequest newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetPayRequest(globalNetworkRepository);
    }
}
