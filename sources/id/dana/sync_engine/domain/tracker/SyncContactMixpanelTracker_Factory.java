package id.dana.sync_engine.domain.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContactMixpanelTracker_Factory implements Factory<SyncContactMixpanelTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private SyncContactMixpanelTracker_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SyncContactMixpanelTracker_Factory PlaceComponentResult(Provider<Context> provider) {
        return new SyncContactMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncContactMixpanelTracker(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
