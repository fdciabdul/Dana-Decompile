package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveKycRenewalButtonClick_Factory implements Factory<SaveKycRenewalButtonClick> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public SaveKycRenewalButtonClick_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveKycRenewalButtonClick get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static SaveKycRenewalButtonClick_Factory create(Provider<KycRenewalRepository> provider) {
        return new SaveKycRenewalButtonClick_Factory(provider);
    }

    public static SaveKycRenewalButtonClick newInstance(KycRenewalRepository kycRenewalRepository) {
        return new SaveKycRenewalButtonClick(kycRenewalRepository);
    }
}
