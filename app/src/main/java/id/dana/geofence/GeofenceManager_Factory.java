package id.dana.geofence;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GeofenceManager_Factory implements Factory<GeofenceManager> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GeofenceManager(this.getAuthRequestContext.get());
    }
}
