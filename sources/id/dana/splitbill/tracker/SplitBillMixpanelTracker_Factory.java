package id.dana.splitbill.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SplitBillMixpanelTracker_Factory implements Factory<SplitBillMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
