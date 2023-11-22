package id.dana.cashier.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b"}, d2 = {"Lid/dana/cashier/domain/model/QueryPromotionInfo;", "", "", "component1", "()Ljava/lang/Boolean;", "", "Lid/dana/cashier/domain/model/VoucherCashierInfo;", "component2", "()Ljava/util/List;", "success", "voucherList", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lid/dana/cashier/domain/model/QueryPromotionInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getSuccess", "Ljava/util/List;", "getVoucherList", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryPromotionInfo {
    private final Boolean success;
    private final List<VoucherCashierInfo> voucherList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryPromotionInfo copy$default(QueryPromotionInfo queryPromotionInfo, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = queryPromotionInfo.success;
        }
        if ((i & 2) != 0) {
            list = queryPromotionInfo.voucherList;
        }
        return queryPromotionInfo.copy(bool, list);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final List<VoucherCashierInfo> component2() {
        return this.voucherList;
    }

    public final QueryPromotionInfo copy(Boolean success, List<VoucherCashierInfo> voucherList) {
        Intrinsics.checkNotNullParameter(voucherList, "");
        return new QueryPromotionInfo(success, voucherList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryPromotionInfo) {
            QueryPromotionInfo queryPromotionInfo = (QueryPromotionInfo) other;
            return Intrinsics.areEqual(this.success, queryPromotionInfo.success) && Intrinsics.areEqual(this.voucherList, queryPromotionInfo.voucherList);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.success;
        return ((bool == null ? 0 : bool.hashCode()) * 31) + this.voucherList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryPromotionInfo(success=");
        sb.append(this.success);
        sb.append(", voucherList=");
        sb.append(this.voucherList);
        sb.append(')');
        return sb.toString();
    }

    public QueryPromotionInfo(Boolean bool, List<VoucherCashierInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.success = bool;
        this.voucherList = list;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getVoucherList")
    public final List<VoucherCashierInfo> getVoucherList() {
        return this.voucherList;
    }
}
