package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.contact.DanaContactContract;

/* loaded from: classes4.dex */
public final class DanaContactModule_ProvideViewFactory implements Factory<DanaContactContract.View> {
    private final DanaContactModule MyBillsEntityDataFactory;

    private DanaContactModule_ProvideViewFactory(DanaContactModule danaContactModule) {
        this.MyBillsEntityDataFactory = danaContactModule;
    }

    public static DanaContactModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(DanaContactModule danaContactModule) {
        return new DanaContactModule_ProvideViewFactory(danaContactModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaContactContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
