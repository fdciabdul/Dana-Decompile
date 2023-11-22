package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckUserBankExist_Factory implements Factory<CheckUserBankExist> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public CheckUserBankExist_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckUserBankExist get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static CheckUserBankExist_Factory create(Provider<UserBankRepository> provider) {
        return new CheckUserBankExist_Factory(provider);
    }

    public static CheckUserBankExist newInstance(UserBankRepository userBankRepository) {
        return new CheckUserBankExist(userBankRepository);
    }
}
