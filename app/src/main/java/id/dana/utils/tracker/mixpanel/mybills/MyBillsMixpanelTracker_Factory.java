package id.dana.utils.tracker.mixpanel.mybills;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MyBillsMixpanelTracker_Factory implements Factory<MyBillsMixpanelTracker> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsMixpanelTracker(this.getAuthRequestContext.get());
    }
}
