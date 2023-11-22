package id.dana.data.config.source.sharedpreference;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SharedPrefNetworkLogging_Factory implements Factory<SharedPrefNetworkLogging> {
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;

    public SharedPrefNetworkLogging_Factory(Provider<SharedPrefStartupConfig> provider) {
        this.sharedPrefStartupConfigProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SharedPrefNetworkLogging get() {
        return newInstance(this.sharedPrefStartupConfigProvider.get());
    }

    public static SharedPrefNetworkLogging_Factory create(Provider<SharedPrefStartupConfig> provider) {
        return new SharedPrefNetworkLogging_Factory(provider);
    }

    public static SharedPrefNetworkLogging newInstance(SharedPrefStartupConfig sharedPrefStartupConfig) {
        return new SharedPrefNetworkLogging(sharedPrefStartupConfig);
    }
}
