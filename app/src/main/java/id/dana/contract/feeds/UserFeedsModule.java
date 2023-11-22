package id.dana.contract.feeds;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.feeds.UserFeedsContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class UserFeedsModule {
    private final UserFeedsContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UserFeedsContract.Presenter BuiltInFictitiousFunctionClassFactory(UserFeedsPresenter userFeedsPresenter) {
        return userFeedsPresenter;
    }

    public UserFeedsModule(UserFeedsContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UserFeedsContract.View PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
