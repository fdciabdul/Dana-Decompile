package id.dana.contract.homeinfo;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class HomeInfoModule {
    private final HomeInfoContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public HomeInfoContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(HomeInfoPresenter homeInfoPresenter) {
        return homeInfoPresenter;
    }

    public HomeInfoModule(HomeInfoContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public HomeInfoContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
