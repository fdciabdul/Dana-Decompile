package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private float DatabaseTableConfigUtil;
    private Matrix GetContactSyncConfig;
    private MPPointF NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    private VelocityTracker NetworkUserEntityData$$ExternalSyntheticLambda8;
    private MPPointF PrepareContext;
    private float getErrorConfigVersion;
    private Matrix initRecordTimeStamp;
    private MPPointF isLayoutRequested;
    private MPPointF lookAheadTest;
    private long moveToNextValue;
    private IDataSet scheduleImpl;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix) {
        super(barLineChartBase);
        this.GetContactSyncConfig = new Matrix();
        this.initRecordTimeStamp = new Matrix();
        this.isLayoutRequested = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.PrepareContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1.0f;
        this.moveToNextValue = 0L;
        this.lookAheadTest = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.GetContactSyncConfig = matrix;
        this.getErrorConfigVersion = Utils.PlaceComponentResult(3.0f);
        this.DatabaseTableConfigUtil = Utils.PlaceComponentResult(3.5f);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean authRequestContext;
        boolean MyBillsEntityDataFactory;
        boolean MyBillsEntityDataFactory2;
        boolean authRequestContext2;
        Highlight highlightByTouchPoint;
        VelocityTracker velocityTracker;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = VelocityTracker.obtain();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda8) != null) {
            velocityTracker.recycle();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        }
        if (this.PlaceComponentResult == 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onTouchEvent(motionEvent);
        }
        if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragEnabled() || ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() || ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled()) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    VelocityTracker velocityTracker2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker2.computeCurrentVelocity(1000, Utils.MyBillsEntityDataFactory());
                    float yVelocity = velocityTracker2.getYVelocity(pointerId);
                    float xVelocity = velocityTracker2.getXVelocity(pointerId);
                    if ((Math.abs(xVelocity) > Utils.PlaceComponentResult() || Math.abs(yVelocity) > Utils.PlaceComponentResult()) && this.PlaceComponentResult == 1 && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragDecelerationEnabled()) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = 0.0f;
                        this.moveToNextValue = AnimationUtils.currentAnimationTimeMillis();
                        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2 = motionEvent.getX();
                        this.lookAheadTest.PlaceComponentResult = motionEvent.getY();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = xVelocity;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = yVelocity;
                        Utils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
                    }
                    if (this.PlaceComponentResult == 2 || this.PlaceComponentResult == 3 || this.PlaceComponentResult == 4 || this.PlaceComponentResult == 5) {
                        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).calculateOffsets();
                        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).postInvalidate();
                    }
                    this.PlaceComponentResult = 0;
                    ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).enableScroll();
                    VelocityTracker velocityTracker3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                    }
                    getAuthRequestContext();
                } else if (action != 2) {
                    if (action == 3) {
                        this.PlaceComponentResult = 0;
                        getAuthRequestContext();
                    } else if (action != 5) {
                        if (action == 6) {
                            Utils.getAuthRequestContext(motionEvent, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                            this.PlaceComponentResult = 5;
                        }
                    } else if (motionEvent.getPointerCount() >= 2) {
                        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).disableScroll();
                        KClassImpl$Data$declaredNonStaticMembers$2(motionEvent);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
                        float BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(motionEvent);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
                        if (BuiltInFictitiousFunctionClassFactory > 10.0f) {
                            if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isPinchZoomEnabled()) {
                                this.PlaceComponentResult = 4;
                            } else if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() != ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled()) {
                                this.PlaceComponentResult = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() ? 2 : 3;
                            } else {
                                this.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda2 > this.NetworkUserEntityData$$ExternalSyntheticLambda7 ? 2 : 3;
                            }
                        }
                        MPPointF mPPointF = this.PrepareContext;
                        float x = motionEvent.getX(0);
                        float x2 = motionEvent.getX(1);
                        float y = motionEvent.getY(0);
                        float y2 = motionEvent.getY(1);
                        mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 = (x + x2) / 2.0f;
                        mPPointF.PlaceComponentResult = (y + y2) / 2.0f;
                    }
                } else if (this.PlaceComponentResult == 1) {
                    ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).disableScroll();
                    getAuthRequestContext(((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragXEnabled() ? motionEvent.getX() - this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2 : 0.0f, ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragYEnabled() ? motionEvent.getY() - this.isLayoutRequested.PlaceComponentResult : 0.0f);
                } else if (this.PlaceComponentResult == 2 || this.PlaceComponentResult == 3 || this.PlaceComponentResult == 4) {
                    ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).disableScroll();
                    if ((((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() || ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled()) && motionEvent.getPointerCount() >= 2) {
                        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
                        float BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(motionEvent);
                        if (BuiltInFictitiousFunctionClassFactory2 > this.DatabaseTableConfigUtil) {
                            MPPointF BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2, this.PrepareContext.PlaceComponentResult);
                            ViewPortHandler viewPortHandler = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getViewPortHandler();
                            if (this.PlaceComponentResult == 4) {
                                this.getAuthRequestContext = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                                float f = BuiltInFictitiousFunctionClassFactory2 / this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                boolean z = f < 1.0f;
                                if (z) {
                                    MyBillsEntityDataFactory2 = viewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2();
                                } else {
                                    MyBillsEntityDataFactory2 = viewPortHandler.MyBillsEntityDataFactory();
                                }
                                if (z) {
                                    authRequestContext2 = viewPortHandler.PlaceComponentResult();
                                } else {
                                    authRequestContext2 = viewPortHandler.getAuthRequestContext();
                                }
                                float f2 = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() ? f : 1.0f;
                                float f3 = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled() ? f : 1.0f;
                                if (authRequestContext2 || MyBillsEntityDataFactory2) {
                                    this.GetContactSyncConfig.set(this.initRecordTimeStamp);
                                    this.GetContactSyncConfig.postScale(f2, f3, BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult);
                                }
                            } else if (this.PlaceComponentResult == 2 && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled()) {
                                this.getAuthRequestContext = ChartTouchListener.ChartGesture.X_ZOOM;
                                float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1)) / this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                if (abs < 1.0f) {
                                    MyBillsEntityDataFactory = viewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2();
                                } else {
                                    MyBillsEntityDataFactory = viewPortHandler.MyBillsEntityDataFactory();
                                }
                                if (MyBillsEntityDataFactory) {
                                    this.GetContactSyncConfig.set(this.initRecordTimeStamp);
                                    this.GetContactSyncConfig.postScale(abs, 1.0f, BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult);
                                }
                            } else if (this.PlaceComponentResult == 3 && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled()) {
                                this.getAuthRequestContext = ChartTouchListener.ChartGesture.Y_ZOOM;
                                float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1)) / this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                if (abs2 < 1.0f) {
                                    authRequestContext = viewPortHandler.PlaceComponentResult();
                                } else {
                                    authRequestContext = viewPortHandler.getAuthRequestContext();
                                }
                                if (authRequestContext) {
                                    this.GetContactSyncConfig.set(this.initRecordTimeStamp);
                                    this.GetContactSyncConfig.postScale(1.0f, abs2, BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult);
                                }
                            }
                            MPPointF.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3);
                        }
                    }
                } else if (this.PlaceComponentResult == 0) {
                    float x3 = motionEvent.getX() - this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2;
                    float y3 = motionEvent.getY() - this.isLayoutRequested.PlaceComponentResult;
                    if (Math.abs((float) Math.sqrt((x3 * x3) + (y3 * y3))) > this.getErrorConfigVersion && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragEnabled()) {
                        if ((((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isFullyZoomedOut() && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).hasNoDragOffset()) ? false : true) {
                            float abs3 = Math.abs(motionEvent.getX() - this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2);
                            float abs4 = Math.abs(motionEvent.getY() - this.isLayoutRequested.PlaceComponentResult);
                            if ((((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragXEnabled() || abs4 >= abs3) && (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragYEnabled() || abs4 <= abs3)) {
                                this.getAuthRequestContext = ChartTouchListener.ChartGesture.DRAG;
                                this.PlaceComponentResult = 1;
                            }
                        } else if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isHighlightPerDragEnabled()) {
                            this.getAuthRequestContext = ChartTouchListener.ChartGesture.DRAG;
                            if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isHighlightPerDragEnabled() && (highlightByTouchPoint = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY())) != null && !highlightByTouchPoint.getAuthRequestContext(this.MyBillsEntityDataFactory)) {
                                this.MyBillsEntityDataFactory = highlightByTouchPoint;
                                ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).highlightValue(highlightByTouchPoint, true);
                            }
                        }
                    }
                }
            } else {
                BuiltInFictitiousFunctionClassFactory();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = 0.0f;
                KClassImpl$Data$declaredNonStaticMembers$2(motionEvent);
            }
            this.GetContactSyncConfig = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getViewPortHandler().MyBillsEntityDataFactory(this.GetContactSyncConfig, this.BuiltInFictitiousFunctionClassFactory, true);
            return true;
        }
        return true;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(MotionEvent motionEvent) {
        this.initRecordTimeStamp.set(this.GetContactSyncConfig);
        this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2 = motionEvent.getX();
        this.isLayoutRequested.PlaceComponentResult = motionEvent.getY();
        this.scheduleImpl = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    private void getAuthRequestContext(float f, float f2) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.DRAG;
        this.GetContactSyncConfig.set(this.initRecordTimeStamp);
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
        if (MyBillsEntityDataFactory()) {
            if (this.BuiltInFictitiousFunctionClassFactory instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.GetContactSyncConfig.postTranslate(f, f2);
    }

    private static float BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private MPPointF BuiltInFictitiousFunctionClassFactory(float f, float f2) {
        float f3;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getViewPortHandler();
        float FragmentBottomSheetPaymentSettingBinding = viewPortHandler.FragmentBottomSheetPaymentSettingBinding();
        if (MyBillsEntityDataFactory()) {
            f3 = -(f2 - viewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda3());
        } else {
            f3 = -((((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getMeasuredHeight() - f2) - viewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda4());
        }
        return MPPointF.getAuthRequestContext(f - FragmentBottomSheetPaymentSettingBinding, f3);
    }

    private boolean MyBillsEntityDataFactory() {
        return (this.scheduleImpl == null && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isAnyAxisInverted()) || (this.scheduleImpl != null && ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isInverted(this.scheduleImpl.scheduleImpl()));
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
        if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getData()).getAuthRequestContext() > 0) {
            MPPointF BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(motionEvent.getX(), motionEvent.getY());
            ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).zoom(((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isScaleYEnabled() ? 1.4f : 1.0f, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isLogEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Double-Tap, Zooming In, x: ");
                sb.append(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(", y: ");
                sb.append(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
                InstrumentInjector.log_i("BarlineChartTouch", sb.toString());
            }
            MPPointF.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
        if (((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isHighlightPerTapEnabled()) {
            getAuthRequestContext(((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()));
            return super.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.getAuthRequestContext = ChartTouchListener.ChartGesture.FLING;
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getOnChartGestureListener();
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 == 0.0f && this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 *= ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getDragDecelerationFrictionCoef();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult *= ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getDragDecelerationFrictionCoef();
        float f = ((float) (currentAnimationTimeMillis - this.moveToNextValue)) / 1000.0f;
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        float f3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2 += f2 * f;
        this.lookAheadTest.PlaceComponentResult += f3 * f;
        MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest.PlaceComponentResult, 0);
        getAuthRequestContext(((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragXEnabled() ? this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2 - this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2 : 0.0f, ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).isDragYEnabled() ? this.lookAheadTest.PlaceComponentResult - this.isLayoutRequested.PlaceComponentResult : 0.0f);
        obtain.recycle();
        this.GetContactSyncConfig = ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).getViewPortHandler().MyBillsEntityDataFactory(this.GetContactSyncConfig, this.BuiltInFictitiousFunctionClassFactory, false);
        this.moveToNextValue = currentAnimationTimeMillis;
        if (Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2) >= 0.01d || Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult) >= 0.01d) {
            Utils.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).calculateOffsets();
        ((BarLineChartBase) this.BuiltInFictitiousFunctionClassFactory).postInvalidate();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = 0.0f;
    }
}
