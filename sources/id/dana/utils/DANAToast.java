package id.dana.utils;

import android.app.Activity;
import id.dana.component.customtoastcomponent.CustomToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lid/dana/utils/DANAToast;", "", "()V", "showTopErrorToast", "", "Landroid/app/Activity;", "message", "", "contentDescription", "showTopToast", "showTopWarningToast", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DANAToast {
    public static final DANAToast PlaceComponentResult = new DANAToast();

    private DANAToast() {
    }

    public static /* synthetic */ void PlaceComponentResult(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter("", "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, id.dana.R.drawable.ic_close_red, id.dana.R.drawable.bg_rounded_border_red_50, str, 64, true, "");
    }

    public static void getAuthRequestContext(Activity activity, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, id.dana.R.drawable.ic_close_red, id.dana.R.drawable.bg_rounded_border_red_50, str, 64, true, str2);
    }

    public static void MyBillsEntityDataFactory(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, id.dana.R.drawable.ic_warning_yellow, id.dana.R.drawable.bg_rounded_border_yellow_50, str, 64, true, null);
    }

    public static /* synthetic */ void getAuthRequestContext(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter("", "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, id.dana.R.drawable.ic_check_24_green50_filled_circle, id.dana.R.drawable.bg_rounded_border_green_50, str, 64, true, "");
    }

    public static void PlaceComponentResult(Activity activity, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, id.dana.R.drawable.ic_check_24_green50_filled_circle, id.dana.R.drawable.bg_rounded_border_green_50, str, 64, true, str2);
    }
}
