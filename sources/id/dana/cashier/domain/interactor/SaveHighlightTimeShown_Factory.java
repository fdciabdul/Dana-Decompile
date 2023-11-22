package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveHighlightTimeShown_Factory implements Factory<SaveHighlightTimeShown> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SaveHighlightTimeShown_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveHighlightTimeShown get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SaveHighlightTimeShown_Factory create(Provider<CashierRepository> provider) {
        return new SaveHighlightTimeShown_Factory(provider);
    }

    public static SaveHighlightTimeShown newInstance(CashierRepository cashierRepository) {
        return new SaveHighlightTimeShown(cashierRepository);
    }
}
