package id.dana.data.userconfig.repository;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.userconfig.repository.source.UserConfigEntityDataFactory;
import id.dana.data.userconfig.repository.source.local.PersistenceEtagEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserConfigEntityRepository_Factory implements Factory<UserConfigEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<PersistenceEtagEntityData> persistenceEtagEntityDataProvider;
    private final Provider<Gson> serializerProvider;
    private final Provider<UserConfigEntityDataFactory> userConfigEntityDataFactoryProvider;

    public UserConfigEntityRepository_Factory(Provider<Gson> provider, Provider<UserConfigEntityDataFactory> provider2, Provider<PersistenceEtagEntityData> provider3, Provider<ConfigEntityDataFactory> provider4) {
        this.serializerProvider = provider;
        this.userConfigEntityDataFactoryProvider = provider2;
        this.persistenceEtagEntityDataProvider = provider3;
        this.configEntityDataFactoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final UserConfigEntityRepository get() {
        return newInstance(this.serializerProvider.get(), this.userConfigEntityDataFactoryProvider.get(), this.persistenceEtagEntityDataProvider.get(), this.configEntityDataFactoryProvider.get());
    }

    public static UserConfigEntityRepository_Factory create(Provider<Gson> provider, Provider<UserConfigEntityDataFactory> provider2, Provider<PersistenceEtagEntityData> provider3, Provider<ConfigEntityDataFactory> provider4) {
        return new UserConfigEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static UserConfigEntityRepository newInstance(Gson gson, UserConfigEntityDataFactory userConfigEntityDataFactory, PersistenceEtagEntityData persistenceEtagEntityData, ConfigEntityDataFactory configEntityDataFactory) {
        return new UserConfigEntityRepository(gson, userConfigEntityDataFactory, persistenceEtagEntityData, configEntityDataFactory);
    }
}
