package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/DealsPaymentResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PAYMENT_FAILED", "PAYMENT_ERROR", "PAYMENT_INPROGRESS", "PAYMENT_SUCCESS"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum DealsPaymentResult {
    PAYMENT_FAILED("PAYMENT_FAILED"),
    PAYMENT_ERROR("PAYMENT_ERROR"),
    PAYMENT_INPROGRESS("PAYMENT_INPROGRESS"),
    PAYMENT_SUCCESS("PAYMENT_SUCCESS");

    private final String value;

    DealsPaymentResult(String str) {
        this.value = str;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}
