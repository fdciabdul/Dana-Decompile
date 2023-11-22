package id.dana.sync_engine.domain.tracker;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncEngineTrackerFactory_Factory implements Factory<SyncEngineTrackerFactory> {
    private final Provider<SyncContactMixpanelTracker> PlaceComponentResult;

    private SyncEngineTrackerFactory_Factory(Provider<SyncContactMixpanelTracker> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SyncEngineTrackerFactory_Factory getAuthRequestContext(Provider<SyncContactMixpanelTracker> provider) {
        return new SyncEngineTrackerFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncEngineTrackerFactory(this.PlaceComponentResult.get());
    }
}
