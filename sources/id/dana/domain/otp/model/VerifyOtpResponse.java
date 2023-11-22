package id.dana.domain.otp.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\b"}, d2 = {"Lid/dana/domain/otp/model/VerifyOtpResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "component1", "()I", "component2", "", "component3", "()Ljava/lang/String;", "failedCount", "maxFailedCount", "riskToken", "copy", "(IILjava/lang/String;)Lid/dana/domain/otp/model/VerifyOtpResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getFailedCount", "setFailedCount", "(I)V", "getMaxFailedCount", "setMaxFailedCount", "Ljava/lang/String;", "getRiskToken", "<init>", "(IILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyOtpResponse extends BaseRpcResponse {
    private int failedCount;
    private int maxFailedCount;
    private final String riskToken;

    public VerifyOtpResponse() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ VerifyOtpResponse copy$default(VerifyOtpResponse verifyOtpResponse, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = verifyOtpResponse.failedCount;
        }
        if ((i3 & 2) != 0) {
            i2 = verifyOtpResponse.maxFailedCount;
        }
        if ((i3 & 4) != 0) {
            str = verifyOtpResponse.riskToken;
        }
        return verifyOtpResponse.copy(i, i2, str);
    }

    /* renamed from: component1  reason: from getter */
    public final int getFailedCount() {
        return this.failedCount;
    }

    /* renamed from: component2  reason: from getter */
    public final int getMaxFailedCount() {
        return this.maxFailedCount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRiskToken() {
        return this.riskToken;
    }

    public final VerifyOtpResponse copy(int failedCount, int maxFailedCount, String riskToken) {
        return new VerifyOtpResponse(failedCount, maxFailedCount, riskToken);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyOtpResponse) {
            VerifyOtpResponse verifyOtpResponse = (VerifyOtpResponse) other;
            return this.failedCount == verifyOtpResponse.failedCount && this.maxFailedCount == verifyOtpResponse.maxFailedCount && Intrinsics.areEqual(this.riskToken, verifyOtpResponse.riskToken);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.failedCount;
        int i2 = this.maxFailedCount;
        String str = this.riskToken;
        return (((i * 31) + i2) * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyOtpResponse(failedCount=");
        sb.append(this.failedCount);
        sb.append(", maxFailedCount=");
        sb.append(this.maxFailedCount);
        sb.append(", riskToken=");
        sb.append(this.riskToken);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifyOtpResponse(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : str);
    }

    @JvmName(name = "getFailedCount")
    public final int getFailedCount() {
        return this.failedCount;
    }

    @JvmName(name = "setFailedCount")
    public final void setFailedCount(int i) {
        this.failedCount = i;
    }

    @JvmName(name = "getMaxFailedCount")
    public final int getMaxFailedCount() {
        return this.maxFailedCount;
    }

    @JvmName(name = "setMaxFailedCount")
    public final void setMaxFailedCount(int i) {
        this.maxFailedCount = i;
    }

    @JvmName(name = "getRiskToken")
    public final String getRiskToken() {
        return this.riskToken;
    }

    public VerifyOtpResponse(int i, int i2, String str) {
        this.failedCount = i;
        this.maxFailedCount = i2;
        this.riskToken = str;
    }
}
