package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.gesture.GestureFinder;

/* loaded from: classes2.dex */
public class ScrollGestureFinder extends GestureFinder {
    private static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("ScrollGestureFinder");
    private GestureDetector MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean scheduleImpl;

    static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(ScrollGestureFinder scrollGestureFinder) {
        scrollGestureFinder.scheduleImpl = true;
        return true;
    }

    public ScrollGestureFinder(final GestureFinder.Controller controller) {
        super(controller, 2);
        GestureDetector gestureDetector = new GestureDetector(controller.MyBillsEntityDataFactory(), new GestureDetector.SimpleOnGestureListener() { // from class: com.otaliastudios.cameraview.gesture.ScrollGestureFinder.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                CameraLogger cameraLogger = ScrollGestureFinder.PlaceComponentResult;
                boolean z = false;
                StringBuilder sb = new StringBuilder();
                sb.append("distanceX=");
                sb.append(f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("distanceY=");
                sb2.append(f2);
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onScroll:", sb.toString(), sb2.toString());
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getX() != ScrollGestureFinder.this.KClassImpl$Data$declaredNonStaticMembers$2[0].x || motionEvent.getY() != ScrollGestureFinder.this.KClassImpl$Data$declaredNonStaticMembers$2[0].y) {
                    boolean z2 = Math.abs(f) >= Math.abs(f2);
                    ScrollGestureFinder.this.getAuthRequestContext = z2 ? Gesture.SCROLL_HORIZONTAL : Gesture.SCROLL_VERTICAL;
                    ScrollGestureFinder.this.KClassImpl$Data$declaredNonStaticMembers$2[0].set(motionEvent.getX(), motionEvent.getY());
                    z = z2;
                } else if (ScrollGestureFinder.this.getAuthRequestContext == Gesture.SCROLL_HORIZONTAL) {
                    z = true;
                }
                ScrollGestureFinder.this.KClassImpl$Data$declaredNonStaticMembers$2[1].set(motionEvent2.getX(), motionEvent2.getY());
                ScrollGestureFinder scrollGestureFinder = ScrollGestureFinder.this;
                GestureFinder.Controller controller2 = controller;
                scrollGestureFinder.NetworkUserEntityData$$ExternalSyntheticLambda0 = z ? f / controller2.getErrorConfigVersion() : f2 / controller2.getAuthRequestContext();
                ScrollGestureFinder scrollGestureFinder2 = ScrollGestureFinder.this;
                float f3 = scrollGestureFinder2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (z) {
                    f3 = -f3;
                }
                scrollGestureFinder2.NetworkUserEntityData$$ExternalSyntheticLambda0 = f3;
                ScrollGestureFinder.BuiltInFictitiousFunctionClassFactory(ScrollGestureFinder.this);
                return true;
            }
        });
        this.MyBillsEntityDataFactory = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    protected final boolean getAuthRequestContext(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.scheduleImpl = false;
        }
        this.MyBillsEntityDataFactory.onTouchEvent(motionEvent);
        if (this.scheduleImpl) {
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "Notifying a gesture of type", this.getAuthRequestContext.name());
        }
        return this.scheduleImpl;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public final float PlaceComponentResult(float f, float f2, float f3) {
        return f + (this.NetworkUserEntityData$$ExternalSyntheticLambda0 * (f3 - f2) * 2.0f);
    }
}
