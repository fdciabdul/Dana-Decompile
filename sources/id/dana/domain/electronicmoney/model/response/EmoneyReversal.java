package id.dana.domain.electronicmoney.model.response;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b \u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004"}, d2 = {"Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Ljava/util/Map;", "success", "errorCode", "approvalCode", "message", "data", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getApprovalCode", "Ljava/util/Map;", "getData", "getErrorCode", "getMessage", "Z", "getSuccess", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EmoneyReversal {
    private final String approvalCode;
    private final Map<String, String> data;
    private final String errorCode;
    private final String message;
    private final boolean success;

    public static /* synthetic */ EmoneyReversal copy$default(EmoneyReversal emoneyReversal, boolean z, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = emoneyReversal.success;
        }
        if ((i & 2) != 0) {
            str = emoneyReversal.errorCode;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = emoneyReversal.approvalCode;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = emoneyReversal.message;
        }
        String str6 = str3;
        Map<String, String> map2 = map;
        if ((i & 16) != 0) {
            map2 = emoneyReversal.data;
        }
        return emoneyReversal.copy(z, str4, str5, str6, map2);
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
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, String> component5() {
        return this.data;
    }

    public final EmoneyReversal copy(boolean success, String errorCode, String approvalCode, String message, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        Intrinsics.checkNotNullParameter(approvalCode, "");
        Intrinsics.checkNotNullParameter(message, "");
        Intrinsics.checkNotNullParameter(data, "");
        return new EmoneyReversal(success, errorCode, approvalCode, message, data);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EmoneyReversal) {
            EmoneyReversal emoneyReversal = (EmoneyReversal) other;
            return this.success == emoneyReversal.success && Intrinsics.areEqual(this.errorCode, emoneyReversal.errorCode) && Intrinsics.areEqual(this.approvalCode, emoneyReversal.approvalCode) && Intrinsics.areEqual(this.message, emoneyReversal.message) && Intrinsics.areEqual(this.data, emoneyReversal.data);
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
        return (((((((r0 * 31) + this.errorCode.hashCode()) * 31) + this.approvalCode.hashCode()) * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmoneyReversal(success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", approvalCode=");
        sb.append(this.approvalCode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(')');
        return sb.toString();
    }

    public EmoneyReversal(boolean z, String str, String str2, String str3, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.success = z;
        this.errorCode = str;
        this.approvalCode = str2;
        this.message = str3;
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

    @JvmName(name = "getApprovalCode")
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getData")
    public final Map<String, String> getData() {
        return this.data;
    }
}
