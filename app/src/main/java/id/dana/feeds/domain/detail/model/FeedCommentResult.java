package id.dana.feeds.domain.detail.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\bR\"\u0010\u0012\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010%"}, d2 = {"Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "", "", "Lid/dana/feeds/domain/detail/model/Comment;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "", "component4", "()I", "comments", "maxId", "hasNext", "numberOfReportedComments", "copy", "(Ljava/util/List;Ljava/lang/String;ZI)Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getComments", "setComments", "(Ljava/util/List;)V", "Z", "getHasNext", "Ljava/lang/String;", "getMaxId", "I", "getNumberOfReportedComments", "setNumberOfReportedComments", "(I)V", "<init>", "(Ljava/util/List;Ljava/lang/String;ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedCommentResult {
    private List<Comment> comments;
    private final boolean hasNext;
    private final String maxId;
    private int numberOfReportedComments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedCommentResult copy$default(FeedCommentResult feedCommentResult, List list, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedCommentResult.comments;
        }
        if ((i2 & 2) != 0) {
            str = feedCommentResult.maxId;
        }
        if ((i2 & 4) != 0) {
            z = feedCommentResult.hasNext;
        }
        if ((i2 & 8) != 0) {
            i = feedCommentResult.numberOfReportedComments;
        }
        return feedCommentResult.copy(list, str, z, i);
    }

    public final List<Comment> component1() {
        return this.comments;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* renamed from: component4  reason: from getter */
    public final int getNumberOfReportedComments() {
        return this.numberOfReportedComments;
    }

    public final FeedCommentResult copy(List<Comment> comments, String maxId, boolean hasNext, int numberOfReportedComments) {
        Intrinsics.checkNotNullParameter(comments, "");
        Intrinsics.checkNotNullParameter(maxId, "");
        return new FeedCommentResult(comments, maxId, hasNext, numberOfReportedComments);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedCommentResult) {
            FeedCommentResult feedCommentResult = (FeedCommentResult) other;
            return Intrinsics.areEqual(this.comments, feedCommentResult.comments) && Intrinsics.areEqual(this.maxId, feedCommentResult.maxId) && this.hasNext == feedCommentResult.hasNext && this.numberOfReportedComments == feedCommentResult.numberOfReportedComments;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.comments.hashCode();
        int hashCode2 = this.maxId.hashCode();
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.numberOfReportedComments;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedCommentResult(comments=");
        sb.append(this.comments);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(", numberOfReportedComments=");
        sb.append(this.numberOfReportedComments);
        sb.append(')');
        return sb.toString();
    }

    public FeedCommentResult(List<Comment> list, String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.comments = list;
        this.maxId = str;
        this.hasNext = z;
        this.numberOfReportedComments = i;
    }

    public /* synthetic */ FeedCommentResult(List list, String str, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, z, (i2 & 8) != 0 ? 0 : i);
    }

    @JvmName(name = "getComments")
    public final List<Comment> getComments() {
        return this.comments;
    }

    @JvmName(name = "setComments")
    public final void setComments(List<Comment> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.comments = list;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }

    @JvmName(name = "getNumberOfReportedComments")
    public final int getNumberOfReportedComments() {
        return this.numberOfReportedComments;
    }

    @JvmName(name = "setNumberOfReportedComments")
    public final void setNumberOfReportedComments(int i) {
        this.numberOfReportedComments = i;
    }
}
