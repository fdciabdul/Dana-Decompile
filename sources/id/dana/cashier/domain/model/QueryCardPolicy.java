package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/QueryCardPolicy;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "action", CashierKeyParams.CASHIER_ORDER_ID, "prefixCardNo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/QueryCardPolicy;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "getCashierOrderId", "getPrefixCardNo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryCardPolicy {
    private final String action;
    private final String cashierOrderId;
    private final String prefixCardNo;

    public static /* synthetic */ QueryCardPolicy copy$default(QueryCardPolicy queryCardPolicy, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryCardPolicy.action;
        }
        if ((i & 2) != 0) {
            str2 = queryCardPolicy.cashierOrderId;
        }
        if ((i & 4) != 0) {
            str3 = queryCardPolicy.prefixCardNo;
        }
        return queryCardPolicy.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPrefixCardNo() {
        return this.prefixCardNo;
    }

    public final QueryCardPolicy copy(String action, String cashierOrderId, String prefixCardNo) {
        return new QueryCardPolicy(action, cashierOrderId, prefixCardNo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryCardPolicy) {
            QueryCardPolicy queryCardPolicy = (QueryCardPolicy) other;
            return Intrinsics.areEqual(this.action, queryCardPolicy.action) && Intrinsics.areEqual(this.cashierOrderId, queryCardPolicy.cashierOrderId) && Intrinsics.areEqual(this.prefixCardNo, queryCardPolicy.prefixCardNo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.action;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.prefixCardNo;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCardPolicy(action=");
        sb.append(this.action);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", prefixCardNo=");
        sb.append(this.prefixCardNo);
        sb.append(')');
        return sb.toString();
    }

    public QueryCardPolicy(String str, String str2, String str3) {
        this.action = str;
        this.cashierOrderId = str2;
        this.prefixCardNo = str3;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getPrefixCardNo")
    public final String getPrefixCardNo() {
        return this.prefixCardNo;
    }
}
