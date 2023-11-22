package id.dana.tracker.mixpanel;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BiometricMixpanelTracker_Factory implements Factory<BiometricMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BiometricMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
