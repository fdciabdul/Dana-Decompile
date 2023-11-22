package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeaturePushVerify_Factory implements Factory<FeaturePushVerify> {
    private final Provider<DeeplinkTracker> PlaceComponentResult;

    private FeaturePushVerify_Factory(Provider<DeeplinkTracker> provider) {
        this.PlaceComponentResult = provider;
    }

    public static FeaturePushVerify_Factory getAuthRequestContext(Provider<DeeplinkTracker> provider) {
        return new FeaturePushVerify_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeaturePushVerify(this.PlaceComponentResult.get());
    }
}
