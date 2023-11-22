package id.dana.data.here.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HereAuthenticationPreference_Factory implements Factory<HereAuthenticationPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public HereAuthenticationPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final HereAuthenticationPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static HereAuthenticationPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new HereAuthenticationPreference_Factory(provider, provider2);
    }

    public static HereAuthenticationPreference newInstance(Context context, Serializer serializer) {
        return new HereAuthenticationPreference(context, serializer);
    }
}
