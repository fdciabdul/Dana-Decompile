package id.dana.data.kycamledd.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.kycamledd.repository.source.KycAmlEddEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycAmlEddEntityRepository_Factory implements Factory<KycAmlEddEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<KycAmlEddEntityDataFactory> kycAmlEddEntityDataFactoryProvider;

    public KycAmlEddEntityRepository_Factory(Provider<KycAmlEddEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.kycAmlEddEntityDataFactoryProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final KycAmlEddEntityRepository get() {
        return newInstance(this.kycAmlEddEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static KycAmlEddEntityRepository_Factory create(Provider<KycAmlEddEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new KycAmlEddEntityRepository_Factory(provider, provider2, provider3);
    }

    public static KycAmlEddEntityRepository newInstance(KycAmlEddEntityDataFactory kycAmlEddEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new KycAmlEddEntityRepository(kycAmlEddEntityDataFactory, configEntityDataFactory, holdLoginV1EntityRepository);
    }
}
