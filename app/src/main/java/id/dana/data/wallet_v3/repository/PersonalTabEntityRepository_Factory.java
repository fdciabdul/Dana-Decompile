package id.dana.data.wallet_v3.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.data.wallet_v3.repository.source.WalletV3EntityDataFactory;
import id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersonalTabEntityRepository_Factory implements Factory<PersonalTabEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<PersonalTabEntityDataFactory> personalTabEntityDataFactoryProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<UserConfigRepository> userConfigRepositoryProvider;
    private final Provider<WalletV3EntityDataFactory> walletV3EntityDataFactoryProvider;

    public PersonalTabEntityRepository_Factory(Provider<PersonalTabEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<UserConfigRepository> provider3, Provider<SecurityEntityDataFactory> provider4, Provider<WalletV3EntityDataFactory> provider5) {
        this.personalTabEntityDataFactoryProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
        this.userConfigRepositoryProvider = provider3;
        this.securityEntityDataFactoryProvider = provider4;
        this.walletV3EntityDataFactoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final PersonalTabEntityRepository get() {
        return newInstance(this.personalTabEntityDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.userConfigRepositoryProvider.get(), this.securityEntityDataFactoryProvider.get(), this.walletV3EntityDataFactoryProvider.get());
    }

    public static PersonalTabEntityRepository_Factory create(Provider<PersonalTabEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<UserConfigRepository> provider3, Provider<SecurityEntityDataFactory> provider4, Provider<WalletV3EntityDataFactory> provider5) {
        return new PersonalTabEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PersonalTabEntityRepository newInstance(PersonalTabEntityDataFactory personalTabEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, UserConfigRepository userConfigRepository, SecurityEntityDataFactory securityEntityDataFactory, WalletV3EntityDataFactory walletV3EntityDataFactory) {
        return new PersonalTabEntityRepository(personalTabEntityDataFactory, accountEntityDataFactory, userConfigRepository, securityEntityDataFactory, walletV3EntityDataFactory);
    }
}
