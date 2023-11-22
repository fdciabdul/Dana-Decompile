package id.dana.data.auth.face.repository.source.entity;

import dagger.internal.Factory;
import id.dana.data.auth.face.repository.source.FaceAuthSuggestionDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FaceAuthPopUpConsultationEntityRepository_Factory implements Factory<FaceAuthPopUpConsultationEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<FaceAuthSuggestionDataFactory> faceAuthSuggestionDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UserRepository> userInfoRepositoryProvider;

    public FaceAuthPopUpConsultationEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<UserRepository> provider2, Provider<FaceAuthSuggestionDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.configEntityDataFactoryProvider = provider;
        this.userInfoRepositoryProvider = provider2;
        this.faceAuthSuggestionDataFactoryProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final FaceAuthPopUpConsultationEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.userInfoRepositoryProvider.get(), this.faceAuthSuggestionDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static FaceAuthPopUpConsultationEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<UserRepository> provider2, Provider<FaceAuthSuggestionDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new FaceAuthPopUpConsultationEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static FaceAuthPopUpConsultationEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, UserRepository userRepository, FaceAuthSuggestionDataFactory faceAuthSuggestionDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new FaceAuthPopUpConsultationEntityRepository(configEntityDataFactory, userRepository, faceAuthSuggestionDataFactory, holdLoginV1EntityRepository);
    }
}
