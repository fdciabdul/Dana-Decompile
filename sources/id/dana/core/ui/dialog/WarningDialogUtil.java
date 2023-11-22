package id.dana.core.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.dialog.CommonDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0007\u0010\u000f"}, d2 = {"Lid/dana/core/ui/dialog/WarningDialogUtil;", "", "Landroid/content/Context;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/content/DialogInterface$OnDismissListener;", "p2", "", "p3", "", "p4", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;ZI)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WarningDialogUtil {
    public static final WarningDialogUtil INSTANCE = new WarningDialogUtil();

    private WarningDialogUtil() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(p0, p1, null, true, 0);
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Context p0, String p1, DialogInterface.OnDismissListener p2, boolean p3, int p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        CommonDialog.Builder builder = new CommonDialog.Builder(p0);
        builder.lookAheadTest = p1;
        DialogType dialogType = DialogType.WARNING;
        Intrinsics.checkNotNullParameter(dialogType, "");
        builder.DatabaseTableConfigUtil = dialogType;
        if (p2 != null) {
            builder.BuiltInFictitiousFunctionClassFactory = p2;
        }
        if (p3) {
            builder.getAuthRequestContext = p3;
        }
        if (p4 > 0) {
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = p4;
        }
        new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder).moveToNextValue();
    }
}
