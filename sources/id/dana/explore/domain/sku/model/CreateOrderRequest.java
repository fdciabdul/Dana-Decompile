package id.dana.explore.domain.sku.model;

import id.dana.data.constant.UrlParam;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jf\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/explore/domain/sku/model/CreateOrderRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "Lid/dana/domain/nearbyme/model/MoneyView;", "component7", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component8", "productCode", "goodsId", "aggregatorGoodsId", UrlParam.REQUEST_ID, "param", "secondaryBizParam", "amount", "bizType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)Lid/dana/explore/domain/sku/model/CreateOrderRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAmount", "getBizType", "getGoodsId", "getParam", "getProductCode", "getRequestId", "getSecondaryBizParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class CreateOrderRequest {
    private final String aggregatorGoodsId;
    private final MoneyView amount;
    private final String bizType;
    private final String goodsId;
    private final String param;
    private final String productCode;
    private final String requestId;
    private final String secondaryBizParam;

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
    public final MoneyView getAmount() {
        return this.amount;
    }

    /* renamed from: component8  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    public final CreateOrderRequest copy(String productCode, String goodsId, String aggregatorGoodsId, String requestId, String param, String secondaryBizParam, MoneyView amount, String bizType) {
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        return new CreateOrderRequest(productCode, goodsId, aggregatorGoodsId, requestId, param, secondaryBizParam, amount, bizType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderRequest) {
            CreateOrderRequest createOrderRequest = (CreateOrderRequest) other;
            return Intrinsics.areEqual(this.productCode, createOrderRequest.productCode) && Intrinsics.areEqual(this.goodsId, createOrderRequest.goodsId) && Intrinsics.areEqual(this.aggregatorGoodsId, createOrderRequest.aggregatorGoodsId) && Intrinsics.areEqual(this.requestId, createOrderRequest.requestId) && Intrinsics.areEqual(this.param, createOrderRequest.param) && Intrinsics.areEqual(this.secondaryBizParam, createOrderRequest.secondaryBizParam) && Intrinsics.areEqual(this.amount, createOrderRequest.amount) && Intrinsics.areEqual(this.bizType, createOrderRequest.bizType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.productCode.hashCode();
        int hashCode2 = this.goodsId.hashCode();
        String str = this.aggregatorGoodsId;
        int hashCode3 = str == null ? 0 : str.hashCode();
        int hashCode4 = this.requestId.hashCode();
        int hashCode5 = this.param.hashCode();
        String str2 = this.secondaryBizParam;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        MoneyView moneyView = this.amount;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (moneyView != null ? moneyView.hashCode() : 0)) * 31) + this.bizType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderRequest(productCode=");
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

    public CreateOrderRequest(String str, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.productCode = str;
        this.goodsId = str2;
        this.aggregatorGoodsId = str3;
        this.requestId = str4;
        this.param = str5;
        this.secondaryBizParam = str6;
        this.amount = moneyView;
        this.bizType = str7;
    }

    public /* synthetic */ CreateOrderRequest(String str, String str2, String str3, String str4, String str5, String str6, MoneyView moneyView, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4, str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : moneyView, str7);
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getParam")
    public final String getParam() {
        return this.param;
    }

    @JvmName(name = "getSecondaryBizParam")
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    @JvmName(name = "getAmount")
    public final MoneyView getAmount() {
        return this.amount;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }
}
