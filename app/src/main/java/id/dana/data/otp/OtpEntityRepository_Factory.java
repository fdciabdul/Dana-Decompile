package id.dana.data.otp;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.data.otp.mapper.OtpBankMapper;
import id.dana.data.otp.mapper.OtpMapper;
import id.dana.data.otp.repository.source.OtpEntityDataFactory;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.security.source.SecurityEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OtpEntityRepository_Factory implements Factory<OtpEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<VerifyChallengeManager> challengeManagerProvider;
    private final Provider<OtpBankMapper> otpBankMapperProvider;
    private final Provider<OtpEntityDataFactory> otpEntityDataFactoryProvider;
    private final Provider<OtpMapper> otpMapperProvider;
    private final Provider<OtpRetryManager> otpRetryManagerProvider;
    private final Provider<RegistrationProcessManager> processManagerProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;

    public OtpEntityRepository_Factory(Provider<OtpEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<RegistrationProcessManager> provider3, Provider<VerifyChallengeManager> provider4, Provider<OtpRetryManager> provider5, Provider<OtpMapper> provider6, Provider<OtpBankMapper> provider7, Provider<SecurityEntityDataFactory> provider8) {
        this.otpEntityDataFactoryProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
        this.processManagerProvider = provider3;
        this.challengeManagerProvider = provider4;
        this.otpRetryManagerProvider = provider5;
        this.otpMapperProvider = provider6;
        this.otpBankMapperProvider = provider7;
        this.securityEntityDataFactoryProvider = provider8;
    }

    @Override // javax.inject.Provider
    public final OtpEntityRepository get() {
        return newInstance(this.otpEntityDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.processManagerProvider.get(), this.challengeManagerProvider.get(), this.otpRetryManagerProvider.get(), this.otpMapperProvider.get(), this.otpBankMapperProvider.get(), this.securityEntityDataFactoryProvider.get());
    }

    public static OtpEntityRepository_Factory create(Provider<OtpEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<RegistrationProcessManager> provider3, Provider<VerifyChallengeManager> provider4, Provider<OtpRetryManager> provider5, Provider<OtpMapper> provider6, Provider<OtpBankMapper> provider7, Provider<SecurityEntityDataFactory> provider8) {
        return new OtpEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static OtpEntityRepository newInstance(OtpEntityDataFactory otpEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, RegistrationProcessManager registrationProcessManager, VerifyChallengeManager verifyChallengeManager, OtpRetryManager otpRetryManager, OtpMapper otpMapper, OtpBankMapper otpBankMapper, SecurityEntityDataFactory securityEntityDataFactory) {
        return new OtpEntityRepository(otpEntityDataFactory, accountEntityDataFactory, registrationProcessManager, verifyChallengeManager, otpRetryManager, otpMapper, otpBankMapper, securityEntityDataFactory);
    }
}
