package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycRenewalCheckQuery_Factory implements Factory<GetKycRenewalCheckQuery> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public GetKycRenewalCheckQuery_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycRenewalCheckQuery get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static GetKycRenewalCheckQuery_Factory create(Provider<KycRenewalRepository> provider) {
        return new GetKycRenewalCheckQuery_Factory(provider);
    }

    public static GetKycRenewalCheckQuery newInstance(KycRenewalRepository kycRenewalRepository) {
        return new GetKycRenewalCheckQuery(kycRenewalRepository);
    }
}
