package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillDetailContract;

/* loaded from: classes4.dex */
public final class SplitBillDetailModule_ProvideViewFactory implements Factory<SplitBillDetailContract.View> {
    private final SplitBillDetailModule BuiltInFictitiousFunctionClassFactory;

    public static SplitBillDetailContract.View PlaceComponentResult(SplitBillDetailModule splitBillDetailModule) {
        return (SplitBillDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(splitBillDetailModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }
}
