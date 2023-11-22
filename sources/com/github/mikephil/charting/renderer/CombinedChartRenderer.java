package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class CombinedChartRenderer extends DataRenderer {
    protected WeakReference<Chart> BuiltInFictitiousFunctionClassFactory;
    protected List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2;
    protected List<DataRenderer> getAuthRequestContext;

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.getAuthRequestContext = new ArrayList(5);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(combinedChart);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.clear();
        CombinedChart combinedChart = (CombinedChart) this.BuiltInFictitiousFunctionClassFactory.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i = AnonymousClass1.PlaceComponentResult[drawOrder.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (combinedChart.getCandleData() != null) {
                                this.getAuthRequestContext.add(new CandleStickChartRenderer(combinedChart, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
                            }
                        } else if (i == 5 && combinedChart.getScatterData() != null) {
                            this.getAuthRequestContext.add(new ScatterChartRenderer(combinedChart, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.getAuthRequestContext.add(new LineChartRenderer(combinedChart, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.getAuthRequestContext.add(new BubbleChartRenderer(combinedChart, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
                }
            } else if (combinedChart.getBarData() != null) {
                this.getAuthRequestContext.add(new BarChartRenderer(combinedChart, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
        Iterator<DataRenderer> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult();
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        Iterator<DataRenderer> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().BuiltInFictitiousFunctionClassFactory(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        Iterator<DataRenderer> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        Iterator<DataRenderer> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        Chart chart = this.BuiltInFictitiousFunctionClassFactory.get();
        if (chart == null) {
            return;
        }
        for (DataRenderer dataRenderer : this.getAuthRequestContext) {
            Object obj = null;
            if (dataRenderer instanceof BarChartRenderer) {
                obj = ((BarChartRenderer) dataRenderer).MyBillsEntityDataFactory.getBarData();
            } else if (dataRenderer instanceof LineChartRenderer) {
                obj = ((LineChartRenderer) dataRenderer).BuiltInFictitiousFunctionClassFactory.getLineData();
            } else if (dataRenderer instanceof CandleStickChartRenderer) {
                obj = ((CandleStickChartRenderer) dataRenderer).MyBillsEntityDataFactory.getCandleData();
            } else if (dataRenderer instanceof ScatterChartRenderer) {
                obj = ((ScatterChartRenderer) dataRenderer).BuiltInFictitiousFunctionClassFactory.getScatterData();
            } else if (dataRenderer instanceof BubbleChartRenderer) {
                obj = ((BubbleChartRenderer) dataRenderer).BuiltInFictitiousFunctionClassFactory.getBubbleData();
            }
            int indexOf = obj == null ? -1 : ((CombinedData) chart.getData()).initRecordTimeStamp().indexOf(obj);
            this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            for (Highlight highlight : highlightArr) {
                if (highlight.getAuthRequestContext == indexOf || highlight.getAuthRequestContext == -1) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.add(highlight);
                }
            }
            List<Highlight> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            dataRenderer.MyBillsEntityDataFactory(canvas, (Highlight[]) list.toArray(new Highlight[list.size()]));
        }
    }
}
