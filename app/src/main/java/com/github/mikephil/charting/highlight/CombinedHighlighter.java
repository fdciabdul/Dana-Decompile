package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* loaded from: classes7.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
    protected BarHighlighter MyBillsEntityDataFactory;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.MyBillsEntityDataFactory = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected final List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        this.PlaceComponentResult.clear();
        List<BarLineScatterCandleBubbleData> initRecordTimeStamp = ((CombinedDataProvider) this.getAuthRequestContext).getCombinedData().initRecordTimeStamp();
        for (int i = 0; i < initRecordTimeStamp.size(); i++) {
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = initRecordTimeStamp.get(i);
            BarHighlighter barHighlighter = this.MyBillsEntityDataFactory;
            if (barHighlighter != null && (barLineScatterCandleBubbleData instanceof BarData)) {
                Highlight PlaceComponentResult = barHighlighter.PlaceComponentResult(f2, f3);
                if (PlaceComponentResult != null) {
                    PlaceComponentResult.getAuthRequestContext = i;
                    this.PlaceComponentResult.add(PlaceComponentResult);
                }
            } else {
                int KClassImpl$Data$declaredNonStaticMembers$2 = barLineScatterCandleBubbleData.KClassImpl$Data$declaredNonStaticMembers$2();
                for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                    IDataSet MyBillsEntityDataFactory = initRecordTimeStamp.get(i).MyBillsEntityDataFactory(i2);
                    if (MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                        for (Highlight highlight : KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, i2, f, DataSet.Rounding.CLOSEST)) {
                            highlight.getAuthRequestContext = i;
                            this.PlaceComponentResult.add(highlight);
                        }
                    }
                }
            }
        }
        return this.PlaceComponentResult;
    }
}
