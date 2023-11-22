package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class i extends PushPreferences {
    public static final String MyBillsEntityDataFactory = "i";
    public Context BuiltInFictitiousFunctionClassFactory;

    private i(Context context) {
        super(context, "push_client_self_info");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public static i BuiltInFictitiousFunctionClassFactory(Context context) {
        return new i(context);
    }

    public final String BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return PlaceComponentResult("token_info_v2");
            }
            return PlaceComponentResult(str);
        } catch (Exception e) {
            String str2 = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("getSecureData");
            sb.append(e.getMessage());
            HMSLog.e(str2, sb.toString());
            return "";
        }
    }

    private String PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Context context = this.BuiltInFictitiousFunctionClassFactory;
            SharedPreferences sharedPreferences = this.getAuthRequestContext;
            return PushEncrypter.MyBillsEntityDataFactory(context, sharedPreferences != null ? sharedPreferences.getString(str, "") : "");
        } catch (Exception e) {
            String str2 = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("getSecureData");
            sb.append(e.getMessage());
            HMSLog.e(str2, sb.toString());
            return "";
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return MyBillsEntityDataFactory(str, PushEncrypter.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, str2));
        } catch (Exception e) {
            String str3 = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("saveSecureData");
            sb.append(e.getMessage());
            HMSLog.e(str3, sb.toString());
            return false;
        }
    }

    public final boolean getAuthRequestContext(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return KClassImpl$Data$declaredNonStaticMembers$2("token_info_v2", str2);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        } catch (Exception e) {
            String str3 = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("saveSecureData");
            sb.append(e.getMessage());
            HMSLog.e(str3, sb.toString());
            return false;
        }
    }
}
