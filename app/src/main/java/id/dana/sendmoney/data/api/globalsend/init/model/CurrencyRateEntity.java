package id.dana.sendmoney.data.api.globalsend.init.model;

import id.dana.data.model.CurrencyAmountResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;", "", "Lid/dana/data/model/CurrencyAmountResult;", "destinationAmount", "Lid/dana/data/model/CurrencyAmountResult;", "getDestinationAmount", "()Lid/dana/data/model/CurrencyAmountResult;", "", "destinationAmountCent", "Ljava/lang/String;", "getDestinationAmountCent", "()Ljava/lang/String;", "sourceAmount", "getSourceAmount", "sourceAmountCent", "getSourceAmountCent", "<init>", "(Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrencyRateEntity {
    private final CurrencyAmountResult destinationAmount;
    private final String destinationAmountCent;
    private final CurrencyAmountResult sourceAmount;
    private final String sourceAmountCent;

    public CurrencyRateEntity(CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, String str, String str2) {
        this.sourceAmount = currencyAmountResult;
        this.destinationAmount = currencyAmountResult2;
        this.destinationAmountCent = str;
        this.sourceAmountCent = str2;
    }

    @JvmName(name = "getSourceAmount")
    public final CurrencyAmountResult getSourceAmount() {
        return this.sourceAmount;
    }

    @JvmName(name = "getDestinationAmount")
    public final CurrencyAmountResult getDestinationAmount() {
        return this.destinationAmount;
    }

    @JvmName(name = "getDestinationAmountCent")
    public final String getDestinationAmountCent() {
        return this.destinationAmountCent;
    }

    @JvmName(name = "getSourceAmountCent")
    public final String getSourceAmountCent() {
        return this.sourceAmountCent;
    }
}
