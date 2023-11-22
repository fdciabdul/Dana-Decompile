package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pin.AbstractPinContract;

/* loaded from: classes4.dex */
public final class PinChallengeModule_ProvideViewFactory implements Factory<AbstractPinContract.View> {
    private final PinChallengeModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PinChallengeModule_ProvideViewFactory(PinChallengeModule pinChallengeModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pinChallengeModule;
    }

    public static PinChallengeModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(PinChallengeModule pinChallengeModule) {
        return new PinChallengeModule_ProvideViewFactory(pinChallengeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AbstractPinContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
    }
}
