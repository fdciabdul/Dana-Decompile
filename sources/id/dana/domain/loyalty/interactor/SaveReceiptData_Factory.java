package id.dana.domain.loyalty.interactor;

import dagger.internal.Factory;
import id.dana.domain.loyalty.LoyaltyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveReceiptData_Factory implements Factory<SaveReceiptData> {
    private final Provider<LoyaltyRepository> loyaltyRepositoryProvider;

    public SaveReceiptData_Factory(Provider<LoyaltyRepository> provider) {
        this.loyaltyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveReceiptData get() {
        return newInstance(this.loyaltyRepositoryProvider.get());
    }

    public static SaveReceiptData_Factory create(Provider<LoyaltyRepository> provider) {
        return new SaveReceiptData_Factory(provider);
    }

    public static SaveReceiptData newInstance(LoyaltyRepository loyaltyRepository) {
        return new SaveReceiptData(loyaltyRepository);
    }
}
