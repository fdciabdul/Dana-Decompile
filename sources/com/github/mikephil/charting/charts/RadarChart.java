package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes7.dex */
public class RadarChart extends PieRadarChartBase<RadarData> {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private boolean getAuthRequestContext;
    private float lookAheadTest;
    protected XAxisRendererRadarChart mXAxisRenderer;
    protected YAxisRendererRadarChart mYAxisRenderer;
    private YAxis scheduleImpl;

    public RadarChart(Context context) {
        super(context);
        this.lookAheadTest = 2.5f;
        this.MyBillsEntityDataFactory = 1.5f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Color.rgb(122, 122, 122);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Color.rgb(122, 122, 122);
        this.BuiltInFictitiousFunctionClassFactory = 150;
        this.getAuthRequestContext = true;
        this.PlaceComponentResult = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lookAheadTest = 2.5f;
        this.MyBillsEntityDataFactory = 1.5f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Color.rgb(122, 122, 122);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Color.rgb(122, 122, 122);
        this.BuiltInFictitiousFunctionClassFactory = 150;
        this.getAuthRequestContext = true;
        this.PlaceComponentResult = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lookAheadTest = 2.5f;
        this.MyBillsEntityDataFactory = 1.5f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Color.rgb(122, 122, 122);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Color.rgb(122, 122, 122);
        this.BuiltInFictitiousFunctionClassFactory = 150;
        this.getAuthRequestContext = true;
        this.PlaceComponentResult = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.scheduleImpl = new YAxis(YAxis.AxisDependency.LEFT);
        this.lookAheadTest = Utils.PlaceComponentResult(1.5f);
        this.MyBillsEntityDataFactory = Utils.PlaceComponentResult(0.75f);
        this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.scheduleImpl, this);
        this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
        this.mHighlighter = new RadarHighlighter(this);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        super.calcMinMax();
        this.scheduleImpl.getAuthRequestContext(((RadarData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.LEFT), ((RadarData) this.mData).getAuthRequestContext(YAxis.AxisDependency.LEFT));
        this.mXAxis.getAuthRequestContext(0.0f, ((RadarData) this.mData).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1());
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == 0) {
            return;
        }
        calcMinMax();
        this.mYAxisRenderer.MyBillsEntityDataFactory(this.scheduleImpl.MyBillsEntityDataFactory, this.scheduleImpl.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl.whenAvailable());
        this.mXAxisRenderer.MyBillsEntityDataFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.BuiltInFictitiousFunctionClassFactory, false);
        if (this.mLegend != null && !this.mLegend.MyBillsEntityDataFactory()) {
            this.mLegendRenderer.PlaceComponentResult(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.mXAxisRenderer.MyBillsEntityDataFactory(this.mXAxis.MyBillsEntityDataFactory, this.mXAxis.BuiltInFictitiousFunctionClassFactory, false);
        }
        this.mXAxisRenderer.getAuthRequestContext(canvas);
        if (this.getAuthRequestContext) {
            this.mRenderer.getAuthRequestContext(canvas);
        }
        if (this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.scheduleImpl.getErrorConfigVersion()) {
            this.mYAxisRenderer.PlaceComponentResult(canvas);
        }
        this.mRenderer.BuiltInFictitiousFunctionClassFactory(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.MyBillsEntityDataFactory(canvas, this.mIndicesToHighlight);
        }
        if (this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda3() && !this.scheduleImpl.getErrorConfigVersion()) {
            this.mYAxisRenderer.PlaceComponentResult(canvas);
        }
        this.mYAxisRenderer.KClassImpl$Data$declaredNonStaticMembers$2(canvas);
        this.mRenderer.PlaceComponentResult(canvas);
        this.mLegendRenderer.getAuthRequestContext(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public float getFactor() {
        RectF GetContactSyncConfig = this.mViewPortHandler.GetContactSyncConfig();
        return Math.min(GetContactSyncConfig.width() / 2.0f, GetContactSyncConfig.height() / 2.0f) / this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public float getSliceAngle() {
        return 360.0f / ((RadarData) this.mData).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float KClassImpl$Data$declaredNonStaticMembers$2 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int BottomSheetCardBindingView$watcherCardNumberView$1 = ((RadarData) this.mData).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1();
        int i = 0;
        while (i < BottomSheetCardBindingView$watcherCardNumberView$1) {
            int i2 = i + 1;
            if ((i2 * sliceAngle) - (sliceAngle / 2.0f) > KClassImpl$Data$declaredNonStaticMembers$2) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    public YAxis getYAxis() {
        return this.scheduleImpl;
    }

    public void setWebLineWidth(float f) {
        this.lookAheadTest = Utils.PlaceComponentResult(f);
    }

    public float getWebLineWidth() {
        return this.lookAheadTest;
    }

    public void setWebLineWidthInner(float f) {
        this.MyBillsEntityDataFactory = Utils.PlaceComponentResult(f);
    }

    public float getWebLineWidthInner() {
        return this.MyBillsEntityDataFactory;
    }

    public void setWebAlpha(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public int getWebAlpha() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setWebColor(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    public int getWebColor() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setWebColorInner(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    public int getWebColorInner() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setDrawWeb(boolean z) {
        this.getAuthRequestContext = z;
    }

    public void setSkipWebLineCount(int i) {
        this.PlaceComponentResult = Math.max(0, i);
    }

    public int getSkipWebLineCount() {
        return this.PlaceComponentResult;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.BuiltInFictitiousFunctionClassFactory().getTextSize() * 4.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.mXAxis.lookAheadTest()) ? this.mXAxis.E : Utils.PlaceComponentResult(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF GetContactSyncConfig = this.mViewPortHandler.GetContactSyncConfig();
        return Math.min(GetContactSyncConfig.width() / 2.0f, GetContactSyncConfig.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return this.scheduleImpl.MyBillsEntityDataFactory;
    }

    public float getYRange() {
        return this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
