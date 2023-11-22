package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUniPaymentResult_Factory implements Factory<GetUniPaymentResult> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetUniPaymentResult_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUniPaymentResult get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetUniPaymentResult_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetUniPaymentResult_Factory(provider);
    }

    public static GetUniPaymentResult newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetUniPaymentResult(globalNetworkRepository);
    }
}
