package id.dana.data.nearbyme.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jb\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u0014\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010(R\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010$R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010$R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010$R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010$R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010!\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010$"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component7", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component8", "productCode", "goodsId", "aggregatorGoodsId", UrlParam.REQUEST_ID, "param", "secondaryBizParam", "amount", "bizType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "setAggregatorGoodsId", "(Ljava/lang/String;)V", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAmount", "setAmount", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V", "getBizType", "setBizType", "getGoodsId", "setGoodsId", "getParam", "setParam", "getProductCode", "setProductCode", "getRequestId", "setRequestId", "getSecondaryBizParam", "setSecondaryBizParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProductOrderRequest extends BaseRpcRequest {
    private String aggregatorGoodsId;
    private MoneyViewEntity amount;
    private String bizType;
    private String goodsId;
    private String param;
    private String productCode;
    private String requestId;
    private String secondaryBizParam;

    /* renamed from: component1  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getParam() {
        return this.param;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    /* renamed from: component8  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    public final ProductOrderRequest copy(String productCode, String goodsId, String aggregatorGoodsId, String requestId, String param, String secondaryBizParam, MoneyViewEntity amount, String bizType) {
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        return new ProductOrderRequest(productCode, goodsId, aggregatorGoodsId, requestId, param, secondaryBizParam, amount, bizType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProductOrderRequest) {
            ProductOrderRequest productOrderRequest = (ProductOrderRequest) other;
            return Intrinsics.areEqual(this.productCode, productOrderRequest.productCode) && Intrinsics.areEqual(this.goodsId, productOrderRequest.goodsId) && Intrinsics.areEqual(this.aggregatorGoodsId, productOrderRequest.aggregatorGoodsId) && Intrinsics.areEqual(this.requestId, productOrderRequest.requestId) && Intrinsics.areEqual(this.param, productOrderRequest.param) && Intrinsics.areEqual(this.secondaryBizParam, productOrderRequest.secondaryBizParam) && Intrinsics.areEqual(this.amount, productOrderRequest.amount) && Intrinsics.areEqual(this.bizType, productOrderRequest.bizType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.productCode.hashCode();
        int hashCode2 = this.goodsId.hashCode();
        int hashCode3 = this.aggregatorGoodsId.hashCode();
        int hashCode4 = this.requestId.hashCode();
        int hashCode5 = this.param.hashCode();
        String str = this.secondaryBizParam;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.amount.hashCode()) * 31) + this.bizType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductOrderRequest(productCode=");
        sb.append(this.productCode);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", param=");
        sb.append(this.param);
        sb.append(", secondaryBizParam=");
        sb.append(this.secondaryBizParam);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "setProductCode")
    public final void setProductCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.productCode = str;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "setGoodsId")
    public final void setGoodsId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.goodsId = str;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "setAggregatorGoodsId")
    public final void setAggregatorGoodsId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.aggregatorGoodsId = str;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "setRequestId")
    public final void setRequestId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.requestId = str;
    }

    @JvmName(name = "getParam")
    public final String getParam() {
        return this.param;
    }

    @JvmName(name = "setParam")
    public final void setParam(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.param = str;
    }

    @JvmName(name = "getSecondaryBizParam")
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    @JvmName(name = "setSecondaryBizParam")
    public final void setSecondaryBizParam(String str) {
        this.secondaryBizParam = str;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(MoneyViewEntity moneyViewEntity) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.amount = moneyViewEntity;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizType = str;
    }

    public ProductOrderRequest(String str, String str2, String str3, String str4, String str5, String str6, MoneyViewEntity moneyViewEntity, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.productCode = str;
        this.goodsId = str2;
        this.aggregatorGoodsId = str3;
        this.requestId = str4;
        this.param = str5;
        this.secondaryBizParam = str6;
        this.amount = moneyViewEntity;
        this.bizType = str7;
    }
}
