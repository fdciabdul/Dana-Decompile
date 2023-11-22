package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendOtpFlow_Factory implements Factory<SendOtpFlow> {
    private final Provider<SendOtp> sendOtpProvider;

    public SendOtpFlow_Factory(Provider<SendOtp> provider) {
        this.sendOtpProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendOtpFlow get() {
        return newInstance(this.sendOtpProvider.get());
    }

    public static SendOtpFlow_Factory create(Provider<SendOtp> provider) {
        return new SendOtpFlow_Factory(provider);
    }

    public static SendOtpFlow newInstance(SendOtp sendOtp) {
        return new SendOtpFlow(sendOtp);
    }
}
