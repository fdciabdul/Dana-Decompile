package com.alipay.mobile.security.bio.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StatFs;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DeviceUtil {
    public static final byte[] MyBillsEntityDataFactory = {3, -83, -69, 19, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 19;

    public static int getProcessorNum() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.alipay.mobile.security.bio.utils.DeviceUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r4 != null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getMemorySize() {
        /*
            r0 = 0
            r1 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L30
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r0 = r4.readLine()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L29
            java.lang.String r5 = "\\s+"
            java.lang.String[] r0 = r0.split(r5)     // Catch: java.lang.Throwable -> L2e
            r5 = 1
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L2e
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L2e
            r5 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r5
            r1 = r0
        L29:
            r3.close()     // Catch: java.lang.Throwable -> L3b
            goto L3b
        L2d:
            r4 = r0
        L2e:
            r0 = r3
            goto L31
        L30:
            r4 = r0
        L31:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Throwable -> L37
            goto L38
        L37:
        L38:
            if (r4 != 0) goto L3b
            goto L3e
        L3b:
            r4.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.utils.DeviceUtil.getMemorySize():long");
    }

    public static long getTotalStorageSize(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long getAvailableStorageSize(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean isDebug(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 16384).flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #0 {Exception -> 0x0056, blocks: (B:3:0x0002, B:7:0x0025, B:9:0x002d, B:10:0x004a), top: B:16:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:3:0x0002, B:7:0x0025, B:9:0x002d, B:10:0x004a), top: B:16:0x0002 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004c -> B:12:0x004f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getUtdid(android.content.Context r14) {
        /*
            java.lang.String r0 = "UTDID"
            java.lang.String r1 = "com.ut.device.UTDevice"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L56
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L56
            byte[] r4 = com.alipay.mobile.security.bio.utils.DeviceUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L56
            r5 = 3
            r6 = 23
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> L56
            r8 = 97
            r9 = 0
            r5 = r4
            if (r4 != 0) goto L1f
            r10 = r7
            r7 = 3
            r11 = 0
            r12 = 23
            r4 = r3
            goto L4f
        L1f:
            r8 = r7
            r7 = 3
            r10 = 97
            r11 = 0
            r4 = r3
        L25:
            byte r12 = (byte) r10     // Catch: java.lang.Exception -> L56
            r8[r11] = r12     // Catch: java.lang.Exception -> L56
            int r7 = r7 + r2
            int r11 = r11 + 1
            if (r11 != r6) goto L4a
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L56
            r5.<init>(r8, r9)     // Catch: java.lang.Exception -> L56
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L56
            r3[r9] = r5     // Catch: java.lang.Exception -> L56
            java.lang.String r3 = "getUtdid"
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Exception -> L56
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L56
            r2[r9] = r14     // Catch: java.lang.Exception -> L56
            r14 = 0
            java.lang.Object r14 = r1.invoke(r14, r2)     // Catch: java.lang.Exception -> L56
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.Exception -> L56
            goto L5d
        L4a:
            r12 = r5[r7]     // Catch: java.lang.Exception -> L56
            r13 = r10
            r10 = r8
            r8 = r13
        L4f:
            int r8 = r8 + r12
            int r8 = r8 + (-8)
            r13 = r10
            r10 = r8
            r8 = r13
            goto L25
        L56:
            java.lang.String r14 = "[*] UTDID error。"
            com.fullstory.instrumentation.InstrumentInjector.log_i(r0, r14)
            java.lang.String r14 = ""
        L5d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[*] UTDID:"
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            com.fullstory.instrumentation.InstrumentInjector.log_i(r0, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.utils.DeviceUtil.getUtdid(android.content.Context):java.lang.String");
    }
}
