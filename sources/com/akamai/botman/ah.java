package com.akamai.botman;

import android.util.Log;

/* loaded from: classes3.dex */
public final class ah {
    public static final ah BuiltInFictitiousFunctionClassFactory = new ah();
    public int PlaceComponentResult = 5;

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(int i, String str, Throwable... thArr) {
        if (i < this.PlaceComponentResult) {
            return;
        }
        if (thArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('\n');
            sb.append(Log.getStackTraceString(thArr[0]));
            String obj = sb.toString();
            if (obj.length() > 4000) {
                int length = obj.length() / 4000;
            }
        } else if (str.length() > 4000) {
            int length2 = str.length() / 4000;
        }
    }

    public static void PlaceComponentResult(String str, String str2, Throwable... thArr) {
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(4, str2, thArr);
    }

    public static void MyBillsEntityDataFactory(String str, String str2, Throwable... thArr) {
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(5, str2, thArr);
    }
}
