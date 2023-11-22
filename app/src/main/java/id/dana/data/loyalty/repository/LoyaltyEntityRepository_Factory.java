package id.dana.data.loyalty.repository;

import dagger.internal.Factory;
import id.dana.data.loyalty.repository.source.LoyaltyEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LoyaltyEntityRepository_Factory implements Factory<LoyaltyEntityRepository> {
    private final Provider<LoyaltyEntityDataFactory> loyaltyEntityDataFactoryProvider;

    public LoyaltyEntityRepository_Factory(Provider<LoyaltyEntityDataFactory> provider) {
        this.loyaltyEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LoyaltyEntityRepository get() {
        return newInstance(this.loyaltyEntityDataFactoryProvider.get());
    }

    public static LoyaltyEntityRepository_Factory create(Provider<LoyaltyEntityDataFactory> provider) {
        return new LoyaltyEntityRepository_Factory(provider);
    }

    public static LoyaltyEntityRepository newInstance(LoyaltyEntityDataFactory loyaltyEntityDataFactory) {
        return new LoyaltyEntityRepository(loyaltyEntityDataFactory);
    }
}
