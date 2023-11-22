package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveNeverShowFaceAuthSuggestion_Factory implements Factory<SaveNeverShowFaceAuthSuggestion> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public SaveNeverShowFaceAuthSuggestion_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveNeverShowFaceAuthSuggestion get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SaveNeverShowFaceAuthSuggestion_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new SaveNeverShowFaceAuthSuggestion_Factory(provider);
    }

    public static SaveNeverShowFaceAuthSuggestion newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new SaveNeverShowFaceAuthSuggestion(faceAuthPopUpConsultationRepository);
    }
}
