package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.merchantmanagement.MerchantManagementContract;

/* loaded from: classes4.dex */
public final class MerchantManagementModule_ProvideView$app_productionReleaseFactory implements Factory<MerchantManagementContract.View> {
    private final MerchantManagementModule BuiltInFictitiousFunctionClassFactory;

    public static MerchantManagementContract.View BuiltInFictitiousFunctionClassFactory(MerchantManagementModule merchantManagementModule) {
        return (MerchantManagementContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantManagementModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantManagementContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
