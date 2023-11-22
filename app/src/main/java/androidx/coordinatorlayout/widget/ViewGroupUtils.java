package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes3.dex */
public class ViewGroupUtils {
    private static final ThreadLocal<Matrix> BuiltInFictitiousFunctionClassFactory = new ThreadLocal<>();
    private static final ThreadLocal<RectF> KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadLocal<>();

    public static void PlaceComponentResult(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal = BuiltInFictitiousFunctionClassFactory;
        Matrix matrix = threadLocal.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal.set(matrix);
        } else {
            matrix.reset();
        }
        BuiltInFictitiousFunctionClassFactory(viewGroup, view, matrix);
        ThreadLocal<RectF> threadLocal2 = KClassImpl$Data$declaredNonStaticMembers$2;
        RectF rectF = threadLocal2.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal2.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static void BuiltInFictitiousFunctionClassFactory(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            BuiltInFictitiousFunctionClassFactory(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }

    private ViewGroupUtils() {
    }
}
