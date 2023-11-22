package id.dana.kyb.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007Jt\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b$\u0010\u0007R\u0017\u0010\u001b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b)\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b*\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b+\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b-\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b1\u0010\u0007"}, d2 = {"Lid/dana/kyb/domain/model/KybTransactionOrderInfo;", "", "", "component1", "()Z", "", "component10", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component7", "component8", "component9", "offUsMerchant", "orderId", "orderType", "orderTitle", "orderTime", "payMoneyAmount", "subOrderStatus", "orderStatus", "productCode", "inOut", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/KybTransactionOrderInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getInOut", "Z", "getOffUsMerchant", "getOrderId", "getOrderStatus", "getOrderTime", CashierKeyParams.GET_ORDER_TITLE, "getOrderType", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPayMoneyAmount", "getProductCode", "getSubOrderStatus", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybTransactionOrderInfo {
    private final String inOut;
    private final boolean offUsMerchant;
    private final String orderId;
    private final String orderStatus;
    private final String orderTime;
    private final String orderTitle;
    private final String orderType;
    private final MoneyView payMoneyAmount;
    private final String productCode;
    private final String subOrderStatus;

    /* renamed from: component1  reason: from getter */
    public final boolean getOffUsMerchant() {
        return this.offUsMerchant;
    }

    /* renamed from: component10  reason: from getter */
    public final String getInOut() {
        return this.inOut;
    }

    /* renamed from: component2  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOrderType() {
        return this.orderType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    /* renamed from: component5  reason: from getter */
    public final String getOrderTime() {
        return this.orderTime;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSubOrderStatus() {
        return this.subOrderStatus;
    }

    /* renamed from: component8  reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    /* renamed from: component9  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    public final KybTransactionOrderInfo copy(boolean offUsMerchant, String orderId, String orderType, String orderTitle, String orderTime, MoneyView payMoneyAmount, String subOrderStatus, String orderStatus, String productCode, String inOut) {
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(orderType, "");
        Intrinsics.checkNotNullParameter(orderTitle, "");
        Intrinsics.checkNotNullParameter(orderTime, "");
        Intrinsics.checkNotNullParameter(payMoneyAmount, "");
        Intrinsics.checkNotNullParameter(subOrderStatus, "");
        Intrinsics.checkNotNullParameter(orderStatus, "");
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(inOut, "");
        return new KybTransactionOrderInfo(offUsMerchant, orderId, orderType, orderTitle, orderTime, payMoneyAmount, subOrderStatus, orderStatus, productCode, inOut);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybTransactionOrderInfo) {
            KybTransactionOrderInfo kybTransactionOrderInfo = (KybTransactionOrderInfo) other;
            return this.offUsMerchant == kybTransactionOrderInfo.offUsMerchant && Intrinsics.areEqual(this.orderId, kybTransactionOrderInfo.orderId) && Intrinsics.areEqual(this.orderType, kybTransactionOrderInfo.orderType) && Intrinsics.areEqual(this.orderTitle, kybTransactionOrderInfo.orderTitle) && Intrinsics.areEqual(this.orderTime, kybTransactionOrderInfo.orderTime) && Intrinsics.areEqual(this.payMoneyAmount, kybTransactionOrderInfo.payMoneyAmount) && Intrinsics.areEqual(this.subOrderStatus, kybTransactionOrderInfo.subOrderStatus) && Intrinsics.areEqual(this.orderStatus, kybTransactionOrderInfo.orderStatus) && Intrinsics.areEqual(this.productCode, kybTransactionOrderInfo.productCode) && Intrinsics.areEqual(this.inOut, kybTransactionOrderInfo.inOut);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public final int hashCode() {
        boolean z = this.offUsMerchant;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((r0 * 31) + this.orderId.hashCode()) * 31) + this.orderType.hashCode()) * 31) + this.orderTitle.hashCode()) * 31) + this.orderTime.hashCode()) * 31) + this.payMoneyAmount.hashCode()) * 31) + this.subOrderStatus.hashCode()) * 31) + this.orderStatus.hashCode()) * 31) + this.productCode.hashCode()) * 31) + this.inOut.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybTransactionOrderInfo(offUsMerchant=");
        sb.append(this.offUsMerchant);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", orderType=");
        sb.append(this.orderType);
        sb.append(", orderTitle=");
        sb.append(this.orderTitle);
        sb.append(", orderTime=");
        sb.append(this.orderTime);
        sb.append(", payMoneyAmount=");
        sb.append(this.payMoneyAmount);
        sb.append(", subOrderStatus=");
        sb.append(this.subOrderStatus);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(", productCode=");
        sb.append(this.productCode);
        sb.append(", inOut=");
        sb.append(this.inOut);
        sb.append(')');
        return sb.toString();
    }

    public KybTransactionOrderInfo(boolean z, String str, String str2, String str3, String str4, MoneyView moneyView, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.offUsMerchant = z;
        this.orderId = str;
        this.orderType = str2;
        this.orderTitle = str3;
        this.orderTime = str4;
        this.payMoneyAmount = moneyView;
        this.subOrderStatus = str5;
        this.orderStatus = str6;
        this.productCode = str7;
        this.inOut = str8;
    }

    @JvmName(name = "getOffUsMerchant")
    public final boolean getOffUsMerchant() {
        return this.offUsMerchant;
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    @JvmName(name = "getOrderType")
    public final String getOrderType() {
        return this.orderType;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    @JvmName(name = "getOrderTime")
    public final String getOrderTime() {
        return this.orderTime;
    }

    @JvmName(name = "getPayMoneyAmount")
    public final MoneyView getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    @JvmName(name = "getSubOrderStatus")
    public final String getSubOrderStatus() {
        return this.subOrderStatus;
    }

    @JvmName(name = "getOrderStatus")
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getInOut")
    public final String getInOut() {
        return this.inOut;
    }
}
