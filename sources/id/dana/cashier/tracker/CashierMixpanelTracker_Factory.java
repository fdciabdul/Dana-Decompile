package id.dana.cashier.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierMixpanelTracker_Factory implements Factory<CashierMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
