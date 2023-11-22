package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;

/* loaded from: classes7.dex */
public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    protected IShapeRenderer NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private float isLayoutRequested;
    private float newProxyInstance;

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.newProxyInstance;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public final IShapeRenderer MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.isLayoutRequested;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public final int getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    /* renamed from: com.github.mikephil.charting.data.ScatterDataSet$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
