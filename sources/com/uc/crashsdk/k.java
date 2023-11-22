package com.uc.crashsdk;

import android.util.SparseArray;
import com.uc.crashsdk.b;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7731a = new Object();
    private static SparseArray<String> b = new SparseArray<>();
    private static boolean c = false;
    private static volatile Object d = new Object();

    public static void a(int i) {
        a(i, 1);
    }

    public static void a(int i, int i2) {
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder("Add stat for type ");
            sb.append(i);
            sb.append(" with count 0!");
            com.uc.crashsdk.a.c.c(sb.toString());
            return;
        }
        String c2 = b.c();
        a(c2, new l(c2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(int i, int i2) {
        try {
            b.m();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        try {
            String b2 = b(i);
            if (b2 == null) {
                StringBuilder sb = new StringBuilder("Stat type not exists: ");
                sb.append(i);
                com.uc.crashsdk.a.c.a("crashsdk", sb.toString());
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.a.a(th2, false);
            }
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.h.a(a2)) {
                if (a2 == null) {
                    a2 = new StringBuffer();
                }
                StringBuilder sb2 = new StringBuilder("[");
                sb2.append(f.d());
                sb2.append("]\n");
                a2.append(sb2.toString());
            }
            a(a2, b2, a(a2, b2) + i2);
            return a(file, a2);
        } catch (Exception e) {
            com.uc.crashsdk.a.a.a(e, false);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0041 -> B:38:0x0044). Please submit an issue!!! */
    private static StringBuffer a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] d2 = d();
        if (d2 == null) {
            com.uc.crashsdk.a.c.a("crashsdk", "readCrashStatData alloc buffer failed!");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                try {
                    fileReader = new FileReader(file);
                    try {
                        int read = fileReader.read(d2);
                        if (read > 0) {
                            stringBuffer.append(d2, 0, read);
                        }
                        fileReader.close();
                    } catch (Exception e) {
                        e = e;
                        fileReader2 = fileReader;
                        com.uc.crashsdk.a.a.a(e, false);
                        if (fileReader2 != null) {
                            fileReader2.close();
                        }
                        return stringBuffer;
                    } catch (Throwable th) {
                        th = th;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e2) {
                                com.uc.crashsdk.a.a.a(e2, false);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                com.uc.crashsdk.a.a.a(e4, false);
            }
            return stringBuffer;
        } catch (Throwable th2) {
            th = th2;
            fileReader = fileReader2;
        }
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" line not contain '='!");
            com.uc.crashsdk.a.c.c(sb.toString());
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e) {
            com.uc.crashsdk.a.a.a(e, false);
            return 0;
        }
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append("\n");
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf("\n", indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        sb.append(String.valueOf(i));
        stringBuffer.replace(indexOf, indexOf2, sb.toString());
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
                try {
                    String obj = stringBuffer.toString();
                    fileWriter.write(obj, 0, obj.length());
                    try {
                        fileWriter.close();
                    } catch (Exception e) {
                        com.uc.crashsdk.a.a.a(e, false);
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    com.uc.crashsdk.a.a.a(e, false);
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                            return false;
                        } catch (Exception e3) {
                            com.uc.crashsdk.a.a.a(e3, false);
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                            com.uc.crashsdk.a.a.a(e4, false);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter = fileWriter2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str) {
        e();
        synchronized (b) {
            File file = new File(str);
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.h.a(a2)) {
                return false;
            }
            int indexOf = a2.indexOf("[");
            if (indexOf < 0) {
                com.uc.crashsdk.a.c.a("crashsdk", "Can not found process name start!");
                return false;
            }
            boolean z = true;
            int i = indexOf + 1;
            int indexOf2 = a2.indexOf("]", i);
            if (indexOf2 < 0) {
                com.uc.crashsdk.a.c.a("crashsdk", "Can not found process name end!");
                return false;
            }
            String substring = a2.substring(i, indexOf2);
            boolean z2 = false;
            for (int i2 = 0; i2 < b.size(); i2++) {
                try {
                    int keyAt = b.keyAt(i2);
                    String str2 = b.get(keyAt);
                    int a3 = a(a2, str2);
                    if (a3 > 0) {
                        boolean a4 = d.a(substring, keyAt, a3);
                        com.uc.crashsdk.a.k.a(substring, keyAt, a3);
                        if (a4 || p.I()) {
                            try {
                                a(a2, str2, 0);
                                StringBuilder sb = new StringBuilder("Clear stat item: ");
                                sb.append(keyAt);
                                com.uc.crashsdk.a.c.b(sb.toString());
                                z2 = true;
                            } catch (Throwable th) {
                                th = th;
                                if (z) {
                                    a(file, a2);
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = z2;
                }
            }
            if (z2) {
                a(file, a2);
            }
            return true;
        }
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static boolean a(String str, b.a aVar) {
        return b.a(f7731a, str, aVar);
    }

    public static boolean a(String str) {
        return a(str, new m(str));
    }

    private static String b(int i) {
        String str;
        e();
        synchronized (b) {
            str = b.get(i);
        }
        return str;
    }

    private static void e() {
        synchronized (b) {
            if (b.size() != 0) {
                return;
            }
            b.put(100, "start_pv");
            b.put(1, "all_all");
            b.put(2, "all_fg");
            b.put(3, "java_fg");
            b.put(4, "java_bg");
            b.put(7, "native_fg");
            b.put(8, "native_bg");
            b.put(27, "native_anr_fg");
            b.put(28, "native_anr_bg");
            b.put(9, "native_ok");
            b.put(10, "unexp_anr");
            b.put(29, "unexp_lowmem");
            b.put(30, "unexp_killed");
            b.put(31, "unexp_exit");
            b.put(11, "unexp_fg");
            b.put(12, "unexp_bg");
            b.put(13, "log_up_succ");
            b.put(14, "log_up_fail");
            b.put(15, "log_empty");
            b.put(16, "log_abd_all");
            b.put(22, "log_abd_crash");
            b.put(23, "log_abd_custom");
            b.put(17, "log_large");
            b.put(18, "log_up_all");
            b.put(19, "log_up_bytes");
            b.put(20, "log_up_crash");
            b.put(21, "log_up_custom");
            b.put(24, "log_zipped");
            b.put(25, "log_renamed");
            b.put(26, "log_safe_skip");
        }
    }

    private static File[] f() {
        return new File(p.N()).listFiles(new n());
    }

    public static int a() {
        File[] f = f();
        if (f != null) {
            int i = 0;
            for (File file : f) {
                if (a(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static boolean b(String str) {
        return a(str, new o(str));
    }

    public static int b() {
        File[] f = f();
        if (f != null) {
            int i = 0;
            for (File file : f) {
                if (b(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static void c() {
        if (c) {
            return;
        }
        synchronized (d) {
            if (c) {
                return;
            }
            c = true;
            if (b.j() || b.k()) {
                a(1, 1);
                if (b.j()) {
                    a(2, 1);
                }
            }
            a(100, 1);
        }
    }
}
