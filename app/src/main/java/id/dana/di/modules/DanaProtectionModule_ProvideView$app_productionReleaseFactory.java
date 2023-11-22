package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.danaprotection.DanaProtectionContract;

/* loaded from: classes4.dex */
public final class DanaProtectionModule_ProvideView$app_productionReleaseFactory implements Factory<DanaProtectionContract.View> {
    private final DanaProtectionModule MyBillsEntityDataFactory;

    private DanaProtectionModule_ProvideView$app_productionReleaseFactory(DanaProtectionModule danaProtectionModule) {
        this.MyBillsEntityDataFactory = danaProtectionModule;
    }

    public static DanaProtectionModule_ProvideView$app_productionReleaseFactory MyBillsEntityDataFactory(DanaProtectionModule danaProtectionModule) {
        return new DanaProtectionModule_ProvideView$app_productionReleaseFactory(danaProtectionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaProtectionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory());
    }
}
