package id.dana.sendmoney.data.api.globalsend.init.model;

import id.dana.data.model.CurrencyAmountResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/init/model/SubTransferMethodInfoEntity;", "", "", "instId", "Ljava/lang/String;", "getInstId", "()Ljava/lang/String;", "instLocalName", "getInstLocalName", "", "maintenance", "Ljava/lang/Boolean;", "getMaintenance", "()Ljava/lang/Boolean;", "payChannelApi", "getPayChannelApi", "payMethod", "getPayMethod", "payOption", "getPayOption", "Lid/dana/data/model/CurrencyAmountResult;", "payerMaxAmount", "Lid/dana/data/model/CurrencyAmountResult;", "getPayerMaxAmount", "()Lid/dana/data/model/CurrencyAmountResult;", "payerMinAmount", "getPayerMinAmount", "Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;", "rateAmount", "Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;", "getRateAmount", "()Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;", "subTransferMethodType", "getSubTransferMethodType", "<init>", "(Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubTransferMethodInfoEntity {
    private final String instId;
    private final String instLocalName;
    private final Boolean maintenance;
    private final String payChannelApi;
    private final String payMethod;
    private final String payOption;
    private final CurrencyAmountResult payerMaxAmount;
    private final CurrencyAmountResult payerMinAmount;
    private final CurrencyRateEntity rateAmount;
    private final String subTransferMethodType;

    public SubTransferMethodInfoEntity(CurrencyRateEntity currencyRateEntity, String str, String str2, String str3, String str4, String str5, String str6, CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, Boolean bool) {
        this.rateAmount = currencyRateEntity;
        this.subTransferMethodType = str;
        this.payChannelApi = str2;
        this.instId = str3;
        this.instLocalName = str4;
        this.payMethod = str5;
        this.payOption = str6;
        this.payerMinAmount = currencyAmountResult;
        this.payerMaxAmount = currencyAmountResult2;
        this.maintenance = bool;
    }

    @JvmName(name = "getRateAmount")
    public final CurrencyRateEntity getRateAmount() {
        return this.rateAmount;
    }

    @JvmName(name = "getSubTransferMethodType")
    public final String getSubTransferMethodType() {
        return this.subTransferMethodType;
    }

    @JvmName(name = "getPayChannelApi")
    public final String getPayChannelApi() {
        return this.payChannelApi;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getPayerMinAmount")
    public final CurrencyAmountResult getPayerMinAmount() {
        return this.payerMinAmount;
    }

    @JvmName(name = "getPayerMaxAmount")
    public final CurrencyAmountResult getPayerMaxAmount() {
        return this.payerMaxAmount;
    }

    @JvmName(name = "getMaintenance")
    public final Boolean getMaintenance() {
        return this.maintenance;
    }
}
