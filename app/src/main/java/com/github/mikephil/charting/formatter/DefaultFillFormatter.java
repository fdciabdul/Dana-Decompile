package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* loaded from: classes3.dex */
public class DefaultFillFormatter implements IFillFormatter {
    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public final float PlaceComponentResult(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.getOnBoardingScenario() <= 0.0f || iLineDataSet.D() >= 0.0f) {
            if (lineData.scheduleImpl() > 0.0f) {
                yChartMax = 0.0f;
            }
            if (lineData.moveToNextValue() < 0.0f) {
                yChartMin = 0.0f;
            }
            return iLineDataSet.D() >= 0.0f ? yChartMin : yChartMax;
        }
        return 0.0f;
    }
}
