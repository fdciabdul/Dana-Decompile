package id.dana.data.wallet_v3.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPersonalTabEntityData_Factory implements Factory<LocalPersonalTabEntityData> {
    private final Provider<PersonalTabPreference> personalTabPreferenceProvider;

    public LocalPersonalTabEntityData_Factory(Provider<PersonalTabPreference> provider) {
        this.personalTabPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalPersonalTabEntityData get() {
        return newInstance(this.personalTabPreferenceProvider.get());
    }

    public static LocalPersonalTabEntityData_Factory create(Provider<PersonalTabPreference> provider) {
        return new LocalPersonalTabEntityData_Factory(provider);
    }

    public static LocalPersonalTabEntityData newInstance(PersonalTabPreference personalTabPreference) {
        return new LocalPersonalTabEntityData(personalTabPreference);
    }
}
