package id.dana.data.saving.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultSavingConfigEntityData_Factory implements Factory<DefaultSavingConfigEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultSavingConfigEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultSavingConfigEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultSavingConfigEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultSavingConfigEntityData_Factory(provider, provider2);
    }

    public static DefaultSavingConfigEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultSavingConfigEntityData(context, serializer);
    }
}
