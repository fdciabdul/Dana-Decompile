package id.dana.network.response.autoroute;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/network/response/autoroute/RiskResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "result", CashierKeyParams.VERIFICATION_METHOD, BioUtilityBridge.SECURITY_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/network/response/autoroute/RiskResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getResult", "setResult", "(Ljava/lang/String;)V", "getSecurityId", "setSecurityId", "getVerificationMethod", "setVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RiskResult {
    private String result;
    private String securityId;
    private String verificationMethod;

    public RiskResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RiskResult copy$default(RiskResult riskResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = riskResult.result;
        }
        if ((i & 2) != 0) {
            str2 = riskResult.verificationMethod;
        }
        if ((i & 4) != 0) {
            str3 = riskResult.securityId;
        }
        return riskResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final RiskResult copy(String result, String verificationMethod, String securityId) {
        return new RiskResult(result, verificationMethod, securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskResult) {
            RiskResult riskResult = (RiskResult) other;
            return Intrinsics.areEqual(this.result, riskResult.result) && Intrinsics.areEqual(this.verificationMethod, riskResult.verificationMethod) && Intrinsics.areEqual(this.securityId, riskResult.securityId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.result;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.verificationMethod;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.securityId;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskResult(result=");
        sb.append(this.result);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    public RiskResult(String str, String str2, String str3) {
        this.result = str;
        this.verificationMethod = str2;
        this.securityId = str3;
    }

    public /* synthetic */ RiskResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getResult")
    public final String getResult() {
        return this.result;
    }

    @JvmName(name = "setResult")
    public final void setResult(String str) {
        this.result = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }
}
