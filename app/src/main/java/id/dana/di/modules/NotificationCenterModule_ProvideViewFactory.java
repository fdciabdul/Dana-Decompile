package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.notificationcenter.NotificationCenterContract;

/* loaded from: classes4.dex */
public final class NotificationCenterModule_ProvideViewFactory implements Factory<NotificationCenterContract.View> {
    private final NotificationCenterModule PlaceComponentResult;

    public static NotificationCenterContract.View getAuthRequestContext(NotificationCenterModule notificationCenterModule) {
        return (NotificationCenterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(notificationCenterModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NotificationCenterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory());
    }
}
