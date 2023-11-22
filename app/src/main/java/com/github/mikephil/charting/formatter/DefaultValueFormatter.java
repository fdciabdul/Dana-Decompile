package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public class DefaultValueFormatter extends ValueFormatter {
    protected int BuiltInFictitiousFunctionClassFactory;
    protected DecimalFormat PlaceComponentResult;

    public DefaultValueFormatter(int i) {
        PlaceComponentResult(i);
    }

    public final void PlaceComponentResult(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("###,###,###,##0");
        sb.append(stringBuffer.toString());
        this.PlaceComponentResult = new DecimalFormat(sb.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String MyBillsEntityDataFactory(float f) {
        return this.PlaceComponentResult.format(f);
    }
}
