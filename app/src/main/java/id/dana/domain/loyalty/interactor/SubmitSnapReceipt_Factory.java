package id.dana.domain.loyalty.interactor;

import dagger.internal.Factory;
import id.dana.domain.loyalty.LoyaltyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SubmitSnapReceipt_Factory implements Factory<SubmitSnapReceipt> {
    private final Provider<LoyaltyRepository> loyaltyRepositoryProvider;

    public SubmitSnapReceipt_Factory(Provider<LoyaltyRepository> provider) {
        this.loyaltyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SubmitSnapReceipt get() {
        return newInstance(this.loyaltyRepositoryProvider.get());
    }

    public static SubmitSnapReceipt_Factory create(Provider<LoyaltyRepository> provider) {
        return new SubmitSnapReceipt_Factory(provider);
    }

    public static SubmitSnapReceipt newInstance(LoyaltyRepository loyaltyRepository) {
        return new SubmitSnapReceipt(loyaltyRepository);
    }
}
