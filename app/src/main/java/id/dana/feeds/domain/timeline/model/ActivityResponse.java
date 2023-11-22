package id.dana.feeds.domain.timeline.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001iB\u00ad\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u000b\u0012\b\b\u0002\u00102\u001a\u00020#\u0012,\b\u0002\u00103\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`'\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020*0\u0005\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u000b\u0012\b\b\u0002\u00109\u001a\u00020\u000e\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0012\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bg\u0010hJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\"\u0010\rJ\u0010\u0010$\u001a\u00020#HÆ\u0003¢\u0006\u0004\b$\u0010%J4\u0010(\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0005HÆ\u0003¢\u0006\u0004\b+\u0010\bJ¶\u0002\u0010A\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020#2,\b\u0002\u00103\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`'2\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020*0\u00052\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010;\u001a\u00020\u00122\b\b\u0002\u0010<\u001a\u00020\u000b2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0004\bA\u0010BJ\u001a\u0010D\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u0002¢\u0006\u0004\bF\u0010\u0004J\u0010\u0010G\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bG\u0010\u0010J\u0010\u0010H\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bH\u0010\u0004R\u0019\u00107\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b7\u0010I\u001a\u0004\bJ\u0010\u0004R\u001c\u0010@\u001a\u0004\u0018\u00010\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010K\u001a\u0004\bL\u0010\u001eR\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010I\u001a\u0004\bM\u0010\u0004R\u001a\u00109\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010N\u001a\u0004\bO\u0010\u0010R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bP\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010I\u001a\u0004\bQ\u0010\u0004R\u001a\u00102\u001a\u00020#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010R\u001a\u0004\bS\u0010%RF\u00103\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`'8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010T\u001a\u0004\bU\u0010)\"\u0004\bV\u0010WR\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010I\u001a\u0004\bX\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010I\u001a\u0004\bY\u0010\u0004R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010Z\u001a\u0004\b[\u0010\bR\u001a\u0010<\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\\\u001a\u0004\b<\u0010\rR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010Z\u001a\u0004\b]\u0010\bR\u001a\u00108\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\\\u001a\u0004\b^\u0010\rR \u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010Z\u001a\u0004\b_\u0010\bR \u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010Z\u001a\u0004\b`\u0010\bR \u00104\u001a\b\u0012\u0004\u0012\u00020*0\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010Z\u001a\u0004\ba\u0010\bR\u001a\u00101\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\\\u001a\u0004\bb\u0010\rR\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010I\u001a\u0004\bc\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010I\u001a\u0004\bd\u0010\u0004R\u001a\u0010;\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010e\u001a\u0004\bf\u0010\u0014"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/feeds/domain/timeline/model/OwnReaction;", "component10", "()Ljava/util/List;", "component11", "component12", "", "component13", "()Z", "", "component14", "()I", "component15", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "component16", "()Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "component17", "component18", "Lid/dana/feeds/domain/timeline/model/OwnComment;", "component19", "component2", "Lid/dana/feeds/domain/detail/model/Comment;", "component20", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "component21", "()Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "component3", "component4", "component5", "component6", "", "component7", "()J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component8", "()Ljava/util/HashMap;", "Lid/dana/feeds/domain/timeline/model/ReactionCount;", "component9", "id", "iconUrl", "content", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, "read", "createdTime", "extendInfo", "reactionCounts", "ownReactions", "contentType", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "ownActivity", "commentCounts", "caption", "state", "isSubmitFeedBanner", "imageUrls", "ownComment", "latestComments", "activityWidget", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Lid/dana/feeds/domain/timeline/model/ActivityWidget;)Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "getUserId", "hashCode", "toString", "Ljava/lang/String;", "getActivityId", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "getActivityWidget", "getCaption", "I", "getCommentCounts", "getContent", "getContentType", "J", "getCreatedTime", "Ljava/util/HashMap;", "getExtendInfo", "setExtendInfo", "(Ljava/util/HashMap;)V", "getIconUrl", "getId", "Ljava/util/List;", "getImageUrls", "Z", "getLatestComments", "getOwnActivity", "getOwnComment", "getOwnReactions", "getReactionCounts", "getRead", "getRedirectType", "getRedirectValue", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "getState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Lid/dana/feeds/domain/timeline/model/ActivityWidget;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String activityId;
    private final ActivityWidget activityWidget;
    private final String caption;
    private final int commentCounts;
    private final String content;
    private final String contentType;
    private final long createdTime;
    private HashMap<String, String> extendInfo;
    private final String iconUrl;
    private final String id;
    private final List<String> imageUrls;
    private final boolean isSubmitFeedBanner;
    private final List<Comment> latestComments;
    private final boolean ownActivity;
    private final List<OwnComment> ownComment;
    private final List<OwnReaction> ownReactions;
    private final List<ReactionCount> reactionCounts;
    private final boolean read;
    private final String redirectType;
    private final String redirectValue;
    private final FeedActivityState state;

    public ActivityResponse() {
        this(null, null, null, null, null, false, 0L, null, null, null, null, null, false, 0, null, null, false, null, null, null, null, 2097151, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<OwnReaction> component10() {
        return this.ownReactions;
    }

    /* renamed from: component11  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component12  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component13  reason: from getter */
    public final boolean getOwnActivity() {
        return this.ownActivity;
    }

    /* renamed from: component14  reason: from getter */
    public final int getCommentCounts() {
        return this.commentCounts;
    }

    /* renamed from: component15  reason: from getter */
    public final String getCaption() {
        return this.caption;
    }

    /* renamed from: component16  reason: from getter */
    public final FeedActivityState getState() {
        return this.state;
    }

    /* renamed from: component17  reason: from getter */
    public final boolean getIsSubmitFeedBanner() {
        return this.isSubmitFeedBanner;
    }

    public final List<String> component18() {
        return this.imageUrls;
    }

    public final List<OwnComment> component19() {
        return this.ownComment;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<Comment> component20() {
        return this.latestComments;
    }

    /* renamed from: component21  reason: from getter */
    public final ActivityWidget getActivityWidget() {
        return this.activityWidget;
    }

    /* renamed from: component3  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRedirectType() {
        return this.redirectType;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getRead() {
        return this.read;
    }

    /* renamed from: component7  reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final HashMap<String, String> component8() {
        return this.extendInfo;
    }

    public final List<ReactionCount> component9() {
        return this.reactionCounts;
    }

    public final ActivityResponse copy(String id2, String iconUrl, String content, String redirectType, String redirectValue, boolean read, long createdTime, HashMap<String, String> extendInfo, List<ReactionCount> reactionCounts, List<OwnReaction> ownReactions, String contentType, String activityId, boolean ownActivity, int commentCounts, String caption, FeedActivityState state, boolean isSubmitFeedBanner, List<String> imageUrls, List<OwnComment> ownComment, List<Comment> latestComments, ActivityWidget activityWidget) {
        Intrinsics.checkNotNullParameter(reactionCounts, "");
        Intrinsics.checkNotNullParameter(ownReactions, "");
        Intrinsics.checkNotNullParameter(state, "");
        Intrinsics.checkNotNullParameter(imageUrls, "");
        Intrinsics.checkNotNullParameter(ownComment, "");
        Intrinsics.checkNotNullParameter(latestComments, "");
        return new ActivityResponse(id2, iconUrl, content, redirectType, redirectValue, read, createdTime, extendInfo, reactionCounts, ownReactions, contentType, activityId, ownActivity, commentCounts, caption, state, isSubmitFeedBanner, imageUrls, ownComment, latestComments, activityWidget);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityResponse) {
            ActivityResponse activityResponse = (ActivityResponse) other;
            return Intrinsics.areEqual(this.id, activityResponse.id) && Intrinsics.areEqual(this.iconUrl, activityResponse.iconUrl) && Intrinsics.areEqual(this.content, activityResponse.content) && Intrinsics.areEqual(this.redirectType, activityResponse.redirectType) && Intrinsics.areEqual(this.redirectValue, activityResponse.redirectValue) && this.read == activityResponse.read && this.createdTime == activityResponse.createdTime && Intrinsics.areEqual(this.extendInfo, activityResponse.extendInfo) && Intrinsics.areEqual(this.reactionCounts, activityResponse.reactionCounts) && Intrinsics.areEqual(this.ownReactions, activityResponse.ownReactions) && Intrinsics.areEqual(this.contentType, activityResponse.contentType) && Intrinsics.areEqual(this.activityId, activityResponse.activityId) && this.ownActivity == activityResponse.ownActivity && this.commentCounts == activityResponse.commentCounts && Intrinsics.areEqual(this.caption, activityResponse.caption) && this.state == activityResponse.state && this.isSubmitFeedBanner == activityResponse.isSubmitFeedBanner && Intrinsics.areEqual(this.imageUrls, activityResponse.imageUrls) && Intrinsics.areEqual(this.ownComment, activityResponse.ownComment) && Intrinsics.areEqual(this.latestComments, activityResponse.latestComments) && Intrinsics.areEqual(this.activityWidget, activityResponse.activityWidget);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.iconUrl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.content;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.redirectType;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.redirectValue;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        boolean z = this.read;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.createdTime);
        HashMap<String, String> hashMap = this.extendInfo;
        int hashCode6 = hashMap == null ? 0 : hashMap.hashCode();
        int hashCode7 = this.reactionCounts.hashCode();
        int hashCode8 = this.ownReactions.hashCode();
        String str6 = this.contentType;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.activityId;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        boolean z2 = this.ownActivity;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = this.commentCounts;
        String str8 = this.caption;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        int hashCode12 = this.state.hashCode();
        boolean z3 = this.isSubmitFeedBanner;
        int i4 = !z3 ? z3 ? 1 : 0 : 1;
        int hashCode13 = this.imageUrls.hashCode();
        int hashCode14 = this.ownComment.hashCode();
        int hashCode15 = this.latestComments.hashCode();
        ActivityWidget activityWidget = this.activityWidget;
        return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i2) * 31) + i3) * 31) + hashCode11) * 31) + hashCode12) * 31) + i4) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + (activityWidget != null ? activityWidget.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityResponse(id=");
        sb.append(this.id);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", redirectType=");
        sb.append(this.redirectType);
        sb.append(", redirectValue=");
        sb.append(this.redirectValue);
        sb.append(", read=");
        sb.append(this.read);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", reactionCounts=");
        sb.append(this.reactionCounts);
        sb.append(", ownReactions=");
        sb.append(this.ownReactions);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", ownActivity=");
        sb.append(this.ownActivity);
        sb.append(", commentCounts=");
        sb.append(this.commentCounts);
        sb.append(", caption=");
        sb.append(this.caption);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", isSubmitFeedBanner=");
        sb.append(this.isSubmitFeedBanner);
        sb.append(", imageUrls=");
        sb.append(this.imageUrls);
        sb.append(", ownComment=");
        sb.append(this.ownComment);
        sb.append(", latestComments=");
        sb.append(this.latestComments);
        sb.append(", activityWidget=");
        sb.append(this.activityWidget);
        sb.append(')');
        return sb.toString();
    }

    public ActivityResponse(String str, String str2, String str3, String str4, String str5, boolean z, long j, HashMap<String, String> hashMap, List<ReactionCount> list, List<OwnReaction> list2, String str6, String str7, boolean z2, int i, String str8, FeedActivityState feedActivityState, boolean z3, List<String> list3, List<OwnComment> list4, List<Comment> list5, ActivityWidget activityWidget) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(feedActivityState, "");
        Intrinsics.checkNotNullParameter(list3, "");
        Intrinsics.checkNotNullParameter(list4, "");
        Intrinsics.checkNotNullParameter(list5, "");
        this.id = str;
        this.iconUrl = str2;
        this.content = str3;
        this.redirectType = str4;
        this.redirectValue = str5;
        this.read = z;
        this.createdTime = j;
        this.extendInfo = hashMap;
        this.reactionCounts = list;
        this.ownReactions = list2;
        this.contentType = str6;
        this.activityId = str7;
        this.ownActivity = z2;
        this.commentCounts = i;
        this.caption = str8;
        this.state = feedActivityState;
        this.isSubmitFeedBanner = z3;
        this.imageUrls = list3;
        this.ownComment = list4;
        this.latestComments = list5;
        this.activityWidget = activityWidget;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    @JvmName(name = "getRead")
    public final boolean getRead() {
        return this.read;
    }

    @JvmName(name = "getCreatedTime")
    public final long getCreatedTime() {
        return this.createdTime;
    }

    public /* synthetic */ ActivityResponse(String str, String str2, String str3, String str4, String str5, boolean z, long j, HashMap hashMap, List list, List list2, String str6, String str7, boolean z2, int i, String str8, FeedActivityState feedActivityState, boolean z3, List list3, List list4, List list5, ActivityWidget activityWidget, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? 0L : j, (i2 & 128) != 0 ? new HashMap() : hashMap, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 1024) != 0 ? "" : str6, (i2 & 2048) != 0 ? "" : str7, (i2 & 4096) != 0 ? false : z2, (i2 & 8192) != 0 ? 0 : i, (i2 & 16384) != 0 ? "" : str8, (i2 & 32768) != 0 ? FeedActivityState.SUCCESS : feedActivityState, (i2 & 65536) != 0 ? false : z3, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 262144) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 524288) != 0 ? CollectionsKt.emptyList() : list5, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : activityWidget);
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(HashMap<String, String> hashMap) {
        this.extendInfo = hashMap;
    }

    @JvmName(name = "getReactionCounts")
    public final List<ReactionCount> getReactionCounts() {
        return this.reactionCounts;
    }

    @JvmName(name = "getOwnReactions")
    public final List<OwnReaction> getOwnReactions() {
        return this.ownReactions;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getOwnActivity")
    public final boolean getOwnActivity() {
        return this.ownActivity;
    }

    @JvmName(name = "getCommentCounts")
    public final int getCommentCounts() {
        return this.commentCounts;
    }

    @JvmName(name = "getCaption")
    public final String getCaption() {
        return this.caption;
    }

    @JvmName(name = "getState")
    public final FeedActivityState getState() {
        return this.state;
    }

    @JvmName(name = "isSubmitFeedBanner")
    public final boolean isSubmitFeedBanner() {
        return this.isSubmitFeedBanner;
    }

    @JvmName(name = "getImageUrls")
    public final List<String> getImageUrls() {
        return this.imageUrls;
    }

    @JvmName(name = "getOwnComment")
    public final List<OwnComment> getOwnComment() {
        return this.ownComment;
    }

    @JvmName(name = "getLatestComments")
    public final List<Comment> getLatestComments() {
        return this.latestComments;
    }

    @JvmName(name = "getActivityWidget")
    public final ActivityWidget getActivityWidget() {
        return this.activityWidget;
    }

    public final String getUserId() {
        String userId;
        HashMap<String, String> hashMap = this.extendInfo;
        return (hashMap == null || (userId = ExtendInfoUtilKt.getUserId(hashMap)) == null) ? "" : userId;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityResponse$Companion;", "", "", "success", "", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "", "createdTime", "isSubmitFeedBanner", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "createShareFeedActivityResponse", "(ZLjava/lang/String;JZ)Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityResponse createShareFeedActivityResponse(boolean success, String shareFeedRequestId, long createdTime, boolean isSubmitFeedBanner) {
            Intrinsics.checkNotNullParameter(shareFeedRequestId, "");
            ActivityResponse activityResponse = new ActivityResponse(null, null, null, null, null, false, createdTime, null, null, null, null, null, false, 0, null, success ? FeedActivityState.SUCCESS : FeedActivityState.ERROR, isSubmitFeedBanner, null, null, null, null, 1998783, null);
            HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
            if (extendInfo != null) {
                ExtendInfoUtilKt.setShareFeedRequestId(extendInfo, shareFeedRequestId);
            }
            return activityResponse;
        }
    }
}
