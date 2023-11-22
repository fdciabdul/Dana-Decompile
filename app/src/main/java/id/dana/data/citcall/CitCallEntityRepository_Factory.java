package id.dana.data.citcall;

import dagger.internal.Factory;
import id.dana.data.citcall.source.CitCallEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CitCallEntityRepository_Factory implements Factory<CitCallEntityRepository> {
    private final Provider<CitCallEntityDataFactory> citcallEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;

    public CitCallEntityRepository_Factory(Provider<CitCallEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2) {
        this.citcallEntityDataFactoryProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CitCallEntityRepository get() {
        return newInstance(this.citcallEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get());
    }

    public static CitCallEntityRepository_Factory create(Provider<CitCallEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2) {
        return new CitCallEntityRepository_Factory(provider, provider2);
    }

    public static CitCallEntityRepository newInstance(CitCallEntityDataFactory citCallEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory) {
        return new CitCallEntityRepository(citCallEntityDataFactory, configEntityDataFactory);
    }
}
