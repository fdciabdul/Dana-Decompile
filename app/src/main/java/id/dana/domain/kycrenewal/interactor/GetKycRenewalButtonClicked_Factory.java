package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycRenewalButtonClicked_Factory implements Factory<GetKycRenewalButtonClicked> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public GetKycRenewalButtonClicked_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycRenewalButtonClicked get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static GetKycRenewalButtonClicked_Factory create(Provider<KycRenewalRepository> provider) {
        return new GetKycRenewalButtonClicked_Factory(provider);
    }

    public static GetKycRenewalButtonClicked newInstance(KycRenewalRepository kycRenewalRepository) {
        return new GetKycRenewalButtonClicked(kycRenewalRepository);
    }
}
