package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBalanceVisibility_Factory implements Factory<GetBalanceVisibility> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public GetBalanceVisibility_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBalanceVisibility get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static GetBalanceVisibility_Factory create(Provider<AccountRepository> provider) {
        return new GetBalanceVisibility_Factory(provider);
    }

    public static GetBalanceVisibility newInstance(AccountRepository accountRepository) {
        return new GetBalanceVisibility(accountRepository);
    }
}
