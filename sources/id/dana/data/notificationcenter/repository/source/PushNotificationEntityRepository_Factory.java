package id.dana.data.notificationcenter.repository.source;

import dagger.internal.Factory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.notificationcenter.mapper.PushNotificationMapper;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushNotificationEntityRepository_Factory implements Factory<PushNotificationEntityRepository> {
    private final Provider<PushNotificationEntityDataFactory> factoryProvider;
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PushNotificationMapper> pushNotificationMapperProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;

    public PushNotificationEntityRepository_Factory(Provider<GeneralPreferencesDataFactory> provider, Provider<PushNotificationEntityDataFactory> provider2, Provider<PushNotificationMapper> provider3, Provider<SecurityGuardFacade> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.generalPreferencesDataFactoryProvider = provider;
        this.factoryProvider = provider2;
        this.pushNotificationMapperProvider = provider3;
        this.securityGuardFacadeProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final PushNotificationEntityRepository get() {
        return newInstance(this.generalPreferencesDataFactoryProvider.get(), this.factoryProvider.get(), this.pushNotificationMapperProvider.get(), this.securityGuardFacadeProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PushNotificationEntityRepository_Factory create(Provider<GeneralPreferencesDataFactory> provider, Provider<PushNotificationEntityDataFactory> provider2, Provider<PushNotificationMapper> provider3, Provider<SecurityGuardFacade> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new PushNotificationEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PushNotificationEntityRepository newInstance(GeneralPreferencesDataFactory generalPreferencesDataFactory, PushNotificationEntityDataFactory pushNotificationEntityDataFactory, PushNotificationMapper pushNotificationMapper, SecurityGuardFacade securityGuardFacade, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PushNotificationEntityRepository(generalPreferencesDataFactory, pushNotificationEntityDataFactory, pushNotificationMapper, securityGuardFacade, holdLoginV1EntityRepository);
    }
}
