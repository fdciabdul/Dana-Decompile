package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillHistoryContract;

/* loaded from: classes4.dex */
public final class SplitBillHistoryModule_ProvideViewFactory implements Factory<SplitBillHistoryContract.View> {
    private final SplitBillHistoryModule BuiltInFictitiousFunctionClassFactory;

    public static SplitBillHistoryContract.View getAuthRequestContext(SplitBillHistoryModule splitBillHistoryModule) {
        return (SplitBillHistoryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(splitBillHistoryModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillHistoryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }
}
