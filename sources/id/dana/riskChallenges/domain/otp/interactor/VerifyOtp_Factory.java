package id.dana.riskChallenges.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.otp.OtpRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyOtp_Factory implements Factory<VerifyOtp> {
    private final Provider<OtpRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CarrierIdentificationRepository> PlaceComponentResult;
    private final Provider<LoginRepository> getAuthRequestContext;

    private VerifyOtp_Factory(Provider<LoginRepository> provider, Provider<CarrierIdentificationRepository> provider2, Provider<OtpRepository> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static VerifyOtp_Factory BuiltInFictitiousFunctionClassFactory(Provider<LoginRepository> provider, Provider<CarrierIdentificationRepository> provider2, Provider<OtpRepository> provider3) {
        return new VerifyOtp_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyOtp(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
