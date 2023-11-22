package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long getErrorConfigVersion;
    private ArrayList<AngularVelocitySample> lookAheadTest;
    private MPPointF moveToNextValue;
    private float scheduleImpl;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.moveToNextValue = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
        this.lookAheadTest = new ArrayList<>();
        this.getErrorConfigVersion = 0L;
        this.scheduleImpl = 0.0f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float abs;
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).isRotationEnabled()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                BuiltInFictitiousFunctionClassFactory();
                this.scheduleImpl = 0.0f;
                this.lookAheadTest.clear();
                if (((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragDecelerationEnabled()) {
                    MyBillsEntityDataFactory(x, y);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getAngleForPoint(x, y) - ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getRawRotationAngle();
                this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = x;
                this.moveToNextValue.PlaceComponentResult = y;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragDecelerationEnabled()) {
                    this.scheduleImpl = 0.0f;
                    MyBillsEntityDataFactory(x, y);
                    if (this.lookAheadTest.isEmpty()) {
                        abs = 0.0f;
                    } else {
                        AngularVelocitySample angularVelocitySample = this.lookAheadTest.get(0);
                        ArrayList<AngularVelocitySample> arrayList = this.lookAheadTest;
                        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
                        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
                        for (int size = this.lookAheadTest.size() - 1; size >= 0; size--) {
                            angularVelocitySample3 = this.lookAheadTest.get(size);
                            if (angularVelocitySample3.MyBillsEntityDataFactory != angularVelocitySample2.MyBillsEntityDataFactory) {
                                break;
                            }
                        }
                        float f = ((float) (angularVelocitySample2.PlaceComponentResult - angularVelocitySample.PlaceComponentResult)) / 1000.0f;
                        if (f == 0.0f) {
                            f = 0.1f;
                        }
                        boolean z = angularVelocitySample2.MyBillsEntityDataFactory >= angularVelocitySample3.MyBillsEntityDataFactory;
                        if (Math.abs(angularVelocitySample2.MyBillsEntityDataFactory - angularVelocitySample3.MyBillsEntityDataFactory) > 270.0d) {
                            z = !z;
                        }
                        if (angularVelocitySample2.MyBillsEntityDataFactory - angularVelocitySample.MyBillsEntityDataFactory > 180.0d) {
                            double d = angularVelocitySample.MyBillsEntityDataFactory;
                            Double.isNaN(d);
                            angularVelocitySample.MyBillsEntityDataFactory = (float) (d + 360.0d);
                        } else if (angularVelocitySample.MyBillsEntityDataFactory - angularVelocitySample2.MyBillsEntityDataFactory > 180.0d) {
                            double d2 = angularVelocitySample2.MyBillsEntityDataFactory;
                            Double.isNaN(d2);
                            angularVelocitySample2.MyBillsEntityDataFactory = (float) (d2 + 360.0d);
                        }
                        abs = Math.abs((angularVelocitySample2.MyBillsEntityDataFactory - angularVelocitySample.MyBillsEntityDataFactory) / f);
                        if (!z) {
                            abs = -abs;
                        }
                    }
                    this.scheduleImpl = abs;
                    if (abs != 0.0f) {
                        this.getErrorConfigVersion = AnimationUtils.currentAnimationTimeMillis();
                        Utils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
                    }
                }
                ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).enableScroll();
                this.PlaceComponentResult = 0;
                getAuthRequestContext();
            } else if (action == 2) {
                if (((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragDecelerationEnabled()) {
                    MyBillsEntityDataFactory(x, y);
                }
                if (this.PlaceComponentResult == 0) {
                    float f2 = x - this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
                    float f3 = y - this.moveToNextValue.PlaceComponentResult;
                    if (((float) Math.sqrt((f2 * f2) + (f3 * f3))) > Utils.PlaceComponentResult(8.0f)) {
                        this.getAuthRequestContext = ChartTouchListener.ChartGesture.ROTATE;
                        this.PlaceComponentResult = 6;
                        ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).disableScroll();
                        getAuthRequestContext();
                    }
                }
                if (this.PlaceComponentResult == 6) {
                    ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).setRotationAngle(((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getAngleForPoint(x, y) - this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).invalidate();
                }
                getAuthRequestContext();
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
        if (((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).isHighlightPerTapEnabled()) {
            getAuthRequestContext(((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()));
            return true;
        }
        return false;
    }

    private void MyBillsEntityDataFactory(float f, float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.lookAheadTest.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getAngleForPoint(f, f2)));
        for (int size = this.lookAheadTest.size(); size - 2 > 0 && currentAnimationTimeMillis - this.lookAheadTest.get(0).PlaceComponentResult > 1000; size--) {
            this.lookAheadTest.remove(0);
        }
    }

    public final void PlaceComponentResult() {
        if (this.scheduleImpl == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.scheduleImpl *= ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getDragDecelerationFrictionCoef();
        ((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).setRotationAngle(((PieRadarChartBase) this.BuiltInFictitiousFunctionClassFactory).getRotationAngle() + (this.scheduleImpl * (((float) (currentAnimationTimeMillis - this.getErrorConfigVersion)) / 1000.0f)));
        this.getErrorConfigVersion = currentAnimationTimeMillis;
        if (Math.abs(this.scheduleImpl) >= 0.001d) {
            Utils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        } else {
            this.scheduleImpl = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class AngularVelocitySample {
        public float MyBillsEntityDataFactory;
        public long PlaceComponentResult;

        public AngularVelocitySample(long j, float f) {
            this.PlaceComponentResult = j;
            this.MyBillsEntityDataFactory = f;
        }
    }
}
