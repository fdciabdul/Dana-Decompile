package com.xiaomi.channel.commonutils.android;

/* loaded from: classes8.dex */
public class i {
    public static String MyBillsEntityDataFactory(String str, String str2) {
        try {
            return (String) j.PlaceComponentResult(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("SystemProperties.get: ");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return str2;
        }
    }
}
