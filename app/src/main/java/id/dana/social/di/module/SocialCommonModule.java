package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.base.AbstractContractKt;
import id.dana.di.PerModule;
import id.dana.feeds.data.detail.FeedsDetailEntityRepository;
import id.dana.feeds.data.notification.FeedsNotificationEntityRepository;
import id.dana.feeds.data.timeline.FeedsTimelineEntityRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\b\u0010\u0014J\u0017\u0010\b\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\b\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/social/di/module/SocialCommonModule;", "", "Lid/dana/usereducation/BottomSheetOnBoardingPresenter;", "p0", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/usereducation/BottomSheetOnBoardingPresenter;)Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "Lid/dana/usereducation/BottomSheetOnBoardingContract$View;", "getAuthRequestContext", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$View;", "Lid/dana/feeds/data/detail/FeedsDetailEntityRepository;", "Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/data/detail/FeedsDetailEntityRepository;)Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "Lid/dana/feeds/data/notification/FeedsNotificationEntityRepository;", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/notification/FeedsNotificationEntityRepository;)Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "Lid/dana/feeds/data/timeline/FeedsTimelineEntityRepository;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "(Lid/dana/feeds/data/timeline/FeedsTimelineEntityRepository;)Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/feeds/ui/tracker/FriendshipMixpanelTracker;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "(Lid/dana/feeds/ui/tracker/FriendshipMixpanelTracker;)Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "PlaceComponentResult", "Lid/dana/usereducation/BottomSheetOnBoardingContract$View;", "<init>", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class SocialCommonModule {
    public final BottomSheetOnBoardingContract.View PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.usereducation.BottomSheetOnBoardingContract$View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SocialCommonModule() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.di.module.SocialCommonModule.<init>():void");
    }

    public SocialCommonModule(BottomSheetOnBoardingContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    public /* synthetic */ SocialCommonModule(BottomSheetOnBoardingContract.View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new BottomSheetOnBoardingContract.View() { // from class: id.dana.social.di.module.SocialCommonModule.1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        } : view);
    }

    @Provides
    @PerModule
    public final FriendshipAnalyticTracker getAuthRequestContext(FriendshipMixpanelTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final BottomSheetOnBoardingContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetOnBoardingPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final BottomSheetOnBoardingContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerModule
    public final FeedsTimelineRepository getAuthRequestContext(FeedsTimelineEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final FeedsNotificationRepository BuiltInFictitiousFunctionClassFactory(FeedsNotificationEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final FeedsDetailRepository MyBillsEntityDataFactory(FeedsDetailEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
