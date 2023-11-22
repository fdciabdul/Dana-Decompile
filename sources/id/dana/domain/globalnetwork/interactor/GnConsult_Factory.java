package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GnConsult_Factory implements Factory<GnConsult> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GnConsult_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GnConsult get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GnConsult_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GnConsult_Factory(provider);
    }

    public static GnConsult newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GnConsult(globalNetworkRepository);
    }
}
