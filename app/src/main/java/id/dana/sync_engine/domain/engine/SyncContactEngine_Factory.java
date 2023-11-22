package id.dana.sync_engine.domain.engine;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.tracker.SyncEngineTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContactEngine_Factory implements Factory<SyncContactEngine> {
    private final Provider<ContactRepository> PlaceComponentResult;
    private final Provider<SyncEngineTrackerFactory> getAuthRequestContext;

    private SyncContactEngine_Factory(Provider<ContactRepository> provider, Provider<SyncEngineTrackerFactory> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static SyncContactEngine_Factory MyBillsEntityDataFactory(Provider<ContactRepository> provider, Provider<SyncEngineTrackerFactory> provider2) {
        return new SyncContactEngine_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncContactEngine(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
