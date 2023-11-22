package id.dana.data.errorconfig.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalErrorConfigEntityData_Factory implements Factory<LocalErrorConfigEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public LocalErrorConfigEntityData_Factory(Provider<Serializer> provider, Provider<Context> provider2) {
        this.serializerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LocalErrorConfigEntityData get() {
        return newInstance(this.serializerProvider.get(), this.contextProvider.get());
    }

    public static LocalErrorConfigEntityData_Factory create(Provider<Serializer> provider, Provider<Context> provider2) {
        return new LocalErrorConfigEntityData_Factory(provider, provider2);
    }

    public static LocalErrorConfigEntityData newInstance(Serializer serializer, Context context) {
        return new LocalErrorConfigEntityData(serializer, context);
    }
}
