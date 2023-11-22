package id.dana.data.paylater.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "amount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAmount", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "period", "Ljava/lang/Integer;", "getPeriod", "()Ljava/lang/Integer;", "", "recommended", "Ljava/lang/Boolean;", "getRecommended", "()Ljava/lang/Boolean;", "", "Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;", "repaymentInfo", "Ljava/util/List;", "getRepaymentInfo", "()Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentPlanResult {
    private final MoneyViewEntity amount;
    @SerializedName("period")
    private final Integer period;
    private final Boolean recommended;
    private final List<RepaymentInfoResult> repaymentInfo;

    public RepaymentPlanResult(Integer num, MoneyViewEntity moneyViewEntity, List<RepaymentInfoResult> list, Boolean bool) {
        this.period = num;
        this.amount = moneyViewEntity;
        this.repaymentInfo = list;
        this.recommended = bool;
    }

    @JvmName(name = "getPeriod")
    public final Integer getPeriod() {
        return this.period;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    @JvmName(name = "getRepaymentInfo")
    public final List<RepaymentInfoResult> getRepaymentInfo() {
        return this.repaymentInfo;
    }

    @JvmName(name = "getRecommended")
    public final Boolean getRecommended() {
        return this.recommended;
    }
}
