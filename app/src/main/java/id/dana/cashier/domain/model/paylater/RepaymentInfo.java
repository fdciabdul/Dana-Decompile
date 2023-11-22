package id.dana.cashier.domain.model.paylater;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "interestFeeAmount", "Lid/dana/domain/nearbyme/model/MoneyView;", "getInterestFeeAmount", "()Lid/dana/domain/nearbyme/model/MoneyView;", "lateFeeAmount", "getLateFeeAmount", "principalAmount", "getPrincipalAmount", "repaymentAmount", "getRepaymentAmount", "repaymentAmountWithFee", "getRepaymentAmountWithFee", "", "repaymentDueDate", "Ljava/lang/String;", "getRepaymentDueDate", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentInfo {
    private final MoneyView interestFeeAmount;
    private final MoneyView lateFeeAmount;
    private final MoneyView principalAmount;
    private final MoneyView repaymentAmount;
    private final MoneyView repaymentAmountWithFee;
    private final String repaymentDueDate;

    public RepaymentInfo(String str, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, MoneyView moneyView5) {
        Intrinsics.checkNotNullParameter(str, "");
        this.repaymentDueDate = str;
        this.repaymentAmount = moneyView;
        this.repaymentAmountWithFee = moneyView2;
        this.principalAmount = moneyView3;
        this.interestFeeAmount = moneyView4;
        this.lateFeeAmount = moneyView5;
    }

    public /* synthetic */ RepaymentInfo(String str, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, MoneyView moneyView5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, moneyView, moneyView2, moneyView3, moneyView4, moneyView5);
    }

    @JvmName(name = "getRepaymentDueDate")
    public final String getRepaymentDueDate() {
        return this.repaymentDueDate;
    }

    @JvmName(name = "getRepaymentAmount")
    public final MoneyView getRepaymentAmount() {
        return this.repaymentAmount;
    }

    @JvmName(name = "getRepaymentAmountWithFee")
    public final MoneyView getRepaymentAmountWithFee() {
        return this.repaymentAmountWithFee;
    }

    @JvmName(name = "getPrincipalAmount")
    public final MoneyView getPrincipalAmount() {
        return this.principalAmount;
    }

    @JvmName(name = "getInterestFeeAmount")
    public final MoneyView getInterestFeeAmount() {
        return this.interestFeeAmount;
    }

    @JvmName(name = "getLateFeeAmount")
    public final MoneyView getLateFeeAmount() {
        return this.lateFeeAmount;
    }
}
