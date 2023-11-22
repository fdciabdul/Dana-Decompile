package id.dana.domain.loyalty.model;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\bX\u0010YJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004JÄ\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u0004R\"\u0010\u0017\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u00105R\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u00102\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00105R\"\u0010 \u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00102\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u00105R\"\u0010\u001c\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u00105R\"\u0010\u001a\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u00105R\"\u0010\u001b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u00105R\"\u0010\u0018\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u00105R\"\u0010\u001f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u00105R\"\u0010\u001e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00102\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u00105R\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00102\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u00105R\"\u0010\u001d\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00102\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u00105R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00102\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u00105R\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u00102\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u00105R\"\u0010&\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00102\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u00105R\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00102\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u00105R\"\u0010#\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00102\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u00105R\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00102\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u00105R\"\u0010!\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00102\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u00105"}, d2 = {"Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "id", "createdDate", "modifiedDate", "orderId", "merchantId", "merchantName", "loyaltyMerchantName", "originalMerchantName", "orderDate", CashierKeyParams.TOTAL_AMOUNT, "imageAssetUrl", "userLoyaltyId", "receiptStatus", "receiptResultType", "receiptApprovalStatus", "pointGenerated", "reasonId", "reasonEn", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCreatedDate", "setCreatedDate", "(Ljava/lang/String;)V", "getId", "setId", "getImageAssetUrl", "setImageAssetUrl", "getLoyaltyMerchantName", "setLoyaltyMerchantName", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getModifiedDate", "setModifiedDate", "getOrderAmount", "setOrderAmount", "getOrderDate", "setOrderDate", "getOrderId", "setOrderId", "getOriginalMerchantName", "setOriginalMerchantName", "getPointGenerated", "setPointGenerated", "getReasonEn", "setReasonEn", "getReasonId", "setReasonId", "getReceiptApprovalStatus", "setReceiptApprovalStatus", "getReceiptResultType", "setReceiptResultType", "getReceiptStatus", "setReceiptStatus", "getUserLoyaltyId", "setUserLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class SubmitReceiptResult {
    private String createdDate;
    private String id;
    private String imageAssetUrl;
    private String loyaltyMerchantName;
    private String merchantId;
    private String merchantName;
    private String modifiedDate;
    private String orderAmount;
    private String orderDate;
    private String orderId;
    private String originalMerchantName;
    private String pointGenerated;
    private String reasonEn;
    private String reasonId;
    private String receiptApprovalStatus;
    private String receiptResultType;
    private String receiptStatus;
    private String userLoyaltyId;

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10  reason: from getter */
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    /* renamed from: component11  reason: from getter */
    public final String getImageAssetUrl() {
        return this.imageAssetUrl;
    }

    /* renamed from: component12  reason: from getter */
    public final String getUserLoyaltyId() {
        return this.userLoyaltyId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getReceiptStatus() {
        return this.receiptStatus;
    }

    /* renamed from: component14  reason: from getter */
    public final String getReceiptResultType() {
        return this.receiptResultType;
    }

    /* renamed from: component15  reason: from getter */
    public final String getReceiptApprovalStatus() {
        return this.receiptApprovalStatus;
    }

    /* renamed from: component16  reason: from getter */
    public final String getPointGenerated() {
        return this.pointGenerated;
    }

    /* renamed from: component17  reason: from getter */
    public final String getReasonId() {
        return this.reasonId;
    }

    /* renamed from: component18  reason: from getter */
    public final String getReasonEn() {
        return this.reasonEn;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCreatedDate() {
        return this.createdDate;
    }

    /* renamed from: component3  reason: from getter */
    public final String getModifiedDate() {
        return this.modifiedDate;
    }

    /* renamed from: component4  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getLoyaltyMerchantName() {
        return this.loyaltyMerchantName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getOriginalMerchantName() {
        return this.originalMerchantName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getOrderDate() {
        return this.orderDate;
    }

    public final SubmitReceiptResult copy(String id2, String createdDate, String modifiedDate, String orderId, String merchantId, String merchantName, String loyaltyMerchantName, String originalMerchantName, String orderDate, String orderAmount, String imageAssetUrl, String userLoyaltyId, String receiptStatus, String receiptResultType, String receiptApprovalStatus, String pointGenerated, String reasonId, String reasonEn) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(createdDate, "");
        Intrinsics.checkNotNullParameter(modifiedDate, "");
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(loyaltyMerchantName, "");
        Intrinsics.checkNotNullParameter(originalMerchantName, "");
        Intrinsics.checkNotNullParameter(orderDate, "");
        Intrinsics.checkNotNullParameter(orderAmount, "");
        Intrinsics.checkNotNullParameter(imageAssetUrl, "");
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Intrinsics.checkNotNullParameter(receiptStatus, "");
        Intrinsics.checkNotNullParameter(receiptResultType, "");
        Intrinsics.checkNotNullParameter(receiptApprovalStatus, "");
        Intrinsics.checkNotNullParameter(pointGenerated, "");
        Intrinsics.checkNotNullParameter(reasonId, "");
        Intrinsics.checkNotNullParameter(reasonEn, "");
        return new SubmitReceiptResult(id2, createdDate, modifiedDate, orderId, merchantId, merchantName, loyaltyMerchantName, originalMerchantName, orderDate, orderAmount, imageAssetUrl, userLoyaltyId, receiptStatus, receiptResultType, receiptApprovalStatus, pointGenerated, reasonId, reasonEn);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SubmitReceiptResult) {
            SubmitReceiptResult submitReceiptResult = (SubmitReceiptResult) other;
            return Intrinsics.areEqual(this.id, submitReceiptResult.id) && Intrinsics.areEqual(this.createdDate, submitReceiptResult.createdDate) && Intrinsics.areEqual(this.modifiedDate, submitReceiptResult.modifiedDate) && Intrinsics.areEqual(this.orderId, submitReceiptResult.orderId) && Intrinsics.areEqual(this.merchantId, submitReceiptResult.merchantId) && Intrinsics.areEqual(this.merchantName, submitReceiptResult.merchantName) && Intrinsics.areEqual(this.loyaltyMerchantName, submitReceiptResult.loyaltyMerchantName) && Intrinsics.areEqual(this.originalMerchantName, submitReceiptResult.originalMerchantName) && Intrinsics.areEqual(this.orderDate, submitReceiptResult.orderDate) && Intrinsics.areEqual(this.orderAmount, submitReceiptResult.orderAmount) && Intrinsics.areEqual(this.imageAssetUrl, submitReceiptResult.imageAssetUrl) && Intrinsics.areEqual(this.userLoyaltyId, submitReceiptResult.userLoyaltyId) && Intrinsics.areEqual(this.receiptStatus, submitReceiptResult.receiptStatus) && Intrinsics.areEqual(this.receiptResultType, submitReceiptResult.receiptResultType) && Intrinsics.areEqual(this.receiptApprovalStatus, submitReceiptResult.receiptApprovalStatus) && Intrinsics.areEqual(this.pointGenerated, submitReceiptResult.pointGenerated) && Intrinsics.areEqual(this.reasonId, submitReceiptResult.reasonId) && Intrinsics.areEqual(this.reasonEn, submitReceiptResult.reasonEn);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.createdDate.hashCode()) * 31) + this.modifiedDate.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.merchantId.hashCode()) * 31) + this.merchantName.hashCode()) * 31) + this.loyaltyMerchantName.hashCode()) * 31) + this.originalMerchantName.hashCode()) * 31) + this.orderDate.hashCode()) * 31) + this.orderAmount.hashCode()) * 31) + this.imageAssetUrl.hashCode()) * 31) + this.userLoyaltyId.hashCode()) * 31) + this.receiptStatus.hashCode()) * 31) + this.receiptResultType.hashCode()) * 31) + this.receiptApprovalStatus.hashCode()) * 31) + this.pointGenerated.hashCode()) * 31) + this.reasonId.hashCode()) * 31) + this.reasonEn.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubmitReceiptResult(id=");
        sb.append(this.id);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", modifiedDate=");
        sb.append(this.modifiedDate);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", loyaltyMerchantName=");
        sb.append(this.loyaltyMerchantName);
        sb.append(", originalMerchantName=");
        sb.append(this.originalMerchantName);
        sb.append(", orderDate=");
        sb.append(this.orderDate);
        sb.append(", orderAmount=");
        sb.append(this.orderAmount);
        sb.append(", imageAssetUrl=");
        sb.append(this.imageAssetUrl);
        sb.append(", userLoyaltyId=");
        sb.append(this.userLoyaltyId);
        sb.append(", receiptStatus=");
        sb.append(this.receiptStatus);
        sb.append(", receiptResultType=");
        sb.append(this.receiptResultType);
        sb.append(", receiptApprovalStatus=");
        sb.append(this.receiptApprovalStatus);
        sb.append(", pointGenerated=");
        sb.append(this.pointGenerated);
        sb.append(", reasonId=");
        sb.append(this.reasonId);
        sb.append(", reasonEn=");
        sb.append(this.reasonEn);
        sb.append(')');
        return sb.toString();
    }

    public SubmitReceiptResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(str18, "");
        this.id = str;
        this.createdDate = str2;
        this.modifiedDate = str3;
        this.orderId = str4;
        this.merchantId = str5;
        this.merchantName = str6;
        this.loyaltyMerchantName = str7;
        this.originalMerchantName = str8;
        this.orderDate = str9;
        this.orderAmount = str10;
        this.imageAssetUrl = str11;
        this.userLoyaltyId = str12;
        this.receiptStatus = str13;
        this.receiptResultType = str14;
        this.receiptApprovalStatus = str15;
        this.pointGenerated = str16;
        this.reasonId = str17;
        this.reasonEn = str18;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.id = str;
    }

    @JvmName(name = "getCreatedDate")
    public final String getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "setCreatedDate")
    public final void setCreatedDate(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.createdDate = str;
    }

    @JvmName(name = "getModifiedDate")
    public final String getModifiedDate() {
        return this.modifiedDate;
    }

    @JvmName(name = "setModifiedDate")
    public final void setModifiedDate(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.modifiedDate = str;
    }

    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    @JvmName(name = "setOrderId")
    public final void setOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.orderId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "setMerchantName")
    public final void setMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantName = str;
    }

    @JvmName(name = "getLoyaltyMerchantName")
    public final String getLoyaltyMerchantName() {
        return this.loyaltyMerchantName;
    }

    @JvmName(name = "setLoyaltyMerchantName")
    public final void setLoyaltyMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.loyaltyMerchantName = str;
    }

    @JvmName(name = "getOriginalMerchantName")
    public final String getOriginalMerchantName() {
        return this.originalMerchantName;
    }

    @JvmName(name = "setOriginalMerchantName")
    public final void setOriginalMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.originalMerchantName = str;
    }

    @JvmName(name = "getOrderDate")
    public final String getOrderDate() {
        return this.orderDate;
    }

    @JvmName(name = "setOrderDate")
    public final void setOrderDate(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.orderDate = str;
    }

    @JvmName(name = "getOrderAmount")
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = "setOrderAmount")
    public final void setOrderAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.orderAmount = str;
    }

    @JvmName(name = "getImageAssetUrl")
    public final String getImageAssetUrl() {
        return this.imageAssetUrl;
    }

    @JvmName(name = "setImageAssetUrl")
    public final void setImageAssetUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.imageAssetUrl = str;
    }

    @JvmName(name = "getUserLoyaltyId")
    public final String getUserLoyaltyId() {
        return this.userLoyaltyId;
    }

    @JvmName(name = "setUserLoyaltyId")
    public final void setUserLoyaltyId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userLoyaltyId = str;
    }

    @JvmName(name = "getReceiptStatus")
    public final String getReceiptStatus() {
        return this.receiptStatus;
    }

    @JvmName(name = "setReceiptStatus")
    public final void setReceiptStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.receiptStatus = str;
    }

    @JvmName(name = "getReceiptResultType")
    public final String getReceiptResultType() {
        return this.receiptResultType;
    }

    @JvmName(name = "setReceiptResultType")
    public final void setReceiptResultType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.receiptResultType = str;
    }

    @JvmName(name = "getReceiptApprovalStatus")
    public final String getReceiptApprovalStatus() {
        return this.receiptApprovalStatus;
    }

    @JvmName(name = "setReceiptApprovalStatus")
    public final void setReceiptApprovalStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.receiptApprovalStatus = str;
    }

    @JvmName(name = "getPointGenerated")
    public final String getPointGenerated() {
        return this.pointGenerated;
    }

    @JvmName(name = "setPointGenerated")
    public final void setPointGenerated(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pointGenerated = str;
    }

    @JvmName(name = "getReasonId")
    public final String getReasonId() {
        return this.reasonId;
    }

    @JvmName(name = "setReasonId")
    public final void setReasonId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.reasonId = str;
    }

    @JvmName(name = "getReasonEn")
    public final String getReasonEn() {
        return this.reasonEn;
    }

    @JvmName(name = "setReasonEn")
    public final void setReasonEn(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.reasonEn = str;
    }
}
