package id.dana.feeds.domain.detail.model;

import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010Jj\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b!\u0010\tJ\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b&\u0010\u0004R\"\u0010\u001b\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010'\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010*R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b,\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\tR\u001a\u0010\u0017\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\f"}, d2 = {"Lid/dana/feeds/domain/detail/model/Comment;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "component5", "()Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "component6", "", "component7", "()Z", "component8", "component9", "id", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "parentCommentId", "replyCounts", "user", "content", "ownComment", "createdTime", "hasReport", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILid/dana/feeds/domain/reactions/model/ActivityReactionsUser;Ljava/lang/String;ZLjava/lang/String;Z)Lid/dana/feeds/domain/detail/model/Comment;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getActivityId", "getContent", "getCreatedTime", "Z", "getHasReport", "setHasReport", "(Z)V", "getId", "getOwnComment", "getParentCommentId", "I", "getReplyCounts", "Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "getUser", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILid/dana/feeds/domain/reactions/model/ActivityReactionsUser;Ljava/lang/String;ZLjava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Comment {
    private final String activityId;
    private final String content;
    private final String createdTime;
    private boolean hasReport;
    private final String id;
    private final boolean ownComment;
    private final String parentCommentId;
    private final int replyCounts;
    private final ActivityReactionsUser user;

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
    public final int getReplyCounts() {
        return this.replyCounts;
    }

    /* renamed from: component5  reason: from getter */
    public final ActivityReactionsUser getUser() {
        return this.user;
    }

    /* renamed from: component6  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getOwnComment() {
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

    public final Comment copy(String id2, String activityId, String parentCommentId, int replyCounts, ActivityReactionsUser user, String content, boolean ownComment, String createdTime, boolean hasReport) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(activityId, "");
        Intrinsics.checkNotNullParameter(parentCommentId, "");
        Intrinsics.checkNotNullParameter(user, "");
        Intrinsics.checkNotNullParameter(content, "");
        Intrinsics.checkNotNullParameter(createdTime, "");
        return new Comment(id2, activityId, parentCommentId, replyCounts, user, content, ownComment, createdTime, hasReport);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Comment) {
            Comment comment = (Comment) other;
            return Intrinsics.areEqual(this.id, comment.id) && Intrinsics.areEqual(this.activityId, comment.activityId) && Intrinsics.areEqual(this.parentCommentId, comment.parentCommentId) && this.replyCounts == comment.replyCounts && Intrinsics.areEqual(this.user, comment.user) && Intrinsics.areEqual(this.content, comment.content) && this.ownComment == comment.ownComment && Intrinsics.areEqual(this.createdTime, comment.createdTime) && this.hasReport == comment.hasReport;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.id.hashCode();
        int hashCode2 = this.activityId.hashCode();
        int hashCode3 = this.parentCommentId.hashCode();
        int i = this.replyCounts;
        int hashCode4 = this.user.hashCode();
        int hashCode5 = this.content.hashCode();
        boolean z = this.ownComment;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode6 = this.createdTime.hashCode();
        boolean z2 = this.hasReport;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + i2) * 31) + hashCode6) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment(id=");
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

    public Comment(String str, String str2, String str3, int i, ActivityReactionsUser activityReactionsUser, String str4, boolean z, String str5, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(activityReactionsUser, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.id = str;
        this.activityId = str2;
        this.parentCommentId = str3;
        this.replyCounts = i;
        this.user = activityReactionsUser;
        this.content = str4;
        this.ownComment = z;
        this.createdTime = str5;
        this.hasReport = z2;
    }

    public /* synthetic */ Comment(String str, String str2, String str3, int i, ActivityReactionsUser activityReactionsUser, String str4, boolean z, String str5, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, activityReactionsUser, str4, z, str5, (i2 & 256) != 0 ? false : z2);
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

    @JvmName(name = "getReplyCounts")
    public final int getReplyCounts() {
        return this.replyCounts;
    }

    @JvmName(name = "getUser")
    public final ActivityReactionsUser getUser() {
        return this.user;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getOwnComment")
    public final boolean getOwnComment() {
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
}
