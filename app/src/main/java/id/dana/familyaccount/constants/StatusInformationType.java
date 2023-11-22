package id.dana.familyaccount.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/familyaccount/constants/StatusInformationType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface StatusInformationType {
    public static final String ACCOUNT_FREEZE = "ACCOUNT_FREEZE";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
    public static final String FAMILY_ACCOUNT_DELETED = "FAMILY_ACCOUNT_DELETED";
    public static final String GENERAL_STATUS_ERROR = "GENERAL_STATUS_ERROR";
    public static final String INVITATION_CANCELED = "INVITATION_CANCELED";
    public static final String KYC_REVOKED = "KYC_REVOKED";
    public static final String MAINTENANCE = "MAINTENANCE";
    public static final String MEMBER_DELETED = "MEMBER_DELETED";
    public static final String MEMBER_USER_FREEZE = "MEMBER_USER_FREEZE";
    public static final String ORGANIZER_HAS_FROZEN = "ORGANIZER_HAS_FROZEN";
    public static final String ORGANIZER_KYC_REVOKED = "ORGANIZER_KYC_REVOKED";
    public static final String REQUEST_EXPIRED = "REQUEST_EXPIRED";
    public static final String STATUS_REVOKED_ROLE_MEMBER = "STATUS_REVOKED_ROLE_MEMBER";
    public static final String STATUS_REVOKED_ROLE_ORGANIZER = "STATUS_REVOKED_ROLE_ORGANIZER";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/constants/StatusInformationType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
