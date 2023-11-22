package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/cashier/domain/model/IntlOrderInfoDTO;", "", "", "exchangeDate", "Ljava/lang/String;", "getExchangeDate", "()Ljava/lang/String;", "Lid/dana/cashier/domain/model/ExchangeRate;", CashierKeyParams.EXCHANGE_RATE, "Lid/dana/cashier/domain/model/ExchangeRate;", "getExchangeRate", "()Lid/dana/cashier/domain/model/ExchangeRate;", "Lid/dana/cashier/domain/model/OriginAmount;", "originConvertAmount", "Lid/dana/cashier/domain/model/OriginAmount;", "getOriginConvertAmount", "()Lid/dana/cashier/domain/model/OriginAmount;", "originOrderAmount", "getOriginOrderAmount", "<init>", "(Ljava/lang/String;Lid/dana/cashier/domain/model/ExchangeRate;Lid/dana/cashier/domain/model/OriginAmount;Lid/dana/cashier/domain/model/OriginAmount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntlOrderInfoDTO {
    private final String exchangeDate;
    private final ExchangeRate exchangeRate;
    private final OriginAmount originConvertAmount;
    private final OriginAmount originOrderAmount;

    public IntlOrderInfoDTO(String str, ExchangeRate exchangeRate, OriginAmount originAmount, OriginAmount originAmount2) {
        this.exchangeDate = str;
        this.exchangeRate = exchangeRate;
        this.originOrderAmount = originAmount;
        this.originConvertAmount = originAmount2;
    }

    @JvmName(name = "getExchangeDate")
    public final String getExchangeDate() {
        return this.exchangeDate;
    }

    @JvmName(name = "getExchangeRate")
    public final ExchangeRate getExchangeRate() {
        return this.exchangeRate;
    }

    @JvmName(name = "getOriginOrderAmount")
    public final OriginAmount getOriginOrderAmount() {
        return this.originOrderAmount;
    }

    @JvmName(name = "getOriginConvertAmount")
    public final OriginAmount getOriginConvertAmount() {
        return this.originConvertAmount;
    }
}
