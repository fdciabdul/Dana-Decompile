package id.dana.contract.payasset;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.QueryPayMethodContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QueryPayMethodModule_ProvidePresenterFactory implements Factory<QueryPayMethodContract.Presenter> {
    private final QueryPayMethodModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<QueryPayMethodPresenter> MyBillsEntityDataFactory;

    private QueryPayMethodModule_ProvidePresenterFactory(QueryPayMethodModule queryPayMethodModule, Provider<QueryPayMethodPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = queryPayMethodModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static QueryPayMethodModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(QueryPayMethodModule queryPayMethodModule, Provider<QueryPayMethodPresenter> provider) {
        return new QueryPayMethodModule_ProvidePresenterFactory(queryPayMethodModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QueryPayMethodContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
