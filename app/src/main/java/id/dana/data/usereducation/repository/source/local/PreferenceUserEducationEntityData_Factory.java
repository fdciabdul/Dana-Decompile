package id.dana.data.usereducation.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceUserEducationEntityData_Factory implements Factory<PreferenceUserEducationEntityData> {
    private final Provider<UserEducationPreference> userEducationPreferenceProvider;

    public PreferenceUserEducationEntityData_Factory(Provider<UserEducationPreference> provider) {
        this.userEducationPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceUserEducationEntityData get() {
        return newInstance(this.userEducationPreferenceProvider.get());
    }

    public static PreferenceUserEducationEntityData_Factory create(Provider<UserEducationPreference> provider) {
        return new PreferenceUserEducationEntityData_Factory(provider);
    }

    public static PreferenceUserEducationEntityData newInstance(UserEducationPreference userEducationPreference) {
        return new PreferenceUserEducationEntityData(userEducationPreference);
    }
}
