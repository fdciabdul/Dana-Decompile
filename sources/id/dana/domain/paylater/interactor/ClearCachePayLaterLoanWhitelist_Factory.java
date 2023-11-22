package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ClearCachePayLaterLoanWhitelist_Factory implements Factory<ClearCachePayLaterLoanWhitelist> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public ClearCachePayLaterLoanWhitelist_Factory(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        this.payLaterRepositoryProvider = provider;
        this.servicesRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ClearCachePayLaterLoanWhitelist get() {
        return newInstance(this.payLaterRepositoryProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static ClearCachePayLaterLoanWhitelist_Factory create(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        return new ClearCachePayLaterLoanWhitelist_Factory(provider, provider2);
    }

    public static ClearCachePayLaterLoanWhitelist newInstance(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        return new ClearCachePayLaterLoanWhitelist(paylaterRepository, servicesRepository);
    }
}
