package com.huawei.hms.hatool;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class z {
    public boolean BuiltInFictitiousFunctionClassFactory = false;
    public int getAuthRequestContext = 4;

    public static String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append("FormalHASDK_2.2.0.313");
        sb.append(k1.MyBillsEntityDataFactory());
        return sb.toString();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return this.BuiltInFictitiousFunctionClassFactory && i >= this.getAuthRequestContext;
    }

    public static void MyBillsEntityDataFactory(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=> ");
        sb.append(str2);
        String obj = sb.toString();
        if (i == 3) {
            InstrumentInjector.log_d("FormalHASDK", obj);
        } else if (i == 5) {
            InstrumentInjector.log_w("FormalHASDK", obj);
        } else if (i != 6) {
            InstrumentInjector.log_i("FormalHASDK", obj);
        } else {
            InstrumentInjector.log_e("FormalHASDK", obj);
        }
    }
}
