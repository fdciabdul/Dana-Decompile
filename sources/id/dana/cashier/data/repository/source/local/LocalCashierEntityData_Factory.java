package id.dana.cashier.data.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LocalCashierEntityData_Factory implements Factory<LocalCashierEntityData> {
    private final Provider<CashierPreference> cashierPreferenceProvider;

    public LocalCashierEntityData_Factory(Provider<CashierPreference> provider) {
        this.cashierPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalCashierEntityData get() {
        return newInstance(this.cashierPreferenceProvider.get());
    }

    public static LocalCashierEntityData_Factory create(Provider<CashierPreference> provider) {
        return new LocalCashierEntityData_Factory(provider);
    }

    public static LocalCashierEntityData newInstance(CashierPreference cashierPreference) {
        return new LocalCashierEntityData(cashierPreference);
    }
}
