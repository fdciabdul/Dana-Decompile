package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastTransaction_Factory implements Factory<SaveLastTransaction> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public SaveLastTransaction_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastTransaction get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static SaveLastTransaction_Factory create(Provider<AccountRepository> provider) {
        return new SaveLastTransaction_Factory(provider);
    }

    public static SaveLastTransaction newInstance(AccountRepository accountRepository) {
        return new SaveLastTransaction(accountRepository);
    }
}
