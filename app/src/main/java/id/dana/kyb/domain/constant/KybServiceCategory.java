package id.dana.kyb.domain.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/kyb/domain/constant/KybServiceCategory;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface KybServiceCategory {
    public static final String BUSINESS_EDUCATION = "kyb_service_business_education";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String DIGITAL_MONEY = "kyb_service_digital_money";
    public static final String GAMES = "kyb_service_games";
    public static final String MOBILE_RECHARGE = "kyb_service_mobile_recharge";
    public static final String PRODUCT_CATALOG = "kyb_service_product_catalog";
    public static final String PROMO = "kyb_service_promo";
    public static final String QRIS_BUSINESS = "kyb_service_product_qris_business";
    public static final String REQUEST_PAYMENT = "kyb_service_request_payment";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/kyb/domain/constant/KybServiceCategory$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
