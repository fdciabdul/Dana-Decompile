package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyOtp_Factory implements Factory<VerifyOtp> {
    private final Provider<OtpRepository> otpRepositoryProvider;

    public VerifyOtp_Factory(Provider<OtpRepository> provider) {
        this.otpRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyOtp get() {
        return newInstance(this.otpRepositoryProvider.get());
    }

    public static VerifyOtp_Factory create(Provider<OtpRepository> provider) {
        return new VerifyOtp_Factory(provider);
    }

    public static VerifyOtp newInstance(OtpRepository otpRepository) {
        return new VerifyOtp(otpRepository);
    }
}
