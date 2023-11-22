package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaylaterOfferExpressPurchase_Factory implements Factory<GetPaylaterOfferExpressPurchase> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public GetPaylaterOfferExpressPurchase_Factory(Provider<ExpressPurchaseRepository> provider, Provider<UserConsentRepository> provider2) {
        this.expressPurchaseRepositoryProvider = provider;
        this.userConsentRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetPaylaterOfferExpressPurchase get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get(), this.userConsentRepositoryProvider.get());
    }

    public static GetPaylaterOfferExpressPurchase_Factory create(Provider<ExpressPurchaseRepository> provider, Provider<UserConsentRepository> provider2) {
        return new GetPaylaterOfferExpressPurchase_Factory(provider, provider2);
    }

    public static GetPaylaterOfferExpressPurchase newInstance(ExpressPurchaseRepository expressPurchaseRepository, UserConsentRepository userConsentRepository) {
        return new GetPaylaterOfferExpressPurchase(expressPurchaseRepository, userConsentRepository);
    }
}
