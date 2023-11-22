package id.dana.di.modules;

import dagger.Binds;
import dagger.Module;
import id.dana.oauth.tracker.MixpanelOauthGrantTracker;
import id.dana.oauth.tracker.OauthGrantTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/modules/OauthGrantTrackerModule;", "", "Lid/dana/oauth/tracker/MixpanelOauthGrantTracker;", "p0", "Lid/dana/oauth/tracker/OauthGrantTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/oauth/tracker/MixpanelOauthGrantTracker;)Lid/dana/oauth/tracker/OauthGrantTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class OauthGrantTrackerModule {
    @Binds
    public abstract OauthGrantTracker KClassImpl$Data$declaredNonStaticMembers$2(MixpanelOauthGrantTracker p0);
}
