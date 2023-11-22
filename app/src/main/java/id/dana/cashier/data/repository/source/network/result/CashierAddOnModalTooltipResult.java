package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;", "component1", "()Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;", "Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;", "component2", "()Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;", "content", "productInfo", "copy", "(Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;)Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;", "getContent", "Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;", "getProductInfo", "<init>", "(Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalTooltipResult extends BaseRpcResultAphome {
    @SerializedName("content")
    private final TooltipContentResult content;
    private final TooltipProductInfoResult productInfo;

    public static /* synthetic */ CashierAddOnModalTooltipResult copy$default(CashierAddOnModalTooltipResult cashierAddOnModalTooltipResult, TooltipContentResult tooltipContentResult, TooltipProductInfoResult tooltipProductInfoResult, int i, Object obj) {
        if ((i & 1) != 0) {
            tooltipContentResult = cashierAddOnModalTooltipResult.content;
        }
        if ((i & 2) != 0) {
            tooltipProductInfoResult = cashierAddOnModalTooltipResult.productInfo;
        }
        return cashierAddOnModalTooltipResult.copy(tooltipContentResult, tooltipProductInfoResult);
    }

    /* renamed from: component1  reason: from getter */
    public final TooltipContentResult getContent() {
        return this.content;
    }

    /* renamed from: component2  reason: from getter */
    public final TooltipProductInfoResult getProductInfo() {
        return this.productInfo;
    }

    public final CashierAddOnModalTooltipResult copy(TooltipContentResult content, TooltipProductInfoResult productInfo) {
        return new CashierAddOnModalTooltipResult(content, productInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAddOnModalTooltipResult) {
            CashierAddOnModalTooltipResult cashierAddOnModalTooltipResult = (CashierAddOnModalTooltipResult) other;
            return Intrinsics.areEqual(this.content, cashierAddOnModalTooltipResult.content) && Intrinsics.areEqual(this.productInfo, cashierAddOnModalTooltipResult.productInfo);
        }
        return false;
    }

    public final int hashCode() {
        TooltipContentResult tooltipContentResult = this.content;
        int hashCode = tooltipContentResult == null ? 0 : tooltipContentResult.hashCode();
        TooltipProductInfoResult tooltipProductInfoResult = this.productInfo;
        return (hashCode * 31) + (tooltipProductInfoResult != null ? tooltipProductInfoResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalTooltipResult(content=");
        sb.append(this.content);
        sb.append(", productInfo=");
        sb.append(this.productInfo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getContent")
    public final TooltipContentResult getContent() {
        return this.content;
    }

    @JvmName(name = "getProductInfo")
    public final TooltipProductInfoResult getProductInfo() {
        return this.productInfo;
    }

    public CashierAddOnModalTooltipResult(TooltipContentResult tooltipContentResult, TooltipProductInfoResult tooltipProductInfoResult) {
        this.content = tooltipContentResult;
        this.productInfo = tooltipProductInfoResult;
    }
}
