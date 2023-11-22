package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.verifypush.VerifyPushContract;

/* loaded from: classes4.dex */
public final class VerifyPushChallengeModule_ProvideViewFactory implements Factory<VerifyPushContract.View> {
    private final VerifyPushChallengeModule KClassImpl$Data$declaredNonStaticMembers$2;

    private VerifyPushChallengeModule_ProvideViewFactory(VerifyPushChallengeModule verifyPushChallengeModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = verifyPushChallengeModule;
    }

    public static VerifyPushChallengeModule_ProvideViewFactory getAuthRequestContext(VerifyPushChallengeModule verifyPushChallengeModule) {
        return new VerifyPushChallengeModule_ProvideViewFactory(verifyPushChallengeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerifyPushContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getBuiltInFictitiousFunctionClassFactory());
    }
}
