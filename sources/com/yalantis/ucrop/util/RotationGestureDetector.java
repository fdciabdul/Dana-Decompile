package com.yalantis.ucrop.util;

import android.view.MotionEvent;

/* loaded from: classes8.dex */
public class RotationGestureDetector {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private OnRotationGestureListener MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float PlaceComponentResult;
    private float getAuthRequestContext;
    private float moveToNextValue;
    private int lookAheadTest = -1;
    private int getErrorConfigVersion = -1;

    /* loaded from: classes8.dex */
    public interface OnRotationGestureListener {
        boolean PlaceComponentResult(RotationGestureDetector rotationGestureDetector);
    }

    /* loaded from: classes8.dex */
    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean PlaceComponentResult(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.MyBillsEntityDataFactory = onRotationGestureListener;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionEvent.getX();
            this.moveToNextValue = motionEvent.getY();
            this.lookAheadTest = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.PlaceComponentResult = 0.0f;
            this.BuiltInFictitiousFunctionClassFactory = true;
        } else if (actionMasked == 1) {
            this.lookAheadTest = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.getAuthRequestContext = motionEvent.getX();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = motionEvent.getY();
                this.getErrorConfigVersion = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.PlaceComponentResult = 0.0f;
                this.BuiltInFictitiousFunctionClassFactory = true;
            } else if (actionMasked == 6) {
                this.getErrorConfigVersion = -1;
            }
        } else if (this.lookAheadTest != -1 && this.getErrorConfigVersion != -1 && motionEvent.getPointerCount() > this.getErrorConfigVersion) {
            float x = motionEvent.getX(this.lookAheadTest);
            float y = motionEvent.getY(this.lookAheadTest);
            float x2 = motionEvent.getX(this.getErrorConfigVersion);
            float y2 = motionEvent.getY(this.getErrorConfigVersion);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.PlaceComponentResult = 0.0f;
                this.BuiltInFictitiousFunctionClassFactory = false;
            } else {
                float f = this.getAuthRequestContext;
                float degrees = (((float) Math.toDegrees((float) Math.atan2(y2 - y, x2 - x))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(this.KClassImpl$Data$declaredNonStaticMembers$2 - this.moveToNextValue, f - this.NetworkUserEntityData$$ExternalSyntheticLambda0))) % 360.0f);
                this.PlaceComponentResult = degrees;
                if (degrees < -180.0f) {
                    this.PlaceComponentResult = degrees + 360.0f;
                } else if (degrees > 180.0f) {
                    this.PlaceComponentResult = degrees - 360.0f;
                }
            }
            OnRotationGestureListener onRotationGestureListener = this.MyBillsEntityDataFactory;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.PlaceComponentResult(this);
            }
            this.getAuthRequestContext = x2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = y2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = x;
            this.moveToNextValue = y;
        }
        return true;
    }
}
