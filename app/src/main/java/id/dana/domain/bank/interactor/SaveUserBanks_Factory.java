package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveUserBanks_Factory implements Factory<SaveUserBanks> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public SaveUserBanks_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveUserBanks get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static SaveUserBanks_Factory create(Provider<UserBankRepository> provider) {
        return new SaveUserBanks_Factory(provider);
    }

    public static SaveUserBanks newInstance(UserBankRepository userBankRepository) {
        return new SaveUserBanks(userBankRepository);
    }
}
