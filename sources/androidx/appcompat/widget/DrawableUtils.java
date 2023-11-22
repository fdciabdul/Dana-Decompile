package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16842912};
    private static final int[] MyBillsEntityDataFactory = new int[0];
    public static final Rect BuiltInFictitiousFunctionClassFactory = new Rect();

    private DrawableUtils() {
    }

    public static Rect PlaceComponentResult(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets PlaceComponentResult = Api29Impl.PlaceComponentResult(drawable);
            return new Rect(PlaceComponentResult.left, PlaceComponentResult.top, PlaceComponentResult.right, PlaceComponentResult.bottom);
        } else if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.KClassImpl$Data$declaredNonStaticMembers$2(DrawableCompat.getErrorConfigVersion(drawable));
        } else {
            return BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        String name = drawable.getClass().getName();
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            MyBillsEntityDataFactory(drawable);
        } else if (Build.VERSION.SDK_INT < 29 || Build.VERSION.SDK_INT >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
        } else {
            MyBillsEntityDataFactory(drawable);
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Drawable drawable) {
        while (Build.VERSION.SDK_INT < 17) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
                if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                    if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                        if (drawable instanceof DrawableContainer) {
                            Drawable.ConstantState constantState = drawable.getConstantState();
                            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                                    if (!BuiltInFictitiousFunctionClassFactory(drawable2)) {
                                        return false;
                                    }
                                }
                            }
                        } else if (drawable instanceof WrappedDrawable) {
                            drawable = ((WrappedDrawable) drawable).PlaceComponentResult();
                        } else if (drawable instanceof DrawableWrapper) {
                            drawable = ((DrawableWrapper) drawable).getWrappedDrawable();
                        } else if (drawable instanceof ScaleDrawable) {
                            drawable = ((ScaleDrawable) drawable).getDrawable();
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private static void MyBillsEntityDataFactory(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            drawable.setState(MyBillsEntityDataFactory);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode MyBillsEntityDataFactory(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i == 9) {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                switch (i) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return mode;
                }
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        private static final Field BuiltInFictitiousFunctionClassFactory;
        private static final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private static final Field MyBillsEntityDataFactory;
        private static final Field PlaceComponentResult;
        private static final Method getAuthRequestContext;
        private static final Field moveToNextValue;

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L2f
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L2f
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L2f
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.Throwable -> L30
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.Throwable -> L31
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2d
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L33
                r8 = 1
                goto L35
            L2d:
                r7 = r2
                goto L33
            L2f:
                r4 = r2
            L30:
                r5 = r2
            L31:
                r6 = r2
                r7 = r6
            L33:
                r3 = r2
                r8 = 0
            L35:
                if (r8 == 0) goto L44
                androidx.appcompat.widget.DrawableUtils.Api18Impl.getAuthRequestContext = r4
                androidx.appcompat.widget.DrawableUtils.Api18Impl.PlaceComponentResult = r5
                androidx.appcompat.widget.DrawableUtils.Api18Impl.moveToNextValue = r6
                androidx.appcompat.widget.DrawableUtils.Api18Impl.MyBillsEntityDataFactory = r7
                androidx.appcompat.widget.DrawableUtils.Api18Impl.BuiltInFictitiousFunctionClassFactory = r3
                androidx.appcompat.widget.DrawableUtils.Api18Impl.KClassImpl$Data$declaredNonStaticMembers$2 = r0
                return
            L44:
                androidx.appcompat.widget.DrawableUtils.Api18Impl.getAuthRequestContext = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.PlaceComponentResult = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.moveToNextValue = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.MyBillsEntityDataFactory = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.BuiltInFictitiousFunctionClassFactory = r2
                androidx.appcompat.widget.DrawableUtils.Api18Impl.KClassImpl$Data$declaredNonStaticMembers$2 = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }

        private Api18Impl() {
        }

        static Rect KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && KClassImpl$Data$declaredNonStaticMembers$2) {
                try {
                    Object invoke = getAuthRequestContext.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(PlaceComponentResult.getInt(invoke), moveToNextValue.getInt(invoke), MyBillsEntityDataFactory.getInt(invoke), BuiltInFictitiousFunctionClassFactory.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets PlaceComponentResult(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }
}
