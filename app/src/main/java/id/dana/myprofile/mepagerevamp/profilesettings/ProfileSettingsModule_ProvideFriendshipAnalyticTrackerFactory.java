package id.dana.myprofile.mepagerevamp.profilesettings;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ProfileSettingsModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final ProfileSettingsModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> getAuthRequestContext;

    public static FriendshipAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(ProfileSettingsModule profileSettingsModule, Context context) {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(profileSettingsModule.getAuthRequestContext(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
