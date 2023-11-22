package fsimpl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.ArrayList;

/* renamed from: fsimpl.o  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0365o {
    public static final byte[] getAuthRequestContext = {95, 98, 60, -42, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int PlaceComponentResult = 223;

    private static int a(Context context, fi fiVar) {
        bQ.a(fiVar);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        bQ.a(fiVar, (short) activityManager.getMemoryClass());
        bQ.b(fiVar, memoryInfo.threshold);
        bQ.a(fiVar, memoryInfo.totalMem);
        return bQ.b(fiVar);
    }

    public static int a(Context context, fi fiVar, bG bGVar) {
        int a2 = a(fiVar, a(context));
        int a3 = a(fiVar, context.getPackageName());
        int c = c(context, fiVar);
        int a4 = a(context, fiVar);
        int b = b(fiVar);
        int a5 = a(fiVar);
        int b2 = b(context, fiVar);
        int c2 = c(fiVar);
        int e = e(fiVar);
        byte b3 = bGVar.u() > 0 ? (byte) 2 : (byte) 1;
        bT.a(fiVar);
        bT.a(fiVar, a3);
        bT.b(fiVar, a5);
        bT.c(fiVar, a4);
        bT.d(fiVar, b);
        bT.e(fiVar, c);
        bT.f(fiVar, b2);
        bT.g(fiVar, c2);
        bT.h(fiVar, a2);
        bT.i(fiVar, e);
        bT.a(fiVar, b3);
        return bT.b(fiVar);
    }

    private static int a(fi fiVar) {
        int a2 = a(fiVar, Build.BOARD);
        int a3 = a(fiVar, Build.BRAND);
        int a4 = a(fiVar, Build.DEVICE);
        int a5 = a(fiVar, Build.DISPLAY);
        int a6 = a(fiVar, Build.HARDWARE);
        int a7 = a(fiVar, Build.ID);
        int a8 = a(fiVar, Build.MANUFACTURER);
        int a9 = a(fiVar, Build.MODEL);
        int a10 = a(fiVar, Build.PRODUCT);
        int a11 = a(fiVar, Build.VERSION.CODENAME);
        int a12 = a(fiVar, Build.VERSION.INCREMENTAL);
        int a13 = a(fiVar, Build.VERSION.RELEASE);
        int d = d(fiVar);
        bR.a(fiVar);
        bR.e(fiVar, a2);
        bR.g(fiVar, a3);
        bR.d(fiVar, a4);
        bR.b(fiVar, a5);
        bR.i(fiVar, a6);
        bR.a(fiVar, a7);
        bR.f(fiVar, a8);
        bR.h(fiVar, a9);
        bR.c(fiVar, a10);
        bR.m(fiVar, a11);
        bR.j(fiVar, a12);
        bR.k(fiVar, a13);
        bR.l(fiVar, Build.VERSION.SDK_INT);
        bR.n(fiVar, d);
        return bR.b(fiVar);
    }

    private static int a(fi fiVar, Class cls, String str) {
        try {
            Object obj = cls.getField(str).get(null);
            if (obj == null) {
                return 0;
            }
            return a(fiVar, obj.toString());
        } catch (NoSuchFieldException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field ");
            sb.append(str);
            sb.append(" not found on ");
            sb.append(cls);
            Log.w(sb.toString());
            return 0;
        } catch (Throwable th) {
            cS.a("Error reading static field", th);
            return 0;
        }
    }

    public static int a(fi fiVar, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return fiVar.a(str.trim());
    }

    public static int a(fi fiVar, boolean z, bG bGVar) {
        ArrayList arrayList = new ArrayList(2);
        if (z) {
            arrayList.add((byte) 0);
        }
        if (bGVar.G()) {
            arrayList.add((byte) 1);
        }
        int size = arrayList.size();
        if (size <= 0) {
            return 0;
        }
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return C0299cw.a(fiVar, bArr);
    }

    private static Class a(String str) {
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".BuildConfig");
            String obj = sb.toString();
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trying to find build config at ");
                sb2.append(obj);
                Log.d(sb2.toString());
                Class<?> cls = Class.forName(obj);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Found build config at ");
                sb3.append(obj);
                Log.d(sb3.toString());
                return cls;
            } catch (ClassNotFoundException unused) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Did not find build config at ");
                sb4.append(obj);
                Log.d(sb4.toString());
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf <= 0) {
                    return null;
                }
                str = str.substring(0, lastIndexOf);
            }
        }
    }

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            byte b = (byte) (PlaceComponentResult & 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            f(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[41];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            f(b3, b4, b4, objArr2);
            CharSequence applicationLabel = packageManager.getApplicationLabel((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null));
            return applicationLabel != null ? applicationLabel.toString() : "";
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static int b(Context context, fi fiVar) {
        String packageName = context.getPackageName();
        Class a2 = a(packageName);
        if (a2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to find ");
            sb.append(packageName);
            sb.append(".BuildConfig");
            Log.w(sb.toString());
            return 0;
        }
        try {
            int a3 = a(fiVar, a2, "BUILD_TYPE");
            int a4 = a(fiVar, a2, "FLAVOR");
            if (a3 == 0 && a4 == 0) {
                return 0;
            }
            bO.a(fiVar);
            bO.a(fiVar, a3);
            bO.b(fiVar, a4);
            return bO.b(fiVar);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to find ");
            sb2.append(packageName);
            sb2.append(".BuildConfig");
            cS.a(sb2.toString(), th);
            return 0;
        }
    }

    private static int b(fi fiVar) {
        PackageInfo a2 = cZ.a();
        int a3 = a(fiVar, a2.versionName);
        bS.a(fiVar);
        bS.a(fiVar, a3);
        bS.b(fiVar, cZ.a(a2));
        return bS.b(fiVar);
    }

    private static int c(Context context, fi fiVar) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            systemAvailableFeatures = new FeatureInfo[0];
        }
        int[] iArr = new int[systemAvailableFeatures.length];
        for (int i = 0; i < systemAvailableFeatures.length; i++) {
            String str = systemAvailableFeatures[i].name;
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("GL:");
                sb.append(systemAvailableFeatures[i].reqGlEsVersion);
                str = sb.toString();
            }
            iArr[i] = a(fiVar, str);
        }
        return bT.a(fiVar, iArr);
    }

    private static int c(fi fiVar) {
        DisplayMetrics a2 = eD.a();
        if (a2 == null) {
            return 0;
        }
        bP.a(fiVar);
        bP.a(fiVar, a2.density);
        bP.a(fiVar, a2.densityDpi);
        bP.c(fiVar, C0300cx.a(fiVar, a2.xdpi, a2.ydpi));
        bP.b(fiVar, a2.scaledDensity);
        bP.b(fiVar, C0301cy.a(fiVar, a2.widthPixels, a2.heightPixels));
        return bP.b(fiVar);
    }

    private static int d(fi fiVar) {
        String[] strArr = Build.SUPPORTED_ABIS;
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = a(fiVar, strArr[i]);
        }
        return bR.a(fiVar, iArr);
    }

    private static int e(fi fiVar) {
        ArrayList arrayList = new ArrayList();
        if (C0256bg.e()) {
            arrayList.add((byte) 0);
        }
        if (C0256bg.f()) {
            arrayList.add((byte) 2);
        }
        if (C0256bg.g()) {
            arrayList.add((byte) 3);
        }
        if (C0256bg.h()) {
            arrayList.add((byte) 6);
        }
        if (C0256bg.a()) {
            arrayList.add((byte) 5);
        }
        byte[] bArr = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return bT.a(fiVar, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 5
            int r9 = r9 + 18
            int r7 = r7 * 6
            int r7 = 103 - r7
            byte[] r0 = fsimpl.C0365o.getAuthRequestContext
            int r8 = r8 * 22
            int r8 = 26 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L34
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L34:
            int r8 = r8 + r7
            int r7 = r8 + (-8)
            int r8 = r9 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0365o.f(byte, short, byte, java.lang.Object[]):void");
    }
}
