package id.dana.mybills.domain.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u008a\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00142\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010!\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000bR&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b3\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b6\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b7\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0016"}, d2 = {"Lid/dana/mybills/domain/model/BizProduct;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/Map;", "component11", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "component4", "component5", "", "component6", "()Z", "component7", "component8", "", "component9", "()J", "bizId", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsTitle", "goodsType", "isGoodsActive", "provider", "providerName", KybCpmConstants.TRANSACTION_DATE_PARAM, "extendInfo", "customerName", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;)Lid/dana/mybills/domain/model/BizProduct;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizId", "getCustomerName", "Lid/dana/domain/nearbyme/model/MoneyView;", "getDenom", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getGoodsTitle", "getGoodsType", "Z", "getProvider", "getProviderName", "J", "getTransactionDate", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizProduct {
    private final String bizId;
    private final String customerName;
    private final MoneyView denom;
    private final Map<String, Object> extendInfo;
    private final String goodsId;
    private final String goodsTitle;
    private final String goodsType;
    private final boolean isGoodsActive;
    private final String provider;
    private final String providerName;
    private final long transactionDate;

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
    public final MoneyView getDenom() {
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
    public final boolean getIsGoodsActive() {
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
    public final long getTransactionDate() {
        return this.transactionDate;
    }

    public final BizProduct copy(String bizId, MoneyView denom, String goodsId, String goodsTitle, String goodsType, boolean isGoodsActive, String provider, String providerName, long transactionDate, Map<String, ? extends Object> extendInfo, String customerName) {
        Intrinsics.checkNotNullParameter(bizId, "");
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(goodsTitle, "");
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(provider, "");
        Intrinsics.checkNotNullParameter(providerName, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(customerName, "");
        return new BizProduct(bizId, denom, goodsId, goodsTitle, goodsType, isGoodsActive, provider, providerName, transactionDate, extendInfo, customerName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizProduct) {
            BizProduct bizProduct = (BizProduct) other;
            return Intrinsics.areEqual(this.bizId, bizProduct.bizId) && Intrinsics.areEqual(this.denom, bizProduct.denom) && Intrinsics.areEqual(this.goodsId, bizProduct.goodsId) && Intrinsics.areEqual(this.goodsTitle, bizProduct.goodsTitle) && Intrinsics.areEqual(this.goodsType, bizProduct.goodsType) && this.isGoodsActive == bizProduct.isGoodsActive && Intrinsics.areEqual(this.provider, bizProduct.provider) && Intrinsics.areEqual(this.providerName, bizProduct.providerName) && this.transactionDate == bizProduct.transactionDate && Intrinsics.areEqual(this.extendInfo, bizProduct.extendInfo) && Intrinsics.areEqual(this.customerName, bizProduct.customerName);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.bizId.hashCode();
        int hashCode2 = this.denom.hashCode();
        int hashCode3 = this.goodsId.hashCode();
        int hashCode4 = this.goodsTitle.hashCode();
        int hashCode5 = this.goodsType.hashCode();
        boolean z = this.isGoodsActive;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + this.provider.hashCode()) * 31) + this.providerName.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.transactionDate)) * 31) + this.extendInfo.hashCode()) * 31) + this.customerName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizProduct(bizId=");
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

    public BizProduct(String str, MoneyView moneyView, String str2, String str3, String str4, boolean z, String str5, String str6, long j, Map<String, ? extends Object> map, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.bizId = str;
        this.denom = moneyView;
        this.goodsId = str2;
        this.goodsTitle = str3;
        this.goodsType = str4;
        this.isGoodsActive = z;
        this.provider = str5;
        this.providerName = str6;
        this.transactionDate = j;
        this.extendInfo = map;
        this.customerName = str7;
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    @JvmName(name = "getDenom")
    public final MoneyView getDenom() {
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
    public final boolean isGoodsActive() {
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
    public final long getTransactionDate() {
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
