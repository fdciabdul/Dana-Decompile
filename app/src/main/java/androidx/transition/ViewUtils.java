package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewUtils {
    private static final ViewUtilsBase BuiltInFictitiousFunctionClassFactory;
    static final Property<View, Float> KClassImpl$Data$declaredNonStaticMembers$2;
    static final Property<View, Rect> MyBillsEntityDataFactory;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsApi29();
        } else if (Build.VERSION.SDK_INT >= 23) {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsApi23();
        } else if (Build.VERSION.SDK_INT >= 22) {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsApi19();
        } else {
            BuiltInFictitiousFunctionClassFactory = new ViewUtilsBase();
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            public /* synthetic */ Float get(View view) {
                return Float.valueOf(ViewUtils.PlaceComponentResult(view));
            }

            @Override // android.util.Property
            public /* synthetic */ void set(View view, Float f) {
                ViewUtils.MyBillsEntityDataFactory(view, f.floatValue());
            }
        };
        MyBillsEntityDataFactory = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            public /* synthetic */ Rect get(View view) {
                return ViewCompat.scheduleImpl(view);
            }

            @Override // android.util.Property
            public /* synthetic */ void set(View view, Rect rect) {
                ViewCompat.PlaceComponentResult(view, rect);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayImpl getAuthRequestContext(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.BuiltInFictitiousFunctionClassFactory(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowIdImpl BuiltInFictitiousFunctionClassFactory(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new WindowIdApi18(view);
        }
        return new WindowIdApi14(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(View view, float f) {
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float PlaceComponentResult(View view) {
        return BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(View view) {
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(View view, int i) {
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(view, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(View view, Matrix matrix) {
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(View view, Matrix matrix) {
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(View view, int i, int i2, int i3, int i4) {
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(view, i, i2, i3, i4);
    }

    private ViewUtils() {
    }
}
