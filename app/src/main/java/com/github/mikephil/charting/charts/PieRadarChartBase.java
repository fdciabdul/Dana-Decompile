package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes7.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    private float BuiltInFictitiousFunctionClassFactory;
    private float getAuthRequestContext;
    protected float mMinOffset;
    protected boolean mRotateEnabled;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
    }

    public abstract int getIndexForAngle(float f);

    public abstract float getRadius();

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    public PieRadarChartBase(Context context) {
        super(context);
        this.getAuthRequestContext = 270.0f;
        this.BuiltInFictitiousFunctionClassFactory = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = 270.0f;
        this.BuiltInFictitiousFunctionClassFactory = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = 270.0f;
        this.BuiltInFictitiousFunctionClassFactory = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mData.getAuthRequestContext();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchEnabled && this.mChartTouchListener != null) {
            return this.mChartTouchListener.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mChartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) this.mChartTouchListener).PlaceComponentResult();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.PlaceComponentResult(this.mData);
        }
        calculateOffsets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r2 != 2) goto L11;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void calculateOffsets() {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.calculateOffsets():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            PlaceComponentResult = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                PlaceComponentResult[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public float getAngleForPoint(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2;
        double d2 = f2 - centerOffsets.PlaceComponentResult;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d2);
        Double.isNaN(d2);
        double sqrt = Math.sqrt((d * d) + (d2 * d2));
        Double.isNaN(d2);
        float degrees = (float) Math.toDegrees(Math.acos(d2 / sqrt));
        if (f > centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
        return f3;
    }

    public MPPointF getPosition(MPPointF mPPointF, float f, float f2) {
        MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        getPosition(mPPointF, f, f2, authRequestContext);
        return authRequestContext;
    }

    public void getPosition(MPPointF mPPointF, float f, float f2, MPPointF mPPointF2) {
        double d = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
        double d2 = f;
        double d3 = f2;
        double cos = Math.cos(Math.toRadians(d3));
        Double.isNaN(d2);
        Double.isNaN(d);
        mPPointF2.KClassImpl$Data$declaredNonStaticMembers$2 = (float) (d + (cos * d2));
        double d4 = mPPointF.PlaceComponentResult;
        double sin = Math.sin(Math.toRadians(d3));
        Double.isNaN(d2);
        Double.isNaN(d4);
        mPPointF2.PlaceComponentResult = (float) (d4 + (d2 * sin));
    }

    public float distanceToCenter(float f, float f2) {
        float f3;
        float f4;
        MPPointF centerOffsets = getCenterOffsets();
        if (f > centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2) {
            f3 = f - centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            f3 = centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2 - f;
        }
        if (f2 > centerOffsets.PlaceComponentResult) {
            f4 = f2 - centerOffsets.PlaceComponentResult;
        } else {
            f4 = centerOffsets.PlaceComponentResult - f2;
        }
        float sqrt = (float) Math.sqrt(Math.pow(f3, 2.0d) + Math.pow(f4, 2.0d));
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
        return sqrt;
    }

    public void setRotationAngle(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        this.getAuthRequestContext = Utils.KClassImpl$Data$declaredNonStaticMembers$2(f);
    }

    public float getRawRotationAngle() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public float getRotationAngle() {
        return this.getAuthRequestContext;
    }

    public void setRotationEnabled(boolean z) {
        this.mRotateEnabled = z;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public float getDiameter() {
        RectF GetContactSyncConfig = this.mViewPortHandler.GetContactSyncConfig();
        GetContactSyncConfig.left += getExtraLeftOffset();
        GetContactSyncConfig.top += getExtraTopOffset();
        GetContactSyncConfig.right -= getExtraRightOffset();
        GetContactSyncConfig.bottom -= getExtraBottomOffset();
        return Math.min(GetContactSyncConfig.width(), GetContactSyncConfig.height());
    }

    public void spin(int i, float f, float f2, Easing.EasingFunction easingFunction) {
        setRotationAngle(f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f, f2);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.PieRadarChartBase.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        ofFloat.start();
    }
}
