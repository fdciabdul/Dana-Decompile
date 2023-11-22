package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public class DefaultAxisValueFormatter extends ValueFormatter {
    protected DecimalFormat MyBillsEntityDataFactory;
    protected int getAuthRequestContext;

    public DefaultAxisValueFormatter(int i) {
        this.getAuthRequestContext = i;
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
        this.MyBillsEntityDataFactory = new DecimalFormat(sb.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String MyBillsEntityDataFactory(float f) {
        return this.MyBillsEntityDataFactory.format(f);
    }

    public final int MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}
