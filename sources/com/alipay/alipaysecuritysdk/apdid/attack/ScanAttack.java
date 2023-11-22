package com.alipay.alipaysecuritysdk.apdid.attack;

import android.content.Context;
import android.util.Base64;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.alipaysecuritysdk.apdid.attack.b;
import com.google.common.base.Ascii;
import id.dana.danah5.scanqr.ScanQrBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class ScanAttack {
    public static int CHECK_ALL = -1;
    public static int CHECK_DEBUG = 2;
    public static int CHECK_HOOK = 1;
    public static int CHECK_VIRTUAL = 4;
    public static int MODE_DETAIL = 1;
    public static int MODE_SIMPLE;
    private static volatile ScanAttack mInstance;
    public static final byte[] PlaceComponentResult = {TarHeader.LF_DIR, 93, -14, -126, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 144;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 103
            byte[] r0 = com.alipay.alipaysecuritysdk.apdid.attack.ScanAttack.PlaceComponentResult
            int r9 = r9 * 26
            int r9 = 29 - r9
            int r8 = r8 * 15
            int r8 = 27 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L36:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.attack.ScanAttack.a(int, byte, int, java.lang.Object[]):void");
    }

    private ScanAttack() {
    }

    public static ScanAttack getInstance() {
        if (mInstance == null) {
            synchronized (ScanAttack.class) {
                if (mInstance == null) {
                    mInstance = new ScanAttack();
                }
            }
        }
        return mInstance;
    }

    public static boolean scanPackage(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).packageName.equals(str);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static JSONArray methodToNative() {
        a aVar = new a(2);
        for (b.a aVar2 : b.f6848a) {
            try {
                if (Modifier.isNative(Class.forName(aVar2.b).getMethod(aVar2.c, aVar2.d).getModifiers())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(aVar2.b);
                    sb.append("#");
                    sb.append(aVar2.c);
                    aVar.a(ScanQrBridge.CODE_CONSUMER_NATIVE, sb.toString());
                }
            } catch (Exception e) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            }
        }
        return aVar.a();
    }

    public static boolean xp1(Context context) {
        return scanPackage(context, new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=", 2)));
    }

    public static boolean xp2(Context context) {
        context.getFilesDir();
        try {
            throw new Exception("凸一_一凸");
        } catch (Exception e) {
            e.getMessage();
            boolean z = false;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                try {
                    byte b = (byte) (PlaceComponentResult[36] - 1);
                    byte b2 = PlaceComponentResult[16];
                    Object[] objArr = new Object[1];
                    a(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = PlaceComponentResult[16];
                    Object[] objArr2 = new Object[1];
                    a(b3, (byte) (b3 + 1), PlaceComponentResult[16], objArr2);
                    if (((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).equals(new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRCcmlkZ2U=", 2))) && stackTraceElement.getMethodName().equals(new String(Base64.decode("bWFpbg==", 2)))) {
                        z = true;
                    }
                    try {
                        byte b4 = (byte) (PlaceComponentResult[36] - 1);
                        byte b5 = PlaceComponentResult[16];
                        Object[] objArr3 = new Object[1];
                        a(b4, b5, (byte) (b5 + 1), objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b6 = PlaceComponentResult[16];
                        Object[] objArr4 = new Object[1];
                        a(b6, (byte) (b6 + 1), PlaceComponentResult[16], objArr4);
                        if (((String) cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement, null)).equals(new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRCcmlkZ2U=", 2))) && stackTraceElement.getMethodName().equals(new String(Base64.decode("aGFuZGxlSG9va2VkTWV0aG9k", 2)))) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            return z;
        }
    }

    public static String xp3(Context context) {
        context.getFilesDir();
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRIZWxwZXJz", 2))).getDeclaredField(new String(Base64.decode("ZmllbGRDYWNoZQ==", 2)));
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(null);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(map.keySet());
            return new JSONArray((Collection) arrayList).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String xp4(Context context) {
        context.getFilesDir();
        a aVar = new a(1);
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRCcmlkZ2U=", 2))).getDeclaredField(new String(Base64.decode("c0hvb2tlZE1ldGhvZENhbGxiYWNrcw==", 2)));
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(null);
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(new String(Base64.decode("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRCcmlkZ2UkQ29weU9uV3JpdGVTb3J0ZWRTZXQ=", 2)));
            Method declaredMethod = loadClass.getDeclaredMethod(new String(Base64.decode("Z2V0U25hcHNob3Q=", 2)), new Class[0]);
            for (Map.Entry entry : map.entrySet()) {
                Member member = (Member) entry.getKey();
                Object value = entry.getValue();
                String a2 = b.a(member.toString());
                if (!"".equals(a2) && loadClass.isInstance(value)) {
                    for (Object obj : (Object[]) declaredMethod.invoke(value, new Object[0])) {
                        String[] split = obj.getClass().getClassLoader().toString().split("\"");
                        if (split.length > 1) {
                            aVar.a((split == null || split.length <= 1) ? "" : split[1], a2);
                        }
                    }
                }
            }
            JSONArray a3 = aVar.a();
            JSONArray methodToNative = methodToNative();
            if (a3 == null) {
                if (methodToNative != null) {
                    return methodToNative.toString();
                }
                return null;
            }
            if (methodToNative != null) {
                for (int i = 0; i < methodToNative.length(); i++) {
                    a3.put(methodToNative.getJSONObject(i));
                }
            }
            return a3.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean cy1(Context context) {
        return scanPackage(context, new String(Base64.decode("Y29tLnNhdXJpay5zdWJzdHJhdGU=", 2)));
    }

    public static boolean cy2(Context context) {
        context.getFilesDir();
        try {
            throw new Exception("凸一_一凸");
        } catch (Exception e) {
            e.getMessage();
            boolean z = false;
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                try {
                    byte b = (byte) (PlaceComponentResult[36] - 1);
                    byte b2 = PlaceComponentResult[16];
                    Object[] objArr = new Object[1];
                    a(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = PlaceComponentResult[16];
                    Object[] objArr2 = new Object[1];
                    a(b3, (byte) (b3 + 1), PlaceComponentResult[16], objArr2);
                    if (((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).equals(new String(Base64.decode("Y29tLmFuZHJvaWQuaW50ZXJuYWwub3MuWnlnb3RlSW5pdA==", 2))) && (i = i + 1) == 2) {
                        z = true;
                    }
                    try {
                        byte b4 = (byte) (PlaceComponentResult[36] - 1);
                        byte b5 = PlaceComponentResult[16];
                        Object[] objArr3 = new Object[1];
                        a(b4, b5, (byte) (b5 + 1), objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b6 = PlaceComponentResult[16];
                        Object[] objArr4 = new Object[1];
                        a(b6, (byte) (b6 + 1), PlaceComponentResult[16], objArr4);
                        if (((String) cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement, null)).equals(new String(Base64.decode("Y29tLnNhdXJpay5zdWJzdHJhdGUuTVMkMg==", 2))) && stackTraceElement.getMethodName().equals(new String(Base64.decode("aW52b2tlZA==", 2)))) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            return z;
        }
    }

    public static boolean cy3(Context context) {
        Class<?> cls;
        context.getFilesDir();
        try {
            cls = ClassLoader.getSystemClassLoader().loadClass(new String(Base64.decode("Y29tLnNhdXJpay5zdWJzdHJhdGUuU3Vic3RyYXRlQ2xhc3NMb2FkZXI=", 2)));
        } catch (Exception unused) {
            cls = null;
        }
        return cls != null;
    }

    public static String vir1(Context context) {
        try {
            String str = new String(Base64.decode("L2RhdGEvZGF0YS8=", 2));
            String str2 = new String(Base64.decode("L2RhdGEvdXNlci8=", 2));
            String packageName = context.getPackageName();
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath.startsWith(str2) && !absolutePath.substring(absolutePath.indexOf(47, str2.length()) + 1).startsWith(packageName)) {
                StringBuilder sb = new StringBuilder("^^^");
                sb.append(absolutePath);
                absolutePath = sb.toString();
            }
            if (!absolutePath.startsWith(str) || absolutePath.substring(str.length()).startsWith(packageName)) {
                return absolutePath;
            }
            StringBuilder sb2 = new StringBuilder("^^^");
            sb2.append(absolutePath);
            return sb2.toString();
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return "";
        }
    }
}
