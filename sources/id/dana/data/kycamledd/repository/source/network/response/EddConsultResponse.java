package id.dana.data.kycamledd.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "component2", "()Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "eddStatus", "eddInfo", "copy", "(ZLid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;)Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "getEddInfo", "Z", "getEddStatus", "<init>", "(ZLid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EddConsultResponse extends BaseRpcResult {
    private final EddInfoResponse eddInfo;
    private final boolean eddStatus;

    public static /* synthetic */ EddConsultResponse copy$default(EddConsultResponse eddConsultResponse, boolean z, EddInfoResponse eddInfoResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            z = eddConsultResponse.eddStatus;
        }
        if ((i & 2) != 0) {
            eddInfoResponse = eddConsultResponse.eddInfo;
        }
        return eddConsultResponse.copy(z, eddInfoResponse);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEddStatus() {
        return this.eddStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final EddInfoResponse getEddInfo() {
        return this.eddInfo;
    }

    public final EddConsultResponse copy(boolean eddStatus, EddInfoResponse eddInfo) {
        return new EddConsultResponse(eddStatus, eddInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EddConsultResponse) {
            EddConsultResponse eddConsultResponse = (EddConsultResponse) other;
            return this.eddStatus == eddConsultResponse.eddStatus && Intrinsics.areEqual(this.eddInfo, eddConsultResponse.eddInfo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.eddStatus;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        EddInfoResponse eddInfoResponse = this.eddInfo;
        return (r0 * 31) + (eddInfoResponse == null ? 0 : eddInfoResponse.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EddConsultResponse(eddStatus=");
        sb.append(this.eddStatus);
        sb.append(", eddInfo=");
        sb.append(this.eddInfo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getEddStatus")
    public final boolean getEddStatus() {
        return this.eddStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ EddConsultResponse(boolean r1, id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Lb
            id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse r2 = new id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse
            r3 = 3
            r4 = 0
            r2.<init>(r4, r4, r3, r4)
        Lb:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse.<init>(boolean, id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getEddInfo")
    public final EddInfoResponse getEddInfo() {
        return this.eddInfo;
    }

    public EddConsultResponse(boolean z, EddInfoResponse eddInfoResponse) {
        this.eddStatus = z;
        this.eddInfo = eddInfoResponse;
    }
}
