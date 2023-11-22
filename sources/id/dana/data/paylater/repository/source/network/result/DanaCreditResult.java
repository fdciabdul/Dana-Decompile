package id.dana.data.paylater.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "availableQuota", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAvailableQuota", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "initCreditQuota", "getInitCreditQuota", "", CashierKeyParams.INSTALLMENT_PLAN_ID, "Ljava/lang/String;", "getInstallmentPlanId", "()Ljava/lang/String;", "totalAmount", "getTotalAmount", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCreditResult {
    @SerializedName("availableQuota")
    private final MoneyViewEntity availableQuota;
    @SerializedName("initCreditQuota")
    private final MoneyViewEntity initCreditQuota;
    @SerializedName(CashierKeyParams.INSTALLMENT_PLAN_ID)
    private final String installmentPlanId;
    @SerializedName("totalAmount")
    private final MoneyViewEntity totalAmount;

    public DanaCreditResult(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str, MoneyViewEntity moneyViewEntity3) {
        this.availableQuota = moneyViewEntity;
        this.initCreditQuota = moneyViewEntity2;
        this.installmentPlanId = str;
        this.totalAmount = moneyViewEntity3;
    }

    @JvmName(name = "getAvailableQuota")
    public final MoneyViewEntity getAvailableQuota() {
        return this.availableQuota;
    }

    @JvmName(name = "getInitCreditQuota")
    public final MoneyViewEntity getInitCreditQuota() {
        return this.initCreditQuota;
    }

    @JvmName(name = "getInstallmentPlanId")
    public final String getInstallmentPlanId() {
        return this.installmentPlanId;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewEntity getTotalAmount() {
        return this.totalAmount;
    }
}
