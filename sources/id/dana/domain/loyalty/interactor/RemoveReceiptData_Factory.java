package id.dana.domain.loyalty.interactor;

import dagger.internal.Factory;
import id.dana.domain.loyalty.LoyaltyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class RemoveReceiptData_Factory implements Factory<RemoveReceiptData> {
    private final Provider<LoyaltyRepository> loyaltyRepositoryProvider;

    public RemoveReceiptData_Factory(Provider<LoyaltyRepository> provider) {
        this.loyaltyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveReceiptData get() {
        return newInstance(this.loyaltyRepositoryProvider.get());
    }

    public static RemoveReceiptData_Factory create(Provider<LoyaltyRepository> provider) {
        return new RemoveReceiptData_Factory(provider);
    }

    public static RemoveReceiptData newInstance(LoyaltyRepository loyaltyRepository) {
        return new RemoveReceiptData(loyaltyRepository);
    }
}
