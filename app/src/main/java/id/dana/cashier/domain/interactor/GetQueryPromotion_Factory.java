package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryPromotion_Factory implements Factory<GetQueryPromotion> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetQueryPromotion_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQueryPromotion get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetQueryPromotion_Factory create(Provider<CashierRepository> provider) {
        return new GetQueryPromotion_Factory(provider);
    }

    public static GetQueryPromotion newInstance(CashierRepository cashierRepository) {
        return new GetQueryPromotion(cashierRepository);
    }
}
