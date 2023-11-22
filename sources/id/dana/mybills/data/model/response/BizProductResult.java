package id.dana.mybills.data.model.response;

import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000bR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0016"}, d2 = {"Lid/dana/mybills/data/model/response/BizProductResult;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/Map;", "component11", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "", "component9", "()Ljava/lang/Long;", "bizId", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsTitle", "goodsType", "isGoodsActive", "provider", "providerName", KybCpmConstants.TRANSACTION_DATE_PARAM, "extendInfo", "customerName", "copy", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;)Lid/dana/mybills/data/model/response/BizProductResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizId", "getCustomerName", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDenom", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getGoodsTitle", "getGoodsType", "Ljava/lang/Boolean;", "getProvider", "getProviderName", "Ljava/lang/Long;", "getTransactionDate", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizProductResult {
    private final String bizId;
    private final String customerName;
    private final MoneyViewEntity denom;
    private final Map<String, Object> extendInfo;
    private final String goodsId;
    private final String goodsTitle;
    private final String goodsType;
    private final Boolean isGoodsActive;
    private final String provider;
    private final String providerName;
    private final Long transactionDate;

    /* renamed from: component1  reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    public final Map<String, Object> component10() {
        return this.extendInfo;
    }

    /* renamed from: component11  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getDenom() {
        return this.denom;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getIsGoodsActive() {
        return this.isGoodsActive;
    }

    /* renamed from: component7  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component8  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component9  reason: from getter */
    public final Long getTransactionDate() {
        return this.transactionDate;
    }

    public final BizProductResult copy(String bizId, MoneyViewEntity denom, String goodsId, String goodsTitle, String goodsType, Boolean isGoodsActive, String provider, String providerName, Long transactionDate, Map<String, ? extends Object> extendInfo, String customerName) {
        return new BizProductResult(bizId, denom, goodsId, goodsTitle, goodsType, isGoodsActive, provider, providerName, transactionDate, extendInfo, customerName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizProductResult) {
            BizProductResult bizProductResult = (BizProductResult) other;
            return Intrinsics.areEqual(this.bizId, bizProductResult.bizId) && Intrinsics.areEqual(this.denom, bizProductResult.denom) && Intrinsics.areEqual(this.goodsId, bizProductResult.goodsId) && Intrinsics.areEqual(this.goodsTitle, bizProductResult.goodsTitle) && Intrinsics.areEqual(this.goodsType, bizProductResult.goodsType) && Intrinsics.areEqual(this.isGoodsActive, bizProductResult.isGoodsActive) && Intrinsics.areEqual(this.provider, bizProductResult.provider) && Intrinsics.areEqual(this.providerName, bizProductResult.providerName) && Intrinsics.areEqual(this.transactionDate, bizProductResult.transactionDate) && Intrinsics.areEqual(this.extendInfo, bizProductResult.extendInfo) && Intrinsics.areEqual(this.customerName, bizProductResult.customerName);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizId;
        int hashCode = str == null ? 0 : str.hashCode();
        MoneyViewEntity moneyViewEntity = this.denom;
        int hashCode2 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str2 = this.goodsId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsTitle;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.goodsType;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.isGoodsActive;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str5 = this.provider;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.providerName;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        Long l = this.transactionDate;
        int hashCode9 = l == null ? 0 : l.hashCode();
        Map<String, Object> map = this.extendInfo;
        int hashCode10 = map == null ? 0 : map.hashCode();
        String str7 = this.customerName;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizProductResult(bizId=");
        sb.append(this.bizId);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", isGoodsActive=");
        sb.append(this.isGoodsActive);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(')');
        return sb.toString();
    }

    public BizProductResult(String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, Boolean bool, String str5, String str6, Long l, Map<String, ? extends Object> map, String str7) {
        this.bizId = str;
        this.denom = moneyViewEntity;
        this.goodsId = str2;
        this.goodsTitle = str3;
        this.goodsType = str4;
        this.isGoodsActive = bool;
        this.provider = str5;
        this.providerName = str6;
        this.transactionDate = l;
        this.extendInfo = map;
        this.customerName = str7;
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewEntity getDenom() {
        return this.denom;
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

    @JvmName(name = "isGoodsActive")
    public final Boolean isGoodsActive() {
        return this.isGoodsActive;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getTransactionDate")
    public final Long getTransactionDate() {
        return this.transactionDate;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }
}
