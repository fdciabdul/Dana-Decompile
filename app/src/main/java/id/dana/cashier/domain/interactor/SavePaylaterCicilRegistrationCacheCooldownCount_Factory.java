package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePaylaterCicilRegistrationCacheCooldownCount_Factory implements Factory<SavePaylaterCicilRegistrationCacheCooldownCount> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SavePaylaterCicilRegistrationCacheCooldownCount_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePaylaterCicilRegistrationCacheCooldownCount get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SavePaylaterCicilRegistrationCacheCooldownCount_Factory create(Provider<CashierRepository> provider) {
        return new SavePaylaterCicilRegistrationCacheCooldownCount_Factory(provider);
    }

    public static SavePaylaterCicilRegistrationCacheCooldownCount newInstance(CashierRepository cashierRepository) {
        return new SavePaylaterCicilRegistrationCacheCooldownCount(cashierRepository);
    }
}
