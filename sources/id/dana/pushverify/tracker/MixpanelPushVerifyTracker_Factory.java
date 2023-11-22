package id.dana.pushverify.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MixpanelPushVerifyTracker_Factory implements Factory<MixpanelPushVerifyTracker> {
    private final Provider<Context> PlaceComponentResult;

    private MixpanelPushVerifyTracker_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static MixpanelPushVerifyTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new MixpanelPushVerifyTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelPushVerifyTracker(this.PlaceComponentResult.get());
    }
}
