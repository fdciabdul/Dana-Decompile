package id.dana.sendmoney.model;

import android.text.TextUtils;
import id.dana.data.constant.DanaUrl;

/* loaded from: classes5.dex */
public class SendMoneyConfirmModel {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public AttributesModel MyBillsEntityDataFactory;
    public PayMethodRiskModel PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String scheduleImpl;

    public final String getAuthRequestContext(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        if (BuiltInFictitiousFunctionClassFactory()) {
            sb.append(BuiltInFictitiousFunctionClassFactory(str, str2, str3, str4));
        } else {
            sb.append(PlaceComponentResult(str, str2, str3, str4));
        }
        return sb.toString();
    }

    private String PlaceComponentResult(String str, String str2, String str3, String str4) {
        if (MyBillsEntityDataFactory(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(DanaUrl.PAYMENT_RESULT, this.KClassImpl$Data$declaredNonStaticMembers$2));
            sb.append(String.format(DanaUrl.CASHIER_COUPON_ID, str4));
            return sb.toString();
        } else if (PlaceComponentResult(str, str2, str3)) {
            return MyBillsEntityDataFactory(str3, str4);
        } else {
            return getAuthRequestContext(str, str2, str4);
        }
    }

    private String getAuthRequestContext(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(DanaUrl.CASHIER_SEND_MONEY);
        sb.append(String.format(DanaUrl.CASHIER_ORDER_ID, this.KClassImpl$Data$declaredNonStaticMembers$2));
        sb.append(String.format(DanaUrl.CASHIER_COUPON_ID, str3));
        sb.append(String.format(DanaUrl.CASHIER_DIRECT_DEBIT, str2, str));
        return sb.toString();
    }

    private String MyBillsEntityDataFactory(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format(DanaUrl.CASHIER_ORDER_ID, this.KClassImpl$Data$declaredNonStaticMembers$2));
        sb.append(String.format(DanaUrl.CASHIER_COUPON_ID, str2));
        return sb.toString();
    }

    private String BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (MyBillsEntityDataFactory(str2)) {
            sb.append(DanaUrl.CASHIER_SEND_MONEY);
            sb.append(String.format(DanaUrl.CASHIER_ORDER_ID, this.KClassImpl$Data$declaredNonStaticMembers$2));
            sb.append(String.format(DanaUrl.CASHIER_COUPON_ID, str4));
        } else if (PlaceComponentResult(str, str2, str3)) {
            sb.append(MyBillsEntityDataFactory(str3, str4));
        } else {
            sb.append(getAuthRequestContext(str, str2, str4));
        }
        if (MyBillsEntityDataFactory()) {
            StringBuilder sb2 = new StringBuilder();
            PayMethodRiskModel payMethodRiskModel = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
            sb2.append(String.format(DanaUrl.CASHIER_RISK_II, payMethodRiskModel.KClassImpl$Data$declaredNonStaticMembers$2, payMethodRiskModel.PlaceComponentResult, payMethodRiskModel.BuiltInFictitiousFunctionClassFactory));
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        return "BALANCE".equals(str);
    }

    private static boolean PlaceComponentResult(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str) || MyBillsEntityDataFactory(str2) || TextUtils.isEmpty(str3)) ? false : true;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext() || MyBillsEntityDataFactory();
    }

    private boolean getAuthRequestContext() {
        return this.PlaceComponentResult != null;
    }

    private boolean MyBillsEntityDataFactory() {
        AttributesModel attributesModel = this.MyBillsEntityDataFactory;
        return (attributesModel == null || attributesModel.BuiltInFictitiousFunctionClassFactory == null) ? false : true;
    }
}
