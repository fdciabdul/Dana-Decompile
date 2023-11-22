package id.dana.feeds.data.detail.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.domain.detail.model.FeedCommentResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bR\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\b"}, d2 = {"Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/feeds/data/detail/source/network/response/CommentResponse;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Boolean;", "comments", "maxId", "hasNext", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "toFeedCommentResult", "()Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "toString", "Ljava/util/List;", "getComments", "Ljava/lang/Boolean;", "getHasNext", "Ljava/lang/String;", "getMaxId", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FetchActivityCommentsResponse extends BaseRpcResult {
    private final List<CommentResponse> comments;
    private final Boolean hasNext;
    private final String maxId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FetchActivityCommentsResponse copy$default(FetchActivityCommentsResponse fetchActivityCommentsResponse, List list, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fetchActivityCommentsResponse.comments;
        }
        if ((i & 2) != 0) {
            str = fetchActivityCommentsResponse.maxId;
        }
        if ((i & 4) != 0) {
            bool = fetchActivityCommentsResponse.hasNext;
        }
        return fetchActivityCommentsResponse.copy(list, str, bool);
    }

    public final List<CommentResponse> component1() {
        return this.comments;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    public final FetchActivityCommentsResponse copy(List<CommentResponse> comments, String maxId, Boolean hasNext) {
        return new FetchActivityCommentsResponse(comments, maxId, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FetchActivityCommentsResponse) {
            FetchActivityCommentsResponse fetchActivityCommentsResponse = (FetchActivityCommentsResponse) other;
            return Intrinsics.areEqual(this.comments, fetchActivityCommentsResponse.comments) && Intrinsics.areEqual(this.maxId, fetchActivityCommentsResponse.maxId) && Intrinsics.areEqual(this.hasNext, fetchActivityCommentsResponse.hasNext);
        }
        return false;
    }

    public final int hashCode() {
        List<CommentResponse> list = this.comments;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.maxId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Boolean bool = this.hasNext;
        return (((hashCode * 31) + hashCode2) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchActivityCommentsResponse(comments=");
        sb.append(this.comments);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getComments")
    public final List<CommentResponse> getComments() {
        return this.comments;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getHasNext")
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    public FetchActivityCommentsResponse(List<CommentResponse> list, String str, Boolean bool) {
        this.comments = list;
        this.maxId = str;
        this.hasNext = bool;
    }

    public final FeedCommentResult toFeedCommentResult() {
        List<CommentResponse> list = this.comments;
        List comments = list != null ? FetchActivityCommentsResponseKt.toComments(list) : null;
        if (comments == null) {
            comments = CollectionsKt.emptyList();
        }
        List list2 = comments;
        String str = this.maxId;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Boolean bool = this.hasNext;
        return new FeedCommentResult(list2, str2, bool != null ? bool.booleanValue() : false, 0, 8, null);
    }
}
