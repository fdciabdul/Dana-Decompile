package id.dana.data.profilemenu.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SettingPreference_Factory implements Factory<SettingPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public SettingPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SettingPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static SettingPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new SettingPreference_Factory(provider, provider2);
    }

    public static SettingPreference newInstance(Context context, Serializer serializer) {
        return new SettingPreference(context, serializer);
    }
}
