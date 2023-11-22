package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
class CanvasUtils {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static boolean PlaceComponentResult;
    private static Method getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Canvas canvas, boolean z) {
        Method method;
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (z) {
                    canvas.enableZ();
                } else {
                    canvas.disableZ();
                }
            } else if (Build.VERSION.SDK_INT == 28) {
                throw new IllegalStateException("This method doesn't work on Pie!");
            } else {
                if (!PlaceComponentResult) {
                    try {
                        Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                        BuiltInFictitiousFunctionClassFactory = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                        getAuthRequestContext = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    PlaceComponentResult = true;
                }
                if (z) {
                    try {
                        Method method2 = BuiltInFictitiousFunctionClassFactory;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException unused2) {
                        return;
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
                if (z || (method = getAuthRequestContext) == null) {
                    return;
                }
                method.invoke(canvas, new Object[0]);
            }
        }
    }

    private CanvasUtils() {
    }
}
