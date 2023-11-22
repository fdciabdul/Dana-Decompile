package id.dana.contract.feeds;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.feeds.GlobalFeedsContract;

/* loaded from: classes4.dex */
public final class GlobalFeedsModule_ProvideViewFactory implements Factory<GlobalFeedsContract.View> {
    private final GlobalFeedsModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GlobalFeedsModule_ProvideViewFactory(GlobalFeedsModule globalFeedsModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalFeedsModule;
    }

    public static GlobalFeedsModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(GlobalFeedsModule globalFeedsModule) {
        return new GlobalFeedsModule_ProvideViewFactory(globalFeedsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalFeedsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
    }
}
