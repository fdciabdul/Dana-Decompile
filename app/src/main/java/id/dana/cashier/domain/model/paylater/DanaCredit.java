package id.dana.cashier.domain.model.paylater;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/paylater/DanaCredit;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "availableQuota", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAvailableQuota", "()Lid/dana/domain/nearbyme/model/MoneyView;", "initCreditQuota", "getInitCreditQuota", "", CashierKeyParams.INSTALLMENT_PLAN_ID, "Ljava/lang/String;", "getInstallmentPlanId", "()Ljava/lang/String;", "totalAmount", "getTotalAmount", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCredit {
    private final MoneyView availableQuota;
    private final MoneyView initCreditQuota;
    private final String installmentPlanId;
    private final MoneyView totalAmount;

    public DanaCredit(MoneyView moneyView, MoneyView moneyView2, String str, MoneyView moneyView3) {
        this.availableQuota = moneyView;
        this.initCreditQuota = moneyView2;
        this.installmentPlanId = str;
        this.totalAmount = moneyView3;
    }

    @JvmName(name = "getAvailableQuota")
    public final MoneyView getAvailableQuota() {
        return this.availableQuota;
    }

    @JvmName(name = "getInitCreditQuota")
    public final MoneyView getInitCreditQuota() {
        return this.initCreditQuota;
    }

    @JvmName(name = "getInstallmentPlanId")
    public final String getInstallmentPlanId() {
        return this.installmentPlanId;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }
}
