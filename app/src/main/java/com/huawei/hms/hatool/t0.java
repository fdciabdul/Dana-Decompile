package com.huawei.hms.hatool;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;
import kotlin.text.Typography;
import o.getCallingPid;

/* loaded from: classes8.dex */
public final class t0 {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char[] MyBillsEntityDataFactory = {42070, 37257, 37346, 42065, 42068, 37367, 37275, 37274, 42071};
    private static int PlaceComponentResult = 0;
    private static char getAuthRequestContext = 42070;

    private static void BuiltInFictitiousFunctionClassFactory(OutputStream outputStream) {
        int i = PlaceComponentResult + 91;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            outputStream.close();
            int i3 = PlaceComponentResult + 109;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (IOException unused) {
            y.moveToNextValue("hmsSdk", "closeStream(): Exception: close OutputStream error!");
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HttpURLConnection httpURLConnection) {
        int i = PlaceComponentResult + 71;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            y.moveToNextValue("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        y.KClassImpl$Data$declaredNonStaticMembers$2("hmsSdk", " connHttp disconnect");
        int i3 = BuiltInFictitiousFunctionClassFactory + 59;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    public static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (true) {
            if ((!deflater.finished() ? 'M' : (char) 6) == 6) {
                break;
            }
            int i = PlaceComponentResult + 51;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                try {
                    byteArrayOutputStream.write(bArr2, 1, deflater.deflate(bArr2));
                } catch (Exception e) {
                    throw e;
                }
            } else {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            throw e;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream);
        int i2 = BuiltInFictitiousFunctionClassFactory + 63;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 20 : 'Z') != 20) {
            return byteArray;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return byteArray;
    }

    public static void PlaceComponentResult(Closeable closeable) {
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (closeable == null) {
            return;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 95;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        try {
            closeable.close();
            int i5 = BuiltInFictitiousFunctionClassFactory + 97;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
        } catch (IOException unused) {
            y.moveToNextValue("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void PlaceComponentResult(java.io.File r8, java.lang.String r9) {
        /*
            r0 = 2
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52 java.io.FileNotFoundException -> L56
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52 java.io.FileNotFoundException -> L56
            r8 = 5
            char[] r3 = new char[r8]     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r4 = 8
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r4 = 7
            r6 = 1
            r3[r6] = r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r3[r0] = r0     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r4 = 3
            r3[r4] = r5     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r4 = 4
            r7 = 13742(0x35ae, float:1.9257E-41)
            r3[r4] = r7     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            java.lang.String r4 = ""
            int r4 = android.view.MotionEvent.axisFromString(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            int r4 = 11 - r4
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            int r7 = android.view.ViewConfiguration.getLongPressTimeout()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            int r7 = r7 >> 16
            int r7 = r7 + r8
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            a(r3, r4, r7, r8)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r8 = r8[r5]     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            java.lang.String r8 = r8.intern()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            byte[] r8 = r9.getBytes(r8)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r2.write(r8)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            r2.flush()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L57
            int r8 = com.huawei.hms.hatool.t0.PlaceComponentResult
            int r8 = r8 + 55
            int r9 = r8 % 128
            com.huawei.hms.hatool.t0.BuiltInFictitiousFunctionClassFactory = r9
            int r8 = r8 % r0
            goto L76
        L4e:
            r8 = move-exception
            goto L7f
        L50:
            r8 = move-exception
            goto L7e
        L52:
            r2 = r1
        L53:
            java.lang.String r8 = "saveInfoToFile(): io exc from write info to file!"
            goto L59
        L56:
            r2 = r1
        L57:
            java.lang.String r8 = "saveInfoToFile(): No files need to be read"
        L59:
            java.lang.String r9 = "hmsSdk"
            com.huawei.hms.hatool.y.moveToNextValue(r9, r8)     // Catch: java.lang.Throwable -> L7c
            int r8 = com.huawei.hms.hatool.t0.PlaceComponentResult
            int r8 = r8 + 33
            int r9 = r8 % 128
            com.huawei.hms.hatool.t0.BuiltInFictitiousFunctionClassFactory = r9
            int r8 = r8 % r0
            r9 = 85
            if (r8 != 0) goto L6e
            r8 = 85
            goto L70
        L6e:
            r8 = 84
        L70:
            if (r8 == r9) goto L73
            goto L76
        L73:
            r1.hashCode()     // Catch: java.lang.Throwable -> L7a
        L76:
            PlaceComponentResult(r2)
            return
        L7a:
            r8 = move-exception
            throw r8
        L7c:
            r8 = move-exception
            r1 = r2
        L7e:
            r2 = r1
        L7f:
            PlaceComponentResult(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.t0.PlaceComponentResult(java.io.File, java.lang.String):void");
    }

    public static String getAuthRequestContext(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            int i = PlaceComponentResult + 23;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            while (true) {
                int i2 = i % 2;
                int read = inputStream.read(bArr);
                if ((read != -1 ? 'B' : '\t') == '\t') {
                    Object[] objArr = new Object[1];
                    a(new char[]{'\b', 7, 2, 0, 13742}, (byte) (TextUtils.indexOf("", "", 0, 0) + 12), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 5, objArr);
                    return byteArrayOutputStream.toString(((String) objArr[0]).intern());
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i = PlaceComponentResult + 59;
                BuiltInFictitiousFunctionClassFactory = i % 128;
            }
        } finally {
            PlaceComponentResult(byteArrayOutputStream);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if ((r8 - r9) >= r4) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MyBillsEntityDataFactory(java.io.File r11) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.t0.MyBillsEntityDataFactory(java.io.File):java.lang.String");
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr2 = MyBillsEntityDataFactory;
            if (cArr2 != null) {
                int i3 = $10 + 73;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = $10 + 79;
                    $11 = i6 % 128;
                    if (i6 % 2 == 0) {
                        cArr3[i5] = (char) (cArr2[i5] / (-1549216646985767851L));
                        i5 %= 1;
                    } else {
                        cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                        i5++;
                    }
                }
                cArr2 = cArr3;
            }
            char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
            char[] cArr4 = new char[i];
            if ((i % 2 != 0 ? (char) 14 : '4') != 14) {
                i2 = i;
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
            if ((i2 > 1 ? 'E' : '_') != '_') {
                getcallingpid.getAuthRequestContext = 0;
                while (true) {
                    if ((getcallingpid.getAuthRequestContext < i2 ? '/' : Typography.greater) == '>') {
                        break;
                    }
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? (char) 7 : (char) 29) == 7) {
                            int i7 = $10 + 119;
                            $11 = i7 % 128;
                            int i8 = i7 % 2;
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            try {
                                int i11 = $11 + 95;
                                $10 = i11 % 128;
                                int i12 = i11 % 2;
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            int i15 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i16 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i15];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i16];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            }
            int i17 = 0;
            while (true) {
                if ((i17 < i ? '3' : '#') == '#') {
                    objArr[0] = new String(cArr4);
                    return;
                } else {
                    cArr4[i17] = (char) (cArr4[i17] ^ 13722);
                    i17++;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
