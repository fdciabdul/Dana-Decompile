package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;

/* loaded from: classes3.dex */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    protected boolean mHighlightFullBarEnabled;

    public BarChart(Context context) {
        super(context);
        this.mHighlightFullBarEnabled = false;
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightFullBarEnabled = false;
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHighlightFullBarEnabled = false;
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new BarHighlighter(this));
        getXAxis().NetworkUserEntityData$$ExternalSyntheticLambda8();
        getXAxis().initRecordTimeStamp();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.mXAxis.getAuthRequestContext(((BarData) this.mData).lookAheadTest() - (((BarData) this.mData).PlaceComponentResult / 2.0f), ((BarData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda0() + (((BarData) this.mData).PlaceComponentResult / 2.0f));
        } else {
            this.mXAxis.getAuthRequestContext(((BarData) this.mData).lookAheadTest(), ((BarData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        this.mAxisLeft.getAuthRequestContext(((BarData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.LEFT), ((BarData) this.mData).getAuthRequestContext(YAxis.AxisDependency.LEFT));
        this.mAxisRight.getAuthRequestContext(((BarData) this.mData).MyBillsEntityDataFactory(YAxis.AxisDependency.RIGHT), ((BarData) this.mData).getAuthRequestContext(YAxis.AxisDependency.RIGHT));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == 0) {
            InstrumentInjector.log_e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        Highlight PlaceComponentResult = getHighlighter().PlaceComponentResult(f, f2);
        return (PlaceComponentResult == null || !isHighlightFullBarEnabled()) ? PlaceComponentResult : new Highlight(PlaceComponentResult.moveToNextValue, PlaceComponentResult.lookAheadTest, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.scheduleImpl, PlaceComponentResult.MyBillsEntityDataFactory, -1, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public RectF getBarBounds(BarEntry barEntry) {
        RectF rectF = new RectF();
        getBarBounds(barEntry, rectF);
        return rectF;
    }

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
        rectF.set(MyBillsEntityDataFactory - f, f2, MyBillsEntityDataFactory + f, authRequestContext);
        getTransformer(iBarDataSet.scheduleImpl()).MyBillsEntityDataFactory(rectF);
    }

    public void setDrawValueAboveBar(boolean z) {
        this.PlaceComponentResult = z;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.PlaceComponentResult;
    }

    public void setDrawBarShadow(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.MyBillsEntityDataFactory;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.mHighlightFullBarEnabled = z;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public void highlightValue(float f, int i, int i2) {
        highlightValue(new Highlight(f, i, i2), false);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.mData;
    }

    public void setFitBars(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public void groupBars(float f, float f2, float f3) {
        if (getBarData() == null) {
            throw new RuntimeException("You need to set data for the chart before grouping bars.");
        }
        getBarData().getAuthRequestContext(f, f2, f3);
        notifyDataSetChanged();
    }
}
