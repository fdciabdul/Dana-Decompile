package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b$\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b%\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b'\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "component4", "component5", "component6", "component7", "bindingId", WalletConstant.CARD_INDEX_NO, "identifyFailedCount", "lockedExpireSeconds", "maxFailed", "payMethod", "payOption", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBindingId", "getCardIndexNo", "Ljava/lang/Long;", "getIdentifyFailedCount", "getLockedExpireSeconds", "getMaxFailed", "getPayMethod", "getPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAgreementResult extends BaseRpcResultAphome {
    @SerializedName("bindingId")
    private final String bindingId;
    private final String cardIndexNo;
    private final Long identifyFailedCount;
    private final Long lockedExpireSeconds;
    private final Long maxFailed;
    private final String payMethod;
    private final String payOption;

    public static /* synthetic */ CashierAgreementResult copy$default(CashierAgreementResult cashierAgreementResult, String str, String str2, Long l, Long l2, Long l3, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierAgreementResult.bindingId;
        }
        if ((i & 2) != 0) {
            str2 = cashierAgreementResult.cardIndexNo;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            l = cashierAgreementResult.identifyFailedCount;
        }
        Long l4 = l;
        if ((i & 8) != 0) {
            l2 = cashierAgreementResult.lockedExpireSeconds;
        }
        Long l5 = l2;
        if ((i & 16) != 0) {
            l3 = cashierAgreementResult.maxFailed;
        }
        Long l6 = l3;
        if ((i & 32) != 0) {
            str3 = cashierAgreementResult.payMethod;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            str4 = cashierAgreementResult.payOption;
        }
        return cashierAgreementResult.copy(str, str5, l4, l5, l6, str6, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getIdentifyFailedCount() {
        return this.identifyFailedCount;
    }

    /* renamed from: component4  reason: from getter */
    public final Long getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getMaxFailed() {
        return this.maxFailed;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    public final CashierAgreementResult copy(String bindingId, String cardIndexNo, Long identifyFailedCount, Long lockedExpireSeconds, Long maxFailed, String payMethod, String payOption) {
        return new CashierAgreementResult(bindingId, cardIndexNo, identifyFailedCount, lockedExpireSeconds, maxFailed, payMethod, payOption);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAgreementResult) {
            CashierAgreementResult cashierAgreementResult = (CashierAgreementResult) other;
            return Intrinsics.areEqual(this.bindingId, cashierAgreementResult.bindingId) && Intrinsics.areEqual(this.cardIndexNo, cashierAgreementResult.cardIndexNo) && Intrinsics.areEqual(this.identifyFailedCount, cashierAgreementResult.identifyFailedCount) && Intrinsics.areEqual(this.lockedExpireSeconds, cashierAgreementResult.lockedExpireSeconds) && Intrinsics.areEqual(this.maxFailed, cashierAgreementResult.maxFailed) && Intrinsics.areEqual(this.payMethod, cashierAgreementResult.payMethod) && Intrinsics.areEqual(this.payOption, cashierAgreementResult.payOption);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bindingId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cardIndexNo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Long l = this.identifyFailedCount;
        int hashCode3 = l == null ? 0 : l.hashCode();
        Long l2 = this.lockedExpireSeconds;
        int hashCode4 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.maxFailed;
        int hashCode5 = l3 == null ? 0 : l3.hashCode();
        String str3 = this.payMethod;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.payOption;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAgreementResult(bindingId=");
        sb.append(this.bindingId);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", identifyFailedCount=");
        sb.append(this.identifyFailedCount);
        sb.append(", lockedExpireSeconds=");
        sb.append(this.lockedExpireSeconds);
        sb.append(", maxFailed=");
        sb.append(this.maxFailed);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getIdentifyFailedCount")
    public final Long getIdentifyFailedCount() {
        return this.identifyFailedCount;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final Long getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "getMaxFailed")
    public final Long getMaxFailed() {
        return this.maxFailed;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    public CashierAgreementResult(String str, String str2, Long l, Long l2, Long l3, String str3, String str4) {
        this.bindingId = str;
        this.cardIndexNo = str2;
        this.identifyFailedCount = l;
        this.lockedExpireSeconds = l2;
        this.maxFailed = l3;
        this.payMethod = str3;
        this.payOption = str4;
    }
}
