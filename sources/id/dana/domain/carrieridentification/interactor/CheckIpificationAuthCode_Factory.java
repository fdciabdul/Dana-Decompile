package id.dana.domain.carrieridentification.interactor;

import dagger.internal.Factory;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckIpificationAuthCode_Factory implements Factory<CheckIpificationAuthCode> {
    private final Provider<CarrierIdentificationRepository> carrierIdentificationRepositoryProvider;

    public CheckIpificationAuthCode_Factory(Provider<CarrierIdentificationRepository> provider) {
        this.carrierIdentificationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckIpificationAuthCode get() {
        return newInstance(this.carrierIdentificationRepositoryProvider.get());
    }

    public static CheckIpificationAuthCode_Factory create(Provider<CarrierIdentificationRepository> provider) {
        return new CheckIpificationAuthCode_Factory(provider);
    }

    public static CheckIpificationAuthCode newInstance(CarrierIdentificationRepository carrierIdentificationRepository) {
        return new CheckIpificationAuthCode(carrierIdentificationRepository);
    }
}
