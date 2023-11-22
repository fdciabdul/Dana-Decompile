package id.dana.data.pushverify.source.model;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005"}, d2 = {"Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "Lid/dana/data/pushverify/source/model/VerificationDetailItemDTO;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "verificationList", "hasMore", "copy", "(Ljava/util/List;Z)Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getVerificationList", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerificationListResult extends BaseRpcResultAphome {
    private final boolean hasMore;
    private final List<VerificationDetailItemDTO> verificationList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushVerificationListResult copy$default(PushVerificationListResult pushVerificationListResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pushVerificationListResult.verificationList;
        }
        if ((i & 2) != 0) {
            z = pushVerificationListResult.hasMore;
        }
        return pushVerificationListResult.copy(list, z);
    }

    public final List<VerificationDetailItemDTO> component1() {
        return this.verificationList;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final PushVerificationListResult copy(List<VerificationDetailItemDTO> verificationList, boolean hasMore) {
        Intrinsics.checkNotNullParameter(verificationList, "");
        return new PushVerificationListResult(verificationList, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerificationListResult) {
            PushVerificationListResult pushVerificationListResult = (PushVerificationListResult) other;
            return Intrinsics.areEqual(this.verificationList, pushVerificationListResult.verificationList) && this.hasMore == pushVerificationListResult.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.verificationList.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerificationListResult(verificationList=");
        sb.append(this.verificationList);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PushVerificationListResult(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, z);
    }

    @JvmName(name = "getVerificationList")
    public final List<VerificationDetailItemDTO> getVerificationList() {
        return this.verificationList;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public PushVerificationListResult(List<VerificationDetailItemDTO> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.verificationList = list;
        this.hasMore = z;
    }
}
