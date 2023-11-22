package id.dana.cashier.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/cashier/domain/TransactionScenario;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface TransactionScenario {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String ELECTRONIC_MONEY = "ELECTRONIC_MONEY";
    public static final String INSURANCE = "INSURANCE";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/TransactionScenario$Companion;", "", "", "ELECTRONIC_MONEY", "Ljava/lang/String;", "INSURANCE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ELECTRONIC_MONEY = "ELECTRONIC_MONEY";
        public static final String INSURANCE = "INSURANCE";

        private Companion() {
        }
    }
}
