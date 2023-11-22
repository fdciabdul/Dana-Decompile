package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    public static int PlaceComponentResult(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.MyBillsEntityDataFactory(marginLayoutParams);
        }
        return marginLayoutParams.leftMargin;
    }

    public static int BuiltInFictitiousFunctionClassFactory(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.PlaceComponentResult(marginLayoutParams);
        }
        return marginLayoutParams.rightMargin;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (Build.VERSION.SDK_INT < 17) {
            marginLayoutParams.leftMargin = i;
        } else {
            marginLayoutParams.setMarginStart(i);
        }
    }

    public static void getAuthRequestContext(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.PlaceComponentResult(marginLayoutParams, i);
        } else {
            marginLayoutParams.rightMargin = i;
        }
    }

    private MarginLayoutParamsCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static int MyBillsEntityDataFactory(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        static int PlaceComponentResult(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        static void PlaceComponentResult(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginEnd(i);
        }
    }
}
