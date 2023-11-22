package id.dana.contract.deeplink.tracker;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeeplinkTrackerFactory_Factory implements Factory<DeeplinkTrackerFactory> {
    private final Provider<DeeplinkTracker> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeeplinkTracker> PlaceComponentResult;

    private DeeplinkTrackerFactory_Factory(Provider<DeeplinkTracker> provider, Provider<DeeplinkTracker> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static DeeplinkTrackerFactory_Factory getAuthRequestContext(Provider<DeeplinkTracker> provider, Provider<DeeplinkTracker> provider2) {
        return new DeeplinkTrackerFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeeplinkTrackerFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
