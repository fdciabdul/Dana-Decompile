package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.notificationcenter.NotificationCenterContract;
import id.dana.notificationcenter.NotificationCenterPresenter;

@Module
/* loaded from: classes4.dex */
public class NotificationCenterModule {
    private NotificationCenterContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public NotificationCenterContract.Presenter BuiltInFictitiousFunctionClassFactory(NotificationCenterPresenter notificationCenterPresenter) {
        return notificationCenterPresenter;
    }

    public NotificationCenterModule(NotificationCenterContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public NotificationCenterContract.View MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
