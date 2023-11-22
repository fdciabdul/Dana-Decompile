package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillHistoryContract;
import id.dana.splitbill.SplitBillHistoryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillHistoryModule_ProvidePresenterFactory implements Factory<SplitBillHistoryContract.Presenter> {
    private final SplitBillHistoryModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SplitBillHistoryPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    public static SplitBillHistoryContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SplitBillHistoryModule splitBillHistoryModule, SplitBillHistoryPresenter splitBillHistoryPresenter) {
        return (SplitBillHistoryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(splitBillHistoryModule.KClassImpl$Data$declaredNonStaticMembers$2(splitBillHistoryPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillHistoryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
