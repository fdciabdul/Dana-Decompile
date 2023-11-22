package id.dana.data.splitbill.repository.source;

import dagger.internal.Factory;
import id.dana.data.splitbill.repository.source.network.NetworkSplitBillEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillEntityDataFactory_Factory implements Factory<SplitBillEntityDataFactory> {
    private final Provider<NetworkSplitBillEntityData> networkSplitBillEntityDataProvider;
    private final Provider<PersistenceSplitBillEntityData> persistenceSplitBillEntityDataProvider;

    public SplitBillEntityDataFactory_Factory(Provider<PersistenceSplitBillEntityData> provider, Provider<NetworkSplitBillEntityData> provider2) {
        this.persistenceSplitBillEntityDataProvider = provider;
        this.networkSplitBillEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SplitBillEntityDataFactory get() {
        return newInstance(this.persistenceSplitBillEntityDataProvider.get(), this.networkSplitBillEntityDataProvider.get());
    }

    public static SplitBillEntityDataFactory_Factory create(Provider<PersistenceSplitBillEntityData> provider, Provider<NetworkSplitBillEntityData> provider2) {
        return new SplitBillEntityDataFactory_Factory(provider, provider2);
    }

    public static SplitBillEntityDataFactory newInstance(PersistenceSplitBillEntityData persistenceSplitBillEntityData, NetworkSplitBillEntityData networkSplitBillEntityData) {
        return new SplitBillEntityDataFactory(persistenceSplitBillEntityData, networkSplitBillEntityData);
    }
}
