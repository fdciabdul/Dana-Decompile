package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class c {
    public static String BuiltInFictitiousFunctionClassFactory(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getString exception");
            sb.append(e.getMessage());
            HMSLog.i("BundleUtil", sb.toString());
            return "";
        }
    }

    public static byte[] MyBillsEntityDataFactory(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getByteArray exception");
            sb.append(e.getMessage());
            HMSLog.i("BundleUtil", sb.toString());
            return new byte[0];
        }
    }

    public static String getAuthRequestContext(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getString exception");
            sb.append(e.getMessage());
            HMSLog.i("BundleUtil", sb.toString());
            return null;
        }
    }
}
