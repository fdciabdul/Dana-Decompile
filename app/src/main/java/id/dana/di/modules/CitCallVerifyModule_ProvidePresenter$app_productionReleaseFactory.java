package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.citcall.CitCallVerifyContract;
import id.dana.onboarding.citcall.CitCallVerifyPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CitCallVerifyModule_ProvidePresenter$app_productionReleaseFactory implements Factory<CitCallVerifyContract.Presenter> {
    private final Provider<CitCallVerifyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final CitCallVerifyModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CitCallVerifyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
