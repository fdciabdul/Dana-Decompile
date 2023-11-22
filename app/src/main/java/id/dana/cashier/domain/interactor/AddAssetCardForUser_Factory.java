package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AddAssetCardForUser_Factory implements Factory<AddAssetCardForUser> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public AddAssetCardForUser_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AddAssetCardForUser get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static AddAssetCardForUser_Factory create(Provider<CashierRepository> provider) {
        return new AddAssetCardForUser_Factory(provider);
    }

    public static AddAssetCardForUser newInstance(CashierRepository cashierRepository) {
        return new AddAssetCardForUser(cashierRepository);
    }
}
