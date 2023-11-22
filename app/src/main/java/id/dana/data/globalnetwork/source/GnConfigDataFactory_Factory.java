package id.dana.data.globalnetwork.source;

import dagger.internal.Factory;
import id.dana.data.globalnetwork.source.local.PreferenceGnConfigEntityData;
import id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GnConfigDataFactory_Factory implements Factory<GnConfigDataFactory> {
    private final Provider<PreferenceGnConfigEntityData> preferenceGnConfigEntityDataProvider;
    private final Provider<SplitGnConfigEntityData> splitGnConfigEntityDataProvider;

    public GnConfigDataFactory_Factory(Provider<SplitGnConfigEntityData> provider, Provider<PreferenceGnConfigEntityData> provider2) {
        this.splitGnConfigEntityDataProvider = provider;
        this.preferenceGnConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GnConfigDataFactory get() {
        return newInstance(this.splitGnConfigEntityDataProvider.get(), this.preferenceGnConfigEntityDataProvider.get());
    }

    public static GnConfigDataFactory_Factory create(Provider<SplitGnConfigEntityData> provider, Provider<PreferenceGnConfigEntityData> provider2) {
        return new GnConfigDataFactory_Factory(provider, provider2);
    }

    public static GnConfigDataFactory newInstance(SplitGnConfigEntityData splitGnConfigEntityData, PreferenceGnConfigEntityData preferenceGnConfigEntityData) {
        return new GnConfigDataFactory(splitGnConfigEntityData, preferenceGnConfigEntityData);
    }
}
