package id.dana.explore.data.sku.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/BillAmountDetail;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component2", "()Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component3", "period", "amount", "displayAmount", "copy", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;)Lid/dana/explore/data/sku/repository/source/network/response/BillAmountDetail;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "getAmount", "getDisplayAmount", "Ljava/lang/String;", "getPeriod", "<init>", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillAmountDetail implements Serializable {
    @SerializedName("amount")
    private final MultiCurrencyMoney amount;
    @SerializedName("displayAmount")
    private final MultiCurrencyMoney displayAmount;
    @SerializedName("period")
    private final String period;

    public BillAmountDetail() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BillAmountDetail copy$default(BillAmountDetail billAmountDetail, String str, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billAmountDetail.period;
        }
        if ((i & 2) != 0) {
            multiCurrencyMoney = billAmountDetail.amount;
        }
        if ((i & 4) != 0) {
            multiCurrencyMoney2 = billAmountDetail.displayAmount;
        }
        return billAmountDetail.copy(str, multiCurrencyMoney, multiCurrencyMoney2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    /* renamed from: component2  reason: from getter */
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    /* renamed from: component3  reason: from getter */
    public final MultiCurrencyMoney getDisplayAmount() {
        return this.displayAmount;
    }

    public final BillAmountDetail copy(String period, MultiCurrencyMoney amount, MultiCurrencyMoney displayAmount) {
        return new BillAmountDetail(period, amount, displayAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillAmountDetail) {
            BillAmountDetail billAmountDetail = (BillAmountDetail) other;
            return Intrinsics.areEqual(this.period, billAmountDetail.period) && Intrinsics.areEqual(this.amount, billAmountDetail.amount) && Intrinsics.areEqual(this.displayAmount, billAmountDetail.displayAmount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.period;
        int hashCode = str == null ? 0 : str.hashCode();
        MultiCurrencyMoney multiCurrencyMoney = this.amount;
        int hashCode2 = multiCurrencyMoney == null ? 0 : multiCurrencyMoney.hashCode();
        MultiCurrencyMoney multiCurrencyMoney2 = this.displayAmount;
        return (((hashCode * 31) + hashCode2) * 31) + (multiCurrencyMoney2 != null ? multiCurrencyMoney2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillAmountDetail(period=");
        sb.append(this.period);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", displayAmount=");
        sb.append(this.displayAmount);
        sb.append(')');
        return sb.toString();
    }

    public BillAmountDetail(String str, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2) {
        this.period = str;
        this.amount = multiCurrencyMoney;
        this.displayAmount = multiCurrencyMoney2;
    }

    public /* synthetic */ BillAmountDetail(String str, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : multiCurrencyMoney, (i & 4) != 0 ? null : multiCurrencyMoney2);
    }

    @JvmName(name = "getPeriod")
    public final String getPeriod() {
        return this.period;
    }

    @JvmName(name = "getAmount")
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    @JvmName(name = "getDisplayAmount")
    public final MultiCurrencyMoney getDisplayAmount() {
        return this.displayAmount;
    }
}
