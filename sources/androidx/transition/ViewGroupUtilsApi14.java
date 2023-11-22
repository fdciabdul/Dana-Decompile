package androidx.transition;

import android.animation.LayoutTransition;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class ViewGroupUtilsApi14 {
    private static LayoutTransition BuiltInFictitiousFunctionClassFactory;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static Method PlaceComponentResult;
    private static Field getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void BuiltInFictitiousFunctionClassFactory(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L28
            androidx.transition.ViewGroupUtilsApi14$1 r0 = new androidx.transition.ViewGroupUtilsApi14$1
            r0.<init>()
            androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r4 = 4
            r0.setAnimator(r4, r3)
        L28:
            if (r6 == 0) goto L48
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L42
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L39
            KClassImpl$Data$declaredNonStaticMembers$2(r6)
        L39:
            android.animation.LayoutTransition r0 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            if (r6 == r0) goto L42
            int r0 = androidx.transition.R.id.NetworkUserEntityData$$ExternalSyntheticLambda0
            r5.setTag(r0, r6)
        L42:
            android.animation.LayoutTransition r6 = androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory
            r5.setLayoutTransition(r6)
            return
        L48:
            r5.setLayoutTransition(r3)
            boolean r6 = androidx.transition.ViewGroupUtilsApi14.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L66
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L5f
            androidx.transition.ViewGroupUtilsApi14.getAuthRequestContext = r6     // Catch: java.lang.NoSuchFieldException -> L5f
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L5f
            goto L64
        L5f:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            com.fullstory.instrumentation.InstrumentInjector.log_i(r0, r6)
        L64:
            androidx.transition.ViewGroupUtilsApi14.KClassImpl$Data$declaredNonStaticMembers$2 = r1
        L66:
            java.lang.reflect.Field r6 = androidx.transition.ViewGroupUtilsApi14.getAuthRequestContext
            if (r6 == 0) goto L7f
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7a
            if (r6 == 0) goto L78
            java.lang.reflect.Field r1 = androidx.transition.ViewGroupUtilsApi14.getAuthRequestContext     // Catch: java.lang.IllegalAccessException -> L76
            r1.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L76
            goto L78
        L76:
            r2 = r6
            goto L7a
        L78:
            r2 = r6
            goto L7f
        L7a:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            com.fullstory.instrumentation.InstrumentInjector.log_i(r0, r6)
        L7f:
            if (r2 == 0) goto L84
            r5.requestLayout()
        L84:
            int r6 = androidx.transition.R.id.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L96
            int r0 = androidx.transition.R.id.NetworkUserEntityData$$ExternalSyntheticLambda0
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ViewGroupUtilsApi14.BuiltInFictitiousFunctionClassFactory(android.view.ViewGroup, boolean):void");
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(LayoutTransition layoutTransition) {
        if (!MyBillsEntityDataFactory) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                PlaceComponentResult = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                InstrumentInjector.log_i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            MyBillsEntityDataFactory = true;
        }
        Method method = PlaceComponentResult;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                InstrumentInjector.log_i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                InstrumentInjector.log_i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    private ViewGroupUtilsApi14() {
    }
}
