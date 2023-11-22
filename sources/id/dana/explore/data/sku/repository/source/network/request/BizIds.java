package id.dana.explore.data.sku.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004Jp\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/BizIds;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/explore/data/sku/repository/source/network/request/Denom;", "component3", "()Lid/dana/explore/data/sku/repository/source/network/request/Denom;", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "bizId", "customerName", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsType", "isGoodsActive", "provider", KybCpmConstants.TRANSACTION_DATE_PARAM, "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/Denom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/request/BizIds;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizId", "getCustomerName", "Lid/dana/explore/data/sku/repository/source/network/request/Denom;", "getDenom", "getGoodsId", "getGoodsType", "Ljava/lang/Boolean;", "getProvider", "getTransactionDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/Denom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizIds {
    @SerializedName("bizId")
    private final String bizId;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName(UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM)
    private final Denom denom;
    @SerializedName("goodsId")
    private final String goodsId;
    @SerializedName("goodsType")
    private final String goodsType;
    @SerializedName("isGoodsActive")
    private final Boolean isGoodsActive;
    @SerializedName("provider")
    private final String provider;
    @SerializedName(KybCpmConstants.TRANSACTION_DATE_PARAM)
    private final String transactionDate;

    public BizIds() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component3  reason: from getter */
    public final Denom getDenom() {
        return this.denom;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
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
    public final String getTransactionDate() {
        return this.transactionDate;
    }

    public final BizIds copy(String bizId, String customerName, Denom denom, String goodsId, String goodsType, Boolean isGoodsActive, String provider, String transactionDate) {
        return new BizIds(bizId, customerName, denom, goodsId, goodsType, isGoodsActive, provider, transactionDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizIds) {
            BizIds bizIds = (BizIds) other;
            return Intrinsics.areEqual(this.bizId, bizIds.bizId) && Intrinsics.areEqual(this.customerName, bizIds.customerName) && Intrinsics.areEqual(this.denom, bizIds.denom) && Intrinsics.areEqual(this.goodsId, bizIds.goodsId) && Intrinsics.areEqual(this.goodsType, bizIds.goodsType) && Intrinsics.areEqual(this.isGoodsActive, bizIds.isGoodsActive) && Intrinsics.areEqual(this.provider, bizIds.provider) && Intrinsics.areEqual(this.transactionDate, bizIds.transactionDate);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.customerName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Denom denom = this.denom;
        int hashCode3 = denom == null ? 0 : denom.hashCode();
        String str3 = this.goodsId;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.goodsType;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.isGoodsActive;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str5 = this.provider;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.transactionDate;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizIds(bizId=");
        sb.append(this.bizId);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", isGoodsActive=");
        sb.append(this.isGoodsActive);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(')');
        return sb.toString();
    }

    public BizIds(String str, String str2, Denom denom, String str3, String str4, Boolean bool, String str5, String str6) {
        this.bizId = str;
        this.customerName = str2;
        this.denom = denom;
        this.goodsId = str3;
        this.goodsType = str4;
        this.isGoodsActive = bool;
        this.provider = str5;
        this.transactionDate = str6;
    }

    public /* synthetic */ BizIds(String str, String str2, Denom denom, String str3, String str4, Boolean bool, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : denom, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? str6 : null);
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getDenom")
    public final Denom getDenom() {
        return this.denom;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
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

    @JvmName(name = "getTransactionDate")
    public final String getTransactionDate() {
        return this.transactionDate;
    }
}
