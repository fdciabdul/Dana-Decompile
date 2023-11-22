package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "orderId", "copy", "(Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getOrderId", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GetCashierKybProductEntityRequest extends BaseRpcRequest {
    @SerializedName("orderId")
    private final String orderId;

    public static /* synthetic */ GetCashierKybProductEntityRequest copy$default(GetCashierKybProductEntityRequest getCashierKybProductEntityRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCashierKybProductEntityRequest.orderId;
        }
        return getCashierKybProductEntityRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    public final GetCashierKybProductEntityRequest copy(String orderId) {
        return new GetCashierKybProductEntityRequest(orderId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetCashierKybProductEntityRequest) && Intrinsics.areEqual(this.orderId, ((GetCashierKybProductEntityRequest) other).orderId);
    }

    public final int hashCode() {
        String str = this.orderId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetCashierKybProductEntityRequest(orderId=");
        sb.append(this.orderId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    public GetCashierKybProductEntityRequest(String str) {
        this.orderId = str;
    }
}
