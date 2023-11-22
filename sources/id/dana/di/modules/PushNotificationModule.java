package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class PushNotificationModule {
    private final PushNotificationContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PushNotificationContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(PushNotificationPresenter pushNotificationPresenter) {
        return pushNotificationPresenter;
    }

    public PushNotificationModule(PushNotificationContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PushNotificationContract.View MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}
