package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReceiveOtp_Factory implements Factory<ReceiveOtp> {
    private final Provider<OtpRepository> otpRepositoryProvider;

    public ReceiveOtp_Factory(Provider<OtpRepository> provider) {
        this.otpRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ReceiveOtp get() {
        return newInstance(this.otpRepositoryProvider.get());
    }

    public static ReceiveOtp_Factory create(Provider<OtpRepository> provider) {
        return new ReceiveOtp_Factory(provider);
    }

    public static ReceiveOtp newInstance(OtpRepository otpRepository) {
        return new ReceiveOtp(otpRepository);
    }
}
