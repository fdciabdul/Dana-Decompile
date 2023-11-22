package id.dana.data.recurring.subscription.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ@\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b!\u0010\b"}, d2 = {"Lid/dana/data/recurring/subscription/source/network/response/ConsultViewResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/recurring/subscription/source/network/response/SubscriptionView;", "component1", "()Ljava/util/List;", "", "component2", "()I", "", "component3", "()Z", "component4", "subscriptionViews", "totalCount", "hasMore", "pageNum", "copy", "(Ljava/util/List;IZI)Lid/dana/data/recurring/subscription/source/network/response/ConsultViewResponse;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "I", "getPageNum", "Ljava/util/List;", "getSubscriptionViews", "getTotalCount", "<init>", "(Ljava/util/List;IZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConsultViewResponse extends BaseRpcResult {
    private final boolean hasMore;
    private final int pageNum;
    private final List<SubscriptionView> subscriptionViews;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultViewResponse copy$default(ConsultViewResponse consultViewResponse, List list, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = consultViewResponse.subscriptionViews;
        }
        if ((i3 & 2) != 0) {
            i = consultViewResponse.totalCount;
        }
        if ((i3 & 4) != 0) {
            z = consultViewResponse.hasMore;
        }
        if ((i3 & 8) != 0) {
            i2 = consultViewResponse.pageNum;
        }
        return consultViewResponse.copy(list, i, z, i2);
    }

    public final List<SubscriptionView> component1() {
        return this.subscriptionViews;
    }

    /* renamed from: component2  reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component4  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final ConsultViewResponse copy(List<SubscriptionView> subscriptionViews, int totalCount, boolean hasMore, int pageNum) {
        return new ConsultViewResponse(subscriptionViews, totalCount, hasMore, pageNum);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ConsultViewResponse) {
            ConsultViewResponse consultViewResponse = (ConsultViewResponse) other;
            return Intrinsics.areEqual(this.subscriptionViews, consultViewResponse.subscriptionViews) && this.totalCount == consultViewResponse.totalCount && this.hasMore == consultViewResponse.hasMore && this.pageNum == consultViewResponse.pageNum;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        List<SubscriptionView> list = this.subscriptionViews;
        int hashCode = list == null ? 0 : list.hashCode();
        int i = this.totalCount;
        boolean z = this.hasMore;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((hashCode * 31) + i) * 31) + i2) * 31) + this.pageNum;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConsultViewResponse(subscriptionViews=");
        sb.append(this.subscriptionViews);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSubscriptionViews")
    public final List<SubscriptionView> getSubscriptionViews() {
        return this.subscriptionViews;
    }

    @JvmName(name = "getTotalCount")
    public final int getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    public ConsultViewResponse(List<SubscriptionView> list, int i, boolean z, int i2) {
        this.subscriptionViews = list;
        this.totalCount = i;
        this.hasMore = z;
        this.pageNum = i2;
    }
}
