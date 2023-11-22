package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FetchNpsSurvey_Factory implements Factory<FetchNpsSurvey> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public FetchNpsSurvey_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FetchNpsSurvey get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static FetchNpsSurvey_Factory create(Provider<CashierRepository> provider) {
        return new FetchNpsSurvey_Factory(provider);
    }

    public static FetchNpsSurvey newInstance(CashierRepository cashierRepository) {
        return new FetchNpsSurvey(cashierRepository);
    }
}
