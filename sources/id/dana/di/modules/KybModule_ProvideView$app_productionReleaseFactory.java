package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kyb.KybContract;

/* loaded from: classes4.dex */
public final class KybModule_ProvideView$app_productionReleaseFactory implements Factory<KybContract.View> {
    private final KybModule getAuthRequestContext;

    private KybModule_ProvideView$app_productionReleaseFactory(KybModule kybModule) {
        this.getAuthRequestContext = kybModule;
    }

    public static KybModule_ProvideView$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(KybModule kybModule) {
        return new KybModule_ProvideView$app_productionReleaseFactory(kybModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KybContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
