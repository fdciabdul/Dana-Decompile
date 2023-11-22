package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendBankOtp_Factory implements Factory<SendBankOtp> {
    private final Provider<OtpRepository> otpRepositoryProvider;

    public SendBankOtp_Factory(Provider<OtpRepository> provider) {
        this.otpRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendBankOtp get() {
        return newInstance(this.otpRepositoryProvider.get());
    }

    public static SendBankOtp_Factory create(Provider<OtpRepository> provider) {
        return new SendBankOtp_Factory(provider);
    }

    public static SendBankOtp newInstance(OtpRepository otpRepository) {
        return new SendBankOtp(otpRepository);
    }
}
