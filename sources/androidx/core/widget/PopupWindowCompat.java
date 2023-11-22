package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static Field BuiltInFictitiousFunctionClassFactory;
    private static Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean PlaceComponentResult;
    private static boolean getAuthRequestContext;

    private PopupWindowCompat() {
    }

    public static void MyBillsEntityDataFactory(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 19) {
            if ((GravityCompat.BuiltInFictitiousFunctionClassFactory(i3, ViewCompat.initRecordTimeStamp(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
            return;
        }
        popupWindow.showAsDropDown(view, i, i2, i3);
    }

    public static void getAuthRequestContext(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.BuiltInFictitiousFunctionClassFactory(popupWindow, z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!PlaceComponentResult) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    BuiltInFictitiousFunctionClassFactory = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    InstrumentInjector.log_i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                PlaceComponentResult = true;
            }
            Field field = BuiltInFictitiousFunctionClassFactory;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    InstrumentInjector.log_i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    public static void MyBillsEntityDataFactory(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.PlaceComponentResult(popupWindow, i);
            return;
        }
        if (!getAuthRequestContext) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                KClassImpl$Data$declaredNonStaticMembers$2 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            getAuthRequestContext = true;
        }
        Method method = KClassImpl$Data$declaredNonStaticMembers$2;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        static void PlaceComponentResult(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }
}
