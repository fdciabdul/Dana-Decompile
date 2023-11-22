package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* loaded from: classes7.dex */
public class PieData extends ChartData<IPieDataSet> {
    public final IPieDataSet initRecordTimeStamp() {
        return (IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public final /* synthetic */ IPieDataSet MyBillsEntityDataFactory(int i) {
        if (i == 0) {
            return (IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0);
        }
        return null;
    }

    public final IPieDataSet KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i == 0) {
            return (IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public final Entry BuiltInFictitiousFunctionClassFactory(Highlight highlight) {
        return ((IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0)).getErrorConfigVersion((int) highlight.moveToNextValue);
    }

    public final float DatabaseTableConfigUtil() {
        float f = 0.0f;
        for (int i = 0; i < ((IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0)).BottomSheetCardBindingView$watcherCardNumberView$1(); i++) {
            f += ((IPieDataSet) this.BuiltInFictitiousFunctionClassFactory.get(0)).getErrorConfigVersion(i).getAuthRequestContext();
        }
        return f;
    }
}
