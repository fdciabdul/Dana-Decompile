package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    private long BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private RectF getAuthRequestContext;
    private boolean getErrorConfigVersion;
    protected boolean mAutoScaleMinMaxEnabled;
    protected YAxis mAxisLeft;
    protected YAxisRenderer mAxisRendererLeft;
    protected YAxisRenderer mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    protected boolean mClipValuesToContent;
    protected boolean mDoubleTapToZoomEnabled;
    protected boolean mDrawBorders;
    protected boolean mDrawGridBackground;
    protected OnDrawListener mDrawListener;
    protected Matrix mFitScreenMatrixBuffer;
    protected float[] mGetPositionBuffer;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled;
    protected boolean mKeepPositionOnRotation;
    protected Transformer mLeftAxisTransformer;
    protected int mMaxVisibleCount;
    protected float mMinOffset;
    protected float[] mOnSizeChangedBuffer;
    protected boolean mPinchZoomEnabled;
    protected Transformer mRightAxisTransformer;
    protected XAxisRenderer mXAxisRenderer;
    protected Matrix mZoomMatrixBuffer;
    private long moveToNextValue;
    protected MPPointD posForGetHighestVisibleX;
    protected MPPointD posForGetLowestVisibleX;
    private boolean scheduleImpl;

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = true;
        this.scheduleImpl = true;
        this.getErrorConfigVersion = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.moveToNextValue = 0L;
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getAuthRequestContext = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.posForGetHighestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = true;
        this.scheduleImpl = true;
        this.getErrorConfigVersion = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.moveToNextValue = 0L;
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getAuthRequestContext = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.posForGetHighestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = true;
        this.scheduleImpl = true;
        this.getErrorConfigVersion = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.moveToNextValue = 0L;
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.getAuthRequestContext = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.posForGetHighestVisibleX = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.mOnSizeChangedBuffer = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        setHighlighter(new ChartHighlighter(this));
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda2());
        Paint paint = new Paint();
        this.mGridBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.PlaceComponentResult(1.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        drawGridBackground(canvas);
        if (this.mAutoScaleMinMaxEnabled) {
            autoScale();
        }
        if (this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mAxisRendererLeft.MyBillsEntityDataFactory(this.mAxisLeft.MyBillsEntityDataFactory, this.mAxisLeft.BuiltInFictitiousFunctionClassFactory, this.mAxisLeft.whenAvailable());
        }
        if (this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mAxisRendererRight.MyBillsEntityDataFactory(this.mAxisRight.MyBillsEntityDataFactory, this.mAxisRight.BuiltInFictitiousFunctionClassFactory, this.mAxisRight.whenAvailable());
        }
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mXAxisRenderer.MyBillsEntityDataFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.BuiltInFictitiousFunctionClassFactory, false);
        }
        this.mXAxisRenderer.BuiltInFictitiousFunctionClassFactory(canvas);
        this.mAxisRendererLeft.MyBillsEntityDataFactory(canvas);
        this.mAxisRendererRight.MyBillsEntityDataFactory(canvas);
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mXAxisRenderer.KClassImpl$Data$declaredNonStaticMembers$2(canvas);
        }
        if (this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mAxisRendererLeft.getAuthRequestContext(canvas);
        }
        if (this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mAxisRendererRight.getAuthRequestContext(canvas);
        }
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.mXAxis.getErrorConfigVersion()) {
            this.mXAxisRenderer.PlaceComponentResult(canvas);
        }
        if (this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.mAxisLeft.getErrorConfigVersion()) {
            this.mAxisRendererLeft.PlaceComponentResult(canvas);
        }
        if (this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.mAxisRight.getErrorConfigVersion()) {
            this.mAxisRendererRight.PlaceComponentResult(canvas);
        }
        int save = canvas.save();
        canvas.clipRect(this.mViewPortHandler.GetContactSyncConfig());
        this.mRenderer.BuiltInFictitiousFunctionClassFactory(canvas);
        if (!this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mXAxisRenderer.KClassImpl$Data$declaredNonStaticMembers$2(canvas);
        }
        if (!this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mAxisRendererLeft.getAuthRequestContext(canvas);
        }
        if (!this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.mAxisRendererRight.getAuthRequestContext(canvas);
        }
        if (valuesToHighlight()) {
            this.mRenderer.MyBillsEntityDataFactory(canvas, this.mIndicesToHighlight);
        }
        canvas.restoreToCount(save);
        this.mRenderer.getAuthRequestContext(canvas);
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3() && !this.mXAxis.getErrorConfigVersion()) {
            this.mXAxisRenderer.PlaceComponentResult(canvas);
        }
        if (this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda3() && !this.mAxisLeft.getErrorConfigVersion()) {
            this.mAxisRendererLeft.PlaceComponentResult(canvas);
        }
        if (this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda3() && !this.mAxisRight.getErrorConfigVersion()) {
            this.mAxisRendererRight.PlaceComponentResult(canvas);
        }
        this.mXAxisRenderer.getAuthRequestContext(canvas);
        this.mAxisRendererLeft.KClassImpl$Data$declaredNonStaticMembers$2(canvas);
        this.mAxisRendererRight.KClassImpl$Data$declaredNonStaticMembers$2(canvas);
        if (isClipValuesToContentEnabled()) {
            int save2 = canvas.save();
            canvas.clipRect(this.mViewPortHandler.GetContactSyncConfig());
            this.mRenderer.PlaceComponentResult(canvas);
            canvas.restoreToCount(save2);
        } else {
            this.mRenderer.PlaceComponentResult(canvas);
        }
        this.mLegendRenderer.getAuthRequestContext(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
        if (this.mLogEnabled) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long j = this.moveToNextValue + currentTimeMillis2;
            this.moveToNextValue = j;
            long j2 = this.BuiltInFictitiousFunctionClassFactory + 1;
            this.BuiltInFictitiousFunctionClassFactory = j2;
            StringBuilder sb = new StringBuilder();
            sb.append("Drawtime: ");
            sb.append(currentTimeMillis2);
            sb.append(" ms, average: ");
            sb.append(j / j2);
            sb.append(" ms, cycles: ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            InstrumentInjector.log_i(Chart.LOG_TAG, sb.toString());
        }
    }

    public void resetTracking() {
        this.moveToNextValue = 0L;
        this.BuiltInFictitiousFunctionClassFactory = 0L;
    }

    protected void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            StringBuilder sb = new StringBuilder();
            sb.append("Preparing Value-Px Matrix, xmin: ");
            sb.append(this.mXAxis.MyBillsEntityDataFactory);
            sb.append(", xmax: ");
            sb.append(this.mXAxis.BuiltInFictitiousFunctionClassFactory);
            sb.append(", xdelta: ");
            sb.append(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0);
            InstrumentInjector.log_i(Chart.LOG_TAG, sb.toString());
        }
        this.mRightAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mAxisRight.MyBillsEntityDataFactory);
        this.mLeftAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mAxisLeft.MyBillsEntityDataFactory);
    }

    public void prepareOffsetMatrix() {
        this.mRightAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mAxisRight.whenAvailable());
        this.mLeftAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mAxisLeft.whenAvailable());
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == 0) {
            if (this.mLogEnabled) {
                InstrumentInjector.log_i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.mLogEnabled) {
            InstrumentInjector.log_i(Chart.LOG_TAG, "Preparing...");
        }
        if (this.mRenderer != null) {
            this.mRenderer.PlaceComponentResult();
        }
        calcMinMax();
        this.mAxisRendererLeft.MyBillsEntityDataFactory(this.mAxisLeft.MyBillsEntityDataFactory, this.mAxisLeft.BuiltInFictitiousFunctionClassFactory, this.mAxisLeft.whenAvailable());
        this.mAxisRendererRight.MyBillsEntityDataFactory(this.mAxisRight.MyBillsEntityDataFactory, this.mAxisRight.BuiltInFictitiousFunctionClassFactory, this.mAxisRight.whenAvailable());
        this.mXAxisRenderer.MyBillsEntityDataFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.BuiltInFictitiousFunctionClassFactory, false);
        if (this.mLegend != null) {
            this.mLegendRenderer.PlaceComponentResult(this.mData);
        }
        calculateOffsets();
    }

    protected void autoScale() {
        ((BarLineScatterCandleBubbleData) this.mData).getAuthRequestContext(getLowestVisibleX(), getHighestVisibleX());
        this.mXAxis.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).lookAheadTest(), ((BarLineScatterCandleBubbleData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda0());
        if (this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mAxisLeft.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.mData).getAuthRequestContext(YAxis.AxisDependency.LEFT));
        }
        if (this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mAxisRight.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.mData).getAuthRequestContext(YAxis.AxisDependency.RIGHT));
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        this.mXAxis.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).lookAheadTest(), ((BarLineScatterCandleBubbleData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda0());
        this.mAxisLeft.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.mData).getAuthRequestContext(YAxis.AxisDependency.LEFT));
        this.mAxisRight.getAuthRequestContext(((BarLineScatterCandleBubbleData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.mData).getAuthRequestContext(YAxis.AxisDependency.RIGHT));
    }

    public void calculateLegendOffsets(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        if (this.mLegend == null || !this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda3() || this.mLegend.BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        int i = AnonymousClass2.getAuthRequestContext[this.mLegend.DatabaseTableConfigUtil.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i2 = AnonymousClass2.BuiltInFictitiousFunctionClassFactory[this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda7.ordinal()];
                if (i2 == 1) {
                    rectF.top += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda1, this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda1() * this.mLegend.GetContactSyncConfig) + this.mLegend.FragmentBottomSheetPaymentSettingBinding();
                    return;
                } else if (i2 == 2) {
                    rectF.bottom += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda1, this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda1() * this.mLegend.GetContactSyncConfig) + this.mLegend.FragmentBottomSheetPaymentSettingBinding();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        int i3 = AnonymousClass2.MyBillsEntityDataFactory[this.mLegend.initRecordTimeStamp.ordinal()];
        if (i3 == 1) {
            rectF.left += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda2, this.mViewPortHandler.initRecordTimeStamp() * this.mLegend.GetContactSyncConfig) + this.mLegend.newProxyInstance();
        } else if (i3 == 2) {
            rectF.right += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda2, this.mViewPortHandler.initRecordTimeStamp() * this.mLegend.GetContactSyncConfig) + this.mLegend.newProxyInstance();
        } else if (i3 == 3) {
            int i4 = AnonymousClass2.BuiltInFictitiousFunctionClassFactory[this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda7.ordinal()];
            if (i4 == 1) {
                rectF.top += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda1, this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda1() * this.mLegend.GetContactSyncConfig) + this.mLegend.FragmentBottomSheetPaymentSettingBinding();
            } else if (i4 == 2) {
                rectF.bottom += Math.min(this.mLegend.NetworkUserEntityData$$ExternalSyntheticLambda1, this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda1() * this.mLegend.GetContactSyncConfig) + this.mLegend.FragmentBottomSheetPaymentSettingBinding();
            }
        }
    }

    /* renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            MyBillsEntityDataFactory = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            calculateLegendOffsets(this.getAuthRequestContext);
            float f = this.getAuthRequestContext.left + 0.0f;
            float f2 = this.getAuthRequestContext.top + 0.0f;
            float f3 = this.getAuthRequestContext.right + 0.0f;
            float f4 = this.getAuthRequestContext.bottom + 0.0f;
            if (this.mAxisLeft.getSupportButtonTintMode()) {
                f += this.mAxisLeft.PlaceComponentResult(this.mAxisRendererLeft.PlaceComponentResult());
            }
            if (this.mAxisRight.getSupportButtonTintMode()) {
                f3 += this.mAxisRight.PlaceComponentResult(this.mAxisRendererRight.PlaceComponentResult());
            }
            if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.mXAxis.lookAheadTest()) {
                float FragmentBottomSheetPaymentSettingBinding = this.mXAxis.D + this.mXAxis.FragmentBottomSheetPaymentSettingBinding();
                if (this.mXAxis.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM) {
                    f4 += FragmentBottomSheetPaymentSettingBinding;
                } else {
                    if (this.mXAxis.AppCompatEmojiTextHelper != XAxis.XAxisPosition.TOP) {
                        if (this.mXAxis.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTH_SIDED) {
                            f4 += FragmentBottomSheetPaymentSettingBinding;
                        }
                    }
                    f2 += FragmentBottomSheetPaymentSettingBinding;
                }
            }
            float extraTopOffset = f2 + getExtraTopOffset();
            float extraRightOffset = f3 + getExtraRightOffset();
            float extraBottomOffset = f4 + getExtraBottomOffset();
            float extraLeftOffset = f + getExtraLeftOffset();
            float PlaceComponentResult = Utils.PlaceComponentResult(this.mMinOffset);
            this.mViewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2(Math.max(PlaceComponentResult, extraLeftOffset), Math.max(PlaceComponentResult, extraTopOffset), Math.max(PlaceComponentResult, extraRightOffset), Math.max(PlaceComponentResult, extraBottomOffset));
            if (this.mLogEnabled) {
                StringBuilder sb = new StringBuilder();
                sb.append("offsetLeft: ");
                sb.append(extraLeftOffset);
                sb.append(", offsetTop: ");
                sb.append(extraTopOffset);
                sb.append(", offsetRight: ");
                sb.append(extraRightOffset);
                sb.append(", offsetBottom: ");
                sb.append(extraBottomOffset);
                InstrumentInjector.log_i(Chart.LOG_TAG, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content: ");
                sb2.append(this.mViewPortHandler.GetContactSyncConfig().toString());
                InstrumentInjector.log_i(Chart.LOG_TAG, sb2.toString());
            }
        }
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    protected void drawGridBackground(Canvas canvas) {
        if (this.mDrawGridBackground) {
            canvas.drawRect(this.mViewPortHandler.GetContactSyncConfig(), this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            canvas.drawRect(this.mViewPortHandler.GetContactSyncConfig(), this.mBorderPaint);
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public Transformer getTransformer(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisTransformer;
        }
        return this.mRightAxisTransformer;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.mChartTouchListener == null || this.mData == 0 || !this.mTouchEnabled) {
            return false;
        }
        return this.mChartTouchListener.onTouch(this, motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mChartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) this.mChartTouchListener).KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public void zoomIn() {
        MPPointF DatabaseTableConfigUtil = this.mViewPortHandler.DatabaseTableConfigUtil();
        this.mViewPortHandler.PlaceComponentResult(DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2, -DatabaseTableConfigUtil.PlaceComponentResult, this.mZoomMatrixBuffer);
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mZoomMatrixBuffer, this, false);
        MPPointF.BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomOut() {
        MPPointF DatabaseTableConfigUtil = this.mViewPortHandler.DatabaseTableConfigUtil();
        this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2, -DatabaseTableConfigUtil.PlaceComponentResult, this.mZoomMatrixBuffer);
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mZoomMatrixBuffer, this, false);
        MPPointF.BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil);
        calculateOffsets();
        postInvalidate();
    }

    public void resetZoom() {
        this.mViewPortHandler.PlaceComponentResult(this.mZoomMatrixBuffer);
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float f, float f2, float f3, float f4) {
        this.mViewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2(f, f2, f3, -f4, this.mZoomMatrixBuffer);
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency) {
        addViewportJob(ZoomJob.MyBillsEntityDataFactory(this.mViewPortHandler, f, f2, f3, f4, getTransformer(axisDependency), axisDependency, this));
    }

    public void zoomToCenter(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        Matrix matrix = this.mZoomMatrixBuffer;
        this.mViewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2(f, f2, centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2, -centerOffsets.PlaceComponentResult, matrix);
        this.mViewPortHandler.MyBillsEntityDataFactory(matrix, this, false);
    }

    public void zoomAndCenterAnimated(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        MPPointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.moveToNextValue(), axisDependency);
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Transformer transformer = getTransformer(axisDependency);
        YAxis axis = getAxis(axisDependency);
        float f5 = this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0;
        float f6 = this.mViewPortHandler.scheduleImpl;
        float f7 = this.mViewPortHandler.getErrorConfigVersion;
        double d = valuesByTouchPoint.getAuthRequestContext;
        double d2 = valuesByTouchPoint.KClassImpl$Data$declaredNonStaticMembers$2;
        addViewportJob(AnimatedZoomJob.PlaceComponentResult(viewPortHandler, this, transformer, axis, f5, f, f2, f6, f7, j));
        MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) valuesByTouchPoint);
    }

    public void fitScreen() {
        Matrix matrix = this.mFitScreenMatrixBuffer;
        this.mViewPortHandler.getAuthRequestContext(matrix);
        this.mViewPortHandler.MyBillsEntityDataFactory(matrix, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void setScaleMinima(float f, float f2) {
        this.mViewPortHandler.moveToNextValue(f);
        this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda0(f2);
    }

    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.moveToNextValue(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.scheduleImpl(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f);
    }

    public void setVisibleXRange(float f, float f2) {
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f2);
    }

    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda0(getAxisRange(axisDependency) / f);
    }

    public void setVisibleYRangeMinimum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.lookAheadTest(getAxisRange(axisDependency) / f);
    }

    public void setVisibleYRange(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(getAxisRange(axisDependency) / f, getAxisRange(axisDependency) / f2);
    }

    public void moveViewToX(float f) {
        addViewportJob(MoveViewJob.getAuthRequestContext(this.mViewPortHandler, f, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this));
    }

    public void moveViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        addViewportJob(MoveViewJob.getAuthRequestContext(this.mViewPortHandler, f, f2 + ((getAxisRange(axisDependency) / this.mViewPortHandler.getErrorConfigVersion) / 2.0f), getTransformer(axisDependency), this));
    }

    public void moveViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        MPPointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.moveToNextValue(), axisDependency);
        addViewportJob(AnimatedMoveViewJob.MyBillsEntityDataFactory(this.mViewPortHandler, f, f2 + ((getAxisRange(axisDependency) / this.mViewPortHandler.getErrorConfigVersion) / 2.0f), getTransformer(axisDependency), this, (float) valuesByTouchPoint.getAuthRequestContext, (float) valuesByTouchPoint.KClassImpl$Data$declaredNonStaticMembers$2, j));
        MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) valuesByTouchPoint);
    }

    public void centerViewToY(float f, YAxis.AxisDependency axisDependency) {
        addViewportJob(MoveViewJob.getAuthRequestContext(this.mViewPortHandler, 0.0f, f + ((getAxisRange(axisDependency) / this.mViewPortHandler.getErrorConfigVersion) / 2.0f), getTransformer(axisDependency), this));
    }

    public void centerViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        float axisRange = getAxisRange(axisDependency) / this.mViewPortHandler.getErrorConfigVersion;
        addViewportJob(MoveViewJob.getAuthRequestContext(this.mViewPortHandler, f - ((getXAxis().NetworkUserEntityData$$ExternalSyntheticLambda0 / this.mViewPortHandler.scheduleImpl) / 2.0f), f2 + (axisRange / 2.0f), getTransformer(axisDependency), this));
    }

    public void centerViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        MPPointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.moveToNextValue(), axisDependency);
        float axisRange = getAxisRange(axisDependency) / this.mViewPortHandler.getErrorConfigVersion;
        addViewportJob(AnimatedMoveViewJob.MyBillsEntityDataFactory(this.mViewPortHandler, f - ((getXAxis().NetworkUserEntityData$$ExternalSyntheticLambda0 / this.mViewPortHandler.scheduleImpl) / 2.0f), f2 + (axisRange / 2.0f), getTransformer(axisDependency), this, (float) valuesByTouchPoint.getAuthRequestContext, (float) valuesByTouchPoint.KClassImpl$Data$declaredNonStaticMembers$2, j));
        MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) valuesByTouchPoint);
    }

    public void setViewPortOffsets(final float f, final float f2, final float f3, final float f4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        post(new Runnable() { // from class: com.github.mikephil.charting.charts.BarLineChartBase.1
            {
                BarLineChartBase.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                BarLineChartBase.this.mViewPortHandler.KClassImpl$Data$declaredNonStaticMembers$2(f, f2, f3, f4);
                BarLineChartBase.this.prepareOffsetMatrix();
                BarLineChartBase.this.prepareValuePxMatrix();
            }
        });
    }

    public void resetViewPortOffsets() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        calculateOffsets();
    }

    public float getAxisRange(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public MPPointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        this.mGetPositionBuffer[0] = entry.MyBillsEntityDataFactory();
        this.mGetPositionBuffer[1] = entry.getAuthRequestContext();
        getTransformer(axisDependency).PlaceComponentResult(this.mGetPositionBuffer);
        float[] fArr = this.mGetPositionBuffer;
        return MPPointF.getAuthRequestContext(fArr[0], fArr[1]);
    }

    public void setMaxVisibleValueCount(int i) {
        this.mMaxVisibleCount = i;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.mHighlightPerDragEnabled = z;
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    public void setGridBackgroundColor(int i) {
        this.mGridBackgroundPaint.setColor(i);
    }

    public void setDragEnabled(boolean z) {
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = z;
    }

    public boolean isDragEnabled() {
        return this.MyBillsEntityDataFactory || this.PlaceComponentResult;
    }

    public void setDragXEnabled(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    public boolean isDragXEnabled() {
        return this.MyBillsEntityDataFactory;
    }

    public void setDragYEnabled(boolean z) {
        this.PlaceComponentResult = z;
    }

    public boolean isDragYEnabled() {
        return this.PlaceComponentResult;
    }

    public void setScaleEnabled(boolean z) {
        this.scheduleImpl = z;
        this.getErrorConfigVersion = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.scheduleImpl = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.getErrorConfigVersion = z;
    }

    public boolean isScaleXEnabled() {
        return this.scheduleImpl;
    }

    public boolean isScaleYEnabled() {
        return this.getErrorConfigVersion;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.mDoubleTapToZoomEnabled = z;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public void setDrawGridBackground(boolean z) {
        this.mDrawGridBackground = z;
    }

    public void setDrawBorders(boolean z) {
        this.mDrawBorders = z;
    }

    public boolean isDrawBordersEnabled() {
        return this.mDrawBorders;
    }

    public void setClipValuesToContent(boolean z) {
        this.mClipValuesToContent = z;
    }

    public boolean isClipValuesToContentEnabled() {
        return this.mClipValuesToContent;
    }

    public void setBorderWidth(float f) {
        this.mBorderPaint.setStrokeWidth(Utils.PlaceComponentResult(f));
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public boolean isKeepPositionOnRotation() {
        return this.mKeepPositionOnRotation;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.mKeepPositionOnRotation = z;
    }

    public MPPointD getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        getValuesByTouchPoint(f, f2, axisDependency, KClassImpl$Data$declaredNonStaticMembers$2);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency, MPPointD mPPointD) {
        getTransformer(axisDependency).getAuthRequestContext(f, f2, mPPointD);
    }

    public MPPointD getPixelForValues(float f, float f2, YAxis.AxisDependency axisDependency) {
        return getTransformer(axisDependency).BuiltInFictitiousFunctionClassFactory(f, f2);
    }

    public Entry getEntryByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return ((BarLineScatterCandleBubbleData) this.mData).BuiltInFictitiousFunctionClassFactory(highlightByTouchPoint);
        }
        return null;
    }

    public IBarLineScatterCandleBubbleDataSet getDataSetByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).MyBillsEntityDataFactory(highlightByTouchPoint.MyBillsEntityDataFactory);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getAuthRequestContext(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.MyBillsEntityDataFactory, this.posForGetLowestVisibleX.getAuthRequestContext);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getAuthRequestContext(this.mViewPortHandler.lookAheadTest(), this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.BuiltInFictitiousFunctionClassFactory, this.posForGetHighestVisibleX.getAuthRequestContext);
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // android.view.View
    public float getScaleX() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.scheduleImpl;
    }

    @Override // android.view.View
    public float getScaleY() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.getErrorConfigVersion;
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.newProxyInstance();
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public YAxis getAxis(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft;
        }
        return this.mAxisRight;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        return getAxis(axisDependency).whenAvailable();
    }

    public void setPinchZoom(boolean z) {
        this.mPinchZoomEnabled = z;
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public void setDragOffsetX(float f) {
        this.mViewPortHandler.moveToNextValue = Utils.PlaceComponentResult(f);
    }

    public void setDragOffsetY(float f) {
        this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda0 = Utils.PlaceComponentResult(f);
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.isLayoutRequested();
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.mXAxisRenderer = xAxisRenderer;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererLeft = yAxisRenderer;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererRight = yAxisRenderer;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return Math.max(this.mAxisLeft.BuiltInFictitiousFunctionClassFactory, this.mAxisRight.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return Math.min(this.mAxisLeft.MyBillsEntityDataFactory, this.mAxisRight.MyBillsEntityDataFactory);
    }

    public boolean isAnyAxisInverted() {
        return this.mAxisLeft.whenAvailable() || this.mAxisRight.whenAvailable();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.mAutoScaleMinMaxEnabled = z;
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setPaint(Paint paint, int i) {
        super.setPaint(paint, i);
        if (i == 4) {
            this.mGridBackgroundPaint = paint;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Paint getPaint(int i) {
        Paint paint = super.getPaint(i);
        if (paint != null) {
            return paint;
        }
        if (i != 4) {
            return null;
        }
        return this.mGridBackgroundPaint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.mOnSizeChangedBuffer;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.mKeepPositionOnRotation) {
            fArr[0] = this.mViewPortHandler.scheduleImpl();
            this.mOnSizeChangedBuffer[1] = this.mViewPortHandler.moveToNextValue();
            getTransformer(YAxis.AxisDependency.LEFT).getAuthRequestContext(this.mOnSizeChangedBuffer);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mKeepPositionOnRotation) {
            getTransformer(YAxis.AxisDependency.LEFT).PlaceComponentResult(this.mOnSizeChangedBuffer);
            this.mViewPortHandler.MyBillsEntityDataFactory(this.mOnSizeChangedBuffer, this);
            return;
        }
        this.mViewPortHandler.MyBillsEntityDataFactory(this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda2(), this, true);
    }
}
