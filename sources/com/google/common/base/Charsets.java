package com.google.common.base;

import android.os.Process;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.C;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Charsets {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    public static final Charset ISO_8859_1;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char PlaceComponentResult;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static char getAuthRequestContext;

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 61224;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 50993;
        getAuthRequestContext = (char) 37215;
        PlaceComponentResult = (char) 40142;
    }

    private Charsets() {
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        US_ASCII = Charset.forName("US-ASCII");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        Object[] objArr = new Object[1];
        a(4 - Process.getGidForName(""), new char[]{35137, 16993, 39767, 563, 1083, 27739}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        UTF_16BE = Charset.forName("UTF-16BE");
        UTF_16LE = Charset.forName("UTF-16LE");
        UTF_16 = Charset.forName("UTF-16");
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '0' : '9') == '0') {
                int i2 = $10 + 1;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = $11 + 109;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                int i7 = 0;
                while (true) {
                    if ((i7 < 16 ? 'S' : Typography.dollar) != 'S') {
                        break;
                    }
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i7++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
                int i8 = $11 + 15;
                $10 = i8 % 128;
                int i9 = i8 % 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
