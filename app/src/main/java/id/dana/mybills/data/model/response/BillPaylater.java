package id.dana.mybills.data.model.response;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0088\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b,\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b/\u0010\bR\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b1\u0010\bR\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b3\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b5\u0010\b"}, d2 = {"Lid/dana/mybills/data/model/response/BillPaylater;", "", "", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/domain/nearbyme/model/MoneyView;", "component11", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "billDate", "currentNeedRepayAmount", "debtAmount", "id", "issueDate", "lateFee", "overdueDay", "repaymentDate", "repaymentMonth", "status", "unpaidAmount", "repaidAmount", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/mybills/data/model/response/BillPaylater;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillDate", "Lid/dana/domain/nearbyme/model/MoneyView;", "getCurrentNeedRepayAmount", "getDebtAmount", "getId", "getIssueDate", "getLateFee", "getOverdueDay", "getRepaidAmount", "getRepaymentDate", "getRepaymentMonth", "getStatus", "getUnpaidAmount", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class BillPaylater {
    private final String billDate;
    private final MoneyView currentNeedRepayAmount;
    private final MoneyView debtAmount;
    private final String id;
    private final String issueDate;
    private final MoneyView lateFee;
    private final String overdueDay;
    private final MoneyView repaidAmount;
    private final String repaymentDate;
    private final String repaymentMonth;
    private final String status;
    private final MoneyView unpaidAmount;

    /* renamed from: component1  reason: from getter */
    public final String getBillDate() {
        return this.billDate;
    }

    /* renamed from: component10  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component11  reason: from getter */
    public final MoneyView getUnpaidAmount() {
        return this.unpaidAmount;
    }

    /* renamed from: component12  reason: from getter */
    public final MoneyView getRepaidAmount() {
        return this.repaidAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getCurrentNeedRepayAmount() {
        return this.currentNeedRepayAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getDebtAmount() {
        return this.debtAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIssueDate() {
        return this.issueDate;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getLateFee() {
        return this.lateFee;
    }

    /* renamed from: component7  reason: from getter */
    public final String getOverdueDay() {
        return this.overdueDay;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRepaymentDate() {
        return this.repaymentDate;
    }

    /* renamed from: component9  reason: from getter */
    public final String getRepaymentMonth() {
        return this.repaymentMonth;
    }

    public final BillPaylater copy(String billDate, MoneyView currentNeedRepayAmount, MoneyView debtAmount, String id2, String issueDate, MoneyView lateFee, String overdueDay, String repaymentDate, String repaymentMonth, String status, MoneyView unpaidAmount, MoneyView repaidAmount) {
        Intrinsics.checkNotNullParameter(billDate, "");
        Intrinsics.checkNotNullParameter(currentNeedRepayAmount, "");
        Intrinsics.checkNotNullParameter(debtAmount, "");
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(issueDate, "");
        Intrinsics.checkNotNullParameter(lateFee, "");
        Intrinsics.checkNotNullParameter(overdueDay, "");
        Intrinsics.checkNotNullParameter(repaymentDate, "");
        Intrinsics.checkNotNullParameter(repaymentMonth, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(unpaidAmount, "");
        Intrinsics.checkNotNullParameter(repaidAmount, "");
        return new BillPaylater(billDate, currentNeedRepayAmount, debtAmount, id2, issueDate, lateFee, overdueDay, repaymentDate, repaymentMonth, status, unpaidAmount, repaidAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillPaylater) {
            BillPaylater billPaylater = (BillPaylater) other;
            return Intrinsics.areEqual(this.billDate, billPaylater.billDate) && Intrinsics.areEqual(this.currentNeedRepayAmount, billPaylater.currentNeedRepayAmount) && Intrinsics.areEqual(this.debtAmount, billPaylater.debtAmount) && Intrinsics.areEqual(this.id, billPaylater.id) && Intrinsics.areEqual(this.issueDate, billPaylater.issueDate) && Intrinsics.areEqual(this.lateFee, billPaylater.lateFee) && Intrinsics.areEqual(this.overdueDay, billPaylater.overdueDay) && Intrinsics.areEqual(this.repaymentDate, billPaylater.repaymentDate) && Intrinsics.areEqual(this.repaymentMonth, billPaylater.repaymentMonth) && Intrinsics.areEqual(this.status, billPaylater.status) && Intrinsics.areEqual(this.unpaidAmount, billPaylater.unpaidAmount) && Intrinsics.areEqual(this.repaidAmount, billPaylater.repaidAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.billDate.hashCode() * 31) + this.currentNeedRepayAmount.hashCode()) * 31) + this.debtAmount.hashCode()) * 31) + this.id.hashCode()) * 31) + this.issueDate.hashCode()) * 31) + this.lateFee.hashCode()) * 31) + this.overdueDay.hashCode()) * 31) + this.repaymentDate.hashCode()) * 31) + this.repaymentMonth.hashCode()) * 31) + this.status.hashCode()) * 31) + this.unpaidAmount.hashCode()) * 31) + this.repaidAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillPaylater(billDate=");
        sb.append(this.billDate);
        sb.append(", currentNeedRepayAmount=");
        sb.append(this.currentNeedRepayAmount);
        sb.append(", debtAmount=");
        sb.append(this.debtAmount);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", issueDate=");
        sb.append(this.issueDate);
        sb.append(", lateFee=");
        sb.append(this.lateFee);
        sb.append(", overdueDay=");
        sb.append(this.overdueDay);
        sb.append(", repaymentDate=");
        sb.append(this.repaymentDate);
        sb.append(", repaymentMonth=");
        sb.append(this.repaymentMonth);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", unpaidAmount=");
        sb.append(this.unpaidAmount);
        sb.append(", repaidAmount=");
        sb.append(this.repaidAmount);
        sb.append(')');
        return sb.toString();
    }

    public BillPaylater(String str, MoneyView moneyView, MoneyView moneyView2, String str2, String str3, MoneyView moneyView3, String str4, String str5, String str6, String str7, MoneyView moneyView4, MoneyView moneyView5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(moneyView4, "");
        Intrinsics.checkNotNullParameter(moneyView5, "");
        this.billDate = str;
        this.currentNeedRepayAmount = moneyView;
        this.debtAmount = moneyView2;
        this.id = str2;
        this.issueDate = str3;
        this.lateFee = moneyView3;
        this.overdueDay = str4;
        this.repaymentDate = str5;
        this.repaymentMonth = str6;
        this.status = str7;
        this.unpaidAmount = moneyView4;
        this.repaidAmount = moneyView5;
    }

    public /* synthetic */ BillPaylater(String str, MoneyView moneyView, MoneyView moneyView2, String str2, String str3, MoneyView moneyView3, String str4, String str5, String str6, String str7, MoneyView moneyView4, MoneyView moneyView5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, moneyView, moneyView2, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, moneyView3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, (i & 256) != 0 ? "" : str6, (i & 512) != 0 ? "" : str7, moneyView4, moneyView5);
    }

    @JvmName(name = "getBillDate")
    public final String getBillDate() {
        return this.billDate;
    }

    @JvmName(name = "getCurrentNeedRepayAmount")
    public final MoneyView getCurrentNeedRepayAmount() {
        return this.currentNeedRepayAmount;
    }

    @JvmName(name = "getDebtAmount")
    public final MoneyView getDebtAmount() {
        return this.debtAmount;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getIssueDate")
    public final String getIssueDate() {
        return this.issueDate;
    }

    @JvmName(name = "getLateFee")
    public final MoneyView getLateFee() {
        return this.lateFee;
    }

    @JvmName(name = "getOverdueDay")
    public final String getOverdueDay() {
        return this.overdueDay;
    }

    @JvmName(name = "getRepaymentDate")
    public final String getRepaymentDate() {
        return this.repaymentDate;
    }

    @JvmName(name = "getRepaymentMonth")
    public final String getRepaymentMonth() {
        return this.repaymentMonth;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getUnpaidAmount")
    public final MoneyView getUnpaidAmount() {
        return this.unpaidAmount;
    }

    @JvmName(name = "getRepaidAmount")
    public final MoneyView getRepaidAmount() {
        return this.repaidAmount;
    }
}
