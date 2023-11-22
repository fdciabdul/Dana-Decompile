package fsimpl;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: fsimpl.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0329e extends ViewGroup {
    public static int a(View view) {
        return view.computeHorizontalScrollRange();
    }

    public static void a(View view, Canvas canvas) {
        view.onDraw(canvas);
    }

    public static void a(ViewGroup viewGroup, Canvas canvas, View view, long j) {
        viewGroup.drawChild(canvas, view, j);
    }

    public static int b(View view) {
        return view.computeVerticalScrollRange();
    }

    public static void b(View view, Canvas canvas) {
        view.dispatchDraw(canvas);
    }

    public static int c(View view) {
        return view.computeHorizontalScrollOffset();
    }

    public static int d(View view) {
        return view.computeVerticalScrollOffset();
    }

    public static int e(View view) {
        return view.computeHorizontalScrollExtent();
    }

    public static int f(View view) {
        return view.computeVerticalScrollExtent();
    }
}
