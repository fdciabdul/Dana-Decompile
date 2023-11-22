package id.dana.mybills.ui.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/mybills/ui/constant/MyBillsPurposeAction;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface MyBillsPurposeAction {
    public static final String ADD_NEW_BILLS = "Add New Bills";
    public static final String ADD_NEW_RECOMENDED_BILLS = "Add New Recomended Bills";
    public static final String BILL_DETAIL = "Bill Detail";
    public static final String BULK_PAY = "Bulk Pay";
    public static final String CANCEL = "Cancel";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String DELETE = "Delete";
    public static final String EDIT = "Edit";
    public static final String MANAGE_BILLS = "Manage Bills";
    public static final String PAY = "Pay";
    public static final String SAVE = "Save";
    public static final String SAVE_BILL = "Save Bill";
    public static final String SAVE_BILL_AND_PAY = "Save Bill & Pay";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/MyBillsPurposeAction$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
