package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.huawei.hms.support.log.HMSLog;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes8.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";
    public static final byte[] MyBillsEntityDataFactory = {11, Ascii.GS, 107, 8, 2, -8, 1, 13, -4, Ascii.US, -39, -11, -15, 8, -16, 1, 4, 3, TarHeader.LF_BLK, -55, -14, -1, -8, 13, -11, -8, 68, -68, 1, 61, -21, -49, -2, 2, 1, 4, 0, -21, 9, -8, -1, 35, -39, 6, -11};
    public static final int PlaceComponentResult = 10;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7520a = "ReadApkFileUtil";
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;

    public static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    public static void b(byte[] bArr) {
        Throwable th;
        BufferedReader bufferedReader;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            HMSLog.e(f7520a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        ByteArrayInputStream byteArrayInputStream2 = null;
        b = null;
        c = null;
        d = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    String a2 = a(bufferedReader);
                    while (a2 != null) {
                        if (a2.length() != 0) {
                            if (a2.startsWith("ApkHash:")) {
                                e = a(a2.substring(a2.indexOf(":") + 1));
                            }
                            if (a2.startsWith(KEY_SIGNATURE)) {
                                b = a(a2.substring(a2.indexOf(":") + 1));
                                a2 = a(bufferedReader);
                            } else if (a2.startsWith(KEY_SIGNATURE2)) {
                                c = a(a2.substring(a2.indexOf(":") + 1));
                                a2 = a(bufferedReader);
                            } else if (a2.startsWith(KEY_SIGNATURE3)) {
                                d = a(a2.substring(a2.indexOf(":") + 1));
                                a2 = a(bufferedReader);
                            } else {
                                stringBuffer.append(a2);
                                stringBuffer.append("\r\n");
                            }
                        }
                        a2 = a(bufferedReader);
                    }
                    f = stringBuffer.toString();
                } catch (Exception unused) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    try {
                        HMSLog.e(f7520a, "loadApkCert Exception!");
                        byteArrayInputStream = byteArrayInputStream2;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream2);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream2 = byteArrayInputStream;
                    IOUtils.closeQuietly((InputStream) byteArrayInputStream2);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Exception unused3) {
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static boolean c() {
        try {
        } catch (Exception e2) {
            String str = f7520a;
            StringBuilder sb = new StringBuilder();
            sb.append("verifyMDMSignatureV3 MDM verify Exception!:");
            sb.append(e2.getMessage());
            HMSLog.i(str, sb.toString());
        }
        if (a(Base64.decode(EMUI11_PK, 0), a(f, "SHA-384"), b(d), "SHA384withRSA")) {
            HMSLog.i(f7520a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.i(f7520a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (d != null) {
            return c();
        }
        if (c != null) {
            return b();
        }
        if (b != null) {
            return a();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 8
            int r9 = 11 - r9
            int r7 = r7 * 25
            int r7 = r7 + 9
            int r8 = r8 * 18
            int r8 = 115 - r8
            byte[] r0 = com.huawei.hms.utils.ReadApkFileUtil.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L3a
        L1c:
            r3 = 0
        L1d:
            int r9 = r9 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L3a:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-2)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.ReadApkFileUtil.g(byte, int, short, java.lang.Object[]):void");
    }

    public static String getHmsPath(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128);
            byte b2 = MyBillsEntityDataFactory[6];
            Object[] objArr = new Object[1];
            g(b2, b2, MyBillsEntityDataFactory[36], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[36];
            Object[] objArr2 = new Object[1];
            g(b3, b3, MyBillsEntityDataFactory[6], objArr2);
            return (String) cls.getField((String) objArr2[0]).get(applicationInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e(f7520a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isCertFound(String str) {
        ZipFile zipFile;
        StringBuilder sb = null;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    boolean z = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        String str2 = f7520a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("zipFile.close Exception!");
                        sb2.append(e2.getMessage());
                        HMSLog.e(str2, sb2.toString());
                    }
                    return z;
                } catch (Exception e3) {
                    e = e3;
                    zipFile2 = zipFile;
                    String str3 = f7520a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("isCertFound Exception!");
                    sb3.append(e.getMessage());
                    HMSLog.e(str3, sb3.toString());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (IOException e4) {
                            String str4 = f7520a;
                            sb = new StringBuilder();
                            sb.append("zipFile.close Exception!");
                            sb.append(e4.getMessage());
                            HMSLog.e(str4, sb.toString());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            String str5 = f7520a;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("zipFile.close Exception!");
                            sb4.append(e5.getMessage());
                            HMSLog.e(str5, sb4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = sb;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean verifyApkHash(String str) {
        ZipFile zipFile;
        String str2 = null;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    byte[] a2 = a(zipFile);
                    ArrayList<String> a3 = a(a2);
                    if (a3 != null) {
                        a2 = a(a3);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(a2);
                    String bytesToString = bytesToString(messageDigest.digest());
                    String str3 = e;
                    if (str3 != null) {
                        if (str3.equals(bytesToString)) {
                            try {
                                zipFile.close();
                                return true;
                            } catch (Exception e2) {
                                String str4 = f7520a;
                                StringBuilder sb = new StringBuilder();
                                sb.append("close stream Exception!");
                                sb.append(e2.getMessage());
                                HMSLog.i(str4, sb.toString());
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e3) {
                        String str5 = f7520a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("close stream Exception!");
                        sb2.append(e3.getMessage());
                        HMSLog.i(str5, sb2.toString());
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipFile2 = zipFile;
                    String str6 = f7520a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("verifyApkHash Exception!");
                    sb3.append(e.getMessage());
                    HMSLog.i(str6, sb3.toString());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (Exception e5) {
                            str2 = f7520a;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("close stream Exception!");
                            sb4.append(e5.getMessage());
                            HMSLog.i(str2, sb4.toString());
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e6) {
                            String str7 = f7520a;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("close stream Exception!");
                            sb5.append(e6.getMessage());
                            HMSLog.i(str7, sb5.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStream] */
    public static byte[] a(ZipFile zipFile, String str) {
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ZipEntry zipEntry;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        Exception e2;
        ?? r8;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        ZipEntry entry = zipFile.getEntry(str);
        ?? r0 = null;
        try {
            if (entry == null) {
                return null;
            }
            try {
                inputStream4 = zipFile.getInputStream(entry);
                if (inputStream4 == null) {
                    IOUtils.closeQuietly(inputStream4);
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    return null;
                }
                try {
                    r8 = new BufferedInputStream(inputStream4);
                    try {
                        bArr = new byte[4096];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
                        } catch (Exception e3) {
                            e2 = e3;
                            bufferedOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                            inputStream2 = inputStream4;
                            zipEntry = r8;
                            r0 = zipEntry;
                            inputStream = inputStream2;
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly((InputStream) r0);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        byteArrayOutputStream = null;
                        bufferedOutputStream = null;
                        String str2 = f7520a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("getManifestBytes Exception!");
                        sb.append(e2.getMessage());
                        HMSLog.i(str2, sb.toString());
                        IOUtils.closeQuietly(inputStream4);
                        IOUtils.closeQuietly((InputStream) r8);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        outputStream = null;
                        inputStream2 = inputStream4;
                        zipEntry = r8;
                    }
                } catch (Exception e5) {
                    e = e5;
                    e2 = e;
                    r8 = 0;
                    byteArrayOutputStream = null;
                    bufferedOutputStream = null;
                    String str22 = f7520a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getManifestBytes Exception!");
                    sb2.append(e2.getMessage());
                    HMSLog.i(str22, sb2.toString());
                    IOUtils.closeQuietly(inputStream4);
                    IOUtils.closeQuietly((InputStream) r8);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream3 = inputStream4;
                    byteArrayOutputStream = null;
                    outputStream = null;
                    inputStream = inputStream3;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) r0);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream);
                    throw th;
                }
                try {
                    for (int read = r8.read(bArr, 0, 4096); read > 0; read = r8.read(bArr, 0, 4096)) {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(inputStream4);
                    IOUtils.closeQuietly((InputStream) r8);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return byteArray;
                } catch (Exception e6) {
                    e2 = e6;
                    String str222 = f7520a;
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("getManifestBytes Exception!");
                    sb22.append(e2.getMessage());
                    HMSLog.i(str222, sb22.toString());
                    IOUtils.closeQuietly(inputStream4);
                    IOUtils.closeQuietly((InputStream) r8);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                }
            } catch (Exception e7) {
                e = e7;
                inputStream4 = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream3 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = zipFile;
            zipEntry = entry;
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return String.valueOf(cArr2);
    }

    public static boolean b() {
        try {
        } catch (Exception e2) {
            String str = f7520a;
            StringBuilder sb = new StringBuilder();
            sb.append("verifyMDMSignatureV2 MDM verify Exception!:");
            sb.append(e2.getMessage());
            HMSLog.i(str, sb.toString());
        }
        if (a(Base64.decode(EMUI10_PK, 0), a(f, "SHA-256"), b(c), "SHA256withRSA")) {
            HMSLog.i(f7520a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.i(f7520a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    public static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f7520a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.e(f7520a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    public static byte[] b(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i = length / 2;
        } else {
            i = (length / 2) + 1;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < length; i2 += 2) {
            int i3 = i2 + 1;
            if (i3 < length) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i3), 16));
            } else {
                bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2), 16) << 4);
            }
        }
        return bArr;
    }

    public static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = arrayList.get(i);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                String str2 = f7520a;
                StringBuilder sb = new StringBuilder();
                sb.append("getManifestBytesbySorted Exception!");
                sb.append(e2.getMessage());
                HMSLog.i(str2, sb.toString());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    public static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String a2 = a(bufferedReader);
        boolean z = false;
        while (a2 != null) {
            if (a2.equals("Name: META-INF/HUAWEI.CER")) {
                String a3 = a(bufferedReader);
                while (true) {
                    if (a3 == null) {
                        break;
                    } else if (a3.startsWith("Name:")) {
                        a2 = a3;
                        break;
                    } else {
                        a3 = a(bufferedReader);
                    }
                }
                z = true;
            }
            if (a2.length() != 0) {
                arrayList.add(a2);
            }
            a2 = a(bufferedReader);
        }
        return z;
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (read != -1) {
            char c2 = (char) read;
            if (c2 == '\n') {
                break;
            } else if (sb.length() < 4096) {
                sb.append(c2);
                read = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String obj = sb.toString();
        return (obj.isEmpty() || !obj.endsWith("\r")) ? obj : obj.substring(0, obj.length() - 1);
    }

    public static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f, "SHA-256"), b(b), "SHA256withRSA")) {
                HMSLog.i(f7520a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f7520a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            String str = f7520a;
            StringBuilder sb = new StringBuilder();
            sb.append("verifyMDMSignatureV1 MDM verify Exception!:");
            sb.append(e2.getMessage());
            HMSLog.i(str, sb.toString());
            return false;
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    public static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    public static String a(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }
}
