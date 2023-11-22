package id.dana.sendmoney.data.api.groupsend.detail.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "bizType", "groupId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getGroupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupDetailEntityRequest extends BaseRpcRequest {
    private final String bizType;
    private final String groupId;

    public static /* synthetic */ BizGroupDetailEntityRequest copy$default(BizGroupDetailEntityRequest bizGroupDetailEntityRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizGroupDetailEntityRequest.bizType;
        }
        if ((i & 2) != 0) {
            str2 = bizGroupDetailEntityRequest.groupId;
        }
        return bizGroupDetailEntityRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final BizGroupDetailEntityRequest copy(String bizType, String groupId) {
        return new BizGroupDetailEntityRequest(bizType, groupId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupDetailEntityRequest) {
            BizGroupDetailEntityRequest bizGroupDetailEntityRequest = (BizGroupDetailEntityRequest) other;
            return Intrinsics.areEqual(this.bizType, bizGroupDetailEntityRequest.bizType) && Intrinsics.areEqual(this.groupId, bizGroupDetailEntityRequest.groupId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.groupId;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupDetailEntityRequest(bizType=");
        sb.append(this.bizType);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
    }

    public BizGroupDetailEntityRequest(String str, String str2) {
        this.bizType = str;
        this.groupId = str2;
    }
}
