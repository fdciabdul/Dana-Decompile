package id.dana.contract.promoexplore;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.view.PromoExploreContract;

/* loaded from: classes4.dex */
public final class PromoExploreModule_ProvidesViewFactory implements Factory<PromoExploreContract.View> {
    private final PromoExploreModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PromoExploreModule_ProvidesViewFactory(PromoExploreModule promoExploreModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoExploreModule;
    }

    public static PromoExploreModule_ProvidesViewFactory KClassImpl$Data$declaredNonStaticMembers$2(PromoExploreModule promoExploreModule) {
        return new PromoExploreModule_ProvidesViewFactory(promoExploreModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoExploreContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
