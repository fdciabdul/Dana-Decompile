package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\t"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "goodsId", "goodsType", "category", "stackInsurance", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "getGoodsId", "getGoodsType", "Ljava/lang/Boolean;", "getStackInsurance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalTooltipRequest {
    private final String category;
    private final String goodsId;
    private final String goodsType;
    private final Boolean stackInsurance;

    public static /* synthetic */ CashierAddOnModalTooltipRequest copy$default(CashierAddOnModalTooltipRequest cashierAddOnModalTooltipRequest, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierAddOnModalTooltipRequest.goodsId;
        }
        if ((i & 2) != 0) {
            str2 = cashierAddOnModalTooltipRequest.goodsType;
        }
        if ((i & 4) != 0) {
            str3 = cashierAddOnModalTooltipRequest.category;
        }
        if ((i & 8) != 0) {
            bool = cashierAddOnModalTooltipRequest.stackInsurance;
        }
        return cashierAddOnModalTooltipRequest.copy(str, str2, str3, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }

    public final CashierAddOnModalTooltipRequest copy(String goodsId, String goodsType, String category, Boolean stackInsurance) {
        return new CashierAddOnModalTooltipRequest(goodsId, goodsType, category, stackInsurance);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAddOnModalTooltipRequest) {
            CashierAddOnModalTooltipRequest cashierAddOnModalTooltipRequest = (CashierAddOnModalTooltipRequest) other;
            return Intrinsics.areEqual(this.goodsId, cashierAddOnModalTooltipRequest.goodsId) && Intrinsics.areEqual(this.goodsType, cashierAddOnModalTooltipRequest.goodsType) && Intrinsics.areEqual(this.category, cashierAddOnModalTooltipRequest.category) && Intrinsics.areEqual(this.stackInsurance, cashierAddOnModalTooltipRequest.stackInsurance);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.goodsId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.goodsType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.category;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.stackInsurance;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalTooltipRequest(goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", category=");
        sb.append(this.category);
        sb.append(", stackInsurance=");
        sb.append(this.stackInsurance);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnModalTooltipRequest(String str, String str2, String str3, Boolean bool) {
        this.goodsId = str;
        this.goodsType = str2;
        this.category = str3;
        this.stackInsurance = bool;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "getStackInsurance")
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }
}
