package id.dana.data.wallet_v3.model;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/wallet_v3/model/PocketUpdateRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "userId", "status", "pocketId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/wallet_v3/model/PocketUpdateRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPocketId", "getStatus", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PocketUpdateRequest extends BaseRpcRequest {
    private final String pocketId;
    private final String status;
    private final String userId;

    public static /* synthetic */ PocketUpdateRequest copy$default(PocketUpdateRequest pocketUpdateRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pocketUpdateRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = pocketUpdateRequest.status;
        }
        if ((i & 4) != 0) {
            str3 = pocketUpdateRequest.pocketId;
        }
        return pocketUpdateRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPocketId() {
        return this.pocketId;
    }

    public final PocketUpdateRequest copy(String userId, String status, String pocketId) {
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(pocketId, "");
        return new PocketUpdateRequest(userId, status, pocketId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PocketUpdateRequest) {
            PocketUpdateRequest pocketUpdateRequest = (PocketUpdateRequest) other;
            return Intrinsics.areEqual(this.userId, pocketUpdateRequest.userId) && Intrinsics.areEqual(this.status, pocketUpdateRequest.status) && Intrinsics.areEqual(this.pocketId, pocketUpdateRequest.pocketId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.status.hashCode()) * 31) + this.pocketId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PocketUpdateRequest(userId=");
        sb.append(this.userId);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", pocketId=");
        sb.append(this.pocketId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PocketUpdateRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "REDEEMED" : str2, str3);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    public PocketUpdateRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.userId = str;
        this.status = str2;
        this.pocketId = str3;
    }
}
