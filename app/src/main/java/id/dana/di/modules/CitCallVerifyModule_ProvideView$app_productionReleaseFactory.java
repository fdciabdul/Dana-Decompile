package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.citcall.CitCallVerifyContract;

/* loaded from: classes4.dex */
public final class CitCallVerifyModule_ProvideView$app_productionReleaseFactory implements Factory<CitCallVerifyContract.View> {
    private final CitCallVerifyModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static CitCallVerifyContract.View KClassImpl$Data$declaredNonStaticMembers$2(CitCallVerifyModule citCallVerifyModule) {
        return (CitCallVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(citCallVerifyModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CitCallVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
