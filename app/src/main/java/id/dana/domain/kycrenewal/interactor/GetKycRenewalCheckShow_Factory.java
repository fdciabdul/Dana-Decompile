package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycRenewalCheckShow_Factory implements Factory<GetKycRenewalCheckShow> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public GetKycRenewalCheckShow_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycRenewalCheckShow get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static GetKycRenewalCheckShow_Factory create(Provider<KycRenewalRepository> provider) {
        return new GetKycRenewalCheckShow_Factory(provider);
    }

    public static GetKycRenewalCheckShow newInstance(KycRenewalRepository kycRenewalRepository) {
        return new GetKycRenewalCheckShow(kycRenewalRepository);
    }
}
