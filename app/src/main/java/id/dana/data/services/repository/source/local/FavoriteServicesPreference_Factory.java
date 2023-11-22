package id.dana.data.services.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FavoriteServicesPreference_Factory implements Factory<FavoriteServicesPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;

    public FavoriteServicesPreference_Factory(Provider<Context> provider, Provider<Gson> provider2) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final FavoriteServicesPreference get() {
        return newInstance(this.contextProvider.get(), this.gsonProvider.get());
    }

    public static FavoriteServicesPreference_Factory create(Provider<Context> provider, Provider<Gson> provider2) {
        return new FavoriteServicesPreference_Factory(provider, provider2);
    }

    public static FavoriteServicesPreference newInstance(Context context, Gson gson) {
        return new FavoriteServicesPreference(context, gson);
    }
}
