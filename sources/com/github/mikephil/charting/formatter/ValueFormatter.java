package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;

/* loaded from: classes3.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String MyBillsEntityDataFactory(float f) {
        return String.valueOf(f);
    }

    public String KClassImpl$Data$declaredNonStaticMembers$2(float f, BarEntry barEntry) {
        return MyBillsEntityDataFactory(f);
    }

    public String PlaceComponentResult(float f) {
        return MyBillsEntityDataFactory(f);
    }
}
