package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* loaded from: classes7.dex */
public class StackedValueFormatter extends ValueFormatter {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private DecimalFormat PlaceComponentResult;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String KClassImpl$Data$declaredNonStaticMembers$2(float f, BarEntry barEntry) {
        float[] fArr;
        if (this.MyBillsEntityDataFactory || (fArr = barEntry.PlaceComponentResult) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult.format(f));
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            return sb.toString();
        } else if (fArr[fArr.length - 1] == f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.PlaceComponentResult.format(barEntry.getAuthRequestContext()));
            sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            return sb2.toString();
        } else {
            return "";
        }
    }
}
