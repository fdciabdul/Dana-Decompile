package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InitRequestMoney_Factory implements Factory<InitRequestMoney> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public InitRequestMoney_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitRequestMoney get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static InitRequestMoney_Factory create(Provider<UserBankRepository> provider) {
        return new InitRequestMoney_Factory(provider);
    }

    public static InitRequestMoney newInstance(UserBankRepository userBankRepository) {
        return new InitRequestMoney(userBankRepository);
    }
}
