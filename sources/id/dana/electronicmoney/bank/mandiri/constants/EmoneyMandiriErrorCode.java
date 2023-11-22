package id.dana.electronicmoney.bank.mandiri.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/EmoneyMandiriErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface EmoneyMandiriErrorCode {
    public static final String ACCOUNT_LIMIT_EXCEEDED = "51005";
    public static final String CARD_NOT_FOUND = "51001";
    public static final String CARD_NOT_SUPPORTED = "51010";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.PlaceComponentResult;
    public static final String DATA_MISMATCH = "51011";
    public static final String DIGITAL_SIGNATURE_FAIL = "AE11012068051008";
    public static final String DIGITAL_SIGNATURE_FAILED = "51008";
    public static final String GENERAL_ERROR = "51000";
    public static final String INSUFFICIENT_FUND = "51012";
    public static final String MONTHLY_TOPUP_LIMIT_EXCEDEED = "51009";
    public static final String NO_PENDING_BALANCE = "AE11012068051003";
    public static final String RETRY_UPDATE_BALANCE = "AE11301858018501";
    public static final String REVERSAL_AMOUNT_DID_NOT_MATCH = "51004";
    public static final String REVERSAL_IN_PROGRESS = "REVERSAL_IN_PROGRESS";
    public static final String REVERSAL_LIMIT_EXCEEDED = "REVERSAL_LIMIT_EXCEEDED";
    public static final String REVERSAL_NEEDED = "REVERSAL_NEEDED";
    public static final String REVERSAL_UPDATE_BALANCE = "AE11301858018502";
    public static final String TERMINAL_NOT_FOUND = "AE11323360001017";
    public static final String TERMINAL_NOT_FOUND_CODE = "51007";
    public static final String THREE_TIMES_LIMIT = "RETRY_LIMIT_EXCEEDED";
    public static final String TID_NOT_FOUND = "AE11012068051002";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String TRANSACTION_CAN_NOT_BE_FOUND = "51013";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/EmoneyMandiriErrorCode$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion PlaceComponentResult = new Companion();

        private Companion() {
        }
    }
}
