package id.dana.data.globalnetwork.model;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.payment.PaymentRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007"}, d2 = {"Lid/dana/data/globalnetwork/model/PayRequest;", "", "", "component1", "()Z", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;", "component2", "()Lcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentResult;", "component3", "()Lcom/alipay/iap/android/wallet/acl/base/Callback;", "isFromMiniProgram", "paymentRequest", "callback", "copy", "(ZLcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;Lcom/alipay/iap/android/wallet/acl/base/Callback;)Lid/dana/data/globalnetwork/model/PayRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "getCallback", "Z", "Lcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;", "getPaymentRequest", "<init>", "(ZLcom/alipay/iap/android/wallet/acl/payment/PaymentRequest;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PayRequest {
    private final Callback<com.alipay.iap.android.wallet.acl.payment.PaymentResult> callback;
    private final boolean isFromMiniProgram;
    private final PaymentRequest paymentRequest;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayRequest copy$default(PayRequest payRequest, boolean z, PaymentRequest paymentRequest, Callback callback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = payRequest.isFromMiniProgram;
        }
        if ((i & 2) != 0) {
            paymentRequest = payRequest.paymentRequest;
        }
        if ((i & 4) != 0) {
            callback = payRequest.callback;
        }
        return payRequest.copy(z, paymentRequest, callback);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsFromMiniProgram() {
        return this.isFromMiniProgram;
    }

    /* renamed from: component2  reason: from getter */
    public final PaymentRequest getPaymentRequest() {
        return this.paymentRequest;
    }

    public final Callback<com.alipay.iap.android.wallet.acl.payment.PaymentResult> component3() {
        return this.callback;
    }

    public final PayRequest copy(boolean isFromMiniProgram, PaymentRequest paymentRequest, Callback<com.alipay.iap.android.wallet.acl.payment.PaymentResult> callback) {
        Intrinsics.checkNotNullParameter(paymentRequest, "");
        Intrinsics.checkNotNullParameter(callback, "");
        return new PayRequest(isFromMiniProgram, paymentRequest, callback);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayRequest) {
            PayRequest payRequest = (PayRequest) other;
            return this.isFromMiniProgram == payRequest.isFromMiniProgram && Intrinsics.areEqual(this.paymentRequest, payRequest.paymentRequest) && Intrinsics.areEqual(this.callback, payRequest.callback);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.isFromMiniProgram;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.paymentRequest.hashCode()) * 31) + this.callback.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayRequest(isFromMiniProgram=");
        sb.append(this.isFromMiniProgram);
        sb.append(", paymentRequest=");
        sb.append(this.paymentRequest);
        sb.append(", callback=");
        sb.append(this.callback);
        sb.append(')');
        return sb.toString();
    }

    public PayRequest(boolean z, PaymentRequest paymentRequest, Callback<com.alipay.iap.android.wallet.acl.payment.PaymentResult> callback) {
        Intrinsics.checkNotNullParameter(paymentRequest, "");
        Intrinsics.checkNotNullParameter(callback, "");
        this.isFromMiniProgram = z;
        this.paymentRequest = paymentRequest;
        this.callback = callback;
    }

    @JvmName(name = "isFromMiniProgram")
    public final boolean isFromMiniProgram() {
        return this.isFromMiniProgram;
    }

    @JvmName(name = "getPaymentRequest")
    public final PaymentRequest getPaymentRequest() {
        return this.paymentRequest;
    }

    @JvmName(name = "getCallback")
    public final Callback<com.alipay.iap.android.wallet.acl.payment.PaymentResult> getCallback() {
        return this.callback;
    }
}
