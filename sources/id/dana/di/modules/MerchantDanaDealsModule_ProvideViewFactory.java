package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;

/* loaded from: classes4.dex */
public final class MerchantDanaDealsModule_ProvideViewFactory implements Factory<MerchantDanaDealsContract.View> {
    private final MerchantDanaDealsModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static MerchantDanaDealsContract.View KClassImpl$Data$declaredNonStaticMembers$2(MerchantDanaDealsModule merchantDanaDealsModule) {
        return (MerchantDanaDealsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantDanaDealsModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDanaDealsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
