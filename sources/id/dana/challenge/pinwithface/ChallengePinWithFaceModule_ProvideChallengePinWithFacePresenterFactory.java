package id.dana.challenge.pinwithface;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChallengePinWithFaceModule_ProvideChallengePinWithFacePresenterFactory implements Factory<ChallengePinWithFaceContract.Presenter> {
    private final ChallengePinWithFaceModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ChallengePinWithFacePresenter> MyBillsEntityDataFactory;

    private ChallengePinWithFaceModule_ProvideChallengePinWithFacePresenterFactory(ChallengePinWithFaceModule challengePinWithFaceModule, Provider<ChallengePinWithFacePresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = challengePinWithFaceModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ChallengePinWithFaceModule_ProvideChallengePinWithFacePresenterFactory BuiltInFictitiousFunctionClassFactory(ChallengePinWithFaceModule challengePinWithFaceModule, Provider<ChallengePinWithFacePresenter> provider) {
        return new ChallengePinWithFaceModule_ProvideChallengePinWithFacePresenterFactory(challengePinWithFaceModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChallengePinWithFaceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
