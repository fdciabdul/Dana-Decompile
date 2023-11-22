package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class GhostViewPlatform implements GhostView {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static Method MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static Class<?> getAuthRequestContext;
    private static boolean getErrorConfigVersion;
    private final View lookAheadTest;

    @Override // androidx.transition.GhostView
    public final void BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, View view) {
    }

    private GhostViewPlatform(View view) {
        this.lookAheadTest = view;
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i) {
        this.lookAheadTest.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostView PlaceComponentResult(View view, ViewGroup viewGroup, Matrix matrix) {
        if (!PlaceComponentResult) {
            try {
                if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                    try {
                        getAuthRequestContext = Class.forName("android.view.GhostView");
                    } catch (ClassNotFoundException e) {
                        InstrumentInjector.log_i("GhostViewApi21", "Failed to retrieve GhostView class", e);
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                Method declaredMethod = getAuthRequestContext.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                MyBillsEntityDataFactory = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
            }
            PlaceComponentResult = true;
        }
        Method method = MyBillsEntityDataFactory;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(View view) {
        if (!getErrorConfigVersion) {
            try {
                if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                    try {
                        getAuthRequestContext = Class.forName("android.view.GhostView");
                    } catch (ClassNotFoundException e) {
                        InstrumentInjector.log_i("GhostViewApi21", "Failed to retrieve GhostView class", e);
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                Method declaredMethod = getAuthRequestContext.getDeclaredMethod("removeGhost", View.class);
                BuiltInFictitiousFunctionClassFactory = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
            }
            getErrorConfigVersion = true;
        }
        Method method = BuiltInFictitiousFunctionClassFactory;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
