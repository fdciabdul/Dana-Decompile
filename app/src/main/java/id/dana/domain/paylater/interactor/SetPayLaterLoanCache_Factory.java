package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetPayLaterLoanCache_Factory implements Factory<SetPayLaterLoanCache> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public SetPayLaterLoanCache_Factory(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        this.payLaterRepositoryProvider = provider;
        this.servicesRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SetPayLaterLoanCache get() {
        return newInstance(this.payLaterRepositoryProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static SetPayLaterLoanCache_Factory create(Provider<PaylaterRepository> provider, Provider<ServicesRepository> provider2) {
        return new SetPayLaterLoanCache_Factory(provider, provider2);
    }

    public static SetPayLaterLoanCache newInstance(PaylaterRepository paylaterRepository, ServicesRepository servicesRepository) {
        return new SetPayLaterLoanCache(paylaterRepository, servicesRepository);
    }
}
