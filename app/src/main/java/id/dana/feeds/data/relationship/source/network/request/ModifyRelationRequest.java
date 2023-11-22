package id.dana.feeds.data.relationship.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/request/ModifyRelationRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "targetUserId", "operationType", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/request/ModifyRelationRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getOperationType", "getTargetUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModifyRelationRequest extends BaseRpcRequest {
    private final String operationType;
    private final String targetUserId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ModifyRelationRequest() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.relationship.source.network.request.ModifyRelationRequest.<init>():void");
    }

    public static /* synthetic */ ModifyRelationRequest copy$default(ModifyRelationRequest modifyRelationRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modifyRelationRequest.targetUserId;
        }
        if ((i & 2) != 0) {
            str2 = modifyRelationRequest.operationType;
        }
        return modifyRelationRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTargetUserId() {
        return this.targetUserId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getOperationType() {
        return this.operationType;
    }

    public final ModifyRelationRequest copy(String targetUserId, String operationType) {
        Intrinsics.checkNotNullParameter(targetUserId, "");
        Intrinsics.checkNotNullParameter(operationType, "");
        return new ModifyRelationRequest(targetUserId, operationType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ModifyRelationRequest) {
            ModifyRelationRequest modifyRelationRequest = (ModifyRelationRequest) other;
            return Intrinsics.areEqual(this.targetUserId, modifyRelationRequest.targetUserId) && Intrinsics.areEqual(this.operationType, modifyRelationRequest.operationType);
        }
        return false;
    }

    public final int hashCode() {
        return (this.targetUserId.hashCode() * 31) + this.operationType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ModifyRelationRequest(targetUserId=");
        sb.append(this.targetUserId);
        sb.append(", operationType=");
        sb.append(this.operationType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ModifyRelationRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @JvmName(name = "getTargetUserId")
    public final String getTargetUserId() {
        return this.targetUserId;
    }

    @JvmName(name = "getOperationType")
    public final String getOperationType() {
        return this.operationType;
    }

    public ModifyRelationRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.targetUserId = str;
        this.operationType = str2;
    }
}
