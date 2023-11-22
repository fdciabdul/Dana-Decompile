package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    public BubbleData GetContactSyncConfig;
    public ScatterData NetworkUserEntityData$$ExternalSyntheticLambda1;
    public CandleData NetworkUserEntityData$$ExternalSyntheticLambda2;
    public BarData PlaceComponentResult;
    public LineData initRecordTimeStamp;

    @Override // com.github.mikephil.charting.data.ChartData
    public final void PlaceComponentResult() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        }
        this.BuiltInFictitiousFunctionClassFactory.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -3.4028235E38f;
        this.lookAheadTest = Float.MAX_VALUE;
        this.getErrorConfigVersion = -3.4028235E38f;
        this.scheduleImpl = Float.MAX_VALUE;
        this.getAuthRequestContext = -3.4028235E38f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.MAX_VALUE;
        this.MyBillsEntityDataFactory = -3.4028235E38f;
        this.moveToNextValue = Float.MAX_VALUE;
        for (BarLineScatterCandleBubbleData barLineScatterCandleBubbleData : initRecordTimeStamp()) {
            barLineScatterCandleBubbleData.PlaceComponentResult();
            this.BuiltInFictitiousFunctionClassFactory.addAll(barLineScatterCandleBubbleData.BuiltInFictitiousFunctionClassFactory());
            if (barLineScatterCandleBubbleData.scheduleImpl() > this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = barLineScatterCandleBubbleData.scheduleImpl();
            }
            if (barLineScatterCandleBubbleData.moveToNextValue() < this.lookAheadTest) {
                this.lookAheadTest = barLineScatterCandleBubbleData.moveToNextValue();
            }
            if (barLineScatterCandleBubbleData.NetworkUserEntityData$$ExternalSyntheticLambda0() > this.getErrorConfigVersion) {
                this.getErrorConfigVersion = barLineScatterCandleBubbleData.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            if (barLineScatterCandleBubbleData.lookAheadTest() < this.scheduleImpl) {
                this.scheduleImpl = barLineScatterCandleBubbleData.lookAheadTest();
            }
            if (barLineScatterCandleBubbleData.getAuthRequestContext > this.getAuthRequestContext) {
                this.getAuthRequestContext = barLineScatterCandleBubbleData.getAuthRequestContext;
            }
            if (barLineScatterCandleBubbleData.KClassImpl$Data$declaredNonStaticMembers$2 < this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = barLineScatterCandleBubbleData.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (barLineScatterCandleBubbleData.MyBillsEntityDataFactory > this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = barLineScatterCandleBubbleData.MyBillsEntityDataFactory;
            }
            if (barLineScatterCandleBubbleData.moveToNextValue < this.moveToNextValue) {
                this.moveToNextValue = barLineScatterCandleBubbleData.moveToNextValue;
            }
        }
    }

    public final List<BarLineScatterCandleBubbleData> initRecordTimeStamp() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.initRecordTimeStamp;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.PlaceComponentResult;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.GetContactSyncConfig;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        LineData lineData = this.initRecordTimeStamp;
        if (lineData != null) {
            lineData.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        BarData barData = this.PlaceComponentResult;
        if (barData != null) {
            barData.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        CandleData candleData = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (candleData != null) {
            candleData.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        ScatterData scatterData = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (scatterData != null) {
            scatterData.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        BubbleData bubbleData = this.GetContactSyncConfig;
        if (bubbleData != null) {
            bubbleData.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        PlaceComponentResult();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.data.ChartData
    public final Entry BuiltInFictitiousFunctionClassFactory(Highlight highlight) {
        if (highlight.getAuthRequestContext >= initRecordTimeStamp().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = initRecordTimeStamp().get(highlight.getAuthRequestContext);
        if (highlight.MyBillsEntityDataFactory >= barLineScatterCandleBubbleData.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return null;
        }
        for (Entry entry : barLineScatterCandleBubbleData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory).MyBillsEntityDataFactory(highlight.moveToNextValue)) {
            if (entry.getAuthRequestContext() == highlight.lookAheadTest || Float.isNaN(highlight.lookAheadTest)) {
                return entry;
            }
        }
        return null;
    }
}
