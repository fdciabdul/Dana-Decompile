package id.dana.riskChallenges.ui.missedCallOtp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/CitCallErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface CitCallErrorCode {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String EXCEED_OTP_PERIOD = "AE15112158352729";
    public static final String GENERIC_ERROR = "AE15112158352723";
    public static final String INVALID_OTP = "AE15112158352728";
    public static final String MAX_ATTEMPTS_REACHED = "AE15112158352724";
    public static final String MIN_INTERVAL_NOT_PASSED = "AE15112158352725";
    public static final String MIN_SEND_INTERVAL_NOT_PASSED_CREATE_TOKEN = "AE15112158351725";
    public static final String OTP_EXPIRED = "AE15112158352726";
    public static final String RISK_CONSULT_REACH_LIMIT = "AE15101858018087";
    public static final String SYSTEM_BUSY = "AE15001858018002";
    public static final String TIMEOUT = "AE15112158352730";
    public static final String VERIFY_OTP_EXPIRED = "AE15112158352727";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/CitCallErrorCode$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
