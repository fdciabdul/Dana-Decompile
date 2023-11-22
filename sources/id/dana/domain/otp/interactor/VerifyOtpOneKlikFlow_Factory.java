package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyOtpOneKlikFlow_Factory implements Factory<VerifyOtpOneKlikFlow> {
    private final Provider<VerifyOtpOneKlik> verifyOtpOneKlikProvider;

    public VerifyOtpOneKlikFlow_Factory(Provider<VerifyOtpOneKlik> provider) {
        this.verifyOtpOneKlikProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyOtpOneKlikFlow get() {
        return newInstance(this.verifyOtpOneKlikProvider.get());
    }

    public static VerifyOtpOneKlikFlow_Factory create(Provider<VerifyOtpOneKlik> provider) {
        return new VerifyOtpOneKlikFlow_Factory(provider);
    }

    public static VerifyOtpOneKlikFlow newInstance(VerifyOtpOneKlik verifyOtpOneKlik) {
        return new VerifyOtpOneKlikFlow(verifyOtpOneKlik);
    }
}
