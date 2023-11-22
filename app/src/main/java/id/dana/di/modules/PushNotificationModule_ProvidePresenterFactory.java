package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PushNotificationModule_ProvidePresenterFactory implements Factory<PushNotificationContract.Presenter> {
    private final PushNotificationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PushNotificationPresenter> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushNotificationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
