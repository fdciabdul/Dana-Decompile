package id.dana.nearbyme.merchantdetail.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantDetailMixpanelTrackers_Factory implements Factory<MerchantDetailMixpanelTrackers> {
    private final Provider<Context> PlaceComponentResult;

    private MerchantDetailMixpanelTrackers_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static MerchantDetailMixpanelTrackers_Factory getAuthRequestContext(Provider<Context> provider) {
        return new MerchantDetailMixpanelTrackers_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDetailMixpanelTrackers(this.PlaceComponentResult.get());
    }
}
