package id.dana.data.usereducation.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.usereducation.repository.source.UserEducationDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEducationEntityRepository_Factory implements Factory<UserEducationEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<UserEducationDataFactory> userEducationDataFactoryProvider;

    public UserEducationEntityRepository_Factory(Provider<UserEducationDataFactory> provider, Provider<AccountEntityDataFactory> provider2) {
        this.userEducationDataFactoryProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UserEducationEntityRepository get() {
        return newInstance(this.userEducationDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get());
    }

    public static UserEducationEntityRepository_Factory create(Provider<UserEducationDataFactory> provider, Provider<AccountEntityDataFactory> provider2) {
        return new UserEducationEntityRepository_Factory(provider, provider2);
    }

    public static UserEducationEntityRepository newInstance(UserEducationDataFactory userEducationDataFactory, AccountEntityDataFactory accountEntityDataFactory) {
        return new UserEducationEntityRepository(userEducationDataFactory, accountEntityDataFactory);
    }
}
