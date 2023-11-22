package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalNearbyMeEntityData_Factory implements Factory<LocalNearbyMeEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<NearbyMePreferences> nearbyMePreferencesProvider;
    private final Provider<Serializer> serializerProvider;

    public LocalNearbyMeEntityData_Factory(Provider<Context> provider, Provider<NearbyMePreferences> provider2, Provider<Serializer> provider3) {
        this.contextProvider = provider;
        this.nearbyMePreferencesProvider = provider2;
        this.serializerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final LocalNearbyMeEntityData get() {
        return newInstance(this.contextProvider.get(), this.nearbyMePreferencesProvider.get(), this.serializerProvider.get());
    }

    public static LocalNearbyMeEntityData_Factory create(Provider<Context> provider, Provider<NearbyMePreferences> provider2, Provider<Serializer> provider3) {
        return new LocalNearbyMeEntityData_Factory(provider, provider2, provider3);
    }

    public static LocalNearbyMeEntityData newInstance(Context context, NearbyMePreferences nearbyMePreferences, Serializer serializer) {
        return new LocalNearbyMeEntityData(context, nearbyMePreferences, serializer);
    }
}
