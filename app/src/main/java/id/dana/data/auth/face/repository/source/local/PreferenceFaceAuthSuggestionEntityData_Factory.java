package id.dana.data.auth.face.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferenceFaceAuthSuggestionEntityData_Factory implements Factory<PreferenceFaceAuthSuggestionEntityData> {
    private final Provider<FaceAuthSuggestionPreference> faceAuthSuggestionPreferenceProvider;

    public PreferenceFaceAuthSuggestionEntityData_Factory(Provider<FaceAuthSuggestionPreference> provider) {
        this.faceAuthSuggestionPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceFaceAuthSuggestionEntityData get() {
        return newInstance(this.faceAuthSuggestionPreferenceProvider.get());
    }

    public static PreferenceFaceAuthSuggestionEntityData_Factory create(Provider<FaceAuthSuggestionPreference> provider) {
        return new PreferenceFaceAuthSuggestionEntityData_Factory(provider);
    }

    public static PreferenceFaceAuthSuggestionEntityData newInstance(FaceAuthSuggestionPreference faceAuthSuggestionPreference) {
        return new PreferenceFaceAuthSuggestionEntityData(faceAuthSuggestionPreference);
    }
}
