package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;

/* loaded from: classes5.dex */
public final class ManageAccountModule_ProvideViewFactory implements Factory<ManageAccountContract.View> {
    private final ManageAccountModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ManageAccountModule_ProvideViewFactory(ManageAccountModule manageAccountModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = manageAccountModule;
    }

    public static ManageAccountModule_ProvideViewFactory MyBillsEntityDataFactory(ManageAccountModule manageAccountModule) {
        return new ManageAccountModule_ProvideViewFactory(manageAccountModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ManageAccountContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
