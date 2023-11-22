package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.animation.danaprotection.DanaProtectionPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory implements Factory<DanaProtectionContract.Presenter> {
    private final DanaProtectionModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<DanaProtectionPresenter> MyBillsEntityDataFactory;

    private DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory(DanaProtectionModule danaProtectionModule, Provider<DanaProtectionPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = danaProtectionModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(DanaProtectionModule danaProtectionModule, Provider<DanaProtectionPresenter> provider) {
        return new DanaProtectionModule_ProvidePresenter$app_productionReleaseFactory(danaProtectionModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaProtectionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
