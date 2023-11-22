package id.dana.data.saving.repository.source.network.request;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007"}, d2 = {"Lid/dana/data/saving/repository/source/network/request/UserSavingSummaryConsultRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Z", "", "component2", "()J", "component3", "needActiveSavings", "savingViewsPage", "savingViewsSize", "copy", "(ZJJ)Lid/dana/data/saving/repository/source/network/request/UserSavingSummaryConsultRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getNeedActiveSavings", "J", "getSavingViewsPage", "getSavingViewsSize", "<init>", "(ZJJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserSavingSummaryConsultRequest extends BaseRpcRequest {
    private final boolean needActiveSavings;
    private final long savingViewsPage;
    private final long savingViewsSize;

    public UserSavingSummaryConsultRequest() {
        this(false, 0L, 0L, 7, null);
    }

    public static /* synthetic */ UserSavingSummaryConsultRequest copy$default(UserSavingSummaryConsultRequest userSavingSummaryConsultRequest, boolean z, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = userSavingSummaryConsultRequest.needActiveSavings;
        }
        if ((i & 2) != 0) {
            j = userSavingSummaryConsultRequest.savingViewsPage;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = userSavingSummaryConsultRequest.savingViewsSize;
        }
        return userSavingSummaryConsultRequest.copy(z, j3, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getNeedActiveSavings() {
        return this.needActiveSavings;
    }

    /* renamed from: component2  reason: from getter */
    public final long getSavingViewsPage() {
        return this.savingViewsPage;
    }

    /* renamed from: component3  reason: from getter */
    public final long getSavingViewsSize() {
        return this.savingViewsSize;
    }

    public final UserSavingSummaryConsultRequest copy(boolean needActiveSavings, long savingViewsPage, long savingViewsSize) {
        return new UserSavingSummaryConsultRequest(needActiveSavings, savingViewsPage, savingViewsSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserSavingSummaryConsultRequest) {
            UserSavingSummaryConsultRequest userSavingSummaryConsultRequest = (UserSavingSummaryConsultRequest) other;
            return this.needActiveSavings == userSavingSummaryConsultRequest.needActiveSavings && this.savingViewsPage == userSavingSummaryConsultRequest.savingViewsPage && this.savingViewsSize == userSavingSummaryConsultRequest.savingViewsSize;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.needActiveSavings;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.savingViewsPage)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.savingViewsSize);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserSavingSummaryConsultRequest(needActiveSavings=");
        sb.append(this.needActiveSavings);
        sb.append(", savingViewsPage=");
        sb.append(this.savingViewsPage);
        sb.append(", savingViewsSize=");
        sb.append(this.savingViewsSize);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserSavingSummaryConsultRequest(boolean z, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 10L : j2);
    }

    @JvmName(name = "getNeedActiveSavings")
    public final boolean getNeedActiveSavings() {
        return this.needActiveSavings;
    }

    @JvmName(name = "getSavingViewsPage")
    public final long getSavingViewsPage() {
        return this.savingViewsPage;
    }

    @JvmName(name = "getSavingViewsSize")
    public final long getSavingViewsSize() {
        return this.savingViewsSize;
    }

    public UserSavingSummaryConsultRequest(boolean z, long j, long j2) {
        this.needActiveSavings = z;
        this.savingViewsPage = j;
        this.savingViewsSize = j2;
    }
}
