package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ValidateGoldProduct_Factory implements Factory<ValidateGoldProduct> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public ValidateGoldProduct_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ValidateGoldProduct get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static ValidateGoldProduct_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new ValidateGoldProduct_Factory(provider);
    }

    public static ValidateGoldProduct newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new ValidateGoldProduct(expressPurchaseRepository);
    }
}
