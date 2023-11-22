package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHighlightNewInstId_Factory implements Factory<GetHighlightNewInstId> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetHighlightNewInstId_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHighlightNewInstId get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetHighlightNewInstId_Factory create(Provider<CashierRepository> provider) {
        return new GetHighlightNewInstId_Factory(provider);
    }

    public static GetHighlightNewInstId newInstance(CashierRepository cashierRepository) {
        return new GetHighlightNewInstId(cashierRepository);
    }
}
