package id.dana.data.auth.face.repository.source;

import dagger.internal.Factory;
import id.dana.data.auth.face.repository.source.local.FaceAuthSuggestionPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FaceAuthSuggestionDataFactory_Factory implements Factory<FaceAuthSuggestionDataFactory> {
    private final Provider<FaceAuthSuggestionPreference> faceAuthSuggestionPreferenceProvider;

    public FaceAuthSuggestionDataFactory_Factory(Provider<FaceAuthSuggestionPreference> provider) {
        this.faceAuthSuggestionPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FaceAuthSuggestionDataFactory get() {
        return newInstance(this.faceAuthSuggestionPreferenceProvider.get());
    }

    public static FaceAuthSuggestionDataFactory_Factory create(Provider<FaceAuthSuggestionPreference> provider) {
        return new FaceAuthSuggestionDataFactory_Factory(provider);
    }

    public static FaceAuthSuggestionDataFactory newInstance(FaceAuthSuggestionPreference faceAuthSuggestionPreference) {
        return new FaceAuthSuggestionDataFactory(faceAuthSuggestionPreference);
    }
}
