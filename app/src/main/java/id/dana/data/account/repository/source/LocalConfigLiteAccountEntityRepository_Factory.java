package id.dana.data.account.repository.source;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.mapper.AccountMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalConfigLiteAccountEntityRepository_Factory implements Factory<LocalConfigLiteAccountEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<AccountMapper> accountMapperProvider;

    public LocalConfigLiteAccountEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<AccountMapper> provider2) {
        this.accountEntityDataFactoryProvider = provider;
        this.accountMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LocalConfigLiteAccountEntityRepository get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.accountEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.accountMapperProvider));
    }

    public static LocalConfigLiteAccountEntityRepository_Factory create(Provider<AccountEntityDataFactory> provider, Provider<AccountMapper> provider2) {
        return new LocalConfigLiteAccountEntityRepository_Factory(provider, provider2);
    }

    public static LocalConfigLiteAccountEntityRepository newInstance(Lazy<AccountEntityDataFactory> lazy, Lazy<AccountMapper> lazy2) {
        return new LocalConfigLiteAccountEntityRepository(lazy, lazy2);
    }
}
