package id.dana.myprofile.mepagerevamp.profilesettings;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getAuthRequestContext", "(Landroid/content/Context;)Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsPresenter;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "PlaceComponentResult", "(Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsPresenter;)Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "MyBillsEntityDataFactory", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "<init>", "(Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class ProfileSettingsModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ProfileSettingsContract.View getAuthRequestContext;

    public ProfileSettingsModule(ProfileSettingsContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final ProfileSettingsContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final ProfileSettingsContract.Presenter PlaceComponentResult(ProfileSettingsPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final FriendshipAnalyticTracker getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new FriendshipMixpanelTracker(p0);
    }
}
