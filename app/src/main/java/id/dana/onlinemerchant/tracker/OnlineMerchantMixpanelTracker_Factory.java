package id.dana.onlinemerchant.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OnlineMerchantMixpanelTracker_Factory implements Factory<OnlineMerchantMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OnlineMerchantMixpanelTracker(this.PlaceComponentResult.get());
    }
}
