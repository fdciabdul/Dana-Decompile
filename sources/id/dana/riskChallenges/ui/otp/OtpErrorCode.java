package id.dana.riskChallenges.ui.otp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface OtpErrorCode {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String ERROR_CODE_DANA_ACCOUNT_FROZEN_2 = "AE15112158065208";
    public static final String ERROR_CODE_DANA_PIN_OR_OTP_TEMPORARY_LOCK = "AE15102058020051";
    public static final String OTP_DAILY_LIMIT = "AE15112158100410";
    public static final String OTP_EXPIRED = "AE15002058020032";
    public static final String OTP_SEND_SHORT_INTERVAL = "AE15112158100310";
    public static final String TOO_MANY_REQUEST_OTP = "AE15002058020031";
    public static final String TOO_MANY_REQUEST_VERIFICATION = "AE15002058020037";
    public static final String TOO_MANY_VERIFY_OTP = "AE15101858018005";
    public static final String WRONG_OTP = "AE15002058020033";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpErrorCode$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
