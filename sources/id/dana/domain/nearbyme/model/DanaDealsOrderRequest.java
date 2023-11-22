package id.dana.domain.nearbyme.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JX\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component7", "productCode", "goodsId", "aggregatorGoodsId", UrlParam.REQUEST_ID, "secondaryBizParam", FirebaseAnalytics.Param.PRICE, "bizType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "getBizType", "getGoodsId", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPrice", "getProductCode", "getRequestId", "getSecondaryBizParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DanaDealsOrderRequest {
    private final String aggregatorGoodsId;
    private final String bizType;
    private final String goodsId;
    private final MoneyView price;
    private final String productCode;
    private final String requestId;
    private final String secondaryBizParam;

    public static /* synthetic */ DanaDealsOrderRequest copy$default(DanaDealsOrderRequest danaDealsOrderRequest, String str, String str2, String str3, String str4, String str5, MoneyView moneyView, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = danaDealsOrderRequest.productCode;
        }
        if ((i & 2) != 0) {
            str2 = danaDealsOrderRequest.goodsId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = danaDealsOrderRequest.aggregatorGoodsId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = danaDealsOrderRequest.requestId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = danaDealsOrderRequest.secondaryBizParam;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            moneyView = danaDealsOrderRequest.price;
        }
        MoneyView moneyView2 = moneyView;
        if ((i & 64) != 0) {
            str6 = danaDealsOrderRequest.bizType;
        }
        return danaDealsOrderRequest.copy(str, str7, str8, str9, str10, moneyView2, str6);
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
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getPrice() {
        return this.price;
    }

    /* renamed from: component7  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    public final DanaDealsOrderRequest copy(String productCode, String goodsId, String aggregatorGoodsId, String requestId, String secondaryBizParam, MoneyView price, String bizType) {
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(price, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        return new DanaDealsOrderRequest(productCode, goodsId, aggregatorGoodsId, requestId, secondaryBizParam, price, bizType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaDealsOrderRequest) {
            DanaDealsOrderRequest danaDealsOrderRequest = (DanaDealsOrderRequest) other;
            return Intrinsics.areEqual(this.productCode, danaDealsOrderRequest.productCode) && Intrinsics.areEqual(this.goodsId, danaDealsOrderRequest.goodsId) && Intrinsics.areEqual(this.aggregatorGoodsId, danaDealsOrderRequest.aggregatorGoodsId) && Intrinsics.areEqual(this.requestId, danaDealsOrderRequest.requestId) && Intrinsics.areEqual(this.secondaryBizParam, danaDealsOrderRequest.secondaryBizParam) && Intrinsics.areEqual(this.price, danaDealsOrderRequest.price) && Intrinsics.areEqual(this.bizType, danaDealsOrderRequest.bizType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.productCode.hashCode();
        int hashCode2 = this.goodsId.hashCode();
        int hashCode3 = this.aggregatorGoodsId.hashCode();
        int hashCode4 = this.requestId.hashCode();
        String str = this.secondaryBizParam;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.price.hashCode()) * 31) + this.bizType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaDealsOrderRequest(productCode=");
        sb.append(this.productCode);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", secondaryBizParam=");
        sb.append(this.secondaryBizParam);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(')');
        return sb.toString();
    }

    public DanaDealsOrderRequest(String str, String str2, String str3, String str4, String str5, MoneyView moneyView, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.productCode = str;
        this.goodsId = str2;
        this.aggregatorGoodsId = str3;
        this.requestId = str4;
        this.secondaryBizParam = str5;
        this.price = moneyView;
        this.bizType = str6;
    }

    public /* synthetic */ DanaDealsOrderRequest(String str, String str2, String str3, String str4, String str5, MoneyView moneyView, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, str4, str5, moneyView, str6);
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

    @JvmName(name = "getSecondaryBizParam")
    public final String getSecondaryBizParam() {
        return this.secondaryBizParam;
    }

    @JvmName(name = "getPrice")
    public final MoneyView getPrice() {
        return this.price;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }
}
