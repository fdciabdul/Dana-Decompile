package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillContract;

/* loaded from: classes4.dex */
public final class SplitBillModule_ProvideSplitBillViewFactory implements Factory<SplitBillContract.View> {
    private final SplitBillModule MyBillsEntityDataFactory;

    private SplitBillModule_ProvideSplitBillViewFactory(SplitBillModule splitBillModule) {
        this.MyBillsEntityDataFactory = splitBillModule;
    }

    public static SplitBillModule_ProvideSplitBillViewFactory getAuthRequestContext(SplitBillModule splitBillModule) {
        return new SplitBillModule_ProvideSplitBillViewFactory(splitBillModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
