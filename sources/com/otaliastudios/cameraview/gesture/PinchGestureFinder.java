package com.otaliastudios.cameraview.gesture;

import android.os.Build;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.otaliastudios.cameraview.gesture.GestureFinder;

/* loaded from: classes2.dex */
public class PinchGestureFinder extends GestureFinder {
    private ScaleGestureDetector MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private boolean moveToNextValue;

    static /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(PinchGestureFinder pinchGestureFinder) {
        pinchGestureFinder.moveToNextValue = true;
        return true;
    }

    public PinchGestureFinder(GestureFinder.Controller controller) {
        super(controller, 2);
        this.PlaceComponentResult = 0.0f;
        this.getAuthRequestContext = Gesture.PINCH;
        this.MyBillsEntityDataFactory = new ScaleGestureDetector(controller.MyBillsEntityDataFactory(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.otaliastudios.cameraview.gesture.PinchGestureFinder.1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                PinchGestureFinder.KClassImpl$Data$declaredNonStaticMembers$2(PinchGestureFinder.this);
                PinchGestureFinder.this.PlaceComponentResult = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setQuickScaleEnabled(false);
        }
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    protected final boolean getAuthRequestContext(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.moveToNextValue = false;
        }
        this.MyBillsEntityDataFactory.onTouchEvent(motionEvent);
        if (this.moveToNextValue) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[0].x = motionEvent.getX(0);
            this.KClassImpl$Data$declaredNonStaticMembers$2[0].y = motionEvent.getY(0);
            if (motionEvent.getPointerCount() > 1) {
                this.KClassImpl$Data$declaredNonStaticMembers$2[1].x = motionEvent.getX(1);
                this.KClassImpl$Data$declaredNonStaticMembers$2[1].y = motionEvent.getY(1);
            }
            return true;
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public final float PlaceComponentResult(float f, float f2, float f3) {
        return f + (this.PlaceComponentResult * (f3 - f2));
    }
}
