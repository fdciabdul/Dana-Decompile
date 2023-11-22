package id.dana.data.connectionbar.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ConnectionBarEntityRepository_Factory implements Factory<ConnectionBarEntityRepository> {
    private final Provider<ConfigEntityDataFactory> PlaceComponentResult;

    private ConnectionBarEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider) {
        this.PlaceComponentResult = provider;
    }

    public static ConnectionBarEntityRepository_Factory MyBillsEntityDataFactory(Provider<ConfigEntityDataFactory> provider) {
        return new ConnectionBarEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConnectionBarEntityRepository(this.PlaceComponentResult.get());
    }
}
