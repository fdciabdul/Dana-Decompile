package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTopUpUserConsult_Factory implements Factory<GetTopUpUserConsult> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public GetTopUpUserConsult_Factory(Provider<FamilyAccountRepository> provider, Provider<UserRepository> provider2) {
        this.familyAccountRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetTopUpUserConsult get() {
        return newInstance(this.familyAccountRepositoryProvider.get(), this.userRepositoryProvider.get());
    }

    public static GetTopUpUserConsult_Factory create(Provider<FamilyAccountRepository> provider, Provider<UserRepository> provider2) {
        return new GetTopUpUserConsult_Factory(provider, provider2);
    }

    public static GetTopUpUserConsult newInstance(FamilyAccountRepository familyAccountRepository, UserRepository userRepository) {
        return new GetTopUpUserConsult(familyAccountRepository, userRepository);
    }
}
