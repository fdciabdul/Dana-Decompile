package id.dana.feeds.data.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.feeds.domain.timeline.model.OwnComment;
import id.dana.feeds.domain.timeline.model.OwnReaction;
import id.dana.feeds.domain.timeline.model.ReactionCount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\t\u001a\u00020\u0002*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u000bR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/data/mapper/ActivityItemEntityMapper;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "", "p0", "p1", "", "p2", "Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/timeline/model/ActivityResponse;Ljava/lang/String;Ljava/lang/String;I)Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;", "(Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;)Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lcom/google/gson/Gson;", "MyBillsEntityDataFactory", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ActivityItemEntityMapper {
    public final Gson MyBillsEntityDataFactory;

    @Inject
    public ActivityItemEntityMapper(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "");
        this.MyBillsEntityDataFactory = gson;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.timeline.model.ActivityResponse r32, java.lang.String r33, java.lang.String r34, int r35) {
        /*
            r31 = this;
            r0 = r31
            id.dana.feeds.domain.timeline.enums.FeedActivityState r1 = r32.getState()
            id.dana.feeds.domain.timeline.enums.FeedActivityState r2 = id.dana.feeds.domain.timeline.enums.FeedActivityState.SUCCESS
            java.lang.String r3 = ""
            r4 = 0
            if (r1 != r2) goto L14
            java.lang.String r1 = r32.getActivityId()
            if (r1 != 0) goto L28
            goto L26
        L14:
            java.util.HashMap r1 = r32.getExtendInfo()
            if (r1 == 0) goto L23
            java.lang.String r2 = "shareFeedRequestId"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            goto L24
        L23:
            r1 = r4
        L24:
            if (r1 != 0) goto L28
        L26:
            r6 = r3
            goto L29
        L28:
            r6 = r1
        L29:
            java.lang.String r1 = r32.getActivityId()
            if (r1 != 0) goto L31
            r7 = r3
            goto L32
        L31:
            r7 = r1
        L32:
            int r1 = r32.getCommentCounts()
            java.lang.String r9 = r32.getContent()
            long r2 = r32.getCreatedTime()
            java.lang.String r10 = r32.getCaption()
            java.util.HashMap r5 = r32.getExtendInfo()
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L4e
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
        L4e:
            r12 = r5
            java.lang.String r13 = r32.getIconUrl()
            java.lang.String r14 = r32.getId()
            java.util.List r15 = r32.getImageUrls()
            boolean r16 = r32.getOwnActivity()
            boolean r17 = r32.getRead()
            java.lang.String r18 = r32.getRedirectType()
            java.lang.String r19 = r32.getRedirectValue()
            id.dana.feeds.domain.timeline.model.ActivityWidget r5 = r32.getActivityWidget()
            if (r5 == 0) goto L77
            com.google.gson.Gson r4 = r0.MyBillsEntityDataFactory
            java.lang.String r4 = r4.toJson(r5)
        L77:
            r20 = r4
            java.util.List r4 = r32.getLatestComments()
            com.google.gson.Gson r5 = r0.MyBillsEntityDataFactory
            java.lang.String r21 = r5.toJson(r4)
            java.util.List r4 = r32.getOwnComment()
            com.google.gson.Gson r5 = r0.MyBillsEntityDataFactory
            java.lang.String r22 = r5.toJson(r4)
            java.util.List r4 = r32.getOwnReactions()
            com.google.gson.Gson r5 = r0.MyBillsEntityDataFactory
            java.lang.String r23 = r5.toJson(r4)
            java.util.List r4 = r32.getReactionCounts()
            com.google.gson.Gson r5 = r0.MyBillsEntityDataFactory
            java.lang.String r24 = r5.toJson(r4)
            id.dana.feeds.domain.timeline.enums.FeedActivityState r4 = r32.getState()
            java.lang.String r28 = r4.getValue()
            boolean r4 = r32.isSubmitFeedBanner()
            id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity r30 = new id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity
            r5 = r30
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            java.lang.Long r11 = java.lang.Long.valueOf(r2)
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r17)
            java.lang.Integer r27 = java.lang.Integer.valueOf(r35)
            java.lang.Boolean r29 = java.lang.Boolean.valueOf(r4)
            r25 = r33
            r26 = r34
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r30
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.mapper.ActivityItemEntityMapper.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.feeds.domain.timeline.model.ActivityResponse, java.lang.String, java.lang.String, int):id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity");
    }

    public final ActivityResponse KClassImpl$Data$declaredNonStaticMembers$2(ActivityItemEntity activityItemEntity) {
        boolean z;
        List list;
        FeedActivityState feedActivityState;
        String activityId = activityItemEntity.getActivityId();
        Integer commentCounts = activityItemEntity.getCommentCounts();
        int intValue = commentCounts != null ? commentCounts.intValue() : 0;
        String content = activityItemEntity.getContent();
        String caption = activityItemEntity.getCaption();
        Long createdTime = activityItemEntity.getCreatedTime();
        long longValue = createdTime != null ? createdTime.longValue() : 0L;
        Map<String, String> extendInfo = activityItemEntity.getExtendInfo();
        HashMap hashMap = extendInfo != null ? new HashMap(extendInfo) : null;
        String iconUrl = activityItemEntity.getIconUrl();
        String id2 = activityItemEntity.getId();
        List<String> imageUrls = activityItemEntity.getImageUrls();
        if (imageUrls == null) {
            imageUrls = CollectionsKt.emptyList();
        }
        List<String> list2 = imageUrls;
        Boolean ownActivity = activityItemEntity.getOwnActivity();
        boolean booleanValue = ownActivity != null ? ownActivity.booleanValue() : false;
        Boolean read = activityItemEntity.getRead();
        boolean booleanValue2 = read != null ? read.booleanValue() : false;
        String redirectType = activityItemEntity.getRedirectType();
        String redirectValue = activityItemEntity.getRedirectValue();
        String widget = activityItemEntity.getWidget();
        ActivityWidget activityWidget = widget != null ? (ActivityWidget) this.MyBillsEntityDataFactory.fromJson(widget, ActivityWidget.class) : null;
        String latestComments = activityItemEntity.getLatestComments();
        List list3 = latestComments != null ? (List) this.MyBillsEntityDataFactory.fromJson(latestComments, TypeToken.getParameterized(List.class, Comment.class).getType()) : null;
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        List list4 = list3;
        String ownComments = activityItemEntity.getOwnComments();
        List list5 = ownComments != null ? (List) this.MyBillsEntityDataFactory.fromJson(ownComments, TypeToken.getParameterized(List.class, OwnComment.class).getType()) : null;
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        List list6 = list5;
        String ownReactions = activityItemEntity.getOwnReactions();
        List list7 = ownReactions != null ? (List) this.MyBillsEntityDataFactory.fromJson(ownReactions, TypeToken.getParameterized(List.class, OwnReaction.class).getType()) : null;
        if (list7 == null) {
            list7 = CollectionsKt.emptyList();
        }
        List list8 = list7;
        String reactionCounts = activityItemEntity.getReactionCounts();
        if (reactionCounts != null) {
            z = false;
            list = (List) this.MyBillsEntityDataFactory.fromJson(reactionCounts, TypeToken.getParameterized(List.class, ReactionCount.class).getType());
        } else {
            z = false;
            list = null;
        }
        List emptyList = list == null ? CollectionsKt.emptyList() : list;
        String state = activityItemEntity.getState();
        if (state == null || (feedActivityState = FeedActivityState.valueOf(state)) == null) {
            feedActivityState = FeedActivityState.SUCCESS;
        }
        FeedActivityState feedActivityState2 = feedActivityState;
        Boolean isSubmitFeedBanner = activityItemEntity.isSubmitFeedBanner();
        if (isSubmitFeedBanner != null) {
            z = isSubmitFeedBanner.booleanValue();
        }
        return new ActivityResponse(id2, iconUrl, content, redirectType, redirectValue, booleanValue2, longValue, hashMap, emptyList, list8, null, activityId, booleanValue, intValue, caption, feedActivityState2, z, list2, list6, list4, activityWidget, 1024, null);
    }
}
