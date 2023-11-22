package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.notificationcenter.NotificationCenterContract;
import id.dana.notificationcenter.NotificationCenterPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NotificationCenterModule_ProvidePresenterFactory implements Factory<NotificationCenterContract.Presenter> {
    private final Provider<NotificationCenterPresenter> MyBillsEntityDataFactory;
    private final NotificationCenterModule getAuthRequestContext;

    public static NotificationCenterContract.Presenter BuiltInFictitiousFunctionClassFactory(NotificationCenterModule notificationCenterModule, NotificationCenterPresenter notificationCenterPresenter) {
        return (NotificationCenterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(notificationCenterModule.BuiltInFictitiousFunctionClassFactory(notificationCenterPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NotificationCenterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
