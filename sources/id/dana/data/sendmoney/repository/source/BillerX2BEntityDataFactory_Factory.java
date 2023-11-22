package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.DefaultBillerX2BEntityData;
import id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BillerX2BEntityDataFactory_Factory implements Factory<BillerX2BEntityDataFactory> {
    private final Provider<DefaultBillerX2BEntityData> defaultAllBillerX2BEntityDataProvider;
    private final Provider<SplitBillerX2BEntityData> splitAllBillerX2BEntityDataProvider;

    public BillerX2BEntityDataFactory_Factory(Provider<DefaultBillerX2BEntityData> provider, Provider<SplitBillerX2BEntityData> provider2) {
        this.defaultAllBillerX2BEntityDataProvider = provider;
        this.splitAllBillerX2BEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final BillerX2BEntityDataFactory get() {
        return newInstance(this.defaultAllBillerX2BEntityDataProvider.get(), this.splitAllBillerX2BEntityDataProvider.get());
    }

    public static BillerX2BEntityDataFactory_Factory create(Provider<DefaultBillerX2BEntityData> provider, Provider<SplitBillerX2BEntityData> provider2) {
        return new BillerX2BEntityDataFactory_Factory(provider, provider2);
    }

    public static BillerX2BEntityDataFactory newInstance(DefaultBillerX2BEntityData defaultBillerX2BEntityData, SplitBillerX2BEntityData splitBillerX2BEntityData) {
        return new BillerX2BEntityDataFactory(defaultBillerX2BEntityData, splitBillerX2BEntityData);
    }
}
