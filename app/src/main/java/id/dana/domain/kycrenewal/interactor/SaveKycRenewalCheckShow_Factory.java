package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckShow_Factory implements Factory<SaveKycRenewalCheckShow> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public SaveKycRenewalCheckShow_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveKycRenewalCheckShow get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static SaveKycRenewalCheckShow_Factory create(Provider<KycRenewalRepository> provider) {
        return new SaveKycRenewalCheckShow_Factory(provider);
    }

    public static SaveKycRenewalCheckShow newInstance(KycRenewalRepository kycRenewalRepository) {
        return new SaveKycRenewalCheckShow(kycRenewalRepository);
    }
}
