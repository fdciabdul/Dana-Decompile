package id.dana.data.h5onlineconfig.repository;

import dagger.internal.Factory;
import id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class H5OnlineConfigEntityRepository_Factory implements Factory<H5OnlineConfigEntityRepository> {
    private final Provider<AmcsH5OnlineConfig> amcsH5OnlineConfigProvider;

    public H5OnlineConfigEntityRepository_Factory(Provider<AmcsH5OnlineConfig> provider) {
        this.amcsH5OnlineConfigProvider = provider;
    }

    @Override // javax.inject.Provider
    public final H5OnlineConfigEntityRepository get() {
        return newInstance(this.amcsH5OnlineConfigProvider.get());
    }

    public static H5OnlineConfigEntityRepository_Factory create(Provider<AmcsH5OnlineConfig> provider) {
        return new H5OnlineConfigEntityRepository_Factory(provider);
    }

    public static H5OnlineConfigEntityRepository newInstance(AmcsH5OnlineConfig amcsH5OnlineConfig) {
        return new H5OnlineConfigEntityRepository(amcsH5OnlineConfig);
    }
}
