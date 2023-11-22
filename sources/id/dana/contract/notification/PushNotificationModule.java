package id.dana.contract.notification;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class PushNotificationModule {
    private final PushNotificationContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PushNotificationContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(PushNotificationPresenter pushNotificationPresenter) {
        return pushNotificationPresenter;
    }

    public PushNotificationModule(PushNotificationContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PushNotificationContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
