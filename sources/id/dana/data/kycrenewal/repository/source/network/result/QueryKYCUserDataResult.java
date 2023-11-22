package id.dana.data.kycrenewal.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "Lid/dana/data/kycrenewal/repository/source/network/result/KYCRenewalUserInfoResult;", "component2", "()Lid/dana/data/kycrenewal/repository/source/network/result/KYCRenewalUserInfoResult;", "succes", "userInfoResult", "copy", "(ZLid/dana/data/kycrenewal/repository/source/network/result/KYCRenewalUserInfoResult;)Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getSucces", "Lid/dana/data/kycrenewal/repository/source/network/result/KYCRenewalUserInfoResult;", "getUserInfoResult", "<init>", "(ZLid/dana/data/kycrenewal/repository/source/network/result/KYCRenewalUserInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class QueryKYCUserDataResult extends BaseRpcResult {
    private final boolean succes;
    private final KYCRenewalUserInfoResult userInfoResult;

    public static /* synthetic */ QueryKYCUserDataResult copy$default(QueryKYCUserDataResult queryKYCUserDataResult, boolean z, KYCRenewalUserInfoResult kYCRenewalUserInfoResult, int i, Object obj) {
        if ((i & 1) != 0) {
            z = queryKYCUserDataResult.succes;
        }
        if ((i & 2) != 0) {
            kYCRenewalUserInfoResult = queryKYCUserDataResult.userInfoResult;
        }
        return queryKYCUserDataResult.copy(z, kYCRenewalUserInfoResult);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSucces() {
        return this.succes;
    }

    /* renamed from: component2  reason: from getter */
    public final KYCRenewalUserInfoResult getUserInfoResult() {
        return this.userInfoResult;
    }

    public final QueryKYCUserDataResult copy(boolean succes, KYCRenewalUserInfoResult userInfoResult) {
        return new QueryKYCUserDataResult(succes, userInfoResult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryKYCUserDataResult) {
            QueryKYCUserDataResult queryKYCUserDataResult = (QueryKYCUserDataResult) other;
            return this.succes == queryKYCUserDataResult.succes && Intrinsics.areEqual(this.userInfoResult, queryKYCUserDataResult.userInfoResult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.succes;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        KYCRenewalUserInfoResult kYCRenewalUserInfoResult = this.userInfoResult;
        return (r0 * 31) + (kYCRenewalUserInfoResult == null ? 0 : kYCRenewalUserInfoResult.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryKYCUserDataResult(succes=");
        sb.append(this.succes);
        sb.append(", userInfoResult=");
        sb.append(this.userInfoResult);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSucces")
    public final boolean getSucces() {
        return this.succes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ QueryKYCUserDataResult(boolean r16, id.dana.data.kycrenewal.repository.source.network.result.KYCRenewalUserInfoResult r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r15 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L1c
            id.dana.data.kycrenewal.repository.source.network.result.KYCRenewalUserInfoResult r0 = new id.dana.data.kycrenewal.repository.source.network.result.KYCRenewalUserInfoResult
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2047(0x7ff, float:2.868E-42)
            r14 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r15
            r2 = r16
            goto L21
        L1c:
            r1 = r15
            r2 = r16
            r0 = r17
        L21:
            r15.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.kycrenewal.repository.source.network.result.QueryKYCUserDataResult.<init>(boolean, id.dana.data.kycrenewal.repository.source.network.result.KYCRenewalUserInfoResult, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getUserInfoResult")
    public final KYCRenewalUserInfoResult getUserInfoResult() {
        return this.userInfoResult;
    }

    public QueryKYCUserDataResult(boolean z, KYCRenewalUserInfoResult kYCRenewalUserInfoResult) {
        this.succes = z;
        this.userInfoResult = kYCRenewalUserInfoResult;
    }
}
