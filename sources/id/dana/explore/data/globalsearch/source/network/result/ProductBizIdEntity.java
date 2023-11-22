package id.dana.explore.data.globalsearch.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0004\b.\u0010/R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/ProductBizIdEntity;", "", "", "bizId", "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "customerName", "getCustomerName", "Lid/dana/explore/data/globalsearch/source/network/result/DenomEntity;", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "Lid/dana/explore/data/globalsearch/source/network/result/DenomEntity;", "getDenom", "()Lid/dana/explore/data/globalsearch/source/network/result/DenomEntity;", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "goodsId", "getGoodsId", "goodsTitle", "getGoodsTitle", "goodsType", "getGoodsType", "", "isGoodsActive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "productCode", "getProductCode", "setProductCode", "(Ljava/lang/String;)V", "productDesc", "getProductDesc", "setProductDesc", "profileKey", "getProfileKey", "provider", "getProvider", "providerName", "getProviderName", "secondaryBizId", "getSecondaryBizId", KybCpmConstants.TRANSACTION_DATE_PARAM, "getTransactionDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/globalsearch/source/network/result/DenomEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductBizIdEntity {
    @SerializedName("bizId")
    private final String bizId;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName(UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM)
    private final DenomEntity denom;
    @SerializedName("extendInfo")
    private final Map<String, Object> extendInfo;
    @SerializedName("goodsId")
    private final String goodsId;
    @SerializedName("goodsTitle")
    private final String goodsTitle;
    @SerializedName("goodsType")
    private final String goodsType;
    @SerializedName("isGoodsActive")
    private final Boolean isGoodsActive;
    @SerializedName("productCode")
    private String productCode;
    @SerializedName("productDesc")
    private String productDesc;
    @SerializedName("profileKey")
    private final String profileKey;
    @SerializedName("provider")
    private final String provider;
    @SerializedName("providerName")
    private final String providerName;
    @SerializedName("secondaryBizId")
    private final String secondaryBizId;
    @SerializedName(KybCpmConstants.TRANSACTION_DATE_PARAM)
    private final String transactionDate;

    public ProductBizIdEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public ProductBizIdEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, DenomEntity denomEntity, String str8, String str9, Boolean bool, String str10, String str11, String str12, Map<String, ? extends Object> map) {
        this.bizId = str;
        this.secondaryBizId = str2;
        this.transactionDate = str3;
        this.customerName = str4;
        this.goodsId = str5;
        this.goodsTitle = str6;
        this.goodsType = str7;
        this.denom = denomEntity;
        this.provider = str8;
        this.providerName = str9;
        this.isGoodsActive = bool;
        this.productCode = str10;
        this.productDesc = str11;
        this.profileKey = str12;
        this.extendInfo = map;
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    @JvmName(name = "getSecondaryBizId")
    public final String getSecondaryBizId() {
        return this.secondaryBizId;
    }

    @JvmName(name = "getTransactionDate")
    public final String getTransactionDate() {
        return this.transactionDate;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getDenom")
    public final DenomEntity getDenom() {
        return this.denom;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    public /* synthetic */ ProductBizIdEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, DenomEntity denomEntity, String str8, String str9, Boolean bool, String str10, String str11, String str12, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? null : denomEntity, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? Boolean.FALSE : bool, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) == 0 ? str12 : "", (i & 16384) != 0 ? MapsKt.emptyMap() : map);
    }

    @JvmName(name = "isGoodsActive")
    /* renamed from: isGoodsActive  reason: from getter */
    public final Boolean getIsGoodsActive() {
        return this.isGoodsActive;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "setProductCode")
    public final void setProductCode(String str) {
        this.productCode = str;
    }

    @JvmName(name = "getProductDesc")
    public final String getProductDesc() {
        return this.productDesc;
    }

    @JvmName(name = "setProductDesc")
    public final void setProductDesc(String str) {
        this.productDesc = str;
    }

    @JvmName(name = "getProfileKey")
    public final String getProfileKey() {
        return this.profileKey;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }
}
