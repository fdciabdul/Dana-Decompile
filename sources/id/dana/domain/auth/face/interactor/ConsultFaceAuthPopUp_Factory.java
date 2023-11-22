package id.dana.domain.auth.face.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ConsultFaceAuthPopUp_Factory implements Factory<ConsultFaceAuthPopUp> {
    private final Provider<FaceAuthPopUpConsultationRepository> repositoryProvider;

    public ConsultFaceAuthPopUp_Factory(Provider<FaceAuthPopUpConsultationRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultFaceAuthPopUp get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static ConsultFaceAuthPopUp_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider) {
        return new ConsultFaceAuthPopUp_Factory(provider);
    }

    public static ConsultFaceAuthPopUp newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository) {
        return new ConsultFaceAuthPopUp(faceAuthPopUpConsultationRepository);
    }
}
