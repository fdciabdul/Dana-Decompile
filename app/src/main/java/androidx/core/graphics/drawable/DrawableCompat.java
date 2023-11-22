package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class DrawableCompat {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;

    @Deprecated
    public static void moveToNextValue(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void BuiltInFictitiousFunctionClassFactory(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.getAuthRequestContext(drawable, z);
        }
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.MyBillsEntityDataFactory(drawable);
        }
        return false;
    }

    public static void getAuthRequestContext(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(drawable, f, f2);
        }
    }

    public static void getAuthRequestContext(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(drawable, i, i2, i3, i4);
        }
    }

    public static void MyBillsEntityDataFactory(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTint(i);
                return;
            }
            return;
        }
        drawable.setTint(i);
    }

    public static void PlaceComponentResult(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(drawable, colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(drawable, mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    public static int getAuthRequestContext(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getAuthRequestContext(drawable);
        }
        return 0;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean MyBillsEntityDataFactory(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.MyBillsEntityDataFactory(drawable);
        }
        return false;
    }

    public static ColorFilter BuiltInFictitiousFunctionClassFactory(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(drawable);
        }
        return null;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        while (Build.VERSION.SDK_INT < 23 && Build.VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                drawable = Api19Impl.BuiltInFictitiousFunctionClassFactory((InsetDrawable) drawable);
            } else if (drawable instanceof WrappedDrawable) {
                drawable = ((WrappedDrawable) drawable).PlaceComponentResult();
            } else if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                return;
            } else {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    Drawable PlaceComponentResult2 = Api19Impl.PlaceComponentResult(drawableContainerState, i);
                    if (PlaceComponentResult2 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2);
                    }
                }
                return;
            }
        }
        drawable.clearColorFilter();
    }

    public static void PlaceComponentResult(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(drawable, resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static Drawable scheduleImpl(Drawable drawable) {
        return Build.VERSION.SDK_INT >= 23 ? drawable : Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T getErrorConfigVersion(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).PlaceComponentResult() : drawable;
    }

    public static boolean getAuthRequestContext(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.MyBillsEntityDataFactory(drawable, i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!PlaceComponentResult) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    BuiltInFictitiousFunctionClassFactory = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    InstrumentInjector.log_i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                PlaceComponentResult = true;
            }
            Method method = BuiltInFictitiousFunctionClassFactory;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    InstrumentInjector.log_i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    BuiltInFictitiousFunctionClassFactory = null;
                }
            }
        }
        return false;
    }

    public static int PlaceComponentResult(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getAuthRequestContext(drawable);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!MyBillsEntityDataFactory) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    KClassImpl$Data$declaredNonStaticMembers$2 = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    InstrumentInjector.log_i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                MyBillsEntityDataFactory = true;
            }
            Method method = KClassImpl$Data$declaredNonStaticMembers$2;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    InstrumentInjector.log_i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
            }
        }
        return 0;
    }

    private DrawableCompat() {
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static void getAuthRequestContext(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        static boolean MyBillsEntityDataFactory(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static int getAuthRequestContext(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable PlaceComponentResult(DrawableContainer.DrawableContainerState drawableContainerState, int i) {
            return drawableContainerState.getChild(i);
        }

        static Drawable BuiltInFictitiousFunctionClassFactory(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void MyBillsEntityDataFactory(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        static void getAuthRequestContext(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void getAuthRequestContext(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        static boolean MyBillsEntityDataFactory(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter PlaceComponentResult(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void getAuthRequestContext(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void MyBillsEntityDataFactory(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static boolean MyBillsEntityDataFactory(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        static int getAuthRequestContext(Drawable drawable) {
            return drawable.getLayoutDirection();
        }
    }
}
