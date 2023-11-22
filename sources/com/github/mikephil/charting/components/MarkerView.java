package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class MarkerView extends RelativeLayout implements IMarker {
    private WeakReference<Chart> BuiltInFictitiousFunctionClassFactory;
    private MPPointF KClassImpl$Data$declaredNonStaticMembers$2;
    private MPPointF PlaceComponentResult;

    public MarkerView(Context context, int i) {
        super(context);
        this.PlaceComponentResult = new MPPointF();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MPPointF();
        View inflate = LayoutInflater.from(getContext()).inflate(i, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void setOffset(MPPointF mPPointF) {
        this.PlaceComponentResult = mPPointF;
        if (mPPointF == null) {
            this.PlaceComponentResult = new MPPointF();
        }
    }

    public void setOffset(float f, float f2) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.PlaceComponentResult.PlaceComponentResult = f2;
    }

    public MPPointF getOffset() {
        return this.PlaceComponentResult;
    }

    public void setChartView(Chart chart) {
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(chart);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.BuiltInFictitiousFunctionClassFactory;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        MPPointF offset = getOffset();
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = offset.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = offset.PlaceComponentResult;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 + f < 0.0f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = -f;
        } else if (chartView != null && f + width + this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 > chartView.getWidth()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (chartView.getWidth() - f) - width;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult + f2 < 0.0f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = -f2;
        } else if (chartView != null && f2 + height + this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult > chartView.getHeight()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (chartView.getHeight() - f2) - height;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f, float f2) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
        int save = canvas.save();
        canvas.translate(f + offsetForDrawingAtPoint.KClassImpl$Data$declaredNonStaticMembers$2, f2 + offsetForDrawingAtPoint.PlaceComponentResult);
        draw(canvas);
        canvas.restoreToCount(save);
    }
}
