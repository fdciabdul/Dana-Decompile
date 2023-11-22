package id.dana.domain.connectionbar.interactor;

import dagger.internal.Factory;
import id.dana.domain.connectionbar.ConnectionBarRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsFeatureConnectionBarWithSignalOn_Factory implements Factory<GetIsFeatureConnectionBarWithSignalOn> {
    private final Provider<ConnectionBarRepository> connectionBarRepositoryProvider;

    public GetIsFeatureConnectionBarWithSignalOn_Factory(Provider<ConnectionBarRepository> provider) {
        this.connectionBarRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIsFeatureConnectionBarWithSignalOn get() {
        return newInstance(this.connectionBarRepositoryProvider.get());
    }

    public static GetIsFeatureConnectionBarWithSignalOn_Factory create(Provider<ConnectionBarRepository> provider) {
        return new GetIsFeatureConnectionBarWithSignalOn_Factory(provider);
    }

    public static GetIsFeatureConnectionBarWithSignalOn newInstance(ConnectionBarRepository connectionBarRepository) {
        return new GetIsFeatureConnectionBarWithSignalOn(connectionBarRepository);
    }
}
