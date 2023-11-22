package id.dana.pushverify.view.verificationdetail;

import dagger.internal.Factory;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PushVerifyPresenter_Factory implements Factory<PushVerifyPresenter> {
    private final Provider<PushVerifyContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PushVerifyTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPushVerifyChallenge> MyBillsEntityDataFactory;
    private final Provider<GetVerifyPushChallenge> getAuthRequestContext;

    private PushVerifyPresenter_Factory(Provider<PushVerifyContract.View> provider, Provider<PushVerifyTracker> provider2, Provider<GetPushVerifyChallenge> provider3, Provider<GetVerifyPushChallenge> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static PushVerifyPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<PushVerifyContract.View> provider, Provider<PushVerifyTracker> provider2, Provider<GetPushVerifyChallenge> provider3, Provider<GetVerifyPushChallenge> provider4) {
        return new PushVerifyPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PushVerifyPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
