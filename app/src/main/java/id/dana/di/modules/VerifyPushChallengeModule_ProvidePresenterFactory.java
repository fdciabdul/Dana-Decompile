package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.challenge.verifypush.VerifyPushLoginPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class VerifyPushChallengeModule_ProvidePresenterFactory implements Factory<VerifyPushContract.Presenter> {
    private final VerifyPushChallengeModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<VerifyPushLoginPresenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerifyPushContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
