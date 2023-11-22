package id.dana.cardbinding.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CardBindingMixpanelTracker_Factory implements Factory<CardBindingMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CardBindingMixpanelTracker(this.PlaceComponentResult.get());
    }
}
