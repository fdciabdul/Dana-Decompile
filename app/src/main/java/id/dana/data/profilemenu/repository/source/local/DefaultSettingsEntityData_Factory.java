package id.dana.data.profilemenu.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultSettingsEntityData_Factory implements Factory<DefaultSettingsEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultSettingsEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultSettingsEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultSettingsEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultSettingsEntityData_Factory(provider, provider2);
    }

    public static DefaultSettingsEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultSettingsEntityData(context, serializer);
    }
}
