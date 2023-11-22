package id.dana.data.risk.riskevent.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.risk.riskevent.SendRiskEventEntityDataFactory;
import id.dana.data.risk.riskevent.config.RiskServicesConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendRiskEventEntityRepository_Factory implements Factory<SendRiskEventEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<RiskServicesConfigEntityDataFactory> riskServicesConfigEntityDataFactoryProvider;
    private final Provider<SendRiskEventEntityDataFactory> sendRiskEventEntityDataFactoryProvider;

    public SendRiskEventEntityRepository_Factory(Provider<SendRiskEventEntityDataFactory> provider, Provider<RiskServicesConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.sendRiskEventEntityDataFactoryProvider = provider;
        this.riskServicesConfigEntityDataFactoryProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SendRiskEventEntityRepository get() {
        return newInstance(this.sendRiskEventEntityDataFactoryProvider.get(), this.riskServicesConfigEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static SendRiskEventEntityRepository_Factory create(Provider<SendRiskEventEntityDataFactory> provider, Provider<RiskServicesConfigEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new SendRiskEventEntityRepository_Factory(provider, provider2, provider3);
    }

    public static SendRiskEventEntityRepository newInstance(SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory, RiskServicesConfigEntityDataFactory riskServicesConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new SendRiskEventEntityRepository(sendRiskEventEntityDataFactory, riskServicesConfigEntityDataFactory, holdLoginV1EntityRepository);
    }
}
