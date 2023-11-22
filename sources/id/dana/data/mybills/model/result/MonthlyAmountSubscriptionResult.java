package id.dana.data.mybills.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b+\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b,\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b-\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b.\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b/\u0010\b"}, d2 = {"Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "interaction", "location", "paidTotalAmount", "totalCount", "totalEstimatedAmount", "totalMonthlyAmount", "totalMonthlyPaid", "totalMonthlyUnpaid", "unpaidTotalAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Integer;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getInteraction", "getLocation", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getPaidTotalAmount", "Ljava/lang/Integer;", "getTotalCount", "getTotalEstimatedAmount", "getTotalMonthlyAmount", "getTotalMonthlyPaid", "getTotalMonthlyUnpaid", "getUnpaidTotalAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Integer;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MonthlyAmountSubscriptionResult extends BaseRpcResult {
    private final String interaction;
    private final String location;
    private final MoneyViewEntity paidTotalAmount;
    private final Integer totalCount;
    private final MoneyViewEntity totalEstimatedAmount;
    private final MoneyViewEntity totalMonthlyAmount;
    private final Integer totalMonthlyPaid;
    private final Integer totalMonthlyUnpaid;
    private final MoneyViewEntity unpaidTotalAmount;

    /* renamed from: component1  reason: from getter */
    public final String getInteraction() {
        return this.interaction;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getPaidTotalAmount() {
        return this.paidTotalAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getTotalEstimatedAmount() {
        return this.totalEstimatedAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyViewEntity getTotalMonthlyAmount() {
        return this.totalMonthlyAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getTotalMonthlyPaid() {
        return this.totalMonthlyPaid;
    }

    /* renamed from: component8  reason: from getter */
    public final Integer getTotalMonthlyUnpaid() {
        return this.totalMonthlyUnpaid;
    }

    /* renamed from: component9  reason: from getter */
    public final MoneyViewEntity getUnpaidTotalAmount() {
        return this.unpaidTotalAmount;
    }

    public final MonthlyAmountSubscriptionResult copy(String interaction, String location, MoneyViewEntity paidTotalAmount, Integer totalCount, MoneyViewEntity totalEstimatedAmount, MoneyViewEntity totalMonthlyAmount, Integer totalMonthlyPaid, Integer totalMonthlyUnpaid, MoneyViewEntity unpaidTotalAmount) {
        return new MonthlyAmountSubscriptionResult(interaction, location, paidTotalAmount, totalCount, totalEstimatedAmount, totalMonthlyAmount, totalMonthlyPaid, totalMonthlyUnpaid, unpaidTotalAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MonthlyAmountSubscriptionResult) {
            MonthlyAmountSubscriptionResult monthlyAmountSubscriptionResult = (MonthlyAmountSubscriptionResult) other;
            return Intrinsics.areEqual(this.interaction, monthlyAmountSubscriptionResult.interaction) && Intrinsics.areEqual(this.location, monthlyAmountSubscriptionResult.location) && Intrinsics.areEqual(this.paidTotalAmount, monthlyAmountSubscriptionResult.paidTotalAmount) && Intrinsics.areEqual(this.totalCount, monthlyAmountSubscriptionResult.totalCount) && Intrinsics.areEqual(this.totalEstimatedAmount, monthlyAmountSubscriptionResult.totalEstimatedAmount) && Intrinsics.areEqual(this.totalMonthlyAmount, monthlyAmountSubscriptionResult.totalMonthlyAmount) && Intrinsics.areEqual(this.totalMonthlyPaid, monthlyAmountSubscriptionResult.totalMonthlyPaid) && Intrinsics.areEqual(this.totalMonthlyUnpaid, monthlyAmountSubscriptionResult.totalMonthlyUnpaid) && Intrinsics.areEqual(this.unpaidTotalAmount, monthlyAmountSubscriptionResult.unpaidTotalAmount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.interaction;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.location;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyViewEntity moneyViewEntity = this.paidTotalAmount;
        int hashCode3 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        Integer num = this.totalCount;
        int hashCode4 = num == null ? 0 : num.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.totalEstimatedAmount;
        int hashCode5 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.totalMonthlyAmount;
        int hashCode6 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        Integer num2 = this.totalMonthlyPaid;
        int hashCode7 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.totalMonthlyUnpaid;
        int hashCode8 = num3 == null ? 0 : num3.hashCode();
        MoneyViewEntity moneyViewEntity4 = this.unpaidTotalAmount;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (moneyViewEntity4 != null ? moneyViewEntity4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MonthlyAmountSubscriptionResult(interaction=");
        sb.append(this.interaction);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", paidTotalAmount=");
        sb.append(this.paidTotalAmount);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", totalEstimatedAmount=");
        sb.append(this.totalEstimatedAmount);
        sb.append(", totalMonthlyAmount=");
        sb.append(this.totalMonthlyAmount);
        sb.append(", totalMonthlyPaid=");
        sb.append(this.totalMonthlyPaid);
        sb.append(", totalMonthlyUnpaid=");
        sb.append(this.totalMonthlyUnpaid);
        sb.append(", unpaidTotalAmount=");
        sb.append(this.unpaidTotalAmount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getInteraction")
    public final String getInteraction() {
        return this.interaction;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getPaidTotalAmount")
    public final MoneyViewEntity getPaidTotalAmount() {
        return this.paidTotalAmount;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getTotalEstimatedAmount")
    public final MoneyViewEntity getTotalEstimatedAmount() {
        return this.totalEstimatedAmount;
    }

    @JvmName(name = "getTotalMonthlyAmount")
    public final MoneyViewEntity getTotalMonthlyAmount() {
        return this.totalMonthlyAmount;
    }

    @JvmName(name = "getTotalMonthlyPaid")
    public final Integer getTotalMonthlyPaid() {
        return this.totalMonthlyPaid;
    }

    @JvmName(name = "getTotalMonthlyUnpaid")
    public final Integer getTotalMonthlyUnpaid() {
        return this.totalMonthlyUnpaid;
    }

    @JvmName(name = "getUnpaidTotalAmount")
    public final MoneyViewEntity getUnpaidTotalAmount() {
        return this.unpaidTotalAmount;
    }

    public MonthlyAmountSubscriptionResult(String str, String str2, MoneyViewEntity moneyViewEntity, Integer num, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, Integer num2, Integer num3, MoneyViewEntity moneyViewEntity4) {
        this.interaction = str;
        this.location = str2;
        this.paidTotalAmount = moneyViewEntity;
        this.totalCount = num;
        this.totalEstimatedAmount = moneyViewEntity2;
        this.totalMonthlyAmount = moneyViewEntity3;
        this.totalMonthlyPaid = num2;
        this.totalMonthlyUnpaid = num3;
        this.unpaidTotalAmount = moneyViewEntity4;
    }
}
