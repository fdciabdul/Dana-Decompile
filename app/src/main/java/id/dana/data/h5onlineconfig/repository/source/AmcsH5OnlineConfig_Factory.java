package id.dana.data.h5onlineconfig.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.amcs.AMCSManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AmcsH5OnlineConfig_Factory implements Factory<AmcsH5OnlineConfig> {
    private final Provider<AMCSManager> amcsManagerProvider;
    private final Provider<Context> contextProvider;

    public AmcsH5OnlineConfig_Factory(Provider<Context> provider, Provider<AMCSManager> provider2) {
        this.contextProvider = provider;
        this.amcsManagerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AmcsH5OnlineConfig get() {
        return newInstance(this.contextProvider.get(), this.amcsManagerProvider.get());
    }

    public static AmcsH5OnlineConfig_Factory create(Provider<Context> provider, Provider<AMCSManager> provider2) {
        return new AmcsH5OnlineConfig_Factory(provider, provider2);
    }

    public static AmcsH5OnlineConfig newInstance(Context context, AMCSManager aMCSManager) {
        return new AmcsH5OnlineConfig(context, aMCSManager);
    }
}
