package com.iap.ac.android.loglite.utils;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import id.dana.cashier.view.InputCardNumberView;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes3.dex */
public class LoggingUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult;
    private static int[] getAuthRequestContext = {197645567, -1184346332, -1305026439, -250427429, 1999225662, -782373203, 1899013163, 191458501, -1482559202, -1303336126, -1841010108, -1760169369, 69992247, -1304605433, 1233567279, -2068580108, 874556537, 652399322};

    public static StringBuilder appendExtParam(StringBuilder sb, Map<String, String> map) {
        Object[] objArr = null;
        if (sb == null) {
            return null;
        }
        sb.append(',');
        if (map != null) {
            int i = MyBillsEntityDataFactory + 11;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (!(map.size() == 0)) {
                int i3 = PlaceComponentResult + 43;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                boolean z = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    int i5 = MyBillsEntityDataFactory + 11;
                    PlaceComponentResult = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key != null) {
                            if (value == null) {
                                int i7 = MyBillsEntityDataFactory + 9;
                                PlaceComponentResult = i7 % 128;
                                if (i7 % 2 != 0) {
                                    int length = objArr.length;
                                }
                                value = "";
                            }
                            try {
                                if ((!TextUtils.isEmpty(value) ? ':' : '!') != '!') {
                                    int i8 = PlaceComponentResult + 23;
                                    MyBillsEntityDataFactory = i8 % 128;
                                    int i9 = i8 % 2;
                                    value = value.replace("\r\n", "###").replace("\n", "###").replace("\r", "###");
                                }
                                if (z) {
                                    z = false;
                                } else {
                                    sb.append('^');
                                }
                                sb.append(key.replace(',', InputCardNumberView.DIVIDER).replace('^', InputCardNumberView.DIVIDER).replace('=', InputCardNumberView.DIVIDER));
                                sb.append('=');
                                sb.append(value.replace(',', InputCardNumberView.DIVIDER).replace('^', InputCardNumberView.DIVIDER));
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
        }
        return sb;
    }

    public static String getMdapStyleName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(str);
        String obj = sb.toString();
        try {
            int i = PlaceComponentResult + 9;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 != 0) {
                return obj;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getNowTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(getServerTime());
        StringBuilder sb = new StringBuilder();
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        int i7 = calendar.get(14);
        sb.append(i);
        sb.append('-');
        if (i2 < 10) {
            try {
                sb.append('0');
            } catch (Exception e) {
                throw e;
            }
        }
        sb.append(i2);
        sb.append('-');
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        char c = InputCardNumberView.DIVIDER;
        sb.append(InputCardNumberView.DIVIDER);
        if (i4 < 10) {
            int i8 = MyBillsEntityDataFactory + 105;
            PlaceComponentResult = i8 % 128;
            int i9 = i8 % 2;
            sb.append('0');
        }
        sb.append(i4);
        sb.append(':');
        if (i5 < 10) {
            c = 'D';
        }
        if (c == 'D') {
            int i10 = PlaceComponentResult + 29;
            MyBillsEntityDataFactory = i10 % 128;
            int i11 = i10 % 2;
            sb.append('0');
        }
        sb.append(i5);
        sb.append(':');
        if (i6 < 10) {
            sb.append('0');
        }
        sb.append(i6);
        sb.append('.');
        if (i7 < 100) {
            try {
                sb.append('0');
                int i12 = PlaceComponentResult + 23;
                MyBillsEntityDataFactory = i12 % 128;
                int i13 = i12 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i7 < 10) {
            sb.append('0');
        }
        sb.append(i7);
        return sb.toString();
    }

    public static String getResolution() {
        DisplayMetrics displayMetrics = AnalyticsContext.getInstance().getApplication().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("*");
        sb.append(i2);
        String obj = sb.toString();
        int i3 = PlaceComponentResult + 27;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return obj;
    }

    public static long getServerTime() {
        int i = PlaceComponentResult + 47;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = MyBillsEntityDataFactory + 39;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return currentTimeMillis;
    }

    public static byte[] gzipDataByBytes(byte[] bArr, int i, int i2) throws IllegalStateException {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr, i, i2);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                gZIPOutputStream.close();
            } catch (Throwable unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            try {
                throw new IllegalStateException(th);
            } finally {
            }
        }
    }

    public static StringBuilder appendParam(StringBuilder sb, String str) {
        int i = MyBillsEntityDataFactory + 95;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (sb == null) {
            int i3 = MyBillsEntityDataFactory + 91;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        sb.append(',');
        if (str != null) {
            sb.append(str.replace(',', InputCardNumberView.DIVIDER));
            int i5 = MyBillsEntityDataFactory + 117;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
        }
        return sb;
    }

    public static byte[] gzipDataByString(String str) throws IllegalStateException {
        int i = MyBillsEntityDataFactory + 125;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(4 - ((byte) KeyEvent.getModifierMetaStateMask()), new int[]{-1010955697, -1817411429, 1969144885, 2075508043}, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            byte[] gzipDataByBytes = gzipDataByBytes(bytes, 0, bytes.length);
            int i3 = PlaceComponentResult + 65;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return gzipDataByBytes;
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int[] iArr2;
        int length;
        int[] iArr3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr4 = getAuthRequestContext;
        if ((iArr4 == null ? '/' : (char) 4) != '/') {
            int length2 = iArr4.length;
            int[] iArr5 = new int[length2];
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                iArr5[i2] = (int) (iArr4[i2] ^ (-3152031022165484798L));
                i2++;
            }
            iArr4 = iArr5;
        }
        int length3 = iArr4.length;
        int[] iArr6 = new int[length3];
        int[] iArr7 = getAuthRequestContext;
        if (iArr7 != null) {
            int i3 = $10 + 123;
            $11 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                length = iArr7.length;
                iArr3 = new int[length];
            } else {
                length = iArr7.length;
                iArr3 = new int[length];
            }
            int i4 = 0;
            while (i4 < length) {
                iArr3[i4] = (int) (iArr7[i4] ^ (-3152031022165484798L));
                i4++;
                iArr6 = iArr6;
            }
            iArr7 = iArr3;
            iArr2 = iArr6;
        } else {
            iArr2 = iArr6;
        }
        System.arraycopy(iArr7, 0, iArr2, 0, length3);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i5 = $11 + 7;
        $10 = i5 % 128;
        int i6 = i5 % 2;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr2);
            int i7 = 0;
            while (true) {
                if (i7 < 16) {
                    try {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr2[i7];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i8 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i8;
                        i7++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            int i9 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i9;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr2[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr2[17];
            int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i11 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr2);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
