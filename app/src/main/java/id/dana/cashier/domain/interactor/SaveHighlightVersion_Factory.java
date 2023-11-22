package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveHighlightVersion_Factory implements Factory<SaveHighlightVersion> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SaveHighlightVersion_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveHighlightVersion get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SaveHighlightVersion_Factory create(Provider<CashierRepository> provider) {
        return new SaveHighlightVersion_Factory(provider);
    }

    public static SaveHighlightVersion newInstance(CashierRepository cashierRepository) {
        return new SaveHighlightVersion(cashierRepository);
    }
}
