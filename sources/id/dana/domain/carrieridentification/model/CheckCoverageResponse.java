package id.dana.domain.carrieridentification.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/carrieridentification/model/CheckCoverageResponse;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "success", "errorCode", "errorMessage", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/carrieridentification/model/CheckCoverageResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorCode", "getErrorMessage", "Z", "getSuccess", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckCoverageResponse {
    private final String errorCode;
    private final String errorMessage;
    private final boolean success;

    public static /* synthetic */ CheckCoverageResponse copy$default(CheckCoverageResponse checkCoverageResponse, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = checkCoverageResponse.success;
        }
        if ((i & 2) != 0) {
            str = checkCoverageResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str2 = checkCoverageResponse.errorMessage;
        }
        return checkCoverageResponse.copy(z, str, str2);
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

    public final CheckCoverageResponse copy(boolean success, String errorCode, String errorMessage) {
        return new CheckCoverageResponse(success, errorCode, errorMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckCoverageResponse) {
            CheckCoverageResponse checkCoverageResponse = (CheckCoverageResponse) other;
            return this.success == checkCoverageResponse.success && Intrinsics.areEqual(this.errorCode, checkCoverageResponse.errorCode) && Intrinsics.areEqual(this.errorMessage, checkCoverageResponse.errorMessage);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.errorCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.errorMessage;
        return (((r0 * 31) + hashCode) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckCoverageResponse(success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(')');
        return sb.toString();
    }

    public CheckCoverageResponse(boolean z, String str, String str2) {
        this.success = z;
        this.errorCode = str;
        this.errorMessage = str2;
    }

    public /* synthetic */ CheckCoverageResponse(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? " " : str, (i & 4) != 0 ? " " : str2);
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
