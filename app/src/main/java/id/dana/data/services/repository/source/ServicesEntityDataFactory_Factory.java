package id.dana.data.services.repository.source;

import dagger.internal.Factory;
import id.dana.data.services.repository.source.local.DefaultServicesEntityData;
import id.dana.data.services.repository.source.split.SplitServicesEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ServicesEntityDataFactory_Factory implements Factory<ServicesEntityDataFactory> {
    private final Provider<DefaultServicesEntityData> defaultServicesEntityDataProvider;
    private final Provider<SplitServicesEntityData> splitServicesEntityDataProvider;

    public ServicesEntityDataFactory_Factory(Provider<SplitServicesEntityData> provider, Provider<DefaultServicesEntityData> provider2) {
        this.splitServicesEntityDataProvider = provider;
        this.defaultServicesEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ServicesEntityDataFactory get() {
        return newInstance(this.splitServicesEntityDataProvider.get(), this.defaultServicesEntityDataProvider.get());
    }

    public static ServicesEntityDataFactory_Factory create(Provider<SplitServicesEntityData> provider, Provider<DefaultServicesEntityData> provider2) {
        return new ServicesEntityDataFactory_Factory(provider, provider2);
    }

    public static ServicesEntityDataFactory newInstance(SplitServicesEntityData splitServicesEntityData, DefaultServicesEntityData defaultServicesEntityData) {
        return new ServicesEntityDataFactory(splitServicesEntityData, defaultServicesEntityData);
    }
}
