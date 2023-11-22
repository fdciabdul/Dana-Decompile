package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f6803a = {"armeabi", "armeabi-v7a", ResourceAttributes.HostArchValues.X86, "arm64-v8a", "x86_64"};
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g = false;

    public static String a(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String a2 = a(classLoader, str, true);
        return a2 == null ? a(classLoader, str, false) : a2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        if (classLoader != null) {
            try {
                Method method = z ? classLoader.getClass().getMethod("findLibrary", String.class) : classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (method == null) {
                    return null;
                }
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                Object invoke = method.invoke(classLoader, str);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if ((r3.applicationInfo.flags & 128) != 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3) {
        /*
            boolean r0 = com.alibaba.wireless.security.framework.utils.f.b
            if (r0 == 0) goto L28
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            r1 = 1
            r2 = 0
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L23
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r2)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto L23
            android.content.pm.ApplicationInfo r0 = r3.applicationInfo     // Catch: java.lang.Throwable -> L23
            int r0 = r0.flags     // Catch: java.lang.Throwable -> L23
            r0 = r0 & r1
            if (r0 == 0) goto L23
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch: java.lang.Throwable -> L23
            int r3 = r3.flags     // Catch: java.lang.Throwable -> L23
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L24
        L23:
            r1 = 0
        L24:
            com.alibaba.wireless.security.framework.utils.f.c = r1
            com.alibaba.wireless.security.framework.utils.f.b = r2
        L28:
            boolean r3 = com.alibaba.wireless.security.framework.utils.f.c
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.a(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static boolean a(String str, String str2, File file) {
        ZipFile zipFile;
        boolean z;
        ZipFile zipFile2 = null;
        int i = 0;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    try {
                        String[] strArr = f6803a;
                        int length = strArr.length;
                        z = 0;
                        while (i < length) {
                            try {
                                String str3 = strArr[i];
                                StringBuilder sb = new StringBuilder();
                                sb.append("lib");
                                sb.append(File.separator);
                                sb.append(str3);
                                sb.append(File.separator);
                                sb.append(str2);
                                ZipEntry entry = zipFile.getEntry(sb.toString());
                                if (entry != null && entry.getSize() != 0) {
                                    z = a(zipFile, entry, file);
                                }
                                i++;
                                z = z;
                            } catch (IOException e2) {
                                e = e2;
                                zipFile2 = zipFile;
                                i = z ? 1 : 0;
                                a.a("", e);
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                z = i;
                                zipFile2 = zipFile2;
                                return z;
                            }
                        }
                        try {
                            zipFile.close();
                            zipFile2 = length;
                            z = z;
                        } catch (IOException unused2) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    zipFile2 = zipFile;
                }
            } catch (IOException e4) {
                e = e4;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.zip.ZipFile r8, java.util.zip.ZipEntry r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    public static boolean b(Context context) {
        boolean z;
        PackageInfo packageInfo;
        if (d) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                if ((packageInfo.applicationInfo.flags & 128) != 0) {
                    z = true;
                    e = z;
                    d = false;
                }
            }
            z = false;
            e = z;
            d = false;
        }
        return e;
    }

    public static boolean c(Context context) {
        if (f) {
            try {
                String d2 = d(context);
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageName);
                    sb.append(":fore");
                    packageName = sb.toString();
                }
                g = d2.equals(packageName);
                f = false;
            } catch (Exception unused) {
            }
        }
        return g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r1.processName == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r3) {
        /*
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L2d
            java.lang.String r1 = "activity"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L2d
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3     // Catch: java.lang.Throwable -> L2d
            java.util.List r3 = r3.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2d
        L16:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L2d
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L2d
            android.app.ActivityManager$RunningAppProcessInfo r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1     // Catch: java.lang.Throwable -> L2d
            int r2 = r1.pid     // Catch: java.lang.Throwable -> L2d
            if (r2 != r0) goto L16
            java.lang.String r3 = r1.processName     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L2d
            java.lang.String r3 = r1.processName     // Catch: java.lang.Throwable -> L2d
            goto L2f
        L2d:
            java.lang.String r3 = ""
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.d(android.content.Context):java.lang.String");
    }
}
