package id.dana.notification;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface RedirectType {
    public static final String CDP = "CDP";
    public static final String DEALS = "DEALS";
    public static final String DEEPLINK = "DEEPLINK";
    public static final String INNER_URL = "INNER_URL";
    public static final String IPG_REGISTRATION = "ipgRegistration";
    public static final String OCR_RECEIPT = "OCR_RECEIPT";
    public static final String TRANSACTION_DETAIL = "TRANSACTION_DETAIL";
    public static final String TWILIO_CHALLENGE = "TWILIO_CHALLENGE";
    public static final String URL = "URL";
    public static final String VOUCHER_DETAIL = "VOUCHER_DETAIL";
}
