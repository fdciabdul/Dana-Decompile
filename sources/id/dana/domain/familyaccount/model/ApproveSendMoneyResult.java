package id.dana.domain.familyaccount.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "Lid/dana/domain/familyaccount/model/AttributesResult;", "component4", "()Lid/dana/domain/familyaccount/model/AttributesResult;", "fundOrderId", "fundAmount", CashierKeyParams.CASHIER_ORDER_ID, "attributes", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Lid/dana/domain/familyaccount/model/AttributesResult;)Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/familyaccount/model/AttributesResult;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "Lid/dana/domain/nearbyme/model/MoneyView;", "getFundAmount", "getFundOrderId", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Lid/dana/domain/familyaccount/model/AttributesResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ApproveSendMoneyResult {
    private final AttributesResult attributes;
    private final String cashierOrderId;
    private final MoneyView fundAmount;
    private final String fundOrderId;

    public static /* synthetic */ ApproveSendMoneyResult copy$default(ApproveSendMoneyResult approveSendMoneyResult, String str, MoneyView moneyView, String str2, AttributesResult attributesResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = approveSendMoneyResult.fundOrderId;
        }
        if ((i & 2) != 0) {
            moneyView = approveSendMoneyResult.fundAmount;
        }
        if ((i & 4) != 0) {
            str2 = approveSendMoneyResult.cashierOrderId;
        }
        if ((i & 8) != 0) {
            attributesResult = approveSendMoneyResult.attributes;
        }
        return approveSendMoneyResult.copy(str, moneyView, str2, attributesResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getFundAmount() {
        return this.fundAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component4  reason: from getter */
    public final AttributesResult getAttributes() {
        return this.attributes;
    }

    public final ApproveSendMoneyResult copy(String fundOrderId, MoneyView fundAmount, String cashierOrderId, AttributesResult attributes) {
        Intrinsics.checkNotNullParameter(fundOrderId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(attributes, "");
        return new ApproveSendMoneyResult(fundOrderId, fundAmount, cashierOrderId, attributes);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ApproveSendMoneyResult) {
            ApproveSendMoneyResult approveSendMoneyResult = (ApproveSendMoneyResult) other;
            return Intrinsics.areEqual(this.fundOrderId, approveSendMoneyResult.fundOrderId) && Intrinsics.areEqual(this.fundAmount, approveSendMoneyResult.fundAmount) && Intrinsics.areEqual(this.cashierOrderId, approveSendMoneyResult.cashierOrderId) && Intrinsics.areEqual(this.attributes, approveSendMoneyResult.attributes);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.fundOrderId.hashCode() * 31) + this.fundAmount.hashCode()) * 31) + this.cashierOrderId.hashCode()) * 31) + this.attributes.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApproveSendMoneyResult(fundOrderId=");
        sb.append(this.fundOrderId);
        sb.append(", fundAmount=");
        sb.append(this.fundAmount);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(')');
        return sb.toString();
    }

    public ApproveSendMoneyResult(String str, MoneyView moneyView, String str2, AttributesResult attributesResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(attributesResult, "");
        this.fundOrderId = str;
        this.fundAmount = moneyView;
        this.cashierOrderId = str2;
        this.attributes = attributesResult;
    }

    @JvmName(name = "getFundOrderId")
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    @JvmName(name = "getFundAmount")
    public final MoneyView getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getAttributes")
    public final AttributesResult getAttributes() {
        return this.attributes;
    }
}
