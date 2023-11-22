package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", CashierKeyParams.CASHIER_ORDER_ID, "selectedAddons", "transType", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCashierOrderId", "Ljava/util/List;", "getSelectedAddons", "getTransType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierUpdateOrderRequest {
    private final String cashierOrderId;
    private final List<String> selectedAddons;
    private final String transType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CashierUpdateOrderRequest copy$default(CashierUpdateOrderRequest cashierUpdateOrderRequest, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierUpdateOrderRequest.cashierOrderId;
        }
        if ((i & 2) != 0) {
            list = cashierUpdateOrderRequest.selectedAddons;
        }
        if ((i & 4) != 0) {
            str2 = cashierUpdateOrderRequest.transType;
        }
        return cashierUpdateOrderRequest.copy(str, list, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    public final List<String> component2() {
        return this.selectedAddons;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    public final CashierUpdateOrderRequest copy(String cashierOrderId, List<String> selectedAddons, String transType) {
        return new CashierUpdateOrderRequest(cashierOrderId, selectedAddons, transType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierUpdateOrderRequest) {
            CashierUpdateOrderRequest cashierUpdateOrderRequest = (CashierUpdateOrderRequest) other;
            return Intrinsics.areEqual(this.cashierOrderId, cashierUpdateOrderRequest.cashierOrderId) && Intrinsics.areEqual(this.selectedAddons, cashierUpdateOrderRequest.selectedAddons) && Intrinsics.areEqual(this.transType, cashierUpdateOrderRequest.transType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cashierOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.selectedAddons;
        int hashCode2 = list == null ? 0 : list.hashCode();
        String str2 = this.transType;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierUpdateOrderRequest(cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", selectedAddons=");
        sb.append(this.selectedAddons);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(')');
        return sb.toString();
    }

    public CashierUpdateOrderRequest(String str, List<String> list, String str2) {
        this.cashierOrderId = str;
        this.selectedAddons = list;
        this.transType = str2;
    }

    public /* synthetic */ CashierUpdateOrderRequest(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getSelectedAddons")
    public final List<String> getSelectedAddons() {
        return this.selectedAddons;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }
}
