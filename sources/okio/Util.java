package okio;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.nio.charset.Charset;
import kotlin.UShort;
import o.whenAvailable;

/* loaded from: classes.dex */
public final class Util {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    public static final Charset PlaceComponentResult;
    private static int getAuthRequestContext = 1;

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = new char[]{22228, 19629, 25143, 6596, 16217};
        KClassImpl$Data$declaredNonStaticMembers$2 = -3746306881338611402L;
    }

    public static long KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        try {
            int i = getAuthRequestContext + 65;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            long j2 = ((j & 65280) << 40) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((255 & j) << 56);
            int i3 = getAuthRequestContext + 73;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return j2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int MyBillsEntityDataFactory(int i) {
        int i2 = getAuthRequestContext + 73;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        int i4 = ((i & 65280) << 8) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((i & 255) << 24);
        int i5 = getAuthRequestContext + 123;
        MyBillsEntityDataFactory = i5 % 128;
        if ((i5 % 2 != 0 ? 'a' : '5') != '5') {
            int i6 = 72 / 0;
            return i4;
        }
        return i4;
    }

    public static short PlaceComponentResult(short s) {
        int i = MyBillsEntityDataFactory + 7;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = s & UShort.MAX_VALUE;
        short s2 = (short) (((i3 & 65280) >>> 8) | ((i3 & 255) << 8));
        int i4 = MyBillsEntityDataFactory + 91;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return s2;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(TextUtils.getTrimmedLength(""), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5, (char) (TextUtils.getOffsetAfter("", 0) + 42447), objArr);
        PlaceComponentResult = Charset.forName(((String) objArr[0]).intern());
        int i = MyBillsEntityDataFactory + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    private Util() {
    }

    public static void MyBillsEntityDataFactory(long j, long j2, long j3) {
        int i = getAuthRequestContext + 107;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (!(i % 2 == 0) ? j2 % j3 >= 1 : (j2 | j3) >= 0) {
                int i2 = MyBillsEntityDataFactory + 71;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                if (!(j2 > j) && j - j2 >= j3) {
                    int i4 = getAuthRequestContext + 23;
                    MyBillsEntityDataFactory = i4 % 128;
                    if (i4 % 2 == 0) {
                        return;
                    }
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
            }
            try {
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j);
                objArr[1] = Long.valueOf(j2);
                objArr[2] = Long.valueOf(j3);
                throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", objArr));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void PlaceComponentResult(Throwable th) {
        try {
            int i = getAuthRequestContext + 99;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 != 0)) {
                BuiltInFictitiousFunctionClassFactory(th);
                return;
            }
            BuiltInFictitiousFunctionClassFactory(th);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private static <T extends Throwable> void BuiltInFictitiousFunctionClassFactory(Throwable th) throws Throwable {
        int i = MyBillsEntityDataFactory + 41;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            throw th;
        }
        throw th;
    }

    public static boolean PlaceComponentResult(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = MyBillsEntityDataFactory + 59;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 0;
        while (true) {
            if ((i6 < i3 ? '6' : 'E') == 'E') {
                int i7 = MyBillsEntityDataFactory + 107;
                getAuthRequestContext = i7 % 128;
                if (i7 % 2 != 0) {
                    return true;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return true;
            }
            if ((bArr[i6 + i] != bArr2[i6 + i2] ? 'R' : '2') != '2') {
                return false;
            }
            i6++;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 81;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                break;
            }
            int i5 = $11 + 59;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (BuiltInFictitiousFunctionClassFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 11 : 'S') == 'S') {
                objArr[0] = new String(cArr);
                return;
            }
            int i7 = $11 + 59;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                try {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory--;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
        }
    }
}
