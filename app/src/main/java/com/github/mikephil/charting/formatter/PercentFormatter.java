package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import java.text.DecimalFormat;

/* loaded from: classes7.dex */
public class PercentFormatter extends ValueFormatter {
    private PieChart KClassImpl$Data$declaredNonStaticMembers$2;
    public DecimalFormat getAuthRequestContext = new DecimalFormat("###,###,##0.0");

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String MyBillsEntityDataFactory(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthRequestContext.format(f));
        sb.append(" %");
        return sb.toString();
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String PlaceComponentResult(float f) {
        PieChart pieChart = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pieChart != null && pieChart.isUsePercentValuesEnabled()) {
            return MyBillsEntityDataFactory(f);
        }
        return this.getAuthRequestContext.format(f);
    }
}
