package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.userconfig.UserConfigContract;
import id.dana.userconfig.UserConfigPresenter;

@Module
/* loaded from: classes2.dex */
public class UserConfigModule {
    private final UserConfigContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UserConfigContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(UserConfigPresenter userConfigPresenter) {
        return userConfigPresenter;
    }

    public UserConfigModule(UserConfigContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UserConfigContract.View PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }
}
