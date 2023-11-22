package id.dana.di.workerfactory;

import dagger.internal.Factory;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.pushverify.tracker.PushVerifyTracker;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushVerifyWorkerFactory_Factory implements Factory<PushVerifyWorkerFactory> {
    private final Provider<PushVerifyTracker> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetVerifyPushChallenge> MyBillsEntityDataFactory;
    private final Provider<GetPushVerifyChallenge> PlaceComponentResult;

    private PushVerifyWorkerFactory_Factory(Provider<GetPushVerifyChallenge> provider, Provider<GetVerifyPushChallenge> provider2, Provider<PushVerifyTracker> provider3) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static PushVerifyWorkerFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetPushVerifyChallenge> provider, Provider<GetVerifyPushChallenge> provider2, Provider<PushVerifyTracker> provider3) {
        return new PushVerifyWorkerFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PushVerifyWorkerFactory(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
