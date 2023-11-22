package id.dana.data.paylater.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.paylater.mapper.PayLaterResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaylaterEntityRepository_Factory implements Factory<PaylaterEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PayLaterResultMapper> payLaterResultMapperProvider;
    private final Provider<PaylaterEntityDataFactory> paylaterEntityDataFactoryProvider;

    public PaylaterEntityRepository_Factory(Provider<PaylaterEntityDataFactory> provider, Provider<PayLaterResultMapper> provider2, Provider<AccountEntityDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.paylaterEntityDataFactoryProvider = provider;
        this.payLaterResultMapperProvider = provider2;
        this.accountEntityDataFactoryProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final PaylaterEntityRepository get() {
        return newInstance(this.paylaterEntityDataFactoryProvider.get(), this.payLaterResultMapperProvider.get(), this.accountEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PaylaterEntityRepository_Factory create(Provider<PaylaterEntityDataFactory> provider, Provider<PayLaterResultMapper> provider2, Provider<AccountEntityDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new PaylaterEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static PaylaterEntityRepository newInstance(PaylaterEntityDataFactory paylaterEntityDataFactory, PayLaterResultMapper payLaterResultMapper, AccountEntityDataFactory accountEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PaylaterEntityRepository(paylaterEntityDataFactory, payLaterResultMapper, accountEntityDataFactory, holdLoginV1EntityRepository);
    }
}
