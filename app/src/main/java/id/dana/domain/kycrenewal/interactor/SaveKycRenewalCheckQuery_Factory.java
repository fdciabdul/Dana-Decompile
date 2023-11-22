package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckQuery_Factory implements Factory<SaveKycRenewalCheckQuery> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public SaveKycRenewalCheckQuery_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveKycRenewalCheckQuery get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static SaveKycRenewalCheckQuery_Factory create(Provider<KycRenewalRepository> provider) {
        return new SaveKycRenewalCheckQuery_Factory(provider);
    }

    public static SaveKycRenewalCheckQuery newInstance(KycRenewalRepository kycRenewalRepository) {
        return new SaveKycRenewalCheckQuery(kycRenewalRepository);
    }
}
