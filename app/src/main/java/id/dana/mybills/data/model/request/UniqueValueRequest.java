package id.dana.mybills.data.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/request/UniqueValueRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "ipRoleId", "billId", "goodsType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/data/model/request/UniqueValueRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillId", "getGoodsType", "getIpRoleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UniqueValueRequest extends BaseRpcRequest {
    private final String billId;
    private final String goodsType;
    private final String ipRoleId;

    public static /* synthetic */ UniqueValueRequest copy$default(UniqueValueRequest uniqueValueRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uniqueValueRequest.ipRoleId;
        }
        if ((i & 2) != 0) {
            str2 = uniqueValueRequest.billId;
        }
        if ((i & 4) != 0) {
            str3 = uniqueValueRequest.goodsType;
        }
        return uniqueValueRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBillId() {
        return this.billId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    public final UniqueValueRequest copy(String ipRoleId, String billId, String goodsType) {
        Intrinsics.checkNotNullParameter(ipRoleId, "");
        Intrinsics.checkNotNullParameter(goodsType, "");
        return new UniqueValueRequest(ipRoleId, billId, goodsType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UniqueValueRequest) {
            UniqueValueRequest uniqueValueRequest = (UniqueValueRequest) other;
            return Intrinsics.areEqual(this.ipRoleId, uniqueValueRequest.ipRoleId) && Intrinsics.areEqual(this.billId, uniqueValueRequest.billId) && Intrinsics.areEqual(this.goodsType, uniqueValueRequest.goodsType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.ipRoleId.hashCode();
        String str = this.billId;
        return (((hashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.goodsType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UniqueValueRequest(ipRoleId=");
        sb.append(this.ipRoleId);
        sb.append(", billId=");
        sb.append(this.billId);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UniqueValueRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, str3);
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    public UniqueValueRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.ipRoleId = str;
        this.billId = str2;
        this.goodsType = str3;
    }
}
