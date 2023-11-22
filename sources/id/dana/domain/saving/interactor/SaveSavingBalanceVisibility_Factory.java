package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveSavingBalanceVisibility_Factory implements Factory<SaveSavingBalanceVisibility> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public SaveSavingBalanceVisibility_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveSavingBalanceVisibility get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static SaveSavingBalanceVisibility_Factory create(Provider<AccountRepository> provider) {
        return new SaveSavingBalanceVisibility_Factory(provider);
    }

    public static SaveSavingBalanceVisibility newInstance(AccountRepository accountRepository) {
        return new SaveSavingBalanceVisibility(accountRepository);
    }
}
