package id.dana.nearbyme.merchantdetail.adapter;

import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantLabelType;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "PROMO", "BISNIS", DeeplinkService.Scene.TOP_UP, "ORDER_ONLINE", "QRIS"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum MerchantLabelType {
    PROMO(1),
    BISNIS(2),
    TOP_UP(3),
    ORDER_ONLINE(4),
    QRIS(5);

    private final int value;

    MerchantLabelType(int i) {
        this.value = i;
    }

    @JvmName(name = "getValue")
    public final int getValue() {
        return this.value;
    }
}
