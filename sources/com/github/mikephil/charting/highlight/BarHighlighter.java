package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: classes7.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight PlaceComponentResult(float f, float f2) {
        Highlight PlaceComponentResult = super.PlaceComponentResult(f, f2);
        if (PlaceComponentResult == null) {
            return null;
        }
        MPPointD BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(f, f2);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.getAuthRequestContext).getBarData().MyBillsEntityDataFactory(PlaceComponentResult.MyBillsEntityDataFactory);
        if (!iBarDataSet.lookAheadTest()) {
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) BuiltInFictitiousFunctionClassFactory);
            return PlaceComponentResult;
        }
        return MyBillsEntityDataFactory(PlaceComponentResult, iBarDataSet, (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final Highlight MyBillsEntityDataFactory(Highlight highlight, IBarDataSet iBarDataSet, float f, float f2) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getAuthRequestContext(f, f2);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.PlaceComponentResult == null) {
            return highlight;
        }
        Range[] rangeArr = barEntry.getAuthRequestContext;
        if (rangeArr.length > 0) {
            int PlaceComponentResult = PlaceComponentResult(rangeArr, f2);
            MPPointD BuiltInFictitiousFunctionClassFactory = ((BarDataProvider) this.getAuthRequestContext).getTransformer(iBarDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(highlight.moveToNextValue, rangeArr[PlaceComponentResult].KClassImpl$Data$declaredNonStaticMembers$2);
            Highlight highlight2 = new Highlight(barEntry.MyBillsEntityDataFactory(), barEntry.getAuthRequestContext(), (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, highlight.MyBillsEntityDataFactory, PlaceComponentResult, highlight.KClassImpl$Data$declaredNonStaticMembers$2);
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) BuiltInFictitiousFunctionClassFactory);
            return highlight2;
        }
        return null;
    }

    private static int PlaceComponentResult(Range[] rangeArr, float f) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (Range range : rangeArr) {
            if (range.KClassImpl$Data$declaredNonStaticMembers$2(f)) {
                return i;
            }
            i++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f > rangeArr[max].KClassImpl$Data$declaredNonStaticMembers$2) {
            return max;
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected final BarLineScatterCandleBubbleData getAuthRequestContext() {
        return ((BarDataProvider) this.getAuthRequestContext).getBarData();
    }
}
