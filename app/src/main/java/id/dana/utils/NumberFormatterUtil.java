package id.dana.utils;

import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes5.dex */
public class NumberFormatterUtil {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Locale locale, int i) {
        return NumberFormat.getNumberInstance(locale).format(i);
    }

    public static String MyBillsEntityDataFactory(Locale locale, int i, String str) {
        if (str == null || str.equalsIgnoreCase(GlobalNetworkConstants.IDR_CURRENCY)) {
            str = "Rp";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(NumberFormat.getNumberInstance(locale).format(i));
        return sb.toString();
    }

    public static String MyBillsEntityDataFactory(Locale locale, double d) {
        return NumberFormat.getNumberInstance(locale).format(d);
    }

    public static String BuiltInFictitiousFunctionClassFactory(Locale locale, long j, String str) {
        if (str == null || str.equalsIgnoreCase(GlobalNetworkConstants.IDR_CURRENCY)) {
            str = "Rp";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(NumberFormat.getNumberInstance(locale).format(j));
        return sb.toString();
    }

    public static String MyBillsEntityDataFactory(String str) {
        char[] cArr = {InputCardNumberView.DIVIDER, 'K', 'M', 'B', 'T', 'P', 'E'};
        double parseDouble = Double.parseDouble(str);
        int floor = (int) Math.floor(Math.log10(parseDouble));
        int i = floor / 3;
        if (floor >= 3 && i < 7) {
            StringBuilder sb = new StringBuilder();
            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            double d = i;
            Double.isNaN(d);
            sb.append(decimalFormat.format(parseDouble / Math.pow(10.0d, d * 3.0d)).replace(",", "."));
            sb.append(cArr[i]);
            return sb.toString();
        }
        return new DecimalFormat("#,##0").format(parseDouble);
    }
}
