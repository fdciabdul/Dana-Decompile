package id.dana.feeds.data.activation.source.network.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJb\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\nR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\rR\u001a\u0010\u0015\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/activation/source/network/response/OperationLog;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/util/Map;", "", "component6", "()J", "component7", "operationId", "fromRoleId", "targetRoleId", "operationType", "extendInfo", "gmtCreate", "gmtModified", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;JJ)Lid/dana/feeds/data/activation/source/network/response/OperationLog;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getExtendInfo", "Ljava/lang/String;", "getFromRoleId", "J", "getGmtCreate", "getGmtModified", "getOperationId", "getOperationType", "getTargetRoleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OperationLog {
    private final Map<String, String> extendInfo;
    private final String fromRoleId;
    private final long gmtCreate;
    private final long gmtModified;
    private final String operationId;
    private final String operationType;
    private final String targetRoleId;

    /* renamed from: component1  reason: from getter */
    public final String getOperationId() {
        return this.operationId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFromRoleId() {
        return this.fromRoleId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTargetRoleId() {
        return this.targetRoleId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getOperationType() {
        return this.operationType;
    }

    public final Map<String, String> component5() {
        return this.extendInfo;
    }

    /* renamed from: component6  reason: from getter */
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component7  reason: from getter */
    public final long getGmtModified() {
        return this.gmtModified;
    }

    public final OperationLog copy(String operationId, String fromRoleId, String targetRoleId, String operationType, Map<String, String> extendInfo, long gmtCreate, long gmtModified) {
        Intrinsics.checkNotNullParameter(operationId, "");
        Intrinsics.checkNotNullParameter(fromRoleId, "");
        Intrinsics.checkNotNullParameter(targetRoleId, "");
        Intrinsics.checkNotNullParameter(operationType, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new OperationLog(operationId, fromRoleId, targetRoleId, operationType, extendInfo, gmtCreate, gmtModified);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OperationLog) {
            OperationLog operationLog = (OperationLog) other;
            return Intrinsics.areEqual(this.operationId, operationLog.operationId) && Intrinsics.areEqual(this.fromRoleId, operationLog.fromRoleId) && Intrinsics.areEqual(this.targetRoleId, operationLog.targetRoleId) && Intrinsics.areEqual(this.operationType, operationLog.operationType) && Intrinsics.areEqual(this.extendInfo, operationLog.extendInfo) && this.gmtCreate == operationLog.gmtCreate && this.gmtModified == operationLog.gmtModified;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.operationId.hashCode() * 31) + this.fromRoleId.hashCode()) * 31) + this.targetRoleId.hashCode()) * 31) + this.operationType.hashCode()) * 31) + this.extendInfo.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtCreate)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtModified);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperationLog(operationId=");
        sb.append(this.operationId);
        sb.append(", fromRoleId=");
        sb.append(this.fromRoleId);
        sb.append(", targetRoleId=");
        sb.append(this.targetRoleId);
        sb.append(", operationType=");
        sb.append(this.operationType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(')');
        return sb.toString();
    }

    public OperationLog(String str, String str2, String str3, String str4, Map<String, String> map, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.operationId = str;
        this.fromRoleId = str2;
        this.targetRoleId = str3;
        this.operationType = str4;
        this.extendInfo = map;
        this.gmtCreate = j;
        this.gmtModified = j2;
    }

    @JvmName(name = "getOperationId")
    public final String getOperationId() {
        return this.operationId;
    }

    @JvmName(name = "getFromRoleId")
    public final String getFromRoleId() {
        return this.fromRoleId;
    }

    @JvmName(name = "getTargetRoleId")
    public final String getTargetRoleId() {
        return this.targetRoleId;
    }

    @JvmName(name = "getOperationType")
    public final String getOperationType() {
        return this.operationType;
    }

    public /* synthetic */ OperationLog(String str, String str2, String str3, String str4, Map map, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? new HashMap() : map, j, j2);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getGmtCreate")
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final long getGmtModified() {
        return this.gmtModified;
    }
}
