package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsNeedToSuggestFaceAuth_Factory implements Factory<IsNeedToSuggestFaceAuth> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public IsNeedToSuggestFaceAuth_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNeedToSuggestFaceAuth get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static IsNeedToSuggestFaceAuth_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new IsNeedToSuggestFaceAuth_Factory(provider);
    }

    public static IsNeedToSuggestFaceAuth newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new IsNeedToSuggestFaceAuth(faceAuthPopUpConsultationRepository);
    }
}
