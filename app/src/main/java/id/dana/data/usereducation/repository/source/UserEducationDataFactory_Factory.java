package id.dana.data.usereducation.repository.source;

import dagger.internal.Factory;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEducationDataFactory_Factory implements Factory<UserEducationDataFactory> {
    private final Provider<UserEducationPreference> userEducationPreferenceProvider;

    public UserEducationDataFactory_Factory(Provider<UserEducationPreference> provider) {
        this.userEducationPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserEducationDataFactory get() {
        return newInstance(this.userEducationPreferenceProvider.get());
    }

    public static UserEducationDataFactory_Factory create(Provider<UserEducationPreference> provider) {
        return new UserEducationDataFactory_Factory(provider);
    }

    public static UserEducationDataFactory newInstance(UserEducationPreference userEducationPreference) {
        return new UserEducationDataFactory(userEducationPreference);
    }
}
