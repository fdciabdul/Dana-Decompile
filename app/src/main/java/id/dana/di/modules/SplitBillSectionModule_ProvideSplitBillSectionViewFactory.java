package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillSectionContract;

/* loaded from: classes8.dex */
public final class SplitBillSectionModule_ProvideSplitBillSectionViewFactory implements Factory<SplitBillSectionContract.View> {
    private final SplitBillSectionModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitBillSectionModule_ProvideSplitBillSectionViewFactory(SplitBillSectionModule splitBillSectionModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillSectionModule;
    }

    public static SplitBillSectionModule_ProvideSplitBillSectionViewFactory KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSectionModule splitBillSectionModule) {
        return new SplitBillSectionModule_ProvideSplitBillSectionViewFactory(splitBillSectionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillSectionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
    }
}
