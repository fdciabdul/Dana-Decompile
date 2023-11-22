package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.otp.AbstractOtpContract;

/* loaded from: classes4.dex */
public final class OtpChallengeModule_ProvideViewFactory implements Factory<AbstractOtpContract.View> {
    private final OtpChallengeModule getAuthRequestContext;

    private OtpChallengeModule_ProvideViewFactory(OtpChallengeModule otpChallengeModule) {
        this.getAuthRequestContext = otpChallengeModule;
    }

    public static OtpChallengeModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(OtpChallengeModule otpChallengeModule) {
        return new OtpChallengeModule_ProvideViewFactory(otpChallengeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AbstractOtpContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
