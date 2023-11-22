package id.dana.data.auth.face.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FaceAuthSuggestionPreference_Factory implements Factory<FaceAuthSuggestionPreference> {
    private final Provider<Context> contextProvider;

    public FaceAuthSuggestionPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FaceAuthSuggestionPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static FaceAuthSuggestionPreference_Factory create(Provider<Context> provider) {
        return new FaceAuthSuggestionPreference_Factory(provider);
    }

    public static FaceAuthSuggestionPreference newInstance(Context context) {
        return new FaceAuthSuggestionPreference(context);
    }
}
