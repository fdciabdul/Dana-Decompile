package id.dana.contract.deeplink.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MixpanelDeeplinkTracker_Factory implements Factory<MixpanelDeeplinkTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private MixpanelDeeplinkTracker_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new MixpanelDeeplinkTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelDeeplinkTracker(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
