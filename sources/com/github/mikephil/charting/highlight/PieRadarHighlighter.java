package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    protected T BuiltInFictitiousFunctionClassFactory;
    protected List<Highlight> MyBillsEntityDataFactory = new ArrayList();

    protected abstract Highlight PlaceComponentResult(int i, float f, float f2);

    public PieRadarHighlighter(T t) {
        this.BuiltInFictitiousFunctionClassFactory = t;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public final Highlight PlaceComponentResult(float f, float f2) {
        if (this.BuiltInFictitiousFunctionClassFactory.distanceToCenter(f, f2) > this.BuiltInFictitiousFunctionClassFactory.getRadius()) {
            return null;
        }
        float angleForPoint = this.BuiltInFictitiousFunctionClassFactory.getAngleForPoint(f, f2);
        T t = this.BuiltInFictitiousFunctionClassFactory;
        if (t instanceof PieChart) {
            angleForPoint /= t.getAnimator().MyBillsEntityDataFactory();
        }
        int indexForAngle = this.BuiltInFictitiousFunctionClassFactory.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.BuiltInFictitiousFunctionClassFactory.getData().getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1()) {
            return null;
        }
        return PlaceComponentResult(indexForAngle, f, f2);
    }
}
