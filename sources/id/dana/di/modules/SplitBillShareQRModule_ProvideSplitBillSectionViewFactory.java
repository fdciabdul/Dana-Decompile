package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillShareQRContract;

/* loaded from: classes4.dex */
public final class SplitBillShareQRModule_ProvideSplitBillSectionViewFactory implements Factory<SplitBillShareQRContract.View> {
    private final SplitBillShareQRModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitBillShareQRModule_ProvideSplitBillSectionViewFactory(SplitBillShareQRModule splitBillShareQRModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillShareQRModule;
    }

    public static SplitBillShareQRModule_ProvideSplitBillSectionViewFactory PlaceComponentResult(SplitBillShareQRModule splitBillShareQRModule) {
        return new SplitBillShareQRModule_ProvideSplitBillSectionViewFactory(splitBillShareQRModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillShareQRContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
    }
}
