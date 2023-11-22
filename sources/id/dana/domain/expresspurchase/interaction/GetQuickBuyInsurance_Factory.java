package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQuickBuyInsurance_Factory implements Factory<GetQuickBuyInsurance> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public GetQuickBuyInsurance_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQuickBuyInsurance get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static GetQuickBuyInsurance_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new GetQuickBuyInsurance_Factory(provider);
    }

    public static GetQuickBuyInsurance newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new GetQuickBuyInsurance(expressPurchaseRepository);
    }
}
