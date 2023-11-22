package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyOtpOneKlik_Factory implements Factory<VerifyOtpOneKlik> {
    private final Provider<OtpRepository> otpRepositoryProvider;

    public VerifyOtpOneKlik_Factory(Provider<OtpRepository> provider) {
        this.otpRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyOtpOneKlik get() {
        return newInstance(this.otpRepositoryProvider.get());
    }

    public static VerifyOtpOneKlik_Factory create(Provider<OtpRepository> provider) {
        return new VerifyOtpOneKlik_Factory(provider);
    }

    public static VerifyOtpOneKlik newInstance(OtpRepository otpRepository) {
        return new VerifyOtpOneKlik(otpRepository);
    }
}
