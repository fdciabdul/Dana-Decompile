package id.dana.data.login.source.network.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface VerifyMethod {
    public static final String CARRIER_IDENTIFICATION = "CARRIER_IDENTIFICATION";
    public static final String DISMISS_PUSH_VERIFY = "DISMISS_PUSH_VERIFY";
    public static final String MIC_FACE = "MIC_FACE";
    public static final String MISSED_CALL_OTP = "MISSED_CALL_OTP";
    public static final String NO_VERIFICATION = "NO_VERIFICATION";
    public static final String OTP_SMS = "OTP_SMS";
    public static final String OTP_WA = "WHATSAPP_OTP";
    public static final String PASSKEY = "PASSKEYS";
    public static final String PASSWORD = "PASSWORD";
    public static final String PUSH_VERIFY = "PUSH_VERIFY";
}
