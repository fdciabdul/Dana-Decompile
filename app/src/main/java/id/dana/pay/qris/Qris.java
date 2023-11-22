package id.dana.pay.qris;

import android.text.TextUtils;
import android.util.Base64;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.pay.qris.QrisContract;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes5.dex */
public class Qris implements QrisContract.Qris {
    private final QrisData KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;

    public Qris(QrisData qrisData) {
        String obj;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = qrisData;
        StringBuilder sb = new StringBuilder();
        sb.append("4F07A000000602202050075152495343504d");
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        if (str.length() % 2 != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(LogConstants.RESULT_FALSE);
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("5A");
        sb3.append(String.format("%02X", Integer.valueOf(str.length() / 2)));
        sb3.append(str);
        sb.append(sb3.toString());
        if (BuiltInFictitiousFunctionClassFactory()) {
            obj = "";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("5F20");
            sb4.append(String.format("%02X", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.length() / 2)));
            sb4.append(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
            obj = sb4.toString();
        }
        sb.append(obj);
        sb.append("5F2D026964");
        sb.append("5F500744414e412e4944");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("9F74");
        sb5.append(String.format("%02X", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.length() / 2)));
        sb5.append(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        String obj2 = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("63");
        sb6.append(String.format("%02X", Integer.valueOf(obj2.length() / 2)));
        sb6.append(obj2);
        sb.append(sb6.toString());
        String obj3 = sb.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("8505435056303161");
        sb7.append(String.format("%02X", Integer.valueOf(obj3.length() / 2)));
        sb7.append(obj3);
        this.MyBillsEntityDataFactory = sb7.toString();
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
    }

    public final String PlaceComponentResult() {
        try {
            if (!getAuthRequestContext() && !MyBillsEntityDataFactory()) {
                return Base64.encodeToString(HexUtil.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), 2);
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Error get QRIS Code BASE64 %s", e.getMessage());
            return "";
        }
    }

    private boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.equals("https://m.dana.id");
    }

    private boolean getAuthRequestContext() {
        return TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
    }
}
