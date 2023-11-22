package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyMePreferences_Factory implements Factory<NearbyMePreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public NearbyMePreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NearbyMePreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static NearbyMePreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new NearbyMePreferences_Factory(provider, provider2);
    }

    public static NearbyMePreferences newInstance(Context context, Serializer serializer) {
        return new NearbyMePreferences(context, serializer);
    }
}
