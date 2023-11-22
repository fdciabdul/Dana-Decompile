package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillIntroductionContract;

/* loaded from: classes4.dex */
public final class SplitBillIntroductionModule_ProvideViewFactory implements Factory<SplitBillIntroductionContract.View> {
    private final SplitBillIntroductionModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitBillIntroductionModule_ProvideViewFactory(SplitBillIntroductionModule splitBillIntroductionModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillIntroductionModule;
    }

    public static SplitBillIntroductionModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(SplitBillIntroductionModule splitBillIntroductionModule) {
        return new SplitBillIntroductionModule_ProvideViewFactory(splitBillIntroductionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillIntroductionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
