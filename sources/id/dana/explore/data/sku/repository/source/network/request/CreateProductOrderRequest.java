package id.dana.explore.data.sku.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.data.constant.UrlParam;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.explore.data.sku.repository.source.network.response.BizDestinationInquiryInfo;
import id.dana.explore.data.sku.repository.source.network.response.BizDestinationInquiryResult;
import id.dana.explore.data.sku.repository.source.network.response.MultiCurrencyMoney;
import id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BK\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component3", "()Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component4", "component5", "component6", "Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;", "component7", "()Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;", UrlParam.REQUEST_ID, "aggregatorGoodsId", "amount", "goodsId", "param", "productCode", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;)Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "getAmount", "Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;", "getExtendInfo", "getGoodsId", "getParam", "getProductCode", "getRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateProductOrderRequest extends BaseRpcRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("aggregatorGoodsId")
    private final String aggregatorGoodsId;
    @SerializedName("amount")
    private final MultiCurrencyMoney amount;
    @SerializedName("extendInfo")
    private final CreateProductOrderExtendInfo extendInfo;
    @SerializedName("goodsId")
    private final String goodsId;
    @SerializedName("param")
    private final String param;
    @SerializedName("productCode")
    private final String productCode;
    @SerializedName(UrlParam.REQUEST_ID)
    private final String requestId;

    public static /* synthetic */ CreateProductOrderRequest copy$default(CreateProductOrderRequest createProductOrderRequest, String str, String str2, MultiCurrencyMoney multiCurrencyMoney, String str3, String str4, String str5, CreateProductOrderExtendInfo createProductOrderExtendInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createProductOrderRequest.requestId;
        }
        if ((i & 2) != 0) {
            str2 = createProductOrderRequest.aggregatorGoodsId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            multiCurrencyMoney = createProductOrderRequest.amount;
        }
        MultiCurrencyMoney multiCurrencyMoney2 = multiCurrencyMoney;
        if ((i & 8) != 0) {
            str3 = createProductOrderRequest.goodsId;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = createProductOrderRequest.param;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = createProductOrderRequest.productCode;
        }
        String str9 = str5;
        if ((i & 64) != 0) {
            createProductOrderExtendInfo = createProductOrderRequest.extendInfo;
        }
        return createProductOrderRequest.copy(str, str6, multiCurrencyMoney2, str7, str8, str9, createProductOrderExtendInfo);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    /* renamed from: component3  reason: from getter */
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getParam() {
        return this.param;
    }

    /* renamed from: component6  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component7  reason: from getter */
    public final CreateProductOrderExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public final CreateProductOrderRequest copy(String r10, String aggregatorGoodsId, MultiCurrencyMoney amount, String goodsId, String param, String productCode, CreateProductOrderExtendInfo extendInfo) {
        Intrinsics.checkNotNullParameter(r10, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(productCode, "");
        return new CreateProductOrderRequest(r10, aggregatorGoodsId, amount, goodsId, param, productCode, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateProductOrderRequest) {
            CreateProductOrderRequest createProductOrderRequest = (CreateProductOrderRequest) other;
            return Intrinsics.areEqual(this.requestId, createProductOrderRequest.requestId) && Intrinsics.areEqual(this.aggregatorGoodsId, createProductOrderRequest.aggregatorGoodsId) && Intrinsics.areEqual(this.amount, createProductOrderRequest.amount) && Intrinsics.areEqual(this.goodsId, createProductOrderRequest.goodsId) && Intrinsics.areEqual(this.param, createProductOrderRequest.param) && Intrinsics.areEqual(this.productCode, createProductOrderRequest.productCode) && Intrinsics.areEqual(this.extendInfo, createProductOrderRequest.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.requestId.hashCode();
        String str = this.aggregatorGoodsId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        MultiCurrencyMoney multiCurrencyMoney = this.amount;
        int hashCode3 = multiCurrencyMoney == null ? 0 : multiCurrencyMoney.hashCode();
        int hashCode4 = this.goodsId.hashCode();
        int hashCode5 = this.param.hashCode();
        int hashCode6 = this.productCode.hashCode();
        CreateProductOrderExtendInfo createProductOrderExtendInfo = this.extendInfo;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (createProductOrderExtendInfo != null ? createProductOrderExtendInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateProductOrderRequest(requestId=");
        sb.append(this.requestId);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", param=");
        sb.append(this.param);
        sb.append(", productCode=");
        sb.append(this.productCode);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ CreateProductOrderRequest(String str, String str2, MultiCurrencyMoney multiCurrencyMoney, String str3, String str4, String str5, CreateProductOrderExtendInfo createProductOrderExtendInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : multiCurrencyMoney, str3, str4, str5, (i & 64) != 0 ? null : createProductOrderExtendInfo);
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getAmount")
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getParam")
    public final String getParam() {
        return this.param;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getExtendInfo")
    public final CreateProductOrderExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public CreateProductOrderRequest(String str, String str2, MultiCurrencyMoney multiCurrencyMoney, String str3, String str4, String str5, CreateProductOrderExtendInfo createProductOrderExtendInfo) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.requestId = str;
        this.aggregatorGoodsId = str2;
        this.amount = multiCurrencyMoney;
        this.goodsId = str3;
        this.param = str4;
        this.productCode = str5;
        this.extendInfo = createProductOrderExtendInfo;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest$Companion;", "", "Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryResult;", "result", "Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "transRes", "Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "forElectricity", "(Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryResult;Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;)Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "fromLastSuccesfulTransaction", "(Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;)Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateProductOrderRequest fromLastSuccesfulTransaction(QueryLastSuccessfulTransactionResponse result) {
            BizIds bizIds;
            BizIds bizIds2;
            Intrinsics.checkNotNullParameter(result, "");
            List<BizIds> bizIds3 = result.getBizIds();
            String str = null;
            String goodsId = (bizIds3 == null || (bizIds2 = (BizIds) CollectionsKt.firstOrNull((List) bizIds3)) == null) ? null : bizIds2.getGoodsId();
            String str2 = goodsId == null ? "" : goodsId;
            List<BizIds> bizIds4 = result.getBizIds();
            if (bizIds4 != null && (bizIds = (BizIds) CollectionsKt.firstOrNull((List) bizIds4)) != null) {
                str = bizIds.getBizId();
            }
            String str3 = str == null ? "" : str;
            String obj = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return new CreateProductOrderRequest(obj, null, null, str2, str3, "PULSA_PREPAID", null, 70, null);
        }

        public final CreateProductOrderRequest forElectricity(BizDestinationInquiryResult result, QueryLastSuccessfulTransactionResponse transRes) {
            MultiCurrencyMoney multiCurrencyMoney;
            MultiCurrencyMoney multiCurrencyMoney2;
            BizDestinationInquiryInfo bizDestinationInquiryInfo;
            BizDestinationInquiryInfo bizDestinationInquiryInfo2;
            BizDestinationInquiryInfo bizDestinationInquiryInfo3;
            BizDestinationInquiryInfo bizDestinationInquiryInfo4;
            BizDestinationInquiryInfo bizDestinationInquiryInfo5;
            BizDestinationInquiryInfo bizDestinationInquiryInfo6;
            BizIds bizIds;
            BizIds bizIds2;
            BizIds bizIds3;
            Intrinsics.checkNotNullParameter(result, "");
            Intrinsics.checkNotNullParameter(transRes, "");
            List<BizIds> bizIds4 = transRes.getBizIds();
            String goodsId = (bizIds4 == null || (bizIds3 = (BizIds) CollectionsKt.firstOrNull((List) bizIds4)) == null) ? null : bizIds3.getGoodsId();
            String str = goodsId == null ? "" : goodsId;
            List<BizIds> bizIds5 = transRes.getBizIds();
            String bizId = (bizIds5 == null || (bizIds2 = (BizIds) CollectionsKt.firstOrNull((List) bizIds5)) == null) ? null : bizIds2.getBizId();
            String str2 = bizId == null ? "" : bizId;
            List<BizIds> bizIds6 = transRes.getBizIds();
            String goodsType = (bizIds6 == null || (bizIds = (BizIds) CollectionsKt.firstOrNull((List) bizIds6)) == null) ? null : bizIds.getGoodsType();
            String str3 = goodsType == null ? "" : goodsType;
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos = result.getDigitalDestinationInquiryInfos();
            if (digitalDestinationInquiryInfos == null || (bizDestinationInquiryInfo6 = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos)) == null || (multiCurrencyMoney = bizDestinationInquiryInfo6.getTotalAmount()) == null) {
                multiCurrencyMoney = new MultiCurrencyMoney(null, null, null, null, null, null, null, null, 255, null);
            }
            MultiCurrencyMoney multiCurrencyMoney3 = multiCurrencyMoney;
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos2 = result.getDigitalDestinationInquiryInfos();
            if (digitalDestinationInquiryInfos2 == null || (bizDestinationInquiryInfo5 = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos2)) == null || (multiCurrencyMoney2 = bizDestinationInquiryInfo5.getAdminFee()) == null) {
                multiCurrencyMoney2 = new MultiCurrencyMoney(null, null, null, null, null, null, null, null, 255, null);
            }
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos3 = result.getDigitalDestinationInquiryInfos();
            String customerName = (digitalDestinationInquiryInfos3 == null || (bizDestinationInquiryInfo4 = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos3)) == null) ? null : bizDestinationInquiryInfo4.getCustomerName();
            String str4 = customerName == null ? "" : customerName;
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos4 = result.getDigitalDestinationInquiryInfos();
            String inquiryId = (digitalDestinationInquiryInfos4 == null || (bizDestinationInquiryInfo3 = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos4)) == null) ? null : bizDestinationInquiryInfo3.getInquiryId();
            String str5 = inquiryId == null ? "" : inquiryId;
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos5 = result.getDigitalDestinationInquiryInfos();
            String fare = (digitalDestinationInquiryInfos5 == null || (bizDestinationInquiryInfo2 = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos5)) == null) ? null : bizDestinationInquiryInfo2.getFare();
            String str6 = fare == null ? "" : fare;
            List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos6 = result.getDigitalDestinationInquiryInfos();
            String totalEnergy = (digitalDestinationInquiryInfos6 == null || (bizDestinationInquiryInfo = (BizDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos6)) == null) ? null : bizDestinationInquiryInfo.getTotalEnergy();
            String str7 = totalEnergy == null ? "" : totalEnergy;
            String aggregatorGoodsId = result.getAggregatorGoodsId();
            String str8 = aggregatorGoodsId == null ? "" : aggregatorGoodsId;
            String obj = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            StringBuilder sb = new StringBuilder();
            String amount = multiCurrencyMoney2.getAmount();
            sb.append(amount != null ? StringsKt.replace$default(amount, ".", "", false, 4, (Object) null) : null);
            sb.append("00");
            return new CreateProductOrderRequest(obj, str8, multiCurrencyMoney3, str, str2, str3, new CreateProductOrderExtendInfo(new MultiCurrencyMoney(null, null, null, GlobalNetworkConstants.IDR_CURRENCY, null, null, null, sb.toString(), 119, null), str4, str6, str5, str7));
        }
    }
}
