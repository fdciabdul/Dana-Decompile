package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.framework.utils.f;
import com.alibaba.wireless.security.open.SecException;
import com.google.common.base.Ascii;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class d implements ISGPluginManager {
    private Context c;
    public static final byte[] PlaceComponentResult = {116, -27, -60, 115, -15, 8, -16, 1, 4, 3, TarHeader.LF_BLK, -55, -14, -1, -8, 13, -11, -8, 68, -23, -46, -1, -8, 13, -21, 2, 2, -8, 1, 13, -4, Ascii.US, -39, -11, 0, -17, TarHeader.LF_LINK, -49, -2, 2, 1, 4, 0, -21, 9, -8, -1, 35, -39, 6, -11, -15, 8, -16, 1, 4, 3, TarHeader.LF_BLK, -55, -14, -1, -8, 13, -11, -8, 68, -68, 1, 61, -21, -49, -2, 2, 1, 4, 0, -21, 9, -8, -1, 35, -39, 6, -11};
    public static final int MyBillsEntityDataFactory = 2;
    private static String[] n = {"armeabi", "armeabi-v7a", ResourceAttributes.HostArchValues.X86, "arm64-v8a", "x86_64"};

    /* renamed from: o  reason: collision with root package name */
    private static String f6793o = null;
    private static volatile boolean p = true;
    private final HashMap<String, c> d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    HashMap<Class, Object> f6794a = new HashMap<>();
    private IRouterComponent e = null;
    com.alibaba.wireless.security.framework.utils.c b = null;
    private boolean f = true;
    private String g = null;
    private String h = null;
    private b i = null;
    private boolean j = false;
    private File k = null;
    private File l = null;
    private File m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        File f6797a;
        File b;
        File c;
        boolean d;

        public a(File file, File file2, File file3, boolean z) {
            this.f6797a = file;
            this.b = file2;
            this.c = file3;
            this.d = z;
        }
    }

    private int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    private PackageInfo a(String str, a aVar, String str2) throws SecException {
        PackageInfo packageInfo;
        try {
            packageInfo = this.c.getPackageManager().getPackageArchiveInfo(aVar.f6797a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(aVar.f6797a.getAbsolutePath());
            a(100043, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "getPackageArchiveInfo failed", obj, c(sb2.toString()), aVar.c != null ? c(aVar.c.getAbsolutePath()) : "", str2);
            if (aVar.f6797a.exists() && !b(aVar.f6797a)) {
                aVar.f6797a.delete();
            }
            packageInfo = null;
        }
        if (packageInfo == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("[");
            sb3.append(str2);
            sb3.append("]");
            a(100043, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "packageInfo == null", sb3.toString(), c(aVar.f6797a.getAbsolutePath()), aVar.c != null ? c(aVar.c.getAbsolutePath()) : "", c());
            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        }
        return packageInfo;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:195:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7 A[Catch: all -> 0x05f6, TRY_ENTER, TryCatch #7 {all -> 0x05f6, blocks: (B:3:0x004f, B:6:0x0065, B:8:0x006d, B:9:0x0077, B:10:0x007b, B:11:0x0087, B:12:0x008b, B:20:0x00a7, B:22:0x00ea, B:28:0x012a, B:31:0x013a, B:35:0x0155, B:37:0x0159, B:38:0x016b, B:40:0x0182, B:41:0x019e, B:39:0x016f, B:34:0x0142, B:42:0x019f, B:43:0x01a2, B:46:0x01ac, B:48:0x01ff, B:52:0x021a, B:54:0x021e, B:55:0x0230, B:57:0x0247, B:58:0x0262, B:56:0x0234, B:51:0x0207, B:62:0x0272, B:66:0x028d, B:68:0x0291, B:69:0x02a3, B:71:0x02ba, B:72:0x02d5, B:70:0x02a7, B:65:0x027a, B:73:0x02d6, B:75:0x0304, B:79:0x0338, B:81:0x033c, B:82:0x034e, B:84:0x0365, B:85:0x0381, B:83:0x0352, B:78:0x0325, B:86:0x0382, B:88:0x03ac, B:89:0x03af, B:91:0x03bb, B:93:0x03c1, B:94:0x03c3, B:96:0x03c7, B:98:0x03cd, B:99:0x03cf, B:101:0x03d7, B:102:0x03d9, B:105:0x03e3, B:107:0x03e7, B:111:0x03f3, B:113:0x043b, B:115:0x0441, B:117:0x0447, B:112:0x0424, B:158:0x0584, B:129:0x0480, B:131:0x04a1, B:135:0x04c5, B:137:0x04cb, B:138:0x04df, B:140:0x04f8, B:147:0x0522, B:149:0x0526, B:156:0x0582, B:151:0x052d, B:153:0x0531, B:154:0x0536, B:139:0x04e3, B:134:0x04ae, B:155:0x0537, B:164:0x0599, B:168:0x05b4, B:170:0x05b8, B:171:0x05ca, B:173:0x05e1, B:174:0x05f5, B:172:0x05ce, B:167:0x05a1, B:27:0x0117, B:141:0x0510, B:143:0x0514, B:144:0x0519, B:146:0x051f), top: B:192:0x004f, inners: #4, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0117 A[Catch: all -> 0x05f6, TRY_ENTER, TryCatch #7 {all -> 0x05f6, blocks: (B:3:0x004f, B:6:0x0065, B:8:0x006d, B:9:0x0077, B:10:0x007b, B:11:0x0087, B:12:0x008b, B:20:0x00a7, B:22:0x00ea, B:28:0x012a, B:31:0x013a, B:35:0x0155, B:37:0x0159, B:38:0x016b, B:40:0x0182, B:41:0x019e, B:39:0x016f, B:34:0x0142, B:42:0x019f, B:43:0x01a2, B:46:0x01ac, B:48:0x01ff, B:52:0x021a, B:54:0x021e, B:55:0x0230, B:57:0x0247, B:58:0x0262, B:56:0x0234, B:51:0x0207, B:62:0x0272, B:66:0x028d, B:68:0x0291, B:69:0x02a3, B:71:0x02ba, B:72:0x02d5, B:70:0x02a7, B:65:0x027a, B:73:0x02d6, B:75:0x0304, B:79:0x0338, B:81:0x033c, B:82:0x034e, B:84:0x0365, B:85:0x0381, B:83:0x0352, B:78:0x0325, B:86:0x0382, B:88:0x03ac, B:89:0x03af, B:91:0x03bb, B:93:0x03c1, B:94:0x03c3, B:96:0x03c7, B:98:0x03cd, B:99:0x03cf, B:101:0x03d7, B:102:0x03d9, B:105:0x03e3, B:107:0x03e7, B:111:0x03f3, B:113:0x043b, B:115:0x0441, B:117:0x0447, B:112:0x0424, B:158:0x0584, B:129:0x0480, B:131:0x04a1, B:135:0x04c5, B:137:0x04cb, B:138:0x04df, B:140:0x04f8, B:147:0x0522, B:149:0x0526, B:156:0x0582, B:151:0x052d, B:153:0x0531, B:154:0x0536, B:139:0x04e3, B:134:0x04ae, B:155:0x0537, B:164:0x0599, B:168:0x05b4, B:170:0x05b8, B:171:0x05ca, B:173:0x05e1, B:174:0x05f5, B:172:0x05ce, B:167:0x05a1, B:27:0x0117, B:141:0x0510, B:143:0x0514, B:144:0x0519, B:146:0x051f), top: B:192:0x004f, inners: #4, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013a A[Catch: all -> 0x05f6, TRY_ENTER, TryCatch #7 {all -> 0x05f6, blocks: (B:3:0x004f, B:6:0x0065, B:8:0x006d, B:9:0x0077, B:10:0x007b, B:11:0x0087, B:12:0x008b, B:20:0x00a7, B:22:0x00ea, B:28:0x012a, B:31:0x013a, B:35:0x0155, B:37:0x0159, B:38:0x016b, B:40:0x0182, B:41:0x019e, B:39:0x016f, B:34:0x0142, B:42:0x019f, B:43:0x01a2, B:46:0x01ac, B:48:0x01ff, B:52:0x021a, B:54:0x021e, B:55:0x0230, B:57:0x0247, B:58:0x0262, B:56:0x0234, B:51:0x0207, B:62:0x0272, B:66:0x028d, B:68:0x0291, B:69:0x02a3, B:71:0x02ba, B:72:0x02d5, B:70:0x02a7, B:65:0x027a, B:73:0x02d6, B:75:0x0304, B:79:0x0338, B:81:0x033c, B:82:0x034e, B:84:0x0365, B:85:0x0381, B:83:0x0352, B:78:0x0325, B:86:0x0382, B:88:0x03ac, B:89:0x03af, B:91:0x03bb, B:93:0x03c1, B:94:0x03c3, B:96:0x03c7, B:98:0x03cd, B:99:0x03cf, B:101:0x03d7, B:102:0x03d9, B:105:0x03e3, B:107:0x03e7, B:111:0x03f3, B:113:0x043b, B:115:0x0441, B:117:0x0447, B:112:0x0424, B:158:0x0584, B:129:0x0480, B:131:0x04a1, B:135:0x04c5, B:137:0x04cb, B:138:0x04df, B:140:0x04f8, B:147:0x0522, B:149:0x0526, B:156:0x0582, B:151:0x052d, B:153:0x0531, B:154:0x0536, B:139:0x04e3, B:134:0x04ae, B:155:0x0537, B:164:0x0599, B:168:0x05b4, B:170:0x05b8, B:171:0x05ca, B:173:0x05e1, B:174:0x05f5, B:172:0x05ce, B:167:0x05a1, B:27:0x0117, B:141:0x0510, B:143:0x0514, B:144:0x0519, B:146:0x051f), top: B:192:0x004f, inners: #4, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.c a(java.lang.String r41, com.alibaba.wireless.security.framework.d.a r42, android.content.Context r43, java.lang.String r44) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 1534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, com.alibaba.wireless.security.framework.d$a, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.c");
    }

    private File a(Context context) throws SecException {
        if (context == null) {
            a(100038, 116, "", "", "", "", "");
            throw new SecException(116);
        }
        String str = null;
        if (context != null) {
            try {
                try {
                    byte b = PlaceComponentResult[9];
                    byte b2 = (byte) (-PlaceComponentResult[12]);
                    Object[] objArr = new Object[1];
                    q(b, b2, (byte) (b2 | 33), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    q((byte) MyBillsEntityDataFactory, PlaceComponentResult[44], (byte) (-PlaceComponentResult[35]), objArr2);
                    Object invoke = cls.getMethod((String) objArr2[0], null).invoke(context, null);
                    Object[] objArr3 = new Object[1];
                    q(PlaceComponentResult[9], Ascii.EM, PlaceComponentResult[34], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b3 = PlaceComponentResult[34];
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    q(b3, b4, (byte) (b4 | Ascii.EM), objArr4);
                    String str2 = (String) cls2.getField((String) objArr4[0]).get(invoke);
                    if (str2 != null) {
                        File file = new File(str2);
                        if (file.exists()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(file.lastModified() / 1000);
                            str = sb.toString();
                        }
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e);
                a(100038, 115, "", sb2.toString(), "", "", "");
                throw new SecException(e, 115);
            }
        }
        if (str != null) {
            File dir = context.getDir("SGLib", 0);
            this.l = dir;
            if (dir == null || !dir.exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.l);
                a(100038, 109, "", sb3.toString(), "", "", "");
                throw new SecException(109);
            }
            String absolutePath = this.l.getAbsolutePath();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("app_");
            sb4.append(str);
            File file2 = new File(absolutePath, sb4.toString());
            if (!file2.exists()) {
                file2.mkdirs();
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (p && file2.exists()) {
                p = false;
                File file3 = this.l;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("app_");
                sb5.append(str);
                a(file3, sb5.toString());
            }
            if (file2.exists()) {
                return file2;
            }
            a(100038, 114, "", "", "", "", "");
            throw new SecException(114);
        }
        throw new SecException(115);
    }

    private File a(Context context, b bVar) {
        if (f.a(context) || bVar == null || bVar.b() == 0 || bVar.c() == null || bVar.c().length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.k.getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        sb.append(File.separator);
        sb.append(bVar.b());
        sb.append(File.separator);
        sb.append(bVar.c());
        File file = new File(sb.toString());
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private File a(String str) {
        if (this.g != null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sg");
        sb.append(str);
        String a2 = f.a(d.class.getClassLoader(), sb.toString());
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new File(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(java.lang.String r14, java.io.File r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(java.lang.String r11, java.io.File r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            r0 = 0
            if (r13 == 0) goto L43
            if (r14 == 0) goto L43
            java.lang.String r1 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
            com.alibaba.wireless.security.framework.utils.a.b(r1)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            java.io.File r11 = r10.a(r11, r12, r1, r14)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L3b
            r0 = r11
            goto L37
        L15:
            r12 = move-exception
            goto L1b
        L17:
            r11 = move-exception
            goto L3d
        L19:
            r12 = move-exception
            r1 = r0
        L1b:
            java.lang.String r14 = "getPluginFile throws exception"
            com.alibaba.wireless.security.framework.utils.a.a(r14, r12)     // Catch: java.lang.Throwable -> L3b
            r3 = 100047(0x186cf, float:1.40196E-40)
            r4 = 3
            java.lang.String r5 = r12.toString()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = r10.c(r13)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            r2 = r10
            r6 = r11
            r2.a(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L3a
        L37:
            r1.close()     // Catch: java.lang.Exception -> L3a
        L3a:
            return r0
        L3b:
            r11 = move-exception
            r0 = r1
        L3d:
            if (r0 == 0) goto L42
            r0.close()     // Catch: java.lang.Exception -> L42
        L42:
            throw r11
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    private File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        if (zipFile != null && str2 != null && (entry = zipFile.getEntry(str2)) != null && com.alibaba.wireless.security.framework.utils.b.a(entry.getName())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Plugin existed  in ");
            sb.append(entry.getName());
            com.alibaba.wireless.security.framework.utils.a.b(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("libsg");
            sb2.append(str);
            sb2.append("_inner");
            sb2.append(entry.getTime());
            sb2.append(".zip");
            File file2 = new File(file, sb2.toString());
            if ((file2.exists() && file2.length() == entry.getSize()) || f.a(zipFile, entry, file2)) {
                com.alibaba.wireless.security.framework.utils.a.b("Extract success");
                return file2;
            }
            com.alibaba.wireless.security.framework.utils.a.b("Extract failed!!");
        }
        return null;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            a(100042, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "Class.forName failed", sb.toString(), str, classLoader.toString(), "");
            cls = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    loadClassFromClassLoader( ");
        sb2.append(str);
        sb2.append(" ) used time: ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        sb2.append(" ms");
        com.alibaba.wireless.security.framework.utils.a.b(sb2.toString());
        return cls;
    }

    private String a(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    private void a() throws SecException {
        File a2 = a(this.c);
        this.k = a2;
        if (a2 != null) {
            Context context = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.k);
            sb.append(File.separator);
            sb.append("lock.lock");
            this.b = new com.alibaba.wireless.security.framework.utils.c(context, sb.toString());
            b b = b();
            this.i = b;
            this.m = a(this.c, b);
        }
    }

    private void a(int i, int i2, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        UserTrackMethodJniBridge.addUtRecord(sb.toString(), i2, 0, com.alibaba.wireless.security.open.initialize.c.a(), 0L, str, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                a(new File(file, str));
            }
        }
        file.delete();
    }

    private void a(final File file, final String str) {
        new Thread(new Runnable() { // from class: com.alibaba.wireless.security.framework.d.1
            @Override // java.lang.Runnable
            public void run() {
                File filesDir;
                File[] listFiles;
                File[] listFiles2;
                try {
                    File file2 = file;
                    if (file2 != null && file2.isDirectory() && (listFiles2 = file.listFiles()) != null && listFiles2.length > 0) {
                        for (File file3 : listFiles2) {
                            if (file3.isDirectory() && file3.getName().startsWith("app_") && !file3.getName().equals(str)) {
                                d.this.a(file3);
                            } else if (file3.getName().startsWith("libsg")) {
                                file3.delete();
                            }
                        }
                    }
                    if (d.this.c == null || (filesDir = d.this.c.getFilesDir()) == null || !filesDir.isDirectory() || (listFiles = filesDir.listFiles()) == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file4 : listFiles) {
                        if (file4.getName().startsWith("libsecuritysdk")) {
                            file4.delete();
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r17, java.io.File r18) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
    
        if (r19 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0136, code lost:
    
        if (r19 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0139, code lost:
    
        r14.b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013d, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r15, java.lang.String r16, java.io.File r17, java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, boolean z) throws SecException {
        if (str.trim().length() == 0) {
            return true;
        }
        String[] split = str.split(";");
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.length() != 0) {
                String[] split2 = trim.split(":");
                if (split2.length != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(z);
                    String obj = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "nameVersionPair.length != 2", trim, str2, obj, sb2.toString());
                    throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                }
                int indexOf = str2.indexOf(split2[0]);
                if (indexOf >= 0) {
                    int indexOf2 = str2.indexOf("(", indexOf);
                    int indexOf3 = str2.indexOf(")", indexOf);
                    if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(indexOf2);
                        String obj2 = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(indexOf3);
                        String obj3 = sb4.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(i);
                        a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", obj2, obj3, "", sb5.toString());
                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                    }
                    String substring = str2.substring(indexOf2 + 1, indexOf3);
                    if (a(substring, split2[1]) < 0) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("version ");
                        sb6.append(substring);
                        sb6.append(" of ");
                        sb6.append(split2[0]);
                        sb6.append(" is not meet the requirement: ");
                        sb6.append(split2[1]);
                        String obj4 = sb6.toString();
                        if (str2.length() != 0) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(obj4);
                            sb7.append(", depended by: ");
                            sb7.append(str2);
                            obj4 = sb7.toString();
                        }
                        String str3 = obj4;
                        if (!z) {
                            String str4 = split2[0];
                            String str5 = split2[1];
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(i);
                            a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, str4, str5, sb8.toString());
                        }
                        throw new SecException(str3, 113);
                    }
                } else {
                    c cVar = this.d.get(split2[0]);
                    if (cVar == null) {
                        try {
                            cVar = d(split2[0], str2, !z);
                            th = null;
                        } catch (Throwable th) {
                            th = th;
                        }
                        if (cVar == null) {
                            if (!z) {
                                if (th instanceof SecException) {
                                    throw th;
                                }
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append(th);
                                String obj5 = sb9.toString();
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append(i);
                                a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "throwable in loadPluginInner", obj5, str, str2, sb10.toString());
                                throw new SecException(str2, (int) SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                            }
                        }
                    }
                    if (a(cVar.getVersion(), split2[1]) < 0) {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("version ");
                        sb11.append(cVar.getVersion());
                        sb11.append(" of ");
                        sb11.append(split2[0]);
                        sb11.append(" is not meet the requirement: ");
                        sb11.append(split2[1]);
                        String obj6 = sb11.toString();
                        if (str2.length() != 0) {
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(obj6);
                            sb12.append(", depended by: ");
                            sb12.append(str2);
                            obj6 = sb12.toString();
                        }
                        if (!z) {
                            String version = cVar.getVersion();
                            String str6 = split2[0];
                            String str7 = split2[1];
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append(i);
                            a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", version, str6, str7, sb13.toString());
                        }
                        throw new SecException(obj6, 113);
                    }
                }
            }
        }
        return true;
    }

    private b b() {
        b a2;
        File file = new File(this.k, "update.config");
        File file2 = new File(this.k, "init.config");
        if (this.j) {
            a2 = b.a(file);
            if (a2 == null) {
                return b.a(file2);
            }
            try {
                this.b.a();
                file2.delete();
                file.renameTo(file2);
            } finally {
            }
        } else {
            try {
                this.b.a();
                a2 = b.a(file2);
            } finally {
            }
        }
        this.b.b();
        return a2;
    }

    private File b(String str) {
        String str2 = this.g;
        if (str2 == null) {
            try {
                Context context = this.c;
                try {
                    byte b = PlaceComponentResult[9];
                    byte b2 = (byte) (-PlaceComponentResult[12]);
                    Object[] objArr = new Object[1];
                    q(b, b2, (byte) (b2 | 33), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    q((byte) MyBillsEntityDataFactory, PlaceComponentResult[44], (byte) (-PlaceComponentResult[35]), objArr2);
                    str2 = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).nativeLibraryDir;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Exception unused) {
            }
        }
        if (str2 == null || str2.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(File.separator);
        sb.append("libsg");
        sb.append(str);
        sb.append(".so");
        File file = new File(sb.toString());
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private ClassLoader b(String str, String str2, boolean z) {
        if (!z) {
            try {
                this.b.a();
            } finally {
                if (!z) {
                    this.b.b();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Context context = this.c;
        try {
            byte b = PlaceComponentResult[9];
            byte b2 = (byte) (-PlaceComponentResult[12]);
            Object[] objArr = new Object[1];
            q(b, b2, (byte) (b2 | 33), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            q((byte) MyBillsEntityDataFactory, PlaceComponentResult[44], (byte) (-PlaceComponentResult[35]), objArr2);
            sb.append(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).nativeLibraryDir);
            sb.append(File.pathSeparator);
            sb.append(str2);
            String obj = sb.toString();
            if (this.g != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(File.pathSeparator);
                sb2.append(this.g);
                obj = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("add path to native classloader ");
                sb3.append(obj);
                com.alibaba.wireless.security.framework.utils.a.b(sb3.toString());
            }
            if (f6793o != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj);
                sb4.append(File.pathSeparator);
                Context context2 = this.c;
                try {
                    byte b3 = PlaceComponentResult[9];
                    byte b4 = (byte) (-PlaceComponentResult[12]);
                    Object[] objArr3 = new Object[1];
                    q(b3, b4, (byte) (b4 | 33), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    q((byte) MyBillsEntityDataFactory, PlaceComponentResult[44], (byte) (-PlaceComponentResult[35]), objArr4);
                    Object invoke = cls2.getMethod((String) objArr4[0], null).invoke(context2, null);
                    Object[] objArr5 = new Object[1];
                    q(PlaceComponentResult[9], Ascii.EM, PlaceComponentResult[34], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte b5 = PlaceComponentResult[34];
                    byte b6 = b5;
                    Object[] objArr6 = new Object[1];
                    q(b5, b6, (byte) (b6 | Ascii.EM), objArr6);
                    sb4.append((String) cls3.getField((String) objArr6[0]).get(invoke));
                    sb4.append("!/lib/");
                    sb4.append(f6793o);
                    obj = sb4.toString();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            return (Build.VERSION.SDK_INT < 21 || "6.0.1".equalsIgnoreCase(Build.VERSION.RELEASE)) ? new DexClassLoader(str, str2, obj, d.class.getClassLoader()) : new PathClassLoader(str, obj, d.class.getClassLoader());
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    private boolean b(File file) {
        try {
        } catch (Exception e) {
            com.alibaba.wireless.security.framework.utils.a.a("", e);
            a(100047, 0, e.toString(), file.getAbsolutePath(), "", "", "");
        }
        if (file.getParentFile().getCanonicalPath().equals(file.getCanonicalFile().getParentFile().getCanonicalPath())) {
            if (file.getName().equals(file.getCanonicalFile().getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean b(File file, File file2) {
        Method method;
        try {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod("symlink", String.class, String.class);
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField(H5GetLogInfoBridge.RESULT_OS);
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                method = obj.getClass().getMethod("symlink", String.class, String.class);
            }
            method.invoke(obj, file.getAbsolutePath(), file2.getAbsolutePath());
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("create symbolic link( ");
            sb.append(file2.getAbsolutePath());
            sb.append(" -> ");
            sb.append(file.getAbsolutePath());
            sb.append(" ) failed");
            com.alibaba.wireless.security.framework.utils.a.a(sb.toString(), e);
            String obj2 = e.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            a(100047, 1, obj2, absolutePath, absolutePath2, sb2.toString(), "");
            return false;
        }
    }

    private boolean b(String str, String str2) throws SecException {
        for (Map.Entry<String, c> entry : this.d.entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            String a2 = value.a("reversedependencies");
            if (a2 != null) {
                String[] split = a2.split(";");
                for (int i = 0; i < split.length; i++) {
                    String trim = split[i].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        if (split2.length != 2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append("(");
                            sb.append(str2);
                            sb.append(")");
                            String obj = sb.toString();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(key);
                            sb2.append("(");
                            sb2.append(value.getVersion());
                            sb2.append(")");
                            a(100041, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "nameVersionPair.length != 2", obj, sb2.toString(), c(value.getPluginPath()), a2);
                            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                        } else if (split2[0].equalsIgnoreCase(str) && a(str2, split2[1]) < 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("plugin ");
                            sb3.append(str);
                            sb3.append("(");
                            sb3.append(str2);
                            sb3.append(") is not meet the reverse dependency of ");
                            sb3.append(key);
                            sb3.append("(");
                            sb3.append(value.getVersion());
                            sb3.append("): ");
                            sb3.append(split2[0]);
                            sb3.append("(");
                            sb3.append(split2[1]);
                            sb3.append(")");
                            String obj2 = sb3.toString();
                            String obj3 = d.class.getClassLoader().toString();
                            String c = c(value.getPluginPath());
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(i);
                            a(100041, 117, obj2, obj3, c, a2, sb4.toString());
                            throw new SecException(obj2, 117);
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:19:0x0056, B:25:0x0067, B:28:0x006f, B:30:0x0075, B:32:0x0083, B:34:0x00af, B:35:0x00b6, B:37:0x00bb, B:40:0x00c3, B:47:0x00d3, B:49:0x00dd, B:50:0x00e5, B:52:0x00eb, B:53:0x00f2, B:55:0x011b, B:57:0x0121, B:59:0x0127, B:60:0x012d, B:62:0x0136, B:63:0x013c, B:65:0x0165, B:69:0x0177, B:67:0x0171), top: B:80:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:19:0x0056, B:25:0x0067, B:28:0x006f, B:30:0x0075, B:32:0x0083, B:34:0x00af, B:35:0x00b6, B:37:0x00bb, B:40:0x00c3, B:47:0x00d3, B:49:0x00dd, B:50:0x00e5, B:52:0x00eb, B:53:0x00f2, B:55:0x011b, B:57:0x0121, B:59:0x0127, B:60:0x012d, B:62:0x0136, B:63:0x013c, B:65:0x0165, B:69:0x0177, B:67:0x0171), top: B:80:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.d.a c(java.lang.String r17, java.lang.String r18, boolean r19) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.c(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.d$a");
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        File file = this.k;
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                sb.append("[");
                File[] listFiles = file.listFiles();
                for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                    File file2 = listFiles[i];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append("(");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(b(file2));
                        sb2.append(" , ");
                        sb.append(sb2.toString());
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                }
                sb.append("]");
            } catch (Throwable unused) {
            }
        } else {
            sb.append("not exists!");
        }
        return sb.toString();
    }

    private String c(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (b(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Exception unused) {
            }
        }
        sb.append('[');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("exists:");
        sb2.append(file.exists());
        sb2.append(",");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("size:");
        sb3.append(file.length());
        sb3.append(",");
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("canRead:");
        sb4.append(file.canRead());
        sb4.append(",");
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("canWrite:");
        sb5.append(file.canWrite());
        sb5.append(",");
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("totalSpace:");
        sb6.append(file.getTotalSpace());
        sb6.append(",");
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("freeSpace:");
        sb7.append(file.getFreeSpace());
        sb7.append(",");
        sb.append(sb7.toString());
        sb.append(']');
        return sb.toString();
    }

    private boolean c(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null && absolutePath.length() > 0) {
                    if (!f.a(this.c)) {
                        if (!absolutePath.startsWith("/system/")) {
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Exception e) {
            com.alibaba.wireless.security.framework.utils.a.a("", e);
            a(100046, 0, e.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        r11 = new java.lang.StringBuilder();
        r11.append("plugin ");
        r11.append(r9);
        r11.append(" not existed");
        r11 = r11.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0128, code lost:
    
        if (r10.length() == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r11);
        r0.append(", depended by ");
        r0.append(r10);
        r11 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x013e, code lost:
    
        a(100044, 110, "", r9, r10, "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0156, code lost:
    
        throw new com.alibaba.wireless.security.open.SecException(r11, 110);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.ISGPluginInfo d(java.lang.String r9, java.lang.String r10, boolean r11) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.d(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.ISGPluginInfo");
    }

    private File d(File file) {
        if (file.exists() && file.isDirectory() && this.j) {
            File file2 = new File(file, "main");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return file2.exists() ? file2 : file;
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void q(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 51 - r8
            int r6 = r6 * 6
            int r6 = 115 - r6
            int r7 = r7 + 9
            byte[] r0 = com.alibaba.wireless.security.framework.d.PlaceComponentResult
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-2)
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.q(short, byte, byte, java.lang.Object[]):void");
    }

    public void a(Context context, String str, String str2, boolean z, Object... objArr) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = context;
        this.h = str;
        this.j = f.c(context);
        this.f = z;
        UserTrackMethodJniBridge.init(this.c);
        if (str2 != null && !str2.isEmpty()) {
            this.g = str2;
        }
        try {
            a();
        } catch (SecException unused) {
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public <T> T getInterface(Class<T> cls) throws SecException {
        synchronized (this) {
            Object obj = this.f6794a.get(cls);
            if (obj != null) {
                return cls.cast(obj);
            }
            String str = null;
            b bVar = this.i;
            if (bVar != null && ((str = bVar.d()) == null || str.length() == 0)) {
                str = this.i.a(cls.getName());
            }
            if (str == null || str.length() == 0) {
                str = a((Class<?>) cls);
            }
            if (str == null || str.length() == 0) {
                throw new SecException(150);
            }
            ISGPluginInfo pluginInfo = getPluginInfo(str);
            if (pluginInfo != null) {
                Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
                if (obj2 != null) {
                    this.f6794a.put(cls, obj2);
                    return cls.cast(obj2);
                }
                String name = cls.getName();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                sb.append(pluginInfo.getVersion());
                sb.append(")");
                a(100045, 112, "", name, sb.toString(), c(pluginInfo.getPluginPath()), "");
                throw new SecException(112);
            }
            throw new SecException(110);
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public String getMainPluginName() {
        return "main";
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        return d(str, "", true);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public IRouterComponent getRouter() {
        return this.e;
    }
}
