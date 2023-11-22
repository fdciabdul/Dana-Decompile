package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSavingBalanceVisibility_Factory implements Factory<GetSavingBalanceVisibility> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public GetSavingBalanceVisibility_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSavingBalanceVisibility get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static GetSavingBalanceVisibility_Factory create(Provider<AccountRepository> provider) {
        return new GetSavingBalanceVisibility_Factory(provider);
    }

    public static GetSavingBalanceVisibility newInstance(AccountRepository accountRepository) {
        return new GetSavingBalanceVisibility(accountRepository);
    }
}
