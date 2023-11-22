package id.dana.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface IntentKeySource {

    /* loaded from: classes3.dex */
    public @interface DEEPLINK {
        public static final String MERCHANT_RETURN_URL = "merchant_return_url";
        public static final String ON_TRANSACTION_DEEPLINK_PAYMENT = "on_transaction_deeplink_payment";
    }

    /* loaded from: classes3.dex */
    public @interface FamilyAccountKey {
        public static final String ON_INVITATION_REJECTED = "on_invitation_rejected";
    }

    /* loaded from: classes3.dex */
    public @interface TransactionKey {
        public static final String ON_TRANSACTION_SUCCESS = "on_transaction_success";
    }
}
