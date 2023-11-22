package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

/* loaded from: classes8.dex */
public class GestureCropImageView extends CropImageView {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private ScaleGestureDetector NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private GestureDetector getAuthRequestContext;
    private float getErrorConfigVersion;
    private RotationGestureDetector lookAheadTest;

    public GestureCropImageView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = 5;
    }

    public void setScaleEnabled(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    public boolean isScaleEnabled() {
        return this.MyBillsEntityDataFactory;
    }

    public void setRotateEnabled(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public boolean isRotateEnabled() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.PlaceComponentResult = i;
    }

    public int getDoubleTapScaleSteps() {
        return this.PlaceComponentResult;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.getErrorConfigVersion = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.getAuthRequestContext.onTouchEvent(motionEvent);
        if (this.MyBillsEntityDataFactory) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onTouchEvent(motionEvent);
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void init() {
        super.init();
        byte b = 0;
        this.getAuthRequestContext = new GestureDetector(getContext(), new GestureListener(this, b), null, true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ScaleGestureDetector(getContext(), new ScaleListener(this, b));
        this.lookAheadTest = new RotationGestureDetector(new RotateListener(this, b));
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.PlaceComponentResult));
    }

    /* loaded from: classes8.dex */
    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        /* synthetic */ ScaleListener(GestureCropImageView gestureCropImageView, byte b) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.KClassImpl$Data$declaredNonStaticMembers$2, GestureCropImageView.this.getErrorConfigVersion);
            return true;
        }
    }

    /* loaded from: classes8.dex */
    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(GestureCropImageView gestureCropImageView, byte b) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.postTranslate(-f, -f2);
            return true;
        }
    }

    /* loaded from: classes8.dex */
    class RotateListener extends RotationGestureDetector.SimpleOnRotationGestureListener {
        private RotateListener() {
        }

        /* synthetic */ RotateListener(GestureCropImageView gestureCropImageView, byte b) {
            this();
        }

        @Override // com.yalantis.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener, com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public final boolean PlaceComponentResult(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.postRotate(rotationGestureDetector.PlaceComponentResult, GestureCropImageView.this.KClassImpl$Data$declaredNonStaticMembers$2, GestureCropImageView.this.getErrorConfigVersion);
            return true;
        }
    }
}
