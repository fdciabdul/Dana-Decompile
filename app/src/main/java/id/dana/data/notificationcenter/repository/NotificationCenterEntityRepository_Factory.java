package id.dana.data.notificationcenter.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.notificationcenter.mapper.NotificationCenterMapper;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NotificationCenterEntityRepository_Factory implements Factory<NotificationCenterEntityRepository> {
    private final Provider<NotificationCenterEntityDataFactory> factoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<NotificationCenterMapper> notificationCenterMapperProvider;

    public NotificationCenterEntityRepository_Factory(Provider<NotificationCenterEntityDataFactory> provider, Provider<NotificationCenterMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.factoryProvider = provider;
        this.notificationCenterMapperProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NotificationCenterEntityRepository get() {
        return newInstance(this.factoryProvider.get(), this.notificationCenterMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static NotificationCenterEntityRepository_Factory create(Provider<NotificationCenterEntityDataFactory> provider, Provider<NotificationCenterMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new NotificationCenterEntityRepository_Factory(provider, provider2, provider3);
    }

    public static NotificationCenterEntityRepository newInstance(NotificationCenterEntityDataFactory notificationCenterEntityDataFactory, NotificationCenterMapper notificationCenterMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new NotificationCenterEntityRepository(notificationCenterEntityDataFactory, notificationCenterMapper, holdLoginV1EntityRepository);
    }
}
