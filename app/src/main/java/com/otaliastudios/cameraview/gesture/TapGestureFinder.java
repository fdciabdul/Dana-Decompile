package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.otaliastudios.cameraview.gesture.GestureFinder;

/* loaded from: classes2.dex */
public class TapGestureFinder extends GestureFinder {
    private boolean MyBillsEntityDataFactory;
    private GestureDetector PlaceComponentResult;

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public final float PlaceComponentResult(float f, float f2, float f3) {
        return 0.0f;
    }

    static /* synthetic */ boolean getAuthRequestContext(TapGestureFinder tapGestureFinder) {
        tapGestureFinder.MyBillsEntityDataFactory = true;
        return true;
    }

    public TapGestureFinder(GestureFinder.Controller controller) {
        super(controller, 1);
        GestureDetector gestureDetector = new GestureDetector(controller.MyBillsEntityDataFactory(), new GestureDetector.SimpleOnGestureListener() { // from class: com.otaliastudios.cameraview.gesture.TapGestureFinder.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                TapGestureFinder.getAuthRequestContext(TapGestureFinder.this);
                TapGestureFinder.this.getAuthRequestContext = Gesture.TAP;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                TapGestureFinder.getAuthRequestContext(TapGestureFinder.this);
                TapGestureFinder.this.getAuthRequestContext = Gesture.LONG_TAP;
            }
        });
        this.PlaceComponentResult = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    protected final boolean getAuthRequestContext(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.MyBillsEntityDataFactory = false;
        }
        this.PlaceComponentResult.onTouchEvent(motionEvent);
        if (this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[0].x = motionEvent.getX();
            this.KClassImpl$Data$declaredNonStaticMembers$2[0].y = motionEvent.getY();
            return true;
        }
        return false;
    }
}
