package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* loaded from: classes7.dex */
public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    public PieHighlighter(PieChart pieChart) {
        super(pieChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected final Highlight PlaceComponentResult(int i, float f, float f2) {
        IPieDataSet initRecordTimeStamp = ((PieData) ((PieChart) this.BuiltInFictitiousFunctionClassFactory).getData()).initRecordTimeStamp();
        return new Highlight(i, initRecordTimeStamp.getErrorConfigVersion(i).getAuthRequestContext(), f, f2, 0, initRecordTimeStamp.scheduleImpl());
    }
}
