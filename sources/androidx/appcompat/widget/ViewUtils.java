package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ViewUtils {
    private static Method BuiltInFictitiousFunctionClassFactory;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                BuiltInFictitiousFunctionClassFactory = declaredMethod;
                if (declaredMethod.isAccessible()) {
                    return;
                }
                BuiltInFictitiousFunctionClassFactory.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                InstrumentInjector.log_d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    private ViewUtils() {
    }

    public static boolean getAuthRequestContext(View view) {
        return ViewCompat.initRecordTimeStamp(view) == 1;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, Rect rect, Rect rect2) {
        Method method = BuiltInFictitiousFunctionClassFactory;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                InstrumentInjector.log_d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static void PlaceComponentResult(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            } catch (NoSuchMethodException unused) {
                InstrumentInjector.log_d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                InstrumentInjector.log_d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }
}
