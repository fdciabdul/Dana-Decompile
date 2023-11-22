package id.dana.kyb.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/kyb/domain/model/QueryLatestOrder;", "", "Lid/dana/kyb/domain/model/KybInfo;", "component1", "()Lid/dana/kyb/domain/model/KybInfo;", "", "component2", "()Ljava/lang/String;", "component3", "kybInfo", "modifiedDate", "orderStatus", "copy", "(Lid/dana/kyb/domain/model/KybInfo;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/QueryLatestOrder;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/kyb/domain/model/KybInfo;", "getKybInfo", "Ljava/lang/String;", "getModifiedDate", "getOrderStatus", "<init>", "(Lid/dana/kyb/domain/model/KybInfo;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QueryLatestOrder {
    private final KybInfo kybInfo;
    private final String modifiedDate;
    private final String orderStatus;

    public QueryLatestOrder() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ QueryLatestOrder copy$default(QueryLatestOrder queryLatestOrder, KybInfo kybInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            kybInfo = queryLatestOrder.kybInfo;
        }
        if ((i & 2) != 0) {
            str = queryLatestOrder.modifiedDate;
        }
        if ((i & 4) != 0) {
            str2 = queryLatestOrder.orderStatus;
        }
        return queryLatestOrder.copy(kybInfo, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final KybInfo getKybInfo() {
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

    public final QueryLatestOrder copy(KybInfo kybInfo, String modifiedDate, String orderStatus) {
        return new QueryLatestOrder(kybInfo, modifiedDate, orderStatus);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryLatestOrder) {
            QueryLatestOrder queryLatestOrder = (QueryLatestOrder) other;
            return Intrinsics.areEqual(this.kybInfo, queryLatestOrder.kybInfo) && Intrinsics.areEqual(this.modifiedDate, queryLatestOrder.modifiedDate) && Intrinsics.areEqual(this.orderStatus, queryLatestOrder.orderStatus);
        }
        return false;
    }

    public final int hashCode() {
        KybInfo kybInfo = this.kybInfo;
        int hashCode = kybInfo == null ? 0 : kybInfo.hashCode();
        String str = this.modifiedDate;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.orderStatus;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryLatestOrder(kybInfo=");
        sb.append(this.kybInfo);
        sb.append(", modifiedDate=");
        sb.append(this.modifiedDate);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(')');
        return sb.toString();
    }

    public QueryLatestOrder(KybInfo kybInfo, String str, String str2) {
        this.kybInfo = kybInfo;
        this.modifiedDate = str;
        this.orderStatus = str2;
    }

    public /* synthetic */ QueryLatestOrder(KybInfo kybInfo, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kybInfo, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getKybInfo")
    public final KybInfo getKybInfo() {
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
}
