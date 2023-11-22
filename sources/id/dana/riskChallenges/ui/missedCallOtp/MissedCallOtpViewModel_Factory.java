package id.dana.riskChallenges.ui.missedCallOtp;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MissedCallOtpViewModel_Factory implements Factory<MissedCallOtpViewModel> {
    private final Provider<GetCitcallOtp> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<VerifyOtpRisk> MyBillsEntityDataFactory;
    private final Provider<GetCitcallPermissionUseCase> getAuthRequestContext;

    private MissedCallOtpViewModel_Factory(Provider<GetCitcallOtp> provider, Provider<GetCitcallPermissionUseCase> provider2, Provider<VerifyOtpRisk> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static MissedCallOtpViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetCitcallOtp> provider, Provider<GetCitcallPermissionUseCase> provider2, Provider<VerifyOtpRisk> provider3) {
        return new MissedCallOtpViewModel_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MissedCallOtpViewModel(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
