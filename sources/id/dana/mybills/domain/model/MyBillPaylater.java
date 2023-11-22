package id.dana.mybills.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b"}, d2 = {"Lid/dana/mybills/domain/model/MyBillPaylater;", "", "", "billDate", "Ljava/lang/String;", "getBillDate", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "currentNeedRepayAmount", "Lid/dana/domain/nearbyme/model/MoneyView;", "getCurrentNeedRepayAmount", "()Lid/dana/domain/nearbyme/model/MoneyView;", "debtAmount", "getDebtAmount", "id", "getId", "issueDate", "getIssueDate", "lateFee", "getLateFee", "overdueDay", "getOverdueDay", "repaidAmount", "getRepaidAmount", "repaymentDate", "getRepaymentDate", "repaymentMonth", "getRepaymentMonth", "status", "getStatus", "unpaidAmount", "getUnpaidAmount", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillPaylater {
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

    public MyBillPaylater(String str, MoneyView moneyView, MoneyView moneyView2, String str2, String str3, MoneyView moneyView3, String str4, String str5, String str6, String str7, MoneyView moneyView4, MoneyView moneyView5) {
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

    public /* synthetic */ MyBillPaylater(String str, MoneyView moneyView, MoneyView moneyView2, String str2, String str3, MoneyView moneyView3, String str4, String str5, String str6, String str7, MoneyView moneyView4, MoneyView moneyView5, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
