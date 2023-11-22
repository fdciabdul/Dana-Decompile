package id.dana.data.nearbyme.repository.source.session;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalMerchantInfoEntityData_Factory implements Factory<LocalMerchantInfoEntityData> {
    private final Provider<MerchantInfoPreferences> merchantInfoPreferencesProvider;

    public LocalMerchantInfoEntityData_Factory(Provider<MerchantInfoPreferences> provider) {
        this.merchantInfoPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalMerchantInfoEntityData get() {
        return newInstance(this.merchantInfoPreferencesProvider.get());
    }

    public static LocalMerchantInfoEntityData_Factory create(Provider<MerchantInfoPreferences> provider) {
        return new LocalMerchantInfoEntityData_Factory(provider);
    }

    public static LocalMerchantInfoEntityData newInstance(MerchantInfoPreferences merchantInfoPreferences) {
        return new LocalMerchantInfoEntityData(merchantInfoPreferences);
    }
}
