package id.dana.electronicmoney.bank.bri;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/electronicmoney/bank/bri/BrizziSdkResponse;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface BrizziSdkResponse {
    public static final String API_PARAM_EMPTY = "64";
    public static final String CARD_NOT_FOUND = "09";
    public static final String CLOSE_CARD = "06";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String DUPLICATE_REFF = "93";
    public static final String EMPTY_VARIABLE = "92";
    public static final String ERROR_CARD_READ = "03";
    public static final String EXPIRED_CARD = "08";
    public static final String INVALID_DATA_TYPE = "98";
    public static final String INVALID_RANDOM = "96";
    public static final String INVALID_SDK_VERSION = "97";
    public static final String NFC_UNAVAILABLE = "81";
    public static final String NO_NETWORK = "01";
    public static final String OVER_TOPUP = "05";
    public static final String TIMEOUT = "91";
    public static final String ZERO_BALANCE = "04";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/electronicmoney/bank/bri/BrizziSdkResponse$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
