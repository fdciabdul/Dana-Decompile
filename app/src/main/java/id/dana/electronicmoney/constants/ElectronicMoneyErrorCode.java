package id.dana.electronicmoney.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/electronicmoney/constants/ElectronicMoneyErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface ElectronicMoneyErrorCode {
    public static final String CALL_CS = "008";
    public static final String CARD_EXPIRED = "011";
    public static final String CARD_NOT_SUPPORTED = "004";
    public static final String CARD_READ_ERROR = "005";
    public static final String CARD_WRITE_ERROR = "006";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;
    public static final String DEVICE_NOT_SUPPORTED = "002";
    public static final String GENERAL_ERROR = "001";
    public static final String INQUIRY_BALANCE_FAILED = "016";
    public static final String NFC_FEATURE_DISABLED = "003";
    public static final String NO_NETWORK_AVAILABLE = "014";
    public static final String REACH_LIMIT = "013";
    public static final String READ_FROM_CARD = "010";
    public static final String RETRY_UPDATE_CARD_LIMIT = "015";
    public static final String REVERSAL_ERROR = "009";
    public static final String SUCCESS = "000";
    public static final String TIMEOUT_NFC = "007";
    public static final String UPDATE_BALANCE_FAILED = "012";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/electronicmoney/constants/ElectronicMoneyErrorCode$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
