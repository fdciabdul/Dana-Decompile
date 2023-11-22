package id.dana.challenge.pinwithface;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;

/* loaded from: classes4.dex */
public final class ChallengePinWithFaceModule_ProvideChallengePinWithFaceViewFactory implements Factory<ChallengePinWithFaceContract.View> {
    private final ChallengePinWithFaceModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ChallengePinWithFaceModule_ProvideChallengePinWithFaceViewFactory(ChallengePinWithFaceModule challengePinWithFaceModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = challengePinWithFaceModule;
    }

    public static ChallengePinWithFaceModule_ProvideChallengePinWithFaceViewFactory BuiltInFictitiousFunctionClassFactory(ChallengePinWithFaceModule challengePinWithFaceModule) {
        return new ChallengePinWithFaceModule_ProvideChallengePinWithFaceViewFactory(challengePinWithFaceModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChallengePinWithFaceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
