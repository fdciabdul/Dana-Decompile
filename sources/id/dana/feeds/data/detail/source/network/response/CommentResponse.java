package id.dana.feeds.data.detail.source.network.response;

import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsUserResult;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b8\u00109J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jx\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b+\u0010\u0004R\"\u0010\u001c\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010/R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b5\u0010\tR\u001a\u0010\u0018\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u0010\f"}, d2 = {"Lid/dana/feeds/data/detail/source/network/response/CommentResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Integer;", "Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "component5", "()Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "component6", "", "component7", "()Ljava/lang/Boolean;", "component8", "component9", "()Z", "id", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "parentCommentId", "replyCounts", "user", "content", "ownComment", "createdTime", "hasReport", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)Lid/dana/feeds/data/detail/source/network/response/CommentResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lid/dana/feeds/domain/detail/model/Comment;", "toComment", "()Lid/dana/feeds/domain/detail/model/Comment;", "toString", "Ljava/lang/String;", "getActivityId", "getContent", "getCreatedTime", "Z", "getHasReport", "setHasReport", "(Z)V", "getId", "Ljava/lang/Boolean;", "getOwnComment", "getParentCommentId", "Ljava/lang/Integer;", "getReplyCounts", "Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "getUser", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CommentResponse {
    private final String activityId;
    private final String content;
    private final String createdTime;
    private boolean hasReport;
    private final String id;
    private final Boolean ownComment;
    private final String parentCommentId;
    private final Integer replyCounts;
    private final ActivityReactionsUserResult user;

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getReplyCounts() {
        return this.replyCounts;
    }

    /* renamed from: component5  reason: from getter */
    public final ActivityReactionsUserResult getUser() {
        return this.user;
    }

    /* renamed from: component6  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getOwnComment() {
        return this.ownComment;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getHasReport() {
        return this.hasReport;
    }

    public final CommentResponse copy(String id2, String activityId, String parentCommentId, Integer replyCounts, ActivityReactionsUserResult user, String content, Boolean ownComment, String createdTime, boolean hasReport) {
        Intrinsics.checkNotNullParameter(user, "");
        return new CommentResponse(id2, activityId, parentCommentId, replyCounts, user, content, ownComment, createdTime, hasReport);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CommentResponse) {
            CommentResponse commentResponse = (CommentResponse) other;
            return Intrinsics.areEqual(this.id, commentResponse.id) && Intrinsics.areEqual(this.activityId, commentResponse.activityId) && Intrinsics.areEqual(this.parentCommentId, commentResponse.parentCommentId) && Intrinsics.areEqual(this.replyCounts, commentResponse.replyCounts) && Intrinsics.areEqual(this.user, commentResponse.user) && Intrinsics.areEqual(this.content, commentResponse.content) && Intrinsics.areEqual(this.ownComment, commentResponse.ownComment) && Intrinsics.areEqual(this.createdTime, commentResponse.createdTime) && this.hasReport == commentResponse.hasReport;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.activityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.parentCommentId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Integer num = this.replyCounts;
        int hashCode4 = num == null ? 0 : num.hashCode();
        int hashCode5 = this.user.hashCode();
        String str4 = this.content;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.ownComment;
        int hashCode7 = bool == null ? 0 : bool.hashCode();
        String str5 = this.createdTime;
        int hashCode8 = str5 != null ? str5.hashCode() : 0;
        boolean z = this.hasReport;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommentResponse(id=");
        sb.append(this.id);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", parentCommentId=");
        sb.append(this.parentCommentId);
        sb.append(", replyCounts=");
        sb.append(this.replyCounts);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", ownComment=");
        sb.append(this.ownComment);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", hasReport=");
        sb.append(this.hasReport);
        sb.append(')');
        return sb.toString();
    }

    public CommentResponse(String str, String str2, String str3, Integer num, ActivityReactionsUserResult activityReactionsUserResult, String str4, Boolean bool, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(activityReactionsUserResult, "");
        this.id = str;
        this.activityId = str2;
        this.parentCommentId = str3;
        this.replyCounts = num;
        this.user = activityReactionsUserResult;
        this.content = str4;
        this.ownComment = bool;
        this.createdTime = str5;
        this.hasReport = z;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getParentCommentId")
    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    public /* synthetic */ CommentResponse(String str, String str2, String str3, Integer num, ActivityReactionsUserResult activityReactionsUserResult, String str4, Boolean bool, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? 0 : num, activityReactionsUserResult, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? "" : str5, (i & 256) != 0 ? false : z);
    }

    @JvmName(name = "getReplyCounts")
    public final Integer getReplyCounts() {
        return this.replyCounts;
    }

    @JvmName(name = "getUser")
    public final ActivityReactionsUserResult getUser() {
        return this.user;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getOwnComment")
    public final Boolean getOwnComment() {
        return this.ownComment;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getHasReport")
    public final boolean getHasReport() {
        return this.hasReport;
    }

    @JvmName(name = "setHasReport")
    public final void setHasReport(boolean z) {
        this.hasReport = z;
    }

    public final Comment toComment() {
        String str = this.id;
        String str2 = str == null ? "" : str;
        String str3 = this.activityId;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.parentCommentId;
        String str6 = str5 == null ? "" : str5;
        Integer num = this.replyCounts;
        int intValue = num != null ? num.intValue() : 0;
        ActivityReactionsUser activityReactiosUser = this.user.toActivityReactiosUser();
        String str7 = this.content;
        String str8 = str7 == null ? "" : str7;
        Boolean bool = this.ownComment;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        String str9 = this.createdTime;
        return new Comment(str2, str4, str6, intValue, activityReactiosUser, str8, booleanValue, str9 == null ? "" : str9, false, 256, null);
    }
}
