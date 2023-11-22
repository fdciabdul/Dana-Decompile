package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingTopUpHistoryContract;

/* loaded from: classes8.dex */
public final class SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory implements Factory<SavingTopUpHistoryContract.View> {
    private final SavingTopUpHistoryModule PlaceComponentResult;

    private SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory(SavingTopUpHistoryModule savingTopUpHistoryModule) {
        this.PlaceComponentResult = savingTopUpHistoryModule;
    }

    public static SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory KClassImpl$Data$declaredNonStaticMembers$2(SavingTopUpHistoryModule savingTopUpHistoryModule) {
        return new SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory(savingTopUpHistoryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingTopUpHistoryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
