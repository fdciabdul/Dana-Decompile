package id.dana.domain.otp.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u001cR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001cR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b#\u0010\u0007R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010'"}, d2 = {"Lid/dana/domain/otp/model/VerifyOtpRiskResponse;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "component5", "success", "errorCode", "errorMessage", "identFailedCount", "riskToken", "copy", "(ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lid/dana/domain/otp/model/VerifyOtpRiskResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getErrorCode", "setErrorCode", "(Ljava/lang/String;)V", "getErrorMessage", "setErrorMessage", "I", "getIdentFailedCount", "setIdentFailedCount", "(I)V", "getRiskToken", "Z", "getSuccess", "setSuccess", "(Z)V", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyOtpRiskResponse {
    private String errorCode;
    private String errorMessage;
    private int identFailedCount;
    private final String riskToken;
    private boolean success;

    public VerifyOtpRiskResponse() {
        this(false, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ VerifyOtpRiskResponse copy$default(VerifyOtpRiskResponse verifyOtpRiskResponse, boolean z, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = verifyOtpRiskResponse.success;
        }
        if ((i2 & 2) != 0) {
            str = verifyOtpRiskResponse.errorCode;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = verifyOtpRiskResponse.errorMessage;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            i = verifyOtpRiskResponse.identFailedCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = verifyOtpRiskResponse.riskToken;
        }
        return verifyOtpRiskResponse.copy(z, str4, str5, i3, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component4  reason: from getter */
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRiskToken() {
        return this.riskToken;
    }

    public final VerifyOtpRiskResponse copy(boolean success, String errorCode, String errorMessage, int identFailedCount, String riskToken) {
        return new VerifyOtpRiskResponse(success, errorCode, errorMessage, identFailedCount, riskToken);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyOtpRiskResponse) {
            VerifyOtpRiskResponse verifyOtpRiskResponse = (VerifyOtpRiskResponse) other;
            return this.success == verifyOtpRiskResponse.success && Intrinsics.areEqual(this.errorCode, verifyOtpRiskResponse.errorCode) && Intrinsics.areEqual(this.errorMessage, verifyOtpRiskResponse.errorMessage) && this.identFailedCount == verifyOtpRiskResponse.identFailedCount && Intrinsics.areEqual(this.riskToken, verifyOtpRiskResponse.riskToken);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.errorCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.errorMessage;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        int i = this.identFailedCount;
        String str3 = this.riskToken;
        return (((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + i) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyOtpRiskResponse(success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", identFailedCount=");
        sb.append(this.identFailedCount);
        sb.append(", riskToken=");
        sb.append(this.riskToken);
        sb.append(')');
        return sb.toString();
    }

    public VerifyOtpRiskResponse(boolean z, String str, String str2, int i, String str3) {
        this.success = z;
        this.errorCode = str;
        this.errorMessage = str2;
        this.identFailedCount = i;
        this.riskToken = str3;
    }

    public /* synthetic */ VerifyOtpRiskResponse(boolean z, String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) == 0 ? i : 0, (i2 & 16) != 0 ? null : str3);
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(boolean z) {
        this.success = z;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "setErrorCode")
    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "setErrorMessage")
    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    @JvmName(name = "getIdentFailedCount")
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "setIdentFailedCount")
    public final void setIdentFailedCount(int i) {
        this.identFailedCount = i;
    }

    @JvmName(name = "getRiskToken")
    public final String getRiskToken() {
        return this.riskToken;
    }
}
