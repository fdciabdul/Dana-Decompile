package com.alipay.alipaysecuritysdk.apdid.d;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.g.c;
import com.alipay.alipaysecuritysdk.apdid.g.e;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f6855a;

    public a(Context context) {
        this.f6855a = context;
    }

    public static String a(Context context, String str) {
        try {
            String a2 = e.a(str);
            if (com.alipay.alipaysecuritysdk.common.e.e.c(a2)) {
                String a3 = c.a(context, str);
                if (com.alipay.alipaysecuritysdk.common.e.e.c(a3)) {
                    return "";
                }
                e.a(str, a3);
                return a3;
            }
            return a2;
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
            return "";
        }
    }

    public static String a(Context context) {
        try {
            String b = e.b();
            if (com.alipay.alipaysecuritysdk.common.e.e.c(b)) {
                com.alipay.alipaysecuritysdk.apdid.g.a.a c = com.alipay.alipaysecuritysdk.apdid.g.a.c(context);
                if (c != null) {
                    e.a(c);
                    String str = c.f6859a;
                    return com.alipay.alipaysecuritysdk.common.e.e.d(str) ? str : "";
                }
                return "";
            }
            return b;
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0109, code lost:
    
        if (com.alipay.alipaysecuritysdk.common.e.e.c(a(r2.f6856a)) == false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff A[Catch: all -> 0x029d, Exception -> 0x029f, TryCatch #0 {Exception -> 0x029f, blocks: (B:4:0x0002, B:6:0x0014, B:8:0x001a, B:9:0x002e, B:11:0x0034, B:16:0x0042, B:17:0x0047, B:26:0x0089, B:55:0x010e, B:60:0x013c, B:62:0x0144, B:63:0x0149, B:65:0x0159, B:88:0x0259, B:92:0x0274, B:66:0x0164, B:68:0x016b, B:70:0x0176, B:72:0x017d, B:73:0x0186, B:75:0x018c, B:77:0x0202, B:79:0x020c, B:81:0x0214, B:83:0x0224, B:85:0x022e, B:87:0x0236, B:86:0x0232, B:80:0x0210, B:29:0x009f, B:31:0x00b3, B:34:0x00be, B:36:0x00c4, B:39:0x00cf, B:42:0x00d8, B:45:0x00e5, B:48:0x00f2, B:51:0x00ff, B:20:0x0077), top: B:103:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0144 A[Catch: all -> 0x029d, Exception -> 0x029f, TryCatch #0 {Exception -> 0x029f, blocks: (B:4:0x0002, B:6:0x0014, B:8:0x001a, B:9:0x002e, B:11:0x0034, B:16:0x0042, B:17:0x0047, B:26:0x0089, B:55:0x010e, B:60:0x013c, B:62:0x0144, B:63:0x0149, B:65:0x0159, B:88:0x0259, B:92:0x0274, B:66:0x0164, B:68:0x016b, B:70:0x0176, B:72:0x017d, B:73:0x0186, B:75:0x018c, B:77:0x0202, B:79:0x020c, B:81:0x0214, B:83:0x0224, B:85:0x022e, B:87:0x0236, B:86:0x0232, B:80:0x0210, B:29:0x009f, B:31:0x00b3, B:34:0x00be, B:36:0x00c4, B:39:0x00cf, B:42:0x00d8, B:45:0x00e5, B:48:0x00f2, B:51:0x00ff, B:20:0x0077), top: B:103:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0159 A[Catch: all -> 0x029d, Exception -> 0x029f, TryCatch #0 {Exception -> 0x029f, blocks: (B:4:0x0002, B:6:0x0014, B:8:0x001a, B:9:0x002e, B:11:0x0034, B:16:0x0042, B:17:0x0047, B:26:0x0089, B:55:0x010e, B:60:0x013c, B:62:0x0144, B:63:0x0149, B:65:0x0159, B:88:0x0259, B:92:0x0274, B:66:0x0164, B:68:0x016b, B:70:0x0176, B:72:0x017d, B:73:0x0186, B:75:0x018c, B:77:0x0202, B:79:0x020c, B:81:0x0214, B:83:0x0224, B:85:0x022e, B:87:0x0236, B:86:0x0232, B:80:0x0210, B:29:0x009f, B:31:0x00b3, B:34:0x00be, B:36:0x00c4, B:39:0x00cf, B:42:0x00d8, B:45:0x00e5, B:48:0x00f2, B:51:0x00ff, B:20:0x0077), top: B:103:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0164 A[Catch: all -> 0x029d, Exception -> 0x029f, TryCatch #0 {Exception -> 0x029f, blocks: (B:4:0x0002, B:6:0x0014, B:8:0x001a, B:9:0x002e, B:11:0x0034, B:16:0x0042, B:17:0x0047, B:26:0x0089, B:55:0x010e, B:60:0x013c, B:62:0x0144, B:63:0x0149, B:65:0x0159, B:88:0x0259, B:92:0x0274, B:66:0x0164, B:68:0x016b, B:70:0x0176, B:72:0x017d, B:73:0x0186, B:75:0x018c, B:77:0x0202, B:79:0x020c, B:81:0x0214, B:83:0x0224, B:85:0x022e, B:87:0x0236, B:86:0x0232, B:80:0x0210, B:29:0x009f, B:31:0x00b3, B:34:0x00be, B:36:0x00c4, B:39:0x00cf, B:42:0x00d8, B:45:0x00e5, B:48:0x00f2, B:51:0x00ff, B:20:0x0077), top: B:103:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.d.a.a(java.util.Map, boolean):int");
    }
}
