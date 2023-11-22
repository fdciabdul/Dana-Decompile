package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.promoclaim.PromoClaimContract;

/* loaded from: classes8.dex */
public final class PromoClaimModule_GetViewFactory implements Factory<PromoClaimContract.View> {
    private final PromoClaimModule BuiltInFictitiousFunctionClassFactory;

    public static PromoClaimContract.View getAuthRequestContext(PromoClaimModule promoClaimModule) {
        return (PromoClaimContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(promoClaimModule.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoClaimContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
