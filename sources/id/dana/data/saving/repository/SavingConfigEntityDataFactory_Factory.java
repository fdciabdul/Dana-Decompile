package id.dana.data.saving.repository;

import dagger.internal.Factory;
import id.dana.data.saving.repository.source.local.DefaultSavingConfigEntityData;
import id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingConfigEntityDataFactory_Factory implements Factory<SavingConfigEntityDataFactory> {
    private final Provider<DefaultSavingConfigEntityData> defaultConfigEntityDataProvider;
    private final Provider<SplitSavingConfigEntityData> splitConfigEntityDataProvider;

    public SavingConfigEntityDataFactory_Factory(Provider<SplitSavingConfigEntityData> provider, Provider<DefaultSavingConfigEntityData> provider2) {
        this.splitConfigEntityDataProvider = provider;
        this.defaultConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SavingConfigEntityDataFactory get() {
        return newInstance(this.splitConfigEntityDataProvider.get(), this.defaultConfigEntityDataProvider.get());
    }

    public static SavingConfigEntityDataFactory_Factory create(Provider<SplitSavingConfigEntityData> provider, Provider<DefaultSavingConfigEntityData> provider2) {
        return new SavingConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static SavingConfigEntityDataFactory newInstance(SplitSavingConfigEntityData splitSavingConfigEntityData, DefaultSavingConfigEntityData defaultSavingConfigEntityData) {
        return new SavingConfigEntityDataFactory(splitSavingConfigEntityData, defaultSavingConfigEntityData);
    }
}
