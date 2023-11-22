package id.dana.domain.loyalty.interactor;

import dagger.internal.Factory;
import id.dana.domain.loyalty.LoyaltyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetReceiptData_Factory implements Factory<GetReceiptData> {
    private final Provider<LoyaltyRepository> loyaltyRepositoryProvider;

    public GetReceiptData_Factory(Provider<LoyaltyRepository> provider) {
        this.loyaltyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReceiptData get() {
        return newInstance(this.loyaltyRepositoryProvider.get());
    }

    public static GetReceiptData_Factory create(Provider<LoyaltyRepository> provider) {
        return new GetReceiptData_Factory(provider);
    }

    public static GetReceiptData newInstance(LoyaltyRepository loyaltyRepository) {
        return new GetReceiptData(loyaltyRepository);
    }
}
