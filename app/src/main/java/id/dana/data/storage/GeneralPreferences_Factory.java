package id.dana.data.storage;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeneralPreferences_Factory implements Factory<GeneralPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public GeneralPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GeneralPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static GeneralPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new GeneralPreferences_Factory(provider, provider2);
    }

    public static GeneralPreferences newInstance(Context context, Serializer serializer) {
        return new GeneralPreferences(context, serializer);
    }
}
