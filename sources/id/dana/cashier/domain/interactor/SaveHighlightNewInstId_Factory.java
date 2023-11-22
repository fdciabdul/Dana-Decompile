package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveHighlightNewInstId_Factory implements Factory<SaveHighlightNewInstId> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SaveHighlightNewInstId_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveHighlightNewInstId get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SaveHighlightNewInstId_Factory create(Provider<CashierRepository> provider) {
        return new SaveHighlightNewInstId_Factory(provider);
    }

    public static SaveHighlightNewInstId newInstance(CashierRepository cashierRepository) {
        return new SaveHighlightNewInstId(cashierRepository);
    }
}
