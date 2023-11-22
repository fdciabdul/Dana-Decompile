package id.dana.paymentsetting.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PaymentSettingMixpanelTracker_Factory implements Factory<PaymentSettingMixpanelTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSettingMixpanelTracker(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
