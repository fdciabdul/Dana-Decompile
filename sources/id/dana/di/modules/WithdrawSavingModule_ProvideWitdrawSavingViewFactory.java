package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.WithdrawSavingContract;

/* loaded from: classes4.dex */
public final class WithdrawSavingModule_ProvideWitdrawSavingViewFactory implements Factory<WithdrawSavingContract.View> {
    private final WithdrawSavingModule MyBillsEntityDataFactory;

    private WithdrawSavingModule_ProvideWitdrawSavingViewFactory(WithdrawSavingModule withdrawSavingModule) {
        this.MyBillsEntityDataFactory = withdrawSavingModule;
    }

    public static WithdrawSavingModule_ProvideWitdrawSavingViewFactory KClassImpl$Data$declaredNonStaticMembers$2(WithdrawSavingModule withdrawSavingModule) {
        return new WithdrawSavingModule_ProvideWitdrawSavingViewFactory(withdrawSavingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (WithdrawSavingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
