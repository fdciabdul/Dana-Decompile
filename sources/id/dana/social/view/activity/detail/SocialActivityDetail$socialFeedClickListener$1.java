package id.dana.social.view.activity.detail;

import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.mapper.FeedTrackerModelMapperKt;
import id.dana.social.mapper.FeedViewModelMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.utils.Content;
import id.dana.social.utils.FeedsContentAction;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\n\u0010\u0010"}, d2 = {"Lid/dana/social/view/activity/detail/SocialActivityDetail$socialFeedClickListener$1;", "Lid/dana/social/adapter/BaseSocialFeedInteraction;", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/ui/model/ActivityWidgetModel;)V", "", "Lid/dana/feeds/ui/model/DealsPayloadModel;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/feeds/ui/model/DealsPayloadModel;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V", "Lid/dana/social/utils/Content;", "(Lid/dana/social/utils/Content;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SocialActivityDetail$socialFeedClickListener$1 extends BaseSocialFeedInteraction {
    final /* synthetic */ SocialActivityDetail MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocialActivityDetail$socialFeedClickListener$1(SocialActivityDetail socialActivityDetail) {
        this.MyBillsEntityDataFactory = socialActivityDetail;
    }

    @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
    public final void getAuthRequestContext(Content p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FeedsContentAction feedsContentAction = this.MyBillsEntityDataFactory.getFeedsContentAction();
        String str = p0.MyBillsEntityDataFactory;
        feedsContentAction.getAuthRequestContext(str != null ? str : "");
    }

    @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        FeedModel feedModel;
        boolean PlaceComponentResult;
        feedModel = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedModel != null) {
            SocialActivityDetail socialActivityDetail = this.MyBillsEntityDataFactory;
            PlaceComponentResult = socialActivityDetail.PlaceComponentResult(feedModel);
            if (PlaceComponentResult) {
                SocialActivityDetail.access$openSelfProfileActivity(socialActivityDetail, feedModel);
            } else {
                SocialActivityDetail.access$openProfileActivity(socialActivityDetail, FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel));
            }
        }
    }

    @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
    public final void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.PlaceComponentResult(p0));
        this.MyBillsEntityDataFactory.getFeedsContentAction().getAuthRequestContext(p0.getAuthRequestContext);
    }

    @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
    public final void getAuthRequestContext(String p0, DealsPayloadModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p1, p0));
        FeedsContentAction feedsContentAction = this.MyBillsEntityDataFactory.getFeedsContentAction();
        String str = (String) MapsKt.getOrImplicitDefaultNullable(p1.PlaceComponentResult, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[1].getName());
        if (str == null) {
            str = "";
        }
        String str2 = (String) MapsKt.getOrImplicitDefaultNullable(p1.BuiltInFictitiousFunctionClassFactory, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[2].getName());
        feedsContentAction.KClassImpl$Data$declaredNonStaticMembers$2(str, str2 != null ? str2 : "");
    }
}
