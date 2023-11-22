package id.dana.domain.globalnetwork.model;

import com.alipay.iap.android.wallet.acl.payment.PaymentType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u0004R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\bR\u001a\u0010\u0015\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u000b"}, d2 = {"Lid/dana/domain/globalnetwork/model/Pay;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentType;", "component4", "()Lcom/alipay/iap/android/wallet/acl/payment/PaymentType;", "component5", "", "component6", "()Z", "amount", FirebaseAnalytics.Param.CURRENCY, "extendInfo", "paymentType", "paymentString", "isFromMiniProgram", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/payment/PaymentType;Ljava/lang/String;Z)Lid/dana/domain/globalnetwork/model/Pay;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getCurrency", "Ljava/util/Map;", "getExtendInfo", "Z", "getPaymentString", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentType;", "getPaymentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/payment/PaymentType;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Pay {
    private final String amount;
    private final String currency;
    private final Map<String, String> extendInfo;
    private final boolean isFromMiniProgram;
    private final String paymentString;
    private final PaymentType paymentType;

    public static /* synthetic */ Pay copy$default(Pay pay, String str, String str2, Map map, PaymentType paymentType, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pay.amount;
        }
        if ((i & 2) != 0) {
            str2 = pay.currency;
        }
        String str4 = str2;
        Map<String, String> map2 = map;
        if ((i & 4) != 0) {
            map2 = pay.extendInfo;
        }
        Map map3 = map2;
        if ((i & 8) != 0) {
            paymentType = pay.paymentType;
        }
        PaymentType paymentType2 = paymentType;
        if ((i & 16) != 0) {
            str3 = pay.paymentString;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            z = pay.isFromMiniProgram;
        }
        return pay.copy(str, str4, map3, paymentType2, str5, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final Map<String, String> component3() {
        return this.extendInfo;
    }

    /* renamed from: component4  reason: from getter */
    public final PaymentType getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPaymentString() {
        return this.paymentString;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsFromMiniProgram() {
        return this.isFromMiniProgram;
    }

    public final Pay copy(String amount, String currency, Map<String, String> extendInfo, PaymentType paymentType, String paymentString, boolean isFromMiniProgram) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(currency, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(paymentType, "");
        Intrinsics.checkNotNullParameter(paymentString, "");
        return new Pay(amount, currency, extendInfo, paymentType, paymentString, isFromMiniProgram);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Pay) {
            Pay pay = (Pay) other;
            return Intrinsics.areEqual(this.amount, pay.amount) && Intrinsics.areEqual(this.currency, pay.currency) && Intrinsics.areEqual(this.extendInfo, pay.extendInfo) && this.paymentType == pay.paymentType && Intrinsics.areEqual(this.paymentString, pay.paymentString) && this.isFromMiniProgram == pay.isFromMiniProgram;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.amount.hashCode();
        int hashCode2 = this.currency.hashCode();
        int hashCode3 = this.extendInfo.hashCode();
        int hashCode4 = this.paymentType.hashCode();
        int hashCode5 = this.paymentString.hashCode();
        boolean z = this.isFromMiniProgram;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pay(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", paymentType=");
        sb.append(this.paymentType);
        sb.append(", paymentString=");
        sb.append(this.paymentString);
        sb.append(", isFromMiniProgram=");
        sb.append(this.isFromMiniProgram);
        sb.append(')');
        return sb.toString();
    }

    public Pay(String str, String str2, Map<String, String> map, PaymentType paymentType, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(paymentType, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.amount = str;
        this.currency = str2;
        this.extendInfo = map;
        this.paymentType = paymentType;
        this.paymentString = str3;
        this.isFromMiniProgram = z;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getPaymentType")
    public final PaymentType getPaymentType() {
        return this.paymentType;
    }

    @JvmName(name = "getPaymentString")
    public final String getPaymentString() {
        return this.paymentString;
    }

    @JvmName(name = "isFromMiniProgram")
    public final boolean isFromMiniProgram() {
        return this.isFromMiniProgram;
    }
}
