package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;

/* loaded from: classes4.dex */
public final class MerchantInfoModule_ProvideViewFactory implements Factory<MerchantInfoContract.View> {
    private final MerchantInfoModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static MerchantInfoContract.View BuiltInFictitiousFunctionClassFactory(MerchantInfoModule merchantInfoModule) {
        return (MerchantInfoContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantInfoModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantInfoContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
