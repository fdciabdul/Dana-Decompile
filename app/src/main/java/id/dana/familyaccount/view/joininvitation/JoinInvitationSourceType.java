package id.dana.familyaccount.view.joininvitation;

import id.dana.R;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B)\b\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004\u0082\u0001\u0003\u0013\u0014\u0015"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "p0", "p1", "p2", "p3", "<init>", "(IIII)V", "Companion", "Invalid", "Pending", "Success", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Pending;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Invalid;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Success;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class JoinInvitationSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int PlaceComponentResult;

    public /* synthetic */ JoinInvitationSourceType(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    private JoinInvitationSourceType(int i, int i2, int i3, int i4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = i2;
        this.PlaceComponentResult = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Pending;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Pending extends JoinInvitationSourceType {
        public static final Pending INSTANCE = new Pending();

        private Pending() {
            super(R.drawable.ic_illustration_family_account_family, R.string.join_invitation_title_content, R.string.join_invitation_desc_content, R.string.img_join_family_account, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Invalid;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Invalid extends JoinInvitationSourceType {
        public static final Invalid INSTANCE = new Invalid();

        private Invalid() {
            super(R.drawable.ic_invalid_join_family_account, R.string.join_invitation_invalid_title_content, R.string.join_invitation_invalid_desc_content, R.string.img_invitation_invalid, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Success;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Success extends JoinInvitationSourceType {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(R.drawable.ic_family_account_success_join, R.string.join_invitation_success_title_content, R.string.join_invitation_success_desc_content, R.string.img_success_join_family, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType$Companion;", "", "", "p0", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/familyaccount/view/joininvitation/JoinInvitationSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static JoinInvitationSourceType PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            int hashCode = p0.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode != 35394935) {
                    if (hashCode == 62073616 && p0.equals(FamilyAccountInvitationStatusType.ABORT)) {
                        return Invalid.INSTANCE;
                    }
                } else if (p0.equals("PENDING")) {
                    return Pending.INSTANCE;
                }
            } else if (p0.equals("SUCCESS")) {
                return Success.INSTANCE;
            }
            return Invalid.INSTANCE;
        }
    }
}
