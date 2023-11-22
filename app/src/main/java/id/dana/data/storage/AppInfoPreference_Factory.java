package id.dana.data.storage;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AppInfoPreference_Factory implements Factory<AppInfoPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public AppInfoPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AppInfoPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static AppInfoPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new AppInfoPreference_Factory(provider, provider2);
    }

    public static AppInfoPreference newInstance(Context context, Serializer serializer) {
        return new AppInfoPreference(context, serializer);
    }
}
