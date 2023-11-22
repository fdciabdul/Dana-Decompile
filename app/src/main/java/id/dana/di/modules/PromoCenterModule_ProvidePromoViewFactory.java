package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promocenter.promo.PromoCenterContract;

/* loaded from: classes4.dex */
public final class PromoCenterModule_ProvidePromoViewFactory implements Factory<PromoCenterContract.View> {
    private final PromoCenterModule BuiltInFictitiousFunctionClassFactory;

    public static PromoCenterContract.View getAuthRequestContext(PromoCenterModule promoCenterModule) {
        return (PromoCenterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(promoCenterModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCenterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
    }
}
