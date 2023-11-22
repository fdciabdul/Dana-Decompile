package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaylaterCicilRegistrationCooldownCache_Factory implements Factory<GetPaylaterCicilRegistrationCooldownCache> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetPaylaterCicilRegistrationCooldownCache_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPaylaterCicilRegistrationCooldownCache get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetPaylaterCicilRegistrationCooldownCache_Factory create(Provider<CashierRepository> provider) {
        return new GetPaylaterCicilRegistrationCooldownCache_Factory(provider);
    }

    public static GetPaylaterCicilRegistrationCooldownCache newInstance(CashierRepository cashierRepository) {
        return new GetPaylaterCicilRegistrationCooldownCache(cashierRepository);
    }
}
