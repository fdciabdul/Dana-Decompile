package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.onboarding.verify.VerifyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyNumberModule_ProvidesPresenterFactory implements Factory<VerifyNumberContract.Presenter> {
    private final Provider<VerifyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final VerifyNumberModule KClassImpl$Data$declaredNonStaticMembers$2;

    private VerifyNumberModule_ProvidesPresenterFactory(VerifyNumberModule verifyNumberModule, Provider<VerifyPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = verifyNumberModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static VerifyNumberModule_ProvidesPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberModule verifyNumberModule, Provider<VerifyPresenter> provider) {
        return new VerifyNumberModule_ProvidesPresenterFactory(verifyNumberModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerifyNumberContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
