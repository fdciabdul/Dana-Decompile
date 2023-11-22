package id.dana.data.paylater.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/RepaymentInfoResult;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "interestFeeAmount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getInterestFeeAmount", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "lateFeeAmount", "getLateFeeAmount", "principalAmount", "getPrincipalAmount", "repaymentAmount", "getRepaymentAmount", "repaymentAmountWithFee", "getRepaymentAmountWithFee", "", "repaymentDueDate", "Ljava/lang/String;", "getRepaymentDueDate", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepaymentInfoResult {
    private final MoneyViewEntity interestFeeAmount;
    private final MoneyViewEntity lateFeeAmount;
    private final MoneyViewEntity principalAmount;
    private final MoneyViewEntity repaymentAmount;
    private final MoneyViewEntity repaymentAmountWithFee;
    @SerializedName("repaymentDueDate")
    private final String repaymentDueDate;

    public RepaymentInfoResult(String str, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, MoneyViewEntity moneyViewEntity5) {
        this.repaymentDueDate = str;
        this.repaymentAmount = moneyViewEntity;
        this.repaymentAmountWithFee = moneyViewEntity2;
        this.principalAmount = moneyViewEntity3;
        this.interestFeeAmount = moneyViewEntity4;
        this.lateFeeAmount = moneyViewEntity5;
    }

    @JvmName(name = "getRepaymentDueDate")
    public final String getRepaymentDueDate() {
        return this.repaymentDueDate;
    }

    @JvmName(name = "getRepaymentAmount")
    public final MoneyViewEntity getRepaymentAmount() {
        return this.repaymentAmount;
    }

    @JvmName(name = "getRepaymentAmountWithFee")
    public final MoneyViewEntity getRepaymentAmountWithFee() {
        return this.repaymentAmountWithFee;
    }

    @JvmName(name = "getPrincipalAmount")
    public final MoneyViewEntity getPrincipalAmount() {
        return this.principalAmount;
    }

    @JvmName(name = "getInterestFeeAmount")
    public final MoneyViewEntity getInterestFeeAmount() {
        return this.interestFeeAmount;
    }

    @JvmName(name = "getLateFeeAmount")
    public final MoneyViewEntity getLateFeeAmount() {
        return this.lateFeeAmount;
    }
}
