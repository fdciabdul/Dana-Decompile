package id.dana.data.config;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.storage.UTDidInfo;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeviceInformationProvider_Factory implements Factory<DeviceInformationProvider> {
    private final Provider<Context> contextProvider;
    private final Provider<UTDidInfo> utDidInfoProvider;

    public DeviceInformationProvider_Factory(Provider<Context> provider, Provider<UTDidInfo> provider2) {
        this.contextProvider = provider;
        this.utDidInfoProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DeviceInformationProvider get() {
        return newInstance(this.contextProvider.get(), this.utDidInfoProvider.get());
    }

    public static DeviceInformationProvider_Factory create(Provider<Context> provider, Provider<UTDidInfo> provider2) {
        return new DeviceInformationProvider_Factory(provider, provider2);
    }

    public static DeviceInformationProvider newInstance(Context context, UTDidInfo uTDidInfo) {
        return new DeviceInformationProvider(context, uTDidInfo);
    }
}
