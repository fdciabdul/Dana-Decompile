package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;

/* loaded from: classes4.dex */
public final class SortingSendMoneyModule_ProvideViewFactory implements Factory<SortingSendMoneyContract.View> {
    private final SortingSendMoneyModule PlaceComponentResult;

    private SortingSendMoneyModule_ProvideViewFactory(SortingSendMoneyModule sortingSendMoneyModule) {
        this.PlaceComponentResult = sortingSendMoneyModule;
    }

    public static SortingSendMoneyModule_ProvideViewFactory MyBillsEntityDataFactory(SortingSendMoneyModule sortingSendMoneyModule) {
        return new SortingSendMoneyModule_ProvideViewFactory(sortingSendMoneyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SortingSendMoneyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
