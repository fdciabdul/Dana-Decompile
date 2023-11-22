package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAllBalanceVisibility_Factory implements Factory<GetAllBalanceVisibility> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public GetAllBalanceVisibility_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAllBalanceVisibility get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static GetAllBalanceVisibility_Factory create(Provider<AccountRepository> provider) {
        return new GetAllBalanceVisibility_Factory(provider);
    }

    public static GetAllBalanceVisibility newInstance(AccountRepository accountRepository) {
        return new GetAllBalanceVisibility(accountRepository);
    }
}
