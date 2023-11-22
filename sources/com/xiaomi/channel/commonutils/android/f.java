package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.xiaomi.push.z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public class f {
    private static Map<String, Region> KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = -1;
    private static volatile int getAuthRequestContext;

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return lookAheadTest() == 1;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        if (intent == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(intent.toString());
        sb.append(" ");
        sb.append(getAuthRequestContext(intent.getExtras()));
        return sb.toString();
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            try {
                return (String) z.PlaceComponentResult("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fail to get property. ");
                sb.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean MyBillsEntityDataFactory() {
        if (MyBillsEntityDataFactory < 0) {
            MyBillsEntityDataFactory = !scheduleImpl() ? 1 : 0;
        }
        return MyBillsEntityDataFactory > 0;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return true;
    }

    public static String PlaceComponentResult() {
        int PlaceComponentResult = j.PlaceComponentResult();
        return (!BuiltInFictitiousFunctionClassFactory() || PlaceComponentResult <= 0) ? "" : PlaceComponentResult < 2 ? "alpha" : PlaceComponentResult < 3 ? "development" : "stable";
    }

    public static boolean PlaceComponentResult(Context context) {
        return context != null && PlaceComponentResult(context.getPackageName());
    }

    private static boolean PlaceComponentResult(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int getAuthRequestContext() {
        String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22) || !TextUtils.isDigitsOnly(KClassImpl$Data$declaredNonStaticMembers$22)) {
            return 0;
        }
        return Integer.parseInt(KClassImpl$Data$declaredNonStaticMembers$22);
    }

    private static String getAuthRequestContext(Bundle bundle) {
        String authRequestContext;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    authRequestContext = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    authRequestContext = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    authRequestContext = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    authRequestContext = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    authRequestContext = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    authRequestContext = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    authRequestContext = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    authRequestContext = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    authRequestContext = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    authRequestContext = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    authRequestContext = getAuthRequestContext((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(authRequestContext);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String getAuthRequestContext(String str) {
        return Region.Global.name().equals(str) ? "SG" : Region.Europe.name().equals(str) ? "DE" : Region.Russia.name().equals(str) ? "RU" : Region.India.name().equals(str) ? "IN" : "";
    }

    public static String getErrorConfigVersion() {
        return KClassImpl$Data$declaredNonStaticMembers$2("ro.miui.ui.version.name");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int lookAheadTest() {
        /*
            int r0 = com.xiaomi.channel.commonutils.android.f.getAuthRequestContext
            if (r0 != 0) goto L47
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = KClassImpl$Data$declaredNonStaticMembers$2(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = KClassImpl$Data$declaredNonStaticMembers$2(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 2
        L26:
            com.xiaomi.channel.commonutils.android.f.getAuthRequestContext = r2     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(r2, r1)
            com.xiaomi.channel.commonutils.android.f.getAuthRequestContext = r0
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = com.xiaomi.channel.commonutils.android.f.getAuthRequestContext
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(r0)
        L47:
            int r0 = com.xiaomi.channel.commonutils.android.f.getAuthRequestContext
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.f.lookAheadTest():int");
    }

    private static boolean scheduleImpl() {
        String str = "";
        try {
            str = i.MyBillsEntityDataFactory("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        String MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.miui.region", "");
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.product.country.region", "");
            if (!TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
                String[] split = MyBillsEntityDataFactory2.split("-");
                if (split.length > 0) {
                    MyBillsEntityDataFactory2 = split[0];
                }
            }
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("get region from system, region = ");
            sb.append(MyBillsEntityDataFactory2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            String country = Locale.getDefault().getCountry();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("locale.default.country = ");
            sb2.append(country);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return country;
        }
        return MyBillsEntityDataFactory2;
    }

    public static String MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("The country code of null is unexpected.");
            return Region.Global.name();
        } else if ("CN".equalsIgnoreCase(str)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("The country code of CN is unexpected.");
            return "China";
        } else {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                HashMap hashMap = new HashMap();
                KClassImpl$Data$declaredNonStaticMembers$2 = hashMap;
                hashMap.put("FI", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("SE", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("NO", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("FO", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("EE", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("LV", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put(Condition.MATCH_TYPE_LESS_THAN, Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("BY", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("MD", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("UA", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("PL", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("CZ", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("SK", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("HU", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("DE", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("AT", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("CH", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("LI", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("GB", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("IE", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("NL", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("BE", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("LU", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("FR", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("RO", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("BG", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("RS", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("MK", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("AL", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("GR", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("SI", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("HR", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("IT", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("SM", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("MT", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("ES", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("PT", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("AD", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("CY", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("DK", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("IS", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("EL", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("UK", Region.Europe);
                KClassImpl$Data$declaredNonStaticMembers$2.put("RU", Region.Russia);
                KClassImpl$Data$declaredNonStaticMembers$2.put("IN", Region.India);
            }
            Region region = KClassImpl$Data$declaredNonStaticMembers$2.get(str.toUpperCase());
            if (region == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unmatched country code: ");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                region = Region.Global;
            }
            return region.name();
        }
    }
}
