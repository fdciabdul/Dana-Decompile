package com.otaliastudios.cameraview.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes2.dex */
public abstract class GestureFinder {
    public boolean BuiltInFictitiousFunctionClassFactory;
    public PointF[] KClassImpl$Data$declaredNonStaticMembers$2;
    private Controller MyBillsEntityDataFactory;
    public Gesture getAuthRequestContext;

    /* loaded from: classes8.dex */
    public interface Controller {
        Context MyBillsEntityDataFactory();

        int getAuthRequestContext();

        int getErrorConfigVersion();
    }

    protected abstract float PlaceComponentResult(float f, float f2, float f3);

    protected abstract boolean getAuthRequestContext(MotionEvent motionEvent);

    /* JADX INFO: Access modifiers changed from: package-private */
    public GestureFinder(Controller controller, int i) {
        this.MyBillsEntityDataFactory = controller;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[i2] = new PointF(0.0f, 0.0f);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return getAuthRequestContext(motionEvent);
        }
        return false;
    }

    public final float KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        float PlaceComponentResult = PlaceComponentResult(f, f2, f3);
        if (PlaceComponentResult < f2) {
            PlaceComponentResult = f2;
        }
        if (PlaceComponentResult > f3) {
            PlaceComponentResult = f3;
        }
        float f4 = ((f3 - f2) / 50.0f) / 2.0f;
        return (PlaceComponentResult < f - f4 || PlaceComponentResult > f4 + f) ? PlaceComponentResult : f;
    }
}
