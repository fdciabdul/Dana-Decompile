package id.dana.pay.qris;

import android.text.TextUtils;
import id.dana.domain.qrpay.model.QrisPaymentData;
import id.dana.utils.Luhn;

/* loaded from: classes5.dex */
public class QrisData {
    private static final Integer KClassImpl$Data$declaredNonStaticMembers$2 = 26;
    final String BuiltInFictitiousFunctionClassFactory;
    final String MyBillsEntityDataFactory;
    final String PlaceComponentResult;
    private final int getAuthRequestContext;
    private final Luhn getErrorConfigVersion;

    private QrisData(String str, String str2, int i, String str3) {
        String KClassImpl$Data$declaredNonStaticMembers$22;
        String obj;
        int i2 = 0;
        String substring = str2.substring(0, Math.min(str2.length(), KClassImpl$Data$declaredNonStaticMembers$2.intValue()));
        this.getErrorConfigVersion = new Luhn();
        if (!TextUtils.isEmpty(str) && !str.equals("https://m.dana.id")) {
            str = HexUtil.PlaceComponentResult(str);
        }
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = HexUtil.PlaceComponentResult(substring);
        this.getAuthRequestContext = i;
        if (TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("93600915");
            sb.append(this.getAuthRequestContext);
            sb.append("1234567897");
            obj = sb.toString();
        } else {
            String substring2 = str3.substring(8);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3.substring(0, 8));
            sb2.append(this.getAuthRequestContext);
            String substring3 = substring2.length() > 4 ? substring2.substring(substring2.length() - 4) : substring2;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(substring2);
            if (Luhn.getAuthRequestContext(substring3)) {
                KClassImpl$Data$declaredNonStaticMembers$22 = "";
            } else {
                boolean z = true;
                for (int length = substring3.length() - 1; length >= 0; length--) {
                    int authRequestContext = Luhn.getAuthRequestContext(substring3, length);
                    if (z && (authRequestContext = authRequestContext * 2) > 9) {
                        authRequestContext -= 9;
                    }
                    i2 += authRequestContext;
                    z = !z;
                }
                KClassImpl$Data$declaredNonStaticMembers$22 = Luhn.KClassImpl$Data$declaredNonStaticMembers$2(i2);
            }
            sb3.append(KClassImpl$Data$declaredNonStaticMembers$22);
            sb2.append(sb3.toString());
            obj = sb2.toString();
        }
        this.BuiltInFictitiousFunctionClassFactory = obj;
    }

    public static QrisData getAuthRequestContext(QrisPaymentData qrisPaymentData) {
        return new QrisData(qrisPaymentData.getPaymentCode(), qrisPaymentData.getCardholderName(), qrisPaymentData.getFundSource(), qrisPaymentData.getUserPan());
    }
}
