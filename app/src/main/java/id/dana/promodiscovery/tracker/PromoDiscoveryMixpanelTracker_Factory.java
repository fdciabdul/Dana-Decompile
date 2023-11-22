package id.dana.promodiscovery.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PromoDiscoveryMixpanelTracker_Factory implements Factory<PromoDiscoveryMixpanelTracker> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoDiscoveryMixpanelTracker(this.getAuthRequestContext.get());
    }
}
