package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public abstract class DataRenderer extends Renderer {
    protected Paint NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected Paint lookAheadTest;
    protected Paint moveToNextValue;
    protected ChartAnimator scheduleImpl;

    public abstract void BuiltInFictitiousFunctionClassFactory(Canvas canvas);

    public abstract void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr);

    public abstract void PlaceComponentResult();

    public abstract void PlaceComponentResult(Canvas canvas);

    public abstract void getAuthRequestContext(Canvas canvas);

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.scheduleImpl = chartAnimator;
        Paint paint = new Paint(1);
        this.lookAheadTest = paint;
        paint.setStyle(Paint.Style.FILL);
        this.moveToNextValue = new Paint(4);
        Paint paint2 = new Paint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextAlign(Paint.Align.CENTER);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextSize(Utils.PlaceComponentResult(9.0f));
        Paint paint3 = new Paint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(2.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(Color.rgb(255, 187, 115));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getAuthRequestContext()) < ((float) chartInterface.getMaxVisibleCount()) * this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult(IDataSet iDataSet) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTypeface(iDataSet.NetworkUserEntityData$$ExternalSyntheticLambda4());
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextSize(iDataSet.NetworkUserEntityData$$ExternalSyntheticLambda3());
    }
}
