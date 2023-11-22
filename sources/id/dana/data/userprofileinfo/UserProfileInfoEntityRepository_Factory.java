package id.dana.data.userprofileinfo;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userprofileinfo.mapper.UserProfileInfoMapper;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserProfileInfoEntityRepository_Factory implements Factory<UserProfileInfoEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UserProfileInfoMapper> mapperProvider;
    private final Provider<UserProfileInfoEntityDataFactory> userProfileInfoEntityDataFactoryProvider;

    public UserProfileInfoEntityRepository_Factory(Provider<UserProfileInfoEntityDataFactory> provider, Provider<UserProfileInfoMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.userProfileInfoEntityDataFactoryProvider = provider;
        this.mapperProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final UserProfileInfoEntityRepository get() {
        return newInstance(this.userProfileInfoEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static UserProfileInfoEntityRepository_Factory create(Provider<UserProfileInfoEntityDataFactory> provider, Provider<UserProfileInfoMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new UserProfileInfoEntityRepository_Factory(provider, provider2, provider3);
    }

    public static UserProfileInfoEntityRepository newInstance(UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory, UserProfileInfoMapper userProfileInfoMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new UserProfileInfoEntityRepository(userProfileInfoEntityDataFactory, userProfileInfoMapper, holdLoginV1EntityRepository);
    }
}
