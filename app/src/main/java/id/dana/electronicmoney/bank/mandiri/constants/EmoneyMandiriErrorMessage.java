package id.dana.electronicmoney.bank.mandiri.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/EmoneyMandiriErrorMessage;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface EmoneyMandiriErrorMessage {
    public static final String CARD_NOT_SUPPORTED = "CARD_NOT_SUPPORTED";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
    public static final String ERROR_AGGREGATOR = "ERROR_AGGREGATOR";
    public static final String ERROR_MESSAGE_DONE = "ERROR_MESSAGE_DONE";
    public static final String GENERAL_ERROR = "GENERAL_ERROR";
    public static final String RETRY_UPDATE_BALANCE = "RETRY_UPDATE_BALANCE";
    public static final String REVERSAL = "REVERSAL";
    public static final String REVERSAL_FAILED = "REVERSAL_FAILED";
    public static final String REVERSAL_UPDATE_BALANCE = "REVERSAL_UPDATE_BALANCE";
    public static final String TIMEOUT = "TIMEOUT";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/constants/EmoneyMandiriErrorMessage$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
