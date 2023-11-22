package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig;
import id.dana.data.sendmoney.repository.source.split.SplitAddPayMethodConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AddPayMethodConfigFactory_Factory implements Factory<AddPayMethodConfigFactory> {
    private final Provider<DefaultAddPayMethodConfig> defaultAddPayMethodConfigProvider;
    private final Provider<SplitAddPayMethodConfig> splitAddPayMethodConfigProvider;

    public AddPayMethodConfigFactory_Factory(Provider<DefaultAddPayMethodConfig> provider, Provider<SplitAddPayMethodConfig> provider2) {
        this.defaultAddPayMethodConfigProvider = provider;
        this.splitAddPayMethodConfigProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AddPayMethodConfigFactory get() {
        return newInstance(this.defaultAddPayMethodConfigProvider.get(), this.splitAddPayMethodConfigProvider.get());
    }

    public static AddPayMethodConfigFactory_Factory create(Provider<DefaultAddPayMethodConfig> provider, Provider<SplitAddPayMethodConfig> provider2) {
        return new AddPayMethodConfigFactory_Factory(provider, provider2);
    }

    public static AddPayMethodConfigFactory newInstance(DefaultAddPayMethodConfig defaultAddPayMethodConfig, SplitAddPayMethodConfig splitAddPayMethodConfig) {
        return new AddPayMethodConfigFactory(defaultAddPayMethodConfig, splitAddPayMethodConfig);
    }
}
