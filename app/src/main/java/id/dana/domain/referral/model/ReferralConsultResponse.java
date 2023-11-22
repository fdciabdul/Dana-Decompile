package id.dana.domain.referral.model;

import id.dana.domain.user.CurrencyAmount;
import id.dana.utils.rpc.response.BaseRpcResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n"}, d2 = {"Lid/dana/domain/referral/model/ReferralConsultResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "component1", "()Z", "Lid/dana/domain/user/CurrencyAmount;", "component2", "()Lid/dana/domain/user/CurrencyAmount;", "", "component3", "()Ljava/lang/String;", "enabled", "prizeAmount", "referralCode", "copy", "(ZLid/dana/domain/user/CurrencyAmount;Ljava/lang/String;)Lid/dana/domain/referral/model/ReferralConsultResponse;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnabled", "Lid/dana/domain/user/CurrencyAmount;", "getPrizeAmount", "Ljava/lang/String;", "getReferralCode", "<init>", "(ZLid/dana/domain/user/CurrencyAmount;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ReferralConsultResponse extends BaseRpcResponse {
    private final boolean enabled;
    private final CurrencyAmount prizeAmount;
    private final String referralCode;

    public static /* synthetic */ ReferralConsultResponse copy$default(ReferralConsultResponse referralConsultResponse, boolean z, CurrencyAmount currencyAmount, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = referralConsultResponse.enabled;
        }
        if ((i & 2) != 0) {
            currencyAmount = referralConsultResponse.prizeAmount;
        }
        if ((i & 4) != 0) {
            str = referralConsultResponse.referralCode;
        }
        return referralConsultResponse.copy(z, currencyAmount, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2  reason: from getter */
    public final CurrencyAmount getPrizeAmount() {
        return this.prizeAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getReferralCode() {
        return this.referralCode;
    }

    public final ReferralConsultResponse copy(boolean enabled, CurrencyAmount prizeAmount, String referralCode) {
        return new ReferralConsultResponse(enabled, prizeAmount, referralCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReferralConsultResponse) {
            ReferralConsultResponse referralConsultResponse = (ReferralConsultResponse) other;
            return this.enabled == referralConsultResponse.enabled && Intrinsics.areEqual(this.prizeAmount, referralConsultResponse.prizeAmount) && Intrinsics.areEqual(this.referralCode, referralConsultResponse.referralCode);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        CurrencyAmount currencyAmount = this.prizeAmount;
        int hashCode = currencyAmount == null ? 0 : currencyAmount.hashCode();
        String str = this.referralCode;
        return (((r0 * 31) + hashCode) * 31) + (str != null ? str.hashCode() : 0);
    }

    public /* synthetic */ ReferralConsultResponse(boolean z, CurrencyAmount currencyAmount, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, currencyAmount, (i & 4) != 0 ? "" : str);
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getPrizeAmount")
    public final CurrencyAmount getPrizeAmount() {
        return this.prizeAmount;
    }

    public ReferralConsultResponse(boolean z, CurrencyAmount currencyAmount, String str) {
        this.enabled = z;
        this.prizeAmount = currencyAmount;
        this.referralCode = str;
    }

    @JvmName(name = "getReferralCode")
    public final String getReferralCode() {
        return this.referralCode;
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralConsultRespone{enabled=");
        sb.append(this.enabled);
        sb.append(", prizeAmount=");
        sb.append(this.prizeAmount);
        sb.append(", referralCode='");
        sb.append(this.referralCode);
        sb.append("'}");
        return sb.toString();
    }
}
