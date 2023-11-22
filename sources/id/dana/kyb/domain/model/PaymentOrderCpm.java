package id.dana.kyb.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/PaymentOrderCpm;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "merchantTransId", "acquirementId", "amount", "closeReason", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/PaymentOrderCpm;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcquirementId", "getAmount", "getCloseReason", "getMerchantTransId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOrderCpm {
    private final String acquirementId;
    private final String amount;
    private final String closeReason;
    private final String merchantTransId;

    public static /* synthetic */ PaymentOrderCpm copy$default(PaymentOrderCpm paymentOrderCpm, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentOrderCpm.merchantTransId;
        }
        if ((i & 2) != 0) {
            str2 = paymentOrderCpm.acquirementId;
        }
        if ((i & 4) != 0) {
            str3 = paymentOrderCpm.amount;
        }
        if ((i & 8) != 0) {
            str4 = paymentOrderCpm.closeReason;
        }
        return paymentOrderCpm.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCloseReason() {
        return this.closeReason;
    }

    public final PaymentOrderCpm copy(String merchantTransId, String acquirementId, String amount, String closeReason) {
        Intrinsics.checkNotNullParameter(merchantTransId, "");
        Intrinsics.checkNotNullParameter(acquirementId, "");
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(closeReason, "");
        return new PaymentOrderCpm(merchantTransId, acquirementId, amount, closeReason);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaymentOrderCpm) {
            PaymentOrderCpm paymentOrderCpm = (PaymentOrderCpm) other;
            return Intrinsics.areEqual(this.merchantTransId, paymentOrderCpm.merchantTransId) && Intrinsics.areEqual(this.acquirementId, paymentOrderCpm.acquirementId) && Intrinsics.areEqual(this.amount, paymentOrderCpm.amount) && Intrinsics.areEqual(this.closeReason, paymentOrderCpm.closeReason);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.merchantTransId.hashCode() * 31) + this.acquirementId.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.closeReason.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentOrderCpm(merchantTransId=");
        sb.append(this.merchantTransId);
        sb.append(", acquirementId=");
        sb.append(this.acquirementId);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", closeReason=");
        sb.append(this.closeReason);
        sb.append(')');
        return sb.toString();
    }

    public PaymentOrderCpm(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.merchantTransId = str;
        this.acquirementId = str2;
        this.amount = str3;
        this.closeReason = str4;
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCloseReason")
    public final String getCloseReason() {
        return this.closeReason;
    }
}
