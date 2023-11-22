package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes3.dex */
public class HorizontalBarChart extends BarChart {
    private RectF PlaceComponentResult;
    protected float[] mGetPositionBuffer;

    public HorizontalBarChart(Context context) {
        super(context);
        this.PlaceComponentResult = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        this.mViewPortHandler = new HorizontalViewPortHandler();
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        calculateLegendOffsets(this.PlaceComponentResult);
        float f = this.PlaceComponentResult.left + 0.0f;
        float f2 = this.PlaceComponentResult.top + 0.0f;
        float f3 = this.PlaceComponentResult.right + 0.0f;
        float f4 = this.PlaceComponentResult.bottom + 0.0f;
        if (this.mAxisLeft.getSupportButtonTintMode()) {
            f2 += this.mAxisLeft.MyBillsEntityDataFactory(this.mAxisRendererLeft.PlaceComponentResult());
        }
        if (this.mAxisRight.getSupportButtonTintMode()) {
            f4 += this.mAxisRight.MyBillsEntityDataFactory(this.mAxisRendererRight.PlaceComponentResult());
        }
        float f5 = this.mXAxis.E;
        if (this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            if (this.mXAxis.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM) {
                f += f5;
            } else {
                if (this.mXAxis.AppCompatEmojiTextHelper != XAxis.XAxisPosition.TOP) {
                    if (this.mXAxis.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTH_SIDED) {
                        f += f5;
                    }
                }
                f3 += f5;
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
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void prepareValuePxMatrix() {
        this.mRightAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mAxisRight.MyBillsEntityDataFactory, this.mAxisRight.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mXAxis.MyBillsEntityDataFactory);
        this.mLeftAxisTransformer.BuiltInFictitiousFunctionClassFactory(this.mAxisLeft.MyBillsEntityDataFactory, this.mAxisLeft.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0, this.mXAxis.MyBillsEntityDataFactory);
    }

    @Override // com.github.mikephil.charting.charts.BarChart
    public void getBarBounds(BarEntry barEntry, RectF rectF) {
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarData) this.mData).MyBillsEntityDataFactory(barEntry);
        if (iBarDataSet == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float authRequestContext = barEntry.getAuthRequestContext();
        float MyBillsEntityDataFactory = barEntry.MyBillsEntityDataFactory();
        float f = ((BarData) this.mData).PlaceComponentResult / 2.0f;
        float f2 = authRequestContext >= 0.0f ? authRequestContext : 0.0f;
        if (authRequestContext > 0.0f) {
            authRequestContext = 0.0f;
        }
        rectF.set(f2, MyBillsEntityDataFactory - f, authRequestContext, MyBillsEntityDataFactory + f);
        getTransformer(iBarDataSet.scheduleImpl()).MyBillsEntityDataFactory(rectF);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public MPPointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.mGetPositionBuffer;
        fArr[0] = entry.getAuthRequestContext();
        fArr[1] = entry.MyBillsEntityDataFactory();
        getTransformer(axisDependency).PlaceComponentResult(fArr);
        return MPPointF.getAuthRequestContext(fArr[0], fArr[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == 0) {
            if (this.mLogEnabled) {
                InstrumentInjector.log_e(Chart.LOG_TAG, "Can't select by touch. No data set.");
                return null;
            }
            return null;
        }
        return getHighlighter().PlaceComponentResult(f2, f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getAuthRequestContext(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.MyBillsEntityDataFactory, this.posForGetLowestVisibleX.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getAuthRequestContext(this.mViewPortHandler.scheduleImpl(), this.mViewPortHandler.moveToNextValue(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.BuiltInFictitiousFunctionClassFactory, this.posForGetHighestVisibleX.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.NetworkUserEntityData$$ExternalSyntheticLambda0(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.lookAheadTest(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRange(float f, float f2) {
        this.mViewPortHandler.BuiltInFictitiousFunctionClassFactory(this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f, this.mXAxis.NetworkUserEntityData$$ExternalSyntheticLambda0 / f2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.moveToNextValue(getAxisRange(axisDependency) / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMinimum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.scheduleImpl(getAxisRange(axisDependency) / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRange(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.MyBillsEntityDataFactory(getAxisRange(axisDependency) / f, getAxisRange(axisDependency) / f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.BuiltInFictitiousFunctionClassFactory, highlight.PlaceComponentResult};
    }
}
