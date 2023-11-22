package com.github.mikephil.charting.formatter;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.text.DecimalFormat;

/* loaded from: classes7.dex */
public class LargeValueFormatter extends ValueFormatter {
    private String[] BuiltInFictitiousFunctionClassFactory = {"", "k", "m", "b", SecurityConstants.KEY_TEXT};
    private int MyBillsEntityDataFactory = 5;
    private String getAuthRequestContext = "";
    private DecimalFormat PlaceComponentResult = new DecimalFormat("###E00");

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public final String MyBillsEntityDataFactory(float f) {
        StringBuilder sb = new StringBuilder();
        String format = this.PlaceComponentResult.format(f);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        int numericValue2 = Character.getNumericValue(format.charAt(format.length() - 2));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(numericValue2);
        sb2.append(numericValue);
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.BuiltInFictitiousFunctionClassFactory[Integer.valueOf(sb2.toString()).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.MyBillsEntityDataFactory && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                sb.append(replaceAll);
                sb.append(this.getAuthRequestContext);
                return sb.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(replaceAll.substring(0, replaceAll.length() - 2));
            sb3.append(replaceAll.substring(replaceAll.length() - 1));
            replaceAll = sb3.toString();
        }
    }
}
