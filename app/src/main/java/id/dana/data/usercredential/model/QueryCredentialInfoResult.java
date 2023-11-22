package id.dana.data.usercredential.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()J", "", "component2", "()Z", "passwordLastModifiedInEpoch", "passwordLastModifiedCheck", "copy", "(JZ)Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getPasswordLastModifiedCheck", "J", "getPasswordLastModifiedInEpoch", "<init>", "(JZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class QueryCredentialInfoResult extends BaseRpcResult {
    public boolean passwordLastModifiedCheck;
    public long passwordLastModifiedInEpoch;

    public QueryCredentialInfoResult() {
        this(0L, false, 3, null);
    }

    public static /* synthetic */ QueryCredentialInfoResult copy$default(QueryCredentialInfoResult queryCredentialInfoResult, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = queryCredentialInfoResult.passwordLastModifiedInEpoch;
        }
        if ((i & 2) != 0) {
            z = queryCredentialInfoResult.passwordLastModifiedCheck;
        }
        return queryCredentialInfoResult.copy(j, z);
    }

    /* renamed from: component1  reason: from getter */
    public final long getPasswordLastModifiedInEpoch() {
        return this.passwordLastModifiedInEpoch;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getPasswordLastModifiedCheck() {
        return this.passwordLastModifiedCheck;
    }

    public final QueryCredentialInfoResult copy(@JSONField(name = "passwordLastModified") long passwordLastModifiedInEpoch, @JSONField(name = "passwordLastModifiedCheck") boolean passwordLastModifiedCheck) {
        return new QueryCredentialInfoResult(passwordLastModifiedInEpoch, passwordLastModifiedCheck);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryCredentialInfoResult) {
            QueryCredentialInfoResult queryCredentialInfoResult = (QueryCredentialInfoResult) other;
            return this.passwordLastModifiedInEpoch == queryCredentialInfoResult.passwordLastModifiedInEpoch && this.passwordLastModifiedCheck == queryCredentialInfoResult.passwordLastModifiedCheck;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.passwordLastModifiedInEpoch);
        boolean z = this.passwordLastModifiedCheck;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (m * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCredentialInfoResult(passwordLastModifiedInEpoch=");
        sb.append(this.passwordLastModifiedInEpoch);
        sb.append(", passwordLastModifiedCheck=");
        sb.append(this.passwordLastModifiedCheck);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryCredentialInfoResult(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getPasswordLastModifiedInEpoch")
    public final long getPasswordLastModifiedInEpoch() {
        return this.passwordLastModifiedInEpoch;
    }

    @JvmName(name = "getPasswordLastModifiedCheck")
    public final boolean getPasswordLastModifiedCheck() {
        return this.passwordLastModifiedCheck;
    }

    public QueryCredentialInfoResult(@JSONField(name = "passwordLastModified") long j, @JSONField(name = "passwordLastModifiedCheck") boolean z) {
        this.passwordLastModifiedInEpoch = j;
        this.passwordLastModifiedCheck = z;
    }
}
