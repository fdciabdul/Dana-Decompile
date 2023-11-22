package id.dana.globalsearch.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GlobalSearchMixpanelTracker_Factory implements Factory<GlobalSearchMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchMixpanelTracker(this.PlaceComponentResult.get());
    }
}
