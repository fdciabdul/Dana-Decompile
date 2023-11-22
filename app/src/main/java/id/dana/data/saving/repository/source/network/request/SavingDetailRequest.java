package id.dana.data.saving.repository.source.network.request;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007"}, d2 = {"Lid/dana/data/saving/repository/source/network/request/SavingDetailRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "savingId", "topUpViewsPage", "topUpViewsSize", "copy", "(Ljava/lang/String;JJ)Lid/dana/data/saving/repository/source/network/request/SavingDetailRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSavingId", "J", "getTopUpViewsPage", "getTopUpViewsSize", "<init>", "(Ljava/lang/String;JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingDetailRequest extends BaseRpcRequest {
    private final String savingId;
    private final long topUpViewsPage;
    private final long topUpViewsSize;

    public static /* synthetic */ SavingDetailRequest copy$default(SavingDetailRequest savingDetailRequest, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = savingDetailRequest.savingId;
        }
        if ((i & 2) != 0) {
            j = savingDetailRequest.topUpViewsPage;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = savingDetailRequest.topUpViewsSize;
        }
        return savingDetailRequest.copy(str, j3, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component2  reason: from getter */
    public final long getTopUpViewsPage() {
        return this.topUpViewsPage;
    }

    /* renamed from: component3  reason: from getter */
    public final long getTopUpViewsSize() {
        return this.topUpViewsSize;
    }

    public final SavingDetailRequest copy(String savingId, long topUpViewsPage, long topUpViewsSize) {
        Intrinsics.checkNotNullParameter(savingId, "");
        return new SavingDetailRequest(savingId, topUpViewsPage, topUpViewsSize);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingDetailRequest) {
            SavingDetailRequest savingDetailRequest = (SavingDetailRequest) other;
            return Intrinsics.areEqual(this.savingId, savingDetailRequest.savingId) && this.topUpViewsPage == savingDetailRequest.topUpViewsPage && this.topUpViewsSize == savingDetailRequest.topUpViewsSize;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.savingId.hashCode() * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.topUpViewsPage)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.topUpViewsSize);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingDetailRequest(savingId=");
        sb.append(this.savingId);
        sb.append(", topUpViewsPage=");
        sb.append(this.topUpViewsPage);
        sb.append(", topUpViewsSize=");
        sb.append(this.topUpViewsSize);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getTopUpViewsPage")
    public final long getTopUpViewsPage() {
        return this.topUpViewsPage;
    }

    @JvmName(name = "getTopUpViewsSize")
    public final long getTopUpViewsSize() {
        return this.topUpViewsSize;
    }

    public SavingDetailRequest(String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.savingId = str;
        this.topUpViewsPage = j;
        this.topUpViewsSize = j2;
    }
}
