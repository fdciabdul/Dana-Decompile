package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStateSendMoneyShareFeed_Factory implements Factory<GetStateSendMoneyShareFeed> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetStateSendMoneyShareFeed_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetStateSendMoneyShareFeed get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetStateSendMoneyShareFeed_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetStateSendMoneyShareFeed_Factory(provider);
    }

    public static GetStateSendMoneyShareFeed newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetStateSendMoneyShareFeed(sendMoneyRepository);
    }
}
