package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;

/* loaded from: classes4.dex */
public final class PromoDiscoveryModule_ProvideViewFactory implements Factory<PromoDiscoveryContract.View> {
    private final PromoDiscoveryModule PlaceComponentResult;

    private PromoDiscoveryModule_ProvideViewFactory(PromoDiscoveryModule promoDiscoveryModule) {
        this.PlaceComponentResult = promoDiscoveryModule;
    }

    public static PromoDiscoveryModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryModule promoDiscoveryModule) {
        return new PromoDiscoveryModule_ProvideViewFactory(promoDiscoveryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoDiscoveryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
