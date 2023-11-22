package id.dana.feeds.data.mapper;

import id.dana.feeds.data.share.source.network.response.ActivityPreviewResponse;
import id.dana.feeds.data.share.source.network.response.FetchShareableActivitiesResponse;
import id.dana.feeds.data.share.source.network.response.PreviewActivityResult;
import id.dana.feeds.data.timeline.source.network.response.ActivityWidgetResult;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareableActivities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/feeds/data/share/source/network/response/FetchShareableActivitiesResponse;", "Lid/dana/feeds/domain/share/model/ShareableActivities;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/data/share/source/network/response/FetchShareableActivitiesResponse;)Lid/dana/feeds/domain/share/model/ShareableActivities;", "Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;)Lid/dana/feeds/domain/share/model/PreviewActivityData;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreviewActivityMapperKt {
    public static final PreviewActivityData BuiltInFictitiousFunctionClassFactory(PreviewActivityResult previewActivityResult) {
        HashMap<String, String> hashMap;
        ActivityWidgetResult widget;
        Intrinsics.checkNotNullParameter(previewActivityResult, "");
        Boolean shareable = previewActivityResult.getShareable();
        boolean booleanValue = shareable != null ? shareable.booleanValue() : false;
        ActivityPreviewResponse activityPreview = previewActivityResult.getActivityPreview();
        String iconUrl = activityPreview != null ? activityPreview.getIconUrl() : null;
        String str = iconUrl == null ? "" : iconUrl;
        ActivityPreviewResponse activityPreview2 = previewActivityResult.getActivityPreview();
        String content = activityPreview2 != null ? activityPreview2.getContent() : null;
        String str2 = content == null ? "" : content;
        ActivityPreviewResponse activityPreview3 = previewActivityResult.getActivityPreview();
        String contentType = activityPreview3 != null ? activityPreview3.getContentType() : null;
        String str3 = contentType == null ? "" : contentType;
        ActivityPreviewResponse activityPreview4 = previewActivityResult.getActivityPreview();
        if (activityPreview4 == null || (hashMap = activityPreview4.getExtendInfo()) == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        ActivityPreviewResponse activityPreview5 = previewActivityResult.getActivityPreview();
        String shareFeedRequestId = activityPreview5 != null ? activityPreview5.getShareFeedRequestId() : null;
        String str4 = shareFeedRequestId == null ? "" : shareFeedRequestId;
        ActivityPreviewResponse activityPreview6 = previewActivityResult.getActivityPreview();
        return new PreviewActivityData(booleanValue, str, str2, str3, hashMap2, str4, false, (activityPreview6 == null || (widget = activityPreview6.getWidget()) == null) ? null : widget.toActivityWidget(), 64, null);
    }

    public static final ShareableActivities KClassImpl$Data$declaredNonStaticMembers$2(FetchShareableActivitiesResponse fetchShareableActivitiesResponse) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(fetchShareableActivitiesResponse, "");
        String maxId = fetchShareableActivitiesResponse.getMaxId();
        if (maxId == null) {
            maxId = "";
        }
        Boolean hasMore = fetchShareableActivitiesResponse.getHasMore();
        boolean booleanValue = hasMore != null ? hasMore.booleanValue() : false;
        List<ActivityPreviewResponse> shareableActivities = fetchShareableActivitiesResponse.getShareableActivities();
        if (shareableActivities == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullParameter(shareableActivities, "");
            List<ActivityPreviewResponse> list = shareableActivities;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ActivityPreviewResponse activityPreviewResponse : list) {
                Intrinsics.checkNotNullParameter(activityPreviewResponse, "");
                String iconUrl = activityPreviewResponse.getIconUrl();
                String str = iconUrl == null ? "" : iconUrl;
                String content = activityPreviewResponse.getContent();
                String str2 = content == null ? "" : content;
                String contentType = activityPreviewResponse.getContentType();
                String str3 = contentType == null ? "" : contentType;
                HashMap<String, String> extendInfo = activityPreviewResponse.getExtendInfo();
                String shareFeedRequestId = activityPreviewResponse.getShareFeedRequestId();
                String str4 = shareFeedRequestId == null ? "" : shareFeedRequestId;
                ActivityWidgetResult widget = activityPreviewResponse.getWidget();
                arrayList.add(new PreviewActivityData(true, str, str2, str3, extendInfo, str4, false, widget != null ? widget.toActivityWidget() : null));
            }
            emptyList = arrayList;
        }
        return new ShareableActivities(maxId, Boolean.valueOf(booleanValue), emptyList);
    }
}
