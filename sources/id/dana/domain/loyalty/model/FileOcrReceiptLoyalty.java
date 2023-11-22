package id.dana.domain.loyalty.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J`\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b'\u0010\u0004"}, d2 = {"Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "Lid/dana/domain/loyalty/model/ReceiptLoyalty;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "orderId", "merchantName", CashierKeyParams.TOTAL_AMOUNT, "timestamp", "rawText", "merchantId", "userLoyaltyId", BridgeKey.FILE_PATH, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFilePath", "getMerchantId", "getMerchantName", "getOrderAmount", "getOrderId", "getRawText", "getTimestamp", "getUserLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class FileOcrReceiptLoyalty extends ReceiptLoyalty {
    private final String filePath;
    private final String merchantId;
    private final String merchantName;
    private final String orderAmount;
    private final String orderId;
    private final String rawText;
    private final String timestamp;
    private final String userLoyaltyId;

    public final String component1() {
        return getOrderId();
    }

    public final String component2() {
        return getMerchantName();
    }

    public final String component3() {
        return getOrderAmount();
    }

    public final String component4() {
        return getTimestamp();
    }

    public final String component5() {
        return getRawText();
    }

    public final String component6() {
        return getMerchantId();
    }

    public final String component7() {
        return getUserLoyaltyId();
    }

    /* renamed from: component8  reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final FileOcrReceiptLoyalty copy(String orderId, String merchantName, String orderAmount, String timestamp, String rawText, String merchantId, String userLoyaltyId, String filePath) {
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(orderAmount, "");
        Intrinsics.checkNotNullParameter(timestamp, "");
        Intrinsics.checkNotNullParameter(rawText, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Intrinsics.checkNotNullParameter(filePath, "");
        return new FileOcrReceiptLoyalty(orderId, merchantName, orderAmount, timestamp, rawText, merchantId, userLoyaltyId, filePath);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FileOcrReceiptLoyalty) {
            FileOcrReceiptLoyalty fileOcrReceiptLoyalty = (FileOcrReceiptLoyalty) other;
            return Intrinsics.areEqual(getOrderId(), fileOcrReceiptLoyalty.getOrderId()) && Intrinsics.areEqual(getMerchantName(), fileOcrReceiptLoyalty.getMerchantName()) && Intrinsics.areEqual(getOrderAmount(), fileOcrReceiptLoyalty.getOrderAmount()) && Intrinsics.areEqual(getTimestamp(), fileOcrReceiptLoyalty.getTimestamp()) && Intrinsics.areEqual(getRawText(), fileOcrReceiptLoyalty.getRawText()) && Intrinsics.areEqual(getMerchantId(), fileOcrReceiptLoyalty.getMerchantId()) && Intrinsics.areEqual(getUserLoyaltyId(), fileOcrReceiptLoyalty.getUserLoyaltyId()) && Intrinsics.areEqual(this.filePath, fileOcrReceiptLoyalty.filePath);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((getOrderId().hashCode() * 31) + getMerchantName().hashCode()) * 31) + getOrderAmount().hashCode()) * 31) + getTimestamp().hashCode()) * 31) + getRawText().hashCode()) * 31) + getMerchantId().hashCode()) * 31) + getUserLoyaltyId().hashCode()) * 31) + this.filePath.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileOcrReceiptLoyalty(orderId=");
        sb.append(getOrderId());
        sb.append(", merchantName=");
        sb.append(getMerchantName());
        sb.append(", orderAmount=");
        sb.append(getOrderAmount());
        sb.append(", timestamp=");
        sb.append(getTimestamp());
        sb.append(", rawText=");
        sb.append(getRawText());
        sb.append(", merchantId=");
        sb.append(getMerchantId());
        sb.append(", userLoyaltyId=");
        sb.append(getUserLoyaltyId());
        sb.append(", filePath=");
        sb.append(this.filePath);
        sb.append(')');
        return sb.toString();
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getOrderId")
    public final String getOrderId() {
        return this.orderId;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getOrderAmount")
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getTimestamp")
    public final String getTimestamp() {
        return this.timestamp;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getRawText")
    public final String getRawText() {
        return this.rawText;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @Override // id.dana.domain.loyalty.model.ReceiptLoyalty
    @JvmName(name = "getUserLoyaltyId")
    public final String getUserLoyaltyId() {
        return this.userLoyaltyId;
    }

    @JvmName(name = "getFilePath")
    public final String getFilePath() {
        return this.filePath;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileOcrReceiptLoyalty(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, str3, str4, str5, str6, str7);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.orderId = str;
        this.merchantName = str2;
        this.orderAmount = str3;
        this.timestamp = str4;
        this.rawText = str5;
        this.merchantId = str6;
        this.userLoyaltyId = str7;
        this.filePath = str8;
    }
}
