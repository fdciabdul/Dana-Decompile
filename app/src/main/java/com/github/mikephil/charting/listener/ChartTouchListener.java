package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

/* loaded from: classes3.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    protected T BuiltInFictitiousFunctionClassFactory;
    protected GestureDetector KClassImpl$Data$declaredNonStaticMembers$2;
    protected Highlight MyBillsEntityDataFactory;
    protected ChartGesture getAuthRequestContext = ChartGesture.NONE;
    protected int PlaceComponentResult = 0;

    /* loaded from: classes3.dex */
    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t) {
        this.BuiltInFictitiousFunctionClassFactory = t;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new GestureDetector(t.getContext(), this);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.getOnChartGestureListener();
    }

    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.getOnChartGestureListener();
    }

    public final void PlaceComponentResult(Highlight highlight) {
        this.MyBillsEntityDataFactory = highlight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(Highlight highlight) {
        if (highlight == null || highlight.getAuthRequestContext(this.MyBillsEntityDataFactory)) {
            this.BuiltInFictitiousFunctionClassFactory.highlightValue(null, true);
            this.MyBillsEntityDataFactory = null;
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.highlightValue(highlight, true);
        this.MyBillsEntityDataFactory = highlight;
    }
}
