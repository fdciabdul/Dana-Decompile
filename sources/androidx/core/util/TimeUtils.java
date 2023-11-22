package androidx.core.util;

import id.dana.domain.featureconfig.model.UgcConfig;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public final class TimeUtils {
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private static char[] BuiltInFictitiousFunctionClassFactory = new char[24];

    private static int BuiltInFictitiousFunctionClassFactory(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (z || i > 0) {
            if (i > 99) {
                int i5 = i / 100;
                cArr[i2] = (char) (i5 + 48);
                i4 = i2 + 1;
                i -= i5 * 100;
            } else {
                i4 = i2;
            }
            if (i > 9 || i2 != i4) {
                int i6 = i / 10;
                cArr[i4] = (char) (i6 + 48);
                i4++;
                i -= i6 * 10;
            }
            cArr[i4] = (char) (i + 48);
            int i7 = i4 + 1;
            cArr[i7] = c;
            return i7 + 1;
        }
        return i2;
    }

    private static int getAuthRequestContext(long j) {
        char c;
        int i;
        int i2;
        int i3;
        int i4;
        if (BuiltInFictitiousFunctionClassFactory.length < 0) {
            BuiltInFictitiousFunctionClassFactory = new char[0];
        }
        char[] cArr = BuiltInFictitiousFunctionClassFactory;
        if (j == 0) {
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c = '+';
        } else {
            c = '-';
            j = -j;
        }
        int i5 = (int) (j % 1000);
        int floor = (int) Math.floor(j / 1000);
        if (floor > 86400) {
            i = floor / UgcConfig.DEFAULT_UGC_INTERVAL;
            floor -= UgcConfig.DEFAULT_UGC_INTERVAL * i;
        } else {
            i = 0;
        }
        if (floor > 3600) {
            i2 = floor / 3600;
            floor -= i2 * 3600;
        } else {
            i2 = 0;
        }
        if (floor > 60) {
            int i6 = floor / 60;
            i3 = floor - (i6 * 60);
            i4 = i6;
        } else {
            i3 = floor;
            i4 = 0;
        }
        cArr[0] = c;
        int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(cArr, i, 'd', 1, false, 0);
        int BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(cArr, i2, 'h', BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory2 != 1, 0);
        int BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(cArr, i4, 'm', BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory3 != 1, 0);
        int BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(cArr, i5, 'm', BuiltInFictitiousFunctionClassFactory(cArr, i3, 's', BuiltInFictitiousFunctionClassFactory4, BuiltInFictitiousFunctionClassFactory4 != 1, 0), true, 0);
        cArr[BuiltInFictitiousFunctionClassFactory5] = 's';
        return BuiltInFictitiousFunctionClassFactory5 + 1;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(long j, StringBuilder sb) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            sb.append(BuiltInFictitiousFunctionClassFactory, 0, getAuthRequestContext(j));
        }
    }

    private static void MyBillsEntityDataFactory(long j, PrintWriter printWriter) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            printWriter.print(new String(BuiltInFictitiousFunctionClassFactory, 0, getAuthRequestContext(j)));
        }
    }

    public static void getAuthRequestContext(long j, PrintWriter printWriter) {
        MyBillsEntityDataFactory(j, printWriter);
    }

    public static void MyBillsEntityDataFactory(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            MyBillsEntityDataFactory(j - j2, printWriter);
        }
    }

    private TimeUtils() {
    }
}
