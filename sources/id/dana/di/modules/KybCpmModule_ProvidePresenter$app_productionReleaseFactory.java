package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.KybCpmPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class KybCpmModule_ProvidePresenter$app_productionReleaseFactory implements Factory<KybCpmContract.Presenter> {
    private final Provider<KybCpmPresenter> BuiltInFictitiousFunctionClassFactory;
    private final KybCpmModule MyBillsEntityDataFactory;

    private KybCpmModule_ProvidePresenter$app_productionReleaseFactory(KybCpmModule kybCpmModule, Provider<KybCpmPresenter> provider) {
        this.MyBillsEntityDataFactory = kybCpmModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static KybCpmModule_ProvidePresenter$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(KybCpmModule kybCpmModule, Provider<KybCpmPresenter> provider) {
        return new KybCpmModule_ProvidePresenter$app_productionReleaseFactory(kybCpmModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KybCpmContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
