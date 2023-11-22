package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.v2.BillerX2BContract;

/* loaded from: classes4.dex */
public final class BillerX2BModule_ProvideViewFactory implements Factory<BillerX2BContract.View> {
    private final BillerX2BModule PlaceComponentResult;

    private BillerX2BModule_ProvideViewFactory(BillerX2BModule billerX2BModule) {
        this.PlaceComponentResult = billerX2BModule;
    }

    public static BillerX2BModule_ProvideViewFactory getAuthRequestContext(BillerX2BModule billerX2BModule) {
        return new BillerX2BModule_ProvideViewFactory(billerX2BModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BillerX2BContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
