package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.citcall.CitCallContract;
import id.dana.onboarding.citcall.CitCallPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CitCallIntroductionModule_ProvidePresenter$app_productionReleaseFactory implements Factory<CitCallContract.Presenter> {
    private final Provider<CitCallPresenter> BuiltInFictitiousFunctionClassFactory;
    private final CitCallIntroductionModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CitCallContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
