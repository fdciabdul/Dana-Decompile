package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAddOnOfferExpressPurchase_Factory implements Factory<GetAddOnOfferExpressPurchase> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public GetAddOnOfferExpressPurchase_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAddOnOfferExpressPurchase get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static GetAddOnOfferExpressPurchase_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new GetAddOnOfferExpressPurchase_Factory(provider);
    }

    public static GetAddOnOfferExpressPurchase newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new GetAddOnOfferExpressPurchase(expressPurchaseRepository);
    }
}
