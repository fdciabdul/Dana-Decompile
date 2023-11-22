package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kyb.KybContract;
import id.dana.kyb.KybPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class KybModule_ProvidePresenter$app_productionReleaseFactory implements Factory<KybContract.Presenter> {
    private final Provider<KybPresenter> BuiltInFictitiousFunctionClassFactory;
    private final KybModule getAuthRequestContext;

    private KybModule_ProvidePresenter$app_productionReleaseFactory(KybModule kybModule, Provider<KybPresenter> provider) {
        this.getAuthRequestContext = kybModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static KybModule_ProvidePresenter$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(KybModule kybModule, Provider<KybPresenter> provider) {
        return new KybModule_ProvidePresenter$app_productionReleaseFactory(kybModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KybContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
