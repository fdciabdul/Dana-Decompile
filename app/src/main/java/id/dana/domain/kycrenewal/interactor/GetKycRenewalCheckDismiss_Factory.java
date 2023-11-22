package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycRenewalCheckDismiss_Factory implements Factory<GetKycRenewalCheckDismiss> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public GetKycRenewalCheckDismiss_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycRenewalCheckDismiss get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static GetKycRenewalCheckDismiss_Factory create(Provider<KycRenewalRepository> provider) {
        return new GetKycRenewalCheckDismiss_Factory(provider);
    }

    public static GetKycRenewalCheckDismiss newInstance(KycRenewalRepository kycRenewalRepository) {
        return new GetKycRenewalCheckDismiss(kycRenewalRepository);
    }
}
