package id.dana.domain.carrieridentification.interactor;

import dagger.internal.Factory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckIpificationCoverage_Factory implements Factory<CheckIpificationCoverage> {
    private final Provider<CarrierIdentificationRepository> carrierIdentificationRepositoryProvider;

    public CheckIpificationCoverage_Factory(Provider<CarrierIdentificationRepository> provider) {
        this.carrierIdentificationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckIpificationCoverage get() {
        return newInstance(this.carrierIdentificationRepositoryProvider.get());
    }

    public static CheckIpificationCoverage_Factory create(Provider<CarrierIdentificationRepository> provider) {
        return new CheckIpificationCoverage_Factory(provider);
    }

    public static CheckIpificationCoverage newInstance(CarrierIdentificationRepository carrierIdentificationRepository) {
        return new CheckIpificationCoverage(carrierIdentificationRepository);
    }
}
