package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetUserBanks_Factory implements Factory<GetUserBanks> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public GetUserBanks_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserBanks get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static GetUserBanks_Factory create(Provider<UserBankRepository> provider) {
        return new GetUserBanks_Factory(provider);
    }

    public static GetUserBanks newInstance(UserBankRepository userBankRepository) {
        return new GetUserBanks(userBankRepository);
    }
}
