package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory implements Factory<TopUpAndPayContract.Presenter> {
    private final TopUpAndPayModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<TopUpAndPayPresenter> MyBillsEntityDataFactory;

    private TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory(TopUpAndPayModule topUpAndPayModule, Provider<TopUpAndPayPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = topUpAndPayModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayModule topUpAndPayModule, Provider<TopUpAndPayPresenter> provider) {
        return new TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory(topUpAndPayModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TopUpAndPayContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
