package id.dana.familyaccount.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/familyaccount/constants/FamilyStatusConsultConstant;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface FamilyStatusConsultConstant {
    public static final String ACCOUNT_FREEZE = "ACCOUNT_FREEZE";
    public static final String ACCOUNT_HAS_FROZEN = "ACCOUNT_HAS_FROZEN";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String FAMILY_ACCOUNT_DELETED = "FAMILY_ACCOUNT_DELETED";
    public static final String HAS_FAMILY_ACCOUNT = "HAS_FAMILY_ACCOUNT";
    public static final String HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE = "HAS_NOT_FAMILY_ACCOUNT|CANNOT_CREATE";
    public static final String HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE = "HAS_NOT_FAMILY_ACCOUNT|CAN_CREATE";
    public static final String INVITATION_CANCELED = "INVITATION_CANCELED";
    public static final String MAINTENANCE = "MAINTENANCE";
    public static final String MEMBER_DELETED = "MEMBER_DELETED";
    public static final String ORGANIZER_HAS_FROZEN = "ORGANIZER_HAS_FROZEN";
    public static final String ORGANIZER_KYC_REVOKED = "ORGANIZER_KYC_REVOKED";
    public static final String PENDING = "PENDING";
    public static final String REQUEST_EXPIRED = "REQUEST_EXPIRED";
    public static final String REVOKED = "REVOKED";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/constants/FamilyStatusConsultConstant$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
