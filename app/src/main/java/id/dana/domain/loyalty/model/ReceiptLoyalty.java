package id.dana.domain.loyalty.model;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006"}, d2 = {"Lid/dana/domain/loyalty/model/ReceiptLoyalty;", "", "", "merchantId", "Ljava/lang/String;", "getMerchantId", "()Ljava/lang/String;", "merchantName", "getMerchantName", CashierKeyParams.TOTAL_AMOUNT, "getOrderAmount", "orderId", "getOrderId", "rawText", "getRawText", "timestamp", "getTimestamp", "userLoyaltyId", "getUserLoyaltyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class ReceiptLoyalty {
    private final String merchantId;
    private final String merchantName;
    private final String orderAmount;
    private final String orderId;
    private final String rawText;
    private final String timestamp;
    private final String userLoyaltyId;

    public ReceiptLoyalty(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
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
    }

    @JvmName(name = "getOrderId")
    public String getOrderId() {
        return this.orderId;
    }

    @JvmName(name = "getMerchantName")
    public String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getOrderAmount")
    public String getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = "getTimestamp")
    public String getTimestamp() {
        return this.timestamp;
    }

    @JvmName(name = "getRawText")
    public String getRawText() {
        return this.rawText;
    }

    @JvmName(name = "getMerchantId")
    public String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getUserLoyaltyId")
    public String getUserLoyaltyId() {
        return this.userLoyaltyId;
    }
}
