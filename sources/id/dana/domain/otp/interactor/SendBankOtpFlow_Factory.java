package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendBankOtpFlow_Factory implements Factory<SendBankOtpFlow> {
    private final Provider<SendBankOtp> sendBankOtpProvider;

    public SendBankOtpFlow_Factory(Provider<SendBankOtp> provider) {
        this.sendBankOtpProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendBankOtpFlow get() {
        return newInstance(this.sendBankOtpProvider.get());
    }

    public static SendBankOtpFlow_Factory create(Provider<SendBankOtp> provider) {
        return new SendBankOtpFlow_Factory(provider);
    }

    public static SendBankOtpFlow newInstance(SendBankOtp sendBankOtp) {
        return new SendBankOtpFlow(sendBankOtp);
    }
}
