package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "needWithdraw", "copy", "(Z)Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getNeedWithdraw", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalRevokeResult extends BaseRpcResult {
    private final boolean needWithdraw;

    public static /* synthetic */ GoalRevokeResult copy$default(GoalRevokeResult goalRevokeResult, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = goalRevokeResult.needWithdraw;
        }
        return goalRevokeResult.copy(z);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getNeedWithdraw() {
        return this.needWithdraw;
    }

    public final GoalRevokeResult copy(boolean needWithdraw) {
        return new GoalRevokeResult(needWithdraw);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoalRevokeResult) && this.needWithdraw == ((GoalRevokeResult) other).needWithdraw;
    }

    public final int hashCode() {
        boolean z = this.needWithdraw;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalRevokeResult(needWithdraw=");
        sb.append(this.needWithdraw);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getNeedWithdraw")
    public final boolean getNeedWithdraw() {
        return this.needWithdraw;
    }

    public GoalRevokeResult(boolean z) {
        this.needWithdraw = z;
    }
}
