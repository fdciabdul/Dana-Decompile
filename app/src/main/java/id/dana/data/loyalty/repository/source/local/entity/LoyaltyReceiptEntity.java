package id.dana.data.loyalty.repository.source.local.entity;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J`\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010!R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010!R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010!R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010!R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010!R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010!R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010!"}, d2 = {"Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "userLoyaltyId", "merchantId", "orderId", "merchantName", CashierKeyParams.TOTAL_AMOUNT, "timestamp", BridgeKey.FILE_PATH, "rawText", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getOrderAmount", "setOrderAmount", "getOrderId", "setOrderId", "getRawText", "setRawText", "getTimestamp", "setTimestamp", "getUserLoyaltyId", "setUserLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class LoyaltyReceiptEntity {
    private String filePath;
    private String merchantId;
    private String merchantName;
    private String orderAmount;
    private String orderId;
    private String rawText;
    private String timestamp;
    private String userLoyaltyId;

    /* renamed from: component1  reason: from getter */
    public final String getUserLoyaltyId() {
        return this.userLoyaltyId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component7  reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRawText() {
        return this.rawText;
    }

    public final LoyaltyReceiptEntity copy(String userLoyaltyId, String merchantId, String orderId, String merchantName, String orderAmount, String timestamp, String filePath, String rawText) {
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(orderAmount, "");
        Intrinsics.checkNotNullParameter(timestamp, "");
        Intrinsics.checkNotNullParameter(filePath, "");
        Intrinsics.checkNotNullParameter(rawText, "");
        return new LoyaltyReceiptEntity(userLoyaltyId, merchantId, orderId, merchantName, orderAmount, timestamp, filePath, rawText);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoyaltyReceiptEntity) {
            LoyaltyReceiptEntity loyaltyReceiptEntity = (LoyaltyReceiptEntity) other;
            return Intrinsics.areEqual(this.userLoyaltyId, loyaltyReceiptEntity.userLoyaltyId) && Intrinsics.areEqual(this.merchantId, loyaltyReceiptEntity.merchantId) && Intrinsics.areEqual(this.orderId, loyaltyReceiptEntity.orderId) && Intrinsics.areEqual(this.merchantName, loyaltyReceiptEntity.merchantName) && Intrinsics.areEqual(this.orderAmount, loyaltyReceiptEntity.orderAmount) && Intrinsics.areEqual(this.timestamp, loyaltyReceiptEntity.timestamp) && Intrinsics.areEqual(this.filePath, loyaltyReceiptEntity.filePath) && Intrinsics.areEqual(this.rawText, loyaltyReceiptEntity.rawText);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.userLoyaltyId.hashCode() * 31) + this.merchantId.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.merchantName.hashCode()) * 31) + this.orderAmount.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.rawText.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoyaltyReceiptEntity(userLoyaltyId=");
        sb.append(this.userLoyaltyId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", orderAmount=");
        sb.append(this.orderAmount);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", filePath=");
        sb.append(this.filePath);
        sb.append(", rawText=");
        sb.append(this.rawText);
        sb.append(')');
        return sb.toString();
    }

    public LoyaltyReceiptEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.userLoyaltyId = str;
        this.merchantId = str2;
        this.orderId = str3;
        this.merchantName = str4;
        this.orderAmount = str5;
        this.timestamp = str6;
        this.filePath = str7;
        this.rawText = str8;
    }

    public /* synthetic */ LoyaltyReceiptEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8);
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

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
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

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "setMerchantName")
    public final void setMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantName = str;
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

    @JvmName(name = "getTimestamp")
    public final String getTimestamp() {
        return this.timestamp;
    }

    @JvmName(name = "setTimestamp")
    public final void setTimestamp(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.timestamp = str;
    }

    @JvmName(name = "getFilePath")
    public final String getFilePath() {
        return this.filePath;
    }

    @JvmName(name = "setFilePath")
    public final void setFilePath(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.filePath = str;
    }

    @JvmName(name = "getRawText")
    public final String getRawText() {
        return this.rawText;
    }

    @JvmName(name = "setRawText")
    public final void setRawText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.rawText = str;
    }
}
