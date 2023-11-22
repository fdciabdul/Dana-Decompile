package com.github.mikephil.charting.formatter;

/* loaded from: classes7.dex */
public class IndexAxisValueFormatter extends ValueFormatter {
    private String[] PlaceComponentResult = new String[0];
    private int getAuthRequestContext = 0;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String MyBillsEntityDataFactory(float f) {
        int round = Math.round(f);
        return (round < 0 || round >= this.getAuthRequestContext || round != ((int) f)) ? "" : this.PlaceComponentResult[round];
    }
}
