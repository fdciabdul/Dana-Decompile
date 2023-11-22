package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\tJ\u0019\u0010\b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\n\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\n\u0010\u0012J\u0017\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000b\u0010\u0014J\u001f\u0010\n\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "Landroid/app/Activity;", "p0", "Landroidx/window/layout/WindowMetrics;", "getAuthRequestContext", "(Landroid/app/Activity;)Landroidx/window/layout/WindowMetrics;", "Landroid/graphics/Rect;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;)Landroid/graphics/Rect;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "Landroid/view/Display;", "Landroid/view/DisplayCutout;", "(Landroid/view/Display;)Landroid/view/DisplayCutout;", "Landroid/content/Context;", "", "(Landroid/content/Context;)I", "Landroid/graphics/Point;", "(Landroid/view/Display;)Landroid/graphics/Point;", "p1", "", "(Landroid/app/Activity;Landroid/graphics/Rect;)V", "", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final String getAuthRequestContext;

    private WindowMetricsCalculatorCompat() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("WindowMetricsCalculatorCompat", "");
        getAuthRequestContext = "WindowMetricsCalculatorCompat";
    }

    public final WindowMetrics getAuthRequestContext(Activity p0) {
        Rect KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        if (Build.VERSION.SDK_INT >= 30) {
            KClassImpl$Data$declaredNonStaticMembers$2 = ActivityCompatHelperApi30.INSTANCE.PlaceComponentResult(p0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(p0);
        } else if (Build.VERSION.SDK_INT >= 28) {
            KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult(p0);
        } else if (Build.VERSION.SDK_INT >= 24) {
            KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(p0);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
        return new WindowMetrics(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final Rect MyBillsEntityDataFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Configuration configuration = p0.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e) {
            InstrumentInjector.log_w(getAuthRequestContext, e);
            return PlaceComponentResult(p0);
        } catch (NoSuchFieldException e2) {
            InstrumentInjector.log_w(getAuthRequestContext, e2);
            return PlaceComponentResult(p0);
        } catch (NoSuchMethodException e3) {
            InstrumentInjector.log_w(getAuthRequestContext, e3);
            return PlaceComponentResult(p0);
        } catch (InvocationTargetException e4) {
            InstrumentInjector.log_w(getAuthRequestContext, e4);
            return PlaceComponentResult(p0);
        }
    }

    public final Rect PlaceComponentResult(Activity p0) {
        DisplayCutout KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        Rect rect = new Rect();
        Configuration configuration = p0.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                if (invoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException e) {
            InstrumentInjector.log_w(getAuthRequestContext, e);
            BuiltInFictitiousFunctionClassFactory(p0, rect);
        } catch (NoSuchFieldException e2) {
            InstrumentInjector.log_w(getAuthRequestContext, e2);
            BuiltInFictitiousFunctionClassFactory(p0, rect);
        } catch (NoSuchMethodException e3) {
            InstrumentInjector.log_w(getAuthRequestContext, e3);
            BuiltInFictitiousFunctionClassFactory(p0, rect);
        } catch (InvocationTargetException e4) {
            InstrumentInjector.log_w(getAuthRequestContext, e4);
            BuiltInFictitiousFunctionClassFactory(p0, rect);
        }
        Display defaultDisplay = p0.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "");
        displayCompatHelperApi17.KClassImpl$Data$declaredNonStaticMembers$2(defaultDisplay, point);
        if (!ActivityCompatHelperApi24.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((Context) p0);
            if (rect.bottom + BuiltInFictitiousFunctionClassFactory == point.y) {
                rect.bottom += BuiltInFictitiousFunctionClassFactory;
            } else if (rect.right + BuiltInFictitiousFunctionClassFactory == point.x) {
                rect.right += BuiltInFictitiousFunctionClassFactory;
            } else if (rect.left == BuiltInFictitiousFunctionClassFactory) {
                rect.left = 0;
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !ActivityCompatHelperApi24.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(p0) && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(defaultDisplay)) != null) {
            if (rect.left == DisplayCompatHelperApi28.INSTANCE.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2)) {
                rect.left = 0;
            }
            if (point.x - rect.right == DisplayCompatHelperApi28.INSTANCE.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2)) {
                rect.right += DisplayCompatHelperApi28.INSTANCE.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (rect.top == DisplayCompatHelperApi28.INSTANCE.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == DisplayCompatHelperApi28.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2)) {
                rect.bottom += DisplayCompatHelperApi28.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        return rect;
    }

    private final void BuiltInFictitiousFunctionClassFactory(Activity p0, Rect p1) {
        p0.getWindowManager().getDefaultDisplay().getRectSize(p1);
    }

    public final Rect BuiltInFictitiousFunctionClassFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Rect rect = new Rect();
        Display defaultDisplay = p0.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "");
            Point PlaceComponentResult = PlaceComponentResult(defaultDisplay);
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((Context) p0);
            if (rect.bottom + BuiltInFictitiousFunctionClassFactory == PlaceComponentResult.y) {
                rect.bottom += BuiltInFictitiousFunctionClassFactory;
            } else if (rect.right + BuiltInFictitiousFunctionClassFactory == PlaceComponentResult.x) {
                rect.right += BuiltInFictitiousFunctionClassFactory;
            }
        }
        return rect;
    }

    public final Rect KClassImpl$Data$declaredNonStaticMembers$2(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Display defaultDisplay = p0.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "");
        Point PlaceComponentResult = PlaceComponentResult(defaultDisplay);
        Rect rect = new Rect();
        if (PlaceComponentResult.x == 0 || PlaceComponentResult.y == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = PlaceComponentResult.x;
            rect.bottom = PlaceComponentResult.y;
        }
        return rect;
    }

    public final Point PlaceComponentResult(Display p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayCompatHelperApi17.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(p0, point);
        } else {
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", Point.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(p0, point);
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_w(getAuthRequestContext, e);
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_w(getAuthRequestContext, e2);
            } catch (InvocationTargetException e3) {
                InstrumentInjector.log_w(getAuthRequestContext, e3);
            }
        }
        return point;
    }

    private final int BuiltInFictitiousFunctionClassFactory(Context p0) {
        Resources resources = p0.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final DisplayCutout KClassImpl$Data$declaredNonStaticMembers$2(Display p0) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = p0.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(p0, newInstance);
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException e) {
            InstrumentInjector.log_w(getAuthRequestContext, e);
        } catch (IllegalAccessException e2) {
            InstrumentInjector.log_w(getAuthRequestContext, e2);
        } catch (InstantiationException e3) {
            InstrumentInjector.log_w(getAuthRequestContext, e3);
        } catch (NoSuchFieldException e4) {
            InstrumentInjector.log_w(getAuthRequestContext, e4);
        } catch (NoSuchMethodException e5) {
            InstrumentInjector.log_w(getAuthRequestContext, e5);
        } catch (InvocationTargetException e6) {
            InstrumentInjector.log_w(getAuthRequestContext, e6);
        }
        return null;
    }
}
