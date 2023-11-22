package id.dana.base;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/base/GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "p0", "", "onDown", "(Landroid/view/MotionEvent;)Z", "p1", "", "p2", "p3", "onScroll", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z", "Landroid/view/View;", "PlaceComponentResult", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final View BuiltInFictitiousFunctionClassFactory;

    public GestureListener(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent p0, MotionEvent p1, float p2, float p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (Math.abs(p2) < Math.abs(p3)) {
            this.BuiltInFictitiousFunctionClassFactory.getParent().requestDisallowInterceptTouchEvent(false);
        } else if (Math.abs(p2) > 0.0f) {
            this.BuiltInFictitiousFunctionClassFactory.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onScroll(p0, p1, p2, p3);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.getParent().requestDisallowInterceptTouchEvent(true);
        return super.onDown(p0);
    }
}
