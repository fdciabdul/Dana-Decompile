package id.dana.mybills.data.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "merchantId", "subscriptionId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMerchantId", "getSubscriptionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeleteSubscriptionRequest extends BaseRpcRequest {
    private final String merchantId;
    private final String subscriptionId;

    public static /* synthetic */ DeleteSubscriptionRequest copy$default(DeleteSubscriptionRequest deleteSubscriptionRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteSubscriptionRequest.merchantId;
        }
        if ((i & 2) != 0) {
            str2 = deleteSubscriptionRequest.subscriptionId;
        }
        return deleteSubscriptionRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final DeleteSubscriptionRequest copy(String merchantId, String subscriptionId) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(subscriptionId, "");
        return new DeleteSubscriptionRequest(merchantId, subscriptionId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DeleteSubscriptionRequest) {
            DeleteSubscriptionRequest deleteSubscriptionRequest = (DeleteSubscriptionRequest) other;
            return Intrinsics.areEqual(this.merchantId, deleteSubscriptionRequest.merchantId) && Intrinsics.areEqual(this.subscriptionId, deleteSubscriptionRequest.subscriptionId);
        }
        return false;
    }

    public final int hashCode() {
        return (this.merchantId.hashCode() * 31) + this.subscriptionId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeleteSubscriptionRequest(merchantId=");
        sb.append(this.merchantId);
        sb.append(", subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public DeleteSubscriptionRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.merchantId = str;
        this.subscriptionId = str2;
    }
}
