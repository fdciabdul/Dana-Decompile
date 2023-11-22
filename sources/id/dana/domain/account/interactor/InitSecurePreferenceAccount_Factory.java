package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.LiteAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSecurePreferenceAccount_Factory implements Factory<InitSecurePreferenceAccount> {
    private final Provider<LiteAccountRepository> liteAccountRepositoryProvider;

    public InitSecurePreferenceAccount_Factory(Provider<LiteAccountRepository> provider) {
        this.liteAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitSecurePreferenceAccount get() {
        return newInstance(this.liteAccountRepositoryProvider.get());
    }

    public static InitSecurePreferenceAccount_Factory create(Provider<LiteAccountRepository> provider) {
        return new InitSecurePreferenceAccount_Factory(provider);
    }

    public static InitSecurePreferenceAccount newInstance(LiteAccountRepository liteAccountRepository) {
        return new InitSecurePreferenceAccount(liteAccountRepository);
    }
}
