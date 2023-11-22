package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.TopUpAndPayContract;

/* loaded from: classes4.dex */
public final class TopUpAndPayModule_ProvideTopUpAndPayViewFactory implements Factory<TopUpAndPayContract.View> {
    private final TopUpAndPayModule MyBillsEntityDataFactory;

    private TopUpAndPayModule_ProvideTopUpAndPayViewFactory(TopUpAndPayModule topUpAndPayModule) {
        this.MyBillsEntityDataFactory = topUpAndPayModule;
    }

    public static TopUpAndPayModule_ProvideTopUpAndPayViewFactory KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayModule topUpAndPayModule) {
        return new TopUpAndPayModule_ProvideTopUpAndPayViewFactory(topUpAndPayModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TopUpAndPayContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
