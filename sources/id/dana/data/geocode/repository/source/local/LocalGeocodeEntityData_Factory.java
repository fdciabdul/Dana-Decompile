package id.dana.data.geocode.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalGeocodeEntityData_Factory implements Factory<LocalGeocodeEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<LatestProvinceLandmarkPreferences> latestProvinceLandmarkPreferencesProvider;

    public LocalGeocodeEntityData_Factory(Provider<GeneralPreferences> provider, Provider<LatestProvinceLandmarkPreferences> provider2, Provider<Context> provider3) {
        this.generalPreferencesProvider = provider;
        this.latestProvinceLandmarkPreferencesProvider = provider2;
        this.contextProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final LocalGeocodeEntityData get() {
        return newInstance(this.generalPreferencesProvider.get(), this.latestProvinceLandmarkPreferencesProvider.get(), this.contextProvider.get());
    }

    public static LocalGeocodeEntityData_Factory create(Provider<GeneralPreferences> provider, Provider<LatestProvinceLandmarkPreferences> provider2, Provider<Context> provider3) {
        return new LocalGeocodeEntityData_Factory(provider, provider2, provider3);
    }

    public static LocalGeocodeEntityData newInstance(GeneralPreferences generalPreferences, LatestProvinceLandmarkPreferences latestProvinceLandmarkPreferences, Context context) {
        return new LocalGeocodeEntityData(generalPreferences, latestProvinceLandmarkPreferences, context);
    }
}
