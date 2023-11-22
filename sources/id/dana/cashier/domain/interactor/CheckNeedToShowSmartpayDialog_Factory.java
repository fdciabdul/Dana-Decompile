package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckNeedToShowSmartpayDialog_Factory implements Factory<CheckNeedToShowSmartpayDialog> {
    private final Provider<CashierRepository> cashierRepositoryProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckNeedToShowSmartpayDialog_Factory(Provider<FeatureConfigRepository> provider, Provider<CashierRepository> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.cashierRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CheckNeedToShowSmartpayDialog get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.cashierRepositoryProvider.get());
    }

    public static CheckNeedToShowSmartpayDialog_Factory create(Provider<FeatureConfigRepository> provider, Provider<CashierRepository> provider2) {
        return new CheckNeedToShowSmartpayDialog_Factory(provider, provider2);
    }

    public static CheckNeedToShowSmartpayDialog newInstance(FeatureConfigRepository featureConfigRepository, CashierRepository cashierRepository) {
        return new CheckNeedToShowSmartpayDialog(featureConfigRepository, cashierRepository);
    }
}
