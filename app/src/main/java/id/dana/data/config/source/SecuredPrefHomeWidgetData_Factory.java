package id.dana.data.config.source;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SecuredPrefHomeWidgetData_Factory implements Factory<SecuredPrefHomeWidgetData> {
    private final Provider<PreferenceAccountEntityData> preferenceAccountEntityDataProvider;
    private final Provider<PreferenceFacade> preferenceFacadeProvider;

    public SecuredPrefHomeWidgetData_Factory(Provider<PreferenceFacade> provider, Provider<PreferenceAccountEntityData> provider2) {
        this.preferenceFacadeProvider = provider;
        this.preferenceAccountEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SecuredPrefHomeWidgetData get() {
        return newInstance(this.preferenceFacadeProvider.get(), this.preferenceAccountEntityDataProvider.get());
    }

    public static SecuredPrefHomeWidgetData_Factory create(Provider<PreferenceFacade> provider, Provider<PreferenceAccountEntityData> provider2) {
        return new SecuredPrefHomeWidgetData_Factory(provider, provider2);
    }

    public static SecuredPrefHomeWidgetData newInstance(PreferenceFacade preferenceFacade, PreferenceAccountEntityData preferenceAccountEntityData) {
        return new SecuredPrefHomeWidgetData(preferenceFacade, preferenceAccountEntityData);
    }
}
