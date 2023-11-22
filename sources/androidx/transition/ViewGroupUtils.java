package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ViewGroupUtils {
    private static Method BuiltInFictitiousFunctionClassFactory = null;
    private static boolean MyBillsEntityDataFactory = true;
    private static boolean getAuthRequestContext = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroupOverlayImpl getAuthRequestContext(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.BuiltInFictitiousFunctionClassFactory(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT < 18) {
            ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory(viewGroup, z);
        } else if (MyBillsEntityDataFactory) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                MyBillsEntityDataFactory = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!getAuthRequestContext) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                BuiltInFictitiousFunctionClassFactory = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            getAuthRequestContext = true;
        }
        Method method = BuiltInFictitiousFunctionClassFactory;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }

    private ViewGroupUtils() {
    }
}
