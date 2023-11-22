package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

/* loaded from: classes7.dex */
public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    protected DrawOrder[] mDrawOrder;
    protected boolean mHighlightFullBarEnabled;

    /* loaded from: classes7.dex */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.mHighlightFullBarEnabled = false;
        this.MyBillsEntityDataFactory = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.mHighlightFullBarEnabled = false;
        this.MyBillsEntityDataFactory = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.mHighlightFullBarEnabled = false;
        this.MyBillsEntityDataFactory = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.mRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider
    public CombinedData getCombinedData() {
        return (CombinedData) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(CombinedData combinedData) {
        super.setData((CombinedChart) combinedData);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.mRenderer).KClassImpl$Data$declaredNonStaticMembers$2();
        this.mRenderer.PlaceComponentResult();
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

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).initRecordTimeStamp;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).PlaceComponentResult;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).GetContactSyncConfig;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public void setDrawBarShadow(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.mHighlightFullBarEnabled = z;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.mDrawOrder = drawOrderArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void drawMarkers(Canvas canvas) {
        if (this.mMarker != null && isDrawMarkersEnabled() && valuesToHighlight()) {
            for (int i = 0; i < this.mIndicesToHighlight.length; i++) {
                Highlight highlight = this.mIndicesToHighlight[i];
                CombinedData combinedData = (CombinedData) this.mData;
                IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet = null;
                if (highlight.getAuthRequestContext < combinedData.initRecordTimeStamp().size()) {
                    BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = combinedData.initRecordTimeStamp().get(highlight.getAuthRequestContext);
                    if (highlight.MyBillsEntityDataFactory < barLineScatterCandleBubbleData.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        iBarLineScatterCandleBubbleDataSet = (IBarLineScatterCandleBubbleDataSet) barLineScatterCandleBubbleData.BuiltInFictitiousFunctionClassFactory().get(highlight.MyBillsEntityDataFactory);
                    }
                }
                Entry BuiltInFictitiousFunctionClassFactory = ((CombinedData) this.mData).BuiltInFictitiousFunctionClassFactory(highlight);
                if (BuiltInFictitiousFunctionClassFactory != null && iBarLineScatterCandleBubbleDataSet.MyBillsEntityDataFactory((IBarLineScatterCandleBubbleDataSet) BuiltInFictitiousFunctionClassFactory) <= iBarLineScatterCandleBubbleDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * this.mAnimator.PlaceComponentResult()) {
                    float[] markerPosition = getMarkerPosition(highlight);
                    if (this.mViewPortHandler.PlaceComponentResult(markerPosition[0], markerPosition[1])) {
                        this.mMarker.refreshContent(BuiltInFictitiousFunctionClassFactory, highlight);
                        this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                    }
                }
            }
        }
    }
}
