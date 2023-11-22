package id.dana.data.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GeocodeTracker_Factory implements Factory<GeocodeTracker> {
    private final Provider<Context> contextProvider;

    public GeocodeTracker_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GeocodeTracker get() {
        return newInstance(this.contextProvider.get());
    }

    public static GeocodeTracker_Factory create(Provider<Context> provider) {
        return new GeocodeTracker_Factory(provider);
    }

    public static GeocodeTracker newInstance(Context context) {
        return new GeocodeTracker(context);
    }
}
