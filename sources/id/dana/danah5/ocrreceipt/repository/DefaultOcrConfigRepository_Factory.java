package id.dana.danah5.ocrreceipt.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DefaultOcrConfigRepository_Factory implements Factory<DefaultOcrConfigRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultOcrConfigRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<Serializer> provider2) {
        this.configEntityDataFactoryProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultOcrConfigRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.serializerProvider.get());
    }

    public static DefaultOcrConfigRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<Serializer> provider2) {
        return new DefaultOcrConfigRepository_Factory(provider, provider2);
    }

    public static DefaultOcrConfigRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, Serializer serializer) {
        return new DefaultOcrConfigRepository(configEntityDataFactory, serializer);
    }
}
