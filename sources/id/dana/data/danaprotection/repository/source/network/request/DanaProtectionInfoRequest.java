package id.dana.data.danaprotection.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/danaprotection/repository/source/network/request/DanaProtectionInfoRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "userId", "copy", "(Ljava/lang/String;)Lid/dana/data/danaprotection/repository/source/network/request/DanaProtectionInfoRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getUserId", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DanaProtectionInfoRequest extends BaseRpcRequest {
    private final String userId;

    public static /* synthetic */ DanaProtectionInfoRequest copy$default(DanaProtectionInfoRequest danaProtectionInfoRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = danaProtectionInfoRequest.userId;
        }
        return danaProtectionInfoRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final DanaProtectionInfoRequest copy(String userId) {
        Intrinsics.checkNotNullParameter(userId, "");
        return new DanaProtectionInfoRequest(userId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DanaProtectionInfoRequest) && Intrinsics.areEqual(this.userId, ((DanaProtectionInfoRequest) other).userId);
    }

    public final int hashCode() {
        return this.userId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionInfoRequest(userId=");
        sb.append(this.userId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    public DanaProtectionInfoRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
    }
}
