package id.dana.domain.carrieridentification.model;

import com.iap.ac.android.acs.plugin.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J>\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/domain/carrieridentification/model/GetAuthCodeResponse;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "success", "authCode", "errorCode", "errorMessage", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/carrieridentification/model/GetAuthCodeResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", Constants.JS_API_GET_AUTH_CODE, "getErrorCode", "getErrorMessage", "Z", "getSuccess", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GetAuthCodeResponse {
    private final String authCode;
    private final String errorCode;
    private final String errorMessage;
    private final boolean success;

    public static /* synthetic */ GetAuthCodeResponse copy$default(GetAuthCodeResponse getAuthCodeResponse, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = getAuthCodeResponse.success;
        }
        if ((i & 2) != 0) {
            str = getAuthCodeResponse.authCode;
        }
        if ((i & 4) != 0) {
            str2 = getAuthCodeResponse.errorCode;
        }
        if ((i & 8) != 0) {
            str3 = getAuthCodeResponse.errorMessage;
        }
        return getAuthCodeResponse.copy(z, str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAuthCode() {
        return this.authCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component4  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final GetAuthCodeResponse copy(boolean success, String authCode, String errorCode, String errorMessage) {
        return new GetAuthCodeResponse(success, authCode, errorCode, errorMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GetAuthCodeResponse) {
            GetAuthCodeResponse getAuthCodeResponse = (GetAuthCodeResponse) other;
            return this.success == getAuthCodeResponse.success && Intrinsics.areEqual(this.authCode, getAuthCodeResponse.authCode) && Intrinsics.areEqual(this.errorCode, getAuthCodeResponse.errorCode) && Intrinsics.areEqual(this.errorMessage, getAuthCodeResponse.errorMessage);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.authCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.errorCode;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.errorMessage;
        return (((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetAuthCodeResponse(success=");
        sb.append(this.success);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(')');
        return sb.toString();
    }

    public GetAuthCodeResponse(boolean z, String str, String str2, String str3) {
        this.success = z;
        this.authCode = str;
        this.errorCode = str2;
        this.errorMessage = str3;
    }

    public /* synthetic */ GetAuthCodeResponse(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = Constants.JS_API_GET_AUTH_CODE)
    public final String getAuthCode() {
        return this.authCode;
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
