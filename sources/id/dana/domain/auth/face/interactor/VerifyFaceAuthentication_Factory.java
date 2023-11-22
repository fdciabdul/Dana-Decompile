package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyFaceAuthentication_Factory implements Factory<VerifyFaceAuthentication> {
    private final Provider<FaceAuthenticationRepository> faceAuthenticationRepositoryProvider;

    public VerifyFaceAuthentication_Factory(Provider<FaceAuthenticationRepository> provider) {
        this.faceAuthenticationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyFaceAuthentication get() {
        return newInstance(this.faceAuthenticationRepositoryProvider.get());
    }

    public static VerifyFaceAuthentication_Factory create(Provider<FaceAuthenticationRepository> provider) {
        return new VerifyFaceAuthentication_Factory(provider);
    }

    public static VerifyFaceAuthentication newInstance(FaceAuthenticationRepository faceAuthenticationRepository) {
        return new VerifyFaceAuthentication(faceAuthenticationRepository);
    }
}
