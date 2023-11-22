package id.dana.data.config.source;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ConfigEntityDataFactory_Factory implements Factory<ConfigEntityDataFactory> {
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public ConfigEntityDataFactory_Factory(Provider<SplitConfigEntityData> provider) {
        this.splitConfigEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConfigEntityDataFactory get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.splitConfigEntityDataProvider));
    }

    public static ConfigEntityDataFactory_Factory create(Provider<SplitConfigEntityData> provider) {
        return new ConfigEntityDataFactory_Factory(provider);
    }

    public static ConfigEntityDataFactory newInstance(Lazy<SplitConfigEntityData> lazy) {
        return new ConfigEntityDataFactory(lazy);
    }
}
