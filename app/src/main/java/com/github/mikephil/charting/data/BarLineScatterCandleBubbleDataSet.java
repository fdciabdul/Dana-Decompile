package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
    protected int MyBillsEntityDataFactory;

    public BarLineScatterCandleBubbleDataSet(List<T> list, String str) {
        super(list, str);
        this.MyBillsEntityDataFactory = Color.rgb(255, 187, 115);
    }

    public final void MyBillsEntityDataFactory(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.MyBillsEntityDataFactory;
    }
}
