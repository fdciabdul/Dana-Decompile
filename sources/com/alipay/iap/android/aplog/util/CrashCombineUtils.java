package com.alipay.iap.android.aplog.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import o.A;

/* loaded from: classes3.dex */
public class CrashCombineUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final int DEFAULT_MAX_INFO_LEN = 1048576;
    public static final String JNI_SUFFIX = "jni.log";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    public static final String TOMB = "CrashSDK";
    private static final FlatComparator comparator;
    public static long crashTime;
    private static int getAuthRequestContext;

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = 269894677;
    }

    static {
        PlaceComponentResult();
        comparator = new FlatComparator();
        crashTime = 0L;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r12 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        if (r1.isFile() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        r12 = readFile(r1, 0);
        r5 = new java.lang.StringBuilder();
        r5.append("read: ");
        r5.append(r12.length);
        r5.append(" org: ");
        r5.append(r1.length());
        com.fullstory.instrumentation.InstrumentInjector.log_i("MiniDump", r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r12.length <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r0 = new java.lang.Object[1];
        a(new char[]{2, 16, 17, 65524, 65513}, (android.view.ViewConfiguration.getTapTimeout() >> 16) + 116, 4 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0, 0), true, android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0, 0) + 4, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b1, code lost:
    
        return new java.lang.String(r12, ((java.lang.String) r0[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b2, code lost:
    
        r12 = new java.lang.StringBuilder();
        r12.append("error: byte to string, logType:");
        r12.append(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c3, code lost:
    
        return r12.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
    
        r12 = new java.lang.StringBuilder();
        r12.append("error: none byte, logType:");
        r12.append(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d5, code lost:
    
        return r12.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String UserTrackReport(java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.CrashCombineUtils.UserTrackReport(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] readFile(File file, int i) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (i <= 0) {
            i = DEFAULT_MAX_INFO_LEN;
        }
        int length = (int) file.length();
        if (length <= i) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            getAuthRequestContext = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 38 / 0;
            }
            i = length;
        }
        byte[] bArr2 = new byte[i];
        Object[] objArr = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                int read = fileInputStream.read(bArr2, 0, i);
                fileInputStream.close();
                if (read <= 0 || read >= i) {
                    if (read != i) {
                        int i4 = getAuthRequestContext + 73;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                        return i4 % 2 == 0 ? new byte[1] : new byte[0];
                    }
                    return bArr2;
                }
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                getAuthRequestContext = i5 % 128;
                if ((i5 % 2 != 0 ? 'A' : '[') != 'A') {
                    bArr = new byte[read];
                    System.arraycopy(bArr2, 0, bArr, 0, read);
                } else {
                    bArr = new byte[read];
                    System.arraycopy(bArr2, 1, bArr, 0, read);
                }
                return bArr;
            } catch (IOException unused) {
                byte[] bArr3 = new byte[0];
                if (fileInputStream != null) {
                    int i6 = getAuthRequestContext + 83;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                    try {
                        if (i6 % 2 == 0) {
                            fileInputStream.close();
                            int length2 = objArr.length;
                        } else {
                            fileInputStream.close();
                        }
                        return bArr3;
                    } catch (IOException unused2) {
                        return bArr3;
                    }
                }
                return bArr3;
            }
        } catch (IOException unused3) {
            fileInputStream = null;
        }
    }

    public static void deleteFileByPath(String str) {
        try {
            int i = getAuthRequestContext + 21;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    File file = new File(str);
                    boolean z = true;
                    if (file.exists()) {
                        if (!file.isFile()) {
                            z = false;
                        }
                        if (z) {
                            file.delete();
                            int i3 = getAuthRequestContext + 85;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* loaded from: classes3.dex */
    public static class FlatComparator implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.lastModified());
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file2.lastModified());
            return obj.compareTo(sb2.toString());
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        int i4;
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            try {
                int i5 = $11 + 97;
                try {
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i7 = a2.MyBillsEntityDataFactory;
                    cArr2[i7] = (char) (cArr2[i7] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (!(i3 <= 0)) {
            int i8 = $10 + 59;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (!(!z)) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            int i10 = $11 + 13;
            $10 = i10 % 128;
            int i11 = i10 % 2;
            while (a2.MyBillsEntityDataFactory < i2) {
                int i12 = $11 + 3;
                $10 = i12 % 128;
                if (i12 % 2 != 0) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(a2.MyBillsEntityDataFactory * i2) + 1];
                    i4 = a2.MyBillsEntityDataFactory % 1;
                } else {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                }
                a2.MyBillsEntityDataFactory = i4;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
