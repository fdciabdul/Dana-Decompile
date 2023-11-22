package com.huawei.hms.opendevice;

import android.util.TypedValue;
import android.view.View;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes8.dex */
public abstract class s {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 3701988819154506758L;
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext;

    private static void getAuthRequestContext(Closeable closeable) {
        try {
            int i = getAuthRequestContext + 103;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                if (closeable == null) {
                    return;
                }
            } else {
                if ((closeable != null ? '6' : '3') == '3') {
                    return;
                }
            }
            int i2 = getAuthRequestContext + 33;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.w("StreamUtil", "close IOException");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void MyBillsEntityDataFactory(HttpURLConnection httpURLConnection) {
        if ((httpURLConnection != null ? Typography.amp : '*') != '&') {
            return;
        }
        int i = getAuthRequestContext + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            httpURLConnection.disconnect();
            int i3 = PlaceComponentResult + 7;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Throwable unused) {
            HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();
        int i = getAuthRequestContext + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        while (true) {
            if (-1 != read) {
                int i3 = PlaceComponentResult + 5;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                byteArrayOutputStream.write(read);
                read = inputStream.read();
            } else {
                Object[] objArr = new Object[1];
                a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 26681, new char[]{50448, 44328, 5489, 64963, 26009}, objArr);
                String byteArrayOutputStream2 = byteArrayOutputStream.toString(((String) objArr[0]).intern());
                getAuthRequestContext(inputStream);
                IOUtil.getAuthRequestContext(byteArrayOutputStream);
                return byteArrayOutputStream2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if ((!r0 ? 11 : 'R') != 11) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        if ((!r3.getParentFile().exists() ? '8' : 19) != '8') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        if (r3.getParentFile().mkdirs() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        if (r3.createNewFile() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005f, code lost:
    
        r3 = com.huawei.hms.opendevice.s.PlaceComponentResult + 9;
        com.huawei.hms.opendevice.s.getAuthRequestContext = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        com.huawei.hms.support.log.HMSLog.e("StreamUtil", "create file failed.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        throw new java.io.IOException("create file failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        com.huawei.hms.support.log.HMSLog.e("StreamUtil", "make parent dirs failed.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
    
        throw new java.io.IOException("make parent dirs failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void BuiltInFictitiousFunctionClassFactory(java.io.File r3) throws java.io.IOException {
        /*
            boolean r0 = r3.exists()     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L7
            return
        L7:
            java.io.File r0 = r3.getParentFile()
            if (r0 == 0) goto Lf
            r0 = 0
            goto L11
        Lf:
            r0 = 78
        L11:
            java.lang.String r1 = "StreamUtil"
            if (r0 != 0) goto L84
            int r0 = com.huawei.hms.opendevice.s.getAuthRequestContext
            int r0 = r0 + 39
            int r2 = r0 % 128
            com.huawei.hms.opendevice.s.PlaceComponentResult = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L3b
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Exception -> L39
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> L91
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L37
            r2 = 11
            if (r0 != 0) goto L32
            r0 = 11
            goto L34
        L32:
            r0 = 82
        L34:
            if (r0 == r2) goto L4f
            goto L59
        L37:
            r3 = move-exception
            throw r3
        L39:
            r3 = move-exception
            throw r3
        L3b:
            java.io.File r0 = r3.getParentFile()
            boolean r0 = r0.exists()
            r2 = 56
            if (r0 != 0) goto L4a
            r0 = 56
            goto L4c
        L4a:
            r0 = 19
        L4c:
            if (r0 == r2) goto L4f
            goto L59
        L4f:
            java.io.File r0 = r3.getParentFile()
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L77
        L59:
            boolean r3 = r3.createNewFile()
            if (r3 == 0) goto L6a
            int r3 = com.huawei.hms.opendevice.s.PlaceComponentResult
            int r3 = r3 + 9
            int r0 = r3 % 128
            com.huawei.hms.opendevice.s.getAuthRequestContext = r0
            int r3 = r3 % 2
            return
        L6a:
            java.lang.String r3 = "create file failed."
            com.huawei.hms.support.log.HMSLog.e(r1, r3)
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "create file failed"
            r3.<init>(r0)
            throw r3
        L77:
            java.lang.String r3 = "make parent dirs failed."
            com.huawei.hms.support.log.HMSLog.e(r1, r3)
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "make parent dirs failed"
            r3.<init>(r0)
            throw r3
        L84:
            java.lang.String r3 = "parent file is null."
            com.huawei.hms.support.log.HMSLog.e(r1, r3)
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "parent file is null"
            r3.<init>(r0)
            throw r3
        L91:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.s.BuiltInFictitiousFunctionClassFactory(java.io.File):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a4: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:28:0x00a3 */
    public static String getAuthRequestContext(String str) {
        Reader reader;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader3 = null;
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Object[] objArr = new Object[1];
                a(View.combineMeasuredStates(0, 0) + 26681, new char[]{50448, 44328, 5489, 64963, 26009}, objArr);
                inputStreamReader = new InputStreamReader(fileInputStream, ((String) objArr[0]).intern());
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    int i = getAuthRequestContext + 49;
                    PlaceComponentResult = i % 128;
                    while (true) {
                        try {
                            int i2 = i % 2;
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            i = PlaceComponentResult + 83;
                            getAuthRequestContext = i % 128;
                        } catch (FileNotFoundException unused) {
                            inputStreamReader3 = bufferedReader;
                            HMSLog.e("StreamUtil", "file not exist.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) inputStreamReader3);
                            int i3 = PlaceComponentResult + 39;
                            getAuthRequestContext = i3 % 128;
                            int i4 = i3 % 2;
                            return sb.toString();
                        } catch (IOException unused2) {
                            inputStreamReader3 = bufferedReader;
                            HMSLog.e("StreamUtil", "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) inputStreamReader3);
                            int i32 = PlaceComponentResult + 39;
                            getAuthRequestContext = i32 % 128;
                            int i42 = i32 % 2;
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            inputStreamReader3 = inputStreamReader;
                            reader = bufferedReader;
                            IOUtils.closeQuietly((Reader) inputStreamReader3);
                            IOUtils.closeQuietly(reader);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
                inputStreamReader = null;
            } catch (IOException unused6) {
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                reader = null;
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            reader = null;
            inputStreamReader3 = inputStreamReader2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '*' : Typography.dollar) == '$') {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (BuiltInFictitiousFunctionClassFactory ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i2 = $10 + 87;
        try {
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $10 + 81;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
