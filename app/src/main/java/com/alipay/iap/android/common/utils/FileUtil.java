package com.alipay.iap.android.common.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class FileUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final int IO_BUFFER_SIZE = 16384;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int[] MyBillsEntityDataFactory = {-1947571810, 927908352, 2132239695, -1339565444, -1313788786, -378871962, 1089458587, 102399101, 1244584526, -1874322205, -900086139, 653096288, -385150124, 790631221, 1152507166, 536597907, -656248275, 811360706};
    private static final String TAG = "FileUtil";

    private FileUtil() {
    }

    public static String getText(String str) {
        Object[] objArr = null;
        if ((TextUtils.isEmpty(str) ? '^' : '\r') != '^') {
            File file = new File(str);
            try {
                if ((!file.exists() ? (char) 6 : (char) 3) != 6) {
                    int length = (int) file.length();
                    if (length <= 20480) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 1024);
                                if (!(-1 == read)) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    bufferedInputStream.close();
                                    byteArrayOutputStream.close();
                                    return byteArrayOutputStream.toString();
                                }
                            }
                        } catch (Exception e) {
                            LoggerWrapper.e("FileUtil", "exception detail", e);
                        }
                    } else {
                        int i = BuiltInFictitiousFunctionClassFactory + 121;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        if (i % 2 == 0) {
                            int length2 = objArr.length;
                        }
                        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
                        BuiltInFictitiousFunctionClassFactory = i2 % 128;
                        int i3 = i2 % 2;
                        return null;
                    }
                }
                return null;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0051 -> B:72:0x0054). Please submit an issue!!! */
    public static String read(String str) {
        ?? r2 = TextUtils.isEmpty(str) ? 0 : 1;
        ?? r6 = 0;
        r6 = 0;
        String str2 = null;
        r6 = 0;
        InputStream inputStream = null;
        try {
            try {
            } catch (Exception e) {
                LoggerWrapper.e("FileUtil", "exception detail", e);
                r6 = r6;
            }
            if (r2 == 0) {
                int i = BuiltInFictitiousFunctionClassFactory + 93;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? 'O' : '/') != 'O') {
                    return null;
                }
                r6.hashCode();
                return null;
            }
            try {
                r2 = new FileInputStream(str);
            } catch (Exception e2) {
                e = e2;
                r2 = 0;
            } catch (Throwable th) {
                th = th;
                if ((inputStream != null ? '%' : 'K') == '%') {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        LoggerWrapper.e("FileUtil", "exception detail", e3);
                    }
                }
                throw th;
            }
            try {
                str2 = read((InputStream) r2);
            } catch (Exception e4) {
                e = e4;
                LoggerWrapper.e("FileUtil", "Exception", e);
                if ((r2 == 0 ? 'c' : '/') != 'c') {
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    if (i2 % 2 != 0) {
                        r2.close();
                        int length = r6.length;
                    }
                    r2.close();
                    r6 = str2;
                }
                return r6;
            }
            r2.close();
            r6 = str2;
            return r6;
        } catch (Throwable th2) {
            th = th2;
            inputStream = r2;
        }
    }

    public static String read(InputStream inputStream) {
        if ((inputStream == null ? '(' : '\r') != '(') {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[IO_BUFFER_SIZE];
            try {
                Object[] objArr = new Object[1];
                a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 4, new int[]{1668422506, 619652835, -2019440206, -92474394}, objArr);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, ((String) objArr[0]).intern());
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, IO_BUFFER_SIZE);
                    if ((read >= 0 ? '\r' : Typography.amp) == '&') {
                        break;
                    }
                    int i = BuiltInFictitiousFunctionClassFactory + 93;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e) {
                LoggerWrapper.e("FileUtil", "Exception", e);
            }
            return sb.toString();
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = MyBillsEntityDataFactory;
        if (iArr3 != null) {
            int i3 = $11 + 23;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                length = iArr3.length;
                iArr2 = new int[length];
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
            }
            int i4 = $11 + 37;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                int i7 = $11 + 105;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    iArr2[i6] = (int) (iArr3[i6] & (-3152031022165484798L));
                    i6 += 0;
                } else {
                    iArr2[i6] = (int) (iArr3[i6] ^ (-3152031022165484798L));
                    i6++;
                }
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = MyBillsEntityDataFactory;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i8 = 0;
            while (true) {
                if (i8 >= length3) {
                    break;
                }
                iArr6[i8] = (int) (iArr5[i8] ^ (-3152031022165484798L));
                i8++;
                length2 = length2;
            }
            i2 = length2;
            iArr5 = iArr6;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i9 = 0; i9 < 16; i9++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
            }
            try {
                int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                try {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                    int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    int i13 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                    cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                    cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                    verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
