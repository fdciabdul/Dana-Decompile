package com.uc.crashsdk.a;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.google.common.base.Ascii;
import com.uc.crashsdk.p;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7709a = true;
    private static final Object b = new Object();
    private static boolean c = false;
    private static String d = "hsdk";
    private static String e = "alid ";
    private static String f;

    public static byte[] c() {
        return new byte[]{6, 0, Ascii.ETB, 8};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String f() {
        f = null;
        return null;
    }

    public static void a() {
        i.a(0, new g(), 55000L);
    }

    public static String b() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("inv");
            sb.append(e);
            sb.append("cras");
            sb.append(d);
            return sb.toString();
        } catch (Throwable th) {
            a.a(th, true);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(boolean r15) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.f.b(boolean):boolean");
    }

    private static String h() {
        byte[] bArr;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, p.e());
        a(sb, "pkgname", com.uc.crashsdk.a.f7699a);
        a(sb, SemanticAttributes.MessagingOperationValues.PROCESS, com.uc.crashsdk.f.d());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, H5GetLogInfoBridge.RESULT_OS, "android");
        String obj = sb.toString();
        byte[] bArr3 = new byte[16];
        e.a(bArr3, 0, k.d());
        e.a(bArr3, 4, e.c());
        e.a(bArr3, 8, c());
        e.a(bArr3, 12, com.uc.crashsdk.a.c());
        try {
            bArr = e.a(obj.getBytes(), bArr3, true);
        } catch (Throwable th) {
            a.a(th, false);
            bArr = null;
        }
        if (bArr == null || (a2 = e.a("https://woodpecker.uc.cn/api/crashsdk/validate", bArr)) == null) {
            return null;
        }
        try {
            bArr2 = e.a(a2, bArr3, false);
        } catch (Throwable th2) {
            a.a(th2, false);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }

    public static boolean d() {
        try {
            b(true);
        } catch (Throwable unused) {
        }
        return f7709a;
    }
}
