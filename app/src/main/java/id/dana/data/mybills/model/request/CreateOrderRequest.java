package id.dana.data.mybills.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b!\u0010\u0004"}, d2 = {"Lid/dana/data/mybills/model/request/CreateOrderRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component5", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "productCode", "goodsId", UrlParam.REQUEST_ID, "param", "amount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/mybills/model/request/CreateOrderRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAmount", "Ljava/lang/String;", "getGoodsId", "getParam", "getProductCode", "getRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderRequest extends BaseRpcRequest {
    private final MoneyViewEntity amount;
    private final String goodsId;
    private final String param;
    private final String productCode;
    private final String requestId;

    public static /* synthetic */ CreateOrderRequest copy$default(CreateOrderRequest createOrderRequest, String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderRequest.productCode;
        }
        if ((i & 2) != 0) {
            str2 = createOrderRequest.goodsId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = createOrderRequest.requestId;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = createOrderRequest.param;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            moneyViewEntity = createOrderRequest.amount;
        }
        return createOrderRequest.copy(str, str5, str6, str7, moneyViewEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getParam() {
        return this.param;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    public final CreateOrderRequest copy(String productCode, String goodsId, String requestId, String param, MoneyViewEntity amount) {
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(amount, "");
        return new CreateOrderRequest(productCode, goodsId, requestId, param, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderRequest) {
            CreateOrderRequest createOrderRequest = (CreateOrderRequest) other;
            return Intrinsics.areEqual(this.productCode, createOrderRequest.productCode) && Intrinsics.areEqual(this.goodsId, createOrderRequest.goodsId) && Intrinsics.areEqual(this.requestId, createOrderRequest.requestId) && Intrinsics.areEqual(this.param, createOrderRequest.param) && Intrinsics.areEqual(this.amount, createOrderRequest.amount);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.productCode.hashCode() * 31) + this.goodsId.hashCode()) * 31) + this.requestId.hashCode()) * 31) + this.param.hashCode()) * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderRequest(productCode=");
        sb.append(this.productCode);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", param=");
        sb.append(this.param);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getParam")
    public final String getParam() {
        return this.param;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    public CreateOrderRequest(String str, String str2, String str3, String str4, MoneyViewEntity moneyViewEntity) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.productCode = str;
        this.goodsId = str2;
        this.requestId = str3;
        this.param = str4;
        this.amount = moneyViewEntity;
    }
}
