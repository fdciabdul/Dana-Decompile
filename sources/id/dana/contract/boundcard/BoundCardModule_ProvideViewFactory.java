package id.dana.contract.boundcard;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.boundcard.BoundCardContract;

/* loaded from: classes8.dex */
public final class BoundCardModule_ProvideViewFactory implements Factory<BoundCardContract.View> {
    private final BoundCardModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static BoundCardContract.View KClassImpl$Data$declaredNonStaticMembers$2(BoundCardModule boundCardModule) {
        return (BoundCardContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(boundCardModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BoundCardContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
    }
}
