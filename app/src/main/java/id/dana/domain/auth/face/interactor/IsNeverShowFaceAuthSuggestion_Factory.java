package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsNeverShowFaceAuthSuggestion_Factory implements Factory<IsNeverShowFaceAuthSuggestion> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public IsNeverShowFaceAuthSuggestion_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNeverShowFaceAuthSuggestion get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static IsNeverShowFaceAuthSuggestion_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new IsNeverShowFaceAuthSuggestion_Factory(provider);
    }

    public static IsNeverShowFaceAuthSuggestion newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new IsNeverShowFaceAuthSuggestion(faceAuthPopUpConsultationRepository);
    }
}
