package id.dana.cashier.data.repository.source.network.result;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u0010=J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J \u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b+\u0010\u0007R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b1\u0010\u0007R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u000fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b4\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b5\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b6\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b9\u0010\u0007R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b:\u0010\u0007R\u001c\u0010!\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010.\u001a\u0004\b;\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "component1", "()Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "", "component10", "()Ljava/lang/String;", "component11", "component12", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "component7", "Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "component8", "()Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "component9", "attributes", "cardCacheToken", CashierKeyParams.CASHIER_ORDER_ID, "cashierRequestId", "identFailedCount", "lockedExpireMins", "maxFailedLimit", "payMethodRiskResult", RecordError.KEY_PUB_KEY, BioUtilityBridge.SECURITY_ID, "innerCardIndexNo", CashierKeyParams.TOP_UP_ORDER_ID, "copy", "(Lid/dana/cashier/data/repository/source/network/result/AttributesResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Lid/dana/cashier/data/repository/source/network/result/AttributesResult;", "getAttributes", "Ljava/lang/String;", "getCardCacheToken", "getCashierOrderId", "getCashierRequestId", "Ljava/lang/Integer;", "getIdentFailedCount", "getInnerCardIndexNo", "getLockedExpireMins", "getMaxFailedLimit", "Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "getPayMethodRiskResult", "getPubKey", "getSecurityId", "getTopUpOrderId", "<init>", "(Lid/dana/cashier/data/repository/source/network/result/AttributesResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpPayEntityResult extends BaseRpcResultAphome {
    @SerializedName("attributes")
    private final AttributesResult attributes;
    private final String cardCacheToken;
    private final String cashierOrderId;
    private final String cashierRequestId;
    private final Integer identFailedCount;
    private final String innerCardIndexNo;
    private final Integer lockedExpireMins;
    private final Integer maxFailedLimit;
    private final RiskVerificationMethodResult payMethodRiskResult;
    private final String pubKey;
    private final String securityId;
    private final String topUpOrderId;

    /* renamed from: component1  reason: from getter */
    public final AttributesResult getAttributes() {
        return this.attributes;
    }

    /* renamed from: component10  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component11  reason: from getter */
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getIdentFailedCount() {
        return this.identFailedCount;
    }

    /* renamed from: component6  reason: from getter */
    public final Integer getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    /* renamed from: component8  reason: from getter */
    public final RiskVerificationMethodResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    /* renamed from: component9  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
    }

    public final TopUpPayEntityResult copy(AttributesResult attributes, String cardCacheToken, String cashierOrderId, String cashierRequestId, Integer identFailedCount, Integer lockedExpireMins, Integer maxFailedLimit, RiskVerificationMethodResult payMethodRiskResult, String pubKey, String securityId, String innerCardIndexNo, String topUpOrderId) {
        return new TopUpPayEntityResult(attributes, cardCacheToken, cashierOrderId, cashierRequestId, identFailedCount, lockedExpireMins, maxFailedLimit, payMethodRiskResult, pubKey, securityId, innerCardIndexNo, topUpOrderId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpPayEntityResult) {
            TopUpPayEntityResult topUpPayEntityResult = (TopUpPayEntityResult) other;
            return Intrinsics.areEqual(this.attributes, topUpPayEntityResult.attributes) && Intrinsics.areEqual(this.cardCacheToken, topUpPayEntityResult.cardCacheToken) && Intrinsics.areEqual(this.cashierOrderId, topUpPayEntityResult.cashierOrderId) && Intrinsics.areEqual(this.cashierRequestId, topUpPayEntityResult.cashierRequestId) && Intrinsics.areEqual(this.identFailedCount, topUpPayEntityResult.identFailedCount) && Intrinsics.areEqual(this.lockedExpireMins, topUpPayEntityResult.lockedExpireMins) && Intrinsics.areEqual(this.maxFailedLimit, topUpPayEntityResult.maxFailedLimit) && Intrinsics.areEqual(this.payMethodRiskResult, topUpPayEntityResult.payMethodRiskResult) && Intrinsics.areEqual(this.pubKey, topUpPayEntityResult.pubKey) && Intrinsics.areEqual(this.securityId, topUpPayEntityResult.securityId) && Intrinsics.areEqual(this.innerCardIndexNo, topUpPayEntityResult.innerCardIndexNo) && Intrinsics.areEqual(this.topUpOrderId, topUpPayEntityResult.topUpOrderId);
        }
        return false;
    }

    public final int hashCode() {
        AttributesResult attributesResult = this.attributes;
        int hashCode = attributesResult == null ? 0 : attributesResult.hashCode();
        String str = this.cardCacheToken;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cashierRequestId;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        Integer num = this.identFailedCount;
        int hashCode5 = num == null ? 0 : num.hashCode();
        Integer num2 = this.lockedExpireMins;
        int hashCode6 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.maxFailedLimit;
        int hashCode7 = num3 == null ? 0 : num3.hashCode();
        RiskVerificationMethodResult riskVerificationMethodResult = this.payMethodRiskResult;
        int hashCode8 = riskVerificationMethodResult == null ? 0 : riskVerificationMethodResult.hashCode();
        String str4 = this.pubKey;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.securityId;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.innerCardIndexNo;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.topUpOrderId;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpPayEntityResult(attributes=");
        sb.append(this.attributes);
        sb.append(", cardCacheToken=");
        sb.append(this.cardCacheToken);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", cashierRequestId=");
        sb.append(this.cashierRequestId);
        sb.append(", identFailedCount=");
        sb.append(this.identFailedCount);
        sb.append(", lockedExpireMins=");
        sb.append(this.lockedExpireMins);
        sb.append(", maxFailedLimit=");
        sb.append(this.maxFailedLimit);
        sb.append(", payMethodRiskResult=");
        sb.append(this.payMethodRiskResult);
        sb.append(", pubKey=");
        sb.append(this.pubKey);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", innerCardIndexNo=");
        sb.append(this.innerCardIndexNo);
        sb.append(", topUpOrderId=");
        sb.append(this.topUpOrderId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TopUpPayEntityResult(AttributesResult attributesResult, String str, String str2, String str3, Integer num, Integer num2, Integer num3, RiskVerificationMethodResult riskVerificationMethodResult, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attributesResult, (i & 2) != 0 ? null : str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : riskVerificationMethodResult, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7);
    }

    @JvmName(name = "getAttributes")
    public final AttributesResult getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "getCardCacheToken")
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getCashierRequestId")
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    @JvmName(name = "getIdentFailedCount")
    public final Integer getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "getLockedExpireMins")
    public final Integer getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final Integer getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "getPayMethodRiskResult")
    public final RiskVerificationMethodResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getInnerCardIndexNo")
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    @JvmName(name = "getTopUpOrderId")
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    public TopUpPayEntityResult(AttributesResult attributesResult, String str, String str2, String str3, Integer num, Integer num2, Integer num3, RiskVerificationMethodResult riskVerificationMethodResult, String str4, String str5, String str6, String str7) {
        this.attributes = attributesResult;
        this.cardCacheToken = str;
        this.cashierOrderId = str2;
        this.cashierRequestId = str3;
        this.identFailedCount = num;
        this.lockedExpireMins = num2;
        this.maxFailedLimit = num3;
        this.payMethodRiskResult = riskVerificationMethodResult;
        this.pubKey = str4;
        this.securityId = str5;
        this.innerCardIndexNo = str6;
        this.topUpOrderId = str7;
    }
}
