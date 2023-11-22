package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyOtpRisk_Factory implements Factory<VerifyOtpRisk> {
    private final Provider<CarrierIdentificationRepository> carrierIdentificationRepositoryProvider;

    public VerifyOtpRisk_Factory(Provider<CarrierIdentificationRepository> provider) {
        this.carrierIdentificationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyOtpRisk get() {
        return newInstance(this.carrierIdentificationRepositoryProvider.get());
    }

    public static VerifyOtpRisk_Factory create(Provider<CarrierIdentificationRepository> provider) {
        return new VerifyOtpRisk_Factory(provider);
    }

    public static VerifyOtpRisk newInstance(CarrierIdentificationRepository carrierIdentificationRepository) {
        return new VerifyOtpRisk(carrierIdentificationRepository);
    }
}
