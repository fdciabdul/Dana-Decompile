package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingCreateContract;

/* loaded from: classes4.dex */
public final class SavingCreateModule_ProvideSavingCreateViewFactory implements Factory<SavingCreateContract.View> {
    private final SavingCreateModule getAuthRequestContext;

    private SavingCreateModule_ProvideSavingCreateViewFactory(SavingCreateModule savingCreateModule) {
        this.getAuthRequestContext = savingCreateModule;
    }

    public static SavingCreateModule_ProvideSavingCreateViewFactory PlaceComponentResult(SavingCreateModule savingCreateModule) {
        return new SavingCreateModule_ProvideSavingCreateViewFactory(savingCreateModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingCreateContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
