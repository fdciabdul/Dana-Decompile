package id.dana.feeds.data.mapper;

import id.dana.feeds.data.detail.source.network.response.CommentResponse;
import id.dana.feeds.data.timeline.source.network.response.ActivityResult;
import id.dana.feeds.data.timeline.source.network.response.ActivityWidgetResult;
import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.GroupedActivityResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import id.dana.feeds.data.timeline.source.network.response.OwnCommentResult;
import id.dana.feeds.data.timeline.source.network.response.OwnReactionResult;
import id.dana.feeds.data.timeline.source.network.response.ReactionCountResult;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.feeds.domain.timeline.model.OwnReaction;
import id.dana.feeds.domain.timeline.model.ReactionCount;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004\u001a&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\u001a\u0010\r\u001a\u00020\u000b*\u00020\u000e2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u000f"}, d2 = {"toActivityResult", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/feeds/data/timeline/source/network/response/ActivityResult;", "toActivityResults", "", "toGroupedActivities", "Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "Lid/dana/feeds/data/timeline/source/network/response/GroupedActivityResult;", "userCreatedActivities", "toGroupedActivity", "toMyFeed", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "toSocialFeed", "Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "feature-feeds_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFeedResultMapperKt {
    public static final SocialFeed KClassImpl$Data$declaredNonStaticMembers$2(MyFeedResult myFeedResult) {
        Intrinsics.checkNotNullParameter(myFeedResult, "");
        boolean hasMore = myFeedResult.getHasMore();
        String maxId = myFeedResult.getMaxId();
        String str = maxId == null ? "" : maxId;
        List<ActivityResponse> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(myFeedResult.getNotifications());
        List emptyList = CollectionsKt.emptyList();
        String minId = myFeedResult.getMinId();
        return new SocialFeed(hasMore, str, BuiltInFictitiousFunctionClassFactory, 0, emptyList, minId == null ? "" : minId, false, 64, null);
    }

    private static List<ActivityResponse> BuiltInFictitiousFunctionClassFactory(List<ActivityResult> list) {
        ArrayList emptyList;
        ArrayList emptyList2;
        ArrayList emptyList3;
        ArrayList emptyList4;
        Intrinsics.checkNotNullParameter(list, "");
        List<ActivityResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ActivityResult activityResult : list2) {
            Intrinsics.checkNotNullParameter(activityResult, "");
            List<ReactionCountResult> reactionCounts = activityResult.getReactionCounts();
            if (reactionCounts == null) {
                emptyList = CollectionsKt.emptyList();
            } else {
                List<ReactionCountResult> list3 = reactionCounts;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ReactionCountResult) it.next()).toReactionCount());
                }
                emptyList = arrayList2;
            }
            List sortedWith = CollectionsKt.sortedWith(emptyList, new Comparator() { // from class: id.dana.feeds.data.mapper.MyFeedResultMapperKt$toActivityResult$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((ReactionCount) t2).getCount()), Integer.valueOf(((ReactionCount) t).getCount()));
                }
            });
            List<OwnReactionResult> ownReactions = activityResult.getOwnReactions();
            if (ownReactions == null) {
                emptyList2 = CollectionsKt.emptyList();
            } else {
                List<OwnReactionResult> list4 = ownReactions;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (OwnReactionResult ownReactionResult : list4) {
                    arrayList3.add(new OwnReaction(ownReactionResult.getId(), ownReactionResult.getKind()));
                }
                emptyList2 = arrayList3;
            }
            List list5 = emptyList2;
            List list6 = sortedWith;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : list6) {
                ReactionCount reactionCount = (ReactionCount) obj;
                List list7 = list5;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                Iterator it2 = list7.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(((OwnReaction) it2.next()).getKind());
                }
                if (arrayList5.contains(reactionCount.getKind())) {
                    arrayList4.add(obj);
                }
            }
            List sortedWith2 = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: id.dana.feeds.data.mapper.MyFeedResultMapperKt$toActivityResult$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((ReactionCount) t).getCount()), Integer.valueOf(((ReactionCount) t2).getCount()));
                }
            });
            ArrayList arrayList6 = new ArrayList();
            for (Object obj2 : list6) {
                ReactionCount reactionCount2 = (ReactionCount) obj2;
                List list8 = list5;
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                Iterator it3 = list8.iterator();
                while (it3.hasNext()) {
                    arrayList7.add(((OwnReaction) it3.next()).getKind());
                }
                if (!arrayList7.contains(reactionCount2.getKind())) {
                    arrayList6.add(obj2);
                }
            }
            List plus = CollectionsKt.plus((Collection) sortedWith2, (Iterable) arrayList6);
            String id2 = activityResult.getId();
            String iconUrl = activityResult.getIconUrl();
            String content = activityResult.getContent();
            String redirectType = activityResult.getRedirectType();
            String redirectValue = activityResult.getRedirectValue();
            boolean read = activityResult.getRead();
            long createdTime = activityResult.getCreatedTime();
            HashMap<String, String> extendInfo = activityResult.getExtendInfo();
            String contentType = activityResult.getContentType();
            String activityId = activityResult.getActivityId();
            boolean ownActivity = activityResult.getOwnActivity();
            int commentCounts = activityResult.getCommentCounts();
            String caption = activityResult.getCaption();
            List<String> imageUrls = activityResult.getImageUrls();
            if (imageUrls == null) {
                imageUrls = CollectionsKt.emptyList();
            }
            List<String> list9 = imageUrls;
            ActivityWidgetResult widget = activityResult.getWidget();
            ActivityWidget activityWidget = widget != null ? widget.toActivityWidget() : null;
            List<CommentResponse> latestComments = activityResult.getLatestComments();
            if (latestComments == null) {
                emptyList3 = CollectionsKt.emptyList();
            } else {
                List<CommentResponse> list10 = latestComments;
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list10, 10));
                Iterator<T> it4 = list10.iterator();
                while (it4.hasNext()) {
                    arrayList8.add(((CommentResponse) it4.next()).toComment());
                }
                emptyList3 = arrayList8;
            }
            List<OwnCommentResult> ownComments = activityResult.getOwnComments();
            if (ownComments == null) {
                emptyList4 = CollectionsKt.emptyList();
            } else {
                List<OwnCommentResult> list11 = ownComments;
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list11, 10));
                Iterator<T> it5 = list11.iterator();
                while (it5.hasNext()) {
                    arrayList9.add(((OwnCommentResult) it5.next()).toOwnComment());
                }
                emptyList4 = arrayList9;
            }
            arrayList.add(new ActivityResponse(id2, iconUrl, content, redirectType, redirectValue, read, createdTime, extendInfo, plus, list5, contentType, activityId, ownActivity, commentCounts, caption, null, false, list9, emptyList4, emptyList3, activityWidget, 98304, null));
        }
        return arrayList;
    }

    public static final SocialFeed BuiltInFictitiousFunctionClassFactory(FeedResult feedResult, List<GroupedActivity> list) {
        Intrinsics.checkNotNullParameter(feedResult, "");
        Intrinsics.checkNotNullParameter(list, "");
        Boolean hasMore = feedResult.getHasMore();
        boolean booleanValue = hasMore != null ? hasMore.booleanValue() : false;
        String maxId = feedResult.getMaxId();
        String str = maxId == null ? "" : maxId;
        List<ActivityResult> activities = feedResult.getActivities();
        ArrayList arrayList = null;
        List<ActivityResponse> BuiltInFictitiousFunctionClassFactory = activities != null ? BuiltInFictitiousFunctionClassFactory(activities) : null;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
        }
        List<ActivityResponse> list2 = BuiltInFictitiousFunctionClassFactory;
        int feedVersion = feedResult.getFeedVersion();
        List<GroupedActivityResult> groupedActivities = feedResult.getGroupedActivities();
        Intrinsics.checkNotNullParameter(list, "");
        if (groupedActivities != null) {
            List<GroupedActivityResult> list3 = groupedActivities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (GroupedActivityResult groupedActivityResult : list3) {
                Intrinsics.checkNotNullParameter(groupedActivityResult, "");
                arrayList2.add(new GroupedActivity(groupedActivityResult.getId(), groupedActivityResult.getGroup(), groupedActivityResult.getActivityCount(), groupedActivityResult.getActorCount(), BuiltInFictitiousFunctionClassFactory(groupedActivityResult.getActivities()), groupedActivityResult.getRead()));
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(list);
        arrayList3.addAll(arrayList);
        String minId = feedResult.getMinId();
        return new SocialFeed(booleanValue, str, list2, feedVersion, arrayList3, minId == null ? "" : minId, false, 64, null);
    }
}
