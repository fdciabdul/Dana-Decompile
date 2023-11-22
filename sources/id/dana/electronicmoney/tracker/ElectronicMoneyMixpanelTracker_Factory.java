package id.dana.electronicmoney.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ElectronicMoneyMixpanelTracker_Factory implements Factory<ElectronicMoneyMixpanelTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ElectronicMoneyMixpanelTracker(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
