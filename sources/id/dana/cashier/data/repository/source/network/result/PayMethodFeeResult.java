package id.dana.cashier.data.repository.source.network.result;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/PayMethodFeeResult;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "chargeAmount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getChargeAmount", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "chargeType", "Ljava/lang/String;", "getChargeType", "()Ljava/lang/String;", "fixedAmount", "getFixedAmount", "payMethod", "getPayMethod", "ratio", "getRatio", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayMethodFeeResult {
    private final MoneyViewEntity chargeAmount;
    private final String chargeType;
    private final MoneyViewEntity fixedAmount;
    private final String payMethod;
    private final String ratio;

    public PayMethodFeeResult(String str, MoneyViewEntity moneyViewEntity, String str2, MoneyViewEntity moneyViewEntity2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.payMethod = str;
        this.fixedAmount = moneyViewEntity;
        this.ratio = str2;
        this.chargeAmount = moneyViewEntity2;
        this.chargeType = str3;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getFixedAmount")
    public final MoneyViewEntity getFixedAmount() {
        return this.fixedAmount;
    }

    @JvmName(name = "getRatio")
    public final String getRatio() {
        return this.ratio;
    }

    @JvmName(name = "getChargeAmount")
    public final MoneyViewEntity getChargeAmount() {
        return this.chargeAmount;
    }

    @JvmName(name = "getChargeType")
    public final String getChargeType() {
        return this.chargeType;
    }
}
