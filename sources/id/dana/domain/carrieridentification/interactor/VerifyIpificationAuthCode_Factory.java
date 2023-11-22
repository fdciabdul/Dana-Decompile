package id.dana.domain.carrieridentification.interactor;

import dagger.internal.Factory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyIpificationAuthCode_Factory implements Factory<VerifyIpificationAuthCode> {
    private final Provider<CarrierIdentificationRepository> carrierIdentificationRepositoryProvider;

    public VerifyIpificationAuthCode_Factory(Provider<CarrierIdentificationRepository> provider) {
        this.carrierIdentificationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyIpificationAuthCode get() {
        return newInstance(this.carrierIdentificationRepositoryProvider.get());
    }

    public static VerifyIpificationAuthCode_Factory create(Provider<CarrierIdentificationRepository> provider) {
        return new VerifyIpificationAuthCode_Factory(provider);
    }

    public static VerifyIpificationAuthCode newInstance(CarrierIdentificationRepository carrierIdentificationRepository) {
        return new VerifyIpificationAuthCode(carrierIdentificationRepository);
    }
}
