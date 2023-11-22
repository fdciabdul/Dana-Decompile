package id.dana.data.verifytoken;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.verifytoken.repository.source.VerifyTokenEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class VerifyTokenEntityRepository_Factory implements Factory<VerifyTokenEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<VerifyTokenEntityDataFactory> verifyTokenEntityDataFactoryProvider;

    public VerifyTokenEntityRepository_Factory(Provider<VerifyTokenEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.verifyTokenEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final VerifyTokenEntityRepository get() {
        return newInstance(this.verifyTokenEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static VerifyTokenEntityRepository_Factory create(Provider<VerifyTokenEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new VerifyTokenEntityRepository_Factory(provider, provider2);
    }

    public static VerifyTokenEntityRepository newInstance(VerifyTokenEntityDataFactory verifyTokenEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new VerifyTokenEntityRepository(verifyTokenEntityDataFactory, holdLoginV1EntityRepository);
    }
}
