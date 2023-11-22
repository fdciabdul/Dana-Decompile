package id.dana.contract.payasset;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class QueryPayMethodModule {
    private final QueryPayMethodContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public QueryPayMethodContract.Presenter PlaceComponentResult(QueryPayMethodPresenter queryPayMethodPresenter) {
        return queryPayMethodPresenter;
    }

    public QueryPayMethodModule(QueryPayMethodContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public QueryPayMethodContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
