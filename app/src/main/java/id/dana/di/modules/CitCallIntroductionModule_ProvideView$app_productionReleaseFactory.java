package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.citcall.CitCallContract;

/* loaded from: classes4.dex */
public final class CitCallIntroductionModule_ProvideView$app_productionReleaseFactory implements Factory<CitCallContract.View> {
    private final CitCallIntroductionModule getAuthRequestContext;

    public static CitCallContract.View BuiltInFictitiousFunctionClassFactory(CitCallIntroductionModule citCallIntroductionModule) {
        return (CitCallContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(citCallIntroductionModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CitCallContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
