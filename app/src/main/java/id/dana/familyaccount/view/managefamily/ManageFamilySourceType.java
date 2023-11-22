package id.dana.familyaccount.view.managefamily;

import id.dana.R;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\f\r"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "", "", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "p0", "<init>", "(I)V", "Companion", "Member", "Organizer", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType$Organizer;", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType$Member;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ManageFamilySourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    public /* synthetic */ ManageFamilySourceType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private ManageFamilySourceType(int i) {
        this.getAuthRequestContext = i;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType$Organizer;", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Organizer extends ManageFamilySourceType {
        public static final Organizer INSTANCE = new Organizer();

        private Organizer() {
            super(R.string.manage_family_role_organizer, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType$Member;", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Member extends ManageFamilySourceType {
        public static final Member INSTANCE = new Member();

        private Member() {
            super(R.string.manage_family_role_member, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType$Companion;", "", "", "p0", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ManageFamilySourceType BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return Intrinsics.areEqual(p0, FamilyAccountInvitationStatusType.ACCOUNT_OWNER) ? Organizer.INSTANCE : Member.INSTANCE;
        }
    }
}
