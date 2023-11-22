package id.dana.cashier.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PaylaterMixpanelTracker_Factory implements Factory<PaylaterMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaylaterMixpanelTracker(this.PlaceComponentResult.get());
    }
}
