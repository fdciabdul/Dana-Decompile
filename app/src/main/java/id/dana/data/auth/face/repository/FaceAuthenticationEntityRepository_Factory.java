package id.dana.data.auth.face.repository;

import dagger.internal.Factory;
import id.dana.data.auth.face.mapper.FaceAuthenticationEntityMapper;
import id.dana.data.auth.face.repository.source.network.FaceAuthenticationEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FaceAuthenticationEntityRepository_Factory implements Factory<FaceAuthenticationEntityRepository> {
    private final Provider<FaceAuthenticationEntityDataFactory> faceAuthenticationEntityDataFactoryProvider;
    private final Provider<FaceAuthenticationEntityMapper> faceAuthenticationEntityMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public FaceAuthenticationEntityRepository_Factory(Provider<FaceAuthenticationEntityDataFactory> provider, Provider<FaceAuthenticationEntityMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.faceAuthenticationEntityDataFactoryProvider = provider;
        this.faceAuthenticationEntityMapperProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final FaceAuthenticationEntityRepository get() {
        return newInstance(this.faceAuthenticationEntityDataFactoryProvider.get(), this.faceAuthenticationEntityMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static FaceAuthenticationEntityRepository_Factory create(Provider<FaceAuthenticationEntityDataFactory> provider, Provider<FaceAuthenticationEntityMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new FaceAuthenticationEntityRepository_Factory(provider, provider2, provider3);
    }

    public static FaceAuthenticationEntityRepository newInstance(FaceAuthenticationEntityDataFactory faceAuthenticationEntityDataFactory, FaceAuthenticationEntityMapper faceAuthenticationEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new FaceAuthenticationEntityRepository(faceAuthenticationEntityDataFactory, faceAuthenticationEntityMapper, holdLoginV1EntityRepository);
    }
}
