package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveFaceAuthSuggestionState_Factory implements Factory<SaveFaceAuthSuggestionState> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public SaveFaceAuthSuggestionState_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveFaceAuthSuggestionState get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SaveFaceAuthSuggestionState_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new SaveFaceAuthSuggestionState_Factory(provider);
    }

    public static SaveFaceAuthSuggestionState newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new SaveFaceAuthSuggestionState(faceAuthPopUpConsultationRepository);
    }
}
