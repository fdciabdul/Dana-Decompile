package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lazada.LazadaGuideContract;

/* loaded from: classes4.dex */
public final class LazadaModule_ProvideViewFactory implements Factory<LazadaGuideContract.View> {
    private final LazadaModule MyBillsEntityDataFactory;

    public static LazadaGuideContract.View KClassImpl$Data$declaredNonStaticMembers$2(LazadaModule lazadaModule) {
        return (LazadaGuideContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(lazadaModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LazadaGuideContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
    }
}
