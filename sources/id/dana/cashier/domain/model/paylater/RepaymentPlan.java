package id.dana.cashier.domain.model.paylater;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "amount", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAmount", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "period", "Ljava/lang/Integer;", "getPeriod", "()Ljava/lang/Integer;", "", "recommended", "Ljava/lang/Boolean;", "getRecommended", "()Ljava/lang/Boolean;", "", "Lid/dana/cashier/domain/model/paylater/RepaymentInfo;", "repaymentInfos", "Ljava/util/List;", "getRepaymentInfos", "()Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentPlan {
    private final MoneyView amount;
    private final Integer period;
    private final Boolean recommended;
    private final List<RepaymentInfo> repaymentInfos;

    public RepaymentPlan(Integer num, MoneyView moneyView, List<RepaymentInfo> list, Boolean bool) {
        this.period = num;
        this.amount = moneyView;
        this.repaymentInfos = list;
        this.recommended = bool;
    }

    @JvmName(name = "getPeriod")
    public final Integer getPeriod() {
        return this.period;
    }

    @JvmName(name = "getAmount")
    public final MoneyView getAmount() {
        return this.amount;
    }

    @JvmName(name = "getRepaymentInfos")
    public final List<RepaymentInfo> getRepaymentInfos() {
        return this.repaymentInfos;
    }

    @JvmName(name = "getRecommended")
    public final Boolean getRecommended() {
        return this.recommended;
    }
}
