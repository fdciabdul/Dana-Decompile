package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStateSuspiciousAccountSmartFriction_Factory implements Factory<GetStateSuspiciousAccountSmartFriction> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetStateSuspiciousAccountSmartFriction_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetStateSuspiciousAccountSmartFriction get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetStateSuspiciousAccountSmartFriction_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetStateSuspiciousAccountSmartFriction_Factory(provider);
    }

    public static GetStateSuspiciousAccountSmartFriction newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetStateSuspiciousAccountSmartFriction(sendMoneyRepository);
    }
}
