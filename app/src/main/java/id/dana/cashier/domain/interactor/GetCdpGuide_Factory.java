package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetCdpGuide_Factory implements Factory<GetCdpGuide> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCdpGuide_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCdpGuide get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCdpGuide_Factory create(Provider<CashierRepository> provider) {
        return new GetCdpGuide_Factory(provider);
    }

    public static GetCdpGuide newInstance(CashierRepository cashierRepository) {
        return new GetCdpGuide(cashierRepository);
    }
}
