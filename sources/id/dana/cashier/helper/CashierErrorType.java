package id.dana.cashier.helper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/helper/CashierErrorType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface CashierErrorType {
    public static final String ACCOUNT_ON_HOLD = "ACCOUNT_ON_HOLD";
    public static final String API_LIMITED = "API_LIMITED";
    public static final String BCA_ONE_KLIK = "BCA_ONE_KLIK";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
    public static final String DEX_GUARD = "DEX_GUARD";
    public static final String EXCEED_LIMIT = "EXCEED_LIMIT";
    public static final String FORCE_FACE_AUTH_ERROR = "FORCE_FACE_AUTH_ERROR";
    public static final String INSUFFICIENT_PAYLATER_LIMIT = "INSUFFICIENT_PAYLATER_LIMIT";
    public static final String KYC_NOT_READY = "KYC_NOT_READY";
    public static final String NETWORK_TIMEOUT = "NETWORK_TIMEOUT";
    public static final String OTP_BANK_ERROR = "OTP_BANK_ERROR";
    public static final String OTP_ERROR = "OTP_ERROR";
    public static final String OTP_LIMITED = "OTP_LIMITED";
    public static final String RESULT_PAGE = "RESULT_PAGE";
    public static final String RETRYABLE_RISK_CHALLENGE = "RETRYABLE_RISK_CHALLENGE";
    public static final String SYSTEM_BUSY = "SYSTEM_BUSY";
    public static final String UNSTABLE_NETWORK = "UNSTABLE_NETWORK";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/helper/CashierErrorType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
