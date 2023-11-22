package com.xiaomi.push;

import com.alibaba.griver.image.framework.api.APImageFormat;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes8.dex */
public class h {
    public static final String[] BuiltInFictitiousFunctionClassFactory = {APImageFormat.SUFFIX_JPG, APImageFormat.SUFFIX_PNG, "bmp", APImageFormat.SUFFIX_GIF, APImageFormat.SUFFIX_WEBP};

    public static boolean BuiltInFictitiousFunctionClassFactory(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void MyBillsEntityDataFactory(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0065: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0065 */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAuthRequestContext(java.io.File r6) {
        /*
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r3 = 2048(0x800, float:2.87E-42)
            char[] r3 = new char[r3]     // Catch: java.io.IOException -> L30 java.lang.Throwable -> L64
        L19:
            int r4 = r2.read(r3)     // Catch: java.io.IOException -> L30 java.lang.Throwable -> L64
            r5 = -1
            if (r4 == r5) goto L25
            r5 = 0
            r0.write(r3, r5, r4)     // Catch: java.io.IOException -> L30 java.lang.Throwable -> L64
            goto L19
        L25:
            java.lang.String r6 = r0.toString()     // Catch: java.io.IOException -> L30 java.lang.Throwable -> L64
            r2.close()     // Catch: java.lang.Exception -> L2c
        L2c:
            r0.close()     // Catch: java.lang.Exception -> L2f
        L2f:
            return r6
        L30:
            r3 = move-exception
            goto L37
        L32:
            r6 = move-exception
            goto L66
        L34:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L37:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "read file :"
            r4.append(r5)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L64
            r4.append(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = " failure :"
            r4.append(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r3.getMessage()     // Catch: java.lang.Throwable -> L64
            r4.append(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L64
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(r6)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.lang.Exception -> L60
        L60:
            r0.close()     // Catch: java.lang.Exception -> L63
        L63:
            return r1
        L64:
            r6 = move-exception
            r1 = r2
        L66:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.lang.Exception -> L6b
        L6b:
            r0.close()     // Catch: java.lang.Exception -> L6e
        L6e:
            goto L70
        L6f:
            throw r6
        L70:
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.h.getAuthRequestContext(java.io.File):java.lang.String");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(File file, String str) {
        BufferedWriter bufferedWriter;
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("mkdir ");
            sb.append(file.getAbsolutePath());
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write(str);
                    try {
                        bufferedWriter.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedWriter2 = bufferedWriter;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("write file :");
                    sb2.append(file.getAbsolutePath());
                    sb2.append(" failure :");
                    sb2.append(e.getMessage());
                    com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb2.toString());
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
    }

    public static byte[] MyBillsEntityDataFactory(InputStream inputStream) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 8192);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception unused) {
                bArr = null;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (Exception unused3) {
                    throw th;
                }
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        try {
            inputStream.close();
        } catch (Exception unused4) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused5) {
        }
        return bArr;
    }
}
