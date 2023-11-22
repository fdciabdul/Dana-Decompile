package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public class b1 extends f {
    public static Pair<String, String> BuiltInFictitiousFunctionClassFactory(Context context) {
        if (q0.MyBillsEntityDataFactory(context, "android.permission.READ_PHONE_STATE")) {
            y.moveToNextValue("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null")) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }

    public static String getAuthRequestContext() {
        String str;
        String str2;
        String str3 = "";
        try {
            str2 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
        } catch (AndroidRuntimeException unused) {
        } catch (ClassNotFoundException unused2) {
        } catch (IllegalAccessException unused3) {
        } catch (IllegalArgumentException unused4) {
        } catch (NoSuchMethodException unused5) {
        } catch (InvocationTargetException unused6) {
        }
        try {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "getUDID success");
            return str2;
        } catch (AndroidRuntimeException unused7) {
            str3 = str2;
            str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        } catch (ClassNotFoundException unused8) {
            str3 = str2;
            str = "getUDID method invoke failed";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        } catch (IllegalAccessException unused9) {
            str3 = str2;
            str = "getUDID method invoke failed : Illegal AccessException";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        } catch (IllegalArgumentException unused10) {
            str3 = str2;
            str = "getUDID method invoke failed : Illegal ArgumentException";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        } catch (NoSuchMethodException unused11) {
            str3 = str2;
            str = "getUDID method invoke failed : NoSuchMethodException";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        } catch (InvocationTargetException unused12) {
            str3 = str2;
            str = "getUDID method invoke failed : InvocationTargetException";
            y.moveToNextValue("hmsSdk", str);
            return str3;
        }
    }
}
