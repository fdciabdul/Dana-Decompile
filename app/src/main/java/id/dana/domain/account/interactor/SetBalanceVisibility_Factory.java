package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetBalanceVisibility_Factory implements Factory<SetBalanceVisibility> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public SetBalanceVisibility_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetBalanceVisibility get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static SetBalanceVisibility_Factory create(Provider<AccountRepository> provider) {
        return new SetBalanceVisibility_Factory(provider);
    }

    public static SetBalanceVisibility newInstance(AccountRepository accountRepository) {
        return new SetBalanceVisibility(accountRepository);
    }
}
