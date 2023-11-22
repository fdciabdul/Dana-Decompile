package id.dana.expresspurchase.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ExpressPurchaseMixpanelTracker_Factory implements Factory<ExpressPurchaseMixpanelTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExpressPurchaseMixpanelTracker(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
