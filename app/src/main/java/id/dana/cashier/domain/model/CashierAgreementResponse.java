package id.dana.cashier.domain.model;

import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJp\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b&\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u000f"}, d2 = {"Lid/dana/cashier/domain/model/CashierAgreementResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Boolean;", "bindingId", WalletConstant.CARD_INDEX_NO, "identifyFailedCount", "lockedExpireSeconds", "maxFailed", "payMethod", "payOption", "success", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/domain/model/CashierAgreementResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBindingId", "getCardIndexNo", "Ljava/lang/Long;", "getIdentifyFailedCount", "getLockedExpireSeconds", "getMaxFailed", "getPayMethod", "getPayOption", "Ljava/lang/Boolean;", "getSuccess", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAgreementResponse {
    private final String bindingId;
    private final String cardIndexNo;
    private final Long identifyFailedCount;
    private final Long lockedExpireSeconds;
    private final Long maxFailed;
    private final String payMethod;
    private final String payOption;
    private final Boolean success;

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

    /* renamed from: component8  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final CashierAgreementResponse copy(String bindingId, String cardIndexNo, Long identifyFailedCount, Long lockedExpireSeconds, Long maxFailed, String payMethod, String payOption, Boolean success) {
        return new CashierAgreementResponse(bindingId, cardIndexNo, identifyFailedCount, lockedExpireSeconds, maxFailed, payMethod, payOption, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAgreementResponse) {
            CashierAgreementResponse cashierAgreementResponse = (CashierAgreementResponse) other;
            return Intrinsics.areEqual(this.bindingId, cashierAgreementResponse.bindingId) && Intrinsics.areEqual(this.cardIndexNo, cashierAgreementResponse.cardIndexNo) && Intrinsics.areEqual(this.identifyFailedCount, cashierAgreementResponse.identifyFailedCount) && Intrinsics.areEqual(this.lockedExpireSeconds, cashierAgreementResponse.lockedExpireSeconds) && Intrinsics.areEqual(this.maxFailed, cashierAgreementResponse.maxFailed) && Intrinsics.areEqual(this.payMethod, cashierAgreementResponse.payMethod) && Intrinsics.areEqual(this.payOption, cashierAgreementResponse.payOption) && Intrinsics.areEqual(this.success, cashierAgreementResponse.success);
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
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.success;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAgreementResponse(bindingId=");
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
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public CashierAgreementResponse(String str, String str2, Long l, Long l2, Long l3, String str3, String str4, Boolean bool) {
        this.bindingId = str;
        this.cardIndexNo = str2;
        this.identifyFailedCount = l;
        this.lockedExpireSeconds = l2;
        this.maxFailed = l3;
        this.payMethod = str3;
        this.payOption = str4;
        this.success = bool;
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

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }
}
