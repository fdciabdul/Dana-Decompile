package id.dana.social.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import id.dana.social.contract.PrivacySettingContract;
import id.dana.social.contract.PrivacySettingPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\r"}, d2 = {"Lid/dana/social/di/module/PrivacySettingModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/social/contract/PrivacySettingContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/social/contract/PrivacySettingContract$View;", "Lid/dana/social/contract/PrivacySettingPresenter;", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "(Lid/dana/social/contract/PrivacySettingPresenter;)Lid/dana/social/contract/PrivacySettingContract$Presenter;", "Lid/dana/social/contract/PrivacySettingContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/social/contract/PrivacySettingContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class PrivacySettingModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final PrivacySettingContract.View getAuthRequestContext;

    public PrivacySettingModule(PrivacySettingContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final PrivacySettingContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final PrivacySettingContract.Presenter BuiltInFictitiousFunctionClassFactory(PrivacySettingPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final FriendshipAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new FriendshipMixpanelTracker(p0);
    }
}
