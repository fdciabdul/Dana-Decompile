package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.GetStaticQrContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStaticQrModule_ProvidePresenterFactory implements Factory<GetStaticQrContract.Presenter> {
    private final Provider<GetStaticQrPresenter> BuiltInFictitiousFunctionClassFactory;
    private final GetStaticQrModule MyBillsEntityDataFactory;

    private GetStaticQrModule_ProvidePresenterFactory(GetStaticQrModule getStaticQrModule, Provider<GetStaticQrPresenter> provider) {
        this.MyBillsEntityDataFactory = getStaticQrModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetStaticQrModule_ProvidePresenterFactory PlaceComponentResult(GetStaticQrModule getStaticQrModule, Provider<GetStaticQrPresenter> provider) {
        return new GetStaticQrModule_ProvidePresenterFactory(getStaticQrModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetStaticQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
