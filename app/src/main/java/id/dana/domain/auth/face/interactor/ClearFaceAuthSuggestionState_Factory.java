package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ClearFaceAuthSuggestionState_Factory implements Factory<ClearFaceAuthSuggestionState> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public ClearFaceAuthSuggestionState_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearFaceAuthSuggestionState get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static ClearFaceAuthSuggestionState_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new ClearFaceAuthSuggestionState_Factory(provider);
    }

    public static ClearFaceAuthSuggestionState newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new ClearFaceAuthSuggestionState(faceAuthPopUpConsultationRepository);
    }
}
