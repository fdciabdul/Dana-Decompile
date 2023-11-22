package id.dana.familyaccount.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyAccountMixpanelTracker_Factory implements Factory<FamilyAccountMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;

    private FamilyAccountMixpanelTracker_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new FamilyAccountMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyAccountMixpanelTracker(this.PlaceComponentResult.get());
    }
}
