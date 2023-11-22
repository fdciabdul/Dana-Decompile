package id.dana.contract.user;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class GetUserInfoModule {
    private final GetUserInfoContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetUserInfoContract.Presenter BuiltInFictitiousFunctionClassFactory(GetUserInfoPresenter getUserInfoPresenter) {
        return getUserInfoPresenter;
    }

    public GetUserInfoModule(GetUserInfoContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetUserInfoContract.View PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
