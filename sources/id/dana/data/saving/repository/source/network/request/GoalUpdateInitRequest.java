package id.dana.data.saving.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/request/GoalUpdateInitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "savingId", "copy", "(Ljava/lang/String;)Lid/dana/data/saving/repository/source/network/request/GoalUpdateInitRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSavingId", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalUpdateInitRequest extends BaseRpcRequest {
    private final String savingId;

    public static /* synthetic */ GoalUpdateInitRequest copy$default(GoalUpdateInitRequest goalUpdateInitRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goalUpdateInitRequest.savingId;
        }
        return goalUpdateInitRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    public final GoalUpdateInitRequest copy(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        return new GoalUpdateInitRequest(savingId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoalUpdateInitRequest) && Intrinsics.areEqual(this.savingId, ((GoalUpdateInitRequest) other).savingId);
    }

    public final int hashCode() {
        return this.savingId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalUpdateInitRequest(savingId=");
        sb.append(this.savingId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    public GoalUpdateInitRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.savingId = str;
    }
}
