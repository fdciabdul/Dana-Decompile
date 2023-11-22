package id.dana.utils;

import android.text.TextUtils;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import java.util.Currency;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ForeignCurrencySymbolUtil {
    private ForeignCurrencySymbolUtil() {
    }

    public static String MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ID";
        }
        String symbol = Currency.getInstance(new Locale(Locale.ENGLISH.getLanguage(), str)).getSymbol();
        return symbol.equals(GlobalNetworkConstants.IDR_CURRENCY) ? "Rp" : symbol;
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        String symbol = Currency.getInstance(str).getSymbol();
        return symbol.equals(GlobalNetworkConstants.IDR_CURRENCY) ? "Rp" : symbol;
    }
}
