package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycRenewal_Factory implements Factory<GetKycRenewal> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public GetKycRenewal_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycRenewal get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static GetKycRenewal_Factory create(Provider<KycRenewalRepository> provider) {
        return new GetKycRenewal_Factory(provider);
    }

    public static GetKycRenewal newInstance(KycRenewalRepository kycRenewalRepository) {
        return new GetKycRenewal(kycRenewalRepository);
    }
}
