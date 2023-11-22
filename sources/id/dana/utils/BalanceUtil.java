package id.dana.utils;

import android.text.TextUtils;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class BalanceUtil {
    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2(new CurrencyAmountModel(str));
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel currencyAmountModel) {
        if (currencyAmountModel == null || TextUtils.isEmpty(currencyAmountModel.MyBillsEntityDataFactory)) {
            return null;
        }
        String str = currencyAmountModel.MyBillsEntityDataFactory;
        String str2 = currencyAmountModel.BuiltInFictitiousFunctionClassFactory != null ? currencyAmountModel.BuiltInFictitiousFunctionClassFactory : "";
        if (GlobalNetworkConstants.IDR_CURRENCY.equals(str2)) {
            str2 = "Rp";
        }
        if (str.contains(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            return sb.toString();
        }
        return NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.getAuthRequestContext(), Integer.parseInt(str), str2);
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(str);
        currencyAmountModel.BuiltInFictitiousFunctionClassFactory = GlobalNetworkConstants.IDR_CURRENCY;
        return KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel);
    }
}
