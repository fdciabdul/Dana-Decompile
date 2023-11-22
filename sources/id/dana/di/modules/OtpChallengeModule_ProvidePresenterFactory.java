package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.challenge.otp.OtpLoginPresenter;
import id.dana.challenge.otp.OtpRegistrationPresenter;
import id.dana.challenge.otp.OtpTwilioPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpChallengeModule_ProvidePresenterFactory implements Factory<AbstractOtpContract.Presenter> {
    private final Provider<OtpTwilioPresenter> BuiltInFictitiousFunctionClassFactory;
    private final Provider<OtpLoginPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<OtpRegistrationPresenter> MyBillsEntityDataFactory;
    private final OtpChallengeModule PlaceComponentResult;

    private OtpChallengeModule_ProvidePresenterFactory(OtpChallengeModule otpChallengeModule, Provider<OtpRegistrationPresenter> provider, Provider<OtpLoginPresenter> provider2, Provider<OtpTwilioPresenter> provider3) {
        this.PlaceComponentResult = otpChallengeModule;
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static OtpChallengeModule_ProvidePresenterFactory getAuthRequestContext(OtpChallengeModule otpChallengeModule, Provider<OtpRegistrationPresenter> provider, Provider<OtpLoginPresenter> provider2, Provider<OtpTwilioPresenter> provider3) {
        return new OtpChallengeModule_ProvidePresenterFactory(otpChallengeModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AbstractOtpContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
