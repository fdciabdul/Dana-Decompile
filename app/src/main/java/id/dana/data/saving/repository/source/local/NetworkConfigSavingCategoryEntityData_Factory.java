package id.dana.data.saving.repository.source.local;

import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkConfigSavingCategoryEntityData_Factory implements Factory<NetworkConfigSavingCategoryEntityData> {
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public NetworkConfigSavingCategoryEntityData_Factory(Provider<SplitConfigEntityData> provider) {
        this.splitConfigEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkConfigSavingCategoryEntityData get() {
        return newInstance(this.splitConfigEntityDataProvider.get());
    }

    public static NetworkConfigSavingCategoryEntityData_Factory create(Provider<SplitConfigEntityData> provider) {
        return new NetworkConfigSavingCategoryEntityData_Factory(provider);
    }

    public static NetworkConfigSavingCategoryEntityData newInstance(SplitConfigEntityData splitConfigEntityData) {
        return new NetworkConfigSavingCategoryEntityData(splitConfigEntityData);
    }
}
