package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePaylaterCicilRegistrationCacheCooldownDelay_Factory implements Factory<SavePaylaterCicilRegistrationCacheCooldownDelay> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SavePaylaterCicilRegistrationCacheCooldownDelay_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePaylaterCicilRegistrationCacheCooldownDelay get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SavePaylaterCicilRegistrationCacheCooldownDelay_Factory create(Provider<CashierRepository> provider) {
        return new SavePaylaterCicilRegistrationCacheCooldownDelay_Factory(provider);
    }

    public static SavePaylaterCicilRegistrationCacheCooldownDelay newInstance(CashierRepository cashierRepository) {
        return new SavePaylaterCicilRegistrationCacheCooldownDelay(cashierRepository);
    }
}
