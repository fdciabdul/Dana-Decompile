package id.dana.familyaccount.view.statusinformation;

import id.dana.R;
import id.dana.familyaccount.constants.StatusInformationType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u000f2\u00020\u0001:\r\u0010\u000f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB+\b\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u0082\u0001\f\u001c\u001d\u001e\u001f !\"#$%&'"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "<init>", "(IIII)V", "Companion", "AccountOnHold", "FamilyAccountDeleted", "GeneralStatusError", "KycRevoked", "Maintenance", "MemberDeleted", "OrganizerFrozen", "OrganizerKycRevoked", "RequestExpired", "StatusInvitationCanceled", "StatusRevokedRoleMember", "StatusRevokedRoleOrganizer", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$GeneralStatusError;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$Maintenance;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusRevokedRoleOrganizer;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusRevokedRoleMember;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$FamilyAccountDeleted;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$MemberDeleted;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$OrganizerFrozen;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusInvitationCanceled;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$AccountOnHold;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$RequestExpired;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$KycRevoked;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$OrganizerKycRevoked;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class StatusInformationSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    final int BuiltInFictitiousFunctionClassFactory;
    final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int PlaceComponentResult;

    public /* synthetic */ StatusInformationSourceType(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    private StatusInformationSourceType(int i, int i2, int i3, int i4) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        this.PlaceComponentResult = i3;
        this.MyBillsEntityDataFactory = i4;
    }

    public /* synthetic */ StatusInformationSourceType(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? R.string.join_invitation_button_title_got_it : i4, null);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$GeneralStatusError;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class GeneralStatusError extends StatusInformationSourceType {
        public static final GeneralStatusError INSTANCE = new GeneralStatusError();

        private GeneralStatusError() {
            super(R.drawable.ic_something_wrong, R.string.family_account_general_failed_to_load_title, R.string.family_account_general_failed_to_load_description, R.string.family_account_text_organizer_summary_btn_retry, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$Maintenance;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Maintenance extends StatusInformationSourceType {
        public static final Maintenance INSTANCE = new Maintenance();

        private Maintenance() {
            super(R.drawable.ic_family_under_maintenance, R.string.family_maintenance_title, R.string.family_maintenance_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusRevokedRoleOrganizer;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StatusRevokedRoleOrganizer extends StatusInformationSourceType {
        public static final StatusRevokedRoleOrganizer INSTANCE = new StatusRevokedRoleOrganizer();

        private StatusRevokedRoleOrganizer() {
            super(R.drawable.ic_family_member_deleted, R.string.family_member_deleted_title, R.string.family_account_deleted_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusRevokedRoleMember;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StatusRevokedRoleMember extends StatusInformationSourceType {
        public static final StatusRevokedRoleMember INSTANCE = new StatusRevokedRoleMember();

        private StatusRevokedRoleMember() {
            super(R.drawable.ic_family_member_deleted, R.string.family_account_revoked_role_member_title, R.string.family_account_revoked_role_member_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$FamilyAccountDeleted;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FamilyAccountDeleted extends StatusInformationSourceType {
        public static final FamilyAccountDeleted INSTANCE = new FamilyAccountDeleted();

        private FamilyAccountDeleted() {
            super(R.drawable.ic_family_member_deleted, R.string.family_member_deleted_title, R.string.family_account_deleted_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$MemberDeleted;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MemberDeleted extends StatusInformationSourceType {
        public static final MemberDeleted INSTANCE = new MemberDeleted();

        private MemberDeleted() {
            super(R.drawable.ic_family_member_deleted, R.string.family_member_deleted_title, R.string.family_member_deleted_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$OrganizerFrozen;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OrganizerFrozen extends StatusInformationSourceType {
        public static final OrganizerFrozen INSTANCE = new OrganizerFrozen();

        private OrganizerFrozen() {
            super(R.drawable.res_0x7f080905_networkuserentitydata_externalsyntheticlambda0, R.string.family_organizer_account_freeze_title, R.string.family_account_freeze_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$StatusInvitationCanceled;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StatusInvitationCanceled extends StatusInformationSourceType {
        public static final StatusInvitationCanceled INSTANCE = new StatusInvitationCanceled();

        private StatusInvitationCanceled() {
            super(R.drawable.ic_family_account_invite_canceled, R.string.family_status_invite_canceled_title, R.string.family_status_invited_canceled_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$AccountOnHold;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AccountOnHold extends StatusInformationSourceType {
        public static final AccountOnHold INSTANCE = new AccountOnHold();

        private AccountOnHold() {
            super(R.drawable.res_0x7f080905_networkuserentitydata_externalsyntheticlambda0, R.string.family_account_text_organizer_summary_account_freeze_title, R.string.family_account_text_organizer_summary_account_freeze_desc, R.string.family_account_text_organizer_summary_button_contact_customer_care, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$RequestExpired;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RequestExpired extends StatusInformationSourceType {
        public static final RequestExpired INSTANCE = new RequestExpired();

        private RequestExpired() {
            super(R.drawable.ic_req_family_expired, R.string.family_account_text_organizer_summary_req_expired_title, R.string.family_account_text_organizer_summary_req_expired_desc, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$KycRevoked;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class KycRevoked extends StatusInformationSourceType {
        public static final KycRevoked INSTANCE = new KycRevoked();

        private KycRevoked() {
            super(R.drawable.ic_family_account_kyc_revoked, R.string.family_account_text_organizer_summary_kyc_revoke_title, R.string.family_account_text_organizer_summary_kyc_revoke_desc, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$OrganizerKycRevoked;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OrganizerKycRevoked extends StatusInformationSourceType {
        public static final OrganizerKycRevoked INSTANCE = new OrganizerKycRevoked();

        private OrganizerKycRevoked() {
            super(R.drawable.ic_family_account_kyc_revoked, R.string.family_organizer_account_freeze_title, R.string.family_status_organizer_kyc_revoke_description, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType$Companion;", "", "", "p0", "Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/familyaccount/view/statusinformation/StatusInformationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static StatusInformationSourceType BuiltInFictitiousFunctionClassFactory(@StatusInformationType String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            switch (p0.hashCode()) {
                case -1824356621:
                    if (p0.equals("MAINTENANCE")) {
                        return Maintenance.INSTANCE;
                    }
                    break;
                case -1164871444:
                    if (p0.equals("FAMILY_ACCOUNT_DELETED")) {
                        return FamilyAccountDeleted.INSTANCE;
                    }
                    break;
                case -850510209:
                    if (p0.equals("INVITATION_CANCELED")) {
                        return StatusInvitationCanceled.INSTANCE;
                    }
                    break;
                case -86067292:
                    if (p0.equals("ORGANIZER_KYC_REVOKED")) {
                        return OrganizerKycRevoked.INSTANCE;
                    }
                    break;
                case 330987829:
                    if (p0.equals("REQUEST_EXPIRED")) {
                        return RequestExpired.INSTANCE;
                    }
                    break;
                case 944938249:
                    if (p0.equals("ACCOUNT_FREEZE")) {
                        return AccountOnHold.INSTANCE;
                    }
                    break;
                case 982907220:
                    if (p0.equals(StatusInformationType.STATUS_REVOKED_ROLE_ORGANIZER)) {
                        return StatusRevokedRoleOrganizer.INSTANCE;
                    }
                    break;
                case 1048409717:
                    if (p0.equals(StatusInformationType.STATUS_REVOKED_ROLE_MEMBER)) {
                        return StatusRevokedRoleMember.INSTANCE;
                    }
                    break;
                case 1136849717:
                    if (p0.equals("ORGANIZER_HAS_FROZEN")) {
                        return OrganizerFrozen.INSTANCE;
                    }
                    break;
                case 1398781140:
                    if (p0.equals(StatusInformationType.KYC_REVOKED)) {
                        return KycRevoked.INSTANCE;
                    }
                    break;
                case 1441245012:
                    if (p0.equals("MEMBER_DELETED")) {
                        return MemberDeleted.INSTANCE;
                    }
                    break;
            }
            return GeneralStatusError.INSTANCE;
        }
    }
}
