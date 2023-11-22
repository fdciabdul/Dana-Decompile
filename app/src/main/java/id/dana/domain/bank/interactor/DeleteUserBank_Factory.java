package id.dana.domain.bank.interactor;

import dagger.internal.Factory;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DeleteUserBank_Factory implements Factory<DeleteUserBank> {
    private final Provider<UserBankRepository> userBankRepositoryProvider;

    public DeleteUserBank_Factory(Provider<UserBankRepository> provider) {
        this.userBankRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DeleteUserBank get() {
        return newInstance(this.userBankRepositoryProvider.get());
    }

    public static DeleteUserBank_Factory create(Provider<UserBankRepository> provider) {
        return new DeleteUserBank_Factory(provider);
    }

    public static DeleteUserBank newInstance(UserBankRepository userBankRepository) {
        return new DeleteUserBank(userBankRepository);
    }
}
