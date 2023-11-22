package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveSortingSendMoney_Factory implements Factory<SaveSortingSendMoney> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public SaveSortingSendMoney_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveSortingSendMoney get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static SaveSortingSendMoney_Factory create(Provider<SendMoneyRepository> provider) {
        return new SaveSortingSendMoney_Factory(provider);
    }

    public static SaveSortingSendMoney newInstance(SendMoneyRepository sendMoneyRepository) {
        return new SaveSortingSendMoney(sendMoneyRepository);
    }
}
