package id.dana.contract.notification;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.notification.PushNotificationContract;

/* loaded from: classes4.dex */
public final class PushNotificationModule_ProvideViewFactory implements Factory<PushNotificationContract.View> {
    private final PushNotificationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PushNotificationModule_ProvideViewFactory(PushNotificationModule pushNotificationModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pushNotificationModule;
    }

    public static PushNotificationModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(PushNotificationModule pushNotificationModule) {
        return new PushNotificationModule_ProvideViewFactory(pushNotificationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushNotificationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
