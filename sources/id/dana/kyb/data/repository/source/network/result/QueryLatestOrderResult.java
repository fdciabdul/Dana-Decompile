package id.dana.kyb.data.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "kybInfo", "modifiedDate", "orderStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKybInfo", "getModifiedDate", "getOrderStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QueryLatestOrderResult extends BaseRpcResult {
    private final String kybInfo;
    private final String modifiedDate;
    private final String orderStatus;

    public QueryLatestOrderResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ QueryLatestOrderResult copy$default(QueryLatestOrderResult queryLatestOrderResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryLatestOrderResult.kybInfo;
        }
        if ((i & 2) != 0) {
            str2 = queryLatestOrderResult.modifiedDate;
        }
        if ((i & 4) != 0) {
            str3 = queryLatestOrderResult.orderStatus;
        }
        return queryLatestOrderResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKybInfo() {
        return this.kybInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getModifiedDate() {
        return this.modifiedDate;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final QueryLatestOrderResult copy(String kybInfo, String modifiedDate, String orderStatus) {
        return new QueryLatestOrderResult(kybInfo, modifiedDate, orderStatus);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryLatestOrderResult) {
            QueryLatestOrderResult queryLatestOrderResult = (QueryLatestOrderResult) other;
            return Intrinsics.areEqual(this.kybInfo, queryLatestOrderResult.kybInfo) && Intrinsics.areEqual(this.modifiedDate, queryLatestOrderResult.modifiedDate) && Intrinsics.areEqual(this.orderStatus, queryLatestOrderResult.orderStatus);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.kybInfo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.modifiedDate;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.orderStatus;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryLatestOrderResult(kybInfo=");
        sb.append(this.kybInfo);
        sb.append(", modifiedDate=");
        sb.append(this.modifiedDate);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryLatestOrderResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getKybInfo")
    public final String getKybInfo() {
        return this.kybInfo;
    }

    @JvmName(name = "getModifiedDate")
    public final String getModifiedDate() {
        return this.modifiedDate;
    }

    @JvmName(name = "getOrderStatus")
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public QueryLatestOrderResult(String str, String str2, String str3) {
        this.kybInfo = str;
        this.modifiedDate = str2;
        this.orderStatus = str3;
    }
}
