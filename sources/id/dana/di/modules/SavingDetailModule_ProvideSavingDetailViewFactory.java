package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingDetailContract;

/* loaded from: classes4.dex */
public final class SavingDetailModule_ProvideSavingDetailViewFactory implements Factory<SavingDetailContract.View> {
    private final SavingDetailModule BuiltInFictitiousFunctionClassFactory;

    private SavingDetailModule_ProvideSavingDetailViewFactory(SavingDetailModule savingDetailModule) {
        this.BuiltInFictitiousFunctionClassFactory = savingDetailModule;
    }

    public static SavingDetailModule_ProvideSavingDetailViewFactory KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailModule savingDetailModule) {
        return new SavingDetailModule_ProvideSavingDetailViewFactory(savingDetailModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext());
    }
}
