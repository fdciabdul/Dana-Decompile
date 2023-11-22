package com.huawei.hms.hatool;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class d1 extends v {

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[y0.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[y0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[y0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[y0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
    
        if ((java.lang.System.currentTimeMillis() - r2) <= 43200000) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.hatool.C0220r BuiltInFictitiousFunctionClassFactory(java.util.List<com.huawei.hms.hatool.q> r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.d1.BuiltInFictitiousFunctionClassFactory(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.huawei.hms.hatool.r");
    }

    public static Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", b.getErrorConfigVersion());
        hashMap.put("App-Ver", b.moveToNextValue());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.313");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "sendData RequestId : %s", str3);
        hashMap.put("Request-Id", str3);
        Map<String, String> moveToNextValue = c.moveToNextValue(str, str2);
        if (moveToNextValue == null) {
            return hashMap;
        }
        hashMap.putAll(moveToNextValue);
        return hashMap;
    }
}
