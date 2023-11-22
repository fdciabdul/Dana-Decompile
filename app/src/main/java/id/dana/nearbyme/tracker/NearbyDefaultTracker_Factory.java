package id.dana.nearbyme.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NearbyDefaultTracker_Factory implements Factory<NearbyDefaultTracker> {
    private final Provider<Context> getAuthRequestContext;

    private NearbyDefaultTracker_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new NearbyDefaultTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbyDefaultTracker(this.getAuthRequestContext.get());
    }
}
