package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;

/* loaded from: classes7.dex */
public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    protected float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    protected boolean newProxyInstance;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public final /* bridge */ /* synthetic */ void PlaceComponentResult(Entry entry) {
        BubbleEntry bubbleEntry = (BubbleEntry) entry;
        super.PlaceComponentResult((BubbleDataSet) bubbleEntry);
        float f = bubbleEntry.MyBillsEntityDataFactory;
        if (f > this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public final boolean MyBillsEntityDataFactory() {
        return this.newProxyInstance;
    }
}
