package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DealsExpressOrderQueryByCondition_Factory implements Factory<DealsExpressOrderQueryByCondition> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public DealsExpressOrderQueryByCondition_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DealsExpressOrderQueryByCondition get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static DealsExpressOrderQueryByCondition_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new DealsExpressOrderQueryByCondition_Factory(provider);
    }

    public static DealsExpressOrderQueryByCondition newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new DealsExpressOrderQueryByCondition(expressPurchaseRepository);
    }
}
