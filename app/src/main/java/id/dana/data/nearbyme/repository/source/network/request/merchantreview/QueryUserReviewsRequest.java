package id.dana.data.nearbyme.repository.source.network.request.merchantreview;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "component2", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "copy", "(II)Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPageNumber", "getPageSize", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryUserReviewsRequest extends BaseRpcRequest {
    private final int pageNumber;
    private final int pageSize;

    public static /* synthetic */ QueryUserReviewsRequest copy$default(QueryUserReviewsRequest queryUserReviewsRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = queryUserReviewsRequest.pageSize;
        }
        if ((i3 & 2) != 0) {
            i2 = queryUserReviewsRequest.pageNumber;
        }
        return queryUserReviewsRequest.copy(i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final QueryUserReviewsRequest copy(int pageSize, int pageNumber) {
        return new QueryUserReviewsRequest(pageSize, pageNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryUserReviewsRequest) {
            QueryUserReviewsRequest queryUserReviewsRequest = (QueryUserReviewsRequest) other;
            return this.pageSize == queryUserReviewsRequest.pageSize && this.pageNumber == queryUserReviewsRequest.pageNumber;
        }
        return false;
    }

    public final int hashCode() {
        return (this.pageSize * 31) + this.pageNumber;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryUserReviewsRequest(pageSize=");
        sb.append(this.pageSize);
        sb.append(", pageNumber=");
        sb.append(this.pageNumber);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getPageNumber")
    public final int getPageNumber() {
        return this.pageNumber;
    }

    public QueryUserReviewsRequest(int i, int i2) {
        this.pageSize = i;
        this.pageNumber = i2;
    }
}
