package id.dana.data.authcode;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/data/authcode/QueryAuthInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "authBindStatus", "queryAgain", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/data/authcode/QueryAuthInfoResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAuthBindStatus", "Ljava/lang/Boolean;", "getQueryAgain", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class QueryAuthInfoResult extends BaseRpcResultAphome {
    private final String authBindStatus;
    private final Boolean queryAgain;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QueryAuthInfoResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.authcode.QueryAuthInfoResult.<init>():void");
    }

    public static /* synthetic */ QueryAuthInfoResult copy$default(QueryAuthInfoResult queryAuthInfoResult, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryAuthInfoResult.authBindStatus;
        }
        if ((i & 2) != 0) {
            bool = queryAuthInfoResult.queryAgain;
        }
        return queryAuthInfoResult.copy(str, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAuthBindStatus() {
        return this.authBindStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getQueryAgain() {
        return this.queryAgain;
    }

    public final QueryAuthInfoResult copy(String authBindStatus, Boolean queryAgain) {
        return new QueryAuthInfoResult(authBindStatus, queryAgain);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryAuthInfoResult) {
            QueryAuthInfoResult queryAuthInfoResult = (QueryAuthInfoResult) other;
            return Intrinsics.areEqual(this.authBindStatus, queryAuthInfoResult.authBindStatus) && Intrinsics.areEqual(this.queryAgain, queryAuthInfoResult.queryAgain);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.authBindStatus;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.queryAgain;
        return (hashCode * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryAuthInfoResult(authBindStatus=");
        sb.append(this.authBindStatus);
        sb.append(", queryAgain=");
        sb.append(this.queryAgain);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryAuthInfoResult(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool);
    }

    @JvmName(name = "getAuthBindStatus")
    public final String getAuthBindStatus() {
        return this.authBindStatus;
    }

    @JvmName(name = "getQueryAgain")
    public final Boolean getQueryAgain() {
        return this.queryAgain;
    }

    public QueryAuthInfoResult(String str, Boolean bool) {
        this.authBindStatus = str;
        this.queryAgain = bool;
    }
}
