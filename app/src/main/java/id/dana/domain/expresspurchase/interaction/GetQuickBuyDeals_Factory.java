package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQuickBuyDeals_Factory implements Factory<GetQuickBuyDeals> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public GetQuickBuyDeals_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQuickBuyDeals get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static GetQuickBuyDeals_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new GetQuickBuyDeals_Factory(provider);
    }

    public static GetQuickBuyDeals newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new GetQuickBuyDeals(expressPurchaseRepository);
    }
}
