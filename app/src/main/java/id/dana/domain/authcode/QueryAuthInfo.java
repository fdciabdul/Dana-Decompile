package id.dana.domain.authcode;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/authcode/QueryAuthInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "authBindStatus", "queryAgain", "traceId", "copy", "(Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/authcode/QueryAuthInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAuthBindStatus", "Z", "getQueryAgain", "getTraceId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class QueryAuthInfo {
    private final String authBindStatus;
    private final boolean queryAgain;
    private final String traceId;

    public static /* synthetic */ QueryAuthInfo copy$default(QueryAuthInfo queryAuthInfo, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryAuthInfo.authBindStatus;
        }
        if ((i & 2) != 0) {
            z = queryAuthInfo.queryAgain;
        }
        if ((i & 4) != 0) {
            str2 = queryAuthInfo.traceId;
        }
        return queryAuthInfo.copy(str, z, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAuthBindStatus() {
        return this.authBindStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getQueryAgain() {
        return this.queryAgain;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final QueryAuthInfo copy(String authBindStatus, boolean queryAgain, String traceId) {
        Intrinsics.checkNotNullParameter(authBindStatus, "");
        Intrinsics.checkNotNullParameter(traceId, "");
        return new QueryAuthInfo(authBindStatus, queryAgain, traceId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryAuthInfo) {
            QueryAuthInfo queryAuthInfo = (QueryAuthInfo) other;
            return Intrinsics.areEqual(this.authBindStatus, queryAuthInfo.authBindStatus) && this.queryAgain == queryAuthInfo.queryAgain && Intrinsics.areEqual(this.traceId, queryAuthInfo.traceId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.authBindStatus.hashCode();
        boolean z = this.queryAgain;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + i) * 31) + this.traceId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryAuthInfo(authBindStatus=");
        sb.append(this.authBindStatus);
        sb.append(", queryAgain=");
        sb.append(this.queryAgain);
        sb.append(", traceId=");
        sb.append(this.traceId);
        sb.append(')');
        return sb.toString();
    }

    public QueryAuthInfo(String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.authBindStatus = str;
        this.queryAgain = z;
        this.traceId = str2;
    }

    @JvmName(name = "getAuthBindStatus")
    public final String getAuthBindStatus() {
        return this.authBindStatus;
    }

    @JvmName(name = "getQueryAgain")
    public final boolean getQueryAgain() {
        return this.queryAgain;
    }

    @JvmName(name = "getTraceId")
    public final String getTraceId() {
        return this.traceId;
    }
}
