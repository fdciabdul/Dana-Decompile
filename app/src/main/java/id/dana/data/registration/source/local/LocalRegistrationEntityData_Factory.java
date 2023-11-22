package id.dana.data.registration.source.local;

import dagger.internal.Factory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalRegistrationEntityData_Factory implements Factory<LocalRegistrationEntityData> {
    private final Provider<PreferenceFacade> preferenceFacadeProvider;

    public LocalRegistrationEntityData_Factory(Provider<PreferenceFacade> provider) {
        this.preferenceFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalRegistrationEntityData get() {
        return newInstance(this.preferenceFacadeProvider.get());
    }

    public static LocalRegistrationEntityData_Factory create(Provider<PreferenceFacade> provider) {
        return new LocalRegistrationEntityData_Factory(provider);
    }

    public static LocalRegistrationEntityData newInstance(PreferenceFacade preferenceFacade) {
        return new LocalRegistrationEntityData(preferenceFacade);
    }
}
