package id.dana.data.pocket.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.pocket.repository.source.PocketEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PocketEntityRepository_Factory implements Factory<PocketEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PocketEntityDataFactory> pocketEntityDataFactoryProvider;

    public PocketEntityRepository_Factory(Provider<PocketEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.pocketEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PocketEntityRepository get() {
        return newInstance(this.pocketEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PocketEntityRepository_Factory create(Provider<PocketEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new PocketEntityRepository_Factory(provider, provider2);
    }

    public static PocketEntityRepository newInstance(PocketEntityDataFactory pocketEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PocketEntityRepository(pocketEntityDataFactory, holdLoginV1EntityRepository);
    }
}
