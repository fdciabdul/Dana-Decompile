package id.dana.data.usersecurityquestions.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.usersecurityquestions.mapper.UserSecurityQuestionResultMapper;
import id.dana.data.usersecurityquestions.repository.source.UserSecurityQuestionStateEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserSecurityQuestionStateEntityRepository_Factory implements Factory<UserSecurityQuestionStateEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UserSecurityQuestionResultMapper> userSecurityQuestionResultMapperProvider;
    private final Provider<UserSecurityQuestionStateEntityDataFactory> userSecurityQuestionStateEntityDataFactoryProvider;

    public UserSecurityQuestionStateEntityRepository_Factory(Provider<UserSecurityQuestionStateEntityDataFactory> provider, Provider<UserSecurityQuestionResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.userSecurityQuestionStateEntityDataFactoryProvider = provider;
        this.userSecurityQuestionResultMapperProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final UserSecurityQuestionStateEntityRepository get() {
        return newInstance(this.userSecurityQuestionStateEntityDataFactoryProvider.get(), this.userSecurityQuestionResultMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static UserSecurityQuestionStateEntityRepository_Factory create(Provider<UserSecurityQuestionStateEntityDataFactory> provider, Provider<UserSecurityQuestionResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new UserSecurityQuestionStateEntityRepository_Factory(provider, provider2, provider3);
    }

    public static UserSecurityQuestionStateEntityRepository newInstance(UserSecurityQuestionStateEntityDataFactory userSecurityQuestionStateEntityDataFactory, UserSecurityQuestionResultMapper userSecurityQuestionResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new UserSecurityQuestionStateEntityRepository(userSecurityQuestionStateEntityDataFactory, userSecurityQuestionResultMapper, holdLoginV1EntityRepository);
    }
}
