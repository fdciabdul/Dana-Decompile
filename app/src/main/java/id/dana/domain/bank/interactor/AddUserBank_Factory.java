package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AddUserBank_Factory implements Factory<AddUserBank> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public AddUserBank_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AddUserBank get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static AddUserBank_Factory create(Provider<UserBankRepository> provider) {
        return new AddUserBank_Factory(provider);
    }

    public static AddUserBank newInstance(UserBankRepository userBankRepository) {
        return new AddUserBank(userBankRepository);
    }
}
