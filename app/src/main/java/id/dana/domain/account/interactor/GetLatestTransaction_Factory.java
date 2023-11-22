package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetLatestTransaction_Factory implements Factory<GetLatestTransaction> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public GetLatestTransaction_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLatestTransaction get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static GetLatestTransaction_Factory create(Provider<AccountRepository> provider) {
        return new GetLatestTransaction_Factory(provider);
    }

    public static GetLatestTransaction newInstance(AccountRepository accountRepository) {
        return new GetLatestTransaction(accountRepository);
    }
}
