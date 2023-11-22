package id.dana.domain.loyalty.model;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001*BI\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J`\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b'\u0010\u0004"}, d2 = {"Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "Lid/dana/domain/loyalty/model/ReceiptLoyalty;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "orderId", "merchantName", CashierKeyParams.TOTAL_AMOUNT, "timestamp", "rawText", "merchantId", "userLoyaltyId", "base64Receipt", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBase64Receipt", "getMerchantId", "getMerchantName", "getOrderAmount", "getOrderId", "getRawText", "getTimestamp", "getUserLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class Base64ReceiptLoyalty extends ReceiptLoyalty {
    private final String base64Receipt;
    private final String merchantId;
    private final String merchantName;
    private final String orderAmount;
    private final String orderId;
    private final String rawText;
    private final String timestamp;
    private final String userLoyaltyId;

    public /* synthetic */ Base64ReceiptLoyalty(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8);
    }

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
    public final String getBase64Receipt() {
        return this.base64Receipt;
    }

    public final Base64ReceiptLoyalty copy(String orderId, String merchantName, String orderAmount, String timestamp, String rawText, String merchantId, String userLoyaltyId, String base64Receipt) {
        Intrinsics.checkNotNullParameter(orderId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(orderAmount, "");
        Intrinsics.checkNotNullParameter(timestamp, "");
        Intrinsics.checkNotNullParameter(rawText, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Intrinsics.checkNotNullParameter(base64Receipt, "");
        return new Base64ReceiptLoyalty(orderId, merchantName, orderAmount, timestamp, rawText, merchantId, userLoyaltyId, base64Receipt);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Base64ReceiptLoyalty) {
            Base64ReceiptLoyalty base64ReceiptLoyalty = (Base64ReceiptLoyalty) other;
            return Intrinsics.areEqual(getOrderId(), base64ReceiptLoyalty.getOrderId()) && Intrinsics.areEqual(getMerchantName(), base64ReceiptLoyalty.getMerchantName()) && Intrinsics.areEqual(getOrderAmount(), base64ReceiptLoyalty.getOrderAmount()) && Intrinsics.areEqual(getTimestamp(), base64ReceiptLoyalty.getTimestamp()) && Intrinsics.areEqual(getRawText(), base64ReceiptLoyalty.getRawText()) && Intrinsics.areEqual(getMerchantId(), base64ReceiptLoyalty.getMerchantId()) && Intrinsics.areEqual(getUserLoyaltyId(), base64ReceiptLoyalty.getUserLoyaltyId()) && Intrinsics.areEqual(this.base64Receipt, base64ReceiptLoyalty.base64Receipt);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((getOrderId().hashCode() * 31) + getMerchantName().hashCode()) * 31) + getOrderAmount().hashCode()) * 31) + getTimestamp().hashCode()) * 31) + getRawText().hashCode()) * 31) + getMerchantId().hashCode()) * 31) + getUserLoyaltyId().hashCode()) * 31) + this.base64Receipt.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Base64ReceiptLoyalty(orderId=");
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
        sb.append(", base64Receipt=");
        sb.append(this.base64Receipt);
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

    @JvmName(name = "getBase64Receipt")
    public final String getBase64Receipt() {
        return this.base64Receipt;
    }

    private Base64ReceiptLoyalty(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, str3, str4, str5, str6, str7);
        this.orderId = str;
        this.merchantName = str2;
        this.orderAmount = str3;
        this.timestamp = str4;
        this.rawText = str5;
        this.merchantId = str6;
        this.userLoyaltyId = str7;
        this.base64Receipt = str8;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\n"}, d2 = {"Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty$Builder;", "", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "build", "()Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "", "receipt", "withReceipt", "(Ljava/lang/String;)Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty$Builder;", "merchantId", "Ljava/lang/String;", "merchantName", CashierKeyParams.TOTAL_AMOUNT, "orderId", "rawText", "timestamp", "userLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Builder {
        private final String merchantId;
        private final String merchantName;
        private final String orderAmount;
        private final String orderId;
        private final String rawText;
        private String receipt;
        private final String timestamp;
        private final String userLoyaltyId;

        public Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            this.orderId = str;
            this.merchantName = str2;
            this.orderAmount = str3;
            this.timestamp = str4;
            this.rawText = str5;
            this.merchantId = str6;
            this.userLoyaltyId = str7;
            this.receipt = "";
        }

        public final Builder withReceipt(String receipt) {
            if (receipt != null) {
                this.receipt = receipt;
            }
            return this;
        }

        public final Base64ReceiptLoyalty build() {
            return new Base64ReceiptLoyalty(this.orderId, this.merchantName, this.orderAmount, this.timestamp, this.rawText, this.merchantId, this.userLoyaltyId, this.receipt, null);
        }
    }
}
