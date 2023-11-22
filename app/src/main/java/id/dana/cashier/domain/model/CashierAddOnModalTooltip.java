package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "", "Lid/dana/cashier/domain/model/TooltipContent;", "component1", "()Lid/dana/cashier/domain/model/TooltipContent;", "Lid/dana/cashier/domain/model/TooltipProductInfo;", "component2", "()Lid/dana/cashier/domain/model/TooltipProductInfo;", "content", "productInfo", "copy", "(Lid/dana/cashier/domain/model/TooltipContent;Lid/dana/cashier/domain/model/TooltipProductInfo;)Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/cashier/domain/model/TooltipContent;", "getContent", "Lid/dana/cashier/domain/model/TooltipProductInfo;", "getProductInfo", "<init>", "(Lid/dana/cashier/domain/model/TooltipContent;Lid/dana/cashier/domain/model/TooltipProductInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalTooltip {
    private final TooltipContent content;
    private final TooltipProductInfo productInfo;

    public static /* synthetic */ CashierAddOnModalTooltip copy$default(CashierAddOnModalTooltip cashierAddOnModalTooltip, TooltipContent tooltipContent, TooltipProductInfo tooltipProductInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            tooltipContent = cashierAddOnModalTooltip.content;
        }
        if ((i & 2) != 0) {
            tooltipProductInfo = cashierAddOnModalTooltip.productInfo;
        }
        return cashierAddOnModalTooltip.copy(tooltipContent, tooltipProductInfo);
    }

    /* renamed from: component1  reason: from getter */
    public final TooltipContent getContent() {
        return this.content;
    }

    /* renamed from: component2  reason: from getter */
    public final TooltipProductInfo getProductInfo() {
        return this.productInfo;
    }

    public final CashierAddOnModalTooltip copy(TooltipContent content, TooltipProductInfo productInfo) {
        return new CashierAddOnModalTooltip(content, productInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAddOnModalTooltip) {
            CashierAddOnModalTooltip cashierAddOnModalTooltip = (CashierAddOnModalTooltip) other;
            return Intrinsics.areEqual(this.content, cashierAddOnModalTooltip.content) && Intrinsics.areEqual(this.productInfo, cashierAddOnModalTooltip.productInfo);
        }
        return false;
    }

    public final int hashCode() {
        TooltipContent tooltipContent = this.content;
        int hashCode = tooltipContent == null ? 0 : tooltipContent.hashCode();
        TooltipProductInfo tooltipProductInfo = this.productInfo;
        return (hashCode * 31) + (tooltipProductInfo != null ? tooltipProductInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalTooltip(content=");
        sb.append(this.content);
        sb.append(", productInfo=");
        sb.append(this.productInfo);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnModalTooltip(TooltipContent tooltipContent, TooltipProductInfo tooltipProductInfo) {
        this.content = tooltipContent;
        this.productInfo = tooltipProductInfo;
    }

    @JvmName(name = "getContent")
    public final TooltipContent getContent() {
        return this.content;
    }

    @JvmName(name = "getProductInfo")
    public final TooltipProductInfo getProductInfo() {
        return this.productInfo;
    }
}
