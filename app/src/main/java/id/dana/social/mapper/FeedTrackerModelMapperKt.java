package id.dana.social.mapper;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.FeedTrackerModel;
import id.dana.social.model.FeedHighlightModel;
import id.dana.social.model.FeedModel;
import id.dana.social.utils.Content;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\u0002\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\u000b¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\u000e¢\u0006\u0004\b\f\u0010\u000f"}, d2 = {"Lid/dana/feeds/ui/model/ActivityWidgetModel;", "Lid/dana/feeds/ui/model/FeedTrackerModel;", "PlaceComponentResult", "(Lid/dana/feeds/ui/model/ActivityWidgetModel;)Lid/dana/feeds/ui/model/FeedTrackerModel;", "Lid/dana/feeds/ui/model/DealsPayloadModel;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/ui/model/DealsPayloadModel;Ljava/lang/String;)Lid/dana/feeds/ui/model/FeedTrackerModel;", "Lid/dana/social/model/FeedHighlightModel;", "(Lid/dana/social/model/FeedHighlightModel;)Lid/dana/feeds/ui/model/FeedTrackerModel;", "Lid/dana/social/model/FeedModel;", "getAuthRequestContext", "(Lid/dana/social/model/FeedModel;)Lid/dana/feeds/ui/model/FeedTrackerModel;", "Lid/dana/social/utils/Content;", "(Lid/dana/social/utils/Content;)Lid/dana/feeds/ui/model/FeedTrackerModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedTrackerModelMapperKt {
    public static final FeedTrackerModel PlaceComponentResult(ActivityWidgetModel activityWidgetModel) {
        Intrinsics.checkNotNullParameter(activityWidgetModel, "");
        return new FeedTrackerModel(null, activityWidgetModel.PlaceComponentResult, activityWidgetModel.getAuthRequestContext, activityWidgetModel.BuiltInFictitiousFunctionClassFactory, null, 17, null);
    }

    public static final FeedTrackerModel KClassImpl$Data$declaredNonStaticMembers$2(DealsPayloadModel dealsPayloadModel, String str) {
        Intrinsics.checkNotNullParameter(dealsPayloadModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = (String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.PlaceComponentResult, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[1].getName());
        String str3 = str2 == null ? "" : str2;
        String str4 = (String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.BuiltInFictitiousFunctionClassFactory, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[2].getName());
        return new FeedTrackerModel(null, str3, str4 == null ? "" : str4, str, null, 17, null);
    }

    public static final FeedTrackerModel PlaceComponentResult(FeedHighlightModel feedHighlightModel) {
        Intrinsics.checkNotNullParameter(feedHighlightModel, "");
        String str = feedHighlightModel.getAuthRequestContext;
        String str2 = feedHighlightModel.MyBillsEntityDataFactory.get("redirectType");
        String str3 = str2 == null ? "" : str2;
        String str4 = feedHighlightModel.MyBillsEntityDataFactory.get(ShareToFeedBridge.REDIRECT_VALUE);
        return new FeedTrackerModel(str, str3, str4 == null ? "" : str4, feedHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2, null, 16, null);
    }

    public static final FeedTrackerModel getAuthRequestContext(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        String str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        HashMap<String, String> hashMap = feedModel.lookAheadTest;
        String str2 = hashMap != null ? hashMap.get("redirectType") : null;
        String str3 = str2 == null ? "" : str2;
        HashMap<String, String> hashMap2 = feedModel.lookAheadTest;
        String str4 = hashMap2 != null ? hashMap2.get(ShareToFeedBridge.REDIRECT_VALUE) : null;
        String str5 = str4 == null ? "" : str4;
        String str6 = feedModel.PlaceComponentResult;
        if (str6 == null) {
            str6 = "";
        }
        return new FeedTrackerModel(str, str3, str5, str6, null, 16, null);
    }

    public static final FeedTrackerModel getAuthRequestContext(Content content) {
        Intrinsics.checkNotNullParameter(content, "");
        String str = content.BuiltInFictitiousFunctionClassFactory;
        String str2 = content.getAuthRequestContext;
        String str3 = content.MyBillsEntityDataFactory;
        return new FeedTrackerModel(str, str2, str3 == null ? "" : str3, content.KClassImpl$Data$declaredNonStaticMembers$2, content.lookAheadTest);
    }
}
