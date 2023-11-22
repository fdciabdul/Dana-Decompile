package id.dana.feeds.data.timeline.source.network.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.data.detail.source.network.response.CommentResponse;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B£\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u001f\u0012,\b\u0002\u0010/\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`#\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0005\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00105\u001a\u00020\u000e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005¢\u0006\u0004\b\\\u0010]J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010 \u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J4\u0010$\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010\bJ¬\u0002\u0010;\u001a\u00020\u00002\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u001f2,\b\u0002\u0010/\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`#2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00052\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b;\u0010<J\u001a\u0010>\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b@\u0010\u0010J\u0010\u0010A\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bA\u0010\u0004R\u0019\u00103\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b3\u0010B\u001a\u0004\bC\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010B\u001a\u0004\bD\u0010\u0004R\u001a\u00105\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010E\u001a\u0004\bF\u0010\u0010R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bG\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010B\u001a\u0004\bH\u0010\u0004R\u001a\u0010.\u001a\u00020\u001f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010!R>\u0010/\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010K\u001a\u0004\bL\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010B\u001a\u0004\bM\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bN\u0010\u0004R\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010O\u001a\u0004\bP\u0010\bR\"\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010O\u001a\u0004\bQ\u0010\bR\u001a\u00104\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010R\u001a\u0004\bS\u0010\rR\"\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010O\u001a\u0004\bT\u0010\bR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010O\u001a\u0004\bU\u0010\bR\"\u00100\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010O\u001a\u0004\bV\u0010\bR\u001a\u0010-\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010R\u001a\u0004\bW\u0010\rR\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010B\u001a\u0004\bX\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010B\u001a\u0004\bY\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010Z\u001a\u0004\b[\u0010\u0015"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/response/ActivityResult;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/feeds/data/timeline/source/network/response/OwnReactionResult;", "component10", "()Ljava/util/List;", "component11", "component12", "", "component13", "()Z", "", "component14", "()I", "component15", "component16", "Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "component17", "()Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "Lid/dana/feeds/data/detail/source/network/response/CommentResponse;", "component18", "Lid/dana/feeds/data/timeline/source/network/response/OwnCommentResult;", "component19", "component2", "component3", "component4", "component5", "component6", "", "component7", "()J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component8", "()Ljava/util/HashMap;", "Lid/dana/feeds/data/timeline/source/network/response/ReactionCountResult;", "component9", "id", "iconUrl", "content", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, "read", "createdTime", "extendInfo", "reactionCounts", "ownReactions", "contentType", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "ownActivity", "commentCounts", "caption", "imageUrls", ShareToFeedBridge.WIDGET, "latestComments", "ownComments", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/util/List;Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;Ljava/util/List;Ljava/util/List;)Lid/dana/feeds/data/timeline/source/network/response/ActivityResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getActivityId", "getCaption", "I", "getCommentCounts", "getContent", "getContentType", "J", "getCreatedTime", "Ljava/util/HashMap;", "getExtendInfo", "getIconUrl", "getId", "Ljava/util/List;", "getImageUrls", "getLatestComments", "Z", "getOwnActivity", "getOwnComments", "getOwnReactions", "getReactionCounts", "getRead", "getRedirectType", "getRedirectValue", "Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "getWidget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/util/List;Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityResult {
    private final String activityId;
    private final String caption;
    private final int commentCounts;
    private final String content;
    private final String contentType;
    private final long createdTime;
    private final HashMap<String, String> extendInfo;
    private final String iconUrl;
    private final String id;
    private final List<String> imageUrls;
    private final List<CommentResponse> latestComments;
    private final boolean ownActivity;
    private final List<OwnCommentResult> ownComments;
    private final List<OwnReactionResult> ownReactions;
    private final List<ReactionCountResult> reactionCounts;
    private final boolean read;
    private final String redirectType;
    private final String redirectValue;
    private final ActivityWidgetResult widget;

    public ActivityResult() {
        this(null, null, null, null, null, false, 0L, null, null, null, null, null, false, 0, null, null, null, null, null, 524287, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<OwnReactionResult> component10() {
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

    public final List<String> component16() {
        return this.imageUrls;
    }

    /* renamed from: component17  reason: from getter */
    public final ActivityWidgetResult getWidget() {
        return this.widget;
    }

    public final List<CommentResponse> component18() {
        return this.latestComments;
    }

    public final List<OwnCommentResult> component19() {
        return this.ownComments;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
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

    public final List<ReactionCountResult> component9() {
        return this.reactionCounts;
    }

    public final ActivityResult copy(String id2, String iconUrl, String content, String redirectType, String redirectValue, boolean read, long createdTime, HashMap<String, String> extendInfo, List<ReactionCountResult> reactionCounts, List<OwnReactionResult> ownReactions, String contentType, String activityId, boolean ownActivity, int commentCounts, String caption, List<String> imageUrls, ActivityWidgetResult widget, List<CommentResponse> latestComments, List<OwnCommentResult> ownComments) {
        return new ActivityResult(id2, iconUrl, content, redirectType, redirectValue, read, createdTime, extendInfo, reactionCounts, ownReactions, contentType, activityId, ownActivity, commentCounts, caption, imageUrls, widget, latestComments, ownComments);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityResult) {
            ActivityResult activityResult = (ActivityResult) other;
            return Intrinsics.areEqual(this.id, activityResult.id) && Intrinsics.areEqual(this.iconUrl, activityResult.iconUrl) && Intrinsics.areEqual(this.content, activityResult.content) && Intrinsics.areEqual(this.redirectType, activityResult.redirectType) && Intrinsics.areEqual(this.redirectValue, activityResult.redirectValue) && this.read == activityResult.read && this.createdTime == activityResult.createdTime && Intrinsics.areEqual(this.extendInfo, activityResult.extendInfo) && Intrinsics.areEqual(this.reactionCounts, activityResult.reactionCounts) && Intrinsics.areEqual(this.ownReactions, activityResult.ownReactions) && Intrinsics.areEqual(this.contentType, activityResult.contentType) && Intrinsics.areEqual(this.activityId, activityResult.activityId) && this.ownActivity == activityResult.ownActivity && this.commentCounts == activityResult.commentCounts && Intrinsics.areEqual(this.caption, activityResult.caption) && Intrinsics.areEqual(this.imageUrls, activityResult.imageUrls) && Intrinsics.areEqual(this.widget, activityResult.widget) && Intrinsics.areEqual(this.latestComments, activityResult.latestComments) && Intrinsics.areEqual(this.ownComments, activityResult.ownComments);
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
        List<ReactionCountResult> list = this.reactionCounts;
        int hashCode7 = list == null ? 0 : list.hashCode();
        List<OwnReactionResult> list2 = this.ownReactions;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        String str6 = this.contentType;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.activityId;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        boolean z2 = this.ownActivity;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        int i3 = this.commentCounts;
        String str8 = this.caption;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        List<String> list3 = this.imageUrls;
        int hashCode12 = list3 == null ? 0 : list3.hashCode();
        ActivityWidgetResult activityWidgetResult = this.widget;
        int hashCode13 = activityWidgetResult == null ? 0 : activityWidgetResult.hashCode();
        List<CommentResponse> list4 = this.latestComments;
        int hashCode14 = list4 == null ? 0 : list4.hashCode();
        List<OwnCommentResult> list5 = this.ownComments;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i2) * 31) + i3) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (list5 != null ? list5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityResult(id=");
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
        sb.append(", imageUrls=");
        sb.append(this.imageUrls);
        sb.append(", widget=");
        sb.append(this.widget);
        sb.append(", latestComments=");
        sb.append(this.latestComments);
        sb.append(", ownComments=");
        sb.append(this.ownComments);
        sb.append(')');
        return sb.toString();
    }

    public ActivityResult(String str, String str2, String str3, String str4, String str5, boolean z, long j, HashMap<String, String> hashMap, List<ReactionCountResult> list, List<OwnReactionResult> list2, String str6, String str7, boolean z2, int i, String str8, List<String> list3, ActivityWidgetResult activityWidgetResult, List<CommentResponse> list4, List<OwnCommentResult> list5) {
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
        this.imageUrls = list3;
        this.widget = activityWidgetResult;
        this.latestComments = list4;
        this.ownComments = list5;
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

    public /* synthetic */ ActivityResult(String str, String str2, String str3, String str4, String str5, boolean z, long j, HashMap hashMap, List list, List list2, String str6, String str7, boolean z2, int i, String str8, List list3, ActivityWidgetResult activityWidgetResult, List list4, List list5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? 0L : j, (i2 & 128) != 0 ? new HashMap() : hashMap, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 1024) != 0 ? "" : str6, (i2 & 2048) != 0 ? "" : str7, (i2 & 4096) != 0 ? false : z2, (i2 & 8192) != 0 ? 0 : i, (i2 & 16384) != 0 ? "" : str8, (i2 & 32768) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 65536) != 0 ? null : activityWidgetResult, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 262144) != 0 ? CollectionsKt.emptyList() : list5);
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getReactionCounts")
    public final List<ReactionCountResult> getReactionCounts() {
        return this.reactionCounts;
    }

    @JvmName(name = "getOwnReactions")
    public final List<OwnReactionResult> getOwnReactions() {
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

    @JvmName(name = "getImageUrls")
    public final List<String> getImageUrls() {
        return this.imageUrls;
    }

    @JvmName(name = "getWidget")
    public final ActivityWidgetResult getWidget() {
        return this.widget;
    }

    @JvmName(name = "getLatestComments")
    public final List<CommentResponse> getLatestComments() {
        return this.latestComments;
    }

    @JvmName(name = "getOwnComments")
    public final List<OwnCommentResult> getOwnComments() {
        return this.ownComments;
    }
}
