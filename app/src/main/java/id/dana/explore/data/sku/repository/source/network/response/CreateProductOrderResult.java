package id.dana.explore.data.sku.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\t"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/CreateProductOrderResult;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "acquirementId", "checkoutUrl", "orderId", "success", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/explore/data/sku/repository/source/network/response/CreateProductOrderResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcquirementId", "getCheckoutUrl", "getOrderId", "Ljava/lang/Boolean;", "getSuccess", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateProductOrderResult implements Serializable {
    @SerializedName("acquir ementId")
    private final String acquirementId;
    @SerializedName("checkoutUrl")
    private final String checkoutUrl;
    @SerializedName("orderId")
    private final String orderId;
    @SerializedName("success")
    private final Boolean success;

    public CreateProductOrderResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreateProductOrderResult copy$default(CreateProductOrderResult createProductOrderResult, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createProductOrderResult.acquirementId;
        }
        if ((i & 2) != 0) {
            str2 = createProductOrderResult.checkoutUrl;
        }
        if ((i & 4) != 0) {
            str3 = createProductOrderResult.orderId;
        }
        if ((i & 8) != 0) {
            bool = createProductOrderResult.success;
        }
        return createProductOrderResult.copy(str, str2, str3, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final CreateProductOrderResult copy(String acquirementId, String checkoutUrl, String orderId, Boolean success) {
        return new CreateProductOrderResult(acquirementId, checkoutUrl, orderId, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateProductOrderResult) {
            CreateProductOrderResult createProductOrderResult = (CreateProductOrderResult) other;
            return Intrinsics.areEqual(this.acquirementId, createProductOrderResult.acquirementId) && Intrinsics.areEqual(this.checkoutUrl, createProductOrderResult.checkoutUrl) && Intrinsics.areEqual(this.orderId, createProductOrderResult.orderId) && Intrinsics.areEqual(this.success, createProductOrderResult.success);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.acquirementId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.checkoutUrl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.orderId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.success;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateProductOrderResult(acquirementId=");
        sb.append(this.acquirementId);
        sb.append(", checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public CreateProductOrderResult(String str, String str2, String str3, Boolean bool) {
        this.acquirementId = str;
        this.checkoutUrl = str2;
        this.orderId = str3;
        this.success = bool;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    public /* synthetic */ CreateProductOrderResult(String str, String str2, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }
}
