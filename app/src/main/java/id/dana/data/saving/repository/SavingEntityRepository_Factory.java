package id.dana.data.saving.repository;

import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingEntityRepository_Factory implements Factory<SavingEntityRepository> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<SavingConfigEntityDataFactory> savingConfigEntityDataFactoryProvider;
    private final Provider<SavingEntityDataFactory> savingEntityDataFactoryProvider;
    private final Provider<SavingWithdrawEntityDataFactory> savingWithdrawEntityDataFactoryProvider;

    public SavingEntityRepository_Factory(Provider<DeviceInformationProvider> provider, Provider<SavingEntityDataFactory> provider2, Provider<SavingWithdrawEntityDataFactory> provider3, Provider<SavingConfigEntityDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.deviceInformationProvider = provider;
        this.savingEntityDataFactoryProvider = provider2;
        this.savingWithdrawEntityDataFactoryProvider = provider3;
        this.savingConfigEntityDataFactoryProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final SavingEntityRepository get() {
        return newInstance(this.deviceInformationProvider.get(), this.savingEntityDataFactoryProvider.get(), this.savingWithdrawEntityDataFactoryProvider.get(), this.savingConfigEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static SavingEntityRepository_Factory create(Provider<DeviceInformationProvider> provider, Provider<SavingEntityDataFactory> provider2, Provider<SavingWithdrawEntityDataFactory> provider3, Provider<SavingConfigEntityDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new SavingEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SavingEntityRepository newInstance(DeviceInformationProvider deviceInformationProvider, SavingEntityDataFactory savingEntityDataFactory, SavingWithdrawEntityDataFactory savingWithdrawEntityDataFactory, SavingConfigEntityDataFactory savingConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new SavingEntityRepository(deviceInformationProvider, savingEntityDataFactory, savingWithdrawEntityDataFactory, savingConfigEntityDataFactory, holdLoginV1EntityRepository);
    }
}
