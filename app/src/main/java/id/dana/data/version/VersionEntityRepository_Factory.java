package id.dana.data.version;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class VersionEntityRepository_Factory implements Factory<VersionEntityRepository> {
    private final Provider<ConfigEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<StorageVersionPreference> PlaceComponentResult;

    private VersionEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<StorageVersionPreference> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static VersionEntityRepository_Factory MyBillsEntityDataFactory(Provider<ConfigEntityDataFactory> provider, Provider<StorageVersionPreference> provider2) {
        return new VersionEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VersionEntityRepository(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
