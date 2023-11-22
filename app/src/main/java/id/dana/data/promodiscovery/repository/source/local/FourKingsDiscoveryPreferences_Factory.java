package id.dana.data.promodiscovery.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FourKingsDiscoveryPreferences_Factory implements Factory<FourKingsDiscoveryPreferences> {
    private final Provider<Context> contextProvider;

    public FourKingsDiscoveryPreferences_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FourKingsDiscoveryPreferences get() {
        return newInstance(this.contextProvider.get());
    }

    public static FourKingsDiscoveryPreferences_Factory create(Provider<Context> provider) {
        return new FourKingsDiscoveryPreferences_Factory(provider);
    }

    public static FourKingsDiscoveryPreferences newInstance(Context context) {
        return new FourKingsDiscoveryPreferences(context);
    }
}
