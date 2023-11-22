package id.dana.domain.mybills.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b+\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b,\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b-\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b.\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b/\u0010\b"}, d2 = {"Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "errorMsg", "location", "paidTotalAmount", "totalCount", "totalEstimatedAmount", "totalMonthlyAmount", "totalMonthlyPaid", "totalMonthlyUnpaid", "unpaidTotalAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/Integer;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorMsg", "getLocation", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPaidTotalAmount", "Ljava/lang/Integer;", "getTotalCount", "getTotalEstimatedAmount", "getTotalMonthlyAmount", "getTotalMonthlyPaid", "getTotalMonthlyUnpaid", "getUnpaidTotalAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/Integer;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MyBillsMonthlyAmount implements Serializable {
    private final String errorMsg;
    private final String location;
    private final MoneyView paidTotalAmount;
    private final Integer totalCount;
    private final MoneyView totalEstimatedAmount;
    private final MoneyView totalMonthlyAmount;
    private final Integer totalMonthlyPaid;
    private final Integer totalMonthlyUnpaid;
    private final MoneyView unpaidTotalAmount;

    /* renamed from: component1  reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getPaidTotalAmount() {
        return this.paidTotalAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getTotalEstimatedAmount() {
        return this.totalEstimatedAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getTotalMonthlyAmount() {
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
    public final MoneyView getUnpaidTotalAmount() {
        return this.unpaidTotalAmount;
    }

    public final MyBillsMonthlyAmount copy(String errorMsg, String location, MoneyView paidTotalAmount, Integer totalCount, MoneyView totalEstimatedAmount, MoneyView totalMonthlyAmount, Integer totalMonthlyPaid, Integer totalMonthlyUnpaid, MoneyView unpaidTotalAmount) {
        return new MyBillsMonthlyAmount(errorMsg, location, paidTotalAmount, totalCount, totalEstimatedAmount, totalMonthlyAmount, totalMonthlyPaid, totalMonthlyUnpaid, unpaidTotalAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillsMonthlyAmount) {
            MyBillsMonthlyAmount myBillsMonthlyAmount = (MyBillsMonthlyAmount) other;
            return Intrinsics.areEqual(this.errorMsg, myBillsMonthlyAmount.errorMsg) && Intrinsics.areEqual(this.location, myBillsMonthlyAmount.location) && Intrinsics.areEqual(this.paidTotalAmount, myBillsMonthlyAmount.paidTotalAmount) && Intrinsics.areEqual(this.totalCount, myBillsMonthlyAmount.totalCount) && Intrinsics.areEqual(this.totalEstimatedAmount, myBillsMonthlyAmount.totalEstimatedAmount) && Intrinsics.areEqual(this.totalMonthlyAmount, myBillsMonthlyAmount.totalMonthlyAmount) && Intrinsics.areEqual(this.totalMonthlyPaid, myBillsMonthlyAmount.totalMonthlyPaid) && Intrinsics.areEqual(this.totalMonthlyUnpaid, myBillsMonthlyAmount.totalMonthlyUnpaid) && Intrinsics.areEqual(this.unpaidTotalAmount, myBillsMonthlyAmount.unpaidTotalAmount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.errorMsg;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.location;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyView moneyView = this.paidTotalAmount;
        int hashCode3 = moneyView == null ? 0 : moneyView.hashCode();
        Integer num = this.totalCount;
        int hashCode4 = num == null ? 0 : num.hashCode();
        MoneyView moneyView2 = this.totalEstimatedAmount;
        int hashCode5 = moneyView2 == null ? 0 : moneyView2.hashCode();
        MoneyView moneyView3 = this.totalMonthlyAmount;
        int hashCode6 = moneyView3 == null ? 0 : moneyView3.hashCode();
        Integer num2 = this.totalMonthlyPaid;
        int hashCode7 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.totalMonthlyUnpaid;
        int hashCode8 = num3 == null ? 0 : num3.hashCode();
        MoneyView moneyView4 = this.unpaidTotalAmount;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (moneyView4 != null ? moneyView4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsMonthlyAmount(errorMsg=");
        sb.append(this.errorMsg);
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

    public MyBillsMonthlyAmount(String str, String str2, MoneyView moneyView, Integer num, MoneyView moneyView2, MoneyView moneyView3, Integer num2, Integer num3, MoneyView moneyView4) {
        this.errorMsg = str;
        this.location = str2;
        this.paidTotalAmount = moneyView;
        this.totalCount = num;
        this.totalEstimatedAmount = moneyView2;
        this.totalMonthlyAmount = moneyView3;
        this.totalMonthlyPaid = num2;
        this.totalMonthlyUnpaid = num3;
        this.unpaidTotalAmount = moneyView4;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getPaidTotalAmount")
    public final MoneyView getPaidTotalAmount() {
        return this.paidTotalAmount;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getTotalEstimatedAmount")
    public final MoneyView getTotalEstimatedAmount() {
        return this.totalEstimatedAmount;
    }

    @JvmName(name = "getTotalMonthlyAmount")
    public final MoneyView getTotalMonthlyAmount() {
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
    public final MoneyView getUnpaidTotalAmount() {
        return this.unpaidTotalAmount;
    }
}
