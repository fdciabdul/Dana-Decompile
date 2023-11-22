package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UpdatePayLaterLoanCache_Factory implements Factory<UpdatePayLaterLoanCache> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public UpdatePayLaterLoanCache_Factory(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        this.payLaterRepositoryProvider = provider;
        this.servicesRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UpdatePayLaterLoanCache get() {
        return newInstance(this.payLaterRepositoryProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static UpdatePayLaterLoanCache_Factory create(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        return new UpdatePayLaterLoanCache_Factory(provider, provider2);
    }

    public static UpdatePayLaterLoanCache newInstance(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        return new UpdatePayLaterLoanCache(paylaterRepository, servicesRepository);
    }
}
