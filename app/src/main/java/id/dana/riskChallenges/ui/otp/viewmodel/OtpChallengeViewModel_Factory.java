package id.dana.riskChallenges.ui.otp.viewmodel;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.riskChallenges.domain.otp.interactor.RequestOtp;
import id.dana.riskChallenges.domain.otp.interactor.VerifyOtp;
import id.dana.riskChallenges.ui.util.strategy.FallbackStrategyImpl;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OtpChallengeViewModel_Factory implements Factory<OtpChallengeViewModel> {
    private final Provider<VerifyOtp> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RequestOtp> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FallbackStrategyImpl> MyBillsEntityDataFactory;
    private final Provider<RiskChallengeTracker> PlaceComponentResult;
    private final Provider<ReceiveOtp> getAuthRequestContext;

    private OtpChallengeViewModel_Factory(Provider<RequestOtp> provider, Provider<ReceiveOtp> provider2, Provider<VerifyOtp> provider3, Provider<FallbackStrategyImpl> provider4, Provider<RiskChallengeTracker> provider5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static OtpChallengeViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<RequestOtp> provider, Provider<ReceiveOtp> provider2, Provider<VerifyOtp> provider3, Provider<FallbackStrategyImpl> provider4, Provider<RiskChallengeTracker> provider5) {
        return new OtpChallengeViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtpChallengeViewModel(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
