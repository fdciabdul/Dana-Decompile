package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetSortingSendMoney_Factory implements Factory<GetSortingSendMoney> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetSortingSendMoney_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSortingSendMoney get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetSortingSendMoney_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetSortingSendMoney_Factory(provider);
    }

    public static GetSortingSendMoney newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetSortingSendMoney(sendMoneyRepository);
    }
}
