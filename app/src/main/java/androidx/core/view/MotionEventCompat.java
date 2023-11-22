package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class MotionEventCompat {
    @Deprecated
    public static int PlaceComponentResult(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int MyBillsEntityDataFactory(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float PlaceComponentResult(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    @Deprecated
    public static float getAuthRequestContext(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    private MotionEventCompat() {
    }
}
