package id.dana.contract.notification;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.notification.PushNotificationContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PushNotificationModule_ProvidePresenterFactory implements Factory<PushNotificationContract.Presenter> {
    private final PushNotificationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<PushNotificationPresenter> MyBillsEntityDataFactory;

    private PushNotificationModule_ProvidePresenterFactory(PushNotificationModule pushNotificationModule, Provider<PushNotificationPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = pushNotificationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static PushNotificationModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(PushNotificationModule pushNotificationModule, Provider<PushNotificationPresenter> provider) {
        return new PushNotificationModule_ProvidePresenterFactory(pushNotificationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushNotificationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
