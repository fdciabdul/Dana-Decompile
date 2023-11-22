package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveStateSuspiciousAccountSmartFriction_Factory implements Factory<SaveStateSuspiciousAccountSmartFriction> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public SaveStateSuspiciousAccountSmartFriction_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveStateSuspiciousAccountSmartFriction get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static SaveStateSuspiciousAccountSmartFriction_Factory create(Provider<SendMoneyRepository> provider) {
        return new SaveStateSuspiciousAccountSmartFriction_Factory(provider);
    }

    public static SaveStateSuspiciousAccountSmartFriction newInstance(SendMoneyRepository sendMoneyRepository) {
        return new SaveStateSuspiciousAccountSmartFriction(sendMoneyRepository);
    }
}
