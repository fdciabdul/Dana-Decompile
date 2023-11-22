package id.dana.electronicmoney.bank.mandiri.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/MandiriApdu;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface MandiriApdu {
    public static final String CARD_ATTRIBUTE = "00F210000B";
    public static final String CARD_INFO = "00B300003F";
    public static final String CARD_UID = "FFCA000000";
    public static final String CERTIFICATE = "00E0000000";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String DATA_TO_CREATE_SAM = "00E50000";
    public static final String EMONEY_AVAILABILITY = "00A40400080000000000000001";
    public static final String LAST_BALANCE = "00B500000A";
    public static final String REVERSAL_DATA_TO_CREATE_SAM = "00E70000";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/MandiriApdu$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
