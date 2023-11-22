package id.dana.data.social.repository.source.persistence.entity;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\bC\b\u0086\b\u0018\u00002\u00020\u0001B³\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001e\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010!\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bc\u0010dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J \u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004JÀ\u0002\u0010>\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001e2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010!2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b>\u0010?J\u001a\u0010A\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bE\u0010\u0004R\u0017\u0010'\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b'\u0010F\u001a\u0004\bG\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bH\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010I\u001a\u0004\bJ\u0010\u0018R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010F\u001a\u0004\bK\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u001e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010L\u001a\u0004\bM\u0010 R\u001a\u0010&\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010F\u001a\u0004\bN\u0010\u0004R*\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010O\u001a\u0004\bP\u0010#R\u001c\u0010;\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010I\u001a\u0004\bQ\u0010\u0018R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010F\u001a\u0004\bR\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010F\u001a\u0004\bS\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bT\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010F\u001a\u0004\bU\u0010\u0004R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010V\u001a\u0004\bW\u0010\u0007R\u001c\u0010=\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010X\u001a\u0004\b=\u0010\nR\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010F\u001a\u0004\bY\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010X\u001a\u0004\bZ\u0010\nR\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010F\u001a\u0004\b[\u0010\u0004R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010F\u001a\u0004\b\\\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010F\u001a\u0004\b]\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010X\u001a\u0004\b^\u0010\nR\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010F\u001a\u0004\b_\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010F\u001a\u0004\b`\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010F\u001a\u0004\ba\u0010\u0004R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010F\u001a\u0004\bb\u0010\u0004"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/List;", "", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "", "component22", "()Ljava/lang/Integer;", "component23", "component24", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Long;", "", "component7", "()Ljava/util/Map;", "component8", "component9", "entityId", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "commentCounts", "content", "caption", "createdTime", "extendInfo", "iconUrl", "id", "imageUrls", "ownActivity", "read", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, ShareToFeedBridge.WIDGET, "latestComments", "ownComments", "ownReactions", "reactionCounts", "groupName", "groupId", "groupActorCount", "state", "isSubmitFeedBanner", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "getCaption", "Ljava/lang/Integer;", "getCommentCounts", "getContent", "Ljava/lang/Long;", "getCreatedTime", "getEntityId", "Ljava/util/Map;", "getExtendInfo", "getGroupActorCount", "getGroupId", "getGroupName", "getIconUrl", "getId", "Ljava/util/List;", "getImageUrls", "Ljava/lang/Boolean;", "getLatestComments", "getOwnActivity", "getOwnComments", "getOwnReactions", "getReactionCounts", "getRead", "getRedirectType", "getRedirectValue", "getState", "getWidget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ActivityItemEntity {
    private final String activityId;
    private final String caption;
    private final Integer commentCounts;
    private final String content;
    private final Long createdTime;
    private final String entityId;
    private final Map<String, String> extendInfo;
    private final Integer groupActorCount;
    private final String groupId;
    private final String groupName;
    private final String iconUrl;
    private final String id;
    private final List<String> imageUrls;
    private final Boolean isSubmitFeedBanner;
    private final String latestComments;
    private final Boolean ownActivity;
    private final String ownComments;
    private final String ownReactions;
    private final String reactionCounts;
    private final Boolean read;
    private final String redirectType;
    private final String redirectValue;
    private final String state;
    private final String widget;

    /* renamed from: component1  reason: from getter */
    public final String getEntityId() {
        return this.entityId;
    }

    public final List<String> component10() {
        return this.imageUrls;
    }

    /* renamed from: component11  reason: from getter */
    public final Boolean getOwnActivity() {
        return this.ownActivity;
    }

    /* renamed from: component12  reason: from getter */
    public final Boolean getRead() {
        return this.read;
    }

    /* renamed from: component13  reason: from getter */
    public final String getRedirectType() {
        return this.redirectType;
    }

    /* renamed from: component14  reason: from getter */
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    /* renamed from: component15  reason: from getter */
    public final String getWidget() {
        return this.widget;
    }

    /* renamed from: component16  reason: from getter */
    public final String getLatestComments() {
        return this.latestComments;
    }

    /* renamed from: component17  reason: from getter */
    public final String getOwnComments() {
        return this.ownComments;
    }

    /* renamed from: component18  reason: from getter */
    public final String getOwnReactions() {
        return this.ownReactions;
    }

    /* renamed from: component19  reason: from getter */
    public final String getReactionCounts() {
        return this.reactionCounts;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component20  reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    /* renamed from: component21  reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component22  reason: from getter */
    public final Integer getGroupActorCount() {
        return this.groupActorCount;
    }

    /* renamed from: component23  reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component24  reason: from getter */
    public final Boolean getIsSubmitFeedBanner() {
        return this.isSubmitFeedBanner;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getCommentCounts() {
        return this.commentCounts;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCaption() {
        return this.caption;
    }

    /* renamed from: component6  reason: from getter */
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    public final Map<String, String> component7() {
        return this.extendInfo;
    }

    /* renamed from: component8  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component9  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ActivityItemEntity copy(String entityId, String activityId, Integer commentCounts, String content, String caption, Long createdTime, Map<String, String> extendInfo, String iconUrl, String id2, List<String> imageUrls, Boolean ownActivity, Boolean read, String redirectType, String redirectValue, String widget, String latestComments, String ownComments, String ownReactions, String reactionCounts, String groupName, String groupId, Integer groupActorCount, String state, Boolean isSubmitFeedBanner) {
        Intrinsics.checkNotNullParameter(entityId, "");
        Intrinsics.checkNotNullParameter(activityId, "");
        return new ActivityItemEntity(entityId, activityId, commentCounts, content, caption, createdTime, extendInfo, iconUrl, id2, imageUrls, ownActivity, read, redirectType, redirectValue, widget, latestComments, ownComments, ownReactions, reactionCounts, groupName, groupId, groupActorCount, state, isSubmitFeedBanner);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityItemEntity) {
            ActivityItemEntity activityItemEntity = (ActivityItemEntity) other;
            return Intrinsics.areEqual(this.entityId, activityItemEntity.entityId) && Intrinsics.areEqual(this.activityId, activityItemEntity.activityId) && Intrinsics.areEqual(this.commentCounts, activityItemEntity.commentCounts) && Intrinsics.areEqual(this.content, activityItemEntity.content) && Intrinsics.areEqual(this.caption, activityItemEntity.caption) && Intrinsics.areEqual(this.createdTime, activityItemEntity.createdTime) && Intrinsics.areEqual(this.extendInfo, activityItemEntity.extendInfo) && Intrinsics.areEqual(this.iconUrl, activityItemEntity.iconUrl) && Intrinsics.areEqual(this.id, activityItemEntity.id) && Intrinsics.areEqual(this.imageUrls, activityItemEntity.imageUrls) && Intrinsics.areEqual(this.ownActivity, activityItemEntity.ownActivity) && Intrinsics.areEqual(this.read, activityItemEntity.read) && Intrinsics.areEqual(this.redirectType, activityItemEntity.redirectType) && Intrinsics.areEqual(this.redirectValue, activityItemEntity.redirectValue) && Intrinsics.areEqual(this.widget, activityItemEntity.widget) && Intrinsics.areEqual(this.latestComments, activityItemEntity.latestComments) && Intrinsics.areEqual(this.ownComments, activityItemEntity.ownComments) && Intrinsics.areEqual(this.ownReactions, activityItemEntity.ownReactions) && Intrinsics.areEqual(this.reactionCounts, activityItemEntity.reactionCounts) && Intrinsics.areEqual(this.groupName, activityItemEntity.groupName) && Intrinsics.areEqual(this.groupId, activityItemEntity.groupId) && Intrinsics.areEqual(this.groupActorCount, activityItemEntity.groupActorCount) && Intrinsics.areEqual(this.state, activityItemEntity.state) && Intrinsics.areEqual(this.isSubmitFeedBanner, activityItemEntity.isSubmitFeedBanner);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.entityId.hashCode();
        int hashCode2 = this.activityId.hashCode();
        Integer num = this.commentCounts;
        int hashCode3 = num == null ? 0 : num.hashCode();
        String str = this.content;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.caption;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        Long l = this.createdTime;
        int hashCode6 = l == null ? 0 : l.hashCode();
        Map<String, String> map = this.extendInfo;
        int hashCode7 = map == null ? 0 : map.hashCode();
        String str3 = this.iconUrl;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.id;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        List<String> list = this.imageUrls;
        int hashCode10 = list == null ? 0 : list.hashCode();
        Boolean bool = this.ownActivity;
        int hashCode11 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.read;
        int hashCode12 = bool2 == null ? 0 : bool2.hashCode();
        String str5 = this.redirectType;
        int hashCode13 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.redirectValue;
        int hashCode14 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.widget;
        int hashCode15 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.latestComments;
        int hashCode16 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.ownComments;
        int hashCode17 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.ownReactions;
        int hashCode18 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.reactionCounts;
        int hashCode19 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.groupName;
        int hashCode20 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.groupId;
        int hashCode21 = str13 == null ? 0 : str13.hashCode();
        Integer num2 = this.groupActorCount;
        int hashCode22 = num2 == null ? 0 : num2.hashCode();
        String str14 = this.state;
        int hashCode23 = str14 == null ? 0 : str14.hashCode();
        Boolean bool3 = this.isSubmitFeedBanner;
        return (((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityItemEntity(entityId=");
        sb.append(this.entityId);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", commentCounts=");
        sb.append(this.commentCounts);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", caption=");
        sb.append(this.caption);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", imageUrls=");
        sb.append(this.imageUrls);
        sb.append(", ownActivity=");
        sb.append(this.ownActivity);
        sb.append(", read=");
        sb.append(this.read);
        sb.append(", redirectType=");
        sb.append(this.redirectType);
        sb.append(", redirectValue=");
        sb.append(this.redirectValue);
        sb.append(", widget=");
        sb.append(this.widget);
        sb.append(", latestComments=");
        sb.append(this.latestComments);
        sb.append(", ownComments=");
        sb.append(this.ownComments);
        sb.append(", ownReactions=");
        sb.append(this.ownReactions);
        sb.append(", reactionCounts=");
        sb.append(this.reactionCounts);
        sb.append(", groupName=");
        sb.append(this.groupName);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", groupActorCount=");
        sb.append(this.groupActorCount);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", isSubmitFeedBanner=");
        sb.append(this.isSubmitFeedBanner);
        sb.append(')');
        return sb.toString();
    }

    public ActivityItemEntity(String str, String str2, Integer num, String str3, String str4, Long l, Map<String, String> map, String str5, String str6, List<String> list, Boolean bool, Boolean bool2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num2, String str16, Boolean bool3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.entityId = str;
        this.activityId = str2;
        this.commentCounts = num;
        this.content = str3;
        this.caption = str4;
        this.createdTime = l;
        this.extendInfo = map;
        this.iconUrl = str5;
        this.id = str6;
        this.imageUrls = list;
        this.ownActivity = bool;
        this.read = bool2;
        this.redirectType = str7;
        this.redirectValue = str8;
        this.widget = str9;
        this.latestComments = str10;
        this.ownComments = str11;
        this.ownReactions = str12;
        this.reactionCounts = str13;
        this.groupName = str14;
        this.groupId = str15;
        this.groupActorCount = num2;
        this.state = str16;
        this.isSubmitFeedBanner = bool3;
    }

    public /* synthetic */ ActivityItemEntity(String str, String str2, Integer num, String str3, String str4, Long l, Map map, String str5, String str6, List list, Boolean bool, Boolean bool2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num2, String str16, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : list, (i & 1024) != 0 ? null : bool, (i & 2048) != 0 ? null : bool2, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9, (32768 & i) != 0 ? null : str10, (65536 & i) != 0 ? null : str11, (131072 & i) != 0 ? null : str12, (262144 & i) != 0 ? null : str13, (524288 & i) != 0 ? null : str14, (1048576 & i) != 0 ? null : str15, (2097152 & i) != 0 ? null : num2, (4194304 & i) != 0 ? null : str16, (i & 8388608) != 0 ? null : bool3);
    }

    @JvmName(name = "getEntityId")
    public final String getEntityId() {
        return this.entityId;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getCommentCounts")
    public final Integer getCommentCounts() {
        return this.commentCounts;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getCaption")
    public final String getCaption() {
        return this.caption;
    }

    @JvmName(name = "getCreatedTime")
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getImageUrls")
    public final List<String> getImageUrls() {
        return this.imageUrls;
    }

    @JvmName(name = "getOwnActivity")
    public final Boolean getOwnActivity() {
        return this.ownActivity;
    }

    @JvmName(name = "getRead")
    public final Boolean getRead() {
        return this.read;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    @JvmName(name = "getWidget")
    public final String getWidget() {
        return this.widget;
    }

    @JvmName(name = "getLatestComments")
    public final String getLatestComments() {
        return this.latestComments;
    }

    @JvmName(name = "getOwnComments")
    public final String getOwnComments() {
        return this.ownComments;
    }

    @JvmName(name = "getOwnReactions")
    public final String getOwnReactions() {
        return this.ownReactions;
    }

    @JvmName(name = "getReactionCounts")
    public final String getReactionCounts() {
        return this.reactionCounts;
    }

    @JvmName(name = "getGroupName")
    public final String getGroupName() {
        return this.groupName;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
    }

    @JvmName(name = "getGroupActorCount")
    public final Integer getGroupActorCount() {
        return this.groupActorCount;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "isSubmitFeedBanner")
    public final Boolean isSubmitFeedBanner() {
        return this.isSubmitFeedBanner;
    }
}
