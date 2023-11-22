package id.dana.danapoly.data.play.model.response;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/danapoly/data/play/model/response/RollDiceErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface RollDiceErrorCode {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String EVENT_EXPIRED = "DP002010103";
    public static final String EVENT_NOT_FOUND = "DP002010101";
    public static final String EVENT_NOT_STARTED = "DP002010102";
    public static final String INSUFFICIENT_FUND = "DP002010104";
    public static final String SYSTEM_ERROR = "DP002010001";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/danapoly/data/play/model/response/RollDiceErrorCode$Companion;", "", "", "EVENT_EXPIRED", "Ljava/lang/String;", "EVENT_NOT_FOUND", "EVENT_NOT_STARTED", "INSUFFICIENT_FUND", "SYSTEM_ERROR", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String EVENT_EXPIRED = "DP002010103";
        public static final String EVENT_NOT_FOUND = "DP002010101";
        public static final String EVENT_NOT_STARTED = "DP002010102";
        public static final String INSUFFICIENT_FUND = "DP002010104";
        public static final String SYSTEM_ERROR = "DP002010001";

        private Companion() {
        }
    }
}
