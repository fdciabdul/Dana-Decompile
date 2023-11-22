package id.dana.data.autoroute.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalAutoRouteEntity_Factory implements Factory<LocalAutoRouteEntity> {
    private final Provider<Context> contextProvider;

    public LocalAutoRouteEntity_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalAutoRouteEntity get() {
        return newInstance(this.contextProvider.get());
    }

    public static LocalAutoRouteEntity_Factory create(Provider<Context> provider) {
        return new LocalAutoRouteEntity_Factory(provider);
    }

    public static LocalAutoRouteEntity newInstance(Context context) {
        return new LocalAutoRouteEntity(context);
    }
}
