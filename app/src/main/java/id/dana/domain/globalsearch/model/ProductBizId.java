package id.dana.domain.globalsearch.model;

import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J²\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\fHÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u0004R\u0017\u0010\u0019\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b3\u0010\u0004R\u001a\u0010 \u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\u0017R&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\b7\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b8\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b9\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b:\u0010\u0004R\u001a\u0010#\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00101\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010>R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010>R\u001a\u0010&\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\bA\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\bB\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\bC\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\bD\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\bE\u0010\u0004"}, d2 = {"Lid/dana/domain/globalsearch/model/ProductBizId;", "", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Z", "component12", "component13", "component14", "", "component15", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "Lid/dana/domain/globalsearch/model/Denom;", "component8", "()Lid/dana/domain/globalsearch/model/Denom;", "component9", "bizId", "secondaryBizId", KybCpmConstants.TRANSACTION_DATE_PARAM, "customerName", "goodsId", "goodsTitle", "goodsType", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "provider", "providerName", "isGoodsActive", "productCode", "productDesc", "profileKey", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/Denom;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/globalsearch/model/ProductBizId;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizId", "getCustomerName", "Lid/dana/domain/globalsearch/model/Denom;", "getDenom", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getGoodsTitle", "getGoodsType", "Z", "getProductCode", "setProductCode", "(Ljava/lang/String;)V", "getProductDesc", "setProductDesc", "getProfileKey", "getProvider", "getProviderName", "getSecondaryBizId", "getTransactionDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/Denom;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProductBizId {
    private final String bizId;
    private final String customerName;
    private final Denom denom;
    private final Map<String, Object> extendInfo;
    private final String goodsId;
    private final String goodsTitle;
    private final String goodsType;
    private final boolean isGoodsActive;
    private String productCode;
    private String productDesc;
    private final String profileKey;
    private final String provider;
    private final String providerName;
    private final String secondaryBizId;
    private final String transactionDate;

    public ProductBizId() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 32767, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component11  reason: from getter */
    public final boolean getIsGoodsActive() {
        return this.isGoodsActive;
    }

    /* renamed from: component12  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component13  reason: from getter */
    public final String getProductDesc() {
        return this.productDesc;
    }

    /* renamed from: component14  reason: from getter */
    public final String getProfileKey() {
        return this.profileKey;
    }

    public final Map<String, Object> component15() {
        return this.extendInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecondaryBizId() {
        return this.secondaryBizId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransactionDate() {
        return this.transactionDate;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component8  reason: from getter */
    public final Denom getDenom() {
        return this.denom;
    }

    /* renamed from: component9  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    public final ProductBizId copy(String bizId, String secondaryBizId, String transactionDate, String customerName, String goodsId, String goodsTitle, String goodsType, Denom denom, String provider, String providerName, boolean isGoodsActive, String productCode, String productDesc, String profileKey, Map<String, ? extends Object> extendInfo) {
        Intrinsics.checkNotNullParameter(bizId, "");
        Intrinsics.checkNotNullParameter(secondaryBizId, "");
        Intrinsics.checkNotNullParameter(transactionDate, "");
        Intrinsics.checkNotNullParameter(customerName, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(goodsTitle, "");
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(provider, "");
        Intrinsics.checkNotNullParameter(providerName, "");
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(productDesc, "");
        Intrinsics.checkNotNullParameter(profileKey, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new ProductBizId(bizId, secondaryBizId, transactionDate, customerName, goodsId, goodsTitle, goodsType, denom, provider, providerName, isGoodsActive, productCode, productDesc, profileKey, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProductBizId) {
            ProductBizId productBizId = (ProductBizId) other;
            return Intrinsics.areEqual(this.bizId, productBizId.bizId) && Intrinsics.areEqual(this.secondaryBizId, productBizId.secondaryBizId) && Intrinsics.areEqual(this.transactionDate, productBizId.transactionDate) && Intrinsics.areEqual(this.customerName, productBizId.customerName) && Intrinsics.areEqual(this.goodsId, productBizId.goodsId) && Intrinsics.areEqual(this.goodsTitle, productBizId.goodsTitle) && Intrinsics.areEqual(this.goodsType, productBizId.goodsType) && Intrinsics.areEqual(this.denom, productBizId.denom) && Intrinsics.areEqual(this.provider, productBizId.provider) && Intrinsics.areEqual(this.providerName, productBizId.providerName) && this.isGoodsActive == productBizId.isGoodsActive && Intrinsics.areEqual(this.productCode, productBizId.productCode) && Intrinsics.areEqual(this.productDesc, productBizId.productDesc) && Intrinsics.areEqual(this.profileKey, productBizId.profileKey) && Intrinsics.areEqual(this.extendInfo, productBizId.extendInfo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.bizId.hashCode();
        int hashCode2 = this.secondaryBizId.hashCode();
        int hashCode3 = this.transactionDate.hashCode();
        int hashCode4 = this.customerName.hashCode();
        int hashCode5 = this.goodsId.hashCode();
        int hashCode6 = this.goodsTitle.hashCode();
        int hashCode7 = this.goodsType.hashCode();
        int hashCode8 = this.denom.hashCode();
        int hashCode9 = this.provider.hashCode();
        int hashCode10 = this.providerName.hashCode();
        boolean z = this.isGoodsActive;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i) * 31) + this.productCode.hashCode()) * 31) + this.productDesc.hashCode()) * 31) + this.profileKey.hashCode()) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductBizId(bizId=");
        sb.append(this.bizId);
        sb.append(", secondaryBizId=");
        sb.append(this.secondaryBizId);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", isGoodsActive=");
        sb.append(this.isGoodsActive);
        sb.append(", productCode=");
        sb.append(this.productCode);
        sb.append(", productDesc=");
        sb.append(this.productDesc);
        sb.append(", profileKey=");
        sb.append(this.profileKey);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public ProductBizId(String str, String str2, String str3, String str4, String str5, String str6, String str7, Denom denom, String str8, String str9, boolean z, String str10, String str11, String str12, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.bizId = str;
        this.secondaryBizId = str2;
        this.transactionDate = str3;
        this.customerName = str4;
        this.goodsId = str5;
        this.goodsTitle = str6;
        this.goodsType = str7;
        this.denom = denom;
        this.provider = str8;
        this.providerName = str9;
        this.isGoodsActive = z;
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

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r11v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ProductBizId(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, id.dana.domain.globalsearch.model.Denom r24, java.lang.String r25, java.lang.String r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.util.Map r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lc
        La:
            r1 = r17
        Lc:
            r3 = r0 & 2
            if (r3 == 0) goto L12
            r3 = r2
            goto L14
        L12:
            r3 = r18
        L14:
            r4 = r0 & 4
            if (r4 == 0) goto L1a
            r4 = r2
            goto L1c
        L1a:
            r4 = r19
        L1c:
            r5 = r0 & 8
            if (r5 == 0) goto L22
            r5 = r2
            goto L24
        L22:
            r5 = r20
        L24:
            r6 = r0 & 16
            if (r6 == 0) goto L2a
            r6 = r2
            goto L2c
        L2a:
            r6 = r21
        L2c:
            r7 = r0 & 32
            if (r7 == 0) goto L32
            r7 = r2
            goto L34
        L32:
            r7 = r22
        L34:
            r8 = r0 & 64
            if (r8 == 0) goto L3a
            r8 = r2
            goto L3c
        L3a:
            r8 = r23
        L3c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L48
            id.dana.domain.globalsearch.model.Denom r9 = new id.dana.domain.globalsearch.model.Denom
            r10 = 3
            r11 = 0
            r9.<init>(r11, r11, r10, r11)
            goto L4a
        L48:
            r9 = r24
        L4a:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L50
            r10 = r2
            goto L52
        L50:
            r10 = r25
        L52:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L58
            r11 = r2
            goto L5a
        L58:
            r11 = r26
        L5a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L60
            r12 = 0
            goto L62
        L60:
            r12 = r27
        L62:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L68
            r13 = r2
            goto L6a
        L68:
            r13 = r28
        L6a:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L70
            r14 = r2
            goto L72
        L70:
            r14 = r29
        L72:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L77
            goto L79
        L77:
            r2 = r30
        L79:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L82
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            goto L84
        L82:
            r0 = r31
        L84:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r2
            r32 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.globalsearch.model.ProductBizId.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, id.dana.domain.globalsearch.model.Denom, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getDenom")
    public final Denom getDenom() {
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

    @JvmName(name = "isGoodsActive")
    public final boolean isGoodsActive() {
        return this.isGoodsActive;
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

    @JvmName(name = "getProductDesc")
    public final String getProductDesc() {
        return this.productDesc;
    }

    @JvmName(name = "setProductDesc")
    public final void setProductDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
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
