package id.dana.utils.rpc.errorcode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface VerificationErrorCode {
    public static final String BOKU_FAILED = "AE15001858018002";
    public static final String RETRY_VERIFY = "AE15001858018406";
    public static final String VERIFY_FAILED_BACK_OTP = "AE15002058020033";
}
