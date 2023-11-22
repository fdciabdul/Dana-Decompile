package id.dana.cashier.model.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/model/constants/PaymentResultBackToHomeStatus;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface PaymentResultBackToHomeStatus {
    public static final String CANCELLED = "CANCELLED";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String EMPTY = "";
    public static final String FAILED = "FAILED";
    public static final String PENDING = "PENDING";
    public static final String SUCCESS = "SUCCESS";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/model/constants/PaymentResultBackToHomeStatus$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
