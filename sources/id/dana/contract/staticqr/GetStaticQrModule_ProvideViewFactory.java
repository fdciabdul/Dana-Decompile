package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.GetStaticQrContract;

/* loaded from: classes4.dex */
public final class GetStaticQrModule_ProvideViewFactory implements Factory<GetStaticQrContract.View> {
    private final GetStaticQrModule MyBillsEntityDataFactory;

    private GetStaticQrModule_ProvideViewFactory(GetStaticQrModule getStaticQrModule) {
        this.MyBillsEntityDataFactory = getStaticQrModule;
    }

    public static GetStaticQrModule_ProvideViewFactory MyBillsEntityDataFactory(GetStaticQrModule getStaticQrModule) {
        return new GetStaticQrModule_ProvideViewFactory(getStaticQrModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetStaticQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult());
    }
}
