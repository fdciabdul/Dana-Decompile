package id.dana.domain.electronicmoney.model.response;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0084\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010\u0007R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b%\u0010\u0007R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b(\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010\u0004"}, d2 = {"Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/util/Map;", "success", "errorCode", "apiVersion", "approvalCode", "message", "status", "pendingTopup", "session", "data", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getApiVersion", "getApprovalCode", "Ljava/util/Map;", "getData", "getErrorCode", "getMessage", "getPendingTopup", "getSession", "getStatus", "Z", "getSuccess", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EmoneyCardInfo {
    private final String apiVersion;
    private final String approvalCode;
    private final Map<String, String> data;
    private final String errorCode;
    private final String message;
    private final String pendingTopup;
    private final String session;
    private final String status;
    private final boolean success;

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /* renamed from: component4  reason: from getter */
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component6  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPendingTopup() {
        return this.pendingTopup;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSession() {
        return this.session;
    }

    public final Map<String, String> component9() {
        return this.data;
    }

    public final EmoneyCardInfo copy(boolean success, String errorCode, String apiVersion, String approvalCode, String message, String status, String pendingTopup, String session, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "");
        return new EmoneyCardInfo(success, errorCode, apiVersion, approvalCode, message, status, pendingTopup, session, data);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EmoneyCardInfo) {
            EmoneyCardInfo emoneyCardInfo = (EmoneyCardInfo) other;
            return this.success == emoneyCardInfo.success && Intrinsics.areEqual(this.errorCode, emoneyCardInfo.errorCode) && Intrinsics.areEqual(this.apiVersion, emoneyCardInfo.apiVersion) && Intrinsics.areEqual(this.approvalCode, emoneyCardInfo.approvalCode) && Intrinsics.areEqual(this.message, emoneyCardInfo.message) && Intrinsics.areEqual(this.status, emoneyCardInfo.status) && Intrinsics.areEqual(this.pendingTopup, emoneyCardInfo.pendingTopup) && Intrinsics.areEqual(this.session, emoneyCardInfo.session) && Intrinsics.areEqual(this.data, emoneyCardInfo.data);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.errorCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.apiVersion;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.approvalCode;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.message;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.status;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.pendingTopup;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.session;
        return (((((((((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0)) * 31) + this.data.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmoneyCardInfo(success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", apiVersion=");
        sb.append(this.apiVersion);
        sb.append(", approvalCode=");
        sb.append(this.approvalCode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", pendingTopup=");
        sb.append(this.pendingTopup);
        sb.append(", session=");
        sb.append(this.session);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(')');
        return sb.toString();
    }

    public EmoneyCardInfo(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.success = z;
        this.errorCode = str;
        this.apiVersion = str2;
        this.approvalCode = str3;
        this.message = str4;
        this.status = str5;
        this.pendingTopup = str6;
        this.session = str7;
        this.data = map;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getApiVersion")
    public final String getApiVersion() {
        return this.apiVersion;
    }

    @JvmName(name = "getApprovalCode")
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getPendingTopup")
    public final String getPendingTopup() {
        return this.pendingTopup;
    }

    @JvmName(name = "getSession")
    public final String getSession() {
        return this.session;
    }

    @JvmName(name = "getData")
    public final Map<String, String> getData() {
        return this.data;
    }
}
