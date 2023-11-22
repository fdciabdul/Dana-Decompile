package id.dana.sendmoney.ui.groupsend.recipient.view;

import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.ui.groupsend.recipient.datasource.ContactDataSourceFactoryV3;
import id.dana.sendmoney.ui.groupsend.recipient.datasource.RecipientDataSourceFactoryV3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\b6\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "", "BuiltInFictitiousFunctionClassFactory", "I", "p0", "<init>", "(I)V", "Companion", "Contact", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType$Contact;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RecipientSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final int BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ RecipientSourceType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public abstract RecipientDataSourceFactoryV3 MyBillsEntityDataFactory();

    private RecipientSourceType(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType$Contact;", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType;", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Contact extends RecipientSourceType {
        public static final Contact INSTANCE = new Contact();

        private Contact() {
            super(R.string.sendmoneygroup_x2p_searchview_hint, null);
        }

        @Override // id.dana.sendmoney.ui.groupsend.recipient.view.RecipientSourceType
        public final RecipientDataSourceFactoryV3 MyBillsEntityDataFactory() {
            return new ContactDataSourceFactoryV3(false, false, null, 7, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType$Companion;", "", "", "p0", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RecipientSourceType BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (Intrinsics.areEqual(p0, GroupSendRecipientType.CONTACT)) {
                return Contact.INSTANCE;
            }
            throw new IllegalArgumentException("Unknown recipient type");
        }
    }
}
