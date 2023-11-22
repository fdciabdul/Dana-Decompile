package id.dana.contract.payasset;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.QueryPayMethodContract;

/* loaded from: classes4.dex */
public final class QueryPayMethodModule_ProvideViewFactory implements Factory<QueryPayMethodContract.View> {
    private final QueryPayMethodModule MyBillsEntityDataFactory;

    private QueryPayMethodModule_ProvideViewFactory(QueryPayMethodModule queryPayMethodModule) {
        this.MyBillsEntityDataFactory = queryPayMethodModule;
    }

    public static QueryPayMethodModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(QueryPayMethodModule queryPayMethodModule) {
        return new QueryPayMethodModule_ProvideViewFactory(queryPayMethodModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QueryPayMethodContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
