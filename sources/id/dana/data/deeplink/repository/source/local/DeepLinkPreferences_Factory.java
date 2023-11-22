package id.dana.data.deeplink.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeepLinkPreferences_Factory implements Factory<DeepLinkPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DeepLinkPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DeepLinkPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DeepLinkPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DeepLinkPreferences_Factory(provider, provider2);
    }

    public static DeepLinkPreferences newInstance(Context context, Serializer serializer) {
        return new DeepLinkPreferences(context, serializer);
    }
}
