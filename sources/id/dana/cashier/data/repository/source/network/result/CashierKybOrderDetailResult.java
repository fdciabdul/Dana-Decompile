package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b \u0010\b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component1", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "additionalFee", "amount", "checkOutUrl", CashierKeyParams.TOTAL_AMOUNT, "orderTitle", "copy", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAdditionalFee", "getAmount", "Ljava/lang/String;", "getCheckOutUrl", "getOrderAmount", CashierKeyParams.GET_ORDER_TITLE, "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierKybOrderDetailResult {
    @SerializedName("additionalFee")
    private final MoneyViewEntity additionalFee;
    private final MoneyViewEntity amount;
    private final String checkOutUrl;
    private final MoneyViewEntity orderAmount;
    private final String orderTitle;

    public static /* synthetic */ CashierKybOrderDetailResult copy$default(CashierKybOrderDetailResult cashierKybOrderDetailResult, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str, MoneyViewEntity moneyViewEntity3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyViewEntity = cashierKybOrderDetailResult.additionalFee;
        }
        if ((i & 2) != 0) {
            moneyViewEntity2 = cashierKybOrderDetailResult.amount;
        }
        MoneyViewEntity moneyViewEntity4 = moneyViewEntity2;
        if ((i & 4) != 0) {
            str = cashierKybOrderDetailResult.checkOutUrl;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            moneyViewEntity3 = cashierKybOrderDetailResult.orderAmount;
        }
        MoneyViewEntity moneyViewEntity5 = moneyViewEntity3;
        if ((i & 16) != 0) {
            str2 = cashierKybOrderDetailResult.orderTitle;
        }
        return cashierKybOrderDetailResult.copy(moneyViewEntity, moneyViewEntity4, str3, moneyViewEntity5, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyViewEntity getAdditionalFee() {
        return this.additionalFee;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCheckOutUrl() {
        return this.checkOutUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getOrderAmount() {
        return this.orderAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    public final CashierKybOrderDetailResult copy(MoneyViewEntity additionalFee, MoneyViewEntity amount, String checkOutUrl, MoneyViewEntity orderAmount, String orderTitle) {
        return new CashierKybOrderDetailResult(additionalFee, amount, checkOutUrl, orderAmount, orderTitle);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierKybOrderDetailResult) {
            CashierKybOrderDetailResult cashierKybOrderDetailResult = (CashierKybOrderDetailResult) other;
            return Intrinsics.areEqual(this.additionalFee, cashierKybOrderDetailResult.additionalFee) && Intrinsics.areEqual(this.amount, cashierKybOrderDetailResult.amount) && Intrinsics.areEqual(this.checkOutUrl, cashierKybOrderDetailResult.checkOutUrl) && Intrinsics.areEqual(this.orderAmount, cashierKybOrderDetailResult.orderAmount) && Intrinsics.areEqual(this.orderTitle, cashierKybOrderDetailResult.orderTitle);
        }
        return false;
    }

    public final int hashCode() {
        MoneyViewEntity moneyViewEntity = this.additionalFee;
        int hashCode = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.amount;
        int hashCode2 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        String str = this.checkOutUrl;
        int hashCode3 = str == null ? 0 : str.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.orderAmount;
        int hashCode4 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        String str2 = this.orderTitle;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierKybOrderDetailResult(additionalFee=");
        sb.append(this.additionalFee);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", checkOutUrl=");
        sb.append(this.checkOutUrl);
        sb.append(", orderAmount=");
        sb.append(this.orderAmount);
        sb.append(", orderTitle=");
        sb.append(this.orderTitle);
        sb.append(')');
        return sb.toString();
    }

    public CashierKybOrderDetailResult(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str, MoneyViewEntity moneyViewEntity3, String str2) {
        this.additionalFee = moneyViewEntity;
        this.amount = moneyViewEntity2;
        this.checkOutUrl = str;
        this.orderAmount = moneyViewEntity3;
        this.orderTitle = str2;
    }

    @JvmName(name = "getAdditionalFee")
    public final MoneyViewEntity getAdditionalFee() {
        return this.additionalFee;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCheckOutUrl")
    public final String getCheckOutUrl() {
        return this.checkOutUrl;
    }

    @JvmName(name = "getOrderAmount")
    public final MoneyViewEntity getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }
}
