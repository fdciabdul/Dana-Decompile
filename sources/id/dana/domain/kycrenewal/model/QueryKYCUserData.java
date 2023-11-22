package id.dana.domain.kycrenewal.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/domain/kycrenewal/model/QueryKYCUserData;", "", "", "component1", "()Z", "Lid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;", "component2", "()Lid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;", "succes", "userInfo", "copy", "(ZLid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;)Lid/dana/domain/kycrenewal/model/QueryKYCUserData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getSucces", "Lid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;", "getUserInfo", "<init>", "(ZLid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class QueryKYCUserData {
    private final boolean succes;
    private final KYCRenewalUserInfo userInfo;

    public static /* synthetic */ QueryKYCUserData copy$default(QueryKYCUserData queryKYCUserData, boolean z, KYCRenewalUserInfo kYCRenewalUserInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = queryKYCUserData.succes;
        }
        if ((i & 2) != 0) {
            kYCRenewalUserInfo = queryKYCUserData.userInfo;
        }
        return queryKYCUserData.copy(z, kYCRenewalUserInfo);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSucces() {
        return this.succes;
    }

    /* renamed from: component2  reason: from getter */
    public final KYCRenewalUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final QueryKYCUserData copy(boolean succes, KYCRenewalUserInfo userInfo) {
        return new QueryKYCUserData(succes, userInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryKYCUserData) {
            QueryKYCUserData queryKYCUserData = (QueryKYCUserData) other;
            return this.succes == queryKYCUserData.succes && Intrinsics.areEqual(this.userInfo, queryKYCUserData.userInfo);
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
        KYCRenewalUserInfo kYCRenewalUserInfo = this.userInfo;
        return (r0 * 31) + (kYCRenewalUserInfo == null ? 0 : kYCRenewalUserInfo.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryKYCUserData(succes=");
        sb.append(this.succes);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(')');
        return sb.toString();
    }

    public QueryKYCUserData(boolean z, KYCRenewalUserInfo kYCRenewalUserInfo) {
        this.succes = z;
        this.userInfo = kYCRenewalUserInfo;
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
    public /* synthetic */ QueryKYCUserData(boolean r16, id.dana.domain.kycrenewal.model.KYCRenewalUserInfo r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r15 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L1c
            id.dana.domain.kycrenewal.model.KYCRenewalUserInfo r0 = new id.dana.domain.kycrenewal.model.KYCRenewalUserInfo
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.kycrenewal.model.QueryKYCUserData.<init>(boolean, id.dana.domain.kycrenewal.model.KYCRenewalUserInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getUserInfo")
    public final KYCRenewalUserInfo getUserInfo() {
        return this.userInfo;
    }
}
