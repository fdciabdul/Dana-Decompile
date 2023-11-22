package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsGoogleBlockRegistration_Factory implements Factory<IsGoogleBlockRegistration> {
    private final Provider<GlobalNetworkRepository> repositoryProvider;

    public IsGoogleBlockRegistration_Factory(Provider<GlobalNetworkRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsGoogleBlockRegistration get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static IsGoogleBlockRegistration_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new IsGoogleBlockRegistration_Factory(provider);
    }

    public static IsGoogleBlockRegistration newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new IsGoogleBlockRegistration(globalNetworkRepository);
    }
}
