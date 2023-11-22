package id.dana.domain.danaprotection.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaProtectionRecommendation_Factory implements Factory<GetDanaProtectionRecommendation> {
    private final Provider<CredentialRepository> credentialEntityRepositoryProvider;
    private final Provider<DanaProtectionInfoRepository> danaProtectionInfoRepositoryProvider;
    private final Provider<FaceAuthPopUpConsultationRepository> faceAuthPopUpConsultationRepositoryProvider;
    private final Provider<UserSecurityQuestionStateRepository> userSecurityQuestionStateRepositoryProvider;

    public GetDanaProtectionRecommendation_Factory(Provider<FaceAuthPopUpConsultationRepository> provider, Provider<CredentialRepository> provider2, Provider<UserSecurityQuestionStateRepository> provider3, Provider<DanaProtectionInfoRepository> provider4) {
        this.faceAuthPopUpConsultationRepositoryProvider = provider;
        this.credentialEntityRepositoryProvider = provider2;
        this.userSecurityQuestionStateRepositoryProvider = provider3;
        this.danaProtectionInfoRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final GetDanaProtectionRecommendation get() {
        return newInstance(this.faceAuthPopUpConsultationRepositoryProvider.get(), this.credentialEntityRepositoryProvider.get(), this.userSecurityQuestionStateRepositoryProvider.get(), this.danaProtectionInfoRepositoryProvider.get());
    }

    public static GetDanaProtectionRecommendation_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider, Provider<CredentialRepository> provider2, Provider<UserSecurityQuestionStateRepository> provider3, Provider<DanaProtectionInfoRepository> provider4) {
        return new GetDanaProtectionRecommendation_Factory(provider, provider2, provider3, provider4);
    }

    public static GetDanaProtectionRecommendation newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository, CredentialRepository credentialRepository, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository, DanaProtectionInfoRepository danaProtectionInfoRepository) {
        return new GetDanaProtectionRecommendation(faceAuthPopUpConsultationRepository, credentialRepository, userSecurityQuestionStateRepository, danaProtectionInfoRepository);
    }
}
