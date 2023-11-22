package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kybcpm.KybCpmContract;

/* loaded from: classes4.dex */
public final class KybCpmModule_ProvideView$app_productionReleaseFactory implements Factory<KybCpmContract.View> {
    private final KybCpmModule PlaceComponentResult;

    private KybCpmModule_ProvideView$app_productionReleaseFactory(KybCpmModule kybCpmModule) {
        this.PlaceComponentResult = kybCpmModule;
    }

    public static KybCpmModule_ProvideView$app_productionReleaseFactory MyBillsEntityDataFactory(KybCpmModule kybCpmModule) {
        return new KybCpmModule_ProvideView$app_productionReleaseFactory(kybCpmModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KybCpmContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
