package id.dana.oauth.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MixpanelOauthGrantTracker_Factory implements Factory<MixpanelOauthGrantTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private MixpanelOauthGrantTracker_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static MixpanelOauthGrantTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new MixpanelOauthGrantTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelOauthGrantTracker(this.MyBillsEntityDataFactory.get());
    }
}
