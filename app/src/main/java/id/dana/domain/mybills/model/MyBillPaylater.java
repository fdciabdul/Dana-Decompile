package id.dana.domain.mybills.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/domain/mybills/model/MyBillPaylater;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "lateFee", "Lid/dana/domain/nearbyme/model/MoneyView;", "getLateFee", "()Lid/dana/domain/nearbyme/model/MoneyView;", "repaymentDate", "getRepaymentDate", "status", "getStatus", "unpaidAmount", "getUnpaidAmount", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MyBillPaylater {
    private final String id;
    private final MoneyView lateFee;
    private final String repaymentDate;
    private final String status;
    private final MoneyView unpaidAmount;

    public MyBillPaylater(String str, MoneyView moneyView, String str2, String str3, MoneyView moneyView2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        this.id = str;
        this.lateFee = moneyView;
        this.repaymentDate = str2;
        this.status = str3;
        this.unpaidAmount = moneyView2;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getLateFee")
    public final MoneyView getLateFee() {
        return this.lateFee;
    }

    @JvmName(name = "getRepaymentDate")
    public final String getRepaymentDate() {
        return this.repaymentDate;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getUnpaidAmount")
    public final MoneyView getUnpaidAmount() {
        return this.unpaidAmount;
    }
}
