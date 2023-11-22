package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes3.dex */
public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {
    public float PlaceComponentResult = 0.85f;

    public final void getAuthRequestContext(float f, float f2, float f3) {
        BarEntry barEntry;
        if (this.BuiltInFictitiousFunctionClassFactory.size() <= 1) {
            throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
        }
        int BottomSheetCardBindingView$watcherCardNumberView$1 = ((IBarDataSet) getErrorConfigVersion()).BottomSheetCardBindingView$watcherCardNumberView$1();
        float f4 = f2 / 2.0f;
        float f5 = f3 / 2.0f;
        float f6 = this.PlaceComponentResult / 2.0f;
        float size = (this.BuiltInFictitiousFunctionClassFactory.size() * (this.PlaceComponentResult + f3)) + f2;
        for (int i = 0; i < BottomSheetCardBindingView$watcherCardNumberView$1; i++) {
            float f7 = f + f4;
            for (T t : this.BuiltInFictitiousFunctionClassFactory) {
                float f8 = f7 + f5 + f6;
                if (i < t.BottomSheetCardBindingView$watcherCardNumberView$1() && (barEntry = (BarEntry) t.getErrorConfigVersion(i)) != null) {
                    barEntry.KClassImpl$Data$declaredNonStaticMembers$2(f8);
                }
                f7 = f8 + f6 + f5;
            }
            float f9 = f7 + f4;
            float f10 = size - (f9 - f);
            if (f10 > 0.0f || f10 < 0.0f) {
                f9 += f10;
            }
            f = f9;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }
}
