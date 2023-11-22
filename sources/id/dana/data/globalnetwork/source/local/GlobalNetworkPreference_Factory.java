package id.dana.data.globalnetwork.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalNetworkPreference_Factory implements Factory<GlobalNetworkPreference> {
    private final Provider<Context> contextProvider;

    public GlobalNetworkPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GlobalNetworkPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static GlobalNetworkPreference_Factory create(Provider<Context> provider) {
        return new GlobalNetworkPreference_Factory(provider);
    }

    public static GlobalNetworkPreference newInstance(Context context) {
        return new GlobalNetworkPreference(context);
    }
}
