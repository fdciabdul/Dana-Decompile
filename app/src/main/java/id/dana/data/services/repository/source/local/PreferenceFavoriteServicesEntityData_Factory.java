package id.dana.data.services.repository.source.local;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceFavoriteServicesEntityData_Factory implements Factory<PreferenceFavoriteServicesEntityData> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<FavoriteServicesPreference> favoriteServicesPreferenceProvider;

    public PreferenceFavoriteServicesEntityData_Factory(Provider<FavoriteServicesPreference> provider, Provider<AccountEntityDataFactory> provider2) {
        this.favoriteServicesPreferenceProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PreferenceFavoriteServicesEntityData get() {
        return newInstance(this.favoriteServicesPreferenceProvider.get(), this.accountEntityDataFactoryProvider.get());
    }

    public static PreferenceFavoriteServicesEntityData_Factory create(Provider<FavoriteServicesPreference> provider, Provider<AccountEntityDataFactory> provider2) {
        return new PreferenceFavoriteServicesEntityData_Factory(provider, provider2);
    }

    public static PreferenceFavoriteServicesEntityData newInstance(FavoriteServicesPreference favoriteServicesPreference, AccountEntityDataFactory accountEntityDataFactory) {
        return new PreferenceFavoriteServicesEntityData(favoriteServicesPreference, accountEntityDataFactory);
    }
}
