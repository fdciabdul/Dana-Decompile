package id.dana.utils.deeplink;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes9.dex */
public interface DeepLinkConstant {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DeepLinkParams {
        public static final String ORDER_ID = "orderId";
        public static final String PARAMS = "params";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DeepLinkPath {
        public static final String CASHOUT = "/cashoutlink";
        public static final String LINK_PAYMENT = "/paymentlink";
        public static final String LINK_PAYMENT_P2M = "/p2mlink";
        public static final String LUCKY_MONEY = "/luckymoney";
        public static final String SPIN_THE_WHEEL = "/spinthewheel";
    }
}
