package id.dana.data.useremailaddress.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.useremailaddress.mapper.UserEmailAddressEntityResultMapper;
import id.dana.data.useremailaddress.repository.source.UserEmailAddressEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEmailAddressEntityRepository_Factory implements Factory<UserEmailAddressEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UserEmailAddressEntityResultMapper> mapperProvider;
    private final Provider<UserEmailAddressEntityDataFactory> userEmailAddressEntityDataFactoryProvider;

    public UserEmailAddressEntityRepository_Factory(Provider<UserEmailAddressEntityDataFactory> provider, Provider<UserEmailAddressEntityResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.userEmailAddressEntityDataFactoryProvider = provider;
        this.mapperProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final UserEmailAddressEntityRepository get() {
        return newInstance(this.userEmailAddressEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static UserEmailAddressEntityRepository_Factory create(Provider<UserEmailAddressEntityDataFactory> provider, Provider<UserEmailAddressEntityResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new UserEmailAddressEntityRepository_Factory(provider, provider2, provider3);
    }

    public static UserEmailAddressEntityRepository newInstance(UserEmailAddressEntityDataFactory userEmailAddressEntityDataFactory, UserEmailAddressEntityResultMapper userEmailAddressEntityResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new UserEmailAddressEntityRepository(userEmailAddressEntityDataFactory, userEmailAddressEntityResultMapper, holdLoginV1EntityRepository);
    }
}
