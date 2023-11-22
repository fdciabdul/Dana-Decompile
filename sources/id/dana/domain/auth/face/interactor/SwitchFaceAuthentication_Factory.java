package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SwitchFaceAuthentication_Factory implements Factory<SwitchFaceAuthentication> {
    private final Provider<FaceAuthenticationRepository> faceAuthenticationRepositoryProvider;

    public SwitchFaceAuthentication_Factory(Provider<FaceAuthenticationRepository> provider) {
        this.faceAuthenticationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SwitchFaceAuthentication get() {
        return newInstance(this.faceAuthenticationRepositoryProvider.get());
    }

    public static SwitchFaceAuthentication_Factory create(Provider<FaceAuthenticationRepository> provider) {
        return new SwitchFaceAuthentication_Factory(provider);
    }

    public static SwitchFaceAuthentication newInstance(FaceAuthenticationRepository faceAuthenticationRepository) {
        return new SwitchFaceAuthentication(faceAuthenticationRepository);
    }
}
