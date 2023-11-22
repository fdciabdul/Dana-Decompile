package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReceiveSms_Factory implements Factory<ReceiveSms> {
    private final Provider<OtpRepository> otpRepositoryProvider;

    public ReceiveSms_Factory(Provider<OtpRepository> provider) {
        this.otpRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ReceiveSms get() {
        return newInstance(this.otpRepositoryProvider.get());
    }

    public static ReceiveSms_Factory create(Provider<OtpRepository> provider) {
        return new ReceiveSms_Factory(provider);
    }

    public static ReceiveSms newInstance(OtpRepository otpRepository) {
        return new ReceiveSms(otpRepository);
    }
}
