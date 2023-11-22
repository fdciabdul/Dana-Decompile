package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.GetPaymentResultContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaymentResultModule_ProvidePresenterFactory implements Factory<GetPaymentResultContract.Presenter> {
    private final GetPaymentResultModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPaymentResultPresenter> getAuthRequestContext;

    private GetPaymentResultModule_ProvidePresenterFactory(GetPaymentResultModule getPaymentResultModule, Provider<GetPaymentResultPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = getPaymentResultModule;
        this.getAuthRequestContext = provider;
    }

    public static GetPaymentResultModule_ProvidePresenterFactory PlaceComponentResult(GetPaymentResultModule getPaymentResultModule, Provider<GetPaymentResultPresenter> provider) {
        return new GetPaymentResultModule_ProvidePresenterFactory(getPaymentResultModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetPaymentResultContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
