package id.dana.data.account.repository;

import dagger.internal.Factory;
import id.dana.data.account.avatar.repository.source.AvatarEntityDataFactory;
import id.dana.data.account.general.repository.GeneralEntityDataFactory;
import id.dana.data.account.mapper.AccountMapper;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AccountEntityRepository_Factory implements Factory<AccountEntityRepository> {
    private final Provider<AccountMapper> accountMapperProvider;
    private final Provider<AvatarEntityDataFactory> avatarEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<GeneralEntityDataFactory> generalEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UserProfileInfoEntityDataFactory> userProfileInfoEntityDataFactoryProvider;

    public AccountEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<AvatarEntityDataFactory> provider2, Provider<UserProfileInfoEntityDataFactory> provider3, Provider<AccountMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5, Provider<GeneralEntityDataFactory> provider6) {
        this.configEntityDataFactoryProvider = provider;
        this.avatarEntityDataFactoryProvider = provider2;
        this.userProfileInfoEntityDataFactoryProvider = provider3;
        this.accountMapperProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
        this.generalEntityDataFactoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final AccountEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.avatarEntityDataFactoryProvider.get(), this.userProfileInfoEntityDataFactoryProvider.get(), this.accountMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get(), this.generalEntityDataFactoryProvider.get());
    }

    public static AccountEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<AvatarEntityDataFactory> provider2, Provider<UserProfileInfoEntityDataFactory> provider3, Provider<AccountMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5, Provider<GeneralEntityDataFactory> provider6) {
        return new AccountEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AccountEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, AvatarEntityDataFactory avatarEntityDataFactory, UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory, AccountMapper accountMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository, GeneralEntityDataFactory generalEntityDataFactory) {
        return new AccountEntityRepository(configEntityDataFactory, avatarEntityDataFactory, userProfileInfoEntityDataFactory, accountMapper, holdLoginV1EntityRepository, generalEntityDataFactory);
    }
}
