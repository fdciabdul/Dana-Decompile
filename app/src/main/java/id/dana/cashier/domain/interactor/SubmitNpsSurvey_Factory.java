package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubmitNpsSurvey_Factory implements Factory<SubmitNpsSurvey> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SubmitNpsSurvey_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SubmitNpsSurvey get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SubmitNpsSurvey_Factory create(Provider<CashierRepository> provider) {
        return new SubmitNpsSurvey_Factory(provider);
    }

    public static SubmitNpsSurvey newInstance(CashierRepository cashierRepository) {
        return new SubmitNpsSurvey(cashierRepository);
    }
}
