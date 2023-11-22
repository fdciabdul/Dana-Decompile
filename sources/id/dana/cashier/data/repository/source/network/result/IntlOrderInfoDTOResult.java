package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/IntlOrderInfoDTOResult;", "", "", "exchangeDate", "Ljava/lang/String;", "getExchangeDate", "()Ljava/lang/String;", "Lid/dana/cashier/data/repository/source/network/result/ExchangeRateResult;", CashierKeyParams.EXCHANGE_RATE, "Lid/dana/cashier/data/repository/source/network/result/ExchangeRateResult;", "getExchangeRate", "()Lid/dana/cashier/data/repository/source/network/result/ExchangeRateResult;", "Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;", "originConvertAmount", "Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;", "getOriginConvertAmount", "()Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;", "originOrderAmount", "getOriginOrderAmount", "<init>", "(Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/ExchangeRateResult;Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntlOrderInfoDTOResult {
    private final String exchangeDate;
    private final ExchangeRateResult exchangeRate;
    private final OriginAmountResult originConvertAmount;
    private final OriginAmountResult originOrderAmount;

    public IntlOrderInfoDTOResult(String str, ExchangeRateResult exchangeRateResult, OriginAmountResult originAmountResult, OriginAmountResult originAmountResult2) {
        this.exchangeDate = str;
        this.exchangeRate = exchangeRateResult;
        this.originOrderAmount = originAmountResult;
        this.originConvertAmount = originAmountResult2;
    }

    @JvmName(name = "getExchangeDate")
    public final String getExchangeDate() {
        return this.exchangeDate;
    }

    @JvmName(name = "getExchangeRate")
    public final ExchangeRateResult getExchangeRate() {
        return this.exchangeRate;
    }

    @JvmName(name = "getOriginOrderAmount")
    public final OriginAmountResult getOriginOrderAmount() {
        return this.originOrderAmount;
    }

    @JvmName(name = "getOriginConvertAmount")
    public final OriginAmountResult getOriginConvertAmount() {
        return this.originConvertAmount;
    }
}
