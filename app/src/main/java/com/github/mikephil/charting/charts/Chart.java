package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.griver.image.framework.utils.Format;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    private boolean BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float PlaceComponentResult;
    private float getAuthRequestContext;
    private float getErrorConfigVersion;
    private OnChartGestureListener lookAheadTest;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected DefaultValueFormatter mDefaultValueFormatter;
    protected Paint mDescPaint;
    protected Description mDescription;
    protected boolean mDrawMarkers;
    protected boolean mHighLightPerTapEnabled;
    protected IHighlighter mHighlighter;
    protected Highlight[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled;
    protected IMarker mMarker;
    protected float mMaxHighlightDistance;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled;
    protected ViewPortHandler mViewPortHandler;
    protected XAxis mXAxis;
    private boolean moveToNextValue;
    private String scheduleImpl;

    protected abstract void calcMinMax();

    protected abstract void calculateOffsets();

    public abstract void notifyDataSetChanged();

    public Chart(Context context) {
        super(context);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.scheduleImpl = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.getErrorConfigVersion = 0.0f;
        this.MyBillsEntityDataFactory = 0.0f;
        this.getAuthRequestContext = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.moveToNextValue = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        init();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.scheduleImpl = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.getErrorConfigVersion = 0.0f;
        this.MyBillsEntityDataFactory = 0.0f;
        this.getAuthRequestContext = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.moveToNextValue = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        init();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.scheduleImpl = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.getErrorConfigVersion = 0.0f;
        this.MyBillsEntityDataFactory = 0.0f;
        this.getAuthRequestContext = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.moveToNextValue = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.BuiltInFictitiousFunctionClassFactory(getContext());
        this.mMaxHighlightDistance = Utils.PlaceComponentResult(500.0f);
        this.mDescription = new Description();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mInfoPaint = paint;
        paint.setColor(Color.rgb(247, (int) WSContextConstant.HANDSHAKE_SEND_SIZE, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.PlaceComponentResult(12.0f));
        if (this.mLogEnabled) {
            InstrumentInjector.log_i("", "Chart.init()");
        }
    }

    public void setData(T t) {
        this.mData = t;
        this.moveToNextValue = false;
        if (t == null) {
            return;
        }
        setupDefaultFormatter(t.moveToNextValue(), t.scheduleImpl());
        for (IDataSet iDataSet : this.mData.BuiltInFictitiousFunctionClassFactory()) {
            if (iDataSet.getCallingPid() || iDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7() == this.mDefaultValueFormatter) {
                iDataSet.getAuthRequestContext(this.mDefaultValueFormatter);
            }
        }
        notifyDataSetChanged();
        if (this.mLogEnabled) {
            InstrumentInjector.log_i(LOG_TAG, "Data is set.");
        }
    }

    public void clear() {
        this.mData = null;
        this.moveToNextValue = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.PlaceComponentResult(null);
        invalidate();
    }

    public void clearValues() {
        this.mData.MyBillsEntityDataFactory();
        invalidate();
    }

    public boolean isEmpty() {
        T t = this.mData;
        return t == null || t.getAuthRequestContext() <= 0;
    }

    protected void setupDefaultFormatter(float f, float f2) {
        float max;
        T t = this.mData;
        if (t == null || t.getAuthRequestContext() < 2) {
            max = Math.max(Math.abs(f), Math.abs(f2));
        } else {
            max = Math.abs(f2 - f);
        }
        this.mDefaultValueFormatter.PlaceComponentResult(Utils.getAuthRequestContext(max));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if ((!TextUtils.isEmpty(this.scheduleImpl)) == true) {
                MPPointF center = getCenter();
                canvas.drawText(this.scheduleImpl, center.KClassImpl$Data$declaredNonStaticMembers$2, center.PlaceComponentResult, this.mInfoPaint);
            }
        } else if (this.moveToNextValue) {
        } else {
            calculateOffsets();
            this.moveToNextValue = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawDescription(Canvas canvas) {
        float f;
        float f2;
        Description description = this.mDescription;
        if (description == null || !description.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            return;
        }
        MPPointF mPPointF = this.mDescription.PlaceComponentResult;
        this.mDescPaint.setTypeface(this.mDescription.PrepareContext());
        this.mDescPaint.setTextSize(this.mDescription.NetworkUserEntityData$$ExternalSyntheticLambda7());
        this.mDescPaint.setColor(this.mDescription.isLayoutRequested());
        this.mDescPaint.setTextAlign(this.mDescription.KClassImpl$Data$declaredNonStaticMembers$2);
        if (mPPointF == null) {
            f2 = (getWidth() - this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda6()) - this.mDescription.newProxyInstance();
            f = (getHeight() - this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda4()) - this.mDescription.FragmentBottomSheetPaymentSettingBinding();
        } else {
            float f3 = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
            f = mPPointF.PlaceComponentResult;
            f2 = f3;
        }
        canvas.drawText(this.mDescription.getAuthRequestContext, f2, f, this.mDescPaint);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public void setMaxHighlightDistance(float f) {
        this.mMaxHighlightDistance = Utils.PlaceComponentResult(f);
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.mHighLightPerTapEnabled = z;
    }

    public boolean valuesToHighlight() {
        Highlight[] highlightArr = this.mIndicesToHighlight;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    protected void setLastHighlighted(Highlight[] highlightArr) {
        Highlight highlight;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight = highlightArr[0]) == null) {
            this.mChartTouchListener.PlaceComponentResult(null);
        } else {
            this.mChartTouchListener.PlaceComponentResult(highlight);
        }
    }

    public void highlightValues(Highlight[] highlightArr) {
        this.mIndicesToHighlight = highlightArr;
        setLastHighlighted(highlightArr);
        invalidate();
    }

    public void highlightValue(float f, int i) {
        highlightValue(f, i, true);
    }

    public void highlightValue(float f, float f2, int i) {
        highlightValue(f, f2, i, true);
    }

    public void highlightValue(float f, int i, boolean z) {
        highlightValue(f, Float.NaN, i, z);
    }

    public void highlightValue(float f, float f2, int i, boolean z) {
        if (i < 0 || i >= this.mData.KClassImpl$Data$declaredNonStaticMembers$2()) {
            highlightValue((Highlight) null, z);
        } else {
            highlightValue(new Highlight(f, f2, i), z);
        }
    }

    public void highlightValue(Highlight highlight) {
        highlightValue(highlight, false);
    }

    public void highlightValue(Highlight highlight, boolean z) {
        Entry entry = null;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                StringBuilder sb = new StringBuilder();
                sb.append("Highlighted: ");
                sb.append(highlight.toString());
                InstrumentInjector.log_i(LOG_TAG, sb.toString());
            }
            Entry BuiltInFictitiousFunctionClassFactory = this.mData.BuiltInFictitiousFunctionClassFactory(highlight);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = BuiltInFictitiousFunctionClassFactory;
        }
        setLastHighlighted(this.mIndicesToHighlight);
        if (z && this.mSelectionListener != null && valuesToHighlight()) {
            this.mSelectionListener.PlaceComponentResult(entry, highlight);
        }
        invalidate();
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            InstrumentInjector.log_e(LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        return getHighlighter().PlaceComponentResult(f, f2);
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawMarkers(Canvas canvas) {
        if (this.mMarker == null || !isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }
        int i = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i];
            IDataSet MyBillsEntityDataFactory = this.mData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            Entry BuiltInFictitiousFunctionClassFactory = this.mData.BuiltInFictitiousFunctionClassFactory(this.mIndicesToHighlight[i]);
            int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory((IDataSet) BuiltInFictitiousFunctionClassFactory);
            if (BuiltInFictitiousFunctionClassFactory != null && MyBillsEntityDataFactory2 <= MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1() * this.mAnimator.PlaceComponentResult()) {
                float[] markerPosition = getMarkerPosition(highlight);
                if (this.mViewPortHandler.PlaceComponentResult(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(BuiltInFictitiousFunctionClassFactory, highlight);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i++;
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public boolean isDragDecelerationEnabled() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.PlaceComponentResult;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.PlaceComponentResult = f;
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        this.mAnimator.MyBillsEntityDataFactory(i, i2, easingFunction, easingFunction2);
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction) {
        ChartAnimator chartAnimator = this.mAnimator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chartAnimator, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(chartAnimator, "phaseY", 0.0f, 1.0f);
        ofFloat2.setInterpolator(easingFunction);
        ofFloat2.setDuration(i2);
        if (i > i2) {
            ofFloat.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        } else {
            ofFloat2.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public void animateX(int i, Easing.EasingFunction easingFunction) {
        ChartAnimator chartAnimator = this.mAnimator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chartAnimator, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        ofFloat.start();
    }

    public void animateY(int i, Easing.EasingFunction easingFunction) {
        ChartAnimator chartAnimator = this.mAnimator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chartAnimator, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        ofFloat.start();
    }

    public void animateX(int i) {
        ChartAnimator chartAnimator = this.mAnimator;
        Easing.EasingFunction easingFunction = Easing.readMicros;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chartAnimator, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        ofFloat.start();
    }

    public void animateY(int i) {
        ChartAnimator chartAnimator = this.mAnimator;
        Easing.EasingFunction easingFunction = Easing.readMicros;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(chartAnimator, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(chartAnimator.MyBillsEntityDataFactory);
        ofFloat.start();
    }

    public void animateXY(int i, int i2) {
        ChartAnimator chartAnimator = this.mAnimator;
        Easing.EasingFunction easingFunction = Easing.readMicros;
        chartAnimator.MyBillsEntityDataFactory(i, i2, easingFunction, easingFunction);
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.lookAheadTest = onChartGestureListener;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.lookAheadTest;
    }

    public float getYMax() {
        return this.mData.scheduleImpl();
    }

    public float getYMin() {
        return this.mData.moveToNextValue();
    }

    public float getXChartMax() {
        return this.mXAxis.BuiltInFictitiousFunctionClassFactory;
    }

    public float getXChartMin() {
        return this.mXAxis.MyBillsEntityDataFactory;
    }

    public float getXRange() {
        return this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public MPPointF getCenter() {
        return MPPointF.getAuthRequestContext(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public MPPointF getCenterOffsets() {
        return this.mViewPortHandler.DatabaseTableConfigUtil();
    }

    public void setExtraOffsets(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public void setExtraTopOffset(float f) {
        this.getErrorConfigVersion = Utils.PlaceComponentResult(f);
    }

    public float getExtraTopOffset() {
        return this.getErrorConfigVersion;
    }

    public void setExtraRightOffset(float f) {
        this.MyBillsEntityDataFactory = Utils.PlaceComponentResult(f);
    }

    public float getExtraRightOffset() {
        return this.MyBillsEntityDataFactory;
    }

    public void setExtraBottomOffset(float f) {
        this.getAuthRequestContext = Utils.PlaceComponentResult(f);
    }

    public float getExtraBottomOffset() {
        return this.getAuthRequestContext;
    }

    public void setExtraLeftOffset(float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(f);
    }

    public float getExtraLeftOffset() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setLogEnabled(boolean z) {
        this.mLogEnabled = z;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public void setNoDataText(String str) {
        this.scheduleImpl = str;
    }

    public void setNoDataTextColor(int i) {
        this.mInfoPaint.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setTouchEnabled(boolean z) {
        this.mTouchEnabled = z;
    }

    public void setMarker(IMarker iMarker) {
        this.mMarker = iMarker;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    public void setDescription(Description description) {
        this.mDescription = description;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public RectF getContentRect() {
        return this.mViewPortHandler.GetContactSyncConfig();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void setPaint(Paint paint, int i) {
        if (i == 7) {
            this.mInfoPaint = paint;
        } else if (i == 11) {
            this.mDescPaint = paint;
        }
    }

    public Paint getPaint(int i) {
        if (i != 7) {
            if (i != 11) {
                return null;
            }
            return this.mDescPaint;
        }
        return this.mInfoPaint;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public void setDrawMarkers(boolean z) {
        this.mDrawMarkers = z;
    }

    public T getData() {
        return this.mData;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            sb.append(".png");
            FileOutputStream fileOutputStream = new FileOutputStream(sb.toString());
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i) {
        if (i < 0 || i > 100) {
            i = 50;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/DCIM/");
        sb.append(str2);
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            int i2 = AnonymousClass2.MyBillsEntityDataFactory[compressFormat.ordinal()];
            String str4 = "image/png";
            if (i2 != 1) {
                if (i2 == 2) {
                    if (!str.endsWith(Format.SUFFIX_WEBP)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(Format.SUFFIX_WEBP);
                        str = sb2.toString();
                    }
                    str4 = "image/webp";
                } else {
                    if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(".jpg");
                        str = sb3.toString();
                    }
                    str4 = "image/jpeg";
                }
            } else if (!str.endsWith(".png")) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".png");
                str = sb4.toString();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getAbsolutePath());
            sb5.append("/");
            sb5.append(str);
            String obj = sb5.toString();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(obj);
                getChartBitmap().compress(compressFormat, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                long length = new File(obj).length();
                ContentValues contentValues = new ContentValues(8);
                contentValues.put("title", str);
                contentValues.put("_display_name", str);
                contentValues.put("date_added", Long.valueOf(currentTimeMillis));
                contentValues.put("mime_type", str4);
                contentValues.put("description", str3);
                contentValues.put("orientation", (Integer) 0);
                contentValues.put("_data", obj);
                contentValues.put("_size", Long.valueOf(length));
                return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.charts.Chart$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean saveToGallery(String str, int i) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i);
    }

    public boolean saveToGallery(String str) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda8()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int PlaceComponentResult = (int) Utils.PlaceComponentResult(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(PlaceComponentResult, i)), Math.max(getSuggestedMinimumHeight(), resolveSize(PlaceComponentResult, i2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mLogEnabled) {
            InstrumentInjector.log_i(LOG_TAG, "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.mLogEnabled) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting chart dimens, width: ");
                sb.append(i);
                sb.append(", height: ");
                sb.append(i2);
                InstrumentInjector.log_i(LOG_TAG, sb.toString());
            }
            this.mViewPortHandler.getAuthRequestContext(i, i2);
        } else if (this.mLogEnabled) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*Avoiding* setting chart dimens! width: ");
            sb2.append(i);
            sb2.append(", height: ");
            sb2.append(i2);
            InstrumentInjector.log_w(LOG_TAG, sb2.toString());
        }
        notifyDataSetChanged();
        Iterator<Runnable> it = this.mJobs.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            PlaceComponentResult(this);
        }
    }

    private void PlaceComponentResult(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i < viewGroup.getChildCount()) {
                PlaceComponentResult(viewGroup.getChildAt(i));
                i++;
            } else {
                viewGroup.removeAllViews();
                return;
            }
        }
    }

    public void setUnbindEnabled(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.PlaceComponentResult, highlight.BuiltInFictitiousFunctionClassFactory};
    }
}
