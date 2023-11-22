package id.dana.cashier;

import android.content.Context;
import android.view.View;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/CashierPinOtpLimiterDialog;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "Lkotlin/Function1;", "Landroid/view/View;", "", "p3", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPinOtpLimiterDialog {
    public static final CashierPinOtpLimiterDialog INSTANCE = new CashierPinOtpLimiterDialog();

    private CashierPinOtpLimiterDialog() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context p0, String p1, int p2, Function1<? super View, Unit> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(p0);
        builder.DatabaseTableConfigUtil = id.dana.R.drawable.illustration_account_frozen;
        builder.SubSequence = p0.getString(id.dana.R.string.your_account_is_on_hold);
        builder.GetContactSyncConfig = p1;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        String string = p0.getString(p2);
        Intrinsics.checkNotNullParameter(p3, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(p3);
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }
}
