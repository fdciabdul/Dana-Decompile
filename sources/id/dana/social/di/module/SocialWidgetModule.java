package id.dana.social.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.di.PerModule;
import id.dana.feeds.data.timeline.FeedsTimelineEntityRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.presenter.NewSocialWidgetPresenter;
import id.dana.social.presenter.SocialWidgetPresenter;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0005\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/social/di/module/SocialWidgetModule;", "", "Lid/dana/feeds/data/timeline/FeedsTimelineEntityRepository;", "p0", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "PlaceComponentResult", "(Lid/dana/feeds/data/timeline/FeedsTimelineEntityRepository;)Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Landroid/content/Context;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "(Landroid/content/Context;)Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/social/presenter/NewSocialWidgetPresenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/presenter/NewSocialWidgetPresenter;)Lid/dana/social/presenter/NewSocialWidgetPresenter;", "Lid/dana/social/presenter/SocialWidgetPresenter;", "Lid/dana/social/contract/SocialWidgetContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/presenter/SocialWidgetPresenter;)Lid/dana/social/contract/SocialWidgetContract$Presenter;", "Lid/dana/social/contract/SocialWidgetContract$View;", "()Lid/dana/social/contract/SocialWidgetContract$View;", "getAuthRequestContext", "Lid/dana/social/contract/SocialWidgetContract$View;", "<init>", "(Lid/dana/social/contract/SocialWidgetContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class SocialWidgetModule {
    private final SocialWidgetContract.View getAuthRequestContext;

    @Provides
    @Named("newSocialWidgetPresenter")
    public final NewSocialWidgetPresenter KClassImpl$Data$declaredNonStaticMembers$2(NewSocialWidgetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    public SocialWidgetModule(SocialWidgetContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SocialWidgetContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @Named("oldSocialWidgetPresenter")
    public final SocialWidgetContract.Presenter BuiltInFictitiousFunctionClassFactory(SocialWidgetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final FeedsTimelineRepository PlaceComponentResult(FeedsTimelineEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final FriendshipAnalyticTracker PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new FriendshipMixpanelTracker(p0);
    }
}
