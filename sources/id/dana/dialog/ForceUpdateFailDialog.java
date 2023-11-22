package id.dana.dialog;

import android.content.Context;
import android.view.View;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/dialog/ForceUpdateFailDialog;", "", "Landroid/content/Context;", "p0", "Lkotlin/Function1;", "Landroid/view/View;", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ForceUpdateFailDialog {
    public static final ForceUpdateFailDialog INSTANCE = new ForceUpdateFailDialog();

    private ForceUpdateFailDialog() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context p0, Function1<? super View, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(p0);
        builder.DatabaseTableConfigUtil = R.drawable.ic_update_app;
        builder.SubSequence = p0.getString(R.string.app_update_fail_title);
        builder.GetContactSyncConfig = p0.getString(R.string.app_update_fail_subtitle);
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory("OK", p1).BuiltInFictitiousFunctionClassFactory().show();
    }
}
