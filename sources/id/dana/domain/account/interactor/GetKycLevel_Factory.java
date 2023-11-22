package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycLevel_Factory implements Factory<GetKycLevel> {
    private final Provider<AccountRepository> accountRepositoryProvider;

    public GetKycLevel_Factory(Provider<AccountRepository> provider) {
        this.accountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKycLevel get() {
        return newInstance(this.accountRepositoryProvider.get());
    }

    public static GetKycLevel_Factory create(Provider<AccountRepository> provider) {
        return new GetKycLevel_Factory(provider);
    }

    public static GetKycLevel newInstance(AccountRepository accountRepository) {
        return new GetKycLevel(accountRepository);
    }
}
