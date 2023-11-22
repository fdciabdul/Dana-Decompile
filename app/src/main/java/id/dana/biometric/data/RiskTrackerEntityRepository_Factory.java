package id.dana.biometric.data;

import dagger.internal.Factory;
import id.dana.biometric.data.source.RiskTrackerConfigEntityDataFactory;
import id.dana.biometric.data.source.RiskTrackerEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskTrackerEntityRepository_Factory implements Factory<RiskTrackerEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<RiskTrackerConfigEntityDataFactory> riskTrackerConfigEntityDataFactoryProvider;
    private final Provider<RiskTrackerEntityDataFactory> riskTrackerEntityDataFactoryProvider;

    public RiskTrackerEntityRepository_Factory(Provider<RiskTrackerEntityDataFactory> provider, Provider<RiskTrackerConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.riskTrackerEntityDataFactoryProvider = provider;
        this.riskTrackerConfigEntityDataFactoryProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RiskTrackerEntityRepository get() {
        return newInstance(this.riskTrackerEntityDataFactoryProvider.get(), this.riskTrackerConfigEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static RiskTrackerEntityRepository_Factory create(Provider<RiskTrackerEntityDataFactory> provider, Provider<RiskTrackerConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new RiskTrackerEntityRepository_Factory(provider, provider2, provider3);
    }

    public static RiskTrackerEntityRepository newInstance(RiskTrackerEntityDataFactory riskTrackerEntityDataFactory, RiskTrackerConfigEntityDataFactory riskTrackerConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new RiskTrackerEntityRepository(riskTrackerEntityDataFactory, riskTrackerConfigEntityDataFactory, holdLoginV1EntityRepository);
    }
}
