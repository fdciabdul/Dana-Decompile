package id.dana.data.account.repository.source;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AccountEntityDataFactory_Factory implements Factory<AccountEntityDataFactory> {
    private final Provider<PreferenceAccountEntityData> preferenceAccountEntityDataProvider;

    public AccountEntityDataFactory_Factory(Provider<PreferenceAccountEntityData> provider) {
        this.preferenceAccountEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AccountEntityDataFactory get() {
        return newInstance(this.preferenceAccountEntityDataProvider.get());
    }

    public static AccountEntityDataFactory_Factory create(Provider<PreferenceAccountEntityData> provider) {
        return new AccountEntityDataFactory_Factory(provider);
    }

    public static AccountEntityDataFactory newInstance(PreferenceAccountEntityData preferenceAccountEntityData) {
        return new AccountEntityDataFactory(preferenceAccountEntityData);
    }
}
