package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureOauth_Factory implements Factory<FeatureOauth> {
    private final Provider<DeeplinkTracker> BuiltInFictitiousFunctionClassFactory;

    private FeatureOauth_Factory(Provider<DeeplinkTracker> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static FeatureOauth_Factory BuiltInFictitiousFunctionClassFactory(Provider<DeeplinkTracker> provider) {
        return new FeatureOauth_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureOauth(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
