package id.dana.data.qrbarcode.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.amcs.AMCSManager;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AmcsQrScanWhitelistConfig_Factory implements Factory<AmcsQrScanWhitelistConfig> {
    private final Provider<AMCSManager> amcsManagerProvider;
    private final Provider<Context> contextProvider;

    public AmcsQrScanWhitelistConfig_Factory(Provider<Context> provider, Provider<AMCSManager> provider2) {
        this.contextProvider = provider;
        this.amcsManagerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AmcsQrScanWhitelistConfig get() {
        return newInstance(this.contextProvider.get(), this.amcsManagerProvider.get());
    }

    public static AmcsQrScanWhitelistConfig_Factory create(Provider<Context> provider, Provider<AMCSManager> provider2) {
        return new AmcsQrScanWhitelistConfig_Factory(provider, provider2);
    }

    public static AmcsQrScanWhitelistConfig newInstance(Context context, AMCSManager aMCSManager) {
        return new AmcsQrScanWhitelistConfig(context, aMCSManager);
    }
}
