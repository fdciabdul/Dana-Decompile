package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.di.PerActivity;

@Module(includes = {SessionModule.class})
/* loaded from: classes2.dex */
public class LogoutModule {
    private LogoutContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public LogoutContract.Presenter PlaceComponentResult(LogoutPresenter logoutPresenter) {
        return logoutPresenter;
    }

    public LogoutModule(LogoutContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public LogoutContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
