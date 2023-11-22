package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static Method getAuthRequestContext;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                getAuthRequestContext = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                InstrumentInjector.log_i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    @Deprecated
    public static int getAuthRequestContext(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float KClassImpl$Data$declaredNonStaticMembers$2(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.PlaceComponentResult(viewConfiguration);
        }
        return MyBillsEntityDataFactory(viewConfiguration, context);
    }

    public static float getAuthRequestContext(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.BuiltInFictitiousFunctionClassFactory(viewConfiguration);
        }
        return MyBillsEntityDataFactory(viewConfiguration, context);
    }

    private static float MyBillsEntityDataFactory(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = getAuthRequestContext) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                InstrumentInjector.log_i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int MyBillsEntityDataFactory(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.BuiltInFictitiousFunctionClassFactory(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static boolean PlaceComponentResult(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
            return identifier != 0 && resources.getBoolean(identifier);
        }
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }

    private ViewConfigurationCompat() {
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static float PlaceComponentResult(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float BuiltInFictitiousFunctionClassFactory(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static int BuiltInFictitiousFunctionClassFactory(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }
    }
}
