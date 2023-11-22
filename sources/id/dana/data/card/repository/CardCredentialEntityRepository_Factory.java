package id.dana.data.card.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CardCredentialEntityRepository_Factory implements Factory<CardCredentialEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;

    public CardCredentialEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        this.accountEntityDataFactoryProvider = provider;
        this.securityEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CardCredentialEntityRepository get() {
        return newInstance(this.accountEntityDataFactoryProvider.get(), this.securityEntityDataFactoryProvider.get());
    }

    public static CardCredentialEntityRepository_Factory create(Provider<AccountEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2) {
        return new CardCredentialEntityRepository_Factory(provider, provider2);
    }

    public static CardCredentialEntityRepository newInstance(AccountEntityDataFactory accountEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory) {
        return new CardCredentialEntityRepository(accountEntityDataFactory, securityEntityDataFactory);
    }
}
