package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class ThemeUtils {
    private static final ThreadLocal<TypedValue> scheduleImpl = new ThreadLocal<>();
    static final int[] BuiltInFictitiousFunctionClassFactory = {-16842910};
    static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16842908};
    static final int[] PlaceComponentResult = {16843518};
    static final int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {16842919};
    static final int[] MyBillsEntityDataFactory = {16842912};
    static final int[] moveToNextValue = {16842913};
    static final int[] getErrorConfigVersion = {-16842919, -16842908};
    static final int[] getAuthRequestContext = new int[0];
    private static final int[] lookAheadTest = new int[1];

    public static int getAuthRequestContext(Context context, int i) {
        int[] iArr = lookAheadTest;
        iArr[0] = i;
        TintTypedArray MyBillsEntityDataFactory2 = TintTypedArray.MyBillsEntityDataFactory(context, null, iArr);
        try {
            return MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getColor(0, 0);
        } finally {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.recycle();
        }
    }

    public static ColorStateList BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        int[] iArr = lookAheadTest;
        iArr[0] = i;
        TintTypedArray MyBillsEntityDataFactory2 = TintTypedArray.MyBillsEntityDataFactory(context, null, iArr);
        try {
            return MyBillsEntityDataFactory2.PlaceComponentResult(0);
        } finally {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.recycle();
        }
    }

    public static int MyBillsEntityDataFactory(Context context, int i) {
        ColorStateList BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, i);
        if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory2.isStateful()) {
            return BuiltInFictitiousFunctionClassFactory2.getColorForState(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = scheduleImpl;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        return ColorUtils.MyBillsEntityDataFactory(getAuthRequestContext(context, i), Math.round(Color.alpha(r4) * f));
    }

    public static void getAuthRequestContext(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.g);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.i)) {
                StringBuilder sb = new StringBuilder();
                sb.append("View ");
                sb.append(view.getClass());
                sb.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
                InstrumentInjector.log_e("ThemeUtils", sb.toString());
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private ThemeUtils() {
    }
}
