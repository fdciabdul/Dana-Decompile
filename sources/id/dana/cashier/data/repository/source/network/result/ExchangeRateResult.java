package id.dana.cashier.data.repository.source.network.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/ExchangeRateResult;", "", "", "baseCurrency", "Ljava/lang/String;", "getBaseCurrency", "()Ljava/lang/String;", "exchangeCurrency", "getExchangeCurrency", "exchangeRelation", "getExchangeRelation", "rate", "getRate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExchangeRateResult {
    private final String baseCurrency;
    private final String exchangeCurrency;
    private final String exchangeRelation;
    private final String rate;

    public ExchangeRateResult(String str, String str2, String str3, String str4) {
        this.baseCurrency = str;
        this.exchangeCurrency = str2;
        this.exchangeRelation = str3;
        this.rate = str4;
    }

    @JvmName(name = "getBaseCurrency")
    public final String getBaseCurrency() {
        return this.baseCurrency;
    }

    @JvmName(name = "getExchangeCurrency")
    public final String getExchangeCurrency() {
        return this.exchangeCurrency;
    }

    @JvmName(name = "getExchangeRelation")
    public final String getExchangeRelation() {
        return this.exchangeRelation;
    }

    @JvmName(name = "getRate")
    public final String getRate() {
        return this.rate;
    }
}
