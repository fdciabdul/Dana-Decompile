package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
    private Path PlaceComponentResult;

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.PlaceComponentResult = new Path();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(Canvas canvas, float f, float f2, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(iLineScatterCandleRadarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda0());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(iLineScatterCandleRadarDataSet.H());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setPathEffect(iLineScatterCandleRadarDataSet.G());
        if (iLineScatterCandleRadarDataSet.L()) {
            this.PlaceComponentResult.reset();
            this.PlaceComponentResult.moveTo(f, this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue());
            this.PlaceComponentResult.lineTo(f, this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory());
            canvas.drawPath(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (iLineScatterCandleRadarDataSet.K()) {
            this.PlaceComponentResult.reset();
            this.PlaceComponentResult.moveTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), f2);
            this.PlaceComponentResult.lineTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), f2);
            canvas.drawPath(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }
}
