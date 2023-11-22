package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.notificationcenter.repository.NotificationCenterEntityRepository;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNotificationCenterRepositoryFactory implements Factory<NotificationCenterRepository> {
    private final Provider<NotificationCenterEntityRepository> PlaceComponentResult;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideNotificationCenterRepositoryFactory(ApplicationModule applicationModule, Provider<NotificationCenterEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideNotificationCenterRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<NotificationCenterEntityRepository> provider) {
        return new ApplicationModule_ProvideNotificationCenterRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NotificationCenterRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
