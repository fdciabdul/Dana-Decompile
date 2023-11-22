package id.dana.domain.profilecompletion.interactor;

import dagger.internal.Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetProfileCompletionData_Factory implements Factory<GetProfileCompletionData> {
    private final Provider<FaceAuthPopUpConsultationRepository> faceAuthPopUpConsultationRepositoryProvider;
    private final Provider<TwilioEnrollmentEligibilityRepository> twilioEnrollmentEligibilityRepositoryProvider;
    private final Provider<UserEmailAddressRepository> userEmailAddressRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;
    private final Provider<UserSecurityQuestionStateRepository> userSecurityQuestionStateRepositoryProvider;

    public GetProfileCompletionData_Factory(Provider<FaceAuthPopUpConsultationRepository> provider, Provider<TwilioEnrollmentEligibilityRepository> provider2, Provider<UserRepository> provider3, Provider<UserEmailAddressRepository> provider4, Provider<UserSecurityQuestionStateRepository> provider5) {
        this.faceAuthPopUpConsultationRepositoryProvider = provider;
        this.twilioEnrollmentEligibilityRepositoryProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.userEmailAddressRepositoryProvider = provider4;
        this.userSecurityQuestionStateRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final GetProfileCompletionData get() {
        return newInstance(this.faceAuthPopUpConsultationRepositoryProvider.get(), this.twilioEnrollmentEligibilityRepositoryProvider.get(), this.userRepositoryProvider.get(), this.userEmailAddressRepositoryProvider.get(), this.userSecurityQuestionStateRepositoryProvider.get());
    }

    public static GetProfileCompletionData_Factory create(Provider<FaceAuthPopUpConsultationRepository> provider, Provider<TwilioEnrollmentEligibilityRepository> provider2, Provider<UserRepository> provider3, Provider<UserEmailAddressRepository> provider4, Provider<UserSecurityQuestionStateRepository> provider5) {
        return new GetProfileCompletionData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GetProfileCompletionData newInstance(FaceAuthPopUpConsultationRepository faceAuthPopUpConsultationRepository, TwilioEnrollmentEligibilityRepository twilioEnrollmentEligibilityRepository, UserRepository userRepository, UserEmailAddressRepository userEmailAddressRepository, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository) {
        return new GetProfileCompletionData(faceAuthPopUpConsultationRepository, twilioEnrollmentEligibilityRepository, userRepository, userEmailAddressRepository, userSecurityQuestionStateRepository);
    }
}
