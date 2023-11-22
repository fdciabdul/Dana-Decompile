package id.dana.data.promocenter.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoCategoryPreferences_Factory implements Factory<PromoCategoryPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public PromoCategoryPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PromoCategoryPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static PromoCategoryPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PromoCategoryPreferences_Factory(provider, provider2);
    }

    public static PromoCategoryPreferences newInstance(Context context, Serializer serializer) {
        return new PromoCategoryPreferences(context, serializer);
    }
}
