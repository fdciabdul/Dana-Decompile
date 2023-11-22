package id.dana.userpersonalization.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class UserPersonalizationMixpanelTracker_Factory implements Factory<UserPersonalizationMixpanelTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserPersonalizationMixpanelTracker(this.MyBillsEntityDataFactory.get());
    }
}
