package id.dana.domain.kycrenewal.interactor;

import dagger.internal.Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveKycRenewalCheckDismiss_Factory implements Factory<SaveKycRenewalCheckDismiss> {
    private final Provider<KycRenewalRepository> kycRenewalRepositoryProvider;

    public SaveKycRenewalCheckDismiss_Factory(Provider<KycRenewalRepository> provider) {
        this.kycRenewalRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveKycRenewalCheckDismiss get() {
        return newInstance(this.kycRenewalRepositoryProvider.get());
    }

    public static SaveKycRenewalCheckDismiss_Factory create(Provider<KycRenewalRepository> provider) {
        return new SaveKycRenewalCheckDismiss_Factory(provider);
    }

    public static SaveKycRenewalCheckDismiss newInstance(KycRenewalRepository kycRenewalRepository) {
        return new SaveKycRenewalCheckDismiss(kycRenewalRepository);
    }
}
