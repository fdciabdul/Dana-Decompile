package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: classes7.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected final Highlight PlaceComponentResult(int i, float f, float f2) {
        int i2 = i;
        this.MyBillsEntityDataFactory.clear();
        float PlaceComponentResult = ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getAnimator().PlaceComponentResult();
        float MyBillsEntityDataFactory = ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getAnimator().MyBillsEntityDataFactory();
        float sliceAngle = ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getSliceAngle();
        float factor = ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getFactor();
        MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        int i3 = 0;
        while (i3 < ((RadarData) ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getData()).KClassImpl$Data$declaredNonStaticMembers$2()) {
            IRadarDataSet MyBillsEntityDataFactory2 = ((RadarData) ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getData()).MyBillsEntityDataFactory(i3);
            ?? errorConfigVersion = MyBillsEntityDataFactory2.getErrorConfigVersion(i2);
            float f3 = i2;
            Utils.KClassImpl$Data$declaredNonStaticMembers$2(((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getCenterOffsets(), (errorConfigVersion.getAuthRequestContext() - ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getYChartMin()) * factor * MyBillsEntityDataFactory, (sliceAngle * f3 * PlaceComponentResult) + ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getRotationAngle(), authRequestContext);
            this.MyBillsEntityDataFactory.add(new Highlight(f3, errorConfigVersion.getAuthRequestContext(), authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, i3, MyBillsEntityDataFactory2.scheduleImpl()));
            i3++;
            i2 = i;
        }
        List<Highlight> list = this.MyBillsEntityDataFactory;
        float distanceToCenter = ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).distanceToCenter(f, f2) / ((RadarChart) this.BuiltInFictitiousFunctionClassFactory).getFactor();
        Highlight highlight = null;
        float f4 = Float.MAX_VALUE;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Highlight highlight2 = list.get(i4);
            float abs = Math.abs(highlight2.lookAheadTest - distanceToCenter);
            if (abs < f4) {
                highlight = highlight2;
                f4 = abs;
            }
        }
        return highlight;
    }
}
