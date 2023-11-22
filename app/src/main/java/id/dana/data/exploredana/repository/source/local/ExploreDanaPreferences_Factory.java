package id.dana.data.exploredana.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExploreDanaPreferences_Factory implements Factory<ExploreDanaPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public ExploreDanaPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ExploreDanaPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ExploreDanaPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ExploreDanaPreferences_Factory(provider, provider2);
    }

    public static ExploreDanaPreferences newInstance(Context context, Serializer serializer) {
        return new ExploreDanaPreferences(context, serializer);
    }
}
