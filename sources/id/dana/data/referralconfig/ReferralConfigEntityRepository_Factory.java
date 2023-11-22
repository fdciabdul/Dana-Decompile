package id.dana.data.referralconfig;

import dagger.internal.Factory;
import id.dana.data.referralconfig.mapper.ReferralConfigEntityMapper;
import id.dana.data.referralconfig.repository.source.ReferralConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralConfigEntityRepository_Factory implements Factory<ReferralConfigEntityRepository> {
    private final Provider<ReferralConfigEntityDataFactory> referralConfigEntityDataFactoryProvider;
    private final Provider<ReferralConfigEntityMapper> referralConfigEntityMapperProvider;

    public ReferralConfigEntityRepository_Factory(Provider<ReferralConfigEntityDataFactory> provider, Provider<ReferralConfigEntityMapper> provider2) {
        this.referralConfigEntityDataFactoryProvider = provider;
        this.referralConfigEntityMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralConfigEntityRepository get() {
        return newInstance(this.referralConfigEntityDataFactoryProvider.get(), this.referralConfigEntityMapperProvider.get());
    }

    public static ReferralConfigEntityRepository_Factory create(Provider<ReferralConfigEntityDataFactory> provider, Provider<ReferralConfigEntityMapper> provider2) {
        return new ReferralConfigEntityRepository_Factory(provider, provider2);
    }

    public static ReferralConfigEntityRepository newInstance(ReferralConfigEntityDataFactory referralConfigEntityDataFactory, ReferralConfigEntityMapper referralConfigEntityMapper) {
        return new ReferralConfigEntityRepository(referralConfigEntityDataFactory, referralConfigEntityMapper);
    }
}
