package id.dana.riskChallenges.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RequestOtp_Factory implements Factory<RequestOtp> {
    private final Provider<RegistrationRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<OtpRepository> getAuthRequestContext;

    private RequestOtp_Factory(Provider<OtpRepository> provider, Provider<RegistrationRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static RequestOtp_Factory MyBillsEntityDataFactory(Provider<OtpRepository> provider, Provider<RegistrationRepository> provider2) {
        return new RequestOtp_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RequestOtp(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
