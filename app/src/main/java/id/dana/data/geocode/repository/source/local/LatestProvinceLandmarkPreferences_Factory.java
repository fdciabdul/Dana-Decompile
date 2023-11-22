package id.dana.data.geocode.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LatestProvinceLandmarkPreferences_Factory implements Factory<LatestProvinceLandmarkPreferences> {
    private final Provider<Context> contextProvider;

    public LatestProvinceLandmarkPreferences_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LatestProvinceLandmarkPreferences get() {
        return newInstance(this.contextProvider.get());
    }

    public static LatestProvinceLandmarkPreferences_Factory create(Provider<Context> provider) {
        return new LatestProvinceLandmarkPreferences_Factory(provider);
    }

    public static LatestProvinceLandmarkPreferences newInstance(Context context) {
        return new LatestProvinceLandmarkPreferences(context);
    }
}
