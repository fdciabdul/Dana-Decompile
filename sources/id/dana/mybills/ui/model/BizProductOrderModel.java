package id.dana.mybills.ui.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/BizProductOrderModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "checkoutUrl", "orderId", "acquirementId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/ui/model/BizProductOrderModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcquirementId", "getCheckoutUrl", "getOrderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BizProductOrderModel {
    private final String acquirementId;
    private final String checkoutUrl;
    private final String orderId;

    public static /* synthetic */ BizProductOrderModel copy$default(BizProductOrderModel bizProductOrderModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizProductOrderModel.checkoutUrl;
        }
        if ((i & 2) != 0) {
            str2 = bizProductOrderModel.orderId;
        }
        if ((i & 4) != 0) {
            str3 = bizProductOrderModel.acquirementId;
        }
        return bizProductOrderModel.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    public final BizProductOrderModel copy(String checkoutUrl, String orderId, String acquirementId) {
        Intrinsics.checkNotNullParameter(checkoutUrl, "");
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(acquirementId, "");
        return new BizProductOrderModel(checkoutUrl, orderId, acquirementId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizProductOrderModel) {
            BizProductOrderModel bizProductOrderModel = (BizProductOrderModel) other;
            return Intrinsics.areEqual(this.checkoutUrl, bizProductOrderModel.checkoutUrl) && Intrinsics.areEqual(this.orderId, bizProductOrderModel.orderId) && Intrinsics.areEqual(this.acquirementId, bizProductOrderModel.acquirementId);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.checkoutUrl.hashCode() * 31) + this.orderId.hashCode()) * 31) + this.acquirementId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizProductOrderModel(checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", acquirementId=");
        sb.append(this.acquirementId);
        sb.append(')');
        return sb.toString();
    }

    public BizProductOrderModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.checkoutUrl = str;
        this.orderId = str2;
        this.acquirementId = str3;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }
}
