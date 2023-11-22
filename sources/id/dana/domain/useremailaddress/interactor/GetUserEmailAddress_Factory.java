package id.dana.domain.useremailaddress.interactor;

import dagger.internal.Factory;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserEmailAddress_Factory implements Factory<GetUserEmailAddress> {
    private final Provider<UserEmailAddressRepository> userEmailAddressRepositoryProvider;

    public GetUserEmailAddress_Factory(Provider<UserEmailAddressRepository> provider) {
        this.userEmailAddressRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserEmailAddress get() {
        return newInstance(this.userEmailAddressRepositoryProvider.get());
    }

    public static GetUserEmailAddress_Factory create(Provider<UserEmailAddressRepository> provider) {
        return new GetUserEmailAddress_Factory(provider);
    }

    public static GetUserEmailAddress newInstance(UserEmailAddressRepository userEmailAddressRepository) {
        return new GetUserEmailAddress(userEmailAddressRepository);
    }
}
