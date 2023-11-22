package id.dana.expresspurchase.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/expresspurchase/constant/ExpressPurchaseResult;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface ExpressPurchaseResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.PlaceComponentResult;
    public static final String FAILED_NOT_ENOUGH_BALANCE_RESULT = "not_enough_balance";
    public static final String FAILED_RESULT = "failed";
    public static final String GENERAL_ERROR = "general_error";
    public static final String PENDING_RESULT = "pending";
    public static final String PREV_SCREEN_CONFIRMATION = "confirmation_page";
    public static final String PREV_SCREEN_LOADING = "loading_page";
    public static final String SUCCESS_RESULT = "success";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/expresspurchase/constant/ExpressPurchaseResult$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion PlaceComponentResult = new Companion();

        private Companion() {
        }
    }
}
