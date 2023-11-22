package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePushNotificationRepositoryFactory implements Factory<PushNotificationRepository> {
    private final Provider<PushNotificationEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvidePushNotificationRepositoryFactory(ApplicationModule applicationModule, Provider<PushNotificationEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvidePushNotificationRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<PushNotificationEntityRepository> provider) {
        return new ApplicationModule_ProvidePushNotificationRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushNotificationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
