package id.dana.data.dynamicurl;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DynamicUrlWrapper_Factory implements Factory<DynamicUrlWrapper> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;

    public DynamicUrlWrapper_Factory(Provider<ConfigEntityDataFactory> provider) {
        this.configEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DynamicUrlWrapper get() {
        return newInstance(this.configEntityDataFactoryProvider.get());
    }

    public static DynamicUrlWrapper_Factory create(Provider<ConfigEntityDataFactory> provider) {
        return new DynamicUrlWrapper_Factory(provider);
    }

    public static DynamicUrlWrapper newInstance(ConfigEntityDataFactory configEntityDataFactory) {
        return new DynamicUrlWrapper(configEntityDataFactory);
    }
}
