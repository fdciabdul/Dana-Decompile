package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.MerchantContract;

/* loaded from: classes4.dex */
public final class MerchantModule_ProvideViewFactory implements Factory<MerchantContract.View> {
    private final MerchantModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static MerchantContract.View MyBillsEntityDataFactory(MerchantModule merchantModule) {
        return (MerchantContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantModule.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
