package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b!\u0010\u0007"}, d2 = {"Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Z", "", "component2", "()I", "", "Lid/dana/mybills/data/model/response/SubscriptionHighlightViewResult;", "component3", "()Ljava/util/List;", "component4", "hasMore", "pageNum", "subscriptionViews", "totalCount", "copy", "(ZILjava/util/List;I)Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "I", "getPageNum", "Ljava/util/List;", "getSubscriptionViews", "getTotalCount", "<init>", "(ZILjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HighlightSubscriptionResult extends BaseRpcResultAphome {
    private final boolean hasMore;
    private final int pageNum;
    private final List<SubscriptionHighlightViewResult> subscriptionViews;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HighlightSubscriptionResult copy$default(HighlightSubscriptionResult highlightSubscriptionResult, boolean z, int i, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = highlightSubscriptionResult.hasMore;
        }
        if ((i3 & 2) != 0) {
            i = highlightSubscriptionResult.pageNum;
        }
        if ((i3 & 4) != 0) {
            list = highlightSubscriptionResult.subscriptionViews;
        }
        if ((i3 & 8) != 0) {
            i2 = highlightSubscriptionResult.totalCount;
        }
        return highlightSubscriptionResult.copy(z, i, list, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final List<SubscriptionHighlightViewResult> component3() {
        return this.subscriptionViews;
    }

    /* renamed from: component4  reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final HighlightSubscriptionResult copy(boolean hasMore, int pageNum, List<SubscriptionHighlightViewResult> subscriptionViews, int totalCount) {
        return new HighlightSubscriptionResult(hasMore, pageNum, subscriptionViews, totalCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HighlightSubscriptionResult) {
            HighlightSubscriptionResult highlightSubscriptionResult = (HighlightSubscriptionResult) other;
            return this.hasMore == highlightSubscriptionResult.hasMore && this.pageNum == highlightSubscriptionResult.pageNum && Intrinsics.areEqual(this.subscriptionViews, highlightSubscriptionResult.subscriptionViews) && this.totalCount == highlightSubscriptionResult.totalCount;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = this.pageNum;
        List<SubscriptionHighlightViewResult> list = this.subscriptionViews;
        return (((((r0 * 31) + i) * 31) + (list == null ? 0 : list.hashCode())) * 31) + this.totalCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HighlightSubscriptionResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", subscriptionViews=");
        sb.append(this.subscriptionViews);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getSubscriptionViews")
    public final List<SubscriptionHighlightViewResult> getSubscriptionViews() {
        return this.subscriptionViews;
    }

    @JvmName(name = "getTotalCount")
    public final int getTotalCount() {
        return this.totalCount;
    }

    public HighlightSubscriptionResult(boolean z, int i, List<SubscriptionHighlightViewResult> list, int i2) {
        this.hasMore = z;
        this.pageNum = i;
        this.subscriptionViews = list;
        this.totalCount = i2;
    }
}
