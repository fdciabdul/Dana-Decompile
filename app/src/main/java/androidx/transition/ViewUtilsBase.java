package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewUtilsBase {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static boolean MyBillsEntityDataFactory;
    private static Field PlaceComponentResult;
    private static boolean getAuthRequestContext;
    private float[] KClassImpl$Data$declaredNonStaticMembers$2;

    public void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f) {
        Float f2 = (Float) view.getTag(R.id.getAuthRequestContext);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float getAuthRequestContext(View view) {
        Float f = (Float) view.getTag(R.id.getAuthRequestContext);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (view.getTag(R.id.getAuthRequestContext) == null) {
            view.setTag(R.id.getAuthRequestContext, Float.valueOf(view.getAlpha()));
        }
    }

    public void BuiltInFictitiousFunctionClassFactory(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.getAuthRequestContext, null);
        }
    }

    public void getAuthRequestContext(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            getAuthRequestContext((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            KClassImpl$Data$declaredNonStaticMembers$2((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void PlaceComponentResult(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fArr == null) {
            fArr = new float[9];
            this.KClassImpl$Data$declaredNonStaticMembers$2 = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float sqrt = ((float) Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f, sqrt));
        float f2 = fArr[0] / sqrt;
        float f3 = fArr[4] / sqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    public void BuiltInFictitiousFunctionClassFactory(View view, int i, int i2, int i3, int i4) {
        MyBillsEntityDataFactory();
        Method method = BuiltInFictitiousFunctionClassFactory;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void MyBillsEntityDataFactory(View view, int i) {
        if (!getAuthRequestContext) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                PlaceComponentResult = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                InstrumentInjector.log_i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            getAuthRequestContext = true;
        }
        Field field = PlaceComponentResult;
        if (field != null) {
            try {
                PlaceComponentResult.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        if (MyBillsEntityDataFactory) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            BuiltInFictitiousFunctionClassFactory = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            InstrumentInjector.log_i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
        }
        MyBillsEntityDataFactory = true;
    }
}
