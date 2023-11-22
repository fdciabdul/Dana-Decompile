package id.dana.data.kycrenewal.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "renewKYC", "verificationId", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getRenewKYC", "Ljava/lang/String;", "getVerificationId", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryKYCRenewalStatusResult extends BaseRpcResult {
    @SerializedName("renewKYC")
    private final Boolean renewKYC;
    @SerializedName("verificationId")
    private final String verificationId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QueryKYCRenewalStatusResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.kycrenewal.repository.source.network.result.QueryKYCRenewalStatusResult.<init>():void");
    }

    public static /* synthetic */ QueryKYCRenewalStatusResult copy$default(QueryKYCRenewalStatusResult queryKYCRenewalStatusResult, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = queryKYCRenewalStatusResult.renewKYC;
        }
        if ((i & 2) != 0) {
            str = queryKYCRenewalStatusResult.verificationId;
        }
        return queryKYCRenewalStatusResult.copy(bool, str);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getRenewKYC() {
        return this.renewKYC;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationId() {
        return this.verificationId;
    }

    public final QueryKYCRenewalStatusResult copy(Boolean renewKYC, String verificationId) {
        return new QueryKYCRenewalStatusResult(renewKYC, verificationId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryKYCRenewalStatusResult) {
            QueryKYCRenewalStatusResult queryKYCRenewalStatusResult = (QueryKYCRenewalStatusResult) other;
            return Intrinsics.areEqual(this.renewKYC, queryKYCRenewalStatusResult.renewKYC) && Intrinsics.areEqual(this.verificationId, queryKYCRenewalStatusResult.verificationId);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.renewKYC;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.verificationId;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryKYCRenewalStatusResult(renewKYC=");
        sb.append(this.renewKYC);
        sb.append(", verificationId=");
        sb.append(this.verificationId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryKYCRenewalStatusResult(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
    }

    @JvmName(name = "getRenewKYC")
    public final Boolean getRenewKYC() {
        return this.renewKYC;
    }

    @JvmName(name = "getVerificationId")
    public final String getVerificationId() {
        return this.verificationId;
    }

    public QueryKYCRenewalStatusResult(Boolean bool, String str) {
        this.renewKYC = bool;
        this.verificationId = str;
    }
}
