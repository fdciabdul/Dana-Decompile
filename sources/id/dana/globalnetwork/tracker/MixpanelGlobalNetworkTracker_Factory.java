package id.dana.globalnetwork.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MixpanelGlobalNetworkTracker_Factory implements Factory<MixpanelGlobalNetworkTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private MixpanelGlobalNetworkTracker_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static MixpanelGlobalNetworkTracker_Factory PlaceComponentResult(Provider<Context> provider) {
        return new MixpanelGlobalNetworkTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelGlobalNetworkTracker(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
